package com.airbnb.lottie.model.animatable;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
  public AnimatableShapeValue(List<Keyframe<ShapeData>> paramList) {
    super(paramList);
  }
  
  public BaseKeyframeAnimation<ShapeData, Path> a() {
    return (BaseKeyframeAnimation<ShapeData, Path>)new ShapeKeyframeAnimation(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableShapeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */