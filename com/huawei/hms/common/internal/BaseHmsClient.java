package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.PackageNameManager;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseHmsClient implements AidlApiClient {
  private static final int BINDING = 5;
  
  private static final int CONNECTED = 3;
  
  private static final int DISCONNECTED = 1;
  
  private static final int DISCONNECTING = 4;
  
  private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
  
  private static final int MSG_CONN_TIMEOUT = 2;
  
  private static final String TAG = "BaseHmsClient";
  
  private String mAppID;
  
  private BinderAdapter mBinderAdapter;
  
  private final ClientSettings mClientSettings;
  
  private final AtomicInteger mConnStatus = new AtomicInteger(1);
  
  private Handler mConnectTimeoutHandler = null;
  
  private final ConnectionCallbacks mConnectionCallbacks;
  
  private final OnConnectionFailedListener mConnectionFailedListener;
  
  private final Context mContext;
  
  private volatile d mService;
  
  protected String sessionId;
  
  public BaseHmsClient(Context paramContext, ClientSettings paramClientSettings, OnConnectionFailedListener paramOnConnectionFailedListener, ConnectionCallbacks paramConnectionCallbacks) {
    this.mContext = paramContext;
    this.mClientSettings = paramClientSettings;
    this.mAppID = this.mClientSettings.getAppID();
    this.mConnectionFailedListener = paramOnConnectionFailedListener;
    this.mConnectionCallbacks = paramConnectionCallbacks;
  }
  
  private void bindCoreService() {
    String str2 = this.mClientSettings.getInnerHmsPkg();
    HMSPackageManager.getInstance(this.mContext).refresh();
    String str1 = str2;
    if ("com.huawei.hms".equals(str2))
      str1 = HMSPackageManager.getInstance(this.mContext).getHMSPackageName(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enter bindCoreService, packageName is ");
    stringBuilder.append(str1);
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    this.mBinderAdapter = new BinderAdapter(this.mContext, getServiceAction(), str1);
    this.mBinderAdapter.binder(new BinderAdapter.BinderCallBack() {
          public void onBinderFailed(int param1Int) {
            onBinderFailed(param1Int, null);
          }
          
          public void onBinderFailed(int param1Int, Intent param1Intent) {
            if (param1Intent != null) {
              Activity activity = BaseHmsClient.this.mClientSettings.getCpActivity();
              if (activity != null) {
                HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                activity.startActivity(param1Intent);
                return;
              } 
              HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
              PendingIntent pendingIntent = PendingIntent.getActivity(BaseHmsClient.this.mContext, 11, param1Intent, 134217728);
              BaseHmsClient.this.notifyFailed(new ConnectionResult(10, pendingIntent));
              BaseHmsClient.access$002(BaseHmsClient.this, null);
              return;
            } 
            HMSLog.i("BaseHmsClient", "onBinderFailed: pendingIntent is null!");
            BaseHmsClient.this.notifyFailed(new ConnectionResult(10, null));
            BaseHmsClient.access$002(BaseHmsClient.this, null);
          }
          
          public void onNullBinding(ComponentName param1ComponentName) {
            BaseHmsClient.this.setConnectStatus(1);
            BaseHmsClient.this.notifyFailed(10);
          }
          
          public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
            HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
            BaseHmsClient.access$002(BaseHmsClient.this, d.a.a(param1IBinder));
            if (BaseHmsClient.this.mService == null) {
              HMSLog.e("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
              BaseHmsClient.this.mBinderAdapter.unBind();
              BaseHmsClient.this.setConnectStatus(1);
              BaseHmsClient.this.notifyFailed(10);
              return;
            } 
            BaseHmsClient.this.onConnecting();
          }
          
          public void onServiceDisconnected(ComponentName param1ComponentName) {
            HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
            BaseHmsClient.this.setConnectStatus(1);
            if (BaseHmsClient.this.mConnectionCallbacks != null)
              BaseHmsClient.this.mConnectionCallbacks.onConnectionSuspended(1); 
          }
        });
  }
  
  private void cancelConnDelayHandle() {
    synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
      if (this.mConnectTimeoutHandler != null) {
        this.mConnectTimeoutHandler.removeMessages(2);
        this.mConnectTimeoutHandler = null;
      } 
      return;
    } 
  }
  
  private void checkAvailabilityAndConnect(int paramInt, boolean paramBoolean) {
    HMSLog.i("BaseHmsClient", "====== HMSSDK version: 50004301 ======");
    int i = this.mConnStatus.get();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter connect, Connection Status: ");
    stringBuilder.append(i);
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    if (!paramBoolean && (i == 3 || i == 5 || i == 4))
      return; 
    setConnectStatus(5);
    i = paramInt;
    if (getMinApkVersion() > paramInt)
      i = getMinApkVersion(); 
    stringBuilder = new StringBuilder();
    stringBuilder.append("connect minVersion:");
    stringBuilder.append(i);
    stringBuilder.append(" packageName:");
    stringBuilder.append(this.mClientSettings.getInnerHmsPkg());
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    if (this.mContext.getPackageName().equals(this.mClientSettings.getInnerHmsPkg())) {
      HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
      bindCoreService();
      return;
    } 
    if (Util.isAvailableLibExist(this.mContext)) {
      AvailableAdapter availableAdapter = new AvailableAdapter(i);
      paramInt = availableAdapter.isHuaweiMobileServicesAvailable(this.mContext);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("check available result: ");
      stringBuilder2.append(paramInt);
      HMSLog.i("BaseHmsClient", stringBuilder2.toString());
      if (paramInt == 0) {
        bindCoreService();
        return;
      } 
      if (availableAdapter.isUserResolvableError(paramInt)) {
        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
        resolution(availableAdapter, paramInt);
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("bindCoreService3.0 fail: ");
      stringBuilder1.append(paramInt);
      stringBuilder1.append(" is not resolvable.");
      HMSLog.i("BaseHmsClient", stringBuilder1.toString());
      notifyFailed(paramInt);
      return;
    } 
    paramInt = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.mContext, i);
    stringBuilder = new StringBuilder();
    stringBuilder.append("HuaweiApiAvailability check available result: ");
    stringBuilder.append(paramInt);
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    if (paramInt == 0) {
      bindCoreService();
      return;
    } 
    notifyFailed(paramInt);
  }
  
  private void notifyFailed(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyFailed result: ");
    stringBuilder.append(paramInt);
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
    if (onConnectionFailedListener != null)
      onConnectionFailedListener.onConnectionFailed(new ConnectionResult(paramInt)); 
  }
  
  private void notifyFailed(ConnectionResult paramConnectionResult) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyFailed result: ");
    stringBuilder.append(paramConnectionResult.getErrorCode());
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
    if (onConnectionFailedListener != null)
      onConnectionFailedListener.onConnectionFailed(paramConnectionResult); 
  }
  
  private void onDisconnectionResult(ResolveResult<DisconnectResp> paramResolveResult) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter onDisconnectionResult, disconnect from server result: ");
    stringBuilder.append(paramResolveResult.getStatus().getStatusCode());
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    this.mBinderAdapter.unBind();
    setConnectStatus(1);
  }
  
  private void resolution(AvailableAdapter paramAvailableAdapter, int paramInt) {
    HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
    if (!getClientSettings().isHasActivity()) {
      PackageNameManager.getInstance(this.mContext).queryPackageName(new VoidOnConnectionFailed(paramInt));
      return;
    } 
    Activity activity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
    if (activity != null) {
      paramAvailableAdapter.startResolution(activity, new AvailableAdapter.AvailableCallBack() {
            public void onComplete(int param1Int) {
              if (param1Int == 0) {
                BaseHmsClient.this.bindCoreService();
                return;
              } 
              BaseHmsClient.this.notifyFailed(param1Int);
            }
          });
      return;
    } 
    notifyFailed(26);
  }
  
  private void setConnectStatus(int paramInt) {
    this.mConnStatus.set(paramInt);
  }
  
  protected final void checkConnected() {
    if (isConnected())
      return; 
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public void connect(int paramInt) {
    checkAvailabilityAndConnect(paramInt, false);
  }
  
  public void connect(int paramInt, boolean paramBoolean) {
    checkAvailabilityAndConnect(paramInt, paramBoolean);
  }
  
  protected final void connectionConnected() {
    setConnectStatus(3);
    ConnectionCallbacks connectionCallbacks = this.mConnectionCallbacks;
    if (connectionCallbacks != null)
      connectionCallbacks.onConnected(); 
  }
  
  public void disconnect() {
    int i = this.mConnStatus.get();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter disconnect, Connection Status: ");
    stringBuilder.append(i);
    HMSLog.i("BaseHmsClient", stringBuilder.toString());
    if (i != 1)
      if (i != 3) {
        if (i != 4) {
          if (i != 5)
            return; 
          cancelConnDelayHandle();
          setConnectStatus(4);
          return;
        } 
      } else {
        BinderAdapter binderAdapter = this.mBinderAdapter;
        if (binderAdapter != null)
          binderAdapter.unBind(); 
        setConnectStatus(1);
      }  
  }
  
  public List<String> getApiNameList() {
    return this.mClientSettings.getApiName();
  }
  
  public String getAppID() {
    return this.mAppID;
  }
  
  protected ClientSettings getClientSettings() {
    return this.mClientSettings;
  }
  
  public Context getContext() {
    return this.mContext;
  }
  
  public String getCpID() {
    return this.mClientSettings.getCpID();
  }
  
  @Deprecated
  public int getMinApkVersion() {
    return 30000000;
  }
  
  public String getPackageName() {
    return this.mClientSettings.getClientPackageName();
  }
  
  public d getService() {
    return this.mService;
  }
  
  public String getServiceAction() {
    return "com.huawei.hms.core.aidlservice";
  }
  
  public String getSessionId() {
    return this.sessionId;
  }
  
  public SubAppInfo getSubAppInfo() {
    return this.mClientSettings.getSubAppID();
  }
  
  public String getTransportName() {
    return IPCTransport.class.getName();
  }
  
  public boolean isConnected() {
    return (this.mConnStatus.get() == 3 || this.mConnStatus.get() == 4);
  }
  
  public boolean isConnecting() {
    return (this.mConnStatus.get() == 5);
  }
  
  public void onConnecting() {
    connectionConnected();
  }
  
  public static interface ConnectionCallbacks {
    public static final int CAUSE_API_CLIENT_EXPIRED = 3;
    
    public static final int CAUSE_NETWORK_LOST = 2;
    
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    void onConnected();
    
    void onConnectionSuspended(int param1Int);
  }
  
  public static interface OnConnectionFailedListener {
    void onConnectionFailed(ConnectionResult param1ConnectionResult);
  }
  
  class VoidOnConnectionFailed implements PackageNameManager.QueryPublishCallback {
    private int errorCode;
    
    public VoidOnConnectionFailed(int param1Int) {
      this.errorCode = param1Int;
    }
    
    public void onQueryResult() {
      ConnectionResult connectionResult = new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(BaseHmsClient.this.mContext, this.errorCode, 0));
      BaseHmsClient.this.notifyFailed(connectionResult);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\BaseHmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */