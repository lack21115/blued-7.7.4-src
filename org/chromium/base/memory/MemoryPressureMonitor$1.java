package org.chromium.base.memory;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

public final class MemoryPressureMonitor$1 implements ComponentCallbacks2 {
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {
    MemoryPressureMonitor.this.notifyPressure(2);
  }
  
  public final void onTrimMemory(int paramInt) {
    Integer integer = MemoryPressureMonitor.memoryPressureFromTrimLevel(paramInt);
    if (integer != null)
      MemoryPressureMonitor.this.notifyPressure(integer.intValue()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\memory\MemoryPressureMonitor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */