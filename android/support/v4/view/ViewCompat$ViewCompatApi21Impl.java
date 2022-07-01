package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

class ViewCompat$ViewCompatApi21Impl extends ViewCompat$ViewCompatApi19Impl {
  public final ColorStateList getBackgroundTintList(View paramView) {
    return paramView.getBackgroundTintList();
  }
  
  public final PorterDuff.Mode getBackgroundTintMode(View paramView) {
    return paramView.getBackgroundTintMode();
  }
  
  public final String getTransitionName(View paramView) {
    return paramView.getTransitionName();
  }
  
  public final void requestApplyInsets(View paramView) {
    paramView.requestApplyInsets();
  }
  
  public final void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    paramView.setBackgroundTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramView.getBackground();
      if (paramView.getBackgroundTintList() != null && paramView.getBackgroundTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramView.getDrawableState()); 
        paramView.setBackground(drawable);
      } 
    } 
  }
  
  public final void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    paramView.setBackgroundTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramView.getBackground();
      if (paramView.getBackgroundTintList() != null && paramView.getBackgroundTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramView.getDrawableState()); 
        paramView.setBackground(drawable);
      } 
    } 
  }
  
  public final void setTransitionName(View paramView, String paramString) {
    paramView.setTransitionName(paramString);
  }
  
  public final void stopNestedScroll(View paramView) {
    paramView.stopNestedScroll();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewCompat$ViewCompatApi21Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */