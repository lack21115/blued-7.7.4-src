package com.huawei.android.hms.agent.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ApiClientMgr implements IActivityDestroyedCallback, IActivityPauseCallback, IActivityResumeCallback, HuaweiApiClient.ConnectionCallbacks, HuaweiApiClient.OnConnectionFailedListener {
  private static final int APICLIENT_CONNECT_TIMEOUT = 30000;
  
  private static final Object APICLIENT_LOCK;
  
  private static final int APICLIENT_STARTACTIVITY_TIMEOUT = 3000;
  
  private static final int APICLIENT_STARTACTIVITY_TIMEOUT_HANDLE_MSG = 4;
  
  private static final int APICLIENT_TIMEOUT_HANDLE_MSG = 3;
  
  private static final Object CALLBACK_LOCK;
  
  public static final ApiClientMgr INST = new ApiClientMgr();
  
  private static final int MAX_RESOLVE_TIMES = 3;
  
  private static final String PACKAGE_NAME_HIAPP = "com.huawei.appmarket";
  
  private static final Object STATIC_CALLBACK_LOCK;
  
  private static final int UPDATE_OVER_ACTIVITY_CHECK_TIMEOUT = 3000;
  
  private static final int UPDATE_OVER_ACTIVITY_CHECK_TIMEOUT_HANDLE_MSG = 5;
  
  private boolean allowResolveConnectError = false;
  
  private HuaweiApiClient apiClient;
  
  private List<IClientConnectCallback> connCallbacks = new ArrayList<IClientConnectCallback>();
  
  private Context context;
  
  private String curAppPackageName;
  
  private int curLeftResolveTimes = 3;
  
  private boolean hasOverActivity = false;
  
  private boolean isResolving;
  
  private BridgeActivity resolveActivity;
  
  private List<IClientConnectCallback> staticCallbacks = new ArrayList<IClientConnectCallback>();
  
  private Handler timeoutHandler = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message param1Message) {
          synchronized (ApiClientMgr.CALLBACK_LOCK) {
            boolean bool;
            if (!ApiClientMgr.this.connCallbacks.isEmpty()) {
              bool = true;
            } else {
              bool = false;
            } 
            if (param1Message != null && param1Message.what == 3 && bool) {
              HMSAgentLog.d("connect time out");
              ApiClientMgr.this.resetApiClient();
              ApiClientMgr.this.onConnectEnd(-1007);
              return true;
            } 
            if (param1Message != null && param1Message.what == 4 && bool) {
              HMSAgentLog.d("start activity time out");
              ApiClientMgr.this.onConnectEnd(-1007);
              return true;
            } 
            if (param1Message != null && param1Message.what == 5 && bool) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Discarded update dispose:hasOverActivity=");
              stringBuilder.append(ApiClientMgr.this.hasOverActivity);
              stringBuilder.append(" resolveActivity=");
              stringBuilder.append(StrUtils.objDesc(ApiClientMgr.this.resolveActivity));
              HMSAgentLog.d(stringBuilder.toString());
              if (ApiClientMgr.this.hasOverActivity && ApiClientMgr.this.resolveActivity != null && !ApiClientMgr.this.resolveActivity.isFinishing())
                ApiClientMgr.this.onResolveErrorRst(13); 
              return true;
            } 
            return false;
          } 
        }
      });
  
  static {
    CALLBACK_LOCK = new Object();
    STATIC_CALLBACK_LOCK = new Object();
    APICLIENT_LOCK = new Object();
  }
  
  private void aSysnCallback(final int rstCode, final IClientConnectCallback callback) {
    ThreadManager.a().a(new ThreadExecutor("aSysnCallback") {
          public void execute() {
            HuaweiApiClient huaweiApiClient = ApiClientMgr.this.getApiClient();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("callback connect: rst=");
            stringBuilder.append(rstCode);
            stringBuilder.append(" apiClient=");
            stringBuilder.append(huaweiApiClient);
            HMSAgentLog.d(stringBuilder.toString());
            callback.onConnect(rstCode, huaweiApiClient);
          }
        });
  }
  
  private static void disConnectClientDelay(final HuaweiApiClient clientTmp, int paramInt) {
    (new Handler()).postDelayed(new Runnable() {
          public void run() {
            clientTmp.disconnect();
          }
        },  paramInt);
  }
  
  private void onConnectEnd(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("connect end:");
    stringBuilder.append(paramInt);
    HMSAgentLog.d(stringBuilder.toString());
    synchronized (CALLBACK_LOCK) {
      null = this.connCallbacks.iterator();
      while (null.hasNext())
        aSysnCallback(paramInt, null.next()); 
      this.connCallbacks.clear();
      this.allowResolveConnectError = false;
      synchronized (STATIC_CALLBACK_LOCK) {
        null = this.staticCallbacks.iterator();
        while (null.hasNext())
          aSysnCallback(paramInt, null.next()); 
        this.staticCallbacks.clear();
        return;
      } 
    } 
  }
  
  private HuaweiApiClient resetApiClient() {
    if (this.context == null) {
      HMSAgentLog.e("HMSAgent not init");
      return null;
    } 
    synchronized (APICLIENT_LOCK) {
      if (this.apiClient != null)
        disConnectClientDelay(this.apiClient, 60000); 
      HMSAgentLog.d("reset client");
      this.apiClient = (new HuaweiApiClient.Builder(this.context)).addConnectionCallbacks(INST).addOnConnectionFailedListener(INST).build();
      return this.apiClient;
    } 
  }
  
  private void startConnect() {
    this.curLeftResolveTimes--;
    HMSAgentLog.d("start thread to connect");
    ThreadManager.a().a(new ThreadExecutor("startConnect") {
          public void execute() {
            HuaweiApiClient huaweiApiClient = ApiClientMgr.this.getApiClient();
            if (huaweiApiClient != null) {
              HMSAgentLog.d("connect");
              Activity activity = ActivityMgr.INST.getLastActivity();
              ApiClientMgr.this.timeoutHandler.sendEmptyMessageDelayed(3, 30000L);
              huaweiApiClient.connect(activity);
              return;
            } 
            HMSAgentLog.d("client is generate error");
            ApiClientMgr.this.onConnectEnd(-1002);
          }
        });
  }
  
  public void connect(IClientConnectCallback paramIClientConnectCallback, boolean paramBoolean) {
    if (this.context == null) {
      aSysnCallback(-1000, paramIClientConnectCallback);
      return;
    } 
    HuaweiApiClient huaweiApiClient = getApiClient();
    boolean bool = false;
    if (huaweiApiClient != null && huaweiApiClient.isConnected()) {
      HMSAgentLog.d("client is valid");
      aSysnCallback(0, paramIClientConnectCallback);
      return;
    } 
    synchronized (CALLBACK_LOCK) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("client is invalid：size=");
      stringBuilder.append(this.connCallbacks.size());
      HMSAgentLog.d(stringBuilder.toString());
      if (this.allowResolveConnectError || paramBoolean)
        bool = true; 
      this.allowResolveConnectError = bool;
      if (this.connCallbacks.isEmpty()) {
        this.connCallbacks.add(paramIClientConnectCallback);
        this.curLeftResolveTimes = 3;
        startConnect();
      } else {
        this.connCallbacks.add(paramIClientConnectCallback);
      } 
      return;
    } 
  }
  
  public HuaweiApiClient getApiClient() {
    synchronized (APICLIENT_LOCK) {
      HuaweiApiClient huaweiApiClient;
      if (this.apiClient != null) {
        huaweiApiClient = this.apiClient;
      } else {
        huaweiApiClient = resetApiClient();
      } 
      return huaweiApiClient;
    } 
  }
  
  public void init(Application paramApplication) {
    HMSAgentLog.d("init");
    this.context = paramApplication.getApplicationContext();
    this.curAppPackageName = paramApplication.getPackageName();
    ActivityMgr.INST.unRegisterActivitResumeEvent(this);
    ActivityMgr.INST.registerActivitResumeEvent(this);
    ActivityMgr.INST.unRegisterActivitPauseEvent(this);
    ActivityMgr.INST.registerActivitPauseEvent(this);
    ActivityMgr.INST.unRegisterActivitDestroyedEvent(this);
    ActivityMgr.INST.registerActivitDestroyedEvent(this);
  }
  
  public boolean isConnect(HuaweiApiClient paramHuaweiApiClient) {
    return (paramHuaweiApiClient != null && paramHuaweiApiClient.isConnected());
  }
  
  public void onActivityDestroyed(Activity paramActivity1, Activity paramActivity2) {
    if (paramActivity2 == null)
      resetApiClient(); 
  }
  
  void onActivityLunched() {
    HMSAgentLog.d("resolve onActivityLunched");
    this.timeoutHandler.removeMessages(4);
    this.isResolving = true;
  }
  
  public void onActivityPause(Activity paramActivity) {
    HuaweiApiClient huaweiApiClient = getApiClient();
    if (huaweiApiClient != null)
      huaweiApiClient.onPause(paramActivity); 
  }
  
  public void onActivityResume(Activity paramActivity) {
    HuaweiApiClient huaweiApiClient = getApiClient();
    if (huaweiApiClient != null) {
      HMSAgentLog.d("tell hmssdk: onResume");
      huaweiApiClient.onResume(paramActivity);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("is resolving:");
    stringBuilder.append(this.isResolving);
    HMSAgentLog.d(stringBuilder.toString());
    if (this.isResolving && !"com.huawei.appmarket".equals(this.curAppPackageName)) {
      if (paramActivity instanceof BridgeActivity) {
        this.resolveActivity = (BridgeActivity)paramActivity;
        this.hasOverActivity = false;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("received bridgeActivity:");
        stringBuilder1.append(StrUtils.objDesc(this.resolveActivity));
        HMSAgentLog.d(stringBuilder1.toString());
      } else {
        BridgeActivity bridgeActivity = this.resolveActivity;
        if (bridgeActivity != null && !bridgeActivity.isFinishing()) {
          this.hasOverActivity = true;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("received other Activity:");
          stringBuilder1.append(StrUtils.objDesc(this.resolveActivity));
          HMSAgentLog.d(stringBuilder1.toString());
        } 
      } 
      this.timeoutHandler.removeMessages(5);
      this.timeoutHandler.sendEmptyMessageDelayed(5, 3000L);
    } 
  }
  
  public void onConnected() {
    HMSAgentLog.d("connect success");
    this.timeoutHandler.removeMessages(3);
    onConnectEnd(0);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult) {
    this.timeoutHandler.removeMessages(3);
    if (paramConnectionResult == null) {
      HMSAgentLog.e("result is null");
      onConnectEnd(-1002);
      return;
    } 
    int i = paramConnectionResult.getErrorCode();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("errCode=");
    stringBuilder.append(i);
    stringBuilder.append(" allowResolve=");
    stringBuilder.append(this.allowResolveConnectError);
    HMSAgentLog.d(stringBuilder.toString());
    if (HuaweiApiAvailability.getInstance().isUserResolvableError(i) && this.allowResolveConnectError) {
      Activity activity = ActivityMgr.INST.getLastActivity();
      if (activity != null)
        try {
          this.timeoutHandler.sendEmptyMessageDelayed(4, 3000L);
          Intent intent = new Intent((Context)activity, HMSAgentActivity.class);
          intent.putExtra("HMSConnectionErrorCode", i);
          intent.putExtra("should_be_fullscreen", UIUtils.isActivityFullscreen(activity));
          activity.startActivity(intent);
          return;
        } catch (Exception exception) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("start HMSAgentActivity exception:");
          stringBuilder1.append(exception.getMessage());
          HMSAgentLog.e(stringBuilder1.toString());
          this.timeoutHandler.removeMessages(4);
          onConnectEnd(-1004);
          return;
        }  
      HMSAgentLog.d("no activity");
      onConnectEnd(-1001);
      return;
    } 
    onConnectEnd(i);
  }
  
  public void onConnectionSuspended(int paramInt) {
    HMSAgentLog.d("connect suspended");
    connect(new EmptyConnectCallback("onConnectionSuspended try end:"), true);
  }
  
  void onResolveErrorRst(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("result=");
    stringBuilder.append(paramInt);
    HMSAgentLog.d(stringBuilder.toString());
    this.isResolving = false;
    this.resolveActivity = null;
    this.hasOverActivity = false;
    if (paramInt == 0) {
      HuaweiApiClient huaweiApiClient = getApiClient();
      if (huaweiApiClient != null && !huaweiApiClient.isConnecting() && !huaweiApiClient.isConnected() && this.curLeftResolveTimes > 0) {
        startConnect();
        return;
      } 
    } 
    onConnectEnd(paramInt);
  }
  
  public void registerClientConnect(IClientConnectCallback paramIClientConnectCallback) {
    synchronized (STATIC_CALLBACK_LOCK) {
      this.staticCallbacks.add(paramIClientConnectCallback);
      return;
    } 
  }
  
  public void release() {
    HMSAgentLog.d("release");
    this.isResolving = false;
    this.resolveActivity = null;
    this.hasOverActivity = false;
    HuaweiApiClient huaweiApiClient = getApiClient();
    if (huaweiApiClient != null)
      huaweiApiClient.disconnect(); 
    synchronized (APICLIENT_LOCK) {
      this.apiClient = null;
      synchronized (STATIC_CALLBACK_LOCK) {
        this.staticCallbacks.clear();
        synchronized (CALLBACK_LOCK) {
          this.connCallbacks.clear();
          return;
        } 
      } 
    } 
  }
  
  public void removeClientConnectCallback(IClientConnectCallback paramIClientConnectCallback) {
    synchronized (STATIC_CALLBACK_LOCK) {
      this.staticCallbacks.remove(paramIClientConnectCallback);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\ApiClientMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */