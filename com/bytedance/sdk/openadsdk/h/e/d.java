package com.bytedance.sdk.openadsdk.h.e;

import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.h;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.openadsdk.g.e;
import java.io.IOException;

public class d implements b {
  private IHttpStack a = e.a();
  
  public d() {
    if (this.a == null)
      this.a = (IHttpStack)new h(); 
  }
  
  public a a(f paramf) throws IOException, VAdError {
    e e = new e(paramf.a, paramf.b);
    if (paramf.c != -1L)
      e.setRetryPolicy((com.bytedance.sdk.adnet.face.d)(new e()).a((int)paramf.c)); 
    return new g(this.a.a(e, paramf.e), paramf);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */