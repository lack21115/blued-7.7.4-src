package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

final class OneShotPreDrawListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
  private final Runnable mRunnable;
  
  private final View mView;
  
  private ViewTreeObserver mViewTreeObserver;
  
  private OneShotPreDrawListener(View paramView, Runnable paramRunnable) {
    this.mView = paramView;
    this.mViewTreeObserver = paramView.getViewTreeObserver();
    this.mRunnable = paramRunnable;
  }
  
  public static OneShotPreDrawListener add(View paramView, Runnable paramRunnable) {
    OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
    paramView.addOnAttachStateChangeListener(oneShotPreDrawListener);
    return oneShotPreDrawListener;
  }
  
  private void removeListener() {
    if (this.mViewTreeObserver.isAlive()) {
      this.mViewTreeObserver.removeOnPreDrawListener(this);
    } else {
      this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
    } 
    this.mView.removeOnAttachStateChangeListener(this);
  }
  
  public final boolean onPreDraw() {
    removeListener();
    this.mRunnable.run();
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {
    this.mViewTreeObserver = paramView.getViewTreeObserver();
  }
  
  public final void onViewDetachedFromWindow(View paramView) {
    removeListener();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\OneShotPreDrawListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */