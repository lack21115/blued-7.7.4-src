package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
  protected Drawable o;
  
  private int p = Color.rgb(140, 234, 255);
  
  private int q = 85;
  
  private float r = 2.5F;
  
  private boolean s = false;
  
  public LineRadarDataSet(List<T> paramList, String paramString) {
    super(paramList, paramString);
  }
  
  public int O() {
    return this.p;
  }
  
  public Drawable P() {
    return this.o;
  }
  
  public int Q() {
    return this.q;
  }
  
  public float R() {
    return this.r;
  }
  
  public boolean S() {
    return this.s;
  }
  
  public void a(Drawable paramDrawable) {
    this.o = paramDrawable;
  }
  
  public void d(boolean paramBoolean) {
    this.s = paramBoolean;
  }
  
  public void e(float paramFloat) {
    float f = paramFloat;
    if (paramFloat < 0.0F)
      f = 0.0F; 
    paramFloat = f;
    if (f > 10.0F)
      paramFloat = 10.0F; 
    this.r = Utils.a(paramFloat);
  }
  
  public void g(int paramInt) {
    this.q = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\LineRadarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */