package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface TintableCompoundDrawablesView {
  ColorStateList getSupportCompoundDrawablesTintList();
  
  PorterDuff.Mode getSupportCompoundDrawablesTintMode();
  
  void setSupportCompoundDrawablesTintList(ColorStateList paramColorStateList);
  
  void setSupportCompoundDrawablesTintMode(PorterDuff.Mode paramMode);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\TintableCompoundDrawablesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */