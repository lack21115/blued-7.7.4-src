package org.chromium.components.minidump_uploader;

import java.io.File;
import org.chromium.components.minidump_uploader.util.CrashReportingPermissionManager;

public interface MinidumpUploaderDelegate {
  CrashReportingPermissionManager createCrashReportingPermissionManager();
  
  File getCrashParentDir();
  
  void prepareToUploadMinidumps(Runnable paramRunnable);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploaderDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */