package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.w.a;
import com.qq.e.comm.plugin.w.a.c;

public class n {
  static Intent a(Context paramContext, c paramc) {
    Intent intent2 = paramContext.getPackageManager().getLaunchIntentForPackage(paramc.h());
    String str = paramc.t();
    Intent intent1 = intent2;
    if (bb.b(str)) {
      intent1 = intent2;
      if (c.a(paramContext, paramc.h(), str))
        intent1 = c.a(paramContext, paramc.h(), Uri.parse(c.a(str, paramc.l(), paramc.k()))); 
    } 
    if (intent1 != null)
      intent1.addFlags(268435456); 
    return intent1;
  }
  
  public static void a(c paramc) {
    if (paramc == null)
      return; 
    if (bb.b(paramc.t()))
      a.b(paramc.k()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */