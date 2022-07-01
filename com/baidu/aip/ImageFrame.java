package com.baidu.aip;

import com.baidu.aip.face.ArgbPool;

public class ImageFrame {
  private int[] argb;
  
  private int height;
  
  private ArgbPool pool;
  
  private boolean retained = false;
  
  private int width;
  
  public ImageFrame() {}
  
  public ImageFrame(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    this.argb = paramArrayOfint;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public int[] getArgb() {
    return this.argb;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public ArgbPool getPool() {
    return this.pool;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public void release() {
    this.retained = false;
  }
  
  public void retain() {
    this.retained = true;
  }
  
  public void setArgb(int[] paramArrayOfint) {
    this.argb = paramArrayOfint;
  }
  
  public void setHeight(int paramInt) {
    this.height = paramInt;
  }
  
  public void setPool(ArgbPool paramArgbPool) {
    this.pool = paramArgbPool;
  }
  
  public void setWidth(int paramInt) {
    this.width = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\ImageFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */