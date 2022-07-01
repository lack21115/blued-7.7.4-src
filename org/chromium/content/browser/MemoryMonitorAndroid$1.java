package org.chromium.content.browser;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class MemoryMonitorAndroid$1 implements ComponentCallbacks2 {
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt) {
    if (paramInt != 20)
      MemoryMonitorAndroid.access$000(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\MemoryMonitorAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */