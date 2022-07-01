package com.bytedance.sdk.openadsdk;

public class TTImage {
  private int a;
  
  private int b;
  
  private String c;
  
  public TTImage(int paramInt1, int paramInt2, String paramString) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  public int getHeight() {
    return this.a;
  }
  
  public String getImageUrl() {
    return this.c;
  }
  
  public int getWidth() {
    return this.b;
  }
  
  public boolean isValid() {
    if (this.a > 0 && this.b > 0) {
      String str = this.c;
      if (str != null && str.length() > 0)
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */