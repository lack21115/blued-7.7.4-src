package com.soft.blued.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.ui.video.manager.NetWorkObserverManager;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;

public class SystemEventReceiver extends BroadcastReceiver {
  private static final String a = SystemEventReceiver.class.getName();
  
  private final int b = 100;
  
  private final int c = 101;
  
  private final int d = 102;
  
  private final int e = 103;
  
  private Handler f = new Handler(new Handler.Callback(this) {
        public boolean handleMessage(Message param1Message) {
          switch (param1Message.what) {
            default:
              return false;
            case 103:
              NetWorkObserverManager.a().b(false);
              LiveSysNetworkObserver.a().b();
              return false;
            case 102:
              NetWorkObserverManager.a().b(true);
              return false;
            case 101:
              Logger.b(SystemEventReceiver.a(), new Object[] { " 非联网状态1" });
              NetWorkObserverManager.a().a(false);
              return false;
            case 100:
              break;
          } 
          ChatManager.getInstance().networkChanged();
          NetWorkObserverManager.a().a(true);
          return false;
        }
      });
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    Logger.b(a, new Object[] { "  网络状态改变了。。。" });
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      BluedStatistics.a().b(NetworkUtils.d());
      BluedStatistics.a().a(DeviceUtils.d());
      NetworkInfo networkInfo = ((ConnectivityManager)AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isAvailable()) {
        this.f.sendEmptyMessage(100);
        if (networkInfo != null && networkInfo.getType() == 1) {
          this.f.sendEmptyMessage(102);
          Logger.b(a, new Object[] { "  wifi状态" });
          return;
        } 
        this.f.sendEmptyMessage(103);
        Logger.b(a, new Object[] { "  正常联网的非wifi状态" });
        return;
      } 
      this.f.sendEmptyMessage(101);
      Logger.b(a, new Object[] { " 非联网状态" });
      return;
    } 
    if ("android.intent.action.LOCALE_CHANGED".equals(paramIntent.getAction())) {
      LocaleUtils.d();
      if (LocaleUtils.a()) {
        LocaleUtils.a(AppInfo.d(), LocaleUtils.e());
        AppUtils.a(AppInfo.d());
        return;
      } 
      LocaleUtils.c(AppInfo.d());
    } 
  }
  
  static class SingletonCreator {
    private static final SystemEventReceiver a = new SystemEventReceiver();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\broadcastReceiver\SystemEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */