package com.huawei.hms.common.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiManager implements Handler.Callback {
  private static final String HANDLER_NAME = "HuaweiApiHandler";
  
  private static final Object LOCK_OBJECT = new Object();
  
  private static final int MSG_RECEIVE_SEND_REQ = 4;
  
  private static final String TAG = "HuaweiApiManager";
  
  private static HuaweiApiManager mInstance;
  
  private final Map<ConnectionManagerKey<?>, ConnectionManager<?>> mConnectionCache = new ConcurrentHashMap<ConnectionManagerKey<?>, ConnectionManager<?>>(5, 0.75F, 1);
  
  private final Handler mHandler;
  
  private final AtomicInteger mSerial = new AtomicInteger(0);
  
  private HuaweiApiManager(Context paramContext, Looper paramLooper, HuaweiApiAvailability paramHuaweiApiAvailability) {
    this.mHandler = new Handler(paramLooper, this);
  }
  
  private void connectAndSendRequest(HandlerMessageWrapper paramHandlerMessageWrapper) {
    HuaweiApi<?> huaweiApi = paramHandlerMessageWrapper.mApi;
    ConnectionManager<?> connectionManager2 = this.mConnectionCache.get(huaweiApi.getConnectionManagerKey());
    ConnectionManager<?> connectionManager1 = connectionManager2;
    if (connectionManager2 == null) {
      connectionManager1 = new ConnectionManager(huaweiApi);
      this.mConnectionCache.put(huaweiApi.getConnectionManagerKey(), connectionManager1);
    } 
    connectionManager1.sendRequest((TaskApiCallWrapper)paramHandlerMessageWrapper.mContentWrapper);
  }
  
  public static HuaweiApiManager getInstance(Context paramContext) {
    synchronized (LOCK_OBJECT) {
      if (mInstance == null) {
        HandlerThread handlerThread = new HandlerThread("HuaweiApiManager");
        handlerThread.start();
        mInstance = new HuaweiApiManager(paramContext.getApplicationContext(), handlerThread.getLooper(), HuaweiApiAvailability.getInstance());
      } 
      return mInstance;
    } 
  }
  
  private void innerDisconnect(HuaweiApi<?> paramHuaweiApi, TaskCompletionSource<Boolean> paramTaskCompletionSource) {
    ConnectionManager connectionManager = this.mConnectionCache.get(paramHuaweiApi.getConnectionManagerKey());
    if (connectionManager == null) {
      paramTaskCompletionSource.a(Boolean.valueOf(false));
      return;
    } 
    paramTaskCompletionSource.a(Boolean.valueOf(connectionManager.disconnect()));
  }
  
  public void disconnectService(final HuaweiApi<?> api, final TaskCompletionSource<Boolean> completionSource) {
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      innerDisconnect(api, completionSource);
      return;
    } 
    this.mHandler.post(new Runnable() {
          public void run() {
            HuaweiApiManager.this.innerDisconnect(api, completionSource);
          }
        });
  }
  
  public boolean handleMessage(Message paramMessage) {
    if (paramMessage.what != 4) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown message id: ");
      stringBuilder.append(paramMessage.what);
      HMSLog.w("HuaweiApiManager", stringBuilder.toString());
      return false;
    } 
    connectAndSendRequest((HandlerMessageWrapper)paramMessage.obj);
    return true;
  }
  
  public final <TOption extends Api.ApiOptions, TResult> void sendRequest(HuaweiApi<TOption> paramHuaweiApi, TaskApiCall<? extends AnyClient, TResult> paramTaskApiCall, TaskCompletionSource<TResult> paramTaskCompletionSource) {
    TaskApiCallWrapper<TResult> taskApiCallWrapper = new TaskApiCallWrapper<TResult>(paramTaskApiCall, paramTaskCompletionSource);
    Handler handler = this.mHandler;
    handler.sendMessage(handler.obtainMessage(4, new HandlerMessageWrapper(taskApiCallWrapper, this.mSerial.getAndIncrement(), paramHuaweiApi)));
  }
  
  public class ConnectionManager<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {
    private final Queue<HuaweiApiManager.TaskApiCallbackWrapper> callbackQueue = new LinkedList<HuaweiApiManager.TaskApiCallbackWrapper>();
    
    private final HuaweiApi<OptionsT> mApi;
    
    private final AnyClient mClient;
    
    private final ConnectionManagerKey mConnectionManagerKey;
    
    private ConnectionResult mConnectionResult;
    
    private ResolveClientBean mResolveClientBean;
    
    ConnectionManager(HuaweiApi<OptionsT> param1HuaweiApi) {
      this.mApi = param1HuaweiApi;
      this.mClient = param1HuaweiApi.getClient(HuaweiApiManager.this.mHandler.getLooper(), this);
      this.mConnectionResult = null;
      this.mConnectionManagerKey = param1HuaweiApi.getConnectionManagerKey();
    }
    
    private String errorReason(ConnectionResult param1ConnectionResult) {
      boolean bool = Util.isAvailableLibExist(this.mApi.getContext());
      String str = "application configuration error, please developer check configuration";
      if (bool) {
        int i = param1ConnectionResult.getErrorCode();
        if (i != -1) {
          if (i != 3) {
            if (i != 8) {
              null = str;
              if (i != 10) {
                if (i != 13) {
                  if (i != 21) {
                    switch (i) {
                      default:
                        return "unknown errorReason";
                      case 27:
                        return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                      case 26:
                        return "update failed, because no activity incoming, can't pop update page";
                      case 25:
                        break;
                    } 
                    return "failed to get update result";
                  } 
                  return "device is too old to be support";
                } 
                return "update cancelled";
              } 
            } else {
              return "internal error";
            } 
          } else {
            return "HuaWei Mobile Service is disabled";
          } 
          return null;
        } 
      } else {
        int i = null.getErrorCode();
        if (i != -1) {
          if (i != 8) {
            null = str;
            if (i != 10);
          } else {
            return "internal error";
          } 
          return null;
        } 
      } 
      return "get update result, but has other error codes";
    }
    
    private String getTransactionId(String param1String1, String param1String2) {
      String str = param1String1;
      if (TextUtils.isEmpty(param1String1))
        str = TransactionIdCreater.getId(this.mApi.getAppID(), param1String2); 
      return str;
    }
    
    private void innerConnected() {
      Checker.assertHandlerThread(HuaweiApiManager.this.mHandler);
      this.mConnectionResult = null;
      Iterator<HuaweiApiManager.TaskApiCallbackWrapper> iterator = this.callbackQueue.iterator();
      while (iterator.hasNext())
        postMessage(iterator.next()); 
      this.callbackQueue.clear();
    }
    
    private void innerConnectionFailed(ConnectionResult param1ConnectionResult) {
      Checker.assertHandlerThread(HuaweiApiManager.this.mHandler);
      this.mConnectionResult = param1ConnectionResult;
      Iterator<HuaweiApiManager.TaskApiCallbackWrapper> iterator = this.callbackQueue.iterator();
      for (boolean bool = true; iterator.hasNext(); bool = bool1) {
        TaskApiCallWrapper taskApiCallWrapper = ((HuaweiApiManager.TaskApiCallbackWrapper)iterator.next()).getApiCallWrapper();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection Failed:");
        stringBuilder.append(errorReason(param1ConnectionResult));
        stringBuilder.append("(");
        stringBuilder.append(param1ConnectionResult.getErrorCode());
        stringBuilder.append(")");
        ResponseHeader responseHeader = new ResponseHeader(1, 907135003, stringBuilder.toString());
        responseHeader.setTransactionId(taskApiCallWrapper.getTaskApiCall().getTransactionId());
        HiAnalyticsInnerClient.reportEntryExit(this.mApi.getContext(), responseHeader, String.valueOf(this.mApi.getKitSdkVersion()));
        boolean bool1 = bool;
        if (this.mConnectionResult.getResolution() != null) {
          bool1 = bool;
          if (bool) {
            responseHeader.setParcelable((Parcelable)this.mConnectionResult.getResolution());
            bool = false;
            bool1 = bool;
            if (Util.isAvailableLibExist(this.mApi.getContext())) {
              bool1 = bool;
              if (this.mConnectionResult.getErrorCode() == 26) {
                responseHeader.setResolution("hasContextResolution");
                bool1 = bool;
              } 
            } 
          } 
        } 
        taskApiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, taskApiCallWrapper.getTaskCompletionSource());
      } 
      this.callbackQueue.clear();
      this.mConnectionResult = null;
      this.mClient.disconnect();
      HuaweiApiManager.this.mConnectionCache.remove(this.mConnectionManagerKey);
    }
    
    private void innerConnectionSuspended(int param1Int) {
      Checker.assertHandlerThread(HuaweiApiManager.this.mHandler);
      Iterator<HuaweiApiManager.TaskApiCallbackWrapper> iterator = this.callbackQueue.iterator();
      while (iterator.hasNext()) {
        TaskApiCallWrapper taskApiCallWrapper = ((HuaweiApiManager.TaskApiCallbackWrapper)iterator.next()).getApiCallWrapper();
        ResponseHeader responseHeader = new ResponseHeader(1, 907135003, "Connection Suspended");
        responseHeader.setTransactionId(taskApiCallWrapper.getTaskApiCall().getTransactionId());
        taskApiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, taskApiCallWrapper.getTaskCompletionSource());
      } 
      this.callbackQueue.clear();
      this.mConnectionResult = null;
      this.mClient.disconnect();
      HuaweiApiManager.this.mConnectionCache.remove(this.mConnectionManagerKey);
    }
    
    private void postMessage(HuaweiApiManager.TaskApiCallbackWrapper param1TaskApiCallbackWrapper) {
      String str = param1TaskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getUri();
      RequestHeader requestHeader = new RequestHeader();
      requestHeader.setSrvName(str.split("\\.")[0]);
      requestHeader.setApiName(str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mApi.getAppID());
      stringBuilder.append("|");
      stringBuilder.append(this.mApi.getSubAppID());
      requestHeader.setAppID(stringBuilder.toString());
      requestHeader.setPkgName(this.mApi.getContext().getPackageName());
      requestHeader.setSessionId(this.mClient.getSessionId());
      TaskApiCall taskApiCall = param1TaskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall();
      requestHeader.setTransactionId(getTransactionId(taskApiCall.getTransactionId(), str));
      requestHeader.setParcelable(taskApiCall.getParcelable());
      requestHeader.setKitSdkVersion(this.mApi.getKitSdkVersion());
      requestHeader.setApiLevel(Math.max(this.mApi.getApiLevel(), taskApiCall.getApiLevel()));
      this.mClient.post(requestHeader, taskApiCall.getRequestJson(), param1TaskApiCallbackWrapper.getCallBack());
    }
    
    private HuaweiApiManager.TaskApiCallbackWrapper wrapperRequest(final TaskApiCallWrapper req) {
      return new HuaweiApiManager.TaskApiCallbackWrapper(req, new AnyClient.CallBack() {
            private AtomicBoolean isFirstRsp = new AtomicBoolean(true);
            
            public void onCallback(IMessageEntity param2IMessageEntity, String param2String) {
              if (!(param2IMessageEntity instanceof ResponseHeader)) {
                HMSLog.e("HuaweiApiManager", "header is not instance of ResponseHeader");
                return;
              } 
              param2IMessageEntity = param2IMessageEntity;
              if (!TextUtils.isEmpty(param2IMessageEntity.getResolution())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Response has resolution: ");
                stringBuilder.append(param2IMessageEntity.getResolution());
                HMSLog.e("HuaweiApiManager", stringBuilder.toString());
              } 
              if (this.isFirstRsp.compareAndSet(true, false))
                HiAnalyticsInnerClient.reportEntryExit(HuaweiApiManager.ConnectionManager.this.mApi.getContext(), (ResponseHeader)param2IMessageEntity, String.valueOf(HuaweiApiManager.ConnectionManager.this.mApi.getKitSdkVersion())); 
              req.getTaskApiCall().onResponse(HuaweiApiManager.ConnectionManager.this.mClient, (ResponseErrorCode)param2IMessageEntity, param2String, req.getTaskCompletionSource());
            }
          });
    }
    
    void connect(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield this$0 : Lcom/huawei/hms/common/internal/HuaweiApiManager;
      //   6: invokestatic access$100 : (Lcom/huawei/hms/common/internal/HuaweiApiManager;)Landroid/os/Handler;
      //   9: invokestatic assertHandlerThread : (Landroid/os/Handler;)V
      //   12: aload_0
      //   13: getfield mClient : Lcom/huawei/hms/common/internal/AnyClient;
      //   16: invokeinterface isConnected : ()Z
      //   21: ifeq -> 36
      //   24: ldc_w 'HuaweiApiManager'
      //   27: ldc_w 'client is connected'
      //   30: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
      //   33: aload_0
      //   34: monitorexit
      //   35: return
      //   36: aload_0
      //   37: getfield mClient : Lcom/huawei/hms/common/internal/AnyClient;
      //   40: invokeinterface isConnecting : ()Z
      //   45: ifeq -> 60
      //   48: ldc_w 'HuaweiApiManager'
      //   51: ldc_w 'client is isConnecting'
      //   54: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
      //   57: aload_0
      //   58: monitorexit
      //   59: return
      //   60: aload_0
      //   61: getfield mApi : Lcom/huawei/hms/common/HuaweiApi;
      //   64: invokevirtual getActivity : ()Landroid/app/Activity;
      //   67: ifnull -> 128
      //   70: aload_0
      //   71: getfield mResolveClientBean : Lcom/huawei/hms/common/internal/ResolveClientBean;
      //   74: ifnonnull -> 93
      //   77: aload_0
      //   78: new com/huawei/hms/common/internal/ResolveClientBean
      //   81: dup
      //   82: aload_0
      //   83: getfield mClient : Lcom/huawei/hms/common/internal/AnyClient;
      //   86: iload_1
      //   87: invokespecial <init> : (Lcom/huawei/hms/common/internal/AnyClient;I)V
      //   90: putfield mResolveClientBean : Lcom/huawei/hms/common/internal/ResolveClientBean;
      //   93: invokestatic getInstance : ()Lcom/huawei/hms/common/internal/BindResolveClients;
      //   96: aload_0
      //   97: getfield mResolveClientBean : Lcom/huawei/hms/common/internal/ResolveClientBean;
      //   100: invokevirtual isClientRegistered : (Lcom/huawei/hms/common/internal/ResolveClientBean;)Z
      //   103: ifeq -> 118
      //   106: ldc_w 'HuaweiApiManager'
      //   109: ldc_w 'mResolveClientBean has already register, return!'
      //   112: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
      //   115: aload_0
      //   116: monitorexit
      //   117: return
      //   118: invokestatic getInstance : ()Lcom/huawei/hms/common/internal/BindResolveClients;
      //   121: aload_0
      //   122: getfield mResolveClientBean : Lcom/huawei/hms/common/internal/ResolveClientBean;
      //   125: invokevirtual register : (Lcom/huawei/hms/common/internal/ResolveClientBean;)V
      //   128: aload_0
      //   129: getfield mClient : Lcom/huawei/hms/common/internal/AnyClient;
      //   132: iload_1
      //   133: invokeinterface connect : (I)V
      //   138: aload_0
      //   139: monitorexit
      //   140: return
      //   141: astore_2
      //   142: aload_0
      //   143: monitorexit
      //   144: aload_2
      //   145: athrow
      // Exception table:
      //   from	to	target	type
      //   2	33	141	finally
      //   36	57	141	finally
      //   60	93	141	finally
      //   93	115	141	finally
      //   118	128	141	finally
      //   128	138	141	finally
    }
    
    boolean disconnect() {
      Checker.assertHandlerThread(HuaweiApiManager.this.mHandler);
      this.mClient.disconnect();
      return true;
    }
    
    public void onConnected() {
      HMSLog.d("HuaweiApiManager", "onConnected");
      BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
      this.mResolveClientBean = null;
      if (Looper.myLooper() == HuaweiApiManager.this.mHandler.getLooper()) {
        innerConnected();
        return;
      } 
      HuaweiApiManager.this.mHandler.post(new Runnable() {
            public void run() {
              HuaweiApiManager.ConnectionManager.this.innerConnected();
            }
          });
    }
    
    public void onConnectionFailed(final ConnectionResult result) {
      HMSLog.i("HuaweiApiManager", "onConnectionFailed");
      BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
      this.mResolveClientBean = null;
      if (Looper.myLooper() == HuaweiApiManager.this.mHandler.getLooper()) {
        innerConnectionFailed(result);
        return;
      } 
      HuaweiApiManager.this.mHandler.post(new Runnable() {
            public void run() {
              HuaweiApiManager.ConnectionManager.this.innerConnectionFailed(result);
            }
          });
    }
    
    public void onConnectionSuspended(final int cause) {
      HMSLog.i("HuaweiApiManager", "onConnectionSuspended");
      BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
      this.mResolveClientBean = null;
      if (Looper.myLooper() == HuaweiApiManager.this.mHandler.getLooper()) {
        innerConnectionSuspended(cause);
        return;
      } 
      HuaweiApiManager.this.mHandler.post(new Runnable() {
            public void run() {
              HuaweiApiManager.ConnectionManager.this.innerConnectionSuspended(cause);
            }
          });
    }
    
    void sendRequest(TaskApiCallWrapper param1TaskApiCallWrapper) {
      HMSLog.i("HuaweiApiManager", "sendRequest");
      Checker.assertHandlerThread(HuaweiApiManager.this.mHandler);
      HuaweiApiManager.TaskApiCallbackWrapper taskApiCallbackWrapper = wrapperRequest(param1TaskApiCallWrapper);
      int i = param1TaskApiCallWrapper.getTaskApiCall().getMinApkVersion();
      if (this.mClient.isConnected()) {
        if (HMSPackageManager.getInstance(this.mApi.getContext()).hmsVerHigherThan(i)) {
          postMessage(taskApiCallbackWrapper);
          return;
        } 
        disconnect();
        this.callbackQueue.add(taskApiCallbackWrapper);
        connect(i);
        return;
      } 
      this.callbackQueue.add(taskApiCallbackWrapper);
      ConnectionResult connectionResult = this.mConnectionResult;
      if (connectionResult != null && connectionResult.getErrorCode() != 0) {
        onConnectionFailed(this.mConnectionResult);
        return;
      } 
      connect(i);
    }
  }
  
  class null implements AnyClient.CallBack {
    private AtomicBoolean isFirstRsp = new AtomicBoolean(true);
    
    public void onCallback(IMessageEntity param1IMessageEntity, String param1String) {
      if (!(param1IMessageEntity instanceof ResponseHeader)) {
        HMSLog.e("HuaweiApiManager", "header is not instance of ResponseHeader");
        return;
      } 
      param1IMessageEntity = param1IMessageEntity;
      if (!TextUtils.isEmpty(param1IMessageEntity.getResolution())) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response has resolution: ");
        stringBuilder.append(param1IMessageEntity.getResolution());
        HMSLog.e("HuaweiApiManager", stringBuilder.toString());
      } 
      if (this.isFirstRsp.compareAndSet(true, false))
        HiAnalyticsInnerClient.reportEntryExit(this.this$1.mApi.getContext(), (ResponseHeader)param1IMessageEntity, String.valueOf(this.this$1.mApi.getKitSdkVersion())); 
      req.getTaskApiCall().onResponse(this.this$1.mClient, (ResponseErrorCode)param1IMessageEntity, param1String, req.getTaskCompletionSource());
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.innerConnectionFailed(result);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.innerConnected();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.innerConnectionSuspended(cause);
    }
  }
  
  static class TaskApiCallbackWrapper {
    private final TaskApiCallWrapper mApiCallWrapper;
    
    private final AnyClient.CallBack mCallBack;
    
    TaskApiCallbackWrapper(TaskApiCallWrapper param1TaskApiCallWrapper, AnyClient.CallBack param1CallBack) {
      this.mApiCallWrapper = param1TaskApiCallWrapper;
      this.mCallBack = param1CallBack;
    }
    
    TaskApiCallWrapper getApiCallWrapper() {
      return this.mApiCallWrapper;
    }
    
    AnyClient.CallBack getCallBack() {
      return this.mCallBack;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\HuaweiApiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */