package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

public class AnimatableTransform implements ModifierContent, ContentModel {
  private final AnimatablePathValue a;
  
  private final AnimatableValue<PointF, PointF> b;
  
  private final AnimatableScaleValue c;
  
  private final AnimatableFloatValue d;
  
  private final AnimatableIntegerValue e;
  
  private final AnimatableFloatValue f;
  
  private final AnimatableFloatValue g;
  
  private final AnimatableFloatValue h;
  
  private final AnimatableFloatValue i;
  
  public AnimatableTransform() {
    this(null, null, null, null, null, null, null, null, null);
  }
  
  public AnimatableTransform(AnimatablePathValue paramAnimatablePathValue, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatableScaleValue paramAnimatableScaleValue, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableFloatValue paramAnimatableFloatValue3, AnimatableFloatValue paramAnimatableFloatValue4, AnimatableFloatValue paramAnimatableFloatValue5) {
    this.a = paramAnimatablePathValue;
    this.b = paramAnimatableValue;
    this.c = paramAnimatableScaleValue;
    this.d = paramAnimatableFloatValue1;
    this.e = paramAnimatableIntegerValue;
    this.h = paramAnimatableFloatValue2;
    this.i = paramAnimatableFloatValue3;
    this.f = paramAnimatableFloatValue4;
    this.g = paramAnimatableFloatValue5;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return null;
  }
  
  public AnimatablePathValue a() {
    return this.a;
  }
  
  public AnimatableValue<PointF, PointF> b() {
    return this.b;
  }
  
  public AnimatableScaleValue c() {
    return this.c;
  }
  
  public AnimatableFloatValue d() {
    return this.d;
  }
  
  public AnimatableIntegerValue e() {
    return this.e;
  }
  
  public AnimatableFloatValue f() {
    return this.h;
  }
  
  public AnimatableFloatValue g() {
    return this.i;
  }
  
  public AnimatableFloatValue h() {
    return this.f;
  }
  
  public AnimatableFloatValue i() {
    return this.g;
  }
  
  public TransformKeyframeAnimation j() {
    return new TransformKeyframeAnimation(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\animatable\AnimatableTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */