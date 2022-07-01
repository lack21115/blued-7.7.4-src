package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class DefaultValueFormatter extends ValueFormatter {
  protected DecimalFormat a;
  
  protected int b;
  
  public DefaultValueFormatter(int paramInt) {
    a(paramInt);
  }
  
  public String a(float paramFloat) {
    return this.a.format(paramFloat);
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < paramInt; i++) {
      if (i == 0)
        stringBuffer.append("."); 
      stringBuffer.append("0");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("###,###,###,##0");
    stringBuilder.append(stringBuffer.toString());
    this.a = new DecimalFormat(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\formatter\DefaultValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */