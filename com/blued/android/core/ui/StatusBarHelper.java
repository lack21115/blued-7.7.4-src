package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class StatusBarHelper {
  public static int a(Context paramContext) {
    int i = AppMethods.a(25);
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0)
      i = paramContext.getResources().getDimensionPixelSize(j); 
    return i;
  }
  
  public static int a(String paramString1, String paramString2) throws Exception {
    if (paramString1 != null && paramString2 != null) {
      String[] arrayOfString1 = paramString1.split("\\.");
      String[] arrayOfString2 = paramString2.split("\\.");
      int k = Math.min(arrayOfString1.length, arrayOfString2.length);
      int j = 0;
      int i = 0;
      while (j < k) {
        int m = arrayOfString1[j].length() - arrayOfString2[j].length();
        i = m;
        if (m == 0) {
          m = arrayOfString1[j].compareTo(arrayOfString2[j]);
          i = m;
          if (m == 0) {
            j++;
            i = m;
          } 
        } 
      } 
      return (i != 0) ? i : (arrayOfString1.length - arrayOfString2.length);
    } 
    throw new Exception("compareVersion error:illegal params.");
  }
  
  public static Drawable a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    if (AppInfo.d() == null)
      return (Drawable)new GradientDrawable(); 
    GradientDrawable gradientDrawable1 = new GradientDrawable();
    gradientDrawable1.setColor(ContextCompat.getColor(AppInfo.d(), paramInt3));
    if (paramBoolean)
      return (Drawable)gradientDrawable1; 
    GradientDrawable gradientDrawable2 = new GradientDrawable();
    if (paramInt2 != 0 && paramInt2 != 17170445 && Build.VERSION.SDK_INT >= 19) {
      gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
      gradientDrawable2.setColors(new int[] { ContextCompat.getColor(AppInfo.d(), paramInt1), ContextCompat.getColor(AppInfo.d(), paramInt2) });
    } else {
      gradientDrawable2.setColor(ContextCompat.getColor(AppInfo.d(), paramInt1));
    } 
    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)gradientDrawable2, (Drawable)gradientDrawable1 });
    layerDrawable.setLayerInset(1, 0, a(paramContext), 0, 0);
    return (Drawable)layerDrawable;
  }
  
  public static void a(Activity paramActivity, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21) {
      Window window = paramActivity.getWindow();
      window.addFlags(-2147483648);
      window.setNavigationBarColor(paramInt);
    } 
  }
  
  public static boolean a() {
    return (b() || c() || (AppInfo.i() && Build.VERSION.SDK_INT >= 23) || (!AppInfo.i() && Build.VERSION.SDK_INT >= 19));
  }
  
  public static boolean a(Activity paramActivity) {
    return a(paramActivity, AppInfo.i(), AppInfo.v);
  }
  
  public static boolean a(Activity paramActivity, View paramView) {
    if (paramActivity != null) {
      if (paramView == null)
        return false; 
      if (a()) {
        paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + a((Context)paramActivity), paramView.getPaddingRight(), paramView.getPaddingBottom());
        return true;
      } 
    } 
    return false;
  }
  
  public static boolean a(Activity paramActivity, boolean paramBoolean) {
    return a(paramActivity, paramBoolean, true);
  }
  
  protected static boolean a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2) {
    if (!a())
      return false; 
    if (Build.VERSION.SDK_INT >= 21) {
      Window window = paramActivity.getWindow();
      window.clearFlags(67108864);
      window.getDecorView().setSystemUiVisibility(1280);
      window.addFlags(-2147483648);
      window.setStatusBarColor(0);
      b(paramActivity, paramBoolean1, paramBoolean2);
      return true;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
      b(paramActivity, paramBoolean1, paramBoolean2);
      return true;
    } 
    return false;
  }
  
  public static boolean a(Window paramWindow) {
    if (!a())
      return false; 
    if (Build.VERSION.SDK_INT >= 21) {
      paramWindow.clearFlags(67108864);
      paramWindow.getDecorView().setSystemUiVisibility(1280);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
      return true;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      paramWindow.addFlags(67108864);
      return true;
    } 
    return false;
  }
  
  public static int b(Activity paramActivity) {
    if (!c(paramActivity))
      return 0; 
    if (paramActivity.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
      int i = paramActivity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
      return paramActivity.getResources().getDimensionPixelSize(i);
    } 
    return 0;
  }
  
  public static void b(Activity paramActivity, boolean paramBoolean) {
    b(paramActivity, paramBoolean, false);
  }
  
  protected static void b(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool = paramBoolean1;
    if (BluedSkinUtils.a()) {
      bool = paramBoolean1;
      if (!paramBoolean2)
        bool = BluedSkinUtils.c(); 
    } 
    if (b())
      try {
        Window window = paramActivity.getWindow();
        Class<?> clazz1 = paramActivity.getWindow().getClass();
        Class<?> clazz2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = clazz2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(clazz2);
        Method method = clazz1.getMethod("setExtraFlags", new Class[] { int.class, int.class });
        if (bool) {
          method.invoke(window, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          return;
        } 
        method.invoke(window, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        return;
      } catch (Exception null) {
        Log.c("miui status bar excn", exception.getMessage());
        exception.printStackTrace();
        return;
      }  
    if (c())
      try {
        Window window = exception.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        Field field1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field field2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        field1.setAccessible(true);
        field2.setAccessible(true);
        int i = field1.getInt((Object)null);
        int j = field2.getInt(layoutParams);
        if (bool) {
          i = j | i;
        } else {
          i &= j;
        } 
        field2.setInt(layoutParams, i);
        window.setAttributes(layoutParams);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      }  
    if (Build.VERSION.SDK_INT >= 23) {
      View view = exception.getWindow().getDecorView();
      if (view != null) {
        int i = view.getSystemUiVisibility();
        if (bool) {
          i |= 0x2000;
        } else {
          i &= 0xFFFFDFFF;
        } 
        view.setSystemUiVisibility(i);
      } 
    } 
  }
  
  public static boolean b() {
    if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi"))
      try {
        File file = new File(Environment.getRootDirectory(), "build.prop");
        if (!file.exists())
          return false; 
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String str = properties.getProperty("ro.miui.ui.version.code");
        fileInputStream.close();
        if (!TextUtils.isEmpty(str)) {
          int i = Integer.parseInt(str);
          String str1 = Build.VERSION.INCREMENTAL;
          if (i >= 4) {
            Class<?> clazz = Class.forName("miui.os.Build");
            if (clazz.getField("IS_ALPHA_BUILD").getBoolean((Object)null) || clazz.getField("IS_DEVELOPMENT_VERSION").getBoolean((Object)null)) {
              i = a("7.7.13", str1);
              return (i > 0);
            } 
            if (clazz.getField("IS_STABLE_VERSION").getBoolean((Object)null) && a("V8.6", str1) > 0)
              return true; 
          } 
        } 
        return false;
      } catch (Exception exception) {
        return false;
      }  
    return false;
  }
  
  public static void c(Activity paramActivity, boolean paramBoolean) {
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (paramBoolean) {
      i |= 0x10;
    } else {
      i &= 0xFFFFFFEF;
    } 
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
    a(paramActivity, BluedSkinUtils.a((Context)paramActivity, AppInfo.k()));
  }
  
  private static boolean c() {
    String str = Build.DISPLAY;
    if (!TextUtils.isEmpty(str) && str.contains("Flyme") && Build.VERSION.SDK_INT < 23) {
      String[] arrayOfString = str.split(" ");
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        if (arrayOfString[i].matches("^[4-9]\\.(\\d+\\.)+\\S*"))
          return true; 
      } 
    } 
    return false;
  }
  
  public static boolean c(Activity paramActivity) {
    try {
      ViewGroup viewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
      if (viewGroup != null)
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
          viewGroup.getChildAt(i).getContext().getPackageName();
          if (viewGroup.getChildAt(i).getId() != -1) {
            boolean bool = "navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(viewGroup.getChildAt(i).getId()));
            if (bool)
              return true; 
          } 
        }  
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\StatusBarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */