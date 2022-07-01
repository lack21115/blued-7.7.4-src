package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
  private final ScaleXY c = new ScaleXY();
  
  public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> paramList) {
    super(paramList);
  }
  
  public ScaleXY b(Keyframe<ScaleXY> paramKeyframe, float paramFloat) {
    if (paramKeyframe.a != null && paramKeyframe.b != null) {
      ScaleXY scaleXY1 = (ScaleXY)paramKeyframe.a;
      ScaleXY scaleXY2 = (ScaleXY)paramKeyframe.b;
      if (this.b != null) {
        ScaleXY scaleXY = (ScaleXY)this.b.a(paramKeyframe.d, paramKeyframe.e.floatValue(), scaleXY1, scaleXY2, paramFloat, d(), h());
        if (scaleXY != null)
          return scaleXY; 
      } 
      this.c.a(MiscUtils.a(scaleXY1.a(), scaleXY2.a(), paramFloat), MiscUtils.a(scaleXY1.b(), scaleXY2.b(), paramFloat));
      return this.c;
    } 
    throw new IllegalStateException("Missing values for keyframe.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\ScaleKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */