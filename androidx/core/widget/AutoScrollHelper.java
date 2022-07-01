package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements View.OnTouchListener {
  public static final int EDGE_TYPE_INSIDE = 0;
  
  public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
  
  public static final int EDGE_TYPE_OUTSIDE = 2;
  
  public static final float NO_MAX = 3.4028235E38F;
  
  public static final float NO_MIN = 0.0F;
  
  public static final float RELATIVE_UNSPECIFIED = 0.0F;
  
  private static final int r = ViewConfiguration.getTapTimeout();
  
  final ClampedScroller a = new ClampedScroller();
  
  final View b;
  
  boolean c;
  
  boolean d;
  
  boolean e;
  
  private final Interpolator f = (Interpolator)new AccelerateInterpolator();
  
  private Runnable g;
  
  private float[] h = new float[] { 0.0F, 0.0F };
  
  private float[] i = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
  
  private int j;
  
  private int k;
  
  private float[] l = new float[] { 0.0F, 0.0F };
  
  private float[] m = new float[] { 0.0F, 0.0F };
  
  private float[] n = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
  
  private boolean o;
  
  private boolean p;
  
  private boolean q;
  
  public AutoScrollHelper(View paramView) {
    this.b = paramView;
    DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
    int i = (int)(displayMetrics.density * 1575.0F + 0.5F);
    int j = (int)(displayMetrics.density * 315.0F + 0.5F);
    float f = i;
    setMaximumVelocity(f, f);
    f = j;
    setMinimumVelocity(f, f);
    setEdgeType(1);
    setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
    setRelativeEdges(0.2F, 0.2F);
    setRelativeVelocity(1.0F, 1.0F);
    setActivationDelay(r);
    setRampUpDuration(500);
    setRampDownDuration(500);
  }
  
  private float a(float paramFloat1, float paramFloat2) {
    if (paramFloat2 == 0.0F)
      return 0.0F; 
    int i = this.j;
    if (i != 0 && i != 1) {
      if (i != 2)
        return 0.0F; 
      if (paramFloat1 < 0.0F)
        return paramFloat1 / -paramFloat2; 
    } else if (paramFloat1 < paramFloat2) {
      if (paramFloat1 >= 0.0F)
        return 1.0F - paramFloat1 / paramFloat2; 
      if (this.e && this.j == 1)
        return 1.0F; 
    } 
    return 0.0F;
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 > paramFloat3) ? paramFloat3 : ((paramFloat1 < paramFloat2) ? paramFloat2 : paramFloat1);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    paramFloat1 = a(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = a(paramFloat4, paramFloat1);
    paramFloat1 = a(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = -this.f.getInterpolation(-paramFloat1);
    } else {
      if (paramFloat1 > 0.0F) {
        paramFloat1 = this.f.getInterpolation(paramFloat1);
        return a(paramFloat1, -1.0F, 1.0F);
      } 
      return 0.0F;
    } 
    return a(paramFloat1, -1.0F, 1.0F);
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    paramFloat1 = a(this.h[paramInt], paramFloat2, this.i[paramInt], paramFloat1);
    int i = paramFloat1 cmp 0.0F;
    if (i == 0)
      return 0.0F; 
    float f2 = this.l[paramInt];
    paramFloat2 = this.m[paramInt];
    float f1 = this.n[paramInt];
    paramFloat3 = f2 * paramFloat3;
    return (i > 0) ? a(paramFloat1 * paramFloat3, paramFloat2, f1) : -a(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > paramInt3) ? paramInt3 : ((paramInt1 < paramInt2) ? paramInt2 : paramInt1);
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Ljava/lang/Runnable;
    //   4: ifnonnull -> 19
    //   7: aload_0
    //   8: new androidx/core/widget/AutoScrollHelper$ScrollAnimationRunnable
    //   11: dup
    //   12: aload_0
    //   13: invokespecial <init> : (Landroidx/core/widget/AutoScrollHelper;)V
    //   16: putfield g : Ljava/lang/Runnable;
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield e : Z
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield c : Z
    //   29: aload_0
    //   30: getfield o : Z
    //   33: ifne -> 61
    //   36: aload_0
    //   37: getfield k : I
    //   40: istore_1
    //   41: iload_1
    //   42: ifle -> 61
    //   45: aload_0
    //   46: getfield b : Landroid/view/View;
    //   49: aload_0
    //   50: getfield g : Ljava/lang/Runnable;
    //   53: iload_1
    //   54: i2l
    //   55: invokestatic postOnAnimationDelayed : (Landroid/view/View;Ljava/lang/Runnable;J)V
    //   58: goto -> 70
    //   61: aload_0
    //   62: getfield g : Ljava/lang/Runnable;
    //   65: invokeinterface run : ()V
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield o : Z
    //   75: return
  }
  
  private void d() {
    if (this.c) {
      this.e = false;
      return;
    } 
    this.a.requestStop();
  }
  
  boolean a() {
    ClampedScroller clampedScroller = this.a;
    int i = clampedScroller.getVerticalDirection();
    int j = clampedScroller.getHorizontalDirection();
    return ((i != 0 && canTargetScrollVertically(i)) || (j != 0 && canTargetScrollHorizontally(j)));
  }
  
  void b() {
    long l = SystemClock.uptimeMillis();
    MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    this.b.onTouchEvent(motionEvent);
    motionEvent.recycle();
  }
  
  public abstract boolean canTargetScrollHorizontally(int paramInt);
  
  public abstract boolean canTargetScrollVertically(int paramInt);
  
  public boolean isEnabled() {
    return this.p;
  }
  
  public boolean isExclusive() {
    return this.q;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield p : Z
    //   4: istore #6
    //   6: iconst_0
    //   7: istore #7
    //   9: iload #6
    //   11: ifne -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokevirtual getActionMasked : ()I
    //   20: istore #5
    //   22: iload #5
    //   24: ifeq -> 55
    //   27: iload #5
    //   29: iconst_1
    //   30: if_icmpeq -> 48
    //   33: iload #5
    //   35: iconst_2
    //   36: if_icmpeq -> 65
    //   39: iload #5
    //   41: iconst_3
    //   42: if_icmpeq -> 48
    //   45: goto -> 140
    //   48: aload_0
    //   49: invokespecial d : ()V
    //   52: goto -> 140
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield d : Z
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield o : Z
    //   65: aload_0
    //   66: iconst_0
    //   67: aload_2
    //   68: invokevirtual getX : ()F
    //   71: aload_1
    //   72: invokevirtual getWidth : ()I
    //   75: i2f
    //   76: aload_0
    //   77: getfield b : Landroid/view/View;
    //   80: invokevirtual getWidth : ()I
    //   83: i2f
    //   84: invokespecial a : (IFFF)F
    //   87: fstore_3
    //   88: aload_0
    //   89: iconst_1
    //   90: aload_2
    //   91: invokevirtual getY : ()F
    //   94: aload_1
    //   95: invokevirtual getHeight : ()I
    //   98: i2f
    //   99: aload_0
    //   100: getfield b : Landroid/view/View;
    //   103: invokevirtual getHeight : ()I
    //   106: i2f
    //   107: invokespecial a : (IFFF)F
    //   110: fstore #4
    //   112: aload_0
    //   113: getfield a : Landroidx/core/widget/AutoScrollHelper$ClampedScroller;
    //   116: fload_3
    //   117: fload #4
    //   119: invokevirtual setTargetVelocity : (FF)V
    //   122: aload_0
    //   123: getfield e : Z
    //   126: ifne -> 140
    //   129: aload_0
    //   130: invokevirtual a : ()Z
    //   133: ifeq -> 140
    //   136: aload_0
    //   137: invokespecial c : ()V
    //   140: iload #7
    //   142: istore #6
    //   144: aload_0
    //   145: getfield q : Z
    //   148: ifeq -> 165
    //   151: iload #7
    //   153: istore #6
    //   155: aload_0
    //   156: getfield e : Z
    //   159: ifeq -> 165
    //   162: iconst_1
    //   163: istore #6
    //   165: iload #6
    //   167: ireturn
  }
  
  public abstract void scrollTargetBy(int paramInt1, int paramInt2);
  
  public AutoScrollHelper setActivationDelay(int paramInt) {
    this.k = paramInt;
    return this;
  }
  
  public AutoScrollHelper setEdgeType(int paramInt) {
    this.j = paramInt;
    return this;
  }
  
  public AutoScrollHelper setEnabled(boolean paramBoolean) {
    if (this.p && !paramBoolean)
      d(); 
    this.p = paramBoolean;
    return this;
  }
  
  public AutoScrollHelper setExclusive(boolean paramBoolean) {
    this.q = paramBoolean;
    return this;
  }
  
  public AutoScrollHelper setMaximumEdges(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  public AutoScrollHelper setMaximumVelocity(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.n;
    arrayOfFloat[0] = paramFloat1 / 1000.0F;
    arrayOfFloat[1] = paramFloat2 / 1000.0F;
    return this;
  }
  
  public AutoScrollHelper setMinimumVelocity(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.m;
    arrayOfFloat[0] = paramFloat1 / 1000.0F;
    arrayOfFloat[1] = paramFloat2 / 1000.0F;
    return this;
  }
  
  public AutoScrollHelper setRampDownDuration(int paramInt) {
    this.a.setRampDownDuration(paramInt);
    return this;
  }
  
  public AutoScrollHelper setRampUpDuration(int paramInt) {
    this.a.setRampUpDuration(paramInt);
    return this;
  }
  
  public AutoScrollHelper setRelativeEdges(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.h;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  public AutoScrollHelper setRelativeVelocity(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.l;
    arrayOfFloat[0] = paramFloat1 / 1000.0F;
    arrayOfFloat[1] = paramFloat2 / 1000.0F;
    return this;
  }
  
  static class ClampedScroller {
    private int a;
    
    private int b;
    
    private float c;
    
    private float d;
    
    private long e = Long.MIN_VALUE;
    
    private long f = 0L;
    
    private int g = 0;
    
    private int h = 0;
    
    private long i = -1L;
    
    private float j;
    
    private int k;
    
    private float a(float param1Float) {
      return -4.0F * param1Float * param1Float + param1Float * 4.0F;
    }
    
    private float a(long param1Long) {
      if (param1Long < this.e)
        return 0.0F; 
      long l = this.i;
      if (l < 0L || param1Long < l)
        return AutoScrollHelper.a((float)(param1Long - this.e) / this.a, 0.0F, 1.0F) * 0.5F; 
      float f = this.j;
      return 1.0F - f + f * AutoScrollHelper.a((float)(param1Long - l) / this.k, 0.0F, 1.0F);
    }
    
    public void computeScrollDelta() {
      if (this.f != 0L) {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        float f = a(a(l1));
        long l2 = this.f;
        this.f = l1;
        f = (float)(l1 - l2) * f;
        this.g = (int)(this.c * f);
        this.h = (int)(f * this.d);
        return;
      } 
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    
    public int getDeltaX() {
      return this.g;
    }
    
    public int getDeltaY() {
      return this.h;
    }
    
    public int getHorizontalDirection() {
      float f = this.c;
      return (int)(f / Math.abs(f));
    }
    
    public int getVerticalDirection() {
      float f = this.d;
      return (int)(f / Math.abs(f));
    }
    
    public boolean isFinished() {
      return (this.i > 0L && AnimationUtils.currentAnimationTimeMillis() > this.i + this.k);
    }
    
    public void requestStop() {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.k = AutoScrollHelper.a((int)(l - this.e), 0, this.b);
      this.j = a(l);
      this.i = l;
    }
    
    public void setRampDownDuration(int param1Int) {
      this.b = param1Int;
    }
    
    public void setRampUpDuration(int param1Int) {
      this.a = param1Int;
    }
    
    public void setTargetVelocity(float param1Float1, float param1Float2) {
      this.c = param1Float1;
      this.d = param1Float2;
    }
    
    public void start() {
      this.e = AnimationUtils.currentAnimationTimeMillis();
      this.i = -1L;
      this.f = this.e;
      this.j = 0.5F;
      this.g = 0;
      this.h = 0;
    }
  }
  
  class ScrollAnimationRunnable implements Runnable {
    ScrollAnimationRunnable(AutoScrollHelper this$0) {}
    
    public void run() {
      if (!this.a.e)
        return; 
      if (this.a.c) {
        AutoScrollHelper autoScrollHelper = this.a;
        autoScrollHelper.c = false;
        autoScrollHelper.a.start();
      } 
      AutoScrollHelper.ClampedScroller clampedScroller = this.a.a;
      if (clampedScroller.isFinished() || !this.a.a()) {
        this.a.e = false;
        return;
      } 
      if (this.a.d) {
        AutoScrollHelper autoScrollHelper = this.a;
        autoScrollHelper.d = false;
        autoScrollHelper.b();
      } 
      clampedScroller.computeScrollDelta();
      int i = clampedScroller.getDeltaX();
      int j = clampedScroller.getDeltaY();
      this.a.scrollTargetBy(i, j);
      ViewCompat.postOnAnimation(this.a.b, this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\AutoScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */