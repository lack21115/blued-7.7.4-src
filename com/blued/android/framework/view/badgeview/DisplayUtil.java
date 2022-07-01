package com.blued.android.framework.view.badgeview;

import android.content.Context;

public class DisplayUtil {
  public static int a(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\badgeview\DisplayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */