package com.android.webview.chromium;

import android.arch.lifecycle.R;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.compat.R;
import android.support.coreui.R;
import android.support.coreutils.R;
import android.support.fragment.R;
import android.support.graphics.drawable.R;
import android.support.graphics.drawable.animated.R;
import android.support.mediacompat.R;
import android.support.v4.R;
import android.support.v7.appcompat.R;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.TokenBindingService;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.google.android.gms.R;
import com.google.android.gms.base.R;
import com.google.android.gms.gcm.R;
import com.google.android.gms.iid.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.Random;
import org.chromium.android_webview.AwBrowserContext;
import org.chromium.android_webview.AwCookieManager;
import org.chromium.android_webview.AwResource;
import org.chromium.android_webview.AwServiceWorkerController;
import org.chromium.android_webview.AwTracingController;
import org.chromium.android_webview.HttpAuthDatabase;
import org.chromium.android_webview.R;
import org.chromium.android_webview.ScopedSysTraceEvent;
import org.chromium.android_webview.VariationsSeedLoader;
import org.chromium.base.metrics.CachedMetrics;
import org.chromium.components.autofill.R;
import org.chromium.components.embedder_support.delegate.R;
import org.chromium.content.R;
import org.chromium.media.R;
import org.chromium.ui.R;

public class WebViewChromiumAwInit {
  private AwTracingController mAwTracingController;
  
  private AwBrowserContext mBrowserContext;
  
  private CookieManagerAdapter mCookieManager;
  
  private final WebViewChromiumFactoryProvider mFactory;
  
  private GeolocationPermissionsAdapter mGeolocationPermissions;
  
  public final Object mLock = new Object();
  
  private VariationsSeedLoader mSeedLoader;
  
  private AwServiceWorkerController mServiceWorkerController;
  
  Thread mSetUpResourcesThread;
  
  private SharedStatics mSharedStatics;
  
  boolean mStarted;
  
  private Object mTokenBindingManager;
  
  private WebIconDatabaseAdapter mWebIconDatabase;
  
  private WebStorageAdapter mWebStorage;
  
  private WebViewDatabaseAdapter mWebViewDatabase;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  WebViewChromiumAwInit(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider) {
    this.mFactory = paramWebViewChromiumFactoryProvider;
  }
  
  final void ensureChromiumStartedLocked(boolean paramBoolean) {
    assert false;
    throw new AssertionError();
  }
  
  final AwTracingController getAwTracingController() {
    synchronized (this.mLock) {
      if (this.mAwTracingController == null)
        ensureChromiumStartedLocked(true); 
      return this.mAwTracingController;
    } 
  }
  
  final AwBrowserContext getBrowserContextOnUiThread() {
    assert false;
    throw new AssertionError();
  }
  
  public final CookieManager getCookieManager() {
    synchronized (this.mLock) {
      if (this.mCookieManager == null)
        this.mCookieManager = new CookieManagerAdapter(new AwCookieManager()); 
      return this.mCookieManager;
    } 
  }
  
  public final GeolocationPermissions getGeolocationPermissions() {
    synchronized (this.mLock) {
      if (this.mGeolocationPermissions == null)
        ensureChromiumStartedLocked(true); 
      return this.mGeolocationPermissions;
    } 
  }
  
  public final AwServiceWorkerController getServiceWorkerController() {
    synchronized (this.mLock) {
      if (this.mServiceWorkerController == null)
        ensureChromiumStartedLocked(true); 
      return this.mServiceWorkerController;
    } 
  }
  
  public final SharedStatics getStatics() {
    synchronized (this.mLock) {
      if (this.mSharedStatics == null)
        ensureChromiumStartedLocked(true); 
      return this.mSharedStatics;
    } 
  }
  
  public final TokenBindingService getTokenBindingService() {
    synchronized (this.mLock) {
      if (this.mTokenBindingManager == null)
        this.mTokenBindingManager = ApiHelperForN.createTokenBindingManagerAdapter(this.mFactory); 
      return (TokenBindingService)this.mTokenBindingManager;
    } 
  }
  
  public final WebIconDatabase getWebIconDatabase() {
    synchronized (this.mLock) {
      ensureChromiumStartedLocked(true);
      if (this.mWebIconDatabase == null)
        this.mWebIconDatabase = new WebIconDatabaseAdapter(); 
      return this.mWebIconDatabase;
    } 
  }
  
  public final WebStorage getWebStorage() {
    synchronized (this.mLock) {
      if (this.mWebStorage == null)
        ensureChromiumStartedLocked(true); 
      return this.mWebStorage;
    } 
  }
  
  public final WebViewDatabase getWebViewDatabase(Context paramContext) {
    synchronized (this.mLock) {
      ensureChromiumStartedLocked(true);
      if (this.mWebViewDatabase == null)
        this.mWebViewDatabase = new WebViewDatabaseAdapter(this.mFactory, HttpAuthDatabase.newInstance(paramContext, "http_auth.db")); 
      return this.mWebViewDatabase;
    } 
  }
  
  protected final void startChromiumLocked() {
    // Byte code:
    //   0: ldc_w 'WebViewChromiumAwInit.startChromiumLocked'
    //   3: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   6: astore #6
    //   8: aconst_null
    //   9: astore #5
    //   11: aload #5
    //   13: astore_2
    //   14: getstatic com/android/webview/chromium/WebViewChromiumAwInit.$assertionsDisabled : Z
    //   17: ifne -> 56
    //   20: aload #5
    //   22: astore_2
    //   23: aload_0
    //   24: getfield mLock : Ljava/lang/Object;
    //   27: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   30: ifeq -> 45
    //   33: aload #5
    //   35: astore_2
    //   36: invokestatic runningOnUiThread : ()Z
    //   39: ifeq -> 45
    //   42: goto -> 56
    //   45: aload #5
    //   47: astore_2
    //   48: new java/lang/AssertionError
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: athrow
    //   56: aload #5
    //   58: astore_2
    //   59: aload_0
    //   60: getfield mLock : Ljava/lang/Object;
    //   63: invokevirtual notifyAll : ()V
    //   66: aload #5
    //   68: astore_2
    //   69: aload_0
    //   70: getfield mStarted : Z
    //   73: istore_1
    //   74: iload_1
    //   75: ifeq -> 90
    //   78: aload #6
    //   80: ifnull -> 89
    //   83: aconst_null
    //   84: aload #6
    //   86: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   89: return
    //   90: aload #5
    //   92: astore_2
    //   93: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   96: astore_3
    //   97: aload #5
    //   99: astore_2
    //   100: ldc_w 'WebViewChromiumAwInit.LibraryLoader'
    //   103: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   106: astore #7
    //   108: invokestatic getInstance : ()Lorg/chromium/base/library_loader/LibraryLoader;
    //   111: iconst_3
    //   112: invokevirtual ensureInitialized : (I)V
    //   115: aload #7
    //   117: ifnull -> 132
    //   120: aload #5
    //   122: astore_2
    //   123: aconst_null
    //   124: aload #7
    //   126: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   129: goto -> 132
    //   132: aload #5
    //   134: astore_2
    //   135: iconst_3
    //   136: ldc_w '/system/lib/'
    //   139: invokestatic override : (ILjava/lang/String;)V
    //   142: aload #5
    //   144: astore_2
    //   145: sipush #3003
    //   148: ldc_w '/system/framework/webview/paks'
    //   151: invokestatic override : (ILjava/lang/String;)V
    //   154: aload #5
    //   156: astore_2
    //   157: ldc_w 'WebViewChromiumAwInit.initPlatSupportLibrary'
    //   160: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   163: astore #7
    //   165: invokestatic getAwDrawGLFunction : ()J
    //   168: invokestatic setChromiumAwDrawGLFunction : (J)V
    //   171: invokestatic getDrawSWFunctionTable : ()J
    //   174: invokestatic setAwDrawSWFunctionTable : (J)V
    //   177: invokestatic getDrawGLFunctionTable : ()J
    //   180: invokestatic setAwDrawGLFunctionTable : (J)V
    //   183: aload #7
    //   185: ifnull -> 197
    //   188: aload #5
    //   190: astore_2
    //   191: aconst_null
    //   192: aload #7
    //   194: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   197: aload #5
    //   199: astore_2
    //   200: ldc_w 'WebViewChromiumAwInit.doNetworkInitializations'
    //   203: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   206: astore #7
    //   208: aload_3
    //   209: ldc_w 'android.permission.ACCESS_NETWORK_STATE'
    //   212: invokestatic myPid : ()I
    //   215: invokestatic myUid : ()I
    //   218: invokevirtual checkPermission : (Ljava/lang/String;II)I
    //   221: ifne -> 238
    //   224: invokestatic init : ()Lorg/chromium/net/NetworkChangeNotifier;
    //   227: pop
    //   228: new org/chromium/android_webview/AwNetworkChangeNotifierRegistrationPolicy
    //   231: dup
    //   232: invokespecial <init> : ()V
    //   235: invokestatic setAutoDetectConnectivityState : (Lorg/chromium/net/NetworkChangeNotifierAutoDetect$RegistrationPolicy;)V
    //   238: aload_3
    //   239: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   242: getfield targetSdkVersion : I
    //   245: bipush #26
    //   247: if_icmplt -> 939
    //   250: iconst_1
    //   251: istore_1
    //   252: goto -> 255
    //   255: iload_1
    //   256: invokestatic setCheckClearTextPermitted : (Z)V
    //   259: aload #7
    //   261: ifnull -> 273
    //   264: aload #5
    //   266: astore_2
    //   267: aconst_null
    //   268: aload #7
    //   270: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   273: aload #5
    //   275: astore_2
    //   276: ldc_w 'WebViewChromiumAwInit.waitUntilSetUpResources'
    //   279: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   282: astore #7
    //   284: aload_0
    //   285: getfield mSetUpResourcesThread : Ljava/lang/Thread;
    //   288: invokevirtual join : ()V
    //   291: aload #7
    //   293: ifnull -> 308
    //   296: aload #5
    //   298: astore_2
    //   299: aconst_null
    //   300: aload #7
    //   302: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   305: goto -> 308
    //   308: aload #5
    //   310: astore_2
    //   311: invokestatic configureChildProcessLauncher : ()V
    //   314: aload #5
    //   316: astore_2
    //   317: ldc_w 'WebViewChromiumAwInit.finishVariationsInitLocked'
    //   320: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   323: astore #7
    //   325: getstatic com/android/webview/chromium/WebViewChromiumAwInit.$assertionsDisabled : Z
    //   328: ifne -> 352
    //   331: aload_0
    //   332: getfield mLock : Ljava/lang/Object;
    //   335: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   338: ifeq -> 344
    //   341: goto -> 352
    //   344: new java/lang/AssertionError
    //   347: dup
    //   348: invokespecial <init> : ()V
    //   351: athrow
    //   352: aload_0
    //   353: getfield mSeedLoader : Lorg/chromium/android_webview/VariationsSeedLoader;
    //   356: ifnonnull -> 373
    //   359: ldc_w 'WebViewChromiumAwInit'
    //   362: ldc_w 'finishVariationsInitLocked() called before startVariationsInit()'
    //   365: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   368: pop
    //   369: aload_0
    //   370: invokevirtual startVariationsInit : ()V
    //   373: aload_0
    //   374: getfield mSeedLoader : Lorg/chromium/android_webview/VariationsSeedLoader;
    //   377: invokevirtual getSeedBlockingAndLog : ()Lorg/chromium/components/variations/firstrun/VariationsSeedFetcher$SeedInfo;
    //   380: astore_2
    //   381: aload_2
    //   382: ifnull -> 404
    //   385: invokestatic isEnabledByCmd : ()Z
    //   388: ifne -> 400
    //   391: invokestatic getInstance : ()Lorg/chromium/base/CommandLine;
    //   394: ldc_w 'enable-webview-variations'
    //   397: invokevirtual appendSwitch : (Ljava/lang/String;)V
    //   400: aload_2
    //   401: invokestatic setSeed : (Lorg/chromium/components/variations/firstrun/VariationsSeedFetcher$SeedInfo;)V
    //   404: aload_0
    //   405: aconst_null
    //   406: putfield mSeedLoader : Lorg/chromium/android_webview/VariationsSeedLoader;
    //   409: aload #7
    //   411: ifnull -> 423
    //   414: aload #5
    //   416: astore_2
    //   417: aconst_null
    //   418: aload #7
    //   420: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   423: aload #5
    //   425: astore_2
    //   426: invokestatic start : ()V
    //   429: aload #5
    //   431: astore_2
    //   432: iconst_1
    //   433: invokestatic handleMinidumpsAndSetMetricsConsent : (Z)V
    //   436: aload #5
    //   438: astore_2
    //   439: aload_0
    //   440: new com/android/webview/chromium/SharedStatics
    //   443: dup
    //   444: invokespecial <init> : ()V
    //   447: putfield mSharedStatics : Lcom/android/webview/chromium/SharedStatics;
    //   450: aload #5
    //   452: astore_2
    //   453: invokestatic isBuildDebuggable : ()Z
    //   456: ifeq -> 470
    //   459: aload #5
    //   461: astore_2
    //   462: aload_0
    //   463: getfield mSharedStatics : Lcom/android/webview/chromium/SharedStatics;
    //   466: iconst_1
    //   467: invokevirtual setWebContentsDebuggingEnabledUnconditionally : (Z)V
    //   470: aload #5
    //   472: astore_2
    //   473: aload_0
    //   474: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   477: getfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   480: invokeinterface isTraceTagEnabled : ()Z
    //   485: invokestatic setATraceEnabled : (Z)V
    //   488: aload #5
    //   490: astore_2
    //   491: aload_0
    //   492: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   495: getfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   498: new com/android/webview/chromium/WebViewChromiumAwInit$1
    //   501: dup
    //   502: invokespecial <init> : ()V
    //   505: invokeinterface setOnTraceEnabledChangeListener : (Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener;)V
    //   510: aload #5
    //   512: astore_2
    //   513: aload_0
    //   514: iconst_1
    //   515: putfield mStarted : Z
    //   518: aload #5
    //   520: astore_2
    //   521: invokestatic commitCachedMetrics : ()V
    //   524: aload #5
    //   526: astore_2
    //   527: ldc_w 'Android.WebView.TargetSdkVersion'
    //   530: aload_3
    //   531: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   534: getfield targetSdkVersion : I
    //   537: invokestatic recordSparseSlowlyHistogram : (Ljava/lang/String;I)V
    //   540: aload #5
    //   542: astore_2
    //   543: ldc_w 'WebViewChromiumAwInit.initThreadUnsafeSingletons'
    //   546: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   549: astore #7
    //   551: aload_0
    //   552: invokevirtual getBrowserContextOnUiThread : ()Lorg/chromium/android_webview/AwBrowserContext;
    //   555: astore_2
    //   556: aload_0
    //   557: new com/android/webview/chromium/GeolocationPermissionsAdapter
    //   560: dup
    //   561: aload_0
    //   562: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   565: aload_2
    //   566: invokevirtual getGeolocationPermissions : ()Lorg/chromium/android_webview/AwGeolocationPermissions;
    //   569: invokespecial <init> : (Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;Lorg/chromium/android_webview/AwGeolocationPermissions;)V
    //   572: putfield mGeolocationPermissions : Lcom/android/webview/chromium/GeolocationPermissionsAdapter;
    //   575: aload_0
    //   576: new com/android/webview/chromium/WebStorageAdapter
    //   579: dup
    //   580: aload_0
    //   581: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   584: invokestatic getInstance : ()Lorg/chromium/android_webview/AwQuotaManagerBridge;
    //   587: invokespecial <init> : (Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;Lorg/chromium/android_webview/AwQuotaManagerBridge;)V
    //   590: putfield mWebStorage : Lcom/android/webview/chromium/WebStorageAdapter;
    //   593: aload_2
    //   594: getfield mTracingController : Lorg/chromium/android_webview/AwTracingController;
    //   597: ifnonnull -> 611
    //   600: aload_2
    //   601: new org/chromium/android_webview/AwTracingController
    //   604: dup
    //   605: invokespecial <init> : ()V
    //   608: putfield mTracingController : Lorg/chromium/android_webview/AwTracingController;
    //   611: aload_0
    //   612: aload_2
    //   613: getfield mTracingController : Lorg/chromium/android_webview/AwTracingController;
    //   616: putfield mAwTracingController : Lorg/chromium/android_webview/AwTracingController;
    //   619: aload_2
    //   620: getfield mServiceWorkerController : Lorg/chromium/android_webview/AwServiceWorkerController;
    //   623: ifnonnull -> 642
    //   626: aload_2
    //   627: new org/chromium/android_webview/AwServiceWorkerController
    //   630: dup
    //   631: aload_2
    //   632: getfield mApplicationContext : Landroid/content/Context;
    //   635: aload_2
    //   636: invokespecial <init> : (Landroid/content/Context;Lorg/chromium/android_webview/AwBrowserContext;)V
    //   639: putfield mServiceWorkerController : Lorg/chromium/android_webview/AwServiceWorkerController;
    //   642: aload_0
    //   643: aload_2
    //   644: getfield mServiceWorkerController : Lorg/chromium/android_webview/AwServiceWorkerController;
    //   647: putfield mServiceWorkerController : Lorg/chromium/android_webview/AwServiceWorkerController;
    //   650: aload #7
    //   652: ifnull -> 664
    //   655: aload #5
    //   657: astore_2
    //   658: aconst_null
    //   659: aload #7
    //   661: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   664: aload #5
    //   666: astore_2
    //   667: aload_0
    //   668: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   671: getfield mRunQueue : Lorg/chromium/android_webview/WebViewChromiumRunQueue;
    //   674: invokevirtual drainQueue : ()V
    //   677: aload #6
    //   679: ifnull -> 689
    //   682: aconst_null
    //   683: aload #6
    //   685: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   688: return
    //   689: return
    //   690: astore_3
    //   691: aconst_null
    //   692: astore #4
    //   694: goto -> 703
    //   697: astore #4
    //   699: aload #4
    //   701: athrow
    //   702: astore_3
    //   703: aload #7
    //   705: ifnull -> 718
    //   708: aload #5
    //   710: astore_2
    //   711: aload #4
    //   713: aload #7
    //   715: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   718: aload #5
    //   720: astore_2
    //   721: aload_3
    //   722: athrow
    //   723: astore_3
    //   724: aconst_null
    //   725: astore #4
    //   727: goto -> 736
    //   730: astore #4
    //   732: aload #4
    //   734: athrow
    //   735: astore_3
    //   736: aload #7
    //   738: ifnull -> 751
    //   741: aload #5
    //   743: astore_2
    //   744: aload #4
    //   746: aload #7
    //   748: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   751: aload #5
    //   753: astore_2
    //   754: aload_3
    //   755: athrow
    //   756: astore_3
    //   757: aconst_null
    //   758: astore #4
    //   760: goto -> 769
    //   763: astore #4
    //   765: aload #4
    //   767: athrow
    //   768: astore_3
    //   769: aload #7
    //   771: ifnull -> 784
    //   774: aload #5
    //   776: astore_2
    //   777: aload #4
    //   779: aload #7
    //   781: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   784: aload #5
    //   786: astore_2
    //   787: aload_3
    //   788: athrow
    //   789: astore_3
    //   790: aload #5
    //   792: astore_2
    //   793: new java/lang/RuntimeException
    //   796: dup
    //   797: aload_3
    //   798: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   801: athrow
    //   802: astore_3
    //   803: aconst_null
    //   804: astore #4
    //   806: goto -> 815
    //   809: astore #4
    //   811: aload #4
    //   813: athrow
    //   814: astore_3
    //   815: aload #7
    //   817: ifnull -> 830
    //   820: aload #5
    //   822: astore_2
    //   823: aload #4
    //   825: aload #7
    //   827: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   830: aload #5
    //   832: astore_2
    //   833: aload_3
    //   834: athrow
    //   835: astore_3
    //   836: aconst_null
    //   837: astore #4
    //   839: goto -> 848
    //   842: astore #4
    //   844: aload #4
    //   846: athrow
    //   847: astore_3
    //   848: aload #7
    //   850: ifnull -> 863
    //   853: aload #5
    //   855: astore_2
    //   856: aload #4
    //   858: aload #7
    //   860: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   863: aload #5
    //   865: astore_2
    //   866: aload_3
    //   867: athrow
    //   868: astore_3
    //   869: aconst_null
    //   870: astore #4
    //   872: goto -> 881
    //   875: astore #4
    //   877: aload #4
    //   879: athrow
    //   880: astore_3
    //   881: aload #7
    //   883: ifnull -> 896
    //   886: aload #5
    //   888: astore_2
    //   889: aload #4
    //   891: aload #7
    //   893: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   896: aload #5
    //   898: astore_2
    //   899: aload_3
    //   900: athrow
    //   901: astore_3
    //   902: aload #5
    //   904: astore_2
    //   905: new java/lang/RuntimeException
    //   908: dup
    //   909: ldc_w 'Error initializing WebView library'
    //   912: aload_3
    //   913: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   916: athrow
    //   917: astore_3
    //   918: goto -> 926
    //   921: astore_3
    //   922: aload_3
    //   923: astore_2
    //   924: aload_3
    //   925: athrow
    //   926: aload #6
    //   928: ifnull -> 937
    //   931: aload_2
    //   932: aload #6
    //   934: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   937: aload_3
    //   938: athrow
    //   939: iconst_0
    //   940: istore_1
    //   941: goto -> 255
    // Exception table:
    //   from	to	target	type
    //   14	20	921	java/lang/Throwable
    //   14	20	917	finally
    //   23	33	921	java/lang/Throwable
    //   23	33	917	finally
    //   36	42	921	java/lang/Throwable
    //   36	42	917	finally
    //   48	56	921	java/lang/Throwable
    //   48	56	917	finally
    //   59	66	921	java/lang/Throwable
    //   59	66	917	finally
    //   69	74	921	java/lang/Throwable
    //   69	74	917	finally
    //   93	97	921	java/lang/Throwable
    //   93	97	917	finally
    //   100	108	901	org/chromium/base/library_loader/ProcessInitException
    //   100	108	921	java/lang/Throwable
    //   100	108	917	finally
    //   108	115	875	java/lang/Throwable
    //   108	115	868	finally
    //   123	129	901	org/chromium/base/library_loader/ProcessInitException
    //   123	129	921	java/lang/Throwable
    //   123	129	917	finally
    //   135	142	921	java/lang/Throwable
    //   135	142	917	finally
    //   145	154	921	java/lang/Throwable
    //   145	154	917	finally
    //   157	165	921	java/lang/Throwable
    //   157	165	917	finally
    //   165	183	842	java/lang/Throwable
    //   165	183	835	finally
    //   191	197	921	java/lang/Throwable
    //   191	197	917	finally
    //   200	208	921	java/lang/Throwable
    //   200	208	917	finally
    //   208	238	809	java/lang/Throwable
    //   208	238	802	finally
    //   238	250	809	java/lang/Throwable
    //   238	250	802	finally
    //   255	259	809	java/lang/Throwable
    //   255	259	802	finally
    //   267	273	921	java/lang/Throwable
    //   267	273	917	finally
    //   276	284	789	java/lang/InterruptedException
    //   276	284	921	java/lang/Throwable
    //   276	284	917	finally
    //   284	291	763	java/lang/Throwable
    //   284	291	756	finally
    //   299	305	789	java/lang/InterruptedException
    //   299	305	921	java/lang/Throwable
    //   299	305	917	finally
    //   311	314	921	java/lang/Throwable
    //   311	314	917	finally
    //   317	325	921	java/lang/Throwable
    //   317	325	917	finally
    //   325	341	730	java/lang/Throwable
    //   325	341	723	finally
    //   344	352	730	java/lang/Throwable
    //   344	352	723	finally
    //   352	373	730	java/lang/Throwable
    //   352	373	723	finally
    //   373	381	730	java/lang/Throwable
    //   373	381	723	finally
    //   385	400	730	java/lang/Throwable
    //   385	400	723	finally
    //   400	404	730	java/lang/Throwable
    //   400	404	723	finally
    //   404	409	730	java/lang/Throwable
    //   404	409	723	finally
    //   417	423	921	java/lang/Throwable
    //   417	423	917	finally
    //   426	429	921	java/lang/Throwable
    //   426	429	917	finally
    //   432	436	921	java/lang/Throwable
    //   432	436	917	finally
    //   439	450	921	java/lang/Throwable
    //   439	450	917	finally
    //   453	459	921	java/lang/Throwable
    //   453	459	917	finally
    //   462	470	921	java/lang/Throwable
    //   462	470	917	finally
    //   473	488	921	java/lang/Throwable
    //   473	488	917	finally
    //   491	510	921	java/lang/Throwable
    //   491	510	917	finally
    //   513	518	921	java/lang/Throwable
    //   513	518	917	finally
    //   521	524	921	java/lang/Throwable
    //   521	524	917	finally
    //   527	540	921	java/lang/Throwable
    //   527	540	917	finally
    //   543	551	921	java/lang/Throwable
    //   543	551	917	finally
    //   551	611	697	java/lang/Throwable
    //   551	611	690	finally
    //   611	642	697	java/lang/Throwable
    //   611	642	690	finally
    //   642	650	697	java/lang/Throwable
    //   642	650	690	finally
    //   658	664	921	java/lang/Throwable
    //   658	664	917	finally
    //   667	677	921	java/lang/Throwable
    //   667	677	917	finally
    //   699	702	702	finally
    //   711	718	921	java/lang/Throwable
    //   711	718	917	finally
    //   721	723	921	java/lang/Throwable
    //   721	723	917	finally
    //   732	735	735	finally
    //   744	751	921	java/lang/Throwable
    //   744	751	917	finally
    //   754	756	921	java/lang/Throwable
    //   754	756	917	finally
    //   765	768	768	finally
    //   777	784	789	java/lang/InterruptedException
    //   777	784	921	java/lang/Throwable
    //   777	784	917	finally
    //   787	789	789	java/lang/InterruptedException
    //   787	789	921	java/lang/Throwable
    //   787	789	917	finally
    //   793	802	921	java/lang/Throwable
    //   793	802	917	finally
    //   811	814	814	finally
    //   823	830	921	java/lang/Throwable
    //   823	830	917	finally
    //   833	835	921	java/lang/Throwable
    //   833	835	917	finally
    //   844	847	847	finally
    //   856	863	921	java/lang/Throwable
    //   856	863	917	finally
    //   866	868	921	java/lang/Throwable
    //   866	868	917	finally
    //   877	880	880	finally
    //   889	896	901	org/chromium/base/library_loader/ProcessInitException
    //   889	896	921	java/lang/Throwable
    //   889	896	917	finally
    //   899	901	901	org/chromium/base/library_loader/ProcessInitException
    //   899	901	921	java/lang/Throwable
    //   899	901	917	finally
    //   905	917	921	java/lang/Throwable
    //   905	917	917	finally
    //   924	926	917	finally
  }
  
  public final void startVariationsInit() {
    synchronized (this.mLock) {
      if (this.mSeedLoader == null) {
        this.mSeedLoader = new VariationsSeedLoader();
        VariationsSeedLoader variationsSeedLoader = this.mSeedLoader;
        if (VariationsSeedLoader.$assertionsDisabled || variationsSeedLoader.mEnableState == -1) {
          int i = (new Random()).nextInt(1000);
          byte b = 1;
          if (i != 0)
            if (i == 1) {
              b = 2;
            } else {
              b = 0;
            }  
          (new CachedMetrics.EnumeratedHistogramSample("Android.WebView.VariationsEnableState", 3)).record(b);
          variationsSeedLoader.mEnableState = b;
          variationsSeedLoader.mRunnable = new VariationsSeedLoader.SeedLoadAndUpdateRunnable(variationsSeedLoader, VariationsSeedLoader.isEnabledByCmd());
          (new Thread((Runnable)variationsSeedLoader.mRunnable)).start();
        } else {
          throw new AssertionError();
        } 
      } 
      return;
    } 
  }
  
  final void startYourEngines(boolean paramBoolean) {
    synchronized (this.mLock) {
      ensureChromiumStartedLocked(paramBoolean);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumAwInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */