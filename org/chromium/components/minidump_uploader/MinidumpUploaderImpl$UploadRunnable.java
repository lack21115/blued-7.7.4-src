package org.chromium.components.minidump_uploader;

import java.io.File;
import org.chromium.base.Log;

final class MinidumpUploaderImpl$UploadRunnable implements Runnable {
  private final MinidumpUploader$UploadsFinishedCallback mUploadsFinishedCallback;
  
  public MinidumpUploaderImpl$UploadRunnable(MinidumpUploader$UploadsFinishedCallback paramMinidumpUploader$UploadsFinishedCallback) {
    this.mUploadsFinishedCallback = paramMinidumpUploader$UploadsFinishedCallback;
  }
  
  public final void run() {
    File file = MinidumpUploaderImpl.this.mDelegate.getCrashParentDir();
    boolean bool1 = file.isDirectory();
    boolean bool = false;
    if (!bool1) {
      Log.e("MinidumpUploaderImpl", "Parent crash directory doesn't exist!", new Object[0]);
      this.mUploadsFinishedCallback.uploadsFinished(false);
      return;
    } 
    CrashFileManager crashFileManager = new CrashFileManager(file);
    if (!crashFileManager.getCrashDirectory().isDirectory()) {
      Log.e("MinidumpUploaderImpl", "Crash directory doesn't exist!", new Object[0]);
      this.mUploadsFinishedCallback.uploadsFinished(false);
      return;
    } 
    File[] arrayOfFile = crashFileManager.getMinidumpsReadyForUpload(3);
    Log.i("MinidumpUploaderImpl", "Attempting to upload %d minidumps.", new Object[] { Integer.valueOf(arrayOfFile.length) });
    int j = arrayOfFile.length;
    for (int i = 0; i < j; i++) {
      File file1 = arrayOfFile[i];
      StringBuilder stringBuilder = new StringBuilder("Attempting to upload ");
      stringBuilder.append(file1.getName());
      Log.i("MinidumpUploaderImpl", stringBuilder.toString(), new Object[0]);
      int k = MinidumpUploaderImpl.this.createMinidumpUploadCallable(file1, new File(crashFileManager.getCrashDirectory(), "uploads.log")).call().intValue();
      if (k != 0 && k == 1)
        CrashFileManager.readAttemptNumber(file1.getName()); 
      if (MinidumpUploaderImpl.this.mCancelUpload)
        return; 
      if (k == 1 && CrashFileManager.tryIncrementAttemptNumber(file1) == null) {
        stringBuilder = new StringBuilder("Failed to increment attempt number of ");
        stringBuilder.append(file1);
        Log.w("MinidumpUploaderImpl", stringBuilder.toString(), new Object[0]);
      } 
    } 
    crashFileManager.cleanOutAllNonFreshMinidumpFiles();
    if ((crashFileManager.getMinidumpsReadyForUpload(3)).length > 0)
      bool = true; 
    this.mUploadsFinishedCallback.uploadsFinished(bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploaderImpl$UploadRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */