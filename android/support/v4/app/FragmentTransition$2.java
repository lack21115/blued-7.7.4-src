package android.support.v4.app;

import android.view.View;
import java.util.ArrayList;

final class FragmentTransition$2 implements Runnable {
  public final void run() {
    if (enterTransition != null) {
      impl.removeTarget(enterTransition, nonExistentView);
      ArrayList arrayList = FragmentTransition.access$100(impl, enterTransition, inFragment, sharedElementsIn, nonExistentView);
      enteringViews.addAll(arrayList);
    } 
    if (exitingViews != null) {
      if (exitTransition != null) {
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(nonExistentView);
        impl.replaceTargets(exitTransition, exitingViews, arrayList);
      } 
      exitingViews.clear();
      exitingViews.add(nonExistentView);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransition$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */