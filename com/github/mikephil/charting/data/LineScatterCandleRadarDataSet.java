package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineScatterCandleRadarDataSet<T extends Entry> extends BarLineScatterCandleBubbleDataSet<T> implements ILineScatterCandleRadarDataSet<T> {
  protected boolean A = true;
  
  protected float B = 0.5F;
  
  protected DashPathEffect C = null;
  
  protected boolean z = true;
  
  public LineScatterCandleRadarDataSet(List<T> paramList, String paramString) {
    super(paramList, paramString);
    this.B = Utils.a(0.5F);
  }
  
  public boolean T() {
    return this.z;
  }
  
  public boolean U() {
    return this.A;
  }
  
  public float V() {
    return this.B;
  }
  
  public DashPathEffect W() {
    return this.C;
  }
  
  public void e(boolean paramBoolean) {
    this.A = paramBoolean;
  }
  
  public void f(boolean paramBoolean) {
    this.z = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\LineScatterCandleRadarDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */