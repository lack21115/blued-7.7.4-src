package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
  public AnimatableColorValue(List<Keyframe<Integer>> paramList) {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<Integer, Integer> a() {
    return (BaseKeyframeAnimation<Integer, Integer>)new ColorKeyframeAnimation(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableColorValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */