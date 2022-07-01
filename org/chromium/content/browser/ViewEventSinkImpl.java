package org.chromium.content.browser;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Iterator;
import org.chromium.base.TraceEvent;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;

public final class ViewEventSinkImpl implements ViewEventSink {
  private Context mContext;
  
  private Boolean mHasInputFocus;
  
  private Boolean mHasViewFocus;
  
  private boolean mHideKeyboardOnBlur;
  
  private boolean mPaused;
  
  private final WebContentsImpl mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ViewEventSinkImpl(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
  }
  
  public static ViewEventSinkImpl create(Context paramContext, WebContents paramWebContents) {
    ViewEventSinkImpl viewEventSinkImpl = (ViewEventSinkImpl)paramWebContents.getOrSetUserData(ViewEventSinkImpl.class, ViewEventSinkImpl$UserDataFactoryLazyHolder.access$000());
    assert false;
    throw new AssertionError();
  }
  
  public static ViewEventSinkImpl from(WebContents paramWebContents) {
    return (ViewEventSinkImpl)paramWebContents.getOrSetUserData(ViewEventSinkImpl.class, null);
  }
  
  private void onFocusChanged() {
    if (this.mHasViewFocus == null)
      return; 
    if (this.mHasViewFocus.booleanValue() && !this.mPaused) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.mHasInputFocus != null && this.mHasInputFocus.booleanValue() == bool1)
      return; 
    this.mHasInputFocus = Boolean.valueOf(bool1);
    if (this.mWebContents == null)
      return; 
    WindowEventObserverManager windowEventObserverManager = WindowEventObserverManager.from((WebContents)this.mWebContents);
    boolean bool1 = this.mHasInputFocus.booleanValue();
    boolean bool2 = this.mHideKeyboardOnBlur;
    Iterator<WindowEventObserver> iterator = windowEventObserverManager.mWindowEventObservers.iterator();
    while (iterator.hasNext())
      ((WindowEventObserver)iterator.next()).onViewFocusChanged(bool1, bool2); 
    WebContentsImpl webContentsImpl = this.mWebContents;
    bool1 = this.mHasInputFocus.booleanValue();
    if (webContentsImpl.mNativeWebContentsAndroid != 0L)
      webContentsImpl.nativeSetFocus(webContentsImpl.mNativeWebContentsAndroid, bool1); 
  }
  
  public final void onActivityResumed() {
    if (!this.mPaused)
      return; 
    this.mPaused = false;
    onFocusChanged();
  }
  
  public final void onAttachedToWindow() {
    WindowEventObserverManager windowEventObserverManager = WindowEventObserverManager.from((WebContents)this.mWebContents);
    windowEventObserverManager.mAttachedToWindow = true;
    windowEventObserverManager.addUiObservers();
    Iterator<WindowEventObserver> iterator = windowEventObserverManager.mWindowEventObservers.iterator();
    while (iterator.hasNext())
      ((WindowEventObserver)iterator.next()).onAttachedToWindow(); 
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {
    try {
      TraceEvent.begin("ViewEventSink.onConfigurationChanged");
      Iterator<WindowEventObserver> iterator = (WindowEventObserverManager.from((WebContents)this.mWebContents)).mWindowEventObservers.iterator();
      while (iterator.hasNext())
        ((WindowEventObserver)iterator.next()).onConfigurationChanged(paramConfiguration); 
      ViewAndroidDelegate viewAndroidDelegate = this.mWebContents.getViewAndroidDelegate();
      if (viewAndroidDelegate != null)
        viewAndroidDelegate.getContainerView().requestLayout(); 
      return;
    } finally {
      TraceEvent.end("ViewEventSink.onConfigurationChanged");
    } 
  }
  
  public final void onDetachedFromWindow() {
    WindowEventObserverManager windowEventObserverManager = WindowEventObserverManager.from((WebContents)this.mWebContents);
    windowEventObserverManager.removeUiObservers();
    windowEventObserverManager.mAttachedToWindow = false;
    Iterator<WindowEventObserver> iterator = windowEventObserverManager.mWindowEventObservers.iterator();
    while (iterator.hasNext())
      ((WindowEventObserver)iterator.next()).onDetachedFromWindow(); 
  }
  
  public final void onViewFocusChanged(boolean paramBoolean) {
    if (this.mHasViewFocus != null && this.mHasViewFocus.booleanValue() == paramBoolean)
      return; 
    this.mHasViewFocus = Boolean.valueOf(paramBoolean);
    onFocusChanged();
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    Iterator<WindowEventObserver> iterator = (WindowEventObserverManager.from((WebContents)this.mWebContents)).mWindowEventObservers.iterator();
    while (iterator.hasNext())
      ((WindowEventObserver)iterator.next()).onWindowFocusChanged(paramBoolean); 
  }
  
  public final void setAccessDelegate(ViewEventSink.InternalAccessDelegate paramInternalAccessDelegate) {
    (GestureListenerManagerImpl.fromWebContents((WebContents)this.mWebContents)).mScrollDelegate = paramInternalAccessDelegate;
    (ContentUiEventHandler.fromWebContents((WebContents)this.mWebContents)).mEventDelegate = paramInternalAccessDelegate;
  }
  
  public final void setHideKeyboardOnBlur(boolean paramBoolean) {
    this.mHideKeyboardOnBlur = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ViewEventSinkImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */