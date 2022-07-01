package com.qq.e.comm.plugin.s;

import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {
  private String a;
  
  private long b;
  
  public static g a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      g g1 = new g();
      g1.a(paramJSONObject.optString("url"));
      g1.a(paramJSONObject.optLong("reporttime"));
      return g1;
    } 
    return null;
  }
  
  public static List<g> a(JSONArray paramJSONArray) {
    ArrayList<Object> arrayList = new ArrayList();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++) {
        Object object = paramJSONArray.opt(i);
        if (object instanceof JSONObject) {
          object = a((JSONObject)object);
          if (object != null)
            arrayList.add(object); 
        } else {
          GDTLogger.e("Slot.parseList error !");
        } 
      }  
    return arrayList;
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */