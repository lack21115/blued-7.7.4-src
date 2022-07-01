package com.github.mikephil.charting.buffer;

public abstract class AbstractBuffer<T> {
  protected int a = 0;
  
  public final float[] b;
  
  protected float c = 1.0F;
  
  protected float d = 1.0F;
  
  protected int e = 0;
  
  protected int f = 0;
  
  public AbstractBuffer(int paramInt) {
    this.a = 0;
    this.b = new float[paramInt];
  }
  
  public void a() {
    this.a = 0;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  public int b() {
    return this.b.length;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\buffer\AbstractBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */