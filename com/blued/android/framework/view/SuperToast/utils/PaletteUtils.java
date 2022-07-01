package com.blued.android.framework.view.SuperToast.utils;

import android.graphics.Color;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PaletteUtils {
  public static int a(String paramString) {
    return Color.parseColor("#FF".concat(paramString));
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PaletteColors {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToas\\utils\PaletteUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */