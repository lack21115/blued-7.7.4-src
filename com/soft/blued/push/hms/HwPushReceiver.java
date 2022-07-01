package com.soft.blued.push.hms;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.huawei.hms.support.api.push.PushMsgReceiver;

public class HwPushReceiver extends PushMsgReceiver {
  private final String a = HwPushReceiver.class.getSimpleName();
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    super.onReceive(paramContext, paramIntent);
    Log.d(this.a, "onReceive=============");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\hms\HwPushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */