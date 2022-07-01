package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.TokenBindingService;
import android.webkit.TracingController;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.webkit.WebViewDelegate;
import android.webkit.WebViewFactoryProvider;
import android.webkit.WebViewProvider;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import org.chromium.android_webview.AwAutofillProvider;
import org.chromium.android_webview.ScopedSysTraceEvent;
import org.chromium.android_webview.WebViewChromiumRunQueue;
import org.chromium.base.StrictModeContext;
import org.chromium.base.library_loader.NativeLibraries;
import org.chromium.components.autofill.AutofillProvider;

public class WebViewChromiumFactoryProvider implements WebViewFactoryProvider {
  private static WebViewChromiumFactoryProvider sSingleton;
  
  private static final Object sSingletonLock = new Object();
  
  public WebViewChromiumAwInit mAwInit;
  
  final WebViewChromiumRunQueue mRunQueue = new WebViewChromiumRunQueue(new WebViewChromiumFactoryProvider$$Lambda$0(this));
  
  private Object mServiceWorkerControllerAdapter;
  
  private boolean mShouldDisableThreadChecking;
  
  private WebViewFactoryProvider.Statics mStaticsAdapter;
  
  private TracingController mTracingController;
  
  WebViewDelegateFactory$WebViewDelegate mWebViewDelegate;
  
  SharedPreferences mWebViewPrefs;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public WebViewChromiumFactoryProvider() {
    initialize(new WebViewDelegateFactory$Api21CompatibilityDelegate());
  }
  
  public WebViewChromiumFactoryProvider(WebViewDelegate paramWebViewDelegate) {
    initialize(new WebViewDelegateFactory$ProxyDelegate(paramWebViewDelegate));
  }
  
  static void checkStorageIsNotDeviceProtected(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 24) {
      if (!paramContext.isDeviceProtectedStorage())
        return; 
      throw new IllegalArgumentException("WebView cannot be used with device protected storage");
    } 
  }
  
  public static WebViewChromiumFactoryProvider create(WebViewDelegate paramWebViewDelegate) {
    return new WebViewChromiumFactoryProvider(paramWebViewDelegate);
  }
  
  static AutofillProvider createAutofillProvider(Context paramContext, ViewGroup paramViewGroup) {
    return (AutofillProvider)((Build.VERSION.SDK_INT < 26) ? null : new AwAutofillProvider(paramContext, paramViewGroup));
  }
  
  private WebViewChromiumAwInit createAwInit() {
    Throwable throwable2;
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("WebViewChromiumFactoryProvider.createAwInit");
    Throwable throwable1 = null;
    try {
      WebViewChromiumAwInit webViewChromiumAwInit = new WebViewChromiumAwInit(this);
      if (scopedSysTraceEvent != null)
        $closeResource((Throwable)null, scopedSysTraceEvent); 
      return webViewChromiumAwInit;
    } catch (Throwable null) {
      throwable1 = throwable2;
      throw throwable2;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable1, scopedSysTraceEvent); 
    throw throwable2;
  }
  
  private static void deleteContents(File paramFile) {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null) {
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++) {
        File file = arrayOfFile[i];
        if (file.isDirectory())
          deleteContents(file); 
        if (!file.delete()) {
          StringBuilder stringBuilder = new StringBuilder("Failed to delete ");
          stringBuilder.append(file);
          Log.w("WebViewChromiumFactoryProvider", stringBuilder.toString());
        } 
      } 
    } 
  }
  
  public static WebViewChromiumFactoryProvider getSingleton() {
    synchronized (sSingletonLock) {
      if (sSingleton != null)
        return sSingleton; 
      throw new RuntimeException("WebViewChromiumFactoryProvider has not been set!");
    } 
  }
  
  @TargetApi(24)
  private void initialize(WebViewDelegateFactory$WebViewDelegate paramWebViewDelegateFactory$WebViewDelegate) {
    // Byte code:
    //   0: invokestatic elapsedRealtime : ()J
    //   3: lstore #5
    //   5: ldc 'WebViewChromiumFactoryProvider.initialize'
    //   7: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   10: astore #13
    //   12: aconst_null
    //   13: astore #11
    //   15: aload #11
    //   17: astore #9
    //   19: ldc 'WebViewChromiumFactoryProvider.getLoadedPackageInfo'
    //   21: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   24: astore #12
    //   26: invokestatic getLoadedPackageInfo : ()Landroid/content/pm/PackageInfo;
    //   29: astore #14
    //   31: aload #12
    //   33: ifnull -> 46
    //   36: aload #11
    //   38: astore #9
    //   40: aconst_null
    //   41: aload #12
    //   43: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   46: aload #11
    //   48: astore #9
    //   50: aload #14
    //   52: getfield packageName : Ljava/lang/String;
    //   55: invokestatic setWebViewPackageName : (Ljava/lang/String;)V
    //   58: aload #11
    //   60: astore #9
    //   62: aload_0
    //   63: aload_0
    //   64: invokespecial createAwInit : ()Lcom/android/webview/chromium/WebViewChromiumAwInit;
    //   67: putfield mAwInit : Lcom/android/webview/chromium/WebViewChromiumAwInit;
    //   70: aload #11
    //   72: astore #9
    //   74: aload_0
    //   75: aload_1
    //   76: putfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   79: aload #11
    //   81: astore #9
    //   83: aload_0
    //   84: getfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   87: invokeinterface getApplication : ()Landroid/app/Application;
    //   92: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   95: astore #12
    //   97: aload #11
    //   99: astore #9
    //   101: ldc 'WebViewChromiumFactoryProvider.checkStorage'
    //   103: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   106: astore #15
    //   108: aload_0
    //   109: getfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   112: invokeinterface getApplication : ()Landroid/app/Application;
    //   117: invokestatic checkStorageIsNotDeviceProtected : (Landroid/content/Context;)V
    //   120: aload #15
    //   122: ifnull -> 141
    //   125: aload #11
    //   127: astore #9
    //   129: aconst_null
    //   130: aload #15
    //   132: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   135: aload #12
    //   137: astore_1
    //   138: goto -> 250
    //   141: aload #12
    //   143: astore_1
    //   144: goto -> 250
    //   147: astore_1
    //   148: aconst_null
    //   149: astore #10
    //   151: goto -> 160
    //   154: astore #10
    //   156: aload #10
    //   158: athrow
    //   159: astore_1
    //   160: aload #15
    //   162: ifnull -> 176
    //   165: aload #11
    //   167: astore #9
    //   169: aload #10
    //   171: aload #15
    //   173: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   176: aload #11
    //   178: astore #9
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload #11
    //   185: astore #9
    //   187: getstatic com/android/webview/chromium/WebViewChromiumFactoryProvider.$assertionsDisabled : Z
    //   190: ifne -> 220
    //   193: aload #11
    //   195: astore #9
    //   197: getstatic android/os/Build$VERSION.SDK_INT : I
    //   200: bipush #24
    //   202: if_icmplt -> 208
    //   205: goto -> 220
    //   208: aload #11
    //   210: astore #9
    //   212: new java/lang/AssertionError
    //   215: dup
    //   216: invokespecial <init> : ()V
    //   219: athrow
    //   220: aload #11
    //   222: astore #9
    //   224: aload #12
    //   226: ldc android/os/UserManager
    //   228: invokevirtual getSystemService : (Ljava/lang/Class;)Ljava/lang/Object;
    //   231: checkcast android/os/UserManager
    //   234: invokevirtual isUserUnlocked : ()Z
    //   237: ifeq -> 1307
    //   240: aload #11
    //   242: astore #9
    //   244: aload #12
    //   246: invokevirtual createCredentialProtectedStorageContext : ()Landroid/content/Context;
    //   249: astore_1
    //   250: aload #11
    //   252: astore #9
    //   254: aload_1
    //   255: invokestatic get : (Landroid/content/Context;)Landroid/content/Context;
    //   258: invokestatic initApplicationContext : (Landroid/content/Context;)V
    //   261: aload #11
    //   263: astore #9
    //   265: aload_0
    //   266: getfield mAwInit : Lcom/android/webview/chromium/WebViewChromiumAwInit;
    //   269: astore_1
    //   270: aload #11
    //   272: astore #9
    //   274: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   277: astore #10
    //   279: aload #11
    //   281: astore #9
    //   283: ldc_w 'WebViewChromiumAwInit.setUpResourcesOnBackgroundThread'
    //   286: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   289: astore #12
    //   291: getstatic com/android/webview/chromium/WebViewChromiumAwInit.$assertionsDisabled : Z
    //   294: ifne -> 318
    //   297: aload_1
    //   298: getfield mSetUpResourcesThread : Ljava/lang/Thread;
    //   301: ifnonnull -> 307
    //   304: goto -> 318
    //   307: new java/lang/AssertionError
    //   310: dup
    //   311: ldc_w 'This method shouldn't be called twice.'
    //   314: invokespecial <init> : (Ljava/lang/Object;)V
    //   317: athrow
    //   318: aload_1
    //   319: new java/lang/Thread
    //   322: dup
    //   323: new com/android/webview/chromium/WebViewChromiumAwInit$2
    //   326: dup
    //   327: aload_1
    //   328: aload #14
    //   330: aload #10
    //   332: invokespecial <init> : (Lcom/android/webview/chromium/WebViewChromiumAwInit;Landroid/content/pm/PackageInfo;Landroid/content/Context;)V
    //   335: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   338: putfield mSetUpResourcesThread : Ljava/lang/Thread;
    //   341: aload_1
    //   342: getfield mSetUpResourcesThread : Ljava/lang/Thread;
    //   345: invokevirtual start : ()V
    //   348: aload #12
    //   350: ifnull -> 363
    //   353: aload #11
    //   355: astore #9
    //   357: aconst_null
    //   358: aload #12
    //   360: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   363: aload #11
    //   365: astore #9
    //   367: ldc_w 'WebViewChromiumFactoryProvider.initCommandLine'
    //   370: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   373: astore #12
    //   375: invokestatic initCommandLine : ()V
    //   378: aload #12
    //   380: ifnull -> 393
    //   383: aload #11
    //   385: astore #9
    //   387: aconst_null
    //   388: aload #12
    //   390: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   393: aload #11
    //   395: astore #9
    //   397: getstatic android/os/Build$VERSION.SDK_INT : I
    //   400: istore_2
    //   401: iconst_0
    //   402: istore #8
    //   404: iload_2
    //   405: bipush #26
    //   407: if_icmplt -> 428
    //   410: aload #11
    //   412: astore #9
    //   414: aload_0
    //   415: getfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   418: invokeinterface isMultiProcessEnabled : ()Z
    //   423: istore #7
    //   425: goto -> 467
    //   428: aload #11
    //   430: astore #9
    //   432: getstatic android/os/Build$VERSION.SDK_INT : I
    //   435: bipush #24
    //   437: if_icmplt -> 1372
    //   440: aload #11
    //   442: astore #9
    //   444: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   447: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   450: ldc_w 'webview_multiprocess'
    //   453: iconst_0
    //   454: invokestatic getInt : (Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   457: iconst_1
    //   458: if_icmpne -> 1372
    //   461: iconst_1
    //   462: istore #7
    //   464: goto -> 467
    //   467: iload #7
    //   469: ifeq -> 485
    //   472: aload #11
    //   474: astore #9
    //   476: invokestatic getInstance : ()Lorg/chromium/base/CommandLine;
    //   479: ldc_w 'webview-sandboxed-renderer'
    //   482: invokevirtual appendSwitch : (Ljava/lang/String;)V
    //   485: aload #11
    //   487: astore #9
    //   489: invokestatic setWillOverrideUiThread : ()V
    //   492: aload #11
    //   494: astore #9
    //   496: aload #14
    //   498: invokestatic setBrowserPackageInfo : (Landroid/content/pm/PackageInfo;)V
    //   501: aload #11
    //   503: astore #9
    //   505: invokestatic allowDiskWrites : ()Lorg/chromium/base/StrictModeContext;
    //   508: astore #12
    //   510: ldc_w 'WebViewChromiumFactoryProvider.loadChromiumLibrary'
    //   513: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   516: astore #10
    //   518: getstatic android/os/Build$VERSION.SDK_INT : I
    //   521: bipush #28
    //   523: if_icmplt -> 1378
    //   526: aload_0
    //   527: getfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   530: invokeinterface getDataDirectorySuffix : ()Ljava/lang/String;
    //   535: astore_1
    //   536: goto -> 539
    //   539: aload_1
    //   540: invokestatic loadLibrary : (Ljava/lang/String;)V
    //   543: aload #10
    //   545: ifnull -> 554
    //   548: aconst_null
    //   549: aload #10
    //   551: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   554: ldc_w 'WebViewChromiumFactoryProvider.loadGlueLayerPlatSupportLibrary'
    //   557: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   560: astore #10
    //   562: ldc_w 'webviewchromium_plat_support'
    //   565: invokestatic loadLibrary : (Ljava/lang/String;)V
    //   568: aload #10
    //   570: ifnull -> 579
    //   573: aconst_null
    //   574: aload #10
    //   576: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   579: ldc_w 'WebViewChromiumFactoryProvider.deleteContentsOnPackageDowngrade'
    //   582: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   585: astore #10
    //   587: aload_0
    //   588: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   591: ldc_w 'WebViewChromiumPrefs'
    //   594: iconst_0
    //   595: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   598: putfield mWebViewPrefs : Landroid/content/SharedPreferences;
    //   601: aload_0
    //   602: getfield mWebViewPrefs : Landroid/content/SharedPreferences;
    //   605: ldc_w 'lastVersionCodeUsed'
    //   608: iconst_0
    //   609: invokeinterface getInt : (Ljava/lang/String;I)I
    //   614: istore_3
    //   615: aload #14
    //   617: getfield versionCode : I
    //   620: istore #4
    //   622: iload #4
    //   624: ldc_w 100000
    //   627: idiv
    //   628: iload_3
    //   629: ldc_w 100000
    //   632: idiv
    //   633: if_icmplt -> 1383
    //   636: iconst_1
    //   637: istore_2
    //   638: goto -> 641
    //   641: iload_2
    //   642: ifne -> 723
    //   645: invokestatic getDataDirectory : ()Ljava/lang/String;
    //   648: astore_1
    //   649: new java/lang/StringBuilder
    //   652: dup
    //   653: ldc_w 'WebView package downgraded from '
    //   656: invokespecial <init> : (Ljava/lang/String;)V
    //   659: astore #9
    //   661: aload #9
    //   663: iload_3
    //   664: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload #9
    //   670: ldc_w ' to '
    //   673: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload #9
    //   679: iload #4
    //   681: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload #9
    //   687: ldc_w '; deleting contents of '
    //   690: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload #9
    //   696: aload_1
    //   697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: ldc 'WebViewChromiumFactoryProvider'
    //   703: aload #9
    //   705: invokevirtual toString : ()Ljava/lang/String;
    //   708: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   711: pop
    //   712: new java/io/File
    //   715: dup
    //   716: aload_1
    //   717: invokespecial <init> : (Ljava/lang/String;)V
    //   720: invokestatic deleteContents : (Ljava/io/File;)V
    //   723: iload_3
    //   724: iload #4
    //   726: if_icmpeq -> 753
    //   729: aload_0
    //   730: getfield mWebViewPrefs : Landroid/content/SharedPreferences;
    //   733: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   738: ldc_w 'lastVersionCodeUsed'
    //   741: iload #4
    //   743: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   748: invokeinterface apply : ()V
    //   753: aload #10
    //   755: ifnull -> 764
    //   758: aconst_null
    //   759: aload #10
    //   761: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   764: aload #12
    //   766: ifnull -> 779
    //   769: aload #11
    //   771: astore #9
    //   773: aconst_null
    //   774: aload #12
    //   776: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/base/StrictModeContext;)V
    //   779: aload #11
    //   781: astore #9
    //   783: aload_0
    //   784: getfield mAwInit : Lcom/android/webview/chromium/WebViewChromiumAwInit;
    //   787: invokevirtual startVariationsInit : ()V
    //   790: aload #11
    //   792: astore #9
    //   794: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   797: astore #10
    //   799: aload #11
    //   801: astore #9
    //   803: aload #10
    //   805: invokevirtual getPackageName : ()Ljava/lang/String;
    //   808: astore_1
    //   809: aload #11
    //   811: astore #9
    //   813: aload #10
    //   815: aload_1
    //   816: invokestatic getPackageVersion : (Landroid/content/Context;Ljava/lang/String;)I
    //   819: istore_3
    //   820: aload #11
    //   822: astore #9
    //   824: aload #10
    //   826: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   829: getfield targetSdkVersion : I
    //   832: istore #4
    //   834: iload_3
    //   835: iconst_m1
    //   836: if_icmpne -> 846
    //   839: iload #8
    //   841: istore #7
    //   843: goto -> 1029
    //   846: aload #11
    //   848: astore #9
    //   850: ldc_w 'com.lge.email'
    //   853: aload_1
    //   854: invokevirtual equals : (Ljava/lang/Object;)Z
    //   857: ifeq -> 1419
    //   860: iload #4
    //   862: bipush #24
    //   864: if_icmple -> 1388
    //   867: iload #8
    //   869: istore #7
    //   871: goto -> 1029
    //   874: aload #11
    //   876: astore #9
    //   878: aload_1
    //   879: ldc_w 'com.yahoo.mobile.client.android.mail'
    //   882: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   885: ifeq -> 902
    //   888: iload #4
    //   890: bipush #23
    //   892: if_icmple -> 1425
    //   895: iload #8
    //   897: istore #7
    //   899: goto -> 1029
    //   902: aload #11
    //   904: astore #9
    //   906: ldc_w 'com.htc.android.mail'
    //   909: aload_1
    //   910: invokevirtual equals : (Ljava/lang/Object;)Z
    //   913: ifeq -> 1465
    //   916: iload #4
    //   918: bipush #23
    //   920: if_icmple -> 1445
    //   923: iload #8
    //   925: istore #7
    //   927: goto -> 1029
    //   930: iload #7
    //   932: ifeq -> 1468
    //   935: aload #11
    //   937: astore #9
    //   939: new java/lang/StringBuilder
    //   942: dup
    //   943: ldc_w 'Disabling thread check in WebView. APK name: '
    //   946: invokespecial <init> : (Ljava/lang/String;)V
    //   949: astore #10
    //   951: aload #11
    //   953: astore #9
    //   955: aload #10
    //   957: aload_1
    //   958: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: aload #11
    //   964: astore #9
    //   966: aload #10
    //   968: ldc_w ', versionCode: '
    //   971: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload #11
    //   977: astore #9
    //   979: aload #10
    //   981: iload_3
    //   982: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   985: pop
    //   986: aload #11
    //   988: astore #9
    //   990: aload #10
    //   992: ldc_w ', targetSdkVersion: '
    //   995: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: aload #11
    //   1001: astore #9
    //   1003: aload #10
    //   1005: iload #4
    //   1007: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload #11
    //   1013: astore #9
    //   1015: ldc 'WebViewChromiumFactoryProvider'
    //   1017: aload #10
    //   1019: invokevirtual toString : ()Ljava/lang/String;
    //   1022: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   1025: pop
    //   1026: goto -> 1468
    //   1029: aload #11
    //   1031: astore #9
    //   1033: aload_0
    //   1034: iload #7
    //   1036: putfield mShouldDisableThreadChecking : Z
    //   1039: aload #11
    //   1041: astore #9
    //   1043: getstatic com/android/webview/chromium/WebViewChromiumFactoryProvider.sSingletonLock : Ljava/lang/Object;
    //   1046: astore_1
    //   1047: aload #11
    //   1049: astore #9
    //   1051: aload_1
    //   1052: monitorenter
    //   1053: getstatic com/android/webview/chromium/WebViewChromiumFactoryProvider.sSingleton : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   1056: ifnonnull -> 1099
    //   1059: aload_0
    //   1060: putstatic com/android/webview/chromium/WebViewChromiumFactoryProvider.sSingleton : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   1063: aload_1
    //   1064: monitorexit
    //   1065: aload #13
    //   1067: ifnull -> 1076
    //   1070: aconst_null
    //   1071: aload #13
    //   1073: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1076: new org/chromium/base/metrics/CachedMetrics$TimesHistogramSample
    //   1079: dup
    //   1080: ldc_w 'Android.WebView.Startup.CreationTime.Stage1.FactoryInit'
    //   1083: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   1086: invokespecial <init> : (Ljava/lang/String;Ljava/util/concurrent/TimeUnit;)V
    //   1089: invokestatic elapsedRealtime : ()J
    //   1092: lload #5
    //   1094: lsub
    //   1095: invokevirtual record : (J)V
    //   1098: return
    //   1099: new java/lang/RuntimeException
    //   1102: dup
    //   1103: ldc_w 'WebViewChromiumFactoryProvider should only be set once!'
    //   1106: invokespecial <init> : (Ljava/lang/String;)V
    //   1109: athrow
    //   1110: astore #10
    //   1112: aload_1
    //   1113: monitorexit
    //   1114: aload #11
    //   1116: astore #9
    //   1118: aload #10
    //   1120: athrow
    //   1121: astore_1
    //   1122: aconst_null
    //   1123: astore #9
    //   1125: goto -> 1134
    //   1128: astore #9
    //   1130: aload #9
    //   1132: athrow
    //   1133: astore_1
    //   1134: aload #10
    //   1136: ifnull -> 1146
    //   1139: aload #9
    //   1141: aload #10
    //   1143: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1146: aload_1
    //   1147: athrow
    //   1148: astore_1
    //   1149: aconst_null
    //   1150: astore #9
    //   1152: goto -> 1161
    //   1155: astore #9
    //   1157: aload #9
    //   1159: athrow
    //   1160: astore_1
    //   1161: aload #10
    //   1163: ifnull -> 1173
    //   1166: aload #9
    //   1168: aload #10
    //   1170: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1173: aload_1
    //   1174: athrow
    //   1175: astore_1
    //   1176: aconst_null
    //   1177: astore #9
    //   1179: goto -> 1188
    //   1182: astore #9
    //   1184: aload #9
    //   1186: athrow
    //   1187: astore_1
    //   1188: aload #10
    //   1190: ifnull -> 1200
    //   1193: aload #9
    //   1195: aload #10
    //   1197: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1200: aload_1
    //   1201: athrow
    //   1202: astore_1
    //   1203: aconst_null
    //   1204: astore #10
    //   1206: goto -> 1215
    //   1209: astore #10
    //   1211: aload #10
    //   1213: athrow
    //   1214: astore_1
    //   1215: aload #12
    //   1217: ifnull -> 1231
    //   1220: aload #11
    //   1222: astore #9
    //   1224: aload #10
    //   1226: aload #12
    //   1228: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/base/StrictModeContext;)V
    //   1231: aload #11
    //   1233: astore #9
    //   1235: aload_1
    //   1236: athrow
    //   1237: astore_1
    //   1238: aconst_null
    //   1239: astore #10
    //   1241: goto -> 1250
    //   1244: astore #10
    //   1246: aload #10
    //   1248: athrow
    //   1249: astore_1
    //   1250: aload #12
    //   1252: ifnull -> 1266
    //   1255: aload #11
    //   1257: astore #9
    //   1259: aload #10
    //   1261: aload #12
    //   1263: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1266: aload #11
    //   1268: astore #9
    //   1270: aload_1
    //   1271: athrow
    //   1272: astore_1
    //   1273: aconst_null
    //   1274: astore #10
    //   1276: goto -> 1285
    //   1279: astore #10
    //   1281: aload #10
    //   1283: athrow
    //   1284: astore_1
    //   1285: aload #12
    //   1287: ifnull -> 1301
    //   1290: aload #11
    //   1292: astore #9
    //   1294: aload #10
    //   1296: aload #12
    //   1298: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1301: aload #11
    //   1303: astore #9
    //   1305: aload_1
    //   1306: athrow
    //   1307: aload #11
    //   1309: astore #9
    //   1311: aload_1
    //   1312: athrow
    //   1313: astore_1
    //   1314: aconst_null
    //   1315: astore #10
    //   1317: goto -> 1326
    //   1320: astore #10
    //   1322: aload #10
    //   1324: athrow
    //   1325: astore_1
    //   1326: aload #12
    //   1328: ifnull -> 1342
    //   1331: aload #11
    //   1333: astore #9
    //   1335: aload #10
    //   1337: aload #12
    //   1339: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1342: aload #11
    //   1344: astore #9
    //   1346: aload_1
    //   1347: athrow
    //   1348: astore_1
    //   1349: goto -> 1358
    //   1352: astore_1
    //   1353: aload_1
    //   1354: astore #9
    //   1356: aload_1
    //   1357: athrow
    //   1358: aload #13
    //   1360: ifnull -> 1370
    //   1363: aload #9
    //   1365: aload #13
    //   1367: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   1370: aload_1
    //   1371: athrow
    //   1372: iconst_0
    //   1373: istore #7
    //   1375: goto -> 467
    //   1378: aconst_null
    //   1379: astore_1
    //   1380: goto -> 539
    //   1383: iconst_0
    //   1384: istore_2
    //   1385: goto -> 641
    //   1388: iload_3
    //   1389: ldc_w 67502100
    //   1392: if_icmple -> 1400
    //   1395: iconst_1
    //   1396: istore_2
    //   1397: goto -> 1402
    //   1400: iconst_0
    //   1401: istore_2
    //   1402: iload_2
    //   1403: ifeq -> 1413
    //   1406: iload #8
    //   1408: istore #7
    //   1410: goto -> 1029
    //   1413: iconst_1
    //   1414: istore #7
    //   1416: goto -> 874
    //   1419: iconst_0
    //   1420: istore #7
    //   1422: goto -> 874
    //   1425: iload_3
    //   1426: ldc_w 1315850
    //   1429: if_icmple -> 1439
    //   1432: iload #8
    //   1434: istore #7
    //   1436: goto -> 1029
    //   1439: iconst_1
    //   1440: istore #7
    //   1442: goto -> 902
    //   1445: iload_3
    //   1446: ldc_w 866001861
    //   1449: if_icmplt -> 1459
    //   1452: iload #8
    //   1454: istore #7
    //   1456: goto -> 1029
    //   1459: iconst_1
    //   1460: istore #7
    //   1462: goto -> 930
    //   1465: goto -> 930
    //   1468: goto -> 1029
    // Exception table:
    //   from	to	target	type
    //   19	26	1352	java/lang/Throwable
    //   19	26	1348	finally
    //   26	31	1320	java/lang/Throwable
    //   26	31	1313	finally
    //   40	46	1352	java/lang/Throwable
    //   40	46	1348	finally
    //   50	58	1352	java/lang/Throwable
    //   50	58	1348	finally
    //   62	70	1352	java/lang/Throwable
    //   62	70	1348	finally
    //   74	79	1352	java/lang/Throwable
    //   74	79	1348	finally
    //   83	97	1352	java/lang/Throwable
    //   83	97	1348	finally
    //   101	108	182	java/lang/IllegalArgumentException
    //   101	108	1352	java/lang/Throwable
    //   101	108	1348	finally
    //   108	120	154	java/lang/Throwable
    //   108	120	147	finally
    //   129	135	182	java/lang/IllegalArgumentException
    //   129	135	1352	java/lang/Throwable
    //   129	135	1348	finally
    //   156	159	159	finally
    //   169	176	182	java/lang/IllegalArgumentException
    //   169	176	1352	java/lang/Throwable
    //   169	176	1348	finally
    //   180	182	182	java/lang/IllegalArgumentException
    //   180	182	1352	java/lang/Throwable
    //   180	182	1348	finally
    //   187	193	1352	java/lang/Throwable
    //   187	193	1348	finally
    //   197	205	1352	java/lang/Throwable
    //   197	205	1348	finally
    //   212	220	1352	java/lang/Throwable
    //   212	220	1348	finally
    //   224	240	1352	java/lang/Throwable
    //   224	240	1348	finally
    //   244	250	1352	java/lang/Throwable
    //   244	250	1348	finally
    //   254	261	1352	java/lang/Throwable
    //   254	261	1348	finally
    //   265	270	1352	java/lang/Throwable
    //   265	270	1348	finally
    //   274	279	1352	java/lang/Throwable
    //   274	279	1348	finally
    //   283	291	1352	java/lang/Throwable
    //   283	291	1348	finally
    //   291	304	1279	java/lang/Throwable
    //   291	304	1272	finally
    //   307	318	1279	java/lang/Throwable
    //   307	318	1272	finally
    //   318	348	1279	java/lang/Throwable
    //   318	348	1272	finally
    //   357	363	1352	java/lang/Throwable
    //   357	363	1348	finally
    //   367	375	1352	java/lang/Throwable
    //   367	375	1348	finally
    //   375	378	1244	java/lang/Throwable
    //   375	378	1237	finally
    //   387	393	1352	java/lang/Throwable
    //   387	393	1348	finally
    //   397	401	1352	java/lang/Throwable
    //   397	401	1348	finally
    //   414	425	1352	java/lang/Throwable
    //   414	425	1348	finally
    //   432	440	1352	java/lang/Throwable
    //   432	440	1348	finally
    //   444	461	1352	java/lang/Throwable
    //   444	461	1348	finally
    //   476	485	1352	java/lang/Throwable
    //   476	485	1348	finally
    //   489	492	1352	java/lang/Throwable
    //   489	492	1348	finally
    //   496	501	1352	java/lang/Throwable
    //   496	501	1348	finally
    //   505	510	1352	java/lang/Throwable
    //   505	510	1348	finally
    //   510	518	1209	java/lang/Throwable
    //   510	518	1202	finally
    //   518	536	1182	java/lang/Throwable
    //   518	536	1175	finally
    //   539	543	1182	java/lang/Throwable
    //   539	543	1175	finally
    //   548	554	1209	java/lang/Throwable
    //   548	554	1202	finally
    //   554	562	1209	java/lang/Throwable
    //   554	562	1202	finally
    //   562	568	1155	java/lang/Throwable
    //   562	568	1148	finally
    //   573	579	1209	java/lang/Throwable
    //   573	579	1202	finally
    //   579	587	1209	java/lang/Throwable
    //   579	587	1202	finally
    //   587	636	1128	java/lang/Throwable
    //   587	636	1121	finally
    //   645	723	1128	java/lang/Throwable
    //   645	723	1121	finally
    //   729	753	1128	java/lang/Throwable
    //   729	753	1121	finally
    //   758	764	1209	java/lang/Throwable
    //   758	764	1202	finally
    //   773	779	1352	java/lang/Throwable
    //   773	779	1348	finally
    //   783	790	1352	java/lang/Throwable
    //   783	790	1348	finally
    //   794	799	1352	java/lang/Throwable
    //   794	799	1348	finally
    //   803	809	1352	java/lang/Throwable
    //   803	809	1348	finally
    //   813	820	1352	java/lang/Throwable
    //   813	820	1348	finally
    //   824	834	1352	java/lang/Throwable
    //   824	834	1348	finally
    //   850	860	1352	java/lang/Throwable
    //   850	860	1348	finally
    //   878	888	1352	java/lang/Throwable
    //   878	888	1348	finally
    //   906	916	1352	java/lang/Throwable
    //   906	916	1348	finally
    //   939	951	1352	java/lang/Throwable
    //   939	951	1348	finally
    //   955	962	1352	java/lang/Throwable
    //   955	962	1348	finally
    //   966	975	1352	java/lang/Throwable
    //   966	975	1348	finally
    //   979	986	1352	java/lang/Throwable
    //   979	986	1348	finally
    //   990	999	1352	java/lang/Throwable
    //   990	999	1348	finally
    //   1003	1011	1352	java/lang/Throwable
    //   1003	1011	1348	finally
    //   1015	1026	1352	java/lang/Throwable
    //   1015	1026	1348	finally
    //   1033	1039	1352	java/lang/Throwable
    //   1033	1039	1348	finally
    //   1043	1047	1352	java/lang/Throwable
    //   1043	1047	1348	finally
    //   1051	1053	1352	java/lang/Throwable
    //   1051	1053	1348	finally
    //   1053	1065	1110	finally
    //   1099	1110	1110	finally
    //   1112	1114	1110	finally
    //   1118	1121	1352	java/lang/Throwable
    //   1118	1121	1348	finally
    //   1130	1133	1133	finally
    //   1139	1146	1209	java/lang/Throwable
    //   1139	1146	1202	finally
    //   1146	1148	1209	java/lang/Throwable
    //   1146	1148	1202	finally
    //   1157	1160	1160	finally
    //   1166	1173	1209	java/lang/Throwable
    //   1166	1173	1202	finally
    //   1173	1175	1209	java/lang/Throwable
    //   1173	1175	1202	finally
    //   1184	1187	1187	finally
    //   1193	1200	1209	java/lang/Throwable
    //   1193	1200	1202	finally
    //   1200	1202	1209	java/lang/Throwable
    //   1200	1202	1202	finally
    //   1211	1214	1214	finally
    //   1224	1231	1352	java/lang/Throwable
    //   1224	1231	1348	finally
    //   1235	1237	1352	java/lang/Throwable
    //   1235	1237	1348	finally
    //   1246	1249	1249	finally
    //   1259	1266	1352	java/lang/Throwable
    //   1259	1266	1348	finally
    //   1270	1272	1352	java/lang/Throwable
    //   1270	1272	1348	finally
    //   1281	1284	1284	finally
    //   1294	1301	1352	java/lang/Throwable
    //   1294	1301	1348	finally
    //   1305	1307	1352	java/lang/Throwable
    //   1305	1307	1348	finally
    //   1311	1313	1352	java/lang/Throwable
    //   1311	1313	1348	finally
    //   1322	1325	1325	finally
    //   1335	1342	1352	java/lang/Throwable
    //   1335	1342	1348	finally
    //   1346	1348	1352	java/lang/Throwable
    //   1346	1348	1348	finally
    //   1356	1358	1348	finally
  }
  
  public static boolean preloadInZygote() {
    String[] arrayOfString = NativeLibraries.LIBRARIES;
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++)
      System.loadLibrary(arrayOfString[i]); 
    return true;
  }
  
  final void addTask(Runnable paramRunnable) {
    this.mRunQueue.addTask(paramRunnable);
  }
  
  public WebViewProvider createWebView(WebView paramWebView, WebView.PrivateAccess paramPrivateAccess) {
    return new WebViewChromium(this, paramWebView, paramPrivateAccess, this.mShouldDisableThreadChecking);
  }
  
  final WebViewContentsClientAdapter createWebViewContentsClientAdapter(WebView paramWebView, Context paramContext) {
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("WebViewChromiumFactoryProvider.insideCreateWebViewContentsClientAdapter");
    Throwable throwable = null;
    try {
      WebViewContentsClientAdapter webViewContentsClientAdapter = new WebViewContentsClientAdapter(paramWebView, paramContext, this.mWebViewDelegate);
      if (scopedSysTraceEvent != null)
        $closeResource((Throwable)null, scopedSysTraceEvent); 
      return webViewContentsClientAdapter;
    } catch (Throwable throwable1) {
      throwable = throwable1;
      throw throwable1;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable, scopedSysTraceEvent); 
    throw paramWebView;
  }
  
  public CookieManager getCookieManager() {
    return this.mAwInit.getCookieManager();
  }
  
  public GeolocationPermissions getGeolocationPermissions() {
    return this.mAwInit.getGeolocationPermissions();
  }
  
  public ServiceWorkerController getServiceWorkerController() {
    synchronized (this.mAwInit.mLock) {
      if (this.mServiceWorkerControllerAdapter == null)
        this.mServiceWorkerControllerAdapter = ApiHelperForN.createServiceWorkerControllerAdapter(this.mAwInit); 
      return (ServiceWorkerController)this.mServiceWorkerControllerAdapter;
    } 
  }
  
  public WebViewFactoryProvider.Statics getStatics() {
    synchronized (this.mAwInit.mLock) {
      SharedStatics sharedStatics = this.mAwInit.getStatics();
      if (this.mStaticsAdapter == null)
        this.mStaticsAdapter = new WebViewChromiumFactoryProvider$1(this, sharedStatics); 
      return this.mStaticsAdapter;
    } 
  }
  
  public TokenBindingService getTokenBindingService() {
    return this.mAwInit.getTokenBindingService();
  }
  
  public TracingController getTracingController() {
    synchronized (this.mAwInit.mLock) {
      this.mAwInit.ensureChromiumStartedLocked(true);
      if (this.mTracingController == null)
        this.mTracingController = new TracingControllerAdapter(this, this.mAwInit.getAwTracingController()); 
      return this.mTracingController;
    } 
  }
  
  public WebIconDatabase getWebIconDatabase() {
    return this.mAwInit.getWebIconDatabase();
  }
  
  public WebStorage getWebStorage() {
    return this.mAwInit.getWebStorage();
  }
  
  public ClassLoader getWebViewClassLoader() {
    return new WebViewChromiumFactoryProvider$FilteredClassLoader(WebViewChromiumFactoryProvider.class.getClassLoader());
  }
  
  public WebViewDatabase getWebViewDatabase(Context paramContext) {
    return this.mAwInit.getWebViewDatabase(paramContext);
  }
  
  final Object runOnUiThreadBlocking(Callable<?> paramCallable) {
    return this.mRunQueue.runBlockingFuture(new FutureTask(paramCallable));
  }
  
  final void runVoidTaskOnUiThreadBlocking(Runnable paramRunnable) {
    this.mRunQueue.runBlockingFuture(new FutureTask(paramRunnable, null));
  }
  
  final void startYourEngines(boolean paramBoolean) {
    Throwable throwable2;
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("WebViewChromiumFactoryProvider.startYourEngines");
    Throwable throwable1 = null;
    try {
      this.mAwInit.startYourEngines(paramBoolean);
      if (scopedSysTraceEvent != null) {
        $closeResource((Throwable)null, scopedSysTraceEvent);
        return;
      } 
      return;
    } catch (Throwable null) {
      throwable1 = throwable2;
      throw throwable2;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable1, scopedSysTraceEvent); 
    throw throwable2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumFactoryProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */