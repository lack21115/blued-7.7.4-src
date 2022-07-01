package com.blued.android.module.yy_china.utils;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPayRemaining;
import com.blued.android.module.yy_china.model.YYReportMsg;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YYRoomHttpUtils {
  public static void a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().f());
    stringBuilder.append("/sums/android");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<YYPayRemaining>>(null) {
          protected void a(BluedEntityA<YYPayRemaining> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              LiveDataManager.a().b(((YYPayRemaining)param1BluedEntityA.getSingleData()).beans);
              if (((YYPayRemaining)param1BluedEntityA.getSingleData()).text != null) {
                ((YYPayRemaining)param1BluedEntityA.getSingleData()).text.sums = "充值";
                ((YYPayRemaining)param1BluedEntityA.getSingleData()).text.goods = "充值";
              } 
              ((YYPayRemaining)param1BluedEntityA.getSingleData()).bonus = 0L;
              LiveEventBus.get("gold_remain_result").post(param1BluedEntityA.getSingleData());
            } 
          }
        },  null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(int paramInt, String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(YYRoomInfoManager.d().c().e());
    stringBuilder1.append("/users/chatroom/");
    stringBuilder1.append(paramString);
    stringBuilder1.append("/apply/confirm");
    paramString = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("result", stringBuilder2.toString());
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/gettype");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/users/chatroom/anchor");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append("");
    map.put("page", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    map.put("size", stringBuilder1.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(YYRoomInfoManager.d().c().e());
    stringBuilder1.append("/users/chatroom/");
    stringBuilder1.append(paramString);
    stringBuilder1.append("/cproom/step");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("step_id", stringBuilder2.toString());
    map.put("room_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/applied");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/user?uid=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/mics/stream_report");
    paramString = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(paramString, (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<Object>>(null) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {}
        },  null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
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
    map.put("from", "1");
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(YYRoomInfoManager.d().c().e());
    stringBuilder1.append("/users/chatroom/");
    stringBuilder1.append(paramString);
    stringBuilder1.append("/mics/lock");
    paramString = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("status", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("mic_position", stringBuilder2.toString());
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, List<String> paramList, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(YYRoomInfoManager.d().c().e());
    stringBuilder1.append("/users/chatroom/");
    stringBuilder1.append(paramString);
    stringBuilder1.append("/vote/create");
    paramString = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.b();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("vote_type", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("ageing", stringBuilder2.toString());
    map.put("uids", paramList);
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/live/music/search");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("keyword", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("page", stringBuilder1.toString());
    map.put("from", "1");
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/room_list?type_id=");
    stringBuilder.append(paramString);
    stringBuilder.append("&page=");
    stringBuilder.append(paramInt);
    stringBuilder.append("&page_size=30");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/members");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    String str1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/users/chatroom/");
    stringBuilder2.append(paramString3);
    stringBuilder2.append("/gift/send");
    String str2 = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("hit_id", paramString1);
    map.put("goods_id", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append("");
    map.put("count", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    map.put("hit_batch", stringBuilder1.toString());
    map.put("platform", "android");
    map.put("room_id", paramString3);
    map.put("target_uid", paramString4);
    map.put("beans", paramString5);
    map.put("pay_code", paramString6);
    map.put("pay_token", paramString7);
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    map.put("rememberMe", str1);
    HttpManager.b(str2, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/users/chatroom/");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("/invite");
    paramString1 = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("mic_position", stringBuilder1.toString());
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/create");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("type_id", paramString1);
    map.put("room_name", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/applied/chatroom");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("apply", "1");
    map.put("card_name", paramString2);
    map.put("card_number", paramString3);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/update");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("room_name", paramString2);
    map.put("room_desc", paramString3);
    map.put("type_id", paramString4);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/blued/newreport/chat-room/user");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("room_id", paramString1);
    map.put("uid", paramString3);
    map.put("reason", paramString4);
    map.put("anchor", paramString2);
    map.put("members", Arrays.toString(paramList.toArray((Object[])new String[paramList.size()])));
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList, List<YYReportMsg> paramList1, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/blued/newreport/chat-room/msg");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("room_id", paramString1);
    map.put("anchor", paramString2);
    map.put("reason", paramString4);
    if (!TextUtils.isEmpty(paramString3))
      map.put("uid", paramString3); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.putAll(map);
    hashMap.put("members", paramList);
    hashMap.put("msg", paramList1);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, List<String> paramList, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/blued/newreport/chat-room/room");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("room_id", paramString1);
    map.put("anchor", paramString2);
    map.put("reason", paramString3);
    map.put("members", Arrays.toString(paramList.toArray((Object[])new String[paramList.size()])));
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/blued/qiniu?filter=token&action=zip");
    return stringBuilder.toString();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/banner");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/anchor/list");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/kickout");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/members_all?page=");
    stringBuilder.append(paramInt);
    stringBuilder.append("&page_size=20");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/into_room");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("room_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/users/chatroom/");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("/mics/status");
    paramString1 = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("status", stringBuilder1.toString());
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/mics/leave");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/users/mute");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString2);
    map.put("status", paramString3);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/blued/zip");
    return stringBuilder.toString();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().f());
    stringBuilder.append("/pay/goods");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/cproom/list");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("room_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/cproom/choose");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("room_id", paramString1);
    map.put("target_uid", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(YYRoomInfoManager.d().c().e());
    stringBuilder1.append("/users/chatroom/");
    stringBuilder1.append(paramString);
    stringBuilder1.append("/apply");
    paramString = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("mic_position", stringBuilder2.toString());
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/close");
    paramString = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/users/chatroom/");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("/apply/handle");
    paramString1 = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("result", stringBuilder1.toString());
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/users/follow");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/vote/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/");
    stringBuilder.append(paramString3);
    paramString1 = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/live/music/sheet/list");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("from", "1");
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void d(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/apply?page=");
    stringBuilder.append(paramInt);
    stringBuilder.append("&page_size=20");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/leave");
    paramString = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/users/chatroom/");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("/manager");
    paramString1 = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("status", stringBuilder1.toString());
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/emoji/");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void e(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(YYRoomInfoManager.d().c().e());
    stringBuilder1.append("/users/chatroom/");
    stringBuilder1.append(paramString);
    stringBuilder1.append("/invited/handle");
    paramString = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("result", stringBuilder2.toString());
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void e(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/end/info");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void e(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/effects/");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void f(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/gift/send_rank?page=");
    stringBuilder.append(paramInt);
    stringBuilder.append("&page_size=20");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void f(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/users/status");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void f(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/vote/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/status");
    paramString1 = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.a(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void g(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/gift/receive_rank?page=");
    stringBuilder.append(paramInt);
    stringBuilder.append("&page_size=20");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void g(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/desc");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void g(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/vote/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/close");
    paramString1 = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void h(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/end/members?page=");
    stringBuilder.append(paramInt);
    stringBuilder.append("&page_size=20");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void h(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/mics/confirm");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void i(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(YYRoomInfoManager.d().c().e());
    stringBuilder2.append("/live/music/collect?from=1");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("music_id", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("status", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void i(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/emoji");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void j(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/effects");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void k(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/live/music/song/item");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("music_id", paramString);
    map.put("from", "1");
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void l(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(YYRoomInfoManager.d().c().e());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/subinfo");
    paramString = stringBuilder.toString();
    Map map = BluedHttpTools.a();
    HttpManager.a(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\YYRoomHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */