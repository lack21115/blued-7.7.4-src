package com.qq.e.comm.pi;

import android.app.Activity;

public interface RVADI2 {
  void destroy();
  
  String getECPMLevel();
  
  long getExpireTimestamp();
  
  int getVideoDuration();
  
  boolean hasShown();
  
  boolean isVideoCached();
  
  void loadAD();
  
  void setVolumeOn(boolean paramBoolean);
  
  void showAD(Activity paramActivity);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\RVADI2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */