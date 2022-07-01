package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.util.ArrayMap;
import android.view.View;
import java.util.ArrayList;

final class FragmentTransition$4 implements Runnable {
  public final void run() {
    ArrayMap arrayMap = FragmentTransition.access$300(impl, nameOverrides, finalSharedElementTransition, fragments);
    if (arrayMap != null) {
      sharedElementsIn.addAll(arrayMap.values());
      sharedElementsIn.add(nonExistentView);
    } 
    FragmentTransition.access$200$5a6982c5(inFragment, outFragment, inIsPop, arrayMap);
    if (finalSharedElementTransition != null) {
      impl.swapSharedElementTargets(finalSharedElementTransition, sharedElementsOut, sharedElementsIn);
      View view = FragmentTransition.access$400(arrayMap, fragments, enterTransition, inIsPop);
      if (view != null)
        FragmentTransitionImpl.getBoundsOnScreen(view, inEpicenter); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransition$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */