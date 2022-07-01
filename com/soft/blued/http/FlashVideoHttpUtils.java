package com.soft.blued.http;

import android.content.Context;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class FlashVideoHttpUtils {
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map<String, String> map = BluedHttpTools.b();
    map.put("video", paramString);
    if (LiveDataManager.a().g() == 1)
      map.put("from", "1"); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append("/verify");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/catch");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("size", stringBuilder2.toString());
    if (!StringUtils.e(paramString))
      map.put("from", paramString); 
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/users/");
    stringBuilder1.append(paramString1);
    stringBuilder1.append("/timeline/catch");
    paramString1 = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("size", stringBuilder2.toString());
    map.put("feed_id", paramString2);
    HttpManager.a(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/catch/music");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, int paramInt1, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/catch/music/");
    stringBuilder1.append(paramInt1);
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt3);
    stringBuilder2.append("");
    map.put("size", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    String str = paramString;
    try {
      if (StringUtils.e(paramString))
        str = "------------------"; 
      map.put("q", URLEncoder.encode(str, "UTF-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/catch/music/search");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\FlashVideoHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */