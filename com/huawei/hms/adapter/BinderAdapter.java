package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class BinderAdapter implements ServiceConnection {
  private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
  
  private static final int MSG_CONN_TIMEOUT = 1001;
  
  private static final String TAG = "BinderAdapter";
  
  private BinderCallBack callback;
  
  private String mAction;
  
  private Handler mBinderTimeoutHandler = null;
  
  private Context mContext;
  
  private String mService;
  
  public BinderAdapter(Context paramContext, String paramString1, String paramString2) {
    this.mContext = paramContext;
    this.mAction = paramString1;
    this.mService = paramString2;
  }
  
  private void bindCoreService() {
    if (TextUtils.isEmpty(this.mAction) || TextUtils.isEmpty(this.mService))
      getBindFailPendingIntent(); 
    null = new Intent(this.mAction);
    null.setPackage(this.mService);
    synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
      if (this.mContext.bindService(null, this, 1)) {
        postConnDelayHandle();
        return;
      } 
      getBindFailPendingIntent();
      return;
    } 
  }
  
  private void binderServiceFailed() {
    BinderCallBack binderCallBack = getCallBack();
    if (binderCallBack != null)
      binderCallBack.onBinderFailed(-1); 
  }
  
  private void cancelConnDelayHandle() {
    synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
      if (this.mBinderTimeoutHandler != null) {
        this.mBinderTimeoutHandler.removeMessages(1001);
        this.mBinderTimeoutHandler = null;
      } 
      return;
    } 
  }
  
  private void getBindFailPendingIntent() {
    HMSLog.e("BinderAdapter", "In connect, bind core service fail");
    ComponentName componentName = new ComponentName((this.mContext.getApplicationInfo()).packageName, "com.huawei.hms.activity.BridgeActivity");
    Intent intent = new Intent();
    intent.setComponent(componentName);
    intent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", BindingFailedResolution.class.getName());
    this.callback.onBinderFailed(-1, intent);
  }
  
  private BinderCallBack getCallBack() {
    return this.callback;
  }
  
  private void postConnDelayHandle() {
    Handler handler = this.mBinderTimeoutHandler;
    if (handler != null) {
      handler.removeMessages(1001);
    } else {
      this.mBinderTimeoutHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message param1Message) {
              if (param1Message == null || param1Message.what != 1001)
                return false; 
              HMSLog.e("BinderAdapter", "In connect, bind core service time out");
              BinderAdapter.this.binderServiceFailed();
              return true;
            }
          });
    } 
    this.mBinderTimeoutHandler.sendEmptyMessageDelayed(1001, 5000L);
  }
  
  public void binder(BinderCallBack paramBinderCallBack) {
    if (paramBinderCallBack == null)
      return; 
    this.callback = paramBinderCallBack;
    bindCoreService();
  }
  
  public void onNullBinding(ComponentName paramComponentName) {
    HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
    unBind();
    cancelConnDelayHandle();
    BinderCallBack binderCallBack = getCallBack();
    if (binderCallBack != null)
      binderCallBack.onNullBinding(paramComponentName); 
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    HMSLog.i("BinderAdapter", "Enter onServiceConnected.");
    cancelConnDelayHandle();
    BinderCallBack binderCallBack = getCallBack();
    if (binderCallBack != null)
      binderCallBack.onServiceConnected(paramComponentName, paramIBinder); 
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
    BinderCallBack binderCallBack = getCallBack();
    if (binderCallBack != null)
      binderCallBack.onServiceDisconnected(paramComponentName); 
  }
  
  public void unBind() {
    Util.unBindServiceCatchException(this.mContext, this);
  }
  
  public static interface BinderCallBack {
    void onBinderFailed(int param1Int);
    
    void onBinderFailed(int param1Int, Intent param1Intent);
    
    void onNullBinding(ComponentName param1ComponentName);
    
    void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
    
    void onServiceDisconnected(ComponentName param1ComponentName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapter\BinderAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */