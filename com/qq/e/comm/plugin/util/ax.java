package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.tencent.turingfd.sdk.ams.au.r;
import com.tencent.turingfd.sdk.ams.au.s;
import org.json.JSONObject;
import yaq.gdtadv;

public class ax {
  private static volatile String a = e();
  
  private static volatile String b = f();
  
  public static Pair<String, String> a() {
    return (Pair<String, String>)gdtadv.getobjresult(353, 1, new Object[0]);
  }
  
  public static void a(Context paramContext) {
    gdtadv.getVresult(354, 1, new Object[] { paramContext });
  }
  
  public static void a(w paramw, String paramString) {
    gdtadv.getVresult(355, 1, new Object[] { paramw, paramString });
  }
  
  private static void a(r paramr) {
    gdtadv.getVresult(356, 1, new Object[] { paramr });
  }
  
  private static void a(String paramString) {
    gdtadv.getVresult(357, 1, new Object[] { paramString });
  }
  
  public static void a(JSONObject paramJSONObject, String paramString) {
    gdtadv.getVresult(358, 1, new Object[] { paramJSONObject, paramString });
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, String paramString) {
    gdtadv.getVresult(359, 1, new Object[] { Boolean.valueOf(paramBoolean), paramJSONObject, paramString });
  }
  
  private static void b(String paramString) {
    gdtadv.getVresult(361, 1, new Object[] { paramString });
  }
  
  private static void c() {
    gdtadv.getVresult(362, 1, new Object[0]);
  }
  
  private static void d() {
    gdtadv.getVresult(363, 1, new Object[0]);
  }
  
  private static String e() {
    return (String)gdtadv.getobjresult(364, 1, new Object[0]);
  }
  
  private static String f() {
    return (String)gdtadv.getobjresult(365, 1, new Object[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */