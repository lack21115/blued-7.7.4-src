package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
  public IntegerKeyframeAnimation(List<Keyframe<Integer>> paramList) {
    super(paramList);
  }
  
  Integer b(Keyframe<Integer> paramKeyframe, float paramFloat) {
    return Integer.valueOf(c(paramKeyframe, paramFloat));
  }
  
  int c(Keyframe<Integer> paramKeyframe, float paramFloat) {
    if (paramKeyframe.a != null && paramKeyframe.b != null) {
      if (this.b != null) {
        Integer integer = (Integer)this.b.a(paramKeyframe.d, paramKeyframe.e.floatValue(), paramKeyframe.a, paramKeyframe.b, paramFloat, d(), h());
        if (integer != null)
          return integer.intValue(); 
      } 
      return MiscUtils.a(paramKeyframe.h(), paramKeyframe.i(), paramFloat);
    } 
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  public int i() {
    return c(c(), e());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\IntegerKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */