package com.blued.android.chat.utils;

import android.os.Build;
import com.blued.android.chat.ChatManager;
import java.util.TimeZone;

public class DeviceInfo {
  public static boolean fitApiLevel(int paramInt) {
    try {
      int i = Integer.parseInt(Build.VERSION.SDK);
      if (i >= paramInt)
        return true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  private static String getCountry() {
    return (ChatManager.context.getResources().getConfiguration()).locale.getCountry();
  }
  
  public static String getDeviceInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Language:");
    stringBuilder.append(getLanguage());
    stringBuilder.append(", Country:");
    stringBuilder.append(getCountry());
    stringBuilder.append(", TimeZone:");
    stringBuilder.append(getTimeZone());
    return stringBuilder.toString();
  }
  
  private static String getLanguage() {
    return (ChatManager.context.getResources().getConfiguration()).locale.getLanguage();
  }
  
  private static String getTimeZone() {
    return TimeZone.getDefault().getID();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */