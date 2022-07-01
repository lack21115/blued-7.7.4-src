package com.blued.android.framework.flutter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageFileWrapper;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.HashidEncryptTool;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.live.LiveProtos;
import com.blued.das.superexpose.SuperExposeProtos;
import com.blued.das.vip.VipProtos;
import com.idlefish.flutterboost.FlutterBoost;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.log.trackUtils.EventTrackSuperExpose;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.fragment.LiveListTabFragment;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlutterManager {
  private static MethodChannel a;
  
  private static MethodChannel b;
  
  private static MethodChannel c;
  
  private static MethodChannel d;
  
  private static MethodChannel e;
  
  private static MethodChannel f;
  
  private static MethodChannel g;
  
  private static MethodChannel h;
  
  private static MethodChannel a(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_network_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$hoXc8JWIeTiV5cgsC9GOBRl7QXg.INSTANCE);
    return methodChannel;
  }
  
  private static void a(Activity paramActivity) {
    if (Build.MANUFACTURER.toLowerCase().equals("huawei"))
      paramActivity.overridePendingTransition(2130772039, 2130772039); 
  }
  
  public static void a(Context paramContext, FlutterRouteArgModel paramFlutterRouteArgModel) {
    FlutterRouteArgModel flutterRouteArgModel = paramFlutterRouteArgModel;
    if (paramFlutterRouteArgModel == null)
      flutterRouteArgModel = FlutterRouteArgModel.getDefault(); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("route_name", flutterRouteArgModel.routeName);
    hashMap.put("user_id", flutterRouteArgModel.user_id);
    hashMap.put("user_name", flutterRouteArgModel.user_name);
    hashMap.put("user_avatar", flutterRouteArgModel.user_avatar);
    hashMap.put("dark_mode", Integer.valueOf(flutterRouteArgModel.darkMode));
    hashMap.put("language", flutterRouteArgModel.language);
    hashMap.put("h5_host", flutterRouteArgModel.h5_host);
    if (flutterRouteArgModel.extra != null)
      hashMap.putAll(flutterRouteArgModel.extra); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("strArg: ");
    stringBuilder.append(hashMap.toString());
    LogUtils.c(stringBuilder.toString());
    FlutterPageRouter.a(paramContext, flutterRouteArgModel.routeName, hashMap);
  }
  
  public static void a(DartExecutor paramDartExecutor) {
    a = a((BinaryMessenger)paramDartExecutor);
    b = b((BinaryMessenger)paramDartExecutor);
    c = c((BinaryMessenger)paramDartExecutor);
    d = d((BinaryMessenger)paramDartExecutor);
    e = e((BinaryMessenger)paramDartExecutor);
    f = f((BinaryMessenger)paramDartExecutor);
    g = g((BinaryMessenger)paramDartExecutor);
    h = h((BinaryMessenger)paramDartExecutor);
  }
  
  private static MethodChannel b(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_image_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$tXiCulfW3O3DCC_eCUPRWUeubvo.INSTANCE);
    return methodChannel;
  }
  
  private static MethodChannel c(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_common_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$Roj5PVS9HGCV38uEakj68H7l2tc.INSTANCE);
    return methodChannel;
  }
  
  private static MethodChannel d(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_emotion_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$TiEwl_ex8qV4GnUXH6W-5wvqfSA.INSTANCE);
    return methodChannel;
  }
  
  private static MethodChannel e(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_error_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$dWQJaVNqZuHGzQQ2Xq7nq7czFpk.INSTANCE);
    return methodChannel;
  }
  
  private static MethodChannel f(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_live_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$uwQ2S9GW0wEFLVqjiMXfebWVHeA.INSTANCE);
    return methodChannel;
  }
  
  private static MethodChannel g(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_user_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$M3O93DbKUthFgMXPkccWJkxADsE.INSTANCE);
    return methodChannel;
  }
  
  private static MethodChannel h(BinaryMessenger paramBinaryMessenger) {
    MethodChannel methodChannel = new MethodChannel(paramBinaryMessenger, "native_track_channel");
    methodChannel.setMethodCallHandler(-$$Lambda$FlutterManager$-V6ApGQm-svkc6Y-OzgsQTDm9fc.INSTANCE);
    return methodChannel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\flutter\FlutterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */