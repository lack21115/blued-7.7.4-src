package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public interface AnimatableValue<K, A> {
  BaseKeyframeAnimation<K, A> a();
  
  boolean b();
  
  List<Keyframe<K>> c();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */