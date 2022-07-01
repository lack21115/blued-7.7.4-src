package com.qq.e.comm.plugin.s;

import org.json.JSONObject;

public class i {
  private int a;
  
  public static i a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optJSONObject("ssp_ext");
      if (paramJSONObject != null) {
        i i1 = new i();
        i1.a(paramJSONObject.optInt("priority"));
        return i1;
      } 
    } 
    return null;
  }
  
  public static int b(JSONObject paramJSONObject) {
    int j = -1;
    if (paramJSONObject == null)
      return -1; 
    paramJSONObject = paramJSONObject.optJSONObject("ssp_ext");
    if (paramJSONObject != null)
      j = paramJSONObject.optInt("priority", -1); 
    return j;
  }
  
  public int a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\s\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */