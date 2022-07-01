package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {
  private String a = "DataSet";
  
  protected List<Integer> b = null;
  
  protected GradientColor c = null;
  
  protected List<GradientColor> d = null;
  
  protected List<Integer> e = null;
  
  protected YAxis.AxisDependency f = YAxis.AxisDependency.a;
  
  protected boolean g = true;
  
  protected transient ValueFormatter h;
  
  protected Typeface i;
  
  protected boolean j = true;
  
  protected boolean k = true;
  
  protected MPPointF l = new MPPointF();
  
  protected float m = 17.0F;
  
  protected boolean n = true;
  
  private Legend.LegendForm o = Legend.LegendForm.c;
  
  private float p = Float.NaN;
  
  private float q = Float.NaN;
  
  private DashPathEffect r = null;
  
  public BaseDataSet() {
    this.b = new ArrayList<Integer>();
    this.e = new ArrayList<Integer>();
    this.b.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    this.e.add(Integer.valueOf(-16777216));
  }
  
  public BaseDataSet(String paramString) {
    this();
    this.a = paramString;
  }
  
  public MPPointF A() {
    return this.l;
  }
  
  public boolean B() {
    return this.n;
  }
  
  public YAxis.AxisDependency C() {
    return this.f;
  }
  
  public int a(int paramInt) {
    List<Integer> list = this.b;
    return ((Integer)list.get(paramInt % list.size())).intValue();
  }
  
  public void a(float paramFloat) {
    this.m = Utils.a(paramFloat);
  }
  
  public void a(ValueFormatter paramValueFormatter) {
    if (paramValueFormatter == null)
      return; 
    this.h = paramValueFormatter;
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public GradientColor b(int paramInt) {
    List<GradientColor> list = this.d;
    return list.get(paramInt % list.size());
  }
  
  public void b(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void c(int paramInt) {
    n();
    this.b.add(Integer.valueOf(paramInt));
  }
  
  public int d(int paramInt) {
    List<Integer> list = this.e;
    return ((Integer)list.get(paramInt % list.size())).intValue();
  }
  
  public void i() {
    G();
  }
  
  public List<Integer> j() {
    return this.b;
  }
  
  public int k() {
    return ((Integer)this.b.get(0)).intValue();
  }
  
  public GradientColor l() {
    return this.c;
  }
  
  public List<GradientColor> m() {
    return this.d;
  }
  
  public void n() {
    if (this.b == null)
      this.b = new ArrayList<Integer>(); 
    this.b.clear();
  }
  
  public String o() {
    return this.a;
  }
  
  public boolean p() {
    return this.g;
  }
  
  public ValueFormatter q() {
    return r() ? Utils.a() : this.h;
  }
  
  public boolean r() {
    return (this.h == null);
  }
  
  public Typeface s() {
    return this.i;
  }
  
  public float t() {
    return this.m;
  }
  
  public Legend.LegendForm u() {
    return this.o;
  }
  
  public float v() {
    return this.p;
  }
  
  public float w() {
    return this.q;
  }
  
  public DashPathEffect x() {
    return this.r;
  }
  
  public boolean y() {
    return this.j;
  }
  
  public boolean z() {
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\BaseDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */