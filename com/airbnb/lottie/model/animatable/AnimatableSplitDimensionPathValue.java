package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
  private final AnimatableFloatValue a;
  
  private final AnimatableFloatValue b;
  
  public AnimatableSplitDimensionPathValue(AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2) {
    this.a = paramAnimatableFloatValue1;
    this.b = paramAnimatableFloatValue2;
  }
  
  public BaseKeyframeAnimation<PointF, PointF> a() {
    return (BaseKeyframeAnimation<PointF, PointF>)new SplitDimensionPathKeyframeAnimation(this.a.a(), this.b.a());
  }
  
  public boolean b() {
    return (this.a.b() && this.b.b());
  }
  
  public List<Keyframe<PointF>> c() {
    throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableSplitDimensionPathValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */