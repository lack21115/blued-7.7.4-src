package com.facebook.stetho.server;

import com.facebook.stetho.common.ProcessUtil;

public class AddressNameHelper {
  private static final String PREFIX = "stetho_";
  
  public static String createCustomAddress(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stetho_");
    stringBuilder.append(ProcessUtil.getProcessName());
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\AddressNameHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */