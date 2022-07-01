package com.bytedance.embedapplog.a;

import android.content.Context;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.d.b;

class g extends j {
  private boolean b;
  
  g(Context paramContext, b paramb, h paramh, i parami) {
    super(paramContext, paramb, paramh, parami);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */