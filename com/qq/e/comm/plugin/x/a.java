package com.qq.e.comm.plugin.x;

import android.content.Context;
import android.os.Build;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.plugin.util.al;
import com.qq.e.comm.plugin.util.an;
import com.qq.e.comm.plugin.util.ax;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.services.RetCodeService;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;

public class a {
  public static String a;
  
  private static final String b = String.format("http://%s/%s", new Object[] { "sdk.e.qq.com", "update" });
  
  private static String c;
  
  private static final a d;
  
  private ExecutorService e = Executors.newSingleThreadExecutor();
  
  private AtomicLong f = new AtomicLong();
  
  private int g = 69;
  
  private long h = 0L;
  
  private long i = 0L;
  
  static {
    a = "";
    c = "";
    d = new a();
  }
  
  public static a a() {
    return (a)gdtadv.getobjresult(293, 1, new Object[0]);
  }
  
  private String a(SM paramSM, PM paramPM, DeviceStatus paramDeviceStatus, APPStatus paramAPPStatus, Context paramContext) {
    return (String)gdtadv.getobjresult(294, 0, new Object[] { this, paramSM, paramPM, paramDeviceStatus, paramAPPStatus, paramContext });
  }
  
  private void a(String paramString) {
    gdtadv.getVresult(298, 0, new Object[] { this, paramString });
  }
  
  private void a(String paramString1, String paramString2) {
    gdtadv.getVresult(299, 0, new Object[] { this, paramString1, paramString2 });
  }
  
  private void a(JSONObject paramJSONObject) {
    gdtadv.getVresult(300, 0, new Object[] { this, paramJSONObject });
  }
  
  private void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    gdtadv.getVresult(301, 0, new Object[] { this, paramJSONObject1, paramJSONObject2 });
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean) {
    gdtadv.getVresult(302, 0, new Object[] { this, paramJSONObject, Boolean.valueOf(paramBoolean) });
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2) {
    return gdtadv.getZresult(303, 1, new Object[] { paramContext, paramString1, paramString2 });
  }
  
  private void b(int paramInt) {
    gdtadv.getVresult(304, 0, new Object[] { this, Integer.valueOf(paramInt) });
  }
  
  private void b(String paramString) {
    gdtadv.getVresult(306, 0, new Object[] { this, paramString });
  }
  
  private void b(String paramString1, String paramString2) {
    gdtadv.getVresult(307, 0, new Object[] { this, paramString1, paramString2 });
  }
  
  private void b(JSONObject paramJSONObject) {
    gdtadv.getVresult(308, 0, new Object[] { this, paramJSONObject });
  }
  
  private void b(JSONObject paramJSONObject, boolean paramBoolean) {
    gdtadv.getVresult(309, 0, new Object[] { this, paramJSONObject, Boolean.valueOf(paramBoolean) });
  }
  
  private void c(int paramInt) {
    gdtadv.getVresult(310, 0, new Object[] { this, Integer.valueOf(paramInt) });
  }
  
  private void c(String paramString) {
    gdtadv.getVresult(311, 0, new Object[] { this, paramString });
  }
  
  private void c(String paramString1, String paramString2) {
    gdtadv.getVresult(312, 0, new Object[] { this, paramString1, paramString2 });
  }
  
  private void d(String paramString) {
    gdtadv.getVresult(313, 0, new Object[] { this, paramString });
  }
  
  private boolean d(int paramInt) {
    return gdtadv.getZresult(314, 0, new Object[] { this, Integer.valueOf(paramInt) });
  }
  
  private void e(String paramString) {
    gdtadv.getVresult(315, 0, new Object[] { this, paramString });
  }
  
  private void f() {
    gdtadv.getVresult(316, 0, new Object[] { this });
  }
  
  private void g() {
    gdtadv.getVresult(317, 0, new Object[] { this });
  }
  
  private void h() {
    gdtadv.getVresult(318, 0, new Object[] { this });
  }
  
  private void i() {
    gdtadv.getVresult(319, 0, new Object[] { this });
  }
  
  private void j() {
    gdtadv.getVresult(320, 0, new Object[] { this });
  }
  
  private long k() {
    return gdtadv.getJresult(321, 0, new Object[] { this });
  }
  
  private int l() {
    return gdtadv.getIresult(322, 0, new Object[] { this });
  }
  
  public void a(int paramInt) {
    gdtadv.getVresult(323, 0, new Object[] { this, Integer.valueOf(paramInt) });
  }
  
  public void a(int paramInt, String paramString) {
    gdtadv.getVresult(324, 0, new Object[] { this, Integer.valueOf(paramInt), paramString });
  }
  
  public void b() {
    gdtadv.getVresult(325, 0, new Object[] { this });
  }
  
  public boolean c() {
    return gdtadv.getZresult(326, 0, new Object[] { this });
  }
  
  public long d() {
    return gdtadv.getJresult(327, 0, new Object[] { this });
  }
  
  public long e() {
    return gdtadv.getJresult(328, 0, new Object[] { this });
  }
  
  static class a {
    public static JSONObject a(PM param1PM) throws JSONException {
      JSONObject jSONObject = new JSONObject();
      jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
      jSONObject.putOpt("pv", Integer.valueOf(param1PM.getPluginVersion()));
      jSONObject.putOpt("sdk_st", Integer.valueOf(al.a()));
      jSONObject.putOpt("sdk_pt", Integer.valueOf(1));
      return jSONObject;
    }
    
    public static JSONObject a(SM param1SM) throws JSONException {
      JSONObject jSONObject = new JSONObject();
      if (param1SM != null) {
        jSONObject.putOpt("suid", param1SM.getSuid());
        jSONObject.putOpt("sid", param1SM.getSid());
      } 
      return jSONObject;
    }
    
    public static JSONObject a(SM param1SM, PM param1PM) throws JSONException {
      JSONObject jSONObject = new JSONObject();
      if (param1SM != null) {
        jSONObject.putOpt("app", param1SM.getDevCloudSettingSig());
        jSONObject.putOpt("sdk", param1SM.getSdkCloudSettingSig());
      } 
      if (param1PM != null) {
        jSONObject.putOpt("jar", param1PM.getLocalSig());
        jSONObject.putOpt("plugin_version", Integer.valueOf(param1PM.getPluginVersion()));
      } 
      return jSONObject;
    }
    
    public static JSONObject a(APPStatus param1APPStatus) throws JSONException {
      JSONObject jSONObject = new JSONObject();
      if (param1APPStatus != null) {
        jSONObject.putOpt("an", param1APPStatus.getAPPName());
        jSONObject.putOpt("appkey", param1APPStatus.getAPPID());
        jSONObject.putOpt("appv", param1APPStatus.getAPPVersion());
        jSONObject.putOpt("appn", param1APPStatus.getAPPRealName());
      } 
      return jSONObject;
    }
    
    public static JSONObject a(DeviceStatus param1DeviceStatus) throws JSONException {
      JSONObject jSONObject = new JSONObject();
      if (param1DeviceStatus != null) {
        jSONObject.putOpt("so", param1DeviceStatus.getScreenOrientation());
        jSONObject.putOpt("dn", param1DeviceStatus.getDataNet());
        String str = ad.a();
        if (!StringUtil.isEmpty(str))
          jSONObject.putOpt("cell_native", str); 
        jSONObject.putOpt("lat", param1DeviceStatus.getLat());
        jSONObject.putOpt("lng", param1DeviceStatus.getLng());
        for (Map.Entry entry : param1DeviceStatus.getLacAndCeilId().entrySet())
          jSONObject.putOpt((String)entry.getKey(), entry.getValue()); 
      } 
      return jSONObject;
    }
    
    public static JSONObject a(DeviceStatus param1DeviceStatus, Context param1Context) throws JSONException {
      JSONObject jSONObject = new JSONObject();
      if (param1DeviceStatus != null) {
        String str2 = o.b();
        String str1 = str2;
        if (str2 == null)
          str1 = ""; 
        jSONObject.putOpt("did", str1);
        SM sM = GDTADManager.getInstance().getSM();
        if (sM != null && 1 == sM.getInteger("support_servers_upload_qadid", 0))
          jSONObject.putOpt("qaid", an.a(param1Context)); 
        jSONObject.putOpt("md", param1DeviceStatus.model);
        jSONObject.putOpt("lg", param1DeviceStatus.getLanguage());
        jSONObject.putOpt("w", Integer.valueOf(param1DeviceStatus.getDeviceWidth()));
        jSONObject.putOpt("h", Integer.valueOf(param1DeviceStatus.getDeviceHeight()));
        jSONObject.putOpt("dd", Integer.valueOf(param1DeviceStatus.getDeviceDensity()));
        jSONObject.putOpt("apil", Integer.valueOf(param1DeviceStatus.getVersion()));
        jSONObject.putOpt("os", param1DeviceStatus.getOS());
        jSONObject.putOpt("op", param1DeviceStatus.getOperator());
        jSONObject.putOpt("mf", Build.MANUFACTURER);
        ax.a(jSONObject, "/update");
      } 
      return jSONObject;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\x\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */