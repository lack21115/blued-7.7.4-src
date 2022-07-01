package com.sina.weibo.sdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

class WBAgentHandler {
  private static int MAX_CACHE_SIZE = 5;
  
  private static List<PageLog> mActivePages;
  
  private static WBAgentHandler mInstance;
  
  private static Map<String, PageLog> mPages;
  
  private static Timer mTimer;
  
  private WBAgentHandler() {
    mActivePages = new ArrayList<PageLog>();
    mPages = new HashMap<String, PageLog>();
    LogUtil.i("WBAgent", "init handler");
  }
  
  private void checkAppStatus(Context paramContext) {
    if (isBackground(paramContext)) {
      saveActivePages(mActivePages);
      mActivePages.clear();
    } 
  }
  
  private void checkNewSession(Context paramContext, long paramLong) {
    if (PageLog.isNewSession(paramContext, paramLong)) {
      List<PageLog> list;
      StringBuilder stringBuilder;
      PageLog pageLog = new PageLog(paramContext);
      pageLog.setType(LogType.SESSION_END);
      null = new PageLog(paramContext, paramLong);
      null.setType(LogType.SESSION_START);
      synchronized (mActivePages) {
        if (pageLog.getEndTime() > 0L) {
          mActivePages.add(pageLog);
        } else {
          LogUtil.d("WBAgent", "is a new install");
        } 
        mActivePages.add(null);
        stringBuilder = new StringBuilder("last session--- starttime:");
        stringBuilder.append(pageLog.getStartTime());
        stringBuilder.append(" ,endtime:");
        stringBuilder.append(pageLog.getEndTime());
        LogUtil.d("WBAgent", stringBuilder.toString());
        StringBuilder stringBuilder1 = new StringBuilder("is a new session--- starttime:");
        stringBuilder1.append(null.getStartTime());
        LogUtil.d("WBAgent", stringBuilder1.toString());
        return;
      } 
    } 
    LogUtil.i("WBAgent", "is not a new session");
  }
  
  private void closeTimer() {
    Timer timer = mTimer;
    if (timer != null)
      timer.cancel(); 
  }
  
  public static WBAgentHandler getInstance() {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/statistic/WBAgentHandler
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/statistic/WBAgentHandler.mInstance : Lcom/sina/weibo/sdk/statistic/WBAgentHandler;
    //   6: ifnonnull -> 19
    //   9: new com/sina/weibo/sdk/statistic/WBAgentHandler
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/sina/weibo/sdk/statistic/WBAgentHandler.mInstance : Lcom/sina/weibo/sdk/statistic/WBAgentHandler;
    //   19: getstatic com/sina/weibo/sdk/statistic/WBAgentHandler.mInstance : Lcom/sina/weibo/sdk/statistic/WBAgentHandler;
    //   22: astore_0
    //   23: ldc com/sina/weibo/sdk/statistic/WBAgentHandler
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/sina/weibo/sdk/statistic/WBAgentHandler
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private String getLogsInMemory() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc ''
    //   4: astore_1
    //   5: getstatic com/sina/weibo/sdk/statistic/WBAgentHandler.mActivePages : Ljava/util/List;
    //   8: invokeinterface size : ()I
    //   13: ifle -> 31
    //   16: getstatic com/sina/weibo/sdk/statistic/WBAgentHandler.mActivePages : Ljava/util/List;
    //   19: invokestatic getPageLogs : (Ljava/util/List;)Ljava/lang/String;
    //   22: astore_1
    //   23: getstatic com/sina/weibo/sdk/statistic/WBAgentHandler.mActivePages : Ljava/util/List;
    //   26: invokeinterface clear : ()V
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   5	31	35	finally
  }
  
  private boolean isBackground(Context paramContext) {
    Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (true) {
      if (!iterator.hasNext())
        return false; 
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
      if (runningAppProcessInfo.processName.equals(paramContext.getPackageName())) {
        if (runningAppProcessInfo.importance == 400) {
          StringBuilder stringBuilder1 = new StringBuilder("后台:");
          stringBuilder1.append(runningAppProcessInfo.processName);
          LogUtil.i("WBAgent", stringBuilder1.toString());
          return true;
        } 
        StringBuilder stringBuilder = new StringBuilder("前台:");
        stringBuilder.append(runningAppProcessInfo.processName);
        LogUtil.i("WBAgent", stringBuilder.toString());
        return false;
      } 
    } 
  }
  
  private void saveActivePages(List<PageLog> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/sina/weibo/sdk/statistic/WBAgentHandler$2
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic getPageLogs : (Ljava/util/List;)Ljava/lang/String;
    //   11: invokespecial <init> : (Lcom/sina/weibo/sdk/statistic/WBAgentHandler;Ljava/lang/String;)V
    //   14: invokestatic execute : (Ljava/lang/Runnable;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  private Timer timerTask(final Context context, long paramLong1, long paramLong2) {
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        public void run() {
          LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
        }
      };
    if (paramLong2 == 0L) {
      timer.schedule(timerTask, paramLong1);
      return timer;
    } 
    timer.schedule(timerTask, paramLong1, paramLong2);
    return timer;
  }
  
  public void onEvent(String paramString1, String paramString2, Map<String, String> paramMap) {
    List<PageLog> list;
    StringBuilder stringBuilder;
    EventLog eventLog = new EventLog(paramString1, paramString2, paramMap);
    eventLog.setType(LogType.EVENT);
    synchronized (mActivePages) {
      StringBuilder stringBuilder1;
      mActivePages.add(eventLog);
      if (paramMap == null) {
        stringBuilder1 = new StringBuilder("event--- page:");
        stringBuilder1.append(paramString1);
        stringBuilder1.append(" ,event name:");
        stringBuilder1.append(paramString2);
        LogUtil.d("WBAgent", stringBuilder1.toString());
      } else {
        stringBuilder = new StringBuilder("event--- page:");
        stringBuilder.append(paramString1);
        stringBuilder.append(" ,event name:");
        stringBuilder.append(paramString2);
        stringBuilder.append(" ,extend:");
        stringBuilder.append(stringBuilder1.toString());
        LogUtil.d("WBAgent", stringBuilder.toString());
      } 
      if (mActivePages.size() >= MAX_CACHE_SIZE) {
        saveActivePages(mActivePages);
        mActivePages.clear();
      } 
      return;
    } 
  }
  
  public void onKillProcess() {
    LogUtil.i("WBAgent", "save applogs and close timer and shutdown thread executor");
    saveActivePages(mActivePages);
    mInstance = null;
    closeTimer();
    WBAgentExecutor.shutDownExecutor();
  }
  
  public void onPageEnd(String paramString) {
    if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
      if (mPages.containsKey(paramString)) {
        PageLog pageLog = mPages.get(paramString);
        pageLog.setDuration(System.currentTimeMillis() - pageLog.getStartTime());
        synchronized (mActivePages) {
          mActivePages.add(pageLog);
          synchronized (mPages) {
            mPages.remove(paramString);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString));
            stringBuilder.append(", ");
            stringBuilder.append(pageLog.getStartTime() / 1000L);
            stringBuilder.append(", ");
            stringBuilder.append(pageLog.getDuration() / 1000L);
            LogUtil.d("WBAgent", stringBuilder.toString());
          } 
        } 
      } else {
        LogUtil.e("WBAgent", "please call onPageStart before onPageEnd");
      } 
      if (mActivePages.size() >= MAX_CACHE_SIZE) {
        saveActivePages(mActivePages);
        mActivePages.clear();
      } 
    } 
  }
  
  public void onPageStart(String paramString) {
    if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
      PageLog pageLog = new PageLog(paramString);
      pageLog.setType(LogType.FRAGMENT);
      synchronized (mPages) {
        mPages.put(paramString, pageLog);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString));
        stringBuilder.append(", ");
        stringBuilder.append(pageLog.getStartTime() / 1000L);
        LogUtil.d("WBAgent", stringBuilder.toString());
        return;
      } 
    } 
  }
  
  public void onPause(Context paramContext) {
    long l = System.currentTimeMillis();
    String str = paramContext.getClass().getName();
    StringBuilder stringBuilder = new StringBuilder("update last page endtime:");
    stringBuilder.append(l / 1000L);
    LogUtil.i("WBAgent", stringBuilder.toString());
    PageLog.updateSession(paramContext, null, Long.valueOf(0L), Long.valueOf(l));
    if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
      if (mPages.containsKey(str)) {
        PageLog pageLog = mPages.get(str);
        pageLog.setDuration(l - pageLog.getStartTime());
        synchronized (mActivePages) {
          mActivePages.add(pageLog);
          synchronized (mPages) {
            mPages.remove(str);
            StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str));
            stringBuilder1.append(", ");
            stringBuilder1.append(pageLog.getStartTime() / 1000L);
            stringBuilder1.append(", ");
            stringBuilder1.append(pageLog.getDuration() / 1000L);
            LogUtil.d("WBAgent", stringBuilder1.toString());
          } 
        } 
      } else {
        LogUtil.e("WBAgent", "please call onResume before onPause");
      } 
      if (mActivePages.size() >= MAX_CACHE_SIZE) {
        saveActivePages(mActivePages);
        mActivePages.clear();
      } 
    } 
    checkAppStatus(paramContext);
  }
  
  public void onResume(Context paramContext) {
    if (LogReport.getPackageName() == null)
      LogReport.setPackageName(paramContext.getPackageName()); 
    if (mTimer == null)
      mTimer = timerTask(paramContext, 500L, StatisticConfig.getUploadInterval()); 
    long l = System.currentTimeMillis();
    String str = paramContext.getClass().getName();
    checkNewSession(paramContext, l);
    if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
      PageLog pageLog = new PageLog(str, l);
      pageLog.setType(LogType.ACTIVITY);
      synchronized (mPages) {
        mPages.put(str, pageLog);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str));
    stringBuilder.append(", ");
    stringBuilder.append(l / 1000L);
    LogUtil.d("WBAgent", stringBuilder.toString());
  }
  
  public void onStop(Context paramContext) {
    checkAppStatus(paramContext);
  }
  
  public void uploadAppLogs(final Context context) {
    long l = System.currentTimeMillis() - LogReport.getTime(context);
    if (LogReport.getTime(context) > 0L && l < 30000L) {
      timerTask(context, 30000L - l, 0L);
      return;
    } 
    WBAgentExecutor.execute(new Runnable() {
          public void run() {
            LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\WBAgentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */