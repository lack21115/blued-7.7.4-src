package com.soft.blued.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.location.LocationService;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.authority.SystemAuthorityProtos;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.control.LocationHelperNew;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackSystemAuthority;
import com.soft.blued.ui.home.manager.WelcomeADManager;
import com.soft.blued.version.update.UpdateVersionFragment;
import com.soft.blued.version.update.UpdateVersionHelper;
import java.lang.reflect.Method;
import java.util.UUID;

public class DeviceUtils {
  private static final String a = DeviceUtils.class.getSimpleName();
  
  public static void a(Context paramContext) {
    if (f())
      return; 
    Context context = paramContext;
    if (paramContext == null)
      context = AppInfo.d(); 
    int i = UpdateVersionHelper.a(context);
    if (i != -1) {
      if (i != 2) {
        if (i != 8)
          return; 
        UpdateVersionFragment.a(context, "i_s_install_update");
        return;
      } 
    } else {
      MineHttpUtils.a(context, "0", (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<DownloadBaseInfo>>() {
            protected BluedEntityA<DownloadBaseInfo> a(String param1String) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(DeviceUtils.j());
              stringBuilder.append("===update json");
              Logger.a(stringBuilder.toString(), new Object[] { param1String });
              return (BluedEntityA<DownloadBaseInfo>)super.parseData(param1String);
            }
            
            public void a(BluedEntityA<DownloadBaseInfo> param1BluedEntityA) {
              if (param1BluedEntityA != null)
                try {
                  if (param1BluedEntityA.hasData()) {
                    DownloadBaseInfo downloadBaseInfo = param1BluedEntityA.data.get(0);
                    String str = downloadBaseInfo.type;
                    if (!TextUtils.isEmpty(downloadBaseInfo.version_code))
                      BluedPreferences.Y(downloadBaseInfo.version_code); 
                    if (!StringUtils.e(str) && str.equals("0"))
                      return; 
                    if (!TextUtils.isEmpty(str) && str.equals("1"))
                      return; 
                    if (!TextUtils.isEmpty(str) && str.equals("2")) {
                      UpdateVersionFragment.a(AppInfo.d(), downloadBaseInfo, "i_s_strong_update");
                      return;
                    } 
                  } 
                } catch (Exception exception) {
                  exception.printStackTrace();
                }  
            }
            
            public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
              String str = DeviceUtils.j();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("===update responseCode json===");
              stringBuilder.append(param1String);
              Logger.a(str, new Object[] { stringBuilder.toString() });
              super.onFailure(param1Throwable, param1Int, param1String);
            }
            
            public void onUIFinish() {}
          });
    } 
  }
  
  public static void a(LocationHelperNew.LocationFinishListener paramLocationFinishListener) {
    boolean bool = BluedPreferences.l();
    boolean bool1 = true;
    if (bool) {
      Logger.a("location", "大于24");
      bool = bool1;
      if (!BluedPreferences.p()) {
        Logger.a("location", "未检查过");
        BluedPreferences.o();
        bool = bool1;
      } 
    } else {
      Logger.a("location", "小于24");
      if (!BluedPreferences.p()) {
        Logger.a("location", "不需要检查");
        bool = false;
        BluedPreferences.o();
      } else {
        Logger.a("location", "需要检查");
        bool = bool1;
      } 
    } 
    a(paramLocationFinishListener, bool);
  }
  
  public static void a(LocationHelperNew.LocationFinishListener paramLocationFinishListener, boolean paramBoolean) {
    if (paramBoolean && !WelcomeADManager.a().c()) {
      EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.SYSTEM_AUTHORITY, SystemAuthorityProtos.Type.LOCATION, PermissionHelper.a(new String[] { "android.permission.ACCESS_FINE_LOCATION" }));
      PermissionHelper.c(new PermissionCallbacks(paramLocationFinishListener) {
            public void a(String[] param1ArrayOfString) {
              LocationHelperNew.LocationFinishListener locationFinishListener = this.a;
              if (locationFinishListener != null)
                locationFinishListener.a(-1001); 
            }
            
            public void aa_() {
              DeviceUtils.c(this.a);
            }
          });
      return;
    } 
    AppInfo.n().post(new Runnable(paramLocationFinishListener) {
          public void run() {
            DeviceUtils.c(this.a);
          }
        });
  }
  
  public static boolean a() {
    String str1 = BlueAppLocal.c().getLanguage();
    String str2 = BlueAppLocal.c().getCountry();
    return (!StringUtils.e(str1) && !StringUtils.e(str2) && str1.toLowerCase().equals("zh") && str2.toUpperCase().equals("CN"));
  }
  
  public static int b() {
    return 707046;
  }
  
  public static void b(LocationHelperNew.LocationFinishListener paramLocationFinishListener) {
    boolean bool;
    if (!BluedPreferences.r()) {
      bool = false;
      BluedPreferences.q();
    } else {
      bool = true;
    } 
    a(paramLocationFinishListener, bool);
  }
  
  public static boolean b(Context paramContext) {
    try {
      if (Build.VERSION.SDK_INT < 18)
        return true; 
      AppOpsManager appOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
      String str = paramContext.getApplicationContext().getPackageName();
      int i = applicationInfo.uid;
      Class<?> clazz = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)clazz.getMethod("checkOpNoThrow", new Class[] { int.class, int.class, String.class }).invoke(appOpsManager, new Object[] { Integer.valueOf(((Integer)clazz.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      return (i == 0);
    } catch (Exception exception) {
      exception.printStackTrace();
      return true;
    } 
  }
  
  public static String c() {
    return "7.7.4";
  }
  
  public static void c(LocationHelperNew.LocationFinishListener paramLocationFinishListener) {
    LocationService.a(new -$$Lambda$DeviceUtils$4ohSwACMsrSt-NvL5G0yopQeS50(paramLocationFinishListener));
  }
  
  public static String d() {
    TelephonyManager telephonyManager = (TelephonyManager)AppInfo.d().getSystemService("phone");
    if (PermissionHelper.a(new String[] { "android.permission.READ_PHONE_STATE" })) {
      if (Build.VERSION.SDK_INT >= 29)
        return telephonyManager.getSimOperatorName(); 
      String str = telephonyManager.getSubscriberId();
      if (!TextUtils.isEmpty(str)) {
        String str1;
        if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007"))
          return "中国移动"; 
        if (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009"))
          return "中国联通"; 
        if (!str.startsWith("46003") && !str.startsWith("46005")) {
          str1 = str;
          if (str.startsWith("46011"))
            return "中国电信"; 
        } else {
          return "中国电信";
        } 
        return str1;
      } 
    } 
    return "";
  }
  
  public static boolean e() {
    return "smartisan".equals(Build.MANUFACTURER);
  }
  
  public static boolean f() {
    return TextUtils.equals("a0300a", AppInfo.c);
  }
  
  public static String g() {
    String str;
    if (!TextUtils.isEmpty(AppInfo.d) || !TextUtils.isEmpty(AppInfo.e)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(AppInfo.d);
      stringBuilder.append(AppInfo.e);
      str = stringBuilder.toString();
    } else {
      String str1 = BluedPreferences.b().getString("uuid", null);
      str = str1;
      if (TextUtils.isEmpty(str1)) {
        str = UUID.randomUUID().toString().replaceAll("-", "");
        BluedPreferences.b().edit().putString("uuid", str).commit();
      } 
    } 
    try {
      null = Md5.a(str, AesCrypto.b);
      String str1 = Md5.a(null, AesCrypto.b);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return str;
    } 
  }
  
  public static String h() {
    String str;
    if (!TextUtils.isEmpty(AppInfo.d) || !TextUtils.isEmpty(AppInfo.e)) {
      if (Build.VERSION.SDK_INT < 21) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppInfo.d);
        stringBuilder.append(AppInfo.e);
        str = stringBuilder.toString();
      } else {
        String[] arrayOfString = i();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfString[0]);
        stringBuilder.append(arrayOfString[1]);
        stringBuilder.append(AppInfo.e);
        str = stringBuilder.toString();
      } 
    } else {
      String str1 = BluedPreferences.b().getString("uuid", null);
      str = str1;
      if (TextUtils.isEmpty(str1)) {
        str = UUID.randomUUID().toString().replaceAll("-", "");
        BluedPreferences.b().edit().putString("uuid", str).commit();
      } 
    } 
    try {
      null = Md5.a(str, AesCrypto.b);
      String str1 = Md5.a(null, AesCrypto.b);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return str;
    } 
  }
  
  public static String[] i() {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    TelephonyManager telephonyManager = (TelephonyManager)AppInfo.d().getSystemService("phone");
    try {
      Method method = telephonyManager.getClass().getDeclaredMethod("getImei", new Class[] { int.class });
      String str1 = (String)method.invoke(telephonyManager, new Object[] { Integer.valueOf(0) });
      String str2 = (String)method.invoke(telephonyManager, new Object[] { Integer.valueOf(1) });
      if (!TextUtils.isEmpty(str1))
        arrayOfString[0] = str1; 
      if (!TextUtils.isEmpty(str2))
        arrayOfString[1] = str2; 
      return arrayOfString;
    } catch (Exception exception) {
      return arrayOfString;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */