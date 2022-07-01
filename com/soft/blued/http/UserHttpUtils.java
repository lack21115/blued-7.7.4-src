package com.soft.blued.http;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.chat.manager.SessionDataManager;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.msg.model.GiftVoucherModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class UserHttpUtils {
  public static int a = 1;
  
  public static boolean b = BluedPreferences.G();
  
  public static FilterEntity c;
  
  public static boolean d;
  
  public static void a(Context paramContext, BinaryHttpResponseHandler paramBinaryHttpResponseHandler, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/qrcode");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBinaryHttpResponseHandler, paramIRequestHost).b(BluedHttpTools.c(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    try {
      if (!StringUtils.e(paramString)) {
        String str = URLEncoder.encode(paramString);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BluedHttpUrl.n());
        stringBuilder.append("/users/name?name=");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&is_shadow=");
        stringBuilder.append(paramInt1);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&is_call=");
        stringBuilder.append(paramInt2);
        HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    a(paramContext, paramBluedUIHttpResponse, paramString, 0, 0, paramIRequestHost);
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("keywords", paramString1);
    map.put("page", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/search");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  private static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/followed/");
    stringBuilder.append(paramString2);
    paramString1 = stringBuilder.toString();
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString3)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append("?from=");
      stringBuilder1.append(paramString3);
      str = stringBuilder1.toString();
    } 
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/call");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString1);
    map.put("size", paramString2);
    if (!TextUtils.isEmpty(paramString3))
      map.put("rank_by", paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      map.put("role", paramString4); 
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/users/");
    stringBuilder1.append(paramString1);
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("?from=");
    stringBuilder2.append(paramString2);
    str = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("&is_living=");
    stringBuilder2.append(paramBoolean);
    str = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("&is_vip_page=");
    stringBuilder2.append(paramInt1);
    str = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("&is_shadow=");
    stringBuilder2.append(paramInt2);
    str = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("&is_call=");
    stringBuilder2.append(paramInt3);
    HttpManager.a(stringBuilder2.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, Map<String, String> paramMap, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(paramMap)).i();
  }
  
  public static void a(Context paramContext, UserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    b(paramContext, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(paramIRequestHost, paramString1, paramIAddOrRemoveAttentionDone) {
          protected void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
            List list = param1BluedEntityA.data;
            boolean bool = false;
            String str = ((UserInfoEntity)list.get(0)).relationship;
            if ("1".equals(str) || "3".equals(str))
              bool = true; 
            try {
              SessionDataManager.getInstance().updateFollower(Long.valueOf(this.a).longValue(), bool);
            } catch (Exception exception) {}
            this.b.b(str);
            ((UserInfoEntity)param1BluedEntityA.getSingleData()).uid = this.a;
            LiveEventBus.get("feed_relation_ship").post(param1BluedEntityA.getSingleData());
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.b.b();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.b.a();
          }
        }UserInfo.a().i().getUid(), paramString1, paramString2, paramIRequestHost);
  }
  
  public static void a(Context paramContext, String paramString, BinaryHttpResponseHandler paramBinaryHttpResponseHandler, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/qrcode/");
    stringBuilder.append(EncryptTool.b(paramString));
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBinaryHttpResponseHandler, paramIRequestHost).b(BluedHttpTools.c(true)).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/android/entrust");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("contract_code", paramString1);
    map.put("stage", "verify");
    map.put("type", paramString2);
    Gson gson = AppInfo.f();
    try {
      if (AppInfo.m()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get result parms:");
        stringBuilder1.append(gson.toJson(map));
        Logger.a("auto_charge", stringBuilder1.toString());
      } 
      String str1 = AesCrypto.b(gson.toJson(map));
      Map<String, String> map1 = BluedHttpTools.a();
      map1.put("_", str1);
      HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, String paramString1, double paramDouble, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, boolean paramBoolean, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.o());
    stringBuilder2.append("/pay/android/entrust");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramInt1);
    stringBuilder3.append("");
    map.put("id", stringBuilder3.toString());
    map.put("type", paramString1);
    map.put("money", String.valueOf(paramDouble));
    map.put("stage", "prepay");
    map.put("detail", paramString4);
    if (paramInt2 == 2) {
      paramString1 = "svip";
    } else {
      paramString1 = "vip";
    } 
    map.put("vip_type", paramString1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt3);
    stringBuilder1.append("");
    map.put("month", stringBuilder1.toString());
    if (!StringUtils.e(paramString2))
      map.put("target_uid", paramString2); 
    if (paramBoolean)
      map.put("is_change", "1"); 
    if (!StringUtils.e(paramString3))
      map.put("activity_id", paramString3); 
    Gson gson = AppInfo.f();
    try {
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get order parms:");
        stringBuilder.append(gson.toJson(map));
        Logger.a("auto_charge", stringBuilder.toString());
      } 
      String str1 = AesCrypto.b(gson.toJson(map));
      Map<String, String> map1 = BluedHttpTools.a();
      map1.put("_", str1);
      HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/eco/vote");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/config/new_gift?target_uid=");
    stringBuilder.append(EncryptTool.b(paramString));
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, GiftVoucherModel paramGiftVoucherModel, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/gift/free");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString1);
    map.put("gift_id", paramString2);
    map.put("detail", paramString3);
    if (paramGiftVoucherModel != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramGiftVoucherModel.coupons_id);
      stringBuilder1.append("");
      map.put("coupons_id", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramGiftVoucherModel.money);
      stringBuilder1.append("");
      map.put("coupons_money", stringBuilder1.toString());
    } 
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString3);
    map.put("size", paramString4);
    map.put("ttid", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/photowall");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IRequestHost paramIRequestHost, String paramString6, String paramString7, boolean paramBoolean, String paramString8, int paramInt, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13) {
    String str1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.o());
    stringBuilder2.append("/pay/beans");
    String str2 = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString1);
    map.put("id", paramString2);
    map.put("detail", paramString4);
    map.put("from", paramString5);
    map.put("pay_code", paramString6);
    map.put("pay_token", paramString7);
    map.put("tt_id", paramString3);
    map.put("trade_type", paramString8);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("beans", stringBuilder1.toString());
    map.put("aim", paramString9);
    map.put("promotion_type", paramString10);
    map.put("role", paramString11);
    map.put("age", paramString12);
    map.put("area", paramString13);
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    map.put("rememberMe", str1);
    HttpManager.b(str2, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.n());
    stringBuilder2.append("/blued/praise");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("type", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append("");
    map.put("is_praise", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    map.put("code", stringBuilder1.toString());
    HttpManager.a(str, null, null).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.n());
    stringBuilder2.append("/users/eco/vote");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("result", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString, IRequestHost paramIRequestHost, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append((UserInfo.a().i()).uid);
    stringBuilder.append("/secretly_followed/");
    stringBuilder.append(paramString);
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/gift/bag");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString1);
    map.put("bag_id", paramString4);
    map.put("detail", paramString2);
    map.put("from", paramString3);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/blacklist/");
    stringBuilder.append(paramString2);
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  private static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/followed/");
    stringBuilder.append(paramString2);
    stringBuilder.append("?http_method_override=DELETE");
    paramString1 = stringBuilder.toString();
    String str = paramString1;
    if (!StringUtils.e(paramString3)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append("&from=");
      stringBuilder1.append(paramString3);
      str = stringBuilder1.toString();
    } 
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(Context paramContext, UserRelationshipUtils.IAddOrRemoveAttentionDone paramIAddOrRemoveAttentionDone, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    a(paramContext, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(paramIRequestHost, paramString1, paramIAddOrRemoveAttentionDone) {
          boolean a = false;
          
          protected void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
            List list = param1BluedEntityA.data;
            boolean bool = false;
            String str = ((UserInfoEntity)list.get(0)).relationship;
            if ("1".equals(str) || "3".equals(str))
              bool = true; 
            try {
              SessionDataManager.getInstance().updateFollower(Long.valueOf(this.b).longValue(), bool);
            } catch (Exception exception) {}
            UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.c;
            if (iAddOrRemoveAttentionDone != null)
              iAddOrRemoveAttentionDone.a(str); 
            ((UserInfoEntity)param1BluedEntityA.getSingleData()).uid = this.b;
            LiveEventBus.get("feed_relation_ship").post(param1BluedEntityA.getSingleData());
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.c;
            if (iAddOrRemoveAttentionDone != null)
              if (this.a) {
                iAddOrRemoveAttentionDone.c();
              } else {
                iAddOrRemoveAttentionDone.b();
              }  
            this.a = false;
          }
          
          public void onUIStart() {
            super.onUIStart();
            UserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = this.c;
            if (iAddOrRemoveAttentionDone != null)
              iAddOrRemoveAttentionDone.a(); 
          }
        }UserInfo.a().i().getUid(), paramString1, paramString2, paramIRequestHost);
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/gift/bag");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/gift");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/gift/reduce_stock");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_uid", paramString1);
    map.put("gift_id", paramString2);
    map.put("detail", paramString3);
    map.put("from", paramString4);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/blacklist/");
    stringBuilder.append(paramString2);
    stringBuilder.append("?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/photos/background?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/theme");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("type", paramString);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/messages/unread");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/photos/dilatation?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static interface MARKET_GUIDE_TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\UserHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */