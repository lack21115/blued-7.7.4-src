package com.soft.blued.http;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;

public class LiveHttpUtils {
  public static void a(int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/live/two-floor");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(paramInt);
    map.put("from", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/blued/qiniu?=filter=token&action=idcard");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/viewers/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/stars?page=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/hb/status");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, int paramInt) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/live/nearby");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    map.put("latitude", BluedPreferences.t());
    map.put("longitude", BluedPreferences.s());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, int paramInt, String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/live/followed/recommend");
    String str = stringBuilder1.toString();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    arrayMap.put("page", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("");
    arrayMap.put("last", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a((Map)arrayMap).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/idcard");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          map.put("type", "hands"); 
      } else {
        map.put("type", "after");
      } 
    } else {
      map.put("type", "front");
    } 
    map.put("idcard", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/live_idcard");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (paramInt != 0) {
      if (paramInt == 1)
        map.put("type", "after"); 
    } else {
      map.put("type", "front");
    } 
    map.put("idcard", paramString2);
    if (!TextUtils.isEmpty(paramString3))
      map.put("from", paramString3); 
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/banner?topic=");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/cates/");
    stringBuilder.append(paramString1);
    stringBuilder.append("?page=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/followed/recommend/hate");
    String str = stringBuilder.toString();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("target", paramString);
    HttpManager.a(str).b(BluedHttpTools.a(true)).a((Map)arrayMap).i();
  }
  
  public static void a(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/anchor-fans/");
    stringBuilder.append(paramString);
    stringBuilder.append("/leave");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/live/recommend");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (!TextUtils.isEmpty(paramString1))
      map.put("last_lid", paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      map.put("ai_last_uid", paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      map.put("recommend_char", paramString3); 
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/live/anchor-fans/list");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/hb/status?type=index");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/idcard?http_method_override=DELETE");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          map.put("type", "hands"); 
      } else {
        map.put("type", "after");
      } 
    } else {
      map.put("type", "front");
    } 
    map.put("idcard", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/live_idcard?http_method_override=DELETE");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (paramInt != 0) {
      if (paramInt == 1)
        map.put("type", "after"); 
    } else {
      map.put("type", "front");
    } 
    map.put("idcard", paramString2);
    if (!TextUtils.isEmpty(paramString3))
      map.put("from", paramString3); 
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/onairlist?page=");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/cates/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/recommend?page=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/users/chatroom/");
    stringBuilder.append(paramString);
    stringBuilder.append("/user/invite");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/live/anchor-fans/recommend");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    a(1, paramBluedUIHttpResponse, paramIRequestHost);
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, IRequestHost paramIRequestHost) {
    a(paramBluedUIHttpResponse, paramString1, paramInt, paramString2, null, paramIRequestHost);
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    c(paramBluedUIHttpResponse, paramString, "", paramIRequestHost);
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/applied");
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("sign_contract", "1");
    if (!TextUtils.isEmpty(paramString2))
      map.put("from", paramString2); 
    HttpManager.a(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/cates");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, IRequestHost paramIRequestHost) {
    b(paramBluedUIHttpResponse, paramString1, paramInt, paramString2, null, paramIRequestHost);
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/recommend/banner");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\LiveHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */