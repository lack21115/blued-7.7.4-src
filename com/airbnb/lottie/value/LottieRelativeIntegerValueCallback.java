package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
  public Integer b(LottieFrameInfo<Integer> paramLottieFrameInfo) {
    return Integer.valueOf(MiscUtils.a(((Integer)paramLottieFrameInfo.a()).intValue(), ((Integer)paramLottieFrameInfo.b()).intValue(), paramLottieFrameInfo.c()) + c(paramLottieFrameInfo).intValue());
  }
  
  public Integer c(LottieFrameInfo<Integer> paramLottieFrameInfo) {
    if (this.b != null)
      return this.b; 
    throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieRelativeIntegerValueCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */