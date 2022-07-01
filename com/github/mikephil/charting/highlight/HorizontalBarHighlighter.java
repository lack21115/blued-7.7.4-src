package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

public class HorizontalBarHighlighter extends BarHighlighter {
  public HorizontalBarHighlighter(BarDataProvider paramBarDataProvider) {
    super(paramBarDataProvider);
  }
  
  protected float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return Math.abs(paramFloat2 - paramFloat4);
  }
  
  public Highlight a(float paramFloat1, float paramFloat2) {
    BarData barData = this.a.getBarData();
    MPPointD mPPointD = b(paramFloat2, paramFloat1);
    Highlight highlight = a((float)mPPointD.b, paramFloat2, paramFloat1);
    if (highlight == null)
      return null; 
    IBarDataSet iBarDataSet = (IBarDataSet)barData.a(highlight.f());
    if (iBarDataSet.b())
      return a(highlight, iBarDataSet, (float)mPPointD.b, (float)mPPointD.a); 
    MPPointD.a(mPPointD);
    return highlight;
  }
  
  protected List<Highlight> a(IDataSet paramIDataSet, int paramInt, float paramFloat, DataSet.Rounding paramRounding) {
    ArrayList<Highlight> arrayList = new ArrayList();
    List list2 = paramIDataSet.b(paramFloat);
    List list1 = list2;
    if (list2.size() == 0) {
      Entry entry = paramIDataSet.a(paramFloat, Float.NaN, paramRounding);
      list1 = list2;
      if (entry != null)
        list1 = paramIDataSet.b(entry.i()); 
    } 
    if (list1.size() == 0)
      return arrayList; 
    for (Entry entry : list1) {
      MPPointD mPPointD = this.a.a(paramIDataSet.C()).b(entry.b(), entry.i());
      arrayList.add(new Highlight(entry.i(), entry.b(), (float)mPPointD.a, (float)mPPointD.b, paramInt, paramIDataSet.C()));
    } 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\HorizontalBarHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */