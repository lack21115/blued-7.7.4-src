package org.chromium.components.minidump_uploader;

import android.app.job.JobParameters;
import org.chromium.base.Log;

final class MinidumpUploadJobService$1 implements MinidumpUploader$UploadsFinishedCallback {
  public final void uploadsFinished(boolean paramBoolean) {
    if (paramBoolean)
      Log.i("MinidumpJobService", "Some minidumps remain un-uploaded; rescheduling.", new Object[0]); 
    synchronized (MinidumpUploadJobService.access$000(MinidumpUploadJobService.this)) {
      MinidumpUploadJobService.access$102(MinidumpUploadJobService.this, false);
      MinidumpUploadJobService.this.jobFinished(params, paramBoolean);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploadJobService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */