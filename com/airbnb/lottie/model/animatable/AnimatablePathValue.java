package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
  private final List<Keyframe<PointF>> a = Collections.singletonList(new Keyframe(new PointF(0.0F, 0.0F)));
  
  public AnimatablePathValue() {}
  
  public AnimatablePathValue(List<Keyframe<PointF>> paramList) {}
  
  public BaseKeyframeAnimation<PointF, PointF> a() {
    return (BaseKeyframeAnimation<PointF, PointF>)(((Keyframe)this.a.get(0)).e() ? new PointKeyframeAnimation(this.a) : new PathKeyframeAnimation(this.a));
  }
  
  public boolean b() {
    int i = this.a.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1) {
      bool1 = bool2;
      if (((Keyframe)this.a.get(0)).e())
        bool1 = true; 
    } 
    return bool1;
  }
  
  public List<Keyframe<PointF>> c() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatablePathValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */