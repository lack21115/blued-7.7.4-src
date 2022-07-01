package com.blued.android.module.external_sense_library.utils;

public class SenseLibSPMgr {
  private static SenseLibSPMgr a;
  
  private SPUtils b = new SPUtils("senseBeautyConfig");
  
  public static SenseLibSPMgr a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/external_sense_library/utils/SenseLibSPMgr.a : Lcom/blued/android/module/external_sense_library/utils/SenseLibSPMgr;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/external_sense_library/utils/SenseLibSPMgr
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/external_sense_library/utils/SenseLibSPMgr.a : Lcom/blued/android/module/external_sense_library/utils/SenseLibSPMgr;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/external_sense_library/utils/SenseLibSPMgr
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/external_sense_library/utils/SenseLibSPMgr.a : Lcom/blued/android/module/external_sense_library/utils/SenseLibSPMgr;
    //   25: ldc com/blued/android/module/external_sense_library/utils/SenseLibSPMgr
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/external_sense_library/utils/SenseLibSPMgr
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/external_sense_library/utils/SenseLibSPMgr.a : Lcom/blued/android/module/external_sense_library/utils/SenseLibSPMgr;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(String paramString) {
    SPUtils sPUtils = this.b;
    if (sPUtils != null)
      sPUtils.a("external_sense_sticker_key", paramString); 
  }
  
  public String b() {
    SPUtils sPUtils = this.b;
    return (sPUtils != null) ? sPUtils.b("external_sense_sticker_key", (String)null) : null;
  }
  
  public void b(String paramString) {
    SPUtils sPUtils = this.b;
    if (sPUtils != null)
      sPUtils.a("external_sense_filter_key", paramString); 
  }
  
  public String c() {
    SPUtils sPUtils = this.b;
    return (sPUtils != null) ? sPUtils.b("external_sense_filter_key", (String)null) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\SenseLibSPMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */