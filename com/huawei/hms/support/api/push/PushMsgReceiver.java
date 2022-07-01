package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.pushselfshow.SelfShow;
import com.huawei.hms.support.api.push.utils.common.NotificationUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class PushMsgReceiver extends BroadcastReceiver {
  public static final String TAG = "PushMsgReceiver";
  
  public static void invokeSelfShow(Context paramContext, Intent paramIntent) {
    if (paramIntent.hasExtra("selfshow_info")) {
      if (!NotificationUtil.areNotificationsEnabled(paramContext)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getPackageName());
        stringBuilder.append(" disable display notification.");
        HMSLog.i("PushMsgReceiver", stringBuilder.toString());
      } 
      SelfShow.onReceive(paramContext, paramIntent);
    } 
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent != null) {
      if (paramContext == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("push receive broadcast message, Intent:");
      stringBuilder.append(paramIntent.getAction());
      stringBuilder.append(" pkgName:");
      stringBuilder.append(paramContext.getPackageName());
      HMSLog.i("PushMsgReceiver", stringBuilder.toString());
      try {
        paramIntent.getStringExtra("TestIntent");
        String str = paramIntent.getAction();
        if (ResourceLoaderUtil.getmContext() == null)
          ResourceLoaderUtil.setmContext(paramContext.getApplicationContext()); 
        if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(str) || ("com.huawei.intent.action.PUSH".equals(str) && HwBuildEx.VERSION.EMUI_SDK_INT < 10)) {
          invokeSelfShow(paramContext, paramIntent);
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("message can't be recognised:");
        stringBuilder1.append(paramIntent.toUri(0));
        HMSLog.i("PushMsgReceiver", stringBuilder1.toString());
        return;
      } catch (Exception exception) {
        HMSLog.e("PushMsgReceiver", "intent has some error");
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\PushMsgReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */