package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
  private final ShapeData c = new ShapeData();
  
  private final Path d = new Path();
  
  public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> paramList) {
    super(paramList);
  }
  
  public Path b(Keyframe<ShapeData> paramKeyframe, float paramFloat) {
    ShapeData shapeData2 = (ShapeData)paramKeyframe.a;
    ShapeData shapeData1 = (ShapeData)paramKeyframe.b;
    this.c.a(shapeData2, shapeData1, paramFloat);
    MiscUtils.a(this.c, this.d);
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\ShapeKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */