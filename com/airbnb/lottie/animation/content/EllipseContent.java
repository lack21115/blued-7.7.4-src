package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class EllipseContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
  private final Path a = new Path();
  
  private final String b;
  
  private final LottieDrawable c;
  
  private final BaseKeyframeAnimation<?, PointF> d;
  
  private final BaseKeyframeAnimation<?, PointF> e;
  
  private final CircleShape f;
  
  private CompoundTrimPathContent g = new CompoundTrimPathContent();
  
  private boolean h;
  
  public EllipseContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, CircleShape paramCircleShape) {
    this.b = paramCircleShape.a();
    this.c = paramLottieDrawable;
    this.d = paramCircleShape.c().a();
    this.e = paramCircleShape.b().a();
    this.f = paramCircleShape;
    paramBaseLayer.a(this.d);
    paramBaseLayer.a(this.e);
    this.d.a(this);
    this.e.a(this);
  }
  
  private void c() {
    this.h = false;
    this.c.invalidateSelf();
  }
  
  public void a() {
    c();
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    MiscUtils.a(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (paramT == LottieProperty.g) {
      this.d.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.j)
      this.e.a(paramLottieValueCallback); 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    for (int i = 0; i < paramList1.size(); i++) {
      Content content = paramList1.get(i);
      if (content instanceof TrimPathContent) {
        content = content;
        if (content.c() == ShapeTrimPath.Type.a) {
          this.g.a((TrimPathContent)content);
          content.a(this);
        } 
      } 
    } 
  }
  
  public String b() {
    return this.b;
  }
  
  public Path e() {
    if (this.h)
      return this.a; 
    this.a.reset();
    if (this.f.e()) {
      this.h = true;
      return this.a;
    } 
    PointF pointF = (PointF)this.d.g();
    float f2 = pointF.x / 2.0F;
    float f1 = pointF.y / 2.0F;
    float f3 = f2 * 0.55228F;
    float f4 = 0.55228F * f1;
    this.a.reset();
    if (this.f.d()) {
      Path path = this.a;
      float f5 = -f1;
      path.moveTo(0.0F, f5);
      path = this.a;
      float f7 = 0.0F - f3;
      float f8 = -f2;
      float f6 = 0.0F - f4;
      path.cubicTo(f7, f5, f8, f6, f8, 0.0F);
      path = this.a;
      f4 += 0.0F;
      path.cubicTo(f8, f4, f7, f1, 0.0F, f1);
      path = this.a;
      f3 += 0.0F;
      path.cubicTo(f3, f1, f2, f4, f2, 0.0F);
      this.a.cubicTo(f2, f6, f3, f5, 0.0F, f5);
    } else {
      Path path = this.a;
      float f5 = -f1;
      path.moveTo(0.0F, f5);
      path = this.a;
      float f7 = f3 + 0.0F;
      float f6 = 0.0F - f4;
      path.cubicTo(f7, f5, f2, f6, f2, 0.0F);
      path = this.a;
      f4 += 0.0F;
      path.cubicTo(f2, f4, f7, f1, 0.0F, f1);
      path = this.a;
      f3 = 0.0F - f3;
      f2 = -f2;
      path.cubicTo(f3, f1, f2, f4, f2, 0.0F);
      this.a.cubicTo(f2, f6, f3, f5, 0.0F, f5);
    } 
    pointF = (PointF)this.e.g();
    this.a.offset(pointF.x, pointF.y);
    this.a.close();
    this.g.a(this.a);
    this.h = true;
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\EllipseContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */