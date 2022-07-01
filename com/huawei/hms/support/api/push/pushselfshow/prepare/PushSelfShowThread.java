package com.huawei.hms.support.api.push.pushselfshow.prepare;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.push.pushselfshow.entity.PushSelfShowMessage;
import com.huawei.hms.support.api.push.pushselfshow.utils.CommFun;
import com.huawei.hms.support.log.HMSLog;

public class PushSelfShowThread extends Thread {
  public static final String TAG = "PushSelfShowLog";
  
  public Context mContext;
  
  public PushSelfShowMessage psMsg;
  
  public PushSelfShowThread(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage) {
    this.mContext = paramContext;
    this.psMsg = paramPushSelfShowMessage;
  }
  
  private boolean checkCOSA(Context paramContext) {
    return CommFun.isInstalled(paramContext, this.psMsg.getAppPackageName());
  }
  
  public static Intent getIntentToStartActivity(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage) {
    StringBuilder stringBuilder;
    Intent intent1;
    if (paramPushSelfShowMessage == null)
      return null; 
    Intent intent2 = CommFun.hasActivity(paramContext, paramPushSelfShowMessage.getAppPackageName());
    if (paramPushSelfShowMessage.getIntentUri() != null) {
      try {
        Intent intent = Intent.parseUri(paramPushSelfShowMessage.getIntentUri(), 0);
        intent.setSelector(null);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Intent.parseUri(msg.intentUri, 0)，");
        stringBuilder1.append(intent.getAction());
        HMSLog.d("PushSelfShowLog", stringBuilder1.toString());
        boolean bool = CommFun.findActivityByIntent(paramContext, paramPushSelfShowMessage.getAppPackageName(), intent).booleanValue();
        intent1 = intent2;
        if (bool)
          return intent; 
      } catch (Exception exception) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("intentUri error");
        stringBuilder.append(exception.toString());
        HMSLog.w("PushSelfShowLog", stringBuilder.toString());
        return intent2;
      } 
    } else {
      intent1 = intent2;
      if (stringBuilder.getAcn() != null) {
        Intent intent = new Intent(stringBuilder.getAcn());
        intent1 = intent2;
        if (CommFun.findActivityByIntent((Context)exception, stringBuilder.getAppPackageName(), intent).booleanValue())
          intent1 = intent; 
      } 
      intent1.setPackage(stringBuilder.getAppPackageName());
    } 
    return intent1;
  }
  
  private boolean hasNoPermissionToStartActivity(Context paramContext, PushSelfShowMessage paramPushSelfShowMessage) {
    boolean bool = "cosa".equals(paramPushSelfShowMessage.getCmd());
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool) {
      Intent intent = getIntentToStartActivity(paramContext, paramPushSelfShowMessage);
      bool1 = bool2;
      if (intent == null) {
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        bool1 = true;
      } 
      if (!CommFun.hasPermissionToStartActivity(paramContext, intent)) {
        HMSLog.i("PushSelfShowLog", "no permission to start activity");
        bool1 = true;
      } 
    } 
    return bool1;
  }
  
  private boolean notifyUser(Context paramContext) {
    return "cosa".equals(this.psMsg.getCmd()) ? checkCOSA(paramContext) : true;
  }
  
  public void run() {
    HMSLog.i("PushSelfShowLog", "enter run()");
    try {
      if (notifyUser(this.mContext)) {
        if (hasNoPermissionToStartActivity(this.mContext, this.psMsg))
          return; 
        PushNotification.showNotification(this.mContext, this.psMsg);
        return;
      } 
    } catch (Exception exception) {
      HMSLog.e("PushSelfShowLog", exception.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\prepare\PushSelfShowThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */