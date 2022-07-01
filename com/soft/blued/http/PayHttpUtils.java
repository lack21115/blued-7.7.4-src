package com.soft.blued.http;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.AesCrypto;
import com.google.gson.Gson;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

public class PayHttpUtils {
  private static final String a = PayHttpUtils.class.getSimpleName();
  
  public static String a(int paramInt) {
    return (paramInt != 2) ? ((paramInt != 4) ? "alipay" : "huabei") : "weixin";
  }
  
  public static void a(HttpResponseHandler paramHttpResponseHandler, IRequestHost paramIRequestHost, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    // Byte code:
    //   0: aload #5
    //   2: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   5: ifne -> 20
    //   8: aload #6
    //   10: astore #8
    //   12: aload #6
    //   14: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   17: ifeq -> 32
    //   20: invokestatic currentTimeMillis : ()J
    //   23: ldc2_w 1000
    //   26: ldiv
    //   27: invokestatic valueOf : (J)Ljava/lang/String;
    //   30: astore #8
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #6
    //   41: aload #6
    //   43: invokestatic p : ()Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #6
    //   52: ldc '/pay/android/orders?T='
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #6
    //   60: aload #8
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #6
    //   68: ldc '&access_token='
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #6
    //   76: aload #7
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #6
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: astore #9
    //   89: invokestatic a : ()Ljava/util/Map;
    //   92: astore #6
    //   94: aload #6
    //   96: ldc 'goods_id'
    //   98: iload_2
    //   99: invokestatic valueOf : (I)Ljava/lang/String;
    //   102: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload #9
    //   110: aload_0
    //   111: aload_1
    //   112: invokestatic b : (Ljava/lang/String;Lcom/blued/android/core/net/HttpResponseHandler;Lcom/blued/android/core/net/IRequestHost;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   115: astore_1
    //   116: aload #5
    //   118: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   121: ifne -> 133
    //   124: aload #5
    //   126: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   129: astore_0
    //   130: goto -> 144
    //   133: aload_3
    //   134: aload #4
    //   136: aload #7
    //   138: aload #8
    //   140: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   143: astore_0
    //   144: aload_1
    //   145: aload_0
    //   146: invokevirtual b : (Ljava/util/Map;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   149: aload #6
    //   151: invokestatic a : (Ljava/util/Map;)Ljava/lang/String;
    //   154: invokevirtual a : (Ljava/lang/String;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   157: invokevirtual i : ()Lcom/blued/android/core/net/HttpRequestWrapper;
    //   160: pop
    //   161: return
  }
  
  public static void a(HttpResponseHandler paramHttpResponseHandler, IRequestHost paramIRequestHost, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.p());
    stringBuilder.append("/oauth2/access_token");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", UserInfo.a().i().getUid());
    map.put("access_token", UserInfo.a().d());
    map.put("appkey", paramString);
    HttpManager.b(str, paramHttpResponseHandler, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(HttpResponseHandler paramHttpResponseHandler, IRequestHost paramIRequestHost, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    // Byte code:
    //   0: aload #4
    //   2: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   5: ifne -> 20
    //   8: aload #5
    //   10: astore #7
    //   12: aload #5
    //   14: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   17: ifeq -> 32
    //   20: invokestatic currentTimeMillis : ()J
    //   23: ldc2_w 1000
    //   26: ldiv
    //   27: invokestatic valueOf : (J)Ljava/lang/String;
    //   30: astore #7
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #5
    //   41: aload #5
    //   43: invokestatic p : ()Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #5
    //   52: ldc '/pay/android/sum?T='
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #5
    //   60: aload #7
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: ldc '&access_token='
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #5
    //   76: aload #6
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #5
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: aload_0
    //   88: aload_1
    //   89: invokestatic a : (Ljava/lang/String;Lcom/blued/android/core/net/HttpResponseHandler;Lcom/blued/android/core/net/IRequestHost;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   92: astore_1
    //   93: aload #4
    //   95: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   98: ifne -> 110
    //   101: aload #4
    //   103: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   106: astore_0
    //   107: goto -> 120
    //   110: aload_2
    //   111: aload_3
    //   112: aload #6
    //   114: aload #7
    //   116: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   119: astore_0
    //   120: aload_1
    //   121: aload_0
    //   122: invokevirtual b : (Ljava/util/Map;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   125: invokevirtual i : ()Lcom/blued/android/core/net/HttpRequestWrapper;
    //   128: pop
    //   129: return
  }
  
  public static void a(HttpResponseHandler paramHttpResponseHandler, IRequestHost paramIRequestHost, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
    // Byte code:
    //   0: aload #6
    //   2: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   5: ifne -> 20
    //   8: aload #7
    //   10: astore #10
    //   12: aload #7
    //   14: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   17: ifeq -> 32
    //   20: invokestatic currentTimeMillis : ()J
    //   23: ldc2_w 1000
    //   26: ldiv
    //   27: invokestatic valueOf : (J)Ljava/lang/String;
    //   30: astore #10
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #7
    //   41: aload #7
    //   43: invokestatic p : ()Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #7
    //   52: ldc '/pay/android/consume?T='
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #7
    //   60: aload #10
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #7
    //   68: ldc '&access_token='
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #7
    //   76: aload #8
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #7
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: astore #11
    //   89: invokestatic a : ()Ljava/util/Map;
    //   92: astore #7
    //   94: aload #7
    //   96: ldc 'orders_id'
    //   98: aload_2
    //   99: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload_3
    //   106: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   109: ifne -> 138
    //   112: aload_3
    //   113: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_2
    //   117: aload_2
    //   118: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   121: ifne -> 138
    //   124: aload #7
    //   126: ldc 'payment'
    //   128: aload_2
    //   129: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   132: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: aload #7
    //   140: ldc 'body'
    //   142: aload #9
    //   144: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: aload #11
    //   152: aload_0
    //   153: aload_1
    //   154: invokestatic b : (Ljava/lang/String;Lcom/blued/android/core/net/HttpResponseHandler;Lcom/blued/android/core/net/IRequestHost;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   157: astore_1
    //   158: aload #6
    //   160: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   163: ifne -> 175
    //   166: aload #6
    //   168: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   171: astore_0
    //   172: goto -> 187
    //   175: aload #4
    //   177: aload #5
    //   179: aload #8
    //   181: aload #10
    //   183: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   186: astore_0
    //   187: aload_1
    //   188: aload_0
    //   189: invokevirtual b : (Ljava/util/Map;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   192: aload #7
    //   194: invokestatic a : (Ljava/util/Map;)Ljava/lang/String;
    //   197: invokevirtual a : (Ljava/lang/String;)Lcom/blued/android/core/net/HttpRequestWrapper;
    //   200: invokevirtual i : ()Lcom/blued/android/core/net/HttpRequestWrapper;
    //   203: pop
    //   204: return
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/config");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/config/vip?pid=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2, int paramInt3, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.o());
    stringBuilder1.append("/pay/coupons/new");
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
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt3);
    stringBuilder2.append("");
    map.put("product_id", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/channel?sid=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.o());
      stringBuilder.append("/paymentcode");
      HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.o());
    stringBuilder1.append("/pay/android/unified");
    String str = stringBuilder1.toString();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("id", stringBuilder2.toString());
    map.put("type", a(paramInt1));
    map.put("stage", "prepay");
    map.put("detail", paramString5);
    if (paramInt3 > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt3);
      stringBuilder.append("");
      map.put("users_coupons_id", stringBuilder.toString());
    } 
    if (!StringUtils.e(paramString3))
      map.put("target_uid", paramString3); 
    if (!StringUtils.e(paramString2))
      map.put("activity_id", paramString2); 
    if (!StringUtils.e(paramString4))
      map.put("exchange_id", paramString4); 
    if (!StringUtils.e(paramString1))
      map.put("from", paramString1); 
    Gson gson = AppInfo.f();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("data==");
      stringBuilder.append(gson.toJson(map));
      Logger.c("PayHttpUtils", new Object[] { stringBuilder.toString() });
      String str1 = AesCrypto.b(gson.toJson(map));
      Map<String, String> map1 = BluedHttpTools.a();
      map1.put("_", str1);
      HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null, -1, "");
      return;
    } 
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/config/");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/config/");
    stringBuilder.append(paramString);
    stringBuilder.append("?id=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/android/unified");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("stage", "verify");
    if ("alipay".equals(paramString1)) {
      map.put("result", paramString2);
    } else if ("weixin".equals(paramString1)) {
      map.put("prepayid", paramString2);
    } 
    map.put("type", paramString1);
    Gson gson = AppInfo.f();
    try {
      String str1 = AesCrypto.b(gson.toJson(map));
      Map<String, String> map1 = BluedHttpTools.a();
      map1.put("_", str1);
      HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null, -1, "");
      return;
    } 
  }
  
  public static void a(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.o());
      stringBuilder.append("/paymentcode");
      String str = stringBuilder.toString();
      Map<String, String> map = BluedHttpTools.a();
      map.put("type", "modify");
      map.put("code", BluedHttpTools.b(paramString));
      paramString = AesCrypto.b(AppInfo.f().toJson(map));
      map = BluedHttpTools.a();
      map.put("_", paramString);
      HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
  }
  
  public static void a(String paramString, Boolean paramBoolean, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    try {
      String str1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pwd===");
      stringBuilder.append(BluedHttpTools.b(paramString));
      Logger.e("setPayPW", new Object[] { stringBuilder.toString() });
      stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.o());
      stringBuilder.append("/paymentcode/");
      stringBuilder.append(paramInt);
      String str2 = stringBuilder.toString();
      Map<String, String> map2 = BluedHttpTools.a();
      if (paramBoolean.booleanValue()) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      map2.put("verify", str1);
      map2.put("code", BluedHttpTools.b(paramString));
      map2.put("type", "set");
      paramString = AesCrypto.b(AppInfo.f().toJson(map2));
      Map<String, String> map1 = BluedHttpTools.a();
      map1.put("_", paramString);
      HttpManager.b(str2, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
      return;
    } catch (Exception exception) {
      paramBluedUIHttpResponse.onFailure(null);
      return;
    } 
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.o());
    stringBuilder1.append("/pay/config/vip/cancle");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("is_svip", stringBuilder2.toString());
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/config/localization/new");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.o());
    stringBuilder.append("/pay/beans/get_detail?product_id=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\PayHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */