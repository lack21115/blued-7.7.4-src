package com.blued.android.chat.utils;

import com.blued.android.statistics.BluedStatistics;

public class DataUtils {
  private static String chatRealHost = "";
  
  private static int chatRealHostPort = 0;
  
  private static String chatRealIpAddr = "";
  
  public static void imMessageFailed(String paramString1, long paramLong, String paramString2) {
    BluedStatistics.b().a(paramString1, paramLong, paramString2, chatRealHost, chatRealHostPort, chatRealIpAddr);
  }
  
  public static void imMessageSuccess(String paramString, long paramLong) {
    BluedStatistics.b().a(paramString, paramLong, chatRealHost, chatRealHostPort, chatRealIpAddr);
  }
  
  public static void setChatRealNetArgs(String paramString1, int paramInt, String paramString2) {
    chatRealHost = paramString1;
    chatRealIpAddr = paramString2;
    chatRealHostPort = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\DataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */