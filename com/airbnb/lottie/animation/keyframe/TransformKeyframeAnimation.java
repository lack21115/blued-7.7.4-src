package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation {
  private final Matrix a;
  
  private final Matrix b;
  
  private final Matrix c;
  
  private final Matrix d;
  
  private final float[] e;
  
  private BaseKeyframeAnimation<PointF, PointF> f;
  
  private BaseKeyframeAnimation<?, PointF> g;
  
  private BaseKeyframeAnimation<ScaleXY, ScaleXY> h;
  
  private BaseKeyframeAnimation<Float, Float> i;
  
  private BaseKeyframeAnimation<Integer, Integer> j;
  
  private FloatKeyframeAnimation k;
  
  private FloatKeyframeAnimation l;
  
  private BaseKeyframeAnimation<?, Float> m;
  
  private BaseKeyframeAnimation<?, Float> n;
  
  public TransformKeyframeAnimation(AnimatableTransform paramAnimatableTransform) {
    BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
    this.a = new Matrix();
    if (paramAnimatableTransform.a() == null) {
      baseKeyframeAnimation = null;
    } else {
      baseKeyframeAnimation = paramAnimatableTransform.a().a();
    } 
    this.f = baseKeyframeAnimation;
    if (paramAnimatableTransform.b() == null) {
      baseKeyframeAnimation = null;
    } else {
      baseKeyframeAnimation = paramAnimatableTransform.b().a();
    } 
    this.g = baseKeyframeAnimation;
    if (paramAnimatableTransform.c() == null) {
      baseKeyframeAnimation = null;
    } else {
      baseKeyframeAnimation = paramAnimatableTransform.c().a();
    } 
    this.h = (BaseKeyframeAnimation)baseKeyframeAnimation;
    if (paramAnimatableTransform.d() == null) {
      baseKeyframeAnimation = null;
    } else {
      baseKeyframeAnimation = paramAnimatableTransform.d().a();
    } 
    this.i = (BaseKeyframeAnimation)baseKeyframeAnimation;
    if (paramAnimatableTransform.h() == null) {
      baseKeyframeAnimation = null;
    } else {
      baseKeyframeAnimation = paramAnimatableTransform.h().a();
    } 
    this.k = (FloatKeyframeAnimation)baseKeyframeAnimation;
    if (this.k != null) {
      this.b = new Matrix();
      this.c = new Matrix();
      this.d = new Matrix();
      this.e = new float[9];
    } else {
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
    } 
    if (paramAnimatableTransform.i() == null) {
      baseKeyframeAnimation = null;
    } else {
      baseKeyframeAnimation = paramAnimatableTransform.i().a();
    } 
    this.l = (FloatKeyframeAnimation)baseKeyframeAnimation;
    if (paramAnimatableTransform.e() != null)
      this.j = paramAnimatableTransform.e().a(); 
    if (paramAnimatableTransform.f() != null) {
      this.m = paramAnimatableTransform.f().a();
    } else {
      this.m = null;
    } 
    if (paramAnimatableTransform.g() != null) {
      this.n = paramAnimatableTransform.g().a();
      return;
    } 
    this.n = null;
  }
  
  private void e() {
    for (int i = 0; i < 9; i++)
      this.e[i] = 0.0F; 
  }
  
  public BaseKeyframeAnimation<?, Integer> a() {
    return this.j;
  }
  
  public void a(float paramFloat) {
    BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation5 = this.j;
    if (baseKeyframeAnimation5 != null)
      baseKeyframeAnimation5.a(paramFloat); 
    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.m;
    if (baseKeyframeAnimation4 != null)
      baseKeyframeAnimation4.a(paramFloat); 
    baseKeyframeAnimation4 = this.n;
    if (baseKeyframeAnimation4 != null)
      baseKeyframeAnimation4.a(paramFloat); 
    BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f;
    if (baseKeyframeAnimation3 != null)
      baseKeyframeAnimation3.a(paramFloat); 
    BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.g;
    if (baseKeyframeAnimation2 != null)
      baseKeyframeAnimation2.a(paramFloat); 
    BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation1 = this.h;
    if (baseKeyframeAnimation1 != null)
      baseKeyframeAnimation1.a(paramFloat); 
    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.i;
    if (baseKeyframeAnimation != null)
      baseKeyframeAnimation.a(paramFloat); 
    baseKeyframeAnimation = this.k;
    if (baseKeyframeAnimation != null)
      baseKeyframeAnimation.a(paramFloat); 
    baseKeyframeAnimation = this.l;
    if (baseKeyframeAnimation != null)
      baseKeyframeAnimation.a(paramFloat); 
  }
  
  public void a(BaseKeyframeAnimation.AnimationListener paramAnimationListener) {
    BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation5 = this.j;
    if (baseKeyframeAnimation5 != null)
      baseKeyframeAnimation5.a(paramAnimationListener); 
    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.m;
    if (baseKeyframeAnimation4 != null)
      baseKeyframeAnimation4.a(paramAnimationListener); 
    baseKeyframeAnimation4 = this.n;
    if (baseKeyframeAnimation4 != null)
      baseKeyframeAnimation4.a(paramAnimationListener); 
    BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f;
    if (baseKeyframeAnimation3 != null)
      baseKeyframeAnimation3.a(paramAnimationListener); 
    BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.g;
    if (baseKeyframeAnimation2 != null)
      baseKeyframeAnimation2.a(paramAnimationListener); 
    BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation1 = this.h;
    if (baseKeyframeAnimation1 != null)
      baseKeyframeAnimation1.a(paramAnimationListener); 
    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.i;
    if (baseKeyframeAnimation != null)
      baseKeyframeAnimation.a(paramAnimationListener); 
    baseKeyframeAnimation = this.k;
    if (baseKeyframeAnimation != null)
      baseKeyframeAnimation.a(paramAnimationListener); 
    baseKeyframeAnimation = this.l;
    if (baseKeyframeAnimation != null)
      baseKeyframeAnimation.a(paramAnimationListener); 
  }
  
  public void a(BaseLayer paramBaseLayer) {
    paramBaseLayer.a(this.j);
    paramBaseLayer.a(this.m);
    paramBaseLayer.a(this.n);
    paramBaseLayer.a(this.f);
    paramBaseLayer.a(this.g);
    paramBaseLayer.a(this.h);
    paramBaseLayer.a(this.i);
    paramBaseLayer.a(this.k);
    paramBaseLayer.a(this.l);
  }
  
  public <T> boolean a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
    if (paramT == LottieProperty.e) {
      baseKeyframeAnimation = this.f;
      if (baseKeyframeAnimation == null) {
        this.f = new ValueCallbackKeyframeAnimation<PointF, PointF>((LottieValueCallback)paramLottieValueCallback, new PointF());
      } else {
        baseKeyframeAnimation.a((LottieValueCallback)paramLottieValueCallback);
      } 
    } else {
      BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation1;
      if (baseKeyframeAnimation == LottieProperty.f) {
        baseKeyframeAnimation1 = this.g;
        if (baseKeyframeAnimation1 == null) {
          this.g = new ValueCallbackKeyframeAnimation<Object, PointF>((LottieValueCallback)paramLottieValueCallback, new PointF());
        } else {
          baseKeyframeAnimation1.a((LottieValueCallback)paramLottieValueCallback);
        } 
      } else {
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2;
        if (baseKeyframeAnimation1 == LottieProperty.k) {
          baseKeyframeAnimation2 = this.h;
          if (baseKeyframeAnimation2 == null) {
            this.h = new ValueCallbackKeyframeAnimation<ScaleXY, ScaleXY>((LottieValueCallback)paramLottieValueCallback, new ScaleXY());
          } else {
            baseKeyframeAnimation2.a((LottieValueCallback)paramLottieValueCallback);
          } 
        } else {
          BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3;
          if (baseKeyframeAnimation2 == LottieProperty.l) {
            baseKeyframeAnimation3 = this.i;
            if (baseKeyframeAnimation3 == null) {
              this.i = new ValueCallbackKeyframeAnimation<Float, Float>((LottieValueCallback)paramLottieValueCallback, Float.valueOf(0.0F));
            } else {
              baseKeyframeAnimation3.a((LottieValueCallback)paramLottieValueCallback);
            } 
          } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4;
            if (baseKeyframeAnimation3 == LottieProperty.c) {
              baseKeyframeAnimation4 = this.j;
              if (baseKeyframeAnimation4 == null) {
                this.j = new ValueCallbackKeyframeAnimation<Integer, Integer>((LottieValueCallback)paramLottieValueCallback, Integer.valueOf(100));
              } else {
                baseKeyframeAnimation4.a((LottieValueCallback)paramLottieValueCallback);
              } 
            } else {
              if (baseKeyframeAnimation4 == LottieProperty.y) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation5 = this.m;
                if (baseKeyframeAnimation5 != null) {
                  if (baseKeyframeAnimation5 == null) {
                    this.m = (BaseKeyframeAnimation)new ValueCallbackKeyframeAnimation<Object, Object>(paramLottieValueCallback, Integer.valueOf(100));
                  } else {
                    baseKeyframeAnimation5.a((LottieValueCallback)paramLottieValueCallback);
                  } 
                  return true;
                } 
              } 
              if (baseKeyframeAnimation4 == LottieProperty.z) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation5 = this.n;
                if (baseKeyframeAnimation5 != null) {
                  if (baseKeyframeAnimation5 == null) {
                    this.n = (BaseKeyframeAnimation)new ValueCallbackKeyframeAnimation<Object, Object>(paramLottieValueCallback, Integer.valueOf(100));
                  } else {
                    baseKeyframeAnimation5.a((LottieValueCallback)paramLottieValueCallback);
                  } 
                  return true;
                } 
              } 
              if (baseKeyframeAnimation4 == LottieProperty.m) {
                FloatKeyframeAnimation floatKeyframeAnimation = this.k;
                if (floatKeyframeAnimation != null) {
                  if (floatKeyframeAnimation == null)
                    this.k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0F)))); 
                  this.k.a((LottieValueCallback)paramLottieValueCallback);
                  return true;
                } 
              } 
              if (baseKeyframeAnimation4 == LottieProperty.n) {
                baseKeyframeAnimation4 = this.l;
                if (baseKeyframeAnimation4 != null) {
                  if (baseKeyframeAnimation4 == null)
                    this.l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0F)))); 
                  this.l.a((LottieValueCallback)paramLottieValueCallback);
                  return true;
                } 
              } 
              return false;
            } 
          } 
        } 
      } 
    } 
    return true;
  }
  
  public Matrix b(float paramFloat) {
    PointF pointF;
    ScaleXY scaleXY;
    BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation1 = this.g;
    BaseKeyframeAnimation baseKeyframeAnimation3 = null;
    if (baseKeyframeAnimation1 == null) {
      baseKeyframeAnimation1 = null;
    } else {
      pointF = baseKeyframeAnimation1.g();
    } 
    BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.h;
    if (baseKeyframeAnimation2 == null) {
      baseKeyframeAnimation2 = null;
    } else {
      scaleXY = baseKeyframeAnimation2.g();
    } 
    this.a.reset();
    if (pointF != null)
      this.a.preTranslate(pointF.x * paramFloat, pointF.y * paramFloat); 
    if (scaleXY != null) {
      Matrix matrix = this.a;
      double d1 = scaleXY.a();
      double d2 = paramFloat;
      matrix.preScale((float)Math.pow(d1, d2), (float)Math.pow(scaleXY.b(), d2));
    } 
    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.i;
    if (baseKeyframeAnimation != null) {
      float f1;
      PointF pointF1;
      float f3 = ((Float)baseKeyframeAnimation.g()).floatValue();
      BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f;
      if (baseKeyframeAnimation4 == null) {
        baseKeyframeAnimation4 = baseKeyframeAnimation3;
      } else {
        pointF1 = baseKeyframeAnimation4.g();
      } 
      Matrix matrix = this.a;
      float f2 = 0.0F;
      if (pointF1 == null) {
        f1 = 0.0F;
      } else {
        f1 = pointF1.x;
      } 
      if (pointF1 != null)
        f2 = pointF1.y; 
      matrix.preRotate(f3 * paramFloat, f1, f2);
    } 
    return this.a;
  }
  
  public BaseKeyframeAnimation<?, Float> b() {
    return this.m;
  }
  
  public BaseKeyframeAnimation<?, Float> c() {
    return this.n;
  }
  
  public Matrix d() {
    this.a.reset();
    BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = this.g;
    if (baseKeyframeAnimation3 != null) {
      PointF pointF = baseKeyframeAnimation3.g();
      if (pointF.x != 0.0F || pointF.y != 0.0F)
        this.a.preTranslate(pointF.x, pointF.y); 
    } 
    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.i;
    if (baseKeyframeAnimation2 != null) {
      float f;
      if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
        f = ((Float)baseKeyframeAnimation2.g()).floatValue();
      } else {
        f = ((FloatKeyframeAnimation)baseKeyframeAnimation2).i();
      } 
      if (f != 0.0F)
        this.a.preRotate(f); 
    } 
    if (this.k != null) {
      float f1;
      float f2;
      baseKeyframeAnimation2 = this.l;
      if (baseKeyframeAnimation2 == null) {
        f1 = 0.0F;
      } else {
        f1 = (float)Math.cos(Math.toRadians((-baseKeyframeAnimation2.i() + 90.0F)));
      } 
      baseKeyframeAnimation2 = this.l;
      if (baseKeyframeAnimation2 == null) {
        f2 = 1.0F;
      } else {
        f2 = (float)Math.sin(Math.toRadians((-baseKeyframeAnimation2.i() + 90.0F)));
      } 
      float f3 = (float)Math.tan(Math.toRadians(this.k.i()));
      e();
      float[] arrayOfFloat = this.e;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f2;
      float f4 = -f2;
      arrayOfFloat[3] = f4;
      arrayOfFloat[4] = f1;
      arrayOfFloat[8] = 1.0F;
      this.b.setValues(arrayOfFloat);
      e();
      arrayOfFloat = this.e;
      arrayOfFloat[0] = 1.0F;
      arrayOfFloat[3] = f3;
      arrayOfFloat[4] = 1.0F;
      arrayOfFloat[8] = 1.0F;
      this.c.setValues(arrayOfFloat);
      e();
      arrayOfFloat = this.e;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f4;
      arrayOfFloat[3] = f2;
      arrayOfFloat[4] = f1;
      arrayOfFloat[8] = 1.0F;
      this.d.setValues(arrayOfFloat);
      this.c.preConcat(this.b);
      this.d.preConcat(this.c);
      this.a.preConcat(this.d);
    } 
    BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation1 = this.h;
    if (baseKeyframeAnimation1 != null) {
      ScaleXY scaleXY = baseKeyframeAnimation1.g();
      if (scaleXY.a() != 1.0F || scaleXY.b() != 1.0F)
        this.a.preScale(scaleXY.a(), scaleXY.b()); 
    } 
    BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation = this.f;
    if (baseKeyframeAnimation != null) {
      PointF pointF = baseKeyframeAnimation.g();
      if (pointF.x != 0.0F || pointF.y != 0.0F)
        this.a.preTranslate(-pointF.x, -pointF.y); 
    } 
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\TransformKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */