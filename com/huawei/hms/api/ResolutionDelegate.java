package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class ResolutionDelegate implements IBridgeActivityDelegate {
  public static final String CALLBACK_METHOD = "CALLBACK_METHOD";
  
  private WeakReference<Activity> a;
  
  private BusResponseCallback a(String paramString) {
    return ForegroundBusResponseMgr.getInstance().get(paramString);
  }
  
  private void a() {
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return; 
      activity.finish();
    } 
  }
  
  private Activity b() {
    WeakReference<Activity> weakReference = this.a;
    return (weakReference == null) ? null : weakReference.get();
  }
  
  public int getRequestCode() {
    return 1002;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    this.a = new WeakReference<Activity>(paramActivity);
    Bundle bundle = paramActivity.getIntent().getExtras();
    if (bundle != null)
      paramActivity.startActivityForResult((Intent)bundle.getParcelable("resolution"), 1002); 
  }
  
  public void onBridgeActivityDestroy() {
    this.a = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 != getRequestCode())
      return false; 
    BusResponseCallback busResponseCallback = a("CALLBACK_METHOD");
    Activity activity = this.a.get();
    paramInt1 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable((Context)activity, 30000000);
    if (paramInt2 == -1 && paramInt1 == 0) {
      HMSLog.i("ResolutionDelegate", "Make service available success.");
    } else {
      busResponseCallback.innerError(this.a.get(), paramInt2, "Make service available failed.");
    } 
    a();
    return true;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\ResolutionDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */