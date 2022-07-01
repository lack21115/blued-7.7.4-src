package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
  private final PointF c = new PointF();
  
  public PointKeyframeAnimation(List<Keyframe<PointF>> paramList) {
    super(paramList);
  }
  
  public PointF b(Keyframe<PointF> paramKeyframe, float paramFloat) {
    if (paramKeyframe.a != null && paramKeyframe.b != null) {
      PointF pointF1 = (PointF)paramKeyframe.a;
      PointF pointF2 = (PointF)paramKeyframe.b;
      if (this.b != null) {
        PointF pointF = (PointF)this.b.a(paramKeyframe.d, paramKeyframe.e.floatValue(), pointF1, pointF2, paramFloat, d(), h());
        if (pointF != null)
          return pointF; 
      } 
      this.c.set(pointF1.x + (pointF2.x - pointF1.x) * paramFloat, pointF1.y + paramFloat * (pointF2.y - pointF1.y));
      return this.c;
    } 
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\PointKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */