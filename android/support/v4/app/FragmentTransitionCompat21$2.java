package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

final class FragmentTransitionCompat21$2 implements Transition.TransitionListener {
  public final void onTransitionCancel(Transition paramTransition) {}
  
  public final void onTransitionEnd(Transition paramTransition) {
    paramTransition.removeListener(this);
    fragmentView.setVisibility(8);
    int j = exitingViews.size();
    for (int i = 0; i < j; i++)
      ((View)exitingViews.get(i)).setVisibility(0); 
  }
  
  public final void onTransitionPause(Transition paramTransition) {}
  
  public final void onTransitionResume(Transition paramTransition) {}
  
  public final void onTransitionStart(Transition paramTransition) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransitionCompat21$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */