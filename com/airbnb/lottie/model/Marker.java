package com.airbnb.lottie.model;

public class Marker {
  private static String c = "\r";
  
  public final float a;
  
  public final float b;
  
  private final String d;
  
  public Marker(String paramString, float paramFloat1, float paramFloat2) {
    this.d = paramString;
    this.b = paramFloat2;
    this.a = paramFloat1;
  }
  
  public boolean a(String paramString) {
    if (this.d.equalsIgnoreCase(paramString))
      return true; 
    if (this.d.endsWith(c)) {
      String str = this.d;
      if (str.substring(0, str.length() - 1).equalsIgnoreCase(paramString))
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */