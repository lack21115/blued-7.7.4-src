package com.android.webview.chromium;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsDialogHelper;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.chromium.android_webview.AwConsoleMessage;
import org.chromium.android_webview.AwContents;
import org.chromium.android_webview.AwContentsClient;
import org.chromium.android_webview.AwContentsClientBridge;
import org.chromium.android_webview.AwGeolocationPermissions;
import org.chromium.android_webview.AwHttpAuthHandler;
import org.chromium.android_webview.AwRenderProcessGoneDetail;
import org.chromium.android_webview.AwSafeBrowsingResponse;
import org.chromium.android_webview.AwWebResourceResponse;
import org.chromium.android_webview.JsPromptResultReceiver;
import org.chromium.android_webview.JsResultReceiver;
import org.chromium.android_webview.R;
import org.chromium.android_webview.ScopedSysTraceEvent;
import org.chromium.android_webview.permission.AwPermissionRequest;
import org.chromium.base.Callback;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_callback_glue.SupportLibSafeBrowsingResponse;
import org.chromium.support_lib_callback_glue.SupportLibWebResourceError;
import org.chromium.support_lib_callback_glue.SupportLibWebViewContentsClientAdapter;

class WebViewContentsClientAdapter extends AwContentsClient {
  private static Method sWebChromeClientThemeColorMethod;
  
  private static boolean sWebChromeClientThemeColorMethodInitialized = false;
  
  private final Context mContext;
  
  DownloadListener mDownloadListener;
  
  WebView.FindListener mFindListener;
  
  private WeakHashMap mOngoingPermissionRequests;
  
  private WebView.PictureListener mPictureListener;
  
  private boolean mPictureListenerInvalidateOnly;
  
  final SupportLibWebViewContentsClientAdapter mSupportLibClient;
  
  private Handler mUiThreadHandler;
  
  WebChromeClient mWebChromeClient;
  
  protected final WebView mWebView;
  
  WebViewClient mWebViewClient = SharedWebViewChromium.sNullWebViewClient;
  
  private WebViewDelegateFactory$WebViewDelegate mWebViewDelegate;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @SuppressLint({"HandlerLeak"})
  WebViewContentsClientAdapter(WebView paramWebView, Context paramContext, WebViewDelegateFactory$WebViewDelegate paramWebViewDelegateFactory$WebViewDelegate) {
    if (paramWebView != null && paramWebViewDelegateFactory$WebViewDelegate != null) {
      if (paramContext != null) {
        Throwable throwable;
        this.mContext = paramContext;
        this.mWebView = paramWebView;
        this.mWebViewDelegate = paramWebViewDelegateFactory$WebViewDelegate;
        ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("WebViewContentsClientAdapter.constructor");
        paramContext = null;
        Context context = paramContext;
        try {
          this.mSupportLibClient = new SupportLibWebViewContentsClientAdapter();
          context = paramContext;
          boolean bool = sWebChromeClientThemeColorMethodInitialized;
          if (!bool) {
            context = paramContext;
            try {
              sWebChromeClientThemeColorMethod = WebChromeClient.class.getMethod("onThemeColorChanged", new Class[] { WebView.class, int.class });
            } catch (Exception null) {}
            context = paramContext;
            sWebChromeClientThemeColorMethodInitialized = true;
          } 
          context = paramContext;
          this.mUiThreadHandler = new WebViewContentsClientAdapter$1(this);
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
            throwable1.close();
          }  
        throw paramContext;
      } 
      throw new IllegalArgumentException("context can't be null.");
    } 
    throw new IllegalArgumentException("webView or delegate can't be null.");
  }
  
  private static boolean isMethodDeclaredInSubClass(Class paramClass1, Class paramClass2, String paramString, Class... paramVarArgs) {
    try {
      boolean bool = paramClass2.getMethod(paramString, paramVarArgs).getDeclaringClass().equals(paramClass1);
      return !bool;
    } catch (SecurityException securityException) {
      return false;
    } catch (NoSuchMethodException noSuchMethodException) {
      return false;
    } 
  }
  
  private boolean showDefaultJsDialog(JsPromptResult paramJsPromptResult, int paramInt, String paramString1, String paramString2, String paramString3) {
    Activity activity = AwContents.activityFromContext(this.mContext);
    if (activity == null) {
      Log.w("WebViewCallback", "Unable to create JsDialog without an Activity", new Object[0]);
      return false;
    } 
    try {
      (new JsDialogHelper(paramJsPromptResult, paramInt, paramString1, paramString2, paramString3)).showDialog((Context)activity);
      return true;
    } catch (android.view.WindowManager.BadTokenException badTokenException) {
      Log.w("WebViewCallback", "Unable to create JsDialog. Has this WebView outlived the Activity it was created with?", new Object[0]);
      return false;
    } 
  }
  
  public final void doUpdateVisitedHistory(String paramString, boolean paramBoolean) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.doUpdateVisitedHistory");
      this.mWebViewClient.doUpdateVisitedHistory(this.mWebView, paramString, paramBoolean);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.doUpdateVisitedHistory");
    } 
  }
  
  public final Bitmap getDefaultVideoPoster() {
    try {
      Bitmap bitmap1;
      TraceEvent.begin("WebViewContentsClientAdapter.getDefaultVideoPoster");
      if (this.mWebChromeClient != null) {
        bitmap1 = this.mWebChromeClient.getDefaultVideoPoster();
      } else {
        bitmap1 = null;
      } 
      Bitmap bitmap2 = bitmap1;
      if (bitmap1 == null) {
        bitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ic_play_circle_outline_black_48dp);
        bitmap2 = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), bitmap1.getConfig());
        bitmap2.eraseColor(-7829368);
        (new Canvas(bitmap2)).drawBitmap(bitmap1, 0.0F, 0.0F, null);
      } 
      return bitmap2;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.getDefaultVideoPoster");
    } 
  }
  
  public final void getVisitedHistory(Callback paramCallback) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.getVisitedHistory");
      if (this.mWebChromeClient != null) {
        WebViewContentsClientAdapter$$Lambda$0 webViewContentsClientAdapter$$Lambda$0;
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (paramCallback == null) {
          paramCallback = null;
        } else {
          webViewContentsClientAdapter$$Lambda$0 = new WebViewContentsClientAdapter$$Lambda$0(paramCallback);
        } 
        webChromeClient.getVisitedHistory(webViewContentsClientAdapter$$Lambda$0);
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.getVisitedHistory");
    } 
  }
  
  public final void handleJsAlert(String paramString1, String paramString2, JsResultReceiver paramJsResultReceiver) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.handleJsAlert");
      if (this.mWebChromeClient != null) {
        JsPromptResult jsPromptResult = (new WebViewContentsClientAdapter$JsPromptResultReceiverAdapter(paramJsResultReceiver)).mPromptResult;
        if (!this.mWebChromeClient.onJsAlert(this.mWebView, paramString1, paramString2, (JsResult)jsPromptResult) && !showDefaultJsDialog(jsPromptResult, 1, null, paramString2, paramString1))
          paramJsResultReceiver.cancel(); 
      } else {
        paramJsResultReceiver.cancel();
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.handleJsAlert");
    } 
  }
  
  public final void handleJsBeforeUnload(String paramString1, String paramString2, JsResultReceiver paramJsResultReceiver) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.handleJsBeforeUnload");
      if (this.mWebChromeClient != null) {
        JsPromptResult jsPromptResult = (new WebViewContentsClientAdapter$JsPromptResultReceiverAdapter(paramJsResultReceiver)).mPromptResult;
        if (!this.mWebChromeClient.onJsBeforeUnload(this.mWebView, paramString1, paramString2, (JsResult)jsPromptResult) && !showDefaultJsDialog(jsPromptResult, 4, null, paramString2, paramString1))
          paramJsResultReceiver.cancel(); 
      } else {
        paramJsResultReceiver.cancel();
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.handleJsBeforeUnload");
    } 
  }
  
  public final void handleJsConfirm(String paramString1, String paramString2, JsResultReceiver paramJsResultReceiver) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.handleJsConfirm");
      if (this.mWebChromeClient != null) {
        JsPromptResult jsPromptResult = (new WebViewContentsClientAdapter$JsPromptResultReceiverAdapter(paramJsResultReceiver)).mPromptResult;
        if (!this.mWebChromeClient.onJsConfirm(this.mWebView, paramString1, paramString2, (JsResult)jsPromptResult) && !showDefaultJsDialog(jsPromptResult, 2, null, paramString2, paramString1))
          paramJsResultReceiver.cancel(); 
      } else {
        paramJsResultReceiver.cancel();
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.handleJsConfirm");
    } 
  }
  
  public final void handleJsPrompt(String paramString1, String paramString2, String paramString3, JsPromptResultReceiver paramJsPromptResultReceiver) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.handleJsPrompt");
      if (this.mWebChromeClient != null) {
        JsPromptResult jsPromptResult = (new WebViewContentsClientAdapter$JsPromptResultReceiverAdapter(paramJsPromptResultReceiver)).mPromptResult;
        if (!this.mWebChromeClient.onJsPrompt(this.mWebView, paramString1, paramString2, paramString3, jsPromptResult) && !showDefaultJsDialog(jsPromptResult, 3, paramString3, paramString2, paramString1))
          paramJsPromptResultReceiver.cancel(); 
      } else {
        paramJsPromptResultReceiver.cancel();
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.handleJsPrompt");
    } 
  }
  
  public final boolean hasWebViewClient() {
    return (this.mWebViewClient != SharedWebViewChromium.sNullWebViewClient);
  }
  
  public final void onCloseWindow() {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onCloseWindow");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onCloseWindow(this.mWebView); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onCloseWindow");
    } 
  }
  
  public final boolean onConsoleMessage(AwConsoleMessage paramAwConsoleMessage) {
    // Byte code:
    //   0: ldc_w 'WebViewContentsClientAdapter.onConsoleMessage'
    //   3: invokestatic begin : (Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield mWebChromeClient : Landroid/webkit/WebChromeClient;
    //   10: ifnull -> 173
    //   13: aload_0
    //   14: getfield mWebChromeClient : Landroid/webkit/WebChromeClient;
    //   17: astore #5
    //   19: aload_1
    //   20: ifnonnull -> 28
    //   23: aconst_null
    //   24: astore_1
    //   25: goto -> 133
    //   28: aload_1
    //   29: getfield mMessage : Ljava/lang/String;
    //   32: astore #6
    //   34: aload_1
    //   35: getfield mSourceId : Ljava/lang/String;
    //   38: astore #7
    //   40: aload_1
    //   41: getfield mLineNumber : I
    //   44: istore_2
    //   45: aload_1
    //   46: getfield mLevel : I
    //   49: istore_3
    //   50: iload_3
    //   51: tableswitch default -> 194, 0 -> 115, 1 -> 108, 2 -> 101, 3 -> 94, 4 -> 87
    //   84: goto -> 144
    //   87: getstatic android/webkit/ConsoleMessage$MessageLevel.DEBUG : Landroid/webkit/ConsoleMessage$MessageLevel;
    //   90: astore_1
    //   91: goto -> 119
    //   94: getstatic android/webkit/ConsoleMessage$MessageLevel.ERROR : Landroid/webkit/ConsoleMessage$MessageLevel;
    //   97: astore_1
    //   98: goto -> 119
    //   101: getstatic android/webkit/ConsoleMessage$MessageLevel.WARNING : Landroid/webkit/ConsoleMessage$MessageLevel;
    //   104: astore_1
    //   105: goto -> 119
    //   108: getstatic android/webkit/ConsoleMessage$MessageLevel.LOG : Landroid/webkit/ConsoleMessage$MessageLevel;
    //   111: astore_1
    //   112: goto -> 119
    //   115: getstatic android/webkit/ConsoleMessage$MessageLevel.TIP : Landroid/webkit/ConsoleMessage$MessageLevel;
    //   118: astore_1
    //   119: new android/webkit/ConsoleMessage
    //   122: dup
    //   123: aload #6
    //   125: aload #7
    //   127: iload_2
    //   128: aload_1
    //   129: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;ILandroid/webkit/ConsoleMessage$MessageLevel;)V
    //   132: astore_1
    //   133: aload #5
    //   135: aload_1
    //   136: invokevirtual onConsoleMessage : (Landroid/webkit/ConsoleMessage;)Z
    //   139: istore #4
    //   141: goto -> 176
    //   144: new java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 'Unsupported value: '
    //   151: invokespecial <init> : (Ljava/lang/String;)V
    //   154: astore_1
    //   155: aload_1
    //   156: iload_3
    //   157: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: new java/lang/IllegalArgumentException
    //   164: dup
    //   165: aload_1
    //   166: invokevirtual toString : ()Ljava/lang/String;
    //   169: invokespecial <init> : (Ljava/lang/String;)V
    //   172: athrow
    //   173: iconst_0
    //   174: istore #4
    //   176: ldc_w 'WebViewContentsClientAdapter.onConsoleMessage'
    //   179: invokestatic end : (Ljava/lang/String;)V
    //   182: iload #4
    //   184: ireturn
    //   185: astore_1
    //   186: ldc_w 'WebViewContentsClientAdapter.onConsoleMessage'
    //   189: invokestatic end : (Ljava/lang/String;)V
    //   192: aload_1
    //   193: athrow
    //   194: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   0	19	185	finally
    //   28	50	185	finally
    //   87	91	185	finally
    //   94	98	185	finally
    //   101	105	185	finally
    //   108	112	185	finally
    //   115	119	185	finally
    //   119	133	185	finally
    //   133	141	185	finally
    //   144	173	185	finally
  }
  
  public final boolean onCreateWindow(boolean paramBoolean1, boolean paramBoolean2) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onCreateWindow");
      Handler handler = this.mUiThreadHandler;
      WebView webView = this.mWebView;
      webView.getClass();
      Message message = handler.obtainMessage(100, new WebView.WebViewTransport(webView));
      if (this.mWebChromeClient != null) {
        paramBoolean1 = this.mWebChromeClient.onCreateWindow(this.mWebView, paramBoolean1, paramBoolean2, message);
      } else {
        paramBoolean1 = false;
      } 
      return paramBoolean1;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onCreateWindow");
    } 
  }
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onDownloadStart");
      if (this.mDownloadListener != null)
        this.mDownloadListener.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onDownloadStart");
    } 
  }
  
  public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onFindResultReceived");
      WebView.FindListener findListener = this.mFindListener;
      if (findListener == null)
        return; 
      this.mFindListener.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onFindResultReceived");
    } 
  }
  
  public final void onFormResubmission(Message paramMessage1, Message paramMessage2) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onFormResubmission");
      this.mWebViewClient.onFormResubmission(this.mWebView, paramMessage1, paramMessage2);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onFormResubmission");
    } 
  }
  
  public final void onGeolocationPermissionsHidePrompt() {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onGeolocationPermissionsHidePrompt");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onGeolocationPermissionsHidePrompt(); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onGeolocationPermissionsHidePrompt");
    } 
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, AwGeolocationPermissions.Callback paramCallback) {
    try {
      WebViewContentsClientAdapter$$Lambda$1 webViewContentsClientAdapter$$Lambda$1;
      TraceEvent.begin("WebViewContentsClientAdapter.onGeolocationPermissionsShowPrompt");
      if (this.mWebChromeClient == null) {
        paramCallback.invoke(paramString, false, false);
        return;
      } 
      if (!isMethodDeclaredInSubClass(WebChromeClient.class, this.mWebChromeClient.getClass(), "onGeolocationPermissionsShowPrompt", new Class[] { String.class, GeolocationPermissions.Callback.class })) {
        paramCallback.invoke(paramString, false, false);
        return;
      } 
      WebChromeClient webChromeClient = this.mWebChromeClient;
      if (paramCallback == null) {
        paramCallback = null;
      } else {
        webViewContentsClientAdapter$$Lambda$1 = new WebViewContentsClientAdapter$$Lambda$1(paramCallback);
      } 
      webChromeClient.onGeolocationPermissionsShowPrompt(paramString, webViewContentsClientAdapter$$Lambda$1);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onGeolocationPermissionsShowPrompt");
    } 
  }
  
  public final void onHideCustomView() {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onHideCustomView");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onHideCustomView(); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onHideCustomView");
    } 
  }
  
  public final void onLoadResource(String paramString) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onLoadResource");
      this.mWebViewClient.onLoadResource(this.mWebView, paramString);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onLoadResource");
    } 
  }
  
  public final void onNewPicture(Picture paramPicture) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onNewPicture");
      WebView.PictureListener pictureListener = this.mPictureListener;
      if (pictureListener == null)
        return; 
      this.mPictureListener.onNewPicture(this.mWebView, paramPicture);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onNewPicture");
    } 
  }
  
  public final void onPageCommitVisible(String paramString) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onPageCommitVisible");
      if (this.mSupportLibClient.isFeatureAvailable("VISUAL_STATE_CALLBACK")) {
        SupportLibWebViewContentsClientAdapter supportLibWebViewContentsClientAdapter = this.mSupportLibClient;
        WebView webView = this.mWebView;
        if (SupportLibWebViewContentsClientAdapter.$assertionsDisabled || supportLibWebViewContentsClientAdapter.isFeatureAvailable("VISUAL_STATE_CALLBACK")) {
          supportLibWebViewContentsClientAdapter.mWebViewClient.onPageCommitVisible(webView, paramString);
        } else {
          throw new AssertionError();
        } 
      } else if (Build.VERSION.SDK_INT >= 23) {
        ApiHelperForM.onPageCommitVisible(this.mWebViewClient, this.mWebView, paramString);
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onPageCommitVisible");
    } 
  }
  
  public final void onPageFinished(String paramString) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onPageFinished");
      this.mWebViewClient.onPageFinished(this.mWebView, paramString);
      if (this.mPictureListener != null)
        ThreadUtils.postOnUiThreadDelayed(new WebViewContentsClientAdapter$2(this), 100L); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onPageFinished");
    } 
  }
  
  public final void onPageStarted(String paramString) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onPageStarted");
      this.mWebViewClient.onPageStarted(this.mWebView, paramString, this.mWebView.getFavicon());
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onPageStarted");
    } 
  }
  
  public final void onPermissionRequest(AwPermissionRequest paramAwPermissionRequest) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onPermissionRequest");
      if (this.mWebChromeClient != null) {
        if (this.mOngoingPermissionRequests == null)
          this.mOngoingPermissionRequests = new WeakHashMap<Object, Object>(); 
        WebViewContentsClientAdapter$PermissionRequestAdapter webViewContentsClientAdapter$PermissionRequestAdapter = new WebViewContentsClientAdapter$PermissionRequestAdapter(paramAwPermissionRequest);
        this.mOngoingPermissionRequests.put(paramAwPermissionRequest, new WeakReference<WebViewContentsClientAdapter$PermissionRequestAdapter>(webViewContentsClientAdapter$PermissionRequestAdapter));
        this.mWebChromeClient.onPermissionRequest(webViewContentsClientAdapter$PermissionRequestAdapter);
      } else {
        paramAwPermissionRequest.deny();
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onPermissionRequest");
    } 
  }
  
  public final void onPermissionRequestCanceled(AwPermissionRequest paramAwPermissionRequest) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onPermissionRequestCanceled");
      if (this.mWebChromeClient != null && this.mOngoingPermissionRequests != null) {
        WeakReference<WebViewContentsClientAdapter$PermissionRequestAdapter> weakReference = (WeakReference)this.mOngoingPermissionRequests.get(paramAwPermissionRequest);
        if (weakReference != null) {
          WebViewContentsClientAdapter$PermissionRequestAdapter webViewContentsClientAdapter$PermissionRequestAdapter = weakReference.get();
          if (webViewContentsClientAdapter$PermissionRequestAdapter != null)
            this.mWebChromeClient.onPermissionRequestCanceled(webViewContentsClientAdapter$PermissionRequestAdapter); 
        } 
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onPermissionRequestCanceled");
    } 
  }
  
  public final void onProgressChanged(int paramInt) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onProgressChanged");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onProgressChanged(this.mWebView, paramInt); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onProgressChanged");
    } 
  }
  
  public final void onReceivedClientCertRequest(AwContentsClientBridge.ClientCertificateRequestCallback paramClientCertificateRequestCallback, String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, String paramString, int paramInt) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedClientCertRequest");
      WebViewContentsClientAdapter$ClientCertRequestImpl webViewContentsClientAdapter$ClientCertRequestImpl = new WebViewContentsClientAdapter$ClientCertRequestImpl(paramClientCertificateRequestCallback, paramArrayOfString, paramArrayOfPrincipal, paramString, paramInt);
      this.mWebViewClient.onReceivedClientCertRequest(this.mWebView, webViewContentsClientAdapter$ClientCertRequestImpl);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedClientCertRequest");
    } 
  }
  
  public final void onReceivedError(int paramInt, String paramString1, String paramString2) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #23
    //   5: if_icmplt -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield mSupportLibClient : Lorg/chromium/support_lib_callback_glue/SupportLibWebViewContentsClientAdapter;
    //   13: ldc_w 'RECEIVE_WEB_RESOURCE_ERROR'
    //   16: invokevirtual isFeatureAvailable : (Ljava/lang/String;)Z
    //   19: ifeq -> 23
    //   22: return
    //   23: ldc_w 'WebViewContentsClientAdapter.onReceivedError'
    //   26: invokestatic begin : (Ljava/lang/String;)V
    //   29: aload_2
    //   30: ifnull -> 43
    //   33: aload_2
    //   34: astore #4
    //   36: aload_2
    //   37: invokevirtual isEmpty : ()Z
    //   40: ifeq -> 59
    //   43: aload_0
    //   44: getfield mWebViewDelegate : Lcom/android/webview/chromium/WebViewDelegateFactory$WebViewDelegate;
    //   47: aload_0
    //   48: getfield mContext : Landroid/content/Context;
    //   51: iload_1
    //   52: invokeinterface getErrorString : (Landroid/content/Context;I)Ljava/lang/String;
    //   57: astore #4
    //   59: aload_0
    //   60: getfield mWebViewClient : Landroid/webkit/WebViewClient;
    //   63: aload_0
    //   64: getfield mWebView : Landroid/webkit/WebView;
    //   67: iload_1
    //   68: aload #4
    //   70: aload_3
    //   71: invokevirtual onReceivedError : (Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    //   74: ldc_w 'WebViewContentsClientAdapter.onReceivedError'
    //   77: invokestatic end : (Ljava/lang/String;)V
    //   80: return
    //   81: astore_2
    //   82: ldc_w 'WebViewContentsClientAdapter.onReceivedError'
    //   85: invokestatic end : (Ljava/lang/String;)V
    //   88: aload_2
    //   89: athrow
    // Exception table:
    //   from	to	target	type
    //   23	29	81	finally
    //   36	43	81	finally
    //   43	59	81	finally
    //   59	74	81	finally
  }
  
  public final void onReceivedError2(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest, AwContentsClient.AwWebResourceError paramAwWebResourceError) {
    try {
      WebResourceRequestAdapter webResourceRequestAdapter;
      InvocationHandler invocationHandler;
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedError");
      if (paramAwWebResourceError.description == null || paramAwWebResourceError.description.isEmpty())
        paramAwWebResourceError.description = this.mWebViewDelegate.getErrorString(this.mContext, paramAwWebResourceError.errorCode); 
      if (this.mSupportLibClient.isFeatureAvailable("RECEIVE_WEB_RESOURCE_ERROR")) {
        SupportLibWebViewContentsClientAdapter supportLibWebViewContentsClientAdapter = this.mSupportLibClient;
        WebView webView = this.mWebView;
        webResourceRequestAdapter = new WebResourceRequestAdapter(paramAwWebResourceRequest);
        if (SupportLibWebViewContentsClientAdapter.$assertionsDisabled || supportLibWebViewContentsClientAdapter.isFeatureAvailable("RECEIVE_WEB_RESOURCE_ERROR")) {
          invocationHandler = BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebResourceError(paramAwWebResourceError));
          supportLibWebViewContentsClientAdapter.mWebViewClient.onReceivedError(webView, webResourceRequestAdapter, invocationHandler);
        } else {
          throw new AssertionError();
        } 
      } else if (Build.VERSION.SDK_INT >= 23) {
        ApiHelperForM.onReceivedError(this.mWebViewClient, this.mWebView, (AwContentsClient.AwWebResourceRequest)webResourceRequestAdapter, (AwContentsClient.AwWebResourceError)invocationHandler);
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedError");
    } 
  }
  
  public final void onReceivedHttpAuthRequest(AwHttpAuthHandler paramAwHttpAuthHandler, String paramString1, String paramString2) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedHttpAuthRequest");
      this.mWebViewClient.onReceivedHttpAuthRequest(this.mWebView, new WebViewContentsClientAdapter$AwHttpAuthHandlerAdapter(paramAwHttpAuthHandler), paramString1, paramString2);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedHttpAuthRequest");
    } 
  }
  
  public final void onReceivedHttpError(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest, AwWebResourceResponse paramAwWebResourceResponse) {
    try {
      WebResourceRequestAdapter webResourceRequestAdapter;
      WebResourceResponse webResourceResponse;
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedHttpError");
      if (this.mSupportLibClient.isFeatureAvailable("RECEIVE_HTTP_ERROR")) {
        SupportLibWebViewContentsClientAdapter supportLibWebViewContentsClientAdapter = this.mSupportLibClient;
        WebView webView = this.mWebView;
        webResourceRequestAdapter = new WebResourceRequestAdapter(paramAwWebResourceRequest);
        webResourceResponse = new WebResourceResponse(paramAwWebResourceResponse.getMimeType(), paramAwWebResourceResponse.getCharset(), paramAwWebResourceResponse.getStatusCode(), paramAwWebResourceResponse.getReasonPhrase(), paramAwWebResourceResponse.mResponseHeaders, paramAwWebResourceResponse.getData());
        if (SupportLibWebViewContentsClientAdapter.$assertionsDisabled || supportLibWebViewContentsClientAdapter.isFeatureAvailable("RECEIVE_HTTP_ERROR")) {
          supportLibWebViewContentsClientAdapter.mWebViewClient.onReceivedHttpError(webView, webResourceRequestAdapter, webResourceResponse);
        } else {
          throw new AssertionError();
        } 
      } else if (Build.VERSION.SDK_INT >= 23) {
        ApiHelperForM.onReceivedHttpError(this.mWebViewClient, this.mWebView, (AwContentsClient.AwWebResourceRequest)webResourceRequestAdapter, (AwWebResourceResponse)webResourceResponse);
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedHttpError");
    } 
  }
  
  public final void onReceivedIcon(Bitmap paramBitmap) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedIcon");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onReceivedIcon(this.mWebView, paramBitmap); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedIcon");
    } 
  }
  
  public final void onReceivedLoginRequest(String paramString1, String paramString2, String paramString3) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedLoginRequest");
      this.mWebViewClient.onReceivedLoginRequest(this.mWebView, paramString1, paramString2, paramString3);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedLoginRequest");
    } 
  }
  
  public final void onReceivedSslError(Callback paramCallback, SslError paramSslError) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedSslError");
      WebViewContentsClientAdapter$3 webViewContentsClientAdapter$3 = new WebViewContentsClientAdapter$3(paramCallback);
      this.mWebViewClient.onReceivedSslError(this.mWebView, webViewContentsClientAdapter$3, paramSslError);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedSslError");
    } 
  }
  
  public final void onReceivedTitle(String paramString) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedTitle");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onReceivedTitle(this.mWebView, paramString); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedTitle");
    } 
  }
  
  public final void onReceivedTouchIconUrl(String paramString, boolean paramBoolean) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onReceivedTouchIconUrl");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onReceivedTouchIconUrl(this.mWebView, paramString, paramBoolean); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onReceivedTouchIconUrl");
    } 
  }
  
  public final boolean onRenderProcessGone(AwRenderProcessGoneDetail paramAwRenderProcessGoneDetail) {
    if (Build.VERSION.SDK_INT < 26)
      return false; 
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onRenderProcessGone");
      return ApiHelperForO.onRenderProcessGone(this.mWebViewClient, this.mWebView, paramAwRenderProcessGoneDetail);
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onRenderProcessGone");
    } 
  }
  
  public final void onRequestFocus() {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onRequestFocus");
      if (this.mWebChromeClient != null)
        this.mWebChromeClient.onRequestFocus(this.mWebView); 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onRequestFocus");
    } 
  }
  
  public final void onSafeBrowsingHit(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest, int paramInt, Callback paramCallback) {
    try {
      WebResourceRequestAdapter webResourceRequestAdapter;
      InvocationHandler invocationHandler;
      TraceEvent.begin("WebViewContentsClientAdapter.onSafeBrowsingHit");
      if (this.mSupportLibClient.isFeatureAvailable("SAFE_BROWSING_HIT")) {
        SupportLibWebViewContentsClientAdapter supportLibWebViewContentsClientAdapter = this.mSupportLibClient;
        WebView webView = this.mWebView;
        webResourceRequestAdapter = new WebResourceRequestAdapter(paramAwWebResourceRequest);
        if (SupportLibWebViewContentsClientAdapter.$assertionsDisabled || supportLibWebViewContentsClientAdapter.isFeatureAvailable("SAFE_BROWSING_HIT")) {
          invocationHandler = BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibSafeBrowsingResponse(paramCallback));
          supportLibWebViewContentsClientAdapter.mWebViewClient.onSafeBrowsingHit(webView, webResourceRequestAdapter, paramInt, invocationHandler);
        } else {
          throw new AssertionError();
        } 
      } else if (Build.VERSION.SDK_INT >= 27) {
        ApiHelperForOMR1.onSafeBrowsingHit(this.mWebViewClient, this.mWebView, (AwContentsClient.AwWebResourceRequest)webResourceRequestAdapter, paramInt, (Callback)invocationHandler);
      } else {
        invocationHandler.onResult(new AwSafeBrowsingResponse(0, true));
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onSafeBrowsingHit");
    } 
  }
  
  public final void onScaleChangedScaled(float paramFloat1, float paramFloat2) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onScaleChangedScaled");
      this.mWebViewClient.onScaleChanged(this.mWebView, paramFloat1, paramFloat2);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onScaleChangedScaled");
    } 
  }
  
  public final void onShowCustomView(View paramView, AwContentsClient.CustomViewCallback paramCustomViewCallback) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onShowCustomView");
      if (this.mWebChromeClient != null) {
        WebViewContentsClientAdapter$$Lambda$2 webViewContentsClientAdapter$$Lambda$2;
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (paramCustomViewCallback == null) {
          paramCustomViewCallback = null;
        } else {
          webViewContentsClientAdapter$$Lambda$2 = new WebViewContentsClientAdapter$$Lambda$2(paramCustomViewCallback);
        } 
        webChromeClient.onShowCustomView(paramView, webViewContentsClientAdapter$$Lambda$2);
      } 
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onShowCustomView");
    } 
  }
  
  public final void onThemeColorChanged(int paramInt) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onThemeColorChanged");
    } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
    
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onThemeColorChanged");
    } 
    TraceEvent.end("WebViewContentsClientAdapter.onThemeColorChanged");
  }
  
  public final void onUnhandledKeyEvent(KeyEvent paramKeyEvent) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.onUnhandledKeyEvent");
      this.mWebViewClient.onUnhandledKeyEvent(this.mWebView, paramKeyEvent);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.onUnhandledKeyEvent");
    } 
  }
  
  final void setPictureListener(WebView.PictureListener paramPictureListener, boolean paramBoolean) {
    this.mPictureListener = paramPictureListener;
    this.mPictureListenerInvalidateOnly = paramBoolean;
  }
  
  public final AwWebResourceResponse shouldInterceptRequest(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.shouldInterceptRequest");
      WebResourceResponse webResourceResponse = this.mWebViewClient.shouldInterceptRequest(this.mWebView, new WebResourceRequestAdapter(paramAwWebResourceRequest));
      if (webResourceResponse == null)
        return null; 
      Map<Object, Object> map2 = webResourceResponse.getResponseHeaders();
      Map<Object, Object> map1 = map2;
      if (map2 == null)
        map1 = new HashMap<Object, Object>(); 
      return new AwWebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), map1);
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.shouldInterceptRequest");
    } 
  }
  
  public final boolean shouldOverrideKeyEvent(KeyEvent paramKeyEvent) {
    try {
      TraceEvent.begin("WebViewContentsClientAdapter.shouldOverrideKeyEvent");
      return this.mWebViewClient.shouldOverrideKeyEvent(this.mWebView, paramKeyEvent);
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.shouldOverrideKeyEvent");
    } 
  }
  
  public final boolean shouldOverrideUrlLoading(AwContentsClient.AwWebResourceRequest paramAwWebResourceRequest) {
    try {
      WebResourceRequestAdapter webResourceRequestAdapter;
      boolean bool;
      TraceEvent.begin("WebViewContentsClientAdapter.shouldOverrideUrlLoading");
      if (this.mSupportLibClient.isFeatureAvailable("SHOULD_OVERRIDE_WITH_REDIRECTS")) {
        SupportLibWebViewContentsClientAdapter supportLibWebViewContentsClientAdapter = this.mSupportLibClient;
        WebView webView = this.mWebView;
        webResourceRequestAdapter = new WebResourceRequestAdapter(paramAwWebResourceRequest);
        if (SupportLibWebViewContentsClientAdapter.$assertionsDisabled || supportLibWebViewContentsClientAdapter.isFeatureAvailable("SHOULD_OVERRIDE_WITH_REDIRECTS")) {
          bool = supportLibWebViewContentsClientAdapter.mWebViewClient.shouldOverrideUrlLoading(webView, webResourceRequestAdapter);
          return bool;
        } 
        throw new AssertionError();
      } 
      if (Build.VERSION.SDK_INT >= 24) {
        bool = ApiHelperForN.shouldOverrideUrlLoading(this.mWebViewClient, this.mWebView, (AwContentsClient.AwWebResourceRequest)webResourceRequestAdapter);
      } else {
        bool = this.mWebViewClient.shouldOverrideUrlLoading(this.mWebView, ((AwContentsClient.AwWebResourceRequest)webResourceRequestAdapter).url);
      } 
      return bool;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.shouldOverrideUrlLoading");
    } 
  }
  
  public final void showFileChooser(Callback paramCallback, AwContentsClient.FileChooserParamsImpl paramFileChooserParamsImpl) {
    try {
      String str1;
      WebViewContentsClientAdapter$6 webViewContentsClientAdapter$6;
      TraceEvent.begin("WebViewContentsClientAdapter.showFileChooser");
      if (this.mWebChromeClient == null) {
        paramCallback.onResult(null);
        return;
      } 
      WebViewContentsClientAdapter$4 webViewContentsClientAdapter$4 = new WebViewContentsClientAdapter$4(paramCallback);
      WebChromeClient webChromeClient2 = this.mWebChromeClient;
      WebView webView = this.mWebView;
      if (paramFileChooserParamsImpl == null) {
        webViewContentsClientAdapter$6 = null;
      } else {
        webViewContentsClientAdapter$6 = new WebViewContentsClientAdapter$6(paramFileChooserParamsImpl);
      } 
      boolean bool = webChromeClient2.onShowFileChooser(webView, webViewContentsClientAdapter$4, webViewContentsClientAdapter$6);
      if (bool)
        return; 
      if ((this.mContext.getApplicationInfo()).targetSdkVersion >= 21) {
        paramCallback.onResult(null);
        return;
      } 
      WebViewContentsClientAdapter$5 webViewContentsClientAdapter$5 = new WebViewContentsClientAdapter$5(paramCallback);
      WebChromeClient webChromeClient1 = this.mWebChromeClient;
      String str2 = paramFileChooserParamsImpl.mAcceptTypes;
      if (paramFileChooserParamsImpl.mCapture) {
        str1 = "*";
      } else {
        str1 = "";
      } 
      webChromeClient1.openFileChooser(webViewContentsClientAdapter$5, str2, str1);
      return;
    } finally {
      TraceEvent.end("WebViewContentsClientAdapter.showFileChooser");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */