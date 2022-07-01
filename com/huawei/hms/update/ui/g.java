package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class g extends a {
  private boolean d() {
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return false; 
      if (this.c == null)
        return false; 
      if (TextUtils.isEmpty(this.j))
        return false; 
      try {
        ResourceLoaderUtil.setmContext((Context)activity);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ResourceLoaderUtil.getString("hms_base_vmall"));
        stringBuilder.append(this.j);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
        intent.setFlags(268435456);
        activity.startActivityForResult(intent, getRequestCode());
        a(0, this.f);
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {
        HMSLog.e("HiappWebWizard", "can not find web to hold update hms apk");
      } 
    } 
    return false;
  }
  
  void a() {
    b(13, this.f);
  }
  
  public void a(b paramb) {
    HMSLog.d("HiappWebWizard", "Enter onCancel.");
    if (paramb instanceof i)
      a(); 
  }
  
  void a(Class<? extends b> paramClass) {
    c();
    try {
      b b = paramClass.newInstance();
      if (!TextUtils.isEmpty(this.h) && b instanceof i) {
        this.h = ResourceLoaderUtil.getString("hms_update_title");
        ((i)b).a(this.h);
      } 
      b.a(this);
      this.d = b;
      return;
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalStateException illegalStateException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In showDialog, Failed to show the dialog.");
    stringBuilder.append(illegalStateException.getMessage());
    HMSLog.e("HiappWebWizard", stringBuilder.toString());
  }
  
  public void b(b paramb) {
    HMSLog.d("HiappWebWizard", "Enter onDoWork.");
    if (paramb instanceof i) {
      paramb.c();
      if (!d())
        b(8, this.f); 
    } 
  }
  
  public int getRequestCode() {
    return 2004;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null)
      return; 
    this.f = 4;
    if (this.c.isNeedConfirm() && !TextUtils.isEmpty(this.h)) {
      a((Class)i.class);
      return;
    } 
    if (!d())
      b(8, this.f); 
  }
  
  public void onBridgeActivityDestroy() {
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    return false;
  }
  
  public void onBridgeConfigurationChanged() {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (4 == paramInt) {
      HMSLog.i("HiappWebWizard", "In onKeyUp, Call finish.");
      Activity activity = b();
      if (activity != null && !activity.isFinishing()) {
        activity.setResult(0, null);
        activity.finish();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */