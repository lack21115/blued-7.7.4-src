package com.qq.e.comm.plugin.m.a;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.ab.f.a.b;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.util.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b {
  public String a() {
    return "getAppInfo";
  }
  
  public void a(e parame, String paramString1, String paramString2, String paramString3) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("sdkEdition", SDKStatus.getSDKVersion());
      jSONObject.put("appVersion", GDTADManager.getInstance().getAppStatus().getAPPVersion());
      jSONObject.put("netType", GDTADManager.getInstance().getDeviceStatus().getPhoneNet());
      jSONObject.put("appName", GDTADManager.getInstance().getAppStatus().getAPPRealName());
      jSONObject.put("supportList", new JSONArray(parame.a()));
      jSONObject.put("muid", o.l());
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("code", 0);
      jSONObject1.put("data", jSONObject);
      parame.a(paramString3, 0, jSONObject1.toString(), 0);
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */