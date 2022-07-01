package com.qiniu.pili.droid.shortvideo.gl.texread;

public class e {
  public static class a {
    private Thread a = Thread.currentThread();
    
    public void a() {
      if (this.a == null)
        this.a = Thread.currentThread(); 
      if (Thread.currentThread() == this.a)
        return; 
      throw new IllegalStateException("Wrong thread");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\texread\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */