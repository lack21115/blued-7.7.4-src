package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.util.ArrayMap;
import android.view.View;

final class FragmentTransition$3 implements Runnable {
  public final void run() {
    FragmentTransition.access$200$5a6982c5(inFragment, outFragment, inIsPop, inSharedElements);
    if (epicenterView != null)
      FragmentTransitionImpl.getBoundsOnScreen(epicenterView, epicenter); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransition$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */