package com.pgl.sys.a;

import android.content.Context;
import android.util.Base64;
import com.pgl.a.b.d;
import com.pgl.sys.a.a.a;
import org.json.JSONObject;

public class a {
  static int a = 504;
  
  static boolean b = false;
  
  static String c = "";
  
  static String d = "";
  
  private static long e;
  
  public static String a() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("os", "Android");
      jSONObject.put("version", "1.0.3");
      boolean bool = b;
      return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
    } finally {
      Exception exception = null;
      d.a("Call onEvent Error");
    } 
  }
  
  public static void a(Context paramContext, String paramString, a parama) {
    int i = a;
    if (i == 102)
      return; 
    if (i == 202)
      return; 
    if (i == 200)
      return; 
    e = System.currentTimeMillis();
    b = false;
    c = paramString;
    a = 102;
    Thread thread = new Thread(new b(paramContext, parama));
    thread.setName("CZL-3");
    thread.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */