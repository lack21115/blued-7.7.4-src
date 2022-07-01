package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface TintableBackgroundView {
  ColorStateList getSupportBackgroundTintList();
  
  PorterDuff.Mode getSupportBackgroundTintMode();
  
  void setSupportBackgroundTintList(ColorStateList paramColorStateList);
  
  void setSupportBackgroundTintMode(PorterDuff.Mode paramMode);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\TintableBackgroundView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */