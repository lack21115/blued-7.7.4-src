package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.view.View;

class ViewCompat$ViewCompatApi16Impl extends ViewCompat$ViewCompatApi15Impl {
  public final int getMinimumHeight(View paramView) {
    return paramView.getMinimumHeight();
  }
  
  public final boolean hasOverlappingRendering(View paramView) {
    return paramView.hasOverlappingRendering();
  }
  
  public final void postInvalidateOnAnimation(View paramView) {
    paramView.postInvalidateOnAnimation();
  }
  
  public final void postOnAnimation(View paramView, Runnable paramRunnable) {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public final void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong) {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public void requestApplyInsets(View paramView) {
    paramView.requestFitSystemWindows();
  }
  
  public final void setBackground(View paramView, Drawable paramDrawable) {
    paramView.setBackground(paramDrawable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewCompat$ViewCompatApi16Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */