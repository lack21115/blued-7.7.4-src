package com.blued.android.framework.web.cache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  
  private static final OutputStream p = new OutputStream() {
      public void write(int param1Int) throws IOException {}
    };
  
  final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
  
  private final File c;
  
  private final File d;
  
  private final File e;
  
  private final File f;
  
  private final int g;
  
  private long h;
  
  private final int i;
  
  private long j = 0L;
  
  private Writer k;
  
  private final LinkedHashMap<String, Entry> l = new LinkedHashMap<String, Entry>(0, 0.75F, true);
  
  private int m;
  
  private long n = 0L;
  
  private final Callable<Void> o = new Callable<Void>(this) {
      public Void a() throws Exception {
        synchronized (this.a) {
          if (DiskLruCache.a(this.a) == null)
            return null; 
          DiskLruCache.b(this.a);
          if (DiskLruCache.c(this.a)) {
            DiskLruCache.d(this.a);
            DiskLruCache.a(this.a, 0);
          } 
          return null;
        } 
      }
    };
  
  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong) {
    this.c = paramFile;
    this.g = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.i = paramInt2;
    this.h = paramLong;
  }
  
  private Editor a(String paramString, long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial h : ()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial e : (Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield l : Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/blued/android/framework/web/cache/DiskLruCache$Entry
    //   22: astore #6
    //   24: lload_2
    //   25: ldc2_w -1
    //   28: lcmp
    //   29: ifeq -> 55
    //   32: aload #6
    //   34: ifnull -> 51
    //   37: aload #6
    //   39: invokestatic e : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)J
    //   42: lstore #4
    //   44: lload #4
    //   46: lload_2
    //   47: lcmp
    //   48: ifeq -> 55
    //   51: aload_0
    //   52: monitorexit
    //   53: aconst_null
    //   54: areturn
    //   55: aload #6
    //   57: ifnonnull -> 86
    //   60: new com/blued/android/framework/web/cache/DiskLruCache$Entry
    //   63: dup
    //   64: aload_0
    //   65: aload_1
    //   66: aconst_null
    //   67: invokespecial <init> : (Lcom/blued/android/framework/web/cache/DiskLruCache;Ljava/lang/String;Lcom/blued/android/framework/web/cache/DiskLruCache$1;)V
    //   70: astore #6
    //   72: aload_0
    //   73: getfield l : Ljava/util/LinkedHashMap;
    //   76: aload_1
    //   77: aload #6
    //   79: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   82: pop
    //   83: goto -> 102
    //   86: aload #6
    //   88: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   91: astore #7
    //   93: aload #7
    //   95: ifnull -> 102
    //   98: aload_0
    //   99: monitorexit
    //   100: aconst_null
    //   101: areturn
    //   102: new com/blued/android/framework/web/cache/DiskLruCache$Editor
    //   105: dup
    //   106: aload_0
    //   107: aload #6
    //   109: aconst_null
    //   110: invokespecial <init> : (Lcom/blued/android/framework/web/cache/DiskLruCache;Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;Lcom/blued/android/framework/web/cache/DiskLruCache$1;)V
    //   113: astore #7
    //   115: aload #6
    //   117: aload #7
    //   119: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   122: pop
    //   123: aload_0
    //   124: getfield k : Ljava/io/Writer;
    //   127: astore #6
    //   129: new java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial <init> : ()V
    //   136: astore #8
    //   138: aload #8
    //   140: ldc 'DIRTY '
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload #8
    //   148: aload_1
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #8
    //   155: bipush #10
    //   157: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #6
    //   163: aload #8
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokevirtual write : (Ljava/lang/String;)V
    //   171: aload_0
    //   172: getfield k : Ljava/io/Writer;
    //   175: invokevirtual flush : ()V
    //   178: aload_0
    //   179: monitorexit
    //   180: aload #7
    //   182: areturn
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	183	finally
    //   37	44	183	finally
    //   60	83	183	finally
    //   86	93	183	finally
    //   102	178	183	finally
  }
  
  public static DiskLruCache a(File paramFile, int paramInt1, int paramInt2, long paramLong) throws IOException {
    if (paramLong > 0L) {
      if (paramInt2 > 0) {
        File file = new File(paramFile, "journal.bkp");
        if (file.exists()) {
          File file1 = new File(paramFile, "journal");
          if (file1.exists()) {
            file.delete();
          } else {
            a(file, file1, false);
          } 
        } 
        DiskLruCache diskLruCache2 = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        if (diskLruCache2.d.exists())
          try {
            diskLruCache2.d();
            diskLruCache2.e();
            return diskLruCache2;
          } catch (IOException iOException) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DiskLruCache ");
            stringBuilder.append(paramFile);
            stringBuilder.append(" is corrupt: ");
            stringBuilder.append(iOException.getMessage());
            stringBuilder.append(", removing");
            printStream.println(stringBuilder.toString());
            diskLruCache2.b();
          }  
        paramFile.mkdirs();
        DiskLruCache diskLruCache1 = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        diskLruCache1.f();
        return diskLruCache1;
      } 
      throw new IllegalArgumentException("valueCount <= 0");
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a(Editor paramEditor, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;)Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;
    //   6: astore #10
    //   8: aload #10
    //   10: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   13: aload_1
    //   14: if_acmpne -> 452
    //   17: iconst_0
    //   18: istore #5
    //   20: iload #5
    //   22: istore #4
    //   24: iload_2
    //   25: ifeq -> 127
    //   28: iload #5
    //   30: istore #4
    //   32: aload #10
    //   34: invokestatic d : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Z
    //   37: ifne -> 127
    //   40: iconst_0
    //   41: istore_3
    //   42: iload #5
    //   44: istore #4
    //   46: iload_3
    //   47: aload_0
    //   48: getfield i : I
    //   51: if_icmpge -> 127
    //   54: aload_1
    //   55: invokestatic b : (Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;)[Z
    //   58: iload_3
    //   59: baload
    //   60: ifeq -> 89
    //   63: aload #10
    //   65: iload_3
    //   66: invokevirtual b : (I)Ljava/io/File;
    //   69: invokevirtual exists : ()Z
    //   72: ifne -> 82
    //   75: aload_1
    //   76: invokevirtual b : ()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: iload_3
    //   83: iconst_1
    //   84: iadd
    //   85: istore_3
    //   86: goto -> 42
    //   89: aload_1
    //   90: invokevirtual b : ()V
    //   93: new java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial <init> : ()V
    //   100: astore_1
    //   101: aload_1
    //   102: ldc_w 'Newly created entry didn't create value for index '
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_1
    //   110: iload_3
    //   111: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: new java/lang/IllegalStateException
    //   118: dup
    //   119: aload_1
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokespecial <init> : (Ljava/lang/String;)V
    //   126: athrow
    //   127: iload #4
    //   129: aload_0
    //   130: getfield i : I
    //   133: if_icmpge -> 222
    //   136: aload #10
    //   138: iload #4
    //   140: invokevirtual b : (I)Ljava/io/File;
    //   143: astore_1
    //   144: iload_2
    //   145: ifeq -> 215
    //   148: aload_1
    //   149: invokevirtual exists : ()Z
    //   152: ifeq -> 465
    //   155: aload #10
    //   157: iload #4
    //   159: invokevirtual a : (I)Ljava/io/File;
    //   162: astore #11
    //   164: aload_1
    //   165: aload #11
    //   167: invokevirtual renameTo : (Ljava/io/File;)Z
    //   170: pop
    //   171: aload #10
    //   173: invokestatic b : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)[J
    //   176: iload #4
    //   178: laload
    //   179: lstore #6
    //   181: aload #11
    //   183: invokevirtual length : ()J
    //   186: lstore #8
    //   188: aload #10
    //   190: invokestatic b : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)[J
    //   193: iload #4
    //   195: lload #8
    //   197: lastore
    //   198: aload_0
    //   199: aload_0
    //   200: getfield j : J
    //   203: lload #6
    //   205: lsub
    //   206: lload #8
    //   208: ladd
    //   209: putfield j : J
    //   212: goto -> 465
    //   215: aload_1
    //   216: invokestatic a : (Ljava/io/File;)V
    //   219: goto -> 465
    //   222: aload_0
    //   223: aload_0
    //   224: getfield m : I
    //   227: iconst_1
    //   228: iadd
    //   229: putfield m : I
    //   232: aload #10
    //   234: aconst_null
    //   235: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   238: pop
    //   239: aload #10
    //   241: invokestatic d : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Z
    //   244: iload_2
    //   245: ior
    //   246: ifeq -> 347
    //   249: aload #10
    //   251: iconst_1
    //   252: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;Z)Z
    //   255: pop
    //   256: aload_0
    //   257: getfield k : Ljava/io/Writer;
    //   260: astore_1
    //   261: new java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial <init> : ()V
    //   268: astore #11
    //   270: aload #11
    //   272: ldc_w 'CLEAN '
    //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload #11
    //   281: aload #10
    //   283: invokestatic c : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Ljava/lang/String;
    //   286: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload #11
    //   292: aload #10
    //   294: invokevirtual a : ()Ljava/lang/String;
    //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload #11
    //   303: bipush #10
    //   305: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_1
    //   310: aload #11
    //   312: invokevirtual toString : ()Ljava/lang/String;
    //   315: invokevirtual write : (Ljava/lang/String;)V
    //   318: iload_2
    //   319: ifeq -> 411
    //   322: aload_0
    //   323: getfield n : J
    //   326: lstore #6
    //   328: aload_0
    //   329: lconst_1
    //   330: lload #6
    //   332: ladd
    //   333: putfield n : J
    //   336: aload #10
    //   338: lload #6
    //   340: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;J)J
    //   343: pop2
    //   344: goto -> 411
    //   347: aload_0
    //   348: getfield l : Ljava/util/LinkedHashMap;
    //   351: aload #10
    //   353: invokestatic c : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Ljava/lang/String;
    //   356: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   359: pop
    //   360: aload_0
    //   361: getfield k : Ljava/io/Writer;
    //   364: astore_1
    //   365: new java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial <init> : ()V
    //   372: astore #11
    //   374: aload #11
    //   376: ldc_w 'REMOVE '
    //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #11
    //   385: aload #10
    //   387: invokestatic c : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Ljava/lang/String;
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #11
    //   396: bipush #10
    //   398: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_1
    //   403: aload #11
    //   405: invokevirtual toString : ()Ljava/lang/String;
    //   408: invokevirtual write : (Ljava/lang/String;)V
    //   411: aload_0
    //   412: getfield k : Ljava/io/Writer;
    //   415: invokevirtual flush : ()V
    //   418: aload_0
    //   419: getfield j : J
    //   422: aload_0
    //   423: getfield h : J
    //   426: lcmp
    //   427: ifgt -> 437
    //   430: aload_0
    //   431: invokespecial g : ()Z
    //   434: ifeq -> 449
    //   437: aload_0
    //   438: getfield b : Ljava/util/concurrent/ThreadPoolExecutor;
    //   441: aload_0
    //   442: getfield o : Ljava/util/concurrent/Callable;
    //   445: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   448: pop
    //   449: aload_0
    //   450: monitorexit
    //   451: return
    //   452: new java/lang/IllegalStateException
    //   455: dup
    //   456: invokespecial <init> : ()V
    //   459: athrow
    //   460: astore_1
    //   461: aload_0
    //   462: monitorexit
    //   463: aload_1
    //   464: athrow
    //   465: iload #4
    //   467: iconst_1
    //   468: iadd
    //   469: istore #4
    //   471: goto -> 127
    // Exception table:
    //   from	to	target	type
    //   2	17	460	finally
    //   32	40	460	finally
    //   46	79	460	finally
    //   89	127	460	finally
    //   127	144	460	finally
    //   148	212	460	finally
    //   215	219	460	finally
    //   222	318	460	finally
    //   322	344	460	finally
    //   347	411	460	finally
    //   411	437	460	finally
    //   437	449	460	finally
    //   452	460	460	finally
  }
  
  private static void a(File paramFile) throws IOException {
    if (paramFile.exists()) {
      if (paramFile.delete())
        return; 
      throw new IOException();
    } 
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean) throws IOException {
    if (paramBoolean)
      a(paramFile2); 
    if (paramFile1.renameTo(paramFile2))
      return; 
    throw new IOException();
  }
  
  private void d() throws IOException {
    StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.d), Util.a);
    try {
      String str1 = strictLineReader.a();
      String str2 = strictLineReader.a();
      String str5 = strictLineReader.a();
      String str3 = strictLineReader.a();
      String str4 = strictLineReader.a();
      if ("libcore.io.DiskLruCache".equals(str1) && "1".equals(str2) && Integer.toString(this.g).equals(str5) && Integer.toString(this.i).equals(str3)) {
        boolean bool = "".equals(str4);
        if (bool) {
          int i = 0;
          try {
            while (true) {
              d(strictLineReader.a());
              i++;
            } 
          } catch (EOFException eOFException) {
            this.m = i - this.l.size();
            if (strictLineReader.b()) {
              f();
            } else {
              this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), Util.a));
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
      Util.a(strictLineReader);
    } 
  }
  
  private void d(String paramString) throws IOException {
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
            this.l.remove(str1);
            return;
          } 
        } 
      } else {
        str = paramString.substring(j, k);
      } 
      Entry entry2 = this.l.get(str);
      Entry entry1 = entry2;
      if (entry2 == null) {
        entry1 = new Entry(str);
        this.l.put(str, entry1);
      } 
      if (k != -1 && i == 5 && paramString.startsWith("CLEAN")) {
        arrayOfString = paramString.substring(k + 1).split(" ");
        Entry.a(entry1, true);
        Entry.a(entry1, (Editor)null);
        Entry.a(entry1, arrayOfString);
        return;
      } 
      if (k == -1 && i == 5 && arrayOfString.startsWith("DIRTY")) {
        Entry.a(entry1, new Editor(entry1));
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
  
  private void e() throws IOException {
    a(this.e);
    Iterator<Entry> iterator = this.l.values().iterator();
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      Editor editor = Entry.a(entry);
      boolean bool = false;
      int i = 0;
      if (editor == null) {
        while (i < this.i) {
          this.j += Entry.b(entry)[i];
          i++;
        } 
        continue;
      } 
      Entry.a(entry, (Editor)null);
      for (i = bool; i < this.i; i++) {
        a(entry.a(i));
        a(entry.b(i));
      } 
      iterator.remove();
    } 
  }
  
  private void e(String paramString) {
    if (a.matcher(paramString).matches())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private void f() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Ljava/io/Writer;
    //   6: ifnull -> 16
    //   9: aload_0
    //   10: getfield k : Ljava/io/Writer;
    //   13: invokevirtual close : ()V
    //   16: new java/io/BufferedWriter
    //   19: dup
    //   20: new java/io/OutputStreamWriter
    //   23: dup
    //   24: new java/io/FileOutputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield e : Ljava/io/File;
    //   32: invokespecial <init> : (Ljava/io/File;)V
    //   35: getstatic com/blued/android/framework/web/cache/Util.a : Ljava/nio/charset/Charset;
    //   38: invokespecial <init> : (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   41: invokespecial <init> : (Ljava/io/Writer;)V
    //   44: astore_1
    //   45: aload_1
    //   46: ldc_w 'libcore.io.DiskLruCache'
    //   49: invokevirtual write : (Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc_w '\\n'
    //   56: invokevirtual write : (Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc_w '1'
    //   63: invokevirtual write : (Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w '\\n'
    //   70: invokevirtual write : (Ljava/lang/String;)V
    //   73: aload_1
    //   74: aload_0
    //   75: getfield g : I
    //   78: invokestatic toString : (I)Ljava/lang/String;
    //   81: invokevirtual write : (Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc_w '\\n'
    //   88: invokevirtual write : (Ljava/lang/String;)V
    //   91: aload_1
    //   92: aload_0
    //   93: getfield i : I
    //   96: invokestatic toString : (I)Ljava/lang/String;
    //   99: invokevirtual write : (Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc_w '\\n'
    //   106: invokevirtual write : (Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc_w '\\n'
    //   113: invokevirtual write : (Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield l : Ljava/util/LinkedHashMap;
    //   120: invokevirtual values : ()Ljava/util/Collection;
    //   123: invokeinterface iterator : ()Ljava/util/Iterator;
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface hasNext : ()Z
    //   135: ifeq -> 260
    //   138: aload_2
    //   139: invokeinterface next : ()Ljava/lang/Object;
    //   144: checkcast com/blued/android/framework/web/cache/DiskLruCache$Entry
    //   147: astore_3
    //   148: aload_3
    //   149: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   152: ifnull -> 202
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #4
    //   164: aload #4
    //   166: ldc 'DIRTY '
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #4
    //   174: aload_3
    //   175: invokestatic c : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Ljava/lang/String;
    //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload #4
    //   184: bipush #10
    //   186: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: aload #4
    //   193: invokevirtual toString : ()Ljava/lang/String;
    //   196: invokevirtual write : (Ljava/lang/String;)V
    //   199: goto -> 129
    //   202: new java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial <init> : ()V
    //   209: astore #4
    //   211: aload #4
    //   213: ldc_w 'CLEAN '
    //   216: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload #4
    //   222: aload_3
    //   223: invokestatic c : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Ljava/lang/String;
    //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload #4
    //   232: aload_3
    //   233: invokevirtual a : ()Ljava/lang/String;
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #4
    //   242: bipush #10
    //   244: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: aload #4
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: invokevirtual write : (Ljava/lang/String;)V
    //   257: goto -> 129
    //   260: aload_1
    //   261: invokevirtual close : ()V
    //   264: aload_0
    //   265: getfield d : Ljava/io/File;
    //   268: invokevirtual exists : ()Z
    //   271: ifeq -> 286
    //   274: aload_0
    //   275: getfield d : Ljava/io/File;
    //   278: aload_0
    //   279: getfield f : Ljava/io/File;
    //   282: iconst_1
    //   283: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   286: aload_0
    //   287: getfield e : Ljava/io/File;
    //   290: aload_0
    //   291: getfield d : Ljava/io/File;
    //   294: iconst_0
    //   295: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   298: aload_0
    //   299: getfield f : Ljava/io/File;
    //   302: invokevirtual delete : ()Z
    //   305: pop
    //   306: aload_0
    //   307: new java/io/BufferedWriter
    //   310: dup
    //   311: new java/io/OutputStreamWriter
    //   314: dup
    //   315: new java/io/FileOutputStream
    //   318: dup
    //   319: aload_0
    //   320: getfield d : Ljava/io/File;
    //   323: iconst_1
    //   324: invokespecial <init> : (Ljava/io/File;Z)V
    //   327: getstatic com/blued/android/framework/web/cache/Util.a : Ljava/nio/charset/Charset;
    //   330: invokespecial <init> : (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   333: invokespecial <init> : (Ljava/io/Writer;)V
    //   336: putfield k : Ljava/io/Writer;
    //   339: aload_0
    //   340: monitorexit
    //   341: return
    //   342: astore_2
    //   343: aload_1
    //   344: invokevirtual close : ()V
    //   347: aload_2
    //   348: athrow
    //   349: astore_1
    //   350: aload_0
    //   351: monitorexit
    //   352: aload_1
    //   353: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	349	finally
    //   16	45	349	finally
    //   45	129	342	finally
    //   129	199	342	finally
    //   202	257	342	finally
    //   260	286	349	finally
    //   286	339	349	finally
    //   343	349	349	finally
  }
  
  private boolean g() {
    int i = this.m;
    return (i >= 2000 && i >= this.l.size());
  }
  
  private void h() {
    if (this.k != null)
      return; 
    throw new IllegalStateException("cache is closed");
  }
  
  private void i() throws IOException {
    while (this.j > this.h)
      c((String)((Map.Entry)this.l.entrySet().iterator().next()).getKey()); 
  }
  
  public Snapshot a(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial h : ()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial e : (Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield l : Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/blued/android/framework/web/cache/DiskLruCache$Entry
    //   22: astore #6
    //   24: aload #6
    //   26: ifnonnull -> 33
    //   29: aload_0
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload #6
    //   35: invokestatic d : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Z
    //   38: istore #4
    //   40: iload #4
    //   42: ifne -> 49
    //   45: aload_0
    //   46: monitorexit
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: getfield i : I
    //   53: anewarray java/io/InputStream
    //   56: astore #5
    //   58: iconst_0
    //   59: istore_3
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: aload_0
    //   64: getfield i : I
    //   67: if_icmpge -> 94
    //   70: aload #5
    //   72: iload_2
    //   73: new java/io/FileInputStream
    //   76: dup
    //   77: aload #6
    //   79: iload_2
    //   80: invokevirtual a : (I)Ljava/io/File;
    //   83: invokespecial <init> : (Ljava/io/File;)V
    //   86: aastore
    //   87: iload_2
    //   88: iconst_1
    //   89: iadd
    //   90: istore_2
    //   91: goto -> 62
    //   94: aload_0
    //   95: aload_0
    //   96: getfield m : I
    //   99: iconst_1
    //   100: iadd
    //   101: putfield m : I
    //   104: aload_0
    //   105: getfield k : Ljava/io/Writer;
    //   108: astore #7
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore #8
    //   119: aload #8
    //   121: ldc_w 'READ '
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload #8
    //   130: aload_1
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #8
    //   137: bipush #10
    //   139: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload #7
    //   145: aload #8
    //   147: invokevirtual toString : ()Ljava/lang/String;
    //   150: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   153: pop
    //   154: aload_0
    //   155: invokespecial g : ()Z
    //   158: ifeq -> 173
    //   161: aload_0
    //   162: getfield b : Ljava/util/concurrent/ThreadPoolExecutor;
    //   165: aload_0
    //   166: getfield o : Ljava/util/concurrent/Callable;
    //   169: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   172: pop
    //   173: new com/blued/android/framework/web/cache/DiskLruCache$Snapshot
    //   176: dup
    //   177: aload_0
    //   178: aload_1
    //   179: aload #6
    //   181: invokestatic e : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)J
    //   184: aload #5
    //   186: aload #6
    //   188: invokestatic b : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)[J
    //   191: aconst_null
    //   192: invokespecial <init> : (Lcom/blued/android/framework/web/cache/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/blued/android/framework/web/cache/DiskLruCache$1;)V
    //   195: astore_1
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_1
    //   199: areturn
    //   200: iload_2
    //   201: aload_0
    //   202: getfield i : I
    //   205: if_icmpge -> 229
    //   208: aload #5
    //   210: iload_2
    //   211: aaload
    //   212: ifnull -> 229
    //   215: aload #5
    //   217: iload_2
    //   218: aaload
    //   219: invokestatic a : (Ljava/io/Closeable;)V
    //   222: iload_2
    //   223: iconst_1
    //   224: iadd
    //   225: istore_2
    //   226: goto -> 200
    //   229: aload_0
    //   230: monitorexit
    //   231: aconst_null
    //   232: areturn
    //   233: astore_1
    //   234: aload_0
    //   235: monitorexit
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: iload_3
    //   240: istore_2
    //   241: goto -> 200
    // Exception table:
    //   from	to	target	type
    //   2	24	233	finally
    //   33	40	233	finally
    //   49	58	233	finally
    //   62	87	238	java/io/FileNotFoundException
    //   62	87	233	finally
    //   94	173	233	finally
    //   173	196	233	finally
    //   200	208	233	finally
    //   215	222	233	finally
  }
  
  public void a() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial h : ()V
    //   6: aload_0
    //   7: invokespecial i : ()V
    //   10: aload_0
    //   11: getfield k : Ljava/io/Writer;
    //   14: invokevirtual flush : ()V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  public Editor b(String paramString) throws IOException {
    return a(paramString, -1L);
  }
  
  public void b() throws IOException {
    close();
    Util.a(this.c);
  }
  
  public boolean c(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial h : ()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial e : (Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield l : Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/blued/android/framework/web/cache/DiskLruCache$Entry
    //   22: astore #4
    //   24: iconst_0
    //   25: istore_2
    //   26: aload #4
    //   28: ifnull -> 229
    //   31: aload #4
    //   33: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   36: ifnull -> 42
    //   39: goto -> 229
    //   42: iload_2
    //   43: aload_0
    //   44: getfield i : I
    //   47: if_icmpge -> 139
    //   50: aload #4
    //   52: iload_2
    //   53: invokevirtual a : (I)Ljava/io/File;
    //   56: astore_3
    //   57: aload_3
    //   58: invokevirtual exists : ()Z
    //   61: ifeq -> 108
    //   64: aload_3
    //   65: invokevirtual delete : ()Z
    //   68: ifeq -> 74
    //   71: goto -> 108
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore_1
    //   82: aload_1
    //   83: ldc_w 'failed to delete '
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: aload_3
    //   92: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: new java/io/IOException
    //   99: dup
    //   100: aload_1
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: invokespecial <init> : (Ljava/lang/String;)V
    //   107: athrow
    //   108: aload_0
    //   109: aload_0
    //   110: getfield j : J
    //   113: aload #4
    //   115: invokestatic b : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)[J
    //   118: iload_2
    //   119: laload
    //   120: lsub
    //   121: putfield j : J
    //   124: aload #4
    //   126: invokestatic b : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)[J
    //   129: iload_2
    //   130: lconst_0
    //   131: lastore
    //   132: iload_2
    //   133: iconst_1
    //   134: iadd
    //   135: istore_2
    //   136: goto -> 42
    //   139: aload_0
    //   140: aload_0
    //   141: getfield m : I
    //   144: iconst_1
    //   145: iadd
    //   146: putfield m : I
    //   149: aload_0
    //   150: getfield k : Ljava/io/Writer;
    //   153: astore_3
    //   154: new java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial <init> : ()V
    //   161: astore #4
    //   163: aload #4
    //   165: ldc_w 'REMOVE '
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #4
    //   174: aload_1
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload #4
    //   181: bipush #10
    //   183: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_3
    //   188: aload #4
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   196: pop
    //   197: aload_0
    //   198: getfield l : Ljava/util/LinkedHashMap;
    //   201: aload_1
    //   202: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload_0
    //   207: invokespecial g : ()Z
    //   210: ifeq -> 225
    //   213: aload_0
    //   214: getfield b : Ljava/util/concurrent/ThreadPoolExecutor;
    //   217: aload_0
    //   218: getfield o : Ljava/util/concurrent/Callable;
    //   221: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   224: pop
    //   225: aload_0
    //   226: monitorexit
    //   227: iconst_1
    //   228: ireturn
    //   229: aload_0
    //   230: monitorexit
    //   231: iconst_0
    //   232: ireturn
    //   233: astore_1
    //   234: aload_0
    //   235: monitorexit
    //   236: aload_1
    //   237: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	233	finally
    //   31	39	233	finally
    //   42	71	233	finally
    //   74	108	233	finally
    //   108	132	233	finally
    //   139	225	233	finally
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Ljava/io/Writer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/util/ArrayList
    //   17: dup
    //   18: aload_0
    //   19: getfield l : Ljava/util/LinkedHashMap;
    //   22: invokevirtual values : ()Ljava/util/Collection;
    //   25: invokespecial <init> : (Ljava/util/Collection;)V
    //   28: invokevirtual iterator : ()Ljava/util/Iterator;
    //   31: astore_1
    //   32: aload_1
    //   33: invokeinterface hasNext : ()Z
    //   38: ifeq -> 68
    //   41: aload_1
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast com/blued/android/framework/web/cache/DiskLruCache$Entry
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   55: ifnull -> 32
    //   58: aload_2
    //   59: invokestatic a : (Lcom/blued/android/framework/web/cache/DiskLruCache$Entry;)Lcom/blued/android/framework/web/cache/DiskLruCache$Editor;
    //   62: invokevirtual b : ()V
    //   65: goto -> 32
    //   68: aload_0
    //   69: invokespecial i : ()V
    //   72: aload_0
    //   73: getfield k : Ljava/io/Writer;
    //   76: invokevirtual close : ()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield k : Ljava/io/Writer;
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	87	finally
    //   14	32	87	finally
    //   32	65	87	finally
    //   68	84	87	finally
  }
  
  public final class Editor {
    private final DiskLruCache.Entry b;
    
    private final boolean[] c;
    
    private boolean d;
    
    private boolean e;
    
    private Editor(DiskLruCache this$0, DiskLruCache.Entry param1Entry) {
      boolean[] arrayOfBoolean;
      this.b = param1Entry;
      if (DiskLruCache.Entry.d(param1Entry)) {
        DiskLruCache.this = null;
      } else {
        arrayOfBoolean = new boolean[DiskLruCache.e(DiskLruCache.this)];
      } 
      this.c = arrayOfBoolean;
    }
    
    public OutputStream a(int param1Int) throws IOException {
      if (param1Int >= 0 && param1Int < DiskLruCache.e(this.a))
        synchronized (this.a) {
          if (DiskLruCache.Entry.a(this.b) == this) {
            if (!DiskLruCache.Entry.d(this.b))
              this.c[param1Int] = true; 
            File file = this.b.b(param1Int);
            try {
              FileOutputStream fileOutputStream = new FileOutputStream(file);
              return new FaultHidingOutputStream(fileOutputStream);
            } catch (FileNotFoundException fileNotFoundException) {
              DiskLruCache.f(this.a).mkdirs();
              try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                return new FaultHidingOutputStream(fileOutputStream);
              } catch (FileNotFoundException fileNotFoundException1) {
                return DiskLruCache.c();
              } 
            } 
          } 
          throw new IllegalStateException();
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected index ");
      stringBuilder.append(param1Int);
      stringBuilder.append(" to be greater than 0 and less than the maximum value count of ");
      stringBuilder.append(DiskLruCache.e(this.a));
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void a() throws IOException {
      if (this.d) {
        DiskLruCache.a(this.a, this, false);
        this.a.c(DiskLruCache.Entry.c(this.b));
      } else {
        DiskLruCache.a(this.a, this, true);
      } 
      this.e = true;
    }
    
    public void b() throws IOException {
      DiskLruCache.a(this.a, this, false);
    }
    
    class FaultHidingOutputStream extends FilterOutputStream {
      private FaultHidingOutputStream(DiskLruCache.Editor this$0, OutputStream param2OutputStream) {
        super(param2OutputStream);
      }
      
      public void close() {
        try {
          this.out.close();
          return;
        } catch (IOException iOException) {
          DiskLruCache.Editor.a(this.a, true);
          return;
        } 
      }
      
      public void flush() {
        try {
          this.out.flush();
          return;
        } catch (IOException iOException) {
          DiskLruCache.Editor.a(this.a, true);
          return;
        } 
      }
      
      public void write(int param2Int) {
        try {
          this.out.write(param2Int);
          return;
        } catch (IOException iOException) {
          DiskLruCache.Editor.a(this.a, true);
          return;
        } 
      }
      
      public void write(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) {
        try {
          this.out.write(param2ArrayOfbyte, param2Int1, param2Int2);
          return;
        } catch (IOException iOException) {
          DiskLruCache.Editor.a(this.a, true);
          return;
        } 
      }
    }
  }
  
  class FaultHidingOutputStream extends FilterOutputStream {
    private FaultHidingOutputStream(DiskLruCache this$0, OutputStream param1OutputStream) {
      super(param1OutputStream);
    }
    
    public void close() {
      try {
        this.out.close();
        return;
      } catch (IOException iOException) {
        DiskLruCache.Editor.a(this.a, true);
        return;
      } 
    }
    
    public void flush() {
      try {
        this.out.flush();
        return;
      } catch (IOException iOException) {
        DiskLruCache.Editor.a(this.a, true);
        return;
      } 
    }
    
    public void write(int param1Int) {
      try {
        this.out.write(param1Int);
        return;
      } catch (IOException iOException) {
        DiskLruCache.Editor.a(this.a, true);
        return;
      } 
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        DiskLruCache.Editor.a(this.a, true);
        return;
      } 
    }
  }
  
  final class Entry {
    private final String b;
    
    private final long[] c;
    
    private boolean d;
    
    private DiskLruCache.Editor e;
    
    private long f;
    
    private Entry(DiskLruCache this$0, String param1String) {
      this.b = param1String;
      this.c = new long[DiskLruCache.e(DiskLruCache.this)];
    }
    
    private void a(String[] param1ArrayOfString) throws IOException {
      if (param1ArrayOfString.length == DiskLruCache.e(this.a)) {
        int i = 0;
        try {
          while (i < param1ArrayOfString.length) {
            this.c[i] = Long.parseLong(param1ArrayOfString[i]);
            i++;
          } 
          return;
        } catch (NumberFormatException numberFormatException) {
          throw b(param1ArrayOfString);
        } 
      } 
      throw b(param1ArrayOfString);
    }
    
    private IOException b(String[] param1ArrayOfString) throws IOException {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected journal line: ");
      stringBuilder.append(Arrays.toString((Object[])param1ArrayOfString));
      throw new IOException(stringBuilder.toString());
    }
    
    public File a(int param1Int) {
      File file = DiskLruCache.f(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(".");
      stringBuilder.append(param1Int);
      return new File(file, stringBuilder.toString());
    }
    
    public String a() throws IOException {
      StringBuilder stringBuilder = new StringBuilder();
      for (long l : this.c) {
        stringBuilder.append(' ');
        stringBuilder.append(l);
      } 
      return stringBuilder.toString();
    }
    
    public File b(int param1Int) {
      File file = DiskLruCache.f(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(".");
      stringBuilder.append(param1Int);
      stringBuilder.append(".tmp");
      return new File(file, stringBuilder.toString());
    }
  }
  
  public final class Snapshot implements Closeable {
    private final String b;
    
    private final long c;
    
    private final InputStream[] d;
    
    private final long[] e;
    
    private Snapshot(DiskLruCache this$0, String param1String, long param1Long, InputStream[] param1ArrayOfInputStream, long[] param1ArrayOflong) {
      this.b = param1String;
      this.c = param1Long;
      this.d = param1ArrayOfInputStream;
      this.e = param1ArrayOflong;
    }
    
    public InputStream a(int param1Int) {
      return this.d[param1Int];
    }
    
    public void close() {
      InputStream[] arrayOfInputStream = this.d;
      int j = arrayOfInputStream.length;
      for (int i = 0; i < j; i++)
        Util.a(arrayOfInputStream[i]); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\cache\DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */