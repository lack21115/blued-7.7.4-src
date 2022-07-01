package com.soft.blued.http;

import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.urlmanager.UrlFormatUtil;

public final class ActivityUrl {
  private static final String[] a = new String[] { "0/hd/2020/series%s", "0/hd/2020/share-test%s" };
  
  private static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(HostConfig.a("ACTIVITY"));
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public static String a(int paramInt) {
    return UrlFormatUtil.a(a[paramInt], a(), new Object[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\ActivityUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */