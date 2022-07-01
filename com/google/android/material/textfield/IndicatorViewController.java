package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController {
  private final Context a;
  
  private final TextInputLayout b;
  
  private LinearLayout c;
  
  private int d;
  
  private FrameLayout e;
  
  private int f;
  
  private Animator g;
  
  private final float h;
  
  private int i;
  
  private int j;
  
  private CharSequence k;
  
  private boolean l;
  
  private TextView m;
  
  private CharSequence n;
  
  private int o;
  
  private ColorStateList p;
  
  private CharSequence q;
  
  private boolean r;
  
  private TextView s;
  
  private int t;
  
  private ColorStateList u;
  
  private Typeface v;
  
  public IndicatorViewController(TextInputLayout paramTextInputLayout) {
    this.a = paramTextInputLayout.getContext();
    this.b = paramTextInputLayout;
    this.h = this.a.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
  }
  
  private ObjectAnimator a(TextView paramTextView) {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.h, 0.0F });
    objectAnimator.setDuration(217L);
    objectAnimator.setInterpolator(AnimationUtils.d);
    return objectAnimator;
  }
  
  private ObjectAnimator a(TextView paramTextView, boolean paramBoolean) {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    } 
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
    objectAnimator.setDuration(167L);
    objectAnimator.setInterpolator(AnimationUtils.a);
    return objectAnimator;
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (paramInt1 == paramInt2)
      return; 
    if (paramInt2 != 0) {
      TextView textView = d(paramInt2);
      if (textView != null) {
        textView.setVisibility(0);
        textView.setAlpha(1.0F);
      } 
    } 
    if (paramInt1 != 0) {
      TextView textView = d(paramInt1);
      if (textView != null) {
        textView.setVisibility(4);
        if (paramInt1 == 1)
          textView.setText(null); 
      } 
    } 
    this.i = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramInt1 == paramInt2)
      return; 
    if (paramBoolean) {
      AnimatorSet animatorSet = new AnimatorSet();
      this.g = (Animator)animatorSet;
      ArrayList<Animator> arrayList = new ArrayList();
      a(arrayList, this.r, this.s, 2, paramInt1, paramInt2);
      a(arrayList, this.l, this.m, 1, paramInt1, paramInt2);
      AnimatorSetCompat.a(animatorSet, arrayList);
      animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramInt2, d(paramInt1), paramInt1, d(paramInt2)) {
            public void onAnimationEnd(Animator param1Animator) {
              IndicatorViewController.a(this.e, this.a);
              IndicatorViewController.a(this.e, (Animator)null);
              TextView textView = this.b;
              if (textView != null) {
                textView.setVisibility(4);
                if (this.c == 1 && IndicatorViewController.a(this.e) != null)
                  IndicatorViewController.a(this.e).setText(null); 
              } 
              textView = this.d;
              if (textView != null) {
                textView.setTranslationY(0.0F);
                this.d.setAlpha(1.0F);
              } 
            }
            
            public void onAnimationStart(Animator param1Animator) {
              TextView textView = this.d;
              if (textView != null)
                textView.setVisibility(0); 
            }
          });
      animatorSet.start();
    } else {
      a(paramInt1, paramInt2);
    } 
    this.b.c();
    this.b.a(paramBoolean);
    this.b.f();
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt) {
    if (paramInt == 0)
      paramViewGroup.setVisibility(8); 
  }
  
  private void a(TextView paramTextView, Typeface paramTypeface) {
    if (paramTextView != null)
      paramTextView.setTypeface(paramTypeface); 
  }
  
  private void a(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramTextView != null) {
      if (!paramBoolean)
        return; 
      if (paramInt1 == paramInt3 || paramInt1 == paramInt2) {
        if (paramInt3 == paramInt1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        } 
        paramList.add(a(paramTextView, paramBoolean));
        if (paramInt3 == paramInt1)
          paramList.add(a(paramTextView)); 
      } 
    } 
  }
  
  private boolean a(TextView paramTextView, CharSequence paramCharSequence) {
    return (ViewCompat.isLaidOut((View)this.b) && this.b.isEnabled() && (this.j != this.i || paramTextView == null || !TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  private TextView d(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? null : this.s) : this.m;
  }
  
  private boolean e(int paramInt) {
    return (paramInt == 1 && this.m != null && !TextUtils.isEmpty(this.k));
  }
  
  private boolean n() {
    return (this.c != null && this.b.getEditText() != null);
  }
  
  void a() {
    c();
    if (this.i == 2)
      this.j = 0; 
    a(this.i, this.j, a(this.s, (CharSequence)null));
  }
  
  void a(ColorStateList paramColorStateList) {
    this.p = paramColorStateList;
    TextView textView = this.m;
    if (textView != null && paramColorStateList != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  void a(Typeface paramTypeface) {
    if (paramTypeface != this.v) {
      this.v = paramTypeface;
      a(this.m, paramTypeface);
      a(this.s, paramTypeface);
    } 
  }
  
  void a(TextView paramTextView, int paramInt) {
    if (this.c == null && this.e == null) {
      this.c = new LinearLayout(this.a);
      this.c.setOrientation(0);
      this.b.addView((View)this.c, -1, -2);
      this.e = new FrameLayout(this.a);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
      this.c.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
      if (this.b.getEditText() != null)
        d(); 
    } 
    if (a(paramInt)) {
      this.e.setVisibility(0);
      this.e.addView((View)paramTextView);
      this.f++;
    } else {
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      this.c.addView((View)paramTextView, (ViewGroup.LayoutParams)layoutParams);
    } 
    this.c.setVisibility(0);
    this.d++;
  }
  
  void a(CharSequence paramCharSequence) {
    c();
    this.q = paramCharSequence;
    this.s.setText(paramCharSequence);
    if (this.i != 2)
      this.j = 2; 
    a(this.i, this.j, a(this.s, paramCharSequence));
  }
  
  void a(boolean paramBoolean) {
    if (this.l == paramBoolean)
      return; 
    c();
    if (paramBoolean) {
      this.m = (TextView)new AppCompatTextView(this.a);
      this.m.setId(R.id.textinput_error);
      if (Build.VERSION.SDK_INT >= 17)
        this.m.setTextAlignment(5); 
      Typeface typeface = this.v;
      if (typeface != null)
        this.m.setTypeface(typeface); 
      b(this.o);
      a(this.p);
      c(this.n);
      this.m.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion((View)this.m, 1);
      a(this.m, 0);
    } else {
      b();
      b(this.m, 0);
      this.m = null;
      this.b.c();
      this.b.f();
    } 
    this.l = paramBoolean;
  }
  
  boolean a(int paramInt) {
    boolean bool = true;
    if (paramInt != 0) {
      if (paramInt == 1)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  void b() {
    this.k = null;
    c();
    if (this.i == 1)
      if (this.r && !TextUtils.isEmpty(this.q)) {
        this.j = 2;
      } else {
        this.j = 0;
      }  
    a(this.i, this.j, a(this.m, (CharSequence)null));
  }
  
  void b(int paramInt) {
    this.o = paramInt;
    TextView textView = this.m;
    if (textView != null)
      this.b.a(textView, paramInt); 
  }
  
  void b(ColorStateList paramColorStateList) {
    this.u = paramColorStateList;
    TextView textView = this.s;
    if (textView != null && paramColorStateList != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  void b(TextView paramTextView, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Landroid/widget/LinearLayout;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: aload_0
    //   9: iload_2
    //   10: invokevirtual a : (I)Z
    //   13: ifeq -> 55
    //   16: aload_0
    //   17: getfield e : Landroid/widget/FrameLayout;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull -> 55
    //   25: aload_0
    //   26: aload_0
    //   27: getfield f : I
    //   30: iconst_1
    //   31: isub
    //   32: putfield f : I
    //   35: aload_0
    //   36: aload_3
    //   37: aload_0
    //   38: getfield f : I
    //   41: invokespecial a : (Landroid/view/ViewGroup;I)V
    //   44: aload_0
    //   45: getfield e : Landroid/widget/FrameLayout;
    //   48: aload_1
    //   49: invokevirtual removeView : (Landroid/view/View;)V
    //   52: goto -> 63
    //   55: aload_0
    //   56: getfield c : Landroid/widget/LinearLayout;
    //   59: aload_1
    //   60: invokevirtual removeView : (Landroid/view/View;)V
    //   63: aload_0
    //   64: aload_0
    //   65: getfield d : I
    //   68: iconst_1
    //   69: isub
    //   70: putfield d : I
    //   73: aload_0
    //   74: aload_0
    //   75: getfield c : Landroid/widget/LinearLayout;
    //   78: aload_0
    //   79: getfield d : I
    //   82: invokespecial a : (Landroid/view/ViewGroup;I)V
    //   85: return
  }
  
  void b(CharSequence paramCharSequence) {
    c();
    this.k = paramCharSequence;
    this.m.setText(paramCharSequence);
    if (this.i != 1)
      this.j = 1; 
    a(this.i, this.j, a(this.m, paramCharSequence));
  }
  
  void b(boolean paramBoolean) {
    if (this.r == paramBoolean)
      return; 
    c();
    if (paramBoolean) {
      this.s = (TextView)new AppCompatTextView(this.a);
      this.s.setId(R.id.textinput_helper_text);
      if (Build.VERSION.SDK_INT >= 17)
        this.s.setTextAlignment(5); 
      Typeface typeface = this.v;
      if (typeface != null)
        this.s.setTypeface(typeface); 
      this.s.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion((View)this.s, 1);
      c(this.t);
      b(this.u);
      a(this.s, 1);
    } else {
      a();
      b(this.s, 1);
      this.s = null;
      this.b.c();
      this.b.f();
    } 
    this.r = paramBoolean;
  }
  
  void c() {
    Animator animator = this.g;
    if (animator != null)
      animator.cancel(); 
  }
  
  void c(int paramInt) {
    this.t = paramInt;
    TextView textView = this.s;
    if (textView != null)
      TextViewCompat.setTextAppearance(textView, paramInt); 
  }
  
  void c(CharSequence paramCharSequence) {
    this.n = paramCharSequence;
    TextView textView = this.m;
    if (textView != null)
      textView.setContentDescription(paramCharSequence); 
  }
  
  void d() {
    if (n())
      ViewCompat.setPaddingRelative((View)this.c, ViewCompat.getPaddingStart((View)this.b.getEditText()), 0, ViewCompat.getPaddingEnd((View)this.b.getEditText()), 0); 
  }
  
  boolean e() {
    return this.l;
  }
  
  boolean f() {
    return this.r;
  }
  
  boolean g() {
    return e(this.j);
  }
  
  CharSequence h() {
    return this.k;
  }
  
  CharSequence i() {
    return this.q;
  }
  
  int j() {
    TextView textView = this.m;
    return (textView != null) ? textView.getCurrentTextColor() : -1;
  }
  
  ColorStateList k() {
    TextView textView = this.m;
    return (textView != null) ? textView.getTextColors() : null;
  }
  
  CharSequence l() {
    return this.n;
  }
  
  int m() {
    TextView textView = this.s;
    return (textView != null) ? textView.getCurrentTextColor() : -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\IndicatorViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */