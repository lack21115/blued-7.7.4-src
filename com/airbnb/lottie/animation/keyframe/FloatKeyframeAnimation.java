package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
  public FloatKeyframeAnimation(List<Keyframe<Float>> paramList) {
    super(paramList);
  }
  
  Float b(Keyframe<Float> paramKeyframe, float paramFloat) {
    return Float.valueOf(c(paramKeyframe, paramFloat));
  }
  
  float c(Keyframe<Float> paramKeyframe, float paramFloat) {
    if (paramKeyframe.a != null && paramKeyframe.b != null) {
      if (this.b != null) {
        Float float_ = (Float)this.b.a(paramKeyframe.d, paramKeyframe.e.floatValue(), paramKeyframe.a, paramKeyframe.b, paramFloat, d(), h());
        if (float_ != null)
          return float_.floatValue(); 
      } 
      return MiscUtils.a(paramKeyframe.f(), paramKeyframe.g(), paramFloat);
    } 
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  public float i() {
    return c(c(), e());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\FloatKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */