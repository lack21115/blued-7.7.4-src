package org.chromium.content.browser;

import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;

public final class WindowEventObserverManager implements DisplayAndroid.DisplayAndroidObserver {
  boolean mAttachedToWindow;
  
  private float mDipScale;
  
  private int mRotation;
  
  private ViewEventSinkImpl mViewEventSink;
  
  private WindowAndroid mWindowAndroid;
  
  final ObserverList mWindowEventObservers = new ObserverList();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private WindowEventObserverManager(WebContents paramWebContents) {
    this.mViewEventSink = ViewEventSinkImpl.from(paramWebContents);
    assert false;
    throw new AssertionError();
  }
  
  public static WindowEventObserverManager from(WebContents paramWebContents) {
    return (WindowEventObserverManager)paramWebContents.getOrSetUserData(WindowEventObserverManager.class, WindowEventObserverManager$UserDataFactoryLazyHolder.access$100());
  }
  
  public final void addObserver(WindowEventObserver paramWindowEventObserver) {
    assert false;
    throw new AssertionError();
  }
  
  final void addUiObservers() {
    if (this.mAttachedToWindow && this.mWindowAndroid != null) {
      DisplayAndroid displayAndroid = this.mWindowAndroid.mDisplayAndroid;
      displayAndroid.addObserver(this);
      onRotationChanged(displayAndroid.mRotation);
      onDIPScaleChanged(displayAndroid.mDipScale);
    } 
    if (this.mAttachedToWindow) {
      if (this.mWindowAndroid == null)
        return; 
      WindowAndroid windowAndroid = this.mWindowAndroid;
      ViewEventSinkImpl viewEventSinkImpl = this.mViewEventSink;
      if (WindowAndroid.$assertionsDisabled || !windowAndroid.mActivityStateObservers.hasObserver(viewEventSinkImpl)) {
        windowAndroid.mActivityStateObservers.addObserver(viewEventSinkImpl);
        if (this.mWindowAndroid.getActivityState() == 3)
          this.mViewEventSink.onActivityResumed(); 
        return;
      } 
      throw new AssertionError();
    } 
  }
  
  public final void onDIPScaleChanged(float paramFloat) {
    if (this.mDipScale == paramFloat)
      return; 
    this.mDipScale = paramFloat;
    Iterator<WindowEventObserver> iterator = this.mWindowEventObservers.iterator();
    while (iterator.hasNext())
      ((WindowEventObserver)iterator.next()).onDIPScaleChanged(paramFloat); 
  }
  
  public final void onRotationChanged(int paramInt) {
    if (this.mRotation == paramInt)
      return; 
    this.mRotation = paramInt;
    Iterator<WindowEventObserver> iterator = this.mWindowEventObservers.iterator();
    while (iterator.hasNext())
      ((WindowEventObserver)iterator.next()).onRotationChanged(paramInt); 
  }
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {
    if (paramWindowAndroid == this.mWindowAndroid)
      return; 
    removeUiObservers();
    this.mWindowAndroid = paramWindowAndroid;
    addUiObservers();
    Iterator<WindowEventObserver> iterator = this.mWindowEventObservers.iterator();
    while (iterator.hasNext())
      ((WindowEventObserver)iterator.next()).onWindowAndroidChanged(paramWindowAndroid); 
  }
  
  final void removeUiObservers() {
    if (this.mWindowAndroid != null)
      this.mWindowAndroid.mDisplayAndroid.removeObserver(this); 
    if (this.mAttachedToWindow) {
      if (this.mWindowAndroid == null)
        return; 
      WindowAndroid windowAndroid = this.mWindowAndroid;
      ViewEventSinkImpl viewEventSinkImpl = this.mViewEventSink;
      if (WindowAndroid.$assertionsDisabled || windowAndroid.mActivityStateObservers.hasObserver(viewEventSinkImpl)) {
        windowAndroid.mActivityStateObservers.removeObserver(viewEventSinkImpl);
        return;
      } 
      throw new AssertionError();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\WindowEventObserverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */