package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
  private static final float a = (float)Math.tan(Math.toRadians(35.0D));
  
  private float b = 0.0F;
  
  private float c = 0.0F;
  
  private float d = 70.0F;
  
  private float e = 0.0F;
  
  private float f = 0.0F;
  
  private float g = a;
  
  public ArcMotion() {}
  
  public ArcMotion(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.j);
    XmlPullParser xmlPullParser = (XmlPullParser)paramAttributeSet;
    setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "minimumVerticalAngle", 1, 0.0F));
    setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "minimumHorizontalAngle", 0, 0.0F));
    setMaximumAngle(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "maximumAngle", 2, 70.0F));
    typedArray.recycle();
  }
  
  private static float a(float paramFloat) {
    if (paramFloat >= 0.0F && paramFloat <= 90.0F)
      return (float)Math.tan(Math.toRadians((paramFloat / 2.0F))); 
    throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
  }
  
  public float getMaximumAngle() {
    return this.d;
  }
  
  public float getMinimumHorizontalAngle() {
    return this.b;
  }
  
  public float getMinimumVerticalAngle() {
    return this.c;
  }
  
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    boolean bool;
    Path path = new Path();
    path.moveTo(paramFloat1, paramFloat2);
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = f1 * f1 + f2 * f2;
    float f7 = (paramFloat1 + paramFloat3) / 2.0F;
    float f6 = (paramFloat2 + paramFloat4) / 2.0F;
    float f4 = 0.25F * f3;
    if (paramFloat2 > paramFloat4) {
      bool = true;
    } else {
      bool = false;
    } 
    if (Math.abs(f1) < Math.abs(f2)) {
      f1 = Math.abs(f3 / f2 * 2.0F);
      if (bool) {
        f1 += paramFloat4;
        f2 = paramFloat3;
      } else {
        f1 += paramFloat2;
        f2 = paramFloat1;
      } 
      f3 = this.f;
    } else {
      f2 = f3 / f1 * 2.0F;
      if (bool) {
        f1 = paramFloat2;
        f2 += paramFloat1;
      } else {
        f2 = paramFloat3 - f2;
        f1 = paramFloat4;
      } 
      f3 = this.e;
    } 
    f3 = f4 * f3 * f3;
    float f5 = f7 - f2;
    float f8 = f6 - f1;
    f8 = f5 * f5 + f8 * f8;
    f5 = this.g;
    f4 = f4 * f5 * f5;
    if (f8 >= f3)
      if (f8 > f4) {
        f3 = f4;
      } else {
        f3 = 0.0F;
      }  
    f5 = f2;
    f4 = f1;
    if (f3 != 0.0F) {
      f3 = (float)Math.sqrt((f3 / f8));
      f5 = (f2 - f7) * f3 + f7;
      f4 = f6 + f3 * (f1 - f6);
    } 
    path.cubicTo((paramFloat1 + f5) / 2.0F, (paramFloat2 + f4) / 2.0F, (f5 + paramFloat3) / 2.0F, (f4 + paramFloat4) / 2.0F, paramFloat3, paramFloat4);
    return path;
  }
  
  public void setMaximumAngle(float paramFloat) {
    this.d = paramFloat;
    this.g = a(paramFloat);
  }
  
  public void setMinimumHorizontalAngle(float paramFloat) {
    this.b = paramFloat;
    this.e = a(paramFloat);
  }
  
  public void setMinimumVerticalAngle(float paramFloat) {
    this.c = paramFloat;
    this.f = a(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ArcMotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */