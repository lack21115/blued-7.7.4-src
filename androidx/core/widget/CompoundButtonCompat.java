package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {
  private static Field a;
  
  private static boolean b;
  
  public static Drawable getButtonDrawable(CompoundButton paramCompoundButton) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramCompoundButton.getButtonDrawable(); 
    if (!b) {
      try {
        a = CompoundButton.class.getDeclaredField("mButtonDrawable");
        a.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", noSuchFieldException);
      } 
      b = true;
    } 
    Field field = a;
    if (field != null)
      try {
        return (Drawable)field.get(paramCompoundButton);
      } catch (IllegalAccessException illegalAccessException) {
        Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", illegalAccessException);
        a = null;
      }  
    return null;
  }
  
  public static ColorStateList getButtonTintList(CompoundButton paramCompoundButton) {
    return (Build.VERSION.SDK_INT >= 21) ? paramCompoundButton.getButtonTintList() : ((paramCompoundButton instanceof TintableCompoundButton) ? ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList() : null);
  }
  
  public static PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton) {
    return (Build.VERSION.SDK_INT >= 21) ? paramCompoundButton.getButtonTintMode() : ((paramCompoundButton instanceof TintableCompoundButton) ? ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode() : null);
  }
  
  public static void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintList(paramColorStateList);
      return;
    } 
    if (paramCompoundButton instanceof TintableCompoundButton)
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList); 
  }
  
  public static void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintMode(paramMode);
      return;
    } 
    if (paramCompoundButton instanceof TintableCompoundButton)
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\CompoundButtonCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */