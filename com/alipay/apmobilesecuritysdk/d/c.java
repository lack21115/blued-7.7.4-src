package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.a;
import com.alipay.apmobilesecuritysdk.e.e;
import com.alipay.apmobilesecuritysdk.e.f;
import com.alipay.apmobilesecuritysdk.f.a;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c {
  public static Map<String, String> a(Context paramContext) {
    b b = b.a();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    f f2 = e.a(paramContext);
    String str1 = b.a(paramContext);
    String str2 = b.b(paramContext);
    String str7 = b.k(paramContext);
    String str8 = b.m(paramContext);
    String str3 = str1;
    String str4 = str2;
    String str5 = str7;
    String str6 = str8;
    if (f2 != null) {
      String str = str1;
      if (a.a(str1))
        str = f2.a(); 
      str1 = str2;
      if (a.a(str2))
        str1 = f2.b(); 
      str2 = str7;
      if (a.a(str7))
        str2 = f2.c(); 
      str3 = str;
      str4 = str1;
      str5 = str2;
      str6 = str8;
      if (a.a(str8)) {
        str6 = f2.e();
        str5 = str2;
        str4 = str1;
        str3 = str;
      } 
    } 
    f f1 = new f(str3, str4, str5, "", str6);
    if (paramContext != null)
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imei", f1.a());
        jSONObject.put("imsi", f1.b());
        jSONObject.put("mac", f1.c());
        jSONObject.put("bluetoothmac", f1.d());
        jSONObject.put("gsi", f1.e());
        String str = jSONObject.toString();
        a.a("device_feature_file_name", "device_feature_file_key", str);
        a.a(paramContext, "device_feature_prefs_name", "device_feature_prefs_key", str);
      } catch (Exception exception) {
        a.a(exception);
      }  
    hashMap.put("AD1", str3);
    hashMap.put("AD2", str4);
    hashMap.put("AD3", b.f(paramContext));
    hashMap.put("AD5", b.h(paramContext));
    hashMap.put("AD6", b.i(paramContext));
    hashMap.put("AD7", b.j(paramContext));
    hashMap.put("AD8", str5);
    hashMap.put("AD9", b.l(paramContext));
    hashMap.put("AD10", str6);
    hashMap.put("AD11", b.d());
    hashMap.put("AD12", b.e());
    hashMap.put("AD13", b.f());
    hashMap.put("AD14", b.h());
    hashMap.put("AD15", b.i());
    hashMap.put("AD16", b.j());
    hashMap.put("AD17", "");
    hashMap.put("AD19", b.n(paramContext));
    hashMap.put("AD20", b.k());
    hashMap.put("AD22", "");
    hashMap.put("AD23", b.p(paramContext));
    hashMap.put("AD24", a.g(b.g(paramContext)));
    hashMap.put("AD26", b.e(paramContext));
    hashMap.put("AD27", b.p());
    hashMap.put("AD28", b.r());
    hashMap.put("AD29", b.t());
    hashMap.put("AD30", b.q());
    hashMap.put("AD31", b.s());
    hashMap.put("AD32", b.n());
    hashMap.put("AD33", b.o());
    hashMap.put("AD34", b.r(paramContext));
    hashMap.put("AD35", b.s(paramContext));
    hashMap.put("AD36", b.q(paramContext));
    hashMap.put("AD37", b.m());
    hashMap.put("AD38", b.l());
    hashMap.put("AD39", b.c(paramContext));
    hashMap.put("AD40", b.d(paramContext));
    hashMap.put("AD41", b.b());
    hashMap.put("AD42", b.c());
    hashMap.put("AL3", b.o(paramContext));
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */