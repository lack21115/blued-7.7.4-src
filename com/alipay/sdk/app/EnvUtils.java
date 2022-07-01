package com.alipay.sdk.app;

public class EnvUtils {
  private static EnvEnum mEnv = EnvEnum.ONLINE;
  
  public static EnvEnum geEnv() {
    return mEnv;
  }
  
  public static boolean isSandBox() {
    return (mEnv == EnvEnum.SANDBOX);
  }
  
  public static void setEnv(EnvEnum paramEnvEnum) {
    mEnv = paramEnvEnum;
  }
  
  public enum EnvEnum {
    ONLINE, SANDBOX;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\EnvUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */