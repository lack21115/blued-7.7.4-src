package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.biz.Dau;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.android.statistics.util.Utils;
import com.blued.das.dau.DayActiveUserProtos;
import com.blued.das.dau.ReportServiceGrpc;
import com.blued.das.perf.PerfProtos;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class DauManager {
  private Runnable a = new Runnable(this) {
      public void run() {
        StatThreadManager.a((Runnable)new DauManager.DauRunnable(this.a, DayActiveUserProtos.Request.newBuilder().setCommon(BluedStatistics.a().b()).setName(DayActiveUserProtos.NAME.REGULAR).build()));
        if (DauManager.a(this.a) != null)
          DauManager.a(this.a).a(DayActiveUserProtos.NAME.REGULAR); 
        if (StatConfig.i())
          Utils.a(DauManager.b(this.a), 300000L); 
      }
    };
  
  private Dau.OnDauListener b;
  
  private DauManager() {}
  
  public static DauManager a() {
    return InstanceHolder.a();
  }
  
  private void a(DayActiveUserProtos.Request.Builder paramBuilder, boolean paramBoolean) {
    if (!StatConfig.i())
      return; 
    if (!ConnectManager.b())
      return; 
    paramBuilder.setCommon(BluedStatistics.a().b());
    StatThreadManager.a((Runnable)new DauRunnable(this, paramBuilder.build()));
    Dau.OnDauListener onDauListener = this.b;
    if (onDauListener != null)
      onDauListener.a(paramBuilder.getName()); 
    Utils.b(this.a);
    if (paramBoolean)
      Utils.a(this.a, 300000L); 
  }
  
  public void a(DayActiveUserProtos.Request.Builder paramBuilder) {
    a(paramBuilder, false);
  }
  
  public void b(DayActiveUserProtos.Request.Builder paramBuilder) {
    a(paramBuilder, true);
  }
  
  class DauRunnable extends NamedRunnable {
    private DayActiveUserProtos.Request b;
    
    public DauRunnable(DauManager this$0, DayActiveUserProtos.Request param1Request) {
      super(StatConfig.a("dau"));
      this.b = param1Request;
    }
    
    public void a() {
      boolean bool;
      if (StatConfig.j())
        StatConfig.a().b(new Object[] { "DAU start-request @", Thread.currentThread().getName(), "\n", this.b }); 
      ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)ConnectManager.a((AbstractStub)ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
      long l = SystemClock.uptimeMillis();
      try {
        DayActiveUserProtos.Response response = reportServiceBlockingStub.report(this.b);
        if (response != null) {
          try {
            bool = response.getCode();
          } catch (Exception exception1) {}
        } else {
          bool = false;
        } 
        exception = null;
      } catch (Exception exception) {
        reportServiceBlockingStub = null;
        if (StatConfig.j())
          exception.printStackTrace(); 
        bool = false;
      } 
      l = SystemClock.uptimeMillis() - l;
      PerfManager.a().a(PerfProtos.Type.DAY_ACTIVE_USER, l, bool, exception);
      if (StatConfig.j())
        StatConfig.a().b(new Object[] { "DAU ", Long.valueOf(l), ", ", reportServiceBlockingStub }); 
    }
  }
  
  static class InstanceHolder {
    private static final DauManager a = new DauManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\connect\DauManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */