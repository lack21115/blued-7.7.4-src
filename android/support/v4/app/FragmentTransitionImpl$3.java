package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

final class FragmentTransitionImpl$3 implements Runnable {
  public final void run() {
    int j = sharedElementsIn.size();
    for (int i = 0; i < j; i++) {
      View view = sharedElementsIn.get(i);
      String str = ViewCompat.getTransitionName(view);
      ViewCompat.setTransitionName(view, (String)nameOverrides.get(str));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransitionImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */