package com.blued.android.core.net.http;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

public class SyncOkHttpDns implements Dns {
  private static SyncOkHttpDns b;
  
  public static SyncOkHttpDns a() {
    if (b == null)
      b = new SyncOkHttpDns(); 
    return b;
  }
  
  public List<InetAddress> lookup(String paramString) throws UnknownHostException {
    String str = HttpDnsUtils.a(paramString);
    if (HttpManager.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("httpdns lookup, hostname:");
      stringBuilder.append(paramString);
      stringBuilder.append(", ip:");
      stringBuilder.append(str);
      Log.b("HttpManager", stringBuilder.toString());
    } 
    if (str != null) {
      List<InetAddress> list = Arrays.asList(InetAddress.getAllByName(str));
      if (HttpManager.c()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SyncOkHttpDns lookup, hostname:");
        stringBuilder.append(paramString);
        stringBuilder.append(", inetAddresses:");
        stringBuilder.append(list);
        Log.b("HttpManager", stringBuilder.toString());
      } 
      return list;
    } 
    return Dns.a.lookup(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\SyncOkHttpDns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */