package com.soft.blued.ui.msg.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.view.CubicInterpolator;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.List;

public class TranslationAnimHintView extends FrameLayout {
  private List<HintInfo> a = new ArrayList<HintInfo>();
  
  private int b;
  
  public TranslationAnimHintView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TranslationAnimHintView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TranslationAnimHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TranslationAnimHintView);
    if (typedArray != null) {
      this.b = typedArray.getColor(0, 0);
      typedArray.recycle();
    } 
  }
  
  private HintInfo a(int paramInt, View.OnClickListener paramOnClickListener) {
    HintInfo hintInfo = new HintInfo();
    hintInfo.a = paramInt;
    hintInfo.c = paramOnClickListener;
    if (paramInt != 3) {
      if (paramInt != 4) {
        if (paramInt != 5)
          return hintInfo; 
        hintInfo.b = getResources().getString(2131757968);
        return hintInfo;
      } 
      hintInfo.b = getContext().getResources().getString(2131755803);
      return hintInfo;
    } 
    hintInfo.b = getResources().getString(2131758072);
    return hintInfo;
  }
  
  private void a(View paramView) {
    View view2 = null;
    View view1 = view2;
    try {
    
    } finally {
      view1 = null;
    } 
    AnimatorSet animatorSet = new AnimatorSet();
    paramView.setAlpha(0.0F);
    ValueAnimator valueAnimator1 = ValueAnimator.ofInt(new int[] { -paramView.getMeasuredHeight(), 0 });
    valueAnimator1.setInterpolator((TimeInterpolator)new CubicInterpolator(0.66F, 0.0F, 0.34F, 1.0F));
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
            if (TranslationAnimHintView.a(this.b) == 0) {
              marginLayoutParams.topMargin = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            } else {
              marginLayoutParams.bottomMargin = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            } 
            this.a.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          }
        });
    ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.b == 0) {
      valueAnimator2.setInterpolator((TimeInterpolator)new CubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    } else {
      valueAnimator2.setInterpolator((TimeInterpolator)new CubicInterpolator(0.66F, 0.0F, 0.34F, 1.0F));
    } 
    if (view1 != null)
      view1.setAlpha(1.0F); 
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView, view1) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            this.a.setAlpha(((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
            View view = this.b;
            if (view != null)
              view.setAlpha(1.0F - ((Float)param1ValueAnimator.getAnimatedValue()).floatValue()); 
          }
        });
    animatorSet.playTogether(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    animatorSet.setDuration(287L);
    animatorSet.start();
  }
  
  private void a(View paramView, HintInfo paramHintInfo) {
    // Byte code:
    //   0: aload_2
    //   1: getfield a : I
    //   4: istore_3
    //   5: iload_3
    //   6: iconst_1
    //   7: if_icmpeq -> 62
    //   10: iload_3
    //   11: iconst_2
    //   12: if_icmpeq -> 62
    //   15: iload_3
    //   16: iconst_3
    //   17: if_icmpeq -> 62
    //   20: iload_3
    //   21: iconst_4
    //   22: if_icmpeq -> 48
    //   25: iload_3
    //   26: iconst_5
    //   27: if_icmpeq -> 48
    //   30: iload_3
    //   31: bipush #11
    //   33: if_icmpeq -> 62
    //   36: iload_3
    //   37: bipush #12
    //   39: if_icmpeq -> 48
    //   42: aconst_null
    //   43: astore #4
    //   45: goto -> 73
    //   48: aload_1
    //   49: ldc 2131300617
    //   51: invokevirtual findViewById : (I)Landroid/view/View;
    //   54: checkcast android/widget/TextView
    //   57: astore #4
    //   59: goto -> 73
    //   62: aload_1
    //   63: ldc 2131300890
    //   65: invokevirtual findViewById : (I)Landroid/view/View;
    //   68: checkcast android/widget/TextView
    //   71: astore #4
    //   73: aload #4
    //   75: ifnull -> 87
    //   78: aload #4
    //   80: aload_2
    //   81: getfield b : Ljava/lang/String;
    //   84: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   87: aload_2
    //   88: getfield c : Landroid/view/View$OnClickListener;
    //   91: ifnull -> 107
    //   94: aload_1
    //   95: ldc 2131297729
    //   97: invokevirtual findViewById : (I)Landroid/view/View;
    //   100: aload_2
    //   101: getfield c : Landroid/view/View$OnClickListener;
    //   104: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   107: aload_2
    //   108: getfield d : Landroid/view/View$OnClickListener;
    //   111: ifnull -> 122
    //   114: aload_1
    //   115: aload_2
    //   116: getfield d : Landroid/view/View$OnClickListener;
    //   119: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   122: return
  }
  
  private View b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContext : ()Landroid/content/Context;
    //   4: ldc 2131494255
    //   6: aconst_null
    //   7: invokestatic inflate : (Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   10: astore_3
    //   11: aload_3
    //   12: ldc 2131299736
    //   14: invokevirtual findViewById : (I)Landroid/view/View;
    //   17: checkcast android/widget/RelativeLayout
    //   20: astore #4
    //   22: aload_3
    //   23: ldc 2131297804
    //   25: invokevirtual findViewById : (I)Landroid/view/View;
    //   28: checkcast android/widget/ImageView
    //   31: astore #5
    //   33: aload_3
    //   34: ldc 2131300890
    //   36: invokevirtual findViewById : (I)Landroid/view/View;
    //   39: checkcast android/widget/TextView
    //   42: astore #6
    //   44: aload_3
    //   45: ldc 2131297729
    //   47: invokevirtual findViewById : (I)Landroid/view/View;
    //   50: checkcast android/widget/ImageView
    //   53: astore #7
    //   55: aload_3
    //   56: ldc 2131300617
    //   58: invokevirtual findViewById : (I)Landroid/view/View;
    //   61: checkcast android/widget/TextView
    //   64: astore #8
    //   66: iload_1
    //   67: iconst_1
    //   68: if_icmpeq -> 264
    //   71: iload_1
    //   72: iconst_2
    //   73: if_icmpeq -> 264
    //   76: iload_1
    //   77: iconst_3
    //   78: if_icmpeq -> 199
    //   81: iload_1
    //   82: iconst_4
    //   83: if_icmpeq -> 157
    //   86: iload_1
    //   87: iconst_5
    //   88: if_icmpeq -> 106
    //   91: iload_1
    //   92: bipush #11
    //   94: if_icmpeq -> 199
    //   97: iload_1
    //   98: bipush #12
    //   100: if_icmpeq -> 106
    //   103: goto -> 317
    //   106: aload #4
    //   108: ldc '#E628282B'
    //   110: invokestatic parseColor : (Ljava/lang/String;)I
    //   113: invokevirtual setBackgroundColor : (I)V
    //   116: aload #5
    //   118: bipush #8
    //   120: invokevirtual setVisibility : (I)V
    //   123: aload #6
    //   125: iconst_4
    //   126: invokevirtual setVisibility : (I)V
    //   129: aload #7
    //   131: iconst_4
    //   132: invokevirtual setVisibility : (I)V
    //   135: aload #8
    //   137: iconst_0
    //   138: invokevirtual setVisibility : (I)V
    //   141: aload #8
    //   143: iconst_m1
    //   144: invokevirtual setTextColor : (I)V
    //   147: aload #8
    //   149: ldc 14.0
    //   151: invokevirtual setTextSize : (F)V
    //   154: goto -> 317
    //   157: aload #5
    //   159: bipush #8
    //   161: invokevirtual setVisibility : (I)V
    //   164: aload #4
    //   166: aload_0
    //   167: invokevirtual getContext : ()Landroid/content/Context;
    //   170: ldc 2131100471
    //   172: invokestatic a : (Landroid/content/Context;I)I
    //   175: invokevirtual setBackgroundColor : (I)V
    //   178: aload #6
    //   180: iconst_4
    //   181: invokevirtual setVisibility : (I)V
    //   184: aload #7
    //   186: iconst_4
    //   187: invokevirtual setVisibility : (I)V
    //   190: aload #8
    //   192: iconst_0
    //   193: invokevirtual setVisibility : (I)V
    //   196: goto -> 317
    //   199: aload #5
    //   201: bipush #8
    //   203: invokevirtual setVisibility : (I)V
    //   206: aload #4
    //   208: aload_0
    //   209: invokevirtual getContext : ()Landroid/content/Context;
    //   212: ldc 2131100471
    //   214: invokestatic a : (Landroid/content/Context;I)I
    //   217: invokevirtual setBackgroundColor : (I)V
    //   220: aload #6
    //   222: aload_0
    //   223: invokevirtual getContext : ()Landroid/content/Context;
    //   226: ldc 2131100838
    //   228: invokestatic a : (Landroid/content/Context;I)I
    //   231: invokevirtual setTextColor : (I)V
    //   234: aload #7
    //   236: aload_0
    //   237: invokevirtual getContext : ()Landroid/content/Context;
    //   240: ldc 2131232438
    //   242: invokestatic b : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   245: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   248: iload_1
    //   249: bipush #11
    //   251: if_icmpne -> 317
    //   254: aload #7
    //   256: bipush #8
    //   258: invokevirtual setVisibility : (I)V
    //   261: goto -> 317
    //   264: aload #5
    //   266: iconst_0
    //   267: invokevirtual setVisibility : (I)V
    //   270: aload #4
    //   272: aload_0
    //   273: invokevirtual getContext : ()Landroid/content/Context;
    //   276: ldc 2131100716
    //   278: invokestatic getColor : (Landroid/content/Context;I)I
    //   281: invokevirtual setBackgroundColor : (I)V
    //   284: aload #6
    //   286: aload_0
    //   287: invokevirtual getContext : ()Landroid/content/Context;
    //   290: ldc 2131100980
    //   292: invokestatic getColor : (Landroid/content/Context;I)I
    //   295: invokevirtual setTextColor : (I)V
    //   298: aload #7
    //   300: iconst_0
    //   301: invokevirtual setVisibility : (I)V
    //   304: aload #7
    //   306: ldc 2131232444
    //   308: invokevirtual setImageResource : (I)V
    //   311: aload #8
    //   313: iconst_4
    //   314: invokevirtual setVisibility : (I)V
    //   317: iconst_0
    //   318: iconst_0
    //   319: invokestatic makeMeasureSpec : (II)I
    //   322: istore_1
    //   323: aload_0
    //   324: getfield b : I
    //   327: ifne -> 336
    //   330: ldc 35.0
    //   332: fstore_2
    //   333: goto -> 339
    //   336: ldc 37.5
    //   338: fstore_2
    //   339: aload_3
    //   340: iload_1
    //   341: fload_2
    //   342: invokestatic a : (F)I
    //   345: ldc_w 1073741824
    //   348: invokestatic makeMeasureSpec : (II)I
    //   351: invokevirtual measure : (II)V
    //   354: aload_3
    //   355: iconst_0
    //   356: invokevirtual setVisibility : (I)V
    //   359: aload_3
    //   360: areturn
  }
  
  private void b(View paramView) {
    View view2 = null;
    View view1 = view2;
    try {
    
    } finally {
      view1 = null;
    } 
    AnimatorSet animatorSet = new AnimatorSet();
    ValueAnimator valueAnimator1 = ValueAnimator.ofInt(new int[] { 0, -paramView.getMeasuredHeight() });
    if (this.b == 0) {
      valueAnimator1.setInterpolator((TimeInterpolator)new CubicInterpolator(0.76F, 0.0F, 0.24F, 1.0F));
    } else {
      valueAnimator1.setInterpolator((TimeInterpolator)new CubicInterpolator(0.66F, 0.0F, 0.34F, 1.0F));
    } 
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
            if (TranslationAnimHintView.a(this.b) == 0) {
              marginLayoutParams.topMargin = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            } else {
              marginLayoutParams.bottomMargin = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            } 
            this.a.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          }
        });
    ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    if (this.b == 0) {
      valueAnimator2.setInterpolator((TimeInterpolator)new CubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    } else {
      valueAnimator2.setInterpolator((TimeInterpolator)new CubicInterpolator(0.66F, 0.0F, 0.34F, 1.0F));
    } 
    if (view1 != null)
      view1.setAlpha(0.0F); 
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, view1) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            View view = this.a;
            if (view != null)
              view.setAlpha(1.0F - ((Float)param1ValueAnimator.getAnimatedValue()).floatValue()); 
          }
        });
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramView) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            this.b.removeView(this.a);
          }
        });
    animatorSet.playTogether(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    animatorSet.setDuration(287L);
    animatorSet.start();
  }
  
  private boolean b(HintInfo paramHintInfo) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: ifle -> 60
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: aload_0
    //   16: getfield a : Ljava/util/List;
    //   19: invokeinterface size : ()I
    //   24: if_icmpge -> 60
    //   27: aload_0
    //   28: getfield a : Ljava/util/List;
    //   31: iload_2
    //   32: invokeinterface get : (I)Ljava/lang/Object;
    //   37: checkcast com/soft/blued/ui/msg/customview/TranslationAnimHintView$HintInfo
    //   40: getfield a : I
    //   43: aload_1
    //   44: getfield a : I
    //   47: if_icmple -> 53
    //   50: goto -> 62
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -> 14
    //   60: iconst_m1
    //   61: istore_2
    //   62: new android/widget/FrameLayout$LayoutParams
    //   65: dup
    //   66: iconst_m1
    //   67: bipush #-2
    //   69: invokespecial <init> : (II)V
    //   72: astore_3
    //   73: aload_0
    //   74: getfield b : I
    //   77: ifne -> 95
    //   80: aload_3
    //   81: aload_1
    //   82: getfield e : Landroid/view/View;
    //   85: invokevirtual getMeasuredHeight : ()I
    //   88: ineg
    //   89: putfield topMargin : I
    //   92: goto -> 107
    //   95: aload_3
    //   96: aload_1
    //   97: getfield e : Landroid/view/View;
    //   100: invokevirtual getMeasuredHeight : ()I
    //   103: ineg
    //   104: putfield bottomMargin : I
    //   107: iload_2
    //   108: iconst_m1
    //   109: if_icmpne -> 134
    //   112: aload_0
    //   113: getfield a : Ljava/util/List;
    //   116: aload_1
    //   117: invokeinterface add : (Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload_0
    //   124: aload_1
    //   125: getfield e : Landroid/view/View;
    //   128: aload_3
    //   129: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: aload_0
    //   135: getfield a : Ljava/util/List;
    //   138: iload_2
    //   139: aload_1
    //   140: invokeinterface add : (ILjava/lang/Object;)V
    //   145: aload_0
    //   146: aload_1
    //   147: getfield e : Landroid/view/View;
    //   150: iload_2
    //   151: aload_3
    //   152: invokevirtual addView : (Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    //   155: iconst_0
    //   156: ireturn
  }
  
  public void a(int paramInt) {
    boolean bool = false;
    int i = 0;
    int j = -1;
    while (i < this.a.size()) {
      if (((HintInfo)this.a.get(i)).a == paramInt)
        j = i; 
      i++;
    } 
    if (j != -1) {
      paramInt = bool;
      if (j == this.a.size() - 1)
        paramInt = 1; 
      HintInfo hintInfo = this.a.remove(j);
      if (paramInt != 0) {
        b(hintInfo.e);
        return;
      } 
      removeView(hintInfo.e);
    } 
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener, boolean... paramVarArgs) {
    HintInfo hintInfo = a(paramInt, paramOnClickListener);
    if (paramVarArgs.length > 0)
      hintInfo.f = paramVarArgs[0]; 
    try {
      return;
    } finally {
      hintInfo = null;
    } 
  }
  
  public void a(int paramInt, String paramString) {
    HintInfo hintInfo = new HintInfo();
    hintInfo.a = paramInt;
    hintInfo.b = paramString;
    try {
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public void a(HintInfo paramHintInfo) {
    if (paramHintInfo == null)
      return; 
    if (this.a.contains(paramHintInfo)) {
      int i = this.a.indexOf(paramHintInfo);
      HintInfo hintInfo = this.a.get(i);
      hintInfo.a(paramHintInfo);
      a(hintInfo.e, hintInfo);
      if (paramHintInfo.f && paramHintInfo.h != null) {
        AppInfo.n().removeCallbacks(paramHintInfo.h);
        AppInfo.n().postDelayed(paramHintInfo.h, paramHintInfo.g);
        return;
      } 
    } else {
      paramHintInfo.e = b(paramHintInfo.a);
      a(paramHintInfo.e, paramHintInfo);
      if (b(paramHintInfo))
        a(paramHintInfo.e); 
      if (paramHintInfo.f) {
        if (paramHintInfo.g == 0)
          paramHintInfo.g = 2385; 
        paramHintInfo.h = new Runnable(this, paramHintInfo) {
            public void run() {
              this.b.a(this.a.a);
            }
          };
        AppInfo.n().postDelayed(paramHintInfo.h, paramHintInfo.g);
      } 
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.a.clear();
    removeAllViews();
  }
  
  public static class HintInfo {
    public int a;
    
    public String b;
    
    public View.OnClickListener c;
    
    public View.OnClickListener d;
    
    public View e;
    
    public boolean f;
    
    public int g;
    
    public Runnable h;
    
    public void a(HintInfo param1HintInfo) {
      this.f = param1HintInfo.f;
      this.b = param1HintInfo.b;
      View.OnClickListener onClickListener = param1HintInfo.c;
      if (onClickListener != null)
        this.c = onClickListener; 
      onClickListener = param1HintInfo.d;
      if (onClickListener != null)
        this.d = onClickListener; 
      if (this.f) {
        int i = param1HintInfo.g;
        if (i != 0)
          this.g = i; 
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        return (this.a == ((HintInfo)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a;
    }
  }
  
  public static class TYPE_COMMON {}
  
  public static class TYPE_GROUP_MSG {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\TranslationAnimHintView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */