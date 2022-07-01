package org.chromium.components.crash.browser;

import java.io.File;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class CrashDumpManager {
  private static CrashDumpManager$UploadMinidumpCallback sCallback;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  public static void tryToUploadMinidump(String paramString) {
    ThreadUtils.assertOnBackgroundThread();
    if (paramString == null) {
      Log.e("CrashDumpManager", "Minidump path should be non-null! Bailing...", new Object[0]);
      return;
    } 
    File file = new File(paramString);
    if (!file.exists() || !file.isFile()) {
      StringBuilder stringBuilder = new StringBuilder("Minidump path '");
      stringBuilder.append(paramString);
      stringBuilder.append("' should describe a file that exists! Bailing...");
      Log.e("CrashDumpManager", stringBuilder.toString(), new Object[0]);
      return;
    } 
    ThreadUtils.postOnUiThread(new CrashDumpManager$1());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\crash\browser\CrashDumpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */