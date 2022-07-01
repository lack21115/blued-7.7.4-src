package com.blued.android.module.yy_china.trtc_audio.model;

import android.text.TextUtils;
import android.util.Base64;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class GenerateTestUserSig {
  public static int a() {
    return YYRoomInfoManager.d().c().d() ? 1400437701 : 1400437703;
  }
  
  private static String a(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2, String paramString3) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TLS.identifier:");
    stringBuilder.append(paramString1);
    stringBuilder.append("\nTLS.sdkappid:");
    stringBuilder.append(paramLong1);
    stringBuilder.append("\nTLS.time:");
    stringBuilder.append(paramLong2);
    stringBuilder.append("\nTLS.expire:");
    stringBuilder.append(paramLong3);
    stringBuilder.append("\n");
    String str2 = stringBuilder.toString();
    paramString1 = str2;
    if (paramString3 != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append("TLS.userbuf:");
      stringBuilder1.append(paramString3);
      stringBuilder1.append("\n");
      str1 = stringBuilder1.toString();
    } 
    try {
      byte[] arrayOfByte = paramString2.getBytes("UTF-8");
      Mac mac = Mac.getInstance("HmacSHA256");
      mac.init(new SecretKeySpec(arrayOfByte, "HmacSHA256"));
      return new String(Base64.encode(mac.doFinal(str1.getBytes("UTF-8")), 2));
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  private static String a(long paramLong1, String paramString1, long paramLong2, byte[] paramArrayOfbyte, String paramString2) {
    if (TextUtils.isEmpty(paramString2))
      return ""; 
    long l = System.currentTimeMillis() / 1000L;
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("TLS.ver", "2.0");
      try {
        jSONObject.put("TLS.identifier", paramString1);
        try {
          jSONObject.put("TLS.sdkappid", paramLong1);
          try {
            jSONObject.put("TLS.expire", paramLong2);
            jSONObject.put("TLS.time", l);
          } catch (JSONException null) {}
        } catch (JSONException null) {}
      } catch (JSONException null) {}
    } catch (JSONException jSONException) {}
    jSONException.printStackTrace();
  }
  
  public static String a(String paramString) {
    return a(a(), paramString, 604800L, null, c());
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = (new String(Base64.encode(paramArrayOfbyte, 2))).getBytes();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      byte b = paramArrayOfbyte[i];
      if (b != 43) {
        if (b != 47) {
          if (b == 61)
            paramArrayOfbyte[i] = 95; 
        } else {
          paramArrayOfbyte[i] = 45;
        } 
      } else {
        paramArrayOfbyte[i] = 42;
      } 
    } 
    return paramArrayOfbyte;
  }
  
  public static int b() {
    return 1252271228;
  }
  
  public static String c() {
    return YYRoomInfoManager.d().c().d() ? "82373b52872bb32aa0217ab03803388c8d63a3fa3d690100a99a95b6d1bbb171" : "d6fafd2e28ee82e8ef5c207843fe18c0f3540b7386426025e3e29b8c9c9aec36";
  }
  
  public static int d() {
    YYRoomInfoManager.d().c().d();
    return 84981;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\model\GenerateTestUserSig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */