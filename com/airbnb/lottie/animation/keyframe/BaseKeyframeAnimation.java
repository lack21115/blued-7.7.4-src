package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A> {
  final List<AnimationListener> a = new ArrayList<AnimationListener>(1);
  
  protected LottieValueCallback<A> b;
  
  private boolean c = false;
  
  private final List<? extends Keyframe<K>> d;
  
  private float e = 0.0F;
  
  private Keyframe<K> f;
  
  private Keyframe<K> g;
  
  private float h = -1.0F;
  
  private A i = null;
  
  private float j = -1.0F;
  
  private float k = -1.0F;
  
  BaseKeyframeAnimation(List<? extends Keyframe<K>> paramList) {
    this.d = paramList;
  }
  
  private float i() {
    if (this.j == -1.0F) {
      float f;
      if (this.d.isEmpty()) {
        f = 0.0F;
      } else {
        f = ((Keyframe)this.d.get(0)).c();
      } 
      this.j = f;
    } 
    return this.j;
  }
  
  abstract A a(Keyframe<K> paramKeyframe, float paramFloat);
  
  public void a() {
    this.c = true;
  }
  
  public void a(float paramFloat) {
    float f;
    if (this.d.isEmpty())
      return; 
    Keyframe<K> keyframe1 = c();
    if (paramFloat < i()) {
      f = i();
    } else {
      f = paramFloat;
      if (paramFloat > f())
        f = f(); 
    } 
    if (f == this.e)
      return; 
    this.e = f;
    Keyframe<K> keyframe2 = c();
    if (keyframe1 != keyframe2 || !keyframe2.e())
      b(); 
  }
  
  public void a(AnimationListener paramAnimationListener) {
    this.a.add(paramAnimationListener);
  }
  
  public void a(LottieValueCallback<A> paramLottieValueCallback) {
    LottieValueCallback<A> lottieValueCallback = this.b;
    if (lottieValueCallback != null)
      lottieValueCallback.a(null); 
    this.b = paramLottieValueCallback;
    if (paramLottieValueCallback != null)
      paramLottieValueCallback.a(this); 
  }
  
  public void b() {
    for (int i = 0; i < this.a.size(); i++)
      ((AnimationListener)this.a.get(i)).a(); 
  }
  
  protected Keyframe<K> c() {
    Keyframe<K> keyframe2 = this.f;
    if (keyframe2 != null && keyframe2.a(this.e))
      return this.f; 
    List<? extends Keyframe<K>> list = this.d;
    Keyframe<K> keyframe3 = list.get(list.size() - 1);
    Keyframe<K> keyframe1 = keyframe3;
    if (this.e < keyframe3.c()) {
      int i = this.d.size() - 1;
      keyframe1 = keyframe3;
      while (i >= 0) {
        keyframe1 = this.d.get(i);
        if (keyframe1.a(this.e))
          break; 
        i--;
      } 
    } 
    this.f = keyframe1;
    return keyframe1;
  }
  
  float d() {
    if (this.c)
      return 0.0F; 
    Keyframe<K> keyframe = c();
    return keyframe.e() ? 0.0F : ((this.e - keyframe.c()) / (keyframe.d() - keyframe.c()));
  }
  
  protected float e() {
    Keyframe<K> keyframe = c();
    return keyframe.e() ? 0.0F : keyframe.c.getInterpolation(d());
  }
  
  float f() {
    if (this.k == -1.0F) {
      float f;
      if (this.d.isEmpty()) {
        f = 1.0F;
      } else {
        List<? extends Keyframe<K>> list = this.d;
        f = ((Keyframe)list.get(list.size() - 1)).d();
      } 
      this.k = f;
    } 
    return this.k;
  }
  
  public A g() {
    Keyframe<K> keyframe = c();
    float f = e();
    if (this.b == null && keyframe == this.g && this.h == f)
      return this.i; 
    this.g = keyframe;
    this.h = f;
    keyframe = (Keyframe<K>)a(keyframe, f);
    this.i = (A)keyframe;
    return (A)keyframe;
  }
  
  public float h() {
    return this.e;
  }
  
  public static interface AnimationListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\keyframe\BaseKeyframeAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */