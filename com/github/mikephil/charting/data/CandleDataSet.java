package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;

public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
  private float D;
  
  private boolean E;
  
  private float F;
  
  private boolean G;
  
  protected Paint.Style o;
  
  protected Paint.Style p;
  
  protected int q;
  
  protected int r;
  
  protected int s;
  
  protected int t;
  
  public Paint.Style D() {
    return this.p;
  }
  
  public int E() {
    return this.t;
  }
  
  public boolean F() {
    return this.G;
  }
  
  public float a() {
    return this.F;
  }
  
  protected void a(CandleEntry paramCandleEntry) {
    if (paramCandleEntry.c() < this.w)
      this.w = paramCandleEntry.c(); 
    if (paramCandleEntry.a() > this.v)
      this.v = paramCandleEntry.a(); 
    c(paramCandleEntry);
  }
  
  public float b() {
    return this.D;
  }
  
  protected void b(CandleEntry paramCandleEntry) {
    if (paramCandleEntry.a() < this.w)
      this.w = paramCandleEntry.a(); 
    if (paramCandleEntry.a() > this.v)
      this.v = paramCandleEntry.a(); 
    if (paramCandleEntry.c() < this.w)
      this.w = paramCandleEntry.c(); 
    if (paramCandleEntry.c() > this.v)
      this.v = paramCandleEntry.c(); 
  }
  
  public boolean c() {
    return this.E;
  }
  
  public int d() {
    return this.q;
  }
  
  public int e() {
    return this.r;
  }
  
  public int f() {
    return this.s;
  }
  
  public Paint.Style g() {
    return this.o;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\CandleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */