package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.Map;

public class WBAgent {
  public static final String TAG = "WBAgent";
  
  public static void onEvent(Object paramObject, String paramString) {
    onEvent(paramObject, paramString, null);
  }
  
  public static void onEvent(Object paramObject, String paramString, Map<String, String> paramMap) {
    if (paramObject == null) {
      LogUtil.e("WBAgent", "unexpected null page or activity in onEvent");
      return;
    } 
    if (paramString == null) {
      LogUtil.e("WBAgent", "unexpected null eventId in onEvent");
      return;
    } 
    Object object = paramObject;
    if (paramObject instanceof Context)
      object = paramObject.getClass().getName(); 
    WBAgentHandler.getInstance().onEvent((String)object, paramString, paramMap);
  }
  
  public static void onKillProcess() {
    WBAgentHandler.getInstance().onKillProcess();
  }
  
  public static void onPageEnd(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      WBAgentHandler.getInstance().onPageEnd(paramString); 
  }
  
  public static void onPageStart(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      WBAgentHandler.getInstance().onPageStart(paramString); 
  }
  
  public static void onPause(Context paramContext) {
    if (paramContext == null) {
      LogUtil.e("WBAgent", "unexpected null context in onResume");
      return;
    } 
    WBAgentHandler.getInstance().onPause(paramContext);
  }
  
  public static void onResume(Context paramContext) {
    if (paramContext == null) {
      LogUtil.e("WBAgent", "unexpected null context in onResume");
      return;
    } 
    WBAgentHandler.getInstance().onResume(paramContext);
  }
  
  public static void onStop(Context paramContext) {
    if (paramContext == null) {
      LogUtil.e("WBAgent", "unexpected null context in onStop");
      return;
    } 
    WBAgentHandler.getInstance().onStop(paramContext);
  }
  
  public static void openActivityDurationTrack(boolean paramBoolean) {
    StatisticConfig.ACTIVITY_DURATION_OPEN = paramBoolean;
  }
  
  public static void setAppKey(String paramString) {
    StatisticConfig.setAppkey(paramString);
  }
  
  public static void setChannel(String paramString) {
    StatisticConfig.setChannel(paramString);
  }
  
  public static void setDebugMode(boolean paramBoolean1, boolean paramBoolean2) {
    LogUtil.sIsLogEnable = paramBoolean1;
    StatisticConfig.setNeedGizp(paramBoolean2);
  }
  
  public static void setForceUploadInterval(long paramLong) {
    StatisticConfig.setForceUploadInterval(paramLong);
  }
  
  public static void setNeedGzip(boolean paramBoolean) {
    StatisticConfig.setNeedGizp(paramBoolean);
  }
  
  public static void setSessionContinueMillis(long paramLong) {
    StatisticConfig.kContinueSessionMillis = paramLong;
  }
  
  public static void setUploadInterval(long paramLong) throws Exception {
    StatisticConfig.setUploadInterval(paramLong);
  }
  
  public static void uploadAppLogs(Context paramContext) {
    if (paramContext == null) {
      LogUtil.e("WBAgent", "unexpected null context in uploadAppLogs");
      return;
    } 
    WBAgentHandler.getInstance().uploadAppLogs(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\WBAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */