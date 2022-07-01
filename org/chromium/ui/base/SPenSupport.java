package org.chromium.ui.base;

import android.content.pm.FeatureInfo;
import android.os.Build;
import org.chromium.base.ContextUtils;

public final class SPenSupport {
  static Boolean sIsSPenSupported;
  
  static void initialize() {
    if (sIsSPenSupported != null)
      return; 
    if (!"SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER)) {
      sIsSPenSupported = Boolean.valueOf(false);
      return;
    } 
    FeatureInfo[] arrayOfFeatureInfo = ContextUtils.sApplicationContext.getPackageManager().getSystemAvailableFeatures();
    int j = arrayOfFeatureInfo.length;
    for (int i = 0; i < j; i++) {
      if ("com.sec.feature.spen_usp".equalsIgnoreCase((arrayOfFeatureInfo[i]).name)) {
        sIsSPenSupported = Boolean.valueOf(true);
        return;
      } 
    } 
    sIsSPenSupported = Boolean.valueOf(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\SPenSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */