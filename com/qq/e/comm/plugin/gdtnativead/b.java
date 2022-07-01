package com.qq.e.comm.plugin.gdtnativead;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.managers.GDTADManager;
import org.json.JSONException;
import org.json.JSONObject;

class b {
  static int a(String paramString) {
    return GDTADManager.getInstance().getSM().getIntegerForPlacement("download_confirm", paramString, 0);
  }
  
  static void a(String paramString, DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    GDTADManager.getInstance().getSM().setDEVCodeSetting("download_confirm", Integer.valueOf(paramDownAPPConfirmPolicy.value()), paramString);
  }
  
  static void a(String paramString, VideoOption paramVideoOption) {
    GDTADManager.getInstance().getSM().setDEVCodeSetting("videoOptions", paramVideoOption.getOptions().toString(), paramString);
  }
  
  static boolean a() {
    return (GDTADManager.getInstance().getSM().getInteger("expressInstallFilter", 1) == 1);
  }
  
  static JSONObject b(String paramString) {
    paramString = GDTADManager.getInstance().getSM().getStringForPlacement("videoOptions", paramString);
    if (paramString == null)
      paramString = "{}"; 
    try {
      return new JSONObject(paramString);
    } catch (JSONException jSONException) {
      return new JSONObject();
    } 
  }
  
  static boolean b() {
    return (GDTADManager.getInstance().getSM().getInteger("nativeExpressPreloadVideo", 1) == 1);
  }
  
  static String c() {
    return GDTADManager.getInstance().getSM().getString("aNativeJS_1_1");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */