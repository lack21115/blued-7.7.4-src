package com.soft.blued.http;

import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.urlmanager.UrlFormatUtil;

public final class Blued_healthUrl {
  private static final String[] a = new String[] { "0/health/kb/home?redirect=1%s", "0/health/kb/home?register=1%s" };
  
  private static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(HostConfig.a("BLUED_HEALTH"));
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public static String a(int paramInt) {
    return UrlFormatUtil.a(a[paramInt], a(), new Object[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\Blued_healthUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */