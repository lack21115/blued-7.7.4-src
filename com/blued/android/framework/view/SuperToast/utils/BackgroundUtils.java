package com.blued.android.framework.view.SuperToast.utils;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.TypedValue;
import com.blued.android.framework.view.SuperToast.Style;

public class BackgroundUtils {
  public static int a(int paramInt) {
    return 0;
  }
  
  public static Drawable a(Style paramStyle, int paramInt) {
    if (paramStyle.e > 0) {
      int j = paramStyle.e;
      if (j != 1) {
        if (j != 2) {
          if (j == 3)
            return (Drawable)c(paramInt); 
        } else {
          return (Drawable)d(paramInt);
        } 
      } else {
        return (Drawable)e(paramInt);
      } 
    } 
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      paramStyle.e = 3;
      return (Drawable)c(paramInt);
    } 
    if (i >= 19) {
      paramStyle.e = 2;
      return (Drawable)d(paramInt);
    } 
    paramStyle.e = 1;
    return (Drawable)e(paramInt);
  }
  
  public static int b(int paramInt) {
    return Math.round(TypedValue.applyDimension(1, paramInt, Resources.getSystem().getDisplayMetrics()));
  }
  
  private static ColorDrawable c(int paramInt) {
    return new ColorDrawable(paramInt);
  }
  
  private static GradientDrawable d(int paramInt) {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setCornerRadius(b(24));
    gradientDrawable.setColor(paramInt);
    return gradientDrawable;
  }
  
  private static GradientDrawable e(int paramInt) {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setCornerRadius(b(4));
    gradientDrawable.setColor(paramInt);
    return gradientDrawable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToas\\utils\BackgroundUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */