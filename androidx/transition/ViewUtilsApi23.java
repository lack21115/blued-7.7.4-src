package androidx.transition;

import android.os.Build;
import android.view.View;

class ViewUtilsApi23 extends ViewUtilsApi22 {
  private static boolean a = true;
  
  public void setTransitionVisibility(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT == 28) {
      super.setTransitionVisibility(paramView, paramInt);
      return;
    } 
    if (a)
      try {
        paramView.setTransitionVisibility(paramInt);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewUtilsApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */