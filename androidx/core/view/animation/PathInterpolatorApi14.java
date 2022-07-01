package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorApi14 implements Interpolator {
  private final float[] a;
  
  private final float[] b;
  
  PathInterpolatorApi14(float paramFloat1, float paramFloat2) {
    this(a(paramFloat1, paramFloat2));
  }
  
  PathInterpolatorApi14(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    this(a(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  PathInterpolatorApi14(Path paramPath) {
    PathMeasure pathMeasure = new PathMeasure(paramPath, false);
    float f = pathMeasure.getLength();
    int j = (int)(f / 0.002F) + 1;
    this.a = new float[j];
    this.b = new float[j];
    float[] arrayOfFloat = new float[2];
    for (int i = 0; i < j; i++) {
      pathMeasure.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      this.a[i] = arrayOfFloat[0];
      this.b[i] = arrayOfFloat[1];
    } 
  }
  
  private static Path a(float paramFloat1, float paramFloat2) {
    Path path = new Path();
    path.moveTo(0.0F, 0.0F);
    path.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    return path;
  }
  
  private static Path a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Path path = new Path();
    path.moveTo(0.0F, 0.0F);
    path.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    return path;
  }
  
  public float getInterpolation(float paramFloat) {
    if (paramFloat <= 0.0F)
      return 0.0F; 
    if (paramFloat >= 1.0F)
      return 1.0F; 
    int j = 0;
    int i = this.a.length - 1;
    while (i - j > 1) {
      int k = (j + i) / 2;
      if (paramFloat < this.a[k]) {
        i = k;
        continue;
      } 
      j = k;
    } 
    float[] arrayOfFloat = this.a;
    float f = arrayOfFloat[i] - arrayOfFloat[j];
    if (f == 0.0F)
      return this.b[j]; 
    paramFloat = (paramFloat - arrayOfFloat[j]) / f;
    arrayOfFloat = this.b;
    f = arrayOfFloat[j];
    return f + paramFloat * (arrayOfFloat[i] - f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\animation\PathInterpolatorApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */