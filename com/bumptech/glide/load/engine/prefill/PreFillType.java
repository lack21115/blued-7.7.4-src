package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;

public final class PreFillType {
  static final Bitmap.Config a = Bitmap.Config.RGB_565;
  
  private final int b;
  
  private final int c;
  
  private final Bitmap.Config d;
  
  private final int e;
  
  int a() {
    return this.b;
  }
  
  int b() {
    return this.c;
  }
  
  Bitmap.Config c() {
    return this.d;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof PreFillType;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.c == ((PreFillType)paramObject).c) {
        bool1 = bool2;
        if (this.b == ((PreFillType)paramObject).b) {
          bool1 = bool2;
          if (this.e == ((PreFillType)paramObject).e) {
            bool1 = bool2;
            if (this.d == ((PreFillType)paramObject).d)
              bool1 = true; 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return ((this.b * 31 + this.c) * 31 + this.d.hashCode()) * 31 + this.e;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PreFillSize{width=");
    stringBuilder.append(this.b);
    stringBuilder.append(", height=");
    stringBuilder.append(this.c);
    stringBuilder.append(", config=");
    stringBuilder.append(this.d);
    stringBuilder.append(", weight=");
    stringBuilder.append(this.e);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static class Builder {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\prefill\PreFillType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */