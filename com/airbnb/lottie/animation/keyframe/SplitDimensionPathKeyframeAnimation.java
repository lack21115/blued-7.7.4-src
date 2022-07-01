package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
  private final PointF c = new PointF();
  
  private final BaseKeyframeAnimation<Float, Float> d;
  
  private final BaseKeyframeAnimation<Float, Float> e;
  
  public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> paramBaseKeyframeAnimation1, BaseKeyframeAnimation<Float, Float> paramBaseKeyframeAnimation2) {
    super(Collections.emptyList());
    this.d = paramBaseKeyframeAnimation1;
    this.e = paramBaseKeyframeAnimation2;
    a(h());
  }
  
  public void a(float paramFloat) {
    this.d.a(paramFloat);
    this.e.a(paramFloat);
    this.c.set(((Float)this.d.g()).floatValue(), ((Float)this.e.g()).floatValue());
    for (int i = 0; i < this.a.size(); i++)
      ((BaseKeyframeAnimation.AnimationListener)this.a.get(i)).a(); 
  }
  
  PointF b(Keyframe<PointF> paramKeyframe, float paramFloat) {
    return this.c;
  }
  
  public PointF i() {
    return b((Keyframe<PointF>)null, 0.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\SplitDimensionPathKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */