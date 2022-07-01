package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import java.util.concurrent.Future;

public interface c {
  Future<f> a(e parame);
  
  Future<f> a(e parame, a parama);
  
  void a(e parame, a parama, b paramb);
  
  public enum a {
    a(1),
    b(2),
    c(3);
    
    private int d;
    
    a(int param1Int1) {
      this.d = param1Int1;
    }
    
    public int a() {
      return this.d;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */