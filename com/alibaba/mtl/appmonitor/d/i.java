package com.alibaba.mtl.appmonitor.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class i extends a<JSONObject> {
  protected List<c> e;
  
  private String p;
  
  public i(String paramString, int paramInt) {
    super(paramInt);
    this.p = paramString;
  }
  
  public boolean a(int paramInt, Map<String, String> paramMap) {
    List<c> list = this.e;
    if (list != null && paramMap != null) {
      Iterator<c> iterator = list.iterator();
      while (iterator.hasNext()) {
        Boolean bool = ((c)iterator.next()).a(paramInt, paramMap);
        if (bool != null)
          return bool.booleanValue(); 
      } 
    } 
    return a(paramInt);
  }
  
  public void b(JSONObject paramJSONObject) {
    a(paramJSONObject);
    try {
      JSONArray jSONArray = paramJSONObject.optJSONArray("extra");
      if (jSONArray != null)
        for (int j = 0; j < jSONArray.length(); j++) {
          JSONObject jSONObject = jSONArray.getJSONObject(j);
          c c = new c(this.n);
          if (this.e == null)
            this.e = new ArrayList<c>(); 
          this.e.add(c);
          c.b(jSONObject);
        }  
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */