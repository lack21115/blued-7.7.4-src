package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
  private final LottieFrameInfo<A> c = new LottieFrameInfo();
  
  private final A d;
  
  public ValueCallbackKeyframeAnimation(LottieValueCallback<A> paramLottieValueCallback) {
    this(paramLottieValueCallback, (A)null);
  }
  
  public ValueCallbackKeyframeAnimation(LottieValueCallback<A> paramLottieValueCallback, A paramA) {
    super(Collections.emptyList());
    a(paramLottieValueCallback);
    this.d = paramA;
  }
  
  A a(Keyframe<K> paramKeyframe, float paramFloat) {
    return g();
  }
  
  public void b() {
    if (this.b != null)
      super.b(); 
  }
  
  float f() {
    return 1.0F;
  }
  
  public A g() {
    LottieValueCallback<A> lottieValueCallback = this.b;
    A a = this.d;
    return (A)lottieValueCallback.a(0.0F, 0.0F, a, a, h(), h(), h());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\ValueCallbackKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */