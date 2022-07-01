package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeFill implements ContentModel {
  private final boolean a;
  
  private final Path.FillType b;
  
  private final String c;
  
  private final AnimatableColorValue d;
  
  private final AnimatableIntegerValue e;
  
  private final boolean f;
  
  public ShapeFill(String paramString, boolean paramBoolean1, Path.FillType paramFillType, AnimatableColorValue paramAnimatableColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, boolean paramBoolean2) {
    this.c = paramString;
    this.a = paramBoolean1;
    this.b = paramFillType;
    this.d = paramAnimatableColorValue;
    this.e = paramAnimatableIntegerValue;
    this.f = paramBoolean2;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new FillContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.c;
  }
  
  public AnimatableColorValue b() {
    return this.d;
  }
  
  public AnimatableIntegerValue c() {
    return this.e;
  }
  
  public Path.FillType d() {
    return this.b;
  }
  
  public boolean e() {
    return this.f;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ShapeFill{color=, fillEnabled=");
    stringBuilder.append(this.a);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\ShapeFill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */