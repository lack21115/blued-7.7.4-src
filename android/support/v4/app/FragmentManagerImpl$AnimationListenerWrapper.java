package android.support.v4.app;

import android.view.animation.Animation;

class FragmentManagerImpl$AnimationListenerWrapper implements Animation.AnimationListener {
  private final Animation.AnimationListener mWrapped;
  
  private FragmentManagerImpl$AnimationListenerWrapper(Animation.AnimationListener paramAnimationListener) {
    this.mWrapped = paramAnimationListener;
  }
  
  public void onAnimationEnd(Animation paramAnimation) {
    if (this.mWrapped != null)
      this.mWrapped.onAnimationEnd(paramAnimation); 
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {
    if (this.mWrapped != null)
      this.mWrapped.onAnimationRepeat(paramAnimation); 
  }
  
  public void onAnimationStart(Animation paramAnimation) {
    if (this.mWrapped != null)
      this.mWrapped.onAnimationStart(paramAnimation); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$AnimationListenerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */