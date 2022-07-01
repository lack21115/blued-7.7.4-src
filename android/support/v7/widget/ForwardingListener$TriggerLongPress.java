package android.support.v7.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

final class ForwardingListener$TriggerLongPress implements Runnable {
  public final void run() {
    ForwardingListener forwardingListener = ForwardingListener.this;
    forwardingListener.clearCallbacks();
    View view = forwardingListener.mSrc;
    if (view.isEnabled()) {
      if (view.isLongClickable())
        return; 
      if (forwardingListener.onForwardingStarted()) {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        view.onTouchEvent(motionEvent);
        motionEvent.recycle();
        forwardingListener.mForwarding = true;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ForwardingListener$TriggerLongPress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */