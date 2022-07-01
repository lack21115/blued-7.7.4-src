package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.g;

public class UTDevice {
  private static String d(Context paramContext) {
    a a = b.b(paramContext);
    return (a == null || g.a(a.f())) ? "ffffffffffffffffffffffff" : a.f();
  }
  
  private static String e(Context paramContext) {
    String str = c.a(paramContext).h();
    if (str != null) {
      String str1 = str;
      return g.a(str) ? "ffffffffffffffffffffffff" : str1;
    } 
    return "ffffffffffffffffffffffff";
  }
  
  @Deprecated
  public static String getUtdid(Context paramContext) {
    return d(paramContext);
  }
  
  @Deprecated
  public static String getUtdidForUpdate(Context paramContext) {
    return e(paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\device\UTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */