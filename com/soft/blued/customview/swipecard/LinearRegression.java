package com.soft.blued.customview.swipecard;

public class LinearRegression {
  private final double a;
  
  private final double b;
  
  private final double c;
  
  public double a() {
    return this.a;
  }
  
  public double b() {
    return this.b;
  }
  
  public double c() {
    return this.c;
  }
  
  public String toString() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("");
    stringBuilder1.append(String.format("%.2f N + %.2f", new Object[] { Double.valueOf(b()), Double.valueOf(a()) }));
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("  (R^2 = ");
    stringBuilder2.append(String.format("%.3f", new Object[] { Double.valueOf(c()) }));
    stringBuilder2.append(")");
    return stringBuilder2.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\swipecard\LinearRegression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */