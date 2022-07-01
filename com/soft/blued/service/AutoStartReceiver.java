package com.soft.blued.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.soft.blued.utils.Logger;

public class AutoStartReceiver extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    Logger.a("AutoStartReceiver", new Object[] { "AutoStartReceiver.onReceive(), intent:", paramIntent.getAction() });
    AutoStartService.a(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\service\AutoStartReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */