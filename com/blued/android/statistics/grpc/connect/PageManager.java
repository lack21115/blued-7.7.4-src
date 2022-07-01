package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.page.PageDurationProtos;
import com.blued.das.page.ReportServiceGrpc;
import com.blued.das.perf.PerfProtos;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class PageManager extends BaseManager<PageDurationProtos.Request> {
  private PageManager() {}
  
  public static PageManager a() {
    return InstanceHolder.a();
  }
  
  protected void a(Object[] paramArrayOfObject) {
    PageDurationProtos.Requests.Builder builder = PageDurationProtos.Requests.newBuilder();
    for (int i = 0; i < paramArrayOfObject.length; i++)
      builder.addRequest((PageDurationProtos.Request)paramArrayOfObject[i]); 
    builder.setCommon(BluedStatistics.a().b());
    StatThreadManager.a((Runnable)new PageRunnable(this, builder.build()));
  }
  
  protected long b() {
    return 5000L;
  }
  
  protected boolean c() {
    return StatConfig.g();
  }
  
  static class InstanceHolder {
    private static final PageManager a = new PageManager();
  }
  
  class PageRunnable extends NamedRunnable {
    private PageDurationProtos.Requests b;
    
    public PageRunnable(PageManager this$0, PageDurationProtos.Requests param1Requests) {
      super(StatConfig.a("page"));
      this.b = param1Requests;
    }
    
    public void a() {
      boolean bool;
      if (StatConfig.h())
        StatConfig.a().b(new Object[] { "PAGE start-request \n", this.b }); 
      ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)ConnectManager.a((AbstractStub)ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
      long l = SystemClock.uptimeMillis();
      try {
        PageDurationProtos.Response response = reportServiceBlockingStub.batchReport(this.b);
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
        if (StatConfig.h())
          exception.printStackTrace(); 
        bool = false;
      } 
      l = SystemClock.uptimeMillis() - l;
      PerfManager.a().a(PerfProtos.Type.PAGE_DURATION, l, bool, exception);
      if (StatConfig.h())
        StatConfig.a().b(new Object[] { "PAGE ", Long.valueOf(l), ", ", reportServiceBlockingStub }); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\connect\PageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */