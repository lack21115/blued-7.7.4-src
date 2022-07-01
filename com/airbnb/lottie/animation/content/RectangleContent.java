package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
  private final Path a = new Path();
  
  private final RectF b = new RectF();
  
  private final String c;
  
  private final boolean d;
  
  private final LottieDrawable e;
  
  private final BaseKeyframeAnimation<?, PointF> f;
  
  private final BaseKeyframeAnimation<?, PointF> g;
  
  private final BaseKeyframeAnimation<?, Float> h;
  
  private CompoundTrimPathContent i = new CompoundTrimPathContent();
  
  private boolean j;
  
  public RectangleContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, RectangleShape paramRectangleShape) {
    this.c = paramRectangleShape.a();
    this.d = paramRectangleShape.e();
    this.e = paramLottieDrawable;
    this.f = paramRectangleShape.d().a();
    this.g = paramRectangleShape.c().a();
    this.h = paramRectangleShape.b().a();
    paramBaseLayer.a(this.f);
    paramBaseLayer.a(this.g);
    paramBaseLayer.a(this.h);
    this.f.a(this);
    this.g.a(this);
    this.h.a(this);
  }
  
  private void c() {
    this.j = false;
    this.e.invalidateSelf();
  }
  
  public void a() {
    c();
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    MiscUtils.a(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (paramT == LottieProperty.h) {
      this.g.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.j) {
      this.f.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.i)
      this.h.a(paramLottieValueCallback); 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    for (int i = 0; i < paramList1.size(); i++) {
      Content content = paramList1.get(i);
      if (content instanceof TrimPathContent) {
        content = content;
        if (content.c() == ShapeTrimPath.Type.a) {
          this.i.a((TrimPathContent)content);
          content.a(this);
        } 
      } 
    } 
  }
  
  public String b() {
    return this.c;
  }
  
  public Path e() {
    float f1;
    if (this.j)
      return this.a; 
    this.a.reset();
    if (this.d) {
      this.j = true;
      return this.a;
    } 
    PointF pointF2 = (PointF)this.g.g();
    float f4 = pointF2.x / 2.0F;
    float f5 = pointF2.y / 2.0F;
    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
    if (baseKeyframeAnimation == null) {
      f1 = 0.0F;
    } else {
      f1 = ((FloatKeyframeAnimation)baseKeyframeAnimation).i();
    } 
    float f3 = Math.min(f4, f5);
    float f2 = f1;
    if (f1 > f3)
      f2 = f3; 
    PointF pointF1 = (PointF)this.f.g();
    this.a.moveTo(pointF1.x + f4, pointF1.y - f5 + f2);
    this.a.lineTo(pointF1.x + f4, pointF1.y + f5 - f2);
    int i = f2 cmp 0.0F;
    if (i > 0) {
      RectF rectF = this.b;
      f1 = pointF1.x;
      f3 = f2 * 2.0F;
      rectF.set(f1 + f4 - f3, pointF1.y + f5 - f3, pointF1.x + f4, pointF1.y + f5);
      this.a.arcTo(this.b, 0.0F, 90.0F, false);
    } 
    this.a.lineTo(pointF1.x - f4 + f2, pointF1.y + f5);
    if (i > 0) {
      RectF rectF = this.b;
      f1 = pointF1.x;
      f3 = pointF1.y;
      float f = f2 * 2.0F;
      rectF.set(f1 - f4, f3 + f5 - f, pointF1.x - f4 + f, pointF1.y + f5);
      this.a.arcTo(this.b, 90.0F, 90.0F, false);
    } 
    this.a.lineTo(pointF1.x - f4, pointF1.y - f5 + f2);
    if (i > 0) {
      RectF rectF = this.b;
      f1 = pointF1.x;
      f3 = pointF1.y;
      float f6 = pointF1.x;
      float f7 = f2 * 2.0F;
      rectF.set(f1 - f4, f3 - f5, f6 - f4 + f7, pointF1.y - f5 + f7);
      this.a.arcTo(this.b, 180.0F, 90.0F, false);
    } 
    this.a.lineTo(pointF1.x + f4 - f2, pointF1.y - f5);
    if (i > 0) {
      RectF rectF = this.b;
      f1 = pointF1.x;
      f2 *= 2.0F;
      rectF.set(f1 + f4 - f2, pointF1.y - f5, pointF1.x + f4, pointF1.y - f5 + f2);
      this.a.arcTo(this.b, 270.0F, 90.0F, false);
    } 
    this.a.close();
    this.i.a(this.a);
    this.j = true;
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\RectangleContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */