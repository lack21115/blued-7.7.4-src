package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

public class LottieValueCallback<T> {
  private final LottieFrameInfo<T> a = new LottieFrameInfo<T>();
  
  protected T b = null;
  
  private BaseKeyframeAnimation<?, ?> c;
  
  public LottieValueCallback() {}
  
  public LottieValueCallback(T paramT) {
    this.b = paramT;
  }
  
  public final T a(float paramFloat1, float paramFloat2, T paramT1, T paramT2, float paramFloat3, float paramFloat4, float paramFloat5) {
    return a(this.a.a(paramFloat1, paramFloat2, paramT1, paramT2, paramFloat3, paramFloat4, paramFloat5));
  }
  
  public T a(LottieFrameInfo<T> paramLottieFrameInfo) {
    return this.b;
  }
  
  public final void a(BaseKeyframeAnimation<?, ?> paramBaseKeyframeAnimation) {
    this.c = paramBaseKeyframeAnimation;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieValueCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */