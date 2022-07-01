package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import java.util.ArrayList;

final class FragmentTransitionImpl$1 implements Runnable {
  public final void run() {
    for (int i = 0; i < numSharedElements; i++) {
      ViewCompat.setTransitionName(sharedElementsIn.get(i), inNames.get(i));
      ViewCompat.setTransitionName(sharedElementsOut.get(i), outNames.get(i));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransitionImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */