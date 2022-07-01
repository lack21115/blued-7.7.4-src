package com.google.android.cameraview;

public class Size implements Comparable<Size> {
  private final int a;
  
  private final int b;
  
  public Size(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a() {
    return this.a;
  }
  
  public int a(Size paramSize) {
    return this.a * this.b - paramSize.a * paramSize.b;
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
    if (paramObject instanceof Size) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.a == ((Size)paramObject).a) {
        bool1 = bool2;
        if (this.b == ((Size)paramObject).b)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    int i = this.b;
    int j = this.a;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append("x");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */