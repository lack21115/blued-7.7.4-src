package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy {
  static {
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    i = bool;
  }
  
  public abstract float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract SampleSizeRounding b(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  static {
    boolean bool;
  }
  
  public static final DownsampleStrategy a = new AtLeast();
  
  public static final DownsampleStrategy b = new AtMost();
  
  public static final DownsampleStrategy c = new FitCenter();
  
  public static final DownsampleStrategy d = new CenterInside();
  
  public static final DownsampleStrategy e = new CenterOutside();
  
  public static final DownsampleStrategy f = new None();
  
  public static final DownsampleStrategy g = e;
  
  public static final Option<DownsampleStrategy> h = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", g);
  
  static final boolean i;
  
  static class AtLeast extends DownsampleStrategy {
    public float a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      param1Int1 = Math.min(param1Int2 / param1Int4, param1Int1 / param1Int3);
      return (param1Int1 == 0) ? 1.0F : (1.0F / Integer.highestOneBit(param1Int1));
    }
    
    public DownsampleStrategy.SampleSizeRounding b(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return DownsampleStrategy.SampleSizeRounding.b;
    }
  }
  
  static class AtMost extends DownsampleStrategy {
    public float a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      param1Int3 = (int)Math.ceil(Math.max(param1Int2 / param1Int4, param1Int1 / param1Int3));
      param1Int2 = Integer.highestOneBit(param1Int3);
      param1Int1 = 1;
      param1Int2 = Math.max(1, param1Int2);
      if (param1Int2 >= param1Int3)
        param1Int1 = 0; 
      return 1.0F / (param1Int2 << param1Int1);
    }
    
    public DownsampleStrategy.SampleSizeRounding b(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return DownsampleStrategy.SampleSizeRounding.a;
    }
  }
  
  static class CenterInside extends DownsampleStrategy {
    public float a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return Math.min(1.0F, c.a(param1Int1, param1Int2, param1Int3, param1Int4));
    }
    
    public DownsampleStrategy.SampleSizeRounding b(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return (a(param1Int1, param1Int2, param1Int3, param1Int4) == 1.0F) ? DownsampleStrategy.SampleSizeRounding.b : c.b(param1Int1, param1Int2, param1Int3, param1Int4);
    }
  }
  
  static class CenterOutside extends DownsampleStrategy {
    public float a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return Math.max(param1Int3 / param1Int1, param1Int4 / param1Int2);
    }
    
    public DownsampleStrategy.SampleSizeRounding b(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return DownsampleStrategy.SampleSizeRounding.b;
    }
  }
  
  static class FitCenter extends DownsampleStrategy {
    public float a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      if (i)
        return Math.min(param1Int3 / param1Int1, param1Int4 / param1Int2); 
      param1Int1 = Math.max(param1Int2 / param1Int4, param1Int1 / param1Int3);
      return (param1Int1 == 0) ? 1.0F : (1.0F / Integer.highestOneBit(param1Int1));
    }
    
    public DownsampleStrategy.SampleSizeRounding b(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return i ? DownsampleStrategy.SampleSizeRounding.b : DownsampleStrategy.SampleSizeRounding.a;
    }
  }
  
  static class None extends DownsampleStrategy {
    public float a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return 1.0F;
    }
    
    public DownsampleStrategy.SampleSizeRounding b(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return DownsampleStrategy.SampleSizeRounding.b;
    }
  }
  
  public enum SampleSizeRounding {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\DownsampleStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */