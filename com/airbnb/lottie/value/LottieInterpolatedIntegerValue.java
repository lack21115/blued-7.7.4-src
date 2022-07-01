package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
  Integer a(Integer paramInteger1, Integer paramInteger2, float paramFloat) {
    return Integer.valueOf(MiscUtils.a(paramInteger1.intValue(), paramInteger2.intValue(), paramFloat));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieInterpolatedIntegerValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */