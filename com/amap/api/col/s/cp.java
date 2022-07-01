package com.amap.api.col.s;

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
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public final class cp implements Closeable {
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  
  public static final Charset b = Charset.forName("US-ASCII");
  
  static final Charset c = Charset.forName("UTF-8");
  
  static ThreadPoolExecutor d;
  
  private static final ThreadFactory r = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public final Thread newThread(Runnable param1Runnable) {
        StringBuilder stringBuilder = new StringBuilder("disklrucache#");
        stringBuilder.append(this.a.getAndIncrement());
        return new Thread(param1Runnable, stringBuilder.toString());
      }
    };
  
  private static final OutputStream t;
  
  private final File e;
  
  private final File f;
  
  private final File g;
  
  private final File h;
  
  private final int i;
  
  private long j;
  
  private final int k;
  
  private long l = 0L;
  
  private Writer m;
  
  private int n = 1000;
  
  private final LinkedHashMap<String, c> o = new LinkedHashMap<String, c>(0, 0.75F, true);
  
  private int p;
  
  private long q = 0L;
  
  private final Callable<Void> s = new Callable<Void>(this) {
      private Void a() throws Exception {
        synchronized (this.a) {
          if (cp.a(this.a) == null)
            return null; 
          cp.b(this.a);
          if (cp.c(this.a)) {
            cp.d(this.a);
            cp.e(this.a);
          } 
          return null;
        } 
      }
    };
  
  static {
    d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), r);
    t = new OutputStream() {
        public final void write(int param1Int) throws IOException {}
      };
  }
  
  private cp(File paramFile, long paramLong) {
    this.e = paramFile;
    this.i = 1;
    this.f = new File(paramFile, "journal");
    this.g = new File(paramFile, "journal.tmp");
    this.h = new File(paramFile, "journal.bkp");
    this.k = 1;
    this.j = paramLong;
  }
  
  public static cp a(File paramFile, long paramLong) throws IOException {
    if (paramLong > 0L) {
      File file = new File(paramFile, "journal.bkp");
      if (file.exists()) {
        File file1 = new File(paramFile, "journal");
        if (file1.exists()) {
          file.delete();
        } else {
          a(file, file1, false);
        } 
      } 
      cp cp2 = new cp(paramFile, paramLong);
      if (cp2.f.exists())
        try {
          cp2.f();
          cp2.g();
          return cp2;
        } finally {
          Exception exception = null;
        }  
      paramFile.mkdirs();
      cp cp1 = new cp(paramFile, paramLong);
      cp1.h();
      return cp1;
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a(a parama, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Lcom/amap/api/col/s/cp$a;)Lcom/amap/api/col/s/cp$c;
    //   6: astore #10
    //   8: aload #10
    //   10: invokestatic b : (Lcom/amap/api/col/s/cp$c;)Lcom/amap/api/col/s/cp$a;
    //   13: aload_1
    //   14: if_acmpne -> 421
    //   17: iconst_0
    //   18: istore #5
    //   20: iload #5
    //   22: istore #4
    //   24: iload_2
    //   25: ifeq -> 110
    //   28: iload #5
    //   30: istore #4
    //   32: aload #10
    //   34: invokestatic e : (Lcom/amap/api/col/s/cp$c;)Z
    //   37: ifne -> 110
    //   40: iconst_0
    //   41: istore_3
    //   42: iload #5
    //   44: istore #4
    //   46: iload_3
    //   47: aload_0
    //   48: getfield k : I
    //   51: if_icmpge -> 110
    //   54: aload_1
    //   55: invokestatic b : (Lcom/amap/api/col/s/cp$a;)[Z
    //   58: iload_3
    //   59: baload
    //   60: ifeq -> 89
    //   63: aload #10
    //   65: iload_3
    //   66: invokevirtual b : (I)Ljava/io/File;
    //   69: invokevirtual exists : ()Z
    //   72: ifne -> 82
    //   75: aload_1
    //   76: invokevirtual c : ()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: iload_3
    //   83: iconst_1
    //   84: iadd
    //   85: istore_3
    //   86: goto -> 42
    //   89: aload_1
    //   90: invokevirtual c : ()V
    //   93: new java/lang/IllegalStateException
    //   96: dup
    //   97: ldc 'Newly created entry didn't create value for index '
    //   99: iload_3
    //   100: invokestatic valueOf : (I)Ljava/lang/String;
    //   103: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   106: invokespecial <init> : (Ljava/lang/String;)V
    //   109: athrow
    //   110: iload #4
    //   112: aload_0
    //   113: getfield k : I
    //   116: if_icmpge -> 205
    //   119: aload #10
    //   121: iload #4
    //   123: invokevirtual b : (I)Ljava/io/File;
    //   126: astore_1
    //   127: iload_2
    //   128: ifeq -> 198
    //   131: aload_1
    //   132: invokevirtual exists : ()Z
    //   135: ifeq -> 434
    //   138: aload #10
    //   140: iload #4
    //   142: invokevirtual a : (I)Ljava/io/File;
    //   145: astore #11
    //   147: aload_1
    //   148: aload #11
    //   150: invokevirtual renameTo : (Ljava/io/File;)Z
    //   153: pop
    //   154: aload #10
    //   156: invokestatic c : (Lcom/amap/api/col/s/cp$c;)[J
    //   159: iload #4
    //   161: laload
    //   162: lstore #6
    //   164: aload #11
    //   166: invokevirtual length : ()J
    //   169: lstore #8
    //   171: aload #10
    //   173: invokestatic c : (Lcom/amap/api/col/s/cp$c;)[J
    //   176: iload #4
    //   178: lload #8
    //   180: lastore
    //   181: aload_0
    //   182: aload_0
    //   183: getfield l : J
    //   186: lload #6
    //   188: lsub
    //   189: lload #8
    //   191: ladd
    //   192: putfield l : J
    //   195: goto -> 434
    //   198: aload_1
    //   199: invokestatic a : (Ljava/io/File;)V
    //   202: goto -> 434
    //   205: aload_0
    //   206: aload_0
    //   207: getfield p : I
    //   210: iconst_1
    //   211: iadd
    //   212: putfield p : I
    //   215: aload #10
    //   217: aconst_null
    //   218: invokestatic a : (Lcom/amap/api/col/s/cp$c;Lcom/amap/api/col/s/cp$a;)Lcom/amap/api/col/s/cp$a;
    //   221: pop
    //   222: aload #10
    //   224: invokestatic e : (Lcom/amap/api/col/s/cp$c;)Z
    //   227: iload_2
    //   228: ior
    //   229: ifeq -> 323
    //   232: aload #10
    //   234: invokestatic a : (Lcom/amap/api/col/s/cp$c;)Z
    //   237: pop
    //   238: aload_0
    //   239: getfield m : Ljava/io/Writer;
    //   242: astore_1
    //   243: new java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 'CLEAN '
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: astore #11
    //   255: aload #11
    //   257: aload #10
    //   259: invokestatic d : (Lcom/amap/api/col/s/cp$c;)Ljava/lang/String;
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload #11
    //   268: aload #10
    //   270: invokevirtual a : ()Ljava/lang/String;
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload #11
    //   279: bipush #10
    //   281: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: aload #11
    //   288: invokevirtual toString : ()Ljava/lang/String;
    //   291: invokevirtual write : (Ljava/lang/String;)V
    //   294: iload_2
    //   295: ifeq -> 381
    //   298: aload_0
    //   299: getfield q : J
    //   302: lstore #6
    //   304: aload_0
    //   305: lconst_1
    //   306: lload #6
    //   308: ladd
    //   309: putfield q : J
    //   312: aload #10
    //   314: lload #6
    //   316: invokestatic a : (Lcom/amap/api/col/s/cp$c;J)J
    //   319: pop2
    //   320: goto -> 381
    //   323: aload_0
    //   324: getfield o : Ljava/util/LinkedHashMap;
    //   327: aload #10
    //   329: invokestatic d : (Lcom/amap/api/col/s/cp$c;)Ljava/lang/String;
    //   332: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   335: pop
    //   336: aload_0
    //   337: getfield m : Ljava/io/Writer;
    //   340: astore_1
    //   341: new java/lang/StringBuilder
    //   344: dup
    //   345: ldc_w 'REMOVE '
    //   348: invokespecial <init> : (Ljava/lang/String;)V
    //   351: astore #11
    //   353: aload #11
    //   355: aload #10
    //   357: invokestatic d : (Lcom/amap/api/col/s/cp$c;)Ljava/lang/String;
    //   360: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload #11
    //   366: bipush #10
    //   368: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_1
    //   373: aload #11
    //   375: invokevirtual toString : ()Ljava/lang/String;
    //   378: invokevirtual write : (Ljava/lang/String;)V
    //   381: aload_0
    //   382: getfield m : Ljava/io/Writer;
    //   385: invokevirtual flush : ()V
    //   388: aload_0
    //   389: getfield l : J
    //   392: aload_0
    //   393: getfield j : J
    //   396: lcmp
    //   397: ifgt -> 407
    //   400: aload_0
    //   401: invokespecial i : ()Z
    //   404: ifeq -> 418
    //   407: invokestatic e : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   410: aload_0
    //   411: getfield s : Ljava/util/concurrent/Callable;
    //   414: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   417: pop
    //   418: aload_0
    //   419: monitorexit
    //   420: return
    //   421: new java/lang/IllegalStateException
    //   424: dup
    //   425: invokespecial <init> : ()V
    //   428: athrow
    //   429: astore_1
    //   430: aload_0
    //   431: monitorexit
    //   432: aload_1
    //   433: athrow
    //   434: iload #4
    //   436: iconst_1
    //   437: iadd
    //   438: istore #4
    //   440: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   2	17	429	finally
    //   32	40	429	finally
    //   46	79	429	finally
    //   89	110	429	finally
    //   110	127	429	finally
    //   131	195	429	finally
    //   198	202	429	finally
    //   205	294	429	finally
    //   298	320	429	finally
    //   323	381	429	finally
    //   381	407	429	finally
    //   407	418	429	finally
    //   421	429	429	finally
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
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
  
  private static void b(File paramFile) throws IOException {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null) {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j) {
        paramFile = arrayOfFile[i];
        if (paramFile.isDirectory())
          b(paramFile); 
        if (paramFile.delete()) {
          i++;
          continue;
        } 
        throw new IOException("failed to delete file: ".concat(String.valueOf(paramFile)));
      } 
      return;
    } 
    throw new IOException("not a readable directory: ".concat(String.valueOf(paramFile)));
  }
  
  private a d(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial j : ()V
    //   6: aload_1
    //   7: invokestatic e : (Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield o : Ljava/util/LinkedHashMap;
    //   14: aload_1
    //   15: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast com/amap/api/col/s/cp$c
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull -> 50
    //   26: new com/amap/api/col/s/cp$c
    //   29: dup
    //   30: aload_0
    //   31: aload_1
    //   32: iconst_0
    //   33: invokespecial <init> : (Lcom/amap/api/col/s/cp;Ljava/lang/String;B)V
    //   36: astore_2
    //   37: aload_0
    //   38: getfield o : Ljava/util/LinkedHashMap;
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: goto -> 63
    //   50: aload_2
    //   51: invokestatic b : (Lcom/amap/api/col/s/cp$c;)Lcom/amap/api/col/s/cp$a;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -> 63
    //   59: aload_0
    //   60: monitorexit
    //   61: aconst_null
    //   62: areturn
    //   63: new com/amap/api/col/s/cp$a
    //   66: dup
    //   67: aload_0
    //   68: aload_2
    //   69: iconst_0
    //   70: invokespecial <init> : (Lcom/amap/api/col/s/cp;Lcom/amap/api/col/s/cp$c;B)V
    //   73: astore_3
    //   74: aload_2
    //   75: aload_3
    //   76: invokestatic a : (Lcom/amap/api/col/s/cp$c;Lcom/amap/api/col/s/cp$a;)Lcom/amap/api/col/s/cp$a;
    //   79: pop
    //   80: aload_0
    //   81: getfield m : Ljava/io/Writer;
    //   84: astore_2
    //   85: new java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 'DIRTY '
    //   92: invokespecial <init> : (Ljava/lang/String;)V
    //   95: astore #4
    //   97: aload #4
    //   99: aload_1
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload #4
    //   106: bipush #10
    //   108: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_2
    //   113: aload #4
    //   115: invokevirtual toString : ()Ljava/lang/String;
    //   118: invokevirtual write : (Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield m : Ljava/io/Writer;
    //   125: invokevirtual flush : ()V
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_3
    //   131: areturn
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	132	finally
    //   26	47	132	finally
    //   50	55	132	finally
    //   63	128	132	finally
  }
  
  private static ThreadPoolExecutor e() {
    try {
    
    } finally {
      Exception exception = null;
    } 
    return d;
  }
  
  private static void e(String paramString) {
    if (a.matcher(paramString).matches())
      return; 
    StringBuilder stringBuilder = new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private void f() throws IOException {
    cq cq = new cq(new FileInputStream(this.f), b);
    try {
      c c1;
      c c2;
      String str1 = cq.a();
      String str2 = cq.a();
      String str5 = cq.a();
      String str3 = cq.a();
      String str4 = cq.a();
      if ("libcore.io.DiskLruCache".equals(str1) && "1".equals(str2) && Integer.toString(this.i).equals(str5) && Integer.toString(this.k).equals(str3)) {
        boolean bool = "".equals(str4);
        if (bool)
          for (int i = 0;; i++) {
            try {
              str4 = cq.a();
              int j = str4.indexOf(' ');
              if (j != -1) {
                int k = j + 1;
                int m = str4.indexOf(' ', k);
                if (m == -1) {
                  str2 = str4.substring(k);
                  str1 = str2;
                  if (j == 6) {
                    str1 = str2;
                    if (str4.startsWith("REMOVE")) {
                      this.o.remove(str2);
                      continue;
                    } 
                  } 
                } else {
                  str1 = str4.substring(k, m);
                } 
                c2 = this.o.get(str1);
                c1 = c2;
                if (c2 == null) {
                  c1 = new c(str1, (byte)0);
                  this.o.put(str1, c1);
                } 
                if (m != -1 && j == 5 && str4.startsWith("CLEAN")) {
                  String[] arrayOfString = str4.substring(m + 1).split(" ");
                  c.a(c1);
                  c.a(c1, (a)null);
                  c.a(c1, arrayOfString);
                } else if (m == -1 && j == 5 && str4.startsWith("DIRTY")) {
                  c.a(c1, new a(c1, (byte)0));
                } else if (m != -1 || j != 4 || !str4.startsWith("READ")) {
                  throw new IOException("unexpected journal line: ".concat(String.valueOf(str4)));
                } 
                continue;
              } 
              throw new IOException("unexpected journal line: ".concat(String.valueOf(str4)));
            } catch (EOFException eOFException) {
              this.p = i - this.o.size();
              return;
            } 
          }  
      } 
      StringBuilder stringBuilder = new StringBuilder("unexpected journal header: [");
      stringBuilder.append((String)eOFException);
      stringBuilder.append(", ");
      stringBuilder.append((String)c1);
      stringBuilder.append(", ");
      stringBuilder.append((String)c2);
      stringBuilder.append(", ");
      stringBuilder.append(str4);
      stringBuilder.append("]");
      throw new IOException(stringBuilder.toString());
    } finally {
      a(cq);
    } 
  }
  
  private void g() throws IOException {
    a(this.g);
    Iterator<c> iterator = this.o.values().iterator();
    while (iterator.hasNext()) {
      c c = iterator.next();
      a a = c.b(c);
      boolean bool = false;
      int i = 0;
      if (a == null) {
        while (i < this.k) {
          this.l += c.c(c)[i];
          i++;
        } 
        continue;
      } 
      c.a(c, (a)null);
      for (i = bool; i < this.k; i++) {
        a(c.a(i));
        a(c.b(i));
      } 
      iterator.remove();
    } 
  }
  
  private void h() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield m : Ljava/io/Writer;
    //   6: ifnull -> 16
    //   9: aload_0
    //   10: getfield m : Ljava/io/Writer;
    //   13: invokevirtual close : ()V
    //   16: new java/io/BufferedWriter
    //   19: dup
    //   20: new java/io/OutputStreamWriter
    //   23: dup
    //   24: new java/io/FileOutputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield g : Ljava/io/File;
    //   32: invokespecial <init> : (Ljava/io/File;)V
    //   35: getstatic com/amap/api/col/s/cp.b : Ljava/nio/charset/Charset;
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
    //   75: getfield i : I
    //   78: invokestatic toString : (I)Ljava/lang/String;
    //   81: invokevirtual write : (Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc_w '\\n'
    //   88: invokevirtual write : (Ljava/lang/String;)V
    //   91: aload_1
    //   92: aload_0
    //   93: getfield k : I
    //   96: invokestatic toString : (I)Ljava/lang/String;
    //   99: invokevirtual write : (Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc_w '\\n'
    //   106: invokevirtual write : (Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc_w '\\n'
    //   113: invokevirtual write : (Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield o : Ljava/util/LinkedHashMap;
    //   120: invokevirtual values : ()Ljava/util/Collection;
    //   123: invokeinterface iterator : ()Ljava/util/Iterator;
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface hasNext : ()Z
    //   135: ifeq -> 249
    //   138: aload_2
    //   139: invokeinterface next : ()Ljava/lang/Object;
    //   144: checkcast com/amap/api/col/s/cp$c
    //   147: astore_3
    //   148: aload_3
    //   149: invokestatic b : (Lcom/amap/api/col/s/cp$c;)Lcom/amap/api/col/s/cp$a;
    //   152: ifnull -> 197
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 'DIRTY '
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: astore #4
    //   167: aload #4
    //   169: aload_3
    //   170: invokestatic d : (Lcom/amap/api/col/s/cp$c;)Ljava/lang/String;
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #4
    //   179: bipush #10
    //   181: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: aload #4
    //   188: invokevirtual toString : ()Ljava/lang/String;
    //   191: invokevirtual write : (Ljava/lang/String;)V
    //   194: goto -> 129
    //   197: new java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 'CLEAN '
    //   204: invokespecial <init> : (Ljava/lang/String;)V
    //   207: astore #4
    //   209: aload #4
    //   211: aload_3
    //   212: invokestatic d : (Lcom/amap/api/col/s/cp$c;)Ljava/lang/String;
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload #4
    //   221: aload_3
    //   222: invokevirtual a : ()Ljava/lang/String;
    //   225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload #4
    //   231: bipush #10
    //   233: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_1
    //   238: aload #4
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: invokevirtual write : (Ljava/lang/String;)V
    //   246: goto -> 129
    //   249: aload_1
    //   250: invokevirtual close : ()V
    //   253: aload_0
    //   254: getfield f : Ljava/io/File;
    //   257: invokevirtual exists : ()Z
    //   260: ifeq -> 275
    //   263: aload_0
    //   264: getfield f : Ljava/io/File;
    //   267: aload_0
    //   268: getfield h : Ljava/io/File;
    //   271: iconst_1
    //   272: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   275: aload_0
    //   276: getfield g : Ljava/io/File;
    //   279: aload_0
    //   280: getfield f : Ljava/io/File;
    //   283: iconst_0
    //   284: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   287: aload_0
    //   288: getfield h : Ljava/io/File;
    //   291: invokevirtual delete : ()Z
    //   294: pop
    //   295: aload_0
    //   296: new java/io/BufferedWriter
    //   299: dup
    //   300: new java/io/OutputStreamWriter
    //   303: dup
    //   304: new java/io/FileOutputStream
    //   307: dup
    //   308: aload_0
    //   309: getfield f : Ljava/io/File;
    //   312: iconst_1
    //   313: invokespecial <init> : (Ljava/io/File;Z)V
    //   316: getstatic com/amap/api/col/s/cp.b : Ljava/nio/charset/Charset;
    //   319: invokespecial <init> : (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   322: invokespecial <init> : (Ljava/io/Writer;)V
    //   325: putfield m : Ljava/io/Writer;
    //   328: aload_0
    //   329: monitorexit
    //   330: return
    //   331: astore_2
    //   332: aload_1
    //   333: invokevirtual close : ()V
    //   336: aload_2
    //   337: athrow
    //   338: astore_1
    //   339: aload_0
    //   340: monitorexit
    //   341: aload_1
    //   342: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	338	finally
    //   16	45	338	finally
    //   45	129	331	finally
    //   129	194	331	finally
    //   197	246	331	finally
    //   249	275	338	finally
    //   275	328	338	finally
    //   332	338	338	finally
  }
  
  private boolean i() {
    int i = this.p;
    return (i >= 2000 && i >= this.o.size());
  }
  
  private void j() {
    if (this.m != null)
      return; 
    throw new IllegalStateException("cache is closed");
  }
  
  private void k() throws IOException {
    while (true) {
      if (this.l > this.j || this.o.size() > this.n) {
        c((String)((Map.Entry)this.o.entrySet().iterator().next()).getKey());
        continue;
      } 
      return;
    } 
  }
  
  public final b a(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial j : ()V
    //   6: aload_1
    //   7: invokestatic e : (Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield o : Ljava/util/LinkedHashMap;
    //   14: aload_1
    //   15: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast com/amap/api/col/s/cp$c
    //   21: astore #6
    //   23: aload #6
    //   25: ifnonnull -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: aconst_null
    //   31: areturn
    //   32: aload #6
    //   34: invokestatic e : (Lcom/amap/api/col/s/cp$c;)Z
    //   37: istore #4
    //   39: iload #4
    //   41: ifne -> 48
    //   44: aload_0
    //   45: monitorexit
    //   46: aconst_null
    //   47: areturn
    //   48: aload_0
    //   49: getfield k : I
    //   52: anewarray java/io/InputStream
    //   55: astore #5
    //   57: iconst_0
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield k : I
    //   66: if_icmpge -> 93
    //   69: aload #5
    //   71: iload_2
    //   72: new java/io/FileInputStream
    //   75: dup
    //   76: aload #6
    //   78: iload_2
    //   79: invokevirtual a : (I)Ljava/io/File;
    //   82: invokespecial <init> : (Ljava/io/File;)V
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -> 61
    //   93: aload_0
    //   94: aload_0
    //   95: getfield p : I
    //   98: iconst_1
    //   99: iadd
    //   100: putfield p : I
    //   103: aload_0
    //   104: getfield m : Ljava/io/Writer;
    //   107: astore #7
    //   109: new java/lang/StringBuilder
    //   112: dup
    //   113: ldc_w 'READ '
    //   116: invokespecial <init> : (Ljava/lang/String;)V
    //   119: astore #8
    //   121: aload #8
    //   123: aload_1
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload #8
    //   130: bipush #10
    //   132: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #7
    //   138: aload #8
    //   140: invokevirtual toString : ()Ljava/lang/String;
    //   143: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   146: pop
    //   147: aload_0
    //   148: invokespecial i : ()Z
    //   151: ifeq -> 165
    //   154: invokestatic e : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   157: aload_0
    //   158: getfield s : Ljava/util/concurrent/Callable;
    //   161: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   164: pop
    //   165: new com/amap/api/col/s/cp$b
    //   168: dup
    //   169: aload_0
    //   170: aload_1
    //   171: aload #6
    //   173: invokestatic f : (Lcom/amap/api/col/s/cp$c;)J
    //   176: aload #5
    //   178: aload #6
    //   180: invokestatic c : (Lcom/amap/api/col/s/cp$c;)[J
    //   183: iconst_0
    //   184: invokespecial <init> : (Lcom/amap/api/col/s/cp;Ljava/lang/String;J[Ljava/io/InputStream;[JB)V
    //   187: astore_1
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_1
    //   191: areturn
    //   192: iload_2
    //   193: aload_0
    //   194: getfield k : I
    //   197: if_icmpge -> 221
    //   200: aload #5
    //   202: iload_2
    //   203: aaload
    //   204: ifnull -> 221
    //   207: aload #5
    //   209: iload_2
    //   210: aaload
    //   211: invokestatic a : (Ljava/io/Closeable;)V
    //   214: iload_2
    //   215: iconst_1
    //   216: iadd
    //   217: istore_2
    //   218: goto -> 192
    //   221: aload_0
    //   222: monitorexit
    //   223: aconst_null
    //   224: areturn
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: iload_3
    //   232: istore_2
    //   233: goto -> 192
    // Exception table:
    //   from	to	target	type
    //   2	23	225	finally
    //   32	39	225	finally
    //   48	57	225	finally
    //   61	86	230	java/io/FileNotFoundException
    //   61	86	225	finally
    //   93	165	225	finally
    //   165	188	225	finally
    //   192	200	225	finally
    //   207	214	225	finally
  }
  
  public final File a() {
    return this.e;
  }
  
  public final void a(int paramInt) {
    int i;
    if (paramInt < 10) {
      i = 10;
    } else {
      i = paramInt;
      if (paramInt > 10000)
        i = 10000; 
    } 
    this.n = i;
  }
  
  public final a b(String paramString) throws IOException {
    return d(paramString);
  }
  
  public final void b() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial j : ()V
    //   6: aload_0
    //   7: invokespecial k : ()V
    //   10: aload_0
    //   11: getfield m : Ljava/io/Writer;
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
  
  public final void c() throws IOException {
    close();
    b(this.e);
  }
  
  public final boolean c(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial j : ()V
    //   6: aload_1
    //   7: invokestatic e : (Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield o : Ljava/util/LinkedHashMap;
    //   14: aload_1
    //   15: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast com/amap/api/col/s/cp$c
    //   21: astore_3
    //   22: iconst_0
    //   23: istore_2
    //   24: aload_3
    //   25: ifnull -> 203
    //   28: aload_3
    //   29: invokestatic b : (Lcom/amap/api/col/s/cp$c;)Lcom/amap/api/col/s/cp$a;
    //   32: ifnull -> 38
    //   35: goto -> 203
    //   38: iload_2
    //   39: aload_0
    //   40: getfield k : I
    //   43: if_icmpge -> 120
    //   46: aload_3
    //   47: iload_2
    //   48: invokevirtual a : (I)Ljava/io/File;
    //   51: astore #4
    //   53: aload #4
    //   55: invokevirtual exists : ()Z
    //   58: ifeq -> 91
    //   61: aload #4
    //   63: invokevirtual delete : ()Z
    //   66: ifeq -> 72
    //   69: goto -> 91
    //   72: new java/io/IOException
    //   75: dup
    //   76: ldc_w 'failed to delete '
    //   79: aload #4
    //   81: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   84: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: athrow
    //   91: aload_0
    //   92: aload_0
    //   93: getfield l : J
    //   96: aload_3
    //   97: invokestatic c : (Lcom/amap/api/col/s/cp$c;)[J
    //   100: iload_2
    //   101: laload
    //   102: lsub
    //   103: putfield l : J
    //   106: aload_3
    //   107: invokestatic c : (Lcom/amap/api/col/s/cp$c;)[J
    //   110: iload_2
    //   111: lconst_0
    //   112: lastore
    //   113: iload_2
    //   114: iconst_1
    //   115: iadd
    //   116: istore_2
    //   117: goto -> 38
    //   120: aload_0
    //   121: aload_0
    //   122: getfield p : I
    //   125: iconst_1
    //   126: iadd
    //   127: putfield p : I
    //   130: aload_0
    //   131: getfield m : Ljava/io/Writer;
    //   134: astore_3
    //   135: new java/lang/StringBuilder
    //   138: dup
    //   139: ldc_w 'REMOVE '
    //   142: invokespecial <init> : (Ljava/lang/String;)V
    //   145: astore #4
    //   147: aload #4
    //   149: aload_1
    //   150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload #4
    //   156: bipush #10
    //   158: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_3
    //   163: aload #4
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   171: pop
    //   172: aload_0
    //   173: getfield o : Ljava/util/LinkedHashMap;
    //   176: aload_1
    //   177: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: aload_0
    //   182: invokespecial i : ()Z
    //   185: ifeq -> 199
    //   188: invokestatic e : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   191: aload_0
    //   192: getfield s : Ljava/util/concurrent/Callable;
    //   195: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   198: pop
    //   199: aload_0
    //   200: monitorexit
    //   201: iconst_1
    //   202: ireturn
    //   203: aload_0
    //   204: monitorexit
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_1
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	207	finally
    //   28	35	207	finally
    //   38	69	207	finally
    //   72	91	207	finally
    //   91	113	207	finally
    //   120	199	207	finally
  }
  
  public final void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield m : Ljava/io/Writer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new java/util/ArrayList
    //   17: dup
    //   18: aload_0
    //   19: getfield o : Ljava/util/LinkedHashMap;
    //   22: invokevirtual values : ()Ljava/util/Collection;
    //   25: invokespecial <init> : (Ljava/util/Collection;)V
    //   28: invokevirtual iterator : ()Ljava/util/Iterator;
    //   31: astore_1
    //   32: aload_1
    //   33: invokeinterface hasNext : ()Z
    //   38: ifeq -> 68
    //   41: aload_1
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast com/amap/api/col/s/cp$c
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic b : (Lcom/amap/api/col/s/cp$c;)Lcom/amap/api/col/s/cp$a;
    //   55: ifnull -> 32
    //   58: aload_2
    //   59: invokestatic b : (Lcom/amap/api/col/s/cp$c;)Lcom/amap/api/col/s/cp$a;
    //   62: invokevirtual c : ()V
    //   65: goto -> 32
    //   68: aload_0
    //   69: invokespecial k : ()V
    //   72: aload_0
    //   73: getfield m : Ljava/io/Writer;
    //   76: invokevirtual close : ()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield m : Ljava/io/Writer;
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
  
  public final class a {
    private final cp.c b;
    
    private final boolean[] c;
    
    private boolean d;
    
    private boolean e;
    
    private a(cp this$0, cp.c param1c) {
      boolean[] arrayOfBoolean;
      this.b = param1c;
      if (cp.c.e(param1c)) {
        cp.this = null;
      } else {
        arrayOfBoolean = new boolean[cp.f(cp.this)];
      } 
      this.c = arrayOfBoolean;
    }
    
    public final OutputStream a() throws IOException {
      if (cp.f(this.a) > 0)
        synchronized (this.a) {
          if (cp.c.b(this.b) == this) {
            if (!cp.c.e(this.b))
              this.c[0] = true; 
            File file = this.b.b(0);
            try {
              FileOutputStream fileOutputStream = new FileOutputStream(file);
              return new a(fileOutputStream, (byte)0);
            } catch (FileNotFoundException fileNotFoundException) {
              cp.g(this.a).mkdirs();
              try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                return new a(fileOutputStream, (byte)0);
              } catch (FileNotFoundException fileNotFoundException1) {
                return cp.d();
              } 
            } 
          } 
          throw new IllegalStateException();
        }  
      StringBuilder stringBuilder = new StringBuilder("Expected index 0 to be greater than 0 and less than the maximum value count of ");
      stringBuilder.append(cp.f(this.a));
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public final void b() throws IOException {
      if (this.d) {
        cp.a(this.a, this, false);
        this.a.c(cp.c.d(this.b));
      } else {
        cp.a(this.a, this, true);
      } 
      this.e = true;
    }
    
    public final void c() throws IOException {
      cp.a(this.a, this, false);
    }
    
    final class a extends FilterOutputStream {
      private a(cp.a this$0, OutputStream param2OutputStream) {
        super(param2OutputStream);
      }
      
      public final void close() {
        try {
          this.out.close();
          return;
        } catch (IOException iOException) {
          cp.a.c(this.a);
          return;
        } 
      }
      
      public final void flush() {
        try {
          this.out.flush();
          return;
        } catch (IOException iOException) {
          cp.a.c(this.a);
          return;
        } 
      }
      
      public final void write(int param2Int) {
        try {
          this.out.write(param2Int);
          return;
        } catch (IOException iOException) {
          cp.a.c(this.a);
          return;
        } 
      }
      
      public final void write(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) {
        try {
          this.out.write(param2ArrayOfbyte, param2Int1, param2Int2);
          return;
        } catch (IOException iOException) {
          cp.a.c(this.a);
          return;
        } 
      }
    }
  }
  
  final class a extends FilterOutputStream {
    private a(cp this$0, OutputStream param1OutputStream) {
      super(param1OutputStream);
    }
    
    public final void close() {
      try {
        this.out.close();
        return;
      } catch (IOException iOException) {
        cp.a.c(this.a);
        return;
      } 
    }
    
    public final void flush() {
      try {
        this.out.flush();
        return;
      } catch (IOException iOException) {
        cp.a.c(this.a);
        return;
      } 
    }
    
    public final void write(int param1Int) {
      try {
        this.out.write(param1Int);
        return;
      } catch (IOException iOException) {
        cp.a.c(this.a);
        return;
      } 
    }
    
    public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        cp.a.c(this.a);
        return;
      } 
    }
  }
  
  public final class b implements Closeable {
    private final String b;
    
    private final long c;
    
    private final InputStream[] d;
    
    private final long[] e;
    
    private b(cp this$0, String param1String, long param1Long, InputStream[] param1ArrayOfInputStream, long[] param1ArrayOflong) {
      this.b = param1String;
      this.c = param1Long;
      this.d = param1ArrayOfInputStream;
      this.e = param1ArrayOflong;
    }
    
    public final InputStream a() {
      return this.d[0];
    }
    
    public final void close() {
      InputStream[] arrayOfInputStream = this.d;
      int j = arrayOfInputStream.length;
      for (int i = 0; i < j; i++)
        cp.a(arrayOfInputStream[i]); 
    }
  }
  
  final class c {
    private final String b;
    
    private final long[] c;
    
    private boolean d;
    
    private cp.a e;
    
    private long f;
    
    private c(cp this$0, String param1String) {
      this.b = param1String;
      this.c = new long[cp.f(cp.this)];
    }
    
    private static IOException a(String[] param1ArrayOfString) throws IOException {
      StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
      stringBuilder.append(Arrays.toString((Object[])param1ArrayOfString));
      throw new IOException(stringBuilder.toString());
    }
    
    public final File a(int param1Int) {
      File file = cp.g(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(".");
      stringBuilder.append(param1Int);
      return new File(file, stringBuilder.toString());
    }
    
    public final String a() throws IOException {
      StringBuilder stringBuilder = new StringBuilder();
      for (long l : this.c) {
        stringBuilder.append(' ');
        stringBuilder.append(l);
      } 
      return stringBuilder.toString();
    }
    
    public final File b(int param1Int) {
      File file = cp.g(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(".");
      stringBuilder.append(param1Int);
      stringBuilder.append(".tmp");
      return new File(file, stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */