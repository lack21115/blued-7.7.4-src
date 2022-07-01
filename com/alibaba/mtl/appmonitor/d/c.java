package com.alibaba.mtl.appmonitor.d;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c extends a<JSONObject> {
  private Map<String, b> n = new HashMap<String, b>();
  
  public c(int paramInt) {
    super(paramInt);
  }
  
  public Boolean a(int paramInt, Map<String, String> paramMap) {
    if (paramMap != null) {
      Map<String, b> map = this.n;
      if (map == null)
        return null; 
      for (String str : map.keySet()) {
        if (!((b)this.n.get(str)).b(paramMap.get(str)))
          return null; 
      } 
      return Boolean.valueOf(a(paramInt));
    } 
    return null;
  }
  
  public void b(JSONObject paramJSONObject) {
    a(paramJSONObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */