package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import android.os.SystemClock;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.l.a;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.q;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;

public class n {
  private static SM a = GDTADManager.getInstance().getSM();
  
  public static int a() {
    return a.getInteger("rewardVideoCardShowTime", 4);
  }
  
  public static int a(SM paramSM) {
    return paramSM.getInteger("rewardVideoDemoGamePreloadTime", 3);
  }
  
  public static int a(a parama, boolean paramBoolean) {
    return !paramBoolean ? 1 : (q.a(parama) ? 2 : 0);
  }
  
  public static int a(String paramString) {
    return a.getIntegerForPlacement("rewardVideoCloseShowTime", paramString, 30);
  }
  
  public static String a(int paramInt, String paramString, long paramLong) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      jSONObject.put("p", String.valueOf(paramLong));
      jSONObject.put("click_area", String.valueOf(paramInt));
      jSONObject.put("vp", String.valueOf(1));
      jSONObject.put("sz", "-999");
      jSONObject.put("tid", "-999");
      String str = jSONObject.toString();
      paramString = str;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return g.a(paramString);
  }
  
  public static JSONObject a(Context paramContext, a parama) throws JSONException {
    JSONObject jSONObject = new JSONObject(parama.E().toString());
    if (b.a(paramContext, parama) || !parama.v()) {
      String str;
      jSONObject.put("custom_button_txt", parama.ad());
      if (q.a(parama)) {
        str = (parama.ab()).f;
      } else {
        str = "";
      } 
      jSONObject.put("dpa_custom_button_txt", str);
    } 
    return jSONObject;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, d paramd) {
    gdtadv.getVresult(173, 1, new Object[] { paramContext, paramString1, paramString2, paramd });
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt3 /= 1000;
    if (paramInt2 >= paramInt3) {
      paramInt3 -= paramInt4;
    } else {
      paramInt3 = paramInt2 - paramInt4;
    } 
    boolean bool2 = false;
    paramInt4 = paramInt3;
    if (paramInt3 < 0)
      paramInt4 = 0; 
    boolean bool1 = bool2;
    if (paramInt2 >= 0) {
      bool1 = bool2;
      if (paramInt1 >= paramInt4 * 1000)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static boolean a(a parama) {
    int i = a.getInteger("rvfsClickable", 0);
    if (i != 1) {
      if (i == 0)
        return false; 
      if (a.a().a(parama.Z(), String.valueOf(i), 0) != 1)
        return false; 
    } 
    return true;
  }
  
  public static int b() {
    int i = a.getInteger("rewardLoadAdCount", 1);
    if (i <= 2) {
      int j = i;
      return (i < 1) ? 1 : j;
    } 
    return 1;
  }
  
  public static int b(String paramString) {
    return a.getIntegerForPlacement("rewardVideoEffectiveTime", paramString, 30);
  }
  
  public static long c() {
    return SystemClock.elapsedRealtime() + (a.getInteger("rewardVideoExpireDuration", 1800) * 1000);
  }
  
  public static boolean c(String paramString) {
    return (a.getIntegerForPlacement("showRewardVideoTips", paramString, 0) == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */