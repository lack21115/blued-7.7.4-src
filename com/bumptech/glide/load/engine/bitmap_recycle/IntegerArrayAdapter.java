package com.bumptech.glide.load.engine.bitmap_recycle;

public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {
  public int a(int[] paramArrayOfint) {
    return paramArrayOfint.length;
  }
  
  public String a() {
    return "IntegerArrayPool";
  }
  
  public int b() {
    return 4;
  }
  
  public int[] b(int paramInt) {
    return new int[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\IntegerArrayAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */