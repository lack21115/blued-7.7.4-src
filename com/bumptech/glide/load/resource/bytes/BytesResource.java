package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource<byte[]> {
  private final byte[] a;
  
  public BytesResource(byte[] paramArrayOfbyte) {
    this.a = (byte[])Preconditions.a(paramArrayOfbyte);
  }
  
  public Class<byte[]> a() {
    return byte[].class;
  }
  
  public int b() {
    return this.a.length;
  }
  
  public void c() {}
  
  public byte[] d() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bytes\BytesResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */