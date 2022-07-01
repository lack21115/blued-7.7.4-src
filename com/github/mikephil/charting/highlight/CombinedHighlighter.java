package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {
  protected BarHighlighter c;
  
  public CombinedHighlighter(CombinedDataProvider paramCombinedDataProvider, BarDataProvider paramBarDataProvider) {
    super(paramCombinedDataProvider);
    BarHighlighter barHighlighter;
    if (paramBarDataProvider.getBarData() == null) {
      paramCombinedDataProvider = null;
    } else {
      barHighlighter = new BarHighlighter(paramBarDataProvider);
    } 
    this.c = barHighlighter;
  }
  
  protected List<Highlight> b(float paramFloat1, float paramFloat2, float paramFloat3) {
    this.b.clear();
    List<ChartData> list = this.a.getCombinedData().p();
    int i;
    for (i = 0; i < list.size(); i++) {
      Highlight highlight;
      ChartData chartData = list.get(i);
      BarHighlighter barHighlighter = this.c;
      if (barHighlighter != null && chartData instanceof com.github.mikephil.charting.data.BarData) {
        highlight = barHighlighter.a(paramFloat2, paramFloat3);
        if (highlight != null) {
          highlight.a(i);
          this.b.add(highlight);
        } 
      } else {
        int k = highlight.d();
        int j;
        for (j = 0; j < k; j++) {
          IDataSet iDataSet = ((BarLineScatterCandleBubbleData)list.get(i)).a(j);
          if (iDataSet.p())
            for (Highlight highlight1 : a(iDataSet, j, paramFloat1, DataSet.Rounding.c)) {
              highlight1.a(i);
              this.b.add(highlight1);
            }  
        } 
      } 
    } 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\CombinedHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */