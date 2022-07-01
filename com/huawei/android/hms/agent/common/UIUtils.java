package com.huawei.android.hms.agent.common;

import android.app.Activity;

public final class UIUtils {
  public static boolean isActivityFullscreen(Activity paramActivity) {
    return (((paramActivity.getWindow().getAttributes()).flags & 0x400) == 1024);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */