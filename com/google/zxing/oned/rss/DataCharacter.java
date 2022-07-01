package com.google.zxing.oned.rss;

public class DataCharacter {
  private final int a;
  
  private final int b;
  
  public DataCharacter(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final int a() {
    return this.a;
  }
  
  public final int b() {
    return this.b;
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof DataCharacter))
      return false; 
    paramObject = paramObject;
    return (this.a == ((DataCharacter)paramObject).a && this.b == ((DataCharacter)paramObject).b);
  }
  
  public final int hashCode() {
    return this.a ^ this.b;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("(");
    stringBuilder.append(this.b);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\DataCharacter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */