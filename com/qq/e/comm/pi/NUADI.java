package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

public interface NUADI extends ADI {
  String getAdNetWorkName();
  
  void loadData(int paramInt);
  
  void loadData(int paramInt, LoadAdParams paramLoadAdParams);
  
  void setCategories(List<String> paramList);
  
  void setMaxVideoDuration(int paramInt);
  
  void setMinVideoDuration(int paramInt);
  
  void setVastClassName(String paramString);
  
  void setVideoADContainerRender(int paramInt);
  
  void setVideoPlayPolicy(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\NUADI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */