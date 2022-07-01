package com.soft.blued.customview.swipecard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

public class FlingCardListener implements View.OnTouchListener {
  private final float a;
  
  private final float b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private final FlingListener f;
  
  private final Object g;
  
  private final float h;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private float l;
  
  private float m;
  
  private int n = -1;
  
  private View o = null;
  
  private boolean p = false;
  
  private int q = 200;
  
  private float r;
  
  private Runnable s = new Runnable(this) {
      public void run() {
        FlingCardListener.b(this.a).a(FlingCardListener.a(this.a), 0.0F);
        if (FlingCardListener.a(this.a) > 0.0F) {
          FlingCardListener flingCardListener = this.a;
          FlingCardListener.a(flingCardListener, FlingCardListener.a(flingCardListener) - 0.1F);
          if (FlingCardListener.a(this.a) < 0.0F)
            FlingCardListener.a(this.a, 0.0F); 
          FlingCardListener.d(this.a).postDelayed(this, (FlingCardListener.c(this.a) / 20));
          return;
        } 
        if (FlingCardListener.a(this.a) < 0.0F) {
          FlingCardListener flingCardListener = this.a;
          FlingCardListener.a(flingCardListener, FlingCardListener.a(flingCardListener) + 0.1F);
          if (FlingCardListener.a(this.a) > 0.0F)
            FlingCardListener.a(this.a, 0.0F); 
          FlingCardListener.d(this.a).postDelayed(this, (FlingCardListener.c(this.a) / 20));
        } 
      }
    };
  
  public FlingCardListener(View paramView, Object paramObject, float paramFloat, FlingListener paramFlingListener) {
    this.o = paramView;
    this.a = paramView.getX();
    this.b = paramView.getY();
    this.c = paramView.getHeight();
    this.d = paramView.getWidth();
    this.h = this.d / 2.0F;
    this.g = paramObject;
    this.e = ((ViewGroup)paramView.getParent()).getWidth();
    this.i = paramFloat;
    this.f = paramFlingListener;
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    if (g()) {
      c();
      this.f.a(-1.0F, -1.0F);
    } else if (h()) {
      d();
      this.f.a(1.0F, 1.0F);
    } else {
      float f1 = Math.abs(this.j - this.a);
      float f2 = Math.abs(this.k - this.b);
      if (f1 < 4.0F && f2 < 4.0F) {
        this.f.a(paramMotionEvent, this.o, this.g);
      } else {
        this.o.animate().setDuration(this.q).setInterpolator((TimeInterpolator)new OvershootInterpolator(1.5F)).x(this.a).y(this.b).rotation(0.0F).start();
        this.r = e();
        this.o.postDelayed(this.s, 0L);
      } 
      this.j = 0.0F;
      this.k = 0.0F;
      this.l = 0.0F;
      this.m = 0.0F;
    } 
    return false;
  }
  
  private float e() {
    float f1 = this.j - this.a;
    float f2 = Math.abs(f1) / 3.5F;
    if (f1 > 0.0F) {
      f1 = Math.min(f2, a());
    } else {
      f1 = -Math.min(f2, a());
    } 
    return f1 / a();
  }
  
  private float f() {
    return g() ? -1.0F : (h() ? 1.0F : ((this.j + this.h - a()) / (b() - a()) * 2.0F - 1.0F));
  }
  
  private boolean g() {
    int i;
    int j;
    Object object = this.o.getTag(2131296875);
    boolean bool2 = false;
    if (object == null) {
      i = 0;
    } else {
      i = ((Integer)this.o.getTag(2131296875)).intValue();
    } 
    if (this.o.getTag(2131300307) == null) {
      j = 0;
    } else {
      j = ((Integer)this.o.getTag(2131300307)).intValue();
    } 
    boolean bool1 = bool2;
    if (this.j - this.a < -a()) {
      bool1 = bool2;
      if (i < j - 1)
        bool1 = true; 
    } 
    return bool1;
  }
  
  private boolean h() {
    int i;
    Object object = this.o.getTag(2131296875);
    boolean bool2 = false;
    if (object == null) {
      i = 0;
    } else {
      i = ((Integer)this.o.getTag(2131296875)).intValue();
    } 
    boolean bool1 = bool2;
    if (this.j - this.a > b()) {
      bool1 = bool2;
      if (i >= 1)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public float a() {
    return this.e / 5.0F;
  }
  
  public void a(long paramLong) {
    if (!this.p)
      a(true, this.b, paramLong); 
  }
  
  public void a(boolean paramBoolean, float paramFloat, long paramLong) {
    float f;
    this.p = true;
    if (paramBoolean) {
      f = ((Float)this.o.getTag(2131298110)).floatValue();
      paramFloat = ((Float)this.o.getTag(2131298111)).floatValue();
    } else {
      f = ((Float)this.o.getTag(2131299682)).floatValue();
      paramFloat = ((Float)this.o.getTag(2131299683)).floatValue();
    } 
    this.o.animate().setDuration(paramLong).setInterpolator((TimeInterpolator)new DecelerateInterpolator()).scaleX(((Float)this.o.getTag(2131299826)).floatValue()).scaleY(((Float)this.o.getTag(2131299825)).floatValue()).x(f).y(paramFloat).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramBoolean) {
          public void onAnimationEnd(Animator param1Animator) {
            if (this.a) {
              FlingCardListener.b(this.b).a();
              FlingCardListener.b(this.b).a(FlingCardListener.e(this.b));
            } else {
              FlingCardListener.b(this.b).a();
              FlingCardListener.b(this.b).b(FlingCardListener.e(this.b));
            } 
            FlingCardListener.a(this.b, false);
          }
        }).start();
  }
  
  public float b() {
    return this.e / 5.0F;
  }
  
  public void b(long paramLong) {
    if (!this.p)
      a(false, this.b, paramLong); 
  }
  
  public void c() {
    if (!this.p)
      a(this.q); 
  }
  
  public void d() {
    if (!this.p)
      b(this.q); 
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual getAction : ()I
    //   4: sipush #255
    //   7: iand
    //   8: istore #9
    //   10: iconst_0
    //   11: istore #8
    //   13: iconst_0
    //   14: istore #7
    //   16: iload #9
    //   18: ifeq -> 227
    //   21: iload #9
    //   23: iconst_1
    //   24: if_icmpeq -> 204
    //   27: iload #9
    //   29: iconst_2
    //   30: if_icmpeq -> 99
    //   33: iload #9
    //   35: iconst_3
    //   36: if_icmpeq -> 204
    //   39: iload #9
    //   41: iconst_5
    //   42: if_icmpeq -> 343
    //   45: iload #9
    //   47: bipush #6
    //   49: if_icmpeq -> 54
    //   52: iconst_1
    //   53: ireturn
    //   54: aload_2
    //   55: invokevirtual getAction : ()I
    //   58: ldc 65280
    //   60: iand
    //   61: bipush #8
    //   63: ishr
    //   64: istore #8
    //   66: aload_2
    //   67: iload #8
    //   69: invokevirtual getPointerId : (I)I
    //   72: aload_0
    //   73: getfield n : I
    //   76: if_icmpne -> 343
    //   79: iload #8
    //   81: ifne -> 87
    //   84: iconst_1
    //   85: istore #7
    //   87: aload_0
    //   88: aload_2
    //   89: iload #7
    //   91: invokevirtual getPointerId : (I)I
    //   94: putfield n : I
    //   97: iconst_1
    //   98: ireturn
    //   99: aload_2
    //   100: aload_0
    //   101: getfield n : I
    //   104: invokevirtual findPointerIndex : (I)I
    //   107: istore #7
    //   109: aload_2
    //   110: iload #7
    //   112: invokevirtual getX : (I)F
    //   115: fstore_3
    //   116: aload_2
    //   117: iload #7
    //   119: invokevirtual getY : (I)F
    //   122: fstore #4
    //   124: aload_0
    //   125: getfield l : F
    //   128: fstore #5
    //   130: aload_0
    //   131: getfield m : F
    //   134: fstore #6
    //   136: aload_0
    //   137: aload_0
    //   138: getfield j : F
    //   141: fload_3
    //   142: fload #5
    //   144: fsub
    //   145: fadd
    //   146: putfield j : F
    //   149: aload_0
    //   150: aload_0
    //   151: getfield k : F
    //   154: fload #4
    //   156: fload #6
    //   158: fsub
    //   159: fadd
    //   160: putfield k : F
    //   163: aload_0
    //   164: getfield o : Landroid/view/View;
    //   167: aload_0
    //   168: getfield j : F
    //   171: invokevirtual setX : (F)V
    //   174: aload_0
    //   175: getfield o : Landroid/view/View;
    //   178: aload_0
    //   179: getfield k : F
    //   182: invokevirtual setY : (F)V
    //   185: aload_0
    //   186: getfield f : Lcom/soft/blued/customview/swipecard/FlingCardListener$FlingListener;
    //   189: aload_0
    //   190: invokespecial e : ()F
    //   193: aload_0
    //   194: invokespecial f : ()F
    //   197: invokeinterface a : (FF)V
    //   202: iconst_1
    //   203: ireturn
    //   204: aload_0
    //   205: iconst_m1
    //   206: putfield n : I
    //   209: aload_0
    //   210: aload_2
    //   211: invokespecial a : (Landroid/view/MotionEvent;)Z
    //   214: pop
    //   215: aload_1
    //   216: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   219: iconst_0
    //   220: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   225: iconst_1
    //   226: ireturn
    //   227: aload_0
    //   228: aload_2
    //   229: iconst_0
    //   230: invokevirtual getPointerId : (I)I
    //   233: putfield n : I
    //   236: aload_2
    //   237: aload_0
    //   238: getfield n : I
    //   241: invokevirtual getX : (I)F
    //   244: fstore_3
    //   245: aload_2
    //   246: aload_0
    //   247: getfield n : I
    //   250: invokevirtual getY : (I)F
    //   253: fstore #4
    //   255: iconst_1
    //   256: istore #7
    //   258: goto -> 270
    //   261: fconst_0
    //   262: fstore_3
    //   263: fconst_0
    //   264: fstore #4
    //   266: iload #8
    //   268: istore #7
    //   270: iload #7
    //   272: ifeq -> 326
    //   275: aload_0
    //   276: fload_3
    //   277: putfield l : F
    //   280: aload_0
    //   281: fload #4
    //   283: putfield m : F
    //   286: aload_0
    //   287: getfield j : F
    //   290: fconst_0
    //   291: fcmpl
    //   292: ifne -> 306
    //   295: aload_0
    //   296: aload_0
    //   297: getfield o : Landroid/view/View;
    //   300: invokevirtual getX : ()F
    //   303: putfield j : F
    //   306: aload_0
    //   307: getfield k : F
    //   310: fconst_0
    //   311: fcmpl
    //   312: ifne -> 326
    //   315: aload_0
    //   316: aload_0
    //   317: getfield o : Landroid/view/View;
    //   320: invokevirtual getY : ()F
    //   323: putfield k : F
    //   326: aload_1
    //   327: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   330: iconst_1
    //   331: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   336: iconst_1
    //   337: ireturn
    //   338: astore_1
    //   339: aload_1
    //   340: invokevirtual printStackTrace : ()V
    //   343: iconst_1
    //   344: ireturn
    //   345: astore_2
    //   346: goto -> 261
    //   349: astore_2
    //   350: goto -> 263
    // Exception table:
    //   from	to	target	type
    //   0	10	338	java/lang/Exception
    //   54	79	338	java/lang/Exception
    //   87	97	338	java/lang/Exception
    //   99	202	338	java/lang/Exception
    //   204	225	338	java/lang/Exception
    //   227	236	338	java/lang/Exception
    //   236	245	345	java/lang/IllegalArgumentException
    //   236	245	338	java/lang/Exception
    //   245	255	349	java/lang/IllegalArgumentException
    //   245	255	338	java/lang/Exception
    //   275	306	338	java/lang/Exception
    //   306	326	338	java/lang/Exception
    //   326	336	338	java/lang/Exception
  }
  
  public static interface FlingListener {
    void a();
    
    void a(float param1Float1, float param1Float2);
    
    void a(MotionEvent param1MotionEvent, View param1View, Object param1Object);
    
    void a(Object param1Object);
    
    void b(Object param1Object);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\swipecard\FlingCardListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */