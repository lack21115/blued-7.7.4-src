package org.chromium.base;

import android.os.StrictMode;
import java.io.Closeable;

public final class StrictModeContext implements Closeable {
  private final StrictMode.ThreadPolicy mThreadPolicy;
  
  private final StrictMode.VmPolicy mVmPolicy;
  
  private StrictModeContext(StrictMode.ThreadPolicy paramThreadPolicy) {
    this(paramThreadPolicy, null);
  }
  
  private StrictModeContext(StrictMode.ThreadPolicy paramThreadPolicy, StrictMode.VmPolicy paramVmPolicy) {
    this.mThreadPolicy = paramThreadPolicy;
    this.mVmPolicy = paramVmPolicy;
  }
  
  public static StrictModeContext allowDiskReads() {
    return new StrictModeContext(StrictMode.allowThreadDiskReads());
  }
  
  public static StrictModeContext allowDiskWrites() {
    return new StrictModeContext(StrictMode.allowThreadDiskWrites());
  }
  
  public final void close() {
    if (this.mThreadPolicy != null)
      StrictMode.setThreadPolicy(this.mThreadPolicy); 
    if (this.mVmPolicy != null)
      StrictMode.setVmPolicy(this.mVmPolicy); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\StrictModeContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */