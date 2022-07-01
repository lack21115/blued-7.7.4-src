package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

public class BindingFailedResolution implements ServiceConnection, IBridgeActivityDelegate {
  private static final Object a = new Object();
  
  private Activity b;
  
  private boolean c = true;
  
  private a d;
  
  private Handler e = null;
  
  private Handler f = null;
  
  private void a() {
    Handler handler = this.f;
    if (handler != null) {
      handler.removeMessages(3);
    } else {
      this.f = new Handler(Looper.getMainLooper(), new Handler.Callback(this) {
            public boolean handleMessage(Message param1Message) {
              if (param1Message == null || param1Message.what != 3)
                return false; 
              BindingFailedResolution.a(this.a, 8);
              return true;
            }
          });
    } 
    this.f.sendEmptyMessageDelayed(3, 2000L);
  }
  
  private void a(int paramInt) {
    Activity activity = getActivity();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("finishBridgeActivity：");
      stringBuilder.append(paramInt);
      HMSLog.i("BindingFailedResolution", stringBuilder.toString());
      Intent intent = new Intent();
      intent.putExtra("intent.extra.RESULT", paramInt);
      activity.setResult(-1, intent);
      activity.finish();
    } 
  }
  
  private void a(Activity paramActivity) {
    Intent intent = new Intent();
    intent.setClassName(HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName(), "com.huawei.hms.core.activity.JumpActivity");
    HMSLog.i("BindingFailedResolution", "onBridgeActivityCreate：try to start HMS");
    try {
      return;
    } finally {
      paramActivity = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ActivityNotFoundException：");
      stringBuilder.append(paramActivity.getMessage());
      HMSLog.e("BindingFailedResolution", stringBuilder.toString());
      Handler handler = this.f;
      if (handler != null) {
        handler.removeMessages(3);
        this.f = null;
      } 
      b();
    } 
  }
  
  private void a(boolean paramBoolean) {
    if (this.c) {
      this.c = false;
      onStartResult(paramBoolean);
    } 
  }
  
  private void b() {
    null = getActivity();
    if (null == null) {
      HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
      a(false);
      return;
    } 
    Intent intent = new Intent("com.huawei.hms.core.aidlservice");
    intent.setPackage(HMSPackageManager.getInstance(null.getApplicationContext()).getHMSPackageName());
    synchronized (a) {
      if (null.bindService(intent, this, 1)) {
        c();
        return;
      } 
      HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
      a(false);
      return;
    } 
  }
  
  private void c() {
    Handler handler = this.e;
    if (handler != null) {
      handler.removeMessages(2);
    } else {
      this.e = new Handler(Looper.getMainLooper(), new Handler.Callback(this) {
            public boolean handleMessage(Message param1Message) {
              if (param1Message != null) {
                if (param1Message.what != 2)
                  return false; 
                HMSLog.e("BindingFailedResolution", "In connect, bind core try timeout");
                BindingFailedResolution.a(this.a, false);
                return true;
              } 
              return false;
            }
          });
    } 
    this.e.sendEmptyMessageDelayed(2, 5000L);
  }
  
  private void d() {
    synchronized (a) {
      if (this.e != null) {
        this.e.removeMessages(2);
        this.e = null;
      } 
      return;
    } 
  }
  
  private void e() {
    Activity activity = getActivity();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      a a1 = this.d;
      if (a1 == null) {
        this.d = new a();
      } else {
        a1.dismiss();
      } 
      HMSLog.e("BindingFailedResolution", "showPromptdlg to resolve conn error");
      this.d.show(activity, new AbstractDialog.Callback(this) {
            public void onCancel(AbstractDialog param1AbstractDialog) {
              BindingFailedResolution.a(this.a, (BindingFailedResolution.a)null);
              BindResolveClients.getInstance().unRegisterAll();
              BindingFailedResolution.a(this.a, 8);
            }
            
            public void onDoWork(AbstractDialog param1AbstractDialog) {
              BindingFailedResolution.a(this.a, (BindingFailedResolution.a)null);
              BindResolveClients.getInstance().unRegisterAll();
              BindingFailedResolution.a(this.a, 8);
            }
          });
    } 
  }
  
  protected Activity getActivity() {
    return this.b;
  }
  
  public int getRequestCode() {
    return 2003;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    this.b = paramActivity;
    a.a.a(this.b);
    a();
    a(paramActivity);
  }
  
  public void onBridgeActivityDestroy() {
    d();
    a.a.b(this.b);
    this.b = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 != getRequestCode())
      return false; 
    HMSLog.i("BindingFailedResolution", "onBridgeActivityResult");
    Handler handler = this.f;
    if (handler != null) {
      handler.removeMessages(3);
      this.f = null;
    } 
    b();
    return true;
  }
  
  public void onBridgeConfigurationChanged() {
    if (this.d == null)
      return; 
    HMSLog.i("BindingFailedResolution", "re show prompt dialog");
    e();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    HMSLog.i("BindingFailedResolution", "On key up when resolve conn error");
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    d();
    a(true);
    Activity activity = getActivity();
    if (activity == null)
      return; 
    Util.unBindServiceCatchException((Context)activity, this);
    HMSLog.i("BindingFailedResolution", "test connect success, try to reConnect and reply message");
    BindResolveClients.getInstance().notifyClientReconnect();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  protected void onStartResult(boolean paramBoolean) {
    if (getActivity() == null)
      return; 
    if (paramBoolean) {
      a(0);
      return;
    } 
    e();
  }
  
  static class a extends AbstractPromptDialog {
    private a() {}
    
    public String onGetMessageString(Context param1Context) {
      return ResourceLoaderUtil.getString("hms_bindfaildlg_message", new Object[] { Util.getAppName(param1Context, null), Util.getAppName(param1Context, HMSPackageManager.getInstance(param1Context).getHMSPackageName()) });
    }
    
    public String onGetPositiveButtonString(Context param1Context) {
      return ResourceLoaderUtil.getString("hms_confirm");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\BindingFailedResolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */