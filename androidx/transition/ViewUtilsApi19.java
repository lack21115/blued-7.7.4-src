package androidx.transition;

import android.view.View;

class ViewUtilsApi19 extends ViewUtilsBase {
  private static boolean a = true;
  
  public void clearNonTransitionAlpha(View paramView) {}
  
  public float getTransitionAlpha(View paramView) {
    if (a)
      try {
        return paramView.getTransitionAlpha();
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
    return paramView.getAlpha();
  }
  
  public void saveNonTransitionAlpha(View paramView) {}
  
  public void setTransitionAlpha(View paramView, float paramFloat) {
    if (a)
      try {
        paramView.setTransitionAlpha(paramFloat);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
    paramView.setAlpha(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewUtilsApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */