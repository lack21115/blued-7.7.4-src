package org.chromium.android_webview.command_line;

import android.os.Build;
import android.os.StrictMode;
import org.chromium.base.CommandLine;

public final class CommandLineUtil {
  public static void initCommandLine() {
    if (isBuildDebuggable()) {
      StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
      CommandLine.initFromFile("/data/local/tmp/webview-command-line");
      StrictMode.setThreadPolicy(threadPolicy);
      return;
    } 
    CommandLine.init(null);
  }
  
  public static boolean isBuildDebuggable() {
    return !Build.TYPE.equals("user");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\command_line\CommandLineUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */