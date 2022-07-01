package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
  private float D = 0.2F;
  
  private DashPathEffect E = null;
  
  private IFillFormatter F = (IFillFormatter)new DefaultFillFormatter();
  
  private boolean G = true;
  
  private boolean H = true;
  
  private Mode p = Mode.a;
  
  private List<Integer> q = null;
  
  private int r = -1;
  
  private float s = 8.0F;
  
  private float t = 4.0F;
  
  public LineDataSet(List<Entry> paramList, String paramString) {
    super(paramList, paramString);
    if (this.q == null)
      this.q = new ArrayList<Integer>(); 
    this.q.clear();
    this.q.add(Integer.valueOf(Color.rgb(140, 234, 255)));
  }
  
  public int D() {
    return this.q.size();
  }
  
  public int E() {
    return this.r;
  }
  
  public boolean F() {
    return this.H;
  }
  
  public IFillFormatter N() {
    return this.F;
  }
  
  public Mode a() {
    return this.p;
  }
  
  public void a(Mode paramMode) {
    this.p = paramMode;
  }
  
  public void a(IFillFormatter paramIFillFormatter) {
    if (paramIFillFormatter == null) {
      this.F = (IFillFormatter)new DefaultFillFormatter();
      return;
    } 
    this.F = paramIFillFormatter;
  }
  
  public float b() {
    return this.D;
  }
  
  public float c() {
    return this.s;
  }
  
  public void c(float paramFloat) {
    float f = paramFloat;
    if (paramFloat > 1.0F)
      f = 1.0F; 
    paramFloat = f;
    if (f < 0.05F)
      paramFloat = 0.05F; 
    this.D = paramFloat;
  }
  
  public void c(boolean paramBoolean) {
    this.G = paramBoolean;
  }
  
  public float d() {
    return this.t;
  }
  
  public void d(float paramFloat) {
    if (paramFloat >= 1.0F) {
      this.s = Utils.a(paramFloat);
      return;
    } 
    Log.e("LineDataSet", "Circle radius cannot be < 1");
  }
  
  public boolean e() {
    return !(this.E == null);
  }
  
  public int f(int paramInt) {
    return ((Integer)this.q.get(paramInt)).intValue();
  }
  
  public DashPathEffect f() {
    return this.E;
  }
  
  public boolean g() {
    return this.G;
  }
  
  public enum Mode {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\LineDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */