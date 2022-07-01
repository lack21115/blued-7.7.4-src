package com.soft.blued.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.blued.android.chat.BluedChat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.init.InitTask;
import com.blued.android.framework.init.InitTaskManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshHelper;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.location.LocationService;
import com.blued.android.modules.ModulesHelper;
import com.blued.android.pulltorefresh.WaveLoadingLayout;
import com.blued.android.statistics.BluedStatistics;
import com.qq.e.comm.managers.GDTADManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.smartrefresh.BluedLoadMoreView;
import com.soft.blued.customview.smartrefresh.BluedRefreshView;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.push.PushManager;
import com.soft.blued.service.AutoStartService;
import com.soft.blued.tinker.service.PatchCheckUpdateUtils;
import com.soft.blued.ui.home.manager.WelcomeADManager;
import com.soft.blued.ui.msg.controller.tools.IMManager;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.BuglyCrashRecorder;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.third.GeeTestUtils;
import com.soft.blued.utils.third.TTAdManagerHolder;
import com.soft.blued.utils.third.YouZanUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import java.util.ArrayList;

public class InitTaskUtil {
  private static String TAG = "InitTaskUtil";
  
  private static boolean startAutoStartService = true;
  
  public static InitTaskManager.OnTaskListBuilder generateTaskListBuilder() {
    return new InitTaskManager.OnTaskListBuilder() {
        public void onBuild(Application param1Application, ArrayList<InitTask> param1ArrayList) {
          ArrayList<InitTask> arrayList = param1ArrayList;
          if (param1ArrayList == null)
            arrayList = new ArrayList<InitTask>(); 
          arrayList.add(new InitTask(this, "BluedConfig") {
                public void b() {
                  BluedConfig.b();
                }
                
                public boolean d() {
                  return true;
                }
              });
          arrayList.add(new InitTask(this, "hookSP") {
                public void b() {
                  SharedPreferencesUtils.b();
                }
              });
          arrayList.add(new InitTask(this, "refreshUserInfo & 需要用户资料的一些初始化") {
                public void b() {
                  UserInfo.a().i();
                  WelcomeADManager.a().i();
                }
                
                public boolean d() {
                  return true;
                }
              });
          arrayList.add(new InitTask(this, "地图") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB())
                    InitTaskUtil.initMap(); 
                }
              });
          arrayList.add(new InitTask(this, "语言设置&下拉刷新") {
                public void b() {
                  LocaleUtils.d();
                  BluedApplicationLike.initAppLanguage();
                  BluedPreferences.b(0L);
                  PullToRefreshHelper.a(WaveLoadingLayout.class.getName());
                  WaveLoadingLayout.preloadLoadingAnimation(AppInfo.d());
                  SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator(this) {
                        public RefreshHeader a(Context param3Context, RefreshLayout param3RefreshLayout) {
                          param3RefreshLayout.c(new int[] { 2131100897, 17170445 });
                          return (RefreshHeader)new BluedRefreshView(param3Context);
                        }
                      });
                  SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator(this) {
                        public RefreshFooter a(Context param3Context, RefreshLayout param3RefreshLayout) {
                          param3RefreshLayout.f(30.0F);
                          return (RefreshFooter)new BluedLoadMoreView(param3Context);
                        }
                      });
                }
              });
          arrayList.add(new InitTask(this, "友盟") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB())
                    InitTaskUtil.initYouMeng(); 
                }
              });
          if (!PushManager.b())
            arrayList.add(new InitTask(this, "connectIm") {
                  public void b() {
                    BluedChat.getInstance().startIMService(AppInfo.d());
                  }
                }); 
          arrayList.add(new InitTask(this, "AutoStartService") {
                public void b() {
                  EmotionManager.b();
                  AppInfo.n().post(new Runnable(this) {
                        public void run() {
                          if (InitTaskUtil.getStartAutoStartService() && BluedApplicationLike.isMainApplication(AppInfo.d()))
                            AutoStartService.a(AppInfo.d()); 
                        }
                      });
                }
                
                public boolean d() {
                  return true;
                }
              });
          arrayList.add(new InitTask(this, "广点通") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB()) {
                    Logger.c("ljx_init", new Object[] { "guang dian tong" });
                    GDTADManager.getInstance().initWith(AppInfo.d(), BluedConstant.a());
                  } 
                }
                
                public boolean d() {
                  return true;
                }
              });
          arrayList.add(new InitTask(this, "穿山甲SDK初始化") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB())
                    InitTaskUtil.initTTAdSDK(); 
                }
              });
          arrayList.add(new InitTask(this, "IMEI&AsyncTask") {
                public void b() {
                  if (PermissionHelper.a(new String[] { "android.permission.READ_PHONE_STATE" })) {
                    TelephonyManager telephonyManager = (TelephonyManager)AppInfo.d().getSystemService("phone");
                    String str = null;
                    try {
                      String str1 = telephonyManager.getDeviceId();
                      str = str1;
                    } catch (SecurityException securityException) {
                      securityException.printStackTrace();
                    } 
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("IMEI: ");
                    stringBuilder.append(str);
                    LogUtils.c(stringBuilder.toString());
                    if (!AppMethods.c(str)) {
                      str = "";
                    } else {
                      AppInfo.c(str);
                    } 
                    BluedStatistics.a().i(str);
                  } 
                  try {
                    return;
                  } finally {
                    Exception exception = null;
                  } 
                }
              });
          arrayList.add(new InitTask(this, "激活统计") {
                public void b() {
                  BluedPreferences.m();
                  if (!BluedPreferences.bz())
                    AppInfo.n().postDelayed(new Runnable(this) {
                          public void run() {
                            AppHttpUtils.a(new BluedUIHttpResponse(this) {
                                  public void onUIUpdate(BluedEntity param4BluedEntity) {
                                    BluedPreferences.bA();
                                  }
                                },  );
                          }
                        },  2000L); 
                  BluedPreferences.C(false);
                }
              });
          arrayList.add(new InitTask(this, "下拉刷新字符串") {
                public void b() {
                  PullToRefreshHelper.a(2131758476, 2131758479, 2131758478, 2131756019, 2131757789);
                }
              });
          arrayList.add(new InitTask(this, "Patch更新") {
                public void b() {
                  AppInfo.n().postDelayed(new Runnable(this) {
                        public void run() {
                          PatchCheckUpdateUtils.a();
                        }
                      },  2000L);
                }
              });
          arrayList.add(new InitTask(this, "其他模块") {
                public void b() {
                  ModulesHelper.a();
                }
              });
          arrayList.add(new InitTask(this, "页面时长") {
                public void b() {
                  PageTimeUtils.a("pagebiz_table.json");
                }
                
                public boolean d() {
                  return true;
                }
              });
          arrayList.add(new InitTask(this, "zego") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB())
                    InitTaskUtil.initZego(); 
                }
              });
          arrayList.add(new InitTask(this, "设备标识") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB()) {
                    BluedDeviceIdentity bluedDeviceIdentity = BluedDeviceIdentity.a();
                    Context context = AppInfo.d();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(BluedHttpUrl.n());
                    stringBuilder.append("/blued/device");
                    bluedDeviceIdentity.a(context, stringBuilder.toString(), "com.bluecity.blued-KPiA1xP30QYJy", "3UOTFs6sc6mC8ZTmjKckn3cWfnk7hIbS");
                  } 
                }
              });
          arrayList.add(new InitTask(this, "BluedAPM") {
                public void b() {
                  BluedStatistics.a(BluedHttpUrl.t(), 443, HappyDnsUtils.d());
                  DisplayMetrics displayMetrics = AppInfo.d().getResources().getDisplayMetrics();
                  BluedStatistics.a().g("android_china").e(AppInfo.c).h(AppInfo.g).a(AppInfo.h).b(NetworkUtils.d()).a(DeviceUtils.d()).a(new Point(displayMetrics.widthPixels, displayMetrics.heightPixels));
                  IMManager.a().d();
                }
              });
          arrayList.add(new InitTask(this, "推送") {
                public void b() {
                  PushManager.a().b(AppInfo.d());
                }
                
                public boolean d() {
                  return true;
                }
                
                public boolean e() {
                  return false;
                }
              });
          arrayList.add(new InitTask(this, "极验一键登录") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB())
                    InitTaskUtil.initGeeTestSDK(); 
                }
                
                public boolean d() {
                  return true;
                }
                
                public boolean e() {
                  return false;
                }
              });
          arrayList.add(new InitTask(this, "YouZanSDK初始化") {
                public void b() {
                  if (BluedPreferences.aA() == 1 || BluedPreferences.aB())
                    InitTaskUtil.initYouZanSDK(); 
                }
                
                public boolean d() {
                  return true;
                }
                
                public boolean e() {
                  return false;
                }
              });
        }
      };
  }
  
  public static boolean getStartAutoStartService() {
    return startAutoStartService;
  }
  
  public static void initBuglyCrash(Context paramContext) {
    Logger.c("ljx_init", new Object[] { "bugly crash" });
    CrashReport.setIsDevelopmentDevice(paramContext, false);
    CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(paramContext);
    userStrategy.setUploadProcess(BluedApplicationLike.isMainApplication(paramContext));
    userStrategy.setCrashHandleCallback((CrashReport.CrashHandleCallback)new BuglyCrashRecorder());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("7.7.4");
    stringBuilder.append(".");
    stringBuilder.append(6);
    String str = stringBuilder.toString();
    Log.i("initBuglyCrash", str);
    userStrategy.setAppVersion(str);
    CrashReport.initCrashReport(paramContext, "cf53dd5a91", false, userStrategy);
  }
  
  public static void initGeeTestSDK() {
    Logger.c("ljx_init", new Object[] { "极验一键登录" });
    GeeTestUtils.a(AppInfo.d());
  }
  
  public static void initMap() {
    Logger.c("ljx_init", new Object[] { "map" });
    LocationService.a(AppUtils.a());
    DeviceUtils.a(null, false);
    LocationService.a(BluedHttpUrl.n());
  }
  
  public static void initTTAdSDK() {
    Logger.c("ljx_init", new Object[] { "穿山甲SDK初始化" });
    TTAdManagerHolder.b(AppInfo.d());
  }
  
  public static void initYouMeng() {
    Logger.c("ljx_init", new Object[] { "youmeng" });
    UMConfigure.init(AppInfo.d(), "5359cd0256240b7faf0a09db", AppInfo.c, 1, null);
    UMConfigure.setLogEnabled(false);
    MobclickAgent.setDebugMode(false);
    MobclickAgent.setCatchUncaughtExceptions(false);
    MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
  }
  
  public static void initYouZanSDK() {
    Logger.c("ljx_init", new Object[] { "YouZanSDK初始化" });
    YouZanUtils.a();
  }
  
  public static void initZego() {
    Logger.c("ljx_init", new Object[] { "zego" });
    if (BluedApplicationLike.isMainApplication(AppInfo.d()))
      ZegoCommonHelper.a(); 
  }
  
  public static void setStartAutoStartService(boolean paramBoolean) {
    startAutoStartService = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\app\InitTaskUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */