package org.chromium.content.browser.webcontents;

import org.chromium.base.ObserverList;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.WebContentsObserver;

class WebContentsObserverProxy extends WebContentsObserver {
  long mNativeWebContentsObserverProxy;
  
  final ObserverList mObservers;
  
  private final ObserverList.RewindableIterator mObserversIterator;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public WebContentsObserverProxy(WebContentsImpl paramWebContentsImpl) {
    ThreadUtils.assertOnUiThread();
    this.mNativeWebContentsObserverProxy = nativeInit(paramWebContentsImpl);
    this.mObservers = new ObserverList();
    this.mObserversIterator = this.mObservers.rewindableIterator();
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native long nativeInit(WebContentsImpl paramWebContentsImpl);
  
  @CalledByNative
  public void destroy() {
    ThreadUtils.assertOnUiThread();
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).destroy(); 
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  public void didAttachInterstitialPage() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didAttachInterstitialPage(); 
  }
  
  @CalledByNative
  public void didChangeThemeColor(int paramInt) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didChangeThemeColor(paramInt); 
  }
  
  @CalledByNative
  public void didDetachInterstitialPage() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didDetachInterstitialPage(); 
  }
  
  @CalledByNative
  public void didFailLoad(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didFailLoad(paramBoolean, paramInt, paramString1, paramString2); 
  }
  
  @CalledByNative
  public void didFinishLoad(long paramLong, String paramString, boolean paramBoolean) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didFinishLoad(paramLong, paramString, paramBoolean); 
  }
  
  @CalledByNative
  public void didFinishNavigation(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, String paramString2, int paramInt3) {
    Integer integer;
    if (paramInt1 == -1) {
      integer = null;
    } else {
      integer = Integer.valueOf(paramInt1);
    } 
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didFinishNavigation$664b0948(paramString1, paramBoolean1, paramBoolean3, paramBoolean4, paramBoolean5, integer, paramInt2, paramString2); 
  }
  
  @CalledByNative
  public void didFirstVisuallyNonEmptyPaint() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didFirstVisuallyNonEmptyPaint(); 
  }
  
  @CalledByNative
  public void didStartLoading(String paramString) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didStartLoading(paramString); 
  }
  
  @CalledByNative
  public void didStartNavigation(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didStartNavigation(paramString, paramBoolean1, paramBoolean2, paramBoolean3); 
  }
  
  @CalledByNative
  public void didStopLoading(String paramString) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).didStopLoading(paramString); 
  }
  
  @CalledByNative
  public void documentAvailableInMainFrame() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).documentAvailableInMainFrame(); 
  }
  
  @CalledByNative
  public void documentLoadedInFrame(long paramLong, boolean paramBoolean) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).documentLoadedInFrame(paramLong, paramBoolean); 
  }
  
  @CalledByNative
  public void hasEffectivelyFullscreenVideoChange(boolean paramBoolean) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).hasEffectivelyFullscreenVideoChange(paramBoolean); 
  }
  
  @CalledByNative
  public void navigationEntriesDeleted() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).navigationEntriesDeleted(); 
  }
  
  @CalledByNative
  public void navigationEntryCommitted() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).navigationEntryCommitted(); 
  }
  
  @CalledByNative
  public void renderProcessGone(boolean paramBoolean) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).renderProcessGone(paramBoolean); 
  }
  
  @CalledByNative
  public void renderViewReady() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).renderViewReady(); 
  }
  
  @CalledByNative
  public void titleWasSet(String paramString) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).titleWasSet(paramString); 
  }
  
  @CalledByNative
  public void viewportFitChanged(int paramInt) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).viewportFitChanged(paramInt); 
  }
  
  @CalledByNative
  public void wasHidden() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).wasHidden(); 
  }
  
  @CalledByNative
  public void wasShown() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      ((WebContentsObserver)this.mObserversIterator.next()).wasShown(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\webcontents\WebContentsObserverProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */