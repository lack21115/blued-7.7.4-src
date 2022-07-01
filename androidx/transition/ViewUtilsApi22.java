package androidx.transition;

import android.view.View;

class ViewUtilsApi22 extends ViewUtilsApi21 {
  private static boolean a = true;
  
  public void setLeftTopRightBottom(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (a)
      try {
        paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewUtilsApi22.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */