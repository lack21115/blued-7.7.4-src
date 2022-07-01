package org.chromium.ui.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;

final class Toast$1 extends ContextWrapper {
  Toast$1(Context paramContext) {
    super(paramContext);
  }
  
  public final ApplicationInfo getApplicationInfo() {
    ApplicationInfo applicationInfo = new ApplicationInfo(super.getApplicationInfo());
    applicationInfo.targetSdkVersion = 19;
    applicationInfo.flags &= 0xDFFFFFFF;
    return applicationInfo;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\widget\Toast$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */