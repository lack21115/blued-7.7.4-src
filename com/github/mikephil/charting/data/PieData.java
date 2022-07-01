package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

public class PieData extends ChartData<IPieDataSet> {
  public Entry a(Highlight paramHighlight) {
    return a().e((int)paramHighlight.a());
  }
  
  public IPieDataSet a() {
    return this.i.get(0);
  }
  
  public IPieDataSet b(int paramInt) {
    return (paramInt == 0) ? a() : null;
  }
  
  public float l() {
    float f = 0.0F;
    for (int i = 0; i < a().H(); i++)
      f += ((PieEntry)a().e(i)).b(); 
    return f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\PieData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */