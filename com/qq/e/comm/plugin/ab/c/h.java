package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.b.e;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.c;
import com.qq.e.comm.plugin.ad.d;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements e {
  private h() {}
  
  public static h a() {
    return a.a;
  }
  
  private b a(e parame, JSONObject paramJSONObject, String paramString) {
    String str = paramJSONObject.optString("jsver");
    JSONObject jSONObject = paramJSONObject.optJSONObject("extreq");
    int i = paramJSONObject.optInt("adposcount");
    int j = paramJSONObject.optInt("count");
    int k = paramJSONObject.optInt("posw");
    int m = paramJSONObject.optInt("posh");
    int n = paramJSONObject.optInt("reqtype");
    b b = new b();
    b.a(jSONObject);
    if (i <= 0)
      i = 1; 
    b.c(i);
    if (j > 0) {
      i = j;
    } else {
      i = parame.c();
    } 
    b.d(i);
    b.a(paramString);
    if (k > 0 && m > 0) {
      b.f(k);
      b.g(m);
    } else {
      d d = c.a(parame, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
      b.f(d.a());
      b.g(d.b());
    } 
    if (parame == e.c)
      b.i(n); 
    b.e(2);
    b.h(parame.b());
    b.b(str);
    return b;
  }
  
  private void a(com.qq.e.comm.plugin.ab.h paramh, d paramd, String paramString, b paramb) throws JSONException {
    e e1 = paramh.e().c();
    e.a a = new e.a(this, paramh, paramd) {
        public void a(com.qq.e.comm.plugin.k.a param1a) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          hashMap.put("errorCode", Integer.valueOf(param1a.a()));
          JSONObject jSONObject = new JSONObject(hashMap);
          this.a.b().a(new e(this.b, e.a.b, jSONObject));
        }
        
        public void a(JSONObject param1JSONObject) {
          this.a.b().a(new e(this.b, e.a.a, param1JSONObject.toString()));
        }
      };
    e.a(paramb, new b(paramh.e().a(), e1, paramString), a);
  }
  
  public void a(com.qq.e.comm.plugin.ab.h paramh, d paramd) {
    String str1;
    String str2 = paramd.b();
    e e1 = e.a(str2);
    if (e1 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadAD with error action(adtype)");
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
    } else {
      JSONObject jSONObject = paramd.d();
      if (jSONObject != null)
        try {
          return;
        } finally {
          e1 = null;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Exception occurred while Loading AD,request=");
          stringBuilder.append(paramd);
          GDTLogger.report(stringBuilder.toString(), (Throwable)e1);
          str1.b().a(new e(paramd, e.a.b, "Exception occurred when fetching ad"));
        }  
      str1 = "ParaObj should not be null while loadAD";
    } 
    GDTLogger.e(str1);
  }
  
  public String b() {
    return "loadAD";
  }
  
  static final class a {
    static final h a = new h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */