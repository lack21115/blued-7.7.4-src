package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.f.b.c;
import com.bytedance.sdk.openadsdk.multipro.c.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class m extends b<c.a> {
  private AtomicBoolean a = new AtomicBoolean(false);
  
  private boolean b = true;
  
  public m(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public void a() {
    if (!this.a.getAndSet(true))
      a.a(this.b); 
  }
  
  public void a(c.a parama) {
    if (this.a.get())
      a.a(parama.a(), this.b); 
  }
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */