package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
  public AnimatableGradientColorValue(List<Keyframe<GradientColor>> paramList) {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<GradientColor, GradientColor> a() {
    return (BaseKeyframeAnimation<GradientColor, GradientColor>)new GradientColorKeyframeAnimation(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableGradientColorValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */