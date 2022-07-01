package com.huawei.updatesdk.a.a.a;

import java.util.ArrayDeque;
import java.util.Queue;

public final class a {
  private static final a b = new a();
  
  private final Queue<byte[]> a = (Queue)new ArrayDeque<byte>(0);
  
  public static a b() {
    return b;
  }
  
  public void a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length == 65536)
      synchronized (this.a) {
        if (this.a.size() < 32 && !this.a.offer(paramArrayOfbyte))
          com.huawei.updatesdk.a.a.b.a.a.a.a("ByteArrayPool", "releaseBytes false"); 
        return;
      }  
  }
  
  public byte[] a() {
    Queue<byte[]> queue;
    byte[] arrayOfByte;
    synchronized (this.a) {
      byte[] arrayOfByte1 = this.a.poll();
      arrayOfByte = arrayOfByte1;
      if (arrayOfByte1 == null)
        arrayOfByte = new byte[65536]; 
      return arrayOfByte;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */