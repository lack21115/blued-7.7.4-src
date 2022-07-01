package org.chromium.content.browser;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.SparseArray;
import org.chromium.base.Callback;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsObserver;
import org.chromium.ui.base.WindowAndroid;

class NfcHost extends WebContentsObserver implements WindowEventObserver {
  private static final SparseArray sContextHostsMap;
  
  Callback mCallback;
  
  private final int mContextId;
  
  final WebContents mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private NfcHost(WebContents paramWebContents, int paramInt) {
    super(paramWebContents);
    this.mWebContents = paramWebContents;
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private static NfcHost create(WebContents paramWebContents, int paramInt) {
    return new NfcHost(paramWebContents, paramInt);
  }
  
  public static NfcHost fromContextId(int paramInt) {
    return (NfcHost)sContextHostsMap.get(paramInt);
  }
  
  public void destroy() {
    stopTrackingActivityChanges();
    sContextHostsMap.remove(this.mContextId);
    super.destroy();
  }
  
  public final void onAttachedToWindow() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public final void onDetachedFromWindow() {}
  
  public final void onRotationChanged(int paramInt) {}
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {
    if (paramWindowAndroid != null) {
      Activity activity = paramWindowAndroid.getActivity().get();
    } else {
      paramWindowAndroid = null;
    } 
    assert false;
    throw new AssertionError("should have callback");
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
  
  public final void stopTrackingActivityChanges() {
    this.mCallback = null;
    WindowEventObserverManager windowEventObserverManager = WindowEventObserverManager.from(this.mWebContents);
    if (WindowEventObserverManager.$assertionsDisabled || windowEventObserverManager.mWindowEventObservers.hasObserver(this)) {
      windowEventObserverManager.mWindowEventObservers.removeObserver(this);
      return;
    } 
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\NfcHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */