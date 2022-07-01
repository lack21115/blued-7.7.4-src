package com.soft.blued.http;

import com.blued.android.framework.urlmanager.HostConfig;

public final class Host {
  public static String a(String paramString) {
    return HostConfig.a(paramString);
  }
  
  public static void a() {
    HostConfig.b();
    HostConfig.a("H5", new String[] { "https://app.blued.cn", "https://app-testenv.blued.cn" });
    HostConfig.a("HTTP", new String[] { "https://argo.blued.cn", "http://106.75.100.161" });
    HostConfig.a("PAY", new String[] { "https://pay.blued.cn", "https://pay-test.blued.cn" });
    HostConfig.a("SDK", new String[] { "https://sdk.blued.cn", "https://sdk-test.blued.cn" });
    HostConfig.a("CHAT", new String[] { "h4.blued.cn", "106.75.109.100" });
    HostConfig.a("ACTIVITY", new String[] { "https://activity.blued.cn", "https://activity-test.blued.cn" });
    HostConfig.a("HEALTH", new String[] { "https://health.blued.cn", "https://healthtest.blued.cn" });
    HostConfig.a("BLUED_HEALTH", new String[] { "https://activity.bluedhealth.com", "https://activity-test.bluedhealth.com" });
    HostConfig.a("DANLAN_LOVE", new String[] { "https://www.danlanlove.com", "https://wealtest.blued.cn/#" });
    HostConfig.a("DATA", new String[] { "blued.irisdt.cn", "blued-test.irisdt.cn" });
    HostConfig.a("WEB", new String[] { "https://i.blued.cn", "http://test.i.blued.cn" });
    HostConfig.a("M", new String[] { "https://m.blued.cn", "http://m-test.blued.cn" });
    HostConfig.a("GRPC_CHAT", new String[] { "h8.blued.cn", "im-test.blued.cn" });
    HostConfig.a(HostConfig.AREA.b);
  }
  
  public static void a(boolean paramBoolean) {
    HostConfig.a(paramBoolean ^ true);
  }
  
  public static String b() {
    return HostConfig.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\Host.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */