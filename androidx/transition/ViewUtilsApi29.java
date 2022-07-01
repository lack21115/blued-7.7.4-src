package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class ViewUtilsApi29 extends ViewUtilsApi23 {
  public float getTransitionAlpha(View paramView) {
    return paramView.getTransitionAlpha();
  }
  
  public void setAnimationMatrix(View paramView, Matrix paramMatrix) {
    paramView.setAnimationMatrix(paramMatrix);
  }
  
  public void setLeftTopRightBottom(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setTransitionAlpha(View paramView, float paramFloat) {
    paramView.setTransitionAlpha(paramFloat);
  }
  
  public void setTransitionVisibility(View paramView, int paramInt) {
    paramView.setTransitionVisibility(paramInt);
  }
  
  public void transformMatrixToGlobal(View paramView, Matrix paramMatrix) {
    paramView.transformMatrixToGlobal(paramMatrix);
  }
  
  public void transformMatrixToLocal(View paramView, Matrix paramMatrix) {
    paramView.transformMatrixToLocal(paramMatrix);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewUtilsApi29.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */