package com.qq.e.ads.nativ;

public class ADSize {
  public static final int AUTO_HEIGHT = -2;
  
  public static final int FULL_WIDTH = -1;
  
  private int a;
  
  private int b;
  
  public ADSize(int paramInt1, int paramInt2) {
    this.b = paramInt2;
    this.a = paramInt1;
  }
  
  public int getHeight() {
    return this.b;
  }
  
  public int getWidth() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\ADSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */