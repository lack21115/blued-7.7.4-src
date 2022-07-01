package com.huawei.android.hms.agent;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.blued.android.core.AppMethods;
import com.huawei.android.hms.agent.common.ActivityMgr;
import com.huawei.android.hms.agent.common.ApiClientMgr;
import com.huawei.android.hms.agent.common.CheckUpdateApi;
import com.huawei.android.hms.agent.common.HMSAgentLog;
import com.huawei.android.hms.agent.common.IClientConnectCallback;
import com.huawei.android.hms.agent.common.INoProguard;
import com.huawei.android.hms.agent.common.handler.CheckUpdateHandler;
import com.huawei.android.hms.agent.common.handler.ConnectHandler;
import com.huawei.android.hms.agent.push.DeleteTokenApi;
import com.huawei.android.hms.agent.push.EnableReceiveNormalMsgApi;
import com.huawei.android.hms.agent.push.EnableReceiveNotifyMsgApi;
import com.huawei.android.hms.agent.push.GetPushStateApi;
import com.huawei.android.hms.agent.push.GetTokenApi;
import com.huawei.android.hms.agent.push.QueryAgreementApi;
import com.huawei.android.hms.agent.push.handler.DeleteTokenHandler;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNormalMsgHandler;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNotifyMsgHandler;
import com.huawei.android.hms.agent.push.handler.GetPushStateHandler;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.huawei.android.hms.agent.push.handler.QueryAgreementHandler;
import com.huawei.hms.api.HuaweiApiClient;

public final class HMSAgent implements INoProguard {
  public static final String CURVER = "020603300";
  
  private static final String VER_020503001 = "020503001";
  
  private static final String VER_020600001 = "020600001";
  
  private static final String VER_020600200 = "020600200";
  
  private static final String VER_020601002 = "020601002";
  
  private static final String VER_020601302 = "020601302";
  
  private static final String VER_020603300 = "020603300";
  
  private static boolean checkSDKVersion(Context paramContext) {
    long l = Long.parseLong("020603300") / 1000L;
    if (50004L != l) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error: HMSAgent major version code (");
      stringBuilder.append(l);
      stringBuilder.append(") does not match HMSSDK major version code (");
      stringBuilder.append(50004L);
      stringBuilder.append(")");
      String str = stringBuilder.toString();
      HMSAgentLog.e(str);
      AppMethods.a(str);
      return false;
    } 
    return true;
  }
  
  public static void checkUpdate(Activity paramActivity, CheckUpdateHandler paramCheckUpdateHandler) {
    (new CheckUpdateApi()).checkUpdate(paramActivity, paramCheckUpdateHandler);
  }
  
  public static void connect(Activity paramActivity, final ConnectHandler callback) {
    HMSAgentLog.i("start connect");
    ApiClientMgr.INST.connect(new IClientConnectCallback() {
          public void onConnect(final int rst, HuaweiApiClient param1HuaweiApiClient) {
            if (callback != null)
              (new Handler(Looper.getMainLooper())).post(new Runnable() {
                    public void run() {
                      callback.onConnect(rst);
                    }
                  },  ); 
          }
        },  true);
  }
  
  public static void destroy() {
    HMSAgentLog.i("destroy HMSAgent");
    ActivityMgr.INST.release();
    ApiClientMgr.INST.release();
  }
  
  public static boolean init(Activity paramActivity) {
    return init(null, paramActivity);
  }
  
  public static boolean init(Application paramApplication) {
    return init(paramApplication, null);
  }
  
  public static boolean init(Application paramApplication, Activity paramActivity) {
    if (paramApplication == null && paramActivity == null) {
      HMSAgentLog.e("the param of method HMSAgent.init can not be null !!!");
      return false;
    } 
    Application application = paramApplication;
    if (paramApplication == null)
      application = paramActivity.getApplication(); 
    if (application == null) {
      HMSAgentLog.e("the param of method HMSAgent.init app can not be null !!!");
      return false;
    } 
    Activity activity = paramActivity;
    if (paramActivity != null) {
      activity = paramActivity;
      if (paramActivity.isFinishing())
        activity = null; 
    } 
    if (!checkSDKVersion((Context)application))
      return false; 
    HMSAgentLog.i("init HMSAgent 020603300 with hmssdkver 50004301");
    ActivityMgr.INST.init(application, activity);
    ApiClientMgr.INST.init(application);
    return true;
  }
  
  public static final class AgentResultCode {
    public static final int APICLIENT_TIMEOUT = -1007;
    
    public static final int CALL_EXCEPTION = -1008;
    
    public static final int EMPTY_PARAM = -1009;
    
    public static final int HMSAGENT_NO_INIT = -1000;
    
    public static final int HMSAGENT_SUCCESS = 0;
    
    public static final int NO_ACTIVITY_FOR_USE = -1001;
    
    public static final int ON_ACTIVITY_RESULT_ERROR = -1005;
    
    public static final int REQUEST_REPEATED = -1006;
    
    public static final int RESULT_IS_NULL = -1002;
    
    public static final int START_ACTIVITY_ERROR = -1004;
    
    public static final int STATUS_IS_NULL = -1003;
  }
  
  public static final class Push {
    public static void deleteToken(String param1String, DeleteTokenHandler param1DeleteTokenHandler) {
      (new DeleteTokenApi()).deleteToken(param1String, param1DeleteTokenHandler);
    }
    
    public static void enableReceiveNormalMsg(boolean param1Boolean, EnableReceiveNormalMsgHandler param1EnableReceiveNormalMsgHandler) {
      (new EnableReceiveNormalMsgApi()).enableReceiveNormalMsg(param1Boolean, param1EnableReceiveNormalMsgHandler);
    }
    
    public static void enableReceiveNotifyMsg(boolean param1Boolean, EnableReceiveNotifyMsgHandler param1EnableReceiveNotifyMsgHandler) {
      (new EnableReceiveNotifyMsgApi()).enableReceiveNotifyMsg(param1Boolean, param1EnableReceiveNotifyMsgHandler);
    }
    
    public static void getPushState(GetPushStateHandler param1GetPushStateHandler) {
      (new GetPushStateApi()).getPushState(param1GetPushStateHandler);
    }
    
    public static void getToken(GetTokenHandler param1GetTokenHandler) {
      (new GetTokenApi()).getToken(param1GetTokenHandler);
    }
    
    public static void queryAgreement(QueryAgreementHandler param1QueryAgreementHandler) {
      (new QueryAgreementApi()).queryAgreement(param1QueryAgreementHandler);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\HMSAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */