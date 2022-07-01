package com.blued.android.framework.http;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.utils.LocaleUtils;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class BluedHttpTools {
  public static String a(Map<String, ?> paramMap) {
    if (paramMap == null)
      return null; 
    String str = AppInfo.f().toJson(paramMap);
    if (HttpManager.c()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("params string:");
      stringBuilder.append(str);
      Log.v("HttpManager", stringBuilder.toString());
    } 
    return str;
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str2 = Integer.toString(paramArrayOfbyte[i] & 0xFF, 16);
      String str1 = str2;
      if (str2.length() == 1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(str2);
        str1 = stringBuilder1.toString();
      } 
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
  
  public static Map<String, String> a() {
    return (Map<String, String>)new ArrayMap();
  }
  
  public static Map<String, String> a(String paramString) {
    Map<String, String> map = a(false);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued ");
    stringBuilder.append(paramString);
    map.put("Authorization", stringBuilder.toString());
    return map;
  }
  
  public static Map<String, String> a(String paramString1, String paramString2, String paramString3, String paramString4) {
    Map<String, String> map = a(false);
    try {
      String str2 = (new StringBuilder(paramString4)).reverse().toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString3);
      stringBuilder2.append(str2);
      paramString3 = stringBuilder2.toString();
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "HmacSHA1");
      Mac mac = Mac.getInstance("HmacSHA1");
      mac.init(secretKeySpec);
      String str1 = Base64.encodeToString(mac.doFinal(paramString3.getBytes()), 2);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append(":");
      stringBuilder1.append(str1);
      paramString1 = Base64.encodeToString(stringBuilder1.toString().getBytes(), 2);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } catch (InvalidKeyException invalidKeyException) {
    
    } finally {
      paramString1 = null;
    } 
    stringBuilder.append("Blued ");
    stringBuilder.append(paramString1);
    map.put("Authorization", stringBuilder.toString());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sign:");
    stringBuilder.append(paramString1);
    stringBuilder.append(", t:");
    stringBuilder.append(paramString4);
    Log.v("tempTest", stringBuilder.toString());
    return map;
  }
  
  public static Map<String, String> a(boolean paramBoolean) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("Accept", "*/*");
    arrayMap.put("Connection", "keep-alive");
    arrayMap.put("Content-Type", "application/json");
    arrayMap.put("Accept-Language", LocaleUtils.b());
    arrayMap.put("User-Agent", AppInfo.b);
    String str = ProviderHolder.a().e().b();
    if (!TextUtils.isEmpty(str))
      arrayMap.put("X-CLIENT-COLOR", str); 
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Basic ");
      stringBuilder.append(d());
      arrayMap.put("Authorization", stringBuilder.toString());
    } 
    return (Map<String, String>)arrayMap;
  }
  
  public static String b(String paramString) throws NoSuchAlgorithmException {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
    messageDigest.update(paramString.getBytes());
    return a(messageDigest.digest());
  }
  
  public static Map<String, Object> b() {
    return (Map<String, Object>)new ArrayMap();
  }
  
  public static Map<String, String> b(boolean paramBoolean) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("Accept", "*/*");
    arrayMap.put("Connection", "keep-alive");
    arrayMap.put("Accept-Language", LocaleUtils.b());
    arrayMap.put("User-Agent", AppInfo.b);
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Basic ");
      stringBuilder.append(d());
      arrayMap.put("Authorization", stringBuilder.toString());
    } 
    return (Map<String, String>)arrayMap;
  }
  
  public static Map<String, String[]> c() {
    return (Map<String, String[]>)new ArrayMap();
  }
  
  public static Map<String, String> c(boolean paramBoolean) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("Accept", "*/*");
    arrayMap.put("Connection", "keep-alive");
    arrayMap.put("Accept-Language", LocaleUtils.b());
    arrayMap.put("User-Agent", AppInfo.b);
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Basic ");
      stringBuilder.append(d());
      arrayMap.put("Authorization", stringBuilder.toString());
    } 
    return (Map<String, String>)arrayMap;
  }
  
  public static String d() {
    String str3 = ProviderHolder.a().b().a();
    String str2 = ProviderHolder.a().b().b();
    String str1 = str2;
    try {
      if (TextUtils.isEmpty(str2))
        str1 = "0"; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str3);
      stringBuilder.append(":");
      stringBuilder.append(str1);
      return Base64.encodeToString(stringBuilder.toString().getBytes(), 2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\http\BluedHttpTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */