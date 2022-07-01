package com.qq.e.comm.plugin.w.a;

import android.util.Pair;
import com.qq.e.comm.plugin.util.j;
import org.json.JSONObject;
import yaq.gdtadv;

public class i {
  public static <T> Pair<Boolean, Boolean> a(T paramT, d.a parama, d.b paramb, d.e parame, a parama1) {
    return (Pair<Boolean, Boolean>)gdtadv.getobjresult(84, 1, new Object[] { paramT, parama, paramb, parame, parama1 });
  }
  
  public static <T> Pair<Boolean, Boolean> a(T paramT, d.a parama, d.b paramb, d.e parame, boolean paramBoolean) {
    return (Pair<Boolean, Boolean>)gdtadv.getobjresult(85, 1, new Object[] { paramT, parama, paramb, parame, Boolean.valueOf(paramBoolean) });
  }
  
  private static <T> Pair<Boolean, Boolean> a(T paramT, d.a parama, d.b paramb, d.e parame, boolean paramBoolean, a parama1) {
    return (Pair<Boolean, Boolean>)gdtadv.getobjresult(86, 1, new Object[] { paramT, parama, paramb, parame, Boolean.valueOf(paramBoolean), parama1 });
  }
  
  public static interface a {
    void a(String param1String, boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */