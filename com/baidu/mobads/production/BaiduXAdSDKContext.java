package com.baidu.mobads.production;

import com.baidu.mobads.f.g;

public class BaiduXAdSDKContext {
  protected static Boolean isRemoteLoadSuccess = Boolean.valueOf(false);
  
  public static g mApkLoader;
  
  public static void exit() {
    mApkLoader = null;
    isRemoteLoadSuccess = Boolean.valueOf(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\BaiduXAdSDKContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */