package com.baidu.mobad.feeds;

public enum NativeErrorCode {
  CONFIG_ERROR, INTERNAL_ERROR, LOAD_AD_FAILED, UNKNOWN;
  
  static {
    LOAD_AD_FAILED = new NativeErrorCode("LOAD_AD_FAILED", 1);
    INTERNAL_ERROR = new NativeErrorCode("INTERNAL_ERROR", 2);
    CONFIG_ERROR = new NativeErrorCode("CONFIG_ERROR", 3);
    a = new NativeErrorCode[] { UNKNOWN, LOAD_AD_FAILED, INTERNAL_ERROR, CONFIG_ERROR };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\NativeErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */