package android.support.v7.widget;

import android.animation.Animator;

final class ActionBarOverlayLayout$2 implements Runnable {
  public final void run() {
    ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
    ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ActionBarOverlayLayout.this.mActionBarTop.animate().translationY(0.0F).setListener((Animator.AnimatorListener)ActionBarOverlayLayout.this.mTopAnimatorListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionBarOverlayLayout$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */