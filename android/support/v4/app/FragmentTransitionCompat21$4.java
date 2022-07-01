package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;

final class FragmentTransitionCompat21$4 extends Transition.EpicenterCallback {
  public final Rect onGetEpicenter(Transition paramTransition) {
    return (epicenter == null || epicenter.isEmpty()) ? null : epicenter;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransitionCompat21$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */