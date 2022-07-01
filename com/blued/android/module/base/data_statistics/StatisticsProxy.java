package com.blued.android.module.base.data_statistics;

import com.blued.android.module.base.base.BaseProxy;

public class StatisticsProxy extends BaseProxy<IStatistics> implements IStatistics {
  private static StatisticsProxy b;
  
  public static StatisticsProxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/data_statistics/StatisticsProxy.b : Lcom/blued/android/module/base/data_statistics/StatisticsProxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/data_statistics/StatisticsProxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/data_statistics/StatisticsProxy.b : Lcom/blued/android/module/base/data_statistics/StatisticsProxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/data_statistics/StatisticsProxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/data_statistics/StatisticsProxy.b : Lcom/blued/android/module/base/data_statistics/StatisticsProxy;
    //   25: ldc com/blued/android/module/base/data_statistics/StatisticsProxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/data_statistics/StatisticsProxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/data_statistics/StatisticsProxy.b : Lcom/blued/android/module/base/data_statistics/StatisticsProxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(int paramInt1, String paramString, int paramInt2) {
    if (this.a != null)
      ((IStatistics)this.a).a(paramInt1, paramString, paramInt2); 
  }
  
  public void a(String paramString) {
    if (this.a != null)
      ((IStatistics)this.a).a(paramString); 
  }
  
  public void a(String paramString, int paramInt) {
    if (this.a != null)
      ((IStatistics)this.a).a(paramString, paramInt); 
  }
  
  public void a(String paramString, Object paramObject) {
    if (this.a != null)
      ((IStatistics)this.a).a(paramString, paramObject); 
  }
  
  public void a(String paramString1, String paramString2) {
    if (this.a != null)
      ((IStatistics)this.a).a(paramString1, paramString2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\data_statistics\StatisticsProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */