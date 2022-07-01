package com.qq.e.comm.plugin.w;

import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.k.b;
import com.qq.e.comm.plugin.t.b;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.d;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  public static JSONObject a(JSONObject paramJSONObject, long paramLong) {
    if (paramLong > 0L) {
      j j = d.d(paramJSONObject);
      if (!StringUtil.isEmpty(j.i()) && !StringUtil.isEmpty(j.j())) {
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("name", j.i());
          jSONObject.put("iconurl", j.j());
          return jSONObject;
        } catch (JSONException jSONException) {
          GDTLogger.e("ExceptionWhileLoadAPPDetail", (Throwable)jSONException);
        } 
      } 
      String str = paramJSONObject.optString("productid");
      int i = paramJSONObject.optInt("producttype");
      Exchanger<JSONObject> exchanger = new Exchanger();
      a(str, i, new a(exchanger, paramLong) {
            public void a(b param1b) {
              try {
                this.a.exchange(null, this.b, TimeUnit.MICROSECONDS);
                return;
              } catch (Exception exception) {
                GDTLogger.e("ExceptionWhileLoadAPPDetail", exception);
                return;
              } 
            }
            
            public void a(JSONObject param1JSONObject) {
              if (param1JSONObject != null)
                try {
                  this.a.exchange(param1JSONObject.optJSONObject("data"), this.b, TimeUnit.MICROSECONDS);
                  return;
                } catch (Exception exception) {
                  GDTLogger.e("ExceptionWhileLoadAPPDetail", exception);
                  return;
                }  
              this.a.exchange(null, this.b, TimeUnit.MICROSECONDS);
            }
          });
      try {
        return exchanger.exchange(null, paramLong, TimeUnit.MILLISECONDS);
      } catch (Exception exception) {
        GDTLogger.w("LoadAPPDetailInfoTimeOut");
        return null;
      } 
    } 
    throw new Error("TimeOut shouldNot <=0 for loadAPPDetailInfoSyn method");
  }
  
  public static void a(String paramString, int paramInt, a parama) {
    if (parama == null) {
      GDTLogger.e("Callback == null while loadAPKDetail");
      return;
    } 
    String str = d.a(paramString, paramInt);
    if (StringUtil.isEmpty(str)) {
      parama.a(new b(String.format("Detail URL is null for product(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt) }), 503));
      return;
    } 
    b b = new b(parama) {
        public void a(e param1e, f param1f) {
          try {
            return;
          } finally {
            param1e = null;
            this.a.a(new b((Throwable)param1e, 605));
          } 
        }
        
        public void a(Exception param1Exception) {
          this.a.a(new b(param1Exception, 400));
        }
      };
    com.qq.e.comm.plugin.t.b.c c1 = new com.qq.e.comm.plugin.t.b.c(str, e.a.a, null);
    ak.a("gdt_tag_net", ak.a((e)c1));
    d.a().a((e)c1, com.qq.e.comm.plugin.t.c.a.a, b);
  }
  
  public static interface a {
    void a(b param1b);
    
    void a(JSONObject param1JSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */