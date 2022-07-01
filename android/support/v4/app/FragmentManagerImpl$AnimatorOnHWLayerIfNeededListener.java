package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class FragmentManagerImpl$AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {
  private View mView;
  
  FragmentManagerImpl$AnimatorOnHWLayerIfNeededListener(View paramView) {
    this.mView = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator) {
    this.mView.setLayerType(0, null);
    paramAnimator.removeListener((Animator.AnimatorListener)this);
  }
  
  public final void onAnimationStart(Animator paramAnimator) {
    this.mView.setLayerType(2, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$AnimatorOnHWLayerIfNeededListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */