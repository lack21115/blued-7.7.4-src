package com.blued.android.core.image.util;

public final class ImageSize {
  private int a;
  
  private int b;
  
  public ImageSize() {}
  
  public ImageSize(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a() {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int b() {
    return this.b;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool2 = false;
    if (paramObject == null)
      return false; 
    if (this == paramObject)
      return true; 
    boolean bool1 = bool2;
    if (paramObject instanceof ImageSize) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.a == ((ImageSize)paramObject).a) {
        bool1 = bool2;
        if (this.b == ((ImageSize)paramObject).b)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(this.a);
    stringBuilder.append("x");
    stringBuilder.append(this.b);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imag\\util\ImageSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */