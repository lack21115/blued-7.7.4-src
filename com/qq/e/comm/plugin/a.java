package com.qq.e.comm.plugin;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;

public class a {
  private static volatile a a;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/a.a : Lcom/qq/e/comm/plugin/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/a
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/a.a : Lcom/qq/e/comm/plugin/a;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/a.a : Lcom/qq/e/comm/plugin/a;
    //   25: ldc com/qq/e/comm/plugin/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/a.a : Lcom/qq/e/comm/plugin/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public String b() {
    return (SDKStatus.getSDKVersionCode() >= 60) ? GDTADManager.getInstance().getSM().getSettingDir() : "e_qq_com_setting";
  }
  
  public Integer c() {
    if (SDKStatus.getSDKVersionCode() >= 50)
      try {
        return GlobalSetting.getChannel();
      } finally {
        Exception exception = null;
      }  
    return null;
  }
  
  public boolean d() {
    boolean bool;
    if (GDTADManager.getInstance().getSM().getInteger("ubulap", 1) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    return (bool && SDKStatus.getSDKVersionCode() >= 120);
  }
  
  public boolean e() {
    boolean bool;
    if (GDTADManager.getInstance().getSM().getInteger("rvaulap", 1) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    return (bool && SDKStatus.getSDKVersionCode() >= 120);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */