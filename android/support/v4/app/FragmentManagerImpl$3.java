package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

final class FragmentManagerImpl$3 extends AnimatorListenerAdapter {
  public final void onAnimationEnd(Animator paramAnimator) {
    container.endViewTransition(viewToAnimate);
    paramAnimator = fragment.getAnimator();
    fragment.setAnimator(null);
    if (paramAnimator != null && container.indexOfChild(viewToAnimate) < 0)
      FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */