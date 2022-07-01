package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
  public Float b(LottieFrameInfo<Float> paramLottieFrameInfo) {
    return Float.valueOf(MiscUtils.a(((Float)paramLottieFrameInfo.a()).floatValue(), ((Float)paramLottieFrameInfo.b()).floatValue(), paramLottieFrameInfo.c()) + c(paramLottieFrameInfo).floatValue());
  }
  
  public Float c(LottieFrameInfo<Float> paramLottieFrameInfo) {
    if (this.b != null)
      return this.b; 
    throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieRelativeFloatValueCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */