package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class CircleShape implements ContentModel {
  private final String a;
  
  private final AnimatableValue<PointF, PointF> b;
  
  private final AnimatablePointValue c;
  
  private final boolean d;
  
  private final boolean e;
  
  public CircleShape(String paramString, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatablePointValue paramAnimatablePointValue, boolean paramBoolean1, boolean paramBoolean2) {
    this.a = paramString;
    this.b = paramAnimatableValue;
    this.c = paramAnimatablePointValue;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new EllipseContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public AnimatableValue<PointF, PointF> b() {
    return this.b;
  }
  
  public AnimatablePointValue c() {
    return this.c;
  }
  
  public boolean d() {
    return this.d;
  }
  
  public boolean e() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\CircleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */