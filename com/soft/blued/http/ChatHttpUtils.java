package com.soft.blued.http;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.chat.http.IModuleChatHttp;
import com.soft.blued.constant.QiniuConstant;
import com.soft.blued.user.UserInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatHttpUtils implements IModuleChatHttp {
  public static String a(ChattingModel paramChattingModel) {
    short s = paramChattingModel.msgType;
    String str4 = "videos";
    String str3 = "0";
    String str2 = str3;
    if (s != 2) {
      String str;
      if (s != 3) {
        str = str4;
        str2 = str3;
        if (s != 5)
          if (s != 24) {
            if (s != 25) {
              str = "";
              str2 = str;
            } else {
              str2 = "1";
              str = str4;
            } 
          } else {
            str2 = "1";
            str = "images";
          }  
      } else {
        str = "voice";
        str2 = str3;
      } 
      return String.format(QiniuConstant.a(), new Object[] { str, str2 });
    } 
    String str1 = "images";
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("name", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/emotions");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    String str;
    Map<String, Integer> map = BluedHttpTools.b();
    map.put("reason", Integer.valueOf(paramInt));
    map.put("room_id", paramString2);
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("stream", paramString3);
      str = jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      str = "";
    } 
    map.put("attachments", str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/report/sparkchat/");
    stringBuilder.append(paramString1);
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/basic");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String[] paramArrayOfString, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2, IRequestHost paramIRequestHost) {
    String str1;
    Map<String, String> map2 = BluedHttpTools.b();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map2.put("reason", stringBuilder.toString());
    map2.put("contents", paramString1);
    map2.put("lid", Long.valueOf(paramLong));
    if (paramArrayOfString != null && paramArrayOfString.length > 0)
      map2.put("attachments", (String)paramArrayOfString); 
    String str2 = "user";
    paramString1 = str2;
    switch (paramInt1) {
      default:
        paramString1 = str2;
        break;
      case 11:
        map2.put("img", paramString2);
        if (!TextUtils.isEmpty(paramString3) && paramString3.contains(",")) {
          String[] arrayOfString = paramString3.split(",");
          if (arrayOfString.length == 2) {
            map2.put("pid", arrayOfString[0]);
            map2.put("uid", arrayOfString[1]);
          } 
        } 
        paramString1 = "private-album";
        break;
      case 6:
        paramString1 = "chat";
        break;
      case 5:
      case 10:
        paramString1 = "feed_comment";
        break;
      case 4:
        paramString1 = "group";
        break;
      case 2:
      case 9:
        paramString1 = "feed";
        break;
      case 1:
        break;
    } 
    try {
      map2.put("version_name", (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName);
    } catch (Exception exception) {}
    if (paramInt1 != 5 && paramInt1 != 10) {
      if (paramInt1 != 11) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(BluedHttpUrl.n());
        stringBuilder1.append("/blued/newreport/");
        stringBuilder1.append(paramString1);
        stringBuilder1.append("/");
        stringBuilder1.append(paramString2);
        str1 = stringBuilder1.toString();
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(BluedHttpUrl.n());
        stringBuilder1.append("/blued/newreport/");
        stringBuilder1.append(paramString1);
        str1 = stringBuilder1.toString();
      } 
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(BluedHttpUrl.n());
      stringBuilder1.append("/blued/newreport/");
      stringBuilder1.append(paramString1);
      stringBuilder1.append("/");
      stringBuilder1.append(paramString3);
      stringBuilder1.append("/");
      stringBuilder1.append(paramString2);
      str1 = stringBuilder1.toString();
    } 
    Map<String, String> map1 = BluedHttpTools.a();
    if (paramInt1 == 2 || paramInt1 == 5)
      map1.put("source", "ticktock"); 
    if (paramInt1 == 9 || paramInt1 == 10)
      map1.put("source", "posting"); 
    HttpManager.b(HttpUtils.a(map1, str1), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map2)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/sign-hongbao/watch-time");
    String str = stringBuilder.toString();
    Map<String, Integer> map = BluedHttpTools.b();
    map.put("time", Integer.valueOf(paramInt));
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append((UserInfo.a().i()).uid);
    stringBuilder.append("/background");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/validation/words");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.b();
    map.put("content", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("from", "auto");
    map.put("to", LocaleUtils.b());
    map.put("contents", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/translator");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/friends/search?page=");
    stringBuilder.append(paramInt);
    paramString1 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("keywords", paramString2);
    HttpManager.a(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, ChattingModel paramChattingModel) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/users/");
    stringBuilder1.append(paramString1);
    stringBuilder1.append("/messages/attachments");
    paramString1 = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramChattingModel.sessionType);
    stringBuilder2.append("");
    map.put("sessionType", stringBuilder2.toString());
    if (paramChattingModel.msgType == 24)
      map.put("isBurn", "1"); 
    HttpManager.a(paramString1, paramString2, "pic[]", (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.b(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, boolean paramBoolean, IRequestHost paramIRequestHost) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/emotions");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/chat_box");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/voice/transform");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.b();
    map.put("voice_name", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/gift/coupons");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/emotions/sayhi");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public void getChatRelationData(StringHttpResponseHandler paramStringHttpResponseHandler, Long[] paramArrayOfLong) {
    Map<String, Long[]> map = BluedHttpTools.b();
    map.put("uid", paramArrayOfLong);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append("/chat/detail");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramStringHttpResponseHandler, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\ChatHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */