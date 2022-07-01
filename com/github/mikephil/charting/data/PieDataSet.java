package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
  private float A;
  
  private float B;
  
  private float C;
  
  private boolean D;
  
  private float a;
  
  private boolean o;
  
  private float p;
  
  private ValuePosition q;
  
  private ValuePosition r;
  
  private boolean s;
  
  private int t;
  
  private float z;
  
  public float D() {
    return this.A;
  }
  
  public float E() {
    return this.B;
  }
  
  public float F() {
    return this.C;
  }
  
  public boolean N() {
    return this.D;
  }
  
  public float a() {
    return this.a;
  }
  
  protected void a(PieEntry paramPieEntry) {
    if (paramPieEntry == null)
      return; 
    b(paramPieEntry);
  }
  
  public boolean b() {
    return this.o;
  }
  
  public float c() {
    return this.p;
  }
  
  public ValuePosition d() {
    return this.q;
  }
  
  public ValuePosition e() {
    return this.r;
  }
  
  public boolean f() {
    return this.s;
  }
  
  public int g() {
    return this.t;
  }
  
  public float h() {
    return this.z;
  }
  
  public enum ValuePosition {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\PieDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */