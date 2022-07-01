package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.b.a.c;
import java.io.Closeable;
import java.io.InputStream;

public abstract class ab implements Closeable {
  public static ab a(u paramu, long paramLong, e parame) {
    if (parame != null)
      return new ab(paramu, paramLong, parame) {
          public long a() {
            return this.b;
          }
          
          public e b() {
            return this.c;
          }
        }; 
    throw new NullPointerException("source == null");
  }
  
  public static ab a(u paramu, byte[] paramArrayOfbyte) {
    c c = (new c()).b(paramArrayOfbyte);
    return a(paramu, paramArrayOfbyte.length, (e)c);
  }
  
  public abstract long a();
  
  public abstract e b();
  
  public final InputStream c() {
    return b().f();
  }
  
  public void close() {
    c.a((Closeable)b());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */