package com.alibaba.mtl.log.e;

import java.util.Map;

public class s {
  public static void send(Map<String, String> paramMap) {
    try {
      Object object = o.a("com.ut.mini.UTAnalytics", "getInstance");
      if (object != null) {
        object = o.a(object, "getDefaultTracker");
        if (object != null)
          o.a(object, "send", new Object[] { paramMap }, new Class[] { Map.class }); 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */