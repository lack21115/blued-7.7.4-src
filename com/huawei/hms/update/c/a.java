package com.huawei.hms.update.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.ui.SafeIntent;

public class a extends BroadcastReceiver {
  private Handler a;
  
  public a(Handler paramHandler) {
    this.a = paramHandler;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    Bundle bundle;
    Message message;
    if (paramIntent == null)
      return; 
    SafeIntent safeIntent = new SafeIntent(paramIntent);
    String str = safeIntent.getAction();
    if ("com.huawei.appmarket.service.downloadservice.Receiver".equals(str)) {
      bundle = safeIntent.getExtras();
      if (bundle == null)
        return; 
      message = new Message();
      message.what = 101;
      message.obj = bundle;
      this.a.sendMessage(message);
      return;
    } 
    if ("com.huawei.appmarket.service.downloadservice.progress.Receiver".equals(message)) {
      bundle = bundle.getExtras();
      if (bundle == null)
        return; 
      message = new Message();
      message.what = 102;
      message.obj = bundle;
      this.a.sendMessage(message);
      return;
    } 
    if ("com.huawei.appmarket.service.installerservice.Receiver".equals(message)) {
      bundle = bundle.getExtras();
      if (bundle == null)
        return; 
      message = new Message();
      message.what = 103;
      message.obj = bundle;
      this.a.sendMessage(message);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\update\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */