package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class GradientStrokeContent extends BaseStrokeContent {
  private final String c;
  
  private final boolean d;
  
  private final LongSparseArray<LinearGradient> e = new LongSparseArray();
  
  private final LongSparseArray<RadialGradient> f = new LongSparseArray();
  
  private final RectF g = new RectF();
  
  private final GradientType h;
  
  private final int i;
  
  private final BaseKeyframeAnimation<GradientColor, GradientColor> j;
  
  private final BaseKeyframeAnimation<PointF, PointF> k;
  
  private final BaseKeyframeAnimation<PointF, PointF> l;
  
  private ValueCallbackKeyframeAnimation m;
  
  public GradientStrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, GradientStroke paramGradientStroke) {
    super(paramLottieDrawable, paramBaseLayer, paramGradientStroke.h().a(), paramGradientStroke.i().a(), paramGradientStroke.l(), paramGradientStroke.d(), paramGradientStroke.g(), paramGradientStroke.j(), paramGradientStroke.k());
    this.c = paramGradientStroke.a();
    this.h = paramGradientStroke.b();
    this.d = paramGradientStroke.m();
    this.i = (int)(paramLottieDrawable.r().e() / 32.0F);
    this.j = paramGradientStroke.c().a();
    this.j.a(this);
    paramBaseLayer.a(this.j);
    this.k = paramGradientStroke.e().a();
    this.k.a(this);
    paramBaseLayer.a(this.k);
    this.l = paramGradientStroke.f().a();
    this.l.a(this);
    paramBaseLayer.a(this.l);
  }
  
  private int[] a(int[] paramArrayOfint) {
    ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.m;
    int[] arrayOfInt = paramArrayOfint;
    if (valueCallbackKeyframeAnimation != null) {
      Integer[] arrayOfInteger = (Integer[])valueCallbackKeyframeAnimation.g();
      int j = paramArrayOfint.length;
      int k = arrayOfInteger.length;
      boolean bool = false;
      int i = 0;
      if (j == k) {
        while (true) {
          arrayOfInt = paramArrayOfint;
          if (i < paramArrayOfint.length) {
            paramArrayOfint[i] = arrayOfInteger[i].intValue();
            i++;
            continue;
          } 
          break;
        } 
      } else {
        paramArrayOfint = new int[arrayOfInteger.length];
        i = bool;
        while (true) {
          arrayOfInt = paramArrayOfint;
          if (i < arrayOfInteger.length) {
            paramArrayOfint[i] = arrayOfInteger[i].intValue();
            i++;
            continue;
          } 
          break;
        } 
      } 
    } 
    return arrayOfInt;
  }
  
  private LinearGradient c() {
    int i = e();
    LongSparseArray<LinearGradient> longSparseArray = this.e;
    long l = i;
    LinearGradient linearGradient2 = (LinearGradient)longSparseArray.get(l);
    if (linearGradient2 != null)
      return linearGradient2; 
    PointF pointF1 = (PointF)this.k.g();
    PointF pointF2 = (PointF)this.l.g();
    GradientColor gradientColor = (GradientColor)this.j.g();
    int[] arrayOfInt = a(gradientColor.b());
    float[] arrayOfFloat = gradientColor.a();
    i = (int)(this.g.left + this.g.width() / 2.0F + pointF1.x);
    int j = (int)(this.g.top + this.g.height() / 2.0F + pointF1.y);
    int k = (int)(this.g.left + this.g.width() / 2.0F + pointF2.x);
    int m = (int)(this.g.top + this.g.height() / 2.0F + pointF2.y);
    LinearGradient linearGradient1 = new LinearGradient(i, j, k, m, arrayOfInt, arrayOfFloat, Shader.TileMode.CLAMP);
    this.e.put(l, linearGradient1);
    return linearGradient1;
  }
  
  private RadialGradient d() {
    int i = e();
    LongSparseArray<RadialGradient> longSparseArray = this.f;
    long l = i;
    RadialGradient radialGradient2 = (RadialGradient)longSparseArray.get(l);
    if (radialGradient2 != null)
      return radialGradient2; 
    PointF pointF1 = (PointF)this.k.g();
    PointF pointF2 = (PointF)this.l.g();
    GradientColor gradientColor = (GradientColor)this.j.g();
    int[] arrayOfInt = a(gradientColor.b());
    float[] arrayOfFloat = gradientColor.a();
    i = (int)(this.g.left + this.g.width() / 2.0F + pointF1.x);
    int j = (int)(this.g.top + this.g.height() / 2.0F + pointF1.y);
    int k = (int)(this.g.left + this.g.width() / 2.0F + pointF2.x);
    int m = (int)(this.g.top + this.g.height() / 2.0F + pointF2.y);
    float f = (float)Math.hypot((k - i), (m - j));
    RadialGradient radialGradient1 = new RadialGradient(i, j, f, arrayOfInt, arrayOfFloat, Shader.TileMode.CLAMP);
    this.f.put(l, radialGradient1);
    return radialGradient1;
  }
  
  private int e() {
    int i = Math.round(this.k.h() * this.i);
    int m = Math.round(this.l.h() * this.i);
    int k = Math.round(this.j.h() * this.i);
    if (i != 0) {
      j = 527 * i;
    } else {
      j = 17;
    } 
    i = j;
    if (m != 0)
      i = j * 31 * m; 
    int j = i;
    if (k != 0)
      j = i * 31 * k; 
    return j;
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    RadialGradient radialGradient;
    if (this.d)
      return; 
    a(this.g, paramMatrix, false);
    if (this.h == GradientType.a) {
      LinearGradient linearGradient = c();
    } else {
      radialGradient = d();
    } 
    this.b.setShader((Shader)radialGradient);
    super.a(paramCanvas, paramMatrix, paramInt);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    super.a(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.C) {
      if (paramLottieValueCallback == null) {
        if (this.m != null)
          this.a.b((BaseKeyframeAnimation)this.m); 
        this.m = null;
        return;
      } 
      this.m = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.m.a(this);
      this.a.a((BaseKeyframeAnimation)this.m);
    } 
  }
  
  public String b() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\GradientStrokeContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */