package com.blued.android.chat;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.heart.PingCheckerManager;

public class PingCheckerJobServer extends JobService implements PingCheckerManager.PingCheckerListener {
  private static final int IM_CHECK_JOB_ID = 108;
  
  private static final String TAG = "Chat_PingChecker";
  
  private Runnable finishJobTask;
  
  private JobParameters jobParams;
  
  private Handler uiHandler;
  
  public static void startServer(Context paramContext) {
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "start PingCheckerJobServer..."); 
    try {
      JobScheduler jobScheduler = (JobScheduler)paramContext.getSystemService("jobscheduler");
      JobInfo.Builder builder = new JobInfo.Builder(108, new ComponentName(paramContext, PingCheckerJobServer.class));
      builder.setRequiredNetworkType(1);
      builder.setPeriodic(300000L);
      int i = jobScheduler.schedule(builder.build());
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("start PingCheckerJobServer result:");
        stringBuilder.append(i);
        Log.v("Chat_PingChecker", stringBuilder.toString());
        return;
      } 
    } catch (Exception exception) {
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("start PingCheckerJobServer exception:");
        stringBuilder.append(exception);
        Log.v("Chat_PingChecker", stringBuilder.toString());
      } 
    } 
  }
  
  public static void stopServer(Context paramContext) {
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "stop PingCheckerJobServer..."); 
    try {
      ((JobScheduler)paramContext.getSystemService("jobscheduler")).cancel(108);
      return;
    } catch (Exception exception) {
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stop PingCheckerJobServer exception:");
        stringBuilder.append(exception);
        Log.v("Chat_PingChecker", stringBuilder.toString());
      } 
      return;
    } 
  }
  
  public void onCreate() {
    super.onCreate();
    this.uiHandler = new Handler();
    this.finishJobTask = new Runnable() {
        public void run() {
          if (PingCheckerJobServer.this.jobParams != null) {
            if (ChatManager.debug)
              Log.v("Chat_PingChecker", "jobFinished"); 
            PingCheckerJobServer pingCheckerJobServer = PingCheckerJobServer.this;
            pingCheckerJobServer.jobFinished(pingCheckerJobServer.jobParams, false);
          } 
        }
      };
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "pingCheckerJobServer.onDestroy()"); 
  }
  
  public void onPingCheckFinish() {
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "pingCheckerJobServer.onPingCheckFinish(), will finish job after 30s."); 
    this.uiHandler.postDelayed(this.finishJobTask, 30000L);
  }
  
  public boolean onStartJob(JobParameters paramJobParameters) {
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "pingCheckerJobServer.onStartJob()"); 
    this.uiHandler.removeCallbacks(this.finishJobTask);
    this.jobParams = paramJobParameters;
    return ChatManagerInner.isStopped() ? false : (!PingCheckerManager.getInstance().checkImLink(this));
  }
  
  public boolean onStopJob(JobParameters paramJobParameters) {
    if (ChatManager.debug)
      Log.v("Chat_PingChecker", "pingCheckerJobServer.onStopJob()"); 
    PingCheckerManager.getInstance().stopCheckImLink(this);
    this.uiHandler.removeCallbacks(this.finishJobTask);
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\PingCheckerJobServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */