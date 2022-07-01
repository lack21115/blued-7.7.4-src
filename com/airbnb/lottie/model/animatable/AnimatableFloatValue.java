package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
  AnimatableFloatValue() {
    super(Float.valueOf(0.0F));
  }
  
  public AnimatableFloatValue(List<Keyframe<Float>> paramList) {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<Float, Float> a() {
    return (BaseKeyframeAnimation<Float, Float>)new FloatKeyframeAnimation(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableFloatValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */