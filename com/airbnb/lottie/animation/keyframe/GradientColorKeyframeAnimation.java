package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
  private final GradientColor c;
  
  public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> paramList) {
    super(paramList);
    int i = 0;
    GradientColor gradientColor = (GradientColor)((Keyframe)paramList.get(0)).a;
    if (gradientColor != null)
      i = gradientColor.c(); 
    this.c = new GradientColor(new float[i], new int[i]);
  }
  
  GradientColor b(Keyframe<GradientColor> paramKeyframe, float paramFloat) {
    this.c.a((GradientColor)paramKeyframe.a, (GradientColor)paramKeyframe.b, paramFloat);
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\GradientColorKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */