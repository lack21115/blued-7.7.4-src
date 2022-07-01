package com.geetest.onelogin.view;

import android.app.Activity;
import android.os.Build;
import com.geetest.onelogin.config.OneLoginThemeConfig;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.k;

public class b {
  public static void a(Activity paramActivity, OneLoginThemeConfig paramOneLoginThemeConfig) {
    try {
      if (Build.VERSION.SDK_INT >= 21) {
        if (paramOneLoginThemeConfig.getStatusBarColor() != 0) {
          paramActivity.getWindow().addFlags(-2147483648);
          paramActivity.getWindow().clearFlags(67108864);
          paramActivity.getWindow().setStatusBarColor(paramOneLoginThemeConfig.getStatusBarColor());
        } 
        if (paramOneLoginThemeConfig.getNavigationBarColor() != 0) {
          paramActivity.getWindow().addFlags(-2147483648);
          paramActivity.getWindow().clearFlags(134217728);
          paramActivity.getWindow().setNavigationBarColor(paramOneLoginThemeConfig.getNavigationBarColor());
        } 
      } 
      if (Build.VERSION.SDK_INT >= 23) {
        if (paramOneLoginThemeConfig.isLightColor()) {
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(8192);
          return;
        } 
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
        return;
      } 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
  }
  
  public static void b(Activity paramActivity, OneLoginThemeConfig paramOneLoginThemeConfig) {
    try {
      if (paramOneLoginThemeConfig.isDialogTheme()) {
        k.a(paramActivity, paramOneLoginThemeConfig.getDialogWidth(), paramOneLoginThemeConfig.getDialogHeight(), paramOneLoginThemeConfig.getDialogX(), paramOneLoginThemeConfig.getDialogY(), paramOneLoginThemeConfig.isDialogBottom());
        return;
      } 
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
  }
  
  public static void c(Activity paramActivity, OneLoginThemeConfig paramOneLoginThemeConfig) {
    if (paramOneLoginThemeConfig != null)
      try {
        if (paramOneLoginThemeConfig.isDialogTheme() && paramOneLoginThemeConfig.isWebViewDialogTheme()) {
          k.a(paramActivity, paramOneLoginThemeConfig.getDialogWidth(), paramOneLoginThemeConfig.getDialogHeight(), paramOneLoginThemeConfig.getDialogX(), paramOneLoginThemeConfig.getDialogY(), paramOneLoginThemeConfig.isDialogBottom());
          return;
        } 
      } catch (Exception exception) {
        h.c(exception.toString());
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */