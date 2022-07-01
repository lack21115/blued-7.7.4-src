package org.chromium.android_webview;

import java.lang.ref.WeakReference;
import org.chromium.base.ThreadUtils;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsObserver;

public final class AwWebContentsObserver extends WebContentsObserver {
  final WeakReference mAwContents;
  
  final WeakReference mAwContentsClient;
  
  public boolean mCommittedNavigation;
  
  private String mLastDidFinishLoadUrl;
  
  public AwWebContentsObserver(WebContents paramWebContents, AwContents paramAwContents, AwContentsClient paramAwContentsClient) {
    super(paramWebContents);
    this.mAwContents = new WeakReference<AwContents>(paramAwContents);
    this.mAwContentsClient = new WeakReference<AwContentsClient>(paramAwContentsClient);
  }
  
  private AwContentsClient getClientIfNeedToFireCallback(String paramString) {
    AwContentsClient awContentsClient = this.mAwContentsClient.get();
    if (awContentsClient != null) {
      String str = AwContentsStatics.getUnreachableWebDataUrl();
      if (str == null || !str.equals(paramString))
        return awContentsClient; 
    } 
    return null;
  }
  
  public final void didChangeThemeColor(int paramInt) {
    AwContentsClient awContentsClient = this.mAwContentsClient.get();
    if (awContentsClient != null)
      awContentsClient.mCallbackHelper.postOnThemeColorChanged(paramInt); 
  }
  
  public final void didFailLoad(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {
    boolean bool;
    AwContentsClient awContentsClient = this.mAwContentsClient.get();
    if (awContentsClient == null)
      return; 
    String str = AwContentsStatics.getUnreachableWebDataUrl();
    if (str != null && str.equals(paramString2)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramBoolean && !bool && paramInt == -3)
      awContentsClient.mCallbackHelper.postOnPageFinished(paramString2); 
  }
  
  public final void didFinishLoad(long paramLong, String paramString, boolean paramBoolean) {
    if (paramBoolean && getClientIfNeedToFireCallback(paramString) != null)
      this.mLastDidFinishLoadUrl = paramString; 
  }
  
  public final void didFinishNavigation$664b0948(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Integer paramInteger, int paramInt, String paramString2) {
    if (paramInt != 0)
      didFailLoad(paramBoolean1, paramInt, paramString2, paramString1); 
    if (!paramBoolean2)
      return; 
    boolean bool = true;
    this.mCommittedNavigation = true;
    if (!paramBoolean1)
      return; 
    AwContentsClient awContentsClient = this.mAwContentsClient.get();
    if (paramBoolean2 && awContentsClient != null) {
      if (paramInteger != null && (paramInteger.intValue() & 0xFF) == 8) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      } 
      AwContentsClientCallbackHelper awContentsClientCallbackHelper = awContentsClient.mCallbackHelper;
      AwContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo awContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo = new AwContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo(paramString1, paramBoolean1);
      awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(13, awContentsClientCallbackHelper$DoUpdateVisitedHistoryInfo));
    } 
    if (!paramBoolean3)
      ThreadUtils.postOnUiThread(new AwWebContentsObserver$$Lambda$0(this, paramString1)); 
    if (awContentsClient != null) {
      AwContents awContents = this.mAwContents.get();
      if (awContents != null) {
        WebContents webContents = awContents.mWebContents;
      } else {
        awContents = null;
      } 
      if (awContents != null)
        awContentsClient.mCallbackHelper.postOnThemeColorChanged(awContents.getThemeColor()); 
    } 
    if (awContentsClient != null && paramBoolean4)
      awContentsClient.mCallbackHelper.postOnPageFinished(paramString1); 
  }
  
  public final void didStopLoading(String paramString) {
    String str = paramString;
    if (paramString.length() == 0)
      str = "about:blank"; 
    AwContentsClient awContentsClient = getClientIfNeedToFireCallback(str);
    if (awContentsClient != null && str.equals(this.mLastDidFinishLoadUrl)) {
      awContentsClient.mCallbackHelper.postOnPageFinished(str);
      this.mLastDidFinishLoadUrl = null;
    } 
  }
  
  public final void titleWasSet(String paramString) {
    AwContentsClient awContentsClient = this.mAwContentsClient.get();
    if (awContentsClient == null)
      return; 
    awContentsClient.updateTitle(paramString, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwWebContentsObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */