package com.huawei.hms.common.size;

public class Size {
  private final int height;
  
  private final int width;
  
  public Size(int paramInt1, int paramInt2) {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public static Size parseSize(String paramString) {
    try {
      int j = paramString.indexOf("x");
      int i = j;
      if (j < 0)
        i = paramString.indexOf("*"); 
      return new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
    } catch (Exception exception) {
      throw new IllegalArgumentException("Size parses failed");
    } 
  }
  
  public final boolean equals(Object paramObject) {
    boolean bool2 = false;
    if (paramObject == null)
      return false; 
    if (this == paramObject)
      return true; 
    boolean bool1 = bool2;
    if (paramObject instanceof Size) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.width == ((Size)paramObject).width) {
        bool1 = bool2;
        if (this.height == ((Size)paramObject).height)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public final int getHeight() {
    return this.height;
  }
  
  public final int getWidth() {
    return this.width;
  }
  
  public final String toString() {
    int i = this.width;
    int j = this.height;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Width is ");
    stringBuilder.append(i);
    stringBuilder.append(" Height is ");
    stringBuilder.append(j);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\size\Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */