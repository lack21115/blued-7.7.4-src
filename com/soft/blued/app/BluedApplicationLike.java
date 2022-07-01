package com.soft.blued.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.multidex.MultiDex;
import com.blued.android.chat.ChatDBImpl;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.db.DBOper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.flutter.FlutterCommonArgModel;
import com.blued.android.framework.flutter.FlutterManager;
import com.blued.android.framework.flutter.FlutterPageRouter;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.init.InitTaskManager;
import com.blued.android.framework.provider.IAppInfoProvider;
import com.blued.android.framework.provider.IPageLifecycleProvider;
import com.blued.android.framework.provider.IStringResourceProvider;
import com.blued.android.framework.provider.IUserInfoProvider;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.web.cache.BluedWebViewCache;
import com.blued.android.framework_operation_provider.PageLifecycleProvider;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.provider.AppInfoProvider;
import com.blued.android.provider.StringResourceProvider;
import com.blued.android.provider.UserInfoProvider;
import com.blued.android.statistics.BluedStatistics;
import com.huawei.android.hms.agent.common.ActivityMgr;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Platform;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import com.mcxiaoke.packer.helper.PackerNg;
import com.soft.blued.http.Host;
import com.soft.blued.manager.BroadcastReceiverListener;
import com.soft.blued.manager.BroadcastReceiverManager;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.push.mipush.MiPushMessageReceiver;
import com.soft.blued.service.AutoStartService;
import com.soft.blued.tinker.Log.MyLogImp;
import com.soft.blued.tinker.reporter.BluedTinkerReport;
import com.soft.blued.tinker.util.TinkerManager;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.video.manager.NetWorkObserverManager;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.ui.yy_room.YYRoomInfoChannel;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.DurationUtils;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.HookActivityManager;
import com.soft.blued.utils.NetworkUtils;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.umeng.commonsdk.UMConfigure;
import io.flutter.embedding.android.FlutterView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class BluedApplicationLike extends DefaultApplicationLike {
  public static final boolean DEBUG_CHAT = false;
  
  public static final boolean DEBUG_HTTP = false;
  
  private static final String[] GOTO_FIRST_ACTIVITY_CLASSES = new String[] { "com.soft.blued.icon0", "com.soft.blued.icon1", "com.soft.blued.icon2", "com.soft.blued.icon3", "com.soft.blued.icon4", "com.soft.blued.icon5", "com.soft.blued.icon6", "com.soft.blued.ui.welcome.FirstActivity", "com.soft.blued.ui.welcome.PushClickActivity" };
  
  public static boolean SPECIAL_DEVICE_FOR_VIEW_OVERFLOW = false;
  
  private static final String TAG = "Tinker.BluedApplication";
  
  public static final boolean TEST_SERVER = false;
  
  public static BluedAppHandoverListener bluedAppHandoverListener;
  
  public static boolean checkLaunchPermission = false;
  
  public static boolean ifFeedFloatAuthShowed = false;
  
  public static Uri outUri = null;
  
  public static String previousLanguage;
  
  public static final String umengAppKey = "5359cd0256240b7faf0a09db";
  
  private Tinker tinker;
  
  static {
    ifFeedFloatAuthShowed = false;
    checkLaunchPermission = true;
  }
  
  public BluedApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent) {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
  }
  
  private static void applyLanguage(String paramString1, String paramString2) {
    Resources resources = AppInfo.d().getResources();
    Configuration configuration = resources.getConfiguration();
    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
    configuration.locale = new Locale(paramString1, paramString2);
    resources.updateConfiguration(configuration, displayMetrics);
  }
  
  public static long getAppIntoForegroundTime() {
    BluedAppHandoverListener bluedAppHandoverListener = bluedAppHandoverListener;
    return (bluedAppHandoverListener != null) ? bluedAppHandoverListener.d() : 0L;
  }
  
  public static Activity getForeActivity() {
    BluedAppHandoverListener bluedAppHandoverListener = bluedAppHandoverListener;
    return (bluedAppHandoverListener != null) ? bluedAppHandoverListener.c() : null;
  }
  
  public static String getProcessName(Context paramContext) {
    int i = Process.myPid();
    List list = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
    if (list != null)
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
        if (runningAppProcessInfo.pid == i)
          return runningAppProcessInfo.processName; 
      }  
    return "";
  }
  
  public static void initAppGlobal(Application paramApplication) {
    initAppInfo(paramApplication);
    if (BluedPreferences.aA() == 1 || BluedPreferences.aB())
      AppInfo.q(); 
    setChannel();
    initHttpManager((Context)paramApplication);
    initSimilarity();
    initBluedFramework();
    Host.a();
    initChatManager();
    ActivityMgr.INST.init(paramApplication, null);
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
          public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
          
          public void onActivityDestroyed(Activity param1Activity) {}
          
          public void onActivityPaused(Activity param1Activity) {}
          
          public void onActivityResumed(Activity param1Activity) {
            SendNotificationManager.a().b(param1Activity);
          }
          
          public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
          
          public void onActivityStarted(Activity param1Activity) {}
          
          public void onActivityStopped(Activity param1Activity) {
            SendNotificationManager.a().a(param1Activity);
          }
        });
  }
  
  public static void initAppInfo(Application paramApplication) {
    if (!AppInfo.c()) {
      AppInfo.a(paramApplication, "1", false);
      AppInfo.s = 0.1F;
      bluedAppHandoverListener = new BluedAppHandoverListener(AppInfo.d());
      AppInfo.b(FirstActivity.class.getName());
      AppInfo.a(bluedAppHandoverListener);
      String str = Build.MODEL.toLowerCase();
      if (!TextUtils.isEmpty(str) && (str.contains("oppo r11") || str.contains("vivo x9")))
        SPECIAL_DEVICE_FOR_VIEW_OVERFLOW = true; 
      AppInfo.a(true, 2131100728, 2131100728);
    } 
  }
  
  public static void initAppLanguage() {
    String str;
    Locale locale1 = LocaleUtils.e();
    Locale locale2 = LocaleUtils.c();
    if (locale1 != null && locale2 != null && LocaleUtils.a() && !TextUtils.isEmpty(locale1.getLanguage()) && (!TextUtils.equals(locale1.getLanguage(), locale2.getLanguage()) || !TextUtils.equals(locale1.getCountry(), locale2.getCountry()))) {
      LocaleUtils.a(AppInfo.d(), locale1);
      Logger.b("xpf", new Object[] { "not equal" });
    } else {
      locale1 = locale2;
    } 
    if (locale1 != null) {
      str = locale1.getLanguage();
    } else {
      str = "";
    } 
    if (!TextUtils.isEmpty(str))
      if (BluedPreferences.aE()) {
        previousLanguage = str;
      } else {
        previousLanguage = null;
      }  
    LocaleUtils.b(AppInfo.d(), locale1);
  }
  
  public static void initBluedFramework() {
    ProviderHolder.a().a((IUserInfoProvider)new UserInfoProvider());
    ProviderHolder.a().a((IStringResourceProvider)new StringResourceProvider());
    ProviderHolder.a().a((IPageLifecycleProvider)new PageLifecycleProvider());
    ProviderHolder.a().a((IAppInfoProvider)new AppInfoProvider());
    BluedURIRouter.a().b("bd_uri_router.json");
    BluedURIRouter.a().c("bd_uri_prefix.json");
    BluedURIRouter.a().a("com.blued.android.similarity_operation_provider.BluedURIRouterAdapter");
    BluedWebViewCache.a(new String[] { "https://web.bldimg.com", "https://www.bldimg.com" });
    BluedWebViewCache.b(new String[] { "css", "js" });
  }
  
  public static void initChatManager() {
    if (!ChatManager.isInited())
      ChatManager.getInstance().init(AppInfo.d(), ChatManager.ClientType.CHINA, (DBOper)new ChatDBImpl(), false); 
  }
  
  private void initFlutter(Application paramApplication) {
    INativeRouter iNativeRouter = new INativeRouter(this) {
        public void a(Context param1Context, String param1String, Map<String, Object> param1Map1, int param1Int, Map<String, Object> param1Map2) {
          param1String = Utils.a(param1String, param1Map1);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Flutter openContainer: ");
          stringBuilder.append(param1String);
          stringBuilder.append(", urlParams:");
          stringBuilder.append(param1Map1.toString());
          LogUtils.c(stringBuilder.toString());
          FlutterPageRouter.a(param1Context, param1String, param1Map1);
        }
      };
    FlutterBoost.BoostLifecycleListener boostLifecycleListener = new FlutterBoost.BoostLifecycleListener(this) {
        public void a() {
          LogUtils.c("Flutter beforeCreateEngine");
        }
        
        public void b() {
          LogUtils.c("Flutter onEngineCreated");
          FlutterManager.a(FlutterBoost.a().g().getDartExecutor());
        }
      };
    Platform platform = (new FlutterBoost.ConfigBuilder(paramApplication, iNativeRouter)).a(false).a(AppInfo.f().toJson(FlutterCommonArgModel.getDefault())).a(FlutterBoost.ConfigBuilder.b).a(FlutterView.RenderMode.texture).a(boostLifecycleListener).a();
    FlutterBoost.a().a(platform);
  }
  
  public static void initHttpManager(Context paramContext) {
    if (!HttpManager.a())
      (new HttpManager.Builder(paramContext)).a(false).a(HappyDnsUtils.d()).a(); 
  }
  
  private void initLiveRoomCallBack() {
    LiveRoomInfoChannel.a();
  }
  
  private void initReceiver() {
    BroadcastReceiverManager broadcastReceiverManager = BroadcastReceiverManager.a();
    BroadcastReceiverListener broadcastReceiverListener = new BroadcastReceiverListener(this) {
        public void a(String param1String, Intent param1Intent) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("AutoStartReceiver.onReceive(), intent:");
          stringBuilder.append(param1Intent.getAction());
          Logger.a(stringBuilder.toString(), new Object[0]);
          AutoStartService.a(AppInfo.d());
        }
      };
    broadcastReceiverManager.a(new String[] { "android.net.conn.CONNECTIVITY_CHANGE", "android.intent.action.USER_PRESENT", "com.soft.blued.android.ACTION_AUTOSTARTER" }, broadcastReceiverListener);
    BroadcastReceiverManager.a().a("android.intent.action.LOCALE_CHANGED", new BroadcastReceiverListener(this) {
          public void a(String param1String, Intent param1Intent) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LOCALE_CHANGED.onReceive(), intent:");
            stringBuilder.append(param1Intent.getAction());
            Logger.a(stringBuilder.toString(), new Object[0]);
            LocaleUtils.d();
            if (LocaleUtils.a()) {
              LocaleUtils.a(AppInfo.d(), LocaleUtils.e());
              AppUtils.a(AppInfo.d());
              return;
            } 
            LocaleUtils.c(AppInfo.d());
          }
        });
    BroadcastReceiverManager.a().a("android.net.conn.CONNECTIVITY_CHANGE", new BroadcastReceiverListener(this) {
          public void a(String param1String, Intent param1Intent) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CONNECTIVITY_CHANGE.onReceive(), intent:");
            stringBuilder.append(param1Intent.getAction());
            Logger.a(stringBuilder.toString(), new Object[0]);
            BluedStatistics.a().b(NetworkUtils.d());
            BluedStatistics.a().a(DeviceUtils.d());
            NetworkInfo networkInfo = ((ConnectivityManager)AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
              ChatManager.getInstance().networkChanged();
              NetWorkObserverManager.a().a(true);
              if (networkInfo != null && networkInfo.getType() == 1) {
                NetWorkObserverManager.a().b(true);
                Logger.a("Tinker.BluedApplication  wifi状�??", new Object[0]);
                return;
              } 
              NetWorkObserverManager.a().b(false);
              LiveSysNetworkObserver.a().b();
              Logger.a("Tinker.BluedApplication  正常联网的非wifi状�??", new Object[0]);
              return;
            } 
            Logger.a("Tinker.BluedApplication 非联网状�?", new Object[0]);
            NetWorkObserverManager.a().a(false);
          }
        });
    BroadcastReceiverManager.a().a("android.intent.action.DOWNLOAD_COMPLETE", new BroadcastReceiverListener(this) {
          public void a(String param1String, Intent param1Intent) {
            if (param1Intent != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("DOWNLOAD_COMPLETE.onReceive(), intent:");
              stringBuilder.append(param1Intent.getAction());
              Logger.a(stringBuilder.toString(), new Object[0]);
              String str = BluedPreferences.f(param1Intent.getLongExtra("extra_download_id", -1L));
              if (!TextUtils.isEmpty(str))
                FileUtils.b(new File(str)); 
            } 
          }
        });
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
    intentFilter.addAction("com.huawei.android.push.intent.RECEIVE");
    intentFilter.addAction("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    intentFilter = new IntentFilter();
    intentFilter.addAction("com.xiaomi.mipush.RECEIVE_MESSAGE");
    intentFilter.addAction("com.xiaomi.mipush.MESSAGE_ARRIVED");
    intentFilter.addAction("com.xiaomi.mipush.ERROR");
    getApplication().getBaseContext().registerReceiver((BroadcastReceiver)new MiPushMessageReceiver(), intentFilter);
  }
  
  public static void initSimilarity() {
    BluedURIRouter.a().a(true);
    BluedURIRouter.a().a("com.blued.android.similarity_operation_provider.BluedURIRouterAdapter");
  }
  
  public static void initSkinSdk(Application paramApplication) {
    try {
      BluedSkinUtils.a(paramApplication);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void initYYRoomCallBack() {
    YYRoomInfoChannel.a();
  }
  
  public static boolean isAppOnForeground() {
    BluedAppHandoverListener bluedAppHandoverListener = bluedAppHandoverListener;
    return (bluedAppHandoverListener != null) ? bluedAppHandoverListener.b() : false;
  }
  
  public static boolean isMainApplication(Context paramContext) {
    return getProcessName(paramContext).equals(paramContext.getApplicationContext().getPackageName());
  }
  
  public static boolean isPushProcess(Context paramContext) {
    String str = getProcessName(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getApplicationContext().getPackageName());
    stringBuilder.append(":push");
    return TextUtils.equals(str, stringBuilder.toString());
  }
  
  public static void setChannel() {
    String str2 = PackerNg.a(AppInfo.d());
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      try {
        ApplicationInfo applicationInfo = AppInfo.d().getPackageManager().getApplicationInfo(AppInfo.d().getPackageName(), 128);
        str1 = str2;
        if (applicationInfo != null) {
          str1 = str2;
          if (applicationInfo.metaData != null)
            str1 = applicationInfo.metaData.getString("UMENG_CHANNEL"); 
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        nameNotFoundException.printStackTrace();
        str1 = str2;
      }  
    str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = "a9999a"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setChannel: ");
    stringBuilder.append(str2);
    LogUtils.c(stringBuilder.toString());
    AppInfo.a(str2);
  }
  
  public void initUMeng(Application paramApplication) {
    UMConfigure.preInit((Context)paramApplication, "5359cd0256240b7faf0a09db", AppInfo.c);
  }
  
  public void onBaseContextAttached(Context paramContext) {
    super.onBaseContextAttached(paramContext);
    MultiDex.install(paramContext);
    TinkerManager.a((ApplicationLike)this);
    TinkerManager.b();
    TinkerManager.a(true);
    TinkerInstaller.setLogIml((TinkerLog.TinkerLogImp)new MyLogImp());
    TinkerManager.b((ApplicationLike)this);
    this.tinker = Tinker.with((Context)getApplication());
    (new BluedTinkerReport()).a(new BluedTinkerReport.Reporter(this) {
          public void a(int param1Int) {
            Logger.b("PTH", new Object[] { "key:", Integer.valueOf(param1Int) });
          }
          
          public void a(String param1String) {
            Logger.b("PTH", new Object[] { "message:", param1String });
          }
        });
  }
  
  public void onCreate() {
    super.onCreate();
    HookActivityManager.a("ljx_wifi", (Context)getApplication());
    DurationUtils.a();
    Tinker tinker = this.tinker;
    if (tinker != null && tinker.isPatchProcess()) {
      Logger.b("PTH", new Object[] { "isPatchProcess" });
      return;
    } 
    if (isPushProcess((Context)getApplication())) {
      Logger.b("PTH", new Object[] { "isPushProcess" });
      return;
    } 
    if (isMainApplication((Context)getApplication())) {
      Logger.b("PTH", new Object[] { "isMainProcess" });
    } else {
      Logger.b("PTH", new Object[] { "Process:", getProcessName((Context)getApplication()) });
    } 
    InitTaskUtil.initBuglyCrash((Context)getApplication());
    initSkinSdk(getApplication());
    initAppGlobal(getApplication());
    initReceiver();
    initUMeng(getApplication());
    initLiveRoomCallBack();
    initYYRoomCallBack();
    try {
      Object object = Class.forName("com.soft.blued.app.InitTaskUtil").getMethod("generateTaskListBuilder", new Class[0]).invoke(null, new Object[0]);
      InitTaskManager.a().a(getApplication(), GOTO_FIRST_ACTIVITY_CLASSES, (InitTaskManager.OnTaskListBuilder)object);
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    initFlutter(getApplication());
    if (Build.VERSION.SDK_INT == 28)
      HookActivityManager.a(); 
  }
  
  public void onLowMemory() {
    super.onLowMemory();
    ImageLoader.b();
    if (AppInfo.c())
      MemoryRequest.a().b(); 
  }
  
  public void onTrimMemory(int paramInt) {
    super.onTrimMemory(paramInt);
    ImageLoader.a(paramInt);
    if (AppInfo.c())
      MemoryRequest.a().a(paramInt); 
  }
  
  public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks) {
    getApplication().registerActivityLifecycleCallbacks(paramActivityLifecycleCallbacks);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\app\BluedApplicationLike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */