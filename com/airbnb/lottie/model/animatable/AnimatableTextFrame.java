package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {
  public AnimatableTextFrame(List<Keyframe<DocumentData>> paramList) {
    super(paramList);
  }
  
  public TextKeyframeAnimation d() {
    return new TextKeyframeAnimation(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableTextFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */