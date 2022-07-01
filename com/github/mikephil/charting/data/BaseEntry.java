package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public abstract class BaseEntry {
  private float a = 0.0F;
  
  private Object b = null;
  
  private Drawable c = null;
  
  public BaseEntry() {}
  
  public BaseEntry(float paramFloat) {
    this.a = paramFloat;
  }
  
  public BaseEntry(float paramFloat, Object paramObject) {
    this(paramFloat);
    this.b = paramObject;
  }
  
  public void a(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void a(Object paramObject) {
    this.b = paramObject;
  }
  
  public float b() {
    return this.a;
  }
  
  public Drawable g() {
    return this.c;
  }
  
  public Object h() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\BaseEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */