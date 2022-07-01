package com.blued.android.module.yy_china.utils.log;

import android.text.TextUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.statistics.BluedStatistics;
import com.google.protobuf.Message;

public class EventTrackUtils {
  public static String a(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = ""; 
    return str;
  }
  
  public static void a(Message paramMessage) {
    long l1;
    long l2 = 0L;
    try {
      String str = YYRoomInfoManager.d().e();
      l1 = l2;
      if (!TextUtils.isEmpty(str)) {
        l1 = l2;
        if (TextUtils.isDigitsOnly(str))
          l1 = Long.parseLong(str); 
      } 
    } catch (Exception exception) {
      l1 = l2;
    } 
    BluedStatistics.f().a(paramMessage, l1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\log\EventTrackUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */