package com.blued.android.module.yy_china.trtc_audio.float_window;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import com.blued.android.core.AppInfo;

public class FloatWindow implements IFloatWindow {
  public int a;
  
  private Context b;
  
  private View c;
  
  private WindowManager.LayoutParams d;
  
  private WindowManager e;
  
  private IFloatWindow.IFloatWindowCallback f;
  
  private float g;
  
  private float h;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private float l;
  
  private float m = 0.0F;
  
  private float n = 0.0F;
  
  private boolean o = false;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private boolean s = false;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private boolean v = true;
  
  private int w;
  
  private int x;
  
  private int y;
  
  private boolean z;
  
  public FloatWindow(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, IFloatWindow.IFloatWindowCallback paramIFloatWindowCallback) {
    this.b = paramContext;
    this.y = paramInt1;
    this.a = paramInt2;
    this.w = paramInt3;
    this.x = paramInt4;
    this.f = paramIFloatWindowCallback;
    this.z = paramBoolean;
    this.c = paramIFloatWindowCallback.a();
    this.d = new WindowManager.LayoutParams();
    this.e = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 26) {
      this.d.type = 2038;
    } else {
      this.d.type = 2003;
    } 
    WindowManager.LayoutParams layoutParams = this.d;
    layoutParams.format = 1;
    layoutParams.flags = 8;
    layoutParams.gravity = 51;
    layoutParams.width = -2;
    layoutParams.height = -2;
    e();
    d();
  }
  
  private void d() {
    f();
    this.c.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            try {
              int i = param1MotionEvent.getAction();
              float f = 0.0F;
              if (i != 0) {
                if (i != 1) {
                  if (i != 2)
                    return false; 
                  int[] arrayOfInt = new int[2];
                  FloatWindow.a(this.a).getLocationOnScreen(arrayOfInt);
                  float f1 = param1MotionEvent.getRawX();
                  f = param1MotionEvent.getRawY();
                  float f2 = f1 - FloatWindow.b(this.a);
                  float f3 = f - FloatWindow.c(this.a);
                  FloatWindow.a(this.a, f1);
                  FloatWindow.b(this.a, f);
                  if (arrayOfInt[0] < FloatWindow.d(this.a)) {
                    if (f2 >= 0.0F)
                      FloatWindow.e(this.a, FloatWindow.e(this.a) + f2); 
                  } else if (arrayOfInt[0] >= FloatWindow.d(this.a) && arrayOfInt[0] <= FloatWindow.f(this.a) - FloatWindow.d(this.a) - FloatWindow.g(this.a)) {
                    FloatWindow.e(this.a, FloatWindow.e(this.a) + f2);
                  } else if (f2 <= 0.0F) {
                    FloatWindow.e(this.a, FloatWindow.e(this.a) + f2);
                  } 
                  if (arrayOfInt[1] < FloatWindow.d(this.a) + FloatWindow.h(this.a)) {
                    if (f3 >= 0.0F)
                      FloatWindow.f(this.a, FloatWindow.i(this.a) + f3); 
                  } else if (arrayOfInt[1] >= FloatWindow.d(this.a) + FloatWindow.h(this.a) && arrayOfInt[1] <= FloatWindow.j(this.a) - FloatWindow.d(this.a) - FloatWindow.k(this.a)) {
                    FloatWindow.f(this.a, FloatWindow.i(this.a) + f3);
                  } else if (f3 <= 0.0F) {
                    FloatWindow.f(this.a, FloatWindow.i(this.a) + f3);
                  } 
                  if (FloatWindow.e(this.a) > (FloatWindow.f(this.a) - FloatWindow.d(this.a) - FloatWindow.g(this.a)))
                    FloatWindow.e(this.a, (FloatWindow.f(this.a) - FloatWindow.d(this.a) - FloatWindow.g(this.a))); 
                  if (FloatWindow.e(this.a) < FloatWindow.d(this.a))
                    FloatWindow.e(this.a, FloatWindow.d(this.a)); 
                  if (FloatWindow.i(this.a) > (FloatWindow.j(this.a) - FloatWindow.d(this.a) - FloatWindow.k(this.a)))
                    FloatWindow.f(this.a, (FloatWindow.j(this.a) - FloatWindow.d(this.a) - FloatWindow.k(this.a))); 
                  if (FloatWindow.i(this.a) < (FloatWindow.d(this.a) + FloatWindow.h(this.a)))
                    FloatWindow.f(this.a, (FloatWindow.d(this.a) + FloatWindow.h(this.a))); 
                  (FloatWindow.l(this.a)).x = (int)FloatWindow.e(this.a);
                  (FloatWindow.l(this.a)).y = (int)(FloatWindow.i(this.a) - FloatWindow.h(this.a));
                  if (FloatWindow.m(this.a) && FloatWindow.n(this.a)) {
                    FloatWindow.o(this.a).updateViewLayout(param1View, (ViewGroup.LayoutParams)FloatWindow.l(this.a));
                    return false;
                  } 
                } else {
                  if (Math.abs(param1MotionEvent.getRawX() - FloatWindow.p(this.a)) < 20.0F && Math.abs(param1MotionEvent.getRawY() - FloatWindow.q(this.a)) < 20.0F && FloatWindow.m(this.a) && !FloatWindow.r(this.a)) {
                    FloatWindow.s(this.a).b();
                    FloatWindow.a(this.a, false);
                    return false;
                  } 
                  float f1 = FloatWindow.e(this.a);
                  f = (FloatWindow.g(this.a) / 2);
                  float f2 = FloatWindow.i(this.a) + (FloatWindow.k(this.a) / 2);
                  if (f2 <= FloatWindow.k(this.a)) {
                    FloatWindow.g(this.a, FloatWindow.e(this.a));
                    FloatWindow.h(this.a, (FloatWindow.d(this.a) + FloatWindow.h(this.a)));
                  } else if (f2 > FloatWindow.k(this.a) && f2 < (FloatWindow.j(this.a) - FloatWindow.k(this.a))) {
                    if (f1 + f <= (FloatWindow.f(this.a) / 2)) {
                      FloatWindow.g(this.a, FloatWindow.d(this.a));
                      FloatWindow.h(this.a, FloatWindow.i(this.a));
                    } else {
                      FloatWindow.g(this.a, (FloatWindow.f(this.a) - FloatWindow.d(this.a) - FloatWindow.g(this.a)));
                      FloatWindow.h(this.a, FloatWindow.i(this.a));
                    } 
                  } else {
                    FloatWindow.g(this.a, FloatWindow.e(this.a));
                    FloatWindow.h(this.a, (FloatWindow.j(this.a) - FloatWindow.d(this.a) - FloatWindow.k(this.a)));
                  } 
                  i = (int)FloatWindow.t(this.a);
                  f1 = FloatWindow.u(this.a);
                  int j = (int)f1;
                  try {
                    if (FloatWindow.e(this.a) != FloatWindow.t(this.a)) {
                      ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { (int)FloatWindow.e(this.a), i });
                      valueAnimator.setDuration(300L);
                      valueAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator());
                      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, j, param1View) {
                            public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                              Integer integer = (Integer)param2ValueAnimator.getAnimatedValue();
                              (FloatWindow.l(this.c.a)).x = integer.intValue();
                              (FloatWindow.l(this.c.a)).y = this.a - FloatWindow.h(this.c.a);
                              if (FloatWindow.m(this.c.a) && FloatWindow.n(this.c.a))
                                FloatWindow.o(this.c.a).updateViewLayout(this.b, (ViewGroup.LayoutParams)FloatWindow.l(this.c.a)); 
                            }
                          });
                      valueAnimator.addListener(new Animator.AnimatorListener(this) {
                            public void onAnimationCancel(Animator param2Animator) {}
                            
                            public void onAnimationEnd(Animator param2Animator) {
                              FloatWindow.b(this.a.a, false);
                            }
                            
                            public void onAnimationRepeat(Animator param2Animator) {}
                            
                            public void onAnimationStart(Animator param2Animator) {
                              FloatWindow.b(this.a.a, true);
                            }
                          });
                      valueAnimator.start();
                      return false;
                    } 
                    if (FloatWindow.i(this.a) != FloatWindow.u(this.a)) {
                      ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { (int)FloatWindow.i(this.a), j });
                      valueAnimator.setDuration(300L);
                      valueAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator(1.0F));
                      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i, param1View) {
                            public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                              Integer integer = (Integer)param2ValueAnimator.getAnimatedValue();
                              (FloatWindow.l(this.c.a)).x = this.a;
                              (FloatWindow.l(this.c.a)).y = integer.intValue() - FloatWindow.h(this.c.a);
                              if (FloatWindow.m(this.c.a) && FloatWindow.n(this.c.a))
                                FloatWindow.o(this.c.a).updateViewLayout(this.b, (ViewGroup.LayoutParams)FloatWindow.l(this.c.a)); 
                            }
                          });
                      valueAnimator.addListener(new Animator.AnimatorListener(this) {
                            public void onAnimationCancel(Animator param2Animator) {}
                            
                            public void onAnimationEnd(Animator param2Animator) {
                              FloatWindow.b(this.a.a, false);
                            }
                            
                            public void onAnimationRepeat(Animator param2Animator) {}
                            
                            public void onAnimationStart(Animator param2Animator) {
                              FloatWindow.b(this.a.a, true);
                            }
                          });
                      valueAnimator.start();
                      return false;
                    } 
                  } catch (Exception exception) {
                    (FloatWindow.l(this.a)).x = i;
                    (FloatWindow.l(this.a)).y = j - FloatWindow.h(this.a);
                    if (FloatWindow.m(this.a) && FloatWindow.n(this.a))
                      FloatWindow.o(this.a).updateViewLayout(param1View, (ViewGroup.LayoutParams)FloatWindow.l(this.a)); 
                    FloatWindow.b(this.a, false);
                    exception.printStackTrace();
                    return false;
                  } 
                } 
              } else {
                float f1;
                try {
                  f1 = exception.getRawX();
                  try {
                    float f2 = exception.getRawY();
                    i = 1;
                    f = f2;
                    if (i != 0) {
                      FloatWindow.a(this.a, f1);
                      FloatWindow.b(this.a, f);
                      FloatWindow.c(this.a, f1);
                      FloatWindow.d(this.a, f);
                      int[] arrayOfInt = new int[2];
                      FloatWindow.a(this.a).getLocationOnScreen(arrayOfInt);
                      FloatWindow.e(this.a, arrayOfInt[0]);
                      FloatWindow.f(this.a, arrayOfInt[1]);
                      return false;
                    } 
                  } catch (IllegalArgumentException illegalArgumentException) {}
                } catch (IllegalArgumentException illegalArgumentException) {
                  f1 = 0.0F;
                } 
                i = 0;
                if (i != 0) {
                  FloatWindow.a(this.a, f1);
                  FloatWindow.b(this.a, f);
                  FloatWindow.c(this.a, f1);
                  FloatWindow.d(this.a, f);
                  int[] arrayOfInt = new int[2];
                  FloatWindow.a(this.a).getLocationOnScreen(arrayOfInt);
                  FloatWindow.e(this.a, arrayOfInt[0]);
                  FloatWindow.f(this.a, arrayOfInt[1]);
                  return false;
                } 
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
            return false;
          }
        });
  }
  
  private void e() {
    Point point = new Point();
    ((WindowManager)AppInfo.d().getSystemService("window")).getDefaultDisplay().getSize(point);
    this.p = point.x;
    this.q = point.y;
  }
  
  private void f() {
    try {
      Class<?> clazz = Class.forName("com.android.internal.R$dimen");
      Object object = clazz.newInstance();
      int i = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
      this.r = AppInfo.d().getResources().getDimensionPixelSize(i);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield s : Z
    //   7: aload_0
    //   8: getfield t : Z
    //   11: ifne -> 51
    //   14: aload_0
    //   15: getfield u : Z
    //   18: ifeq -> 51
    //   21: aload_0
    //   22: getfield e : Landroid/view/WindowManager;
    //   25: aload_0
    //   26: getfield c : Landroid/view/View;
    //   29: aload_0
    //   30: getfield d : Landroid/view/WindowManager$LayoutParams;
    //   33: invokeinterface addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield t : Z
    //   43: goto -> 51
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual printStackTrace : ()V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	54	finally
    //   7	43	46	java/lang/Exception
    //   7	43	54	finally
    //   47	51	54	finally
  }
  
  public void a(int paramInt) {
    if (this.v) {
      if (this.z) {
        this.d.x = this.y - paramInt;
      } else {
        this.d.x = this.p - this.y - this.w - paramInt;
      } 
      WindowManager.LayoutParams layoutParams = this.d;
      layoutParams.y = this.q - this.r - this.x - this.a;
      this.m = layoutParams.x;
      this.n = this.d.y;
      this.v = false;
    } else {
      float f1 = this.m;
      paramInt = this.w;
      float f2 = (paramInt / 2);
      float f3 = this.n;
      int i = this.x;
      f3 += (i / 2);
      if (f3 <= i) {
        this.n = (this.y + this.r);
      } else if (f3 > i && f3 < (this.q - i)) {
        i = this.p;
        if (f1 + f2 <= (i / 2)) {
          this.m = this.y;
        } else {
          this.m = (i - this.y - paramInt);
        } 
      } else {
        this.n = (this.q - this.y - this.x);
      } 
      WindowManager.LayoutParams layoutParams = this.d;
      layoutParams.x = (int)this.m;
      layoutParams.y = (int)(this.n - this.r);
    } 
    if (this.s && this.t)
      this.e.updateViewLayout(this.c, (ViewGroup.LayoutParams)this.d); 
  }
  
  public void a(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield s : Z
    //   7: aload_0
    //   8: getfield t : Z
    //   11: ifeq -> 40
    //   14: aload_0
    //   15: getfield e : Landroid/view/WindowManager;
    //   18: aload_0
    //   19: getfield c : Landroid/view/View;
    //   22: invokeinterface removeView : (Landroid/view/View;)V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield t : Z
    //   32: goto -> 40
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual printStackTrace : ()V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   7	32	35	java/lang/Exception
    //   7	32	43	finally
    //   36	40	43	finally
  }
  
  public boolean c() {
    return this.t;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\float_window\FloatWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */