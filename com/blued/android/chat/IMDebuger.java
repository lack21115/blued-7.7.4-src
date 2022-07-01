package com.blued.android.chat;

import android.text.TextUtils;
import com.blued.android.chat.core.pack.BasePackage;

public class IMDebuger {
  private static String imStatus;
  
  private static long lastPackageTimeMs;
  
  private static String lastPackageType;
  
  private static String socketStatus;
  
  public static String getIMInformation() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(imStatus);
    stringBuilder.append(", ");
    stringBuilder.append(socketStatus);
    return stringBuilder.toString();
  }
  
  public static String getLastReceivePackageInfo() {
    if (TextUtils.isEmpty(lastPackageType) || lastPackageTimeMs == 0L)
      return "No Package"; 
    long l = (System.currentTimeMillis() - lastPackageTimeMs) / 1000L;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(lastPackageType);
    stringBuilder.append(", ");
    stringBuilder.append(l);
    stringBuilder.append(" seconds ago");
    return stringBuilder.toString();
  }
  
  public static void setImStatus(String paramString) {
    imStatus = paramString;
  }
  
  public static void setLastReceivePackage(BasePackage paramBasePackage) {
    if (paramBasePackage != null) {
      lastPackageType = BasePackage.typeToString(paramBasePackage);
      lastPackageTimeMs = System.currentTimeMillis();
    } 
  }
  
  public static void setSocketStatus(String paramString) {
    socketStatus = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\IMDebuger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */