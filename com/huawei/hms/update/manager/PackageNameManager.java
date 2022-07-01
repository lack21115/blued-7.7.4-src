package com.huawei.hms.update.manager;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.Serializable;

public class PackageNameManager {
  private static final Object a = new Object();
  
  private static PackageNameManager b;
  
  private Context c;
  
  private PackageNameManager(Context paramContext) {
    this.c = paramContext;
  }
  
  public static PackageNameManager getInstance(Context paramContext) {
    synchronized (a) {
      if (b == null)
        b = new PackageNameManager(paramContext); 
      return b;
    } 
  }
  
  public void queryPackageName(QueryPublishCallback paramQueryPublishCallback) {
    UpdateSdkAPI.checkTargetAppUpdate(this.c, "com.huawei.hms", new CheckUpdateCallBack(this, paramQueryPublishCallback) {
          public void onMarketInstallInfo(Intent param1Intent) {
            if (HMSPublishStateHolder.getPublishState() != 1)
              HMSPublishStateHolder.setPublishState(2); 
            this.a.onQueryResult();
          }
          
          public void onMarketStoreError(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onMarketStoreError responseCode: ");
            stringBuilder.append(param1Int);
            HMSLog.e("PackageNameManager", stringBuilder.toString());
            if (HMSPublishStateHolder.getPublishState() != 1)
              HMSPublishStateHolder.setPublishState(2); 
            this.a.onQueryResult();
          }
          
          public void onUpdateInfo(Intent param1Intent) {
            if (param1Intent != null)
              try {
                int i = param1Intent.getIntExtra("status", -99);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CheckUpdateCallBack status is ");
                stringBuilder.append(i);
                HMSLog.i("PackageNameManager", stringBuilder.toString());
                String str = param1Intent.getStringExtra("failreason");
                if (!TextUtils.isEmpty(str)) {
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("checkTargetAppUpdate reason is ");
                  stringBuilder1.append(str);
                  HMSLog.e("PackageNameManager", stringBuilder1.toString());
                } 
                if (i == 7) {
                  Serializable serializable = param1Intent.getSerializableExtra("updatesdk_update_info");
                  if (serializable instanceof ApkUpgradeInfo && ((ApkUpgradeInfo)serializable).getPackage_().equalsIgnoreCase("com.huawei.hms")) {
                    HMSLog.i("PackageNameManager", "com.huawei.hms has already be published");
                    HMSPublishStateHolder.setPublishState(1);
                  } 
                } 
              } catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("intent has some error");
                stringBuilder.append(exception.getMessage());
                HMSLog.e("PackageNameManager", stringBuilder.toString());
              }  
            if (HMSPublishStateHolder.getPublishState() != 1)
              HMSPublishStateHolder.setPublishState(2); 
            this.a.onQueryResult();
          }
          
          public void onUpdateStoreError(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onUpdateStoreError responseCode: ");
            stringBuilder.append(param1Int);
            HMSLog.e("PackageNameManager", stringBuilder.toString());
            if (HMSPublishStateHolder.getPublishState() != 1)
              HMSPublishStateHolder.setPublishState(2); 
            this.a.onQueryResult();
          }
        });
  }
  
  public static interface QueryPublishCallback {
    void onQueryResult();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\manager\PackageNameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */