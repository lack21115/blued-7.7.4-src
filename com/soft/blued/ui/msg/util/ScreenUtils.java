package com.soft.blued.ui.msg.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.blued.android.core.ui.StatusBarHelper;
import com.soft.blued.utils.Logger;

public class ScreenUtils {
  static final String a = ScreenUtils.class.getSimpleName();
  
  public static boolean a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic b : (Landroid/content/Context;)I
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: iload_2
    //   8: ifne -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   16: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: invokevirtual hashCode : ()I
    //   24: istore_2
    //   25: iload_2
    //   26: ldc -1206476313
    //   28: if_icmpeq -> 72
    //   31: iload_2
    //   32: ldc -759499589
    //   34: if_icmpeq -> 60
    //   37: iload_2
    //   38: ldc 3620012
    //   40: if_icmpeq -> 46
    //   43: goto -> 86
    //   46: aload_3
    //   47: ldc 'vivo'
    //   49: invokevirtual equals : (Ljava/lang/Object;)Z
    //   52: ifeq -> 86
    //   55: iconst_2
    //   56: istore_1
    //   57: goto -> 88
    //   60: aload_3
    //   61: ldc 'xiaomi'
    //   63: invokevirtual equals : (Ljava/lang/Object;)Z
    //   66: ifeq -> 86
    //   69: goto -> 88
    //   72: aload_3
    //   73: ldc 'huawei'
    //   75: invokevirtual equals : (Ljava/lang/Object;)Z
    //   78: ifeq -> 86
    //   81: iconst_1
    //   82: istore_1
    //   83: goto -> 88
    //   86: iconst_m1
    //   87: istore_1
    //   88: iload_1
    //   89: ifeq -> 121
    //   92: iload_1
    //   93: iconst_1
    //   94: if_icmpeq -> 114
    //   97: iload_1
    //   98: iconst_2
    //   99: if_icmpeq -> 107
    //   102: aload_0
    //   103: invokestatic f : (Landroid/content/Context;)Z
    //   106: ireturn
    //   107: aload_0
    //   108: invokestatic c : (Landroid/content/Context;)Z
    //   111: iconst_1
    //   112: ixor
    //   113: ireturn
    //   114: aload_0
    //   115: invokestatic e : (Landroid/content/Context;)Z
    //   118: iconst_1
    //   119: ixor
    //   120: ireturn
    //   121: aload_0
    //   122: invokestatic d : (Landroid/content/Context;)Z
    //   125: iconst_1
    //   126: ixor
    //   127: ireturn
  }
  
  private static int b(Context paramContext) {
    Resources resources = paramContext.getResources();
    int i = resources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      i = resources.getDimensionPixelSize(i);
    } else {
      i = 0;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getNavigationBarHeight===");
    stringBuilder.append(i);
    Logger.c(str, new Object[] { stringBuilder.toString() });
    return i;
  }
  
  private static boolean c(Context paramContext) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    boolean bool = false;
    if (Settings.Secure.getInt(contentResolver, "navigation_gesture_on", 0) != 0)
      bool = true; 
    return bool;
  }
  
  private static boolean d(Context paramContext) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    boolean bool = false;
    if (Settings.Global.getInt(contentResolver, "force_fsg_nav_bar", 0) != 0)
      bool = true; 
    return bool;
  }
  
  private static boolean e(Context paramContext) {
    int i;
    if (Build.VERSION.SDK_INT < 21) {
      i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
    } else {
      i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isHuaWeiHideNav===");
    stringBuilder.append(i);
    Logger.c(str, new Object[] { stringBuilder.toString() });
    return (i != 0);
  }
  
  private static boolean f(Context paramContext) {
    Display display = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
      display.getRealMetrics(displayMetrics); 
    int i = displayMetrics.heightPixels;
    int j = displayMetrics.widthPixels;
    displayMetrics = new DisplayMetrics();
    display.getMetrics(displayMetrics);
    int k = displayMetrics.heightPixels;
    int m = displayMetrics.widthPixels;
    boolean bool = false;
    if (k > m) {
      if (StatusBarHelper.b((Activity)paramContext) + k > i)
        return false; 
    } else if (StatusBarHelper.b((Activity)paramContext) + m > j) {
      return false;
    } 
    if (j - m > 0 || i - k > 0)
      bool = true; 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\ms\\util\ScreenUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */