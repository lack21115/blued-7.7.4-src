package android.support.v7.widget;

import android.animation.Animator;

final class ActionBarOverlayLayout$3 implements Runnable {
  public final void run() {
    ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
    ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ActionBarOverlayLayout.this.mActionBarTop.animate().translationY(-ActionBarOverlayLayout.this.mActionBarTop.getHeight()).setListener((Animator.AnimatorListener)ActionBarOverlayLayout.this.mTopAnimatorListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionBarOverlayLayout$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */