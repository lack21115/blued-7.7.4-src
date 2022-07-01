package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeTrimPath implements ContentModel {
  private final String a;
  
  private final Type b;
  
  private final AnimatableFloatValue c;
  
  private final AnimatableFloatValue d;
  
  private final AnimatableFloatValue e;
  
  private final boolean f;
  
  public ShapeTrimPath(String paramString, Type paramType, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableFloatValue paramAnimatableFloatValue3, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramType;
    this.c = paramAnimatableFloatValue1;
    this.d = paramAnimatableFloatValue2;
    this.e = paramAnimatableFloatValue3;
    this.f = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new TrimPathContent(paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public Type b() {
    return this.b;
  }
  
  public AnimatableFloatValue c() {
    return this.d;
  }
  
  public AnimatableFloatValue d() {
    return this.c;
  }
  
  public AnimatableFloatValue e() {
    return this.e;
  }
  
  public boolean f() {
    return this.f;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Trim Path: {start: ");
    stringBuilder.append(this.c);
    stringBuilder.append(", end: ");
    stringBuilder.append(this.d);
    stringBuilder.append(", offset: ");
    stringBuilder.append(this.e);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public enum Type {
    a, b;
    
    public static Type a(int param1Int) {
      if (param1Int != 1) {
        if (param1Int == 2)
          return b; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown trim path type ");
        stringBuilder.append(param1Int);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\ShapeTrimPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */