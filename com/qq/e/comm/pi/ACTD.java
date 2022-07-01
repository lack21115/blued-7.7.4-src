package com.qq.e.comm.pi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public interface ACTD {
  public static final String APPID_KEY = "appid";
  
  public static final String DELEGATE_NAME_KEY = "gdt_activity_delegate_name";
  
  void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  void onAfterCreate(Bundle paramBundle);
  
  void onBackPressed();
  
  void onBeforeCreate(Bundle paramBundle);
  
  void onConfigurationChanged(Configuration paramConfiguration);
  
  void onDestroy();
  
  void onPause();
  
  void onResume();
  
  void onStop();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\ACTD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */