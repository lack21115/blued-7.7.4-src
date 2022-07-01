package org.chromium.content.browser;

import android.content.Context;
import android.content.res.Configuration;
import org.chromium.content_public.browser.WebContents;
import org.chromium.device.gamepad.GamepadList;
import org.chromium.ui.base.WindowAndroid;

public final class Gamepad implements WindowEventObserver {
  private Context mContext;
  
  public Gamepad(Context paramContext, WebContents paramWebContents) {
    this.mContext = paramContext;
    WindowEventObserverManager.from(paramWebContents).addObserver(this);
  }
  
  public final void onAttachedToWindow() {
    GamepadList.onAttachedToWindow(this.mContext);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public final void onDetachedFromWindow() {
    GamepadList.onDetachedFromWindow();
  }
  
  public final void onRotationChanged(int paramInt) {}
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {}
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\Gamepad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */