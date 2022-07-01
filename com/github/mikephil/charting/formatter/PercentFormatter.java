package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

public class PercentFormatter extends ValueFormatter {
  public DecimalFormat a = new DecimalFormat("###,###,##0.0");
  
  private PieChart b;
  
  public String a(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.format(paramFloat));
    stringBuilder.append(" %");
    return stringBuilder.toString();
  }
  
  public String a(float paramFloat, PieEntry paramPieEntry) {
    PieChart pieChart = this.b;
    return (pieChart != null && pieChart.i()) ? a(paramFloat) : this.a.format(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\formatter\PercentFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */