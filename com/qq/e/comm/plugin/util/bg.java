package com.qq.e.comm.plugin.util;

import android.content.Context;
import com.qq.e.comm.plugin.ad.s;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import org.json.JSONObject;
import yaq.gdtadv;

public class bg {
  public static int a() {
    return gdtadv.getIresult(334, 1, new Object[0]);
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    return gdtadv.getIresult(335, 1, new Object[] { paramContext, paramString1, paramString2, paramString3, paramString4 });
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    return gdtadv.getIresult(336, 1, new Object[] { paramContext, paramString1, paramString2, paramString3, paramString4, Boolean.valueOf(paramBoolean) });
  }
  
  private static int a(Object paramObject) {
    return gdtadv.getIresult(337, 1, new Object[] { paramObject });
  }
  
  private static int a(Object paramObject, String paramString) {
    return gdtadv.getIresult(338, 1, new Object[] { paramObject, paramString });
  }
  
  public static int a(JSONObject paramJSONObject) {
    return gdtadv.getIresult(339, 1, new Object[] { paramJSONObject });
  }
  
  public static int a(JSONObject paramJSONObject, boolean paramBoolean) {
    return gdtadv.getIresult(340, 1, new Object[] { paramJSONObject, Boolean.valueOf(paramBoolean) });
  }
  
  public static JSONObject a(s params) {
    return (JSONObject)gdtadv.getobjresult(341, 1, new Object[] { params });
  }
  
  public static void a(int paramInt, c paramc, d paramd, boolean paramBoolean1, boolean paramBoolean2) {
    gdtadv.getVresult(342, 1, new Object[] { Integer.valueOf(paramInt), paramc, paramd, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public static int b() {
    return gdtadv.getIresult(343, 1, new Object[0]);
  }
  
  public static JSONObject b(JSONObject paramJSONObject) {
    return (JSONObject)gdtadv.getobjresult(344, 1, new Object[] { paramJSONObject });
  }
  
  private static JSONObject c() {
    return (JSONObject)gdtadv.getobjresult(345, 1, new Object[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */