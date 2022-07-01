package org.chromium.content.browser;

import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content.browser.webcontents.WebContentsUserData;
import org.chromium.content_public.browser.ImeEventObserver;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.EventForwarder;

public class JoystickHandler implements ImeEventObserver {
  final EventForwarder mEventForwarder;
  
  boolean mScrollEnabled = true;
  
  private JoystickHandler(WebContents paramWebContents) {
    this.mEventForwarder = paramWebContents.getEventForwarder();
    ImeAdapterImpl.fromWebContents(paramWebContents).addEventObserver(this);
  }
  
  public static JoystickHandler fromWebContents(WebContents paramWebContents) {
    return (JoystickHandler)WebContentsUserData.fromWebContents(paramWebContents, JoystickHandler.class, JoystickHandler$UserDataFactoryLazyHolder.access$100());
  }
  
  static float getVelocityFromJoystickAxis(MotionEvent paramMotionEvent, int paramInt) {
    float f = paramMotionEvent.getAxisValue(paramInt);
    return (Math.abs(f) <= 0.2F) ? 0.0F : -f;
  }
  
  public final void onBeforeSendKeyEvent(KeyEvent paramKeyEvent) {}
  
  public final void onImeEvent() {}
  
  public final void onNodeAttributeUpdated(boolean paramBoolean1, boolean paramBoolean2) {
    this.mScrollEnabled = paramBoolean1 ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\JoystickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */