package com.bytedance.sdk.adnet.core;

import android.content.Context;
import com.bytedance.sdk.adnet.a;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.adnet.face.b;
import java.io.File;

public class l {
  public static m a(Context paramContext) {
    return a(paramContext, (IHttpStack)null);
  }
  
  public static m a(Context paramContext, IHttpStack paramIHttpStack) {
    IHttpStack iHttpStack = paramIHttpStack;
    if (paramIHttpStack == null)
      iHttpStack = new h(); 
    return a(paramContext, new a(iHttpStack));
  }
  
  private static m a(Context paramContext, b paramb) {
    m m = new m(new f(new File(a.b(paramContext), "reqQueue")), paramb);
    m.a();
    return m;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */