package com.soft.blued.http;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

public class FindHttpUtils {
  private static final String a = FindHttpUtils.class.getSimpleName();
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/tags");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    if (!NetworkUtils.c())
      return; 
    Map map1 = BluedHttpTools.a();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/blued/explore");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("?exclude_id=");
    stringBuilder2.append(paramString);
    paramString = stringBuilder2.toString();
    Map map2 = BluedHttpTools.a(true);
    if (AppInfo.m())
      try {
        String str1 = AppInfo.f().toJson(map2);
        Logger.c(a, new Object[] { "user-agent", str1 });
      } catch (Exception exception) {} 
    HttpManager.a(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(map2).a(map1).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/chatroom/nearby/num");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lot", BluedPreferences.s());
    map.put("lat", BluedPreferences.t());
    map.put("param", "text");
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/users/");
    stringBuilder1.append(UserInfo.a().i().getUid());
    stringBuilder1.append("/explore");
    String str = stringBuilder1.toString();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    arrayMap.put("page", stringBuilder2.toString());
    if (!StringUtils.e(paramString))
      arrayMap.put("exclude_id", paramString); 
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a((Map)arrayMap).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append("/notification/count");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append("/notification?http_method_override=DELETE");
    String str = stringBuilder.toString();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("filter", paramString1);
    arrayMap.put("max_id", paramString2);
    HttpManager.b(HttpUtils.a((Map<String, String>)arrayMap, str), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.n());
    stringBuilder2.append("/users/");
    stringBuilder2.append(UserInfo.a().i().getUid());
    stringBuilder2.append("/notification");
    String str = stringBuilder2.toString();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("filter", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append("");
    arrayMap.put("page", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    arrayMap.put("size", stringBuilder1.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a((Map)arrayMap).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append("/notification/count?filter=");
    stringBuilder.append(paramString);
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append("/notification/count");
    String str = stringBuilder.toString();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("filter", paramString1);
    arrayMap.put("max_id", paramString2);
    HttpManager.b(HttpUtils.a((Map<String, String>)arrayMap, str), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString) {
    if (!StringUtils.e(paramString)) {
      String str = paramString;
      if (paramString.contains("__CONN_TYPE__"))
        str = paramString.replace("__CONN_TYPE__", NetworkUtils.d()); 
      if (UserInfo.a().j()) {
        HttpManager.a(str, null).b(BluedHttpTools.a(true)).i();
        return;
      } 
      HttpManager.a(str, null).b(BluedHttpTools.a(false)).i();
    } 
  }
  
  public static void a(String[] paramArrayOfString) {
    if (paramArrayOfString != null && paramArrayOfString.length > 0)
      for (int i = 0; i < paramArrayOfString.length; i++)
        a(paramArrayOfString[i]);  
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/recommend");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/city_code");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("lot", paramString1);
    map.put("lat", paramString2);
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/call/state");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b("detail", "1").b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\FindHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */