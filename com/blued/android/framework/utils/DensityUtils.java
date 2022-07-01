package com.blued.android.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;

public class DensityUtils {
  public static int a(Activity paramActivity) {
    Rect rect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
    int i = rect.top;
    if (i == 0)
      try {
        Class<?> clazz = Class.forName("com.android.internal.R$dimen");
        Object object = clazz.newInstance();
        null = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
        return paramActivity.getResources().getDimensionPixelSize(null);
      } catch (ClassNotFoundException classNotFoundException) {
        classNotFoundException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
        return i;
      } catch (InstantiationException instantiationException) {
        instantiationException.printStackTrace();
        return i;
      } catch (NumberFormatException numberFormatException) {
        numberFormatException.printStackTrace();
        return i;
      } catch (IllegalArgumentException illegalArgumentException) {
        illegalArgumentException.printStackTrace();
        return i;
      } catch (SecurityException securityException) {
        securityException.printStackTrace();
        return i;
      } catch (NoSuchFieldException noSuchFieldException) {
        noSuchFieldException.printStackTrace();
        return i;
      }  
    return i;
  }
  
  public static int a(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  public static int b(Context paramContext, float paramFloat) {
    return (int)(paramFloat / (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  public static int c(Context paramContext, float paramFloat) {
    return (int)(paramFloat / (paramContext.getResources().getDisplayMetrics()).scaledDensity + 0.5F);
  }
  
  public static int d(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).scaledDensity + 0.5F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\DensityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */