package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

public class f {
  public static Activity a(Context paramContext) {
    return !(paramContext instanceof ContextWrapper) ? null : ((paramContext instanceof Activity) ? (Activity)paramContext : a(((ContextWrapper)paramContext).getBaseContext()));
  }
  
  public static boolean a(Activity paramActivity) {
    null = false;
    if (paramActivity == null)
      return false; 
    if (Build.VERSION.SDK_INT >= 17) {
      if (!paramActivity.isFinishing()) {
        if (paramActivity.isDestroyed())
          return false; 
      } else {
        return null;
      } 
    } else if (paramActivity.isFinishing()) {
      return false;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */