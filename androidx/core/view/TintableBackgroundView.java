package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface TintableBackgroundView {
  ColorStateList getSupportBackgroundTintList();
  
  PorterDuff.Mode getSupportBackgroundTintMode();
  
  void setSupportBackgroundTintList(ColorStateList paramColorStateList);
  
  void setSupportBackgroundTintMode(PorterDuff.Mode paramMode);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\TintableBackgroundView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */