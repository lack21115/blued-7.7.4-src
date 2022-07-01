package com.soft.blued.http;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.user.UserInfo;
import java.util.Date;
import java.util.Map;

public class HelloHttpUtils {
  private static long a;
  
  public static void a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/call");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", (UserInfo.a().i()).uid);
    HttpManager.b(str, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, boolean paramBoolean) {
    String str1;
    long l = (new Date()).getTime();
    if (l - a < 1000L)
      return; 
    a = l;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/call/open");
    String str2 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    map.put("is_quietly", str1);
    HttpManager.b(str2, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\HelloHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */