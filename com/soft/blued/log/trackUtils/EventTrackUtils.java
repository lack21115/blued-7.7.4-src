package com.soft.blued.log.trackUtils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.statistics.BluedStatistics;
import com.google.protobuf.Message;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.Proto2JsonUtils;

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
      String str = UserInfo.a().i().getUid();
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
    if (AppInfo.m() && paramMessage != null)
      Logger.a("event_track", Proto2JsonUtils.a(paramMessage)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */