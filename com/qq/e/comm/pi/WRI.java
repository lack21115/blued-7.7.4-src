package com.qq.e.comm.pi;

public interface WRI {
  public static final int EVENT_ACTIVITY_GO_BACK = 10;
  
  public static final int EVENT_ACTIVITY_PAUSE = 11;
  
  public static final int EVENT_BEFORE_ACTIVITY_FINISH = 12;
  
  public static final int EVENT_LOAD_ERROR = 3;
  
  public static final int EVENT_LOAD_FINISH = 2;
  
  public static final int EVENT_LOAD_START = 1;
  
  void report(String paramString, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\WRI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */