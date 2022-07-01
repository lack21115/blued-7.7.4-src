package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeStroke implements ContentModel {
  private final String a;
  
  private final AnimatableFloatValue b;
  
  private final List<AnimatableFloatValue> c;
  
  private final AnimatableColorValue d;
  
  private final AnimatableIntegerValue e;
  
  private final AnimatableFloatValue f;
  
  private final LineCapType g;
  
  private final LineJoinType h;
  
  private final float i;
  
  private final boolean j;
  
  public ShapeStroke(String paramString, AnimatableFloatValue paramAnimatableFloatValue1, List<AnimatableFloatValue> paramList, AnimatableColorValue paramAnimatableColorValue, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatableFloatValue paramAnimatableFloatValue2, LineCapType paramLineCapType, LineJoinType paramLineJoinType, float paramFloat, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramAnimatableFloatValue1;
    this.c = paramList;
    this.d = paramAnimatableColorValue;
    this.e = paramAnimatableIntegerValue;
    this.f = paramAnimatableFloatValue2;
    this.g = paramLineCapType;
    this.h = paramLineJoinType;
    this.i = paramFloat;
    this.j = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new StrokeContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public AnimatableColorValue b() {
    return this.d;
  }
  
  public AnimatableIntegerValue c() {
    return this.e;
  }
  
  public AnimatableFloatValue d() {
    return this.f;
  }
  
  public List<AnimatableFloatValue> e() {
    return this.c;
  }
  
  public AnimatableFloatValue f() {
    return this.b;
  }
  
  public LineCapType g() {
    return this.g;
  }
  
  public LineJoinType h() {
    return this.h;
  }
  
  public float i() {
    return this.i;
  }
  
  public boolean j() {
    return this.j;
  }
  
  public enum LineCapType {
    a, b, c;
    
    public Paint.Cap a() {
      int i = ShapeStroke.null.a[ordinal()];
      return (i != 1) ? ((i != 2) ? Paint.Cap.SQUARE : Paint.Cap.ROUND) : Paint.Cap.BUTT;
    }
  }
  
  public enum LineJoinType {
    a, b, c;
    
    public Paint.Join a() {
      int i = ShapeStroke.null.b[ordinal()];
      return (i != 1) ? ((i != 2) ? ((i != 3) ? null : Paint.Join.ROUND) : Paint.Join.MITER) : Paint.Join.BEVEL;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\ShapeStroke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */