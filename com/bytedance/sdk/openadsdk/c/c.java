package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.multipro.c.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class c extends b<a> {
  private AtomicBoolean a = new AtomicBoolean(false);
  
  public void a() {
    if (!this.a.getAndSet(true))
      a.c(); 
  }
  
  public void a(a parama) {
    if (this.a.get())
      a.a(parama.a()); 
  }
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */