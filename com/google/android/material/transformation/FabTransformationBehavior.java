package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
  private final Rect a = new Rect();
  
  private final RectF b = new RectF();
  
  private final RectF c = new RectF();
  
  private final int[] d = new int[2];
  
  private float e;
  
  private float f;
  
  public FabTransformationBehavior() {}
  
  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private float a(View paramView1, View paramView2, Positioning paramPositioning) {
    float f;
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    b(paramView1, rectF1);
    a(paramView2, rectF2);
    int i = paramPositioning.a & 0x7;
    if (i != 1) {
      if (i != 3) {
        if (i != 5) {
          f = 0.0F;
        } else {
          f = rectF2.right;
          float f1 = rectF1.right;
          f -= f1;
        } 
      } else {
        f = rectF2.left;
        float f1 = rectF1.left;
        f -= f1;
      } 
    } else {
      f = rectF2.centerX();
      float f1 = rectF1.centerX();
      f -= f1;
    } 
    return f + paramPositioning.b;
  }
  
  private float a(FabTransformationSpec paramFabTransformationSpec, MotionTiming paramMotionTiming, float paramFloat1, float paramFloat2) {
    long l1 = paramMotionTiming.a();
    long l2 = paramMotionTiming.b();
    MotionTiming motionTiming = paramFabTransformationSpec.a.b("expansion");
    float f = (float)(motionTiming.a() + motionTiming.b() + 17L - l1) / (float)l2;
    return AnimationUtils.a(paramFloat1, paramFloat2, paramMotionTiming.c().getInterpolation(f));
  }
  
  private Pair<MotionTiming, MotionTiming> a(float paramFloat1, float paramFloat2, boolean paramBoolean, FabTransformationSpec paramFabTransformationSpec) {
    if (paramFloat1 != 0.0F) {
      MotionTiming motionTiming;
      int i = paramFloat2 cmp 0.0F;
      if (i == 0) {
        MotionTiming motionTiming4 = paramFabTransformationSpec.a.b("translationXLinear");
        motionTiming = paramFabTransformationSpec.a.b("translationYLinear");
        motionTiming1 = motionTiming4;
        return new Pair(motionTiming1, motionTiming);
      } 
      if ((paramBoolean && paramFloat2 < 0.0F) || (!paramBoolean && i > 0)) {
        motionTiming = ((FabTransformationSpec)motionTiming1).a.b("translationXCurveUpwards");
        MotionTiming motionTiming4 = ((FabTransformationSpec)motionTiming1).a.b("translationYCurveUpwards");
        motionTiming1 = motionTiming;
        motionTiming = motionTiming4;
      } else {
        motionTiming = ((FabTransformationSpec)motionTiming1).a.b("translationXCurveDownwards");
        MotionTiming motionTiming4 = ((FabTransformationSpec)motionTiming1).a.b("translationYCurveDownwards");
        motionTiming1 = motionTiming;
        motionTiming = motionTiming4;
      } 
      return new Pair(motionTiming1, motionTiming);
    } 
    MotionTiming motionTiming3 = ((FabTransformationSpec)motionTiming1).a.b("translationXLinear");
    MotionTiming motionTiming2 = ((FabTransformationSpec)motionTiming1).a.b("translationYLinear");
    MotionTiming motionTiming1 = motionTiming3;
    return new Pair(motionTiming1, motionTiming2);
  }
  
  private ViewGroup a(View paramView) {
    View view = paramView.findViewById(R.id.mtrl_child_content_container);
    return (view != null) ? b(view) : ((paramView instanceof TransformationChildLayout || paramView instanceof TransformationChildCard) ? b(((ViewGroup)paramView).getChildAt(0)) : b(paramView));
  }
  
  private void a(View paramView, long paramLong, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList) {
    if (Build.VERSION.SDK_INT >= 21 && paramLong > 0L) {
      Animator animator = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      animator.setStartDelay(0L);
      animator.setDuration(paramLong);
      paramList.add(animator);
    } 
  }
  
  private void a(View paramView, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramLong1 += paramLong2;
      if (paramLong1 < paramLong3) {
        Animator animator = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
        animator.setStartDelay(paramLong1);
        animator.setDuration(paramLong3 - paramLong1);
        paramList.add(animator);
      } 
    } 
  }
  
  private void a(View paramView, RectF paramRectF) {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = this.d;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }
  
  private void a(View paramView1, View paramView2, boolean paramBoolean, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList) {
    float f1 = a(paramView1, paramView2, paramFabTransformationSpec.b);
    float f2 = b(paramView1, paramView2, paramFabTransformationSpec.b);
    Pair<MotionTiming, MotionTiming> pair = a(f1, f2, paramBoolean, paramFabTransformationSpec);
    MotionTiming motionTiming1 = (MotionTiming)pair.first;
    MotionTiming motionTiming2 = (MotionTiming)pair.second;
    Property property1 = View.TRANSLATION_X;
    if (!paramBoolean)
      f1 = this.e; 
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(paramView1, property1, new float[] { f1 });
    Property property2 = View.TRANSLATION_Y;
    if (paramBoolean) {
      f1 = f2;
    } else {
      f1 = this.f;
    } 
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(paramView1, property2, new float[] { f1 });
    motionTiming1.a((Animator)objectAnimator2);
    motionTiming2.a((Animator)objectAnimator1);
    paramList.add(objectAnimator2);
    paramList.add(objectAnimator1);
  }
  
  private void a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, float paramFloat1, float paramFloat2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1) {
    Animator animator;
    if (!(paramView2 instanceof CircularRevealWidget))
      return; 
    CircularRevealWidget circularRevealWidget = (CircularRevealWidget)paramView2;
    float f2 = c(paramView1, paramView2, paramFabTransformationSpec.b);
    float f3 = d(paramView1, paramView2, paramFabTransformationSpec.b);
    ((FloatingActionButton)paramView1).a(this.a);
    float f1 = this.a.width() / 2.0F;
    MotionTiming motionTiming = paramFabTransformationSpec.a.b("expansion");
    if (paramBoolean1) {
      if (!paramBoolean2)
        circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(f2, f3, f1)); 
      if (paramBoolean2)
        f1 = (circularRevealWidget.getRevealInfo()).c; 
      animator = CircularRevealCompat.a(circularRevealWidget, f2, f3, MathUtils.a(f2, f3, 0.0F, 0.0F, paramFloat1, paramFloat2));
      animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, circularRevealWidget) {
            public void onAnimationEnd(Animator param1Animator) {
              CircularRevealWidget.RevealInfo revealInfo = this.a.getRevealInfo();
              revealInfo.c = Float.MAX_VALUE;
              this.a.setRevealInfo(revealInfo);
            }
          });
      a(paramView2, motionTiming.a(), (int)f2, (int)f3, f1, paramList);
    } else {
      paramFloat1 = (circularRevealWidget.getRevealInfo()).c;
      animator = CircularRevealCompat.a(circularRevealWidget, f2, f3, f1);
      long l = motionTiming.a();
      int i = (int)f2;
      int j = (int)f3;
      a(paramView2, l, i, j, paramFloat1, paramList);
      a(paramView2, motionTiming.a(), motionTiming.b(), paramFabTransformationSpec.a.a(), i, j, f1, paramList);
    } 
    motionTiming.a(animator);
    paramList.add(animator);
    paramList1.add(CircularRevealCompat.a(circularRevealWidget));
  }
  
  private void a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1) {
    ObjectAnimator objectAnimator;
    float f = ViewCompat.getElevation(paramView2) - ViewCompat.getElevation(paramView1);
    if (paramBoolean1) {
      if (!paramBoolean2)
        paramView2.setTranslationZ(-f); 
      objectAnimator = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F });
    } else {
      objectAnimator = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { -f });
    } 
    paramFabTransformationSpec.a.b("elevation").a((Animator)objectAnimator);
    paramList.add(objectAnimator);
  }
  
  private void a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1, RectF paramRectF) {
    ObjectAnimator objectAnimator1;
    ObjectAnimator objectAnimator2;
    float f1 = a(paramView1, paramView2, paramFabTransformationSpec.b);
    float f2 = b(paramView1, paramView2, paramFabTransformationSpec.b);
    Pair<MotionTiming, MotionTiming> pair = a(f1, f2, paramBoolean1, paramFabTransformationSpec);
    MotionTiming motionTiming1 = (MotionTiming)pair.first;
    MotionTiming motionTiming2 = (MotionTiming)pair.second;
    if (paramBoolean1) {
      if (!paramBoolean2) {
        paramView2.setTranslationX(-f1);
        paramView2.setTranslationY(-f2);
      } 
      objectAnimator1 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F });
      ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      a(paramView2, paramFabTransformationSpec, motionTiming1, motionTiming2, -f1, -f2, 0.0F, 0.0F, paramRectF);
      objectAnimator2 = objectAnimator;
    } else {
      objectAnimator1 = ObjectAnimator.ofFloat(objectAnimator2, View.TRANSLATION_X, new float[] { -f1 });
      objectAnimator2 = ObjectAnimator.ofFloat(objectAnimator2, View.TRANSLATION_Y, new float[] { -f2 });
    } 
    motionTiming1.a((Animator)objectAnimator1);
    motionTiming2.a((Animator)objectAnimator2);
    paramList.add(objectAnimator1);
    paramList.add(objectAnimator2);
  }
  
  private void a(View paramView, FabTransformationSpec paramFabTransformationSpec, MotionTiming paramMotionTiming1, MotionTiming paramMotionTiming2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, RectF paramRectF) {
    paramFloat1 = a(paramFabTransformationSpec, paramMotionTiming1, paramFloat1, paramFloat3);
    paramFloat2 = a(paramFabTransformationSpec, paramMotionTiming2, paramFloat2, paramFloat4);
    Rect rect = this.a;
    paramView.getWindowVisibleDisplayFrame(rect);
    RectF rectF1 = this.b;
    rectF1.set(rect);
    RectF rectF2 = this.c;
    a(paramView, rectF2);
    rectF2.offset(paramFloat1, paramFloat2);
    rectF2.intersect(rectF1);
    paramRectF.set(rectF2);
  }
  
  private float b(View paramView1, View paramView2, Positioning paramPositioning) {
    float f;
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    b(paramView1, rectF1);
    a(paramView2, rectF2);
    int i = paramPositioning.a & 0x70;
    if (i != 16) {
      if (i != 48) {
        if (i != 80) {
          f = 0.0F;
        } else {
          f = rectF2.bottom;
          float f1 = rectF1.bottom;
          f -= f1;
        } 
      } else {
        f = rectF2.top;
        float f1 = rectF1.top;
        f -= f1;
      } 
    } else {
      f = rectF2.centerY();
      float f1 = rectF1.centerY();
      f -= f1;
    } 
    return f + paramPositioning.c;
  }
  
  private ViewGroup b(View paramView) {
    return (paramView instanceof ViewGroup) ? (ViewGroup)paramView : null;
  }
  
  private void b(View paramView, RectF paramRectF) {
    a(paramView, paramRectF);
    paramRectF.offset(this.e, this.f);
  }
  
  private void b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1) {
    if (paramView2 instanceof CircularRevealWidget) {
      ObjectAnimator objectAnimator;
      if (!(paramView1 instanceof ImageView))
        return; 
      CircularRevealWidget circularRevealWidget = (CircularRevealWidget)paramView2;
      Drawable drawable = ((ImageView)paramView1).getDrawable();
      if (drawable == null)
        return; 
      drawable.mutate();
      if (paramBoolean1) {
        if (!paramBoolean2)
          drawable.setAlpha(255); 
        objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.a, new int[] { 0 });
      } else {
        objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.a, new int[] { 255 });
      } 
      objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView2) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.invalidate();
            }
          });
      paramFabTransformationSpec.a.b("iconFade").a((Animator)objectAnimator);
      paramList.add(objectAnimator);
      paramList1.add(new AnimatorListenerAdapter(this, circularRevealWidget, drawable) {
            public void onAnimationEnd(Animator param1Animator) {
              this.a.setCircularRevealOverlayDrawable(null);
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.a.setCircularRevealOverlayDrawable(this.b);
            }
          });
    } 
  }
  
  private float c(View paramView1, View paramView2, Positioning paramPositioning) {
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    b(paramView1, rectF1);
    a(paramView2, rectF2);
    rectF2.offset(-a(paramView1, paramView2, paramPositioning), 0.0F);
    return rectF1.centerX() - rectF2.left;
  }
  
  private int c(View paramView) {
    ColorStateList colorStateList = ViewCompat.getBackgroundTintList(paramView);
    return (colorStateList != null) ? colorStateList.getColorForState(paramView.getDrawableState(), colorStateList.getDefaultColor()) : 0;
  }
  
  private void c(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1) {
    ObjectAnimator objectAnimator;
    if (!(paramView2 instanceof CircularRevealWidget))
      return; 
    CircularRevealWidget circularRevealWidget = (CircularRevealWidget)paramView2;
    int i = c(paramView1);
    if (paramBoolean1) {
      if (!paramBoolean2)
        circularRevealWidget.setCircularRevealScrimColor(i); 
      objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.a, new int[] { 0xFFFFFF & i });
    } else {
      objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.a, new int[] { i });
    } 
    objectAnimator.setEvaluator((TypeEvaluator)ArgbEvaluatorCompat.a());
    paramFabTransformationSpec.a.b("color").a((Animator)objectAnimator);
    paramList.add(objectAnimator);
  }
  
  private float d(View paramView1, View paramView2, Positioning paramPositioning) {
    RectF rectF1 = this.b;
    RectF rectF2 = this.c;
    b(paramView1, rectF1);
    a(paramView2, rectF2);
    rectF2.offset(0.0F, -b(paramView1, paramView2, paramPositioning));
    return rectF1.centerY() - rectF2.top;
  }
  
  private void d(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, FabTransformationSpec paramFabTransformationSpec, List<Animator> paramList, List<Animator.AnimatorListener> paramList1) {
    ObjectAnimator objectAnimator;
    if (!(paramView2 instanceof ViewGroup))
      return; 
    if (paramView2 instanceof CircularRevealWidget && CircularRevealHelper.a == 0)
      return; 
    ViewGroup viewGroup = a(paramView2);
    if (viewGroup == null)
      return; 
    if (paramBoolean1) {
      if (!paramBoolean2)
        ChildrenAlphaProperty.a.set(viewGroup, Float.valueOf(0.0F)); 
      objectAnimator = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.a, new float[] { 1.0F });
    } else {
      objectAnimator = ObjectAnimator.ofFloat(objectAnimator, ChildrenAlphaProperty.a, new float[] { 0.0F });
    } 
    paramFabTransformationSpec.a.b("contentFade").a((Animator)objectAnimator);
    paramList.add(objectAnimator);
  }
  
  protected abstract FabTransformationSpec a(Context paramContext, boolean paramBoolean);
  
  protected AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2) {
    FabTransformationSpec fabTransformationSpec = a(paramView2.getContext(), paramBoolean1);
    if (paramBoolean1) {
      this.e = paramView1.getTranslationX();
      this.f = paramView1.getTranslationY();
    } 
    ArrayList<Animator> arrayList = new ArrayList();
    ArrayList<Animator.AnimatorListener> arrayList1 = new ArrayList();
    if (Build.VERSION.SDK_INT >= 21)
      a(paramView1, paramView2, paramBoolean1, paramBoolean2, fabTransformationSpec, arrayList, arrayList1); 
    RectF rectF = this.b;
    a(paramView1, paramView2, paramBoolean1, paramBoolean2, fabTransformationSpec, arrayList, arrayList1, rectF);
    float f1 = rectF.width();
    float f2 = rectF.height();
    a(paramView1, paramView2, paramBoolean1, fabTransformationSpec, arrayList);
    b(paramView1, paramView2, paramBoolean1, paramBoolean2, fabTransformationSpec, arrayList, arrayList1);
    a(paramView1, paramView2, paramBoolean1, paramBoolean2, fabTransformationSpec, f1, f2, arrayList, arrayList1);
    c(paramView1, paramView2, paramBoolean1, paramBoolean2, fabTransformationSpec, arrayList, arrayList1);
    d(paramView1, paramView2, paramBoolean1, paramBoolean2, fabTransformationSpec, arrayList, arrayList1);
    AnimatorSet animatorSet = new AnimatorSet();
    AnimatorSetCompat.a(animatorSet, arrayList);
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramBoolean1, paramView2, paramView1) {
          public void onAnimationEnd(Animator param1Animator) {
            if (!this.a) {
              this.b.setVisibility(4);
              this.c.setAlpha(1.0F);
              this.c.setVisibility(0);
            } 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            if (this.a) {
              this.b.setVisibility(0);
              this.c.setAlpha(0.0F);
              this.c.setVisibility(4);
            } 
          }
        });
    int i = 0;
    int j = arrayList1.size();
    while (i < j) {
      animatorSet.addListener(arrayList1.get(i));
      i++;
    } 
    return animatorSet;
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {
    if (paramView1.getVisibility() != 8) {
      boolean bool = paramView2 instanceof FloatingActionButton;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
        if (i != 0) {
          bool1 = bool2;
          return (i == paramView1.getId()) ? true : bool1;
        } 
      } else {
        return bool1;
      } 
    } else {
      throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    } 
    return true;
  }
  
  public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams paramLayoutParams) {
    if (paramLayoutParams.dodgeInsetEdges == 0)
      paramLayoutParams.dodgeInsetEdges = 80; 
  }
  
  public static class FabTransformationSpec {
    public MotionSpec a;
    
    public Positioning b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transformation\FabTransformationBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */