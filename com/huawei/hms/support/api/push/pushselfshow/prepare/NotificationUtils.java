package com.huawei.hms.support.api.push.pushselfshow.prepare;

import android.app.Notification;
import android.text.TextUtils;
import com.huawei.hms.support.api.push.pushselfshow.entity.PushSelfShowMessage;

public class NotificationUtils {
  public static NotifyStyle getStyle(PushSelfShowMessage paramPushSelfShowMessage) {
    NotifyStyle notifyStyle2 = NotifyStyle.STYLE_DEFAULT;
    NotifyStyle notifyStyle1 = notifyStyle2;
    if (paramPushSelfShowMessage.getStyle() >= 0) {
      notifyStyle1 = notifyStyle2;
      if (paramPushSelfShowMessage.getStyle() < (NotifyStyle.values()).length)
        notifyStyle1 = NotifyStyle.values()[paramPushSelfShowMessage.getStyle()]; 
    } 
    return notifyStyle1;
  }
  
  public static void initBigTextStyleBuilder(Notification.Builder paramBuilder, String paramString, PushSelfShowMessage paramPushSelfShowMessage) {
    Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
    if (!TextUtils.isEmpty(paramPushSelfShowMessage.getBigTitle()))
      bigTextStyle.setBigContentTitle(paramPushSelfShowMessage.getBigTitle()); 
    if (TextUtils.isEmpty(paramString))
      paramString = null; 
    if (!TextUtils.isEmpty(paramString))
      bigTextStyle.bigText(paramString); 
    paramBuilder.setStyle((Notification.Style)bigTextStyle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\prepare\NotificationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */