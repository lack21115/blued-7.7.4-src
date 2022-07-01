package com.qq.e.comm.pi;

public interface AdData {
  boolean equalsAdData(AdData paramAdData);
  
  int getAdPatternType();
  
  String getDesc();
  
  int getECPM();
  
  String getECPMLevel();
  
  <T> T getProperty(Class<T> paramClass);
  
  String getProperty(String paramString);
  
  String getTitle();
  
  int getVideoDuration();
  
  public static interface VideoPlayer {
    int getCurrentPosition();
    
    int getDuration();
    
    int getVideoState();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\AdData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */