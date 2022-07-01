package com.bytedance.sdk.openadsdk.core.f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.bytedance.sdk.openadsdk.utils.t;

public class a {
  private static final String a = a.class.getSimpleName();
  
  public static boolean a(Context paramContext, String paramString) {
    return (Build.VERSION.SDK_INT >= 19) ? b(paramContext, paramString) : c(paramContext, paramString);
  }
  
  private static boolean b(Context paramContext, String paramString) {
    String str = a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("checkPermissinKITKATNew，permission：");
    stringBuilder2.append(paramString);
    t.e(str, stringBuilder2.toString());
    int i = -1;
    boolean bool = false;
    try {
      int j = paramString.hashCode();
      if (j != -1888586689) {
        if (j != -63024214) {
          if (j == -5573545 && paramString.equals("android.permission.READ_PHONE_STATE"))
            i = 2; 
        } else if (paramString.equals("android.permission.ACCESS_COARSE_LOCATION")) {
          i = 0;
        } 
      } else if (paramString.equals("android.permission.ACCESS_FINE_LOCATION")) {
        i = 1;
      } 
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            paramString = paramString.replaceFirst("android.permission.", "android:").toLowerCase();
          } else {
            paramString = "android:read_phone_state";
          } 
        } else {
          paramString = "android:fine_location";
        } 
      } else {
        paramString = "android:coarse_location";
      } 
      i = ((AppOpsManager)paramContext.getSystemService("appops")).checkOp(paramString, Binder.getCallingUid(), paramContext.getPackageName());
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkPermissinKITKATNew，locationOp,permission：");
      stringBuilder.append(i);
      stringBuilder.append(",");
      stringBuilder.append(paramString);
      t.e(str1, stringBuilder.toString());
      if (i != 0) {
        try {
          str1 = a;
          stringBuilder = new StringBuilder();
          stringBuilder.append("checkPermissinKITKATNew，false,permission：");
          stringBuilder.append(paramString);
          t.e(str1, stringBuilder.toString());
          return false;
        } catch (Exception null) {}
      } else {
        return true;
      } 
    } catch (Exception exception) {
      bool = true;
    } 
    paramString = a;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("权限检查出错时默认返回有权限，异常代码：");
    stringBuilder1.append(exception);
    t.e(paramString, stringBuilder1.toString());
    return bool;
  }
  
  private static boolean c(Context paramContext, String paramString) {
    return (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */