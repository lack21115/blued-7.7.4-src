package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface TintableCompoundButton {
  ColorStateList getSupportButtonTintList();
  
  PorterDuff.Mode getSupportButtonTintMode();
  
  void setSupportButtonTintList(ColorStateList paramColorStateList);
  
  void setSupportButtonTintMode(PorterDuff.Mode paramMode);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\TintableCompoundButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */