package com.soft.blued.push.oppo;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.soft.blued.utils.Logger;

public class OPushMessageService extends PushService {
  private static final String a = OPushMessageService.class.getSimpleName();
  
  private void a(String paramString) {
    if (AppInfo.m())
      Logger.b(a, new Object[] { paramString }); 
  }
  
  public void a(Context paramContext, AppMessage paramAppMessage) {
    super.a(paramContext, paramAppMessage);
    if (paramAppMessage != null)
      a(paramAppMessage.a()); 
  }
  
  public void a(Context paramContext, SptDataMessage paramSptDataMessage) {
    super.a(paramContext.getApplicationContext(), paramSptDataMessage);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\oppo\OPushMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */