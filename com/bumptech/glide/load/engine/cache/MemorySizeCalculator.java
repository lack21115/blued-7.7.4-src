package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class MemorySizeCalculator {
  private final int a;
  
  private final int b;
  
  private final Context c;
  
  private final int d;
  
  MemorySizeCalculator(Builder paramBuilder) {
    this.c = paramBuilder.b;
    if (a(paramBuilder.c)) {
      i = paramBuilder.i / 2;
    } else {
      i = paramBuilder.i;
    } 
    this.d = i;
    int i = a(paramBuilder.c, paramBuilder.g, paramBuilder.h);
    float f = (paramBuilder.d.a() * paramBuilder.d.b() * 4);
    int j = Math.round(paramBuilder.f * f);
    int k = Math.round(f * paramBuilder.e);
    int m = i - this.d;
    int n = k + j;
    if (n <= m) {
      this.b = k;
      this.a = j;
    } else {
      f = m / (paramBuilder.f + paramBuilder.e);
      this.b = Math.round(paramBuilder.e * f);
      this.a = Math.round(f * paramBuilder.f);
    } 
    if (Log.isLoggable("MemorySizeCalculator", 3)) {
      boolean bool;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Calculation complete, Calculated memory cache size: ");
      stringBuilder.append(a(this.b));
      stringBuilder.append(", pool size: ");
      stringBuilder.append(a(this.a));
      stringBuilder.append(", byte array size: ");
      stringBuilder.append(a(this.d));
      stringBuilder.append(", memory class limited? ");
      if (n > i) {
        bool = true;
      } else {
        bool = false;
      } 
      stringBuilder.append(bool);
      stringBuilder.append(", max size: ");
      stringBuilder.append(a(i));
      stringBuilder.append(", memoryClass: ");
      stringBuilder.append(paramBuilder.c.getMemoryClass());
      stringBuilder.append(", isLowMemoryDevice: ");
      stringBuilder.append(a(paramBuilder.c));
      Log.d("MemorySizeCalculator", stringBuilder.toString());
    } 
  }
  
  private static int a(ActivityManager paramActivityManager, float paramFloat1, float paramFloat2) {
    int i = paramActivityManager.getMemoryClass();
    boolean bool = a(paramActivityManager);
    float f = (i * 1024 * 1024);
    if (bool)
      paramFloat1 = paramFloat2; 
    return Math.round(f * paramFloat1);
  }
  
  private String a(int paramInt) {
    return Formatter.formatFileSize(this.c, paramInt);
  }
  
  static boolean a(ActivityManager paramActivityManager) {
    return (Build.VERSION.SDK_INT >= 19) ? paramActivityManager.isLowRamDevice() : true;
  }
  
  public int a() {
    return this.b;
  }
  
  public int b() {
    return this.a;
  }
  
  public int c() {
    return this.d;
  }
  
  public static final class Builder {
    static final int a;
    
    final Context b;
    
    ActivityManager c;
    
    MemorySizeCalculator.ScreenDimensions d;
    
    float e = 2.0F;
    
    float f = a;
    
    float g = 0.4F;
    
    float h = 0.33F;
    
    int i = 4194304;
    
    static {
      boolean bool;
      if (Build.VERSION.SDK_INT < 26) {
        bool = true;
      } else {
        bool = true;
      } 
      a = bool;
    }
    
    public Builder(Context param1Context) {
      this.b = param1Context;
      this.c = (ActivityManager)param1Context.getSystemService("activity");
      this.d = new MemorySizeCalculator.DisplayMetricsScreenDimensions(param1Context.getResources().getDisplayMetrics());
      if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.a(this.c))
        this.f = 0.0F; 
    }
    
    public MemorySizeCalculator a() {
      return new MemorySizeCalculator(this);
    }
  }
  
  static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
    private final DisplayMetrics a;
    
    DisplayMetricsScreenDimensions(DisplayMetrics param1DisplayMetrics) {
      this.a = param1DisplayMetrics;
    }
    
    public int a() {
      return this.a.widthPixels;
    }
    
    public int b() {
      return this.a.heightPixels;
    }
  }
  
  static interface ScreenDimensions {
    int a();
    
    int b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\MemorySizeCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */