package org.chromium.android_webview;

import android.os.Trace;

public final class ScopedSysTraceEvent implements AutoCloseable {
  private ScopedSysTraceEvent(String paramString) {
    Trace.beginSection(paramString);
  }
  
  public static ScopedSysTraceEvent scoped(String paramString) {
    return new ScopedSysTraceEvent(paramString);
  }
  
  public final void close() {
    Trace.endSection();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ScopedSysTraceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */