package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.b.b;
import java.io.IOException;
import java.net.HttpURLConnection;

class g extends b {
  public g(HttpURLConnection paramHttpURLConnection) {
    super(paramHttpURLConnection);
  }
  
  public byte[] a() throws IllegalStateException, IOException {
    try {
      return e.b(super.a());
    } catch (b b1) {
      b1.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */