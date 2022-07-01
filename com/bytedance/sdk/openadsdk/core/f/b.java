package com.bytedance.sdk.openadsdk.core.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;

public class b {
  public static int a(Context paramContext, String paramString) {
    if (paramString != null)
      try {
        return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
      } finally {
        paramContext = null;
        paramContext.printStackTrace();
      }  
    throw new IllegalArgumentException("permission is null");
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23)
      paramActivity.requestPermissions(paramArrayOfString, paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */