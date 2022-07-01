package com.tencent.tbs.sdk.extension.partner.debugtbs;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.tbs.sdk.extension.partner.c.d;
import com.tencent.tbs.sdk.extension.partner.c.g;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class a {
  final String a = "cmdDisableX5";
  
  final String b = "cmdDebugtbs";
  
  final String c = "key_command";
  
  final String d = "key_packagename";
  
  String e;
  
  HomeKeyEventBroadcastReceiver f;
  
  boolean g = false;
  
  Handler h;
  
  TextView i;
  
  private int j = 0;
  
  private String k = "";
  
  private int l = 0;
  
  private volatile boolean m = false;
  
  private a() {
    this.l = 0;
    this.g = false;
  }
  
  public static a a() {
    return b.a();
  }
  
  private void a(Context paramContext, View paramView) {
    // Byte code:
    //   0: aload_1
    //   1: instanceof android/app/Activity
    //   4: istore #6
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #7
    //   15: aload #7
    //   17: ldc 'addToParent,isActivity:'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload #7
    //   25: iload #6
    //   27: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #7
    //   33: ldc ','
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #7
    //   41: aload_0
    //   42: invokevirtual b : ()Z
    //   45: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload #7
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: pop
    //   55: iconst_0
    //   56: istore_3
    //   57: iconst_0
    //   58: istore #4
    //   60: iload #6
    //   62: ifeq -> 156
    //   65: aload_1
    //   66: checkcast android/app/Activity
    //   69: ldc 16908290
    //   71: invokevirtual findViewById : (I)Landroid/view/View;
    //   74: checkcast android/view/ViewGroup
    //   77: astore_1
    //   78: new android/widget/FrameLayout$LayoutParams
    //   81: dup
    //   82: iconst_m1
    //   83: iconst_m1
    //   84: invokespecial <init> : (II)V
    //   87: astore #7
    //   89: aload_1
    //   90: invokevirtual getChildCount : ()I
    //   93: istore #5
    //   95: iload #4
    //   97: istore_3
    //   98: iload_3
    //   99: iload #5
    //   101: if_icmpge -> 148
    //   104: new java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial <init> : ()V
    //   111: astore #8
    //   113: aload #8
    //   115: ldc 'child: '
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload #8
    //   123: aload_1
    //   124: iload_3
    //   125: invokevirtual getChildAt : (I)Landroid/view/View;
    //   128: invokevirtual getClass : ()Ljava/lang/Class;
    //   131: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #8
    //   137: invokevirtual toString : ()Ljava/lang/String;
    //   140: pop
    //   141: iload_3
    //   142: iconst_1
    //   143: iadd
    //   144: istore_3
    //   145: goto -> 98
    //   148: aload_1
    //   149: aload_2
    //   150: aload #7
    //   152: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   155: return
    //   156: aload_1
    //   157: ldc 'window'
    //   159: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   162: checkcast android/view/WindowManager
    //   165: astore #7
    //   167: new android/view/WindowManager$LayoutParams
    //   170: dup
    //   171: invokespecial <init> : ()V
    //   174: astore #8
    //   176: aload_1
    //   177: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   180: getfield targetSdkVersion : I
    //   183: istore #4
    //   185: aload_1
    //   186: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   189: ldc 'android.permission.SYSTEM_ALERT_WINDOW'
    //   191: aload_1
    //   192: invokevirtual getPackageName : ()Ljava/lang/String;
    //   195: invokevirtual checkPermission : (Ljava/lang/String;Ljava/lang/String;)I
    //   198: istore #5
    //   200: iload #5
    //   202: ifne -> 207
    //   205: iconst_1
    //   206: istore_3
    //   207: getstatic android/os/Build$VERSION.SDK_INT : I
    //   210: bipush #25
    //   212: if_icmplt -> 245
    //   215: iload #4
    //   217: bipush #22
    //   219: if_icmple -> 245
    //   222: iload #4
    //   224: bipush #26
    //   226: if_icmpge -> 232
    //   229: goto -> 343
    //   232: sipush #2038
    //   235: istore_3
    //   236: aload #8
    //   238: iload_3
    //   239: putfield type : I
    //   242: goto -> 351
    //   245: iload_3
    //   246: ifne -> 343
    //   249: ldc 'xiaomi'
    //   251: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   254: invokevirtual equals : (Ljava/lang/Object;)Z
    //   257: ifne -> 343
    //   260: ldc 'vivo'
    //   262: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   265: invokevirtual equals : (Ljava/lang/Object;)Z
    //   268: ifeq -> 274
    //   271: goto -> 343
    //   274: getstatic android/os/Build$VERSION.SDK_INT : I
    //   277: bipush #25
    //   279: if_icmplt -> 336
    //   282: new java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial <init> : ()V
    //   289: astore_2
    //   290: aload_2
    //   291: ldc '应用未申请权限或未针对该应用开启悬浮窗权限:android.permission.SYSTEM_ALERT_WINDOW，请前往tbssuit中选择其他调试功能! ('
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: getstatic android/os/Build$VERSION.SDK_INT : I
    //   301: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_2
    //   306: ldc ','
    //   308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_2
    //   313: iload #4
    //   315: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_2
    //   320: ldc ')'
    //   322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_0
    //   327: aload_1
    //   328: aload_2
    //   329: invokevirtual toString : ()Ljava/lang/String;
    //   332: invokespecial b : (Landroid/content/Context;Ljava/lang/String;)V
    //   335: return
    //   336: sipush #2005
    //   339: istore_3
    //   340: goto -> 236
    //   343: aload #8
    //   345: sipush #2002
    //   348: putfield type : I
    //   351: new java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial <init> : ()V
    //   358: astore #9
    //   360: aload #9
    //   362: ldc 'addToParent Build.VERSION.SDK_INT:'
    //   364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload #9
    //   370: getstatic android/os/Build$VERSION.SDK_INT : I
    //   373: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload #9
    //   379: ldc ',targetversion:'
    //   381: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload #9
    //   387: iload #4
    //   389: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #9
    //   395: ldc ','
    //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload #9
    //   403: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   406: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload #9
    //   412: ldc ',alertwindowtest:'
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload #9
    //   420: iload #5
    //   422: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: ldc 'DebugTbsHelper'
    //   428: aload #9
    //   430: invokevirtual toString : ()Ljava/lang/String;
    //   433: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   436: new com/tencent/tbs/sdk/extension/partner/debugtbs/a$1
    //   439: dup
    //   440: aload_0
    //   441: aload_1
    //   442: aload #7
    //   444: aload_1
    //   445: invokespecial <init> : (Lcom/tencent/tbs/sdk/extension/partner/debugtbs/a;Landroid/content/Context;Landroid/view/WindowManager;Landroid/content/Context;)V
    //   448: astore #9
    //   450: aload #9
    //   452: aload_2
    //   453: invokevirtual addView : (Landroid/view/View;)V
    //   456: aload_0
    //   457: new com/tencent/tbs/sdk/extension/partner/debugtbs/HomeKeyEventBroadcastReceiver
    //   460: dup
    //   461: new com/tencent/tbs/sdk/extension/partner/debugtbs/a$2
    //   464: dup
    //   465: aload_0
    //   466: aload_1
    //   467: aload #7
    //   469: aload #9
    //   471: invokespecial <init> : (Lcom/tencent/tbs/sdk/extension/partner/debugtbs/a;Landroid/content/Context;Landroid/view/WindowManager;Landroid/widget/FrameLayout;)V
    //   474: invokespecial <init> : (Lcom/tencent/tbs/sdk/extension/partner/debugtbs/a$c;)V
    //   477: putfield f : Lcom/tencent/tbs/sdk/extension/partner/debugtbs/HomeKeyEventBroadcastReceiver;
    //   480: new android/content/IntentFilter
    //   483: dup
    //   484: ldc 'android.intent.action.CLOSE_SYSTEM_DIALOGS'
    //   486: invokespecial <init> : (Ljava/lang/String;)V
    //   489: astore_2
    //   490: aload_1
    //   491: aload_0
    //   492: getfield f : Lcom/tencent/tbs/sdk/extension/partner/debugtbs/HomeKeyEventBroadcastReceiver;
    //   495: aload_2
    //   496: invokevirtual registerReceiver : (Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   499: pop
    //   500: aload #7
    //   502: aload #9
    //   504: aload #8
    //   506: invokeinterface addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   511: return
    //   512: astore_2
    //   513: new java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial <init> : ()V
    //   520: astore #7
    //   522: aload #7
    //   524: ldc_w ' mWindowManager.addView exception:'
    //   527: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload #7
    //   533: aload_2
    //   534: invokevirtual toString : ()Ljava/lang/String;
    //   537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: ldc 'DebugTbsHelper'
    //   543: aload #7
    //   545: invokevirtual toString : ()Ljava/lang/String;
    //   548: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   551: new java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial <init> : ()V
    //   558: astore #7
    //   560: aload #7
    //   562: ldc_w ' mWindowManager.addView exception:'
    //   565: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload #7
    //   571: aload_2
    //   572: invokevirtual toString : ()Ljava/lang/String;
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload #7
    //   581: invokevirtual toString : ()Ljava/lang/String;
    //   584: pop
    //   585: new java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial <init> : ()V
    //   592: astore_2
    //   593: aload_2
    //   594: ldc '应用未申请权限或未针对该应用开启悬浮窗权限:android.permission.SYSTEM_ALERT_WINDOW，请前往tbssuit中选择其他调试功能! ('
    //   596: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload_2
    //   601: getstatic android/os/Build$VERSION.SDK_INT : I
    //   604: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_2
    //   609: ldc ','
    //   611: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_2
    //   616: iload #4
    //   618: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: ldc ')'
    //   625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_0
    //   630: aload_1
    //   631: aload_2
    //   632: invokevirtual toString : ()Ljava/lang/String;
    //   635: invokespecial b : (Landroid/content/Context;Ljava/lang/String;)V
    //   638: return
    // Exception table:
    //   from	to	target	type
    //   500	511	512	java/lang/Throwable
  }
  
  private void a(Context paramContext, String paramString) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("showDebugTbs:");
    stringBuilder2.append(paramString);
    stringBuilder2.append(",isMainThread:");
    stringBuilder2.append(b());
    g.a("DebugTbsHelper", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramContext.getDir("debugtbs", 0).getAbsolutePath());
    stringBuilder2.append(File.separator);
    stringBuilder2.append("plugin");
    this.e = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.e);
    stringBuilder2.append(File.separator);
    stringBuilder2.append("DebugPlugin.tbs");
    String str2 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.e);
    stringBuilder2.append(File.separator);
    stringBuilder2.append("DebugPlugin.apk");
    String str1 = stringBuilder2.toString();
    File file1 = new File(str2);
    File file2 = new File(str1);
    if (file1.exists()) {
      file2.delete();
      file1.renameTo(file2);
    } 
    if (!file2.exists()) {
      this.l++;
      if (this.l > 3) {
        this.j = 7;
        this.k = "downloaddebugtbs times exceed！！";
        return;
      } 
      a(paramContext);
      return;
    } 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("showPluginView -- going to show plugin view with ");
    stringBuilder3.append(str1);
    stringBuilder3.toString();
    try {
      StringBuilder stringBuilder4;
      FrameLayout frameLayout;
      String str3;
      String str5 = com.tencent.tbs.sdk.extension.partner.c.b.a(paramContext, new File(str1));
      if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(str5)) {
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("verifyPlugin apk: ");
        stringBuilder4.append(str1);
        stringBuilder4.append(" signature failed - sig: ");
        stringBuilder4.append(str5);
        Log.e("DebugTbsHelper", stringBuilder4.toString());
        this.j = 8;
        this.k = "verifyPlugin failed!!";
        Toast.makeText(paramContext, "插件校验失败，请重试", 0).show();
        file1.delete();
        file2.delete();
        return;
      } 
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append(this.e);
      stringBuilder5.append(File.separator);
      stringBuilder5.append("opt");
      String str4 = stringBuilder5.toString();
      File file = new File(str4);
      if (!file.exists())
        file.mkdirs(); 
      DexClassLoader dexClassLoader = new DexClassLoader(str1, str4, null, paramContext.getClassLoader());
      str4 = "http://debugtbs.qq.com?from=sdkextension";
      str1 = str4;
      if (stringBuilder4 != null) {
        str1 = str4;
        if (!stringBuilder4.equals("cmdDebugtbs")) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("http://debugtbs.qq.com?from=sdkextension");
          stringBuilder.append("&func=");
          stringBuilder.append((String)stringBuilder4);
          str3 = stringBuilder.toString();
        } 
      } 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("url", str3);
      hashMap.put("tbs_version", "10000");
      hashMap.put("tbs_core_version", Integer.valueOf(com.tencent.tbs.sdk.extension.partner.c.b.e(paramContext)));
      hashMap = dexClassLoader.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[] { Context.class, Map.class }).newInstance(new Object[] { paramContext, hashMap });
      if (hashMap instanceof FrameLayout) {
        frameLayout = (FrameLayout)hashMap;
        if (this.g)
          a(paramContext, (View)frameLayout); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("show ");
        stringBuilder.append(frameLayout);
        stringBuilder.append(" successful in ");
        stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get debugview failure: ");
        stringBuilder.append(frameLayout.getClass());
        g.c("DebugTbsHelper", stringBuilder.toString());
      } 
    } catch (Exception exception) {
      this.j = 9;
      this.k = exception.getMessage();
      try {
        d.b(file2.getAbsolutePath());
      } catch (Exception exception1) {
        exception1.printStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.k);
        stringBuilder.append(",");
        stringBuilder.append(exception1.getMessage());
        this.k = stringBuilder.toString();
      } 
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("mStatusCode: ");
    stringBuilder1.append(this.j);
    stringBuilder1.append(",");
    stringBuilder1.append(this.k);
    g.a("DebugTbsHelper", stringBuilder1.toString());
  }
  
  private void a(Runnable paramRunnable) {
    if (b()) {
      paramRunnable.run();
      return;
    } 
    if (this.h == null)
      this.h = new Handler(Looper.getMainLooper()); 
    this.h.post(paramRunnable);
  }
  
  private void a(String paramString, a parama) {
    (new Thread(this, paramString, parama) {
        public void run() {
          // Byte code:
          //   0: aconst_null
          //   1: astore #11
          //   3: aconst_null
          //   4: astore #9
          //   6: aconst_null
          //   7: astore #8
          //   9: aconst_null
          //   10: astore #12
          //   12: new java/net/URL
          //   15: dup
          //   16: ldc 'https://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs'
          //   18: invokespecial <init> : (Ljava/lang/String;)V
          //   21: invokevirtual openConnection : ()Ljava/net/URLConnection;
          //   24: checkcast java/net/HttpURLConnection
          //   27: astore #10
          //   29: aload #10
          //   31: invokevirtual getContentLength : ()I
          //   34: istore #5
          //   36: aload #10
          //   38: sipush #5000
          //   41: invokevirtual setConnectTimeout : (I)V
          //   44: aload #10
          //   46: invokevirtual connect : ()V
          //   49: aload #10
          //   51: invokevirtual getInputStream : ()Ljava/io/InputStream;
          //   54: astore #10
          //   56: aload #12
          //   58: astore #8
          //   60: aload #11
          //   62: astore #9
          //   64: new java/io/File
          //   67: dup
          //   68: aload_0
          //   69: getfield a : Ljava/lang/String;
          //   72: invokespecial <init> : (Ljava/lang/String;)V
          //   75: invokestatic a : (Ljava/io/File;)Ljava/io/FileOutputStream;
          //   78: astore #11
          //   80: aload #11
          //   82: astore #8
          //   84: aload #11
          //   86: astore #9
          //   88: sipush #8192
          //   91: newarray byte
          //   93: astore #12
          //   95: aload #11
          //   97: astore #8
          //   99: aload #11
          //   101: astore #9
          //   103: invokestatic currentTimeMillis : ()J
          //   106: lstore #6
          //   108: iconst_0
          //   109: istore_2
          //   110: iconst_0
          //   111: istore_1
          //   112: aload #11
          //   114: astore #8
          //   116: aload #11
          //   118: astore #9
          //   120: aload #10
          //   122: aload #12
          //   124: invokevirtual read : ([B)I
          //   127: istore_3
          //   128: iload_3
          //   129: ifle -> 243
          //   132: iload_2
          //   133: iload_3
          //   134: iadd
          //   135: istore #4
          //   137: aload #11
          //   139: astore #8
          //   141: aload #11
          //   143: astore #9
          //   145: aload #11
          //   147: aload #12
          //   149: iconst_0
          //   150: iload_3
          //   151: invokevirtual write : ([BII)V
          //   154: iload_1
          //   155: istore_3
          //   156: iload #5
          //   158: ifeq -> 178
          //   161: aload #11
          //   163: astore #8
          //   165: aload #11
          //   167: astore #9
          //   169: iload #4
          //   171: bipush #100
          //   173: imul
          //   174: iload #5
          //   176: idiv
          //   177: istore_3
          //   178: iload #4
          //   180: istore_2
          //   181: iload_3
          //   182: istore_1
          //   183: aload #11
          //   185: astore #8
          //   187: aload #11
          //   189: astore #9
          //   191: invokestatic currentTimeMillis : ()J
          //   194: lload #6
          //   196: lsub
          //   197: ldc2_w 500
          //   200: lcmp
          //   201: ifle -> 112
          //   204: aload #11
          //   206: astore #8
          //   208: aload #11
          //   210: astore #9
          //   212: invokestatic currentTimeMillis : ()J
          //   215: lstore #6
          //   217: aload #11
          //   219: astore #8
          //   221: aload #11
          //   223: astore #9
          //   225: aload_0
          //   226: getfield b : Lcom/tencent/tbs/sdk/extension/partner/debugtbs/a$a;
          //   229: iload_3
          //   230: invokeinterface a : (I)V
          //   235: iload #4
          //   237: istore_2
          //   238: iload_3
          //   239: istore_1
          //   240: goto -> 112
          //   243: aload #11
          //   245: astore #8
          //   247: aload #11
          //   249: astore #9
          //   251: aload_0
          //   252: getfield b : Lcom/tencent/tbs/sdk/extension/partner/debugtbs/a$a;
          //   255: invokeinterface a : ()V
          //   260: aload #10
          //   262: ifnull -> 280
          //   265: aload #10
          //   267: invokevirtual close : ()V
          //   270: goto -> 280
          //   273: astore #8
          //   275: aload #8
          //   277: invokevirtual printStackTrace : ()V
          //   280: aload #11
          //   282: ifnull -> 380
          //   285: aload #11
          //   287: invokevirtual close : ()V
          //   290: return
          //   291: astore #9
          //   293: goto -> 391
          //   296: astore #11
          //   298: aload #9
          //   300: astore #8
          //   302: aload #10
          //   304: astore #9
          //   306: aload #11
          //   308: astore #10
          //   310: goto -> 326
          //   313: astore #9
          //   315: aconst_null
          //   316: astore #10
          //   318: goto -> 391
          //   321: astore #10
          //   323: aconst_null
          //   324: astore #8
          //   326: aload #10
          //   328: invokevirtual printStackTrace : ()V
          //   331: aload_0
          //   332: getfield b : Lcom/tencent/tbs/sdk/extension/partner/debugtbs/a$a;
          //   335: aload #10
          //   337: invokeinterface a : (Ljava/lang/Throwable;)V
          //   342: aload #9
          //   344: ifnull -> 362
          //   347: aload #9
          //   349: invokevirtual close : ()V
          //   352: goto -> 362
          //   355: astore #9
          //   357: aload #9
          //   359: invokevirtual printStackTrace : ()V
          //   362: aload #8
          //   364: ifnull -> 380
          //   367: aload #8
          //   369: invokevirtual close : ()V
          //   372: return
          //   373: astore #8
          //   375: aload #8
          //   377: invokevirtual printStackTrace : ()V
          //   380: return
          //   381: astore #11
          //   383: aload #9
          //   385: astore #10
          //   387: aload #11
          //   389: astore #9
          //   391: aload #10
          //   393: ifnull -> 411
          //   396: aload #10
          //   398: invokevirtual close : ()V
          //   401: goto -> 411
          //   404: astore #10
          //   406: aload #10
          //   408: invokevirtual printStackTrace : ()V
          //   411: aload #8
          //   413: ifnull -> 431
          //   416: aload #8
          //   418: invokevirtual close : ()V
          //   421: goto -> 431
          //   424: astore #8
          //   426: aload #8
          //   428: invokevirtual printStackTrace : ()V
          //   431: aload #9
          //   433: athrow
          // Exception table:
          //   from	to	target	type
          //   12	56	321	java/lang/Exception
          //   12	56	313	finally
          //   64	80	296	java/lang/Exception
          //   64	80	291	finally
          //   88	95	296	java/lang/Exception
          //   88	95	291	finally
          //   103	108	296	java/lang/Exception
          //   103	108	291	finally
          //   120	128	296	java/lang/Exception
          //   120	128	291	finally
          //   145	154	296	java/lang/Exception
          //   145	154	291	finally
          //   169	178	296	java/lang/Exception
          //   169	178	291	finally
          //   191	204	296	java/lang/Exception
          //   191	204	291	finally
          //   212	217	296	java/lang/Exception
          //   212	217	291	finally
          //   225	235	296	java/lang/Exception
          //   225	235	291	finally
          //   251	260	296	java/lang/Exception
          //   251	260	291	finally
          //   265	270	273	java/lang/Exception
          //   285	290	373	java/lang/Exception
          //   326	342	381	finally
          //   347	352	355	java/lang/Exception
          //   367	372	373	java/lang/Exception
          //   396	401	404	java/lang/Exception
          //   416	421	424	java/lang/Exception
        }
      }).start();
  }
  
  private void b(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("show tips:");
    stringBuilder.append(paramString);
    stringBuilder.append(",");
    stringBuilder.append(Log.getStackTraceString(new Exception("xxx")));
    stringBuilder.toString();
    String str = paramString;
    try {
      if (Build.VERSION.SDK_INT >= 11) {
        ClipboardManager clipboardManager = (ClipboardManager)paramContext.getSystemService("clipboard");
        clipboardManager.setText(paramString);
        clipboardManager.getText();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append("\n copied on clipboard!");
        String str1 = stringBuilder1.toString();
      } 
    } catch (Throwable throwable) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("showTips exception:");
      stringBuilder1.append(throwable.toString());
      stringBuilder1.toString();
      str = paramString;
    } 
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      Toast.makeText(paramContext, str, 1).show();
      return;
    } 
    a(new Runnable(this, paramContext, str) {
          public void run() {
            Toast.makeText(this.a, this.b, 1).show();
          }
        });
  }
  
  public void a(Context paramContext) {
    g.a("DebugTbsHelper", "downloadPlugin");
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    this.i = new TextView(paramContext);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(13);
    this.i.setText("加载中，请稍后...");
    relativeLayout.addView((View)this.i, (ViewGroup.LayoutParams)layoutParams);
    if (this.g)
      a(paramContext, (View)relativeLayout); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append(File.separator);
    stringBuilder.append("DebugPlugin.tbs");
    String str = stringBuilder.toString();
    File file = new File(str);
    try {
      d.b(file.getAbsolutePath());
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    a(str, new a(this, paramContext, relativeLayout) {
          public void a() {
            g.a("DebugTbsHelper", "onDownloadSuccess");
            a.a(this.c, new Runnable(this) {
                  public void run() {
                    Toast.makeText(this.a.a, "下载成功", 0).show();
                    this.a.b.setVisibility(4);
                    a.a(this.a.c, this.a.a, null);
                  }
                });
          }
          
          public void a(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("已下载");
            stringBuilder.append(param1Int);
            stringBuilder.append("%");
            g.a("DebugTbsHelper", stringBuilder.toString());
            a.a(this.c, new Runnable(this, param1Int) {
                  public void run() {
                    TextView textView = this.b.c.i;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("已下载");
                    stringBuilder.append(this.a);
                    stringBuilder.append("%");
                    textView.setText(stringBuilder.toString());
                  }
                });
          }
          
          public void a(Throwable param1Throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onDownloadFailure:");
            stringBuilder.append(param1Throwable.getMessage());
            g.a("DebugTbsHelper", stringBuilder.toString());
            a.a(this.c, new Runnable(this, param1Throwable) {
                  public void run() {
                    TextView textView = this.b.c.i;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("下载失败，请检查网络:");
                    stringBuilder.append(this.a.getMessage());
                    textView.setText(stringBuilder.toString());
                    Context context = this.b.a;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("下载失败，请检查网络:");
                    stringBuilder.append(this.a.getMessage());
                    Toast.makeText(context, stringBuilder.toString(), 0).show();
                  }
                });
          }
        });
  }
  
  public int b(Context paramContext) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload #4
    //   11: ldc_w 'processCommandFromTbsSuitIfNeed:,isMainThread:'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: invokestatic currentThread : ()Ljava/lang/Thread;
    //   21: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   24: invokevirtual getThread : ()Ljava/lang/Thread;
    //   27: if_acmpne -> 35
    //   30: iconst_1
    //   31: istore_3
    //   32: goto -> 37
    //   35: iconst_0
    //   36: istore_3
    //   37: aload #4
    //   39: iload_3
    //   40: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload #4
    //   46: ldc_w ',isActivityContext:'
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload #4
    //   55: aload_1
    //   56: instanceof android/app/Activity
    //   59: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 'DebugTbsHelper'
    //   65: aload #4
    //   67: invokevirtual toString : ()Ljava/lang/String;
    //   70: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield j : I
    //   78: aload_0
    //   79: ldc ''
    //   81: putfield k : Ljava/lang/String;
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield m : Z
    //   89: aconst_null
    //   90: astore #7
    //   92: aconst_null
    //   93: astore #6
    //   95: aload #6
    //   97: astore #5
    //   99: aload #7
    //   101: astore #4
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   108: invokevirtual c : (Landroid/content/Context;)Z
    //   111: ifne -> 127
    //   114: aload #6
    //   116: astore #5
    //   118: aload #7
    //   120: astore #4
    //   122: aload_0
    //   123: getfield j : I
    //   126: ireturn
    //   127: aload #6
    //   129: astore #5
    //   131: aload #7
    //   133: astore #4
    //   135: aload_1
    //   136: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   139: ldc_w 'content://com.tencent.tbs.debug/debugtbs'
    //   142: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   145: aconst_null
    //   146: aconst_null
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   152: astore #6
    //   154: aload #6
    //   156: ifnull -> 773
    //   159: aload #6
    //   161: astore #5
    //   163: aload #6
    //   165: astore #4
    //   167: aload #6
    //   169: invokeinterface getExtras : ()Landroid/os/Bundle;
    //   174: astore #9
    //   176: aload #9
    //   178: ifnonnull -> 202
    //   181: ldc_w 'bundle is null'
    //   184: astore_1
    //   185: aload #6
    //   187: astore #5
    //   189: aload #6
    //   191: astore #4
    //   193: ldc 'DebugTbsHelper'
    //   195: aload_1
    //   196: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   199: goto -> 780
    //   202: ldc ''
    //   204: astore #7
    //   206: ldc ''
    //   208: astore #8
    //   210: aload #6
    //   212: astore #5
    //   214: aload #6
    //   216: astore #4
    //   218: getstatic android/os/Build$VERSION.SDK_INT : I
    //   221: bipush #12
    //   223: if_icmplt -> 264
    //   226: aload #6
    //   228: astore #5
    //   230: aload #6
    //   232: astore #4
    //   234: aload #9
    //   236: ldc 'key_packagename'
    //   238: ldc ''
    //   240: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: astore #7
    //   245: aload #6
    //   247: astore #5
    //   249: aload #6
    //   251: astore #4
    //   253: aload #9
    //   255: ldc 'key_command'
    //   257: ldc ''
    //   259: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: astore #8
    //   264: aload #6
    //   266: astore #5
    //   268: aload #6
    //   270: astore #4
    //   272: new java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial <init> : ()V
    //   279: astore #9
    //   281: aload #6
    //   283: astore #5
    //   285: aload #6
    //   287: astore #4
    //   289: aload #9
    //   291: ldc_w 'getDebugInfo from tbssuit,targetApp:'
    //   294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload #6
    //   300: astore #5
    //   302: aload #6
    //   304: astore #4
    //   306: aload #9
    //   308: aload #7
    //   310: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload #6
    //   316: astore #5
    //   318: aload #6
    //   320: astore #4
    //   322: aload #9
    //   324: ldc_w ',cmpstr:'
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #6
    //   333: astore #5
    //   335: aload #6
    //   337: astore #4
    //   339: aload #9
    //   341: aload #8
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload #6
    //   349: astore #5
    //   351: aload #6
    //   353: astore #4
    //   355: ldc 'DebugTbsHelper'
    //   357: aload #9
    //   359: invokevirtual toString : ()Ljava/lang/String;
    //   362: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload #6
    //   367: astore #5
    //   369: aload #6
    //   371: astore #4
    //   373: ldc_w '所有应用'
    //   376: aload #7
    //   378: invokevirtual equals : (Ljava/lang/Object;)Z
    //   381: ifne -> 926
    //   384: aload #6
    //   386: astore #5
    //   388: aload #6
    //   390: astore #4
    //   392: aload #7
    //   394: aload_1
    //   395: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   398: invokevirtual getPackageName : ()Ljava/lang/String;
    //   401: invokevirtual equals : (Ljava/lang/Object;)Z
    //   404: ifeq -> 921
    //   407: goto -> 926
    //   410: aload #6
    //   412: astore #5
    //   414: aload #6
    //   416: astore #4
    //   418: aload #7
    //   420: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   423: ifne -> 569
    //   426: aload #6
    //   428: astore #5
    //   430: aload #6
    //   432: astore #4
    //   434: aload #8
    //   436: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   439: ifne -> 569
    //   442: iload_2
    //   443: ifne -> 449
    //   446: goto -> 569
    //   449: aload #6
    //   451: astore #5
    //   453: aload #6
    //   455: astore #4
    //   457: aload #8
    //   459: ldc 'cmdDebugtbs'
    //   461: invokevirtual equals : (Ljava/lang/Object;)Z
    //   464: ifeq -> 483
    //   467: aload #6
    //   469: astore #5
    //   471: aload #6
    //   473: astore #4
    //   475: aload_0
    //   476: iconst_1
    //   477: putfield g : Z
    //   480: goto -> 496
    //   483: aload #6
    //   485: astore #5
    //   487: aload #6
    //   489: astore #4
    //   491: aload_0
    //   492: iconst_0
    //   493: putfield g : Z
    //   496: aload #6
    //   498: astore #5
    //   500: aload #6
    //   502: astore #4
    //   504: aload_0
    //   505: iconst_1
    //   506: putfield m : Z
    //   509: aload #6
    //   511: astore #5
    //   513: aload #6
    //   515: astore #4
    //   517: aload_0
    //   518: new com/tencent/tbs/sdk/extension/partner/debugtbs/a$5
    //   521: dup
    //   522: aload_0
    //   523: aload_1
    //   524: aload #8
    //   526: invokespecial <init> : (Lcom/tencent/tbs/sdk/extension/partner/debugtbs/a;Landroid/content/Context;Ljava/lang/String;)V
    //   529: invokespecial a : (Ljava/lang/Runnable;)V
    //   532: aload #6
    //   534: astore #5
    //   536: aload #6
    //   538: astore #4
    //   540: aload_0
    //   541: getfield j : I
    //   544: istore_2
    //   545: aload #6
    //   547: ifnull -> 567
    //   550: aload #6
    //   552: invokeinterface isClosed : ()Z
    //   557: ifne -> 567
    //   560: aload #6
    //   562: invokeinterface close : ()V
    //   567: iload_2
    //   568: ireturn
    //   569: aload #6
    //   571: astore #5
    //   573: aload #6
    //   575: astore #4
    //   577: new java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial <init> : ()V
    //   584: astore_1
    //   585: aload #6
    //   587: astore #5
    //   589: aload #6
    //   591: astore #4
    //   593: aload_1
    //   594: ldc_w 'cmd empty or target not match  :'
    //   597: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload #6
    //   603: astore #5
    //   605: aload #6
    //   607: astore #4
    //   609: aload_1
    //   610: aload #7
    //   612: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload #6
    //   618: astore #5
    //   620: aload #6
    //   622: astore #4
    //   624: aload_1
    //   625: invokevirtual toString : ()Ljava/lang/String;
    //   628: pop
    //   629: aload #6
    //   631: astore #5
    //   633: aload #6
    //   635: astore #4
    //   637: aload_0
    //   638: iconst_4
    //   639: putfield j : I
    //   642: aload #6
    //   644: astore #5
    //   646: aload #6
    //   648: astore #4
    //   650: new java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial <init> : ()V
    //   657: astore_1
    //   658: aload #6
    //   660: astore #5
    //   662: aload #6
    //   664: astore #4
    //   666: aload_1
    //   667: ldc_w 'targetApp:'
    //   670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload #6
    //   676: astore #5
    //   678: aload #6
    //   680: astore #4
    //   682: aload_1
    //   683: aload #7
    //   685: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload #6
    //   691: astore #5
    //   693: aload #6
    //   695: astore #4
    //   697: aload_1
    //   698: ldc_w ',cmpstr:'
    //   701: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload #6
    //   707: astore #5
    //   709: aload #6
    //   711: astore #4
    //   713: aload_1
    //   714: aload #8
    //   716: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload #6
    //   722: astore #5
    //   724: aload #6
    //   726: astore #4
    //   728: aload_0
    //   729: aload_1
    //   730: invokevirtual toString : ()Ljava/lang/String;
    //   733: putfield k : Ljava/lang/String;
    //   736: aload #6
    //   738: astore #5
    //   740: aload #6
    //   742: astore #4
    //   744: aload_0
    //   745: getfield j : I
    //   748: istore_2
    //   749: aload #6
    //   751: ifnull -> 771
    //   754: aload #6
    //   756: invokeinterface isClosed : ()Z
    //   761: ifne -> 771
    //   764: aload #6
    //   766: invokeinterface close : ()V
    //   771: iload_2
    //   772: ireturn
    //   773: ldc_w 'cursor is null'
    //   776: astore_1
    //   777: goto -> 185
    //   780: aload #6
    //   782: ifnull -> 892
    //   785: aload #6
    //   787: invokeinterface isClosed : ()Z
    //   792: ifne -> 892
    //   795: aload #6
    //   797: astore #4
    //   799: goto -> 885
    //   802: astore_1
    //   803: goto -> 897
    //   806: astore_1
    //   807: aload #4
    //   809: astore #5
    //   811: aload_0
    //   812: bipush #6
    //   814: putfield j : I
    //   817: aload #4
    //   819: astore #5
    //   821: new java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial <init> : ()V
    //   828: astore #6
    //   830: aload #4
    //   832: astore #5
    //   834: aload #6
    //   836: ldc_w 'get contentprovider error :'
    //   839: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload #4
    //   845: astore #5
    //   847: aload #6
    //   849: aload_1
    //   850: invokevirtual toString : ()Ljava/lang/String;
    //   853: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload #4
    //   859: astore #5
    //   861: aload_0
    //   862: aload #6
    //   864: invokevirtual toString : ()Ljava/lang/String;
    //   867: putfield k : Ljava/lang/String;
    //   870: aload #4
    //   872: ifnull -> 892
    //   875: aload #4
    //   877: invokeinterface isClosed : ()Z
    //   882: ifne -> 892
    //   885: aload #4
    //   887: invokeinterface close : ()V
    //   892: aload_0
    //   893: getfield j : I
    //   896: ireturn
    //   897: aload #5
    //   899: ifnull -> 919
    //   902: aload #5
    //   904: invokeinterface isClosed : ()Z
    //   909: ifne -> 919
    //   912: aload #5
    //   914: invokeinterface close : ()V
    //   919: aload_1
    //   920: athrow
    //   921: iconst_0
    //   922: istore_2
    //   923: goto -> 410
    //   926: iconst_1
    //   927: istore_2
    //   928: goto -> 410
    // Exception table:
    //   from	to	target	type
    //   103	114	806	java/lang/Throwable
    //   103	114	802	finally
    //   122	127	806	java/lang/Throwable
    //   122	127	802	finally
    //   135	154	806	java/lang/Throwable
    //   135	154	802	finally
    //   167	176	806	java/lang/Throwable
    //   167	176	802	finally
    //   193	199	806	java/lang/Throwable
    //   193	199	802	finally
    //   218	226	806	java/lang/Throwable
    //   218	226	802	finally
    //   234	245	806	java/lang/Throwable
    //   234	245	802	finally
    //   253	264	806	java/lang/Throwable
    //   253	264	802	finally
    //   272	281	806	java/lang/Throwable
    //   272	281	802	finally
    //   289	298	806	java/lang/Throwable
    //   289	298	802	finally
    //   306	314	806	java/lang/Throwable
    //   306	314	802	finally
    //   322	331	806	java/lang/Throwable
    //   322	331	802	finally
    //   339	347	806	java/lang/Throwable
    //   339	347	802	finally
    //   355	365	806	java/lang/Throwable
    //   355	365	802	finally
    //   373	384	806	java/lang/Throwable
    //   373	384	802	finally
    //   392	407	806	java/lang/Throwable
    //   392	407	802	finally
    //   418	426	806	java/lang/Throwable
    //   418	426	802	finally
    //   434	442	806	java/lang/Throwable
    //   434	442	802	finally
    //   457	467	806	java/lang/Throwable
    //   457	467	802	finally
    //   475	480	806	java/lang/Throwable
    //   475	480	802	finally
    //   491	496	806	java/lang/Throwable
    //   491	496	802	finally
    //   504	509	806	java/lang/Throwable
    //   504	509	802	finally
    //   517	532	806	java/lang/Throwable
    //   517	532	802	finally
    //   540	545	806	java/lang/Throwable
    //   540	545	802	finally
    //   577	585	806	java/lang/Throwable
    //   577	585	802	finally
    //   593	601	806	java/lang/Throwable
    //   593	601	802	finally
    //   609	616	806	java/lang/Throwable
    //   609	616	802	finally
    //   624	629	806	java/lang/Throwable
    //   624	629	802	finally
    //   637	642	806	java/lang/Throwable
    //   637	642	802	finally
    //   650	658	806	java/lang/Throwable
    //   650	658	802	finally
    //   666	674	806	java/lang/Throwable
    //   666	674	802	finally
    //   682	689	806	java/lang/Throwable
    //   682	689	802	finally
    //   697	705	806	java/lang/Throwable
    //   697	705	802	finally
    //   713	720	806	java/lang/Throwable
    //   713	720	802	finally
    //   728	736	806	java/lang/Throwable
    //   728	736	802	finally
    //   744	749	806	java/lang/Throwable
    //   744	749	802	finally
    //   811	817	802	finally
    //   821	830	802	finally
    //   834	843	802	finally
    //   847	857	802	finally
    //   861	870	802	finally
  }
  
  boolean b() {
    return (Looper.getMainLooper().getThread() == Thread.currentThread());
  }
  
  public int c() {
    return this.j;
  }
  
  boolean c(Context paramContext) {
    System.currentTimeMillis();
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.tencent.tbssuite", 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException = null;
    } 
    if (nameNotFoundException == null) {
      this.j = 1;
      return false;
    } 
    try {
      String str = (paramContext.getPackageManager().getPackageInfo("com.tencent.tbssuite", 64)).signatures[0].toCharsString();
      boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("vertificateDemo getSign ");
      stringBuilder.append(bool);
      stringBuilder.append(":");
      stringBuilder.append(str);
      stringBuilder.toString();
      if (!bool) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("vertificateDemo DEMO_SIG is wrong:");
        stringBuilder.append(str);
        stringBuilder.toString();
        Toast.makeText(paramContext, "tbssuit sig is wrong!!!", 1).show();
        this.j = 2;
        return false;
      } 
      return true;
    } catch (Throwable throwable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("vertificateTbsSuite SUITE_SIG failed:");
      stringBuilder.append(throwable.toString());
      stringBuilder.toString();
      this.j = 3;
      this.k = throwable.getMessage();
      return false;
    } 
  }
  
  public String d() {
    return this.k;
  }
  
  public boolean e() {
    return this.m;
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int);
    
    void a(Throwable param1Throwable);
  }
  
  private static class b {
    private static final a a = new a();
    
    static {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static interface c {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\debugtbs\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */