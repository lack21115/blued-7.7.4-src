package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.constants.LoadAdParams;

public interface NEADI extends ADI {
  void loadAd(int paramInt);
  
  void loadAd(int paramInt, LoadAdParams paramLoadAdParams);
  
  void setMaxVideoDuration(int paramInt);
  
  void setMinVideoDuration(int paramInt);
  
  void setVideoOption(VideoOption paramVideoOption);
  
  void setVideoPlayPolicy(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\NEADI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */