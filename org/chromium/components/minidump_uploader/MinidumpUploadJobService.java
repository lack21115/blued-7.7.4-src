package org.chromium.components.minidump_uploader;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.build.BuildHooksAndroid;

@TargetApi(21)
public abstract class MinidumpUploadJobService extends JobService {
  private MinidumpUploader mMinidumpUploader;
  
  private boolean mRunningJob = false;
  
  private final Object mRunningLock = new Object();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void scheduleUpload(JobInfo.Builder paramBuilder) {
    Log.i("MinidumpJobService", "Scheduling upload of all pending minidumps.", new Object[0]);
    int i = ((JobScheduler)ContextUtils.sApplicationContext.getSystemService("jobscheduler")).schedule(paramBuilder.setRequiredNetworkType(2).setBackoffCriteria(1800000L, 1).build());
    assert false;
  }
  
  public Context createConfigurationContext(Configuration paramConfiguration) {
    if (Build.VERSION.SDK_INT < 17)
      return null; 
    if (!BuildHooksAndroid.isEnabled())
      return super.createConfigurationContext(paramConfiguration); 
    super.createConfigurationContext(paramConfiguration);
    return BuildHooksAndroid.createConfigurationContext$6263c3eb();
  }
  
  public abstract MinidumpUploader createMinidumpUploader$78a09a4b();
  
  public AssetManager getAssets() {
    return !BuildHooksAndroid.isEnabled() ? super.getAssets() : BuildHooksAndroid.getAssets$49f66a90();
  }
  
  public Resources getResources() {
    return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources$177d0c3c();
  }
  
  public Resources.Theme getTheme() {
    return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme$21e91261();
  }
  
  public void onDestroy() {
    this.mMinidumpUploader = null;
    super.onDestroy();
  }
  
  public boolean onStartJob(JobParameters paramJobParameters) {
    synchronized (this.mRunningLock) {
      assert false;
      throw new AssertionError();
    } 
  }
  
  public boolean onStopJob(JobParameters paramJobParameters) {
    Log.i("MinidumpJobService", "Canceling pending uploads due to change in networking status.", new Object[0]);
    boolean bool = this.mMinidumpUploader.cancelUploads();
    synchronized (this.mRunningLock) {
      this.mRunningJob = false;
      return bool;
    } 
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploadJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */