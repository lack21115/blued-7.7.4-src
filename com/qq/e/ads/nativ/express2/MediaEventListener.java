package com.qq.e.ads.nativ.express2;

public interface MediaEventListener {
  public static final int EVENT_VIDEO_CACHE = 201;
  
  public static final int EVENT_VIDEO_COMPLETE = 206;
  
  public static final int EVENT_VIDEO_DO_DOWNLOAD = 208;
  
  public static final int EVENT_VIDEO_ERROR = 207;
  
  public static final int EVENT_VIDEO_PAUSE = 204;
  
  public static final int EVENT_VIDEO_RESUME = 203;
  
  public static final int EVENT_VIDEO_START = 202;
  
  public static final int EVENT_VIDEO_STOP = 205;
  
  void onVideoCache();
  
  void onVideoComplete();
  
  void onVideoError();
  
  void onVideoPause();
  
  void onVideoResume();
  
  void onVideoStart();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\express2\MediaEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */