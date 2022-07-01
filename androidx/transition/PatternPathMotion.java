package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
  private Path a;
  
  private final Path b = new Path();
  
  private final Matrix c = new Matrix();
  
  public PatternPathMotion() {
    this.b.lineTo(1.0F, 0.0F);
    this.a = this.b;
  }
  
  public PatternPathMotion(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.k);
    try {
      String str = TypedArrayUtils.getNamedString(typedArray, (XmlPullParser)paramAttributeSet, "patternPathData", 0);
      if (str != null) {
        setPatternPath(PathParser.createPathFromPathData(str));
        return;
      } 
      throw new RuntimeException("pathData must be supplied for patternPathMotion");
    } finally {
      typedArray.recycle();
    } 
  }
  
  public PatternPathMotion(Path paramPath) {
    setPatternPath(paramPath);
  }
  
  private static float a(float paramFloat1, float paramFloat2) {
    return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
  }
  
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    paramFloat3 -= paramFloat1;
    paramFloat4 -= paramFloat2;
    float f = a(paramFloat3, paramFloat4);
    double d = Math.atan2(paramFloat4, paramFloat3);
    this.c.setScale(f, f);
    this.c.postRotate((float)Math.toDegrees(d));
    this.c.postTranslate(paramFloat1, paramFloat2);
    Path path = new Path();
    this.b.transform(this.c, path);
    return path;
  }
  
  public Path getPatternPath() {
    return this.a;
  }
  
  public void setPatternPath(Path paramPath) {
    PathMeasure pathMeasure = new PathMeasure(paramPath, false);
    float f1 = pathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    pathMeasure.getPosTan(f1, arrayOfFloat, null);
    float f3 = arrayOfFloat[0];
    f1 = arrayOfFloat[1];
    pathMeasure.getPosTan(0.0F, arrayOfFloat, null);
    float f4 = arrayOfFloat[0];
    float f2 = arrayOfFloat[1];
    if (f4 != f3 || f2 != f1) {
      this.c.setTranslate(-f4, -f2);
      f3 -= f4;
      f1 -= f2;
      f2 = 1.0F / a(f3, f1);
      this.c.postScale(f2, f2);
      double d = Math.atan2(f1, f3);
      this.c.postRotate((float)Math.toDegrees(-d));
      paramPath.transform(this.c, this.b);
      this.a = paramPath;
      return;
    } 
    throw new IllegalArgumentException("pattern must not end at the starting point");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\PatternPathMotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */