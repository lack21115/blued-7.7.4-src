package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.p;
import java.io.UnsupportedEncodingException;

public abstract class g<T> extends Request<T> {
  private static final String c = String.format("application/json; charset=%s", new Object[] { "utf-8" });
  
  private final Object d = new Object();
  
  private n.a<T> e;
  
  private final String f;
  
  public g(int paramInt, String paramString1, String paramString2, n.a<T> parama) {
    super(paramInt, paramString1, parama);
    this.e = parama;
    this.f = paramString2;
  }
  
  public abstract n<T> a(j paramj);
  
  public void a(n<T> paramn) {
    synchronized (this.d) {
      n.a<T> a1 = this.e;
      if (a1 != null)
        a1.a(paramn); 
      return;
    } 
  }
  
  public void cancel() {
    super.cancel();
    synchronized (this.d) {
      this.e = null;
      return;
    } 
  }
  
  public byte[] getBody() {
    try {
      return (this.f == null) ? null : this.f.getBytes("utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      p.d("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[] { this.f, "utf-8" });
      return null;
    } 
  }
  
  public String getBodyContentType() {
    return c;
  }
  
  @Deprecated
  public byte[] getPostBody() {
    return getBody();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */