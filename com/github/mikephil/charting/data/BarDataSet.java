package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
  private int o;
  
  private int p;
  
  private float q;
  
  private int r;
  
  private int s;
  
  private String[] t;
  
  public int a() {
    return this.o;
  }
  
  protected void a(BarEntry paramBarEntry) {
    if (paramBarEntry != null && !Float.isNaN(paramBarEntry.b())) {
      if (paramBarEntry.a() == null) {
        if (paramBarEntry.b() < this.w)
          this.w = paramBarEntry.b(); 
        if (paramBarEntry.b() > this.v)
          this.v = paramBarEntry.b(); 
      } else {
        if (-paramBarEntry.f() < this.w)
          this.w = -paramBarEntry.f(); 
        if (paramBarEntry.e() > this.v)
          this.v = paramBarEntry.e(); 
      } 
      c(paramBarEntry);
    } 
  }
  
  public boolean b() {
    return (this.o > 1);
  }
  
  public int c() {
    return this.p;
  }
  
  public float d() {
    return this.q;
  }
  
  public int e() {
    return this.r;
  }
  
  public int f() {
    return this.s;
  }
  
  public String[] g() {
    return this.t;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\BarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */