package com.android.webview.chromium;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.print.PrintDocumentAdapter;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.webkit.DownloadListener;
import android.webkit.FindActionModeCallback;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewProvider;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.chromium.android_webview.AwContents;
import org.chromium.android_webview.AwPdfExporter;
import org.chromium.android_webview.AwPrintDocumentAdapter;
import org.chromium.android_webview.AwScrollOffsetManager;
import org.chromium.android_webview.AwSettings;
import org.chromium.android_webview.ResourcesContextWrapperFactory;
import org.chromium.android_webview.ScopedSysTraceEvent;
import org.chromium.android_webview.SslUtil;
import org.chromium.base.AsyncTask;
import org.chromium.base.Callback;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid;
import org.chromium.content.browser.ContentViewStaticsImpl;
import org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.browser.SmartClipProvider;
import org.chromium.content_public.browser.WebContents;
import org.chromium.net.NetworkChangeNotifier;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_callback_glue.SupportLibWebViewContentsClientAdapter;

public class WebViewChromium implements WebViewProvider, WebViewProvider.ScrollDelegate, WebViewProvider.ViewDelegate, SmartClipProvider {
  private static final String TAG;
  
  private static boolean sRecordWholeDocumentEnabledByApi;
  
  private final int mAppTargetSdkVersion;
  
  AwContents mAwContents;
  
  private WebViewContentsClientAdapter mContentsClientAdapter;
  
  private Context mContext;
  
  protected WebViewChromiumFactoryProvider mFactory;
  
  private final WebView.HitTestResult mHitTestResult;
  
  public final SharedWebViewChromium mSharedWebViewChromium;
  
  private final boolean mShouldDisableThreadChecking;
  
  private ContentSettingsAdapter mWebSettings;
  
  WebView mWebView;
  
  WebView.PrivateAccess mWebViewPrivate;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public WebViewChromium(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider, WebView paramWebView, WebView.PrivateAccess paramPrivateAccess, boolean paramBoolean) {
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("WebViewChromium.constructor");
    Throwable throwable2 = null;
    Throwable throwable1 = throwable2;
    try {
      WebViewChromiumFactoryProvider.checkStorageIsNotDeviceProtected(paramWebView.getContext());
      throwable1 = throwable2;
      this.mWebView = paramWebView;
      throwable1 = throwable2;
      this.mWebViewPrivate = paramPrivateAccess;
      throwable1 = throwable2;
      this.mHitTestResult = new WebView.HitTestResult();
      throwable1 = throwable2;
      this.mContext = ResourcesContextWrapperFactory.get(this.mWebView.getContext());
      throwable1 = throwable2;
      this.mAppTargetSdkVersion = (this.mContext.getApplicationInfo()).targetSdkVersion;
      throwable1 = throwable2;
      this.mFactory = paramWebViewChromiumFactoryProvider;
      throwable1 = throwable2;
      this.mShouldDisableThreadChecking = paramBoolean;
      throwable1 = throwable2;
      paramWebViewChromiumFactoryProvider.mWebViewDelegate.addWebViewAssetPath(this.mWebView.getContext());
      throwable1 = throwable2;
      this.mSharedWebViewChromium = new SharedWebViewChromium(this.mFactory.mRunQueue, this.mFactory.mAwInit);
      if (scopedSysTraceEvent != null) {
        $closeResource(null, scopedSysTraceEvent);
        return;
      } 
      return;
    } catch (Throwable throwable) {
      throwable1 = throwable;
      throw throwable;
    } finally {}
    if (scopedSysTraceEvent != null)
      $closeResource(throwable1, scopedSysTraceEvent); 
    throw paramWebViewChromiumFactoryProvider;
  }
  
  private static void checkThread() {
    if (ThreadUtils.runningOnUiThread())
      return; 
    ThreadUtils.postOnUiThread(new WebViewChromium$3(createThreadException()));
    throw createThreadException();
  }
  
  static void completeWindowCreation(WebView paramWebView1, WebView paramWebView2) {
    AwContents awContents1;
    AwContents awContents2 = ((WebViewChromium)paramWebView1.getWebViewProvider()).mAwContents;
    if (paramWebView2 == null) {
      paramWebView1 = null;
    } else {
      awContents1 = ((WebViewChromium)paramWebView2.getWebViewProvider()).mAwContents;
    } 
    if (!awContents2.isDestroyedOrNoOperation(1)) {
      long l = awContents2.nativeReleasePopupAwContents(awContents2.mNativeAwContents);
      if (l == 0L) {
        Log.w("AwContents", "Popup WebView bind failed: no pending content.", new Object[0]);
        if (awContents1 != null)
          awContents1.destroy(); 
        return;
      } 
      if (awContents1 == null) {
        AwContents.nativeDestroy(l);
        return;
      } 
      if (!awContents1.isDestroyedOrNoOperation(1)) {
        boolean bool1 = awContents1.mIsAttachedToWindow;
        boolean bool2 = awContents1.mIsViewVisible;
        boolean bool3 = awContents1.mIsWindowVisible;
        boolean bool4 = awContents1.mIsPaused;
        boolean bool5 = awContents1.mContainerViewFocused;
        boolean bool6 = awContents1.mWindowFocused;
        if (bool5)
          awContents1.onFocusChanged$23eb4535(false); 
        if (bool6)
          awContents1.onWindowFocusChanged(false); 
        if (bool2)
          awContents1.setViewVisibilityInternal(false); 
        if (bool3)
          awContents1.setWindowVisibilityInternal(false); 
        if (bool1)
          awContents1.onDetachedFromWindow(); 
        if (!bool4)
          awContents1.onPause(); 
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (awContents1.mWebContents != null)
          hashMap.putAll(awContents1.getJavascriptInjector().getInterfaces()); 
        awContents1.setNewAwContents(l);
        awContents1.nativeResumeLoadingCreatedPopupWebContents(awContents1.mNativeAwContents);
        if (!bool4)
          awContents1.onResume(); 
        if (bool1) {
          awContents1.onAttachedToWindow();
          awContents1.postInvalidateOnAnimation();
        } 
        awContents1.onSizeChanged(awContents1.mContainerView.getWidth(), awContents1.mContainerView.getHeight(), 0, 0);
        if (bool3)
          awContents1.setWindowVisibilityInternal(true); 
        if (bool2)
          awContents1.setViewVisibilityInternal(true); 
        if (bool6)
          awContents1.onWindowFocusChanged(bool6); 
        if (bool5)
          awContents1.onFocusChanged$23eb4535(true); 
        awContents1.mIsPopupWindow = true;
        for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
          Class clazz = (Class)((Pair)entry.getValue()).second;
          awContents1.getJavascriptInjector().addPossiblyUnsafeInterface(((Pair)entry.getValue()).first, (String)entry.getKey(), clazz);
        } 
      } 
    } 
  }
  
  private static RuntimeException createThreadException() {
    return new IllegalStateException("Calling View methods on another thread than the UI thread.");
  }
  
  private static boolean doesSupportFullscreen(WebChromeClient paramWebChromeClient) {
    if (paramWebChromeClient == null)
      return false; 
    Class<?> clazz = paramWebChromeClient.getClass();
    boolean bool2 = false;
    boolean bool1;
    for (bool1 = false; clazz != WebChromeClient.class && (!bool2 || !bool1); bool1 = bool4) {
      boolean bool3 = bool2;
      if (!bool2)
        try {
          clazz.getDeclaredMethod("onShowCustomView", new Class[] { View.class, WebChromeClient.CustomViewCallback.class });
          bool3 = true;
        } catch (NoSuchMethodException noSuchMethodException) {
          bool3 = bool2;
        }  
      boolean bool4 = bool1;
      if (!bool1)
        try {
          clazz.getDeclaredMethod("onHideCustomView", new Class[0]);
          bool4 = true;
        } catch (NoSuchMethodException noSuchMethodException) {
          bool4 = bool1;
        }  
      clazz = clazz.getSuperclass();
      bool2 = bool3;
    } 
    return (bool2 && bool1);
  }
  
  static void enableSlowWholeDocumentDraw() {
    sRecordWholeDocumentEnabledByApi = true;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$59(this, paramObject, paramString));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1)) {
      Class<JavascriptInterface> clazz = null;
      if (awContents.mAppTargetSdkVersion >= 17)
        clazz = JavascriptInterface.class; 
      awContents.getJavascriptInjector().addPossiblyUnsafeInterface(paramObject, paramString, clazz);
    } 
  }
  
  public void autofill(SparseArray paramSparseArray) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      this.mFactory.runVoidTaskOnUiThreadBlocking(new WebViewChromium$64(this, paramSparseArray)); 
    AwContents awContents = this.mAwContents;
    if (awContents.mAutofillProvider != null)
      awContents.mAutofillProvider.autofill(paramSparseArray); 
  }
  
  public boolean canGoBack() {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$24(this))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? false : awContents.mNavigationController.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$28(this, paramInt))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? false : awContents.mNavigationController.canGoToOffset(paramInt);
  }
  
  public boolean canGoForward() {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$26(this))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? false : awContents.mNavigationController.canGoForward();
  }
  
  public boolean canZoomIn() {
    return this.mSharedWebViewChromium.checkNeedsPost() ? false : this.mAwContents.canZoomIn();
  }
  
  public boolean canZoomOut() {
    return this.mSharedWebViewChromium.checkNeedsPost() ? false : this.mAwContents.canZoomOut();
  }
  
  public Picture capturePicture() {
    this.mFactory.startYourEngines(true);
    return this.mSharedWebViewChromium.checkNeedsPost() ? (Picture)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$34(this)) : this.mAwContents.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$48(this, paramBoolean));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.nativeClearCache(awContents.mNativeAwContents, paramBoolean); 
  }
  
  public void clearFormData() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$49(this));
      return;
    } 
    this.mAwContents.hideAutofillPopup();
  }
  
  public void clearHistory() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$50(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mNavigationController.clearHistory(); 
  }
  
  public void clearMatches() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$56(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.nativeClearMatches(awContents.mNativeAwContents); 
  }
  
  public void clearSslPreferences() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$51(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mNavigationController.clearSslPreferences(); 
  }
  
  public void clearView() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$33(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.nativeClearView(awContents.mNativeAwContents); 
  }
  
  public int computeHorizontalScrollOffset() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Integer)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$99(this))).intValue() : this.mAwContents.mAwViewMethods.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Integer)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$98(this))).intValue() : this.mAwContents.mAwViewMethods.computeHorizontalScrollRange();
  }
  
  public void computeScroll() {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.runVoidTaskOnUiThreadBlocking(new WebViewChromium$103(this));
      return;
    } 
    this.mAwContents.mAwViewMethods.computeScroll();
  }
  
  public int computeVerticalScrollExtent() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Integer)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$102(this))).intValue() : this.mAwContents.mAwViewMethods.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Integer)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$101(this))).intValue() : this.mAwContents.mAwViewMethods.computeVerticalScrollOffset();
  }
  
  public int computeVerticalScrollRange() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Integer)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$100(this))).intValue() : this.mAwContents.mAwViewMethods.computeVerticalScrollRange();
  }
  
  public WebBackForwardList copyBackForwardList() {
    NavigationHistory navigationHistory1;
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return (WebBackForwardList)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$52(this)); 
    AwContents awContents = this.mAwContents;
    if (awContents.isDestroyedOrNoOperation(1)) {
      awContents = null;
    } else {
      navigationHistory1 = awContents.mNavigationController.getNavigationHistory();
    } 
    NavigationHistory navigationHistory2 = navigationHistory1;
    if (navigationHistory1 == null)
      navigationHistory2 = new NavigationHistory(); 
    return new WebBackForwardListChromium(navigationHistory2);
  }
  
  public PrintDocumentAdapter createPrintDocumentAdapter(String paramString) {
    AwPdfExporter awPdfExporter;
    checkThread();
    AwContents awContents = this.mAwContents;
    if (awContents.isDestroyedOrNoOperation(1)) {
      awContents = null;
    } else {
      if (awContents.mAwPdfExporter == null) {
        awContents.mAwPdfExporter = new AwPdfExporter(awContents.mContainerView);
        awContents.nativeCreatePdfExporter(awContents.mNativeAwContents, awContents.mAwPdfExporter);
      } 
      awPdfExporter = awContents.mAwPdfExporter;
    } 
    return (PrintDocumentAdapter)new AwPrintDocumentAdapter(awPdfExporter, paramString);
  }
  
  public WebMessagePort[] createWebMessageChannel() {
    return WebMessagePortAdapter.fromMessagePorts(this.mSharedWebViewChromium.createWebMessageChannel());
  }
  
  public void destroy() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$11(this));
      return;
    } 
    setWebChromeClient(null);
    setWebViewClient(null);
    this.mContentsClientAdapter.setPictureListener(null, true);
    this.mContentsClientAdapter.mFindListener = null;
    this.mContentsClientAdapter.mDownloadListener = null;
    this.mAwContents.destroy();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$88(this, paramKeyEvent))).booleanValue() : this.mAwContents.mAwViewMethods.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void documentHasImages(Message paramMessage) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$57(this, paramMessage));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.nativeDocumentHasImages(awContents.mNativeAwContents, paramMessage); 
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt) {}
  
  public void evaluateJavaScript(String paramString, ValueCallback paramValueCallback) {
    if (this.mShouldDisableThreadChecking && this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$20(this, paramString, paramValueCallback));
      return;
    } 
    checkThread();
    this.mAwContents.evaluateJavaScript(paramString, CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public void extractSmartClipData(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    checkThread();
    this.mAwContents.extractSmartClipData(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int findAll(String paramString) {
    findAllAsync(paramString);
    return 0;
  }
  
  public void findAllAsync(String paramString) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$54(this, paramString));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.nativeFindAllAsync(awContents.mNativeAwContents, paramString); 
  }
  
  public View findFocus(View paramView) {
    return paramView;
  }
  
  public View findHierarchyView(String paramString, int paramInt) {
    return null;
  }
  
  public void findNext(boolean paramBoolean) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$53(this, paramBoolean));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.nativeFindNext(awContents.mNativeAwContents, paramBoolean); 
  }
  
  public void flingScroll(int paramInt1, int paramInt2) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$61(this, paramInt1, paramInt2));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mWebContents.getEventForwarder().startFling(SystemClock.uptimeMillis(), -paramInt1, -paramInt2, false, true); 
  }
  
  public void freeMemory() {}
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? (AccessibilityNodeProvider)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$67(this)) : this.mAwContents.mAwViewMethods.getAccessibilityNodeProvider();
  }
  
  public SslCertificate getCertificate() {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return (SslCertificate)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$8(this)); 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? null : SslUtil.getCertificateFromDerBytes(awContents.nativeGetCertificate(awContents.mNativeAwContents));
  }
  
  public int getContentHeight() {
    if (this.mAwContents == null)
      return 0; 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? 0 : (int)Math.ceil(awContents.mContentHeightDip);
  }
  
  public int getContentWidth() {
    if (this.mAwContents == null)
      return 0; 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? 0 : (int)Math.ceil(awContents.mContentWidthDip);
  }
  
  public Bitmap getFavicon() {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return (Bitmap)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$42(this)); 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? null : awContents.mFavicon;
  }
  
  public Handler getHandler(Handler paramHandler) {
    return paramHandler;
  }
  
  public WebView.HitTestResult getHitTestResult() {
    AwContents.HitTestData hitTestData;
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return (WebView.HitTestResult)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$36(this)); 
    AwContents awContents = this.mAwContents;
    if (awContents.isDestroyedOrNoOperation(1)) {
      awContents = null;
    } else {
      awContents.nativeUpdateLastHitTestData(awContents.mNativeAwContents);
      hitTestData = awContents.mPossiblyStaleHitTestData;
    } 
    this.mHitTestResult.setType(hitTestData.hitTestResultType);
    this.mHitTestResult.setExtra(hitTestData.hitTestResultExtraData);
    return this.mHitTestResult;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2) {
    this.mFactory.startYourEngines(true);
    return this.mSharedWebViewChromium.checkNeedsPost() ? (String[])this.mFactory.runOnUiThreadBlocking(new WebViewChromium$10(this, paramString1, paramString2)) : ((WebViewDatabaseAdapter)this.mFactory.getWebViewDatabase(this.mContext)).getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  public String getOriginalUrl() {
    this.mFactory.startYourEngines(true);
    return this.mSharedWebViewChromium.checkNeedsPost() ? (String)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$40(this)) : this.mAwContents.getOriginalUrl();
  }
  
  public int getProgress() {
    if (this.mAwContents == null)
      return 100; 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? 0 : ((WebContentsDelegateAndroid)awContents.mWebContentsDelegate).mMostRecentProgress;
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible() {
    return this.mAwContents.mRendererPriorityWaivedWhenNotVisible;
  }
  
  public int getRendererRequestedPriority() {
    switch (this.mAwContents.mRendererPriority) {
      default:
        return 2;
      case 1:
        return 1;
      case 0:
        break;
    } 
    return 0;
  }
  
  public float getScale() {
    this.mFactory.startYourEngines(true);
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? 1.0F : (awContents.mPageScaleFactor * awContents.getDeviceScaleFactor());
  }
  
  public WebViewProvider.ScrollDelegate getScrollDelegate() {
    return this;
  }
  
  public WebSettings getSettings() {
    return this.mWebSettings;
  }
  
  public TextClassifier getTextClassifier() {
    return this.mAwContents.getTextClassifier();
  }
  
  public int getThemeColor() {
    WebContents webContents;
    if (this.mAwContents != null) {
      webContents = this.mAwContents.mWebContents;
    } else {
      webContents = null;
    } 
    return (webContents == null) ? 0 : webContents.getThemeColor();
  }
  
  public String getTitle() {
    this.mFactory.startYourEngines(true);
    return this.mSharedWebViewChromium.checkNeedsPost() ? (String)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$41(this)) : this.mAwContents.getTitle();
  }
  
  public String getTouchIconUrl() {
    return null;
  }
  
  public String getUrl() {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return (String)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$39(this)); 
    AwContents awContents = this.mAwContents;
    if (awContents.isDestroyedOrNoOperation(1))
      return null; 
    String str = awContents.mWebContents.getVisibleUrl();
    return (str != null) ? (str.trim().isEmpty() ? null : str) : null;
  }
  
  public WebViewProvider.ViewDelegate getViewDelegate() {
    return this;
  }
  
  public int getVisibleTitleHeight() {
    return 0;
  }
  
  public WebChromeClient getWebChromeClient() {
    return this.mSharedWebViewChromium.mWebChromeClient;
  }
  
  public WebViewClient getWebViewClient() {
    return this.mSharedWebViewChromium.mWebViewClient;
  }
  
  public View getZoomControls() {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return null; 
    Log.w(TAG, "WebView doesn't support getZoomControls");
    return this.mAwContents.mSettings.supportZoom() ? new View(this.mContext) : null;
  }
  
  public void goBack() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$25(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mNavigationController.goBack(); 
  }
  
  public void goBackOrForward(int paramInt) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$29(this, paramInt));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mNavigationController.goToOffset(paramInt); 
  }
  
  public void goForward() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$27(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mNavigationController.goForward(); 
  }
  
  public void init(Map paramMap, boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic elapsedRealtime : ()J
    //   3: lstore #9
    //   5: aload_0
    //   6: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   9: getfield mAwInit : Lcom/android/webview/chromium/WebViewChromiumAwInit;
    //   12: getfield mStarted : Z
    //   15: istore #8
    //   17: ldc_w 'WebViewChromium.init'
    //   20: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   23: astore #14
    //   25: aconst_null
    //   26: astore #13
    //   28: iload_2
    //   29: ifeq -> 131
    //   32: aload #13
    //   34: astore_1
    //   35: aload_0
    //   36: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   39: iconst_1
    //   40: invokevirtual startYourEngines : (Z)V
    //   43: aload #13
    //   45: astore_1
    //   46: aload_0
    //   47: getfield mAppTargetSdkVersion : I
    //   50: bipush #19
    //   52: if_icmpge -> 117
    //   55: aload #13
    //   57: astore_1
    //   58: getstatic com/android/webview/chromium/WebViewChromium.TAG : Ljava/lang/String;
    //   61: ldc_w 'Private browsing is not supported in WebView.'
    //   64: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: aload #13
    //   70: astore_1
    //   71: new android/widget/TextView
    //   74: dup
    //   75: aload_0
    //   76: getfield mContext : Landroid/content/Context;
    //   79: invokespecial <init> : (Landroid/content/Context;)V
    //   82: astore #11
    //   84: aload #13
    //   86: astore_1
    //   87: aload #11
    //   89: aload_0
    //   90: getfield mContext : Landroid/content/Context;
    //   93: getstatic org/chromium/android_webview/R$string.private_browsing_warning : I
    //   96: invokevirtual getString : (I)Ljava/lang/String;
    //   99: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   102: aload #13
    //   104: astore_1
    //   105: aload_0
    //   106: getfield mWebView : Landroid/webkit/WebView;
    //   109: aload #11
    //   111: invokevirtual addView : (Landroid/view/View;)V
    //   114: goto -> 131
    //   117: aload #13
    //   119: astore_1
    //   120: new java/lang/IllegalArgumentException
    //   123: dup
    //   124: ldc_w 'Private browsing is not supported in WebView.'
    //   127: invokespecial <init> : (Ljava/lang/String;)V
    //   130: athrow
    //   131: aload #13
    //   133: astore_1
    //   134: aload_0
    //   135: getfield mAppTargetSdkVersion : I
    //   138: bipush #18
    //   140: if_icmplt -> 163
    //   143: aload #13
    //   145: astore_1
    //   146: aload_0
    //   147: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   150: iconst_0
    //   151: invokevirtual startYourEngines : (Z)V
    //   154: aload #13
    //   156: astore_1
    //   157: invokestatic checkThread : ()V
    //   160: goto -> 202
    //   163: aload #13
    //   165: astore_1
    //   166: aload_0
    //   167: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   170: getfield mAwInit : Lcom/android/webview/chromium/WebViewChromiumAwInit;
    //   173: getfield mStarted : Z
    //   176: ifne -> 202
    //   179: aload #13
    //   181: astore_1
    //   182: invokestatic myLooper : ()Landroid/os/Looper;
    //   185: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   188: if_acmpne -> 202
    //   191: aload #13
    //   193: astore_1
    //   194: aload_0
    //   195: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   198: iconst_1
    //   199: invokevirtual startYourEngines : (Z)V
    //   202: aload #13
    //   204: astore_1
    //   205: aload_0
    //   206: getfield mAppTargetSdkVersion : I
    //   209: bipush #16
    //   211: if_icmpge -> 858
    //   214: iconst_1
    //   215: istore_3
    //   216: goto -> 219
    //   219: aload #13
    //   221: astore_1
    //   222: aload_0
    //   223: getfield mAppTargetSdkVersion : I
    //   226: bipush #19
    //   228: if_icmpge -> 863
    //   231: iconst_1
    //   232: istore #4
    //   234: goto -> 237
    //   237: aload #13
    //   239: astore_1
    //   240: aload_0
    //   241: getfield mAppTargetSdkVersion : I
    //   244: bipush #23
    //   246: if_icmpgt -> 869
    //   249: iconst_1
    //   250: istore #5
    //   252: goto -> 255
    //   255: aload #13
    //   257: astore_1
    //   258: aload_0
    //   259: getfield mAppTargetSdkVersion : I
    //   262: bipush #23
    //   264: if_icmpgt -> 875
    //   267: iconst_1
    //   268: istore #6
    //   270: goto -> 273
    //   273: aload #13
    //   275: astore_1
    //   276: aload_0
    //   277: getfield mAppTargetSdkVersion : I
    //   280: bipush #23
    //   282: if_icmpgt -> 881
    //   285: iconst_1
    //   286: istore #7
    //   288: goto -> 291
    //   291: aload #13
    //   293: astore_1
    //   294: aload_0
    //   295: aload_0
    //   296: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   299: aload_0
    //   300: getfield mWebView : Landroid/webkit/WebView;
    //   303: aload_0
    //   304: getfield mContext : Landroid/content/Context;
    //   307: invokevirtual createWebViewContentsClientAdapter : (Landroid/webkit/WebView;Landroid/content/Context;)Lcom/android/webview/chromium/WebViewContentsClientAdapter;
    //   310: putfield mContentsClientAdapter : Lcom/android/webview/chromium/WebViewContentsClientAdapter;
    //   313: aload #13
    //   315: astore_1
    //   316: ldc_w 'WebViewChromium.ContentSettingsAdapter'
    //   319: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/android_webview/ScopedSysTraceEvent;
    //   322: astore #15
    //   324: aload_0
    //   325: new com/android/webview/chromium/ContentSettingsAdapter
    //   328: dup
    //   329: new org/chromium/android_webview/AwSettings
    //   332: dup
    //   333: aload_0
    //   334: getfield mContext : Landroid/content/Context;
    //   337: iload_3
    //   338: iload #4
    //   340: iload #5
    //   342: iload #6
    //   344: iload #7
    //   346: invokespecial <init> : (Landroid/content/Context;ZZZZZ)V
    //   349: invokespecial <init> : (Lorg/chromium/android_webview/AwSettings;)V
    //   352: putfield mWebSettings : Lcom/android/webview/chromium/ContentSettingsAdapter;
    //   355: aload #15
    //   357: ifnull -> 369
    //   360: aload #13
    //   362: astore_1
    //   363: aconst_null
    //   364: aload #15
    //   366: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   369: aload #13
    //   371: astore_1
    //   372: aload_0
    //   373: getfield mAppTargetSdkVersion : I
    //   376: bipush #21
    //   378: if_icmpge -> 471
    //   381: aload #13
    //   383: astore_1
    //   384: aload_0
    //   385: getfield mWebSettings : Lcom/android/webview/chromium/ContentSettingsAdapter;
    //   388: iconst_0
    //   389: invokevirtual setMixedContentMode : (I)V
    //   392: aload #13
    //   394: astore_1
    //   395: aload_0
    //   396: getfield mWebSettings : Lcom/android/webview/chromium/ContentSettingsAdapter;
    //   399: iconst_1
    //   400: invokevirtual setAcceptThirdPartyCookies : (Z)V
    //   403: aload #13
    //   405: astore_1
    //   406: aload_0
    //   407: getfield mWebSettings : Lcom/android/webview/chromium/ContentSettingsAdapter;
    //   410: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   413: astore #12
    //   415: aload #13
    //   417: astore_1
    //   418: aload #12
    //   420: getfield mAwSettingsLock : Ljava/lang/Object;
    //   423: astore #11
    //   425: aload #13
    //   427: astore_1
    //   428: aload #11
    //   430: monitorenter
    //   431: aload #12
    //   433: getfield mZeroLayoutHeightDisablesViewportQuirk : Z
    //   436: iconst_1
    //   437: if_icmpeq -> 454
    //   440: aload #12
    //   442: iconst_1
    //   443: putfield mZeroLayoutHeightDisablesViewportQuirk : Z
    //   446: aload #12
    //   448: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   451: invokevirtual updateWebkitPreferencesLocked : ()V
    //   454: aload #11
    //   456: monitorexit
    //   457: goto -> 471
    //   460: astore #12
    //   462: aload #11
    //   464: monitorexit
    //   465: aload #13
    //   467: astore_1
    //   468: aload #12
    //   470: athrow
    //   471: aload #13
    //   473: astore_1
    //   474: invokestatic targetsAtLeastP : ()Z
    //   477: ifeq -> 613
    //   480: aload #13
    //   482: astore_1
    //   483: aload_0
    //   484: getfield mWebSettings : Lcom/android/webview/chromium/ContentSettingsAdapter;
    //   487: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   490: astore #12
    //   492: aload #13
    //   494: astore_1
    //   495: aload #12
    //   497: getfield mAwSettingsLock : Ljava/lang/Object;
    //   500: astore #11
    //   502: aload #13
    //   504: astore_1
    //   505: aload #11
    //   507: monitorenter
    //   508: aload #12
    //   510: getfield mCSSHexAlphaColorEnabled : Z
    //   513: iconst_1
    //   514: if_icmpeq -> 531
    //   517: aload #12
    //   519: iconst_1
    //   520: putfield mCSSHexAlphaColorEnabled : Z
    //   523: aload #12
    //   525: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   528: invokevirtual updateWebkitPreferencesLocked : ()V
    //   531: aload #11
    //   533: monitorexit
    //   534: aload #13
    //   536: astore_1
    //   537: aload_0
    //   538: getfield mWebSettings : Lcom/android/webview/chromium/ContentSettingsAdapter;
    //   541: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   544: astore #12
    //   546: aload #13
    //   548: astore_1
    //   549: aload #12
    //   551: getfield mAwSettingsLock : Ljava/lang/Object;
    //   554: astore #11
    //   556: aload #13
    //   558: astore_1
    //   559: aload #11
    //   561: monitorenter
    //   562: aload #12
    //   564: getfield mScrollTopLeftInteropEnabled : Z
    //   567: iconst_1
    //   568: if_icmpeq -> 585
    //   571: aload #12
    //   573: iconst_1
    //   574: putfield mScrollTopLeftInteropEnabled : Z
    //   577: aload #12
    //   579: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   582: invokevirtual updateWebkitPreferencesLocked : ()V
    //   585: aload #11
    //   587: monitorexit
    //   588: goto -> 613
    //   591: astore #12
    //   593: aload #11
    //   595: monitorexit
    //   596: aload #13
    //   598: astore_1
    //   599: aload #12
    //   601: athrow
    //   602: astore #12
    //   604: aload #11
    //   606: monitorexit
    //   607: aload #13
    //   609: astore_1
    //   610: aload #12
    //   612: athrow
    //   613: aload #13
    //   615: astore_1
    //   616: aload_0
    //   617: getfield mShouldDisableThreadChecking : Z
    //   620: istore_3
    //   621: iload_3
    //   622: ifeq -> 687
    //   625: aload #13
    //   627: astore_1
    //   628: ldc_w 'android.webkit.WebView'
    //   631: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   634: ldc_w 'sEnforceThreadChecking'
    //   637: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   640: astore #11
    //   642: aload #13
    //   644: astore_1
    //   645: aload #11
    //   647: iconst_1
    //   648: invokevirtual setAccessible : (Z)V
    //   651: aload #13
    //   653: astore_1
    //   654: aload #11
    //   656: aconst_null
    //   657: iconst_0
    //   658: invokevirtual setBoolean : (Ljava/lang/Object;Z)V
    //   661: aload #13
    //   663: astore_1
    //   664: aload #11
    //   666: iconst_0
    //   667: invokevirtual setAccessible : (Z)V
    //   670: goto -> 687
    //   673: astore_1
    //   674: aload #13
    //   676: astore_1
    //   677: getstatic com/android/webview/chromium/WebViewChromium.TAG : Ljava/lang/String;
    //   680: ldc_w 'Failed to disable thread checking.'
    //   683: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   686: pop
    //   687: aload #13
    //   689: astore_1
    //   690: aload_0
    //   691: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   694: new com/android/webview/chromium/WebViewChromium$1
    //   697: dup
    //   698: aload_0
    //   699: iload_2
    //   700: invokespecial <init> : (Lcom/android/webview/chromium/WebViewChromium;Z)V
    //   703: invokevirtual addTask : (Ljava/lang/Runnable;)V
    //   706: aload #14
    //   708: ifnull -> 717
    //   711: aconst_null
    //   712: aload #14
    //   714: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   717: aload_0
    //   718: getfield mFactory : Lcom/android/webview/chromium/WebViewChromiumFactoryProvider;
    //   721: getfield mAwInit : Lcom/android/webview/chromium/WebViewChromiumAwInit;
    //   724: getfield mStarted : Z
    //   727: ifeq -> 791
    //   730: new java/lang/StringBuilder
    //   733: dup
    //   734: ldc_w 'Android.WebView.Startup.CreationTime.Stage2.ProviderInit.'
    //   737: invokespecial <init> : (Ljava/lang/String;)V
    //   740: astore #11
    //   742: iload #8
    //   744: iconst_1
    //   745: ixor
    //   746: ifeq -> 756
    //   749: ldc_w 'Cold'
    //   752: astore_1
    //   753: goto -> 760
    //   756: ldc_w 'Warm'
    //   759: astore_1
    //   760: aload #11
    //   762: aload_1
    //   763: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: new org/chromium/base/metrics/CachedMetrics$TimesHistogramSample
    //   770: dup
    //   771: aload #11
    //   773: invokevirtual toString : ()Ljava/lang/String;
    //   776: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   779: invokespecial <init> : (Ljava/lang/String;Ljava/util/concurrent/TimeUnit;)V
    //   782: invokestatic elapsedRealtime : ()J
    //   785: lload #9
    //   787: lsub
    //   788: invokevirtual record : (J)V
    //   791: return
    //   792: astore #11
    //   794: aconst_null
    //   795: astore #12
    //   797: goto -> 807
    //   800: astore #12
    //   802: aload #12
    //   804: athrow
    //   805: astore #11
    //   807: aload #15
    //   809: ifnull -> 822
    //   812: aload #13
    //   814: astore_1
    //   815: aload #12
    //   817: aload #15
    //   819: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   822: aload #13
    //   824: astore_1
    //   825: aload #11
    //   827: athrow
    //   828: aload #11
    //   830: astore_1
    //   831: aload #11
    //   833: athrow
    //   834: aload #14
    //   836: ifnull -> 845
    //   839: aload_1
    //   840: aload #14
    //   842: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/android_webview/ScopedSysTraceEvent;)V
    //   845: aload #11
    //   847: athrow
    //   848: astore #11
    //   850: goto -> 834
    //   853: astore #11
    //   855: goto -> 828
    //   858: iconst_0
    //   859: istore_3
    //   860: goto -> 219
    //   863: iconst_0
    //   864: istore #4
    //   866: goto -> 237
    //   869: iconst_0
    //   870: istore #5
    //   872: goto -> 255
    //   875: iconst_0
    //   876: istore #6
    //   878: goto -> 273
    //   881: iconst_0
    //   882: istore #7
    //   884: goto -> 291
    // Exception table:
    //   from	to	target	type
    //   35	43	853	java/lang/Throwable
    //   35	43	848	finally
    //   46	55	853	java/lang/Throwable
    //   46	55	848	finally
    //   58	68	853	java/lang/Throwable
    //   58	68	848	finally
    //   71	84	853	java/lang/Throwable
    //   71	84	848	finally
    //   87	102	853	java/lang/Throwable
    //   87	102	848	finally
    //   105	114	853	java/lang/Throwable
    //   105	114	848	finally
    //   120	131	853	java/lang/Throwable
    //   120	131	848	finally
    //   134	143	853	java/lang/Throwable
    //   134	143	848	finally
    //   146	154	853	java/lang/Throwable
    //   146	154	848	finally
    //   157	160	853	java/lang/Throwable
    //   157	160	848	finally
    //   166	179	853	java/lang/Throwable
    //   166	179	848	finally
    //   182	191	853	java/lang/Throwable
    //   182	191	848	finally
    //   194	202	853	java/lang/Throwable
    //   194	202	848	finally
    //   205	214	853	java/lang/Throwable
    //   205	214	848	finally
    //   222	231	853	java/lang/Throwable
    //   222	231	848	finally
    //   240	249	853	java/lang/Throwable
    //   240	249	848	finally
    //   258	267	853	java/lang/Throwable
    //   258	267	848	finally
    //   276	285	853	java/lang/Throwable
    //   276	285	848	finally
    //   294	313	853	java/lang/Throwable
    //   294	313	848	finally
    //   316	324	853	java/lang/Throwable
    //   316	324	848	finally
    //   324	355	800	java/lang/Throwable
    //   324	355	792	finally
    //   363	369	853	java/lang/Throwable
    //   363	369	848	finally
    //   372	381	853	java/lang/Throwable
    //   372	381	848	finally
    //   384	392	853	java/lang/Throwable
    //   384	392	848	finally
    //   395	403	853	java/lang/Throwable
    //   395	403	848	finally
    //   406	415	853	java/lang/Throwable
    //   406	415	848	finally
    //   418	425	853	java/lang/Throwable
    //   418	425	848	finally
    //   428	431	853	java/lang/Throwable
    //   428	431	848	finally
    //   431	454	460	finally
    //   454	457	460	finally
    //   462	465	460	finally
    //   468	471	853	java/lang/Throwable
    //   468	471	848	finally
    //   474	480	853	java/lang/Throwable
    //   474	480	848	finally
    //   483	492	853	java/lang/Throwable
    //   483	492	848	finally
    //   495	502	853	java/lang/Throwable
    //   495	502	848	finally
    //   505	508	853	java/lang/Throwable
    //   505	508	848	finally
    //   508	531	602	finally
    //   531	534	602	finally
    //   537	546	853	java/lang/Throwable
    //   537	546	848	finally
    //   549	556	853	java/lang/Throwable
    //   549	556	848	finally
    //   559	562	853	java/lang/Throwable
    //   559	562	848	finally
    //   562	585	591	finally
    //   585	588	591	finally
    //   593	596	591	finally
    //   599	602	853	java/lang/Throwable
    //   599	602	848	finally
    //   604	607	602	finally
    //   610	613	853	java/lang/Throwable
    //   610	613	848	finally
    //   616	621	853	java/lang/Throwable
    //   616	621	848	finally
    //   628	642	673	java/lang/ClassNotFoundException
    //   628	642	673	java/lang/NoSuchFieldException
    //   628	642	673	java/lang/IllegalAccessException
    //   628	642	673	java/lang/IllegalArgumentException
    //   628	642	853	java/lang/Throwable
    //   628	642	848	finally
    //   645	651	673	java/lang/ClassNotFoundException
    //   645	651	673	java/lang/NoSuchFieldException
    //   645	651	673	java/lang/IllegalAccessException
    //   645	651	673	java/lang/IllegalArgumentException
    //   645	651	853	java/lang/Throwable
    //   645	651	848	finally
    //   654	661	673	java/lang/ClassNotFoundException
    //   654	661	673	java/lang/NoSuchFieldException
    //   654	661	673	java/lang/IllegalAccessException
    //   654	661	673	java/lang/IllegalArgumentException
    //   654	661	853	java/lang/Throwable
    //   654	661	848	finally
    //   664	670	673	java/lang/ClassNotFoundException
    //   664	670	673	java/lang/NoSuchFieldException
    //   664	670	673	java/lang/IllegalAccessException
    //   664	670	673	java/lang/IllegalArgumentException
    //   664	670	853	java/lang/Throwable
    //   664	670	848	finally
    //   677	687	853	java/lang/Throwable
    //   677	687	848	finally
    //   690	706	853	java/lang/Throwable
    //   690	706	848	finally
    //   802	805	805	finally
    //   815	822	853	java/lang/Throwable
    //   815	822	848	finally
    //   825	828	853	java/lang/Throwable
    //   825	828	848	finally
    //   831	834	848	finally
  }
  
  @TargetApi(23)
  public void insertVisualStateCallback(long paramLong, WebView.VisualStateCallback paramVisualStateCallback) {
    this.mSharedWebViewChromium.insertVisualStateCallback(paramLong, new WebViewChromium$32(paramVisualStateCallback));
  }
  
  public void invokeZoomPicker() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$35(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mZoomControls.invokeZoomPicker(); 
  }
  
  public boolean isPaused() {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$47(this))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(1) ? false : awContents.mIsPaused;
  }
  
  public boolean isPrivateBrowsingEnabled() {
    return false;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      assert false;
      throw new AssertionError();
    } 
    this.mAwContents.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      assert false;
      throw new AssertionError();
    } 
    this.mAwContents.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      assert false;
      throw new AssertionError();
    } 
    this.mAwContents.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map paramMap) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      assert false;
      throw new AssertionError();
    } 
    this.mAwContents.loadUrl(paramString, paramMap);
  }
  
  public void notifyFindDialogDismissed() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$55(this));
      return;
    } 
    clearMatches();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$76(this, paramInt1, paramInt2, paramIntent));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(0)) {
      if (paramInt1 == 100) {
        SelectionPopupControllerImpl.fromWebContents(awContents.mWebContents).onReceivedProcessTextResult(paramInt2, paramIntent);
        return;
      } 
      Log.e("AwContents", "Received activity result for an unknown request code %d", new Object[] { Integer.valueOf(paramInt1) });
    } 
  }
  
  public void onAttachedToWindow() {
    this.mFactory.startYourEngines(false);
    checkThread();
    this.mAwContents.onAttachedToWindow();
  }
  
  public boolean onCheckIsTextEditor() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$97(this))).booleanValue() : this.mAwContents.mAwViewMethods.onCheckIsTextEditor();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$77(this, paramConfiguration));
      return;
    } 
    this.mAwContents.mAwViewMethods.onConfigurationChanged(paramConfiguration);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? null : this.mAwContents.mAwViewMethods.onCreateInputConnection(paramEditorInfo);
  }
  
  public void onDetachedFromWindow() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$82(this));
      return;
    } 
    this.mAwContents.onDetachedFromWindow();
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$78(this, paramDragEvent))).booleanValue() : this.mAwContents.mAwViewMethods.onDragEvent(paramDragEvent);
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.runVoidTaskOnUiThreadBlocking(new WebViewChromium$74(this, paramCanvas));
      return;
    } 
    AwContents awContents = this.mAwContents;
    try {
      TraceEvent.begin("AwContents.onDraw");
      awContents.mAwViewMethods.onDraw(paramCanvas);
      return;
    } finally {
      TraceEvent.end("AwContents.onDraw");
    } 
  }
  
  public void onDrawVerticalScrollBar(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mWebViewPrivate.super_onDrawVerticalScrollBar(paramCanvas, paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onFinishTemporaryDetach() {
    this.mAwContents.mTemporarilyDetached = false;
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$85(this, paramBoolean, paramInt, paramRect));
      return;
    } 
    this.mAwContents.onFocusChanged$23eb4535(paramBoolean);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$91(this, paramMotionEvent))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    return awContents.isDestroyedOrNoOperation(0) ? false : awContents.mAwViewMethods.onGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$90(this, paramMotionEvent))).booleanValue() : this.mAwContents.mAwViewMethods.onHoverEvent(paramMotionEvent);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {}
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$80(this, paramInt, paramKeyEvent))).booleanValue() : false;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$79(this, paramInt1, paramInt2, paramKeyEvent))).booleanValue() : false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$81(this, paramInt, paramKeyEvent))).booleanValue() : this.mAwContents.mAwViewMethods.onKeyUp(paramInt, paramKeyEvent);
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onMeasure(int paramInt1, int paramInt2) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.runVoidTaskOnUiThreadBlocking(new WebViewChromium$93(this, paramInt1, paramInt2));
      return;
    } 
    this.mAwContents.mAwViewMethods.onMeasure(paramInt1, paramInt2);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$72(this, paramInt1, paramInt2, paramBoolean1, paramBoolean2));
      return;
    } 
    this.mAwContents.mAwViewMethods.onContainerViewOverScrolled$3b46042b(paramInt1, paramInt2);
  }
  
  public void onPause() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$45(this));
      return;
    } 
    this.mAwContents.onPause();
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.runVoidTaskOnUiThreadBlocking(new WebViewChromium$65(this, paramViewStructure, paramInt));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (awContents.mAutofillProvider != null)
      awContents.mAutofillProvider.onProvideAutoFillVirtualStructure$6304a4bd(paramViewStructure); 
  }
  
  @TargetApi(23)
  public void onProvideVirtualStructure(ViewStructure paramViewStructure) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.runVoidTaskOnUiThreadBlocking(new WebViewChromium$68(this, paramViewStructure));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1)) {
      if (!awContents.mWebContentsObserver.mCommittedNavigation) {
        paramViewStructure.setChildCount(0);
        return;
      } 
      WebContentsAccessibilityImpl.fromWebContents(awContents.mWebContents).onProvideVirtualStructure(paramViewStructure, true);
    } 
  }
  
  public void onResume() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$46(this));
      return;
    } 
    this.mAwContents.onResume();
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$87(this, paramInt1, paramInt2, paramInt3, paramInt4));
      return;
    } 
    this.mAwContents.mAwViewMethods.onContainerViewScrollChanged$3b4dfe4b(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$86(this, paramInt1, paramInt2, paramInt3, paramInt4));
      return;
    } 
    this.mAwContents.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onStartTemporaryDetach() {
    this.mAwContents.mTemporarilyDetached = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$89(this, paramMotionEvent))).booleanValue() : this.mAwContents.mAwViewMethods.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public void onVisibilityChanged(View paramView, int paramInt) {
    if (this.mAwContents == null)
      return; 
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$83(this, paramView, paramInt));
      return;
    } 
    this.mAwContents.mAwViewMethods.onVisibilityChanged$5359dc9a();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$84(this, paramBoolean));
      return;
    } 
    this.mAwContents.onWindowFocusChanged(paramBoolean);
  }
  
  public void onWindowVisibilityChanged(int paramInt) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$73(this, paramInt));
      return;
    } 
    this.mAwContents.mAwViewMethods.onWindowVisibilityChanged(paramInt);
  }
  
  public boolean overlayHorizontalScrollbar() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$6(this))).booleanValue() : this.mAwContents.mOverlayHorizontalScrollbar;
  }
  
  public boolean overlayVerticalScrollbar() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$7(this))).booleanValue() : this.mAwContents.mOverlayVerticalScrollbar;
  }
  
  public boolean pageDown(boolean paramBoolean) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$31(this, paramBoolean))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    if (awContents.isDestroyedOrNoOperation(1))
      return false; 
    AwScrollOffsetManager awScrollOffsetManager = awContents.mScrollOffsetManager;
    int j = awScrollOffsetManager.mDelegate.getContainerViewScrollX();
    int k = awScrollOffsetManager.mDelegate.getContainerViewScrollY();
    if (paramBoolean)
      return awScrollOffsetManager.animateScrollTo(j, awScrollOffsetManager.computeVerticalScrollRange()); 
    int i = awScrollOffsetManager.mContainerViewHeight / 2;
    if (awScrollOffsetManager.mContainerViewHeight > 48)
      i = awScrollOffsetManager.mContainerViewHeight - 24; 
    return awScrollOffsetManager.animateScrollTo(j, k + i);
  }
  
  public boolean pageUp(boolean paramBoolean) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$30(this, paramBoolean))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    if (awContents.isDestroyedOrNoOperation(1))
      return false; 
    AwScrollOffsetManager awScrollOffsetManager = awContents.mScrollOffsetManager;
    int j = awScrollOffsetManager.mDelegate.getContainerViewScrollX();
    int k = awScrollOffsetManager.mDelegate.getContainerViewScrollY();
    if (paramBoolean)
      return awScrollOffsetManager.animateScrollTo(j, 0); 
    int i = -awScrollOffsetManager.mContainerViewHeight / 2;
    if (awScrollOffsetManager.mContainerViewHeight > 48)
      i = -awScrollOffsetManager.mContainerViewHeight + 24; 
    return awScrollOffsetManager.animateScrollTo(j, k + i);
  }
  
  public void pauseTimers() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$43(this));
      return;
    } 
    if (!this.mAwContents.isDestroyedOrNoOperation(1))
      ContentViewStaticsImpl.setWebKitSharedTimersSuspended(true); 
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle) {
    WebViewChromiumFactoryProvider webViewChromiumFactoryProvider = this.mFactory;
    boolean bool = false;
    webViewChromiumFactoryProvider.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$69(this, paramInt, paramBundle))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      bool = WebContentsAccessibilityImpl.fromWebContents(awContents.mWebContents).supportsAction$134632(); 
    return bool ? this.mAwContents.mAwViewMethods.performAccessibilityAction$68e2e3ea() : this.mWebViewPrivate.super_performAccessibilityAction(paramInt, paramBundle);
  }
  
  public boolean performLongClick() {
    return (this.mWebView.getParent() != null) ? this.mWebViewPrivate.super_performLongClick() : false;
  }
  
  @TargetApi(23)
  public void postMessageToMainFrame(WebMessage paramWebMessage, Uri paramUri) {
    this.mSharedWebViewChromium.postMessageToMainFrame(paramWebMessage.getData(), paramUri.toString(), WebMessagePortAdapter.toMessagePorts(paramWebMessage.getPorts()));
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfbyte) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      assert false;
      throw new AssertionError();
    } 
    this.mAwContents.postUrl(paramString, paramArrayOfbyte);
  }
  
  public void preDispatchDraw(Canvas paramCanvas) {}
  
  public void reload() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$23(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mNavigationController.reload(true); 
  }
  
  public void removeJavascriptInterface(String paramString) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$60(this, paramString));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.getJavascriptInjector().removeInterface(paramString); 
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$94(this, paramView, paramRect, paramBoolean))).booleanValue(); 
    AwContents awContents = this.mAwContents;
    if (awContents.isDestroyedOrNoOperation(1))
      return false; 
    AwScrollOffsetManager awScrollOffsetManager = awContents.mScrollOffsetManager;
    int i = paramView.getLeft();
    int j = paramView.getScrollX();
    int n = paramView.getTop();
    int i1 = paramView.getScrollY();
    int k = awScrollOffsetManager.mDelegate.getContainerViewScrollX();
    int m = awScrollOffsetManager.mDelegate.getContainerViewScrollY();
    paramRect.offset(i - j, n - i1);
    i = awScrollOffsetManager.mContainerViewHeight;
    if (paramRect.bottom > i + m) {
      i = awScrollOffsetManager.mContainerViewHeight / 3;
      if (paramRect.width() > i * 2) {
        i = paramRect.top - m;
      } else {
        i = paramRect.top - i + m;
      } 
    } else if (paramRect.top < m) {
      i = paramRect.top - m;
    } else {
      i = 0;
    } 
    j = awScrollOffsetManager.mContainerViewWidth + k;
    if (paramRect.right > j && paramRect.left > k) {
      if (paramRect.width() > awScrollOffsetManager.mContainerViewWidth) {
        j = paramRect.left - k + 0;
      } else {
        j = paramRect.right - j + 0;
      } 
    } else if (paramRect.left < k) {
      j = 0 - k - paramRect.left;
    } else {
      j = 0;
    } 
    if (i == 0 && j == 0)
      return false; 
    if (paramBoolean) {
      awScrollOffsetManager.scrollBy(j, i);
      return true;
    } 
    return awScrollOffsetManager.animateScrollTo(k + j, m + i);
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$92(this, paramInt, paramRect))).booleanValue(); 
    this.mAwContents.mAwViewMethods.requestFocus();
    return this.mWebViewPrivate.super_requestFocus(paramInt, paramRect);
  }
  
  public void requestFocusNodeHref(Message paramMessage) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$37(this, paramMessage));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (paramMessage != null) {
      if (awContents.isDestroyedOrNoOperation(1))
        return; 
      awContents.nativeUpdateLastHitTestData(awContents.mNativeAwContents);
      Bundle bundle = paramMessage.getData();
      bundle.putString("url", awContents.mPossiblyStaleHitTestData.href);
      bundle.putString("title", awContents.mPossiblyStaleHitTestData.anchorText);
      bundle.putString("src", awContents.mPossiblyStaleHitTestData.imgSrc);
      paramMessage.setData(bundle);
      paramMessage.sendToTarget();
      return;
    } 
  }
  
  public void requestImageRef(Message paramMessage) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$38(this, paramMessage));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (paramMessage != null) {
      if (awContents.isDestroyedOrNoOperation(1))
        return; 
      awContents.nativeUpdateLastHitTestData(awContents.mNativeAwContents);
      Bundle bundle = paramMessage.getData();
      bundle.putString("url", awContents.mPossiblyStaleHitTestData.imgSrc);
      paramMessage.setData(bundle);
      paramMessage.sendToTarget();
      return;
    } 
  }
  
  public boolean restorePicture(Bundle paramBundle, File paramFile) {
    return false;
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return (WebBackForwardList)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$14(this, paramBundle)); 
    if (paramBundle == null)
      return null; 
    AwContents awContents = this.mAwContents;
    boolean bool2 = awContents.isDestroyedOrNoOperation(1);
    boolean bool1 = false;
    if (!bool2 && paramBundle != null) {
      byte[] arrayOfByte = paramBundle.getByteArray("WEBVIEW_CHROMIUM_STATE");
      if (arrayOfByte != null) {
        bool1 = awContents.nativeRestoreFromOpaqueState(awContents.mNativeAwContents, arrayOfByte);
        if (bool1)
          awContents.mContentsClient.onReceivedTitle(awContents.mWebContents.getTitle()); 
      } 
    } 
    return !bool1 ? null : copyBackForwardList();
  }
  
  public void resumeTimers() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$44(this));
      return;
    } 
    if (!this.mAwContents.isDestroyedOrNoOperation(1))
      ContentViewStaticsImpl.setWebKitSharedTimersSuspended(false); 
  }
  
  public void savePassword(String paramString1, String paramString2, String paramString3) {}
  
  public boolean savePicture(Bundle paramBundle, File paramFile) {
    return false;
  }
  
  public WebBackForwardList saveState(Bundle paramBundle) {
    this.mFactory.startYourEngines(true);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return (WebBackForwardList)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$13(this, paramBundle)); 
    if (paramBundle == null)
      return null; 
    AwContents awContents = this.mAwContents;
    boolean bool1 = awContents.isDestroyedOrNoOperation(1);
    boolean bool = false;
    if (!bool1 && paramBundle != null) {
      byte[] arrayOfByte = awContents.nativeGetOpaqueState(awContents.mNativeAwContents);
      if (arrayOfByte != null) {
        paramBundle.putByteArray("WEBVIEW_CHROMIUM_STATE", arrayOfByte);
        bool = true;
      } 
    } 
    return !bool ? null : copyBackForwardList();
  }
  
  public void saveWebArchive(String paramString) {
    saveWebArchive(paramString, false, null);
  }
  
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback paramValueCallback) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$21(this, paramString, paramBoolean, paramValueCallback));
      return;
    } 
    AwContents awContents = this.mAwContents;
    Callback callback = CallbackConverter.fromValueCallback(paramValueCallback);
    if (!paramBoolean) {
      awContents.saveWebArchiveInternal(paramString, callback);
      return;
    } 
    (new Object(awContents, paramString, callback)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
  }
  
  public void setBackgroundColor(int paramInt) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      ThreadUtils.postOnUiThread(new WebViewChromium$95(this, paramInt));
      return;
    } 
    AwContents awContents = this.mAwContents;
    awContents.mBaseBackgroundColor = paramInt;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.nativeSetBackgroundColor(awContents.mNativeAwContents, paramInt); 
  }
  
  public void setCertificate(SslCertificate paramSslCertificate) {}
  
  public void setDownloadListener(DownloadListener paramDownloadListener) {
    this.mContentsClientAdapter.mDownloadListener = paramDownloadListener;
  }
  
  public void setFindListener(WebView.FindListener paramFindListener) {
    this.mContentsClientAdapter.mFindListener = paramFindListener;
  }
  
  public boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return this.mWebViewPrivate.super_setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$4(this, paramBoolean));
      return;
    } 
    this.mAwContents.mOverlayHorizontalScrollbar = paramBoolean;
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$9(this, paramString1, paramString2, paramString3, paramString4));
      return;
    } 
    ((WebViewDatabaseAdapter)this.mFactory.getWebViewDatabase(this.mContext)).setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt) {
    null = this.mWebSettings.mAwSettings;
    float f = paramInt;
    synchronized (null.mAwSettingsLock) {
      if (null.mInitialPageScalePercent != f) {
        null.mInitialPageScalePercent = f;
        null.mEventHandler.runOnUiThreadBlockingAndLocked((Runnable)new Object(null));
      } 
      return;
    } 
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {
    if (this.mAwContents == null)
      return; 
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      ThreadUtils.postOnUiThread(new WebViewChromium$96(this, paramInt, paramPaint));
      return;
    } 
    this.mAwContents.setLayerType$42d5a443(paramInt);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    this.mFactory.startYourEngines(false);
    checkThread();
    this.mWebViewPrivate.super_setLayoutParams(paramLayoutParams);
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.runVoidTaskOnUiThreadBlocking(new WebViewChromium$75(this));
      return;
    } 
    this.mAwContents.mLayoutSizer.updateLayoutSettings();
  }
  
  public void setMapTrackballToArrowKeys(boolean paramBoolean) {}
  
  public void setNetworkAvailable(boolean paramBoolean) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$12(this, paramBoolean));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1)) {
      NetworkChangeNotifier.setAutoDetectConnectivityState(false);
      awContents.nativeSetJsOnlineProperty(awContents.mNativeAwContents, paramBoolean);
    } 
  }
  
  public void setOverScrollMode(int paramInt) {
    if (this.mAwContents == null)
      return; 
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$70(this, paramInt));
      return;
    } 
    this.mAwContents.setOverScrollMode(paramInt);
  }
  
  public void setPictureListener(WebView.PictureListener paramPictureListener) {
    boolean bool1;
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$58(this, paramPictureListener));
      return;
    } 
    int i = this.mAppTargetSdkVersion;
    boolean bool2 = false;
    if (i >= 18) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.mContentsClientAdapter.setPictureListener(paramPictureListener, bool1);
    AwContents awContents = this.mAwContents;
    if (paramPictureListener != null)
      bool2 = true; 
    if (!awContents.isDestroyedOrNoOperation(1)) {
      if (bool1) {
        awContents.mPictureListenerContentProvider = null;
      } else if (bool2 && awContents.mPictureListenerContentProvider == null) {
        awContents.mPictureListenerContentProvider = (Callable)new Object(awContents);
      } 
      awContents.nativeEnableOnNewPicture(awContents.mNativeAwContents, bool2);
    } 
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean) {
    switch (paramInt) {
      default:
        paramInt = 2;
        break;
      case 1:
        paramInt = 1;
        break;
      case 0:
        paramInt = 0;
        break;
    } 
    AwContents awContents = this.mAwContents;
    awContents.mRendererPriority = paramInt;
    awContents.mRendererPriorityWaivedWhenNotVisible = paramBoolean;
    awContents.updateChildProcessImportance();
  }
  
  public void setScrollBarStyle(int paramInt) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$71(this, paramInt));
      return;
    } 
    this.mAwContents.setScrollBarStyle(paramInt);
  }
  
  public void setSmartClipResultHandler(Handler paramHandler) {
    checkThread();
    this.mAwContents.setSmartClipResultHandler(paramHandler);
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier) {
    this.mAwContents.setTextClassifier(paramTextClassifier);
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean) {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$5(this, paramBoolean));
      return;
    } 
    this.mAwContents.mOverlayVerticalScrollbar = paramBoolean;
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient) {
    AwSettings awSettings = this.mWebSettings.mAwSettings;
    boolean bool = doesSupportFullscreen(paramWebChromeClient);
    synchronized (awSettings.mAwSettingsLock) {
      if (awSettings.mFullscreenSupported != bool) {
        awSettings.mFullscreenSupported = bool;
        awSettings.mEventHandler.updateWebkitPreferencesLocked();
      } 
      this.mSharedWebViewChromium.mWebChromeClient = paramWebChromeClient;
      this.mContentsClientAdapter.mWebChromeClient = this.mSharedWebViewChromium.mWebChromeClient;
      return;
    } 
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient) {
    Throwable throwable;
    SharedWebViewChromium sharedWebViewChromium = this.mSharedWebViewChromium;
    if (paramWebViewClient == null)
      paramWebViewClient = SharedWebViewChromium.sNullWebViewClient; 
    sharedWebViewChromium.mWebViewClient = paramWebViewClient;
    WebViewContentsClientAdapter webViewContentsClientAdapter1 = this.mContentsClientAdapter;
    WebViewClient webViewClient = this.mSharedWebViewChromium.mWebViewClient;
    webViewContentsClientAdapter1.mWebViewClient = webViewClient;
    SupportLibWebViewContentsClientAdapter supportLibWebViewContentsClientAdapter = webViewContentsClientAdapter1.mSupportLibClient;
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("SupportLibWebViewContentsClientAdapter.setWebViewClient");
    WebViewContentsClientAdapter webViewContentsClientAdapter2 = null;
    webViewContentsClientAdapter1 = webViewContentsClientAdapter2;
    try {
      WebViewClientBoundaryInterface webViewClientBoundaryInterface;
      String[] arrayOfString;
      if (!SupportLibWebViewContentsClientAdapter.clientIsCompat(webViewClient)) {
        webViewClient = null;
      } else {
        webViewContentsClientAdapter1 = webViewContentsClientAdapter2;
        webViewClientBoundaryInterface = (WebViewClientBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewClientBoundaryInterface.class, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(webViewClient));
      } 
      webViewContentsClientAdapter1 = webViewContentsClientAdapter2;
      supportLibWebViewContentsClientAdapter.mWebViewClient = webViewClientBoundaryInterface;
      webViewContentsClientAdapter1 = webViewContentsClientAdapter2;
      if (supportLibWebViewContentsClientAdapter.mWebViewClient == null) {
        webViewContentsClientAdapter1 = webViewContentsClientAdapter2;
        arrayOfString = SupportLibWebViewContentsClientAdapter.EMPTY_FEATURE_LIST;
      } else {
        webViewContentsClientAdapter1 = webViewContentsClientAdapter2;
        arrayOfString = supportLibWebViewContentsClientAdapter.mWebViewClient.getSupportedFeatures();
      } 
      webViewContentsClientAdapter1 = webViewContentsClientAdapter2;
      supportLibWebViewContentsClientAdapter.mWebViewClientSupportedFeatures = arrayOfString;
      if (scopedSysTraceEvent != null) {
        scopedSysTraceEvent.close();
        return;
      } 
      return;
    } catch (Throwable throwable1) {
      throwable = throwable1;
      throw throwable1;
    } finally {}
    if (scopedSysTraceEvent != null)
      if (throwable != null) {
        try {
          scopedSysTraceEvent.close();
        } catch (Throwable throwable1) {
          ThrowableExtension.addSuppressed(throwable, throwable1);
        } 
      } else {
        scopedSysTraceEvent.close();
      }  
    throw webViewClient;
  }
  
  public boolean shouldDelayChildPressedState() {
    this.mFactory.startYourEngines(false);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$66(this))).booleanValue() : true;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean) {
    this.mFactory.startYourEngines(false);
    if (this.mSharedWebViewChromium.checkNeedsPost())
      return false; 
    if (this.mWebView.getParent() == null)
      return false; 
    FindActionModeCallback findActionModeCallback = new FindActionModeCallback(this.mContext);
    this.mWebView.startActionMode((ActionMode.Callback)findActionModeCallback);
    findActionModeCallback.setWebView(this.mWebView);
    if (paramBoolean)
      findActionModeCallback.showSoftInput(); 
    if (paramString != null) {
      findActionModeCallback.setText(paramString);
      findActionModeCallback.findAll();
    } 
    return true;
  }
  
  public void stopLoading() {
    if (this.mSharedWebViewChromium.checkNeedsPost()) {
      this.mFactory.addTask(new WebViewChromium$22(this));
      return;
    } 
    AwContents awContents = this.mAwContents;
    if (!awContents.isDestroyedOrNoOperation(1))
      awContents.mWebContents.stop(); 
  }
  
  public boolean zoomBy(float paramFloat) {
    this.mFactory.startYourEngines(true);
    checkThread();
    this.mAwContents.zoomBy(paramFloat);
    return true;
  }
  
  public boolean zoomIn() {
    this.mFactory.startYourEngines(true);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$62(this))).booleanValue() : this.mAwContents.zoomIn();
  }
  
  public boolean zoomOut() {
    this.mFactory.startYourEngines(true);
    return this.mSharedWebViewChromium.checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new WebViewChromium$63(this))).booleanValue() : this.mAwContents.zoomOut();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */