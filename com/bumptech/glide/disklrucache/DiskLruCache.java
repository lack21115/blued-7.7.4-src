package com.bumptech.glide.disklrucache;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable {
  final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new DiskLruCacheThreadFactory());
  
  private final File b;
  
  private final File c;
  
  private final File d;
  
  private final File e;
  
  private final int f;
  
  private long g;
  
  private final int h;
  
  private long i = 0L;
  
  private Writer j;
  
  private final LinkedHashMap<String, Entry> k = new LinkedHashMap<String, Entry>(0, 0.75F, true);
  
  private int l;
  
  private long m = 0L;
  
  private final Callable<Void> n = new Callable<Void>(this) {
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
    this.b = paramFile;
    this.f = paramInt1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.e = new File(paramFile, "journal.bkp");
    this.h = paramInt2;
    this.g = paramLong;
  }
  
  private Editor a(String paramString, long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial f : ()V
    //   6: aload_0
    //   7: getfield k : Ljava/util/LinkedHashMap;
    //   10: aload_1
    //   11: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast com/bumptech/glide/disklrucache/DiskLruCache$Entry
    //   17: astore #6
    //   19: lload_2
    //   20: ldc2_w -1
    //   23: lcmp
    //   24: ifeq -> 50
    //   27: aload #6
    //   29: ifnull -> 46
    //   32: aload #6
    //   34: invokestatic e : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)J
    //   37: lstore #4
    //   39: lload #4
    //   41: lload_2
    //   42: lcmp
    //   43: ifeq -> 50
    //   46: aload_0
    //   47: monitorexit
    //   48: aconst_null
    //   49: areturn
    //   50: aload #6
    //   52: ifnonnull -> 81
    //   55: new com/bumptech/glide/disklrucache/DiskLruCache$Entry
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: aconst_null
    //   62: invokespecial <init> : (Lcom/bumptech/glide/disklrucache/DiskLruCache;Ljava/lang/String;Lcom/bumptech/glide/disklrucache/DiskLruCache$1;)V
    //   65: astore #6
    //   67: aload_0
    //   68: getfield k : Ljava/util/LinkedHashMap;
    //   71: aload_1
    //   72: aload #6
    //   74: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: goto -> 97
    //   81: aload #6
    //   83: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   86: astore #7
    //   88: aload #7
    //   90: ifnull -> 97
    //   93: aload_0
    //   94: monitorexit
    //   95: aconst_null
    //   96: areturn
    //   97: new com/bumptech/glide/disklrucache/DiskLruCache$Editor
    //   100: dup
    //   101: aload_0
    //   102: aload #6
    //   104: aconst_null
    //   105: invokespecial <init> : (Lcom/bumptech/glide/disklrucache/DiskLruCache;Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;Lcom/bumptech/glide/disklrucache/DiskLruCache$1;)V
    //   108: astore #7
    //   110: aload #6
    //   112: aload #7
    //   114: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   117: pop
    //   118: aload_0
    //   119: getfield j : Ljava/io/Writer;
    //   122: ldc 'DIRTY'
    //   124: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   127: pop
    //   128: aload_0
    //   129: getfield j : Ljava/io/Writer;
    //   132: bipush #32
    //   134: invokevirtual append : (C)Ljava/io/Writer;
    //   137: pop
    //   138: aload_0
    //   139: getfield j : Ljava/io/Writer;
    //   142: aload_1
    //   143: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   146: pop
    //   147: aload_0
    //   148: getfield j : Ljava/io/Writer;
    //   151: bipush #10
    //   153: invokevirtual append : (C)Ljava/io/Writer;
    //   156: pop
    //   157: aload_0
    //   158: getfield j : Ljava/io/Writer;
    //   161: invokestatic b : (Ljava/io/Writer;)V
    //   164: aload_0
    //   165: monitorexit
    //   166: aload #7
    //   168: areturn
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	169	finally
    //   32	39	169	finally
    //   55	78	169	finally
    //   81	88	169	finally
    //   97	164	169	finally
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
        if (diskLruCache2.c.exists())
          try {
            diskLruCache2.b();
            diskLruCache2.c();
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
            diskLruCache2.a();
          }  
        paramFile.mkdirs();
        DiskLruCache diskLruCache1 = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        diskLruCache1.d();
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
    //   3: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;
    //   6: astore #10
    //   8: aload #10
    //   10: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   13: aload_1
    //   14: if_acmpne -> 439
    //   17: iconst_0
    //   18: istore #5
    //   20: iload #5
    //   22: istore #4
    //   24: iload_2
    //   25: ifeq -> 126
    //   28: iload #5
    //   30: istore #4
    //   32: aload #10
    //   34: invokestatic d : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Z
    //   37: ifne -> 126
    //   40: iconst_0
    //   41: istore_3
    //   42: iload #5
    //   44: istore #4
    //   46: iload_3
    //   47: aload_0
    //   48: getfield h : I
    //   51: if_icmpge -> 126
    //   54: aload_1
    //   55: invokestatic b : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;)[Z
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
    //   102: ldc 'Newly created entry didn't create value for index '
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: iload_3
    //   110: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: new java/lang/IllegalStateException
    //   117: dup
    //   118: aload_1
    //   119: invokevirtual toString : ()Ljava/lang/String;
    //   122: invokespecial <init> : (Ljava/lang/String;)V
    //   125: athrow
    //   126: iload #4
    //   128: aload_0
    //   129: getfield h : I
    //   132: if_icmpge -> 221
    //   135: aload #10
    //   137: iload #4
    //   139: invokevirtual b : (I)Ljava/io/File;
    //   142: astore_1
    //   143: iload_2
    //   144: ifeq -> 214
    //   147: aload_1
    //   148: invokevirtual exists : ()Z
    //   151: ifeq -> 452
    //   154: aload #10
    //   156: iload #4
    //   158: invokevirtual a : (I)Ljava/io/File;
    //   161: astore #11
    //   163: aload_1
    //   164: aload #11
    //   166: invokevirtual renameTo : (Ljava/io/File;)Z
    //   169: pop
    //   170: aload #10
    //   172: invokestatic b : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)[J
    //   175: iload #4
    //   177: laload
    //   178: lstore #6
    //   180: aload #11
    //   182: invokevirtual length : ()J
    //   185: lstore #8
    //   187: aload #10
    //   189: invokestatic b : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)[J
    //   192: iload #4
    //   194: lload #8
    //   196: lastore
    //   197: aload_0
    //   198: aload_0
    //   199: getfield i : J
    //   202: lload #6
    //   204: lsub
    //   205: lload #8
    //   207: ladd
    //   208: putfield i : J
    //   211: goto -> 452
    //   214: aload_1
    //   215: invokestatic a : (Ljava/io/File;)V
    //   218: goto -> 452
    //   221: aload_0
    //   222: aload_0
    //   223: getfield l : I
    //   226: iconst_1
    //   227: iadd
    //   228: putfield l : I
    //   231: aload #10
    //   233: aconst_null
    //   234: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   237: pop
    //   238: aload #10
    //   240: invokestatic d : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Z
    //   243: iload_2
    //   244: ior
    //   245: ifeq -> 341
    //   248: aload #10
    //   250: iconst_1
    //   251: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;Z)Z
    //   254: pop
    //   255: aload_0
    //   256: getfield j : Ljava/io/Writer;
    //   259: ldc_w 'CLEAN'
    //   262: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   265: pop
    //   266: aload_0
    //   267: getfield j : Ljava/io/Writer;
    //   270: bipush #32
    //   272: invokevirtual append : (C)Ljava/io/Writer;
    //   275: pop
    //   276: aload_0
    //   277: getfield j : Ljava/io/Writer;
    //   280: aload #10
    //   282: invokestatic c : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Ljava/lang/String;
    //   285: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   288: pop
    //   289: aload_0
    //   290: getfield j : Ljava/io/Writer;
    //   293: aload #10
    //   295: invokevirtual a : ()Ljava/lang/String;
    //   298: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   301: pop
    //   302: aload_0
    //   303: getfield j : Ljava/io/Writer;
    //   306: bipush #10
    //   308: invokevirtual append : (C)Ljava/io/Writer;
    //   311: pop
    //   312: iload_2
    //   313: ifeq -> 398
    //   316: aload_0
    //   317: getfield m : J
    //   320: lstore #6
    //   322: aload_0
    //   323: lconst_1
    //   324: lload #6
    //   326: ladd
    //   327: putfield m : J
    //   330: aload #10
    //   332: lload #6
    //   334: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;J)J
    //   337: pop2
    //   338: goto -> 398
    //   341: aload_0
    //   342: getfield k : Ljava/util/LinkedHashMap;
    //   345: aload #10
    //   347: invokestatic c : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Ljava/lang/String;
    //   350: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload_0
    //   355: getfield j : Ljava/io/Writer;
    //   358: ldc_w 'REMOVE'
    //   361: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   364: pop
    //   365: aload_0
    //   366: getfield j : Ljava/io/Writer;
    //   369: bipush #32
    //   371: invokevirtual append : (C)Ljava/io/Writer;
    //   374: pop
    //   375: aload_0
    //   376: getfield j : Ljava/io/Writer;
    //   379: aload #10
    //   381: invokestatic c : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Ljava/lang/String;
    //   384: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   387: pop
    //   388: aload_0
    //   389: getfield j : Ljava/io/Writer;
    //   392: bipush #10
    //   394: invokevirtual append : (C)Ljava/io/Writer;
    //   397: pop
    //   398: aload_0
    //   399: getfield j : Ljava/io/Writer;
    //   402: invokestatic b : (Ljava/io/Writer;)V
    //   405: aload_0
    //   406: getfield i : J
    //   409: aload_0
    //   410: getfield g : J
    //   413: lcmp
    //   414: ifgt -> 424
    //   417: aload_0
    //   418: invokespecial e : ()Z
    //   421: ifeq -> 436
    //   424: aload_0
    //   425: getfield a : Ljava/util/concurrent/ThreadPoolExecutor;
    //   428: aload_0
    //   429: getfield n : Ljava/util/concurrent/Callable;
    //   432: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   435: pop
    //   436: aload_0
    //   437: monitorexit
    //   438: return
    //   439: new java/lang/IllegalStateException
    //   442: dup
    //   443: invokespecial <init> : ()V
    //   446: athrow
    //   447: astore_1
    //   448: aload_0
    //   449: monitorexit
    //   450: aload_1
    //   451: athrow
    //   452: iload #4
    //   454: iconst_1
    //   455: iadd
    //   456: istore #4
    //   458: goto -> 126
    // Exception table:
    //   from	to	target	type
    //   2	17	447	finally
    //   32	40	447	finally
    //   46	79	447	finally
    //   89	126	447	finally
    //   126	143	447	finally
    //   147	211	447	finally
    //   214	218	447	finally
    //   221	312	447	finally
    //   316	338	447	finally
    //   341	398	447	finally
    //   398	424	447	finally
    //   424	436	447	finally
    //   439	447	447	finally
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
  
  private static void a(Writer paramWriter) throws IOException {
    if (Build.VERSION.SDK_INT < 26) {
      paramWriter.close();
      return;
    } 
    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder(threadPolicy)).permitUnbufferedIo().build());
    try {
      paramWriter.close();
      return;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  private void b() throws IOException {
    StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.c), Util.a);
    try {
      String str1 = strictLineReader.a();
      String str2 = strictLineReader.a();
      String str5 = strictLineReader.a();
      String str3 = strictLineReader.a();
      String str4 = strictLineReader.a();
      if ("libcore.io.DiskLruCache".equals(str1) && "1".equals(str2) && Integer.toString(this.f).equals(str5) && Integer.toString(this.h).equals(str3)) {
        boolean bool = "".equals(str4);
        if (bool) {
          int i = 0;
          try {
            while (true) {
              d(strictLineReader.a());
              i++;
            } 
          } catch (EOFException eOFException) {
            this.l = i - this.k.size();
            if (strictLineReader.b()) {
              d();
            } else {
              this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), Util.a));
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
  
  private static void b(Writer paramWriter) throws IOException {
    if (Build.VERSION.SDK_INT < 26) {
      paramWriter.flush();
      return;
    } 
    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder(threadPolicy)).permitUnbufferedIo().build());
    try {
      paramWriter.flush();
      return;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  private void c() throws IOException {
    a(this.d);
    Iterator<Entry> iterator = this.k.values().iterator();
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      Editor editor = Entry.a(entry);
      boolean bool = false;
      int i = 0;
      if (editor == null) {
        while (i < this.h) {
          this.i += Entry.b(entry)[i];
          i++;
        } 
        continue;
      } 
      Entry.a(entry, (Editor)null);
      for (i = bool; i < this.h; i++) {
        a(entry.a(i));
        a(entry.b(i));
      } 
      iterator.remove();
    } 
  }
  
  private void d() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Ljava/io/Writer;
    //   6: ifnull -> 16
    //   9: aload_0
    //   10: getfield j : Ljava/io/Writer;
    //   13: invokestatic a : (Ljava/io/Writer;)V
    //   16: new java/io/BufferedWriter
    //   19: dup
    //   20: new java/io/OutputStreamWriter
    //   23: dup
    //   24: new java/io/FileOutputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield d : Ljava/io/File;
    //   32: invokespecial <init> : (Ljava/io/File;)V
    //   35: getstatic com/bumptech/glide/disklrucache/Util.a : Ljava/nio/charset/Charset;
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
    //   75: getfield f : I
    //   78: invokestatic toString : (I)Ljava/lang/String;
    //   81: invokevirtual write : (Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc_w '\\n'
    //   88: invokevirtual write : (Ljava/lang/String;)V
    //   91: aload_1
    //   92: aload_0
    //   93: getfield h : I
    //   96: invokestatic toString : (I)Ljava/lang/String;
    //   99: invokevirtual write : (Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc_w '\\n'
    //   106: invokevirtual write : (Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc_w '\\n'
    //   113: invokevirtual write : (Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield k : Ljava/util/LinkedHashMap;
    //   120: invokevirtual values : ()Ljava/util/Collection;
    //   123: invokeinterface iterator : ()Ljava/util/Iterator;
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface hasNext : ()Z
    //   135: ifeq -> 261
    //   138: aload_2
    //   139: invokeinterface next : ()Ljava/lang/Object;
    //   144: checkcast com/bumptech/glide/disklrucache/DiskLruCache$Entry
    //   147: astore_3
    //   148: aload_3
    //   149: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   152: ifnull -> 203
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #4
    //   164: aload #4
    //   166: ldc_w 'DIRTY '
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload #4
    //   175: aload_3
    //   176: invokestatic c : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Ljava/lang/String;
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload #4
    //   185: bipush #10
    //   187: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: aload #4
    //   194: invokevirtual toString : ()Ljava/lang/String;
    //   197: invokevirtual write : (Ljava/lang/String;)V
    //   200: goto -> 129
    //   203: new java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial <init> : ()V
    //   210: astore #4
    //   212: aload #4
    //   214: ldc_w 'CLEAN '
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload #4
    //   223: aload_3
    //   224: invokestatic c : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Ljava/lang/String;
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #4
    //   233: aload_3
    //   234: invokevirtual a : ()Ljava/lang/String;
    //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload #4
    //   243: bipush #10
    //   245: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_1
    //   250: aload #4
    //   252: invokevirtual toString : ()Ljava/lang/String;
    //   255: invokevirtual write : (Ljava/lang/String;)V
    //   258: goto -> 129
    //   261: aload_1
    //   262: invokestatic a : (Ljava/io/Writer;)V
    //   265: aload_0
    //   266: getfield c : Ljava/io/File;
    //   269: invokevirtual exists : ()Z
    //   272: ifeq -> 287
    //   275: aload_0
    //   276: getfield c : Ljava/io/File;
    //   279: aload_0
    //   280: getfield e : Ljava/io/File;
    //   283: iconst_1
    //   284: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   287: aload_0
    //   288: getfield d : Ljava/io/File;
    //   291: aload_0
    //   292: getfield c : Ljava/io/File;
    //   295: iconst_0
    //   296: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   299: aload_0
    //   300: getfield e : Ljava/io/File;
    //   303: invokevirtual delete : ()Z
    //   306: pop
    //   307: aload_0
    //   308: new java/io/BufferedWriter
    //   311: dup
    //   312: new java/io/OutputStreamWriter
    //   315: dup
    //   316: new java/io/FileOutputStream
    //   319: dup
    //   320: aload_0
    //   321: getfield c : Ljava/io/File;
    //   324: iconst_1
    //   325: invokespecial <init> : (Ljava/io/File;Z)V
    //   328: getstatic com/bumptech/glide/disklrucache/Util.a : Ljava/nio/charset/Charset;
    //   331: invokespecial <init> : (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   334: invokespecial <init> : (Ljava/io/Writer;)V
    //   337: putfield j : Ljava/io/Writer;
    //   340: aload_0
    //   341: monitorexit
    //   342: return
    //   343: astore_2
    //   344: aload_1
    //   345: invokestatic a : (Ljava/io/Writer;)V
    //   348: aload_2
    //   349: athrow
    //   350: astore_1
    //   351: aload_0
    //   352: monitorexit
    //   353: aload_1
    //   354: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	350	finally
    //   16	45	350	finally
    //   45	129	343	finally
    //   129	200	343	finally
    //   203	258	343	finally
    //   261	287	350	finally
    //   287	340	350	finally
    //   344	350	350	finally
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
            this.k.remove(str1);
            return;
          } 
        } 
      } else {
        str = paramString.substring(j, k);
      } 
      Entry entry2 = this.k.get(str);
      Entry entry1 = entry2;
      if (entry2 == null) {
        entry1 = new Entry(str);
        this.k.put(str, entry1);
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
  
  private boolean e() {
    int i = this.l;
    return (i >= 2000 && i >= this.k.size());
  }
  
  private void f() {
    if (this.j != null)
      return; 
    throw new IllegalStateException("cache is closed");
  }
  
  private void g() throws IOException {
    while (this.i > this.g)
      c((String)((Map.Entry)this.k.entrySet().iterator().next()).getKey()); 
  }
  
  public Value a(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial f : ()V
    //   6: aload_0
    //   7: getfield k : Ljava/util/LinkedHashMap;
    //   10: aload_1
    //   11: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast com/bumptech/glide/disklrucache/DiskLruCache$Entry
    //   17: astore #5
    //   19: aload #5
    //   21: ifnonnull -> 28
    //   24: aload_0
    //   25: monitorexit
    //   26: aconst_null
    //   27: areturn
    //   28: aload #5
    //   30: invokestatic d : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Z
    //   33: istore #4
    //   35: iload #4
    //   37: ifne -> 44
    //   40: aload_0
    //   41: monitorexit
    //   42: aconst_null
    //   43: areturn
    //   44: aload #5
    //   46: getfield a : [Ljava/io/File;
    //   49: astore #6
    //   51: aload #6
    //   53: arraylength
    //   54: istore_3
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: iload_3
    //   59: if_icmpge -> 87
    //   62: aload #6
    //   64: iload_2
    //   65: aaload
    //   66: invokevirtual exists : ()Z
    //   69: istore #4
    //   71: iload #4
    //   73: ifne -> 80
    //   76: aload_0
    //   77: monitorexit
    //   78: aconst_null
    //   79: areturn
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: istore_2
    //   84: goto -> 57
    //   87: aload_0
    //   88: aload_0
    //   89: getfield l : I
    //   92: iconst_1
    //   93: iadd
    //   94: putfield l : I
    //   97: aload_0
    //   98: getfield j : Ljava/io/Writer;
    //   101: ldc_w 'READ'
    //   104: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   107: pop
    //   108: aload_0
    //   109: getfield j : Ljava/io/Writer;
    //   112: bipush #32
    //   114: invokevirtual append : (C)Ljava/io/Writer;
    //   117: pop
    //   118: aload_0
    //   119: getfield j : Ljava/io/Writer;
    //   122: aload_1
    //   123: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   126: pop
    //   127: aload_0
    //   128: getfield j : Ljava/io/Writer;
    //   131: bipush #10
    //   133: invokevirtual append : (C)Ljava/io/Writer;
    //   136: pop
    //   137: aload_0
    //   138: invokespecial e : ()Z
    //   141: ifeq -> 156
    //   144: aload_0
    //   145: getfield a : Ljava/util/concurrent/ThreadPoolExecutor;
    //   148: aload_0
    //   149: getfield n : Ljava/util/concurrent/Callable;
    //   152: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   155: pop
    //   156: new com/bumptech/glide/disklrucache/DiskLruCache$Value
    //   159: dup
    //   160: aload_0
    //   161: aload_1
    //   162: aload #5
    //   164: invokestatic e : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)J
    //   167: aload #5
    //   169: getfield a : [Ljava/io/File;
    //   172: aload #5
    //   174: invokestatic b : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)[J
    //   177: aconst_null
    //   178: invokespecial <init> : (Lcom/bumptech/glide/disklrucache/DiskLruCache;Ljava/lang/String;J[Ljava/io/File;[JLcom/bumptech/glide/disklrucache/DiskLruCache$1;)V
    //   181: astore_1
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_1
    //   185: areturn
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	186	finally
    //   28	35	186	finally
    //   44	55	186	finally
    //   62	71	186	finally
    //   87	156	186	finally
    //   156	182	186	finally
  }
  
  public void a() throws IOException {
    close();
    Util.a(this.b);
  }
  
  public Editor b(String paramString) throws IOException {
    return a(paramString, -1L);
  }
  
  public boolean c(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial f : ()V
    //   6: aload_0
    //   7: getfield k : Ljava/util/LinkedHashMap;
    //   10: aload_1
    //   11: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast com/bumptech/glide/disklrucache/DiskLruCache$Entry
    //   17: astore #4
    //   19: iconst_0
    //   20: istore_2
    //   21: aload #4
    //   23: ifnull -> 216
    //   26: aload #4
    //   28: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   31: ifnull -> 37
    //   34: goto -> 216
    //   37: iload_2
    //   38: aload_0
    //   39: getfield h : I
    //   42: if_icmpge -> 134
    //   45: aload #4
    //   47: iload_2
    //   48: invokevirtual a : (I)Ljava/io/File;
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual exists : ()Z
    //   56: ifeq -> 103
    //   59: aload_3
    //   60: invokevirtual delete : ()Z
    //   63: ifeq -> 69
    //   66: goto -> 103
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc_w 'failed to delete '
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: aload_3
    //   87: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: new java/io/IOException
    //   94: dup
    //   95: aload_1
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: invokespecial <init> : (Ljava/lang/String;)V
    //   102: athrow
    //   103: aload_0
    //   104: aload_0
    //   105: getfield i : J
    //   108: aload #4
    //   110: invokestatic b : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)[J
    //   113: iload_2
    //   114: laload
    //   115: lsub
    //   116: putfield i : J
    //   119: aload #4
    //   121: invokestatic b : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)[J
    //   124: iload_2
    //   125: lconst_0
    //   126: lastore
    //   127: iload_2
    //   128: iconst_1
    //   129: iadd
    //   130: istore_2
    //   131: goto -> 37
    //   134: aload_0
    //   135: aload_0
    //   136: getfield l : I
    //   139: iconst_1
    //   140: iadd
    //   141: putfield l : I
    //   144: aload_0
    //   145: getfield j : Ljava/io/Writer;
    //   148: ldc_w 'REMOVE'
    //   151: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   154: pop
    //   155: aload_0
    //   156: getfield j : Ljava/io/Writer;
    //   159: bipush #32
    //   161: invokevirtual append : (C)Ljava/io/Writer;
    //   164: pop
    //   165: aload_0
    //   166: getfield j : Ljava/io/Writer;
    //   169: aload_1
    //   170: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   173: pop
    //   174: aload_0
    //   175: getfield j : Ljava/io/Writer;
    //   178: bipush #10
    //   180: invokevirtual append : (C)Ljava/io/Writer;
    //   183: pop
    //   184: aload_0
    //   185: getfield k : Ljava/util/LinkedHashMap;
    //   188: aload_1
    //   189: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   192: pop
    //   193: aload_0
    //   194: invokespecial e : ()Z
    //   197: ifeq -> 212
    //   200: aload_0
    //   201: getfield a : Ljava/util/concurrent/ThreadPoolExecutor;
    //   204: aload_0
    //   205: getfield n : Ljava/util/concurrent/Callable;
    //   208: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   211: pop
    //   212: aload_0
    //   213: monitorexit
    //   214: iconst_1
    //   215: ireturn
    //   216: aload_0
    //   217: monitorexit
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_1
    //   221: aload_0
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	220	finally
    //   26	34	220	finally
    //   37	66	220	finally
    //   69	103	220	finally
    //   103	127	220	finally
    //   134	212	220	finally
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Ljava/io/Writer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/util/ArrayList
    //   17: dup
    //   18: aload_0
    //   19: getfield k : Ljava/util/LinkedHashMap;
    //   22: invokevirtual values : ()Ljava/util/Collection;
    //   25: invokespecial <init> : (Ljava/util/Collection;)V
    //   28: invokevirtual iterator : ()Ljava/util/Iterator;
    //   31: astore_1
    //   32: aload_1
    //   33: invokeinterface hasNext : ()Z
    //   38: ifeq -> 68
    //   41: aload_1
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast com/bumptech/glide/disklrucache/DiskLruCache$Entry
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   55: ifnull -> 32
    //   58: aload_2
    //   59: invokestatic a : (Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   62: invokevirtual b : ()V
    //   65: goto -> 32
    //   68: aload_0
    //   69: invokespecial g : ()V
    //   72: aload_0
    //   73: getfield j : Ljava/io/Writer;
    //   76: invokestatic a : (Ljava/io/Writer;)V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield j : Ljava/io/Writer;
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
  
  static final class DiskLruCacheThreadFactory implements ThreadFactory {
    private DiskLruCacheThreadFactory() {}
    
    public Thread newThread(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/lang/Thread
      //   5: dup
      //   6: aload_1
      //   7: ldc 'glide-disk-lru-cache-thread'
      //   9: invokespecial <init> : (Ljava/lang/Runnable;Ljava/lang/String;)V
      //   12: astore_1
      //   13: aload_1
      //   14: iconst_1
      //   15: invokevirtual setPriority : (I)V
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_1
      //   21: areturn
      //   22: astore_1
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	22	finally
    }
  }
  
  public final class Editor {
    private final DiskLruCache.Entry b;
    
    private final boolean[] c;
    
    private boolean d;
    
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
    
    public File a(int param1Int) throws IOException {
      synchronized (this.a) {
        if (DiskLruCache.Entry.a(this.b) == this) {
          if (!DiskLruCache.Entry.d(this.b))
            this.c[param1Int] = true; 
          File file = this.b.b(param1Int);
          if (!DiskLruCache.f(this.a).exists())
            DiskLruCache.f(this.a).mkdirs(); 
          return file;
        } 
        throw new IllegalStateException();
      } 
    }
    
    public void a() throws IOException {
      DiskLruCache.a(this.a, this, true);
      this.d = true;
    }
    
    public void b() throws IOException {
      DiskLruCache.a(this.a, this, false);
    }
    
    public void c() {
      if (!this.d)
        try {
          b();
          return;
        } catch (IOException iOException) {
          return;
        }  
    }
  }
  
  final class Entry {
    File[] a;
    
    File[] b;
    
    private final String d;
    
    private final long[] e;
    
    private boolean f;
    
    private DiskLruCache.Editor g;
    
    private long h;
    
    private Entry(DiskLruCache this$0, String param1String) {
      this.d = param1String;
      this.e = new long[DiskLruCache.e(DiskLruCache.this)];
      this.a = new File[DiskLruCache.e(DiskLruCache.this)];
      this.b = new File[DiskLruCache.e(DiskLruCache.this)];
      StringBuilder stringBuilder = new StringBuilder(param1String);
      stringBuilder.append('.');
      int j = stringBuilder.length();
      for (int i = 0; i < DiskLruCache.e(DiskLruCache.this); i++) {
        stringBuilder.append(i);
        this.a[i] = new File(DiskLruCache.f(DiskLruCache.this), stringBuilder.toString());
        stringBuilder.append(".tmp");
        this.b[i] = new File(DiskLruCache.f(DiskLruCache.this), stringBuilder.toString());
        stringBuilder.setLength(j);
      } 
    }
    
    private void a(String[] param1ArrayOfString) throws IOException {
      if (param1ArrayOfString.length == DiskLruCache.e(this.c)) {
        int i = 0;
        try {
          while (i < param1ArrayOfString.length) {
            this.e[i] = Long.parseLong(param1ArrayOfString[i]);
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
      return this.a[param1Int];
    }
    
    public String a() throws IOException {
      StringBuilder stringBuilder = new StringBuilder();
      for (long l : this.e) {
        stringBuilder.append(' ');
        stringBuilder.append(l);
      } 
      return stringBuilder.toString();
    }
    
    public File b(int param1Int) {
      return this.b[param1Int];
    }
  }
  
  public final class Value {
    private final String b;
    
    private final long c;
    
    private final long[] d;
    
    private final File[] e;
    
    private Value(DiskLruCache this$0, String param1String, long param1Long, File[] param1ArrayOfFile, long[] param1ArrayOflong) {
      this.b = param1String;
      this.c = param1Long;
      this.e = param1ArrayOfFile;
      this.d = param1ArrayOflong;
    }
    
    public File a(int param1Int) {
      return this.e[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\disklrucache\DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */