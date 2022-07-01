package com.qiniu.pili.droid.shortvideo.f;

public abstract class k implements Runnable {
  private volatile boolean a = false;
  
  private volatile boolean b = false;
  
  private Thread c;
  
  public boolean a() {
    e.a.c(j(), "start +");
    if (this.a) {
      e.a.d(j(), "already started !");
      return false;
    } 
    this.a = true;
    c(false);
    this.c = new Thread(this, j());
    this.c.start();
    e.a.c(j(), "start -");
    return true;
  }
  
  protected void c(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public boolean c() {
    e.a.c(j(), "stop +");
    if (!this.a) {
      e.a.d(j(), "already stopped !");
      return false;
    } 
    c(true);
    this.a = false;
    e.a.c(j(), "stop -");
    return true;
  }
  
  protected abstract String j();
  
  public boolean l() {
    return this.a;
  }
  
  protected boolean m() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */