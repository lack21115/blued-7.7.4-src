package com.bytedance.embedapplog.a;

import android.content.Context;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.d.b;

class f extends h {
  private boolean b;
  
  f(Context paramContext, i parami, b paramb) {
    super(paramContext, parami, paramb);
  }
  
  long b() {
    return this.b ? Long.MAX_VALUE : 0L;
  }
  
  public boolean d() {
    boolean bool = super.d();
    this.b = bool;
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */