package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

public final class x {
  private g a;
  
  private z b;
  
  public x(g paramg) {
    this.a = paramg;
    this.b = new z(this);
  }
  
  public final g a() {
    return this.a;
  }
  
  public final <T> T a(Class<T> paramClass) {
    ClassLoader classLoader = paramClass.getClassLoader();
    y y = new y(this.a, paramClass, this.b);
    return (T)Proxy.newProxyInstance(classLoader, new Class[] { paramClass }, y);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */