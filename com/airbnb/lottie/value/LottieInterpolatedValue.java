package com.airbnb.lottie.value;

import android.view.animation.Interpolator;

abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {
  private final T a;
  
  private final T c;
  
  private final Interpolator d;
  
  public T a(LottieFrameInfo<T> paramLottieFrameInfo) {
    float f = this.d.getInterpolation(paramLottieFrameInfo.d());
    return a(this.a, this.c, f);
  }
  
  abstract T a(T paramT1, T paramT2, float paramFloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieInterpolatedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */