package android.support.v4.app;

import android.animation.Animator;
import android.view.animation.Animation;

final class FragmentManagerImpl$AnimationOrAnimator {
  public final Animation animation = null;
  
  public final Animator animator;
  
  private FragmentManagerImpl$AnimationOrAnimator(Animator paramAnimator) {
    this.animator = paramAnimator;
    if (paramAnimator != null)
      return; 
    throw new IllegalStateException("Animator cannot be null");
  }
  
  private FragmentManagerImpl$AnimationOrAnimator(Animation paramAnimation) {
    this.animator = null;
    if (paramAnimation != null)
      return; 
    throw new IllegalStateException("Animation cannot be null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$AnimationOrAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */