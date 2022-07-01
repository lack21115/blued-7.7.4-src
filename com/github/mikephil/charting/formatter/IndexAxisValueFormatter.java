package com.github.mikephil.charting.formatter;

public class IndexAxisValueFormatter extends ValueFormatter {
  private String[] a = new String[0];
  
  private int b = 0;
  
  public String a(float paramFloat) {
    int i = Math.round(paramFloat);
    return (i < 0 || i >= this.b || i != (int)paramFloat) ? "" : this.a[i];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\formatter\IndexAxisValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */