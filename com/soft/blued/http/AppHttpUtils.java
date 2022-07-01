package com.soft.blued.http;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.google.gson.Gson;
import com.soft.blued.tinker.util.TinkerTools;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class AppHttpUtils {
  public static void a() {
    String str1 = BluedPreferences.bR();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(DeviceUtils.b());
    stringBuilder.append("_");
    stringBuilder.append(TinkerTools.a());
    String str2 = stringBuilder.toString();
    if (!StringUtils.e(str2) && !str2.equalsIgnoreCase(str1)) {
      BluedPreferences.ae(str2);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(BluedHttpUrl.n());
      stringBuilder1.append("/blued/patchcode");
      String str = stringBuilder1.toString();
      Map<String, String> map = BluedHttpTools.a();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("");
      stringBuilder2.append(DeviceUtils.b());
      map.put("version_code", stringBuilder2.toString());
      map.put("patch_code", TinkerTools.a());
      map.put("channel", AppInfo.c);
      map.put("app", "1");
      HttpManager.b(str, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
    } 
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=videos&ops=auth");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/terms");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse) {
    Map<String, String> map = BluedHttpTools.a();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    String str = DeviceUtils.g();
    if (!TextUtils.isEmpty(str))
      arrayMap.put("dev_id", str); 
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    if (!TextUtils.isEmpty(BluedPreferences.bq()))
      arrayMap.put("device_token", BluedPreferences.bq()); 
    arrayMap.put("android_id", Settings.System.getString(AppInfo.d().getContentResolver(), "android_id"));
    arrayMap.put("os", "0");
    arrayMap.put("mac", AppInfo.e);
    arrayMap.put("imei", AppInfo.d);
    arrayMap.put("channel", AppInfo.c);
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/biotrack/a");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, boolean paramBoolean, String paramString1, String paramString2) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/verification");
    String str2 = stringBuilder.toString();
    ArrayMap<String, String> arrayMap = new ArrayMap();
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    arrayMap.put("ops", str1);
    try {
      arrayMap.put("url", URLEncoder.encode(paramString1, "UTF-8"));
      arrayMap.put("destination", URLEncoder.encode(paramString2, "UTF-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      arrayMap.put("url", URLEncoder.encode(paramString1));
      arrayMap.put("destination", URLEncoder.encode(paramString2));
    } catch (Exception exception) {}
    arrayMap.put("domain", Uri.parse(paramString1).getHost());
    HttpManager.a(HttpUtils.a((Map<String, String>)arrayMap, str2), (HttpResponseHandler)paramBluedUIHttpResponse, null).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString1, String paramString2, StringHttpResponseHandler paramStringHttpResponseHandler) {
    int i = DeviceUtils.b();
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(i);
    map.put("version_code", stringBuilder2.toString());
    map.put("patch_code", paramString1);
    map.put("channel", paramString2);
    map.put("app", "1");
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.n());
    stringBuilder2.append("/blued/patch");
    String str = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("version_code:");
    stringBuilder3.append(i);
    Log.i("PTH", stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("patch_code:");
    stringBuilder3.append(paramString1);
    Log.i("PTH", stringBuilder3.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("channel:");
    stringBuilder1.append(paramString2);
    Log.i("PTH", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("url:");
    stringBuilder1.append(str);
    Log.i("PTH", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramStringHttpResponseHandler).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  public static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/setting");
    return stringBuilder.toString();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/config");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/config/client");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\AppHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */