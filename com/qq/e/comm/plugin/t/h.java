package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.w.d;

public class h extends i {
  private d.b a;
  
  public h(d.b paramb) {
    this.a = paramb;
  }
  
  public void a(int paramInt, Exception paramException) {
    d.b b1 = this.a;
    if (b1 == null)
      return; 
    b1.a(paramInt, paramException);
  }
  
  public void a(e parame, f paramf) {
    int j;
    if (this.a == null)
      return; 
    if (paramf == null) {
      j = 0;
    } else {
      j = paramf.e();
    } 
    if (j == 200 || j == 204) {
      this.a.a();
      return;
    } 
    this.a.a(j, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */