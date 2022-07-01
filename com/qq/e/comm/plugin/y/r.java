package com.qq.e.comm.plugin.y;

import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import java.util.concurrent.Future;
import org.json.JSONObject;
import yaq.gdtadv;

class r {
  private static e a(String paramString1, String paramString2) {
    return (e)gdtadv.getobjresult(9, 1, new Object[] { paramString1, paramString2 });
  }
  
  private static Future<f> a(String paramString, JSONObject paramJSONObject) {
    return (Future<f>)gdtadv.getobjresult(10, 1, new Object[] { paramString, paramJSONObject });
  }
  
  static Future<f> a(JSONObject paramJSONObject) {
    return (Future<f>)gdtadv.getobjresult(11, 1, new Object[] { paramJSONObject });
  }
  
  static Future<f> b(JSONObject paramJSONObject) {
    return (Future<f>)gdtadv.getobjresult(12, 1, new Object[] { paramJSONObject });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */