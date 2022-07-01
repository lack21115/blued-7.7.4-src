package com.qq.e.comm.plugin.y;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class b {
  private JSONObject a = new JSONObject();
  
  public JSONObject a() {
    return this.a;
  }
  
  void a(int paramInt) {
    a("seq", Integer.valueOf(paramInt));
  }
  
  void a(long paramLong) {
    a("ts", Long.valueOf(paramLong));
  }
  
  public void a(c paramc) {
    if (paramc != null)
      a("biz", paramc.a()); 
  }
  
  public void a(d paramd) {
    if (paramd != null)
      a("ext", paramd.a()); 
  }
  
  protected void a(String paramString, Object paramObject) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramObject == null)
        return; 
      try {
        this.a.put(paramString, paramObject);
        return;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */