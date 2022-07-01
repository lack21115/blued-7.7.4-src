package com.soft.blued.push;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.heytap.mcssdk.callback.PushAdapter;
import com.heytap.mcssdk.callback.PushCallback;
import com.huawei.android.hms.agent.HMSAgent;
import com.huawei.android.hms.agent.common.HMSAgentLog;
import com.huawei.android.hms.agent.common.handler.ConnectHandler;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.List;

public class PushManager {
  private static final String a = PushManager.class.getSimpleName();
  
  private static boolean j = true;
  
  private Context b;
  
  private boolean c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private long g;
  
  private long h;
  
  private List<Integer> i;
  
  private PushManager() {
    int i = 0;
    this.c = false;
    this.d = 3;
    this.e = 0;
    this.f = 0;
    this.g = 0L;
    this.h = 1800000L;
    this.i = new ArrayList<Integer>();
    if (this.b == null)
      this.b = AppInfo.d(); 
    if (this.i.size() <= 0)
      while (i < 7) {
        this.i.add(Integer.valueOf(i));
        i++;
      }  
  }
  
  public static PushManager a() {
    return PushManagerHolder.a;
  }
  
  public static void a(Context paramContext) {
    if (Build.MANUFACTURER.toLowerCase().equals("huawei") && j)
      try {
        Bundle bundle = new Bundle();
        bundle.putString("package", paramContext.getApplicationContext().getPackageName());
        bundle.putString("class", HomeActivity.class.toString());
        bundle.putInt("badgenumber", 0);
        paramContext.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge / "), " change_badge", null, bundle);
        return;
      } catch (Exception exception) {
        j = false;
      }  
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    if (Build.VERSION.SDK_INT >= 26) {
      NotificationChannel notificationChannel = new NotificationChannel(paramString3, paramString1, 3);
      notificationChannel.setDescription(paramString2);
      ((NotificationManager)this.b.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    } 
  }
  
  private void b(String paramString) {
    if (AppInfo.m())
      Logger.b(a, new Object[] { "PUSH", paramString }); 
  }
  
  public static boolean b() {
    String str = Build.MANUFACTURER.toLowerCase();
    return ("xiaomi".equals(str) || "huawei".equals(str) || "oppo".equals(str));
  }
  
  private boolean c(Context paramContext) {
    if (paramContext == null)
      return false; 
    List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (list == null)
      return false; 
    String str = paramContext.getPackageName();
    int i = Process.myPid();
    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
      if (runningAppProcessInfo.pid == i && str.equals(runningAppProcessInfo.processName))
        return true; 
    } 
    return false;
  }
  
  private void g() {
    PushClient.getInstance(this.b).initialize();
    PushClient.getInstance(this.b).turnOnPush(new IPushActionListener(this) {
          public void onStateChanged(int param1Int) {
            if (param1Int != 0) {
              PushManager pushManager = this.a;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("打开vivo push异常[");
              stringBuilder1.append(param1Int);
              stringBuilder1.append("]");
              PushManager.a(pushManager, stringBuilder1.toString());
              return;
            } 
            PushManager.a(this.a, "打开vivo push成功");
            String str1 = PushClient.getInstance(PushManager.a(this.a)).getRegId();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VIPUSH:");
            stringBuilder.append(str1);
            String str2 = stringBuilder.toString();
            BluedPreferences.X(str1);
            PushManager.a().a(str2);
          }
        });
  }
  
  private void h() {
    if (!j()) {
      if (BluedApplicationLike.getForeActivity() == null)
        return; 
      HMSAgent.connect(BluedApplicationLike.getForeActivity(), new ConnectHandler(this) {
            public void onConnect(int param1Int) {
              PushManager pushManager = this.a;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(" connect end:");
              stringBuilder.append(param1Int);
              PushManager.a(pushManager, stringBuilder.toString());
              if (param1Int == 0) {
                PushManager.a(this.a, " connect success!!");
                PushManager.a(this.a, true);
                PushManager.a(this.a, 0);
                PushManager.b(this.a);
                return;
              } 
              if (param1Int == -1000) {
                PushManager.c(this.a);
                return;
              } 
              PushManager.a(this.a, " 连接错误!!! ");
              long l2 = PushManager.d(this.a);
              long l1 = 0L;
              if (l2 == 0L) {
                PushManager.a(this.a, System.currentTimeMillis());
              } else {
                l1 = System.currentTimeMillis() - PushManager.d(this.a);
              } 
              PushManager.a(this.a, false);
              PushManager.e(this.a);
              if (PushManager.f(this.a) < PushManager.g(this.a)) {
                pushManager = this.a;
                stringBuilder = new StringBuilder();
                stringBuilder.append(" 重连次数 count = ");
                stringBuilder.append(PushManager.f(this.a));
                PushManager.a(pushManager, stringBuilder.toString());
                PushManager.h(this.a);
                return;
              } 
              if (l1 >= PushManager.i(this.a)) {
                PushManager.a(this.a, " 连接错误的间隔时长已达30分钟,把重连计数置为0,并重新连接");
                PushManager.a(this.a, 0);
                PushManager.h(this.a);
              } 
            }
          });
    } 
  }
  
  private void i() {
    HMSAgentLog.setHMSAgentLogCallback(new HMSAgentLog.IHMSAgentLogCallback(this) {
          public void logD(String param1String1, String param1String2) {
            Logger.b(param1String1, new Object[] { param1String2 });
          }
          
          public void logE(String param1String1, String param1String2) {
            Logger.b(param1String1, new Object[] { param1String2 });
          }
          
          public void logI(String param1String1, String param1String2) {
            Logger.b(param1String1, new Object[] { param1String2 });
          }
          
          public void logV(String param1String1, String param1String2) {
            Logger.b(param1String1, new Object[] { param1String2 });
          }
          
          public void logW(String param1String1, String param1String2) {
            Logger.b(param1String1, new Object[] { param1String2 });
          }
        });
  }
  
  private boolean j() {
    return this.c;
  }
  
  private void k() {
    HMSAgent.Push.getToken(new GetTokenHandler(this) {
          public void onResult(int param1Int) {
            PushManager pushManager = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" getToken end:");
            stringBuilder.append(param1Int);
            PushManager.a(pushManager, stringBuilder.toString());
            if (param1Int != 0) {
              PushManager.a(this.a, " getToken 失败!!! ");
              PushManager.k(this.a);
              if (PushManager.l(this.a) < PushManager.g(this.a)) {
                pushManager = this.a;
                stringBuilder = new StringBuilder();
                stringBuilder.append(" 重新调用getToken的次数 count = ");
                stringBuilder.append(PushManager.l(this.a));
                PushManager.a(pushManager, stringBuilder.toString());
                PushManager.b(this.a);
                return;
              } 
            } else {
              PushManager.b(this.a, 0);
            } 
          }
        });
  }
  
  private void l() {
    MiPushClient.a(this.b, q(), r());
    MiPushClient.a(this.b, 0, 0, 23, 59, null);
    LoggerInterface loggerInterface = new LoggerInterface(this) {
        public void a(String param1String) {
          PushManager.a(this.a, param1String);
        }
        
        public void a(String param1String, Throwable param1Throwable) {
          PushManager.a(this.a, param1String);
        }
      };
    Logger.a(this.b, loggerInterface);
  }
  
  private void m() {
    if (com.heytap.mcssdk.PushManager.c(this.b))
      com.heytap.mcssdk.PushManager.a().a(this.b, o(), p(), (PushCallback)new PushAdapter(this) {
            public void a(int param1Int) {
              if (param1Int == 0)
                PushManager.j(this.a); 
            }
            
            public void a(int param1Int, String param1String) {
              String str = PushManager.f();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(" OPPO responseCode:");
              stringBuilder.append(param1Int);
              stringBuilder.append(" | OPPO tokenStr:");
              stringBuilder.append(param1String);
              Log.e(str, stringBuilder.toString());
              PushManager pushManager = this.a;
              stringBuilder = new StringBuilder();
              stringBuilder.append(" OPPO responseCode:");
              stringBuilder.append(param1Int);
              stringBuilder.append(" | OPPO tokenStr:");
              stringBuilder.append(param1String);
              PushManager.a(pushManager, stringBuilder.toString());
              if (param1Int == 0) {
                PushManager.a(this.a, 0);
                if (!TextUtils.isEmpty(param1String))
                  com.heytap.mcssdk.PushManager.a().a(PushManager.m(this.a), 0, 0, 23, 59); 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("OPPUSH:");
                stringBuilder1.append(param1String);
                String str1 = stringBuilder1.toString();
                BluedPreferences.X(param1String);
                PushManager.a().a(str1);
                return;
              } 
              PushManager.e(this.a);
              if (PushManager.f(this.a) < PushManager.g(this.a)) {
                PushManager pushManager1 = this.a;
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(" 重连次数 count = ");
                stringBuilder1.append(PushManager.f(this.a));
                PushManager.a(pushManager1, stringBuilder1.toString());
                com.heytap.mcssdk.PushManager.a().f();
                return;
              } 
              PushManager.a(this.a, 0);
            }
          }); 
  }
  
  private void n() {
    BluedPreferences.W("");
  }
  
  private String o() {
    return "F0ccY7Jssdko8S8OWoko8OsCK";
  }
  
  private String p() {
    return "e42117e29a3e7C1FB1641761Be6A164f";
  }
  
  private String q() {
    return DeviceUtils.f() ? "2882303761517594427" : "2882303761517164855";
  }
  
  private String r() {
    return DeviceUtils.f() ? "5301759433427" : "5931716426855";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 == 1000)
      if (paramInt2 == -1) {
        paramInt1 = paramIntent.getIntExtra("intent.extra.RESULT", 0);
        if (paramInt1 == 0) {
          b("错误成功解决");
          h();
          return;
        } 
        if (paramInt1 == 13) {
          b("解决错误过程被用户取消");
          return;
        } 
        if (paramInt1 == 8) {
          b("发生内部错误，重试可以解决");
          if (NetworkUtils.b()) {
            h();
            return;
          } 
        } else {
          b("未知返回码");
          return;
        } 
      } else {
        b("调用解决方案发生错误");
      }  
  }
  
  public void a(Activity paramActivity) {
    if (c(this.b)) {
      String str = Build.MANUFACTURER.toLowerCase();
      switch (str.hashCode()) {
        default:
          return;
        case 3620012:
          if (str.equals("vivo"))
            return; 
          return;
        case 3418016:
          if (str.equals("oppo"))
            return; 
          return;
        case -759499589:
          if (str.equals("xiaomi"))
            return; 
          return;
        case -1206476313:
          break;
      } 
      if (str.equals("huawei"));
    } 
  }
  
  public void a(String paramString) {
    BluedPreferences.W(paramString);
  }
  
  public void b(Context paramContext) {
    this.b = paramContext;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 推送初始化：");
    stringBuilder.append(Build.MANUFACTURER.toLowerCase());
    b(stringBuilder.toString());
    if (c(this.b)) {
      String str = Build.MANUFACTURER.toLowerCase();
      byte b = -1;
      switch (str.hashCode()) {
        case 3620012:
          if (str.equals("vivo"))
            b = 3; 
          break;
        case 3418016:
          if (str.equals("oppo"))
            b = 2; 
          break;
        case -759499589:
          if (str.equals("xiaomi"))
            b = 0; 
          break;
        case -1206476313:
          if (str.equals("huawei"))
            b = 1; 
          break;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (b != 3)
              return; 
            g();
            return;
          } 
          m();
          a(this.b.getString(2131755769), this.b.getString(2131755758), "1000");
          return;
        } 
        i();
        return;
      } 
      l();
      a(this.b.getString(2131755769), this.b.getString(2131755797), "pre84");
    } 
  }
  
  public void c() {
    byte b;
    b(" 暂停推送");
    String str = Build.MANUFACTURER.toLowerCase();
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 3620012:
        if (str.equals("vivo")) {
          b = 3;
          break;
        } 
      case 3418016:
        if (str.equals("oppo")) {
          b = 2;
          break;
        } 
      case -759499589:
        if (str.equals("xiaomi")) {
          b = 0;
          break;
        } 
      case -1206476313:
        if (str.equals("huawei")) {
          b = 1;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          if (b != 3)
            return; 
          if (this.b == null) {
            this.b = AppInfo.d();
            if (this.b == null)
              return; 
          } 
          PushClient.getInstance(this.b).turnOffPush(new IPushActionListener(this) {
                public void onStateChanged(int param1Int) {
                  if (param1Int != 0) {
                    PushManager pushManager = this.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("关闭vivo push异常[");
                    stringBuilder.append(param1Int);
                    stringBuilder.append("]");
                    PushManager.a(pushManager, stringBuilder.toString());
                    return;
                  } 
                  PushManager.a(this.a, "关闭vivo push成功");
                  PushManager.j(this.a);
                }
              });
          return;
        } 
        if (!TextUtils.isEmpty(com.heytap.mcssdk.PushManager.a().d())) {
          com.heytap.mcssdk.PushManager.a().g();
          return;
        } 
      } 
    } else if (!TextUtils.isEmpty(MiPushClient.o(this.b))) {
      MiPushClient.a(this.b, null);
    } 
  }
  
  public void d() {
    byte b;
    try {
      b(" 恢复推送");
      String str = Build.MANUFACTURER.toLowerCase();
      b = -1;
      switch (str.hashCode()) {
        case 3620012:
          if (str.equals("vivo"))
            b = 3; 
          break;
        case 3418016:
          if (str.equals("oppo"))
            b = 2; 
          break;
        case -759499589:
          if (str.equals("xiaomi"))
            b = 0; 
          break;
        case -1206476313:
          if (str.equals("huawei"))
            b = 1; 
          break;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      b(" 推送初始化失败！！！");
      return;
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          if (b != 3)
            return; 
          PushClient.getInstance(this.b).turnOnPush(new IPushActionListener(this) {
                public void onStateChanged(int param1Int) {
                  if (param1Int != 0) {
                    PushManager pushManager = this.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("打开vivo push异常[");
                    stringBuilder.append(param1Int);
                    stringBuilder.append("]");
                    PushManager.a(pushManager, stringBuilder.toString());
                    return;
                  } 
                  PushManager.a(this.a, "打开vivo push成功");
                }
              });
          return;
        } 
        com.heytap.mcssdk.PushManager.a().h();
        return;
      } 
      return;
    } 
    MiPushClient.b(this.b, null);
  }
  
  public void e() {
    String str1 = BluedPreferences.bq();
    Logger.b(a, new Object[] { "deviceToken:", str1 });
    String str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("deviceToken: ");
    stringBuilder.append(str1);
    Log.e(str2, stringBuilder.toString());
    if (TextUtils.isEmpty(str1))
      return; 
    BluedDeviceIdentity.a().a(str1);
    BluedConstant.b = true;
  }
  
  public static class PushManagerHolder {
    public static PushManager a = new PushManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\PushManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */