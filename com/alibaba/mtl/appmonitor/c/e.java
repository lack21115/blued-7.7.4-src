package com.alibaba.mtl.appmonitor.c;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends JSONObject implements b {
  public void clean() {
    Iterator<String> iterator = keys();
    if (iterator != null)
      while (iterator.hasNext()) {
        String str = iterator.next();
        try {
          Object object = get(str);
          if (object != null && object instanceof b)
            a.a().a((b)object); 
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
      }  
  }
  
  public void fill(Object... paramVarArgs) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */