package com.github.mikephil.charting.utils;

public final class FSize extends ObjectPool.Poolable {
  private static ObjectPool<FSize> c = ObjectPool.a(256, new FSize(0.0F, 0.0F));
  
  public float a;
  
  public float b;
  
  static {
    c.a(0.5F);
  }
  
  public FSize() {}
  
  public FSize(float paramFloat1, float paramFloat2) {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public static FSize a(float paramFloat1, float paramFloat2) {
    FSize fSize = c.a();
    fSize.a = paramFloat1;
    fSize.b = paramFloat2;
    return fSize;
  }
  
  public static void a(FSize paramFSize) {
    c.a(paramFSize);
  }
  
  protected ObjectPool.Poolable b() {
    return new FSize(0.0F, 0.0F);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool2 = false;
    if (paramObject == null)
      return false; 
    if (this == paramObject)
      return true; 
    boolean bool1 = bool2;
    if (paramObject instanceof FSize) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.a == ((FSize)paramObject).a) {
        bool1 = bool2;
        if (this.b == ((FSize)paramObject).b)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return Float.floatToIntBits(this.a) ^ Float.floatToIntBits(this.b);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("x");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\FSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */