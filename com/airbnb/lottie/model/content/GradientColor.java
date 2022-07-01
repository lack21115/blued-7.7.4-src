package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

public class GradientColor {
  private final float[] a;
  
  private final int[] b;
  
  public GradientColor(float[] paramArrayOffloat, int[] paramArrayOfint) {
    this.a = paramArrayOffloat;
    this.b = paramArrayOfint;
  }
  
  public void a(GradientColor paramGradientColor1, GradientColor paramGradientColor2, float paramFloat) {
    if (paramGradientColor1.b.length == paramGradientColor2.b.length) {
      int i;
      for (i = 0; i < paramGradientColor1.b.length; i++) {
        this.a[i] = MiscUtils.a(paramGradientColor1.a[i], paramGradientColor2.a[i], paramFloat);
        this.b[i] = GammaEvaluator.a(paramFloat, paramGradientColor1.b[i], paramGradientColor2.b[i]);
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot interpolate between gradients. Lengths vary (");
    stringBuilder.append(paramGradientColor1.b.length);
    stringBuilder.append(" vs ");
    stringBuilder.append(paramGradientColor2.b.length);
    stringBuilder.append(")");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public float[] a() {
    return this.a;
  }
  
  public int[] b() {
    return this.b;
  }
  
  public int c() {
    return this.b.length;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\GradientColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */