package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.log.e.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class g extends a<JSONObject> {
  private f e;
  
  protected Map<String, h> o;
  
  protected int q = -1;
  
  public g(f paramf, int paramInt) {
    super(paramInt);
    this.e = paramf;
    this.o = Collections.synchronizedMap(new HashMap<String, h>());
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, Map<String, String> paramMap) {
    Map<String, h> map = this.o;
    if (map != null) {
      h h = map.get(paramString1);
      if (h != null)
        return h.a(paramInt, paramString2, paramMap); 
    } 
    return (paramInt < this.n);
  }
  
  public void b(JSONObject paramJSONObject) {
    a(paramJSONObject);
    c(paramJSONObject);
    this.o.clear();
    try {
      JSONArray jSONArray = paramJSONObject.optJSONArray("metrics");
      if (jSONArray != null)
        for (int i = 0; i < jSONArray.length(); i++) {
          JSONObject jSONObject = jSONArray.getJSONObject(i);
          String str = jSONObject.optString("module");
          if (b.c(str)) {
            h h2 = this.o.get(str);
            h h1 = h2;
            if (h2 == null) {
              h1 = new h(str, this.n);
              this.o.put(str, h1);
            } 
            h1.b(jSONObject);
          } 
        }  
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  protected void c(JSONObject paramJSONObject) {
    i.a("EventTypeSampling", new Object[] { "[updateEventTypeTriggerCount]", this, paramJSONObject });
    if (paramJSONObject == null)
      return; 
    try {
      int i = paramJSONObject.optInt("cacheCount");
    } finally {
      paramJSONObject = null;
    } 
  }
  
  public void setSampling(int paramInt) {
    this.n = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */