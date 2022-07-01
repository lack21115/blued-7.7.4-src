package com.taobao.tao.remotebusiness.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mtopsdk.common.util.TBSdkLog;

class DefaultLoginImpl$1 extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return; 
    String str = paramIntent.getAction();
    if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
      StringBuilder stringBuilder = new StringBuilder("Login Broadcast Received. action=");
      stringBuilder.append(str);
      TBSdkLog.b("mtop.rb-DefaultLoginImpl", stringBuilder.toString());
    } 
    if ("NOTIFY_LOGIN_SUCCESS".equals(str)) {
      LoginHandler.instance().onLoginSuccess();
      return;
    } 
    if ("NOTIFY_LOGIN_FAILED".equals(str)) {
      LoginHandler.instance().onLoginFail();
      return;
    } 
    if ("NOTIFY_LOGIN_CANCEL".equals(str))
      LoginHandler.instance().onLoginCancel(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\login\DefaultLoginImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */