package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ScaleKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
  AnimatableScaleValue() {
    this(new ScaleXY(1.0F, 1.0F));
  }
  
  public AnimatableScaleValue(ScaleXY paramScaleXY) {
    super(paramScaleXY);
  }
  
  public AnimatableScaleValue(List<Keyframe<ScaleXY>> paramList) {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<ScaleXY, ScaleXY> a() {
    return (BaseKeyframeAnimation<ScaleXY, ScaleXY>)new ScaleKeyframeAnimation(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableScaleValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */