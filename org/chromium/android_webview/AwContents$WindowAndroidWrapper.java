package org.chromium.android_webview;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import org.chromium.ui.base.WindowAndroid;

final class AwContents$WindowAndroidWrapper {
  final WindowAndroid mWindowAndroid;
  
  public AwContents$WindowAndroidWrapper(WindowAndroid paramWindowAndroid) {
    ScopedSysTraceEvent scopedSysTraceEvent = ScopedSysTraceEvent.scoped("WindowAndroidWrapper.constructor");
    Throwable throwable2 = null;
    Throwable throwable1 = throwable2;
    try {
      this.mWindowAndroid = paramWindowAndroid;
      throwable1 = throwable2;
      new CleanupReference(this, new AwContents$WindowAndroidWrapper$DestroyRunnable(paramWindowAndroid, (byte)0));
      if (scopedSysTraceEvent != null) {
        scopedSysTraceEvent.close();
        return;
      } 
      return;
    } catch (Throwable throwable) {
      throwable1 = throwable;
      throw throwable;
    } finally {}
    if (scopedSysTraceEvent != null)
      if (throwable1 != null) {
        try {
          scopedSysTraceEvent.close();
        } catch (Throwable throwable) {
          ThrowableExtension.addSuppressed(throwable1, throwable);
        } 
      } else {
        scopedSysTraceEvent.close();
      }  
    throw paramWindowAndroid;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$WindowAndroidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */