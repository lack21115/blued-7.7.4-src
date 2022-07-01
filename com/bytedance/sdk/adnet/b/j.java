package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.d.c;
import java.io.UnsupportedEncodingException;

public class j extends Request<String> {
  private final Object c = new Object();
  
  private n.a<String> d;
  
  public j(int paramInt, String paramString, n.a<String> parama) {
    super(paramInt, paramString, parama);
    this.d = parama;
  }
  
  public n<String> a(com.bytedance.sdk.adnet.core.j paramj) {
    String str;
    try {
      str = new String(paramj.b, c.a(paramj.c));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str = new String(paramj.b);
    } 
    return n.a(str, c.a(paramj));
  }
  
  public void a(n<String> paramn) {
    synchronized (this.c) {
      n.a<String> a1 = this.d;
      if (a1 != null)
        a1.a(paramn); 
      return;
    } 
  }
  
  public void cancel() {
    super.cancel();
    synchronized (this.c) {
      this.d = null;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */