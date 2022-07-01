package com.geetest.onelogin.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.geetest.onelogin.j.p;
import org.json.JSONObject;

public class c {
  public static JSONObject a(Context paramContext) {
    p.a().a("getDeviceInfo");
    a a = new a();
    try {
      b.a(paramContext, a);
      b.a(a);
      b.b(paramContext, a);
      b.c(paramContext, a);
    } catch (Exception exception) {}
    JSONObject jSONObject = a.toJSONObject();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getDeviceInfo jsonObject=");
    stringBuilder.append(jSONObject.toString());
    com.geetest.onelogin.j.c.a(stringBuilder.toString());
    p.a().b("getDeviceInfo");
    return jSONObject;
  }
  
  public static JSONObject b(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (packageInfo != null) {
        jSONObject.put("vendor", packageInfo.packageName);
        jSONObject.put("packagesign", e.a(paramContext));
      } 
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */