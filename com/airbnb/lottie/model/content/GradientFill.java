package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class GradientFill implements ContentModel {
  private final GradientType a;
  
  private final Path.FillType b;
  
  private final AnimatableGradientColorValue c;
  
  private final AnimatableIntegerValue d;
  
  private final AnimatablePointValue e;
  
  private final AnimatablePointValue f;
  
  private final String g;
  
  private final AnimatableFloatValue h;
  
  private final AnimatableFloatValue i;
  
  private final boolean j;
  
  public GradientFill(String paramString, GradientType paramGradientType, Path.FillType paramFillType, AnimatableGradientColorValue paramAnimatableGradientColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatablePointValue paramAnimatablePointValue1, AnimatablePointValue paramAnimatablePointValue2, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, boolean paramBoolean) {
    this.a = paramGradientType;
    this.b = paramFillType;
    this.c = paramAnimatableGradientColorValue;
    this.d = paramAnimatableIntegerValue;
    this.e = paramAnimatablePointValue1;
    this.f = paramAnimatablePointValue2;
    this.g = paramString;
    this.h = paramAnimatableFloatValue1;
    this.i = paramAnimatableFloatValue2;
    this.j = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new GradientFillContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.g;
  }
  
  public GradientType b() {
    return this.a;
  }
  
  public Path.FillType c() {
    return this.b;
  }
  
  public AnimatableGradientColorValue d() {
    return this.c;
  }
  
  public AnimatableIntegerValue e() {
    return this.d;
  }
  
  public AnimatablePointValue f() {
    return this.e;
  }
  
  public AnimatablePointValue g() {
    return this.f;
  }
  
  public boolean h() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\GradientFill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */