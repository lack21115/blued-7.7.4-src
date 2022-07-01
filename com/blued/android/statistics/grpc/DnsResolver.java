package com.blued.android.statistics.grpc;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.statistics.util.Utils;
import com.qiniu.android.dns.DnsManager;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.NameResolverRegistry;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Collections;
import javax.annotation.Nullable;

public class DnsResolver {
  private NameResolverProvider a = null;
  
  private DnsManager b;
  
  public DnsResolver(DnsManager paramDnsManager) {
    this.b = paramDnsManager;
  }
  
  private String a(DnsManager paramDnsManager, String paramString) {
    if (paramDnsManager != null) {
      try {
        String[] arrayOfString = paramDnsManager.query(paramString);
      } catch (IOException iOException) {
        iOException.printStackTrace();
        iOException = null;
      } 
      if (iOException != null && iOException.length > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get HttpDns from cache, ");
        stringBuilder.append(paramString);
        stringBuilder.append(" -> ");
        stringBuilder.append((String)iOException[0]);
        Log.v("gRPC", stringBuilder.toString());
        return (String)iOException[0];
      } 
    } 
    return null;
  }
  
  public void a(String paramString, int paramInt, OnGetIPFinishListener paramOnGetIPFinishListener) {
    if (this.a != null) {
      NameResolverRegistry.getDefaultRegistry().deregister(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dns deregister : ");
      stringBuilder.append(this.a);
      Log.v("gRPC", stringBuilder.toString());
    } 
    if (this.b != null) {
      if (TextUtils.isEmpty(paramString))
        return; 
      StatThreadManager.b().execute(new Runnable(this, paramString, paramInt, paramOnGetIPFinishListener) {
            public void run() {
              DnsResolver dnsResolver = this.d;
              String str = DnsResolver.a(dnsResolver, DnsResolver.a(dnsResolver), this.a);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("dns ipAddr : ");
              stringBuilder.append(str);
              Log.v("gRPC", stringBuilder.toString());
              if (TextUtils.isEmpty(str))
                return; 
              Utils.a(new Runnable(this, str) {
                    public void run() {
                      DnsResolver.a(this.b.d, new DnsResolver.DirectAddressNameResolverProvider(this.b.d, this.b.a, this.b.b, this.a));
                      NameResolverRegistry.getDefaultRegistry().register(DnsResolver.b(this.b.d));
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("dns register : ");
                      stringBuilder.append(DnsResolver.b(this.b.d));
                      Log.v("gRPC", stringBuilder.toString());
                      if (this.b.c != null)
                        this.b.c.a(this.a); 
                    }
                  });
            }
          });
    } 
  }
  
  class DirectAddressNameResolverProvider extends NameResolverProvider {
    private String b;
    
    private int c;
    
    private String d;
    
    public DirectAddressNameResolverProvider(DnsResolver this$0, String param1String1, int param1Int, String param1String2) {
      this.b = param1String1;
      this.c = param1Int;
      this.d = param1String2;
    }
    
    public String getDefaultScheme() {
      return TextUtils.isEmpty(this.b) ? "IP" : URI.create(this.b).getScheme();
    }
    
    public boolean isAvailable() {
      return true;
    }
    
    @Nullable
    public NameResolver newNameResolver(URI param1URI, NameResolver.Args param1Args) {
      return (param1URI != null) ? (TextUtils.isEmpty(this.b) ? null : (!param1URI.getScheme().equals(this.b) ? null : new NameResolver(this) {
          public String getServiceAuthority() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DnsResolver.DirectAddressNameResolverProvider.a(this.a));
            stringBuilder.append(":");
            stringBuilder.append(DnsResolver.DirectAddressNameResolverProvider.b(this.a));
            return stringBuilder.toString();
          }
          
          public void shutdown() {}
          
          public void start(NameResolver.Listener param2Listener) {
            InetSocketAddress inetSocketAddress;
            if (TextUtils.isEmpty(DnsResolver.DirectAddressNameResolverProvider.c(this.a))) {
              try {
                InetAddress inetAddress = InetAddress.getByName(DnsResolver.DirectAddressNameResolverProvider.a(this.a));
                inetSocketAddress = new InetSocketAddress(inetAddress, DnsResolver.DirectAddressNameResolverProvider.b(this.a));
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("newNameResolver inetAddress : ");
                stringBuilder1.append(inetAddress);
                Log.v("gRPC", stringBuilder1.toString());
              } catch (UnknownHostException unknownHostException) {
                inetSocketAddress = new InetSocketAddress(DnsResolver.DirectAddressNameResolverProvider.b(this.a));
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Broken system behaviour for dns lookup of ");
                stringBuilder1.append(DnsResolver.DirectAddressNameResolverProvider.a(this.a));
                Log.v("gRPC", stringBuilder1.toString());
                unknownHostException.printStackTrace();
              } 
            } else {
              inetSocketAddress = new InetSocketAddress(DnsResolver.DirectAddressNameResolverProvider.c(this.a), DnsResolver.DirectAddressNameResolverProvider.b(this.a));
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("newNameResolver socketAddress : ");
            stringBuilder.append(inetSocketAddress.toString());
            Log.v("gRPC", stringBuilder.toString());
            param2Listener.onAddresses(Collections.singletonList(new EquivalentAddressGroup(inetSocketAddress)), Attributes.EMPTY);
          }
        })) : null;
    }
    
    public int priority() {
      return 5;
    }
  }
  
  class null extends NameResolver {
    null(DnsResolver this$0) {}
    
    public String getServiceAuthority() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(DnsResolver.DirectAddressNameResolverProvider.a(this.a));
      stringBuilder.append(":");
      stringBuilder.append(DnsResolver.DirectAddressNameResolverProvider.b(this.a));
      return stringBuilder.toString();
    }
    
    public void shutdown() {}
    
    public void start(NameResolver.Listener param1Listener) {
      InetSocketAddress inetSocketAddress;
      if (TextUtils.isEmpty(DnsResolver.DirectAddressNameResolverProvider.c(this.a))) {
        try {
          InetAddress inetAddress = InetAddress.getByName(DnsResolver.DirectAddressNameResolverProvider.a(this.a));
          inetSocketAddress = new InetSocketAddress(inetAddress, DnsResolver.DirectAddressNameResolverProvider.b(this.a));
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("newNameResolver inetAddress : ");
          stringBuilder1.append(inetAddress);
          Log.v("gRPC", stringBuilder1.toString());
        } catch (UnknownHostException unknownHostException) {
          inetSocketAddress = new InetSocketAddress(DnsResolver.DirectAddressNameResolverProvider.b(this.a));
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Broken system behaviour for dns lookup of ");
          stringBuilder1.append(DnsResolver.DirectAddressNameResolverProvider.a(this.a));
          Log.v("gRPC", stringBuilder1.toString());
          unknownHostException.printStackTrace();
        } 
      } else {
        inetSocketAddress = new InetSocketAddress(DnsResolver.DirectAddressNameResolverProvider.c(this.a), DnsResolver.DirectAddressNameResolverProvider.b(this.a));
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("newNameResolver socketAddress : ");
      stringBuilder.append(inetSocketAddress.toString());
      Log.v("gRPC", stringBuilder.toString());
      param1Listener.onAddresses(Collections.singletonList(new EquivalentAddressGroup(inetSocketAddress)), Attributes.EMPTY);
    }
  }
  
  public static interface OnGetIPFinishListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\DnsResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */