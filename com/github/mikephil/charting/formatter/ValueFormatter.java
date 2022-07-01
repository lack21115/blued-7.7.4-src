package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;

public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
  public String a(float paramFloat) {
    return String.valueOf(paramFloat);
  }
  
  public String a(float paramFloat, AxisBase paramAxisBase) {
    return a(paramFloat);
  }
  
  public String a(float paramFloat, BarEntry paramBarEntry) {
    return a(paramFloat);
  }
  
  public String a(float paramFloat, PieEntry paramPieEntry) {
    return a(paramFloat);
  }
  
  public String a(BarEntry paramBarEntry) {
    return a(paramBarEntry.b());
  }
  
  public String a(BubbleEntry paramBubbleEntry) {
    return a(paramBubbleEntry.a());
  }
  
  public String a(CandleEntry paramCandleEntry) {
    return a(paramCandleEntry.a());
  }
  
  public String a(Entry paramEntry) {
    return a(paramEntry.b());
  }
  
  public String a(RadarEntry paramRadarEntry) {
    return a(paramRadarEntry.b());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\formatter\ValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */