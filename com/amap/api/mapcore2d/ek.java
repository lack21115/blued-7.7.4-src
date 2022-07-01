package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

class ek extends ei {
  private PublicKey i = null;
  
  ek(Context paramContext, da paramda, boolean paramBoolean) throws Exception {
    super(paramContext, paramda, paramBoolean);
    String str1 = eb.b(paramContext, paramda.a(), paramda.b());
    String str2 = eb.a(paramContext);
    b(str1, str2);
    File file = new File(str1);
    if (!(eg.b().a(this.e)).b) {
      if (paramBoolean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(File.separator);
        stringBuilder.append(eb.a(file.getName()));
        a(str1, stringBuilder.toString());
        b(paramContext, str1, str2);
      } 
      return;
    } 
    throw new Exception("file is downloading");
  }
  
  private void a(dt paramdt, File paramFile) {
    ee ee = eb.a.a(paramdt, paramFile.getName());
    if (ee != null)
      this.f = ee.e(); 
  }
  
  private void a(JarFile paramJarFile, JarEntry paramJarEntry) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokevirtual getInputStream : (Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_1
    //   6: sipush #8192
    //   9: newarray byte
    //   11: astore_2
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual read : ([B)I
    //   17: istore_3
    //   18: iload_3
    //   19: ifle -> 25
    //   22: goto -> 12
    //   25: aload_1
    //   26: invokestatic a : (Ljava/io/Closeable;)V
    //   29: return
    //   30: astore_2
    //   31: goto -> 37
    //   34: astore_2
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_2
    //   38: ldc 'DyLoader'
    //   40: ldc 'loadJa'
    //   42: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_1
    //   46: invokestatic a : (Ljava/io/Closeable;)V
    //   49: return
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual printStackTrace : ()V
    //   55: return
    //   56: astore_2
    //   57: aload_1
    //   58: invokestatic a : (Ljava/io/Closeable;)V
    //   61: goto -> 69
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual printStackTrace : ()V
    //   69: aload_2
    //   70: athrow
    // Exception table:
    //   from	to	target	type
    //   0	6	34	finally
    //   6	12	30	finally
    //   12	18	30	finally
    //   25	29	50	finally
    //   37	45	56	finally
    //   45	49	50	finally
    //   57	61	64	finally
  }
  
  private boolean a(dt paramdt, da paramda, String paramString) {
    return a(new File(paramString)) ? eh.a(paramdt, eb.a(this.a, paramda.a(), paramda.b()), paramString, paramda) : false;
  }
  
  private boolean a(dt paramdt, String paramString1, String paramString2) {
    String str = eb.a(this.a, paramString1);
    if (eh.a(paramdt, paramString1, str, this.e))
      return true; 
    if (eb.a.a(paramdt, paramString1) != null)
      return false; 
    if (!TextUtils.isEmpty(this.f))
      eb.a.a(paramdt, (new ee.a(paramString1, cx.a(str), this.e.a(), this.e.b(), paramString2)).a("useod").a(), ee.b(paramString1)); 
    return true;
  }
  
  private boolean a(File paramFile) {
    try {
      c();
      JarFile jarFile = new JarFile(paramFile);
    } finally {
      null = null;
    } 
    try {
      eh.a(null, "DyLoader", "verify");
      return false;
    } finally {
      if (paramFile != null)
        try {
          paramFile.close();
        } finally {} 
    } 
  }
  
  private boolean a(File paramFile, Certificate[] paramArrayOfCertificate) {
    try {
      if (paramArrayOfCertificate.length > 0) {
        int i = paramArrayOfCertificate.length - 1;
        if (i >= 0) {
          paramArrayOfCertificate[i].verify(this.i);
          return true;
        } 
      } 
    } catch (Exception exception) {
      eh.a(exception, "DyLoader", "check");
    } 
    return false;
  }
  
  private void b(Context paramContext, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private void b(dt paramdt, File paramFile) {
    this.d = false;
    eb.a(this.a, paramdt, paramFile.getName());
    String str = eb.a(this.a, paramdt, this.e);
    if (!TextUtils.isEmpty(str)) {
      this.f = str;
      eb.a(this.a, this.e);
    } 
  }
  
  private void b(String paramString1, String paramString2) throws Exception {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2))
      return; 
    throw new Exception("dexPath or dexOutputDir is null.");
  }
  
  private void c() {
    if (this.i != null)
      return; 
    this.i = eh.a();
  }
  
  void a(Context paramContext, String paramString1, String paramString2) throws Exception {
    (new Date()).getTime();
    try {
      dt dt = new dt(paramContext, ed.c());
      File file = new File(paramString1);
      a(dt, file);
      if (!a(dt, this.e, file.getAbsolutePath()))
        b(dt, file); 
      if (!file.exists())
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(File.separator);
      stringBuilder.append(eb.a(file.getName()));
    } finally {
      paramContext = null;
    } 
    (new Date()).getTime();
  }
  
  void a(String paramString1, String paramString2) throws Exception {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload #4
    //   5: astore_3
    //   6: aload_0
    //   7: getfield c : Ldalvik/system/DexFile;
    //   10: ifnull -> 14
    //   13: return
    //   14: aload #4
    //   16: astore_3
    //   17: invokestatic b : ()Lcom/amap/api/mapcore2d/eg;
    //   20: aload_0
    //   21: getfield e : Lcom/amap/api/mapcore2d/da;
    //   24: invokevirtual a : (Lcom/amap/api/mapcore2d/da;)Lcom/amap/api/mapcore2d/eg$a;
    //   27: astore #4
    //   29: aload #4
    //   31: ifnull -> 43
    //   34: aload #4
    //   36: astore_3
    //   37: aload #4
    //   39: iconst_1
    //   40: putfield a : Z
    //   43: aload #4
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual b : ()V
    //   50: aload #4
    //   52: astore_3
    //   53: aload #4
    //   55: getfield b : Z
    //   58: ifne -> 104
    //   61: aload #4
    //   63: astore_3
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: iconst_0
    //   68: invokestatic loadDex : (Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
    //   71: putfield c : Ldalvik/system/DexFile;
    //   74: aload #4
    //   76: ifnull -> 103
    //   79: aload #4
    //   81: iconst_0
    //   82: putfield a : Z
    //   85: aload #4
    //   87: monitorenter
    //   88: aload #4
    //   90: invokevirtual notify : ()V
    //   93: aload #4
    //   95: monitorexit
    //   96: return
    //   97: astore_1
    //   98: aload #4
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: return
    //   104: aload #4
    //   106: astore_3
    //   107: new java/lang/Exception
    //   110: dup
    //   111: ldc 'file is downloading'
    //   113: invokespecial <init> : (Ljava/lang/String;)V
    //   116: athrow
    //   117: astore_1
    //   118: aload_1
    //   119: ldc_w 'dLoader'
    //   122: ldc_w 'loadFile'
    //   125: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   128: new java/lang/Exception
    //   131: dup
    //   132: ldc_w 'load file fail'
    //   135: invokespecial <init> : (Ljava/lang/String;)V
    //   138: athrow
    //   139: astore_1
    //   140: aload_3
    //   141: ifnull -> 165
    //   144: aload_3
    //   145: iconst_0
    //   146: putfield a : Z
    //   149: aload_3
    //   150: monitorenter
    //   151: aload_3
    //   152: invokevirtual notify : ()V
    //   155: aload_3
    //   156: monitorexit
    //   157: goto -> 165
    //   160: astore_2
    //   161: aload_3
    //   162: monitorexit
    //   163: aload_2
    //   164: athrow
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: return
    //   169: astore_2
    //   170: goto -> 165
    // Exception table:
    //   from	to	target	type
    //   6	13	117	finally
    //   17	29	117	finally
    //   37	43	117	finally
    //   46	50	117	finally
    //   53	61	117	finally
    //   64	74	117	finally
    //   79	88	167	finally
    //   88	96	97	finally
    //   98	101	97	finally
    //   101	103	167	finally
    //   107	117	117	finally
    //   118	139	139	finally
    //   144	151	169	finally
    //   151	157	160	finally
    //   161	163	160	finally
    //   163	165	169	finally
  }
  
  protected Class<?> findClass(String paramString) throws ClassNotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ldalvik/system/DexFile;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull -> 209
    //   9: aconst_null
    //   10: astore #4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload #4
    //   16: astore_2
    //   17: aload_0
    //   18: getfield b : Ljava/util/Map;
    //   21: astore #5
    //   23: aload #4
    //   25: astore_2
    //   26: aload #5
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield b : Ljava/util/Map;
    //   33: aload_1
    //   34: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast java/lang/Class
    //   42: astore_2
    //   43: aload #5
    //   45: monitorexit
    //   46: goto -> 79
    //   49: astore_3
    //   50: aload_3
    //   51: astore #4
    //   53: goto -> 60
    //   56: astore #4
    //   58: aload_3
    //   59: astore_2
    //   60: aload_2
    //   61: astore_3
    //   62: aload #5
    //   64: monitorexit
    //   65: aload #4
    //   67: athrow
    //   68: astore_3
    //   69: aload_3
    //   70: ldc_w 'dLoader'
    //   73: ldc_w 'findCl'
    //   76: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_2
    //   80: ifnull -> 90
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield h : Z
    //   88: aload_2
    //   89: areturn
    //   90: aload_0
    //   91: getfield g : Z
    //   94: ifne -> 200
    //   97: aload_0
    //   98: iconst_1
    //   99: putfield h : Z
    //   102: aload_0
    //   103: getfield c : Ldalvik/system/DexFile;
    //   106: aload_1
    //   107: aload_0
    //   108: invokevirtual loadClass : (Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    //   111: astore_2
    //   112: aload_0
    //   113: getfield c : Ldalvik/system/DexFile;
    //   116: astore_3
    //   117: aload_3
    //   118: monitorenter
    //   119: aload_0
    //   120: getfield c : Ldalvik/system/DexFile;
    //   123: invokevirtual notify : ()V
    //   126: aload_3
    //   127: monitorexit
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield h : Z
    //   133: aload_2
    //   134: ifnull -> 186
    //   137: aload_0
    //   138: getfield b : Ljava/util/Map;
    //   141: astore_3
    //   142: aload_3
    //   143: monitorenter
    //   144: aload_0
    //   145: getfield b : Ljava/util/Map;
    //   148: aload_1
    //   149: aload_2
    //   150: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_3
    //   157: monitorexit
    //   158: goto -> 179
    //   161: astore #4
    //   163: aload_3
    //   164: monitorexit
    //   165: aload #4
    //   167: athrow
    //   168: astore_3
    //   169: aload_3
    //   170: ldc_w 'dLoader'
    //   173: ldc_w 'findCl'
    //   176: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield h : Z
    //   184: aload_2
    //   185: areturn
    //   186: new java/lang/ClassNotFoundException
    //   189: dup
    //   190: aload_1
    //   191: invokespecial <init> : (Ljava/lang/String;)V
    //   194: athrow
    //   195: astore_2
    //   196: aload_3
    //   197: monitorexit
    //   198: aload_2
    //   199: athrow
    //   200: new java/lang/ClassNotFoundException
    //   203: dup
    //   204: aload_1
    //   205: invokespecial <init> : (Ljava/lang/String;)V
    //   208: athrow
    //   209: new java/lang/ClassNotFoundException
    //   212: dup
    //   213: aload_1
    //   214: invokespecial <init> : (Ljava/lang/String;)V
    //   217: athrow
    //   218: astore_2
    //   219: aload_2
    //   220: ldc_w 'dLoader'
    //   223: ldc_w 'findCl'
    //   226: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   229: new java/lang/ClassNotFoundException
    //   232: dup
    //   233: aload_1
    //   234: invokespecial <init> : (Ljava/lang/String;)V
    //   237: athrow
    //   238: astore_1
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield h : Z
    //   247: aload_1
    //   248: athrow
    // Exception table:
    //   from	to	target	type
    //   0	5	238	java/lang/ClassNotFoundException
    //   0	5	218	finally
    //   17	23	68	finally
    //   26	29	68	finally
    //   29	43	56	finally
    //   43	46	49	finally
    //   62	65	56	finally
    //   65	68	68	finally
    //   69	79	238	java/lang/ClassNotFoundException
    //   69	79	218	finally
    //   90	119	238	java/lang/ClassNotFoundException
    //   90	119	218	finally
    //   119	128	195	finally
    //   128	133	238	java/lang/ClassNotFoundException
    //   128	133	218	finally
    //   137	144	168	finally
    //   144	158	161	finally
    //   163	165	161	finally
    //   165	168	168	finally
    //   169	179	238	java/lang/ClassNotFoundException
    //   169	179	218	finally
    //   186	195	238	java/lang/ClassNotFoundException
    //   186	195	218	finally
    //   196	198	195	finally
    //   198	200	238	java/lang/ClassNotFoundException
    //   198	200	218	finally
    //   200	209	238	java/lang/ClassNotFoundException
    //   200	209	218	finally
    //   209	218	238	java/lang/ClassNotFoundException
    //   209	218	218	finally
    //   219	238	241	finally
    //   239	241	241	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */