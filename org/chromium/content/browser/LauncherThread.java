package org.chromium.content.browser;

import android.os.Handler;
import android.os.Looper;
import org.chromium.base.JavaHandlerThread;
import org.chromium.base.annotations.CalledByNative;

public final class LauncherThread {
  private static Handler sHandler;
  
  private static final JavaHandlerThread sThread = new JavaHandlerThread("Chrome_ProcessLauncherThread", 0);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Handler getHandler() {
    return sHandler;
  }
  
  @CalledByNative
  private static JavaHandlerThread getHandlerThread() {
    return sThread;
  }
  
  public static void post(Runnable paramRunnable) {
    sHandler.post(paramRunnable);
  }
  
  public static boolean runningOnLauncherThread() {
    return (sHandler.getLooper() == Looper.myLooper());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\LauncherThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */