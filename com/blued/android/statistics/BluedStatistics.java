package com.blued.android.statistics;

import android.text.TextUtils;
import com.blued.android.statistics.biz.Apm;
import com.blued.android.statistics.biz.Client;
import com.blued.android.statistics.biz.Common;
import com.blued.android.statistics.biz.Dau;
import com.blued.android.statistics.biz.Event;
import com.blued.android.statistics.biz.Page;
import com.blued.android.statistics.grpc.ConnectManager;
import com.blued.android.statistics.grpc.StatThreadManager;
import com.qiniu.android.dns.DnsManager;

public class BluedStatistics {
  public static Common a() {
    return Common.a();
  }
  
  public static void a(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Basic ");
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
    } 
    ConnectManager.a("Authorization", paramString);
  }
  
  public static void a(String paramString, int paramInt, DnsManager paramDnsManager) {
    StatConfig.a(true);
    StatThreadManager.a();
    ConnectManager.a(paramString, paramInt, paramDnsManager);
  }
  
  public static Apm b() {
    return Apm.a();
  }
  
  public static Event c() {
    return Event.a();
  }
  
  public static Page d() {
    return Page.a();
  }
  
  public static Dau e() {
    return Dau.a();
  }
  
  public static Client f() {
    return Client.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\BluedStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */