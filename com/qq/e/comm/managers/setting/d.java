package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;

class d extends e {
  d() {}
  
  d(String paramString) {
    super(paramString);
  }
  
  final Object a(String paramString) {
    return this.a.opt(paramString);
  }
  
  final void a(String paramString, Object paramObject) {
    try {
      this.a.putOpt(paramString, paramObject);
      return;
    } catch (JSONException jSONException) {
      GDTLogger.e("Exception while update setting", (Throwable)jSONException);
      return;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("GDTSDKSetting[");
    stringBuilder.append(this.a.toString());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\setting\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */