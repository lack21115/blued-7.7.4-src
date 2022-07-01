package com.blued.android.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.blued.android.core.AppInfo;

public class KeyboardUtils {
  private static int a;
  
  private static int b;
  
  public static int a() {
    if (b == 0)
      b = (int)(AppInfo.m * 0.4F); 
    if (a == 0 && AppInfo.d() != null)
      a = AppInfo.d().getSharedPreferences("sp_keyboard", 0).getInt("keyboard_height", b); 
    int i = a;
    return (i != 0) ? i : b;
  }
  
  public static void a(int paramInt) {
    if (a != paramInt) {
      a = paramInt;
      if (AppInfo.d() != null)
        AppInfo.d().getSharedPreferences("sp_keyboard", 0).edit().putInt("keyboard_height", paramInt).commit(); 
    } 
  }
  
  public static void a(Activity paramActivity) {
    try {
      InputMethodManager inputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (inputMethodManager == null)
        return; 
      if (inputMethodManager.isActive() && paramActivity.getCurrentFocus() != null && paramActivity.getCurrentFocus().getWindowToken() != null) {
        inputMethodManager.hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 2);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(Context paramContext, View paramView) {
    ((InputMethodManager)paramContext.getSystemService("input_method")).showSoftInputFromInputMethod(paramView.getWindowToken(), 0);
  }
  
  public static void a(View paramView) {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 2);
  }
  
  public static void b(Context paramContext, View paramView) {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static boolean b(Activity paramActivity) {
    try {
      InputMethodManager inputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (inputMethodManager != null) {
        boolean bool = inputMethodManager.isActive();
        if (bool)
          return true; 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  public static void c(Activity paramActivity) {
    try {
      InputMethodManager inputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (inputMethodManager != null && inputMethodManager.isActive()) {
        inputMethodManager.toggleSoftInput(0, 2);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\KeyboardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */