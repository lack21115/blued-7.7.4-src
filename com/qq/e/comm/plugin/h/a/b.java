package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import com.qq.e.comm.plugin.h.a;

public abstract class b implements a {
  protected volatile String a;
  
  private volatile boolean b = false;
  
  protected boolean a() {
    return true;
  }
  
  public String b(Context paramContext) {
    if (!a())
      return null; 
    if (!this.b) {
      this.a = c(paramContext);
      this.b = true;
    } 
    return this.a;
  }
  
  protected abstract String c(Context paramContext);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */