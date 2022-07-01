package org.chromium.ui.base;

import org.chromium.ui.VSyncMonitor;

final class WindowAndroid$1 implements VSyncMonitor.Listener {
  public final void onVSync$188f8d16(long paramLong) {
    if (WindowAndroid.access$300(WindowAndroid.this)) {
      WindowAndroid.access$402$46e2621e(true);
      return;
    } 
    if (WindowAndroid.access$500(WindowAndroid.this) != 0L)
      WindowAndroid.access$700(WindowAndroid.this, WindowAndroid.access$500(WindowAndroid.this), paramLong, (WindowAndroid.access$600(WindowAndroid.this)).mRefreshPeriodNano / 1000L); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\WindowAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */