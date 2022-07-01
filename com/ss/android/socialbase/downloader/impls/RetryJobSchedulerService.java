package com.ss.android.socialbase.downloader.impls;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;

public class RetryJobSchedulerService extends JobService {
  static void a(c paramc, long paramLong, boolean paramBoolean, int paramInt) {
    long l;
    JobScheduler jobScheduler;
    Context context;
    if (paramc != null) {
      if (paramLong <= 0L)
        return; 
      context = b.B();
      if (context == null)
        return; 
      try {
        jobScheduler = (JobScheduler)context.getSystemService("jobscheduler");
      } finally {
        paramc = null;
        paramc.printStackTrace();
      } 
    } else {
      return;
    } 
    byte b = 2;
    if (paramInt == 0 || (paramBoolean && paramInt != 2)) {
      paramLong = 1000L;
      l = 0L;
    } else {
      l = 60000L + paramLong;
    } 
    JobInfo.Builder builder = (new JobInfo.Builder(paramc.g(), new ComponentName(context.getPackageName(), RetryJobSchedulerService.class.getName()))).setMinimumLatency(paramLong);
    if (paramBoolean) {
      paramInt = b;
    } else {
      paramInt = 1;
    } 
    builder = builder.setRequiredNetworkType(paramInt).setRequiresCharging(false).setRequiresDeviceIdle(false);
    if (l > 0L)
      builder.setOverrideDeadline(l); 
    paramInt = jobScheduler.schedule(builder.build());
    if (paramInt <= 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("schedule err errCode = ");
      stringBuilder.append(paramInt);
      a.d("RetrySchedulerService", stringBuilder.toString());
      return;
    } 
  }
  
  public void onCreate() {
    super.onCreate();
    b.a((Context)this);
  }
  
  public boolean onStartJob(JobParameters paramJobParameters) {
    if (paramJobParameters != null) {
      int i = paramJobParameters.getJobId();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onStartJob, id = ");
      stringBuilder.append(i);
      a.c("RetrySchedulerService", stringBuilder.toString());
      r.a().a(i);
    } 
    return false;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters) {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\RetryJobSchedulerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */