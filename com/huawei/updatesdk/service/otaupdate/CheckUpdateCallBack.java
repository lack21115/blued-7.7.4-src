package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public interface CheckUpdateCallBack {
  void onMarketInstallInfo(Intent paramIntent);
  
  void onMarketStoreError(int paramInt);
  
  void onUpdateInfo(Intent paramIntent);
  
  void onUpdateStoreError(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\CheckUpdateCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */