package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.a.d;
import com.bytedance.sdk.a.b.a.c;
import java.io.IOException;

public abstract class z {
  public static z a(u paramu, byte[] paramArrayOfbyte) {
    return a(paramu, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static z a(u paramu, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte != null) {
      c.a(paramArrayOfbyte.length, paramInt1, paramInt2);
      return new z(paramu, paramInt2, paramArrayOfbyte, paramInt1) {
          public u a() {
            return this.a;
          }
          
          public void a(d param1d) throws IOException {
            param1d.c(this.c, this.d, this.b);
          }
          
          public long b() {
            return this.b;
          }
        };
    } 
    throw new NullPointerException("content == null");
  }
  
  public abstract u a();
  
  public abstract void a(d paramd) throws IOException;
  
  public long b() throws IOException {
    return -1L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */