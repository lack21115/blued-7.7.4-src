package com.soft.blued.push.vivo;

import android.content.Context;
import android.util.Log;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

public class PushMessageReceiverImpl extends OpenClientPushMessageReceiver {
  public static final String TAG = PushMessageReceiverImpl.class.getSimpleName();
  
  public void onNotificationMessageClicked(Context paramContext, UPSNotificationMessage paramUPSNotificationMessage) {
    String str = paramUPSNotificationMessage.getContent();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("通知点击 msgId ");
    stringBuilder.append(paramUPSNotificationMessage.getMsgId());
    stringBuilder.append(" ;customContent=");
    stringBuilder.append(str);
    str = stringBuilder.toString();
    Log.d(TAG, str);
  }
  
  public void onReceiveRegId(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onReceiveRegId regId = ");
    stringBuilder.append(paramString);
    String str = stringBuilder.toString();
    Log.d(TAG, str);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\vivo\PushMessageReceiverImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */