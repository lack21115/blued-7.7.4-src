package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache implements Closeable {
  static final long ANY_SEQUENCE_NUMBER = -1L;
  
  private static final String CLEAN = "CLEAN";
  
  private static final String DIRTY = "DIRTY";
  
  static final String JOURNAL_FILE = "journal";
  
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
  
  static final String MAGIC = "libcore.io.DiskLruCache";
  
  private static final Sink NULL_SINK = new Sink() {
      public void close() throws IOException {}
      
      public void flush() throws IOException {}
      
      public Timeout timeout() {
        return Timeout.NONE;
      }
      
      public void write(Buffer param1Buffer, long param1Long) throws IOException {
        param1Buffer.skip(param1Long);
      }
    };
  
  private static final String READ = "READ";
  
  private static final String REMOVE = "REMOVE";
  
  static final String VERSION_1 = "1";
  
  private final int appVersion;
  
  private final Runnable cleanupRunnable = new Runnable() {
      public void run() {
        synchronized (DiskLruCache.this) {
          boolean bool;
          if (!DiskLruCache.this.initialized) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool | DiskLruCache.this.closed)
            return; 
          try {
            DiskLruCache.this.trimToSize();
            if (DiskLruCache.this.journalRebuildRequired()) {
              DiskLruCache.this.rebuildJournal();
              DiskLruCache.access$502(DiskLruCache.this, 0);
            } 
            return;
          } catch (IOException iOException) {
            throw new RuntimeException(iOException);
          } 
        } 
      }
    };
  
  private boolean closed;
  
  private final File directory;
  
  private final Executor executor;
  
  private final FileSystem fileSystem;
  
  private boolean hasJournalErrors;
  
  private boolean initialized;
  
  private final File journalFile;
  
  private final File journalFileBackup;
  
  private final File journalFileTmp;
  
  private BufferedSink journalWriter;
  
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<String, Entry>(0, 0.75F, true);
  
  private long maxSize;
  
  private long nextSequenceNumber = 0L;
  
  private int redundantOpCount;
  
  private long size = 0L;
  
  private final int valueCount;
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor) {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }
  
  private void checkNotClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual isClosed : ()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/lang/IllegalStateException
    //   17: dup
    //   18: ldc 'cache is closed'
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
    //   14	24	24	finally
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic access$1700 : (Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
    //   6: astore #10
    //   8: aload #10
    //   10: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   13: aload_1
    //   14: if_acmpne -> 474
    //   17: iconst_0
    //   18: istore #5
    //   20: iload #5
    //   22: istore #4
    //   24: iload_2
    //   25: ifeq -> 133
    //   28: iload #5
    //   30: istore #4
    //   32: aload #10
    //   34: invokestatic access$800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   37: ifne -> 133
    //   40: iconst_0
    //   41: istore_3
    //   42: iload #5
    //   44: istore #4
    //   46: iload_3
    //   47: aload_0
    //   48: getfield valueCount : I
    //   51: if_icmpge -> 133
    //   54: aload_1
    //   55: invokestatic access$1800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)[Z
    //   58: iload_3
    //   59: baload
    //   60: ifeq -> 96
    //   63: aload_0
    //   64: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   67: aload #10
    //   69: invokestatic access$1400 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   72: iload_3
    //   73: aaload
    //   74: invokeinterface exists : (Ljava/io/File;)Z
    //   79: ifne -> 89
    //   82: aload_1
    //   83: invokevirtual abort : ()V
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: iload_3
    //   90: iconst_1
    //   91: iadd
    //   92: istore_3
    //   93: goto -> 42
    //   96: aload_1
    //   97: invokevirtual abort : ()V
    //   100: new java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: astore_1
    //   108: aload_1
    //   109: ldc 'Newly created entry didn't create value for index '
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_1
    //   116: iload_3
    //   117: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: new java/lang/IllegalStateException
    //   124: dup
    //   125: aload_1
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: invokespecial <init> : (Ljava/lang/String;)V
    //   132: athrow
    //   133: iload #4
    //   135: aload_0
    //   136: getfield valueCount : I
    //   139: if_icmpge -> 253
    //   142: aload #10
    //   144: invokestatic access$1400 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   147: iload #4
    //   149: aaload
    //   150: astore_1
    //   151: iload_2
    //   152: ifeq -> 240
    //   155: aload_0
    //   156: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   159: aload_1
    //   160: invokeinterface exists : (Ljava/io/File;)Z
    //   165: ifeq -> 487
    //   168: aload #10
    //   170: invokestatic access$1300 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[Ljava/io/File;
    //   173: iload #4
    //   175: aaload
    //   176: astore #11
    //   178: aload_0
    //   179: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   182: aload_1
    //   183: aload #11
    //   185: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   190: aload #10
    //   192: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[J
    //   195: iload #4
    //   197: laload
    //   198: lstore #6
    //   200: aload_0
    //   201: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   204: aload #11
    //   206: invokeinterface size : (Ljava/io/File;)J
    //   211: lstore #8
    //   213: aload #10
    //   215: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)[J
    //   218: iload #4
    //   220: lload #8
    //   222: lastore
    //   223: aload_0
    //   224: aload_0
    //   225: getfield size : J
    //   228: lload #6
    //   230: lsub
    //   231: lload #8
    //   233: ladd
    //   234: putfield size : J
    //   237: goto -> 487
    //   240: aload_0
    //   241: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   244: aload_1
    //   245: invokeinterface delete : (Ljava/io/File;)V
    //   250: goto -> 487
    //   253: aload_0
    //   254: aload_0
    //   255: getfield redundantOpCount : I
    //   258: iconst_1
    //   259: iadd
    //   260: putfield redundantOpCount : I
    //   263: aload #10
    //   265: aconst_null
    //   266: invokestatic access$902 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   269: pop
    //   270: aload #10
    //   272: invokestatic access$800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   275: iload_2
    //   276: ior
    //   277: ifeq -> 371
    //   280: aload #10
    //   282: iconst_1
    //   283: invokestatic access$802 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Z)Z
    //   286: pop
    //   287: aload_0
    //   288: getfield journalWriter : Lokio/BufferedSink;
    //   291: ldc 'CLEAN'
    //   293: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   298: bipush #32
    //   300: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   305: pop
    //   306: aload_0
    //   307: getfield journalWriter : Lokio/BufferedSink;
    //   310: aload #10
    //   312: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   315: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   320: pop
    //   321: aload #10
    //   323: aload_0
    //   324: getfield journalWriter : Lokio/BufferedSink;
    //   327: invokevirtual writeLengths : (Lokio/BufferedSink;)V
    //   330: aload_0
    //   331: getfield journalWriter : Lokio/BufferedSink;
    //   334: bipush #10
    //   336: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   341: pop
    //   342: iload_2
    //   343: ifeq -> 430
    //   346: aload_0
    //   347: getfield nextSequenceNumber : J
    //   350: lstore #6
    //   352: aload_0
    //   353: lconst_1
    //   354: lload #6
    //   356: ladd
    //   357: putfield nextSequenceNumber : J
    //   360: aload #10
    //   362: lload #6
    //   364: invokestatic access$1602 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;J)J
    //   367: pop2
    //   368: goto -> 430
    //   371: aload_0
    //   372: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   375: aload #10
    //   377: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   380: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload_0
    //   385: getfield journalWriter : Lokio/BufferedSink;
    //   388: ldc 'REMOVE'
    //   390: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   395: bipush #32
    //   397: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   402: pop
    //   403: aload_0
    //   404: getfield journalWriter : Lokio/BufferedSink;
    //   407: aload #10
    //   409: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   412: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   417: pop
    //   418: aload_0
    //   419: getfield journalWriter : Lokio/BufferedSink;
    //   422: bipush #10
    //   424: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   429: pop
    //   430: aload_0
    //   431: getfield journalWriter : Lokio/BufferedSink;
    //   434: invokeinterface flush : ()V
    //   439: aload_0
    //   440: getfield size : J
    //   443: aload_0
    //   444: getfield maxSize : J
    //   447: lcmp
    //   448: ifgt -> 458
    //   451: aload_0
    //   452: invokespecial journalRebuildRequired : ()Z
    //   455: ifeq -> 471
    //   458: aload_0
    //   459: getfield executor : Ljava/util/concurrent/Executor;
    //   462: aload_0
    //   463: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   466: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   471: aload_0
    //   472: monitorexit
    //   473: return
    //   474: new java/lang/IllegalStateException
    //   477: dup
    //   478: invokespecial <init> : ()V
    //   481: athrow
    //   482: astore_1
    //   483: aload_0
    //   484: monitorexit
    //   485: aload_1
    //   486: athrow
    //   487: iload #4
    //   489: iconst_1
    //   490: iadd
    //   491: istore #4
    //   493: goto -> 133
    // Exception table:
    //   from	to	target	type
    //   2	17	482	finally
    //   32	40	482	finally
    //   46	86	482	finally
    //   96	133	482	finally
    //   133	151	482	finally
    //   155	237	482	finally
    //   240	250	482	finally
    //   253	342	482	finally
    //   346	368	482	finally
    //   371	430	482	finally
    //   430	458	482	finally
    //   458	471	482	finally
    //   474	482	482	finally
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong) {
    if (paramLong > 0L) {
      if (paramInt2 > 0)
        return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory("OkHttp DiskLruCache", true))); 
      throw new IllegalArgumentException("valueCount <= 0");
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private Editor edit(String paramString, long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: invokespecial checkNotClosed : ()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial validateKey : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore #8
    //   28: lload_2
    //   29: ldc2_w -1
    //   32: lcmp
    //   33: ifeq -> 59
    //   36: aload #8
    //   38: ifnull -> 55
    //   41: aload #8
    //   43: invokestatic access$1600 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)J
    //   46: lstore #4
    //   48: lload #4
    //   50: lload_2
    //   51: lcmp
    //   52: ifeq -> 59
    //   55: aload_0
    //   56: monitorexit
    //   57: aconst_null
    //   58: areturn
    //   59: aload #8
    //   61: ifnull -> 80
    //   64: aload #8
    //   66: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   69: astore #7
    //   71: aload #7
    //   73: ifnull -> 80
    //   76: aload_0
    //   77: monitorexit
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: getfield journalWriter : Lokio/BufferedSink;
    //   84: ldc 'DIRTY'
    //   86: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   91: bipush #32
    //   93: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   98: aload_1
    //   99: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   104: bipush #10
    //   106: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   111: pop
    //   112: aload_0
    //   113: getfield journalWriter : Lokio/BufferedSink;
    //   116: invokeinterface flush : ()V
    //   121: aload_0
    //   122: getfield hasJournalErrors : Z
    //   125: istore #6
    //   127: iload #6
    //   129: ifeq -> 136
    //   132: aload_0
    //   133: monitorexit
    //   134: aconst_null
    //   135: areturn
    //   136: aload #8
    //   138: astore #7
    //   140: aload #8
    //   142: ifnonnull -> 168
    //   145: new com/squareup/okhttp/internal/DiskLruCache$Entry
    //   148: dup
    //   149: aload_0
    //   150: aload_1
    //   151: aconst_null
    //   152: invokespecial <init> : (Lcom/squareup/okhttp/internal/DiskLruCache;Ljava/lang/String;Lcom/squareup/okhttp/internal/DiskLruCache$1;)V
    //   155: astore #7
    //   157: aload_0
    //   158: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   161: aload_1
    //   162: aload #7
    //   164: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: pop
    //   168: new com/squareup/okhttp/internal/DiskLruCache$Editor
    //   171: dup
    //   172: aload_0
    //   173: aload #7
    //   175: aconst_null
    //   176: invokespecial <init> : (Lcom/squareup/okhttp/internal/DiskLruCache;Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$1;)V
    //   179: astore_1
    //   180: aload #7
    //   182: aload_1
    //   183: invokestatic access$902 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   186: pop
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: areturn
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	191	finally
    //   41	48	191	finally
    //   64	71	191	finally
    //   80	127	191	finally
    //   145	168	191	finally
    //   168	187	191	finally
  }
  
  private boolean journalRebuildRequired() {
    int i = this.redundantOpCount;
    return (i >= 2000 && i >= this.lruEntries.size());
  }
  
  private BufferedSink newJournalWriter() throws FileNotFoundException {
    return Okio.buffer((Sink)new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
          protected void onException(IOException param1IOException) {
            DiskLruCache.access$602(DiskLruCache.this, true);
          }
        });
  }
  
  private void processJournal() throws IOException {
    this.fileSystem.delete(this.journalFileTmp);
    Iterator<Entry> iterator = this.lruEntries.values().iterator();
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      Editor editor = entry.currentEditor;
      boolean bool = false;
      int i = 0;
      if (editor == null) {
        while (i < this.valueCount) {
          this.size += entry.lengths[i];
          i++;
        } 
        continue;
      } 
      Entry.access$902(entry, null);
      for (i = bool; i < this.valueCount; i++) {
        this.fileSystem.delete(entry.cleanFiles[i]);
        this.fileSystem.delete(entry.dirtyFiles[i]);
      } 
      iterator.remove();
    } 
  }
  
  private void readJournal() throws IOException {
    BufferedSource bufferedSource = Okio.buffer(this.fileSystem.source(this.journalFile));
    try {
      String str1 = bufferedSource.readUtf8LineStrict();
      String str2 = bufferedSource.readUtf8LineStrict();
      String str5 = bufferedSource.readUtf8LineStrict();
      String str3 = bufferedSource.readUtf8LineStrict();
      String str4 = bufferedSource.readUtf8LineStrict();
      if ("libcore.io.DiskLruCache".equals(str1) && "1".equals(str2) && Integer.toString(this.appVersion).equals(str5) && Integer.toString(this.valueCount).equals(str3)) {
        boolean bool = "".equals(str4);
        if (bool) {
          int i = 0;
          try {
            while (true) {
              readJournalLine(bufferedSource.readUtf8LineStrict());
              i++;
            } 
          } catch (EOFException eOFException) {
            this.redundantOpCount = i - this.lruEntries.size();
            if (!bufferedSource.exhausted()) {
              rebuildJournal();
            } else {
              this.journalWriter = newJournalWriter();
            } 
            return;
          } 
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected journal header: [");
      stringBuilder.append((String)eOFException);
      stringBuilder.append(", ");
      stringBuilder.append(str2);
      stringBuilder.append(", ");
      stringBuilder.append(str3);
      stringBuilder.append(", ");
      stringBuilder.append(str4);
      stringBuilder.append("]");
      throw new IOException(stringBuilder.toString());
    } finally {
      Util.closeQuietly((Closeable)bufferedSource);
    } 
  }
  
  private void readJournalLine(String paramString) throws IOException {
    String[] arrayOfString;
    int i = paramString.indexOf(' ');
    if (i != -1) {
      String str;
      int j = i + 1;
      int k = paramString.indexOf(' ', j);
      if (k == -1) {
        String str1 = paramString.substring(j);
        str = str1;
        if (i == 6) {
          str = str1;
          if (paramString.startsWith("REMOVE")) {
            this.lruEntries.remove(str1);
            return;
          } 
        } 
      } else {
        str = paramString.substring(j, k);
      } 
      Entry entry2 = this.lruEntries.get(str);
      Entry entry1 = entry2;
      if (entry2 == null) {
        entry1 = new Entry(str);
        this.lruEntries.put(str, entry1);
      } 
      if (k != -1 && i == 5 && paramString.startsWith("CLEAN")) {
        arrayOfString = paramString.substring(k + 1).split(" ");
        Entry.access$802(entry1, true);
        Entry.access$902(entry1, null);
        entry1.setLengths(arrayOfString);
        return;
      } 
      if (k == -1 && i == 5 && arrayOfString.startsWith("DIRTY")) {
        Entry.access$902(entry1, new Editor(entry1));
        return;
      } 
      if (k == -1 && i == 4 && arrayOfString.startsWith("READ"))
        return; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("unexpected journal line: ");
      stringBuilder1.append((String)arrayOfString);
      throw new IOException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unexpected journal line: ");
    stringBuilder.append((String)arrayOfString);
    throw new IOException(stringBuilder.toString());
  }
  
  private void rebuildJournal() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield journalWriter : Lokio/BufferedSink;
    //   6: ifnull -> 18
    //   9: aload_0
    //   10: getfield journalWriter : Lokio/BufferedSink;
    //   13: invokeinterface close : ()V
    //   18: aload_0
    //   19: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   22: aload_0
    //   23: getfield journalFileTmp : Ljava/io/File;
    //   26: invokeinterface sink : (Ljava/io/File;)Lokio/Sink;
    //   31: invokestatic buffer : (Lokio/Sink;)Lokio/BufferedSink;
    //   34: astore_1
    //   35: aload_1
    //   36: ldc 'libcore.io.DiskLruCache'
    //   38: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   43: bipush #10
    //   45: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   50: pop
    //   51: aload_1
    //   52: ldc '1'
    //   54: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   59: bipush #10
    //   61: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   66: pop
    //   67: aload_1
    //   68: aload_0
    //   69: getfield appVersion : I
    //   72: i2l
    //   73: invokeinterface writeDecimalLong : (J)Lokio/BufferedSink;
    //   78: bipush #10
    //   80: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   85: pop
    //   86: aload_1
    //   87: aload_0
    //   88: getfield valueCount : I
    //   91: i2l
    //   92: invokeinterface writeDecimalLong : (J)Lokio/BufferedSink;
    //   97: bipush #10
    //   99: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   104: pop
    //   105: aload_1
    //   106: bipush #10
    //   108: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   113: pop
    //   114: aload_0
    //   115: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   118: invokevirtual values : ()Ljava/util/Collection;
    //   121: invokeinterface iterator : ()Ljava/util/Iterator;
    //   126: astore_2
    //   127: aload_2
    //   128: invokeinterface hasNext : ()Z
    //   133: ifeq -> 236
    //   136: aload_2
    //   137: invokeinterface next : ()Ljava/lang/Object;
    //   142: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   145: astore_3
    //   146: aload_3
    //   147: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   150: ifnull -> 192
    //   153: aload_1
    //   154: ldc 'DIRTY'
    //   156: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   161: bipush #32
    //   163: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   168: pop
    //   169: aload_1
    //   170: aload_3
    //   171: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   174: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   179: pop
    //   180: aload_1
    //   181: bipush #10
    //   183: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   188: pop
    //   189: goto -> 127
    //   192: aload_1
    //   193: ldc 'CLEAN'
    //   195: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   200: bipush #32
    //   202: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   207: pop
    //   208: aload_1
    //   209: aload_3
    //   210: invokestatic access$1500 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Ljava/lang/String;
    //   213: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   218: pop
    //   219: aload_3
    //   220: aload_1
    //   221: invokevirtual writeLengths : (Lokio/BufferedSink;)V
    //   224: aload_1
    //   225: bipush #10
    //   227: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   232: pop
    //   233: goto -> 127
    //   236: aload_1
    //   237: invokeinterface close : ()V
    //   242: aload_0
    //   243: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   246: aload_0
    //   247: getfield journalFile : Ljava/io/File;
    //   250: invokeinterface exists : (Ljava/io/File;)Z
    //   255: ifeq -> 275
    //   258: aload_0
    //   259: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   262: aload_0
    //   263: getfield journalFile : Ljava/io/File;
    //   266: aload_0
    //   267: getfield journalFileBackup : Ljava/io/File;
    //   270: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   275: aload_0
    //   276: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   279: aload_0
    //   280: getfield journalFileTmp : Ljava/io/File;
    //   283: aload_0
    //   284: getfield journalFile : Ljava/io/File;
    //   287: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   292: aload_0
    //   293: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   296: aload_0
    //   297: getfield journalFileBackup : Ljava/io/File;
    //   300: invokeinterface delete : (Ljava/io/File;)V
    //   305: aload_0
    //   306: aload_0
    //   307: invokespecial newJournalWriter : ()Lokio/BufferedSink;
    //   310: putfield journalWriter : Lokio/BufferedSink;
    //   313: aload_0
    //   314: iconst_0
    //   315: putfield hasJournalErrors : Z
    //   318: aload_0
    //   319: monitorexit
    //   320: return
    //   321: astore_2
    //   322: aload_1
    //   323: invokeinterface close : ()V
    //   328: aload_2
    //   329: athrow
    //   330: astore_1
    //   331: aload_0
    //   332: monitorexit
    //   333: aload_1
    //   334: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	330	finally
    //   18	35	330	finally
    //   35	127	321	finally
    //   127	189	321	finally
    //   192	233	321	finally
    //   236	275	330	finally
    //   275	318	330	finally
    //   322	330	330	finally
  }
  
  private boolean removeEntry(Entry paramEntry) throws IOException {
    if (paramEntry.currentEditor != null)
      Editor.access$1902(paramEntry.currentEditor, true); 
    for (int i = 0; i < this.valueCount; i++) {
      this.fileSystem.delete(paramEntry.cleanFiles[i]);
      this.size -= paramEntry.lengths[i];
      paramEntry.lengths[i] = 0L;
    } 
    this.redundantOpCount++;
    this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
    this.lruEntries.remove(paramEntry.key);
    if (journalRebuildRequired())
      this.executor.execute(this.cleanupRunnable); 
    return true;
  }
  
  private void trimToSize() throws IOException {
    while (this.size > this.maxSize)
      removeEntry(this.lruEntries.values().iterator().next()); 
  }
  
  private void validateKey(String paramString) {
    if (LEGAL_KEY_PATTERN.matcher(paramString).matches())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: ifeq -> 105
    //   9: aload_0
    //   10: getfield closed : Z
    //   13: ifeq -> 19
    //   16: goto -> 105
    //   19: aload_0
    //   20: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   23: invokevirtual values : ()Ljava/util/Collection;
    //   26: aload_0
    //   27: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   30: invokevirtual size : ()I
    //   33: anewarray com/squareup/okhttp/internal/DiskLruCache$Entry
    //   36: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   41: checkcast [Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
    //   44: astore_3
    //   45: aload_3
    //   46: arraylength
    //   47: istore_2
    //   48: iconst_0
    //   49: istore_1
    //   50: iload_1
    //   51: iload_2
    //   52: if_icmpge -> 79
    //   55: aload_3
    //   56: iload_1
    //   57: aaload
    //   58: astore #4
    //   60: aload #4
    //   62: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   65: ifnull -> 118
    //   68: aload #4
    //   70: invokestatic access$900 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   73: invokevirtual abort : ()V
    //   76: goto -> 118
    //   79: aload_0
    //   80: invokespecial trimToSize : ()V
    //   83: aload_0
    //   84: getfield journalWriter : Lokio/BufferedSink;
    //   87: invokeinterface close : ()V
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield journalWriter : Lokio/BufferedSink;
    //   97: aload_0
    //   98: iconst_1
    //   99: putfield closed : Z
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield closed : Z
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_3
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: athrow
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_1
    //   122: goto -> 50
    // Exception table:
    //   from	to	target	type
    //   2	16	113	finally
    //   19	48	113	finally
    //   60	76	113	finally
    //   79	102	113	finally
    //   105	110	113	finally
  }
  
  public void delete() throws IOException {
    close();
    this.fileSystem.deleteContents(this.directory);
  }
  
  public Editor edit(String paramString) throws IOException {
    return edit(paramString, -1L);
  }
  
  public void evictAll() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   10: invokevirtual values : ()Ljava/util/Collection;
    //   13: aload_0
    //   14: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   17: invokevirtual size : ()I
    //   20: anewarray com/squareup/okhttp/internal/DiskLruCache$Entry
    //   23: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   28: checkcast [Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
    //   31: astore_3
    //   32: aload_3
    //   33: arraylength
    //   34: istore_2
    //   35: iconst_0
    //   36: istore_1
    //   37: iload_1
    //   38: iload_2
    //   39: if_icmpge -> 57
    //   42: aload_0
    //   43: aload_3
    //   44: iload_1
    //   45: aaload
    //   46: invokespecial removeEntry : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   49: pop
    //   50: iload_1
    //   51: iconst_1
    //   52: iadd
    //   53: istore_1
    //   54: goto -> 37
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_3
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_3
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	60	finally
    //   42	50	60	finally
  }
  
  public void flush() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial checkNotClosed : ()V
    //   18: aload_0
    //   19: invokespecial trimToSize : ()V
    //   22: aload_0
    //   23: getfield journalWriter : Lokio/BufferedSink;
    //   26: invokeinterface flush : ()V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public Snapshot get(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: invokespecial checkNotClosed : ()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial validateKey : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull -> 120
    //   31: aload_2
    //   32: invokestatic access$800 : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   35: ifne -> 41
    //   38: goto -> 120
    //   41: aload_2
    //   42: invokevirtual snapshot : ()Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnonnull -> 54
    //   50: aload_0
    //   51: monitorexit
    //   52: aconst_null
    //   53: areturn
    //   54: aload_0
    //   55: aload_0
    //   56: getfield redundantOpCount : I
    //   59: iconst_1
    //   60: iadd
    //   61: putfield redundantOpCount : I
    //   64: aload_0
    //   65: getfield journalWriter : Lokio/BufferedSink;
    //   68: ldc 'READ'
    //   70: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   75: bipush #32
    //   77: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   82: aload_1
    //   83: invokeinterface writeUtf8 : (Ljava/lang/String;)Lokio/BufferedSink;
    //   88: bipush #10
    //   90: invokeinterface writeByte : (I)Lokio/BufferedSink;
    //   95: pop
    //   96: aload_0
    //   97: invokespecial journalRebuildRequired : ()Z
    //   100: ifeq -> 116
    //   103: aload_0
    //   104: getfield executor : Ljava/util/concurrent/Executor;
    //   107: aload_0
    //   108: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   111: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: areturn
    //   120: aload_0
    //   121: monitorexit
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	124	finally
    //   31	38	124	finally
    //   41	46	124	finally
    //   54	116	124	finally
  }
  
  public File getDirectory() {
    return this.directory;
  }
  
  public long getMaxSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxSize : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void initialize() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield initialized : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   18: aload_0
    //   19: getfield journalFileBackup : Ljava/io/File;
    //   22: invokeinterface exists : (Ljava/io/File;)Z
    //   27: ifeq -> 79
    //   30: aload_0
    //   31: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   34: aload_0
    //   35: getfield journalFile : Ljava/io/File;
    //   38: invokeinterface exists : (Ljava/io/File;)Z
    //   43: ifeq -> 62
    //   46: aload_0
    //   47: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   50: aload_0
    //   51: getfield journalFileBackup : Ljava/io/File;
    //   54: invokeinterface delete : (Ljava/io/File;)V
    //   59: goto -> 79
    //   62: aload_0
    //   63: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   66: aload_0
    //   67: getfield journalFileBackup : Ljava/io/File;
    //   70: aload_0
    //   71: getfield journalFile : Ljava/io/File;
    //   74: invokeinterface rename : (Ljava/io/File;Ljava/io/File;)V
    //   79: aload_0
    //   80: getfield fileSystem : Lcom/squareup/okhttp/internal/io/FileSystem;
    //   83: aload_0
    //   84: getfield journalFile : Ljava/io/File;
    //   87: invokeinterface exists : (Ljava/io/File;)Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq -> 192
    //   97: aload_0
    //   98: invokespecial readJournal : ()V
    //   101: aload_0
    //   102: invokespecial processJournal : ()V
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield initialized : Z
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_2
    //   114: invokestatic get : ()Lcom/squareup/okhttp/internal/Platform;
    //   117: astore_3
    //   118: new java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore #4
    //   127: aload #4
    //   129: ldc_w 'DiskLruCache '
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #4
    //   138: aload_0
    //   139: getfield directory : Ljava/io/File;
    //   142: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload #4
    //   148: ldc_w ' is corrupt: '
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload #4
    //   157: aload_2
    //   158: invokevirtual getMessage : ()Ljava/lang/String;
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #4
    //   167: ldc_w ', removing'
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_3
    //   175: aload #4
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: invokevirtual logW : (Ljava/lang/String;)V
    //   183: aload_0
    //   184: invokevirtual delete : ()V
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield closed : Z
    //   192: aload_0
    //   193: invokespecial rebuildJournal : ()V
    //   196: aload_0
    //   197: iconst_1
    //   198: putfield initialized : Z
    //   201: aload_0
    //   202: monitorexit
    //   203: return
    //   204: astore_2
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_2
    //   208: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	204	finally
    //   14	59	204	finally
    //   62	79	204	finally
    //   79	93	204	finally
    //   97	110	113	java/io/IOException
    //   97	110	204	finally
    //   114	192	204	finally
    //   192	201	204	finally
  }
  
  public boolean isClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield closed : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean remove(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: invokespecial checkNotClosed : ()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial validateKey : (Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield lruEntries : Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull -> 35
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial removeEntry : (Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   40: istore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_2
    //   44: ireturn
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	45	finally
    //   35	41	45	finally
  }
  
  public void setMaxSize(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: putfield maxSize : J
    //   7: aload_0
    //   8: getfield initialized : Z
    //   11: ifeq -> 27
    //   14: aload_0
    //   15: getfield executor : Ljava/util/concurrent/Executor;
    //   18: aload_0
    //   19: getfield cleanupRunnable : Ljava/lang/Runnable;
    //   22: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	30	finally
  }
  
  public long size() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: aload_0
    //   7: getfield size : J
    //   10: lstore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: lload_1
    //   14: lreturn
    //   15: astore_3
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_3
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public Iterator<Snapshot> snapshots() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual initialize : ()V
    //   6: new com/squareup/okhttp/internal/DiskLruCache$3
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/squareup/okhttp/internal/DiskLruCache;)V
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	19	finally
  }
  
  public final class Editor {
    private boolean committed;
    
    private final DiskLruCache.Entry entry;
    
    private boolean hasErrors;
    
    private final boolean[] written;
    
    private Editor(DiskLruCache.Entry param1Entry) {
      boolean[] arrayOfBoolean;
      this.entry = param1Entry;
      if (param1Entry.readable) {
        DiskLruCache.this = null;
      } else {
        arrayOfBoolean = new boolean[DiskLruCache.this.valueCount];
      } 
      this.written = arrayOfBoolean;
    }
    
    public void abort() throws IOException {
      synchronized (DiskLruCache.this) {
        DiskLruCache.this.completeEdit(this, false);
        return;
      } 
    }
    
    public void abortUnlessCommitted() {
      synchronized (DiskLruCache.this) {
        boolean bool = this.committed;
        if (!bool)
          try {
            DiskLruCache.this.completeEdit(this, false);
          } catch (IOException iOException) {} 
        return;
      } 
    }
    
    public void commit() throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.hasErrors) {
          DiskLruCache.this.completeEdit(this, false);
          DiskLruCache.this.removeEntry(this.entry);
        } else {
          DiskLruCache.this.completeEdit(this, true);
        } 
        this.committed = true;
        return;
      } 
    }
    
    public Sink newSink(int param1Int) throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.entry.currentEditor == this) {
          if (!this.entry.readable)
            this.written[param1Int] = true; 
          File file = this.entry.dirtyFiles[param1Int];
          try {
            Sink sink = DiskLruCache.this.fileSystem.sink(file);
            return (Sink)new FaultHidingSink(sink) {
                protected void onException(IOException param2IOException) {
                  synchronized (DiskLruCache.this) {
                    DiskLruCache.Editor.access$1902(DiskLruCache.Editor.this, true);
                    return;
                  } 
                }
              };
          } catch (FileNotFoundException fileNotFoundException) {
            return DiskLruCache.NULL_SINK;
          } 
        } 
        throw new IllegalStateException();
      } 
    }
    
    public Source newSource(int param1Int) throws IOException {
      synchronized (DiskLruCache.this) {
        if (this.entry.currentEditor == this) {
          if (!this.entry.readable)
            return null; 
          try {
            return DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[param1Int]);
          } catch (FileNotFoundException fileNotFoundException) {
            return null;
          } 
        } 
        throw new IllegalStateException();
      } 
    }
  }
  
  class null extends FaultHidingSink {
    null(Sink param1Sink) {
      super(param1Sink);
    }
    
    protected void onException(IOException param1IOException) {
      synchronized (DiskLruCache.this) {
        DiskLruCache.Editor.access$1902(this.this$1, true);
        return;
      } 
    }
  }
  
  final class Entry {
    private final File[] cleanFiles;
    
    private DiskLruCache.Editor currentEditor;
    
    private final File[] dirtyFiles;
    
    private final String key;
    
    private final long[] lengths;
    
    private boolean readable;
    
    private long sequenceNumber;
    
    private Entry(String param1String) {
      this.key = param1String;
      this.lengths = new long[DiskLruCache.this.valueCount];
      this.cleanFiles = new File[DiskLruCache.this.valueCount];
      this.dirtyFiles = new File[DiskLruCache.this.valueCount];
      StringBuilder stringBuilder = new StringBuilder(param1String);
      stringBuilder.append('.');
      int j = stringBuilder.length();
      for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
        stringBuilder.append(i);
        this.cleanFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
        stringBuilder.append(".tmp");
        this.dirtyFiles[i] = new File(DiskLruCache.this.directory, stringBuilder.toString());
        stringBuilder.setLength(j);
      } 
    }
    
    private IOException invalidLengths(String[] param1ArrayOfString) throws IOException {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected journal line: ");
      stringBuilder.append(Arrays.toString((Object[])param1ArrayOfString));
      throw new IOException(stringBuilder.toString());
    }
    
    private void setLengths(String[] param1ArrayOfString) throws IOException {
      if (param1ArrayOfString.length == DiskLruCache.this.valueCount) {
        int i = 0;
        try {
          while (i < param1ArrayOfString.length) {
            this.lengths[i] = Long.parseLong(param1ArrayOfString[i]);
            i++;
          } 
          return;
        } catch (NumberFormatException numberFormatException) {
          throw invalidLengths(param1ArrayOfString);
        } 
      } 
      throw invalidLengths(param1ArrayOfString);
    }
    
    DiskLruCache.Snapshot snapshot() {
      if (Thread.holdsLock(DiskLruCache.this)) {
        Source[] arrayOfSource = new Source[DiskLruCache.this.valueCount];
        long[] arrayOfLong = (long[])this.lengths.clone();
        boolean bool = false;
        int i = 0;
        try {
          while (i < DiskLruCache.this.valueCount) {
            arrayOfSource[i] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i]);
            i++;
          } 
          return new DiskLruCache.Snapshot(this.key, this.sequenceNumber, arrayOfSource, arrayOfLong);
        } catch (FileNotFoundException fileNotFoundException) {
          for (i = bool; i < DiskLruCache.this.valueCount && arrayOfSource[i] != null; i++)
            Util.closeQuietly((Closeable)arrayOfSource[i]); 
          return null;
        } 
      } 
      throw new AssertionError();
    }
    
    void writeLengths(BufferedSink param1BufferedSink) throws IOException {
      for (long l : this.lengths)
        param1BufferedSink.writeByte(32).writeDecimalLong(l); 
    }
  }
  
  public final class Snapshot implements Closeable {
    private final String key;
    
    private final long[] lengths;
    
    private final long sequenceNumber;
    
    private final Source[] sources;
    
    private Snapshot(String param1String, long param1Long, Source[] param1ArrayOfSource, long[] param1ArrayOflong) {
      this.key = param1String;
      this.sequenceNumber = param1Long;
      this.sources = param1ArrayOfSource;
      this.lengths = param1ArrayOflong;
    }
    
    public void close() {
      Source[] arrayOfSource = this.sources;
      int j = arrayOfSource.length;
      for (int i = 0; i < j; i++)
        Util.closeQuietly((Closeable)arrayOfSource[i]); 
    }
    
    public DiskLruCache.Editor edit() throws IOException {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }
    
    public long getLength(int param1Int) {
      return this.lengths[param1Int];
    }
    
    public Source getSource(int param1Int) {
      return this.sources[param1Int];
    }
    
    public String key() {
      return this.key;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */