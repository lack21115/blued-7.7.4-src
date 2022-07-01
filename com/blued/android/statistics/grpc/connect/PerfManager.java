package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.perf.PerfProtos;
import com.blued.das.perf.ReportServiceGrpc;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class PerfManager extends BaseManager<PerfProtos.Request> {
  private PerfManager() {}
  
  public static PerfManager a() {
    return InstanceHolder.a();
  }
  
  public void a(PerfProtos.Type paramType, long paramLong, int paramInt, Exception paramException) {
    PerfProtos.Request.Builder builder = PerfProtos.Request.newBuilder().setType(paramType).setTakes((int)paramLong).setCode(paramInt).setClientTime(System.currentTimeMillis());
    if (paramException != null)
      builder.setDescription(paramException.getMessage()); 
    a(builder.build());
  }
  
  protected void a(Object[] paramArrayOfObject) {
    PerfProtos.Requests.Builder builder = PerfProtos.Requests.newBuilder();
    builder.setCommon(BluedStatistics.a().b());
    for (int i = 0; i < paramArrayOfObject.length; i++)
      builder.addRequest((PerfProtos.Request)paramArrayOfObject[i]); 
    StatThreadManager.a((Runnable)new PrefRunnable(this, builder.build()));
  }
  
  protected long b() {
    return 5000L;
  }
  
  static class InstanceHolder {
    private static final PerfManager a = new PerfManager();
  }
  
  class PrefRunnable extends NamedRunnable {
    private PerfProtos.Requests b;
    
    public PrefRunnable(PerfManager this$0, PerfProtos.Requests param1Requests) {
      super(StatConfig.a("pref"));
      this.b = param1Requests;
    }
    
    public void a() {
      if (StatConfig.b())
        StatConfig.a().b(new Object[] { "PREF start-request \n", this.b }); 
      ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub1 = (ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)ConnectManager.a((AbstractStub)ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
      ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub2 = null;
      long l1 = SystemClock.uptimeMillis();
      try {
        PerfProtos.Response response = reportServiceBlockingStub1.batchReport(this.b);
      } catch (Exception exception) {
        reportServiceBlockingStub1 = reportServiceBlockingStub2;
        if (StatConfig.b()) {
          exception.printStackTrace();
          reportServiceBlockingStub1 = reportServiceBlockingStub2;
        } 
      } 
      long l2 = SystemClock.uptimeMillis();
      if (StatConfig.b())
        StatConfig.a().b(new Object[] { "PREF ", Long.valueOf(l2 - l1), ", ", reportServiceBlockingStub1 }); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\connect\PerfManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */