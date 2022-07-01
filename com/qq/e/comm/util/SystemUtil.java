package com.qq.e.comm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.managers.GDTADManager;
import java.util.Iterator;
import java.util.List;

public final class SystemUtil {
  public static String buildNewPathByProcessName(String paramString) {
    if (StringUtil.isEmpty(paramString))
      return paramString; 
    String str2 = GDTADManager.getInstance().getProcessName();
    String str1 = paramString;
    if (!StringUtil.isEmpty(str2)) {
      str1 = "_";
      boolean bool = str2.endsWith("_");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      paramString = str1;
      if (bool)
        paramString = ""; 
      stringBuilder.append(paramString);
      stringBuilder.append(Md5Util.encode(str2));
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  public static String getProcessName(Context paramContext) {
    int i = Process.myPid();
    List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (list != null) {
      Iterator<ActivityManager.RunningAppProcessInfo> iterator = list.iterator();
      while (iterator.hasNext()) {
        try {
          ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
          if (runningAppProcessInfo.pid == i)
            return runningAppProcessInfo.processName; 
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\SystemUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */