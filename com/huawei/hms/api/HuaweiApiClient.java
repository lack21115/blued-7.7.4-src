package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class HuaweiApiClient implements AidlApiClient {
  public abstract void checkUpdate(Activity paramActivity, CheckUpdatelistener paramCheckUpdatelistener);
  
  public void connect(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public abstract void connect(Activity paramActivity);
  
  public abstract void connectForeground();
  
  public abstract void disableLifeCycleManagement(Activity paramActivity);
  
  public abstract PendingResult<Status> discardAndReconnect();
  
  public abstract void disconnect();
  
  public abstract Map<Api<?>, Api.ApiOptions> getApiMap();
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  public abstract List<PermissionInfo> getPermissionInfos();
  
  public abstract List<Scope> getScopes();
  
  public abstract Activity getTopActivity();
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean hasConnectionFailureListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract boolean hasConnectionSuccessListener(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract ConnectionResult holdUpConnect();
  
  public abstract ConnectionResult holdUpConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onResume(Activity paramActivity);
  
  public abstract void print(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract void reconnect();
  
  public abstract void removeConnectionFailureListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void removeConnectionSuccessListener(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void setConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void setConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract boolean setSubAppInfo(SubAppInfo paramSubAppInfo);
  
  public static final class Builder {
    private final Context a;
    
    private final List<Scope> b = new ArrayList<Scope>();
    
    private final List<PermissionInfo> c = new ArrayList<PermissionInfo>();
    
    private final Map<Api<?>, Api.ApiOptions> d = new HashMap<Api<?>, Api.ApiOptions>();
    
    private HuaweiApiClient.OnConnectionFailedListener e;
    
    private HuaweiApiClient.ConnectionCallbacks f;
    
    private int g;
    
    private Activity h;
    
    public Builder(Context param1Context) throws NullPointerException {
      Checker.checkNonNull(param1Context, "context must not be null.");
      this.a = param1Context.getApplicationContext();
      this.g = -1;
      ResourceLoaderUtil.setmContext(this.a);
      a(param1Context);
    }
    
    private void a(Context param1Context) {
      HMSBIInitializer.getInstance(param1Context).initBI();
    }
    
    private void a(HuaweiApiClient param1HuaweiApiClient) {
      AutoLifecycleFragment autoLifecycleFragment = AutoLifecycleFragment.getInstance(this.h);
      if (autoLifecycleFragment == null) {
        HMSLog.e("HuaweiApiClient.builder", "lifecycleFragment must not be NULL here");
        return;
      } 
      autoLifecycleFragment.startAutoMange(this.g, param1HuaweiApiClient);
    }
    
    public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> param1Api) {
      this.d.put(param1Api, null);
      if ("HuaweiGame.API".equals(param1Api.getApiName())) {
        HiAnalyticsUtil hiAnalyticsUtil = HiAnalyticsUtil.getInstance();
        Context context = this.a.getApplicationContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        stringBuilder.append(System.currentTimeMillis());
        hiAnalyticsUtil.onEvent(context, "15060106", stringBuilder.toString());
      } 
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> param1Api, O param1O) {
      Checker.checkNonNull(param1Api, "Api must not be null");
      Checker.checkNonNull(param1O, "Null options are not permitted for this Api");
      this.d.put(param1Api, (Api.ApiOptions)param1O);
      if (param1Api.getOptions() != null) {
        List<Scope> list1 = param1Api.getOptions().getScopeList(param1O);
        this.b.addAll(list1);
        List<PermissionInfo> list = param1Api.getOptions().getPermissionInfoList(param1O);
        this.c.addAll(list);
      } 
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> param1Api, O param1O, Scope... param1VarArgs) {
      Checker.checkNonNull(param1Api, "Api must not be null");
      Checker.checkNonNull(param1O, "Null options are not permitted for this Api");
      Checker.checkNonNull(param1VarArgs, "Scopes must not be null");
      this.d.put(param1Api, (Api.ApiOptions)param1O);
      if (param1Api.getOptions() != null) {
        List<Scope> list1 = param1Api.getOptions().getScopeList(param1O);
        this.b.addAll(list1);
        List<PermissionInfo> list = param1Api.getOptions().getPermissionInfoList(param1O);
        this.c.addAll(list);
      } 
      ArrayList<? extends Scope> arrayList = new ArrayList(Arrays.asList((Object[])param1VarArgs));
      this.b.addAll(arrayList);
      return this;
    }
    
    public Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> param1Api, Scope... param1VarArgs) {
      Checker.checkNonNull(param1Api, "Api must not be null");
      Checker.checkNonNull(param1VarArgs, "Scopes must not be null");
      this.d.put(param1Api, null);
      ArrayList<? extends Scope> arrayList = new ArrayList(Arrays.asList((Object[])param1VarArgs));
      this.b.addAll(arrayList);
      return this;
    }
    
    public Builder addConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks param1ConnectionCallbacks) {
      Checker.checkNonNull(param1ConnectionCallbacks, "listener must not be null.");
      this.f = param1ConnectionCallbacks;
      return this;
    }
    
    public Builder addOnConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      Checker.checkNonNull(param1OnConnectionFailedListener, "listener must not be null.");
      this.e = param1OnConnectionFailedListener;
      return this;
    }
    
    public Builder addScope(Scope param1Scope) {
      Checker.checkNonNull(param1Scope, "scope must not be null.");
      this.b.add(param1Scope);
      return this;
    }
    
    public Builder allowLifeCycleManagement(Activity param1Activity, int param1Int, HuaweiApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      if (param1Int >= 0) {
        this.g = param1Int;
        this.h = (Activity)Preconditions.checkNotNull(param1Activity, "activity must not be Null.");
        return this;
      } 
      throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
    }
    
    public Builder allowLifeCycleManagement(Activity param1Activity, HuaweiApiClient.OnConnectionFailedListener param1OnConnectionFailedListener) {
      return allowLifeCycleManagement(param1Activity, 0, param1OnConnectionFailedListener);
    }
    
    public Builder applyDefaultAccount() {
      return this;
    }
    
    public HuaweiApiClient build() {
      addApi(new Api<Api.ApiOptions.NotRequiredOptions>("Core.API"));
      HuaweiApiClientImpl huaweiApiClientImpl = new HuaweiApiClientImpl(this.a);
      huaweiApiClientImpl.setScopes(this.b);
      huaweiApiClientImpl.setPermissionInfos(this.c);
      huaweiApiClientImpl.setApiMap(this.d);
      huaweiApiClientImpl.setConnectionCallbacks(this.f);
      huaweiApiClientImpl.setConnectionFailedListener(this.e);
      huaweiApiClientImpl.setAutoLifecycleClientId(this.g);
      if (this.g >= 0)
        a(huaweiApiClientImpl); 
      return huaweiApiClientImpl;
    }
    
    public Builder setAccountName(String param1String) {
      return this;
    }
    
    public Builder setHandler(Handler param1Handler) {
      return this;
    }
    
    public Builder setPopupsGravity(int param1Int) {
      return this;
    }
    
    public Builder setViewForPopups(View param1View) {
      return this;
    }
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\HuaweiApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */