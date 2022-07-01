package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
  private final PointF a;
  
  PointF a(PointF paramPointF1, PointF paramPointF2, float paramFloat) {
    this.a.set(MiscUtils.a(paramPointF1.x, paramPointF2.x, paramFloat), MiscUtils.a(paramPointF1.y, paramPointF2.y, paramFloat));
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieInterpolatedPointValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */