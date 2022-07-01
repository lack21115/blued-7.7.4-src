package com.qq.e.comm.plugin.y;

import com.qq.e.comm.plugin.util.w;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.gdtadv;

class l {
  private static final AtomicInteger a = new AtomicInteger(1);
  
  static k a(int paramInt, String paramString) {
    return new k(paramInt, paramString);
  }
  
  static k a(e parame) {
    return (k)gdtadv.getobjresult(6, 1, new Object[] { parame });
  }
  
  static JSONObject a(List<k> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    JSONArray jSONArray = new JSONArray();
    for (int i = 0; i < paramList.size(); i++)
      jSONArray.put((new w(((k)paramList.get(i)).b())).a()); 
    w w = j.a();
    w.a("events", jSONArray);
    return w.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */