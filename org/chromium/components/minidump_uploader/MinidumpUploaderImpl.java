package org.chromium.components.minidump_uploader;

import java.io.File;
import org.chromium.base.ThreadUtils;

public final class MinidumpUploaderImpl implements MinidumpUploader {
  volatile boolean mCancelUpload = false;
  
  protected final MinidumpUploaderDelegate mDelegate;
  
  Thread mWorkerThread;
  
  public MinidumpUploaderImpl(MinidumpUploaderDelegate paramMinidumpUploaderDelegate) {
    this.mDelegate = paramMinidumpUploaderDelegate;
  }
  
  public final boolean cancelUploads() {
    this.mCancelUpload = true;
    return true;
  }
  
  public final MinidumpUploadCallable createMinidumpUploadCallable(File paramFile1, File paramFile2) {
    return new MinidumpUploadCallable(paramFile1, paramFile2, this.mDelegate.createCrashReportingPermissionManager());
  }
  
  public final void uploadAllMinidumps(MinidumpUploader$UploadsFinishedCallback paramMinidumpUploader$UploadsFinishedCallback) {
    ThreadUtils.assertOnUiThread();
    if (this.mWorkerThread == null) {
      this.mWorkerThread = new Thread(new MinidumpUploaderImpl$UploadRunnable(this, paramMinidumpUploader$UploadsFinishedCallback), "MinidumpUploader-WorkerThread");
      this.mCancelUpload = false;
      this.mDelegate.prepareToUploadMinidumps(new MinidumpUploaderImpl$1(this));
      return;
    } 
    throw new RuntimeException("A given minidump uploader instance should never be launched more than once.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploaderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */