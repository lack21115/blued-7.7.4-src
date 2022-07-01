package com.blued.android.statistics.grpc;

import com.blued.android.statistics.util.Utils;
import com.qiniu.android.dns.DnsManager;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectManager {
  private static ManagedChannel a;
  
  private static OkHttpChannelBuilder b;
  
  private static ConcurrentHashMap<String, String> c = new ConcurrentHashMap<String, String>();
  
  private static Metadata d = new Metadata();
  
  private static DnsResolver e = null;
  
  public static Channel a() {
    return (Channel)a;
  }
  
  public static <T extends AbstractStub<T>> T a(T paramT) {
    return (T)Utils.a((AbstractStub)paramT, d);
  }
  
  public static void a(String paramString, int paramInt, DnsManager paramDnsManager) {
    if (paramDnsManager != null) {
      if (e == null)
        e = new DnsResolver(paramDnsManager); 
      e.a(paramString, paramInt, (DnsResolver.OnGetIPFinishListener)null);
    } 
    b = Utils.a(paramString, paramInt);
    a = b.build();
  }
  
  public static void a(String paramString1, String paramString2) {
    d = Utils.a(c, d, paramString1, paramString2);
  }
  
  public static boolean b() {
    return (a != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\ConnectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */