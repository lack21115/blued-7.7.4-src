package com.bumptech.glide.load.engine.bitmap_recycle;

public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {
  public int a(byte[] paramArrayOfbyte) {
    return paramArrayOfbyte.length;
  }
  
  public String a() {
    return "ByteArrayPool";
  }
  
  public int b() {
    return 1;
  }
  
  public byte[] b(int paramInt) {
    return new byte[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\ByteArrayAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */