package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapePath implements ContentModel {
  private final String a;
  
  private final int b;
  
  private final AnimatableShapeValue c;
  
  private final boolean d;
  
  public ShapePath(String paramString, int paramInt, AnimatableShapeValue paramAnimatableShapeValue, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramAnimatableShapeValue;
    this.d = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new ShapeContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public AnimatableShapeValue b() {
    return this.c;
  }
  
  public boolean c() {
    return this.d;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ShapePath{name=");
    stringBuilder.append(this.a);
    stringBuilder.append(", index=");
    stringBuilder.append(this.b);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\ShapePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */