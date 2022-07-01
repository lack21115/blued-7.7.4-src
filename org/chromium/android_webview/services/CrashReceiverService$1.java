package org.chromium.android_webview.services;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import org.chromium.base.Log;
import org.chromium.components.minidump_uploader.MinidumpUploadJobService;

final class CrashReceiverService$1 extends ICrashReceiverService$Stub {
  public final void transmitCrashes(ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor) {
    int i = Binder.getCallingUid();
    CrashReceiverService crashReceiverService = CrashReceiverService.this;
    if (!crashReceiverService.waitUntilWeCanCopy()) {
      Log.e("CrashReceiverService", "something went wrong when waiting to copy minidumps, bailing!", new Object[0]);
      return;
    } 
    try {
      if (CrashReceiverService.copyMinidumps(i, paramArrayOfParcelFileDescriptor))
        MinidumpUploadJobService.scheduleUpload(new JobInfo.Builder(42, new ComponentName((Context)crashReceiverService, AwMinidumpUploadJobService.class))); 
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\CrashReceiverService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */