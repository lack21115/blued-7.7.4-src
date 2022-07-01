package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
  private final String a;
  
  private final boolean b;
  
  private final BaseLayer c;
  
  private final LongSparseArray<LinearGradient> d = new LongSparseArray();
  
  private final LongSparseArray<RadialGradient> e = new LongSparseArray();
  
  private final Matrix f = new Matrix();
  
  private final Path g = new Path();
  
  private final Paint h = (Paint)new LPaint(1);
  
  private final RectF i = new RectF();
  
  private final List<PathContent> j = new ArrayList<PathContent>();
  
  private final GradientType k;
  
  private final BaseKeyframeAnimation<GradientColor, GradientColor> l;
  
  private final BaseKeyframeAnimation<Integer, Integer> m;
  
  private final BaseKeyframeAnimation<PointF, PointF> n;
  
  private final BaseKeyframeAnimation<PointF, PointF> o;
  
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> p;
  
  private ValueCallbackKeyframeAnimation q;
  
  private final LottieDrawable r;
  
  private final int s;
  
  public GradientFillContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, GradientFill paramGradientFill) {
    this.c = paramBaseLayer;
    this.a = paramGradientFill.a();
    this.b = paramGradientFill.h();
    this.r = paramLottieDrawable;
    this.k = paramGradientFill.b();
    this.g.setFillType(paramGradientFill.c());
    this.s = (int)(paramLottieDrawable.r().e() / 32.0F);
    this.l = paramGradientFill.d().a();
    this.l.a(this);
    paramBaseLayer.a(this.l);
    this.m = paramGradientFill.e().a();
    this.m.a(this);
    paramBaseLayer.a(this.m);
    this.n = paramGradientFill.f().a();
    this.n.a(this);
    paramBaseLayer.a(this.n);
    this.o = paramGradientFill.g().a();
    this.o.a(this);
    paramBaseLayer.a(this.o);
  }
  
  private int[] a(int[] paramArrayOfint) {
    ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.q;
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
    LongSparseArray<LinearGradient> longSparseArray = this.d;
    long l = i;
    LinearGradient linearGradient2 = (LinearGradient)longSparseArray.get(l);
    if (linearGradient2 != null)
      return linearGradient2; 
    PointF pointF1 = (PointF)this.n.g();
    PointF pointF2 = (PointF)this.o.g();
    GradientColor gradientColor = (GradientColor)this.l.g();
    int[] arrayOfInt = a(gradientColor.b());
    float[] arrayOfFloat = gradientColor.a();
    LinearGradient linearGradient1 = new LinearGradient(pointF1.x, pointF1.y, pointF2.x, pointF2.y, arrayOfInt, arrayOfFloat, Shader.TileMode.CLAMP);
    this.d.put(l, linearGradient1);
    return linearGradient1;
  }
  
  private RadialGradient d() {
    int i = e();
    LongSparseArray<RadialGradient> longSparseArray = this.e;
    long l = i;
    RadialGradient radialGradient2 = (RadialGradient)longSparseArray.get(l);
    if (radialGradient2 != null)
      return radialGradient2; 
    PointF pointF1 = (PointF)this.n.g();
    PointF pointF2 = (PointF)this.o.g();
    GradientColor gradientColor = (GradientColor)this.l.g();
    int[] arrayOfInt = a(gradientColor.b());
    float[] arrayOfFloat = gradientColor.a();
    float f2 = pointF1.x;
    float f3 = pointF1.y;
    float f1 = pointF2.x;
    float f4 = pointF2.y;
    f1 = (float)Math.hypot((f1 - f2), (f4 - f3));
    if (f1 <= 0.0F)
      f1 = 0.001F; 
    RadialGradient radialGradient1 = new RadialGradient(f2, f3, f1, arrayOfInt, arrayOfFloat, Shader.TileMode.CLAMP);
    this.e.put(l, radialGradient1);
    return radialGradient1;
  }
  
  private int e() {
    int i = Math.round(this.n.h() * this.s);
    int m = Math.round(this.o.h() * this.s);
    int k = Math.round(this.l.h() * this.s);
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
  
  public void a() {
    this.r.invalidateSelf();
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    RadialGradient radialGradient;
    if (this.b)
      return; 
    L.a("GradientFillContent#draw");
    this.g.reset();
    int i;
    for (i = 0; i < this.j.size(); i++)
      this.g.addPath(((PathContent)this.j.get(i)).e(), paramMatrix); 
    this.g.computeBounds(this.i, false);
    if (this.k == GradientType.a) {
      LinearGradient linearGradient = c();
    } else {
      radialGradient = d();
    } 
    this.f.set(paramMatrix);
    radialGradient.setLocalMatrix(this.f);
    this.h.setShader((Shader)radialGradient);
    BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.p;
    if (baseKeyframeAnimation != null)
      this.h.setColorFilter((ColorFilter)baseKeyframeAnimation.g()); 
    paramInt = (int)(paramInt / 255.0F * ((Integer)this.m.g()).intValue() / 100.0F * 255.0F);
    this.h.setAlpha(MiscUtils.a(paramInt, 0, 255));
    paramCanvas.drawPath(this.g, this.h);
    L.b("GradientFillContent#draw");
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    this.g.reset();
    int i;
    for (i = 0; i < this.j.size(); i++)
      this.g.addPath(((PathContent)this.j.get(i)).e(), paramMatrix); 
    this.g.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    MiscUtils.a(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (paramT == LottieProperty.d) {
      this.m.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.B) {
      if (paramLottieValueCallback == null) {
        this.p = null;
        return;
      } 
      this.p = (BaseKeyframeAnimation<ColorFilter, ColorFilter>)new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.p.a(this);
      this.c.a(this.p);
      return;
    } 
    if (paramT == LottieProperty.C) {
      if (paramLottieValueCallback == null) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.q;
        if (valueCallbackKeyframeAnimation != null)
          this.c.b((BaseKeyframeAnimation)valueCallbackKeyframeAnimation); 
        this.q = null;
        return;
      } 
      this.q = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.q.a(this);
      this.c.a((BaseKeyframeAnimation)this.q);
    } 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    for (int i = 0; i < paramList2.size(); i++) {
      Content content = paramList2.get(i);
      if (content instanceof PathContent)
        this.j.add((PathContent)content); 
    } 
  }
  
  public String b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\GradientFillContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */