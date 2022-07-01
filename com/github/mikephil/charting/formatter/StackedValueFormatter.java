package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

public class StackedValueFormatter extends ValueFormatter {
  private boolean a;
  
  private String b;
  
  private DecimalFormat c;
  
  public String a(float paramFloat, BarEntry paramBarEntry) {
    if (!this.a) {
      float[] arrayOfFloat = paramBarEntry.a();
      if (arrayOfFloat != null) {
        if (arrayOfFloat[arrayOfFloat.length - 1] == paramFloat) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.c.format(paramBarEntry.b()));
          stringBuilder1.append(this.b);
          return stringBuilder1.toString();
        } 
        return "";
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.c.format(paramFloat));
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\formatter\StackedValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */