package org.chromium.android_webview.services;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import org.chromium.build.BuildHooksAndroid;
import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

@TargetApi(21)
public class AwVariationsSeedFetcher extends JobService {
  private static final long MIN_JOB_PERIOD_MILLIS = 0L;
  
  private static VariationsSeedFetcher sMockDownloader;
  
  private static JobScheduler sMockJobScheduler;
  
  private AwVariationsSeedFetcher$FetchTask mFetchTask;
  
  private VariationsSeedHolder mSeedHolder;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void scheduleIfNeeded() {
    // Byte code:
    //   0: getstatic org/chromium/android_webview/services/AwVariationsSeedFetcher.sMockJobScheduler : Landroid/app/job/JobScheduler;
    //   3: ifnull -> 13
    //   6: getstatic org/chromium/android_webview/services/AwVariationsSeedFetcher.sMockJobScheduler : Landroid/app/job/JobScheduler;
    //   9: astore_3
    //   10: goto -> 25
    //   13: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   16: ldc 'jobscheduler'
    //   18: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast android/app/job/JobScheduler
    //   24: astore_3
    //   25: getstatic android/os/Build$VERSION.SDK_INT : I
    //   28: bipush #24
    //   30: if_icmpge -> 85
    //   33: aload_3
    //   34: invokevirtual getAllPendingJobs : ()Ljava/util/List;
    //   37: invokeinterface iterator : ()Ljava/util/Iterator;
    //   42: astore #4
    //   44: aload #4
    //   46: invokeinterface hasNext : ()Z
    //   51: ifeq -> 80
    //   54: aload #4
    //   56: invokeinterface next : ()Ljava/lang/Object;
    //   61: checkcast android/app/job/JobInfo
    //   64: astore_2
    //   65: aload_2
    //   66: invokevirtual getId : ()I
    //   69: bipush #83
    //   71: if_icmpne -> 77
    //   74: goto -> 92
    //   77: goto -> 44
    //   80: aconst_null
    //   81: astore_2
    //   82: goto -> 92
    //   85: aload_3
    //   86: bipush #83
    //   88: invokevirtual getPendingJob : (I)Landroid/app/job/JobInfo;
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull -> 97
    //   96: return
    //   97: invokestatic getStampFile : ()Ljava/io/File;
    //   100: invokevirtual lastModified : ()J
    //   103: lstore_0
    //   104: lload_0
    //   105: lconst_0
    //   106: lcmp
    //   107: ifeq -> 130
    //   110: new java/util/Date
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: invokevirtual getTime : ()J
    //   120: lload_0
    //   121: getstatic org/chromium/android_webview/services/AwVariationsSeedFetcher.MIN_JOB_PERIOD_MILLIS : J
    //   124: ladd
    //   125: lcmp
    //   126: ifge -> 130
    //   129: return
    //   130: aload_3
    //   131: new android/app/job/JobInfo$Builder
    //   134: dup
    //   135: bipush #83
    //   137: new android/content/ComponentName
    //   140: dup
    //   141: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   144: ldc org/chromium/android_webview/services/AwVariationsSeedFetcher
    //   146: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   149: invokespecial <init> : (ILandroid/content/ComponentName;)V
    //   152: iconst_1
    //   153: invokevirtual setRequiredNetworkType : (I)Landroid/app/job/JobInfo$Builder;
    //   156: iconst_1
    //   157: invokevirtual setRequiresCharging : (Z)Landroid/app/job/JobInfo$Builder;
    //   160: invokevirtual build : ()Landroid/app/job/JobInfo;
    //   163: invokevirtual schedule : (Landroid/app/job/JobInfo;)I
    //   166: iconst_1
    //   167: if_icmpeq -> 181
    //   170: ldc 'AwVariationsSeedFet-'
    //   172: ldc 'Failed to schedule job'
    //   174: iconst_0
    //   175: anewarray java/lang/Object
    //   178: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: return
  }
  
  public Context createConfigurationContext(Configuration paramConfiguration) {
    if (Build.VERSION.SDK_INT < 17)
      return null; 
    if (!BuildHooksAndroid.isEnabled())
      return super.createConfigurationContext(paramConfiguration); 
    super.createConfigurationContext(paramConfiguration);
    return BuildHooksAndroid.createConfigurationContext$6263c3eb();
  }
  
  public AssetManager getAssets() {
    return !BuildHooksAndroid.isEnabled() ? super.getAssets() : BuildHooksAndroid.getAssets$49f66a90();
  }
  
  public Resources getResources() {
    return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources$177d0c3c();
  }
  
  public Resources.Theme getTheme() {
    return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme$21e91261();
  }
  
  protected final void jobFinished(JobParameters paramJobParameters) {
    assert false;
    throw new AssertionError();
  }
  
  public void onCreate() {
    super.onCreate();
    ServiceInit.init(getApplicationContext());
    this.mSeedHolder = VariationsSeedHolder.getInstance();
  }
  
  public boolean onStartJob(JobParameters paramJobParameters) {
    this.mFetchTask = new AwVariationsSeedFetcher$FetchTask(this, paramJobParameters);
    this.mFetchTask.execute((Object[])new Void[0]);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters) {
    if (this.mFetchTask != null) {
      this.mFetchTask.cancel(true);
      this.mFetchTask = null;
    } 
    return false;
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\AwVariationsSeedFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */