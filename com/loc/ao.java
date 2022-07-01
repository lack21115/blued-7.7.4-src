package com.loc;

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

public final class ao implements Closeable {
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
          if (ao.a(this.a) == null)
            return null; 
          ao.b(this.a);
          if (ao.c(this.a)) {
            ao.d(this.a);
            ao.e(this.a);
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
  
  private ao(File paramFile, long paramLong) {
    this.e = paramFile;
    this.i = 1;
    this.f = new File(paramFile, "journal");
    this.g = new File(paramFile, "journal.tmp");
    this.h = new File(paramFile, "journal.bkp");
    this.k = 1;
    this.j = paramLong;
  }
  
  public static ao a(File paramFile, long paramLong) throws IOException {
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
      ao ao2 = new ao(paramFile, paramLong);
      if (ao2.f.exists())
        try {
          ao2.g();
          ao2.h();
          return ao2;
        } finally {
          Exception exception = null;
        }  
      paramFile.mkdirs();
      ao ao1 = new ao(paramFile, paramLong);
      ao1.i();
      return ao1;
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public static void a() {
    ThreadPoolExecutor threadPoolExecutor = d;
    if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown())
      d.shutdown(); 
  }
  
  private void a(a parama, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Lcom/loc/ao$a;)Lcom/loc/ao$c;
    //   6: astore #10
    //   8: aload #10
    //   10: invokestatic b : (Lcom/loc/ao$c;)Lcom/loc/ao$a;
    //   13: aload_1
    //   14: if_acmpne -> 432
    //   17: iconst_0
    //   18: istore #5
    //   20: iload #5
    //   22: istore #4
    //   24: iload_2
    //   25: ifeq -> 121
    //   28: iload #5
    //   30: istore #4
    //   32: aload #10
    //   34: invokestatic e : (Lcom/loc/ao$c;)Z
    //   37: ifne -> 121
    //   40: iconst_0
    //   41: istore_3
    //   42: iload #5
    //   44: istore #4
    //   46: iload_3
    //   47: aload_0
    //   48: getfield k : I
    //   51: if_icmpge -> 121
    //   54: aload_1
    //   55: invokestatic b : (Lcom/loc/ao$a;)[Z
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
    //   93: new java/lang/StringBuilder
    //   96: dup
    //   97: ldc 'Newly created entry didn't create value for index '
    //   99: invokespecial <init> : (Ljava/lang/String;)V
    //   102: astore_1
    //   103: aload_1
    //   104: iload_3
    //   105: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: new java/lang/IllegalStateException
    //   112: dup
    //   113: aload_1
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: invokespecial <init> : (Ljava/lang/String;)V
    //   120: athrow
    //   121: iload #4
    //   123: aload_0
    //   124: getfield k : I
    //   127: if_icmpge -> 216
    //   130: aload #10
    //   132: iload #4
    //   134: invokevirtual b : (I)Ljava/io/File;
    //   137: astore_1
    //   138: iload_2
    //   139: ifeq -> 209
    //   142: aload_1
    //   143: invokevirtual exists : ()Z
    //   146: ifeq -> 445
    //   149: aload #10
    //   151: iload #4
    //   153: invokevirtual a : (I)Ljava/io/File;
    //   156: astore #11
    //   158: aload_1
    //   159: aload #11
    //   161: invokevirtual renameTo : (Ljava/io/File;)Z
    //   164: pop
    //   165: aload #10
    //   167: invokestatic c : (Lcom/loc/ao$c;)[J
    //   170: iload #4
    //   172: laload
    //   173: lstore #6
    //   175: aload #11
    //   177: invokevirtual length : ()J
    //   180: lstore #8
    //   182: aload #10
    //   184: invokestatic c : (Lcom/loc/ao$c;)[J
    //   187: iload #4
    //   189: lload #8
    //   191: lastore
    //   192: aload_0
    //   193: aload_0
    //   194: getfield l : J
    //   197: lload #6
    //   199: lsub
    //   200: lload #8
    //   202: ladd
    //   203: putfield l : J
    //   206: goto -> 445
    //   209: aload_1
    //   210: invokestatic a : (Ljava/io/File;)V
    //   213: goto -> 445
    //   216: aload_0
    //   217: aload_0
    //   218: getfield p : I
    //   221: iconst_1
    //   222: iadd
    //   223: putfield p : I
    //   226: aload #10
    //   228: aconst_null
    //   229: invokestatic a : (Lcom/loc/ao$c;Lcom/loc/ao$a;)Lcom/loc/ao$a;
    //   232: pop
    //   233: aload #10
    //   235: invokestatic e : (Lcom/loc/ao$c;)Z
    //   238: iload_2
    //   239: ior
    //   240: ifeq -> 334
    //   243: aload #10
    //   245: invokestatic a : (Lcom/loc/ao$c;)Z
    //   248: pop
    //   249: aload_0
    //   250: getfield m : Ljava/io/Writer;
    //   253: astore_1
    //   254: new java/lang/StringBuilder
    //   257: dup
    //   258: ldc_w 'CLEAN '
    //   261: invokespecial <init> : (Ljava/lang/String;)V
    //   264: astore #11
    //   266: aload #11
    //   268: aload #10
    //   270: invokestatic d : (Lcom/loc/ao$c;)Ljava/lang/String;
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload #11
    //   279: aload #10
    //   281: invokevirtual a : ()Ljava/lang/String;
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload #11
    //   290: bipush #10
    //   292: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_1
    //   297: aload #11
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: invokevirtual write : (Ljava/lang/String;)V
    //   305: iload_2
    //   306: ifeq -> 392
    //   309: aload_0
    //   310: getfield q : J
    //   313: lstore #6
    //   315: aload_0
    //   316: lconst_1
    //   317: lload #6
    //   319: ladd
    //   320: putfield q : J
    //   323: aload #10
    //   325: lload #6
    //   327: invokestatic a : (Lcom/loc/ao$c;J)J
    //   330: pop2
    //   331: goto -> 392
    //   334: aload_0
    //   335: getfield o : Ljava/util/LinkedHashMap;
    //   338: aload #10
    //   340: invokestatic d : (Lcom/loc/ao$c;)Ljava/lang/String;
    //   343: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: aload_0
    //   348: getfield m : Ljava/io/Writer;
    //   351: astore_1
    //   352: new java/lang/StringBuilder
    //   355: dup
    //   356: ldc_w 'REMOVE '
    //   359: invokespecial <init> : (Ljava/lang/String;)V
    //   362: astore #11
    //   364: aload #11
    //   366: aload #10
    //   368: invokestatic d : (Lcom/loc/ao$c;)Ljava/lang/String;
    //   371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload #11
    //   377: bipush #10
    //   379: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_1
    //   384: aload #11
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: invokevirtual write : (Ljava/lang/String;)V
    //   392: aload_0
    //   393: getfield m : Ljava/io/Writer;
    //   396: invokevirtual flush : ()V
    //   399: aload_0
    //   400: getfield l : J
    //   403: aload_0
    //   404: getfield j : J
    //   407: lcmp
    //   408: ifgt -> 418
    //   411: aload_0
    //   412: invokespecial j : ()Z
    //   415: ifeq -> 429
    //   418: invokestatic f : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   421: aload_0
    //   422: getfield s : Ljava/util/concurrent/Callable;
    //   425: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   428: pop
    //   429: aload_0
    //   430: monitorexit
    //   431: return
    //   432: new java/lang/IllegalStateException
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: athrow
    //   440: astore_1
    //   441: aload_0
    //   442: monitorexit
    //   443: aload_1
    //   444: athrow
    //   445: iload #4
    //   447: iconst_1
    //   448: iadd
    //   449: istore #4
    //   451: goto -> 121
    // Exception table:
    //   from	to	target	type
    //   2	17	440	finally
    //   32	40	440	finally
    //   46	79	440	finally
    //   89	121	440	finally
    //   121	138	440	finally
    //   142	206	440	finally
    //   209	213	440	finally
    //   216	305	440	finally
    //   309	331	440	finally
    //   334	392	440	finally
    //   392	418	440	finally
    //   418	429	440	finally
    //   432	440	440	finally
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
        StringBuilder stringBuilder1 = new StringBuilder("failed to delete file: ");
        stringBuilder1.append(paramFile);
        throw new IOException(stringBuilder1.toString());
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("not a readable directory: ");
    stringBuilder.append(paramFile);
    throw new IOException(stringBuilder.toString());
  }
  
  private a d(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()V
    //   6: aload_1
    //   7: invokestatic e : (Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield o : Ljava/util/LinkedHashMap;
    //   14: aload_1
    //   15: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast com/loc/ao$c
    //   21: astore_2
    //   22: aload_2
    //   23: ifnonnull -> 50
    //   26: new com/loc/ao$c
    //   29: dup
    //   30: aload_0
    //   31: aload_1
    //   32: iconst_0
    //   33: invokespecial <init> : (Lcom/loc/ao;Ljava/lang/String;B)V
    //   36: astore_2
    //   37: aload_0
    //   38: getfield o : Ljava/util/LinkedHashMap;
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: goto -> 63
    //   50: aload_2
    //   51: invokestatic b : (Lcom/loc/ao$c;)Lcom/loc/ao$a;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -> 63
    //   59: aload_0
    //   60: monitorexit
    //   61: aconst_null
    //   62: areturn
    //   63: new com/loc/ao$a
    //   66: dup
    //   67: aload_0
    //   68: aload_2
    //   69: iconst_0
    //   70: invokespecial <init> : (Lcom/loc/ao;Lcom/loc/ao$c;B)V
    //   73: astore_3
    //   74: aload_2
    //   75: aload_3
    //   76: invokestatic a : (Lcom/loc/ao$c;Lcom/loc/ao$a;)Lcom/loc/ao$a;
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
  
  private static void e(String paramString) {
    if (a.matcher(paramString).matches())
      return; 
    StringBuilder stringBuilder = new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static ThreadPoolExecutor f() {
    try {
    
    } finally {
      Exception exception = null;
    } 
    return d;
  }
  
  private void g() throws IOException {
    ap ap = new ap(new FileInputStream(this.f), b);
    try {
      c c1;
      c c2;
      String str1 = ap.a();
      String str2 = ap.a();
      String str5 = ap.a();
      String str3 = ap.a();
      String str4 = ap.a();
      if ("libcore.io.DiskLruCache".equals(str1) && "1".equals(str2) && Integer.toString(this.i).equals(str5) && Integer.toString(this.k).equals(str3)) {
        boolean bool = "".equals(str4);
        if (bool)
          for (int i = 0;; i++) {
            try {
              str4 = ap.a();
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
                  StringBuilder stringBuilder2 = new StringBuilder("unexpected journal line: ");
                  stringBuilder2.append(str4);
                  throw new IOException(stringBuilder2.toString());
                } 
                continue;
              } 
              StringBuilder stringBuilder1 = new StringBuilder("unexpected journal line: ");
              stringBuilder1.append(str4);
              throw new IOException(stringBuilder1.toString());
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
      a(ap);
    } 
  }
  
  private void h() throws IOException {
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
  
  private void i() throws IOException {
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
    //   35: getstatic com/loc/ao.b : Ljava/nio/charset/Charset;
    //   38: invokespecial <init> : (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   41: invokespecial <init> : (Ljava/io/Writer;)V
    //   44: astore_2
    //   45: aload_2
    //   46: ldc_w 'libcore.io.DiskLruCache'
    //   49: invokevirtual write : (Ljava/lang/String;)V
    //   52: aload_2
    //   53: ldc_w '\\n'
    //   56: invokevirtual write : (Ljava/lang/String;)V
    //   59: aload_2
    //   60: ldc_w '1'
    //   63: invokevirtual write : (Ljava/lang/String;)V
    //   66: aload_2
    //   67: ldc_w '\\n'
    //   70: invokevirtual write : (Ljava/lang/String;)V
    //   73: aload_2
    //   74: aload_0
    //   75: getfield i : I
    //   78: invokestatic toString : (I)Ljava/lang/String;
    //   81: invokevirtual write : (Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w '\\n'
    //   88: invokevirtual write : (Ljava/lang/String;)V
    //   91: aload_2
    //   92: aload_0
    //   93: getfield k : I
    //   96: invokestatic toString : (I)Ljava/lang/String;
    //   99: invokevirtual write : (Ljava/lang/String;)V
    //   102: aload_2
    //   103: ldc_w '\\n'
    //   106: invokevirtual write : (Ljava/lang/String;)V
    //   109: aload_2
    //   110: ldc_w '\\n'
    //   113: invokevirtual write : (Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield o : Ljava/util/LinkedHashMap;
    //   120: invokevirtual values : ()Ljava/util/Collection;
    //   123: invokeinterface iterator : ()Ljava/util/Iterator;
    //   128: astore_3
    //   129: aload_3
    //   130: invokeinterface hasNext : ()Z
    //   135: ifeq -> 248
    //   138: aload_3
    //   139: invokeinterface next : ()Ljava/lang/Object;
    //   144: checkcast com/loc/ao$c
    //   147: astore_1
    //   148: aload_1
    //   149: invokestatic b : (Lcom/loc/ao$c;)Lcom/loc/ao$a;
    //   152: ifnull -> 199
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 'DIRTY '
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: astore #4
    //   167: aload #4
    //   169: aload_1
    //   170: invokestatic d : (Lcom/loc/ao$c;)Ljava/lang/String;
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #4
    //   179: bipush #10
    //   181: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #4
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: astore_1
    //   191: aload_2
    //   192: aload_1
    //   193: invokevirtual write : (Ljava/lang/String;)V
    //   196: goto -> 129
    //   199: new java/lang/StringBuilder
    //   202: dup
    //   203: ldc_w 'CLEAN '
    //   206: invokespecial <init> : (Ljava/lang/String;)V
    //   209: astore #4
    //   211: aload #4
    //   213: aload_1
    //   214: invokestatic d : (Lcom/loc/ao$c;)Ljava/lang/String;
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload #4
    //   223: aload_1
    //   224: invokevirtual a : ()Ljava/lang/String;
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #4
    //   233: bipush #10
    //   235: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload #4
    //   241: invokevirtual toString : ()Ljava/lang/String;
    //   244: astore_1
    //   245: goto -> 191
    //   248: aload_2
    //   249: invokevirtual close : ()V
    //   252: aload_0
    //   253: getfield f : Ljava/io/File;
    //   256: invokevirtual exists : ()Z
    //   259: ifeq -> 274
    //   262: aload_0
    //   263: getfield f : Ljava/io/File;
    //   266: aload_0
    //   267: getfield h : Ljava/io/File;
    //   270: iconst_1
    //   271: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   274: aload_0
    //   275: getfield g : Ljava/io/File;
    //   278: aload_0
    //   279: getfield f : Ljava/io/File;
    //   282: iconst_0
    //   283: invokestatic a : (Ljava/io/File;Ljava/io/File;Z)V
    //   286: aload_0
    //   287: getfield h : Ljava/io/File;
    //   290: invokevirtual delete : ()Z
    //   293: pop
    //   294: aload_0
    //   295: new java/io/BufferedWriter
    //   298: dup
    //   299: new java/io/OutputStreamWriter
    //   302: dup
    //   303: new java/io/FileOutputStream
    //   306: dup
    //   307: aload_0
    //   308: getfield f : Ljava/io/File;
    //   311: iconst_1
    //   312: invokespecial <init> : (Ljava/io/File;Z)V
    //   315: getstatic com/loc/ao.b : Ljava/nio/charset/Charset;
    //   318: invokespecial <init> : (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   321: invokespecial <init> : (Ljava/io/Writer;)V
    //   324: putfield m : Ljava/io/Writer;
    //   327: aload_0
    //   328: monitorexit
    //   329: return
    //   330: astore_1
    //   331: aload_2
    //   332: invokevirtual close : ()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	337	finally
    //   16	45	337	finally
    //   45	129	330	finally
    //   129	191	330	finally
    //   191	196	330	finally
    //   199	245	330	finally
    //   248	274	337	finally
    //   274	327	337	finally
    //   331	337	337	finally
  }
  
  private boolean j() {
    int i = this.p;
    return (i >= 2000 && i >= this.o.size());
  }
  
  private void k() {
    if (this.m != null)
      return; 
    throw new IllegalStateException("cache is closed");
  }
  
  private void l() throws IOException {
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
    //   3: invokespecial k : ()V
    //   6: aload_1
    //   7: invokestatic e : (Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield o : Ljava/util/LinkedHashMap;
    //   14: aload_1
    //   15: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast com/loc/ao$c
    //   21: astore #6
    //   23: aload #6
    //   25: ifnonnull -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: aconst_null
    //   31: areturn
    //   32: aload #6
    //   34: invokestatic e : (Lcom/loc/ao$c;)Z
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
    //   148: invokespecial j : ()Z
    //   151: ifeq -> 165
    //   154: invokestatic f : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   157: aload_0
    //   158: getfield s : Ljava/util/concurrent/Callable;
    //   161: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   164: pop
    //   165: new com/loc/ao$b
    //   168: dup
    //   169: aload_0
    //   170: aload_1
    //   171: aload #6
    //   173: invokestatic f : (Lcom/loc/ao$c;)J
    //   176: aload #5
    //   178: aload #6
    //   180: invokestatic c : (Lcom/loc/ao$c;)[J
    //   183: iconst_0
    //   184: invokespecial <init> : (Lcom/loc/ao;Ljava/lang/String;J[Ljava/io/InputStream;[JB)V
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
  
  public final File b() {
    return this.e;
  }
  
  public final void c() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()V
    //   6: aload_0
    //   7: invokespecial l : ()V
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
  
  public final boolean c(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()V
    //   6: aload_1
    //   7: invokestatic e : (Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield o : Ljava/util/LinkedHashMap;
    //   14: aload_1
    //   15: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast com/loc/ao$c
    //   21: astore #4
    //   23: iconst_0
    //   24: istore_2
    //   25: aload #4
    //   27: ifnull -> 216
    //   30: aload #4
    //   32: invokestatic b : (Lcom/loc/ao$c;)Lcom/loc/ao$a;
    //   35: ifnull -> 41
    //   38: goto -> 216
    //   41: iload_2
    //   42: aload_0
    //   43: getfield k : I
    //   46: if_icmpge -> 133
    //   49: aload #4
    //   51: iload_2
    //   52: invokevirtual a : (I)Ljava/io/File;
    //   55: astore_3
    //   56: aload_3
    //   57: invokevirtual exists : ()Z
    //   60: ifeq -> 102
    //   63: aload_3
    //   64: invokevirtual delete : ()Z
    //   67: ifeq -> 73
    //   70: goto -> 102
    //   73: new java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 'failed to delete '
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: astore_1
    //   84: aload_1
    //   85: aload_3
    //   86: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: new java/io/IOException
    //   93: dup
    //   94: aload_1
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokespecial <init> : (Ljava/lang/String;)V
    //   101: athrow
    //   102: aload_0
    //   103: aload_0
    //   104: getfield l : J
    //   107: aload #4
    //   109: invokestatic c : (Lcom/loc/ao$c;)[J
    //   112: iload_2
    //   113: laload
    //   114: lsub
    //   115: putfield l : J
    //   118: aload #4
    //   120: invokestatic c : (Lcom/loc/ao$c;)[J
    //   123: iload_2
    //   124: lconst_0
    //   125: lastore
    //   126: iload_2
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: goto -> 41
    //   133: aload_0
    //   134: aload_0
    //   135: getfield p : I
    //   138: iconst_1
    //   139: iadd
    //   140: putfield p : I
    //   143: aload_0
    //   144: getfield m : Ljava/io/Writer;
    //   147: astore_3
    //   148: new java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 'REMOVE '
    //   155: invokespecial <init> : (Ljava/lang/String;)V
    //   158: astore #4
    //   160: aload #4
    //   162: aload_1
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload #4
    //   169: bipush #10
    //   171: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: aload #4
    //   178: invokevirtual toString : ()Ljava/lang/String;
    //   181: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   184: pop
    //   185: aload_0
    //   186: getfield o : Ljava/util/LinkedHashMap;
    //   189: aload_1
    //   190: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: aload_0
    //   195: invokespecial j : ()Z
    //   198: ifeq -> 212
    //   201: invokestatic f : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   204: aload_0
    //   205: getfield s : Ljava/util/concurrent/Callable;
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
    //   2	23	220	finally
    //   30	38	220	finally
    //   41	70	220	finally
    //   73	102	220	finally
    //   102	126	220	finally
    //   133	212	220	finally
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
    //   47: checkcast com/loc/ao$c
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic b : (Lcom/loc/ao$c;)Lcom/loc/ao$a;
    //   55: ifnull -> 32
    //   58: aload_2
    //   59: invokestatic b : (Lcom/loc/ao$c;)Lcom/loc/ao$a;
    //   62: invokevirtual c : ()V
    //   65: goto -> 32
    //   68: aload_0
    //   69: invokespecial l : ()V
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
  
  public final void d() throws IOException {
    close();
    b(this.e);
  }
  
  public final class a {
    private final ao.c b;
    
    private final boolean[] c;
    
    private boolean d;
    
    private boolean e;
    
    private a(ao this$0, ao.c param1c) {
      boolean[] arrayOfBoolean;
      this.b = param1c;
      if (ao.c.e(param1c)) {
        ao.this = null;
      } else {
        arrayOfBoolean = new boolean[ao.f(ao.this)];
      } 
      this.c = arrayOfBoolean;
    }
    
    public final OutputStream a() throws IOException {
      if (ao.f(this.a) > 0)
        synchronized (this.a) {
          if (ao.c.b(this.b) == this) {
            if (!ao.c.e(this.b))
              this.c[0] = true; 
            File file = this.b.b(0);
            try {
              FileOutputStream fileOutputStream = new FileOutputStream(file);
              return new a(fileOutputStream, (byte)0);
            } catch (FileNotFoundException fileNotFoundException) {
              ao.g(this.a).mkdirs();
              try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                return new a(fileOutputStream, (byte)0);
              } catch (FileNotFoundException fileNotFoundException1) {
                return ao.e();
              } 
            } 
          } 
          throw new IllegalStateException();
        }  
      StringBuilder stringBuilder = new StringBuilder("Expected index 0 to be greater than 0 and less than the maximum value count of ");
      stringBuilder.append(ao.f(this.a));
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public final void b() throws IOException {
      if (this.d) {
        ao.a(this.a, this, false);
        this.a.c(ao.c.d(this.b));
      } else {
        ao.a(this.a, this, true);
      } 
      this.e = true;
    }
    
    public final void c() throws IOException {
      ao.a(this.a, this, false);
    }
    
    final class a extends FilterOutputStream {
      private a(ao.a this$0, OutputStream param2OutputStream) {
        super(param2OutputStream);
      }
      
      public final void close() {
        try {
          this.out.close();
          return;
        } catch (IOException iOException) {
          ao.a.c(this.a);
          return;
        } 
      }
      
      public final void flush() {
        try {
          this.out.flush();
          return;
        } catch (IOException iOException) {
          ao.a.c(this.a);
          return;
        } 
      }
      
      public final void write(int param2Int) {
        try {
          this.out.write(param2Int);
          return;
        } catch (IOException iOException) {
          ao.a.c(this.a);
          return;
        } 
      }
      
      public final void write(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) {
        try {
          this.out.write(param2ArrayOfbyte, param2Int1, param2Int2);
          return;
        } catch (IOException iOException) {
          ao.a.c(this.a);
          return;
        } 
      }
    }
  }
  
  final class a extends FilterOutputStream {
    private a(ao this$0, OutputStream param1OutputStream) {
      super(param1OutputStream);
    }
    
    public final void close() {
      try {
        this.out.close();
        return;
      } catch (IOException iOException) {
        ao.a.c(this.a);
        return;
      } 
    }
    
    public final void flush() {
      try {
        this.out.flush();
        return;
      } catch (IOException iOException) {
        ao.a.c(this.a);
        return;
      } 
    }
    
    public final void write(int param1Int) {
      try {
        this.out.write(param1Int);
        return;
      } catch (IOException iOException) {
        ao.a.c(this.a);
        return;
      } 
    }
    
    public final void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        ao.a.c(this.a);
        return;
      } 
    }
  }
  
  public final class b implements Closeable {
    private final String b;
    
    private final long c;
    
    private final InputStream[] d;
    
    private final long[] e;
    
    private b(ao this$0, String param1String, long param1Long, InputStream[] param1ArrayOfInputStream, long[] param1ArrayOflong) {
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
        ao.a(arrayOfInputStream[i]); 
    }
  }
  
  final class c {
    private final String b;
    
    private final long[] c;
    
    private boolean d;
    
    private ao.a e;
    
    private long f;
    
    private c(ao this$0, String param1String) {
      this.b = param1String;
      this.c = new long[ao.f(ao.this)];
    }
    
    private static IOException a(String[] param1ArrayOfString) throws IOException {
      StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
      stringBuilder.append(Arrays.toString((Object[])param1ArrayOfString));
      throw new IOException(stringBuilder.toString());
    }
    
    public final File a(int param1Int) {
      File file = ao.g(this.a);
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
      File file = ao.g(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(".");
      stringBuilder.append(param1Int);
      stringBuilder.append(".tmp");
      return new File(file, stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */