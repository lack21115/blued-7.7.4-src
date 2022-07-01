package com.qq.e.comm.plugin.ad;

import org.json.JSONException;
import org.json.JSONObject;

public class f {
  private boolean a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private String f;
  
  public f(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString) {
    this.a = paramBoolean;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramString;
  }
  
  public Object a() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.putOpt("width", Integer.valueOf(this.b));
    jSONObject.putOpt("height", Integer.valueOf(this.c));
    jSONObject.putOpt("visibleWidth", Integer.valueOf(this.d));
    jSONObject.putOpt("visibleHeight", Integer.valueOf(this.e));
    jSONObject.putOpt("description", this.f);
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */