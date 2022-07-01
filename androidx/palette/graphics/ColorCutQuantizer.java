package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class ColorCutQuantizer {
  private static final Comparator<Vbox> g = new Comparator<Vbox>() {
      public int compare(ColorCutQuantizer.Vbox param1Vbox1, ColorCutQuantizer.Vbox param1Vbox2) {
        return param1Vbox2.a() - param1Vbox1.a();
      }
    };
  
  final int[] a;
  
  final int[] b;
  
  final List<Palette.Swatch> c;
  
  final TimingLogger d = null;
  
  final Palette.Filter[] e;
  
  private final float[] f = new float[3];
  
  ColorCutQuantizer(int[] paramArrayOfint, int paramInt, Palette.Filter[] paramArrayOfFilter) {
    this.e = paramArrayOfFilter;
    int[] arrayOfInt = new int[32768];
    this.b = arrayOfInt;
    boolean bool = false;
    int i;
    for (i = 0; i < paramArrayOfint.length; i++) {
      int m = f(paramArrayOfint[i]);
      paramArrayOfint[i] = m;
      arrayOfInt[m] = arrayOfInt[m] + 1;
    } 
    int j = 0;
    for (i = 0; j < arrayOfInt.length; i = m) {
      if (arrayOfInt[j] > 0 && e(j))
        arrayOfInt[j] = 0; 
      int m = i;
      if (arrayOfInt[j] > 0)
        m = i + 1; 
      j++;
    } 
    paramArrayOfint = new int[i];
    this.a = paramArrayOfint;
    j = 0;
    int k;
    for (k = 0; j < arrayOfInt.length; k = m) {
      int m = k;
      if (arrayOfInt[j] > 0) {
        paramArrayOfint[k] = j;
        m = k + 1;
      } 
      j++;
    } 
    if (i <= paramInt) {
      this.c = new ArrayList<Palette.Swatch>();
      i = paramArrayOfint.length;
      for (paramInt = bool; paramInt < i; paramInt++) {
        j = paramArrayOfint[paramInt];
        this.c.add(new Palette.Swatch(g(j), arrayOfInt[j]));
      } 
    } else {
      this.c = d(paramInt);
    } 
  }
  
  static int a(int paramInt) {
    return paramInt >> 10 & 0x1F;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3) {
    return Color.rgb(b(paramInt1, 5, 8), b(paramInt2, 5, 8), b(paramInt3, 5, 8));
  }
  
  private List<Palette.Swatch> a(Collection<Vbox> paramCollection) {
    ArrayList<Palette.Swatch> arrayList = new ArrayList(paramCollection.size());
    Iterator<Vbox> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      Palette.Swatch swatch = ((Vbox)iterator.next()).h();
      if (!a(swatch))
        arrayList.add(swatch); 
    } 
    return arrayList;
  }
  
  private void a(PriorityQueue<Vbox> paramPriorityQueue, int paramInt) {
    while (paramPriorityQueue.size() < paramInt) {
      Vbox vbox = paramPriorityQueue.poll();
      if (vbox != null && vbox.b()) {
        paramPriorityQueue.offer(vbox.e());
        paramPriorityQueue.offer(vbox);
      } 
    } 
  }
  
  static void a(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 != -3) {
      int i = paramInt2;
      if (paramInt1 != -2) {
        if (paramInt1 != -1)
          return; 
        while (paramInt2 <= paramInt3) {
          paramInt1 = paramArrayOfint[paramInt2];
          i = c(paramInt1);
          int j = b(paramInt1);
          paramArrayOfint[paramInt2] = a(paramInt1) | i << 10 | j << 5;
          paramInt2++;
        } 
      } else {
        while (i <= paramInt3) {
          paramInt1 = paramArrayOfint[i];
          paramInt2 = b(paramInt1);
          int j = a(paramInt1);
          paramArrayOfint[i] = c(paramInt1) | paramInt2 << 10 | j << 5;
          i++;
        } 
      } 
    } 
  }
  
  private boolean a(int paramInt, float[] paramArrayOffloat) {
    Palette.Filter[] arrayOfFilter = this.e;
    if (arrayOfFilter != null && arrayOfFilter.length > 0) {
      int j = arrayOfFilter.length;
      for (int i = 0; i < j; i++) {
        if (!this.e[i].isAllowed(paramInt, paramArrayOffloat))
          return true; 
      } 
    } 
    return false;
  }
  
  private boolean a(Palette.Swatch paramSwatch) {
    return a(paramSwatch.getRgb(), paramSwatch.getHsl());
  }
  
  static int b(int paramInt) {
    return paramInt >> 5 & 0x1F;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt3 > paramInt2) {
      paramInt1 <<= paramInt3 - paramInt2;
    } else {
      paramInt1 >>= paramInt2 - paramInt3;
    } 
    return paramInt1 & (1 << paramInt3) - 1;
  }
  
  static int c(int paramInt) {
    return paramInt & 0x1F;
  }
  
  private List<Palette.Swatch> d(int paramInt) {
    PriorityQueue<Vbox> priorityQueue = new PriorityQueue<Vbox>(paramInt, g);
    priorityQueue.offer(new Vbox(this, 0, this.a.length - 1));
    a(priorityQueue, paramInt);
    return a(priorityQueue);
  }
  
  private boolean e(int paramInt) {
    paramInt = g(paramInt);
    ColorUtils.colorToHSL(paramInt, this.f);
    return a(paramInt, this.f);
  }
  
  private static int f(int paramInt) {
    int i = b(Color.red(paramInt), 8, 5);
    int j = b(Color.green(paramInt), 8, 5);
    return b(Color.blue(paramInt), 8, 5) | i << 10 | j << 5;
  }
  
  private static int g(int paramInt) {
    return a(a(paramInt), b(paramInt), c(paramInt));
  }
  
  List<Palette.Swatch> a() {
    return this.c;
  }
  
  class Vbox {
    private int b;
    
    private int c;
    
    private int d;
    
    private int e;
    
    private int f;
    
    private int g;
    
    private int h;
    
    private int i;
    
    private int j;
    
    Vbox(ColorCutQuantizer this$0, int param1Int1, int param1Int2) {
      this.b = param1Int1;
      this.c = param1Int2;
      d();
    }
    
    final int a() {
      return (this.f - this.e + 1) * (this.h - this.g + 1) * (this.j - this.i + 1);
    }
    
    final boolean b() {
      return (c() > 1);
    }
    
    final int c() {
      return this.c + 1 - this.b;
    }
    
    final void d() {
      int[] arrayOfInt1 = this.a.a;
      int[] arrayOfInt2 = this.a.b;
      int k = this.b;
      int i2 = Integer.MAX_VALUE;
      int i3 = Integer.MIN_VALUE;
      int m = Integer.MAX_VALUE;
      int n = Integer.MIN_VALUE;
      int i = Integer.MAX_VALUE;
      int j = Integer.MIN_VALUE;
      int i1;
      for (i1 = 0; k <= this.c; i1 = i7) {
        int i4 = arrayOfInt1[k];
        int i7 = i1 + arrayOfInt2[i4];
        int i5 = ColorCutQuantizer.a(i4);
        int i6 = ColorCutQuantizer.b(i4);
        i4 = ColorCutQuantizer.c(i4);
        i1 = i3;
        if (i5 > i3)
          i1 = i5; 
        i3 = i2;
        if (i5 < i2)
          i3 = i5; 
        i5 = n;
        if (i6 > n)
          i5 = i6; 
        n = m;
        if (i6 < m)
          n = i6; 
        i6 = j;
        if (i4 > j)
          i6 = i4; 
        j = i;
        if (i4 < i)
          j = i4; 
        k++;
        i2 = i3;
        i3 = i1;
        m = n;
        n = i5;
        i = j;
        j = i6;
      } 
      this.e = i2;
      this.f = i3;
      this.g = m;
      this.h = n;
      this.i = i;
      this.j = j;
      this.d = i1;
    }
    
    final Vbox e() {
      if (b()) {
        int i = g();
        Vbox vbox = new Vbox(this.a, i + 1, this.c);
        this.c = i;
        d();
        return vbox;
      } 
      throw new IllegalStateException("Can not split a box with only 1 color");
    }
    
    final int f() {
      int i = this.f - this.e;
      int j = this.h - this.g;
      int k = this.j - this.i;
      return (i >= j && i >= k) ? -3 : ((j >= i && j >= k) ? -2 : -1);
    }
    
    final int g() {
      int i = f();
      int[] arrayOfInt1 = this.a.a;
      int[] arrayOfInt2 = this.a.b;
      ColorCutQuantizer.a(arrayOfInt1, i, this.b, this.c);
      Arrays.sort(arrayOfInt1, this.b, this.c + 1);
      ColorCutQuantizer.a(arrayOfInt1, i, this.b, this.c);
      int k = this.d / 2;
      i = this.b;
      int j = 0;
      while (true) {
        int m = this.c;
        if (i <= m) {
          j += arrayOfInt2[arrayOfInt1[i]];
          if (j >= k)
            return Math.min(m - 1, i); 
          i++;
          continue;
        } 
        return this.b;
      } 
    }
    
    final Palette.Swatch h() {
      int[] arrayOfInt1 = this.a.a;
      int[] arrayOfInt2 = this.a.b;
      int k = this.b;
      int m = 0;
      int n = 0;
      int j = 0;
      int i = 0;
      while (k <= this.c) {
        int i1 = arrayOfInt1[k];
        int i2 = arrayOfInt2[i1];
        n += i2;
        m += ColorCutQuantizer.a(i1) * i2;
        j += ColorCutQuantizer.b(i1) * i2;
        i += i2 * ColorCutQuantizer.c(i1);
        k++;
      } 
      float f1 = m;
      float f2 = n;
      return new Palette.Swatch(ColorCutQuantizer.a(Math.round(f1 / f2), Math.round(j / f2), Math.round(i / f2)), n);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\palette\graphics\ColorCutQuantizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */