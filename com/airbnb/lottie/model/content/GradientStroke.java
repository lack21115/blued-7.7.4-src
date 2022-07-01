package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class GradientStroke implements ContentModel {
  private final String a;
  
  private final GradientType b;
  
  private final AnimatableGradientColorValue c;
  
  private final AnimatableIntegerValue d;
  
  private final AnimatablePointValue e;
  
  private final AnimatablePointValue f;
  
  private final AnimatableFloatValue g;
  
  private final ShapeStroke.LineCapType h;
  
  private final ShapeStroke.LineJoinType i;
  
  private final float j;
  
  private final List<AnimatableFloatValue> k;
  
  private final AnimatableFloatValue l;
  
  private final boolean m;
  
  public GradientStroke(String paramString, GradientType paramGradientType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, ShapeStroke.LineCapType paramLineCapType, ShapeStroke.LineJoinType paramLineJoinType, float paramFloat, List<AnimatableFloatValue> paramList, AnimatableFloatValue paramAnimatableFloatValue2, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramGradientType;
    this.c = paramAnimatableGradientColorValue;
    this.d = paramAnimatableIntegerValue;
    this.e = paramAnimatablePointValue1;
    this.f = paramAnimatablePointValue2;
    this.g = paramAnimatableFloatValue1;
    this.h = paramLineCapType;
    this.i = paramLineJoinType;
    this.j = paramFloat;
    this.k = paramList;
    this.l = paramAnimatableFloatValue2;
    this.m = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new GradientStrokeContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public GradientType b() {
    return this.b;
  }
  
  public AnimatableGradientColorValue c() {
    return this.c;
  }
  
  public AnimatableIntegerValue d() {
    return this.d;
  }
  
  public AnimatablePointValue e() {
    return this.e;
  }
  
  public AnimatablePointValue f() {
    return this.f;
  }
  
  public AnimatableFloatValue g() {
    return this.g;
  }
  
  public ShapeStroke.LineCapType h() {
    return this.h;
  }
  
  public ShapeStroke.LineJoinType i() {
    return this.i;
  }
  
  public List<AnimatableFloatValue> j() {
    return this.k;
  }
  
  public AnimatableFloatValue k() {
    return this.l;
  }
  
  public float l() {
    return this.j;
  }
  
  public boolean m() {
    return this.m;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\GradientStroke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */