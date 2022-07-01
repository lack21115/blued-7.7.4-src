package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.hms.update.manager.PackageNameManager;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HuaweiApiClientImpl extends HuaweiApiClient implements ServiceConnection, InnerApiClient {
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  
  private static final Object a = new Object();
  
  private static final Object b = new Object();
  
  private Handler A = null;
  
  private CheckUpdatelistener B = null;
  
  private CheckUpdateCallBack C;
  
  private int c = -1;
  
  private final Context d;
  
  private final String e;
  
  private String f;
  
  private String g;
  
  private volatile com.huawei.hms.core.aidl.d h;
  
  private String i;
  
  private WeakReference<Activity> j;
  
  private WeakReference<Activity> k;
  
  private boolean l = false;
  
  private AtomicInteger m = new AtomicInteger(1);
  
  private List<Scope> n;
  
  private List<PermissionInfo> o;
  
  private Map<Api<?>, Api.ApiOptions> p;
  
  private SubAppInfo q;
  
  private long r = 0L;
  
  private int s = 0;
  
  private final Object t = new Object();
  
  private final ReentrantLock u = new ReentrantLock();
  
  private final Condition v = this.u.newCondition();
  
  private ConnectionResult w;
  
  private HuaweiApiClient.ConnectionCallbacks x;
  
  private HuaweiApiClient.OnConnectionFailedListener y;
  
  private Handler z = null;
  
  public HuaweiApiClientImpl(Context paramContext) {
    this.d = paramContext;
    this.e = Util.getAppId(paramContext);
    this.f = this.e;
    this.g = Util.getCpId(paramContext);
  }
  
  private void a() {
    this.C = new CheckUpdateCallBack(this) {
        public void onMarketInstallInfo(Intent param1Intent) {
          if (param1Intent != null) {
            int i = param1Intent.getIntExtra("downloadStatus", -99);
            int j = param1Intent.getIntExtra("installState", -99);
            int k = param1Intent.getIntExtra("installType", -99);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onMarketInstallInfo installState: ");
            stringBuilder.append(j);
            stringBuilder.append(",installType: ");
            stringBuilder.append(k);
            stringBuilder.append(",downloadCode: ");
            stringBuilder.append(i);
            HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
          } 
        }
        
        public void onMarketStoreError(int param1Int) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onMarketStoreError responseCode: ");
          stringBuilder.append(param1Int);
          HMSLog.e("HuaweiApiClientImpl", stringBuilder.toString());
        }
        
        public void onUpdateInfo(Intent param1Intent) {
          if (param1Intent != null && HuaweiApiClientImpl.a(this.a) != null)
            try {
              int i = param1Intent.getIntExtra("status", -99);
              int j = param1Intent.getIntExtra("failcause", -99);
              boolean bool = param1Intent.getBooleanExtra("compulsoryUpdateCancel", false);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onUpdateInfo status: ");
              stringBuilder.append(i);
              stringBuilder.append(",failcause: ");
              stringBuilder.append(j);
              stringBuilder.append(",isExit: ");
              stringBuilder.append(bool);
              HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
              if (i == 7) {
                ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo)param1Intent.getSerializableExtra("updatesdk_update_info");
                if (apkUpgradeInfo != null) {
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("onUpdateInfo: ");
                  stringBuilder.append(apkUpgradeInfo.toString());
                  HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
                } 
                HuaweiApiClientImpl.a(this.a).onResult(1);
              } else if (i == 3) {
                HuaweiApiClientImpl.a(this.a).onResult(0);
              } else {
                HuaweiApiClientImpl.a(this.a).onResult(-1);
              } 
              HuaweiApiClientImpl.a(this.a, (CheckUpdatelistener)null);
              return;
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("intent has some error");
              stringBuilder.append(exception.getMessage());
              HMSLog.e("HuaweiApiClientImpl", stringBuilder.toString());
              HuaweiApiClientImpl.a(this.a).onResult(-1);
            }  
        }
        
        public void onUpdateStoreError(int param1Int) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onUpdateStoreError responseCode: ");
          stringBuilder.append(param1Int);
          HMSLog.e("HuaweiApiClientImpl", stringBuilder.toString());
        }
      };
  }
  
  private void a(int paramInt) {
    if (!Util.isAvailableLibExist(this.d)) {
      b(paramInt);
      return;
    } 
    if (paramInt == 1 && HMSPublishStateHolder.getPublishState() == 0) {
      WeakReference<Context> weakReference = new WeakReference<Context>(this.d);
      e e = new e(this, paramInt);
      PackageNameManager.getInstance(weakReference.get()).queryPackageName(e);
      return;
    } 
    b(paramInt);
  }
  
  private void a(ResolveResult<DisconnectResp> paramResolveResult) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter onDisconnectionResult, disconnect from server result: ");
    stringBuilder.append(paramResolveResult.getStatus().getStatusCode());
    HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
    n();
    c(1);
  }
  
  private void b() {
    HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
    ConnectService.forceConnect((ApiClient)this, m()).setResultCallback(new b());
  }
  
  private void b(int paramInt) {
    WeakReference<Activity> weakReference = this.j;
    if (weakReference != null && weakReference.get() != null) {
      PendingIntent pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), paramInt);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("connect 2.0 fail: ");
      stringBuilder.append(paramInt);
      HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
    } else {
      weakReference = null;
    } 
    ConnectionResult connectionResult = new ConnectionResult(paramInt, (PendingIntent)weakReference);
    this.y.onConnectionFailed(connectionResult);
    this.w = connectionResult;
  }
  
  private void b(ResolveResult<ConnectResp> paramResolveResult) {
    String str;
    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
    if (this.h == null || this.m.get() != 2) {
      HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
      return;
    } 
    d(3);
    ConnectResp connectResp = (ConnectResp)paramResolveResult.getValue();
    if (connectResp != null)
      this.i = connectResp.sessionId; 
    SubAppInfo subAppInfo = this.q;
    connectionPostProcessor = null;
    if (subAppInfo == null) {
      subAppInfo = null;
    } else {
      str = subAppInfo.getSubAppID();
    } 
    if (!TextUtils.isEmpty(str))
      this.f = str; 
    int i = paramResolveResult.getStatus().getStatusCode();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter onConnectionResult, connect to server result: ");
    stringBuilder.append(i);
    HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
    if (Status.SUCCESS.equals(paramResolveResult.getStatus())) {
      if (paramResolveResult.getValue() != null)
        ProtocolNegotiate.getInstance().negotiate(((ConnectResp)paramResolveResult.getValue()).protocolVersion); 
      c(3);
      this.w = null;
      HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.x;
      if (connectionCallbacks != null)
        connectionCallbacks.onConnected(); 
      if (this.j != null)
        o(); 
      for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
        if (((Api)entry.getKey()).getmConnetctPostList() != null && !((Api)entry.getKey()).getmConnetctPostList().isEmpty()) {
          HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
          for (ConnectionPostProcessor connectionPostProcessor : ((Api)entry.getKey()).getmConnetctPostList()) {
            HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
            connectionPostProcessor.run(this, this.j);
          } 
        } 
      } 
    } else if (paramResolveResult.getStatus() != null && paramResolveResult.getStatus().getStatusCode() == 1001) {
      n();
      c(1);
      HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.x;
      if (connectionCallbacks != null) {
        connectionCallbacks.onConnectionSuspended(3);
        return;
      } 
    } else {
      n();
      c(1);
      if (this.y != null) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.j;
        ConnectionPostProcessor connectionPostProcessor1 = connectionPostProcessor;
        if (weakReference != null) {
          connectionPostProcessor1 = connectionPostProcessor;
          if (weakReference.get() != null)
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), i); 
        } 
        ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
        this.y.onConnectionFailed(connectionResult);
        this.w = connectionResult;
      } 
    } 
  }
  
  private void c() {
    n();
    if (this.y != null) {
      byte b;
      if (Util.isBackground(this.d)) {
        b = 7;
      } else {
        b = 6;
      } 
      PendingIntent pendingIntent2 = null;
      WeakReference<Activity> weakReference = this.j;
      PendingIntent pendingIntent1 = pendingIntent2;
      if (weakReference != null) {
        pendingIntent1 = pendingIntent2;
        if (weakReference.get() != null)
          pendingIntent1 = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), b); 
      } 
      ConnectionResult connectionResult = new ConnectionResult(b, pendingIntent1);
      this.y.onConnectionFailed(connectionResult);
      this.w = connectionResult;
    } 
  }
  
  private void c(int paramInt) {
    this.m.set(paramInt);
    if (paramInt == 1 || paramInt == 3 || paramInt == 2) {
      this.u.lock();
      try {
        this.v.signalAll();
        return;
      } finally {
        this.u.unlock();
      } 
    } 
  }
  
  private int d() {
    int i = Util.getHmsVersion(this.d);
    if (i == 0 || i < 20503000) {
      i = e();
      if (f()) {
        int k = i;
        if (i < 20503000)
          k = 20503000; 
        return k;
      } 
      int j = i;
      if (i < 20600000)
        j = 20600000; 
      return j;
    } 
    return i;
  }
  
  private void d(int paramInt) {
    if (paramInt == 2)
      synchronized (a) {
        if (this.z != null) {
          this.z.removeMessages(paramInt);
          this.z = null;
        } 
      }  
    if (paramInt == 3)
      synchronized (b) {
        if (this.A != null) {
          this.A.removeMessages(paramInt);
          this.A = null;
        } 
      }  
    synchronized (a) {
      if (this.z != null) {
        this.z.removeMessages(2);
        this.z = null;
      } 
      return;
    } 
  }
  
  private int e() {
    Map<Api<?>, Api.ApiOptions> map = getApiMap();
    int i = 0;
    if (map == null)
      return 0; 
    Iterator<Api> iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      String str = ((Api)iterator.next()).getApiName();
      if (!TextUtils.isEmpty(str)) {
        Integer integer = HuaweiApiAvailability.getApiMap().get(str);
        if (integer != null) {
          int j = integer.intValue();
          if (j > i)
            i = j; 
        } 
      } 
    } 
    return i;
  }
  
  private boolean f() {
    Map<Api<?>, Api.ApiOptions> map = this.p;
    if (map != null) {
      Iterator<Api> iterator = map.keySet().iterator();
      while (iterator.hasNext()) {
        if ("HuaweiGame.API".equals(((Api)iterator.next()).getApiName()))
          return true; 
      } 
    } 
    return false;
  }
  
  private void g() {
    null = new Intent("com.huawei.hms.core.aidlservice");
    HMSPackageManager.getInstance(this.d).refresh();
    null.setPackage(HMSPackageManager.getInstance(this.d).getHMSPackageName());
    synchronized (a) {
      if (this.d.bindService(null, this, 1)) {
        h();
        return;
      } 
      c(1);
      HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
      c();
      return;
    } 
  }
  
  private void h() {
    Handler handler = this.z;
    if (handler != null) {
      handler.removeMessages(2);
    } else {
      this.z = new Handler(Looper.getMainLooper(), new Handler.Callback(this) {
            public boolean handleMessage(Message param1Message) {
              if (param1Message == null || param1Message.what != 2)
                return false; 
              HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
              if (HuaweiApiClientImpl.b(this.a).get() == 5) {
                HuaweiApiClientImpl.a(this.a, 1);
                HuaweiApiClientImpl.c(this.a);
              } 
              return true;
            }
          });
    } 
    this.z.sendEmptyMessageDelayed(2, 5000L);
  }
  
  private void i() {
    synchronized (b) {
      if (this.A != null) {
        this.A.removeMessages(3);
      } else {
        this.A = new Handler(Looper.getMainLooper(), new Handler.Callback(this) {
              public boolean handleMessage(Message param1Message) {
                if (param1Message == null || param1Message.what != 3)
                  return false; 
                HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
                if (HuaweiApiClientImpl.b(this.a).get() == 2) {
                  HuaweiApiClientImpl.a(this.a, 1);
                  HuaweiApiClientImpl.c(this.a);
                } 
                return true;
              }
            });
      } 
      boolean bool = this.A.sendEmptyMessageDelayed(3, 3000L);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : ");
      stringBuilder.append(bool);
      HMSLog.d("HuaweiApiClientImpl", stringBuilder.toString());
      return;
    } 
  }
  
  private void j() {
    ConnectService.disconnect((ApiClient)this, k()).setResultCallback(new c());
  }
  
  private DisconnectInfo k() {
    ArrayList<String> arrayList = new ArrayList();
    Map<Api<?>, Api.ApiOptions> map = this.p;
    if (map != null) {
      Iterator<Api> iterator = map.keySet().iterator();
      while (iterator.hasNext())
        arrayList.add(((Api)iterator.next()).getApiName()); 
    } 
    return new DisconnectInfo(this.n, arrayList);
  }
  
  private void l() {
    HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
    ConnectService.connect((ApiClient)this, m()).setResultCallback(new b());
  }
  
  private ConnectInfo m() {
    String str2;
    String str3 = (new PackageManagerHelper(this.d)).getPackageSignature(this.d.getPackageName());
    String str1 = str3;
    if (str3 == null)
      str1 = ""; 
    SubAppInfo subAppInfo = this.q;
    if (subAppInfo == null) {
      subAppInfo = null;
    } else {
      str2 = subAppInfo.getSubAppID();
    } 
    return new ConnectInfo(getApiNameList(), this.n, str1, str2);
  }
  
  private void n() {
    Util.unBindServiceCatchException(this.d, this);
    this.h = null;
  }
  
  private void o() {
    if (this.l) {
      HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
      return;
    } 
    if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.d) == 0)
      ConnectService.getNotice((ApiClient)this, 0, "5.0.4.301").setResultCallback(new d()); 
  }
  
  public int asyncRequest(Bundle paramBundle, String paramString, int paramInt, ResultCallback<BundleResult> paramResultCallback) {
    HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
    if (paramResultCallback == null || paramString == null || paramBundle == null) {
      HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
      return 907135000;
    } 
    if (!innerIsConnected()) {
      HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
      return 907135003;
    } 
    com.huawei.hms.core.aidl.b b = new com.huawei.hms.core.aidl.b(paramString, paramInt);
    com.huawei.hms.core.aidl.e e = com.huawei.hms.core.aidl.a.a(b.c());
    b.a(paramBundle);
    RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 50004301, getSessionId());
    requestHeader.setApiNameList(getApiNameList());
    b.b = e.a((IMessageEntity)requestHeader, new Bundle());
    try {
      getService().a(b, (com.huawei.hms.core.aidl.c)new com.huawei.hms.core.aidl.c.a(this, paramResultCallback) {
            public void call(com.huawei.hms.core.aidl.b param1b) {
              if (param1b != null) {
                com.huawei.hms.core.aidl.e e = com.huawei.hms.core.aidl.a.a(param1b.c());
                ResponseHeader responseHeader = new ResponseHeader();
                e.a(param1b.b, (IMessageEntity)responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), param1b.a());
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.a.onResult(bundleResult);
                return;
              } 
              HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
              this.a.onResult(new BundleResult(-1, null));
            }
          });
      return 0;
    } catch (RemoteException remoteException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("remote exception:");
      stringBuilder.append(remoteException.getMessage());
      HMSLog.e("HuaweiApiClientImpl", stringBuilder.toString());
      return 907135001;
    } 
  }
  
  public void checkUpdate(Activity paramActivity, CheckUpdatelistener paramCheckUpdatelistener) {
    if (Util.isAvailableLibExist(this.d)) {
      HMSLog.i("HuaweiApiClientImpl", "Enter checkUpdate");
      if (paramCheckUpdatelistener == null) {
        HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        return;
      } 
      if (paramActivity == null || paramActivity.isFinishing()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("checkUpdate, activity is illegal: ");
        stringBuilder.append(paramActivity);
        HMSLog.e("HuaweiApiClientImpl", stringBuilder.toString());
        paramCheckUpdatelistener.onResult(-1);
        return;
      } 
      this.B = paramCheckUpdatelistener;
      if (this.C == null)
        a(); 
      UpdateSdkAPI.checkClientOTAUpdate((Context)paramActivity, this.C, true, 0, true);
      return;
    } 
    HMSLog.e("HuaweiApiClientImpl", "available lib does not exist.");
  }
  
  public void connect(int paramInt) {
    connect((Activity)null);
  }
  
  public void connect(Activity paramActivity) {
    HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50004301 ======");
    int i = this.m.get();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter connect, Connection Status: ");
    stringBuilder.append(i);
    HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
    if (i != 3 && i != 5 && i != 2) {
      String str;
      if (i == 4)
        return; 
      if (paramActivity != null) {
        this.j = new WeakReference<Activity>(paramActivity);
        this.k = new WeakReference<Activity>(paramActivity);
      } 
      if (TextUtils.isEmpty(this.e)) {
        str = Util.getAppId(this.d);
      } else {
        str = this.e;
      } 
      this.f = str;
      i = d();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("connect minVersion:");
      stringBuilder1.append(i);
      HMSLog.i("HuaweiApiClientImpl", stringBuilder1.toString());
      HuaweiApiAvailability.setServicesVersionCode(i);
      i = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.d, i);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("In connect, isHuaweiMobileServicesAvailable result: ");
      stringBuilder1.append(i);
      HMSLog.i("HuaweiApiClientImpl", stringBuilder1.toString());
      this.s = HMSPackageManager.getInstance(this.d).getHmsVersionCode();
      if (i == 0) {
        c(5);
        if (this.h == null) {
          g();
          return;
        } 
        c(2);
        l();
        i();
        return;
      } 
      if (this.y != null)
        a(i); 
    } 
  }
  
  public void connectForeground() {
    HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50004301 ======");
    int i = this.m.get();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter forceConnect, Connection Status: ");
    stringBuilder.append(i);
    HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
    if (i != 3 && i != 5 && i != 2) {
      String str;
      if (i == 4)
        return; 
      if (TextUtils.isEmpty(this.e)) {
        str = Util.getAppId(this.d);
      } else {
        str = this.e;
      } 
      this.f = str;
      b();
    } 
  }
  
  public void disableLifeCycleManagement(Activity paramActivity) {
    if (this.c >= 0) {
      AutoLifecycleFragment autoLifecycleFragment = AutoLifecycleFragment.getInstance(paramActivity);
      if (autoLifecycleFragment == null)
        return; 
      autoLifecycleFragment.stopAutoManage(this.c);
      return;
    } 
    throw new IllegalStateException("disableLifeCycleManagement failed");
  }
  
  public PendingResult<Status> discardAndReconnect() {
    return (PendingResult<Status>)new a((ApiClient)this, null, null);
  }
  
  public void disconnect() {
    int i = this.m.get();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter disconnect, Connection Status: ");
    stringBuilder.append(i);
    HMSLog.i("HuaweiApiClientImpl", stringBuilder.toString());
    if (i != 1)
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return; 
            d(2);
            c(4);
            return;
          } 
        } else {
          c(4);
          j();
          return;
        } 
      } else {
        c(4);
      }  
  }
  
  public Map<Api<?>, Api.ApiOptions> getApiMap() {
    return this.p;
  }
  
  public List<String> getApiNameList() {
    ArrayList<String> arrayList = new ArrayList();
    Map<Api<?>, Api.ApiOptions> map = this.p;
    if (map != null) {
      Iterator<Api> iterator = map.keySet().iterator();
      while (iterator.hasNext())
        arrayList.add(((Api)iterator.next()).getApiName()); 
    } 
    return arrayList;
  }
  
  public String getAppID() {
    return this.f;
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi) {
    if (isConnected()) {
      this.w = null;
      return new ConnectionResult(0, null);
    } 
    ConnectionResult connectionResult = this.w;
    return (connectionResult != null) ? connectionResult : new ConnectionResult(13, null);
  }
  
  public Context getContext() {
    return this.d;
  }
  
  public String getCpID() {
    return this.g;
  }
  
  public String getPackageName() {
    return this.d.getPackageName();
  }
  
  public List<PermissionInfo> getPermissionInfos() {
    return this.o;
  }
  
  public List<Scope> getScopes() {
    return this.n;
  }
  
  public com.huawei.hms.core.aidl.d getService() {
    return this.h;
  }
  
  public String getSessionId() {
    return this.i;
  }
  
  public final SubAppInfo getSubAppInfo() {
    return this.q;
  }
  
  public Activity getTopActivity() {
    WeakReference<Activity> weakReference = this.k;
    return (weakReference == null) ? null : weakReference.get();
  }
  
  public String getTransportName() {
    return IPCTransport.class.getName();
  }
  
  public boolean hasConnectedApi(Api<?> paramApi) {
    return isConnected();
  }
  
  public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Checker.checkNonNull(paramOnConnectionFailedListener, "onConnectionFailedListener should not be null");
    synchronized (this.t) {
      if (this.y == paramOnConnectionFailedListener)
        return true; 
      return false;
    } 
  }
  
  public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Checker.checkNonNull(paramConnectionCallbacks, "connectionCallbacksListener should not be null");
    synchronized (this.t) {
      if (this.x == paramConnectionCallbacks)
        return true; 
      return false;
    } 
  }
  
  public ConnectionResult holdUpConnect() {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.u.lock();
      try {
        connect((Activity)null);
        while (true) {
          boolean bool = isConnecting();
          if (bool) {
            ConnectionResult connectionResult;
            try {
              this.v.await();
              continue;
            } catch (InterruptedException interruptedException) {
              Thread.currentThread().interrupt();
              connectionResult = new ConnectionResult(15, null);
            } 
            return connectionResult;
          } 
          if (isConnected()) {
            this.w = null;
            return new ConnectionResult(0, null);
          } 
          if (this.w != null)
            return this.w; 
          return new ConnectionResult(13, null);
        } 
      } finally {
        this.u.unlock();
      } 
    } 
    throw new IllegalStateException("blockingConnect must not be called on the UI thread");
  }
  
  public ConnectionResult holdUpConnect(long paramLong, TimeUnit paramTimeUnit) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.u.lock();
      try {
        connect((Activity)null);
        paramLong = paramTimeUnit.toNanos(paramLong);
        while (true) {
          if (isConnecting()) {
            if (paramLong <= 0L) {
              disconnect();
              return new ConnectionResult(14, null);
            } 
            try {
              paramLong = this.v.awaitNanos(paramLong);
              continue;
            } catch (InterruptedException interruptedException) {}
            return (ConnectionResult)interruptedException;
          } 
          if (isConnected()) {
            this.w = null;
            return new ConnectionResult(0, null);
          } 
          if (this.w != null)
            return this.w; 
          return new ConnectionResult(13, null);
        } 
      } finally {
        this.u.unlock();
      } 
    } 
    throw new IllegalStateException("blockingConnect must not be called on the UI thread");
  }
  
  public boolean innerIsConnected() {
    return (this.m.get() == 3 || this.m.get() == 4);
  }
  
  public boolean isConnected() {
    if (this.s == 0)
      this.s = HMSPackageManager.getInstance(this.d).getHmsVersionCode(); 
    if (this.s < 20504000) {
      long l = System.currentTimeMillis() - this.r;
      if (l > 0L && l < 300000L)
        return innerIsConnected(); 
      if (innerIsConnected()) {
        Status status = ((ResolveResult)ConnectService.checkconnect((ApiClient)this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS)).getStatus();
        if (status.isSuccess()) {
          this.r = System.currentTimeMillis();
          return true;
        } 
        int i = status.getStatusCode();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isConnected is false, statuscode:");
        stringBuilder.append(i);
        HMSLog.e("HuaweiApiClientImpl", stringBuilder.toString());
        if (i != 907135004) {
          n();
          c(1);
          this.r = System.currentTimeMillis();
        } 
      } 
      return false;
    } 
    return innerIsConnected();
  }
  
  public boolean isConnecting() {
    int i = this.m.get();
    return (i == 2 || i == 5);
  }
  
  public void onPause(Activity paramActivity) {
    HMSLog.i("HuaweiApiClientImpl", "onPause");
  }
  
  public void onResume(Activity paramActivity) {
    if (paramActivity != null) {
      HMSLog.i("HuaweiApiClientImpl", "onResume");
      this.k = new WeakReference<Activity>(paramActivity);
    } 
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    HMSLog.i("HuaweiApiClientImpl", "Enter onServiceConnected.");
    d(2);
    this.h = com.huawei.hms.core.aidl.d.a.a(paramIBinder);
    if (this.h == null) {
      HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
      n();
      c(1);
      if (this.y != null) {
        PendingIntent pendingIntent;
        paramIBinder = null;
        WeakReference<Activity> weakReference = this.j;
        IBinder iBinder = paramIBinder;
        if (weakReference != null) {
          iBinder = paramIBinder;
          if (weakReference.get() != null)
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), 10); 
        } 
        ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
        this.y.onConnectionFailed(connectionResult);
        this.w = connectionResult;
      } 
      return;
    } 
    if (this.m.get() == 5) {
      c(2);
      l();
      i();
      return;
    } 
    if (this.m.get() != 3)
      n(); 
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
    this.h = null;
    c(1);
    HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.x;
    if (connectionCallbacks != null)
      connectionCallbacks.onConnectionSuspended(1); 
  }
  
  public void print(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public void reconnect() {
    disconnect();
    connect((Activity)null);
  }
  
  public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    Checker.checkNonNull(paramOnConnectionFailedListener, "onConnectionFailedListener should not be null");
    synchronized (this.t) {
      if (this.y != paramOnConnectionFailedListener) {
        HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
      } else {
        this.y = null;
      } 
      return;
    } 
  }
  
  public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    Checker.checkNonNull(paramConnectionCallbacks, "connectionCallbacksListener should not be null");
    synchronized (this.t) {
      if (this.x != paramConnectionCallbacks) {
        HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
      } else {
        this.x = null;
      } 
      return;
    } 
  }
  
  public void setApiMap(Map<Api<?>, Api.ApiOptions> paramMap) {
    this.p = paramMap;
  }
  
  protected void setAutoLifecycleClientId(int paramInt) {
    this.c = paramInt;
  }
  
  public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks) {
    this.x = paramConnectionCallbacks;
  }
  
  public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.y = paramOnConnectionFailedListener;
  }
  
  public void setHasShowNotice(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void setPermissionInfos(List<PermissionInfo> paramList) {
    this.o = paramList;
  }
  
  public void setScopes(List<Scope> paramList) {
    this.n = paramList;
  }
  
  public boolean setSubAppInfo(SubAppInfo paramSubAppInfo) {
    String str1;
    HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
    if (paramSubAppInfo == null) {
      HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
      return false;
    } 
    String str2 = paramSubAppInfo.getSubAppID();
    if (TextUtils.isEmpty(str2)) {
      HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
      return false;
    } 
    if (TextUtils.isEmpty(this.e)) {
      str1 = Util.getAppId(this.d);
    } else {
      str1 = this.e;
    } 
    if (str2.equals(str1)) {
      HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
      return false;
    } 
    this.q = new SubAppInfo(paramSubAppInfo);
    return true;
  }
  
  static class a extends PendingResultImpl<Status, IMessageEntity> {
    public a(ApiClient param1ApiClient, String param1String, IMessageEntity param1IMessageEntity) {
      super(param1ApiClient, param1String, param1IMessageEntity);
    }
    
    public Status a(IMessageEntity param1IMessageEntity) {
      return new Status(0);
    }
  }
  
  class b implements ResultCallback<ResolveResult<ConnectResp>> {
    private b(HuaweiApiClientImpl this$0) {}
    
    public void a(ResolveResult<ConnectResp> param1ResolveResult) {
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, param1ResolveResult) {
            public void run() {
              HuaweiApiClientImpl.b(this.b.a, this.a);
            }
          });
    }
  }
  
  class null implements Runnable {
    null(HuaweiApiClientImpl this$0, ResolveResult param1ResolveResult) {}
    
    public void run() {
      HuaweiApiClientImpl.b(this.b.a, this.a);
    }
  }
  
  class c implements ResultCallback<ResolveResult<DisconnectResp>> {
    private c(HuaweiApiClientImpl this$0) {}
    
    public void a(ResolveResult<DisconnectResp> param1ResolveResult) {
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, param1ResolveResult) {
            public void run() {
              HuaweiApiClientImpl.a(this.b.a, this.a);
            }
          });
    }
  }
  
  class null implements Runnable {
    null(HuaweiApiClientImpl this$0, ResolveResult param1ResolveResult) {}
    
    public void run() {
      HuaweiApiClientImpl.a(this.b.a, this.a);
    }
  }
  
  class d implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
    private d(HuaweiApiClientImpl this$0) {}
    
    public void a(ResolveResult<JosGetNoticeResp> param1ResolveResult) {
      if (param1ResolveResult != null && param1ResolveResult.getStatus().isSuccess()) {
        JosGetNoticeResp josGetNoticeResp = (JosGetNoticeResp)param1ResolveResult.getValue();
        Intent intent = josGetNoticeResp.getNoticeIntent();
        if (intent != null && josGetNoticeResp.getStatusCode() == 0) {
          HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
          Activity activity = Util.getValidActivity(HuaweiApiClientImpl.d(this.a).get(), this.a.getTopActivity());
          if (activity == null) {
            HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
            return;
          } 
          HuaweiApiClientImpl.a(this.a, true);
          activity.startActivity(intent);
        } 
      } 
    }
  }
  
  class e implements PackageNameManager.QueryPublishCallback {
    private int b;
    
    public e(HuaweiApiClientImpl this$0, int param1Int) {
      this.b = param1Int;
    }
    
    public void onQueryResult() {
      HuaweiApiClientImpl.b(this.a, this.b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\HuaweiApiClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */