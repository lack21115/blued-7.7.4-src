package com.soft.blued.http;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.ui.msg_group.model.ReportJsonModel;
import com.soft.blued.utils.Logger;
import java.util.Map;

public class MsgGroupHttpUtils {
  public static void a(IRequestHost paramIRequestHost, int paramInt1, int paramInt2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("page", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("size", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/mine");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, ReportJsonModel paramReportJsonModel, BluedUIHttpResponse paramBluedUIHttpResponse) {
    String str;
    if (paramReportJsonModel == null) {
      str = "";
    } else {
      str = AppInfo.f().toJson(str);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ajaxParams : ");
    stringBuilder.append(str);
    Logger.c("reportChat", new Object[] { stringBuilder.toString() });
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/newreport/chat-group/user");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(str).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("group_id", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/info");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString1, String paramString2, int paramInt1, int paramInt2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("group_id", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("page", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("size", stringBuilder.toString());
    map.put("desc_type", paramString2);
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/members");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString1, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("group_id", paramString1);
    map.put("uid", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("group_role", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/members");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("group_id", paramString1);
    map.put("keywords", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/members/search");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, BluedUIHttpResponse paramBluedUIHttpResponse, Map<String, String>... paramVarArgs) {
    Map<String, String> map = BluedHttpTools.a();
    if (paramVarArgs != null && paramVarArgs.length > 0)
      for (Map.Entry<String, String> entry : paramVarArgs[0].entrySet())
        map.put(entry.getKey(), entry.getValue());  
    map.put("group_id", paramString1);
    if (!TextUtils.isEmpty(paramString2))
      map.put("group_cover", paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      map.put("group_title", paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      map.put("group_desc", paramString4); 
    if (paramInt1 != -1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt1);
      stringBuilder1.append("");
      map.put("group_status", stringBuilder1.toString());
    } 
    if (paramInt2 != -1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt2);
      stringBuilder1.append("");
      map.put("allow_join", stringBuilder1.toString());
    } 
    if (paramInt3 != -1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt3);
      stringBuilder1.append("");
      map.put("message_is_mute", stringBuilder1.toString());
    } 
    if (paramInt4 != -1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt4);
      stringBuilder1.append("");
      map.put("at_message_is_mute", stringBuilder1.toString());
    } 
    if (paramInt5 != -1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt5);
      stringBuilder1.append("");
      map.put("notice_is_mute", stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/info");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString, Map<String, String> paramMap, BluedUIHttpResponse paramBluedUIHttpResponse) {
    a(paramIRequestHost, paramString, null, null, null, -1, -1, -1, -1, -1, paramBluedUIHttpResponse, (Map<String, String>[])new Map[] { paramMap });
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/config");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(IRequestHost paramIRequestHost, int paramInt1, int paramInt2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("page", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("size", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/notice");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(IRequestHost paramIRequestHost, String paramString, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("group_id", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/members?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(IRequestHost paramIRequestHost, String paramString1, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("group_id", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("allow_join", stringBuilder.toString());
    if (!TextUtils.isEmpty(paramString2))
      map.put("reason", paramString2); 
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/members?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(IRequestHost paramIRequestHost, int paramInt1, int paramInt2, BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("id", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("result", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/notice");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\MsgGroupHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */