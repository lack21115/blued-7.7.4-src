package com.qq.e.comm.plugin.ab.c;

import com.qq.e.comm.plugin.ab.b.d;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.services.RetCodeService;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class n implements e {
  private n() {}
  
  public static n a() {
    return a.a;
  }
  
  private void a(JSONObject paramJSONObject) {
    try {
      RetCodeService.RetCodeInfo retCodeInfo = new RetCodeService.RetCodeInfo(paramJSONObject.getString("host"), paramJSONObject.getString("cgi"), paramJSONObject.getString("jsver"), paramJSONObject.getInt("code"), paramJSONObject.getInt("duration"), paramJSONObject.optInt("reqsize", 0), paramJSONObject.optInt("rspsize", 0), paramJSONObject.optInt("type"));
      RetCodeService.getInstance().send(retCodeInfo);
      return;
    } catch (JSONException jSONException) {
      GDTLogger.report("Exception While sendingRetCode", (Throwable)jSONException);
      return;
    } 
  }
  
  public void a(h paramh, d paramd) {
    a(paramd.d());
  }
  
  public String b() {
    return "sendRetCode";
  }
  
  static class a {
    static n a = new n();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */