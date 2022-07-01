package cn.com.chinatelecom.account.api.b;

import android.os.Handler;
import android.os.Looper;

public abstract class e implements Runnable {
  private static Handler c = new Handler(Looper.getMainLooper());
  
  private boolean a = false;
  
  private long b;
  
  private a d;
  
  public e() {}
  
  public e(long paramLong) {
    this.b = paramLong;
  }
  
  private void e() {
    this.d = new a(this);
    c.postDelayed(this.d, this.b);
  }
  
  public abstract void a();
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void b() {}
  
  public boolean c() {
    return this.a;
  }
  
  public void d() {
    try {
      if (this.d != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void run() {
    if (this.b > 0L)
      e(); 
    a();
  }
  
  static class a implements Runnable {
    private e a;
    
    public a(e param1e) {
      this.a = param1e;
    }
    
    public void run() {
      e e1 = this.a;
      if (e1 != null)
        e1.b(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */