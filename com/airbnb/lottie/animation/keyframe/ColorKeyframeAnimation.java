package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
  public ColorKeyframeAnimation(List<Keyframe<Integer>> paramList) {
    super(paramList);
  }
  
  Integer b(Keyframe<Integer> paramKeyframe, float paramFloat) {
    return Integer.valueOf(c(paramKeyframe, paramFloat));
  }
  
  public int c(Keyframe<Integer> paramKeyframe, float paramFloat) {
    if (paramKeyframe.a != null && paramKeyframe.b != null) {
      int i = ((Integer)paramKeyframe.a).intValue();
      int j = ((Integer)paramKeyframe.b).intValue();
      if (this.b != null) {
        Integer integer = (Integer)this.b.a(paramKeyframe.d, paramKeyframe.e.floatValue(), Integer.valueOf(i), Integer.valueOf(j), paramFloat, d(), h());
        if (integer != null)
          return integer.intValue(); 
      } 
      return GammaEvaluator.a(MiscUtils.b(paramFloat, 0.0F, 1.0F), i, j);
    } 
    throw new IllegalStateException("Missing values for keyframe.");
  }
  
  public int i() {
    return c(c(), e());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\ColorKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */