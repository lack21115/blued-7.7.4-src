package com.google.zxing;

public final class Dimension {
  private final int a;
  
  private final int b;
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Dimension) {
      paramObject = paramObject;
      if (this.a == ((Dimension)paramObject).a && this.b == ((Dimension)paramObject).b)
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a * 32713 + this.b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("x");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\Dimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */