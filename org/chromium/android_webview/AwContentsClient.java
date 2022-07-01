package org.chromium.android_webview;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.security.Principal;
import org.chromium.android_webview.permission.AwPermissionRequest;
import org.chromium.base.Callback;
import org.chromium.base.Log;

public abstract class AwContentsClient {
  int mCachedRendererBackgroundColor = 0;
  
  final AwContentsClientCallbackHelper mCallbackHelper;
  
  private String mTitle = "";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwContentsClient() {
    this(Looper.myLooper());
  }
  
  private AwContentsClient(Looper paramLooper) {
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("AwContentsClient.constructorOneArg");
    Throwable throwable = null;
    try {
      this.mCallbackHelper = new AwContentsClientCallbackHelper(paramLooper, this);
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
    throw paramLooper;
  }
  
  public static Uri[] parseFileChooserResult(int paramInt, Intent paramIntent) {
    Uri uri;
    Uri[] arrayOfUri = null;
    if (paramInt == 0)
      return null; 
    if (paramIntent == null || paramInt != -1) {
      paramIntent = null;
    } else {
      uri = paramIntent.getData();
    } 
    if (uri != null) {
      arrayOfUri = new Uri[1];
      arrayOfUri[0] = uri;
    } 
    return arrayOfUri;
  }
  
  static boolean sendBrowsingIntent(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    if (!paramBoolean1 && !paramBoolean2) {
      Log.w("AwContentsClient", "Denied starting an intent without a user gesture, URI %s", new Object[] { paramString });
      return true;
    } 
    if (paramString.startsWith("about:"))
      return false; 
    try {
      Intent intent1 = Intent.parseUri(paramString, 1);
      intent1.addCategory("android.intent.category.BROWSABLE");
      intent1.setComponent(null);
      Intent intent2 = intent1.getSelector();
      if (intent2 != null) {
        intent2.addCategory("android.intent.category.BROWSABLE");
        intent2.setComponent(null);
      } 
      intent1.putExtra("com.android.browser.application_id", paramContext.getPackageName());
      if (AwContents.activityFromContext(paramContext) == null) {
        Log.w("AwContentsClient", "Cannot call startActivity on non-activity context.", new Object[0]);
        return false;
      } 
      try {
        paramContext.startActivity(intent1);
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {
        Log.w("AwContentsClient", "No application can handle %s", new Object[] { paramString });
        return false;
      } 
    } catch (Exception exception) {
      Log.w("AwContentsClient", "Bad URI %s", new Object[] { paramString, exception });
      return false;
    } 
  }
  
  public abstract void doUpdateVisitedHistory(String paramString, boolean paramBoolean);
  
  public abstract Bitmap getDefaultVideoPoster();
  
  public abstract void getVisitedHistory(Callback paramCallback);
  
  public abstract void handleJsAlert(String paramString1, String paramString2, JsResultReceiver paramJsResultReceiver);
  
  public abstract void handleJsBeforeUnload(String paramString1, String paramString2, JsResultReceiver paramJsResultReceiver);
  
  public abstract void handleJsConfirm(String paramString1, String paramString2, JsResultReceiver paramJsResultReceiver);
  
  public abstract void handleJsPrompt(String paramString1, String paramString2, String paramString3, JsPromptResultReceiver paramJsPromptResultReceiver);
  
  public abstract boolean hasWebViewClient();
  
  final boolean isCachedRendererBackgroundColorValid() {
    return (this.mCachedRendererBackgroundColor != 0);
  }
  
  public abstract void onCloseWindow();
  
  public abstract boolean onConsoleMessage(AwConsoleMessage paramAwConsoleMessage);
  
  public abstract boolean onCreateWindow(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
  
  public abstract void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void onFormResubmission(Message paramMessage1, Message paramMessage2);
  
  public abstract void onGeolocationPermissionsHidePrompt();
  
  public abstract void onGeolocationPermissionsShowPrompt(String paramString, AwGeolocationPermissions$Callback paramAwGeolocationPermissions$Callback);
  
  public abstract void onHideCustomView();
  
  public abstract void onLoadResource(String paramString);
  
  public abstract void onNewPicture(Picture paramPicture);
  
  public abstract void onPageCommitVisible(String paramString);
  
  public abstract void onPageFinished(String paramString);
  
  public abstract void onPageStarted(String paramString);
  
  public abstract void onPermissionRequest(AwPermissionRequest paramAwPermissionRequest);
  
  public abstract void onPermissionRequestCanceled(AwPermissionRequest paramAwPermissionRequest);
  
  public abstract void onProgressChanged(int paramInt);
  
  public abstract void onReceivedClientCertRequest(AwContentsClientBridge$ClientCertificateRequestCallback paramAwContentsClientBridge$ClientCertificateRequestCallback, String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, String paramString, int paramInt);
  
  public abstract void onReceivedError(int paramInt, String paramString1, String paramString2);
  
  public abstract void onReceivedError2(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest, AwContentsClient$AwWebResourceError paramAwContentsClient$AwWebResourceError);
  
  public abstract void onReceivedHttpAuthRequest(AwHttpAuthHandler paramAwHttpAuthHandler, String paramString1, String paramString2);
  
  public abstract void onReceivedHttpError(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest, AwWebResourceResponse paramAwWebResourceResponse);
  
  public abstract void onReceivedIcon(Bitmap paramBitmap);
  
  public abstract void onReceivedLoginRequest(String paramString1, String paramString2, String paramString3);
  
  public abstract void onReceivedSslError(Callback paramCallback, SslError paramSslError);
  
  public abstract void onReceivedTitle(String paramString);
  
  public abstract void onReceivedTouchIconUrl(String paramString, boolean paramBoolean);
  
  public abstract boolean onRenderProcessGone(AwRenderProcessGoneDetail paramAwRenderProcessGoneDetail);
  
  public abstract void onRequestFocus();
  
  public abstract void onSafeBrowsingHit(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest, int paramInt, Callback paramCallback);
  
  public abstract void onScaleChangedScaled(float paramFloat1, float paramFloat2);
  
  public abstract void onShowCustomView(View paramView, AwContentsClient$CustomViewCallback paramAwContentsClient$CustomViewCallback);
  
  public abstract void onThemeColorChanged(int paramInt);
  
  public abstract void onUnhandledKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract AwWebResourceResponse shouldInterceptRequest(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest);
  
  public abstract boolean shouldOverrideKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean shouldOverrideUrlLoading(AwContentsClient$AwWebResourceRequest paramAwContentsClient$AwWebResourceRequest);
  
  public abstract void showFileChooser(Callback paramCallback, AwContentsClient$FileChooserParamsImpl paramAwContentsClient$FileChooserParamsImpl);
  
  public final void updateTitle(String paramString, boolean paramBoolean) {
    if (!paramBoolean && TextUtils.equals(this.mTitle, paramString))
      return; 
    this.mTitle = paramString;
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mCallbackHelper;
    String str = this.mTitle;
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(10, str));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */