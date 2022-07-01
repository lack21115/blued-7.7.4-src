package com.qq.e.comm.plugin.w;

import com.qq.e.comm.plugin.ad.f;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.t.b;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;

public class h {
  public static final String a = "http://sdk.e.qq.com";
  
  public static final String b = "http://sdk.e.qq.com/getad";
  
  public static final String c = "http://sdk.e.qq.com/disp";
  
  public static final String d = "http://sdk.e.qq.com/click";
  
  public static final String e = "http://sdk.e.qq.com/msg";
  
  private static final String f = "imei";
  
  private static final String g = "index";
  
  private static final String h = "secLevel";
  
  private static final String i = "gdtType";
  
  private static final String j = "trace";
  
  private static final String k = "dev";
  
  private static Random l = new Random();
  
  public static JSONObject a(m paramm) throws JSONException {
    return (JSONObject)gdtadv.getobjresult(156, 1, new Object[] { paramm });
  }
  
  private static JSONObject a(String paramString1, String paramString2, Map<String, Object> paramMap) throws JSONException {
    return (JSONObject)gdtadv.getobjresult(157, 1, new Object[] { paramString1, paramString2, paramMap });
  }
  
  private static JSONObject a(String paramString1, String paramString2, Map<String, Object> paramMap, f paramf, JSONObject paramJSONObject) throws JSONException {
    return (JSONObject)gdtadv.getobjresult(158, 1, new Object[] { paramString1, paramString2, paramMap, paramf, paramJSONObject });
  }
  
  public static void a(int paramInt, JSONObject paramJSONObject) {
    gdtadv.getVresult(159, 1, new Object[] { Integer.valueOf(paramInt), paramJSONObject });
  }
  
  public static void a(int paramInt, JSONObject paramJSONObject, m paramm, String paramString) {
    gdtadv.getVresult(160, 1, new Object[] { Integer.valueOf(paramInt), paramJSONObject, paramm, paramString });
  }
  
  public static void a(String paramString1, String paramString2, m paramm, Map<String, Object> paramMap, b paramb) {
    gdtadv.getVresult(161, 1, new Object[] { paramString1, paramString2, paramm, paramMap, paramb });
  }
  
  public static void a(String paramString1, String paramString2, JSONObject paramJSONObject, m paramm, f paramf, Map<String, Object> paramMap, b paramb) {
    gdtadv.getVresult(162, 1, new Object[] { paramString1, paramString2, paramJSONObject, paramm, paramf, paramMap, paramb });
  }
  
  public static void a(List<String> paramList, String paramString, m paramm, Map<String, Object> paramMap, b paramb) {
    gdtadv.getVresult(163, 1, new Object[] { paramList, paramString, paramm, paramMap, paramb });
  }
  
  private static void a(JSONObject paramJSONObject) throws JSONException {
    gdtadv.getVresult(164, 1, new Object[] { paramJSONObject });
  }
  
  public static void a(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt1, int paramInt2, int paramInt3) {
    gdtadv.getVresult(165, 1, new Object[] { paramArrayOfStackTraceElement, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  private static boolean a(int paramInt1, int paramInt2) {
    return gdtadv.getZresult(166, 1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */