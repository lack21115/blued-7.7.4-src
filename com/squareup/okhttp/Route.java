package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route {
  final Address address;
  
  final InetSocketAddress inetSocketAddress;
  
  final Proxy proxy;
  
  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress) {
    if (paramAddress != null) {
      if (paramProxy != null) {
        if (paramInetSocketAddress != null) {
          this.address = paramAddress;
          this.proxy = paramProxy;
          this.inetSocketAddress = paramInetSocketAddress;
          return;
        } 
        throw new NullPointerException("inetSocketAddress == null");
      } 
      throw new NullPointerException("proxy == null");
    } 
    throw new NullPointerException("address == null");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Route;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.address.equals(((Route)paramObject).address)) {
        bool1 = bool2;
        if (this.proxy.equals(((Route)paramObject).proxy)) {
          bool1 = bool2;
          if (this.inetSocketAddress.equals(((Route)paramObject).inetSocketAddress))
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  public Address getAddress() {
    return this.address;
  }
  
  public Proxy getProxy() {
    return this.proxy;
  }
  
  public InetSocketAddress getSocketAddress() {
    return this.inetSocketAddress;
  }
  
  public int hashCode() {
    return ((527 + this.address.hashCode()) * 31 + this.proxy.hashCode()) * 31 + this.inetSocketAddress.hashCode();
  }
  
  public boolean requiresTunnel() {
    return (this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Route.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */