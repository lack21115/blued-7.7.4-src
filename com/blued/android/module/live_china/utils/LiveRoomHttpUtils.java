package com.blued.android.module.live_china.utils;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.FirstChargeGift;
import com.blued.android.module.live_china.model.LiveFirstChargeInfo;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Map;

public class LiveRoomHttpUtils {
  public static void a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/goods/hongbao/cancel");
    HttpManager.b(stringBuilder.toString()).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/anchor-fans/fans-list/active");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/interaction/matchmaking/apply/list");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    map.put("lid", paramString1);
    map.put("type", paramString2);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(long paramLong, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/task/new-anchor/use-card");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    map.put("lid", stringBuilder2.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(long paramLong, String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/task/new-anchor/take-reward");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    map.put("lid", stringBuilder2.toString());
    map.put("task_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/end-recommend");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("last", paramString);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, long paramLong, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/activity/buildbox/open?box_id=");
    stringBuilder.append(paramString);
    stringBuilder.append("&live_id=");
    stringBuilder.append(paramLong);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, Long paramLong, Short paramShort, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("session_id", String.valueOf(paramLong));
    map.put("session_type", String.valueOf(paramShort));
    if (!TextUtils.isEmpty(paramString2)) {
      map.put("name", paramString2);
      paramString1 = "0";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/card");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/stars/");
    stringBuilder.append(paramString);
    stringBuilder.append("/consumes/");
    stringBuilder.append(paramLong);
    stringBuilder.append("?page=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, String paramString1, long paramLong, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/stars/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/consumes?page=");
    stringBuilder.append(paramInt);
    stringBuilder.append("&lid=");
    stringBuilder.append(paramLong);
    stringBuilder.append("&type=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/daily-task");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    if (paramInt == 1) {
      str = "/live/stars/hot";
    } else {
      str = "/live/stars/rise";
    } 
    stringBuilder.append(str);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/interaction/matchmaking/user-album-pic/list");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(paramInt);
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    map.put("lid", paramString1);
    map.put("activity_id", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/active/rank/list");
    HttpManager.a(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, long paramLong) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/applicants?lid=");
    stringBuilder.append(paramLong);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, long paramLong, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/join");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", String.valueOf(paramLong));
    map.put("type", String.valueOf(paramInt));
    map.put("source", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/goods-mall/setting/status");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/members?lid=");
    stringBuilder.append(paramString1);
    stringBuilder.append("&type=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString1, boolean paramBoolean1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/start");
    String str2 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString1);
    String str1 = "0";
    if (paramBoolean1) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    } 
    map.put("show_in_nearby", paramString1);
    map.put("description", paramString2);
    paramString1 = str1;
    if (paramBoolean2)
      paramString1 = "1"; 
    map.put("is_matchmaking", paramString1);
    map.put("live_type", String.valueOf(paramInt1));
    map.put("screen_pattern", String.valueOf(paramInt2));
    map.put("zego_stream", "1");
    HttpManager.b(str2, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, LiveMsgReportModel paramLiveMsgReportModel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/blued/newreport/live_comment/");
    stringBuilder.append(paramLiveMsgReportModel.lid);
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("reason", "0");
    map.put("contents", paramLiveMsgReportModel.reportContent);
    map.put("comment", paramLiveMsgReportModel.reportMsg);
    map.put("publish_date", paramLiveMsgReportModel.time);
    map.put("report_uid", paramLiveMsgReportModel.uid);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, LiveRewardConfigModel paramLiveRewardConfigModel, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, String paramString5, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(LiveRoomInfo.a().m());
    stringBuilder2.append("/buy/goods/hongbao");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("beans", String.valueOf(paramLiveRewardConfigModel.beans));
    map.put("count", String.valueOf(paramLiveRewardConfigModel.count));
    map.put("size", paramLiveRewardConfigModel.size);
    map.put("condition", paramLiveRewardConfigModel.condition);
    map.put("uid", paramString2);
    map.put("live_id", paramString1);
    map.put("platform", "android");
    map.put("id", String.valueOf(paramLiveRewardConfigModel.hb_beans_id));
    map.put("pay_code", paramString3);
    map.put("pay_token", paramString4);
    paramString2 = "1";
    if (paramBoolean1) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    } 
    map.put("remember_me", paramString1);
    if (paramBoolean2) {
      paramString1 = paramString2;
    } else {
      paramString1 = "0";
    } 
    map.put("is_mall_packet", paramString1);
    if (!TextUtils.isEmpty(paramString5))
      map.put("pwd", paramString5); 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLiveRewardConfigModel.prize_total);
    stringBuilder1.append("");
    map.put("prize_total", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/room/close");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, float paramFloat1, float paramFloat2, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(LiveRoomInfo.a().k());
    stringBuilder2.append("/live/sticker");
    String str = stringBuilder2.toString();
    map.put("lid", paramString1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFloat1);
    stringBuilder1.append("");
    map.put("proportion_x", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFloat2);
    stringBuilder1.append("");
    map.put("proportion_y", stringBuilder1.toString());
    map.put("image", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/stars/battle");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    map.put("week", String.valueOf(paramInt));
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/onair/");
    stringBuilder.append(paramString);
    stringBuilder.append("/share");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, IRequestHost paramIRequestHost, int paramInt1, String paramString2, String paramString3, int paramInt2) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/users/");
    stringBuilder1.append(paramString1);
    stringBuilder1.append("/applied");
    paramString1 = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("apply", "1");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("is_hand_write", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("is_easy_way", stringBuilder2.toString());
    map.put("card_name", paramString2);
    map.put("card_number", paramString3);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/daily-task");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString1);
    map.put("task_id", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/activity/buildbox/conf?target_uid=");
    stringBuilder.append(paramString1);
    stringBuilder.append("&box_id=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/goods/hongbao/open");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("hongbao_id", paramString1);
    map.put("live_id", paramString2);
    map.put("rid", paramString3);
    if (!TextUtils.isEmpty(paramString4))
      map.put("pwd", paramString4); 
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/lives/");
    stringBuilder.append(paramString);
    stringBuilder.append("/share");
    HttpManager.a(stringBuilder.toString(), null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/kiss");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    map.put("action", String.valueOf(paramInt));
    HttpManager.b(str).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(LiveRoomInfo.a().k());
    stringBuilder2.append("/live/music/song/list");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("sheet_id", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append("");
    map.put("is_personal", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    map.put("page", stringBuilder1.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(LiveRoomInfo.a().m());
    stringBuilder2.append("/goods/equip");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("goods_id", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("equip_status", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, long paramLong, String paramString2, String paramString3, boolean paramBoolean, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    String str;
    Map<String, String> map;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(LiveRoomInfo.a().m());
      stringBuilder.append("/buy/liang/renew");
      str = stringBuilder.toString();
      map = BluedHttpTools.a();
      map.put("liang_id", paramString1);
      map.put("pay_code", paramString2);
      if (TextUtils.isEmpty(paramString2))
        map.put("pay_token", paramString3); 
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
    if (paramBoolean) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    } 
    map.put("remember_me", paramString1);
    map.put("expire_time", String.valueOf(paramLong));
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/user/exit");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/share-copywriting");
    String str = stringBuilder.toString();
    map.put("uid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString1, String paramString2) {
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.b(LiveProtos.Event.LIVE_LEAVE_SUCCESS, LiveRoomManager.a().c(), LiveRoomManager.a().e(), (LiveRoomManager.a().h()).liveFrom, (LiveRoomManager.a().h()).recommendType, (LiveRoomManager.a().h()).livePosition); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/leave");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString1);
    map.put("type", "1");
    map.put("source", paramString2);
    HttpManager.b(str).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/kick-out");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString1);
    map.put("type", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/anchor-fans/relation/detail");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("anchor", paramString1);
    map.put("lid", paramString2);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString1, String paramString2, LiveGiftModel paramLiveGiftModel, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(LiveRoomInfo.a().m());
      stringBuilder2.append("/buy/goods");
      String str = stringBuilder2.toString();
      Map<String, String> map = BluedHttpTools.a();
      map.put("target_uid", paramString1);
      map.put("live_id", paramString2);
      map.put("goods_id", paramLiveGiftModel.goods_id);
      map.put("discount_id", paramString3);
      map.put("pay_code", paramString4);
      map.put("pay_token", paramString5);
      if (paramBoolean) {
        paramString1 = "1";
      } else {
        paramString1 = "0";
      } 
      map.put("remember_me", paramString1);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("");
      map.put("count", stringBuilder1.toString());
      map.put("contents", paramLiveGiftModel.contents);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLiveGiftModel.hit_id);
      stringBuilder1.append("");
      map.put("hit_id", stringBuilder1.toString());
      if (paramLiveGiftModel.effectModel != null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramLiveGiftModel.effectModel.effect_id);
        stringBuilder1.append("");
        map.put("effect_id", stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramLiveGiftModel.effectModel.expire);
        stringBuilder1.append("");
        map.put("effect_expire", stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramLiveGiftModel.effectModel.beans);
        stringBuilder1.append("");
        map.put("effect_beans", stringBuilder1.toString());
      } 
      HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/chatroom/operate/mute");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString1);
    map.put("uid", paramString2);
    map.put("type", paramString3);
    HttpManager.b(str).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    String str;
    Map<String, String> map;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(LiveRoomInfo.a().m());
      stringBuilder.append("/buy/liang");
      str = stringBuilder.toString();
      map = BluedHttpTools.a();
      map.put("liang_id", paramString1);
      map.put("pay_code", paramString2);
      if (TextUtils.isEmpty(paramString2))
        map.put("pay_token", paramString3); 
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
    if (paramBoolean) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    } 
    map.put("remember_me", paramString1);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, boolean paramBoolean, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/medal");
    String str2 = stringBuilder.toString();
    paramString = str2;
    if (paramBoolean) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append("?is_live=1");
      str1 = stringBuilder1.toString();
    } 
    HttpManager.a(str1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/sums/android");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(null) {
          protected void a(BluedEntityA<PayRemaining> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              LiveRoomInfo.a().a(((PayRemaining)param1BluedEntityA.getSingleData()).beans);
              LiveDataManager.a().b(((PayRemaining)param1BluedEntityA.getSingleData()).beans);
              LiveEventBus.get("gold_remain_result").post(param1BluedEntityA.getSingleData());
            } 
          }
        },  null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/anchor-fans/fans-list/join-today");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/home");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("cursor", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/pk/friends");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/interaction/matchmaking/user-feed-pic/list");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(paramInt);
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, long paramLong) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/sync/chat");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    map.put("lid", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/chatroom/admin/list");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/chatroom/admin/add");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString1);
    map.put("target_uid", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/stars/battle/");
    stringBuilder.append(paramString);
    stringBuilder.append("/consumes");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(LiveRoomInfo.a().k());
    stringBuilder2.append("/live/interaction/multi/status");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("voice", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/applied");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/fan/exit");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (!TextUtils.isEmpty(paramString1)) {
      map.put("lid", paramString1);
    } else {
      map.put("uid", paramString2);
    } 
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    if (!TextUtils.isEmpty(paramString2)) {
      map.put("name", paramString2);
      paramString1 = "0";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/card");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/goods/hongbao/record");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("hongbao_id", paramString1);
    map.put("live_id", paramString2);
    map.put("page", paramString3);
    map.put("last_record_id", paramString4);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(LiveRoomInfo.a().k());
    stringBuilder2.append("/live/music/search");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("keyword", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("page", stringBuilder1.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/user/lighting-off");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(LiveRoomInfo.a().k());
      stringBuilder.append("/blued/live/feedback");
      String str = stringBuilder.toString();
      Map<String, String> map = BluedHttpTools.a();
      map.put("contents", paramString);
      HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
  }
  
  public static void b(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/user-pic/use");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("pic", paramString1);
    map.put("lid", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/anchor-fans/item");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("anchor", paramString1);
    map.put("lid", paramString2);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void c() {
    h(new BluedUIHttpResponse<BluedEntityA<FirstChargeGift>>(null) {
          protected void a(BluedEntityA<FirstChargeGift> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null)
              LiveRoomManager.a().a((FirstChargeGift)param1BluedEntityA.getSingleData()); 
          }
        },  (IRequestHost)null);
  }
  
  public static void c(int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/anchor-fans/fans-list/all");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/pk/invitation/cancel");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/interaction/pk/status");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("disabled", stringBuilder2.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/access");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/chatroom/admin/remove");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString1);
    map.put("target_uid", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/pk/invitation");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/applied?http_method_override=PUT");
    paramString = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("is_video_verified", "1");
    if (LiveDataManager.a().g() == 1)
      map.put("from", "1"); 
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/onair/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/report");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("reason", "0");
    map.put("contents", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(LiveRoomInfo.a().k());
    stringBuilder2.append("/live/music/collect");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("music_id", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("status", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/level/sticker");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("sticker_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    a(paramString, false, paramBluedUIHttpResponse, paramIRequestHost);
  }
  
  public static void c(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/apply/resolve");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString1);
    map.put("uid", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/charge/info");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<LiveFirstChargeInfo>>(null) {
          protected void a(BluedEntityA<LiveFirstChargeInfo> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              LiveRoomPreferences.k(((LiveFirstChargeInfo)param1BluedEntityA.getSingleData()).count);
              LiveEventBusUtil.a(((LiveFirstChargeInfo)param1BluedEntityA.getSingleData()).count);
              if (((LiveFirstChargeInfo)param1BluedEntityA.getSingleData()).count == 0)
                LiveRoomHttpUtils.c(); 
            } 
          }
        },  null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/pk/interrupt");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("type", "0");
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("cursor", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/ligature/friends");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/anchor-fans/join-ticket");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/pk/invitation/ignore");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/ligature/invitation");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    map.put("type", String.valueOf(paramInt));
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/success");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("chosen_uid", paramString1);
    map.put("chooser_uid", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/music/song/item");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("music_id", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void d(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/anchor-fans");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("name", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/apply/reject");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString1);
    map.put("uid", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/home/letters");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(LiveRoomInfo.a().k());
    stringBuilder1.append("/live/interaction/ligature/status");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("disabled", stringBuilder2.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/daily-task/login-status");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/pk/invitation/confirm");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void e(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/kiss");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void e(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/goods/anchor-fans/free-goods");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("anchor", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void e(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/apply");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString1);
    map.put("type", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void f(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void f(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/task/new-anchor/is-token");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void f(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/apply");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void f(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/task/new-anchor/take-reward");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", "0");
    map.put("task_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void g(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/exit");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void g(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/task/new-anchor/queue-count");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void g(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/apply/cancel");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void g(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/task/new-anchor/task-list");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void h(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/goods/all");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void h(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/charge/first/config");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void h(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/apply/ignore");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void i(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().m());
    stringBuilder.append("/hongbao/config/android");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void i(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/invitation");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void j(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/whole/pk/match");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void j(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/invitation/confirm");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void k(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/whole/pk/match/cancel");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void k(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/multi/invitation/ignore");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void l(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/ligature/invitation/cancel");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void l(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/chatroom");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("title", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void m(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/ligature/interrupt");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void m(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/ligature/invitation/ignore");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void n(BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/gift_bag");
    String str = stringBuilder.toString();
    map.put("field", "is_shelves,buy_state,remain,daily_total,daily_sold,background_pic,picture,url");
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void n(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/ligature/invitation/confirm");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void o(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/callback/share");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void o(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/sticker/delete");
    String str = stringBuilder.toString();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void p(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/reset");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void p(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/rich");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void q(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/music/sheet/list");
    String str = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void q(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/level/info");
    String str = stringBuilder.toString();
    map.put("lid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void r(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/liang");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void r(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/level/sticker");
    String str = stringBuilder.toString();
    map.put("lid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void s(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/level/gesture");
    String str = stringBuilder.toString();
    map.put("lid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void t(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/user/in");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void u(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/apply/cancel");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void v(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/interaction/matchmaking/user/reject-in");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\LiveRoomHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */