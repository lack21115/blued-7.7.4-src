package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

public class Highlight {
  private float a = Float.NaN;
  
  private float b = Float.NaN;
  
  private float c;
  
  private float d;
  
  private int e = -1;
  
  private int f;
  
  private int g = -1;
  
  private YAxis.AxisDependency h;
  
  private float i;
  
  private float j;
  
  public Highlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, YAxis.AxisDependency paramAxisDependency) {
    this(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramAxisDependency);
    this.g = paramInt2;
  }
  
  public Highlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, YAxis.AxisDependency paramAxisDependency) {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.f = paramInt;
    this.h = paramAxisDependency;
  }
  
  public float a() {
    return this.a;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.i = paramFloat1;
    this.j = paramFloat2;
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public boolean a(Highlight paramHighlight) {
    return (paramHighlight == null) ? false : ((this.f == paramHighlight.f && this.a == paramHighlight.a && this.g == paramHighlight.g && this.e == paramHighlight.e));
  }
  
  public float b() {
    return this.b;
  }
  
  public float c() {
    return this.c;
  }
  
  public float d() {
    return this.d;
  }
  
  public int e() {
    return this.e;
  }
  
  public int f() {
    return this.f;
  }
  
  public int g() {
    return this.g;
  }
  
  public YAxis.AxisDependency h() {
    return this.h;
  }
  
  public float i() {
    return this.i;
  }
  
  public float j() {
    return this.j;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Highlight, x: ");
    stringBuilder.append(this.a);
    stringBuilder.append(", y: ");
    stringBuilder.append(this.b);
    stringBuilder.append(", dataSetIndex: ");
    stringBuilder.append(this.f);
    stringBuilder.append(", stackIndex (only stacked barentry): ");
    stringBuilder.append(this.g);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\Highlight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */