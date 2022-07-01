package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;
import java.util.List;

public class h extends a {
  private void a(Intent paramIntent) {
    List list = b().getPackageManager().queryIntentActivities(paramIntent, 65536);
    if (list != null && !list.isEmpty()) {
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add("com.huawei.appmarket.tv");
      arrayList.add("com.huawei.appmarket.car");
      arrayList.add("com.huawei.appmarket");
      if (list.size() == 1)
        return; 
      for (ResolveInfo resolveInfo : list) {
        if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
          paramIntent.setPackage(resolveInfo.activityInfo.packageName);
          break;
        } 
      } 
    } 
  }
  
  private boolean d() {
    Activity activity = b();
    if (activity != null) {
      if (activity.isFinishing())
        return false; 
      if (TextUtils.isEmpty(this.g))
        return false; 
      try {
        Intent intent = new Intent();
        intent.setAction("com.huawei.appmarket.intent.action.AppDetail");
        intent.putExtra("APP_PACKAGENAME", this.g);
        if (SystemUtils.isTVDevice()) {
          int i = (new PackageManagerHelper((Context)activity)).getPackageVersionCode("com.hisilicon.android.hiRMService");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("version ");
          stringBuilder.append(i);
          HMSLog.i("HiappWizard", stringBuilder.toString());
          if (i == 1) {
            HMSLog.i("HiappWizard", "startActivity");
            intent.addFlags(268435456);
            a(intent);
            activity.startActivity(intent);
            return true;
          } 
        } 
        HMSLog.i("HiappWizard", "startActivityForResult");
        a(intent);
        activity.startActivityForResult(intent, getRequestCode());
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {
        HMSLog.e("HiappWizard", "can not open hiapp");
      } 
    } 
    return false;
  }
  
  void a() {
    b(13, this.f);
  }
  
  public void a(b paramb) {
    HMSLog.i("HiappWizard", "Enter onCancel.");
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
    HMSLog.e("HiappWizard", stringBuilder.toString());
  }
  
  public void b(b paramb) {
    HMSLog.i("HiappWizard", "Enter onDoWork.");
    if (paramb instanceof i) {
      paramb.c();
      if (!d()) {
        if (!a(false)) {
          b(8, this.f);
          return;
        } 
        a(8, this.f);
      } 
    } 
  }
  
  public int getRequestCode() {
    return 2005;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity) {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null)
      return; 
    this.f = 5;
    if (this.c.isNeedConfirm() && !TextUtils.isEmpty(this.h)) {
      a((Class)i.class);
      return;
    } 
    if (!d()) {
      if (!a(false)) {
        b(8, this.f);
        return;
      } 
      a(8, this.f);
    } 
  }
  
  public void onBridgeActivityDestroy() {
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.e && this.b != null)
      return this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent); 
    if (this.f == 5 && paramInt1 == getRequestCode()) {
      if (a(this.g, this.i)) {
        b(0, this.f);
      } else {
        b(8, this.f);
      } 
      return true;
    } 
    return false;
  }
  
  public void onBridgeConfigurationChanged() {
    super.onBridgeConfigurationChanged();
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (this.e && this.b != null) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
      return;
    } 
    if (4 == paramInt) {
      HMSLog.i("HiappWizard", "In onKeyUp, Call finish.");
      Activity activity = b();
      if (activity != null && !activity.isFinishing()) {
        activity.setResult(0, null);
        activity.finish();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */