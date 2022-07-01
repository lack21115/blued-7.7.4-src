package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
  public static void a(Context paramContext, String paramString) {
    (new m(paramContext, paramString)).start();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString1)) {
      HMSLog.e("ReportAaidToken", "Https response is empty.");
      return;
    } 
    try {
      StringBuilder stringBuilder2;
      JSONObject jSONObject = new JSONObject(paramString1);
      int i = jSONObject.optInt("ret", 256);
      if (i == 0) {
        String str1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString3);
        stringBuilder.append(paramString2);
        String str2 = stringBuilder.toString();
        str2 = r.a(str2, "SHA-256");
        i i1 = i.a(paramContext);
        boolean bool = i1.saveString("reportAaidAndToken", str2);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Report success ");
        if (bool) {
          str1 = "and save success.";
        } else {
          str1 = "but save failure.";
        } 
        stringBuilder2.append(str1);
        HMSLog.d("ReportAaidToken", stringBuilder2.toString());
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Https response body's ret code: ");
      stringBuilder1.append(i);
      stringBuilder1.append(", error message: ");
      stringBuilder1.append(stringBuilder2.optString("msg"));
      HMSLog.e("ReportAaidToken", stringBuilder1.toString());
      return;
    } catch (JSONException jSONException) {
      HMSLog.e("ReportAaidToken", "Has JSONException.");
      return;
    } catch (Exception exception) {
      HMSLog.e("ReportAaidToken", "Exception occur.");
      return;
    } 
  }
  
  public static boolean b(Context paramContext) {
    int i = (new PackageManagerHelper(paramContext)).getPackageVersionCode("com.huawei.android.pushagent");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NC version code: ");
    stringBuilder.append(i);
    HMSLog.d("ReportAaidToken", stringBuilder.toString());
    return ((90101400 <= i && i < 100000000) || i >= 100001301);
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2) {
    try {
      JSONObject jSONObject1 = new JSONObject();
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("timezone", TimeZone.getDefault().getID());
      jSONObject2.put("country", SystemUtils.getLocalCountry());
      JSONObject jSONObject3 = new JSONObject();
      PackageManagerHelper packageManagerHelper = new PackageManagerHelper(paramContext);
      String str = packageManagerHelper.getPackageVersionName("com.huawei.android.pushagent");
      jSONObject3.put("agent_version", str);
      jSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(paramContext)));
      JSONObject jSONObject4 = new JSONObject();
      jSONObject4.put("dev_type", a.a.a());
      jSONObject4.put("dev_sub_type", "phone");
      jSONObject4.put("os_type", b.b.a());
      jSONObject4.put("os_version", String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
      jSONObject1.put("id", UUID.randomUUID().toString());
      jSONObject1.put("global", jSONObject2);
      jSONObject1.put("push_agent", jSONObject3);
      jSONObject1.put("hardware", jSONObject4);
      jSONObject1.put("aaid", paramString1);
      jSONObject1.put("token", paramString2);
      AGConnectServicesConfig aGConnectServicesConfig = AGConnectServicesConfig.a(paramContext);
      jSONObject1.put("app_id", aGConnectServicesConfig.a("client/app_id"));
      jSONObject1.put("region", AGConnectServicesConfig.a(paramContext).a("region"));
      return jSONObject1.toString();
    } catch (JSONException jSONException) {
      HMSLog.e("ReportAaidToken", "Catch JSONException.");
      return null;
    } 
  }
  
  public static boolean d(Context paramContext, String paramString1, String paramString2) {
    i i = i.a(paramContext);
    if (!i.containsKey("reportAaidAndToken")) {
      HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
      return true;
    } 
    String str = i.getString("reportAaidAndToken");
    if (TextUtils.isEmpty(str)) {
      HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
      return true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append(paramString1);
    return str.equals(r.a(stringBuilder.toString(), "SHA-256")) ^ true;
  }
  
  public enum a {
    a("1"),
    b("2"),
    c("3"),
    d("4"),
    e("5"),
    f("6"),
    g("7"),
    h("8"),
    i("9"),
    j("10"),
    k("11"),
    l("12"),
    m("13");
    
    public String o;
    
    a(String param1String1) {
      this.o = param1String1;
    }
    
    public String a() {
      return this.o;
    }
  }
  
  public enum b {
    a("ios"),
    b("android"),
    c("harmony"),
    d("windows"),
    e("embed"),
    f("others");
    
    public String h;
    
    b(String param1String1) {
      this.h = param1String1;
    }
    
    public String a() {
      return this.h;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */