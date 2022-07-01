package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak extends a<String, String> {
  private String j;
  
  public ak(Context paramContext, String paramString) {
    super(paramContext, paramString);
    this.j = paramString;
  }
  
  private static String b(String paramString) throws AMapException {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      String str1 = p.a(jSONObject, "code");
      String str2 = p.a(jSONObject, "message");
      if ("1".equals(str1))
        return p.a(jSONObject, "transfer_url"); 
      if (!"0".equals(str1)) {
        if (!"2".equals(str1)) {
          if (!"3".equals(str1)) {
            if (!"4".equals(str1)) {
              if ("5".equals(str1))
                throw new AMapException("短串分享认证失败", 0, str2); 
            } else {
              throw new AMapException("用户签名未通过", 0, str2);
            } 
          } else {
            throw new AMapException("请求参数非法", 0, str2);
          } 
        } else {
          throw new AMapException("短串请求失败", 0, str2);
        } 
      } else {
        throw new AMapException("其他未知错误", 0, str2);
      } 
    } catch (JSONException jSONException) {
      i.a((Throwable)jSONException, "ShareUrlSearchHandler", "paseJSON");
    } 
    return null;
  }
  
  protected final String a() {
    return null;
  }
  
  public final Map<String, String> e() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("channel=open_api&flag=1");
    StringBuilder stringBuilder2 = new StringBuilder("&address=");
    stringBuilder2.append(URLEncoder.encode(this.j));
    stringBuilder1.append(stringBuilder2.toString());
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("open_api1");
    stringBuffer.append(this.j);
    stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
    String str = bq.a(stringBuffer.toString());
    stringBuilder1.append("&sign=");
    stringBuilder1.append(str.toUpperCase(Locale.US));
    stringBuilder1.append("&output=json");
    try {
      byte[] arrayOfByte = at.a(stringBuilder1.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      i.a(unsupportedEncodingException, "ShareUrlSearchHandler", "getParams");
      unsupportedEncodingException = null;
    } 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("ent", "2");
    hashMap.put("in", bn.b((byte[])unsupportedEncodingException));
    hashMap.put("keyt", "openapi");
    return (Map)hashMap;
  }
  
  public final String g() {
    return h.e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */