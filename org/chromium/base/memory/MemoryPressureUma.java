package org.chromium.base.memory;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;

public class MemoryPressureUma implements ComponentCallbacks2 {
  private static MemoryPressureUma sInstance;
  
  private final String mHistogramName;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MemoryPressureUma(String paramString) {
    StringBuilder stringBuilder = new StringBuilder("Android.MemoryPressureNotification.");
    stringBuilder.append(paramString);
    this.mHistogramName = stringBuilder.toString();
  }
  
  public static void initializeForChildService() {
    ThreadUtils.assertOnUiThread();
    assert false;
    throw new AssertionError();
  }
  
  private void record(int paramInt) {
    RecordHistogram.recordEnumeratedHistogram(this.mHistogramName, paramInt, 9);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {
    record(8);
  }
  
  public void onTrimMemory(int paramInt) {
    if (paramInt != 5) {
      if (paramInt != 10) {
        if (paramInt != 15) {
          if (paramInt != 20) {
            if (paramInt != 40) {
              if (paramInt != 60) {
                if (paramInt != 80) {
                  record(0);
                  return;
                } 
                record(1);
                return;
              } 
              record(2);
              return;
            } 
            record(3);
            return;
          } 
          record(4);
          return;
        } 
        record(5);
        return;
      } 
      record(6);
      return;
    } 
    record(7);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\memory\MemoryPressureUma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */