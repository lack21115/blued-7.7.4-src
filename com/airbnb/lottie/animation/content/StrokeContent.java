package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class StrokeContent extends BaseStrokeContent {
  private final BaseLayer c;
  
  private final String d;
  
  private final boolean e;
  
  private final BaseKeyframeAnimation<Integer, Integer> f;
  
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> g;
  
  public StrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeStroke paramShapeStroke) {
    super(paramLottieDrawable, paramBaseLayer, paramShapeStroke.g().a(), paramShapeStroke.h().a(), paramShapeStroke.i(), paramShapeStroke.c(), paramShapeStroke.d(), paramShapeStroke.e(), paramShapeStroke.f());
    this.c = paramBaseLayer;
    this.d = paramShapeStroke.a();
    this.e = paramShapeStroke.j();
    this.f = paramShapeStroke.b().a();
    this.f.a(this);
    paramBaseLayer.a(this.f);
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    if (this.e)
      return; 
    this.b.setColor(((ColorKeyframeAnimation)this.f).i());
    if (this.g != null)
      this.b.setColorFilter((ColorFilter)this.g.g()); 
    super.a(paramCanvas, paramMatrix, paramInt);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    super.a(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.b) {
      this.f.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.B) {
      if (paramLottieValueCallback == null) {
        this.g = null;
        return;
      } 
      this.g = (BaseKeyframeAnimation<ColorFilter, ColorFilter>)new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.g.a(this);
      this.c.a(this.f);
    } 
  }
  
  public String b() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\StrokeContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */