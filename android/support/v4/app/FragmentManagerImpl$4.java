package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

final class FragmentManagerImpl$4 extends AnimatorListenerAdapter {
  public final void onAnimationEnd(Animator paramAnimator) {
    container.endViewTransition(animatingView);
    paramAnimator.removeListener((Animator.AnimatorListener)this);
    if (fragment.mView != null)
      fragment.mView.setVisibility(8); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */