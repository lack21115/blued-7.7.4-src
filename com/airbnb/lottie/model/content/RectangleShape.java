package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class RectangleShape implements ContentModel {
  private final String a;
  
  private final AnimatableValue<PointF, PointF> b;
  
  private final AnimatablePointValue c;
  
  private final AnimatableFloatValue d;
  
  private final boolean e;
  
  public RectangleShape(String paramString, AnimatableValue<PointF, PointF> paramAnimatableValue, AnimatablePointValue paramAnimatablePointValue, AnimatableFloatValue paramAnimatableFloatValue, boolean paramBoolean) {
    this.a = paramString;
    this.b = paramAnimatableValue;
    this.c = paramAnimatablePointValue;
    this.d = paramAnimatableFloatValue;
    this.e = paramBoolean;
  }
  
  public Content a(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer) {
    return (Content)new RectangleContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  public String a() {
    return this.a;
  }
  
  public AnimatableFloatValue b() {
    return this.d;
  }
  
  public AnimatablePointValue c() {
    return this.c;
  }
  
  public AnimatableValue<PointF, PointF> d() {
    return this.b;
  }
  
  public boolean e() {
    return this.e;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RectangleShape{position=");
    stringBuilder.append(this.b);
    stringBuilder.append(", size=");
    stringBuilder.append(this.c);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\RectangleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */