package com.github.mikephil.charting.utils;

public class MPPointD extends ObjectPool.Poolable {
  private static ObjectPool<MPPointD> c = ObjectPool.a(64, new MPPointD(0.0D, 0.0D));
  
  public double a;
  
  public double b;
  
  static {
    c.a(0.5F);
  }
  
  private MPPointD(double paramDouble1, double paramDouble2) {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public static MPPointD a(double paramDouble1, double paramDouble2) {
    MPPointD mPPointD = c.a();
    mPPointD.a = paramDouble1;
    mPPointD.b = paramDouble2;
    return mPPointD;
  }
  
  public static void a(MPPointD paramMPPointD) {
    c.a(paramMPPointD);
  }
  
  protected ObjectPool.Poolable b() {
    return new MPPointD(0.0D, 0.0D);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MPPointD, x: ");
    stringBuilder.append(this.a);
    stringBuilder.append(", y: ");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\MPPointD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */