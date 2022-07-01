package com.blued.android.statistics.grpc.connect;

import android.os.SystemClock;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.StatConfig;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.blued.android.statistics.util.NamedRunnable;
import com.blued.das.client.ClientProtos;
import com.blued.das.client.ReportServiceGrpc;
import com.blued.das.perf.PerfProtos;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

public final class ClientManager extends BaseManager<ClientProtos.Request> {
  private ClientManager() {}
  
  public static ClientManager a() {
    return InstanceHolder.a();
  }
  
  protected void a(Object[] paramArrayOfObject) {
    ClientProtos.Requests.Builder builder = ClientProtos.Requests.newBuilder();
    builder.setCommon(BluedStatistics.a().b());
    for (int i = 0; i < paramArrayOfObject.length; i++)
      builder.addRequest((ClientProtos.Request)paramArrayOfObject[i]); 
    StatThreadManager.a((Runnable)new ClientRunnable(this, builder.build()));
  }
  
  protected long b() {
    return 5000L;
  }
  
  protected boolean c() {
    return StatConfig.k();
  }
  
  class ClientRunnable extends NamedRunnable {
    private ClientProtos.Requests b;
    
    public ClientRunnable(ClientManager this$0, ClientProtos.Requests param1Requests) {
      super(StatConfig.a("client"));
      this.b = param1Requests;
    }
    
    public void a() {
      boolean bool;
      if (StatConfig.l())
        StatConfig.a().b(new Object[] { "CLIENT start-request \n", this.b }); 
      ReportServiceGrpc.ReportServiceBlockingStub reportServiceBlockingStub = (ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)((ReportServiceGrpc.ReportServiceBlockingStub)ConnectManager.a((AbstractStub)ReportServiceGrpc.newBlockingStub(ConnectManager.a()))).withCompression("gzip")).withDeadlineAfter(30L, TimeUnit.SECONDS);
      long l = SystemClock.uptimeMillis();
      try {
        ClientProtos.Response response = reportServiceBlockingStub.batchReport(this.b);
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
        if (StatConfig.l())
          exception.printStackTrace(); 
        bool = false;
      } 
      l = SystemClock.uptimeMillis() - l;
      PerfManager.a().a(PerfProtos.Type.CLIENT, l, bool, exception);
      if (StatConfig.l())
        StatConfig.a().b(new Object[] { "CLIENT ", Long.valueOf(l), ", ", reportServiceBlockingStub }); 
    }
  }
  
  static class InstanceHolder {
    private static final ClientManager a = new ClientManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\connect\ClientManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */