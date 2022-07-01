package com.qiniu.pili.droid.shortvideo.gl.a;

import android.util.Log;

public class e {
  private static int e = 12375;
  
  private static int f = 12374;
  
  protected d a;
  
  private Object b = null;
  
  private int c = -1;
  
  private int d = -1;
  
  protected e(d paramd) {
    this.a = paramd;
  }
  
  public void a() {
    this.a.a(this.b);
    this.b = null;
    this.d = -1;
    this.c = -1;
  }
  
  public void a(long paramLong) {
    this.a.a(this.b, paramLong);
  }
  
  public void a(Object paramObject) {
    if (this.b == null) {
      this.b = this.a.b(paramObject);
      return;
    } 
    throw new IllegalStateException("surface already created");
  }
  
  public void b() {
    this.a.c(this.b);
  }
  
  public boolean c() {
    boolean bool = this.a.d(this.b);
    if (!bool)
      Log.d("EglSurfaceBase", "WARNING: swapBuffers() failed"); 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */