package com.amap.api.mapcore2d;

import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;

abstract class bj<T, V> extends ew {
  protected boolean a = false;
  
  protected T b;
  
  private int f = 1;
  
  private int g = 0;
  
  public bj() {
    this.f = 1;
    this.g = 2;
  }
  
  public bj(T paramT) {
    this();
    this.b = paramT;
  }
  
  private V b(byte[] paramArrayOfbyte) throws AMapException {
    return a(paramArrayOfbyte);
  }
  
  private V e() throws AMapException {
    try {
      return b(b());
    } catch (AMapException aMapException) {
      d();
      throw new AMapException(aMapException.getErrorMessage());
    } finally {
      Exception exception = null;
      cm.a(exception, "ProtocalHandler", "GetDataMayThrow");
    } 
  }
  
  public V a() throws AMapException {
    return (this.b != null) ? e() : null;
  }
  
  protected abstract V a(byte[] paramArrayOfbyte) throws AMapException;
  
  protected byte[] b() throws AMapException {
    int i = 0;
    while (true) {
      if (i < this.f)
        try {
          return c();
        } catch (cp cp) {
          if (++i < this.f) {
            try {
              Thread.sleep((this.g * 1000));
              cm.a(cp, "ProtocalHandler", "getData");
            } catch (InterruptedException interruptedException) {
              throw new AMapException(cp.getMessage());
            } 
            continue;
          } 
          throw new AMapException(cp.a());
        }  
      return null;
    } 
  }
  
  protected byte[] c() throws cp {
    int i = MapsInitializer.getProtocol();
    ev ev = ev.a(false);
    return (i == 1) ? (this.a ? ev.b(this) : ev.d(this)) : ((i == 2) ? (this.a ? ev.a(this) : ev.e(this)) : null);
  }
  
  protected V d() {
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */