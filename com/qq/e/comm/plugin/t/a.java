package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.a.a;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import java.util.List;

public class a implements a.a {
  private final int a;
  
  private final List<a> b;
  
  private final e c;
  
  public a(int paramInt, List<a> paramList, e parame) {
    this.a = paramInt;
    this.b = paramList;
    this.c = parame;
  }
  
  public e a() {
    return this.c;
  }
  
  public f a(e parame) throws Exception {
    if (this.a >= this.b.size())
      return null; 
    a a1 = new a(this.a + 1, this.b, parame);
    return ((a)this.b.get(this.a)).a(a1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */