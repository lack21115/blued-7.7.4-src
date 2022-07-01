package com.github.mikephil.charting.data;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ChartData<T extends IDataSet<? extends Entry>> {
  protected float a = -3.4028235E38F;
  
  protected float b = Float.MAX_VALUE;
  
  protected float c = -3.4028235E38F;
  
  protected float d = Float.MAX_VALUE;
  
  protected float e = -3.4028235E38F;
  
  protected float f = Float.MAX_VALUE;
  
  protected float g = -3.4028235E38F;
  
  protected float h = Float.MAX_VALUE;
  
  protected List<T> i = new ArrayList<T>();
  
  public ChartData() {}
  
  public ChartData(T... paramVarArgs) {
    b();
  }
  
  private List<T> a(T[] paramArrayOfT) {
    ArrayList<T> arrayList = new ArrayList();
    int j = paramArrayOfT.length;
    for (int i = 0; i < j; i++)
      arrayList.add(paramArrayOfT[i]); 
    return arrayList;
  }
  
  public float a(YAxis.AxisDependency paramAxisDependency) {
    if (paramAxisDependency == YAxis.AxisDependency.a) {
      float f4 = this.f;
      float f3 = f4;
      if (f4 == Float.MAX_VALUE)
        f3 = this.h; 
      return f3;
    } 
    float f2 = this.h;
    float f1 = f2;
    if (f2 == Float.MAX_VALUE)
      f1 = this.f; 
    return f1;
  }
  
  public Entry a(Highlight paramHighlight) {
    return (paramHighlight.f() >= this.i.size()) ? null : ((IDataSet)this.i.get(paramHighlight.f())).b(paramHighlight.a(), paramHighlight.b());
  }
  
  public T a(int paramInt) {
    List<T> list = this.i;
    return (T)((list == null || paramInt < 0 || paramInt >= list.size()) ? null : (IDataSet)this.i.get(paramInt));
  }
  
  protected T a(List<T> paramList) {
    for (IDataSet iDataSet : paramList) {
      if (iDataSet.C() == YAxis.AxisDependency.a)
        return (T)iDataSet; 
    } 
    return null;
  }
  
  public void a(float paramFloat) {
    Iterator<T> iterator = this.i.iterator();
    while (iterator.hasNext())
      ((IDataSet)iterator.next()).a(paramFloat); 
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    Iterator<T> iterator = this.i.iterator();
    while (iterator.hasNext())
      ((IDataSet)iterator.next()).a(paramFloat1, paramFloat2); 
    c();
  }
  
  protected void a(T paramT) {
    if (this.a < paramT.K())
      this.a = paramT.K(); 
    if (this.b > paramT.J())
      this.b = paramT.J(); 
    if (this.c < paramT.M())
      this.c = paramT.M(); 
    if (this.d > paramT.L())
      this.d = paramT.L(); 
    if (paramT.C() == YAxis.AxisDependency.a) {
      if (this.e < paramT.K())
        this.e = paramT.K(); 
      if (this.f > paramT.J()) {
        this.f = paramT.J();
        return;
      } 
    } else {
      if (this.g < paramT.K())
        this.g = paramT.K(); 
      if (this.h > paramT.J())
        this.h = paramT.J(); 
    } 
  }
  
  public void a(boolean paramBoolean) {
    Iterator<T> iterator = this.i.iterator();
    while (iterator.hasNext())
      ((IDataSet)iterator.next()).b(paramBoolean); 
  }
  
  public float b(YAxis.AxisDependency paramAxisDependency) {
    if (paramAxisDependency == YAxis.AxisDependency.a) {
      float f4 = this.e;
      float f3 = f4;
      if (f4 == -3.4028235E38F)
        f3 = this.g; 
      return f3;
    } 
    float f2 = this.g;
    float f1 = f2;
    if (f2 == -3.4028235E38F)
      f1 = this.e; 
    return f1;
  }
  
  public T b(List<T> paramList) {
    for (IDataSet iDataSet : paramList) {
      if (iDataSet.C() == YAxis.AxisDependency.b)
        return (T)iDataSet; 
    } 
    return null;
  }
  
  public void b() {
    c();
  }
  
  protected void c() {
    List<T> list = this.i;
    if (list == null)
      return; 
    this.a = -3.4028235E38F;
    this.b = Float.MAX_VALUE;
    this.c = -3.4028235E38F;
    this.d = Float.MAX_VALUE;
    Iterator<T> iterator = list.iterator();
    while (iterator.hasNext())
      a(iterator.next()); 
    this.e = -3.4028235E38F;
    this.f = Float.MAX_VALUE;
    this.g = -3.4028235E38F;
    this.h = Float.MAX_VALUE;
    iterator = (Iterator<T>)a(this.i);
    if (iterator != null) {
      this.e = iterator.K();
      this.f = iterator.J();
      for (IDataSet iDataSet : this.i) {
        if (iDataSet.C() == YAxis.AxisDependency.a) {
          if (iDataSet.J() < this.f)
            this.f = iDataSet.J(); 
          if (iDataSet.K() > this.e)
            this.e = iDataSet.K(); 
        } 
      } 
    } 
    iterator = (Iterator<T>)b(this.i);
    if (iterator != null) {
      this.g = iterator.K();
      this.h = iterator.J();
      for (IDataSet iDataSet : this.i) {
        if (iDataSet.C() == YAxis.AxisDependency.b) {
          if (iDataSet.J() < this.h)
            this.h = iDataSet.J(); 
          if (iDataSet.K() > this.g)
            this.g = iDataSet.K(); 
        } 
      } 
    } 
  }
  
  public int d() {
    List<T> list = this.i;
    return (list == null) ? 0 : list.size();
  }
  
  public float e() {
    return this.b;
  }
  
  public float f() {
    return this.a;
  }
  
  public float g() {
    return this.d;
  }
  
  public float h() {
    return this.c;
  }
  
  public List<T> i() {
    return this.i;
  }
  
  public int j() {
    Iterator<T> iterator = this.i.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((IDataSet)iterator.next()).H());
    return i;
  }
  
  public T k() {
    List<T> list = this.i;
    if (list == null || list.isEmpty())
      return null; 
    IDataSet iDataSet = (IDataSet)this.i.get(0);
    for (IDataSet iDataSet1 : this.i) {
      if (iDataSet1.H() > iDataSet.H())
        iDataSet = iDataSet1; 
    } 
    return (T)iDataSet;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\ChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */