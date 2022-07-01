package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class o extends g<c.a> {
  private p<a> m = com.bytedance.sdk.openadsdk.core.o.f();
  
  public o(String paramString1, String paramString2, e<c.a> parame, p<c.a> paramp, g.b paramb, g.a parama) {
    super(paramString1, paramString2, parame, paramp, paramb, parama);
  }
  
  public h a(List<c.a> paramList) {
    if (this.m == null)
      this.m = com.bytedance.sdk.openadsdk.core.o.f(); 
    if (paramList == null || paramList.size() == 0 || !j.a())
      return null; 
    JSONObject jSONObject = new JSONObject();
    try {
      JSONArray jSONArray = new JSONArray();
      Iterator<c.a> iterator = paramList.iterator();
      while (iterator.hasNext())
        jSONArray.put(((c.a)iterator.next()).b); 
      jSONObject.put("stats_list", jSONArray);
    } catch (Exception exception) {}
    return this.m.a(jSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */