package org.chromium.android_webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifier;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import org.chromium.android_webview.permission.AwGeolocationCallback;
import org.chromium.android_webview.permission.AwPermissionRequest;
import org.chromium.base.Callback;
import org.chromium.base.LocaleUtils;
import org.chromium.base.Log;
import org.chromium.base.ObserverList;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.components.autofill.AutofillProvider;
import org.chromium.components.navigation_interception.InterceptNavigationDelegate;
import org.chromium.content.browser.JavascriptInjectorImpl;
import org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl;
import org.chromium.content_public.browser.JavaScriptCallback;
import org.chromium.content_public.browser.JavascriptInjector;
import org.chromium.content_public.browser.LoadUrlParams;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.browser.SmartClipProvider;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsAccessibility;
import org.chromium.content_public.browser.WebContentsInternals;
import org.chromium.content_public.common.Referrer;
import org.chromium.ui.base.ActivityWindowAndroid;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;

public class AwContents implements SmartClipProvider {
  private static final String PRODUCT_VERSION;
  
  private static WeakHashMap sContextWindowMap;
  
  private static String sCurrentLocales;
  
  private static final Rect sLocalGlobalVisibleRect;
  
  public final int mAppTargetSdkVersion;
  
  public AutofillProvider mAutofillProvider;
  
  private AwAutofillClient mAwAutofillClient;
  
  public AwPdfExporter mAwPdfExporter;
  
  public AwViewMethods mAwViewMethods;
  
  private final AwContentsBackgroundThreadClient mBackgroundThreadClient;
  
  public int mBaseBackgroundColor = -1;
  
  public final AwBrowserContext mBrowserContext;
  
  private CleanupReference mCleanupReference;
  
  public ViewGroup mContainerView;
  
  public boolean mContainerViewFocused;
  
  public float mContentHeightDip;
  
  public float mContentWidthDip;
  
  public final AwContentsClient mContentsClient;
  
  private final AwContentsClientBridge mContentsClientBridge;
  
  final Context mContext;
  
  private AwGLFunctor mCurrentFunctor;
  
  private final DefaultVideoPosterRequestHandler mDefaultVideoPosterRequestHandler;
  
  private final DisplayAndroid.DisplayAndroidObserver mDisplayObserver;
  
  public Bitmap mFavicon;
  
  AwGLFunctor mFullScreenFunctor;
  
  final AwContents$FullScreenTransitionsState mFullScreenTransitionsState;
  
  Handler mHandler;
  
  private boolean mHasRequestedVisitedHistoryFromClient;
  
  AwGLFunctor mInitialFunctor;
  
  private final AwContents$InterceptNavigationDelegateImpl mInterceptNavigationDelegate;
  
  AwContents$InternalAccessDelegate mInternalAccessAdapter;
  
  private boolean mInvalidateRootViewOnNextDraw;
  
  private final AwContentsIoThreadClient mIoThreadClient;
  
  public boolean mIsAttachedToWindow;
  
  private boolean mIsContentVisible;
  
  private boolean mIsDestroyed;
  
  private boolean mIsNoOperation;
  
  public boolean mIsPaused;
  
  public boolean mIsPopupWindow;
  
  private boolean mIsUpdateVisibilityTaskPending;
  
  public boolean mIsViewVisible;
  
  public boolean mIsWindowVisible;
  
  private JavascriptInjector mJavascriptInjector;
  
  public final AwLayoutSizer mLayoutSizer;
  
  private float mMaxPageScaleFactor = 1.0F;
  
  private float mMinPageScaleFactor = 1.0F;
  
  public long mNativeAwContents;
  
  final AwContents$NativeDrawGLFunctorFactory mNativeDrawGLFunctorFactory;
  
  public NavigationController mNavigationController;
  
  private OverScrollGlow mOverScrollGlow;
  
  public boolean mOverlayHorizontalScrollbar = true;
  
  public boolean mOverlayVerticalScrollbar;
  
  public float mPageScaleFactor = 1.0F;
  
  private Paint mPaintForNWorkaround;
  
  public Callable mPictureListenerContentProvider;
  
  public final AwContents$HitTestData mPossiblyStaleHitTestData = new AwContents$HitTestData();
  
  public int mRendererPriority;
  
  public boolean mRendererPriorityWaivedWhenNotVisible;
  
  private final ScrollAccessibilityHelper mScrollAccessibilityHelper;
  
  public final AwScrollOffsetManager mScrollOffsetManager;
  
  public final AwSettings mSettings;
  
  public boolean mTemporarilyDetached;
  
  private final ObserverList mTouchHandleDrawables = new ObserverList();
  
  private Runnable mUpdateVisibilityRunnable;
  
  private AwViewAndroidDelegate mViewAndroidDelegate;
  
  private ViewEventSink mViewEventSink;
  
  public WebContents mWebContents;
  
  public final AwWebContentsDelegateAdapter mWebContentsDelegate;
  
  private WebContentsInternals mWebContentsInternals;
  
  private AwContents$WebContentsInternalsHolder mWebContentsInternalsHolder;
  
  public AwWebContentsObserver mWebContentsObserver;
  
  private AwContents$WindowAndroidWrapper mWindowAndroid;
  
  public boolean mWindowFocused;
  
  public final AwZoomControls mZoomControls;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwContents(AwBrowserContext paramAwBrowserContext, ViewGroup paramViewGroup, Context paramContext, AwContents$InternalAccessDelegate paramAwContents$InternalAccessDelegate, AwContents$NativeDrawGLFunctorFactory paramAwContents$NativeDrawGLFunctorFactory, AwContentsClient paramAwContentsClient, AwSettings paramAwSettings, AwContents$DependencyFactory paramAwContents$DependencyFactory) {
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwContents.constructor");
    Throwable throwable2 = null;
    Throwable throwable1 = throwable2;
    try {
      this.mRendererPriority = 2;
      throwable1 = throwable2;
      updateDefaultLocale();
      throwable1 = throwable2;
      paramAwSettings.updateAcceptLanguages();
      throwable1 = throwable2;
      this.mBrowserContext = paramAwBrowserContext;
      throwable1 = throwable2;
      this.mContainerView = paramViewGroup;
      throwable1 = throwable2;
      this.mContainerView.setWillNotDraw(false);
      throwable1 = throwable2;
      this.mHandler = new Handler();
      throwable1 = throwable2;
      this.mContext = paramContext;
      throwable1 = throwable2;
      this.mAutofillProvider = paramAwContents$DependencyFactory.createAutofillProvider$9c0822e(paramContext);
      throwable1 = throwable2;
      this.mAppTargetSdkVersion = (this.mContext.getApplicationInfo()).targetSdkVersion;
      throwable1 = throwable2;
      this.mInternalAccessAdapter = paramAwContents$InternalAccessDelegate;
      throwable1 = throwable2;
      this.mNativeDrawGLFunctorFactory = paramAwContents$NativeDrawGLFunctorFactory;
      throwable1 = throwable2;
      this.mInitialFunctor = new AwGLFunctor(this.mNativeDrawGLFunctorFactory, this.mContainerView);
      throwable1 = throwable2;
      this.mCurrentFunctor = this.mInitialFunctor;
      throwable1 = throwable2;
      this.mContentsClient = paramAwContentsClient;
      throwable1 = throwable2;
      this.mContentsClient.mCallbackHelper.mCancelCallbackPoller = new AwContents$$Lambda$0(this);
      throwable1 = throwable2;
      this.mAwViewMethods = new AwContents$AwViewMethodsImpl(this, (byte)0);
      throwable1 = throwable2;
      this.mFullScreenTransitionsState = new AwContents$FullScreenTransitionsState(this.mContainerView, this.mInternalAccessAdapter, this.mAwViewMethods, (byte)0);
      throwable1 = throwable2;
      this.mLayoutSizer = new AwLayoutSizer();
      throwable1 = throwable2;
      this.mSettings = paramAwSettings;
      throwable1 = throwable2;
      this.mLayoutSizer.mDelegate = new AwContents$AwLayoutSizerDelegate(this, (byte)0);
      throwable1 = throwable2;
      this.mWebContentsDelegate = new AwWebContentsDelegateAdapter(this, paramAwContentsClient, paramAwSettings, this.mContext, (View)this.mContainerView);
      throwable1 = throwable2;
      this.mContentsClientBridge = new AwContentsClientBridge(this.mContext, paramAwContentsClient, AwContentsStatics.getClientCertLookupTable());
      throwable1 = throwable2;
      this.mZoomControls = new AwZoomControls(this);
      throwable1 = throwable2;
      this.mBackgroundThreadClient = new AwContents$BackgroundThreadClientImpl(this, (byte)0);
      throwable1 = throwable2;
      this.mIoThreadClient = new AwContents$IoThreadClientImpl(this, (byte)0);
      throwable1 = throwable2;
      this.mInterceptNavigationDelegate = new AwContents$InterceptNavigationDelegateImpl(this, (byte)0);
      throwable1 = throwable2;
      this.mDisplayObserver = new AwContents$AwDisplayAndroidObserver(this, (byte)0);
      throwable1 = throwable2;
      this.mUpdateVisibilityRunnable = new AwContents$$Lambda$1(this);
      throwable1 = throwable2;
      null = new AwContents$$Lambda$2(this);
      throwable1 = throwable2;
      AwSettings awSettings = this.mSettings;
      throwable1 = throwable2;
      Object object = awSettings.mAwSettingsLock;
      synchronized (throwable2) {
        awSettings.mZoomChangeListener = null;
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
        throwable1 = throwable2;
        this.mDefaultVideoPosterRequestHandler = new DefaultVideoPosterRequestHandler(this.mContentsClient);
        throwable1 = throwable2;
        null = this.mSettings;
        throwable1 = throwable2;
        String str = this.mDefaultVideoPosterRequestHandler.mDefaultVideoPosterURL;
        throwable1 = throwable2;
        object = null.mAwSettingsLock;
        synchronized (throwable2) {
          if ((null.mDefaultVideoPosterURL != null && !null.mDefaultVideoPosterURL.equals(str)) || (null.mDefaultVideoPosterURL == null && str != null)) {
            null.mDefaultVideoPosterURL = str;
            null.mEventHandler.updateWebkitPreferencesLocked();
          } 
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
          throwable1 = throwable2;
          this.mScrollOffsetManager = new AwScrollOffsetManager(new AwContents$AwScrollOffsetManagerDelegate(this, (byte)0));
          throwable1 = throwable2;
          this.mScrollAccessibilityHelper = new ScrollAccessibilityHelper((View)this.mContainerView);
          throwable1 = throwable2;
          setOverScrollMode(this.mContainerView.getOverScrollMode());
          throwable1 = throwable2;
          setScrollBarStyle(this.mInternalAccessAdapter.super_getScrollBarStyle());
          throwable1 = throwable2;
          setNewAwContents(nativeInit(this.mBrowserContext));
          throwable1 = throwable2;
          onContainerViewChanged();
          if (scopedSysTraceEvent != null) {
            $closeResource(null, scopedSysTraceEvent);
            return;
          } 
          return;
        } 
      } 
    } catch (Throwable throwable) {
      throwable1 = throwable;
      throw throwable;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable1, scopedSysTraceEvent); 
    throw paramAwBrowserContext;
  }
  
  public static Activity activityFromContext(Context paramContext) {
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwContents.activityFromContext");
    Throwable throwable = null;
    try {
      Activity activity = WindowAndroid.activityFromContext(paramContext);
      if (scopedSysTraceEvent != null)
        $closeResource(null, scopedSysTraceEvent); 
      return activity;
    } catch (Throwable throwable1) {
      throwable = throwable1;
      throw throwable1;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable, scopedSysTraceEvent); 
    throw paramContext;
  }
  
  @CalledByNative
  private void didOverscroll(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {
    this.mScrollOffsetManager.scrollBy(paramInt1, paramInt2);
    if (this.mOverScrollGlow == null)
      return; 
    OverScrollGlow overScrollGlow = this.mOverScrollGlow;
    overScrollGlow.mOverScrollDeltaX += paramInt1;
    overScrollGlow.mOverScrollDeltaY += paramInt2;
    int i = this.mContainerView.getScrollX();
    int j = this.mContainerView.getScrollY();
    paramInt1 += i;
    paramInt2 += j;
    int k = this.mScrollOffsetManager.mMaxHorizontalScrollOffset;
    int m = this.mScrollOffsetManager.mMaxVerticalScrollOffset;
    overScrollGlow = this.mOverScrollGlow;
    paramFloat1 = (float)Math.hypot(paramFloat1, paramFloat2);
    if (!overScrollGlow.mShouldPull) {
      if (m > 0 || overScrollGlow.mHostView.getOverScrollMode() == 0)
        if (paramInt2 < 0 && j >= 0) {
          overScrollGlow.mEdgeGlowTop.onAbsorb((int)paramFloat1);
          if (!overScrollGlow.mEdgeGlowBottom.isFinished())
            overScrollGlow.mEdgeGlowBottom.onRelease(); 
        } else if (paramInt2 > m && j <= m) {
          overScrollGlow.mEdgeGlowBottom.onAbsorb((int)paramFloat1);
          if (!overScrollGlow.mEdgeGlowTop.isFinished())
            overScrollGlow.mEdgeGlowTop.onRelease(); 
        }  
      if (k > 0)
        if (paramInt1 < 0 && i >= 0) {
          overScrollGlow.mEdgeGlowLeft.onAbsorb((int)paramFloat1);
          if (!overScrollGlow.mEdgeGlowRight.isFinished())
            overScrollGlow.mEdgeGlowRight.onRelease(); 
        } else if (paramInt1 > k && i <= k) {
          overScrollGlow.mEdgeGlowRight.onAbsorb((int)paramFloat1);
          if (!overScrollGlow.mEdgeGlowLeft.isFinished())
            overScrollGlow.mEdgeGlowLeft.onRelease(); 
        }  
    } 
    overScrollGlow = this.mOverScrollGlow;
    if (!overScrollGlow.mEdgeGlowTop.isFinished() || !overScrollGlow.mEdgeGlowBottom.isFinished() || !overScrollGlow.mEdgeGlowLeft.isFinished() || !overScrollGlow.mEdgeGlowRight.isFinished()) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    if (paramInt1 != 0)
      postInvalidateOnAnimation(); 
  }
  
  private static String fixupData(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = ""; 
    return str;
  }
  
  private static String fixupMimeType(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "text/html"; 
    return str;
  }
  
  private static String generateArchiveAutoNamePath(String paramString1, String paramString2) {
    if (paramString1 != null && !paramString1.isEmpty()) {
      String str2;
      try {
        paramString1 = (new URL(paramString1)).getPath();
        int j = paramString1.lastIndexOf('/');
        if (j > 0)
          paramString1 = paramString1.substring(j + 1); 
      } catch (MalformedURLException malformedURLException1) {
        malformedURLException1 = null;
      } 
      MalformedURLException malformedURLException2 = malformedURLException1;
      if (TextUtils.isEmpty((CharSequence)malformedURLException1))
        str2 = "index"; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(str2);
      stringBuilder.append(".mht");
      String str1 = stringBuilder.toString();
      if (!(new File(str1)).exists())
        return str1; 
      for (int i = 1; i < 100; i++) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString2);
        stringBuilder1.append(str2);
        stringBuilder1.append("-");
        stringBuilder1.append(i);
        stringBuilder1.append(".mht");
        String str = stringBuilder1.toString();
        if (!(new File(str)).exists())
          return str; 
      } 
      Log.e("AwContents", "Unable to auto generate archive name for path: %s", new Object[] { paramString2 });
      return null;
    } 
    paramString1 = null;
  }
  
  @CalledByNative
  private static void generateMHTMLCallback(String paramString, long paramLong, Callback paramCallback) {
    if (paramCallback == null)
      return; 
    if (paramLong < 0L)
      paramString = null; 
    paramCallback.onResult(paramString);
  }
  
  public static long getAwDrawGLFunction() {
    return AwGLFunctor.getAwDrawGLFunction();
  }
  
  @CalledByNative
  private int getErrorUiType() {
    int[] arrayOfInt = new int[2];
    this.mContainerView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[0];
    int i = arrayOfInt[1];
    this.mContainerView.getRootView().getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int j = arrayOfInt[1];
    k -= m;
    i -= j;
    if (k < 0 || i < 0 || k + this.mContainerView.getWidth() > this.mContainerView.getRootView().getWidth() || i + this.mContainerView.getHeight() > this.mContainerView.getRootView().getHeight()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i != 0)
      return 2; 
    double d = this.mContainerView.getHeight() / this.mContainerView.getRootView().getHeight();
    if (this.mContainerView.getWidth() == this.mContainerView.getRootView().getWidth() && d >= 0.7D) {
      i = 1;
    } else {
      i = 0;
    } 
    return (i != 0) ? 0 : 1;
  }
  
  @CalledByNative
  private int[] getLocationOnScreen() {
    int[] arrayOfInt = new int[2];
    this.mContainerView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt;
  }
  
  private static AwContents$WindowAndroidWrapper getWindowAndroid(Context paramContext) {
    Throwable throwable;
    if (sContextWindowMap == null)
      sContextWindowMap = new WeakHashMap<Object, Object>(); 
    AwContents$WindowAndroidWrapper awContents$WindowAndroidWrapper1 = (AwContents$WindowAndroidWrapper)sContextWindowMap.get(paramContext);
    if (awContents$WindowAndroidWrapper1 != null)
      return awContents$WindowAndroidWrapper1; 
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwContents.getWindowAndroid");
    AwContents$WindowAndroidWrapper awContents$WindowAndroidWrapper2 = null;
    awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
    try {
      boolean bool;
      AwContents$WindowAndroidWrapper awContents$WindowAndroidWrapper;
      if (activityFromContext(paramContext) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
        ScopedSysTraceEvent scopedSysTraceEvent1 = ScopedSysTraceEvent.scoped("AwContents.createActivityWindow");
        try {
          ActivityWindowAndroid activityWindowAndroid = new ActivityWindowAndroid(paramContext, false);
          if (scopedSysTraceEvent1 != null) {
            awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
            $closeResource(null, scopedSysTraceEvent1);
          } 
          awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
        } catch (Throwable throwable1) {
          Exception exception;
          try {
            throw throwable1;
          } finally {}
          if (scopedSysTraceEvent1 != null) {
            awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
            $closeResource(throwable1, scopedSysTraceEvent1);
          } 
          awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
          throw exception;
        } finally {
          Exception exception = null;
        } 
      } else {
        awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
        awContents$WindowAndroidWrapper = new AwContents$WindowAndroidWrapper(new WindowAndroid(paramContext));
      } 
      awContents$WindowAndroidWrapper1 = awContents$WindowAndroidWrapper2;
      sContextWindowMap.put(paramContext, awContents$WindowAndroidWrapper);
      if (scopedSysTraceEvent != null)
        $closeResource(null, scopedSysTraceEvent); 
      return awContents$WindowAndroidWrapper;
    } catch (Throwable throwable1) {
      throwable = throwable1;
      throw throwable1;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable, scopedSysTraceEvent); 
    throw paramContext;
  }
  
  public static boolean isDpadEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode()) {
        default:
          return false;
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
          break;
      } 
      return true;
    } 
  }
  
  private native long nativeCapturePicture(long paramLong, int paramInt1, int paramInt2);
  
  public static native void nativeDestroy(long paramLong);
  
  private native void nativeEvaluateJavaScriptOnInterstitialForTesting(long paramLong, String paramString, JavaScriptCallback paramJavaScriptCallback);
  
  private native void nativeFocusFirstNode(long paramLong);
  
  private native void nativeGenerateMHTML(long paramLong, String paramString, Callback paramCallback);
  
  private native int nativeGetEffectivePriority(long paramLong);
  
  private static native int nativeGetNativeInstanceCount();
  
  private static native String nativeGetSafeBrowsingLocaleForTesting();
  
  private native WebContents nativeGetWebContents(long paramLong);
  
  private native void nativeGrantFileSchemeAccesstoChildProcess(long paramLong);
  
  private static native boolean nativeHasRequiredHardwareExtensions();
  
  private static native long nativeInit(AwBrowserContext paramAwBrowserContext);
  
  private native boolean nativeIsVisible(long paramLong);
  
  private native void nativeKillRenderProcess(long paramLong);
  
  private native boolean nativeNeedToDrawBackgroundColor(long paramLong);
  
  private native void nativeOnAttachedToWindow(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeOnComputeScroll(long paramLong1, long paramLong2);
  
  private native void nativeOnDetachedFromWindow(long paramLong);
  
  private native boolean nativeOnDraw(long paramLong, Canvas paramCanvas, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2);
  
  private native void nativeOnSizeChanged(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativePreauthorizePermission(long paramLong1, String paramString, long paramLong2);
  
  private native void nativeRequestNewHitTestDataAt(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private native void nativeScrollTo(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nativeSetAwDrawGLFunctionTable(long paramLong);
  
  private static native void nativeSetAwDrawSWFunctionTable(long paramLong);
  
  private native void nativeSetAwGLFunctor(long paramLong1, long paramLong2);
  
  private native void nativeSetDipScale(long paramLong, float paramFloat);
  
  private native void nativeSetExtraHeadersForUrl(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSetIsPaused(long paramLong, boolean paramBoolean);
  
  private native void nativeSetJavaPeers(long paramLong, AwContents paramAwContents, AwWebContentsDelegate paramAwWebContentsDelegate, AwContentsClientBridge paramAwContentsClientBridge, AwContentsIoThreadClient paramAwContentsIoThreadClient, InterceptNavigationDelegate paramInterceptNavigationDelegate, AutofillProvider paramAutofillProvider);
  
  private static native void nativeSetShouldDownloadFavicons();
  
  private native void nativeSetViewVisibility(long paramLong, boolean paramBoolean);
  
  private native void nativeSetWindowVisibility(long paramLong, boolean paramBoolean);
  
  private native void nativeSmoothScroll(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  private native void nativeTrimMemory(long paramLong, int paramInt, boolean paramBoolean);
  
  private static native void nativeUpdateDefaultLocale(String paramString1, String paramString2);
  
  private native void nativeZoomBy(long paramLong, float paramFloat);
  
  @SuppressLint({"NewApi"})
  private void onContainerViewChanged() {
    AwViewMethods awViewMethods = this.mFullScreenTransitionsState.mInitialAwViewMethods;
    this.mContainerView.getVisibility();
    awViewMethods.onVisibilityChanged$5359dc9a();
    awViewMethods.onWindowVisibilityChanged(this.mContainerView.getWindowVisibility());
    boolean bool = this.mContainerView.isAttachedToWindow();
    if (bool && !this.mIsAttachedToWindow) {
      awViewMethods.onAttachedToWindow();
    } else if (!bool && this.mIsAttachedToWindow) {
      awViewMethods.onDetachedFromWindow();
    } 
    awViewMethods.onSizeChanged(this.mContainerView.getWidth(), this.mContainerView.getHeight(), 0, 0);
    awViewMethods.onWindowFocusChanged(this.mContainerView.hasWindowFocus());
    awViewMethods.onFocusChanged$23eb4535(this.mContainerView.hasFocus());
    this.mContainerView.requestLayout();
    if (this.mAutofillProvider != null)
      this.mAutofillProvider.onContainerViewChanged(this.mContainerView); 
  }
  
  @CalledByNative
  private long onCreateTouchHandle() {
    return (PopupTouchHandleDrawable.create(this.mTouchHandleDrawables, this.mWebContents, this.mContainerView)).mNativeDrawable;
  }
  
  @CalledByNative
  private static void onDocumentHasImagesResponse(boolean paramBoolean, Message paramMessage) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @CalledByNative
  private static void onEvaluateJavaScriptResultForTesting(String paramString, JavaScriptCallback paramJavaScriptCallback) {
    paramJavaScriptCallback.handleJavaScriptResult(paramString);
  }
  
  @CalledByNative
  private void onGeolocationPermissionsHidePrompt() {
    this.mContentsClient.onGeolocationPermissionsHidePrompt();
  }
  
  @CalledByNative
  private void onGeolocationPermissionsShowPrompt(String paramString) {
    if (isDestroyedOrNoOperation(0))
      return; 
    AwGeolocationPermissions awGeolocationPermissions = this.mBrowserContext.getGeolocationPermissions();
    if (!this.mSettings.getGeolocationEnabled()) {
      nativeInvokeGeolocationCallback(this.mNativeAwContents, false, paramString);
      return;
    } 
    if (awGeolocationPermissions.mSharedPreferences.contains(AwGeolocationPermissions.getOriginKey(paramString))) {
      nativeInvokeGeolocationCallback(this.mNativeAwContents, awGeolocationPermissions.isOriginAllowed(paramString), paramString);
      return;
    } 
    this.mContentsClient.onGeolocationPermissionsShowPrompt(paramString, (AwGeolocationPermissions$Callback)new AwGeolocationCallback(paramString, this));
  }
  
  @CalledByNative
  private void onPermissionRequest(AwPermissionRequest paramAwPermissionRequest) {
    this.mContentsClient.onPermissionRequest(paramAwPermissionRequest);
  }
  
  @CalledByNative
  private void onPermissionRequestCanceled(AwPermissionRequest paramAwPermissionRequest) {
    this.mContentsClient.onPermissionRequestCanceled(paramAwPermissionRequest);
  }
  
  @CalledByNative
  private void onReceivedHttpAuthRequest(AwHttpAuthHandler paramAwHttpAuthHandler, String paramString1, String paramString2) {
    this.mContentsClient.onReceivedHttpAuthRequest(paramAwHttpAuthHandler, paramString1, paramString2);
  }
  
  @CalledByNative
  private void onReceivedIcon(Bitmap paramBitmap) {
    this.mContentsClient.onReceivedIcon(paramBitmap);
    this.mFavicon = paramBitmap;
  }
  
  @CalledByNative
  private void onReceivedTouchIconUrl(String paramString, boolean paramBoolean) {
    this.mContentsClient.onReceivedTouchIconUrl(paramString, paramBoolean);
  }
  
  @CalledByNative
  private void onWebLayoutContentsSizeChanged(int paramInt1, int paramInt2) {
    AwLayoutSizer awLayoutSizer = this.mLayoutSizer;
    awLayoutSizer.doUpdate(paramInt1, paramInt2, awLayoutSizer.mPageScaleFactor);
  }
  
  @CalledByNative
  private void onWebLayoutPageScaleFactorChanged(float paramFloat) {
    AwLayoutSizer awLayoutSizer = this.mLayoutSizer;
    awLayoutSizer.doUpdate(awLayoutSizer.mContentWidthCss, awLayoutSizer.mContentHeightCss, paramFloat);
  }
  
  private void postUpdateContentViewCoreVisibility() {
    if (this.mIsUpdateVisibilityTaskPending)
      return; 
    this.mIsUpdateVisibilityTaskPending = true;
    this.mHandler.post(this.mUpdateVisibilityRunnable);
  }
  
  private static void recordHistoryUrl(int paramInt) {
    RecordHistogram.recordEnumeratedHistogram("Android.WebView.LoadDataWithBaseUrl.HistoryUrl", paramInt, 3);
  }
  
  @CalledByNative
  private void scrollContainerViewTo(int paramInt1, int paramInt2) {
    AwScrollOffsetManager awScrollOffsetManager = this.mScrollOffsetManager;
    awScrollOffsetManager.mNativeScrollX = paramInt1;
    awScrollOffsetManager.mNativeScrollY = paramInt2;
    int i = awScrollOffsetManager.mDelegate.getContainerViewScrollX();
    int j = awScrollOffsetManager.mDelegate.getContainerViewScrollY();
    int k = awScrollOffsetManager.mMaxHorizontalScrollOffset;
    int m = awScrollOffsetManager.mMaxVerticalScrollOffset;
    awScrollOffsetManager.mDelegate.overScrollContainerViewBy(paramInt1 - i, paramInt2 - j, i, j, k, m, awScrollOffsetManager.mProcessingTouchEvent);
  }
  
  @CalledByNative
  private void setAwAutofillClient(AwAutofillClient paramAwAutofillClient) {
    this.mAwAutofillClient = paramAwAutofillClient;
    paramAwAutofillClient.mContext = this.mContext;
  }
  
  public static void setAwDrawGLFunctionTable(long paramLong) {
    nativeSetAwDrawGLFunctionTable(paramLong);
  }
  
  public static void setAwDrawSWFunctionTable(long paramLong) {
    nativeSetAwDrawSWFunctionTable(paramLong);
  }
  
  private void setNewAwContentsPreO(long paramLong) {
    if (this.mNativeAwContents != 0L) {
      destroyNatives();
      this.mWebContents = null;
      this.mWebContentsInternalsHolder = null;
      this.mWebContentsInternals = null;
      this.mNavigationController = null;
      this.mJavascriptInjector = null;
    } 
    assert false;
    throw new AssertionError();
  }
  
  public static void setShouldDownloadFavicons() {
    nativeSetShouldDownloadFavicons();
  }
  
  public static void updateDefaultLocale() {
    String str = LocaleUtils.getDefaultLocaleListString();
    if (!sCurrentLocales.equals(str)) {
      sCurrentLocales = str;
      nativeUpdateDefaultLocale(LocaleUtils.getDefaultLocaleString(), sCurrentLocales);
    } 
  }
  
  @CalledByNative
  private void updateHitTestData(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {
    this.mPossiblyStaleHitTestData.hitTestResultType = paramInt;
    this.mPossiblyStaleHitTestData.hitTestResultExtraData = paramString1;
    this.mPossiblyStaleHitTestData.href = paramString2;
    this.mPossiblyStaleHitTestData.anchorText = paramString3;
    this.mPossiblyStaleHitTestData.imgSrc = paramString4;
  }
  
  private void updateNativeAwGLFunctor() {
    long l1;
    long l2 = this.mNativeAwContents;
    if (this.mCurrentFunctor != null) {
      l1 = this.mCurrentFunctor.mNativeAwGLFunctor;
    } else {
      l1 = 0L;
    } 
    nativeSetAwGLFunctor(l2, l1);
  }
  
  @CalledByNative
  private void updateScrollState(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3) {
    this.mContentWidthDip = paramInt3;
    this.mContentHeightDip = paramInt4;
    AwScrollOffsetManager awScrollOffsetManager = this.mScrollOffsetManager;
    awScrollOffsetManager.mMaxHorizontalScrollOffset = paramInt1;
    awScrollOffsetManager.mMaxVerticalScrollOffset = paramInt2;
    if (this.mPageScaleFactor != paramFloat1 || this.mMinPageScaleFactor != paramFloat2 || this.mMaxPageScaleFactor != paramFloat3) {
      this.mMinPageScaleFactor = paramFloat2;
      this.mMaxPageScaleFactor = paramFloat3;
      if (this.mPageScaleFactor != paramFloat1) {
        paramFloat2 = this.mPageScaleFactor;
        this.mPageScaleFactor = paramFloat1;
        paramFloat1 = getDeviceScaleFactor();
        AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mContentsClient.mCallbackHelper;
        paramFloat3 = this.mPageScaleFactor;
        awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(7, Float.floatToIntBits(paramFloat2 * paramFloat1), Float.floatToIntBits(paramFloat3 * paramFloat1)));
      } 
    } 
  }
  
  @CalledByNative
  private boolean useLegacyGeolocationPermissionAPI() {
    return true;
  }
  
  @CalledByNative
  protected boolean canShowInterstitial() {
    return (this.mIsAttachedToWindow && this.mIsViewVisible);
  }
  
  public final boolean canZoomIn() {
    return isDestroyedOrNoOperation(1) ? false : ((this.mMaxPageScaleFactor - this.mPageScaleFactor > 0.007F));
  }
  
  public final boolean canZoomOut() {
    return isDestroyedOrNoOperation(1) ? false : ((this.mPageScaleFactor - this.mMinPageScaleFactor > 0.007F));
  }
  
  public final Picture capturePicture() {
    return isDestroyedOrNoOperation(1) ? null : new AwPicture(nativeCapturePicture(this.mNativeAwContents, this.mScrollOffsetManager.computeHorizontalScrollRange(), this.mScrollOffsetManager.computeVerticalScrollRange()));
  }
  
  public final void destroy() {
    if (isDestroyed(0))
      return; 
    this.mContentsClient.mCallbackHelper.mHandler.removeCallbacksAndMessages(null);
    if (this.mIsAttachedToWindow) {
      Log.w("AwContents", "WebView.destroy() called while WebView is still attached to window.", new Object[0]);
      onDetachedFromWindow();
    } 
    this.mIsNoOperation = true;
    this.mIsDestroyed = true;
    this.mHandler.post(new AwContents$$Lambda$3(this));
  }
  
  final void destroyNatives() {
    if (this.mCleanupReference != null)
      if ($assertionsDisabled || this.mNativeAwContents != 0L) {
        this.mWebContentsObserver.destroy();
        this.mWebContentsObserver = null;
        this.mNativeAwContents = 0L;
        this.mWebContents = null;
        this.mWebContentsInternals = null;
        this.mNavigationController = null;
        this.mCleanupReference.handleOnUiThread(2);
        this.mCleanupReference = null;
      } else {
        throw new AssertionError();
      }  
    assert false;
    throw new AssertionError();
  }
  
  public final void evaluateJavaScript(String paramString, Callback paramCallback) {
    if (isDestroyedOrNoOperation(1))
      return; 
    AwContents$$Lambda$7 awContents$$Lambda$7 = null;
    if (paramCallback != null)
      awContents$$Lambda$7 = new AwContents$$Lambda$7(this, paramCallback); 
    this.mWebContents.evaluateJavaScript(paramString, awContents$$Lambda$7);
  }
  
  public void extractSmartClipData(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!isDestroyedOrNoOperation(1))
      this.mWebContents.requestSmartClipExtract(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public final float getDeviceScaleFactor() {
    return this.mWindowAndroid.mWindowAndroid.mDisplayAndroid.mDipScale;
  }
  
  final int getEffectiveBackgroundColor() {
    if (isDestroyedOrNoOperation(0) || !this.mContentsClient.isCachedRendererBackgroundColorValid())
      return this.mBaseBackgroundColor; 
    AwContentsClient awContentsClient = this.mContentsClient;
    if (AwContentsClient.$assertionsDisabled || awContentsClient.isCachedRendererBackgroundColorValid())
      return awContentsClient.mCachedRendererBackgroundColor; 
    throw new AssertionError();
  }
  
  public final JavascriptInjector getJavascriptInjector() {
    if (this.mJavascriptInjector == null)
      this.mJavascriptInjector = JavascriptInjectorImpl.fromWebContents(this.mWebContents); 
    return this.mJavascriptInjector;
  }
  
  public final String getOriginalUrl() {
    if (isDestroyedOrNoOperation(1))
      return null; 
    NavigationHistory navigationHistory = this.mNavigationController.getNavigationHistory();
    int i = navigationHistory.mCurrentEntryIndex;
    return (i >= 0 && i < navigationHistory.mEntries.size()) ? (navigationHistory.getEntryAtIndex(i)).mOriginalUrl : null;
  }
  
  public final TextClassifier getTextClassifier() {
    assert false;
    throw new AssertionError();
  }
  
  public final String getTitle() {
    return isDestroyedOrNoOperation(1) ? null : this.mWebContents.getTitle();
  }
  
  public final void hideAutofillPopup() {
    if (this.mAwAutofillClient != null)
      this.mAwAutofillClient.hideAutofillPopup(); 
  }
  
  @CalledByNative
  public void invokeVisualStateCallback(AwContents$VisualStateCallback paramAwContents$VisualStateCallback, long paramLong) {
    if (isDestroyedOrNoOperation(0))
      return; 
    this.mHandler.post(new AwContents$$Lambda$9(paramAwContents$VisualStateCallback, paramLong));
  }
  
  public final boolean isDestroyed(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mIsDestroyed : Z
    //   4: ifeq -> 35
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne -> 35
    //   12: ldc_w 'AwContents'
    //   15: ldc_w 'Application attempted to call on a destroyed WebView'
    //   18: iconst_1
    //   19: anewarray java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: new java/lang/Throwable
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: aastore
    //   32: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield mCleanupReference : Lorg/chromium/android_webview/CleanupReference;
    //   39: ifnull -> 68
    //   42: aload_0
    //   43: getfield mCleanupReference : Lorg/chromium/android_webview/CleanupReference;
    //   46: getfield mCleanupTask : Ljava/lang/Runnable;
    //   49: ifnonnull -> 57
    //   52: iconst_1
    //   53: istore_1
    //   54: goto -> 59
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: ifeq -> 68
    //   63: iconst_1
    //   64: istore_1
    //   65: goto -> 70
    //   68: iconst_0
    //   69: istore_1
    //   70: aload_0
    //   71: getfield mWebContentsInternalsHolder : Lorg/chromium/android_webview/AwContents$WebContentsInternalsHolder;
    //   74: ifnull -> 106
    //   77: aload_0
    //   78: getfield mWebContentsInternalsHolder : Lorg/chromium/android_webview/AwContents$WebContentsInternalsHolder;
    //   81: getfield mAwContentsRef : Ljava/lang/ref/WeakReference;
    //   84: invokevirtual get : ()Ljava/lang/Object;
    //   87: ifnonnull -> 95
    //   90: iconst_1
    //   91: istore_2
    //   92: goto -> 97
    //   95: iconst_0
    //   96: istore_2
    //   97: iload_2
    //   98: ifeq -> 106
    //   101: iconst_1
    //   102: istore_2
    //   103: goto -> 108
    //   106: iconst_0
    //   107: istore_2
    //   108: aload_0
    //   109: getfield mIsDestroyed : Z
    //   112: ifne -> 127
    //   115: iload_1
    //   116: ifne -> 127
    //   119: iload_2
    //   120: ifeq -> 125
    //   123: iconst_1
    //   124: ireturn
    //   125: iconst_0
    //   126: ireturn
    //   127: iconst_1
    //   128: ireturn
  }
  
  public final boolean isDestroyedOrNoOperation(int paramInt) {
    return (isDestroyed(paramInt) || this.mIsNoOperation);
  }
  
  final boolean isFullScreen() {
    return (this.mFullScreenTransitionsState.mFullScreenView != null);
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3) {
    if (isDestroyedOrNoOperation(1))
      return; 
    if (paramString1 != null && paramString1.contains("#"))
      RecordHistogram.recordBooleanHistogram("Android.WebView.LoadUrl.DataUriHasOctothorpe", true); 
    loadUrl(LoadUrlParams.createLoadDataParams(fixupData(paramString1), fixupMimeType(paramString2), "base64".equals(paramString3)));
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokevirtual isDestroyedOrNoOperation : (I)Z
    //   5: ifeq -> 9
    //   8: return
    //   9: aload_2
    //   10: ifnull -> 30
    //   13: aload_2
    //   14: ldc_w '#'
    //   17: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   20: ifeq -> 30
    //   23: ldc_w 'Android.WebView.LoadUrl.DataUriHasOctothorpe'
    //   26: iconst_1
    //   27: invokestatic recordBooleanHistogram : (Ljava/lang/String;Z)V
    //   30: aload_2
    //   31: invokestatic fixupData : (Ljava/lang/String;)Ljava/lang/String;
    //   34: astore #8
    //   36: aload_3
    //   37: invokestatic fixupMimeType : (Ljava/lang/String;)Ljava/lang/String;
    //   40: astore_3
    //   41: aload_1
    //   42: astore_2
    //   43: aload_1
    //   44: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   47: ifeq -> 54
    //   50: ldc_w 'about:blank'
    //   53: astore_2
    //   54: aload #5
    //   56: astore_1
    //   57: aload #5
    //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   62: ifeq -> 69
    //   65: ldc_w 'about:blank'
    //   68: astore_1
    //   69: aload_1
    //   70: ldc_w 'about:blank'
    //   73: invokevirtual equals : (Ljava/lang/Object;)Z
    //   76: istore #7
    //   78: iconst_0
    //   79: istore #6
    //   81: iload #7
    //   83: ifeq -> 93
    //   86: iconst_0
    //   87: invokestatic recordHistoryUrl : (I)V
    //   90: goto -> 112
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual equals : (Ljava/lang/Object;)Z
    //   98: ifeq -> 108
    //   101: iconst_1
    //   102: invokestatic recordHistoryUrl : (I)V
    //   105: goto -> 112
    //   108: iconst_2
    //   109: invokestatic recordHistoryUrl : (I)V
    //   112: aload_2
    //   113: ldc_w 'data:'
    //   116: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   119: ifeq -> 156
    //   122: ldc_w 'base64'
    //   125: aload #4
    //   127: invokevirtual equals : (Ljava/lang/Object;)Z
    //   130: istore #7
    //   132: iload #7
    //   134: ifeq -> 140
    //   137: aconst_null
    //   138: astore #4
    //   140: aload #8
    //   142: aload_3
    //   143: iload #7
    //   145: aload_2
    //   146: aload_1
    //   147: aload #4
    //   149: invokestatic createLoadDataParamsWithBaseUrl : (Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/chromium/content_public/browser/LoadUrlParams;
    //   152: astore_1
    //   153: goto -> 179
    //   156: aload #8
    //   158: ldc_w 'utf-8'
    //   161: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   164: iconst_0
    //   165: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   168: aload_3
    //   169: iconst_1
    //   170: aload_2
    //   171: aload_1
    //   172: ldc_w 'utf-8'
    //   175: invokestatic createLoadDataParamsWithBaseUrl : (Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/chromium/content_public/browser/LoadUrlParams;
    //   178: astore_1
    //   179: aload_0
    //   180: getfield mContext : Landroid/content/Context;
    //   183: invokevirtual getPackageName : ()Ljava/lang/String;
    //   186: astore_2
    //   187: ldc_w 'com.android.email'
    //   190: aload_2
    //   191: invokevirtual equals : (Ljava/lang/Object;)Z
    //   194: ifne -> 213
    //   197: ldc_w 'com.samsung.android.email.composer'
    //   200: aload_2
    //   201: invokevirtual equals : (Ljava/lang/Object;)Z
    //   204: ifeq -> 210
    //   207: goto -> 213
    //   210: goto -> 216
    //   213: iconst_1
    //   214: istore #6
    //   216: iload #6
    //   218: ifeq -> 250
    //   221: ldc_w 'email://'
    //   224: aload_1
    //   225: getfield mBaseUrlForDataUrl : Ljava/lang/String;
    //   228: invokevirtual equals : (Ljava/lang/Object;)Z
    //   231: ifeq -> 250
    //   234: new org/chromium/android_webview/AwContents$$Lambda$6
    //   237: dup
    //   238: aload_0
    //   239: aload_1
    //   240: invokespecial <init> : (Lorg/chromium/android_webview/AwContents;Lorg/chromium/content_public/browser/LoadUrlParams;)V
    //   243: ldc2_w 200
    //   246: invokestatic postOnUiThreadDelayed : (Ljava/lang/Runnable;J)V
    //   249: return
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual loadUrl : (Lorg/chromium/content_public/browser/LoadUrlParams;)V
    //   255: return
    //   256: astore_1
    //   257: ldc_w 'AwContents'
    //   260: ldc_w 'Unable to load data string %s'
    //   263: iconst_2
    //   264: anewarray java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload #8
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: aload_1
    //   275: aastore
    //   276: invokestatic wtf : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: return
    // Exception table:
    //   from	to	target	type
    //   156	179	256	java/io/UnsupportedEncodingException
  }
  
  public final void loadUrl(String paramString) {
    if (isDestroyedOrNoOperation(1))
      return; 
    if (paramString == null)
      return; 
    loadUrl(paramString, null);
  }
  
  public final void loadUrl(String paramString, Map<?, ?> paramMap) {
    if (isDestroyedOrNoOperation(1))
      return; 
    if (this.mAppTargetSdkVersion < 19 && paramString != null && paramString.startsWith("javascript:")) {
      evaluateJavaScript(paramString.substring(11), null);
      return;
    } 
    LoadUrlParams loadUrlParams = new LoadUrlParams(paramString);
    if (paramMap != null)
      loadUrlParams.mExtraHeaders = new HashMap<Object, Object>(paramMap); 
    if (paramString != null && paramString.startsWith("data:") && paramString.contains("#"))
      RecordHistogram.recordBooleanHistogram("Android.WebView.LoadUrl.DataUriHasOctothorpe", true); 
    loadUrl(loadUrlParams);
  }
  
  public final void loadUrl(LoadUrlParams paramLoadUrlParams) {
    if (paramLoadUrlParams.mLoadUrlType == 2) {
      boolean bool;
      if (paramLoadUrlParams.mBaseUrlForDataUrl == null && paramLoadUrlParams.mLoadUrlType == 2) {
        bool = true;
      } else {
        bool = LoadUrlParams.nativeIsDataScheme(paramLoadUrlParams.mBaseUrlForDataUrl);
      } 
      if (!bool) {
        paramLoadUrlParams.mCanLoadLocalResources = true;
        nativeGrantFileSchemeAccesstoChildProcess(this.mNativeAwContents);
      } 
    } 
    if (paramLoadUrlParams.mUrl != null && paramLoadUrlParams.mUrl.equals(this.mWebContents.getLastCommittedUrl()) && paramLoadUrlParams.mTransitionType == 0)
      paramLoadUrlParams.mTransitionType = 8; 
    paramLoadUrlParams.mTransitionType |= 0x8000000;
    paramLoadUrlParams.mUaOverrideOption = 2;
    Map map = paramLoadUrlParams.mExtraHeaders;
    if (map != null)
      for (String str : map.keySet()) {
        if ("referer".equals(str.toLowerCase(Locale.US))) {
          paramLoadUrlParams.mReferrer = new Referrer((String)map.remove(str), 1);
          paramLoadUrlParams.mExtraHeaders = map;
          break;
        } 
      }  
    nativeSetExtraHeadersForUrl(this.mNativeAwContents, paramLoadUrlParams.mUrl, paramLoadUrlParams.getExtraHeadersString("\r\n", true));
    paramLoadUrlParams.mExtraHeaders = new HashMap<Object, Object>();
    this.mNavigationController.loadUrl(paramLoadUrlParams);
    if (!this.mHasRequestedVisitedHistoryFromClient) {
      this.mHasRequestedVisitedHistoryFromClient = true;
      AwContents$$Lambda$5 awContents$$Lambda$5 = new AwContents$$Lambda$5(this);
      this.mContentsClient.getVisitedHistory(awContents$$Lambda$5);
    } 
  }
  
  native void nativeAddVisitedLinks(long paramLong, String[] paramArrayOfString);
  
  public native void nativeClearCache(long paramLong, boolean paramBoolean);
  
  public native void nativeClearMatches(long paramLong);
  
  public native void nativeClearView(long paramLong);
  
  public native void nativeCreatePdfExporter(long paramLong, AwPdfExporter paramAwPdfExporter);
  
  public native void nativeDocumentHasImages(long paramLong, Message paramMessage);
  
  public native void nativeEnableOnNewPicture(long paramLong, boolean paramBoolean);
  
  public native void nativeFindAllAsync(long paramLong, String paramString);
  
  public native void nativeFindNext(long paramLong, boolean paramBoolean);
  
  public native byte[] nativeGetCertificate(long paramLong);
  
  public native byte[] nativeGetOpaqueState(long paramLong);
  
  public native void nativeInsertVisualStateCallback(long paramLong1, long paramLong2, AwContents$VisualStateCallback paramAwContents$VisualStateCallback);
  
  public native void nativeInvokeGeolocationCallback(long paramLong, boolean paramBoolean, String paramString);
  
  public native long nativeReleasePopupAwContents(long paramLong);
  
  public native boolean nativeRestoreFromOpaqueState(long paramLong, byte[] paramArrayOfbyte);
  
  public native void nativeResumeLoadingCreatedPopupWebContents(long paramLong);
  
  public native void nativeSetBackgroundColor(long paramLong, int paramInt);
  
  public native void nativeSetJsOnlineProperty(long paramLong, boolean paramBoolean);
  
  public native void nativeUpdateLastHitTestData(long paramLong);
  
  public final void onAttachedToWindow() {
    this.mTemporarilyDetached = false;
    this.mAwViewMethods.onAttachedToWindow();
    this.mWindowAndroid.mWindowAndroid.mDisplayAndroid.addObserver(this.mDisplayObserver);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public final void onDetachedFromWindow() {
    this.mWindowAndroid.mWindowAndroid.mDisplayAndroid.removeObserver(this.mDisplayObserver);
    this.mAwViewMethods.onDetachedFromWindow();
  }
  
  @CalledByNative
  public void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.mContentsClient.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
  }
  
  public final void onFocusChanged$23eb4535(boolean paramBoolean) {
    if (!this.mTemporarilyDetached)
      this.mAwViewMethods.onFocusChanged$23eb4535(paramBoolean); 
  }
  
  @CalledByNative
  public void onNewPicture() {
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mContentsClient.mCallbackHelper;
    Callable callable = this.mPictureListenerContentProvider;
    if (!awContentsClientCallbackHelper.mHasPendingOnNewPicture) {
      awContentsClientCallbackHelper.mHasPendingOnNewPicture = true;
      long l = Math.max(awContentsClientCallbackHelper.mLastPictureTime + 500L, SystemClock.uptimeMillis());
      awContentsClientCallbackHelper.mHandler.sendMessageAtTime(awContentsClientCallbackHelper.mHandler.obtainMessage(6, callable), l);
    } 
  }
  
  public final void onPause() {
    if (!this.mIsPaused) {
      if (isDestroyedOrNoOperation(0))
        return; 
      this.mIsPaused = true;
      nativeSetIsPaused(this.mNativeAwContents, this.mIsPaused);
      updateContentViewCoreVisibility();
      return;
    } 
  }
  
  @CalledByNative
  protected void onRenderProcessGone(int paramInt) {
    this.mIsNoOperation = true;
  }
  
  @CalledByNative
  protected boolean onRenderProcessGoneDetail(int paramInt, boolean paramBoolean) {
    return isDestroyed(0) ? true : this.mContentsClient.onRenderProcessGone(new AwRenderProcessGoneDetail(paramBoolean, nativeGetEffectivePriority(this.mNativeAwContents)));
  }
  
  public final void onResume() {
    if (this.mIsPaused) {
      if (isDestroyedOrNoOperation(0))
        return; 
      this.mIsPaused = false;
      nativeSetIsPaused(this.mNativeAwContents, this.mIsPaused);
      updateContentViewCoreVisibility();
      return;
    } 
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mAwViewMethods.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    this.mAwViewMethods.onWindowFocusChanged(paramBoolean);
  }
  
  @CalledByNative
  public void postInvalidateOnAnimation() {
    if (!this.mWindowAndroid.mWindowAndroid.mVSyncMonitor.mInsideVSync) {
      this.mContainerView.postInvalidateOnAnimation();
      return;
    } 
    this.mContainerView.invalidate();
  }
  
  public final void postUrl(String paramString, byte[] paramArrayOfbyte) {
    if (isDestroyedOrNoOperation(1))
      return; 
    LoadUrlParams loadUrlParams = LoadUrlParams.createLoadHttpPostParams(paramString, paramArrayOfbyte);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Content-Type", "application/x-www-form-urlencoded");
    loadUrlParams.mExtraHeaders = hashMap;
    loadUrl(loadUrlParams);
  }
  
  final void requestExitFullscreen() {
    if (!isDestroyedOrNoOperation(0))
      this.mWebContents.exitFullscreen(); 
  }
  
  public final void saveWebArchiveInternal(String paramString, Callback paramCallback) {
    if (paramString == null || isDestroyedOrNoOperation(1)) {
      if (paramCallback == null)
        return; 
      ThreadUtils.runOnUiThread(new AwContents$$Lambda$11(paramCallback));
      return;
    } 
    nativeGenerateMHTML(this.mNativeAwContents, paramString, paramCallback);
  }
  
  final void setContainerView(ViewGroup paramViewGroup, AwGLFunctor paramAwGLFunctor) {
    this.mContainerView = paramViewGroup;
    this.mCurrentFunctor = paramAwGLFunctor;
    updateNativeAwGLFunctor();
    this.mContainerView.setWillNotDraw(false);
    AwViewAndroidDelegate awViewAndroidDelegate = this.mViewAndroidDelegate;
    ViewGroup viewGroup1 = this.mContainerView;
    ViewGroup viewGroup2 = awViewAndroidDelegate.mContainerView;
    awViewAndroidDelegate.mContainerView = viewGroup1;
    awViewAndroidDelegate.updateAnchorViews(viewGroup2);
    Iterator<ViewAndroidDelegate.ContainerViewObserver> iterator = awViewAndroidDelegate.mContainerViewObservers.iterator();
    while (iterator.hasNext())
      ((ViewAndroidDelegate.ContainerViewObserver)iterator.next()).onUpdateContainerView(viewGroup1); 
    if (this.mAwPdfExporter != null)
      this.mAwPdfExporter.mContainerView = this.mContainerView; 
    this.mWebContentsDelegate.setContainerView((View)this.mContainerView);
    for (PopupTouchHandleDrawable popupTouchHandleDrawable : this.mTouchHandleDrawables) {
      popupTouchHandleDrawable.mParentPositionObserver.mListeners.clear();
      popupTouchHandleDrawable.mParentPositionObserver = new ViewPositionObserver((View)paramViewGroup);
      if (popupTouchHandleDrawable.mContainer.isShowing())
        popupTouchHandleDrawable.mParentPositionObserver.addListener(popupTouchHandleDrawable.mParentPositionListener); 
      popupTouchHandleDrawable.mContainerView = paramViewGroup;
    } 
    onContainerViewChanged();
  }
  
  final void setInternalAccessAdapter(AwContents$InternalAccessDelegate paramAwContents$InternalAccessDelegate) {
    this.mInternalAccessAdapter = paramAwContents$InternalAccessDelegate;
    this.mViewEventSink.setAccessDelegate(this.mInternalAccessAdapter);
  }
  
  public final void setLayerType$42d5a443(int paramInt) {
    this.mAwViewMethods.setLayerType$42d5a443(paramInt);
  }
  
  public final void setNewAwContents(long paramLong) {
    TextClassifier textClassifier;
    if (Build.VERSION.SDK_INT < 26) {
      setNewAwContentsPreO(paramLong);
      return;
    } 
    if (this.mWebContents != null) {
      textClassifier = getTextClassifier();
    } else {
      textClassifier = null;
    } 
    setNewAwContentsPreO(paramLong);
    if (textClassifier != null)
      setTextClassifier(textClassifier); 
  }
  
  public final void setOverScrollMode(int paramInt) {
    if (paramInt != 2) {
      this.mOverScrollGlow = new OverScrollGlow(this.mContext, (View)this.mContainerView);
      return;
    } 
    this.mOverScrollGlow = null;
  }
  
  public final void setScrollBarStyle(int paramInt) {
    if (paramInt == 0 || paramInt == 33554432) {
      this.mOverlayVerticalScrollbar = true;
      this.mOverlayHorizontalScrollbar = true;
      return;
    } 
    this.mOverlayVerticalScrollbar = false;
    this.mOverlayHorizontalScrollbar = false;
  }
  
  public void setSmartClipResultHandler(Handler paramHandler) {
    if (isDestroyedOrNoOperation(1))
      return; 
    this.mWebContents.setSmartClipResultHandler(paramHandler);
  }
  
  public final void setTextClassifier(TextClassifier paramTextClassifier) {
    assert false;
    throw new AssertionError();
  }
  
  public final void setViewVisibilityInternal(boolean paramBoolean) {
    this.mIsViewVisible = paramBoolean;
    if (!isDestroyedOrNoOperation(0))
      nativeSetViewVisibility(this.mNativeAwContents, this.mIsViewVisible); 
    postUpdateContentViewCoreVisibility();
  }
  
  public final void setWindowVisibilityInternal(boolean paramBoolean) {
    boolean bool1;
    boolean bool2 = this.mInvalidateRootViewOnNextDraw;
    if (Build.VERSION.SDK_INT <= 21 && paramBoolean && !this.mIsWindowVisible) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.mInvalidateRootViewOnNextDraw = bool2 | bool1;
    this.mIsWindowVisible = paramBoolean;
    if (!isDestroyedOrNoOperation(0))
      nativeSetWindowVisibility(this.mNativeAwContents, this.mIsWindowVisible); 
    postUpdateContentViewCoreVisibility();
  }
  
  public final void updateChildProcessImportance() {
    boolean bool = this.mRendererPriorityWaivedWhenNotVisible;
    byte b = 0;
    if (!bool || this.mIsContentVisible)
      switch (this.mRendererPriority) {
        default:
          assert false;
        case 1:
          b = 1;
          break;
        case 0:
          break;
        case -1:
        case 2:
          b = 2;
          break;
      }  
    this.mWebContents.setImportance(b);
  }
  
  final void updateContentViewCoreVisibility() {
    this.mIsUpdateVisibilityTaskPending = false;
    if (isDestroyedOrNoOperation(0))
      return; 
    boolean bool = nativeIsVisible(this.mNativeAwContents);
    if (bool && !this.mIsContentVisible) {
      this.mWebContents.onShow();
    } else if (!bool && this.mIsContentVisible) {
      this.mWebContents.onHide();
    } 
    this.mIsContentVisible = bool;
    updateChildProcessImportance();
  }
  
  public final void zoomBy(float paramFloat) {
    if (isDestroyedOrNoOperation(1))
      return; 
    if (paramFloat >= 0.01F && paramFloat <= 100.0F) {
      nativeZoomBy(this.mNativeAwContents, paramFloat);
      return;
    } 
    throw new IllegalStateException("zoom delta value outside [0.01, 100] range.");
  }
  
  public final boolean zoomIn() {
    if (!canZoomIn())
      return false; 
    zoomBy(1.25F);
    return true;
  }
  
  public final boolean zoomOut() {
    if (!canZoomOut())
      return false; 
    zoomBy(0.8F);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */