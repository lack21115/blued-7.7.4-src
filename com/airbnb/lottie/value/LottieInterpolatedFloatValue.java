package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
  Float a(Float paramFloat1, Float paramFloat2, float paramFloat) {
    return Float.valueOf(MiscUtils.a(paramFloat1.floatValue(), paramFloat2.floatValue(), paramFloat));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieInterpolatedFloatValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */