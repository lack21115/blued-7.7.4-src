package com.amap.api.mapcore2d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class cs {
  public static int a = -1;
  
  public static String b = "";
  
  private static da c;
  
  private static String d = "http://apiinit.amap.com/v3/log/init";
  
  private static String e;
  
  private static String a() {
    return d;
  }
  
  private static Map<String, String> a(Context paramContext) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      hashMap.put("resType", "json");
      hashMap.put("encode", "UTF-8");
      String str = ct.a();
      hashMap.put("ts", str);
      hashMap.put("key", cq.f(paramContext));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("resType=json&encode=UTF-8&key=");
      return (Map)hashMap;
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "Auth", "gParams");
    } 
  }
  
  public static void a(String paramString) {
    cq.a(paramString);
  }
  
  @Deprecated
  public static boolean a(Context paramContext, da paramda) {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/cs
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: iconst_0
    //   6: invokestatic a : (Landroid/content/Context;Lcom/amap/api/mapcore2d/da;Z)Z
    //   9: istore_2
    //   10: ldc com/amap/api/mapcore2d/cs
    //   12: monitorexit
    //   13: iload_2
    //   14: ireturn
    //   15: astore_0
    //   16: ldc com/amap/api/mapcore2d/cs
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	15	finally
  }
  
  private static boolean a(Context paramContext, da paramda, boolean paramBoolean) {
    c = paramda;
    try {
      String str = a();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("Content-Type", "application/x-www-form-urlencoded");
      hashMap.put("Accept-Encoding", "gzip");
      hashMap.put("Connection", "Keep-Alive");
      hashMap.put("User-Agent", c.d());
      hashMap.put("X-INFO", ct.b(paramContext));
      hashMap.put("logversion", "2.1");
      hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { c.b(), c.a() }));
      er er = er.a();
      dc dc = new dc();
      dc.a(cy.a(paramContext));
      dc.a((Map)hashMap);
      return a(er.b(dc));
    } finally {
      paramContext = null;
      dl.a((Throwable)paramContext, "Auth", "getAuth");
    } 
  }
  
  private static boolean a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return true; 
    try {
      JSONObject jSONObject = new JSONObject(db.a(paramArrayOfbyte));
      if (jSONObject.has("status")) {
        int j = jSONObject.getInt("status");
        if (j == 1) {
          a = 1;
        } else if (j == 0) {
          a = 0;
        } 
      } 
      if (jSONObject.has("info"))
        b = jSONObject.getString("info"); 
      return (i == 1);
    } catch (JSONException jSONException) {
      return false;
    } finally {
      paramArrayOfbyte = null;
      dl.a((Throwable)paramArrayOfbyte, "Auth", "lData");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */