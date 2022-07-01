package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class PolystarShape implements ContentModel {
  private final String a;
  
  private final Type b;
  
  private final AnimatableFloatValue c;
  
  private final AnimatableValue<PointF, PointF> d;
  
  private final AnimatableFloatValue e;
  
  private final AnimatableFloatValue f;
  
  private final AnimatableFloatValue g;
  
  private final AnimatableFloatValue h;
  
  private final AnimatableFloatValue i;
  
  private final boolean j;
  
  public PolystarShape(String paramString, Type paramType, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableFloatValue paramAnimatableFloatValue3, AnimatableFloatValue paramAnimatableFloatValue4, AnimatableFloatValue paramAnimatableFloatValue5, AnimatableFloatValue paramAnimatableFloatValue6, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramType;
    this.c = paramAnimatableFloatValue1;
    this.d = paramAnimatableValue;
    this.e = paramAnimatableFloatValue2;
    this.f = paramAnimatableFloatValue3;
    this.g = paramAnimatableFloatValue4;
    this.h = paramAnimatableFloatValue5;
    this.i = paramAnimatableFloatValue6;
    this.j = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new PolystarContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public Type b() {
    return this.b;
  }
  
  public AnimatableFloatValue c() {
    return this.c;
  }
  
  public AnimatableValue<PointF, PointF> d() {
    return this.d;
  }
  
  public AnimatableFloatValue e() {
    return this.e;
  }
  
  public AnimatableFloatValue f() {
    return this.f;
  }
  
  public AnimatableFloatValue g() {
    return this.g;
  }
  
  public AnimatableFloatValue h() {
    return this.h;
  }
  
  public AnimatableFloatValue i() {
    return this.i;
  }
  
  public boolean j() {
    return this.j;
  }
  
  public enum Type {
    a(1),
    b(2);
    
    private final int c;
    
    Type(int param1Int1) {
      this.c = param1Int1;
    }
    
    public static Type a(int param1Int) {
      for (Type type : values()) {
        if (type.c == param1Int)
          return type; 
      } 
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\PolystarShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */