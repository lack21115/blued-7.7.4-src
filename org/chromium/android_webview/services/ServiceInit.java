package org.chromium.android_webview.services;

import android.content.Context;
import org.chromium.android_webview.command_line.CommandLineUtil;
import org.chromium.base.ContextUtils;
import org.chromium.base.PathUtils;
import org.chromium.base.ThreadUtils;

public final class ServiceInit {
  private static boolean sInitDone;
  
  public static void init(Context paramContext) {
    ThreadUtils.assertOnUiThread();
    if (sInitDone)
      return; 
    ContextUtils.initApplicationContext(paramContext);
    CommandLineUtil.initCommandLine();
    PathUtils.setPrivateDataDirectorySuffix("webview");
    sInitDone = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\ServiceInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */