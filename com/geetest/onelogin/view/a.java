package com.geetest.onelogin.view;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.View;

public class a {
  public static int a(String paramString, Context paramContext) throws Exception {
    ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    return paramContext.getResources().getIdentifier(paramString, "id", applicationInfo.packageName);
  }
  
  public static View a(String paramString, Activity paramActivity) throws Exception {
    ApplicationInfo applicationInfo = paramActivity.getApplicationInfo();
    int i = paramActivity.getResources().getIdentifier(paramString, "layout", applicationInfo.packageName);
    return paramActivity.getLayoutInflater().inflate(i, null);
  }
  
  public static int b(String paramString, Context paramContext) throws Exception {
    ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    return paramContext.getResources().getIdentifier(paramString, "drawable", applicationInfo.packageName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */