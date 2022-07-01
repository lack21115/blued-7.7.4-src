package com.soft.blued.http;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.google.gson.Gson;
import com.soft.blued.BluedConstant;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.third.model.OneLoginResult;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class LoginRegisterHttpUtils {
  private static final String a = LoginRegisterHttpUtils.class.getSimpleName();
  
  public static void a(int paramInt, Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    if (paramInt == 0)
      map.put("type", "recommend"); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/interest");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse) {
    a(paramContext, paramBluedUIHttpResponse, (IRequestHost)null);
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=avatar");
    String str = stringBuilder.toString();
    if (paramIRequestHost != null) {
      HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
      return;
    } 
    HttpManager.a(str, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/blued/splash?exclude_id=");
    stringBuilder1.append(paramString);
    String str2 = stringBuilder1.toString();
    paramString = NetworkUtils.d().toUpperCase();
    String str1 = paramString;
    if (!paramString.equalsIgnoreCase("2G")) {
      str1 = paramString;
      if (!paramString.equalsIgnoreCase("3G")) {
        str1 = paramString;
        if (!paramString.equalsIgnoreCase("4G")) {
          str1 = paramString;
          if (!paramString.equalsIgnoreCase("wifi"))
            str1 = "unknown".toUpperCase(); 
        } 
      } 
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append("&conn_type=");
    stringBuilder2.append(str1);
    stringBuilder2.append("&longitude=");
    stringBuilder2.append(BluedPreferences.s());
    stringBuilder2.append("&latitude=");
    stringBuilder2.append(BluedPreferences.t());
    HttpManager.a(stringBuilder2.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, String paramString1, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("avatar", paramString2);
    map.put("pid", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/avatar?http_method_override=PUT");
    paramString1 = stringBuilder.toString();
    Logger.b(a, new Object[] { "registerSysnHeadPic", paramString1, ";", paramString2, ";", paramString3 });
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/config");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).i();
  }
  
  public static void a(IRequestHost paramIRequestHost, PHONE_CODE_LOGIN_STAGE paramPHONE_CODE_LOGIN_STAGE, String paramString1, String paramString2, String paramString3, String paramString4, BluedUIHttpResponse paramBluedUIHttpResponse) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    String str = DeviceUtils.g();
    if (!TextUtils.isEmpty(str))
      arrayMap.put("dev_id", str); 
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("identity", paramString1);
    arrayMap.put("type", "mobile");
    if (null.a[paramPHONE_CODE_LOGIN_STAGE.ordinal()] != 2) {
      paramString1 = "identify";
    } else {
      paramString1 = "verify";
    } 
    arrayMap.put("stage", paramString1);
    arrayMap.put("captcha", paramString2);
    if (!TextUtils.isEmpty(paramString4))
      arrayMap.put("rid", paramString4); 
    if (paramPHONE_CODE_LOGIN_STAGE == PHONE_CODE_LOGIN_STAGE.b)
      arrayMap.put("authcode", paramString3); 
    Map<String, String> map = BluedHttpTools.a();
    Gson gson = AppInfo.f();
    try {
      String str1 = gson.toJson(arrayMap);
      Logger.a("vcode_login", str1);
      map.put("_", AesCrypto.b(str1));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/3rd/message/auth");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/logout");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, String paramString, IRequestHost paramIRequestHost) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    if (paramInt == 0) {
      paramString = "identify";
    } else if (paramInt == 1) {
      String str;
      if (DeviceUtils.f()) {
        str = "tw_binding";
      } else {
        str = "binding";
      } 
      arrayMap.put("code", paramString);
      paramString = str;
    } else if (paramInt == 2) {
      paramString = "unbinding";
    } else {
      paramString = "";
    } 
    arrayMap.put("stage", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/3rd/weixin/binding");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a((Map)arrayMap)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=faceplus_face");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/faceplus/ocidcard");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("images", paramString);
    map.put("uid", (UserInfo.a().i()).uid);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, int... paramVarArgs) {
    String str1;
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    String str2 = DeviceUtils.g();
    if (!TextUtils.isEmpty(str2))
      arrayMap.put("dev_id", str2); 
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/auth?http_method_override=DELETE&is_switch=");
    if (paramVarArgs.length > 0) {
      Integer integer = Integer.valueOf(paramVarArgs[0]);
    } else {
      str1 = "0";
    } 
    stringBuilder.append(str1);
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("code", paramString);
    if (paramInt != 0) {
      if (paramInt == 1)
        arrayMap.put("stage", "pre_verify"); 
    } else {
      arrayMap.put("stage", "verify");
    } 
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity/binding");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("stage", "send");
    arrayMap.put("captcha", paramString1);
    arrayMap.put("confirm_identity", Integer.valueOf(paramInt));
    arrayMap.put("email", paramString2);
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/safe/email");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("type", paramString);
    arrayMap.put("stage", "token_sm");
    paramString = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString))
      arrayMap.put("dev_id", paramString); 
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("stage", "change_send");
    arrayMap.put("type", paramString1);
    arrayMap.put("identity", paramString2);
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/safe/email");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("type", paramString1);
    arrayMap.put("access_token", paramString2);
    arrayMap.put("uid", paramString3);
    paramString1 = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id", paramString1); 
    paramString1 = DeviceUtils.h();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id_safe", paramString1); 
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    arrayMap.put("lat", BluedPreferences.t());
    arrayMap.put("lon", BluedPreferences.s());
    arrayMap.put("mac", AppInfo.e);
    arrayMap.put("imei", AppInfo.d);
    arrayMap.put("channel", AppInfo.c);
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/renew");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).a(false).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("stage", paramString1);
    map.put("code", paramString2);
    map.put("id", paramString3);
    if (!"close".equals(paramString1)) {
      paramString1 = DeviceUtils.h();
      if (!TextUtils.isEmpty(paramString1))
        map.put("dev_id_safe", paramString1); 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/device_safe");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost, String paramString4, String paramString5, String paramString6, boolean paramBoolean) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("type", paramString1);
    arrayMap.put("identity", paramString2);
    arrayMap.put("password", paramString3);
    arrayMap.put("login_token", UserInfo.a().d());
    paramString1 = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id", paramString1); 
    paramString1 = DeviceUtils.h();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id_safe", paramString1); 
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    arrayMap.put("lat", BluedPreferences.t());
    arrayMap.put("lon", BluedPreferences.s());
    arrayMap.put("token", paramString4);
    arrayMap.put("captcha", paramString5);
    if (!TextUtils.isEmpty(paramString6))
      arrayMap.put("rid", paramString6); 
    arrayMap.put("mac", AppInfo.e);
    arrayMap.put("imei", AppInfo.d);
    arrayMap.put("channel", AppInfo.c);
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    if (paramBoolean) {
      arrayMap.put("from", "auto");
    } else {
      arrayMap.put("from", "manual");
    } 
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/auth");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).a(false).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("identity", paramString1);
    arrayMap.put("type", paramString2);
    if (paramInt != 0) {
      if (paramInt == 1)
        arrayMap.put("stage", "pre"); 
    } else {
      arrayMap.put("stage", "identify");
    } 
    arrayMap.put("confirm_identity", paramString3);
    try {
      arrayMap.put("password", BluedHttpTools.b(paramString4));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } 
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity/binding");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("token", paramString1);
    arrayMap.put("stage", paramString2);
    arrayMap.put("authcode", paramString3);
    arrayMap.put("type", paramString4);
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/safe/device");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("identity", paramString1);
    arrayMap.put("token", paramString2);
    arrayMap.put("captcha", paramString3);
    arrayMap.put("type", paramString4);
    arrayMap.put("stage", paramString5);
    arrayMap.put("rid", paramString6);
    arrayMap.put("confirm_identity", paramString5);
    paramString1 = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id", paramString1); 
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).a(false).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, String paramString11, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("token", paramString1);
    arrayMap.put("password", paramString3);
    paramString1 = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id", paramString1); 
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    arrayMap.put("name", paramString2);
    arrayMap.put("height", paramString4);
    arrayMap.put("weight", paramString5);
    arrayMap.put("role", paramString6);
    arrayMap.put("birthday", paramString7);
    arrayMap.put("city_settled", BluedPreferences.u());
    arrayMap.put("ethnicity", paramString8);
    arrayMap.put("lat", BluedPreferences.t());
    arrayMap.put("lon", BluedPreferences.s());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    arrayMap.put("no_height_weight", stringBuilder2.toString());
    arrayMap.put("health_test_result", paramString9);
    arrayMap.put("health_test_time", paramString10);
    arrayMap.put("health_prpe_use_situation", paramString11);
    arrayMap.put("mac", AppInfo.e);
    arrayMap.put("imei", AppInfo.d);
    arrayMap.put("channel", AppInfo.c);
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    arrayMap.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
    arrayMap.put("dvid", BluedDeviceIdentity.a().g());
    Logger.b(a, new Object[] { "mac,imei,channel==", AppInfo.e, ",", AppInfo.d, ",", AppInfo.c });
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/passport/binding");
    HttpManager.b(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    if (TextUtils.equals(paramString4, "weixin")) {
      if (TextUtils.isEmpty(paramString3)) {
        arrayMap.put("access_token", paramString1);
        arrayMap.put("user_id", paramString2);
      } else {
        arrayMap.put("code", paramString3);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.n());
      stringBuilder.append("/passport/3rd/weixin/auth");
      String str = stringBuilder.toString();
    } else {
      paramString1 = "";
    } 
    paramString2 = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString2))
      arrayMap.put("dev_id", paramString2); 
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    arrayMap.put("mac", AppInfo.e);
    arrayMap.put("imei", AppInfo.d);
    arrayMap.put("channel", AppInfo.c);
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    if (paramBoolean) {
      arrayMap.put("from", "auto");
    } else {
      arrayMap.put("from", "manual");
    } 
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).a(false).i();
  }
  
  public static void a(OneLoginResult paramOneLoginResult, IRequestHost paramIRequestHost, BluedUIHttpResponse paramBluedUIHttpResponse) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    String str = DeviceUtils.g();
    if (!TextUtils.isEmpty(str))
      arrayMap.put("dev_id", str); 
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("token", paramOneLoginResult.token);
    arrayMap.put("process_id", paramOneLoginResult.process_id);
    arrayMap.put("authcode", paramOneLoginResult.authcode);
    arrayMap.put("app_id", "a37bfc7b589306b6b4784df1e130e548");
    arrayMap.put("phone", paramOneLoginResult.security_phone);
    Logger.a("onelogin", arrayMap);
    Map<String, String> map = BluedHttpTools.a();
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/3rd/oneclick/auth");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString) {
    a(paramString, "reg");
  }
  
  public static void a(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    String str = DeviceUtils.g();
    if (!TextUtils.isEmpty(str))
      arrayMap.put("dev_id", str); 
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    arrayMap.put("mac", AppInfo.e);
    arrayMap.put("imei", AppInfo.d);
    arrayMap.put("channel", AppInfo.c);
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("event", paramString1);
    arrayMap.put("type", paramString2);
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/biotrack/e");
    HttpManager.b(stringBuilder.toString(), null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/health_info");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    if (paramInt == 1) {
      arrayMap.put("stage", "change_verify");
    } else {
      arrayMap.put("stage", "verify");
    } 
    arrayMap.put("code", paramString);
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/safe/email");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=faceplus_ocidcard");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/faceplus/baidu");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("images", paramString);
    map.put("uid", (UserInfo.a().i()).uid);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/setting?type=inform");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("token", paramString1);
    arrayMap.put("name", paramString2);
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/name");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("token", paramString1);
    arrayMap.put("type", paramString2);
    try {
      arrayMap.put("password", BluedHttpTools.b(paramString3));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } 
    arrayMap.put("stage", "reset");
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    paramString1 = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id", paramString1); 
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("token", paramString1);
    arrayMap.put("code", paramString2);
    arrayMap.put("captcha", paramString3);
    arrayMap.put("type", paramString4);
    arrayMap.put("stage", "verify");
    paramString1 = DeviceUtils.g();
    if (!TextUtils.isEmpty(paramString1))
      arrayMap.put("dev_id", paramString1); 
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    arrayMap.put("oaid", BluedDeviceIdentity.a().h());
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).a(false).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("stage", "transfer");
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity/binding");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/groups/users/");
    stringBuilder.append(paramString);
    stringBuilder.append("/setting");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.l());
    stringBuilder.append("/yz/login");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("stage", "captcha");
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/safe/email");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public enum PHONE_CODE_LOGIN_STAGE {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\LoginRegisterHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */