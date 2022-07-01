package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

class GhostViewUtils {
  static GhostView a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix) {
    return (Build.VERSION.SDK_INT == 28) ? GhostViewPlatform.a(paramView, paramViewGroup, paramMatrix) : GhostViewPort.b(paramView, paramViewGroup, paramMatrix);
  }
  
  static void a(View paramView) {
    if (Build.VERSION.SDK_INT == 28) {
      GhostViewPlatform.a(paramView);
      return;
    } 
    GhostViewPort.b(paramView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\GhostViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */