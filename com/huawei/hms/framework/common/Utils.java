package com.huawei.hms.framework.common;

import android.os.SystemClock;

public class Utils {
  public static long getCurrentTime(boolean paramBoolean) {
    return paramBoolean ? SystemClock.elapsedRealtime() : System.currentTimeMillis();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */