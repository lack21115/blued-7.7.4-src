package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

class FloatingActionButtonImpl {
  static final TimeInterpolator a = AnimationUtils.c;
  
  static final int[] m = new int[] { 16842919, 16842910 };
  
  static final int[] n = new int[] { 16843623, 16842908, 16842910 };
  
  static final int[] o = new int[] { 16842908, 16842910 };
  
  static final int[] p = new int[] { 16843623, 16842910 };
  
  static final int[] q = new int[] { 16842910 };
  
  static final int[] r = new int[0];
  
  private float A;
  
  private float B = 1.0F;
  
  private int C;
  
  private int D = 0;
  
  private ArrayList<Animator.AnimatorListener> E;
  
  private ArrayList<Animator.AnimatorListener> F;
  
  private ArrayList<InternalTransformationCallback> G;
  
  private final Rect H = new Rect();
  
  private final RectF I = new RectF();
  
  private final RectF J = new RectF();
  
  private final Matrix K = new Matrix();
  
  private ViewTreeObserver.OnPreDrawListener L;
  
  ShapeAppearanceModel b;
  
  MaterialShapeDrawable c;
  
  Drawable d;
  
  BorderDrawable e;
  
  Drawable f;
  
  boolean g;
  
  boolean h = true;
  
  float i;
  
  float j;
  
  float k;
  
  int l;
  
  final FloatingActionButton s;
  
  final ShadowViewDelegate t;
  
  private final StateListAnimator u;
  
  private MotionSpec v;
  
  private MotionSpec w;
  
  private Animator x;
  
  private MotionSpec y;
  
  private MotionSpec z;
  
  FloatingActionButtonImpl(FloatingActionButton paramFloatingActionButton, ShadowViewDelegate paramShadowViewDelegate) {
    this.s = paramFloatingActionButton;
    this.t = paramShadowViewDelegate;
    this.u = new StateListAnimator();
    this.u.a(m, a(new ElevateToPressedTranslationZAnimation(this)));
    this.u.a(n, a(new ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.u.a(o, a(new ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.u.a(p, a(new ElevateToHoveredFocusedTranslationZAnimation(this)));
    this.u.a(q, a(new ResetElevationAnimation(this)));
    this.u.a(r, a(new DisabledElevationAnimation(this)));
    this.A = this.s.getRotation();
  }
  
  private ViewTreeObserver.OnPreDrawListener A() {
    if (this.L == null)
      this.L = new ViewTreeObserver.OnPreDrawListener(this) {
          public boolean onPreDraw() {
            this.a.t();
            return true;
          }
        }; 
    return this.L;
  }
  
  private boolean B() {
    return (ViewCompat.isLaidOut((View)this.s) && !this.s.isInEditMode());
  }
  
  private AnimatorSet a(MotionSpec paramMotionSpec, float paramFloat1, float paramFloat2, float paramFloat3) {
    ArrayList<ObjectAnimator> arrayList = new ArrayList();
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this.s, View.ALPHA, new float[] { paramFloat1 });
    paramMotionSpec.b("opacity").a((Animator)objectAnimator);
    arrayList.add(objectAnimator);
    objectAnimator = ObjectAnimator.ofFloat(this.s, View.SCALE_X, new float[] { paramFloat2 });
    paramMotionSpec.b("scale").a((Animator)objectAnimator);
    a(objectAnimator);
    arrayList.add(objectAnimator);
    objectAnimator = ObjectAnimator.ofFloat(this.s, View.SCALE_Y, new float[] { paramFloat2 });
    paramMotionSpec.b("scale").a((Animator)objectAnimator);
    a(objectAnimator);
    arrayList.add(objectAnimator);
    a(paramFloat3, this.K);
    objectAnimator = ObjectAnimator.ofObject(this.s, (Property)new ImageMatrixProperty(), (TypeEvaluator)new MatrixEvaluator(this) {
          public Matrix a(float param1Float, Matrix param1Matrix1, Matrix param1Matrix2) {
            FloatingActionButtonImpl.a(this.a, param1Float);
            return super.a(param1Float, param1Matrix1, param1Matrix2);
          }
        }(Object[])new Matrix[] { new Matrix(this.K) });
    paramMotionSpec.b("iconScale").a((Animator)objectAnimator);
    arrayList.add(objectAnimator);
    AnimatorSet animatorSet = new AnimatorSet();
    AnimatorSetCompat.a(animatorSet, arrayList);
    return animatorSet;
  }
  
  private ValueAnimator a(ShadowAnimatorImpl paramShadowAnimatorImpl) {
    ValueAnimator valueAnimator = new ValueAnimator();
    valueAnimator.setInterpolator(a);
    valueAnimator.setDuration(100L);
    valueAnimator.addListener((Animator.AnimatorListener)paramShadowAnimatorImpl);
    valueAnimator.addUpdateListener(paramShadowAnimatorImpl);
    valueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return valueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix) {
    paramMatrix.reset();
    Drawable drawable = this.s.getDrawable();
    if (drawable != null && this.C != 0) {
      RectF rectF1 = this.I;
      RectF rectF2 = this.J;
      rectF1.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
      int i = this.C;
      rectF2.set(0.0F, 0.0F, i, i);
      paramMatrix.setRectToRect(rectF1, rectF2, Matrix.ScaleToFit.CENTER);
      i = this.C;
      paramMatrix.postScale(paramFloat, paramFloat, i / 2.0F, i / 2.0F);
    } 
  }
  
  private void a(ObjectAnimator paramObjectAnimator) {
    if (Build.VERSION.SDK_INT != 26)
      return; 
    paramObjectAnimator.setEvaluator(new TypeEvaluator<Float>(this) {
          FloatEvaluator a = new FloatEvaluator();
          
          public Float a(float param1Float, Float param1Float1, Float param1Float2) {
            float f = this.a.evaluate(param1Float, param1Float1, param1Float2).floatValue();
            param1Float = f;
            if (f < 0.1F)
              param1Float = 0.0F; 
            return Float.valueOf(param1Float);
          }
        });
  }
  
  private MotionSpec y() {
    if (this.v == null)
      this.v = MotionSpec.a(this.s.getContext(), R.animator.design_fab_show_motion_spec); 
    return (MotionSpec)Preconditions.checkNotNull(this.v);
  }
  
  private MotionSpec z() {
    if (this.w == null)
      this.w = MotionSpec.a(this.s.getContext(), R.animator.design_fab_hide_motion_spec); 
    return (MotionSpec)Preconditions.checkNotNull(this.w);
  }
  
  float a() {
    return this.i;
  }
  
  final void a(float paramFloat) {
    if (this.i != paramFloat) {
      this.i = paramFloat;
      a(this.i, this.j, this.k);
    } 
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    o();
    e(paramFloat1);
  }
  
  void a(int paramInt) {
    this.l = paramInt;
  }
  
  void a(Animator.AnimatorListener paramAnimatorListener) {
    if (this.E == null)
      this.E = new ArrayList<Animator.AnimatorListener>(); 
    this.E.add(paramAnimatorListener);
  }
  
  void a(ColorStateList paramColorStateList) {
    MaterialShapeDrawable materialShapeDrawable = this.c;
    if (materialShapeDrawable != null)
      materialShapeDrawable.setTintList(paramColorStateList); 
    BorderDrawable borderDrawable = this.e;
    if (borderDrawable != null)
      borderDrawable.a(paramColorStateList); 
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt) {
    this.c = u();
    this.c.setTintList(paramColorStateList1);
    if (paramMode != null)
      this.c.setTintMode(paramMode); 
    this.c.G(-12303292);
    this.c.a(this.s.getContext());
    RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.c.getShapeAppearanceModel());
    rippleDrawableCompat.setTintList(RippleUtils.b(paramColorStateList2));
    this.d = (Drawable)rippleDrawableCompat;
    this.f = (Drawable)new LayerDrawable(new Drawable[] { (Drawable)Preconditions.checkNotNull(this.c), (Drawable)rippleDrawableCompat });
  }
  
  void a(PorterDuff.Mode paramMode) {
    MaterialShapeDrawable materialShapeDrawable = this.c;
    if (materialShapeDrawable != null)
      materialShapeDrawable.setTintMode(paramMode); 
  }
  
  void a(Rect paramRect) {
    float f;
    if (this.g) {
      i = (this.l - this.s.getSizeDimension()) / 2;
    } else {
      i = 0;
    } 
    if (this.h) {
      f = a() + this.k;
    } else {
      f = 0.0F;
    } 
    int j = Math.max(i, (int)Math.ceil(f));
    int i = Math.max(i, (int)Math.ceil((f * 1.5F)));
    paramRect.set(j, i, j, i);
  }
  
  final void a(MotionSpec paramMotionSpec) {
    this.y = paramMotionSpec;
  }
  
  void a(InternalTransformationCallback paramInternalTransformationCallback) {
    if (this.G == null)
      this.G = new ArrayList<InternalTransformationCallback>(); 
    this.G.add(paramInternalTransformationCallback);
  }
  
  void a(InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean) {
    Iterator<Animator.AnimatorListener> iterator;
    byte b;
    if (w())
      return; 
    Animator animator = this.x;
    if (animator != null)
      animator.cancel(); 
    if (B()) {
      MotionSpec motionSpec = this.z;
      if (motionSpec == null)
        motionSpec = z(); 
      AnimatorSet animatorSet = a(motionSpec, 0.0F, 0.0F, 0.0F);
      animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramBoolean, paramInternalVisibilityChangedListener) {
            private boolean d;
            
            public void onAnimationCancel(Animator param1Animator) {
              this.d = true;
            }
            
            public void onAnimationEnd(Animator param1Animator) {
              FloatingActionButtonImpl.a(this.c, 0);
              FloatingActionButtonImpl.a(this.c, (Animator)null);
              if (!this.d) {
                byte b;
                FloatingActionButton floatingActionButton = this.c.s;
                if (this.a) {
                  b = 8;
                } else {
                  b = 4;
                } 
                floatingActionButton.a(b, this.a);
                FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener = this.b;
                if (internalVisibilityChangedListener != null)
                  internalVisibilityChangedListener.b(); 
              } 
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.c.s.a(0, this.a);
              FloatingActionButtonImpl.a(this.c, 1);
              FloatingActionButtonImpl.a(this.c, param1Animator);
              this.d = false;
            }
          });
      ArrayList<Animator.AnimatorListener> arrayList = this.F;
      if (arrayList != null) {
        iterator = arrayList.iterator();
        while (iterator.hasNext())
          animatorSet.addListener(iterator.next()); 
      } 
      animatorSet.start();
      return;
    } 
    FloatingActionButton floatingActionButton = this.s;
    if (paramBoolean) {
      b = 8;
    } else {
      b = 4;
    } 
    floatingActionButton.a(b, paramBoolean);
    if (iterator != null)
      iterator.b(); 
  }
  
  final void a(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.b = paramShapeAppearanceModel;
    MaterialShapeDrawable materialShapeDrawable = this.c;
    if (materialShapeDrawable != null)
      materialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel); 
    Drawable drawable = this.d;
    if (drawable instanceof Shapeable)
      ((Shapeable)drawable).setShapeAppearanceModel(paramShapeAppearanceModel); 
    drawable = this.e;
    if (drawable != null)
      drawable.a(paramShapeAppearanceModel); 
  }
  
  void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  void a(int[] paramArrayOfint) {
    this.u.a(paramArrayOfint);
  }
  
  float b() {
    return this.j;
  }
  
  final void b(float paramFloat) {
    if (this.j != paramFloat) {
      this.j = paramFloat;
      a(this.i, this.j, this.k);
    } 
  }
  
  final void b(int paramInt) {
    if (this.C != paramInt) {
      this.C = paramInt;
      d();
    } 
  }
  
  public void b(Animator.AnimatorListener paramAnimatorListener) {
    if (this.F == null)
      this.F = new ArrayList<Animator.AnimatorListener>(); 
    this.F.add(paramAnimatorListener);
  }
  
  void b(ColorStateList paramColorStateList) {
    Drawable drawable = this.d;
    if (drawable != null)
      DrawableCompat.setTintList(drawable, RippleUtils.b(paramColorStateList)); 
  }
  
  void b(Rect paramRect) {
    Preconditions.checkNotNull(this.f, "Didn't initialize content background");
    if (p()) {
      InsetDrawable insetDrawable = new InsetDrawable(this.f, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.t.a((Drawable)insetDrawable);
      return;
    } 
    this.t.a(this.f);
  }
  
  final void b(MotionSpec paramMotionSpec) {
    this.z = paramMotionSpec;
  }
  
  void b(InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean) {
    Iterator<Animator.AnimatorListener> iterator;
    if (v())
      return; 
    Animator animator = this.x;
    if (animator != null)
      animator.cancel(); 
    if (B()) {
      if (this.s.getVisibility() != 0) {
        this.s.setAlpha(0.0F);
        this.s.setScaleY(0.0F);
        this.s.setScaleX(0.0F);
        d(0.0F);
      } 
      MotionSpec motionSpec = this.y;
      if (motionSpec == null)
        motionSpec = y(); 
      AnimatorSet animatorSet = a(motionSpec, 1.0F, 1.0F, 1.0F);
      animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramBoolean, paramInternalVisibilityChangedListener) {
            public void onAnimationEnd(Animator param1Animator) {
              FloatingActionButtonImpl.a(this.c, 0);
              FloatingActionButtonImpl.a(this.c, (Animator)null);
              FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener = this.b;
              if (internalVisibilityChangedListener != null)
                internalVisibilityChangedListener.a(); 
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.c.s.a(0, this.a);
              FloatingActionButtonImpl.a(this.c, 2);
              FloatingActionButtonImpl.a(this.c, param1Animator);
            }
          });
      ArrayList<Animator.AnimatorListener> arrayList = this.E;
      if (arrayList != null) {
        iterator = arrayList.iterator();
        while (iterator.hasNext())
          animatorSet.addListener(iterator.next()); 
      } 
      animatorSet.start();
      return;
    } 
    this.s.a(0, paramBoolean);
    this.s.setAlpha(1.0F);
    this.s.setScaleY(1.0F);
    this.s.setScaleX(1.0F);
    d(1.0F);
    if (iterator != null)
      iterator.a(); 
  }
  
  void b(boolean paramBoolean) {
    this.h = paramBoolean;
    o();
  }
  
  float c() {
    return this.k;
  }
  
  final void c(float paramFloat) {
    if (this.k != paramFloat) {
      this.k = paramFloat;
      a(this.i, this.j, this.k);
    } 
  }
  
  final void d() {
    d(this.B);
  }
  
  final void d(float paramFloat) {
    this.B = paramFloat;
    Matrix matrix = this.K;
    a(paramFloat, matrix);
    this.s.setImageMatrix(matrix);
  }
  
  final ShapeAppearanceModel e() {
    return this.b;
  }
  
  void e(float paramFloat) {
    MaterialShapeDrawable materialShapeDrawable = this.c;
    if (materialShapeDrawable != null)
      materialShapeDrawable.r(paramFloat); 
  }
  
  final MotionSpec f() {
    return this.y;
  }
  
  final MotionSpec g() {
    return this.z;
  }
  
  final boolean h() {
    return (!this.g || this.s.getSizeDimension() >= this.l);
  }
  
  boolean i() {
    return this.g;
  }
  
  void j() {
    this.u.a();
  }
  
  void k() {
    ArrayList<InternalTransformationCallback> arrayList = this.G;
    if (arrayList != null) {
      Iterator<InternalTransformationCallback> iterator = arrayList.iterator();
      while (iterator.hasNext())
        ((InternalTransformationCallback)iterator.next()).a(); 
    } 
  }
  
  void l() {
    ArrayList<InternalTransformationCallback> arrayList = this.G;
    if (arrayList != null) {
      Iterator<InternalTransformationCallback> iterator = arrayList.iterator();
      while (iterator.hasNext())
        ((InternalTransformationCallback)iterator.next()).b(); 
    } 
  }
  
  final Drawable m() {
    return this.f;
  }
  
  void n() {}
  
  final void o() {
    Rect rect = this.H;
    a(rect);
    b(rect);
    this.t.a(rect.left, rect.top, rect.right, rect.bottom);
  }
  
  boolean p() {
    return true;
  }
  
  void q() {
    MaterialShapeDrawable materialShapeDrawable = this.c;
    if (materialShapeDrawable != null)
      MaterialShapeUtils.a((View)this.s, materialShapeDrawable); 
    if (s())
      this.s.getViewTreeObserver().addOnPreDrawListener(A()); 
  }
  
  void r() {
    ViewTreeObserver viewTreeObserver = this.s.getViewTreeObserver();
    ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.L;
    if (onPreDrawListener != null) {
      viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
      this.L = null;
    } 
  }
  
  boolean s() {
    return true;
  }
  
  void t() {
    float f = this.s.getRotation();
    if (this.A != f) {
      this.A = f;
      x();
    } 
  }
  
  MaterialShapeDrawable u() {
    return new MaterialShapeDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.b));
  }
  
  boolean v() {
    int i = this.s.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 0) {
      if (this.D == 2)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (this.D != 1)
      bool1 = true; 
    return bool1;
  }
  
  boolean w() {
    int i = this.s.getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0) {
      if (this.D == 1)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (this.D != 2)
      bool1 = true; 
    return bool1;
  }
  
  void x() {
    if (Build.VERSION.SDK_INT == 19)
      if (this.A % 90.0F != 0.0F) {
        if (this.s.getLayerType() != 1)
          this.s.setLayerType(1, null); 
      } else if (this.s.getLayerType() != 0) {
        this.s.setLayerType(0, null);
      }  
    MaterialShapeDrawable materialShapeDrawable = this.c;
    if (materialShapeDrawable != null)
      materialShapeDrawable.F((int)this.A); 
  }
  
  class DisabledElevationAnimation extends ShadowAnimatorImpl {
    DisabledElevationAnimation(FloatingActionButtonImpl this$0) {
      super(this$0);
    }
    
    protected float a() {
      return 0.0F;
    }
  }
  
  class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
    ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl this$0) {
      super(this$0);
    }
    
    protected float a() {
      return this.a.i + this.a.j;
    }
  }
  
  class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
    ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl this$0) {
      super(this$0);
    }
    
    protected float a() {
      return this.a.i + this.a.k;
    }
  }
  
  static interface InternalTransformationCallback {
    void a();
    
    void b();
  }
  
  static interface InternalVisibilityChangedListener {
    void a();
    
    void b();
  }
  
  class ResetElevationAnimation extends ShadowAnimatorImpl {
    ResetElevationAnimation(FloatingActionButtonImpl this$0) {
      super(this$0);
    }
    
    protected float a() {
      return this.a.i;
    }
  }
  
  abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    private boolean a;
    
    private float c;
    
    private float d;
    
    private ShadowAnimatorImpl(FloatingActionButtonImpl this$0) {}
    
    protected abstract float a();
    
    public void onAnimationEnd(Animator param1Animator) {
      this.b.e((int)this.d);
      this.a = false;
    }
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      if (!this.a) {
        float f1;
        if (this.b.c == null) {
          f1 = 0.0F;
        } else {
          f1 = this.b.c.S();
        } 
        this.c = f1;
        this.d = a();
        this.a = true;
      } 
      FloatingActionButtonImpl floatingActionButtonImpl = this.b;
      float f = this.c;
      floatingActionButtonImpl.e((int)(f + (this.d - f) * param1ValueAnimator.getAnimatedFraction()));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\FloatingActionButtonImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */