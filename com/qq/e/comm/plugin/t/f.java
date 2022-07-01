package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.b.a;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import java.net.HttpURLConnection;

public class f extends a {
  public f(String paramString, byte[] paramArrayOfbyte) {
    super(paramString, e.a.b, paramArrayOfbyte);
  }
  
  public f a(HttpURLConnection paramHttpURLConnection) {
    return (f)new g(paramHttpURLConnection);
  }
  
  public byte[] a() throws Exception {
    return e.a(super.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */