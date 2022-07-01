package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public final class PathInterpolatorCompat implements Interpolator {
  private float[] mX;
  
  private float[] mY;
  
  public PathInterpolatorCompat(Context paramContext, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser) {
    this(paramContext.getResources(), paramContext.getTheme(), paramAttributeSet, paramXmlPullParser);
  }
  
  private PathInterpolatorCompat(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser) {
    StringBuilder stringBuilder;
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
      String str = TypedArrayUtils.getNamedString(typedArray, paramXmlPullParser, "pathData", 4);
      Path path = PathParser.createPathFromPathData(str);
      if (path != null) {
        initPath(path);
      } else {
        stringBuilder = new StringBuilder("The path is null, which is created from ");
        stringBuilder.append(str);
        throw new InflateException(stringBuilder.toString());
      } 
    } else if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlX1")) {
      if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlY1")) {
        float f1 = TypedArrayUtils.getNamedFloat((TypedArray)stringBuilder, paramXmlPullParser, "controlX1", 0, 0.0F);
        float f2 = TypedArrayUtils.getNamedFloat((TypedArray)stringBuilder, paramXmlPullParser, "controlY1", 1, 0.0F);
        boolean bool = TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlX2");
        if (bool == TypedArrayUtils.hasAttribute(paramXmlPullParser, "controlY2")) {
          if (!bool) {
            Path path = new Path();
            path.moveTo(0.0F, 0.0F);
            path.quadTo(f1, f2, 1.0F, 1.0F);
            initPath(path);
          } else {
            float f3 = TypedArrayUtils.getNamedFloat((TypedArray)stringBuilder, paramXmlPullParser, "controlX2", 2, 0.0F);
            float f4 = TypedArrayUtils.getNamedFloat((TypedArray)stringBuilder, paramXmlPullParser, "controlY2", 3, 0.0F);
            Path path = new Path();
            path.moveTo(0.0F, 0.0F);
            path.cubicTo(f1, f2, f3, f4, 1.0F, 1.0F);
            initPath(path);
          } 
        } else {
          throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        } 
      } else {
        throw new InflateException("pathInterpolator requires the controlY1 attribute");
      } 
    } else {
      throw new InflateException("pathInterpolator requires the controlX1 attribute");
    } 
    stringBuilder.recycle();
  }
  
  private void initPath(Path paramPath) {
    int i = 0;
    PathMeasure pathMeasure = new PathMeasure(paramPath, false);
    float f = pathMeasure.getLength();
    int j = Math.min(3000, (int)(f / 0.002F) + 1);
    if (j > 0) {
      this.mX = new float[j];
      this.mY = new float[j];
      float[] arrayOfFloat = new float[2];
      int k;
      for (k = 0; k < j; k++) {
        pathMeasure.getPosTan(k * f / (j - 1), arrayOfFloat, null);
        this.mX[k] = arrayOfFloat[0];
        this.mY[k] = arrayOfFloat[1];
      } 
      if (Math.abs(this.mX[0]) <= 1.0E-5D && Math.abs(this.mY[0]) <= 1.0E-5D) {
        arrayOfFloat = this.mX;
        k = j - 1;
        if (Math.abs(arrayOfFloat[k] - 1.0F) <= 1.0E-5D && Math.abs(this.mY[k] - 1.0F) <= 1.0E-5D) {
          StringBuilder stringBuilder2;
          k = 0;
          f = 0.0F;
          while (i < j) {
            float f1 = this.mX[k];
            if (f1 >= f) {
              this.mX[i] = f1;
              i++;
              f = f1;
              k++;
              continue;
            } 
            stringBuilder2 = new StringBuilder("The Path cannot loop back on itself, x :");
            stringBuilder2.append(f1);
            throw new IllegalArgumentException(stringBuilder2.toString());
          } 
          if (!stringBuilder2.nextContour())
            return; 
          throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
      stringBuilder1.append(this.mX[0]);
      stringBuilder1.append(",");
      stringBuilder1.append(this.mY[0]);
      stringBuilder1.append(" end:");
      arrayOfFloat = this.mX;
      k = j - 1;
      stringBuilder1.append(arrayOfFloat[k]);
      stringBuilder1.append(",");
      stringBuilder1.append(this.mY[k]);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder("The Path has a invalid length ");
    stringBuilder.append(f);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final float getInterpolation(float paramFloat) {
    if (paramFloat <= 0.0F)
      return 0.0F; 
    if (paramFloat >= 1.0F)
      return 1.0F; 
    int j = 0;
    int i = this.mX.length - 1;
    while (i - j > 1) {
      int k = (j + i) / 2;
      if (paramFloat < this.mX[k]) {
        i = k;
        continue;
      } 
      j = k;
    } 
    float f = this.mX[i] - this.mX[j];
    if (f == 0.0F)
      return this.mY[j]; 
    paramFloat = (paramFloat - this.mX[j]) / f;
    f = this.mY[j];
    return f + paramFloat * (this.mY[i] - f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\PathInterpolatorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */