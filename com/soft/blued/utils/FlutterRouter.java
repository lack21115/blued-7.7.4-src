package com.soft.blued.utils;

import android.content.Context;
import com.blued.android.framework.flutter.FlutterManager;
import com.blued.android.framework.flutter.FlutterRouteArgModel;
import com.blued.das.live.LiveProtos;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.log.trackUtils.EventTrackLive;

public class FlutterRouter {
  public static void a(Context paramContext) {
    EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_PAGE_SHOW);
    FlutterRouteArgModel flutterRouteArgModel = FlutterRouteArgModel.getDefault();
    flutterRouteArgModel.routeName = "recommend_anchor_page";
    FlutterManager.a(paramContext, flutterRouteArgModel);
  }
  
  public static void a(Context paramContext, int paramInt) {
    FlutterRouteArgModel flutterRouteArgModel = FlutterRouteArgModel.getDefault();
    flutterRouteArgModel.routeName = "emotion_page";
    flutterRouteArgModel.extra.put("local_emotions", EmotionManager.f());
    flutterRouteArgModel.extra.put("index", Integer.valueOf(paramInt));
    FlutterManager.a(paramContext, flutterRouteArgModel);
  }
  
  public static void a(Context paramContext, String paramString) {
    FlutterRouteArgModel flutterRouteArgModel = FlutterRouteArgModel.getDefault();
    flutterRouteArgModel.routeName = "emotion_detail";
    flutterRouteArgModel.extra.put("local_emotions", EmotionManager.f());
    flutterRouteArgModel.extra.put("emotion_code", paramString);
    FlutterManager.a(paramContext, flutterRouteArgModel);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    FlutterRouteArgModel flutterRouteArgModel = FlutterRouteArgModel.getDefault();
    flutterRouteArgModel.routeName = "super_exposure";
    flutterRouteArgModel.extra.put("feed_id", paramString1);
    flutterRouteArgModel.extra.put("detail", paramString2);
    FlutterManager.a(paramContext, flutterRouteArgModel);
  }
  
  public static void b(Context paramContext) {
    FlutterRouteArgModel flutterRouteArgModel = FlutterRouteArgModel.getDefault();
    flutterRouteArgModel.routeName = "recommend_grab_page";
    FlutterManager.a(paramContext, flutterRouteArgModel);
  }
  
  public static void c(Context paramContext) {
    FlutterRouteArgModel flutterRouteArgModel = FlutterRouteArgModel.getDefault();
    flutterRouteArgModel.routeName = "vip_level";
    FlutterManager.a(paramContext, flutterRouteArgModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\FlutterRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */