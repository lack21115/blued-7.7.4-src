package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class ViewUtilsApi21 extends ViewUtilsApi19 {
  private static boolean a = true;
  
  private static boolean b = true;
  
  private static boolean c = true;
  
  public void setAnimationMatrix(View paramView, Matrix paramMatrix) {
    if (a)
      try {
        paramView.setAnimationMatrix(paramMatrix);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
  }
  
  public void transformMatrixToGlobal(View paramView, Matrix paramMatrix) {
    if (b)
      try {
        paramView.transformMatrixToGlobal(paramMatrix);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        b = false;
      }  
  }
  
  public void transformMatrixToLocal(View paramView, Matrix paramMatrix) {
    if (c)
      try {
        paramView.transformMatrixToLocal(paramMatrix);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        c = false;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewUtilsApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */