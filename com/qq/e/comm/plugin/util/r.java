package com.qq.e.comm.plugin.util;

import android.net.http.SslError;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;

public class r {
  public static void a(SslError paramSslError) {
    if (paramSslError != null && au.d()) {
      d d = new d();
      d.a("sslError", paramSslError.toString());
      u.a(90032, 0, null, d);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */