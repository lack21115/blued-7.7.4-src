package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

public class Repeater implements ContentModel {
  private final String a;
  
  private final AnimatableFloatValue b;
  
  private final AnimatableFloatValue c;
  
  private final AnimatableTransform d;
  
  private final boolean e;
  
  public Repeater(String paramString, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableTransform paramAnimatableTransform, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramAnimatableFloatValue1;
    this.c = paramAnimatableFloatValue2;
    this.d = paramAnimatableTransform;
    this.e = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new RepeaterContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public AnimatableFloatValue b() {
    return this.b;
  }
  
  public AnimatableFloatValue c() {
    return this.c;
  }
  
  public AnimatableTransform d() {
    return this.d;
  }
  
  public boolean e() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\Repeater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */