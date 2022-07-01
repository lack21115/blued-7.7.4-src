package com.qq.e.comm.plugin.a.d;

import com.qq.e.comm.plugin.util.bh;
import java.util.Iterator;

public class c {
  private final bh<String, a> a = new bh();
  
  public void a(a parama) {
    this.a.a("*", parama);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong) {
    Iterator<a> iterator = this.a.a(paramString).iterator();
    while (iterator.hasNext())
      ((a)iterator.next()).a(paramString, paramInt1, paramInt2, paramLong); 
    iterator = this.a.a("*").iterator();
    while (iterator.hasNext())
      ((a)iterator.next()).a(paramString, paramInt1, paramInt2, paramLong); 
  }
  
  public void a(String paramString, a parama) {
    this.a.a(paramString, parama);
  }
  
  public void b(a parama) {
    b("*", parama);
  }
  
  public void b(String paramString, a parama) {
    this.a.a(paramString, parama);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */