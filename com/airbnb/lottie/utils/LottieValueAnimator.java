package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
  protected boolean a = false;
  
  private float b = 1.0F;
  
  private boolean c = false;
  
  private long d = 0L;
  
  private float e = 0.0F;
  
  private int f = 0;
  
  private float g = -2.14748365E9F;
  
  private float h = 2.14748365E9F;
  
  private LottieComposition i;
  
  private float q() {
    LottieComposition lottieComposition = this.i;
    return (lottieComposition == null) ? Float.MAX_VALUE : (1.0E9F / lottieComposition.h() / Math.abs(this.b));
  }
  
  private boolean r() {
    return (h() < 0.0F);
  }
  
  private void s() {
    if (this.i == null)
      return; 
    float f = this.e;
    if (f >= this.g && f <= this.h)
      return; 
    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[] { Float.valueOf(this.g), Float.valueOf(this.h), Float.valueOf(this.e) }));
  }
  
  public void a(float paramFloat) {
    a(this.g, paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    if (paramFloat1 <= paramFloat2) {
      float f1;
      float f2;
      LottieComposition lottieComposition = this.i;
      if (lottieComposition == null) {
        f1 = -3.4028235E38F;
      } else {
        f1 = lottieComposition.f();
      } 
      lottieComposition = this.i;
      if (lottieComposition == null) {
        f2 = Float.MAX_VALUE;
      } else {
        f2 = lottieComposition.g();
      } 
      this.g = MiscUtils.b(paramFloat1, f1, f2);
      this.h = MiscUtils.b(paramFloat2, f1, f2);
      a((int)MiscUtils.b(this.e, paramFloat1, paramFloat2));
      return;
    } 
    throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
  }
  
  public void a(int paramInt) {
    float f1 = this.e;
    float f2 = paramInt;
    if (f1 == f2)
      return; 
    this.e = MiscUtils.b(f2, m(), n());
    this.d = System.nanoTime();
    c();
  }
  
  public void a(LottieComposition paramLottieComposition) {
    boolean bool;
    if (this.i == null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.i = paramLottieComposition;
    if (bool) {
      a((int)Math.max(this.g, paramLottieComposition.f()), (int)Math.min(this.h, paramLottieComposition.g()));
    } else {
      a((int)paramLottieComposition.f(), (int)paramLottieComposition.g());
    } 
    float f = this.e;
    this.e = 0.0F;
    a((int)f);
  }
  
  public void b(float paramFloat) {
    this.b = paramFloat;
  }
  
  public void b(int paramInt) {
    a(paramInt, (int)this.h);
  }
  
  protected void c(boolean paramBoolean) {
    Choreographer.getInstance().removeFrameCallback(this);
    if (paramBoolean)
      this.a = false; 
  }
  
  public void cancel() {
    b();
    p();
  }
  
  public float d() {
    LottieComposition lottieComposition = this.i;
    return (lottieComposition == null) ? 0.0F : ((this.e - lottieComposition.f()) / (this.i.g() - this.i.f()));
  }
  
  public void doFrame(long paramLong) {
    o();
    if (this.i != null) {
      if (!isRunning())
        return; 
      long l = this.d;
      float f1 = q();
      float f2 = (float)(paramLong - l) / f1;
      float f3 = this.e;
      f1 = f2;
      if (r())
        f1 = -f2; 
      this.e = f3 + f1;
      boolean bool = MiscUtils.c(this.e, m(), n());
      this.e = MiscUtils.b(this.e, m(), n());
      this.d = paramLong;
      c();
      if ((bool ^ true) != 0)
        if (getRepeatCount() != -1 && this.f >= getRepeatCount()) {
          this.e = n();
          p();
          b(r());
        } else {
          a();
          this.f++;
          if (getRepeatMode() == 2) {
            this.c ^= 0x1;
            g();
          } else {
            if (r()) {
              f1 = n();
            } else {
              f1 = m();
            } 
            this.e = f1;
          } 
          this.d = paramLong;
        }  
      s();
    } 
  }
  
  public float e() {
    return this.e;
  }
  
  public void f() {
    this.i = null;
    this.g = -2.14748365E9F;
    this.h = 2.14748365E9F;
  }
  
  public void g() {
    b(-h());
  }
  
  public float getAnimatedFraction() {
    if (this.i == null)
      return 0.0F; 
    if (r()) {
      float f4 = n() - this.e;
      float f5 = n();
      float f6 = m();
      return f4 / (f5 - f6);
    } 
    float f1 = this.e - m();
    float f2 = n();
    float f3 = m();
    return f1 / (f2 - f3);
  }
  
  public Object getAnimatedValue() {
    return Float.valueOf(d());
  }
  
  public long getDuration() {
    LottieComposition lottieComposition = this.i;
    return (lottieComposition == null) ? 0L : (long)lottieComposition.e();
  }
  
  public float h() {
    return this.b;
  }
  
  public void i() {
    float f;
    this.a = true;
    a(r());
    if (r()) {
      f = n();
    } else {
      f = m();
    } 
    a((int)f);
    this.d = System.nanoTime();
    this.f = 0;
    o();
  }
  
  public boolean isRunning() {
    return this.a;
  }
  
  public void j() {
    p();
    b(r());
  }
  
  public void k() {
    p();
  }
  
  public void l() {
    this.a = true;
    o();
    this.d = System.nanoTime();
    if (r() && e() == m()) {
      this.e = n();
      return;
    } 
    if (!r() && e() == n())
      this.e = m(); 
  }
  
  public float m() {
    LottieComposition lottieComposition = this.i;
    if (lottieComposition == null)
      return 0.0F; 
    float f2 = this.g;
    float f1 = f2;
    if (f2 == -2.14748365E9F)
      f1 = lottieComposition.f(); 
    return f1;
  }
  
  public float n() {
    LottieComposition lottieComposition = this.i;
    if (lottieComposition == null)
      return 0.0F; 
    float f2 = this.h;
    float f1 = f2;
    if (f2 == 2.14748365E9F)
      f1 = lottieComposition.g(); 
    return f1;
  }
  
  protected void o() {
    if (isRunning()) {
      c(false);
      Choreographer.getInstance().postFrameCallback(this);
    } 
  }
  
  protected void p() {
    c(true);
  }
  
  public void setRepeatMode(int paramInt) {
    super.setRepeatMode(paramInt);
    if (paramInt != 2 && this.c) {
      this.c = false;
      g();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lotti\\utils\LottieValueAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */