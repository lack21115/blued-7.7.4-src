package com.huawei.hianalytics.ab.fg;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.kl.cd;

public final class ab {
  private static ab bc;
  
  private static final Object cd = new Object();
  
  private Context ab;
  
  public static ab bc() {
    if (bc == null)
      cd(); 
    return bc;
  }
  
  private static void cd() {
    // Byte code:
    //   0: ldc com/huawei/hianalytics/ab/fg/ab
    //   2: monitorenter
    //   3: getstatic com/huawei/hianalytics/ab/fg/ab.bc : Lcom/huawei/hianalytics/ab/fg/ab;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/hianalytics/ab/fg/ab
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/hianalytics/ab/fg/ab.bc : Lcom/huawei/hianalytics/ab/fg/ab;
    //   19: ldc com/huawei/hianalytics/ab/fg/ab
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/huawei/hianalytics/ab/fg/ab
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
  }
  
  public void ab() {
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "clearCachedData() is execute.");
    if (this.ab == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "clearCachedData() sdk is not init");
      return;
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsDataManager.clearCachedData() is execute.");
    com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "stat_v2_1", new String[0]);
    com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "cached_v2_1", new String[0]);
  }
  
  public void ab(Context paramContext) {
    synchronized (cd) {
      if (this.ab != null) {
        com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "DataManager already initialized.");
        return;
      } 
      this.ab = paramContext;
      com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().ab(this.ab);
      com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().fg(paramContext.getPackageName());
      com.huawei.hianalytics.ab.cd.bc.ab.ab().ab(paramContext);
      return;
    } 
  }
  
  public void ab(String paramString) {
    if (this.ab == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "clearDataByTag() sdk is not init");
      return;
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsDataManager.clearDataByTag(String appid) is execute.");
    com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, paramString);
  }
  
  public void bc(String paramString) {
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
    Context context = this.ab;
    if (context == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "sdk is not init");
      return;
    } 
    paramString = cd.ab("appID", paramString, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName());
    com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().ef(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\fg\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */