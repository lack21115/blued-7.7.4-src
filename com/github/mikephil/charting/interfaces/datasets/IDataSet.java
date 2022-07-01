package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

public interface IDataSet<T extends com.github.mikephil.charting.data.Entry> {
  MPPointF A();
  
  boolean B();
  
  YAxis.AxisDependency C();
  
  void G();
  
  int H();
  
  float J();
  
  float K();
  
  float L();
  
  float M();
  
  int a(int paramInt);
  
  T a(float paramFloat1, float paramFloat2, DataSet.Rounding paramRounding);
  
  void a(float paramFloat);
  
  void a(float paramFloat1, float paramFloat2);
  
  void a(ValueFormatter paramValueFormatter);
  
  T b(float paramFloat1, float paramFloat2);
  
  GradientColor b(int paramInt);
  
  List<T> b(float paramFloat);
  
  void b(boolean paramBoolean);
  
  int d(int paramInt);
  
  int d(T paramT);
  
  T e(int paramInt);
  
  List<Integer> j();
  
  int k();
  
  GradientColor l();
  
  List<GradientColor> m();
  
  String o();
  
  boolean p();
  
  ValueFormatter q();
  
  boolean r();
  
  Typeface s();
  
  float t();
  
  Legend.LegendForm u();
  
  float v();
  
  float w();
  
  DashPathEffect x();
  
  boolean y();
  
  boolean z();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\interfaces\datasets\IDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */