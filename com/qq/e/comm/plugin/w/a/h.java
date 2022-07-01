package com.qq.e.comm.plugin.w.a;

import android.content.Context;
import android.util.Pair;
import yaq.gdtadv;

public class h {
  static int a(Context paramContext, d.a parama, String paramString1, String paramString2, boolean paramBoolean) {
    return gdtadv.getIresult(111, 1, new Object[] { paramContext, parama, paramString1, paramString2, Boolean.valueOf(paramBoolean) });
  }
  
  public static String a(String paramString) {
    return (String)gdtadv.getobjresult(112, 1, new Object[] { paramString });
  }
  
  static String a(String paramString, d.a parama, d.e parame, d.b paramb) {
    return (String)gdtadv.getobjresult(113, 1, new Object[] { paramString, parama, parame, paramb });
  }
  
  static <T> void a(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame, boolean paramBoolean) {
    gdtadv.getVresult(114, 1, new Object[] { paramT, paramContext, parama, paramb, parame, Boolean.valueOf(paramBoolean) });
  }
  
  static <T> void a(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame, boolean paramBoolean1, boolean paramBoolean2) {
    gdtadv.getVresult(115, 1, new Object[] { paramT, paramContext, parama, paramb, parame, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  private static boolean a(d.a parama, d.b paramb, d.e parame, String paramString) {
    return gdtadv.getZresult(116, 1, new Object[] { parama, paramb, parame, paramString });
  }
  
  static <T> boolean a(T paramT, Context paramContext, d.a parama, d.b paramb, d.e parame) {
    return gdtadv.getZresult(117, 1, new Object[] { paramT, paramContext, parama, paramb, parame });
  }
  
  private static Pair<String, String> b(String paramString, d.a parama, d.e parame, d.b paramb) {
    return (Pair<String, String>)gdtadv.getobjresult(118, 1, new Object[] { paramString, parama, parame, paramb });
  }
  
  private static String b(String paramString) {
    return (String)gdtadv.getobjresult(119, 1, new Object[] { paramString });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */