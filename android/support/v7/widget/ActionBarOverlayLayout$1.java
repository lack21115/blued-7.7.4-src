package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class ActionBarOverlayLayout$1 extends AnimatorListenerAdapter {
  public final void onAnimationCancel(Animator paramAnimator) {
    ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
    ActionBarOverlayLayout.this.mAnimatingForFling = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator) {
    ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
    ActionBarOverlayLayout.this.mAnimatingForFling = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionBarOverlayLayout$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */