package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class f implements Runnable {
  public Context a;
  
  public f(Context paramContext) {
    this.a = paramContext;
  }
  
  public void run() {
    try {
      int i = ErrorEnum.SUCCESS.getInternalCode();
      String str = null;
      try {
        String str1 = HmsInstanceId.getInstance(this.a).getToken(Util.getAppId(this.a), null);
        str = str1;
        HMSLog.i("AutoInit", "Push init succeed");
        str = str1;
        boolean bool = TextUtils.isEmpty(str1);
        str = str1;
        if (bool)
          return; 
      } catch (ApiException apiException) {
        i = apiException.getStatusCode();
        HMSLog.e("AutoInit", "Push init failed");
      } 
      try {
        ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
        if (applicationInfo.metaData != null) {
          Bundle bundle = applicationInfo.metaData;
          if (bundle.getString("com.huawei.hms.client.service.name:push") != null) {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.a.getPackageName());
            Bundle bundle1 = new Bundle();
            bundle1.putString("message_type", "new_token");
            bundle1.putString("device_token", str);
            bundle1.putInt("error", i);
            boolean bool = (new h()).a(this.a, bundle1, intent);
            if (!bool) {
              HMSLog.e("AutoInit", "start service failed");
              return;
            } 
            return;
          } 
        } 
        HMSLog.i("AutoInit", "push kit sdk not exists");
        return;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        HMSLog.i("AutoInit", "push kit sdk not exists");
      } 
      return;
    } catch (Exception exception) {
      HMSLog.e("AutoInit", "Push init failed", exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */