package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialContainerTransform extends Transition {
  private static final String a = MaterialContainerTransform.class.getSimpleName();
  
  private static final String[] b = new String[] { "materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance" };
  
  private static final ProgressThresholdsGroup c = new ProgressThresholdsGroup(new ProgressThresholds(0.0F, 0.25F), new ProgressThresholds(0.0F, 1.0F), new ProgressThresholds(0.0F, 1.0F), new ProgressThresholds(0.0F, 0.75F));
  
  private static final ProgressThresholdsGroup d = new ProgressThresholdsGroup(new ProgressThresholds(0.6F, 0.9F), new ProgressThresholds(0.0F, 1.0F), new ProgressThresholds(0.0F, 0.9F), new ProgressThresholds(0.3F, 0.9F));
  
  private static final ProgressThresholdsGroup e = new ProgressThresholdsGroup(new ProgressThresholds(0.1F, 0.4F), new ProgressThresholds(0.1F, 1.0F), new ProgressThresholds(0.1F, 1.0F), new ProgressThresholds(0.1F, 0.9F));
  
  private static final ProgressThresholdsGroup f = new ProgressThresholdsGroup(new ProgressThresholds(0.6F, 0.9F), new ProgressThresholds(0.0F, 0.9F), new ProgressThresholds(0.0F, 0.9F), new ProgressThresholds(0.2F, 0.9F));
  
  private boolean A;
  
  private float B;
  
  private float C;
  
  private boolean g;
  
  private boolean h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private View s;
  
  private View t;
  
  private ShapeAppearanceModel u;
  
  private ShapeAppearanceModel v;
  
  private ProgressThresholds w;
  
  private ProgressThresholds x;
  
  private ProgressThresholds y;
  
  private ProgressThresholds z;
  
  public MaterialContainerTransform() {
    boolean bool = false;
    this.g = false;
    this.h = false;
    this.i = 16908290;
    this.j = -1;
    this.k = -1;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = 1375731712;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    if (Build.VERSION.SDK_INT >= 28)
      bool = true; 
    this.A = bool;
    this.B = -1.0F;
    this.C = -1.0F;
    setInterpolator(AnimationUtils.b);
  }
  
  private static float a(float paramFloat, View paramView) {
    return (paramFloat != -1.0F) ? paramFloat : ViewCompat.getElevation(paramView);
  }
  
  private static int a(Context paramContext) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(new int[] { R.attr.transitionShapeAppearance });
    int i = typedArray.getResourceId(0, -1);
    typedArray.recycle();
    return i;
  }
  
  private static RectF a(View paramView1, View paramView2, float paramFloat1, float paramFloat2) {
    RectF rectF;
    if (paramView2 != null) {
      rectF = TransitionUtils.c(paramView2);
      rectF.offset(paramFloat1, paramFloat2);
      return rectF;
    } 
    return new RectF(0.0F, 0.0F, rectF.getWidth(), rectF.getHeight());
  }
  
  private static ShapeAppearanceModel a(View paramView, RectF paramRectF, ShapeAppearanceModel paramShapeAppearanceModel) {
    return TransitionUtils.a(a(paramView, paramShapeAppearanceModel), paramRectF);
  }
  
  private static ShapeAppearanceModel a(View paramView, ShapeAppearanceModel paramShapeAppearanceModel) {
    if (paramShapeAppearanceModel != null)
      return paramShapeAppearanceModel; 
    if (paramView.getTag(R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel)
      return (ShapeAppearanceModel)paramView.getTag(R.id.mtrl_motion_snapshot_view); 
    Context context = paramView.getContext();
    int i = a(context);
    return (i != -1) ? ShapeAppearanceModel.a(context, i, 0).a() : ((paramView instanceof Shapeable) ? ((Shapeable)paramView).getShapeAppearanceModel() : ShapeAppearanceModel.a().a());
  }
  
  private ProgressThresholdsGroup a(boolean paramBoolean, ProgressThresholdsGroup paramProgressThresholdsGroup1, ProgressThresholdsGroup paramProgressThresholdsGroup2) {
    if (!paramBoolean)
      paramProgressThresholdsGroup1 = paramProgressThresholdsGroup2; 
    return new ProgressThresholdsGroup(TransitionUtils.<ProgressThresholds>a(this.w, ProgressThresholdsGroup.a(paramProgressThresholdsGroup1)), TransitionUtils.<ProgressThresholds>a(this.x, ProgressThresholdsGroup.b(paramProgressThresholdsGroup1)), TransitionUtils.<ProgressThresholds>a(this.y, ProgressThresholdsGroup.c(paramProgressThresholdsGroup1)), TransitionUtils.<ProgressThresholds>a(this.z, ProgressThresholdsGroup.d(paramProgressThresholdsGroup1)));
  }
  
  private static void a(TransitionValues paramTransitionValues, View paramView, int paramInt, ShapeAppearanceModel paramShapeAppearanceModel) {
    if (paramInt != -1) {
      paramTransitionValues.view = TransitionUtils.a(paramTransitionValues.view, paramInt);
    } else if (paramView != null) {
      paramTransitionValues.view = paramView;
    } else if (paramTransitionValues.view.getTag(R.id.mtrl_motion_snapshot_view) instanceof View) {
      paramView = (View)paramTransitionValues.view.getTag(R.id.mtrl_motion_snapshot_view);
      paramTransitionValues.view.setTag(R.id.mtrl_motion_snapshot_view, null);
      paramTransitionValues.view = paramView;
    } 
    View view = paramTransitionValues.view;
    if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
      RectF rectF;
      if (view.getParent() == null) {
        rectF = TransitionUtils.a(view);
      } else {
        rectF = TransitionUtils.c(view);
      } 
      paramTransitionValues.values.put("materialContainerTransition:bounds", rectF);
      paramTransitionValues.values.put("materialContainerTransition:shapeAppearance", a(view, rectF, paramShapeAppearanceModel));
    } 
  }
  
  private boolean a(RectF paramRectF1, RectF paramRectF2) {
    StringBuilder stringBuilder;
    int i = this.p;
    boolean bool = false;
    if (i != 0) {
      if (i != 1) {
        if (i == 2)
          return false; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid transition direction: ");
        stringBuilder.append(this.p);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return true;
    } 
    if (TransitionUtils.a(paramRectF2) > TransitionUtils.a((RectF)stringBuilder))
      bool = true; 
    return bool;
  }
  
  private ProgressThresholdsGroup b(boolean paramBoolean) {
    PathMotion pathMotion = getPathMotion();
    return (pathMotion instanceof android.transition.ArcMotion || pathMotion instanceof MaterialArcMotion) ? a(paramBoolean, e, f) : a(paramBoolean, c, d);
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    a(paramTransitionValues, this.t, this.k, this.v);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    a(paramTransitionValues, this.s, this.j, this.u);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    if (paramTransitionValues1 != null) {
      View view1;
      if (paramTransitionValues2 == null)
        return null; 
      RectF rectF3 = (RectF)paramTransitionValues1.values.get("materialContainerTransition:bounds");
      ShapeAppearanceModel shapeAppearanceModel1 = (ShapeAppearanceModel)paramTransitionValues1.values.get("materialContainerTransition:shapeAppearance");
      if (rectF3 == null || shapeAppearanceModel1 == null) {
        Log.w(a, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        return null;
      } 
      RectF rectF4 = (RectF)paramTransitionValues2.values.get("materialContainerTransition:bounds");
      ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel)paramTransitionValues2.values.get("materialContainerTransition:shapeAppearance");
      if (rectF4 == null || shapeAppearanceModel2 == null) {
        Log.w(a, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
      } 
      View view3 = paramTransitionValues1.view;
      View view2 = paramTransitionValues2.view;
      if (view2.getParent() != null) {
        view1 = view2;
      } else {
        view1 = view3;
      } 
      if (this.i == view1.getId()) {
        View view5 = (View)view1.getParent();
        View view4 = view1;
        view1 = view5;
      } else {
        view1 = TransitionUtils.b(view1, this.i);
        paramTransitionValues1 = null;
      } 
      RectF rectF2 = TransitionUtils.c(view1);
      float f1 = -rectF2.left;
      float f2 = -rectF2.top;
      RectF rectF1 = a(view1, (View)paramTransitionValues1, f1, f2);
      rectF3.offset(f1, f2);
      rectF4.offset(f1, f2);
      boolean bool = a(rectF3, rectF4);
      TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view3, rectF3, shapeAppearanceModel1, a(this.B, view3), view2, rectF4, shapeAppearanceModel2, a(this.C, view2), this.l, this.m, this.n, this.o, bool, this.A, FadeModeEvaluators.a(this.q, bool), FitModeEvaluators.a(this.r, bool, rectF3, rectF4), b(bool), this.g);
      transitionDrawable.setBounds(Math.round(rectF1.left), Math.round(rectF1.top), Math.round(rectF1.right), Math.round(rectF1.bottom));
      ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, transitionDrawable) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              MaterialContainerTransform.TransitionDrawable.a(this.a, param1ValueAnimator.getAnimatedFraction());
            }
          });
      addListener(new TransitionListenerAdapter(this, view1, transitionDrawable, view3, view2) {
            public void onTransitionEnd(Transition param1Transition) {
              this.e.removeListener(this);
              if (MaterialContainerTransform.a(this.e))
                return; 
              this.c.setAlpha(1.0F);
              this.d.setAlpha(1.0F);
              ViewUtils.e(this.a).b(this.b);
            }
            
            public void onTransitionStart(Transition param1Transition) {
              ViewUtils.e(this.a).a(this.b);
              this.c.setAlpha(0.0F);
              this.d.setAlpha(0.0F);
            }
          });
      return (Animator)valueAnimator;
    } 
    return null;
  }
  
  public String[] getTransitionProperties() {
    return b;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FadeMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FitMode {}
  
  public static class ProgressThresholds {
    private final float a;
    
    private final float b;
    
    public ProgressThresholds(float param1Float1, float param1Float2) {
      this.a = param1Float1;
      this.b = param1Float2;
    }
    
    public float a() {
      return this.a;
    }
    
    public float b() {
      return this.b;
    }
  }
  
  static class ProgressThresholdsGroup {
    private final MaterialContainerTransform.ProgressThresholds a;
    
    private final MaterialContainerTransform.ProgressThresholds b;
    
    private final MaterialContainerTransform.ProgressThresholds c;
    
    private final MaterialContainerTransform.ProgressThresholds d;
    
    private ProgressThresholdsGroup(MaterialContainerTransform.ProgressThresholds param1ProgressThresholds1, MaterialContainerTransform.ProgressThresholds param1ProgressThresholds2, MaterialContainerTransform.ProgressThresholds param1ProgressThresholds3, MaterialContainerTransform.ProgressThresholds param1ProgressThresholds4) {
      this.a = param1ProgressThresholds1;
      this.b = param1ProgressThresholds2;
      this.c = param1ProgressThresholds3;
      this.d = param1ProgressThresholds4;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TransitionDirection {}
  
  static final class TransitionDrawable extends Drawable {
    private final MaterialContainerTransform.ProgressThresholdsGroup A;
    
    private final FadeModeEvaluator B;
    
    private final FitModeEvaluator C;
    
    private final boolean D;
    
    private final Paint E = new Paint();
    
    private final Path F = new Path();
    
    private FadeModeResult G;
    
    private FitModeResult H;
    
    private RectF I;
    
    private float J;
    
    private float K;
    
    private float L;
    
    private final View a;
    
    private final RectF b;
    
    private final ShapeAppearanceModel c;
    
    private final float d;
    
    private final View e;
    
    private final RectF f;
    
    private final ShapeAppearanceModel g;
    
    private final float h;
    
    private final Paint i = new Paint();
    
    private final Paint j = new Paint();
    
    private final Paint k = new Paint();
    
    private final Paint l = new Paint();
    
    private final Paint m = new Paint();
    
    private final MaskEvaluator n = new MaskEvaluator();
    
    private final PathMeasure o;
    
    private final float p;
    
    private final float[] q = new float[2];
    
    private final boolean r;
    
    private final float s;
    
    private final float t;
    
    private final boolean u;
    
    private final MaterialShapeDrawable v = new MaterialShapeDrawable();
    
    private final RectF w;
    
    private final RectF x;
    
    private final RectF y;
    
    private final RectF z;
    
    private TransitionDrawable(PathMotion param1PathMotion, View param1View1, RectF param1RectF1, ShapeAppearanceModel param1ShapeAppearanceModel1, float param1Float1, View param1View2, RectF param1RectF2, ShapeAppearanceModel param1ShapeAppearanceModel2, float param1Float2, int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2, FadeModeEvaluator param1FadeModeEvaluator, FitModeEvaluator param1FitModeEvaluator, MaterialContainerTransform.ProgressThresholdsGroup param1ProgressThresholdsGroup, boolean param1Boolean3) {
      this.a = param1View1;
      this.b = param1RectF1;
      this.c = param1ShapeAppearanceModel1;
      this.d = param1Float1;
      this.e = param1View2;
      this.f = param1RectF2;
      this.g = param1ShapeAppearanceModel2;
      this.h = param1Float2;
      this.r = param1Boolean1;
      this.u = param1Boolean2;
      this.B = param1FadeModeEvaluator;
      this.C = param1FitModeEvaluator;
      this.A = param1ProgressThresholdsGroup;
      this.D = param1Boolean3;
      WindowManager windowManager = (WindowManager)param1View1.getContext().getSystemService("window");
      DisplayMetrics displayMetrics = new DisplayMetrics();
      windowManager.getDefaultDisplay().getMetrics(displayMetrics);
      this.s = displayMetrics.widthPixels;
      this.t = displayMetrics.heightPixels;
      this.i.setColor(param1Int1);
      this.j.setColor(param1Int2);
      this.k.setColor(param1Int3);
      this.v.g(ColorStateList.valueOf(0));
      this.v.D(2);
      this.v.g(false);
      this.v.G(-7829368);
      this.w = new RectF(param1RectF1);
      this.x = new RectF(this.w);
      this.y = new RectF(this.w);
      this.z = new RectF(this.y);
      PointF pointF1 = a(param1RectF1);
      PointF pointF2 = a(param1RectF2);
      this.o = new PathMeasure(param1PathMotion.getPath(pointF1.x, pointF1.y, pointF2.x, pointF2.y), false);
      this.p = this.o.getLength();
      this.q[0] = param1RectF1.centerX();
      this.q[1] = param1RectF1.top;
      this.m.setStyle(Paint.Style.FILL);
      this.m.setShader(TransitionUtils.a(param1Int4));
      this.E.setStyle(Paint.Style.STROKE);
      this.E.setStrokeWidth(10.0F);
      b(0.0F);
    }
    
    private static float a(RectF param1RectF, float param1Float) {
      return (param1RectF.centerX() / param1Float / 2.0F - 1.0F) * 0.3F;
    }
    
    private static PointF a(RectF param1RectF) {
      return new PointF(param1RectF.centerX(), param1RectF.top);
    }
    
    private void a(float param1Float) {
      if (this.L != param1Float)
        b(param1Float); 
    }
    
    private void a(Canvas param1Canvas) {
      param1Canvas.save();
      param1Canvas.clipPath(this.n.a(), Region.Op.DIFFERENCE);
      if (Build.VERSION.SDK_INT > 28) {
        b(param1Canvas);
      } else {
        c(param1Canvas);
      } 
      param1Canvas.restore();
    }
    
    private void a(Canvas param1Canvas, Paint param1Paint) {
      if (param1Paint.getColor() != 0 && param1Paint.getAlpha() > 0)
        param1Canvas.drawRect(getBounds(), param1Paint); 
    }
    
    private void a(Canvas param1Canvas, RectF param1RectF, int param1Int) {
      this.E.setColor(param1Int);
      param1Canvas.drawRect(param1RectF, this.E);
    }
    
    private void a(Canvas param1Canvas, RectF param1RectF, Path param1Path, int param1Int) {
      PointF pointF = a(param1RectF);
      if (this.L == 0.0F) {
        param1Path.reset();
        param1Path.moveTo(pointF.x, pointF.y);
        return;
      } 
      param1Path.lineTo(pointF.x, pointF.y);
      this.E.setColor(param1Int);
      param1Canvas.drawPath(param1Path, this.E);
    }
    
    private static float b(RectF param1RectF, float param1Float) {
      return param1RectF.centerY() / param1Float * 1.5F;
    }
    
    private void b(float param1Float) {
      RectF rectF;
      this.L = param1Float;
      Paint paint = this.m;
      if (this.r) {
        f1 = TransitionUtils.a(0.0F, 255.0F, param1Float);
      } else {
        f1 = TransitionUtils.a(255.0F, 0.0F, param1Float);
      } 
      paint.setAlpha((int)f1);
      this.o.getPosTan(this.p * param1Float, this.q, null);
      float[] arrayOfFloat = this.q;
      float f1 = arrayOfFloat[0];
      float f2 = arrayOfFloat[1];
      float f3 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.b(this.A))))).floatValue();
      float f4 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.b(this.A))))).floatValue();
      this.H = this.C.a(param1Float, f3, f4, this.b.width(), this.b.height(), this.f.width(), this.f.height());
      this.w.set(f1 - this.H.c / 2.0F, f2, this.H.c / 2.0F + f1, this.H.d + f2);
      this.y.set(f1 - this.H.e / 2.0F, f2, f1 + this.H.e / 2.0F, this.H.f + f2);
      this.x.set(this.w);
      this.z.set(this.y);
      f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.c(this.A))))).floatValue();
      f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.c(this.A))))).floatValue();
      boolean bool = this.C.a(this.H);
      if (bool) {
        rectF = this.x;
      } else {
        rectF = this.z;
      } 
      f1 = TransitionUtils.a(0.0F, 1.0F, f1, f2, param1Float);
      if (!bool)
        f1 = 1.0F - f1; 
      this.C.a(rectF, f1, this.H);
      this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
      this.n.a(param1Float, this.c, this.g, this.w, this.x, this.z, MaterialContainerTransform.ProgressThresholdsGroup.d(this.A));
      this.J = TransitionUtils.a(this.d, this.h, param1Float);
      f3 = a(this.I, this.s);
      f1 = b(this.I, this.t);
      f2 = this.J;
      f3 = (int)(f3 * f2);
      this.K = (int)(f1 * f2);
      this.l.setShadowLayer(f2, f3, this.K, 754974720);
      f1 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.a(MaterialContainerTransform.ProgressThresholdsGroup.a(this.A))))).floatValue();
      f2 = ((Float)Preconditions.checkNotNull(Float.valueOf(MaterialContainerTransform.ProgressThresholds.b(MaterialContainerTransform.ProgressThresholdsGroup.a(this.A))))).floatValue();
      this.G = this.B.a(param1Float, f1, f2);
      if (this.j.getColor() != 0)
        this.j.setAlpha(this.G.a); 
      if (this.k.getColor() != 0)
        this.k.setAlpha(this.G.b); 
      invalidateSelf();
    }
    
    private void b(Canvas param1Canvas) {
      ShapeAppearanceModel shapeAppearanceModel = this.n.b();
      if (shapeAppearanceModel.a(this.I)) {
        float f = shapeAppearanceModel.f().a(this.I);
        param1Canvas.drawRoundRect(this.I, f, f, this.l);
        return;
      } 
      param1Canvas.drawPath(this.n.a(), this.l);
    }
    
    private void c(Canvas param1Canvas) {
      this.v.setBounds((int)this.I.left, (int)this.I.top, (int)this.I.right, (int)this.I.bottom);
      this.v.r(this.J);
      this.v.E((int)this.K);
      this.v.setShapeAppearanceModel(this.n.b());
      this.v.draw(param1Canvas);
    }
    
    private void d(Canvas param1Canvas) {
      a(param1Canvas, this.j);
      TransitionUtils.a(param1Canvas, getBounds(), this.w.left, this.w.top, this.H.a, this.G.a, new TransitionUtils.CanvasOperation(this) {
            public void a(Canvas param2Canvas) {
              MaterialContainerTransform.TransitionDrawable.a(this.a).draw(param2Canvas);
            }
          });
    }
    
    private void e(Canvas param1Canvas) {
      a(param1Canvas, this.k);
      TransitionUtils.a(param1Canvas, getBounds(), this.y.left, this.y.top, this.H.b, this.G.b, new TransitionUtils.CanvasOperation(this) {
            public void a(Canvas param2Canvas) {
              MaterialContainerTransform.TransitionDrawable.b(this.a).draw(param2Canvas);
            }
          });
    }
    
    public void draw(Canvas param1Canvas) {
      byte b;
      if (this.m.getAlpha() > 0)
        param1Canvas.drawRect(getBounds(), this.m); 
      if (this.D) {
        b = param1Canvas.save();
      } else {
        b = -1;
      } 
      if (this.u && this.J > 0.0F)
        a(param1Canvas); 
      this.n.a(param1Canvas);
      a(param1Canvas, this.i);
      if (this.G.c) {
        d(param1Canvas);
        e(param1Canvas);
      } else {
        e(param1Canvas);
        d(param1Canvas);
      } 
      if (this.D) {
        param1Canvas.restoreToCount(b);
        a(param1Canvas, this.w, this.F, -65281);
        a(param1Canvas, this.x, -256);
        a(param1Canvas, this.w, -16711936);
        a(param1Canvas, this.z, -16711681);
        a(param1Canvas, this.y, -16776961);
      } 
    }
    
    public int getOpacity() {
      return -3;
    }
    
    public void setAlpha(int param1Int) {
      throw new UnsupportedOperationException("Setting alpha on is not supported");
    }
    
    public void setColorFilter(ColorFilter param1ColorFilter) {
      throw new UnsupportedOperationException("Setting a color filter is not supported");
    }
  }
  
  class null implements TransitionUtils.CanvasOperation {
    null(MaterialContainerTransform this$0) {}
    
    public void a(Canvas param1Canvas) {
      MaterialContainerTransform.TransitionDrawable.a(this.a).draw(param1Canvas);
    }
  }
  
  class null implements TransitionUtils.CanvasOperation {
    null(MaterialContainerTransform this$0) {}
    
    public void a(Canvas param1Canvas) {
      MaterialContainerTransform.TransitionDrawable.b(this.a).draw(param1Canvas);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\MaterialContainerTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */