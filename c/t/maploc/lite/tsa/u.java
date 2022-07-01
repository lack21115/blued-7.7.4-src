package c.t.maploc.lite.tsa;

import android.os.Handler;

public abstract class u {
  public volatile boolean h = false;
  
  public abstract void a();
  
  public abstract void a(Handler paramHandler);
  
  public abstract String b();
  
  public final void b(Handler paramHandler) {
    if (this.h)
      return; 
    this.h = true;
    a(paramHandler);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b());
    stringBuilder.append(" [startup]");
  }
  
  public final void f() {
    if (!this.h)
      return; 
    this.h = false;
    a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b());
    stringBuilder.append(" [shutdown]");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\ts\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */