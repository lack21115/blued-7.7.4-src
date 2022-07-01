package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class LargeValueFormatter extends ValueFormatter {
  private String[] a = new String[] { "", "k", "m", "b", "t" };
  
  private int b = 5;
  
  private DecimalFormat c = new DecimalFormat("###E00");
  
  private String d = "";
  
  private String a(double paramDouble) {
    String str = this.c.format(paramDouble);
    int i = Character.getNumericValue(str.charAt(str.length() - 1));
    int j = Character.getNumericValue(str.charAt(str.length() - 2));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(j);
    stringBuilder.append("");
    stringBuilder.append(i);
    i = Integer.valueOf(stringBuilder.toString()).intValue();
    str = str.replaceAll("E[0-9][0-9]", this.a[i / 3]);
    while (true) {
      if (str.length() > this.b || str.matches("[0-9]+\\.[a-z]")) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(0, str.length() - 2));
        stringBuilder.append(str.substring(str.length() - 1));
        str = stringBuilder.toString();
        continue;
      } 
      return str;
    } 
  }
  
  public String a(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a(paramFloat));
    stringBuilder.append(this.d);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\formatter\LargeValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */