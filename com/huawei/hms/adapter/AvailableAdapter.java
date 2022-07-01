package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public class AvailableAdapter {
  private static AtomicBoolean c = new AtomicBoolean(false);
  
  private static int d = 0;
  
  private final int a;
  
  private AvailableCallBack b;
  
  private SystemObserver e = new SystemObserver(this) {
      public boolean onSolutionResult(Intent param1Intent, String param1String) {
        return false;
      }
      
      public boolean onUpdateResult(int param1Int) {
        AvailableAdapter.AvailableCallBack availableCallBack = AvailableAdapter.a(this.a);
        if (availableCallBack == null) {
          HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
          return true;
        } 
        availableCallBack.onComplete(param1Int);
        AvailableAdapter.a(param1Int);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("user response ");
        stringBuilder.append(AvailableAdapter.a());
        HMSLog.i("AvailableAdapter", stringBuilder.toString());
        AvailableAdapter.b().set(false);
        return true;
      }
    };
  
  public AvailableAdapter(int paramInt) {
    this.a = paramInt;
  }
  
  private AvailableCallBack c() {
    return this.b;
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext) {
    Checker.checkNonNull(paramContext, "context must not be null.");
    if (Build.VERSION.SDK_INT < 16) {
      HMSLog.i("AvailableAdapter", "HMS can not be supported under android 4.1");
      return 21;
    } 
    HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(paramContext);
    PackageManagerHelper.PackageStates packageStates = hMSPackageManager.getHMSPackageStates();
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates)) {
      HMSLog.i("AvailableAdapter", "HMS is not installed");
      return 1;
    } 
    if (PackageManagerHelper.PackageStates.DISABLED.equals(packageStates)) {
      HMSLog.i("AvailableAdapter", "HMS is disabled");
      return 3;
    } 
    if (hMSPackageManager.isApkUpdateNecessary(this.a)) {
      HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
      return 2;
    } 
    return 0;
  }
  
  public boolean isUserResolvableError(int paramInt) {
    return !(paramInt != 1 && paramInt != 2);
  }
  
  public void startResolution(Activity paramActivity, AvailableCallBack paramAvailableCallBack) {
    boolean bool;
    int j = HMSPackageManager.getInstance((Context)paramActivity).getHmsVersionCode();
    int i = 0;
    if (j >= 40000000) {
      HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
      bool = true;
    } else {
      bool = false;
    } 
    if (c.compareAndSet(false, true)) {
      HMSLog.i("AvailableAdapter", "Start to resolution for the 1st time.");
    } else if (Looper.getMainLooper() == Looper.myLooper()) {
      HMSLog.i("AvailableAdapter", "main thread invokes resolution.");
    } else {
      HMSLog.i("AvailableAdapter", "Another thread start to resolution.");
      while (true) {
        if (c.get()) {
          if (i >= 300) {
            HMSLog.i("AvailableAdapter", "Previous popup is not handled by user or download has not finished within 1min.");
            if (paramAvailableCallBack != null)
              paramAvailableCallBack.onComplete(27); 
            return;
          } 
          try {
            HMSLog.d("AvailableAdapter", "Concurrent startResolution thread is waiting.");
            Thread.sleep(200L);
            i++;
          } catch (InterruptedException interruptedException) {
            HMSLog.d("AvailableAdapter", "Concurrent startResolution thread waiting is interrupted.");
          } 
          continue;
        } 
        HMSLog.i("AvailableAdapter", "Concurrent startResolution thread waiting finished.");
        if (paramAvailableCallBack != null)
          paramAvailableCallBack.onComplete(d); 
        return;
      } 
    } 
    HMSLog.i("AvailableAdapter", "startResolution");
    if (interruptedException != null) {
      if (paramAvailableCallBack == null)
        return; 
      this.b = paramAvailableCallBack;
      SystemManager.getSystemNotifier().registerObserver(this.e);
      Intent intent = BridgeActivity.getIntentStartBridgeActivity((Activity)interruptedException, UpdateAdapter.class.getName());
      intent.putExtra("update_version", this.a);
      intent.putExtra("new_update", bool);
      interruptedException.startActivity(intent);
    } 
  }
  
  public static interface AvailableCallBack {
    void onComplete(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapter\AvailableAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */