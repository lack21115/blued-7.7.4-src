package org.chromium.base;

import android.os.StrictMode;
import java.util.TimeZone;
import org.chromium.base.annotations.CalledByNative;

class TimezoneUtils {
  @CalledByNative
  private static String getDefaultTimeZoneId() {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    String str = TimeZone.getDefault().getID();
    StrictMode.setThreadPolicy(threadPolicy);
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\TimezoneUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */