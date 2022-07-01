package com.amap.api.mapcore2d;

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

public final class em implements Closeable {
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  
  static ThreadPoolExecutor b;
  
  private static final ThreadFactory q = new ThreadFactory() {
      private final AtomicInteger a = new AtomicInteger(1);
      
      public Thread newThread(Runnable param1Runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("disklrucache#");
        stringBuilder.append(this.a.getAndIncrement());
        return new Thread(param1Runnable, stringBuilder.toString());
      }
    };
  
  private static final OutputStream s;
  
  private final File c;
  
  private final File d;
  
  private final File e;
  
  private final File f;
  
  private final int g;
  
  private long h;
  
  private final int i;
  
  private long j = 0L;
  
  private Writer k;
  
  private int l = 1000;
  
  private final LinkedHashMap<String, c> m = new LinkedHashMap<String, c>(0, 0.75F, true);
  
  private int n;
  
  private en o;
  
  private long p = 0L;
  
  private final Callable<Void> r = new Callable<Void>(this) {
      public Void a() throws Exception {
        synchronized (this.a) {
          if (em.a(this.a) == null)
            return null; 
          em.b(this.a);
          if (em.c(this.a)) {
            em.d(this.a);
            em.a(this.a, 0);
          } 
          return null;
        } 
      }
    };
  
  static {
    b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), q);
    s = new OutputStream() {
        public void write(int param1Int) throws IOException {}
      };
  }
  
  private em(File paramFile, int paramInt1, int paramInt2, long paramLong) {
    this.c = paramFile;
    this.g = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.i = paramInt2;
    this.h = paramLong;
  }
  
  private a a(String paramString, long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial e : (Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield m : Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/amap/api/mapcore2d/em$c
    //   22: astore #6
    //   24: lload_2
    //   25: ldc2_w -1
    //   28: lcmp
    //   29: ifeq -> 55
    //   32: aload #6
    //   34: ifnull -> 51
    //   37: aload #6
    //   39: invokestatic e : (Lcom/amap/api/mapcore2d/em$c;)J
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
    //   60: new com/amap/api/mapcore2d/em$c
    //   63: dup
    //   64: aload_0
    //   65: aload_1
    //   66: aconst_null
    //   67: invokespecial <init> : (Lcom/amap/api/mapcore2d/em;Ljava/lang/String;Lcom/amap/api/mapcore2d/em$1;)V
    //   70: astore #6
    //   72: aload_0
    //   73: getfield m : Ljava/util/LinkedHashMap;
    //   76: aload_1
    //   77: aload #6
    //   79: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   82: pop
    //   83: goto -> 102
    //   86: aload #6
    //   88: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;)Lcom/amap/api/mapcore2d/em$a;
    //   91: astore #7
    //   93: aload #7
    //   95: ifnull -> 102
    //   98: aload_0
    //   99: monitorexit
    //   100: aconst_null
    //   101: areturn
    //   102: new com/amap/api/mapcore2d/em$a
    //   105: dup
    //   106: aload_0
    //   107: aload #6
    //   109: aconst_null
    //   110: invokespecial <init> : (Lcom/amap/api/mapcore2d/em;Lcom/amap/api/mapcore2d/em$c;Lcom/amap/api/mapcore2d/em$1;)V
    //   113: astore #7
    //   115: aload #6
    //   117: aload #7
    //   119: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;Lcom/amap/api/mapcore2d/em$a;)Lcom/amap/api/mapcore2d/em$a;
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
  
  public static em a(File paramFile, int paramInt1, int paramInt2, long paramLong) throws IOException {
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
        em em2 = new em(paramFile, paramInt1, paramInt2, paramLong);
        if (em2.d.exists())
          try {
            em2.g();
            em2.h();
            return em2;
          } finally {
            Exception exception = null;
          }  
        paramFile.mkdirs();
        em em1 = new em(paramFile, paramInt1, paramInt2, paramLong);
        em1.i();
        return em1;
      } 
      throw new IllegalArgumentException("valueCount <= 0");
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public static void a() {
    ThreadPoolExecutor threadPoolExecutor = b;
    if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown())
      b.shutdown(); 
  }
  
  private void a(a parama, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic a : (Lcom/amap/api/mapcore2d/em$a;)Lcom/amap/api/mapcore2d/em$c;
    //   6: astore #10
    //   8: aload #10
    //   10: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;)Lcom/amap/api/mapcore2d/em$a;
    //   13: aload_1
    //   14: if_acmpne -> 451
    //   17: iconst_0
    //   18: istore #5
    //   20: iload #5
    //   22: istore #4
    //   24: iload_2
    //   25: ifeq -> 127
    //   28: iload #5
    //   30: istore #4
    //   32: aload #10
    //   34: invokestatic d : (Lcom/amap/api/mapcore2d/em$c;)Z
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
    //   55: invokestatic b : (Lcom/amap/api/mapcore2d/em$a;)[Z
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
    //   152: ifeq -> 464
    //   155: aload #10
    //   157: iload #4
    //   159: invokevirtual a : (I)Ljava/io/File;
    //   162: astore #11
    //   164: aload_1
    //   165: aload #11
    //   167: invokevirtual renameTo : (Ljava/io/File;)Z
    //   170: pop
    //   171: aload #10
    //   173: invokestatic b : (Lcom/amap/api/mapcore2d/em$c;)[J
    //   176: iload #4
    //   178: laload
    //   179: lstore #6
    //   181: aload #11
    //   183: invokevirtual length : ()J
    //   186: lstore #8
    //   188: aload #10
    //   190: invokestatic b : (Lcom/amap/api/mapcore2d/em$c;)[J
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
    //   212: goto -> 464
    //   215: aload_1
    //   216: invokestatic a : (Ljava/io/File;)V
    //   219: goto -> 464
    //   222: aload_0
    //   223: aload_0
    //   224: getfield n : I
    //   227: iconst_1
    //   228: iadd
    //   229: putfield n : I
    //   232: aload #10
    //   234: aconst_null
    //   235: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;Lcom/amap/api/mapcore2d/em$a;)Lcom/amap/api/mapcore2d/em$a;
    //   238: pop
    //   239: aload #10
    //   241: invokestatic d : (Lcom/amap/api/mapcore2d/em$c;)Z
    //   244: iload_2
    //   245: ior
    //   246: ifeq -> 347
    //   249: aload #10
    //   251: iconst_1
    //   252: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;Z)Z
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
    //   283: invokestatic c : (Lcom/amap/api/mapcore2d/em$c;)Ljava/lang/String;
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
    //   323: getfield p : J
    //   326: lstore #6
    //   328: aload_0
    //   329: lconst_1
    //   330: lload #6
    //   332: ladd
    //   333: putfield p : J
    //   336: aload #10
    //   338: lload #6
    //   340: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;J)J
    //   343: pop2
    //   344: goto -> 411
    //   347: aload_0
    //   348: getfield m : Ljava/util/LinkedHashMap;
    //   351: aload #10
    //   353: invokestatic c : (Lcom/amap/api/mapcore2d/em$c;)Ljava/lang/String;
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
    //   387: invokestatic c : (Lcom/amap/api/mapcore2d/em$c;)Ljava/lang/String;
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
    //   431: invokespecial j : ()Z
    //   434: ifeq -> 448
    //   437: invokestatic b : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   440: aload_0
    //   441: getfield r : Ljava/util/concurrent/Callable;
    //   444: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   447: pop
    //   448: aload_0
    //   449: monitorexit
    //   450: return
    //   451: new java/lang/IllegalStateException
    //   454: dup
    //   455: invokespecial <init> : ()V
    //   458: athrow
    //   459: astore_1
    //   460: aload_0
    //   461: monitorexit
    //   462: aload_1
    //   463: athrow
    //   464: iload #4
    //   466: iconst_1
    //   467: iadd
    //   468: istore #4
    //   470: goto -> 127
    // Exception table:
    //   from	to	target	type
    //   2	17	459	finally
    //   32	40	459	finally
    //   46	79	459	finally
    //   89	127	459	finally
    //   127	144	459	finally
    //   148	212	459	finally
    //   215	219	459	finally
    //   222	318	459	finally
    //   322	344	459	finally
    //   347	411	459	finally
    //   411	437	459	finally
    //   437	448	459	finally
    //   451	459	459	finally
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
  
  public static ThreadPoolExecutor b() {
    try {
    
    } finally {
      Exception exception = null;
    } 
    return b;
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
            this.m.remove(str1);
            return;
          } 
        } 
      } else {
        str = paramString.substring(j, k);
      } 
      c c2 = this.m.get(str);
      c c1 = c2;
      if (c2 == null) {
        c1 = new c(str);
        this.m.put(str, c1);
      } 
      if (k != -1 && i == 5 && paramString.startsWith("CLEAN")) {
        arrayOfString = paramString.substring(k + 1).split(" ");
        c.a(c1, true);
        c.a(c1, (a)null);
        c.a(c1, arrayOfString);
        return;
      } 
      if (k == -1 && i == 5 && arrayOfString.startsWith("DIRTY")) {
        c.a(c1, new a(c1));
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
  
  private void e(String paramString) {
    if (a.matcher(paramString).matches())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private void g() throws IOException {
    eo eo = new eo(new FileInputStream(this.d), ep.a);
    try {
      String str1 = eo.a();
      String str2 = eo.a();
      String str5 = eo.a();
      String str3 = eo.a();
      String str4 = eo.a();
      if ("libcore.io.DiskLruCache".equals(str1) && "1".equals(str2) && Integer.toString(this.g).equals(str5) && Integer.toString(this.i).equals(str3)) {
        boolean bool = "".equals(str4);
        if (bool) {
          int i = 0;
          try {
            while (true) {
              d(eo.a());
              i++;
            } 
          } catch (EOFException eOFException) {
            this.n = i - this.m.size();
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
      ep.a(eo);
    } 
  }
  
  private void h() throws IOException {
    a(this.e);
    Iterator<c> iterator = this.m.values().iterator();
    while (iterator.hasNext()) {
      c c = iterator.next();
      a a = c.a(c);
      boolean bool = false;
      int i = 0;
      if (a == null) {
        while (i < this.i) {
          this.j += c.b(c)[i];
          i++;
        } 
        continue;
      } 
      c.a(c, (a)null);
      for (i = bool; i < this.i; i++) {
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
    //   35: getstatic com/amap/api/mapcore2d/ep.a : Ljava/nio/charset/Charset;
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
    //   117: getfield m : Ljava/util/LinkedHashMap;
    //   120: invokevirtual values : ()Ljava/util/Collection;
    //   123: invokeinterface iterator : ()Ljava/util/Iterator;
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface hasNext : ()Z
    //   135: ifeq -> 260
    //   138: aload_2
    //   139: invokeinterface next : ()Ljava/lang/Object;
    //   144: checkcast com/amap/api/mapcore2d/em$c
    //   147: astore_3
    //   148: aload_3
    //   149: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;)Lcom/amap/api/mapcore2d/em$a;
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
    //   175: invokestatic c : (Lcom/amap/api/mapcore2d/em$c;)Ljava/lang/String;
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
    //   223: invokestatic c : (Lcom/amap/api/mapcore2d/em$c;)Ljava/lang/String;
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
    //   327: getstatic com/amap/api/mapcore2d/ep.a : Ljava/nio/charset/Charset;
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
  
  private boolean j() {
    int i = this.n;
    return (i >= 2000 && i >= this.m.size());
  }
  
  private void k() {
    if (this.k != null)
      return; 
    throw new IllegalStateException("cache is closed");
  }
  
  private void l() throws IOException {
    while (true) {
      if (this.j > this.h || this.m.size() > this.l) {
        String str = (String)((Map.Entry)this.m.entrySet().iterator().next()).getKey();
        c(str);
        en en1 = this.o;
        if (en1 != null)
          en1.a(str); 
        continue;
      } 
      return;
    } 
  }
  
  public b a(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial e : (Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield m : Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/amap/api/mapcore2d/em$c
    //   22: astore #6
    //   24: aload #6
    //   26: ifnonnull -> 33
    //   29: aload_0
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload #6
    //   35: invokestatic d : (Lcom/amap/api/mapcore2d/em$c;)Z
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
    //   96: getfield n : I
    //   99: iconst_1
    //   100: iadd
    //   101: putfield n : I
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
    //   155: invokespecial j : ()Z
    //   158: ifeq -> 172
    //   161: invokestatic b : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   164: aload_0
    //   165: getfield r : Ljava/util/concurrent/Callable;
    //   168: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   171: pop
    //   172: new com/amap/api/mapcore2d/em$b
    //   175: dup
    //   176: aload_0
    //   177: aload_1
    //   178: aload #6
    //   180: invokestatic e : (Lcom/amap/api/mapcore2d/em$c;)J
    //   183: aload #5
    //   185: aload #6
    //   187: invokestatic b : (Lcom/amap/api/mapcore2d/em$c;)[J
    //   190: aconst_null
    //   191: invokespecial <init> : (Lcom/amap/api/mapcore2d/em;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/amap/api/mapcore2d/em$1;)V
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: areturn
    //   199: iload_2
    //   200: aload_0
    //   201: getfield i : I
    //   204: if_icmpge -> 228
    //   207: aload #5
    //   209: iload_2
    //   210: aaload
    //   211: ifnull -> 228
    //   214: aload #5
    //   216: iload_2
    //   217: aaload
    //   218: invokestatic a : (Ljava/io/Closeable;)V
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -> 199
    //   228: aload_0
    //   229: monitorexit
    //   230: aconst_null
    //   231: areturn
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: iload_3
    //   239: istore_2
    //   240: goto -> 199
    // Exception table:
    //   from	to	target	type
    //   2	24	232	finally
    //   33	40	232	finally
    //   49	58	232	finally
    //   62	87	237	java/io/FileNotFoundException
    //   62	87	232	finally
    //   94	172	232	finally
    //   172	195	232	finally
    //   199	207	232	finally
    //   214	221	232	finally
  }
  
  public void a(int paramInt) {
    int i;
    if (paramInt < 10) {
      i = 10;
    } else {
      i = paramInt;
      if (paramInt > 10000)
        i = 10000; 
    } 
    this.l = i;
  }
  
  public a b(String paramString) throws IOException {
    return a(paramString, -1L);
  }
  
  public File c() {
    return this.c;
  }
  
  public boolean c(String paramString) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial e : (Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield m : Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/amap/api/mapcore2d/em$c
    //   22: astore #4
    //   24: iconst_0
    //   25: istore_2
    //   26: aload #4
    //   28: ifnull -> 228
    //   31: aload #4
    //   33: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;)Lcom/amap/api/mapcore2d/em$a;
    //   36: ifnull -> 42
    //   39: goto -> 228
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
    //   115: invokestatic b : (Lcom/amap/api/mapcore2d/em$c;)[J
    //   118: iload_2
    //   119: laload
    //   120: lsub
    //   121: putfield j : J
    //   124: aload #4
    //   126: invokestatic b : (Lcom/amap/api/mapcore2d/em$c;)[J
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
    //   141: getfield n : I
    //   144: iconst_1
    //   145: iadd
    //   146: putfield n : I
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
    //   198: getfield m : Ljava/util/LinkedHashMap;
    //   201: aload_1
    //   202: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload_0
    //   207: invokespecial j : ()Z
    //   210: ifeq -> 224
    //   213: invokestatic b : ()Ljava/util/concurrent/ThreadPoolExecutor;
    //   216: aload_0
    //   217: getfield r : Ljava/util/concurrent/Callable;
    //   220: invokevirtual submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   223: pop
    //   224: aload_0
    //   225: monitorexit
    //   226: iconst_1
    //   227: ireturn
    //   228: aload_0
    //   229: monitorexit
    //   230: iconst_0
    //   231: ireturn
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	232	finally
    //   31	39	232	finally
    //   42	71	232	finally
    //   74	108	232	finally
    //   108	132	232	finally
    //   139	224	232	finally
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
    //   19: getfield m : Ljava/util/LinkedHashMap;
    //   22: invokevirtual values : ()Ljava/util/Collection;
    //   25: invokespecial <init> : (Ljava/util/Collection;)V
    //   28: invokevirtual iterator : ()Ljava/util/Iterator;
    //   31: astore_1
    //   32: aload_1
    //   33: invokeinterface hasNext : ()Z
    //   38: ifeq -> 68
    //   41: aload_1
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast com/amap/api/mapcore2d/em$c
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;)Lcom/amap/api/mapcore2d/em$a;
    //   55: ifnull -> 32
    //   58: aload_2
    //   59: invokestatic a : (Lcom/amap/api/mapcore2d/em$c;)Lcom/amap/api/mapcore2d/em$a;
    //   62: invokevirtual b : ()V
    //   65: goto -> 32
    //   68: aload_0
    //   69: invokespecial l : ()V
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
  
  public void d() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()V
    //   6: aload_0
    //   7: invokespecial l : ()V
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
  
  public void e() throws IOException {
    close();
    ep.a(this.c);
  }
  
  public final class a {
    private final em.c b;
    
    private final boolean[] c;
    
    private boolean d;
    
    private boolean e;
    
    private a(em this$0, em.c param1c) {
      boolean[] arrayOfBoolean;
      this.b = param1c;
      if (em.c.d(param1c)) {
        em.this = null;
      } else {
        arrayOfBoolean = new boolean[em.e(em.this)];
      } 
      this.c = arrayOfBoolean;
    }
    
    public OutputStream a(int param1Int) throws IOException {
      if (param1Int >= 0 && param1Int < em.e(this.a))
        synchronized (this.a) {
          if (em.c.a(this.b) == this) {
            if (!em.c.d(this.b))
              this.c[param1Int] = true; 
            File file = this.b.b(param1Int);
            try {
              FileOutputStream fileOutputStream = new FileOutputStream(file);
              return new a(fileOutputStream);
            } catch (FileNotFoundException fileNotFoundException) {
              em.f(this.a).mkdirs();
              try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                return new a(fileOutputStream);
              } catch (FileNotFoundException fileNotFoundException1) {
                return em.f();
              } 
            } 
          } 
          throw new IllegalStateException();
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected index ");
      stringBuilder.append(param1Int);
      stringBuilder.append(" to be greater than 0 and less than the maximum value count of ");
      stringBuilder.append(em.e(this.a));
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void a() throws IOException {
      if (this.d) {
        em.a(this.a, this, false);
        this.a.c(em.c.c(this.b));
      } else {
        em.a(this.a, this, true);
      } 
      this.e = true;
    }
    
    public void b() throws IOException {
      em.a(this.a, this, false);
    }
    
    class a extends FilterOutputStream {
      private a(em.a this$0, OutputStream param2OutputStream) {
        super(param2OutputStream);
      }
      
      public void close() {
        try {
          this.out.close();
          return;
        } catch (IOException iOException) {
          em.a.a(this.a, true);
          return;
        } 
      }
      
      public void flush() {
        try {
          this.out.flush();
          return;
        } catch (IOException iOException) {
          em.a.a(this.a, true);
          return;
        } 
      }
      
      public void write(int param2Int) {
        try {
          this.out.write(param2Int);
          return;
        } catch (IOException iOException) {
          em.a.a(this.a, true);
          return;
        } 
      }
      
      public void write(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) {
        try {
          this.out.write(param2ArrayOfbyte, param2Int1, param2Int2);
          return;
        } catch (IOException iOException) {
          em.a.a(this.a, true);
          return;
        } 
      }
    }
  }
  
  class a extends FilterOutputStream {
    private a(em this$0, OutputStream param1OutputStream) {
      super(param1OutputStream);
    }
    
    public void close() {
      try {
        this.out.close();
        return;
      } catch (IOException iOException) {
        em.a.a(this.a, true);
        return;
      } 
    }
    
    public void flush() {
      try {
        this.out.flush();
        return;
      } catch (IOException iOException) {
        em.a.a(this.a, true);
        return;
      } 
    }
    
    public void write(int param1Int) {
      try {
        this.out.write(param1Int);
        return;
      } catch (IOException iOException) {
        em.a.a(this.a, true);
        return;
      } 
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        em.a.a(this.a, true);
        return;
      } 
    }
  }
  
  public final class b implements Closeable {
    private final String b;
    
    private final long c;
    
    private final InputStream[] d;
    
    private final long[] e;
    
    private b(em this$0, String param1String, long param1Long, InputStream[] param1ArrayOfInputStream, long[] param1ArrayOflong) {
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
        ep.a(arrayOfInputStream[i]); 
    }
  }
  
  final class c {
    private final String b;
    
    private final long[] c;
    
    private boolean d;
    
    private em.a e;
    
    private long f;
    
    private c(em this$0, String param1String) {
      this.b = param1String;
      this.c = new long[em.e(em.this)];
    }
    
    private void a(String[] param1ArrayOfString) throws IOException {
      if (param1ArrayOfString.length == em.e(this.a)) {
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
      File file = em.f(this.a);
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
      File file = em.f(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(".");
      stringBuilder.append(param1Int);
      stringBuilder.append(".tmp");
      return new File(file, stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */