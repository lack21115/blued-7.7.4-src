package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.apm.ApmProtos;
import com.blued.das.apm.ReportServiceGrpc;
import com.blued.das.perf.PerfProtos;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class ApmManager extends BaseManager<ApmProtos.Request> {
  private ApmManager() {}
  
  public static ApmManager a() {
    return InstanceHolder.a();
  }
  
  protected void a(Object[] paramArrayOfObject) {
    ApmProtos.Requests.Builder builder = ApmProtos.Requests.newBuilder();
    builder.setCommon(BluedStatistics.a().b());
    for (int i = 0; i < paramArrayOfObject.length; i++)
      builder.addRequest((ApmProtos.Request)paramArrayOfObject[i]); 
    StatThreadManager.a((Runnable)new ApmRunnable(this, builder.build()));
  }
  
  protected long b() {
    return 5000L;
  }
  
  protected boolean c() {
    return StatConfig.c();
  }
  
  class ApmRunnable extends NamedRunnable {
    private ApmProtos.Requests b;
    
    public ApmRunnable(ApmManager this$0, ApmProtos.Requests param1Requests) {
      super(StatConfig.a("apm"));
      this.b = param1Requests;
    }
    
    public void a() {
      boolean bool;
      if (StatConfig.d())
        StatConfig.a().b(new Object[] { "APM start-request @", Thread.currentThread().getName(), "\n", this.b }); 
      ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)ConnectManager.a((AbstractStub)ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
      long l = SystemClock.uptimeMillis();
      try {
        ApmProtos.Response response = reportServiceBlockingStub.batchReport(this.b);
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
        if (StatConfig.d())
          exception.printStackTrace(); 
        bool = false;
      } 
      l = SystemClock.uptimeMillis() - l;
      PerfManager.a().a(PerfProtos.Type.APM, l, bool, exception);
      if (StatConfig.d())
        StatConfig.a().b(new Object[] { "APM ", Long.valueOf(l), ", ", reportServiceBlockingStub }); 
    }
  }
  
  static class InstanceHolder {
    private static final ApmManager a = new ApmManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\connect\ApmManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */