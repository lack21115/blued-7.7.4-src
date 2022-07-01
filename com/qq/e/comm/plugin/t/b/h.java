package com.qq.e.comm.plugin.t.b;

import com.qq.e.comm.plugin.util.as;
import java.io.IOException;
import java.net.HttpURLConnection;

public class h extends b {
  public h(HttpURLConnection paramHttpURLConnection) {
    super(paramHttpURLConnection);
  }
  
  public byte[] a() throws IllegalStateException, IOException {
    try {
      return as.b(super.a());
    } catch (com.qq.e.comm.plugin.util.as.b b1) {
      b1.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */