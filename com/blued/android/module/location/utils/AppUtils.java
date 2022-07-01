package com.blued.android.module.location.utils;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.BlueAppLocal;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class AppUtils {
  private static Application a;
  
  public static Application a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/location/utils/AppUtils.a : Landroid/app/Application;
    //   3: ifnonnull -> 85
    //   6: ldc com/blued/android/module/location/utils/AppUtils
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/location/utils/AppUtils.a : Landroid/app/Application;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull -> 73
    //   17: ldc 'android.app.ActivityThread'
    //   19: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 'currentActivityThread'
    //   26: iconst_0
    //   27: anewarray java/lang/Class
    //   30: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: astore_0
    //   34: aload_1
    //   35: ldc 'mInitialApplication'
    //   37: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   40: astore_1
    //   41: aload_1
    //   42: iconst_1
    //   43: invokevirtual setAccessible : (Z)V
    //   46: aload_1
    //   47: aload_0
    //   48: aconst_null
    //   49: iconst_0
    //   50: anewarray java/lang/Object
    //   53: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   56: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast android/app/Application
    //   62: putstatic com/blued/android/module/location/utils/AppUtils.a : Landroid/app/Application;
    //   65: goto -> 73
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual printStackTrace : ()V
    //   73: ldc com/blued/android/module/location/utils/AppUtils
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_0
    //   80: ldc com/blued/android/module/location/utils/AppUtils
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    //   85: getstatic com/blued/android/module/location/utils/AppUtils.a : Landroid/app/Application;
    //   88: areturn
    // Exception table:
    //   from	to	target	type
    //   9	13	79	finally
    //   17	65	68	java/lang/Exception
    //   17	65	79	finally
    //   69	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static void a(Application paramApplication) {
    a = paramApplication;
  }
  
  public static boolean a(String paramString) {
    return Pattern.compile("[一-龥]").matcher(paramString).find();
  }
  
  public static boolean b() {
    boolean bool = false;
    try {
      String str = TimeZone.getDefault().getID();
      if (!"Asia/Shanghai".equals(str) && !"Asia/Chongqing".equals(str) && !"Asia/Harbin".equals(str)) {
        boolean bool1 = "Asia/Urumqi".equals(str);
        return bool1 ? true : bool;
      } 
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static int c() {
    return Build.VERSION.SDK_INT;
  }
  
  public static String d() {
    String str1 = BlueAppLocal.c().getLanguage().toLowerCase();
    String str2 = BlueAppLocal.c().getCountry().toLowerCase();
    if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2))
      return "en"; 
    byte b = -1;
    int i = str1.hashCode();
    if (i != 3365) {
      if (i == 3886 && str1.equals("zh"))
        b = 0; 
    } else if (str1.equals("in")) {
      b = 1;
    } 
    return (b != 0) ? ((b != 1) ? str1 : "id") : (str2.equals("cn") ? "zh-CN" : "zh-TW");
  }
  
  public static boolean e() {
    return "zh".equals(BlueAppLocal.c().getLanguage().toLowerCase());
  }
  
  public static boolean f() {
    try {
      Class.forName("com.amap.api.maps2d.AMap");
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\locatio\\utils\AppUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */