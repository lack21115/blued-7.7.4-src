package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.encrypt.c;
import com.alipay.sdk.net.a;
import com.alipay.sdk.packet.b;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends e {
  public b a(a parama, Context paramContext, String paramString) throws Throwable {
    c.b("mspl", "mdap post");
    byte[] arrayOfByte = c.a(paramString.getBytes(Charset.forName("UTF-8")));
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("utdId", b.a().e());
    hashMap.put("logHeader", "RAW");
    hashMap.put("bizCode", "alipaysdk");
    hashMap.put("productId", "alipaysdk_android");
    hashMap.put("Content-Encoding", "Gzip");
    hashMap.put("productVersion", "15.7.4");
    a.b b = a.a(paramContext, new a.a("https://loggw-exsdk.alipay.com/loggw/logUpload.do", hashMap, arrayOfByte));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mdap got ");
    stringBuilder.append(b);
    c.b("mspl", stringBuilder.toString());
    if (b != null) {
      boolean bool = a(b);
      try {
        byte[] arrayOfByte2 = b.c;
        byte[] arrayOfByte1 = arrayOfByte2;
        if (bool)
          arrayOfByte1 = c.b(arrayOfByte2); 
        String str = new String(arrayOfByte1, Charset.forName("UTF-8"));
        return new b("", str);
      } catch (Exception exception) {
        c.a(exception);
        return null;
      } 
    } 
    throw new RuntimeException("Response is null");
  }
  
  public String a(a parama, String paramString, JSONObject paramJSONObject) {
    return paramString;
  }
  
  public Map<String, String> a(boolean paramBoolean, String paramString) {
    return new HashMap<String, String>();
  }
  
  public JSONObject a() {
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\packet\impl\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */