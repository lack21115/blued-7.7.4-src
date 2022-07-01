package org.chromium.components.minidump_uploader;

public interface MinidumpUploader {
  boolean cancelUploads();
  
  void uploadAllMinidumps(MinidumpUploader$UploadsFinishedCallback paramMinidumpUploader$UploadsFinishedCallback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */