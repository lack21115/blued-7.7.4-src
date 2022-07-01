package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

public interface IBridgeActivityDelegate {
  int getRequestCode();
  
  void onBridgeActivityCreate(Activity paramActivity);
  
  void onBridgeActivityDestroy();
  
  boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  void onBridgeConfigurationChanged();
  
  void onKeyUp(int paramInt, KeyEvent paramKeyEvent);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\activity\IBridgeActivityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */