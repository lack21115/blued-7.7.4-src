package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase extends ComponentBase {
  private int C = -7829368;
  
  private float D = 1.0F;
  
  private int E = -7829368;
  
  private float F = 1.0F;
  
  private int G = 6;
  
  private DashPathEffect H = null;
  
  private DashPathEffect I = null;
  
  protected ValueFormatter a;
  
  public float[] b = new float[0];
  
  public float[] c = new float[0];
  
  public int d;
  
  public int e;
  
  protected float f = 1.0F;
  
  protected boolean g = false;
  
  protected boolean h = false;
  
  protected boolean i = true;
  
  protected boolean j = true;
  
  protected boolean k = true;
  
  protected boolean l = false;
  
  protected List<LimitLine> m = new ArrayList<LimitLine>();
  
  protected boolean n = false;
  
  protected boolean o = true;
  
  protected float p = 0.0F;
  
  protected float q = 0.0F;
  
  protected boolean r = false;
  
  protected boolean s = false;
  
  public float t = 0.0F;
  
  public float u = 0.0F;
  
  public float v = 0.0F;
  
  public void a(float paramFloat) {
    this.F = Utils.a(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    if (this.r) {
      paramFloat1 = this.u;
    } else {
      paramFloat1 -= this.p;
    } 
    if (this.s) {
      paramFloat2 = this.t;
    } else {
      paramFloat2 += this.q;
    } 
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (Math.abs(paramFloat2 - paramFloat1) == 0.0F) {
      f1 = paramFloat2 + 1.0F;
      f2 = paramFloat1 - 1.0F;
    } 
    this.u = f2;
    this.t = f1;
    this.v = Math.abs(f1 - f2);
  }
  
  public void a(int paramInt) {
    this.E = paramInt;
  }
  
  public void a(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public boolean a() {
    return this.i;
  }
  
  public String b(int paramInt) {
    return (paramInt < 0 || paramInt >= this.b.length) ? "" : q().a(this.b[paramInt], this);
  }
  
  public void b(float paramFloat) {
    this.s = true;
    this.t = paramFloat;
    this.v = Math.abs(paramFloat - this.u);
  }
  
  public void b(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public boolean b() {
    return this.j;
  }
  
  public void c(float paramFloat) {
    this.p = paramFloat;
  }
  
  public void c(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public boolean c() {
    return (this.l && this.d > 0);
  }
  
  public int d() {
    return this.C;
  }
  
  public void d(float paramFloat) {
    this.q = paramFloat;
  }
  
  public float e() {
    return this.F;
  }
  
  public float f() {
    return this.D;
  }
  
  public int g() {
    return this.E;
  }
  
  public boolean h() {
    return this.k;
  }
  
  public boolean i() {
    return this.h;
  }
  
  public int j() {
    return this.G;
  }
  
  public boolean k() {
    return this.g;
  }
  
  public float l() {
    return this.f;
  }
  
  public List<LimitLine> m() {
    return this.m;
  }
  
  public boolean n() {
    return this.n;
  }
  
  public boolean o() {
    return this.o;
  }
  
  public String p() {
    String str = "";
    int i = 0;
    while (i < this.b.length) {
      String str2 = b(i);
      String str1 = str;
      if (str2 != null) {
        str1 = str;
        if (str.length() < str2.length())
          str1 = str2; 
      } 
      i++;
      str = str1;
    } 
    return str;
  }
  
  public ValueFormatter q() {
    ValueFormatter valueFormatter = this.a;
    if (valueFormatter == null || (valueFormatter instanceof DefaultAxisValueFormatter && ((DefaultAxisValueFormatter)valueFormatter).a() != this.e))
      this.a = (ValueFormatter)new DefaultAxisValueFormatter(this.e); 
    return this.a;
  }
  
  public DashPathEffect r() {
    return this.I;
  }
  
  public DashPathEffect s() {
    return this.H;
  }
  
  public float t() {
    return this.u;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\AxisBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */