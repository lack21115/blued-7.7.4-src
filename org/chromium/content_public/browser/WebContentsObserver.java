package org.chromium.content_public.browser;

import java.lang.ref.WeakReference;

public abstract class WebContentsObserver {
  private WeakReference mWebContents;
  
  public WebContentsObserver() {}
  
  public WebContentsObserver(WebContents paramWebContents) {
    this.mWebContents = new WeakReference<WebContents>(paramWebContents);
    paramWebContents.addObserver(this);
  }
  
  public void destroy() {
    if (this.mWebContents == null)
      return; 
    WebContents webContents = this.mWebContents.get();
    this.mWebContents = null;
    if (webContents == null)
      return; 
    webContents.removeObserver(this);
  }
  
  public void didAttachInterstitialPage() {}
  
  public void didChangeThemeColor(int paramInt) {}
  
  public void didDetachInterstitialPage() {}
  
  public void didFailLoad(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  public void didFinishLoad(long paramLong, String paramString, boolean paramBoolean) {}
  
  public void didFinishNavigation$664b0948(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Integer paramInteger, int paramInt, String paramString2) {}
  
  public void didFirstVisuallyNonEmptyPaint() {}
  
  public void didStartLoading(String paramString) {}
  
  public void didStartNavigation(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void didStopLoading(String paramString) {}
  
  public void documentAvailableInMainFrame() {}
  
  public void documentLoadedInFrame(long paramLong, boolean paramBoolean) {}
  
  public void hasEffectivelyFullscreenVideoChange(boolean paramBoolean) {}
  
  public void navigationEntriesDeleted() {}
  
  public void navigationEntryCommitted() {}
  
  public void renderProcessGone(boolean paramBoolean) {}
  
  public void renderViewReady() {}
  
  public void titleWasSet(String paramString) {}
  
  public void viewportFitChanged(int paramInt) {}
  
  public void wasHidden() {}
  
  public void wasShown() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\WebContentsObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */