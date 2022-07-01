package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinedChartRenderer extends DataRenderer {
  protected List<DataRenderer> a = new ArrayList<DataRenderer>(5);
  
  protected WeakReference<Chart> b;
  
  protected List<Highlight> c = new ArrayList<Highlight>();
  
  public CombinedChartRenderer(CombinedChart paramCombinedChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.b = new WeakReference(paramCombinedChart);
    b();
  }
  
  public void a() {
    Iterator<DataRenderer> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((DataRenderer)iterator.next()).a(); 
  }
  
  public void a(Canvas paramCanvas) {
    Iterator<DataRenderer> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((DataRenderer)iterator.next()).a(paramCanvas); 
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    Chart chart = this.b.get();
    if (chart == null)
      return; 
    for (DataRenderer dataRenderer : this.a) {
      int i;
      BubbleData bubbleData;
      BarData barData = null;
      if (dataRenderer instanceof BarChartRenderer) {
        barData = ((BarChartRenderer)dataRenderer).a.getBarData();
      } else if (dataRenderer instanceof LineChartRenderer) {
        LineData lineData = ((LineChartRenderer)dataRenderer).a.getLineData();
      } else if (dataRenderer instanceof CandleStickChartRenderer) {
        CandleData candleData = ((CandleStickChartRenderer)dataRenderer).a.getCandleData();
      } else if (dataRenderer instanceof ScatterChartRenderer) {
        ScatterData scatterData = ((ScatterChartRenderer)dataRenderer).a.getScatterData();
      } else if (dataRenderer instanceof BubbleChartRenderer) {
        bubbleData = ((BubbleChartRenderer)dataRenderer).a.getBubbleData();
      } 
      if (bubbleData == null) {
        i = -1;
      } else {
        i = ((CombinedData)chart.getData()).p().indexOf(bubbleData);
      } 
      this.c.clear();
      int k = paramArrayOfHighlight.length;
      int j;
      for (j = 0; j < k; j++) {
        Highlight highlight = paramArrayOfHighlight[j];
        if (highlight.e() == i || highlight.e() == -1)
          this.c.add(highlight); 
      } 
      List<Highlight> list = this.c;
      dataRenderer.a(paramCanvas, list.<Highlight>toArray(new Highlight[list.size()]));
    } 
  }
  
  public void b() {
    this.a.clear();
    CombinedChart combinedChart = (CombinedChart)this.b.get();
    if (combinedChart == null)
      return; 
    for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
      int i = null.a[drawOrder.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i == 5 && combinedChart.getScatterData() != null)
                this.a.add(new ScatterChartRenderer((ScatterDataProvider)combinedChart, this.g, this.o)); 
            } else if (combinedChart.getCandleData() != null) {
              this.a.add(new CandleStickChartRenderer((CandleDataProvider)combinedChart, this.g, this.o));
            } 
          } else if (combinedChart.getLineData() != null) {
            this.a.add(new LineChartRenderer((LineDataProvider)combinedChart, this.g, this.o));
          } 
        } else if (combinedChart.getBubbleData() != null) {
          this.a.add(new BubbleChartRenderer((BubbleDataProvider)combinedChart, this.g, this.o));
        } 
      } else if (combinedChart.getBarData() != null) {
        this.a.add(new BarChartRenderer((BarDataProvider)combinedChart, this.g, this.o));
      } 
    } 
  }
  
  public void b(Canvas paramCanvas) {
    Iterator<DataRenderer> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((DataRenderer)iterator.next()).b(paramCanvas); 
  }
  
  public void c(Canvas paramCanvas) {
    Iterator<DataRenderer> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((DataRenderer)iterator.next()).c(paramCanvas); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\CombinedChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */