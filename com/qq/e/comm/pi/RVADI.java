package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.comm.constants.LoadAdParams;

public interface RVADI {
  String getAdNetWorkName();
  
  int getECPM();
  
  String getECPMLevel();
  
  long getExpireTimestamp();
  
  int getRewardAdType();
  
  int getVideoDuration();
  
  boolean hasShown();
  
  void loadAD();
  
  void setLoadAdParams(LoadAdParams paramLoadAdParams);
  
  void setVolumeOn(boolean paramBoolean);
  
  void showAD();
  
  void showAD(Activity paramActivity);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\RVADI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */