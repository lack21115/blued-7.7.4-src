package android.support.v4.app;

import android.transition.Transition;
import java.util.ArrayList;

final class FragmentTransitionCompat21$3 implements Transition.TransitionListener {
  public final void onTransitionCancel(Transition paramTransition) {}
  
  public final void onTransitionEnd(Transition paramTransition) {}
  
  public final void onTransitionPause(Transition paramTransition) {}
  
  public final void onTransitionResume(Transition paramTransition) {}
  
  public final void onTransitionStart(Transition paramTransition) {
    if (enterTransition != null)
      FragmentTransitionCompat21.this.replaceTargets(enterTransition, enteringViews, null); 
    if (exitTransition != null)
      FragmentTransitionCompat21.this.replaceTargets(exitTransition, exitingViews, null); 
    if (sharedElementTransition != null)
      FragmentTransitionCompat21.this.replaceTargets(sharedElementTransition, sharedElementsIn, null); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransitionCompat21$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */