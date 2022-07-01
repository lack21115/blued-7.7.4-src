package com.airbnb.lottie;

import android.graphics.Bitmap;

public class LottieImageAsset {
  private final int a;
  
  private final int b;
  
  private final String c;
  
  private final String d;
  
  private final String e;
  
  private Bitmap f;
  
  public LottieImageAsset(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
  }
  
  public String a() {
    return this.c;
  }
  
  public void a(Bitmap paramBitmap) {
    this.f = paramBitmap;
  }
  
  public String b() {
    return this.d;
  }
  
  public Bitmap c() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\LottieImageAsset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */