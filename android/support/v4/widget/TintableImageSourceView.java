package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface TintableImageSourceView {
  ColorStateList getSupportImageTintList();
  
  PorterDuff.Mode getSupportImageTintMode();
  
  void setSupportImageTintList(ColorStateList paramColorStateList);
  
  void setSupportImageTintMode(PorterDuff.Mode paramMode);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\TintableImageSourceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */