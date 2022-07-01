package a.a.a.a.a.b.i;

import com.qiniu.pili.droid.streaming.PreviewAppearance;

public class f extends g {
  public int a;
  
  public int b;
  
  public float[] c;
  
  public float[] d;
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.c = k.a;
    float f1 = paramInt3 * 1.0F / paramInt4;
    float f2 = paramInt1;
    float f3 = paramInt2;
    if (f2 * 1.0F / f3 < f1) {
      f1 = (f3 - f2 / f1) / 2.0F / f3;
      f2 = 1.0F - f1;
      this.d = new float[] { 0.0F, f1, 0.0F, f2, 1.0F, f1, 1.0F, f2 };
      return;
    } 
    f1 = (f2 - f3 * f1) / 2.0F / f2;
    f2 = 1.0F - f1;
    this.d = new float[] { f1, 0.0F, f1, 1.0F, f2, 0.0F, f2, 1.0F };
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, PreviewAppearance.ScaleType paramScaleType) {
    this.a = paramInt3;
    this.b = paramInt4;
    if (paramScaleType == PreviewAppearance.ScaleType.FULL) {
      a(paramInt1, paramInt2, paramInt5, paramInt6);
    } else {
      b(paramInt1, paramInt2, paramInt5, paramInt6);
    } 
    return a(paramInt5, paramInt6);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.d = k.d;
    float f1 = paramInt3;
    float f2 = paramInt4;
    float f3 = f1 * 1.0F / f2;
    float f4 = paramInt1 * 1.0F / paramInt2;
    if (f4 < f3) {
      f2 = f2 * f4 / f1 / 2.0F;
      f1 = (0.5F - f2) * 2.0F - 1.0F;
      f2 = (f2 + 0.5F) * 2.0F - 1.0F;
      this.c = new float[] { f1, -1.0F, f1, 1.0F, f2, -1.0F, f2, 1.0F };
      return;
    } 
    f2 = f1 / f4 / f2 / 2.0F;
    f1 = (0.5F - f2) * 2.0F - 1.0F;
    f2 = (f2 + 0.5F) * 2.0F - 1.0F;
    this.c = new float[] { -1.0F, f1, -1.0F, f2, 1.0F, f1, 1.0F, f2 };
  }
  
  public int c() {
    return this.a;
  }
  
  public int d() {
    return this.b;
  }
  
  public float[] e() {
    return this.c;
  }
  
  public float[] f() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */