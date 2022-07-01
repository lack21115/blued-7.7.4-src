package com.baidu.mobads.constants;

public class XAdSDKProxyVersion {
  public static final String BAIDU_AD_SDK_VERSION = "";
  
  public static final Boolean DEBUG;
  
  public static final int MAJOR_VERSION_NUMBER = 0;
  
  public static final int MINOR_VERSION_NUMBER = 0;
  
  public static final Boolean MODIFIED;
  
  public static final String REAL_RELEASE_TAG = "";
  
  public static final String RELEASE_TAG = "8.8283";
  
  public static final String SVN_REVISION_FINAL = "";
  
  public static final String SVN_TREE = "";
  
  public static final String TIME_STAMP = "";
  
  public static final String URL = "";
  
  static {
    Boolean bool = Boolean.valueOf(false);
    DEBUG = bool;
    MODIFIED = bool;
  }
  
  public static int getMajorVersionNumber() {
    try {
      return Integer.valueOf("8.8283".split("\\.")[0]).intValue();
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public static double getVersion() {
    try {
      return Double.parseDouble("8.8283");
    } catch (Exception exception) {
      return 0.0D;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\constants\XAdSDKProxyVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */