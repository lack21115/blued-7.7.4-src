package com.blued.android.module.im.grpc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.statistics.grpc.DnsResolver;
import com.blued.android.statistics.util.Utils;
import com.qiniu.android.dns.DnsManager;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.android.AndroidChannelBuilder;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ChannelManager {
  private ManagedChannel a = null;
  
  private ManagedChannel b = null;
  
  private DnsResolver c = null;
  
  private ConcurrentHashMap<String, String> d = new ConcurrentHashMap<String, String>();
  
  private Metadata e = new Metadata();
  
  private Context f = null;
  
  private String g;
  
  private String h;
  
  public ChannelManager(Context paramContext, String paramString, int paramInt, DnsManager paramDnsManager) {
    Log.i("gRPC", "---------- createChannel! ----------");
    this.g = paramString;
    this.f = paramContext;
    if (paramDnsManager != null) {
      if (this.c == null)
        this.c = new DnsResolver(paramDnsManager); 
      this.c.a(paramString, paramInt, new DnsResolver.OnGetIPFinishListener(this) {
            public void a(String param1String) {
              if (!TextUtils.isEmpty(param1String))
                ChannelManager.a(this.a, param1String); 
            }
          });
    } 
    this.b = ((AndroidChannelBuilder)((AndroidChannelBuilder)((AndroidChannelBuilder)((AndroidChannelBuilder)Utils.a(paramContext, paramString, paramInt).keepAliveTime(10L, TimeUnit.SECONDS)).keepAliveTimeout(30L, TimeUnit.SECONDS)).idleTimeout(1L, TimeUnit.MINUTES)).keepAliveWithoutCalls(true)).build();
    this.a = Utils.a(paramString, paramInt).build();
  }
  
  public Status a(Exception paramException) {
    Status status2 = Status.fromThrowable(paramException);
    Status status1 = status2;
    if (status2.getCode() == Status.Code.UNAVAILABLE) {
      status1 = status2;
      if (TextUtils.isEmpty(status2.getDescription())) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("network is ");
        if (g()) {
          str = "connected";
        } else {
          str = "disconnected";
        } 
        stringBuilder.append(str);
        status1 = status2.withDescription(stringBuilder.toString());
      } 
    } 
    return status1;
  }
  
  public <T extends AbstractStub<T>> T a(T paramT) {
    synchronized (this.e) {
      return (T)Utils.a((AbstractStub)paramT, this.e);
    } 
  }
  
  public String a() {
    return this.g;
  }
  
  public void a(String paramString1, String paramString2) {
    synchronized (this.e) {
      this.e = Utils.a(this.d, this.e, paramString1, paramString2);
      return;
    } 
  }
  
  public String b() {
    return this.h;
  }
  
  public void c() {
    try {
      if (this.b != null && !this.b.isShutdown()) {
        Log.e("gRPC", "closeChannel!");
        this.b.shutdownNow();
        return;
      } 
    } catch (Exception exception) {
      Log.e("gRPC", "closeChannel Exception : \n", exception);
    } 
  }
  
  public Channel d() {
    return (Channel)this.a;
  }
  
  public Channel e() {
    return (Channel)this.b;
  }
  
  public Metadata f() {
    synchronized (this.e) {
      return this.e;
    } 
  }
  
  public boolean g() {
    Context context = this.f;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (context != null) {
      ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
      bool1 = bool2;
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        bool1 = bool2;
        if (networkInfo != null) {
          bool1 = bool2;
          if (networkInfo.isConnected())
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\grpc\ChannelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */