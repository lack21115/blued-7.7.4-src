package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

public class LimitLine extends ComponentBase {
  private float a;
  
  private float b;
  
  private int c;
  
  private Paint.Style d;
  
  private String e;
  
  private DashPathEffect f;
  
  private LimitLabelPosition g;
  
  public float a() {
    return this.a;
  }
  
  public float b() {
    return this.b;
  }
  
  public int c() {
    return this.c;
  }
  
  public DashPathEffect d() {
    return this.f;
  }
  
  public Paint.Style e() {
    return this.d;
  }
  
  public LimitLabelPosition f() {
    return this.g;
  }
  
  public String g() {
    return this.e;
  }
  
  public enum LimitLabelPosition {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\LimitLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */