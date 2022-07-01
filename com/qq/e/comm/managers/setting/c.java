package com.qq.e.comm.managers.setting;

import org.json.JSONObject;

final class c extends e {
  c() {}
  
  c(String paramString) {
    super(paramString);
  }
  
  final Object a(String paramString1, String paramString2) {
    JSONObject jSONObject = this.a.optJSONObject(paramString2);
    return (jSONObject != null) ? jSONObject.opt(paramString1) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\setting\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */