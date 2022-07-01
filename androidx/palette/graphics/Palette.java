package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Palette {
  static final Filter a = new Filter() {
      private boolean a(float[] param1ArrayOffloat) {
        return (param1ArrayOffloat[2] <= 0.05F);
      }
      
      private boolean b(float[] param1ArrayOffloat) {
        return (param1ArrayOffloat[2] >= 0.95F);
      }
      
      private boolean c(float[] param1ArrayOffloat) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (param1ArrayOffloat[0] >= 10.0F) {
          bool1 = bool2;
          if (param1ArrayOffloat[0] <= 37.0F) {
            bool1 = bool2;
            if (param1ArrayOffloat[1] <= 0.82F)
              bool1 = true; 
          } 
        } 
        return bool1;
      }
      
      public boolean isAllowed(int param1Int, float[] param1ArrayOffloat) {
        return (!b(param1ArrayOffloat) && !a(param1ArrayOffloat) && !c(param1ArrayOffloat));
      }
    };
  
  private final List<Swatch> b;
  
  private final List<Target> c;
  
  private final Map<Target, Swatch> d;
  
  private final SparseBooleanArray e;
  
  private final Swatch f;
  
  Palette(List<Swatch> paramList, List<Target> paramList1) {
    this.b = paramList;
    this.c = paramList1;
    this.e = new SparseBooleanArray();
    this.d = (Map<Target, Swatch>)new ArrayMap();
    this.f = b();
  }
  
  private Swatch a(Target paramTarget) {
    Swatch swatch = b(paramTarget);
    if (swatch != null && paramTarget.isExclusive())
      this.e.append(swatch.getRgb(), true); 
    return swatch;
  }
  
  private boolean a(Swatch paramSwatch, Target paramTarget) {
    float[] arrayOfFloat = paramSwatch.getHsl();
    return (arrayOfFloat[1] >= paramTarget.getMinimumSaturation() && arrayOfFloat[1] <= paramTarget.getMaximumSaturation() && arrayOfFloat[2] >= paramTarget.getMinimumLightness() && arrayOfFloat[2] <= paramTarget.getMaximumLightness() && !this.e.get(paramSwatch.getRgb()));
  }
  
  private float b(Swatch paramSwatch, Target paramTarget) {
    float f2;
    boolean bool;
    float[] arrayOfFloat = paramSwatch.getHsl();
    Swatch swatch = this.f;
    if (swatch != null) {
      bool = swatch.getPopulation();
    } else {
      bool = true;
    } 
    float f1 = paramTarget.getSaturationWeight();
    float f3 = 0.0F;
    if (f1 > 0.0F) {
      f1 = paramTarget.getSaturationWeight();
      f1 = (1.0F - Math.abs(arrayOfFloat[1] - paramTarget.getTargetSaturation())) * f1;
    } else {
      f1 = 0.0F;
    } 
    if (paramTarget.getLightnessWeight() > 0.0F) {
      f2 = paramTarget.getLightnessWeight() * (1.0F - Math.abs(arrayOfFloat[2] - paramTarget.getTargetLightness()));
    } else {
      f2 = 0.0F;
    } 
    if (paramTarget.getPopulationWeight() > 0.0F)
      f3 = paramTarget.getPopulationWeight() * paramSwatch.getPopulation() / bool; 
    return f1 + f2 + f3;
  }
  
  private Swatch b() {
    int k = this.b.size();
    int j = Integer.MIN_VALUE;
    Swatch swatch = null;
    int i = 0;
    while (i < k) {
      Swatch swatch1 = this.b.get(i);
      int m = j;
      if (swatch1.getPopulation() > j) {
        m = swatch1.getPopulation();
        swatch = swatch1;
      } 
      i++;
      j = m;
    } 
    return swatch;
  }
  
  private Swatch b(Target paramTarget) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: istore #6
    //   11: fconst_0
    //   12: fstore_2
    //   13: aconst_null
    //   14: astore #7
    //   16: iconst_0
    //   17: istore #5
    //   19: iload #5
    //   21: iload #6
    //   23: if_icmpge -> 107
    //   26: aload_0
    //   27: getfield b : Ljava/util/List;
    //   30: iload #5
    //   32: invokeinterface get : (I)Ljava/lang/Object;
    //   37: checkcast androidx/palette/graphics/Palette$Swatch
    //   40: astore #9
    //   42: fload_2
    //   43: fstore_3
    //   44: aload #7
    //   46: astore #8
    //   48: aload_0
    //   49: aload #9
    //   51: aload_1
    //   52: invokespecial a : (Landroidx/palette/graphics/Palette$Swatch;Landroidx/palette/graphics/Target;)Z
    //   55: ifeq -> 92
    //   58: aload_0
    //   59: aload #9
    //   61: aload_1
    //   62: invokespecial b : (Landroidx/palette/graphics/Palette$Swatch;Landroidx/palette/graphics/Target;)F
    //   65: fstore #4
    //   67: aload #7
    //   69: ifnull -> 85
    //   72: fload_2
    //   73: fstore_3
    //   74: aload #7
    //   76: astore #8
    //   78: fload #4
    //   80: fload_2
    //   81: fcmpl
    //   82: ifle -> 92
    //   85: aload #9
    //   87: astore #8
    //   89: fload #4
    //   91: fstore_3
    //   92: iload #5
    //   94: iconst_1
    //   95: iadd
    //   96: istore #5
    //   98: fload_3
    //   99: fstore_2
    //   100: aload #8
    //   102: astore #7
    //   104: goto -> 19
    //   107: aload #7
    //   109: areturn
  }
  
  public static Builder from(Bitmap paramBitmap) {
    return new Builder(paramBitmap);
  }
  
  public static Palette from(List<Swatch> paramList) {
    return (new Builder(paramList)).generate();
  }
  
  @Deprecated
  public static Palette generate(Bitmap paramBitmap) {
    return from(paramBitmap).generate();
  }
  
  @Deprecated
  public static Palette generate(Bitmap paramBitmap, int paramInt) {
    return from(paramBitmap).maximumColorCount(paramInt).generate();
  }
  
  @Deprecated
  public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap paramBitmap, int paramInt, PaletteAsyncListener paramPaletteAsyncListener) {
    return from(paramBitmap).maximumColorCount(paramInt).generate(paramPaletteAsyncListener);
  }
  
  @Deprecated
  public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap paramBitmap, PaletteAsyncListener paramPaletteAsyncListener) {
    return from(paramBitmap).generate(paramPaletteAsyncListener);
  }
  
  void a() {
    int j = this.c.size();
    for (int i = 0; i < j; i++) {
      Target target = this.c.get(i);
      target.a();
      this.d.put(target, a(target));
    } 
    this.e.clear();
  }
  
  public int getColorForTarget(Target paramTarget, int paramInt) {
    Swatch swatch = getSwatchForTarget(paramTarget);
    if (swatch != null)
      paramInt = swatch.getRgb(); 
    return paramInt;
  }
  
  public int getDarkMutedColor(int paramInt) {
    return getColorForTarget(Target.DARK_MUTED, paramInt);
  }
  
  public Swatch getDarkMutedSwatch() {
    return getSwatchForTarget(Target.DARK_MUTED);
  }
  
  public int getDarkVibrantColor(int paramInt) {
    return getColorForTarget(Target.DARK_VIBRANT, paramInt);
  }
  
  public Swatch getDarkVibrantSwatch() {
    return getSwatchForTarget(Target.DARK_VIBRANT);
  }
  
  public int getDominantColor(int paramInt) {
    Swatch swatch = this.f;
    if (swatch != null)
      paramInt = swatch.getRgb(); 
    return paramInt;
  }
  
  public Swatch getDominantSwatch() {
    return this.f;
  }
  
  public int getLightMutedColor(int paramInt) {
    return getColorForTarget(Target.LIGHT_MUTED, paramInt);
  }
  
  public Swatch getLightMutedSwatch() {
    return getSwatchForTarget(Target.LIGHT_MUTED);
  }
  
  public int getLightVibrantColor(int paramInt) {
    return getColorForTarget(Target.LIGHT_VIBRANT, paramInt);
  }
  
  public Swatch getLightVibrantSwatch() {
    return getSwatchForTarget(Target.LIGHT_VIBRANT);
  }
  
  public int getMutedColor(int paramInt) {
    return getColorForTarget(Target.MUTED, paramInt);
  }
  
  public Swatch getMutedSwatch() {
    return getSwatchForTarget(Target.MUTED);
  }
  
  public Swatch getSwatchForTarget(Target paramTarget) {
    return this.d.get(paramTarget);
  }
  
  public List<Swatch> getSwatches() {
    return Collections.unmodifiableList(this.b);
  }
  
  public List<Target> getTargets() {
    return Collections.unmodifiableList(this.c);
  }
  
  public int getVibrantColor(int paramInt) {
    return getColorForTarget(Target.VIBRANT, paramInt);
  }
  
  public Swatch getVibrantSwatch() {
    return getSwatchForTarget(Target.VIBRANT);
  }
  
  public static final class Builder {
    private final List<Palette.Swatch> a;
    
    private final Bitmap b;
    
    private final List<Target> c = new ArrayList<Target>();
    
    private int d = 16;
    
    private int e = 12544;
    
    private int f = -1;
    
    private final List<Palette.Filter> g = new ArrayList<Palette.Filter>();
    
    private Rect h;
    
    public Builder(Bitmap param1Bitmap) {
      if (param1Bitmap != null && !param1Bitmap.isRecycled()) {
        this.g.add(Palette.a);
        this.b = param1Bitmap;
        this.a = null;
        this.c.add(Target.LIGHT_VIBRANT);
        this.c.add(Target.VIBRANT);
        this.c.add(Target.DARK_VIBRANT);
        this.c.add(Target.LIGHT_MUTED);
        this.c.add(Target.MUTED);
        this.c.add(Target.DARK_MUTED);
        return;
      } 
      throw new IllegalArgumentException("Bitmap is not valid");
    }
    
    public Builder(List<Palette.Swatch> param1List) {
      if (param1List != null && !param1List.isEmpty()) {
        this.g.add(Palette.a);
        this.a = param1List;
        this.b = null;
        return;
      } 
      throw new IllegalArgumentException("List of Swatches is not valid");
    }
    
    private int[] a(Bitmap param1Bitmap) {
      int j = param1Bitmap.getWidth();
      int i = param1Bitmap.getHeight();
      int[] arrayOfInt2 = new int[j * i];
      param1Bitmap.getPixels(arrayOfInt2, 0, j, 0, 0, j, i);
      Rect rect = this.h;
      if (rect == null)
        return arrayOfInt2; 
      int k = rect.width();
      int m = this.h.height();
      int[] arrayOfInt1 = new int[k * m];
      for (i = 0; i < m; i++)
        System.arraycopy(arrayOfInt2, (this.h.top + i) * j + this.h.left, arrayOfInt1, i * k, k); 
      return arrayOfInt1;
    }
    
    private Bitmap b(Bitmap param1Bitmap) {
      double d1;
      int i = this.e;
      double d2 = -1.0D;
      if (i > 0) {
        i = param1Bitmap.getWidth() * param1Bitmap.getHeight();
        int j = this.e;
        d1 = d2;
        if (i > j)
          d1 = Math.sqrt(j / i); 
      } else {
        d1 = d2;
        if (this.f > 0) {
          i = Math.max(param1Bitmap.getWidth(), param1Bitmap.getHeight());
          int j = this.f;
          d1 = d2;
          if (i > j)
            d1 = j / i; 
        } 
      } 
      return (d1 <= 0.0D) ? param1Bitmap : Bitmap.createScaledBitmap(param1Bitmap, (int)Math.ceil(param1Bitmap.getWidth() * d1), (int)Math.ceil(param1Bitmap.getHeight() * d1), false);
    }
    
    public Builder addFilter(Palette.Filter param1Filter) {
      if (param1Filter != null)
        this.g.add(param1Filter); 
      return this;
    }
    
    public Builder addTarget(Target param1Target) {
      if (!this.c.contains(param1Target))
        this.c.add(param1Target); 
      return this;
    }
    
    public Builder clearFilters() {
      this.g.clear();
      return this;
    }
    
    public Builder clearRegion() {
      this.h = null;
      return this;
    }
    
    public Builder clearTargets() {
      List<Target> list = this.c;
      if (list != null)
        list.clear(); 
      return this;
    }
    
    public AsyncTask<Bitmap, Void, Palette> generate(Palette.PaletteAsyncListener param1PaletteAsyncListener) {
      if (param1PaletteAsyncListener != null)
        return (new AsyncTask<Bitmap, Void, Palette>(this, param1PaletteAsyncListener) {
            protected Palette a(Bitmap... param2VarArgs) {
              try {
                return this.b.generate();
              } catch (Exception exception) {
                Log.e("Palette", "Exception thrown during async generate", exception);
                return null;
              } 
            }
            
            protected void a(Palette param2Palette) {
              this.a.onGenerated(param2Palette);
            }
          }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Bitmap[] { this.b }); 
      throw new IllegalArgumentException("listener can not be null");
    }
    
    public Palette generate() {
      List<Palette.Swatch> list;
      Bitmap bitmap = this.b;
      if (bitmap != null) {
        Palette.Filter[] arrayOfFilter;
        Bitmap bitmap1 = b(bitmap);
        Rect rect = this.h;
        if (bitmap1 != this.b && rect != null) {
          double d = bitmap1.getWidth() / this.b.getWidth();
          rect.left = (int)Math.floor(rect.left * d);
          rect.top = (int)Math.floor(rect.top * d);
          rect.right = Math.min((int)Math.ceil(rect.right * d), bitmap1.getWidth());
          rect.bottom = Math.min((int)Math.ceil(rect.bottom * d), bitmap1.getHeight());
        } 
        int[] arrayOfInt = a(bitmap1);
        int i = this.d;
        if (this.g.isEmpty()) {
          rect = null;
        } else {
          List<Palette.Filter> list1 = this.g;
          arrayOfFilter = list1.<Palette.Filter>toArray(new Palette.Filter[list1.size()]);
        } 
        ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(arrayOfInt, i, arrayOfFilter);
        if (bitmap1 != this.b)
          bitmap1.recycle(); 
        list = colorCutQuantizer.a();
      } else {
        list = this.a;
        if (list == null)
          throw new AssertionError(); 
      } 
      Palette palette = new Palette(list, this.c);
      palette.a();
      return palette;
    }
    
    public Builder maximumColorCount(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public Builder resizeBitmapArea(int param1Int) {
      this.e = param1Int;
      this.f = -1;
      return this;
    }
    
    @Deprecated
    public Builder resizeBitmapSize(int param1Int) {
      this.f = param1Int;
      this.e = -1;
      return this;
    }
    
    public Builder setRegion(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      if (this.b != null) {
        if (this.h == null)
          this.h = new Rect(); 
        this.h.set(0, 0, this.b.getWidth(), this.b.getHeight());
        if (this.h.intersect(param1Int1, param1Int2, param1Int3, param1Int4))
          return this; 
        throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
      } 
      return this;
    }
  }
  
  class null extends AsyncTask<Bitmap, Void, Palette> {
    null(Palette this$0, Palette.PaletteAsyncListener param1PaletteAsyncListener) {}
    
    protected Palette a(Bitmap... param1VarArgs) {
      try {
        return this.b.generate();
      } catch (Exception exception) {
        Log.e("Palette", "Exception thrown during async generate", exception);
        return null;
      } 
    }
    
    protected void a(Palette param1Palette) {
      this.a.onGenerated(param1Palette);
    }
  }
  
  public static interface Filter {
    boolean isAllowed(int param1Int, float[] param1ArrayOffloat);
  }
  
  public static interface PaletteAsyncListener {
    void onGenerated(Palette param1Palette);
  }
  
  public static final class Swatch {
    private final int a;
    
    private final int b;
    
    private final int c;
    
    private final int d;
    
    private final int e;
    
    private boolean f;
    
    private int g;
    
    private int h;
    
    private float[] i;
    
    public Swatch(int param1Int1, int param1Int2) {
      this.a = Color.red(param1Int1);
      this.b = Color.green(param1Int1);
      this.c = Color.blue(param1Int1);
      this.d = param1Int1;
      this.e = param1Int2;
    }
    
    private void a() {
      if (!this.f) {
        int i = ColorUtils.calculateMinimumAlpha(-1, this.d, 4.5F);
        int j = ColorUtils.calculateMinimumAlpha(-1, this.d, 3.0F);
        if (i != -1 && j != -1) {
          this.h = ColorUtils.setAlphaComponent(-1, i);
          this.g = ColorUtils.setAlphaComponent(-1, j);
          this.f = true;
          return;
        } 
        int m = ColorUtils.calculateMinimumAlpha(-16777216, this.d, 4.5F);
        int k = ColorUtils.calculateMinimumAlpha(-16777216, this.d, 3.0F);
        if (m != -1 && k != -1) {
          this.h = ColorUtils.setAlphaComponent(-16777216, m);
          this.g = ColorUtils.setAlphaComponent(-16777216, k);
          this.f = true;
          return;
        } 
        if (i != -1) {
          i = ColorUtils.setAlphaComponent(-1, i);
        } else {
          i = ColorUtils.setAlphaComponent(-16777216, m);
        } 
        this.h = i;
        if (j != -1) {
          i = ColorUtils.setAlphaComponent(-1, j);
        } else {
          i = ColorUtils.setAlphaComponent(-16777216, k);
        } 
        this.g = i;
        this.f = true;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        return (this.e == ((Swatch)param1Object).e && this.d == ((Swatch)param1Object).d);
      } 
      return false;
    }
    
    public int getBodyTextColor() {
      a();
      return this.h;
    }
    
    public float[] getHsl() {
      if (this.i == null)
        this.i = new float[3]; 
      ColorUtils.RGBToHSL(this.a, this.b, this.c, this.i);
      return this.i;
    }
    
    public int getPopulation() {
      return this.e;
    }
    
    public int getRgb() {
      return this.d;
    }
    
    public int getTitleTextColor() {
      a();
      return this.g;
    }
    
    public int hashCode() {
      return this.d * 31 + this.e;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName());
      stringBuilder.append(" [RGB: #");
      stringBuilder.append(Integer.toHexString(getRgb()));
      stringBuilder.append(']');
      stringBuilder.append(" [HSL: ");
      stringBuilder.append(Arrays.toString(getHsl()));
      stringBuilder.append(']');
      stringBuilder.append(" [Population: ");
      stringBuilder.append(this.e);
      stringBuilder.append(']');
      stringBuilder.append(" [Title Text: #");
      stringBuilder.append(Integer.toHexString(getTitleTextColor()));
      stringBuilder.append(']');
      stringBuilder.append(" [Body Text: #");
      stringBuilder.append(Integer.toHexString(getBodyTextColor()));
      stringBuilder.append(']');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\palette\graphics\Palette.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */