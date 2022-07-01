package com.baidu.mobads.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.p;
import com.baidu.mobads.utils.q;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.jar.JarFile;

public class g {
  protected static Thread.UncaughtExceptionHandler a;
  
  protected static volatile a b;
  
  protected static volatile a c;
  
  protected static volatile Class d;
  
  protected static String e;
  
  protected static final Handler f = new h(Looper.getMainLooper());
  
  private static String i;
  
  protected Handler g = f;
  
  protected final Handler h = new i(this, Looper.getMainLooper());
  
  private com.baidu.mobads.openad.d.a j;
  
  private e k;
  
  private final Context l;
  
  private IXAdLogger m = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private boolean n = false;
  
  private CopyOnWriteArrayList<c> o = new CopyOnWriteArrayList<c>();
  
  public g(Context paramContext) {
    if (i == null) {
      IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(iXAdURIUitls.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/pa/"));
      stringBuilder.append(XAdSDKProxyVersion.getMajorVersionNumber());
      stringBuilder.append("/__pasys_remote_banner.php");
      i = stringBuilder.toString();
    } 
    this.l = paramContext;
    c(paramContext);
    if (a == null) {
      a = q.a(paramContext);
      q.a(paramContext).a(new j(this));
    } 
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof q))
      Thread.setDefaultUncaughtExceptionHandler(a); 
  }
  
  public static double a(Context paramContext, String paramString) {
    try {
      File file = new File(paramString);
      if (p.a(file)) {
        JarFile jarFile = new JarFile(file);
        double d = Double.parseDouble(jarFile.getManifest().getMainAttributes().getValue("Implementation-Version"));
        jarFile.close();
        if (d > 0.0D)
          return d; 
      } 
      return 0.0D;
    } catch (Exception exception) {
      return 0.0D;
    } 
  }
  
  private IXAdContainerFactory a(a parama) {
    IXAdContainerFactory iXAdContainerFactory = null;
    if (parama != null)
      try {
        return parama.a();
      } catch (Exception exception) {
        return null;
      }  
    return iXAdContainerFactory;
  }
  
  public static String a(Context paramContext) {
    if (TextUtils.isEmpty(e)) {
      File file = paramContext.getDir("baidu_ad_sdk", 0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(file.getAbsolutePath());
      stringBuilder1.append("/");
      e = stringBuilder1.toString();
    } 
    if (TextUtils.isEmpty(e))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e);
    stringBuilder.append("__xadsdk__remote__final__running__.jar");
    return stringBuilder.toString();
  }
  
  private void a(b paramb) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual b : ()Ljava/lang/Class;
    //   4: astore_1
    //   5: aload_0
    //   6: monitorenter
    //   7: new com/baidu/mobads/f/a
    //   10: dup
    //   11: aload_1
    //   12: aload_0
    //   13: getfield l : Landroid/content/Context;
    //   16: invokestatic getVersion : ()D
    //   19: getstatic com/baidu/mobads/constants/XAdSDKProxyVersion.DEBUG : Ljava/lang/Boolean;
    //   22: invokespecial <init> : (Ljava/lang/Class;Landroid/content/Context;DLjava/lang/Boolean;)V
    //   25: putstatic com/baidu/mobads/f/g.c : Lcom/baidu/mobads/f/a;
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   7	30	31	finally
    //   32	34	31	finally
  }
  
  private void a(e parame) {
    if (parame.a().booleanValue()) {
      c c = c.a(this.l, parame, e, this.h);
      if (!c.isAlive()) {
        this.m.d("XAdApkLoader", "XApkDownloadThread starting ...");
        c.start();
        return;
      } 
      this.m.d("XAdApkLoader", "XApkDownloadThread already started");
      c.a(parame.c());
    } 
  }
  
  private void a(boolean paramBoolean) {
    Message message = this.g.obtainMessage();
    Bundle bundle = new Bundle();
    bundle.putBoolean("success", paramBoolean);
    message.setData(bundle);
    message.what = 0;
    this.g.sendMessage(message);
  }
  
  private void a(boolean paramBoolean, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Landroid/content/Context;
    //   6: invokestatic a : (Landroid/content/Context;)Lcom/baidu/mobads/f/q;
    //   9: invokevirtual b : ()V
    //   12: aload_0
    //   13: getfield o : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   16: ifnull -> 75
    //   19: aload_0
    //   20: getfield o : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   23: invokevirtual size : ()I
    //   26: ifle -> 75
    //   29: aload_0
    //   30: getfield o : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   33: invokevirtual iterator : ()Ljava/util/Iterator;
    //   36: astore_2
    //   37: aload_2
    //   38: invokeinterface hasNext : ()Z
    //   43: ifeq -> 75
    //   46: aload_2
    //   47: invokeinterface next : ()Ljava/lang/Object;
    //   52: checkcast com/baidu/mobads/f/g$c
    //   55: astore_3
    //   56: aload_3
    //   57: iload_1
    //   58: invokeinterface a : (Z)V
    //   63: aload_0
    //   64: getfield o : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   67: aload_3
    //   68: invokevirtual remove : (Ljava/lang/Object;)Z
    //   71: pop
    //   72: goto -> 37
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	78	finally
    //   37	72	78	finally
  }
  
  public static double b(Context paramContext) {
    try {
      c(paramContext);
      null = a(paramContext, f());
      String str = d();
      double d = a(paramContext, str);
      if (Double.valueOf("8.8283").doubleValue() > d) {
        b b = new b(str, paramContext);
        if (b.exists())
          b.delete(); 
        XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileFromAssetsTo(paramContext, "bdxadsdk.jar", str);
      } 
      return Math.max(null, a(paramContext, d()));
    } catch (Exception exception) {
      return 0.0D;
    } 
  }
  
  private void b(b paramb) {
    IXAdLogger iXAdLogger2 = this.m;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("len=");
    stringBuilder2.append(paramb.length());
    stringBuilder2.append(", path=");
    stringBuilder2.append(paramb.getAbsolutePath());
    iXAdLogger2.d("XAdApkLoader", stringBuilder2.toString());
    if (b == null) {
      String str = a(this.l);
      b b1 = new b(str, this.l);
      if (b1.exists())
        b1.delete(); 
      try {
        FileInputStream fileInputStream = new FileInputStream(paramb);
        XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileInputStream(fileInputStream, str);
      } catch (Exception exception) {
        this.m.e(exception);
      } 
      b = new a(b1.b(), this.l, XAdSDKProxyVersion.getVersion(), XAdSDKProxyVersion.DEBUG);
      try {
        IXAdContainerFactory iXAdContainerFactory = b.a();
        IXAdLogger iXAdLogger = this.m;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preloaded apk.version=");
        stringBuilder.append(iXAdContainerFactory.getRemoteVersion());
        iXAdLogger.d("XAdApkLoader", stringBuilder.toString());
        return;
      } catch (a a1) {
        IXAdLogger iXAdLogger = this.m;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preload local apk ");
        stringBuilder.append(paramb.getAbsolutePath());
        stringBuilder.append(" failed, msg:");
        stringBuilder.append(a1.getMessage());
        stringBuilder.append(", v=");
        stringBuilder.append(b.a);
        iXAdLogger.d("XAdApkLoader", stringBuilder.toString());
        a(a1.getMessage());
        throw a1;
      } 
    } 
    IXAdLogger iXAdLogger1 = this.m;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("mApkBuilder already initialized, version: ");
    stringBuilder1.append(b.a);
    iXAdLogger1.d("XAdApkLoader", stringBuilder1.toString());
  }
  
  private void b(c paramc, Handler paramHandler) {
    CopyOnWriteArrayList<c> copyOnWriteArrayList = this.o;
    if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(paramc))
      this.o.add(paramc); 
    this.g = paramHandler;
    if (b == null) {
      g();
      return;
    } 
    b(true);
  }
  
  private void b(boolean paramBoolean) {
    long l;
    if (!paramBoolean && !n()) {
      this.n = true;
    } else {
      String str;
      if (paramBoolean) {
        str = "apk Successfully Loaded";
      } else {
        str = "apk Load Failed";
      } 
      a(paramBoolean, str);
    } 
    Handler handler = new Handler(Looper.getMainLooper());
    k k = new k(this, paramBoolean);
    if (this.n) {
      l = 0L;
    } else {
      l = 5000L;
    } 
    handler.postDelayed(k, l);
  }
  
  protected static String c() {
    if (TextUtils.isEmpty(e))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e);
    stringBuilder.append("__xadsdk__remote__final__builtin__.jar");
    return stringBuilder.toString();
  }
  
  private static void c(Context paramContext) {
    if (TextUtils.isEmpty(e)) {
      File file = paramContext.getDir("baidu_ad_sdk", 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file.getAbsolutePath());
      stringBuilder.append("/");
      e = stringBuilder.toString();
    } 
  }
  
  private boolean c(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial b : (Lcom/baidu/mobads/f/b;)V
    //   7: aload_0
    //   8: getfield m : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   11: astore_2
    //   12: new java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 'loaded: '
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual getPath : ()Ljava/lang/String;
    //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: ldc_w 'XAdApkLoader'
    //   41: aload_3
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aload_0
    //   52: monitorexit
    //   53: iconst_1
    //   54: ireturn
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	53	55	finally
    //   56	58	55	finally
  }
  
  protected static String d() {
    if (TextUtils.isEmpty(e))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e);
    stringBuilder.append("__xadsdk__remote__final__builtinversion__.jar");
    return stringBuilder.toString();
  }
  
  private static void d(Context paramContext) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/baidu/mobads/f/g}} */
    try {
      String str = c();
      double d = a(paramContext, str);
      if (Double.valueOf("8.8283").doubleValue() > d) {
        b b = new b(str, paramContext);
        if (b.exists())
          b.delete(); 
        XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileFromAssetsTo(paramContext, "bdxadsdk.jar", str);
      } 
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/baidu/mobads/f/g}} */
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadBuiltInApk failed: ");
      stringBuilder.append(exception.toString());
      throw new b(stringBuilder.toString());
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/baidu/mobads/f/g}} */
    throw paramContext;
  }
  
  protected static String f() {
    if (TextUtils.isEmpty(e))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e);
    stringBuilder.append("__xadsdk__remote__final__downloaded__.jar");
    return stringBuilder.toString();
  }
  
  private void k() {
    try {
      File[] arrayOfFile = this.l.getFilesDir().listFiles();
      for (int i = 0; arrayOfFile != null && i < arrayOfFile.length; i++) {
        if (arrayOfFile[i].getAbsolutePath().contains("__xadsdk__remote__final__") && arrayOfFile[i].getAbsolutePath().endsWith("dex"))
          arrayOfFile[i].delete(); 
      } 
    } catch (Exception exception) {
      q.a().e(exception);
    } 
  }
  
  private SharedPreferences l() {
    return this.l.getSharedPreferences("com.baidu.mobads.loader", 0);
  }
  
  private boolean m() {
    String str1 = l().getString("previousProxyVersion", null);
    String str2 = a();
    return (str1 == null) ? true : (!str1.equals(str2));
  }
  
  private boolean n() {
    boolean bool = false;
    try {
      if (!p.b(c())) {
        boolean bool1 = p.b(f());
        return bool1 ? true : bool;
      } 
      return true;
    } catch (Exception exception) {
      this.m.d(exception);
      return false;
    } 
  }
  
  private void o() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Lcom/baidu/mobads/openad/d/a;
    //   6: ifnull -> 23
    //   9: aload_0
    //   10: getfield j : Lcom/baidu/mobads/openad/d/a;
    //   13: invokevirtual removeAllListeners : ()V
    //   16: aload_0
    //   17: getfield j : Lcom/baidu/mobads/openad/d/a;
    //   20: invokevirtual a : ()V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield j : Lcom/baidu/mobads/openad/d/a;
    //   28: goto -> 36
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: goto -> 36
    // Exception table:
    //   from	to	target	type
    //   2	23	39	java/lang/Exception
    //   2	23	31	finally
    //   23	28	39	java/lang/Exception
    //   23	28	31	finally
  }
  
  private boolean p() {
    // Byte code:
    //   0: new com/baidu/mobads/f/b
    //   3: dup
    //   4: invokestatic f : ()Ljava/lang/String;
    //   7: aload_0
    //   8: getfield l : Landroid/content/Context;
    //   11: invokespecial <init> : (Ljava/lang/String;Landroid/content/Context;)V
    //   14: astore_3
    //   15: aload_3
    //   16: invokestatic a : (Ljava/io/File;)Z
    //   19: ifeq -> 358
    //   22: aload_0
    //   23: invokespecial m : ()Z
    //   26: ifne -> 269
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield m : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   35: astore #4
    //   37: new java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #5
    //   46: aload #5
    //   48: ldc_w 'loadDownloadedOrBuiltInApk len='
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload #5
    //   57: aload_3
    //   58: invokevirtual length : ()J
    //   61: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #5
    //   67: ldc_w ', path='
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #5
    //   76: aload_3
    //   77: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload #4
    //   86: ldc_w 'XAdApkLoader'
    //   89: aload #5
    //   91: invokevirtual toString : ()Ljava/lang/String;
    //   94: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: aload_0
    //   101: aload_3
    //   102: invokespecial b : (Lcom/baidu/mobads/f/b;)V
    //   105: aload_0
    //   106: invokespecial l : ()Landroid/content/SharedPreferences;
    //   109: ldc_w '__badApkVersion__8.8283'
    //   112: ldc_w -1.0
    //   115: invokeinterface getFloat : (Ljava/lang/String;F)F
    //   120: f2d
    //   121: dstore_1
    //   122: aload_0
    //   123: getfield m : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   126: astore #4
    //   128: new java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial <init> : ()V
    //   135: astore #5
    //   137: aload #5
    //   139: ldc_w 'downloadedApkFile.getApkVersion(): '
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload #5
    //   148: aload_3
    //   149: invokevirtual c : ()D
    //   152: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #5
    //   158: ldc_w ', badApkVersion: '
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #5
    //   167: dload_1
    //   168: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #4
    //   174: ldc_w 'XAdApkLoader'
    //   177: aload #5
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: aload_3
    //   189: invokevirtual c : ()D
    //   192: dload_1
    //   193: dcmpl
    //   194: ifeq -> 251
    //   197: aload_0
    //   198: getfield m : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   201: astore #4
    //   203: new java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial <init> : ()V
    //   210: astore #5
    //   212: aload #5
    //   214: ldc_w 'loaded: '
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload #5
    //   223: aload_3
    //   224: invokevirtual getPath : ()Ljava/lang/String;
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #4
    //   233: ldc_w 'XAdApkLoader'
    //   236: aload #5
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: aload_0
    //   248: monitorexit
    //   249: iconst_1
    //   250: ireturn
    //   251: new com/baidu/mobads/f/g$a
    //   254: dup
    //   255: ldc_w 'downloaded file marked bad, drop it and use built-in'
    //   258: invokespecial <init> : (Ljava/lang/String;)V
    //   261: athrow
    //   262: astore #4
    //   264: aload_0
    //   265: monitorexit
    //   266: aload #4
    //   268: athrow
    //   269: new com/baidu/mobads/f/g$a
    //   272: dup
    //   273: ldc_w 'XAdApkLoader upgraded, drop stale downloaded file, use built-in instead'
    //   276: invokespecial <init> : (Ljava/lang/String;)V
    //   279: athrow
    //   280: astore #4
    //   282: aload_0
    //   283: getfield m : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   286: astore #5
    //   288: new java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial <init> : ()V
    //   295: astore #6
    //   297: aload #6
    //   299: ldc_w 'load downloaded apk failed: '
    //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload #6
    //   308: aload #4
    //   310: invokevirtual toString : ()Ljava/lang/String;
    //   313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload #6
    //   319: ldc_w ', fallback to built-in'
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload #5
    //   328: ldc_w 'XAdApkLoader'
    //   331: aload #6
    //   333: invokevirtual toString : ()Ljava/lang/String;
    //   336: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   341: pop
    //   342: aload_3
    //   343: invokevirtual exists : ()Z
    //   346: ifeq -> 354
    //   349: aload_3
    //   350: invokevirtual delete : ()Z
    //   353: pop
    //   354: aload_0
    //   355: invokevirtual i : ()V
    //   358: iconst_0
    //   359: ireturn
    // Exception table:
    //   from	to	target	type
    //   22	31	280	com/baidu/mobads/f/g$a
    //   31	249	262	finally
    //   251	262	262	finally
    //   264	266	262	finally
    //   266	269	280	com/baidu/mobads/f/g$a
    //   269	280	280	com/baidu/mobads/f/g$a
  }
  
  public final String a() {
    return "8.8283";
  }
  
  public void a(c paramc) {
    a(paramc, f);
  }
  
  public void a(c paramc, Handler paramHandler) {
    (new Thread(new n(this, paramc, paramHandler))).start();
  }
  
  protected void a(String paramString) {
    if (b != null) {
      SharedPreferences.Editor editor = l().edit();
      editor.putFloat("__badApkVersion__8.8283", (float)b.a);
      if (Build.VERSION.SDK_INT >= 9) {
        editor.apply();
        return;
      } 
      editor.commit();
    } 
  }
  
  protected void b() {
    (new File(f())).delete();
  }
  
  protected void e() {
    d(this.l);
    String str = c();
    b b = new b(str, this.l);
    if (p.a(b)) {
      if (c(b))
        b(true); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("loadBuiltInApk failed: ");
    stringBuilder.append(str);
    throw new b(stringBuilder.toString());
  }
  
  protected void g() {
    if (p()) {
      b(true);
      return;
    } 
    this.m.d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
    try {
      e();
      return;
    } catch (b b) {
      IXAdLogger iXAdLogger = this.m;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("loadBuiltInApk failed: ");
      stringBuilder2.append(b.toString());
      iXAdLogger.d("XAdApkLoader", stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("load built-in apk failed");
      stringBuilder1.append(b.toString());
      throw new a(stringBuilder1.toString());
    } 
  }
  
  public IXAdContainerFactory h() {
    return a(b);
  }
  
  protected void i() {
    if (b != null) {
      b.b();
      b = null;
    } 
  }
  
  public static final class a extends Exception {
    public a(String param1String) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(param1String);
    }
  }
  
  public static final class b extends Exception {
    public b(String param1String) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(param1String);
    }
  }
  
  public static interface c {
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */