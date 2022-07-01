package com.qq.e.comm.plugin.w;

import android.content.Context;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.i;
import com.qq.e.comm.plugin.util.ay;
import com.qq.e.comm.plugin.util.bl;
import com.qq.e.comm.plugin.util.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;

public class e {
  private static ay a = new ay(2048, 5, "loadad_limit_num");
  
  private static com.qq.e.comm.plugin.k.a a(String paramString) {
    return (com.qq.e.comm.plugin.k.a)gdtadv.getobjresult(122, 1, new Object[] { paramString });
  }
  
  public static String a() {
    return (String)gdtadv.getobjresult(123, 1, new Object[0]);
  }
  
  public static void a(b paramb, b paramb1, a parama) {
    gdtadv.getVresult(127, 1, new Object[] { paramb, paramb1, parama });
  }
  
  private static void a(b paramb, b paramb1, a parama, String paramString) {
    gdtadv.getVresult(128, 1, new Object[] { paramb, paramb1, parama, paramString });
  }
  
  private static void a(JSONObject paramJSONObject, String paramString) {
    gdtadv.getVresult(129, 1, new Object[] { paramJSONObject, paramString });
  }
  
  private static JSONObject b(JSONObject paramJSONObject, String paramString1, String paramString2) {
    return (JSONObject)gdtadv.getobjresult(131, 1, new Object[] { paramJSONObject, paramString1, paramString2 });
  }
  
  private static void b() {
    gdtadv.getVresult(132, 1, new Object[0]);
  }
  
  private static void b(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, m paramm) {
    gdtadv.getVresult(133, 1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2, paramString3, paramm });
  }
  
  private static void b(int paramInt, long paramLong, String paramString) {
    gdtadv.getVresult(134, 1, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString });
  }
  
  private static boolean b(l paraml) {
    return gdtadv.getZresult(135, 1, new Object[] { paraml });
  }
  
  public static interface a {
    void a(com.qq.e.comm.plugin.k.a param1a);
    
    void a(JSONObject param1JSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */