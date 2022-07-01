package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
  private final Path a = new Path();
  
  private final String b;
  
  private final LottieDrawable c;
  
  private final PolystarShape.Type d;
  
  private final boolean e;
  
  private final BaseKeyframeAnimation<?, Float> f;
  
  private final BaseKeyframeAnimation<?, PointF> g;
  
  private final BaseKeyframeAnimation<?, Float> h;
  
  private final BaseKeyframeAnimation<?, Float> i;
  
  private final BaseKeyframeAnimation<?, Float> j;
  
  private final BaseKeyframeAnimation<?, Float> k;
  
  private final BaseKeyframeAnimation<?, Float> l;
  
  private CompoundTrimPathContent m = new CompoundTrimPathContent();
  
  private boolean n;
  
  public PolystarContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, PolystarShape paramPolystarShape) {
    this.c = paramLottieDrawable;
    this.b = paramPolystarShape.a();
    this.d = paramPolystarShape.b();
    this.e = paramPolystarShape.j();
    this.f = paramPolystarShape.c().a();
    this.g = paramPolystarShape.d().a();
    this.h = paramPolystarShape.e().a();
    this.j = paramPolystarShape.g().a();
    this.l = paramPolystarShape.i().a();
    if (this.d == PolystarShape.Type.a) {
      this.i = paramPolystarShape.f().a();
      this.k = paramPolystarShape.h().a();
    } else {
      this.i = null;
      this.k = null;
    } 
    paramBaseLayer.a(this.f);
    paramBaseLayer.a(this.g);
    paramBaseLayer.a(this.h);
    paramBaseLayer.a(this.j);
    paramBaseLayer.a(this.l);
    if (this.d == PolystarShape.Type.a) {
      paramBaseLayer.a(this.i);
      paramBaseLayer.a(this.k);
    } 
    this.f.a(this);
    this.g.a(this);
    this.h.a(this);
    this.j.a(this);
    this.l.a(this);
    if (this.d == PolystarShape.Type.a) {
      this.i.a(this);
      this.k.a(this);
    } 
  }
  
  private void c() {
    this.n = false;
    this.c.invalidateSelf();
  }
  
  private void d() {
    float f3;
    float f4;
    float f5;
    float f7;
    float f1 = ((Float)this.f.g()).floatValue();
    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
    if (baseKeyframeAnimation == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)baseKeyframeAnimation.g()).floatValue();
    } 
    double d2 = Math.toRadians(d1 - 90.0D);
    double d3 = f1;
    float f9 = (float)(6.283185307179586D / d3);
    float f8 = f9 / 2.0F;
    float f12 = f1 - (int)f1;
    int k = f12 cmp 0.0F;
    double d1 = d2;
    if (k != 0)
      d1 = d2 + ((1.0F - f12) * f8); 
    float f2 = ((Float)this.j.g()).floatValue();
    f1 = ((Float)this.i.g()).floatValue();
    baseKeyframeAnimation = this.k;
    if (baseKeyframeAnimation != null) {
      f4 = ((Float)baseKeyframeAnimation.g()).floatValue() / 100.0F;
    } else {
      f4 = 0.0F;
    } 
    baseKeyframeAnimation = this.l;
    if (baseKeyframeAnimation != null) {
      f3 = ((Float)baseKeyframeAnimation.g()).floatValue() / 100.0F;
    } else {
      f3 = 0.0F;
    } 
    if (k != 0) {
      f5 = (f2 - f1) * f12 + f1;
      d2 = f5;
      f6 = (float)(d2 * Math.cos(d1));
      f7 = (float)(d2 * Math.sin(d1));
      this.a.moveTo(f6, f7);
      d1 += (f9 * f12 / 2.0F);
    } else {
      d2 = f2;
      f6 = (float)(Math.cos(d1) * d2);
      f7 = (float)(d2 * Math.sin(d1));
      this.a.moveTo(f6, f7);
      d1 += f8;
      f5 = 0.0F;
    } 
    d2 = Math.ceil(d3) * 2.0D;
    int j = 0;
    int i = 0;
    float f11 = f7;
    float f10 = f6;
    float f6 = f8;
    while (true) {
      d3 = i;
      if (d3 < d2) {
        if (j) {
          f7 = f2;
        } else {
          f7 = f1;
        } 
        int m = f5 cmp 0.0F;
        if (m != 0 && d3 == d2 - 2.0D) {
          f8 = f9 * f12 / 2.0F;
        } else {
          f8 = f6;
        } 
        float f14 = f8;
        if (m != 0 && d3 == d2 - 1.0D)
          f7 = f5; 
        double d = f7;
        float f15 = (float)(d * Math.cos(d1));
        float f13 = (float)(d * Math.sin(d1));
        if (f4 == 0.0F && f3 == 0.0F) {
          this.a.lineTo(f15, f13);
        } else {
          d = f11;
          f7 = f4;
          f8 = f3;
          d = (float)(Math.atan2(d, f10) - 1.5707963267948966D);
          float f19 = (float)Math.cos(d);
          float f20 = (float)Math.sin(d);
          d = f13;
          float f18 = f13;
          d = (float)(Math.atan2(d, f15) - 1.5707963267948966D);
          float f21 = (float)Math.cos(d);
          float f22 = (float)Math.sin(d);
          if (j) {
            f16 = f7;
          } else {
            f16 = f8;
          } 
          if (j)
            f7 = f8; 
          if (j) {
            f17 = f1;
          } else {
            f17 = f2;
          } 
          if (j) {
            f8 = f2;
          } else {
            f8 = f1;
          } 
          float f16 = f17 * f16 * 0.47829F;
          f19 *= f16;
          f20 = f16 * f20;
          f7 = f8 * f7 * 0.47829F;
          f21 *= f7;
          f22 = f7 * f22;
          f7 = f19;
          f8 = f21;
          f16 = f20;
          float f17 = f22;
          if (k != 0)
            if (!i) {
              f7 = f19 * f12;
              f16 = f20 * f12;
              f8 = f21;
              f17 = f22;
            } else {
              f7 = f19;
              f8 = f21;
              f16 = f20;
              f17 = f22;
              if (d3 == d2 - 1.0D) {
                f8 = f21 * f12;
                f17 = f22 * f12;
                f16 = f20;
                f7 = f19;
              } 
            }  
          this.a.cubicTo(f10 - f7, f11 - f16, f15 + f8, f18 + f17, f15, f18);
        } 
        d1 += f14;
        j ^= 0x1;
        i++;
        f10 = f15;
        f11 = f13;
        continue;
      } 
      PointF pointF = (PointF)this.g.g();
      this.a.offset(pointF.x, pointF.y);
      this.a.close();
      return;
    } 
  }
  
  private void f() {
    int i = (int)Math.floor(((Float)this.f.g()).floatValue());
    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
    if (baseKeyframeAnimation == null) {
      d1 = 0.0D;
    } else {
      d1 = ((Float)baseKeyframeAnimation.g()).floatValue();
    } 
    double d4 = Math.toRadians(d1 - 90.0D);
    double d3 = i;
    float f3 = (float)(6.283185307179586D / d3);
    float f4 = ((Float)this.l.g()).floatValue() / 100.0F;
    float f5 = ((Float)this.j.g()).floatValue();
    double d2 = f5;
    float f1 = (float)(Math.cos(d4) * d2);
    float f2 = (float)(Math.sin(d4) * d2);
    this.a.moveTo(f1, f2);
    double d1 = f3;
    d4 += d1;
    d3 = Math.ceil(d3);
    i = 0;
    while (i < d3) {
      f3 = (float)(Math.cos(d4) * d2);
      float f = (float)(d2 * Math.sin(d4));
      if (f4 != 0.0F) {
        double d = (float)(Math.atan2(f2, f1) - 1.5707963267948966D);
        float f6 = (float)Math.cos(d);
        float f7 = (float)Math.sin(d);
        d = (float)(Math.atan2(f, f3) - 1.5707963267948966D);
        float f8 = (float)Math.cos(d);
        float f9 = (float)Math.sin(d);
        float f10 = f5 * f4 * 0.25F;
        this.a.cubicTo(f1 - f6 * f10, f2 - f7 * f10, f3 + f8 * f10, f + f10 * f9, f3, f);
      } else {
        this.a.lineTo(f3, f);
      } 
      d4 += d1;
      i++;
      f2 = f;
      f1 = f3;
    } 
    PointF pointF = (PointF)this.g.g();
    this.a.offset(pointF.x, pointF.y);
    this.a.close();
  }
  
  public void a() {
    c();
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    MiscUtils.a(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (paramT == LottieProperty.s) {
      this.f.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.t) {
      this.h.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.j) {
      this.g.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.u) {
      BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.i;
      if (baseKeyframeAnimation != null) {
        baseKeyframeAnimation.a(paramLottieValueCallback);
        return;
      } 
    } 
    if (paramT == LottieProperty.v) {
      this.j.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.w) {
      BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.k;
      if (baseKeyframeAnimation != null) {
        baseKeyframeAnimation.a(paramLottieValueCallback);
        return;
      } 
    } 
    if (paramT == LottieProperty.x)
      this.l.a(paramLottieValueCallback); 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    for (int i = 0; i < paramList1.size(); i++) {
      Content content = paramList1.get(i);
      if (content instanceof TrimPathContent) {
        content = content;
        if (content.c() == ShapeTrimPath.Type.a) {
          this.m.a((TrimPathContent)content);
          content.a(this);
        } 
      } 
    } 
  }
  
  public String b() {
    return this.b;
  }
  
  public Path e() {
    if (this.n)
      return this.a; 
    this.a.reset();
    if (this.e) {
      this.n = true;
      return this.a;
    } 
    int i = null.a[this.d.ordinal()];
    if (i != 1) {
      if (i == 2)
        f(); 
    } else {
      d();
    } 
    this.a.close();
    this.m.a(this.a);
    this.n = true;
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\PolystarContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */