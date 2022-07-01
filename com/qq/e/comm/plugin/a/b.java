package com.qq.e.comm.plugin.a;

import org.json.JSONObject;
import yaq.gdtadv;

public class b {
  private static String a(int paramInt, c paramc) {
    return (String)gdtadv.getobjresult(32, 1, new Object[] { Integer.valueOf(paramInt), paramc });
  }
  
  private static String a(int paramInt, c paramc, boolean paramBoolean) {
    return (String)gdtadv.getobjresult(33, 1, new Object[] { Integer.valueOf(paramInt), paramc, Boolean.valueOf(paramBoolean) });
  }
  
  public static JSONObject a(c paramc) {
    return (JSONObject)gdtadv.getobjresult(34, 1, new Object[] { paramc });
  }
  
  public static void a(c paramc, boolean paramBoolean) {
    gdtadv.getVresult(35, 1, new Object[] { paramc, Boolean.valueOf(paramBoolean) });
  }
  
  private static boolean b(c paramc) {
    return gdtadv.getZresult(36, 1, new Object[] { paramc });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */