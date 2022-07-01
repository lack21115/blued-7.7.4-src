package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class BezierRadarHeader extends InternalAbstract implements RefreshHeader {
  protected int a;
  
  protected int b;
  
  protected boolean c;
  
  protected boolean d;
  
  protected boolean e;
  
  protected boolean f = false;
  
  protected Path g;
  
  protected Paint h;
  
  protected int i;
  
  protected int j;
  
  protected int k = -1;
  
  protected float l;
  
  protected float m;
  
  protected float n;
  
  protected float o;
  
  protected int p = 0;
  
  protected float q = 0.0F;
  
  protected float r = 0.0F;
  
  protected float s = 0.0F;
  
  protected Animator t;
  
  protected RectF u = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  
  public BezierRadarHeader(Context paramContext) {
    this(paramContext, null);
  }
  
  public BezierRadarHeader(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BezierRadarHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    DensityUtil densityUtil = new DensityUtil();
    this.g = new Path();
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.n = densityUtil.b(7.0F);
    this.q = densityUtil.b(20.0F);
    this.r = densityUtil.b(7.0F);
    this.h.setStrokeWidth(densityUtil.b(3.0F));
    setMinimumHeight(densityUtil.b(100.0F));
    if (isInEditMode()) {
      this.i = 1000;
      this.s = 1.0F;
      this.p = 270;
    } else {
      this.s = 0.0F;
    } 
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BezierRadarHeader);
    this.f = typedArray.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f);
    b(typedArray.getColor(R.styleable.BezierRadarHeader_srlAccentColor, -1));
    a(typedArray.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
    this.d = typedArray.hasValue(R.styleable.BezierRadarHeader_srlAccentColor);
    this.c = typedArray.hasValue(R.styleable.BezierRadarHeader_srlPrimaryColor);
    typedArray.recycle();
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    Animator animator = this.t;
    if (animator != null) {
      animator.removeAllListeners();
      this.t.end();
      this.t = null;
    } 
    int i = getWidth();
    int j = getHeight();
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, (float)Math.sqrt((i * i + j * j)) });
    valueAnimator.setDuration(400L);
    valueAnimator.addUpdateListener(new AnimatorUpdater(this, (byte)3));
    valueAnimator.start();
    return 400;
  }
  
  public BezierRadarHeader a(int paramInt) {
    this.b = paramInt;
    this.c = true;
    return this;
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2) {
    this.k = paramInt1;
    if (Build.VERSION.SDK_INT >= 16) {
      postInvalidateOnAnimation();
      return;
    } 
    invalidate();
  }
  
  protected void a(Canvas paramCanvas, int paramInt) {
    this.g.reset();
    this.g.lineTo(0.0F, this.i);
    Path path = this.g;
    int i = this.k;
    if (i < 0)
      i = paramInt / 2; 
    float f1 = i;
    i = this.i;
    float f2 = (this.j + i);
    float f3 = paramInt;
    path.quadTo(f1, f2, f3, i);
    this.g.lineTo(f3, 0.0F);
    this.h.setColor(this.b);
    paramCanvas.drawPath(this.g, this.h);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2) {
    float f1 = this.l;
    float f2 = 0.0F;
    if (f1 > 0.0F) {
      this.h.setColor(this.a);
      float f3 = DensityUtil.a(paramInt2);
      float f4 = (paramInt1 / 7);
      float f5 = this.m;
      if (f5 > 1.0F) {
        f1 = (f5 - 1.0F) * f4 / f5;
      } else {
        f1 = 0.0F;
      } 
      float f6 = paramInt2;
      float f7 = this.m;
      if (f7 > 1.0F)
        f2 = (f7 - 1.0F) * f6 / 2.0F / f7; 
      for (paramInt2 = 0; paramInt2 < 7; paramInt2++) {
        f7 = paramInt2 + 1.0F - 4.0F;
        float f = Math.abs(f7) / 7.0F;
        this.h.setAlpha((int)((this.l * (1.0F - f * 2.0F) * 255.0F) * (1.0D - 1.0D / Math.pow(f3 / 800.0D + 1.0D, 15.0D))));
        f = this.n * (1.0F - 1.0F / (f3 / 10.0F + 1.0F));
        paramCanvas.drawCircle((paramInt1 / 2) - f / 2.0F + f7 * (f4 * f5 - f1), (f6 - f2) / 2.0F, f, this.h);
      } 
      this.h.setAlpha(255);
    } 
  }
  
  public void a(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    this.i = paramInt1;
    this.e = false;
    ValueAnimator valueAnimator1 = ValueAnimator.ofInt(new int[] { 0, 360 });
    valueAnimator1.setDuration(720L);
    valueAnimator1.setRepeatCount(-1);
    valueAnimator1.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    valueAnimator1.addUpdateListener(new AnimatorUpdater(this, (byte)4));
    DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    valueAnimator2.setInterpolator((TimeInterpolator)decelerateInterpolator);
    valueAnimator2.addUpdateListener(new AnimatorUpdater(this, (byte)2));
    ValueAnimator valueAnimator3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    valueAnimator2.setInterpolator((TimeInterpolator)decelerateInterpolator);
    valueAnimator3.addUpdateListener(new AnimatorUpdater(this, (byte)0));
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playSequentially(new Animator[] { (Animator)valueAnimator2, (Animator)valueAnimator3, (Animator)valueAnimator1 });
    animatorSet.start();
    paramInt1 = this.j;
    valueAnimator1 = ValueAnimator.ofInt(new int[] { paramInt1, 0, -((int)(paramInt1 * 0.8F)), 0, -((int)(paramInt1 * 0.4F)), 0 });
    valueAnimator1.addUpdateListener(new AnimatorUpdater(this, (byte)1));
    valueAnimator1.setInterpolator((TimeInterpolator)decelerateInterpolator);
    valueAnimator1.setDuration(800L);
    valueAnimator1.start();
    this.t = (Animator)animatorSet;
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    int i = null.a[paramRefreshState2.ordinal()];
    if (i != 1 && i != 2)
      return; 
    this.l = 1.0F;
    this.s = 0.0F;
    this.o = 0.0F;
  }
  
  public void a(boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3) {
    if (paramBoolean || this.e) {
      this.e = true;
      this.i = Math.min(paramInt2, paramInt1);
      this.j = (int)(Math.max(0, paramInt1 - paramInt2) * 1.9F);
      this.m = paramFloat;
    } 
  }
  
  public boolean a() {
    return this.f;
  }
  
  public BezierRadarHeader b(int paramInt) {
    this.a = paramInt;
    this.d = true;
    return this;
  }
  
  protected void b(Canvas paramCanvas, int paramInt1, int paramInt2) {
    if (this.t != null || isInEditMode()) {
      float f2 = this.q;
      float f1 = this.s;
      f2 *= f1;
      float f5 = this.r;
      this.h.setColor(this.a);
      this.h.setStyle(Paint.Style.FILL);
      float f3 = (paramInt1 / 2);
      float f4 = (paramInt2 / 2);
      paramCanvas.drawCircle(f3, f4, f2, this.h);
      this.h.setStyle(Paint.Style.STROKE);
      f1 = f5 * f1 + f2;
      paramCanvas.drawCircle(f3, f4, f1, this.h);
      this.h.setColor(this.b & 0xFFFFFF | 0x55000000);
      this.h.setStyle(Paint.Style.FILL);
      this.u.set(f3 - f2, f4 - f2, f3 + f2, f2 + f4);
      paramCanvas.drawArc(this.u, 270.0F, this.p, true, this.h);
      this.h.setStyle(Paint.Style.STROKE);
      this.u.set(f3 - f1, f4 - f1, f3 + f1, f4 + f1);
      paramCanvas.drawArc(this.u, 270.0F, this.p, false, this.h);
      this.h.setStyle(Paint.Style.FILL);
    } 
  }
  
  protected void c(Canvas paramCanvas, int paramInt1, int paramInt2) {
    if (this.o > 0.0F) {
      this.h.setColor(this.a);
      paramCanvas.drawCircle((paramInt1 / 2), (paramInt2 / 2), this.o, this.h);
    } 
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    int i = getWidth();
    int j = getHeight();
    a(paramCanvas, i);
    a(paramCanvas, i, j);
    b(paramCanvas, i, j);
    c(paramCanvas, i, j);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Animator animator = this.t;
    if (animator != null) {
      animator.removeAllListeners();
      this.t.end();
      this.t = null;
    } 
  }
  
  @Deprecated
  public void setPrimaryColors(int... paramVarArgs) {
    if (paramVarArgs.length > 0 && !this.c) {
      a(paramVarArgs[0]);
      this.c = false;
    } 
    if (paramVarArgs.length > 1 && !this.d) {
      b(paramVarArgs[1]);
      this.d = false;
    } 
  }
  
  public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
    byte a;
    
    AnimatorUpdater(BezierRadarHeader this$0, byte param1Byte) {
      this.a = param1Byte;
    }
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      byte b = this.a;
      if (b == 0) {
        this.b.s = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
      } else if (1 == b) {
        if (this.b.e) {
          param1ValueAnimator.cancel();
          return;
        } 
        this.b.j = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue() / 2;
      } else if (2 == b) {
        this.b.l = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
      } else if (3 == b) {
        this.b.o = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
      } else if (4 == b) {
        this.b.p = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
      } 
      this.b.invalidate();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\header\BezierRadarHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */