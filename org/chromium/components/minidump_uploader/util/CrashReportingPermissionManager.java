package org.chromium.components.minidump_uploader.util;

public interface CrashReportingPermissionManager {
  boolean isClientInMetricsSample();
  
  boolean isNetworkAvailableForCrashUploads();
  
  boolean isUploadEnabledForTests();
  
  boolean isUsageAndCrashReportingPermittedByUser();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploade\\util\CrashReportingPermissionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */