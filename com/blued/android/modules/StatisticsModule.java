package com.blued.android.modules;

import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.data_statistics.IStatistics;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.soft.blued.log.InstantLog;

public class StatisticsModule {
  protected static IStatistics a = new IStatistics() {
      public void a(int param1Int1, String param1String, int param1Int2) {}
      
      public void a(String param1String) {
        InstantLog.a(param1String);
      }
      
      public void a(String param1String, int param1Int) {
        InstantLog.b(param1String, param1Int);
      }
      
      public void a(String param1String, Object param1Object) {
        InstantLog.a(param1String, param1Object);
      }
      
      public void a(String param1String1, String param1String2) {
        InstantLog.f(param1String1, param1String2);
      }
    };
  
  public static void a() {
    StatisticsProxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\StatisticsModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */