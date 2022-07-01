package com.soft.blued.log.mobevent;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.EncryptTool;
import com.soft.blued.user.UserInfo;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

public class MobEventUtils {
  public static void a() {
    if (UserInfo.a().j()) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("uid", EncryptTool.b(UserInfo.a().i().getUid()));
      MobclickAgent.onEventObject(AppInfo.d(), "__finish_payment", hashMap);
    } 
  }
  
  public static void a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("uid", EncryptTool.b(paramString));
      MobclickAgent.onEventObject(AppInfo.d(), "__register", hashMap);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\mobevent\MobEventUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */