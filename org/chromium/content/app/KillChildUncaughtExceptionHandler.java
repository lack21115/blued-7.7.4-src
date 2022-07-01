package org.chromium.content.app;

import android.os.Process;
import org.chromium.base.BuildInfo;

final class KillChildUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
  private boolean mCrashing;
  
  static void maybeInstallHandler() {
    if (BuildInfo.isDebugAndroid())
      return; 
    Thread.setDefaultUncaughtExceptionHandler(new KillChildUncaughtExceptionHandler());
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (this.mCrashing)
      return; 
    this.mCrashing = true;
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\app\KillChildUncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */