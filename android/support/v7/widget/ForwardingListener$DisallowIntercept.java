package android.support.v7.widget;

import android.view.ViewParent;

final class ForwardingListener$DisallowIntercept implements Runnable {
  public final void run() {
    ViewParent viewParent = ForwardingListener.this.mSrc.getParent();
    if (viewParent != null)
      viewParent.requestDisallowInterceptTouchEvent(true); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ForwardingListener$DisallowIntercept.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */