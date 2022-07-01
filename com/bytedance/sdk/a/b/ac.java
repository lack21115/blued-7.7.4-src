package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class ac {
  final a a;
  
  final Proxy b;
  
  final InetSocketAddress c;
  
  public ac(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress) {
    if (parama != null) {
      if (paramProxy != null) {
        if (paramInetSocketAddress != null) {
          this.a = parama;
          this.b = paramProxy;
          this.c = paramInetSocketAddress;
          return;
        } 
        throw new NullPointerException("inetSocketAddress == null");
      } 
      throw new NullPointerException("proxy == null");
    } 
    throw new NullPointerException("address == null");
  }
  
  public a a() {
    return this.a;
  }
  
  public Proxy b() {
    return this.b;
  }
  
  public InetSocketAddress c() {
    return this.c;
  }
  
  public boolean d() {
    return (this.a.i != null && this.b.type() == Proxy.Type.HTTP);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof ac) {
      paramObject = paramObject;
      if (((ac)paramObject).a.equals(this.a) && ((ac)paramObject).b.equals(this.b) && ((ac)paramObject).c.equals(this.c))
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    return ((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Route{");
    stringBuilder.append(this.c);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */