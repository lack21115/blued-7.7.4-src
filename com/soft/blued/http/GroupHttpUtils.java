package com.soft.blued.http;

import android.content.Context;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

public class GroupHttpUtils {
  private static final String a = GroupHttpUtils.class.getSimpleName();
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=groups&gid=");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("filter", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/information");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("keywords", paramString1);
    map.put("sort", paramString2);
    map.put("page", paramString3);
    map.put("size", paramString4);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/search");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    if (!StringUtils.e(paramString2))
      map.put("name", paramString1); 
    map.put("description", paramString2);
    map.put("city", paramString3);
    map.put("longitude", paramString4);
    map.put("latitude", paramString5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, String[] paramArrayOfString, IRequestHost paramIRequestHost) {
    Map<String, String[]> map = BluedHttpTools.c();
    map.put("target_id", paramArrayOfString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString);
    stringBuilder.append("/members?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, Object paramObject, IRequestHost paramIRequestHost) {
    Map<String, Object> map = BluedHttpTools.b();
    map.put("groups", paramObject);
    paramObject = new StringBuilder();
    paramObject.append(BluedHttpUrl.n());
    paramObject.append("/groups/users/");
    paramObject.append(paramString);
    paramObject.append("/setting?http_method_override=PUT");
    HttpManager.b(paramObject.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, boolean paramBoolean, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString2);
    if (paramBoolean) {
      paramString2 = "1";
    } else {
      paramString2 = "0";
    } 
    map.put("nodisturb", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/chat?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, String[] paramArrayOfString, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString);
    stringBuilder.append("/members");
    paramString = stringBuilder.toString();
    if (paramBoolean) {
      Map<String, String[]> map1 = BluedHttpTools.c();
      map1.put("target_id", paramArrayOfString);
      if (paramArrayOfString != null && paramArrayOfString.length > 0) {
        int i;
        for (i = 0; i < paramArrayOfString.length; i++) {
          Logger.b(a, new Object[] { "inGroupForInvite  group   target_id", Integer.valueOf(i), ":", paramArrayOfString[i] });
        } 
      } 
      HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
      return;
    } 
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_id", paramArrayOfString[0]);
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString);
    stringBuilder.append("/me");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("message", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/members");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("keywords", paramString2);
    map.put("filter", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/members/search");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    if (!StringUtils.e(paramString2))
      map.put("name", paramString2); 
    if (!StringUtils.e(paramString3))
      map.put("description", paramString3); 
    if (!StringUtils.e(paramString4))
      map.put("city", paramString4); 
    if (!StringUtils.e(paramString5))
      map.put("type", paramString5); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    stringBuilder.append("?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    if (!StringUtils.e(paramString))
      map.put("name", paramString); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/check");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/information/");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("members", paramString2);
    map.put("is_vip", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/members/upgrade");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void c(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("sort", paramString2);
    map.put("page", paramString3);
    map.put("size", paramString4);
    map.put("filter", paramString5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/members");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void d(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    if (!StringUtils.e(paramString))
      map.put("description", paramString); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/check");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("iid", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/information");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("iid", paramString2);
    map.put("filter", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/information");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void d(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("filter", paramString1);
    map.put("page", paramString2);
    map.put("size", paramString3);
    map.put("location", paramString4);
    map.put("type", paramString5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void e(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString);
    stringBuilder.append("/members?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void e(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("filter", "location");
    map.put("page", paramString1);
    map.put("size", paramString2);
    map.put("location", "");
    map.put("type", "");
    map.put("sort", "distance");
    map.put("longitude", BluedPreferences.s());
    map.put("latitude", BluedPreferences.t());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void f(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString);
    stringBuilder.append("?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void f(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("reason", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/objectionable/groups/");
    stringBuilder.append(paramString1);
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void g(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void g(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_id", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/admins");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void h(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString);
    stringBuilder.append("/admins");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void h(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("target_id", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/admins?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void i(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("filter", paramString);
    map.put("return", "force");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/classify");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void i(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/information/");
    stringBuilder.append(paramString2);
    stringBuilder.append("?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void j(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/information/clean");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void j(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("avatar", paramString1);
    map.put("gid", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/attachments");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void k(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/verify");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\GroupHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */