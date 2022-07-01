package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.event.CustomEventProtos;
import com.blued.das.event.ReportServiceGrpc;
import com.blued.das.perf.PerfProtos;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class EventManager extends BaseManager<CustomEventProtos.Request> {
  private EventManager() {}
  
  public static EventManager a() {
    return InstanceHolder.a();
  }
  
  protected void a(Object[] paramArrayOfObject) {
    CustomEventProtos.Requests.Builder builder = CustomEventProtos.Requests.newBuilder();
    builder.setCommon(BluedStatistics.a().b());
    for (int i = 0; i < paramArrayOfObject.length; i++)
      builder.addRequest((CustomEventProtos.Request)paramArrayOfObject[i]); 
    StatThreadManager.a((Runnable)new EventRunnable(this, builder.build()));
  }
  
  protected long b() {
    return 5000L;
  }
  
  protected boolean c() {
    return StatConfig.e();
  }
  
  class EventRunnable extends NamedRunnable {
    private CustomEventProtos.Requests b;
    
    public EventRunnable(EventManager this$0, CustomEventProtos.Requests param1Requests) {
      super(StatConfig.a("event"));
      this.b = param1Requests;
    }
    
    public void a() {
      boolean bool;
      if (StatConfig.f())
        StatConfig.a().b(new Object[] { "EVENT start-request \n", this.b }); 
      ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)ConnectManager.a((AbstractStub)ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
      long l = SystemClock.uptimeMillis();
      try {
        CustomEventProtos.Response response = reportServiceBlockingStub.batchReport(this.b);
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
        if (StatConfig.f())
          exception.printStackTrace(); 
        bool = false;
      } 
      l = SystemClock.uptimeMillis() - l;
      PerfManager.a().a(PerfProtos.Type.CUSTOM_EVENT, l, bool, exception);
      if (StatConfig.f())
        StatConfig.a().b(new Object[] { "EVENT ", Long.valueOf(l), ", ", reportServiceBlockingStub }); 
    }
  }
  
  static class InstanceHolder {
    private static final EventManager a = new EventManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\connect\EventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */