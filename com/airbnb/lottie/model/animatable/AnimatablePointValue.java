package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
  public AnimatablePointValue(List<Keyframe<PointF>> paramList) {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<PointF, PointF> a() {
    return (BaseKeyframeAnimation<PointF, PointF>)new PointKeyframeAnimation(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatablePointValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */