package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

public final class OneShotPreDrawListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
  private final View a;
  
  private ViewTreeObserver b;
  
  private final Runnable c;
  
  private OneShotPreDrawListener(View paramView, Runnable paramRunnable) {
    this.a = paramView;
    this.b = paramView.getViewTreeObserver();
    this.c = paramRunnable;
  }
  
  public static OneShotPreDrawListener add(View paramView, Runnable paramRunnable) {
    if (paramView != null) {
      if (paramRunnable != null) {
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(paramView, paramRunnable);
        paramView.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        paramView.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
      } 
      throw new NullPointerException("runnable == null");
    } 
    throw new NullPointerException("view == null");
  }
  
  public boolean onPreDraw() {
    removeListener();
    this.c.run();
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {
    this.b = paramView.getViewTreeObserver();
  }
  
  public void onViewDetachedFromWindow(View paramView) {
    removeListener();
  }
  
  public void removeListener() {
    if (this.b.isAlive()) {
      this.b.removeOnPreDrawListener(this);
    } else {
      this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    } 
    this.a.removeOnAttachStateChangeListener(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\OneShotPreDrawListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */