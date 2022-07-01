package com.qq.e.comm.plugin.y;

import com.qq.e.comm.plugin.util.w;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.gdtadv;

class p {
  private static final AtomicInteger a = new AtomicInteger(1);
  
  static o a(int paramInt, String paramString) {
    return new o(paramInt, paramString);
  }
  
  static o a(g paramg) {
    return (o)gdtadv.getobjresult(5, 1, new Object[] { paramg });
  }
  
  static JSONObject a(List<o> paramList) {
    if (paramList == null || paramList.size() <= 0)
      return null; 
    JSONArray jSONArray = new JSONArray();
    for (int i = 0; i < paramList.size(); i++)
      jSONArray.put((new w(((o)paramList.get(i)).b())).a()); 
    w w = j.a();
    w.a("perfs", jSONArray);
    return w.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */