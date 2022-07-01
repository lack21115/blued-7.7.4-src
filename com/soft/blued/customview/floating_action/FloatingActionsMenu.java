package com.soft.blued.customview.floating_action;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.soft.blued.R;

public class FloatingActionsMenu extends ViewGroup {
  private static Interpolator r = (Interpolator)new OvershootInterpolator();
  
  private static Interpolator s = (Interpolator)new DecelerateInterpolator(3.0F);
  
  private static Interpolator t = (Interpolator)new DecelerateInterpolator();
  
  public FloatingActionButton a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private boolean e;
  
  private AnimatorSet f = (new AnimatorSet()).setDuration(300L);
  
  private AnimatorSet g = (new AnimatorSet()).setDuration(300L);
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private boolean o;
  
  private TouchDelegateGroup p;
  
  private OnFloatingActionsMenuUpdateListener q;
  
  public FloatingActionsMenu(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public FloatingActionsMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt) {
    return paramInt * 12 / 10;
  }
  
  private void a(Context paramContext) {
    this.a = new FloatingActionButton(paramContext);
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.a.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
          }
        });
    addView((View)this.a, generateLayoutParams(new ViewGroup.LayoutParams(this.m, this.n)));
    this.l++;
    if (this.j != 0)
      h(); 
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    this.c = (int)getResources().getDimension(2131165462);
    this.d = getResources().getDimensionPixelSize(2131165463);
    this.p = new TouchDelegateGroup((View)this);
    setTouchDelegate(this.p);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionsMenu, 0, 0);
    this.b = typedArray.getInt(7, 0);
    this.j = typedArray.getResourceId(8, 0);
    this.k = typedArray.getInt(9, 0);
    this.m = typedArray.getLayoutDimension(6, "fab_button_width");
    this.n = typedArray.getLayoutDimension(5, "fab_button_height");
    typedArray.recycle();
    if (this.j == 0 || !g()) {
      a(paramContext);
      return;
    } 
    throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
  }
  
  private void a(boolean paramBoolean) {
    if (this.e) {
      long l;
      this.e = false;
      this.p.a(false);
      AnimatorSet animatorSet = this.g;
      if (paramBoolean) {
        l = 0L;
      } else {
        l = 300L;
      } 
      animatorSet.setDuration(l);
      this.g.start();
      this.f.cancel();
    } 
  }
  
  private boolean g() {
    int i = this.b;
    return (i == 2 || i == 3);
  }
  
  private void h() {
    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.j);
    for (int i = 0; i < this.l; i++) {
      FloatingActionButton floatingActionButton = (FloatingActionButton)getChildAt(i);
      String str2 = floatingActionButton.getTitle();
      String str1 = floatingActionButton.getColor();
      if (str2 != null && floatingActionButton.getTag(2131297027) == null) {
        TextView textView = new TextView((Context)contextThemeWrapper);
        textView.setTextAppearance(getContext(), this.j);
        textView.setText(floatingActionButton.getTitle());
        if (!TextUtils.isEmpty(str1))
          textView.setTextColor(Color.parseColor(str1)); 
        addView((View)textView);
        floatingActionButton.setTag(2131297027, textView);
      } 
    } 
  }
  
  public void a() {
    a(false);
  }
  
  public void b() {
    if (this.e) {
      a();
      return;
    } 
    c();
  }
  
  public void c() {
    if (!this.e) {
      this.e = true;
      this.p.a(true);
      this.g.cancel();
      this.f.start();
    } 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return super.checkLayoutParams(paramLayoutParams);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams(this, super.generateDefaultLayoutParams());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(this, super.generateLayoutParams(paramAttributeSet));
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return new LayoutParams(this, super.generateLayoutParams(paramLayoutParams));
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    bringChildToFront((View)this.a);
    this.l = getChildCount();
    if (this.j != 0)
      h(); 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = this.b;
    if (i != 0 && i != 1) {
      if (i != 2 && i != 3)
        return; 
      if (this.b == 2) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0) {
        paramInt3 = paramInt3 - paramInt1 - this.a.getMeasuredWidth();
      } else {
        paramInt3 = 0;
      } 
      paramInt1 = this.i;
      int j = paramInt4 - paramInt2 - paramInt1 + (paramInt1 - this.a.getMeasuredHeight()) / 2;
      FloatingActionButton floatingActionButton = this.a;
      floatingActionButton.layout(paramInt3, j, floatingActionButton.getMeasuredWidth() + paramInt3, this.a.getMeasuredHeight() + j);
      if (i != 0) {
        paramInt1 = paramInt3 - this.c;
      } else {
        paramInt1 = this.a.getMeasuredWidth() + paramInt3 + this.c;
      } 
      paramInt4 = this.l - 1;
      while (paramInt4 >= 0) {
        View view = getChildAt(paramInt4);
        paramInt2 = paramInt1;
        if (view != this.a)
          if (view.getVisibility() == 8) {
            paramInt2 = paramInt1;
          } else {
            float f1;
            paramInt2 = paramInt1;
            if (i != 0)
              paramInt2 = paramInt1 - view.getMeasuredWidth(); 
            paramInt1 = (this.a.getMeasuredHeight() - view.getMeasuredHeight()) / 2 + j;
            view.layout(paramInt2, paramInt1, view.getMeasuredWidth() + paramInt2, view.getMeasuredHeight() + paramInt1);
            float f2 = (paramInt3 - paramInt2);
            if (this.e) {
              f1 = 0.0F;
            } else {
              f1 = f2;
            } 
            view.setTranslationX(f1);
            if (this.e) {
              f1 = 1.0F;
            } else {
              f1 = 0.0F;
            } 
            view.setAlpha(f1);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            LayoutParams.a(layoutParams).setFloatValues(new float[] { 0.0F, f2 });
            LayoutParams.b(layoutParams).setFloatValues(new float[] { f2, 0.0F });
            layoutParams.a(view);
            if (i != 0) {
              paramInt2 -= this.c;
            } else {
              paramInt2 = paramInt2 + view.getMeasuredWidth() + this.c;
            } 
          }  
        paramInt4--;
        paramInt1 = paramInt2;
      } 
    } else {
      if (this.b == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (paramBoolean)
        this.p.a(); 
      if (i != 0) {
        paramInt2 = paramInt4 - paramInt2 - this.a.getMeasuredHeight();
      } else {
        paramInt2 = 0;
      } 
      if (this.k == 0) {
        paramInt4 = paramInt3 - paramInt1 - this.h / 2;
      } else {
        paramInt4 = this.h / 2;
      } 
      paramInt1 = paramInt4 - this.a.getMeasuredWidth() / 2;
      FloatingActionButton floatingActionButton = this.a;
      floatingActionButton.layout(paramInt1, paramInt2, floatingActionButton.getMeasuredWidth() + paramInt1, this.a.getMeasuredHeight() + paramInt2);
      paramInt1 = this.h / 2 + this.d;
      if (this.k == 0) {
        paramInt1 = paramInt4 - paramInt1;
      } else {
        paramInt1 += paramInt4;
      } 
      if (i != 0) {
        paramInt3 = paramInt2 - this.c;
      } else {
        paramInt3 = this.a.getMeasuredHeight() + paramInt2 + this.c;
      } 
      int j = this.l - 1;
      int k = paramInt2;
      while (j >= 0) {
        View view = getChildAt(j);
        if (j == this.l - 1) {
          View view1 = (View)view.getTag(2131297027);
          if (view1 != null) {
            int m;
            int n = paramInt4 - view.getMeasuredWidth() / 2;
            int i1 = this.c + paramInt3;
            if (this.k == 0) {
              paramInt2 = paramInt1 - view1.getMeasuredWidth();
            } else {
              paramInt2 = view1.getMeasuredWidth() + paramInt1;
            } 
            if (this.k == 0) {
              m = paramInt2;
            } else {
              m = paramInt1;
            } 
            if (this.k == 0)
              paramInt2 = paramInt1; 
            int i2 = (view.getMeasuredHeight() - view1.getMeasuredHeight()) / 2 + i1;
            float f = (k - i1);
            view1.layout(m, i2, paramInt2, i2 + view1.getMeasuredHeight());
            Rect rect = new Rect(Math.min(n, m), i1 - this.c / 2, Math.max(n + view.getMeasuredWidth(), paramInt2), i1 + view.getMeasuredHeight() + this.c / 2);
            this.p.a(new TouchDelegate(rect, view));
            if (this.o) {
              float f1;
              this.o = false;
              if (this.e) {
                f1 = 0.0F;
              } else {
                f1 = f;
              } 
              view1.setTranslationY(f1);
              if (this.e) {
                f1 = 1.0F;
              } else {
                f1 = 0.0F;
              } 
              view1.setAlpha(f1);
            } 
            LayoutParams layoutParams = (LayoutParams)view1.getLayoutParams();
            LayoutParams.a(layoutParams).setFloatValues(new float[] { 0.0F, f });
            LayoutParams.b(layoutParams).setFloatValues(new float[] { f, 0.0F });
            layoutParams.a(view1);
          } 
        } 
        if (view != this.a && view.getVisibility() != 8) {
          int n = paramInt4 - view.getMeasuredWidth() / 2;
          int m = paramInt3;
          if (i != 0)
            m = paramInt3 - view.getMeasuredHeight(); 
          view.layout(n, m, view.getMeasuredWidth() + n, view.getMeasuredHeight() + m);
          float f = (k - m);
          if (this.o) {
            float f1;
            this.o = false;
            if (this.e) {
              f1 = 0.0F;
            } else {
              f1 = f;
            } 
            view.setTranslationY(f1);
            if (this.e) {
              f1 = 1.0F;
            } else {
              f1 = 0.0F;
            } 
            view.setAlpha(f1);
          } 
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          LayoutParams.a(layoutParams).setFloatValues(new float[] { 0.0F, f });
          LayoutParams.b(layoutParams).setFloatValues(new float[] { f, 0.0F });
          layoutParams.a(view);
          View view1 = (View)view.getTag(2131297027);
          if (view1 != null) {
            if (this.k == 0) {
              paramInt2 = paramInt1 - view1.getMeasuredWidth();
            } else {
              paramInt2 = view1.getMeasuredWidth() + paramInt1;
            } 
            if (this.k == 0) {
              paramInt3 = paramInt2;
            } else {
              paramInt3 = paramInt1;
            } 
            if (this.k == 0)
              paramInt2 = paramInt1; 
            int i1 = (view.getMeasuredHeight() - view1.getMeasuredHeight()) / 2 + m;
            view1.layout(paramInt3, i1, paramInt2, i1 + view1.getMeasuredHeight());
            Rect rect = new Rect(Math.min(n, paramInt3), m - this.c / 2, Math.max(n + view.getMeasuredWidth(), paramInt2), view.getMeasuredHeight() + m + this.c / 2);
            this.p.a(new TouchDelegate(rect, view));
            if (this.o) {
              float f1;
              this.o = false;
              if (this.e) {
                f1 = 0.0F;
              } else {
                f1 = f;
              } 
              view1.setTranslationY(f1);
              if (this.e) {
                f1 = 1.0F;
              } else {
                f1 = 0.0F;
              } 
              view1.setAlpha(f1);
            } 
            LayoutParams layoutParams1 = (LayoutParams)view1.getLayoutParams();
            LayoutParams.a(layoutParams1).setFloatValues(new float[] { 0.0F, f });
            LayoutParams.b(layoutParams1).setFloatValues(new float[] { f, 0.0F });
            layoutParams1.a(view1);
          } 
          if (i != 0) {
            paramInt3 = m - this.c;
          } else {
            paramInt3 = m + view.getMeasuredHeight() + this.c;
          } 
        } 
        j--;
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    measureChildren(paramInt1, paramInt2);
    boolean bool = false;
    this.h = 0;
    this.i = 0;
    int i = 0;
    int j = 0;
    paramInt1 = 0;
    for (paramInt2 = 0; i < this.l; paramInt2 = n) {
      int k;
      int m;
      int n;
      View view = getChildAt(i);
      if (view.getVisibility() == 8) {
        k = j;
        m = paramInt1;
        n = paramInt2;
      } else {
        k = this.b;
        if (k != 0 && k != 1) {
          if (k == 2 || k == 3) {
            paramInt2 += view.getMeasuredWidth();
            this.i = Math.max(this.i, view.getMeasuredHeight());
          } 
        } else {
          this.h = Math.max(this.h, view.getMeasuredWidth());
          paramInt1 += view.getMeasuredHeight();
        } 
        k = j;
        m = paramInt1;
        n = paramInt2;
        if (!g()) {
          TextView textView = (TextView)view.getTag(2131297027);
          k = j;
          m = paramInt1;
          n = paramInt2;
          if (textView != null) {
            k = Math.max(j, textView.getMeasuredWidth());
            n = paramInt2;
            m = paramInt1;
          } 
        } 
      } 
      i++;
      j = k;
      paramInt1 = m;
    } 
    if (!g()) {
      i = this.h;
      paramInt2 = bool;
      if (j > 0)
        paramInt2 = this.d + j; 
      paramInt2 = i + paramInt2;
    } else {
      paramInt1 = this.i;
    } 
    i = this.b;
    if (i != 0 && i != 1) {
      if (i == 2 || i == 3)
        paramInt2 = a(paramInt2 + this.c * (this.l - 1)); 
    } else {
      paramInt1 = a(paramInt1 + this.c * (this.l - 1));
    } 
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState;
    if (paramParcelable instanceof SavedState) {
      savedState = (SavedState)paramParcelable;
      this.e = savedState.a;
      this.p.a(this.e);
      super.onRestoreInstanceState(savedState.getSuperState());
      return;
    } 
    super.onRestoreInstanceState((Parcelable)savedState);
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.e;
    return (Parcelable)savedState;
  }
  
  public void setButtonClickListener(View.OnClickListener paramOnClickListener) {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setButtonTitle(String paramString) {
    this.a.setTitle(paramString);
  }
  
  public void setButtonTitleColor(String paramString) {
    this.a.setLabelColor(paramString);
  }
  
  public void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    this.a.setEnabled(paramBoolean);
  }
  
  public void setOnFloatingActionsMenuUpdateListener(OnFloatingActionsMenuUpdateListener paramOnFloatingActionsMenuUpdateListener) {
    this.q = paramOnFloatingActionsMenuUpdateListener;
  }
  
  class LayoutParams extends ViewGroup.LayoutParams {
    private ObjectAnimator b = new ObjectAnimator();
    
    private ObjectAnimator c = new ObjectAnimator();
    
    private ObjectAnimator d = new ObjectAnimator();
    
    private ObjectAnimator e = new ObjectAnimator();
    
    private boolean f;
    
    public LayoutParams(FloatingActionsMenu this$0, ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.b.setInterpolator((TimeInterpolator)FloatingActionsMenu.d());
      this.c.setInterpolator((TimeInterpolator)FloatingActionsMenu.e());
      this.d.setInterpolator((TimeInterpolator)FloatingActionsMenu.f());
      this.e.setInterpolator((TimeInterpolator)FloatingActionsMenu.f());
      this.e.setProperty(View.ALPHA);
      this.e.setFloatValues(new float[] { 1.0F, 0.0F });
      this.c.setProperty(View.ALPHA);
      this.c.setFloatValues(new float[] { 0.0F, 1.0F });
      int i = FloatingActionsMenu.a(this$0);
      if (i != 0 && i != 1) {
        if (i != 2 && i != 3)
          return; 
        this.d.setProperty(View.TRANSLATION_X);
        this.b.setProperty(View.TRANSLATION_X);
        return;
      } 
      this.d.setProperty(View.TRANSLATION_Y);
      this.b.setProperty(View.TRANSLATION_Y);
    }
    
    private void a(Animator param1Animator, View param1View) {
      param1Animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
            public void onAnimationEnd(Animator param2Animator) {
              FloatingActionsMenu.a(this.a.a, true);
              if (FloatingActionsMenu.d(this.a.a)) {
                if (FloatingActionsMenu.e(this.a.a) != null) {
                  FloatingActionsMenu.e(this.a.a).a();
                  return;
                } 
              } else if (FloatingActionsMenu.e(this.a.a) != null) {
                FloatingActionsMenu.e(this.a.a).b();
              } 
            }
            
            public void onAnimationStart(Animator param2Animator) {
              if (FloatingActionsMenu.d(this.a.a)) {
                if (FloatingActionsMenu.e(this.a.a) != null) {
                  FloatingActionsMenu.e(this.a.a).c();
                  return;
                } 
              } else if (FloatingActionsMenu.e(this.a.a) != null) {
                FloatingActionsMenu.e(this.a.a).d();
              } 
            }
          });
    }
    
    public void a(View param1View) {
      this.e.setTarget(param1View);
      this.d.setTarget(param1View);
      this.c.setTarget(param1View);
      this.b.setTarget(param1View);
      if (!this.f) {
        a((Animator)this.b, param1View);
        a((Animator)this.d, param1View);
        FloatingActionsMenu.b(this.a).play((Animator)this.e);
        FloatingActionsMenu.b(this.a).play((Animator)this.d);
        FloatingActionsMenu.c(this.a).play((Animator)this.c);
        FloatingActionsMenu.c(this.a).play((Animator)this.b);
        this.f = true;
      } 
    }
  }
  
  class null extends AnimatorListenerAdapter {
    null(FloatingActionsMenu this$0) {}
    
    public void onAnimationEnd(Animator param1Animator) {
      FloatingActionsMenu.a(this.a.a, true);
      if (FloatingActionsMenu.d(this.a.a)) {
        if (FloatingActionsMenu.e(this.a.a) != null) {
          FloatingActionsMenu.e(this.a.a).a();
          return;
        } 
      } else if (FloatingActionsMenu.e(this.a.a) != null) {
        FloatingActionsMenu.e(this.a.a).b();
      } 
    }
    
    public void onAnimationStart(Animator param1Animator) {
      if (FloatingActionsMenu.d(this.a.a)) {
        if (FloatingActionsMenu.e(this.a.a) != null) {
          FloatingActionsMenu.e(this.a.a).c();
          return;
        } 
      } else if (FloatingActionsMenu.e(this.a.a) != null) {
        FloatingActionsMenu.e(this.a.a).d();
      } 
    }
  }
  
  public static interface OnFloatingActionsMenuUpdateListener {
    void a();
    
    void b();
    
    void c();
    
    void d();
  }
  
  public static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public FloatingActionsMenu.SavedState a(Parcel param2Parcel) {
          return new FloatingActionsMenu.SavedState(param2Parcel);
        }
        
        public FloatingActionsMenu.SavedState[] a(int param2Int) {
          return new FloatingActionsMenu.SavedState[param2Int];
        }
      };
    
    public boolean a;
    
    private SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.a = bool;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public FloatingActionsMenu.SavedState a(Parcel param1Parcel) {
      return new FloatingActionsMenu.SavedState(param1Parcel);
    }
    
    public FloatingActionsMenu.SavedState[] a(int param1Int) {
      return new FloatingActionsMenu.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\floating_action\FloatingActionsMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */