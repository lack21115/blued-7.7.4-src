package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
  private static final int d = R.style.Widget_Design_TextInputLayout;
  
  private boolean A;
  
  private CharSequence B;
  
  private boolean C;
  
  private MaterialShapeDrawable D;
  
  private MaterialShapeDrawable E;
  
  private ShapeAppearanceModel F;
  
  private final int G;
  
  private int H;
  
  private final int I;
  
  private int J;
  
  private int K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private final Rect O;
  
  private final Rect P;
  
  private final RectF Q;
  
  private Typeface R;
  
  private final CheckableImageButton S;
  
  private ColorStateList T;
  
  private boolean U;
  
  private PorterDuff.Mode V;
  
  private boolean W;
  
  EditText a;
  
  private int aA;
  
  private int aB;
  
  private int aC;
  
  private int aD;
  
  private boolean aE;
  
  private boolean aF;
  
  private ValueAnimator aG;
  
  private boolean aH;
  
  private boolean aI;
  
  private Drawable aa;
  
  private int ab;
  
  private View.OnLongClickListener ac;
  
  private final LinkedHashSet<OnEditTextAttachedListener> ad;
  
  private int ae;
  
  private final SparseArray<EndIconDelegate> af;
  
  private final CheckableImageButton ag;
  
  private final LinkedHashSet<OnEndIconChangedListener> ah;
  
  private ColorStateList ai;
  
  private boolean aj;
  
  private PorterDuff.Mode ak;
  
  private boolean al;
  
  private Drawable am;
  
  private int an;
  
  private Drawable ao;
  
  private View.OnLongClickListener ap;
  
  private View.OnLongClickListener aq;
  
  private final CheckableImageButton ar;
  
  private ColorStateList as;
  
  private ColorStateList at;
  
  private ColorStateList au;
  
  private int av;
  
  private int aw;
  
  private int ax;
  
  private ColorStateList ay;
  
  private int az;
  
  boolean b;
  
  final CollapsingTextHelper c;
  
  private final FrameLayout e;
  
  private final LinearLayout f;
  
  private final LinearLayout g;
  
  private final FrameLayout h;
  
  private CharSequence i;
  
  private final IndicatorViewController j;
  
  private int k;
  
  private boolean l;
  
  private TextView m;
  
  private int n;
  
  private int o;
  
  private CharSequence p;
  
  private boolean q;
  
  private TextView r;
  
  private ColorStateList s;
  
  private int t;
  
  private ColorStateList u;
  
  private ColorStateList v;
  
  private CharSequence w;
  
  private final TextView x;
  
  private CharSequence y;
  
  private final TextView z;
  
  public TextInputLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.textInputStyle);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {}
  
  private void A() {
    MaterialShapeDrawable materialShapeDrawable = this.D;
    if (materialShapeDrawable == null)
      return; 
    materialShapeDrawable.setShapeAppearanceModel(this.F);
    if (C())
      this.D.a(this.J, this.M); 
    this.N = z();
    this.D.g(ColorStateList.valueOf(this.N));
    if (this.ae == 3)
      this.a.getBackground().invalidateSelf(); 
    B();
    invalidate();
  }
  
  private void B() {
    if (this.E == null)
      return; 
    if (D())
      this.E.g(ColorStateList.valueOf(this.M)); 
    invalidate();
  }
  
  private boolean C() {
    return (this.H == 2 && D());
  }
  
  private boolean D() {
    return (this.J > -1 && this.M != 0);
  }
  
  private boolean E() {
    if (this.a == null)
      return false; 
    int i = Math.max(this.g.getMeasuredHeight(), this.f.getMeasuredHeight());
    if (this.a.getMeasuredHeight() < i) {
      this.a.setMinimumHeight(i);
      return true;
    } 
    return false;
  }
  
  private void F() {
    if (this.r != null) {
      EditText editText = this.a;
      if (editText != null) {
        int i = editText.getGravity();
        this.r.setGravity(i);
        this.r.setPadding(this.a.getCompoundPaddingLeft(), this.a.getCompoundPaddingTop(), this.a.getCompoundPaddingRight(), this.a.getCompoundPaddingBottom());
      } 
    } 
  }
  
  private void G() {
    Iterator<OnEditTextAttachedListener> iterator = this.ad.iterator();
    while (iterator.hasNext())
      ((OnEditTextAttachedListener)iterator.next()).a(this); 
  }
  
  private void H() {
    a(this.S, this.U, this.T, this.W, this.V);
  }
  
  private boolean I() {
    return (this.ae != 0);
  }
  
  private void J() {
    a(this.ag, this.aj, this.ai, this.al, this.ak);
  }
  
  private boolean K() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroid/widget/EditText;
    //   4: ifnonnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: invokespecial L : ()Z
    //   13: ifeq -> 129
    //   16: aload_0
    //   17: getfield f : Landroid/widget/LinearLayout;
    //   20: invokevirtual getMeasuredWidth : ()I
    //   23: aload_0
    //   24: getfield a : Landroid/widget/EditText;
    //   27: invokevirtual getPaddingLeft : ()I
    //   30: isub
    //   31: istore_1
    //   32: aload_0
    //   33: getfield aa : Landroid/graphics/drawable/Drawable;
    //   36: ifnull -> 47
    //   39: aload_0
    //   40: getfield ab : I
    //   43: iload_1
    //   44: if_icmpeq -> 77
    //   47: aload_0
    //   48: new android/graphics/drawable/ColorDrawable
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: putfield aa : Landroid/graphics/drawable/Drawable;
    //   58: aload_0
    //   59: iload_1
    //   60: putfield ab : I
    //   63: aload_0
    //   64: getfield aa : Landroid/graphics/drawable/Drawable;
    //   67: iconst_0
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield ab : I
    //   73: iconst_1
    //   74: invokevirtual setBounds : (IIII)V
    //   77: aload_0
    //   78: getfield a : Landroid/widget/EditText;
    //   81: invokestatic getCompoundDrawablesRelative : (Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;
    //   84: astore #5
    //   86: aload #5
    //   88: iconst_0
    //   89: aaload
    //   90: astore #6
    //   92: aload_0
    //   93: getfield aa : Landroid/graphics/drawable/Drawable;
    //   96: astore #7
    //   98: aload #6
    //   100: aload #7
    //   102: if_acmpeq -> 175
    //   105: aload_0
    //   106: getfield a : Landroid/widget/EditText;
    //   109: aload #7
    //   111: aload #5
    //   113: iconst_1
    //   114: aaload
    //   115: aload #5
    //   117: iconst_2
    //   118: aaload
    //   119: aload #5
    //   121: iconst_3
    //   122: aaload
    //   123: invokestatic setCompoundDrawablesRelative : (Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   126: goto -> 170
    //   129: aload_0
    //   130: getfield aa : Landroid/graphics/drawable/Drawable;
    //   133: ifnull -> 175
    //   136: aload_0
    //   137: getfield a : Landroid/widget/EditText;
    //   140: invokestatic getCompoundDrawablesRelative : (Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;
    //   143: astore #5
    //   145: aload_0
    //   146: getfield a : Landroid/widget/EditText;
    //   149: aconst_null
    //   150: aload #5
    //   152: iconst_1
    //   153: aaload
    //   154: aload #5
    //   156: iconst_2
    //   157: aaload
    //   158: aload #5
    //   160: iconst_3
    //   161: aaload
    //   162: invokestatic setCompoundDrawablesRelative : (Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield aa : Landroid/graphics/drawable/Drawable;
    //   170: iconst_1
    //   171: istore_3
    //   172: goto -> 177
    //   175: iconst_0
    //   176: istore_3
    //   177: aload_0
    //   178: invokespecial M : ()Z
    //   181: ifeq -> 394
    //   184: aload_0
    //   185: getfield z : Landroid/widget/TextView;
    //   188: invokevirtual getMeasuredWidth : ()I
    //   191: aload_0
    //   192: getfield a : Landroid/widget/EditText;
    //   195: invokevirtual getPaddingRight : ()I
    //   198: isub
    //   199: istore_2
    //   200: aload_0
    //   201: invokespecial getEndIconToUpdateDummyDrawable : ()Lcom/google/android/material/internal/CheckableImageButton;
    //   204: astore #5
    //   206: iload_2
    //   207: istore_1
    //   208: aload #5
    //   210: ifnull -> 233
    //   213: iload_2
    //   214: aload #5
    //   216: invokevirtual getMeasuredWidth : ()I
    //   219: iadd
    //   220: aload #5
    //   222: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   225: checkcast android/view/ViewGroup$MarginLayoutParams
    //   228: invokestatic getMarginStart : (Landroid/view/ViewGroup$MarginLayoutParams;)I
    //   231: iadd
    //   232: istore_1
    //   233: aload_0
    //   234: getfield a : Landroid/widget/EditText;
    //   237: invokestatic getCompoundDrawablesRelative : (Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;
    //   240: astore #5
    //   242: aload_0
    //   243: getfield am : Landroid/graphics/drawable/Drawable;
    //   246: astore #6
    //   248: aload #6
    //   250: ifnull -> 303
    //   253: aload_0
    //   254: getfield an : I
    //   257: iload_1
    //   258: if_icmpeq -> 303
    //   261: aload_0
    //   262: iload_1
    //   263: putfield an : I
    //   266: aload #6
    //   268: iconst_0
    //   269: iconst_0
    //   270: aload_0
    //   271: getfield an : I
    //   274: iconst_1
    //   275: invokevirtual setBounds : (IIII)V
    //   278: aload_0
    //   279: getfield a : Landroid/widget/EditText;
    //   282: aload #5
    //   284: iconst_0
    //   285: aaload
    //   286: aload #5
    //   288: iconst_1
    //   289: aaload
    //   290: aload_0
    //   291: getfield am : Landroid/graphics/drawable/Drawable;
    //   294: aload #5
    //   296: iconst_3
    //   297: aaload
    //   298: invokestatic setCompoundDrawablesRelative : (Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   301: iconst_1
    //   302: ireturn
    //   303: aload_0
    //   304: getfield am : Landroid/graphics/drawable/Drawable;
    //   307: ifnonnull -> 340
    //   310: aload_0
    //   311: new android/graphics/drawable/ColorDrawable
    //   314: dup
    //   315: invokespecial <init> : ()V
    //   318: putfield am : Landroid/graphics/drawable/Drawable;
    //   321: aload_0
    //   322: iload_1
    //   323: putfield an : I
    //   326: aload_0
    //   327: getfield am : Landroid/graphics/drawable/Drawable;
    //   330: iconst_0
    //   331: iconst_0
    //   332: aload_0
    //   333: getfield an : I
    //   336: iconst_1
    //   337: invokevirtual setBounds : (IIII)V
    //   340: aload #5
    //   342: iconst_2
    //   343: aaload
    //   344: astore #6
    //   346: aload_0
    //   347: getfield am : Landroid/graphics/drawable/Drawable;
    //   350: astore #7
    //   352: iload_3
    //   353: istore #4
    //   355: aload #6
    //   357: aload #7
    //   359: if_acmpeq -> 457
    //   362: aload_0
    //   363: aload #5
    //   365: iconst_2
    //   366: aaload
    //   367: putfield ao : Landroid/graphics/drawable/Drawable;
    //   370: aload_0
    //   371: getfield a : Landroid/widget/EditText;
    //   374: aload #5
    //   376: iconst_0
    //   377: aaload
    //   378: aload #5
    //   380: iconst_1
    //   381: aaload
    //   382: aload #7
    //   384: aload #5
    //   386: iconst_3
    //   387: aaload
    //   388: invokestatic setCompoundDrawablesRelative : (Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   391: goto -> 301
    //   394: iload_3
    //   395: istore #4
    //   397: aload_0
    //   398: getfield am : Landroid/graphics/drawable/Drawable;
    //   401: ifnull -> 457
    //   404: aload_0
    //   405: getfield a : Landroid/widget/EditText;
    //   408: invokestatic getCompoundDrawablesRelative : (Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;
    //   411: astore #5
    //   413: aload #5
    //   415: iconst_2
    //   416: aaload
    //   417: aload_0
    //   418: getfield am : Landroid/graphics/drawable/Drawable;
    //   421: if_acmpne -> 449
    //   424: aload_0
    //   425: getfield a : Landroid/widget/EditText;
    //   428: aload #5
    //   430: iconst_0
    //   431: aaload
    //   432: aload #5
    //   434: iconst_1
    //   435: aaload
    //   436: aload_0
    //   437: getfield ao : Landroid/graphics/drawable/Drawable;
    //   440: aload #5
    //   442: iconst_3
    //   443: aaload
    //   444: invokestatic setCompoundDrawablesRelative : (Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   447: iconst_1
    //   448: istore_3
    //   449: aload_0
    //   450: aconst_null
    //   451: putfield am : Landroid/graphics/drawable/Drawable;
    //   454: iload_3
    //   455: istore #4
    //   457: iload #4
    //   459: ireturn
  }
  
  private boolean L() {
    return ((getStartIconDrawable() != null || this.w != null) && this.f.getMeasuredWidth() > 0);
  }
  
  private boolean M() {
    return ((this.ar.getVisibility() == 0 || (I() && e()) || this.y != null) && this.g.getMeasuredWidth() > 0);
  }
  
  private boolean N() {
    return (this.A && !TextUtils.isEmpty(this.B) && this.D instanceof CutoutDrawable);
  }
  
  private void O() {
    if (!N())
      return; 
    RectF rectF = this.Q;
    this.c.a(rectF, this.a.getWidth(), this.a.getGravity());
    a(rectF);
    rectF.offset(-getPaddingLeft(), -getPaddingTop());
    ((CutoutDrawable)this.D).a(rectF);
  }
  
  private void P() {
    if (N())
      ((CutoutDrawable)this.D).b(); 
  }
  
  private boolean Q() {
    return (this.ar.getVisibility() == 0);
  }
  
  private int a(int paramInt, boolean paramBoolean) {
    int i = paramInt + this.a.getCompoundPaddingLeft();
    paramInt = i;
    if (this.w != null) {
      paramInt = i;
      if (!paramBoolean)
        paramInt = i - this.x.getMeasuredWidth() + this.x.getPaddingLeft(); 
    } 
    return paramInt;
  }
  
  private int a(Rect paramRect, float paramFloat) {
    return y() ? (int)(paramRect.centerY() - paramFloat / 2.0F) : (paramRect.top + this.a.getCompoundPaddingTop());
  }
  
  private int a(Rect paramRect1, Rect paramRect2, float paramFloat) {
    return y() ? (int)(paramRect2.top + paramFloat) : (paramRect1.bottom - this.a.getCompoundPaddingBottom());
  }
  
  private Rect a(Rect paramRect) {
    if (this.a != null) {
      boolean bool;
      Rect rect = this.P;
      if (ViewCompat.getLayoutDirection((View)this) == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      rect.bottom = paramRect.bottom;
      int i = this.H;
      if (i != 1) {
        if (i != 2) {
          rect.left = a(paramRect.left, bool);
          rect.top = getPaddingTop();
          rect.right = b(paramRect.right, bool);
          return rect;
        } 
        paramRect.left += this.a.getPaddingLeft();
        paramRect.top -= x();
        paramRect.right -= this.a.getPaddingRight();
        return rect;
      } 
      rect.left = a(paramRect.left, bool);
      paramRect.top += this.I;
      rect.right = b(paramRect.right, bool);
      return rect;
    } 
    throw new IllegalStateException();
  }
  
  private static void a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean) {
    int i;
    if (paramBoolean) {
      i = R.string.character_counter_overflowed_content_description;
    } else {
      i = R.string.character_counter_content_description;
    } 
    paramTextView.setContentDescription(paramContext.getString(i, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private void a(Canvas paramCanvas) {
    if (this.A)
      this.c.a(paramCanvas); 
  }
  
  private void a(RectF paramRectF) {
    paramRectF.left -= this.G;
    paramRectF.top -= this.G;
    paramRectF.right += this.G;
    paramRectF.bottom += this.G;
  }
  
  private static void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    int j = paramViewGroup.getChildCount();
    for (int i = 0; i < j; i++) {
      View view = paramViewGroup.getChildAt(i);
      view.setEnabled(paramBoolean);
      if (view instanceof ViewGroup)
        a((ViewGroup)view, paramBoolean); 
    } 
  }
  
  private void a(CheckableImageButton paramCheckableImageButton, ColorStateList paramColorStateList) {
    Drawable drawable = paramCheckableImageButton.getDrawable();
    if (paramCheckableImageButton.getDrawable() != null && paramColorStateList != null) {
      if (!paramColorStateList.isStateful())
        return; 
      int i = paramColorStateList.getColorForState(getDrawableState(), paramColorStateList.getDefaultColor());
      Drawable drawable1 = DrawableCompat.wrap(drawable).mutate();
      DrawableCompat.setTintList(drawable1, ColorStateList.valueOf(i));
      paramCheckableImageButton.setImageDrawable(drawable1);
    } 
  }
  
  private static void a(CheckableImageButton paramCheckableImageButton, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener) {
    paramCheckableImageButton.setOnClickListener(paramOnClickListener);
    b(paramCheckableImageButton, paramOnLongClickListener);
  }
  
  private static void a(CheckableImageButton paramCheckableImageButton, View.OnLongClickListener paramOnLongClickListener) {
    paramCheckableImageButton.setOnLongClickListener(paramOnLongClickListener);
    b(paramCheckableImageButton, paramOnLongClickListener);
  }
  
  private void a(CheckableImageButton paramCheckableImageButton, boolean paramBoolean1, ColorStateList paramColorStateList, boolean paramBoolean2, PorterDuff.Mode paramMode) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   4: astore #7
    //   6: aload #7
    //   8: astore #6
    //   10: aload #7
    //   12: ifnull -> 68
    //   15: iload_2
    //   16: ifne -> 28
    //   19: aload #7
    //   21: astore #6
    //   23: iload #4
    //   25: ifeq -> 68
    //   28: aload #7
    //   30: invokestatic wrap : (Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   33: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   36: astore #7
    //   38: iload_2
    //   39: ifeq -> 48
    //   42: aload #7
    //   44: aload_3
    //   45: invokestatic setTintList : (Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   48: aload #7
    //   50: astore #6
    //   52: iload #4
    //   54: ifeq -> 68
    //   57: aload #7
    //   59: aload #5
    //   61: invokestatic setTintMode : (Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   64: aload #7
    //   66: astore #6
    //   68: aload_1
    //   69: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   72: aload #6
    //   74: if_acmpeq -> 83
    //   77: aload_1
    //   78: aload #6
    //   80: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   83: return
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isEnabled : ()Z
    //   4: istore #6
    //   6: aload_0
    //   7: getfield a : Landroid/widget/EditText;
    //   10: astore #8
    //   12: aload #8
    //   14: ifnull -> 33
    //   17: aload #8
    //   19: invokevirtual getText : ()Landroid/text/Editable;
    //   22: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   25: ifne -> 33
    //   28: iconst_1
    //   29: istore_3
    //   30: goto -> 35
    //   33: iconst_0
    //   34: istore_3
    //   35: aload_0
    //   36: getfield a : Landroid/widget/EditText;
    //   39: astore #8
    //   41: aload #8
    //   43: ifnull -> 60
    //   46: aload #8
    //   48: invokevirtual hasFocus : ()Z
    //   51: ifeq -> 60
    //   54: iconst_1
    //   55: istore #4
    //   57: goto -> 63
    //   60: iconst_0
    //   61: istore #4
    //   63: aload_0
    //   64: getfield j : Lcom/google/android/material/textfield/IndicatorViewController;
    //   67: invokevirtual g : ()Z
    //   70: istore #7
    //   72: aload_0
    //   73: getfield at : Landroid/content/res/ColorStateList;
    //   76: astore #8
    //   78: aload #8
    //   80: ifnull -> 103
    //   83: aload_0
    //   84: getfield c : Lcom/google/android/material/internal/CollapsingTextHelper;
    //   87: aload #8
    //   89: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   92: aload_0
    //   93: getfield c : Lcom/google/android/material/internal/CollapsingTextHelper;
    //   96: aload_0
    //   97: getfield at : Landroid/content/res/ColorStateList;
    //   100: invokevirtual b : (Landroid/content/res/ColorStateList;)V
    //   103: iload #6
    //   105: ifne -> 179
    //   108: aload_0
    //   109: getfield at : Landroid/content/res/ColorStateList;
    //   112: astore #8
    //   114: aload #8
    //   116: ifnull -> 146
    //   119: aload_0
    //   120: getfield aD : I
    //   123: istore #5
    //   125: aload #8
    //   127: iconst_1
    //   128: newarray int
    //   130: dup
    //   131: iconst_0
    //   132: ldc_w -16842910
    //   135: iastore
    //   136: iload #5
    //   138: invokevirtual getColorForState : ([II)I
    //   141: istore #5
    //   143: goto -> 152
    //   146: aload_0
    //   147: getfield aD : I
    //   150: istore #5
    //   152: aload_0
    //   153: getfield c : Lcom/google/android/material/internal/CollapsingTextHelper;
    //   156: iload #5
    //   158: invokestatic valueOf : (I)Landroid/content/res/ColorStateList;
    //   161: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   164: aload_0
    //   165: getfield c : Lcom/google/android/material/internal/CollapsingTextHelper;
    //   168: iload #5
    //   170: invokestatic valueOf : (I)Landroid/content/res/ColorStateList;
    //   173: invokevirtual b : (Landroid/content/res/ColorStateList;)V
    //   176: goto -> 259
    //   179: iload #7
    //   181: ifeq -> 201
    //   184: aload_0
    //   185: getfield c : Lcom/google/android/material/internal/CollapsingTextHelper;
    //   188: aload_0
    //   189: getfield j : Lcom/google/android/material/textfield/IndicatorViewController;
    //   192: invokevirtual k : ()Landroid/content/res/ColorStateList;
    //   195: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   198: goto -> 259
    //   201: aload_0
    //   202: getfield l : Z
    //   205: ifeq -> 234
    //   208: aload_0
    //   209: getfield m : Landroid/widget/TextView;
    //   212: astore #8
    //   214: aload #8
    //   216: ifnull -> 234
    //   219: aload_0
    //   220: getfield c : Lcom/google/android/material/internal/CollapsingTextHelper;
    //   223: aload #8
    //   225: invokevirtual getTextColors : ()Landroid/content/res/ColorStateList;
    //   228: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   231: goto -> 259
    //   234: iload #4
    //   236: ifeq -> 259
    //   239: aload_0
    //   240: getfield au : Landroid/content/res/ColorStateList;
    //   243: astore #8
    //   245: aload #8
    //   247: ifnull -> 259
    //   250: aload_0
    //   251: getfield c : Lcom/google/android/material/internal/CollapsingTextHelper;
    //   254: aload #8
    //   256: invokevirtual a : (Landroid/content/res/ColorStateList;)V
    //   259: iload_3
    //   260: ifne -> 300
    //   263: aload_0
    //   264: invokevirtual isEnabled : ()Z
    //   267: ifeq -> 283
    //   270: iload #4
    //   272: ifne -> 300
    //   275: iload #7
    //   277: ifeq -> 283
    //   280: goto -> 300
    //   283: iload_2
    //   284: ifne -> 294
    //   287: aload_0
    //   288: getfield aE : Z
    //   291: ifne -> 316
    //   294: aload_0
    //   295: iload_1
    //   296: invokespecial d : (Z)V
    //   299: return
    //   300: iload_2
    //   301: ifne -> 311
    //   304: aload_0
    //   305: getfield aE : Z
    //   308: ifeq -> 316
    //   311: aload_0
    //   312: iload_1
    //   313: invokespecial c : (Z)V
    //   316: return
  }
  
  private int b(int paramInt, boolean paramBoolean) {
    int i = paramInt - this.a.getCompoundPaddingRight();
    paramInt = i;
    if (this.w != null) {
      paramInt = i;
      if (paramBoolean)
        paramInt = i + this.x.getMeasuredWidth() - this.x.getPaddingRight(); 
    } 
    return paramInt;
  }
  
  private Rect b(Rect paramRect) {
    if (this.a != null) {
      Rect rect = this.P;
      float f = this.c.b();
      paramRect.left += this.a.getCompoundPaddingLeft();
      rect.top = a(paramRect, f);
      paramRect.right -= this.a.getCompoundPaddingRight();
      rect.bottom = a(paramRect, rect, f);
      return rect;
    } 
    throw new IllegalStateException();
  }
  
  private void b(int paramInt) {
    if (paramInt == 0 && !this.aE) {
      o();
      return;
    } 
    p();
  }
  
  private void b(Canvas paramCanvas) {
    MaterialShapeDrawable materialShapeDrawable = this.E;
    if (materialShapeDrawable != null) {
      Rect rect = materialShapeDrawable.getBounds();
      rect.top = rect.bottom - this.J;
      this.E.draw(paramCanvas);
    } 
  }
  
  private static void b(CheckableImageButton paramCheckableImageButton, View.OnLongClickListener paramOnLongClickListener) {
    boolean bool1;
    boolean bool = ViewCompat.hasOnClickListeners((View)paramCheckableImageButton);
    boolean bool2 = false;
    byte b = 1;
    if (paramOnLongClickListener != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool || bool1)
      bool2 = true; 
    paramCheckableImageButton.setFocusable(bool2);
    paramCheckableImageButton.setClickable(bool);
    paramCheckableImageButton.setPressable(bool);
    paramCheckableImageButton.setLongClickable(bool1);
    if (!bool2)
      b = 2; 
    ViewCompat.setImportantForAccessibility((View)paramCheckableImageButton, b);
  }
  
  private void b(boolean paramBoolean) {
    if (paramBoolean && getEndIconDrawable() != null) {
      Drawable drawable = DrawableCompat.wrap(getEndIconDrawable()).mutate();
      DrawableCompat.setTint(drawable, this.j.j());
      this.ag.setImageDrawable(drawable);
      return;
    } 
    J();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2) {
    int i = this.ay.getDefaultColor();
    int j = this.ay.getColorForState(new int[] { 16843623, 16842910 }, i);
    int k = this.ay.getColorForState(new int[] { 16843518, 16842910 }, i);
    if (paramBoolean1) {
      this.M = k;
      return;
    } 
    if (paramBoolean2) {
      this.M = j;
      return;
    } 
    this.M = i;
  }
  
  private void c(int paramInt) {
    Iterator<OnEndIconChangedListener> iterator = this.ah.iterator();
    while (iterator.hasNext())
      ((OnEndIconChangedListener)iterator.next()).a(this, paramInt); 
  }
  
  private void c(Rect paramRect) {
    if (this.E != null) {
      int i = paramRect.bottom;
      int j = this.L;
      this.E.setBounds(paramRect.left, i - j, paramRect.right, paramRect.bottom);
    } 
  }
  
  private void c(boolean paramBoolean) {
    ValueAnimator valueAnimator = this.aG;
    if (valueAnimator != null && valueAnimator.isRunning())
      this.aG.cancel(); 
    if (paramBoolean && this.aF) {
      a(1.0F);
    } else {
      this.c.b(1.0F);
    } 
    this.aE = false;
    if (N())
      O(); 
    n();
    s();
    u();
  }
  
  private void d(boolean paramBoolean) {
    ValueAnimator valueAnimator = this.aG;
    if (valueAnimator != null && valueAnimator.isRunning())
      this.aG.cancel(); 
    if (paramBoolean && this.aF) {
      a(0.0F);
    } else {
      this.c.b(0.0F);
    } 
    if (N() && ((CutoutDrawable)this.D).a())
      P(); 
    this.aE = true;
    p();
    s();
    u();
  }
  
  private void g() {
    i();
    j();
    f();
    if (this.H != 0)
      l(); 
  }
  
  private EndIconDelegate getEndIconDelegate() {
    EndIconDelegate endIconDelegate = (EndIconDelegate)this.af.get(this.ae);
    return (endIconDelegate != null) ? endIconDelegate : (EndIconDelegate)this.af.get(0);
  }
  
  private CheckableImageButton getEndIconToUpdateDummyDrawable() {
    return (this.ar.getVisibility() == 0) ? this.ar : ((I() && e()) ? this.ag : null);
  }
  
  private void i() {
    int i = this.H;
    if (i != 0) {
      if (i != 1) {
        if (i == 2) {
          if (this.A && !(this.D instanceof CutoutDrawable)) {
            this.D = new CutoutDrawable(this.F);
          } else {
            this.D = new MaterialShapeDrawable(this.F);
          } 
          this.E = null;
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.H);
        stringBuilder.append(" is illegal; only @BoxBackgroundMode constants are supported.");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      this.D = new MaterialShapeDrawable(this.F);
      this.E = new MaterialShapeDrawable();
      return;
    } 
    this.D = null;
    this.E = null;
  }
  
  private void j() {
    if (k())
      ViewCompat.setBackground((View)this.a, (Drawable)this.D); 
  }
  
  private boolean k() {
    EditText editText = this.a;
    return (editText != null && this.D != null && editText.getBackground() == null && this.H != 0);
  }
  
  private void l() {
    if (this.H != 1) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
      int i = x();
      if (i != layoutParams.topMargin) {
        layoutParams.topMargin = i;
        this.e.requestLayout();
      } 
    } 
  }
  
  private void m() {
    if (this.m != null) {
      int i;
      EditText editText = this.a;
      if (editText == null) {
        i = 0;
      } else {
        i = editText.getText().length();
      } 
      a(i);
    } 
  }
  
  private void n() {
    int i;
    EditText editText = this.a;
    if (editText == null) {
      i = 0;
    } else {
      i = editText.getText().length();
    } 
    b(i);
  }
  
  private void o() {
    TextView textView = this.r;
    if (textView != null && this.q) {
      textView.setText(this.p);
      this.r.setVisibility(0);
      this.r.bringToFront();
    } 
  }
  
  private void p() {
    TextView textView = this.r;
    if (textView != null && this.q) {
      textView.setText(null);
      this.r.setVisibility(4);
    } 
  }
  
  private void q() {
    TextView textView = this.r;
    if (textView != null) {
      this.e.addView((View)textView);
      this.r.setVisibility(0);
    } 
  }
  
  private void r() {
    TextView textView = this.r;
    if (textView != null)
      textView.setVisibility(8); 
  }
  
  private void s() {
    byte b;
    TextView textView = this.x;
    if (this.w != null && !h()) {
      b = 0;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
    K();
  }
  
  private void setEditText(EditText paramEditText) {
    if (this.a == null) {
      if (this.ae != 3 && !(paramEditText instanceof TextInputEditText))
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead."); 
      this.a = paramEditText;
      g();
      setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
      this.c.c(this.a.getTypeface());
      this.c.a(this.a.getTextSize());
      int i = this.a.getGravity();
      this.c.b(i & 0xFFFFFF8F | 0x30);
      this.c.a(i);
      this.a.addTextChangedListener(new TextWatcher(this) {
            public void afterTextChanged(Editable param1Editable) {
              TextInputLayout textInputLayout = this.a;
              textInputLayout.a(TextInputLayout.a(textInputLayout) ^ true);
              if (this.a.b)
                this.a.a(param1Editable.length()); 
              if (TextInputLayout.b(this.a))
                TextInputLayout.a(this.a, param1Editable.length()); 
            }
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          });
      if (this.at == null)
        this.at = this.a.getHintTextColors(); 
      if (this.A) {
        if (TextUtils.isEmpty(this.B)) {
          this.i = this.a.getHint();
          setHint(this.i);
          this.a.setHint(null);
        } 
        this.C = true;
      } 
      if (this.m != null)
        a(this.a.getText().length()); 
      c();
      this.j.d();
      this.f.bringToFront();
      this.g.bringToFront();
      this.h.bringToFront();
      this.ar.bringToFront();
      G();
      t();
      v();
      if (!isEnabled())
        paramEditText.setEnabled(false); 
      a(false, true);
      return;
    } 
    throw new IllegalArgumentException("We already have an EditText, can only have one");
  }
  
  private void setErrorIconVisible(boolean paramBoolean) {
    CheckableImageButton checkableImageButton = this.ar;
    boolean bool = false;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    checkableImageButton.setVisibility(b);
    FrameLayout frameLayout = this.h;
    byte b = bool;
    if (paramBoolean)
      b = 8; 
    frameLayout.setVisibility(b);
    v();
    if (!I())
      K(); 
  }
  
  private void setHintInternal(CharSequence paramCharSequence) {
    if (!TextUtils.equals(paramCharSequence, this.B)) {
      this.B = paramCharSequence;
      this.c.a(paramCharSequence);
      if (!this.aE)
        O(); 
    } 
  }
  
  private void setPlaceholderTextEnabled(boolean paramBoolean) {
    if (this.q == paramBoolean)
      return; 
    if (paramBoolean) {
      this.r = (TextView)new AppCompatTextView(getContext());
      this.r.setId(R.id.textinput_placeholder);
      ViewCompat.setAccessibilityLiveRegion((View)this.r, 1);
      setPlaceholderTextAppearance(this.t);
      setPlaceholderTextColor(this.s);
      q();
    } else {
      r();
      this.r = null;
    } 
    this.q = paramBoolean;
  }
  
  private void t() {
    int i;
    if (this.a == null)
      return; 
    if (d()) {
      i = 0;
    } else {
      i = ViewCompat.getPaddingStart((View)this.a);
    } 
    ViewCompat.setPaddingRelative((View)this.x, i, this.a.getCompoundPaddingTop(), 0, this.a.getCompoundPaddingBottom());
  }
  
  private void u() {
    boolean bool;
    int i = this.z.getVisibility();
    CharSequence charSequence = this.y;
    byte b = 0;
    if (charSequence != null && !h()) {
      bool = true;
    } else {
      bool = false;
    } 
    TextView textView = this.z;
    if (!bool)
      b = 8; 
    textView.setVisibility(b);
    if (i != this.z.getVisibility())
      getEndIconDelegate().a(bool); 
    K();
  }
  
  private void v() {
    int i;
    if (this.a == null)
      return; 
    if (e() || Q()) {
      i = 0;
    } else {
      i = ViewCompat.getPaddingEnd((View)this.a);
    } 
    ViewCompat.setPaddingRelative((View)this.z, 0, this.a.getPaddingTop(), i, this.a.getPaddingBottom());
  }
  
  private void w() {
    TextView textView = this.m;
    if (textView != null) {
      int i;
      if (this.l) {
        i = this.n;
      } else {
        i = this.o;
      } 
      a(textView, i);
      if (!this.l) {
        ColorStateList colorStateList = this.u;
        if (colorStateList != null)
          this.m.setTextColor(colorStateList); 
      } 
      if (this.l) {
        ColorStateList colorStateList = this.v;
        if (colorStateList != null)
          this.m.setTextColor(colorStateList); 
      } 
    } 
  }
  
  private int x() {
    if (!this.A)
      return 0; 
    int i = this.H;
    if (i != 0 && i != 1) {
      if (i != 2)
        return 0; 
      float f1 = this.c.c() / 2.0F;
      return (int)f1;
    } 
    float f = this.c.c();
    return (int)f;
  }
  
  private boolean y() {
    int i = this.H;
    null = true;
    if (i == 1)
      if (Build.VERSION.SDK_INT >= 16) {
        if (this.a.getMinLines() <= 1)
          return true; 
      } else {
        return null;
      }  
    return false;
  }
  
  private int z() {
    int i = this.N;
    if (this.H == 1)
      i = MaterialColors.a(MaterialColors.a((View)this, R.attr.colorSurface, 0), this.N); 
    return i;
  }
  
  void a(float paramFloat) {
    if (this.c.j() == paramFloat)
      return; 
    if (this.aG == null) {
      this.aG = new ValueAnimator();
      this.aG.setInterpolator(AnimationUtils.b);
      this.aG.setDuration(167L);
      this.aG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.c.b(((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
            }
          });
    } 
    this.aG.setFloatValues(new float[] { this.c.j(), paramFloat });
    this.aG.start();
  }
  
  void a(int paramInt) {
    boolean bool = this.l;
    int i = this.k;
    if (i == -1) {
      this.m.setText(String.valueOf(paramInt));
      this.m.setContentDescription(null);
      this.l = false;
    } else {
      boolean bool1;
      if (paramInt > i) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.l = bool1;
      a(getContext(), this.m, paramInt, this.k, this.l);
      if (bool != this.l)
        w(); 
      BidiFormatter bidiFormatter = BidiFormatter.getInstance();
      this.m.setText(bidiFormatter.unicodeWrap(getContext().getString(R.string.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.k) })));
    } 
    if (this.a != null && bool != this.l) {
      a(false);
      f();
      c();
    } 
  }
  
  void a(TextView paramTextView, int paramInt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic setTextAppearance : (Landroid/widget/TextView;I)V
    //   7: getstatic android/os/Build$VERSION.SDK_INT : I
    //   10: bipush #23
    //   12: if_icmplt -> 35
    //   15: aload_1
    //   16: invokevirtual getTextColors : ()Landroid/content/res/ColorStateList;
    //   19: invokevirtual getDefaultColor : ()I
    //   22: istore_2
    //   23: iload_2
    //   24: ldc_w -65281
    //   27: if_icmpne -> 35
    //   30: iload_3
    //   31: istore_2
    //   32: goto -> 40
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -> 40
    //   40: iload_2
    //   41: ifeq -> 65
    //   44: aload_1
    //   45: getstatic com/google/android/material/R$style.TextAppearance_AppCompat_Caption : I
    //   48: invokestatic setTextAppearance : (Landroid/widget/TextView;I)V
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual getContext : ()Landroid/content/Context;
    //   56: getstatic com/google/android/material/R$color.design_error : I
    //   59: invokestatic getColor : (Landroid/content/Context;I)I
    //   62: invokevirtual setTextColor : (I)V
    //   65: return
    //   66: astore #4
    //   68: iload_3
    //   69: istore_2
    //   70: goto -> 40
    // Exception table:
    //   from	to	target	type
    //   2	23	66	java/lang/Exception
  }
  
  public void a(OnEditTextAttachedListener paramOnEditTextAttachedListener) {
    this.ad.add(paramOnEditTextAttachedListener);
    if (this.a != null)
      paramOnEditTextAttachedListener.a(this); 
  }
  
  public void a(OnEndIconChangedListener paramOnEndIconChangedListener) {
    this.ah.add(paramOnEndIconChangedListener);
  }
  
  public void a(boolean paramBoolean) {
    a(paramBoolean, false);
  }
  
  public boolean a() {
    return this.C;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    if (paramView instanceof EditText) {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      layoutParams.gravity = layoutParams.gravity & 0xFFFFFF8F | 0x10;
      this.e.addView(paramView, (ViewGroup.LayoutParams)layoutParams);
      this.e.setLayoutParams(paramLayoutParams);
      l();
      setEditText((EditText)paramView);
      return;
    } 
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean b() {
    return this.j.f();
  }
  
  public void c() {
    EditText editText = this.a;
    if (editText != null) {
      if (this.H != 0)
        return; 
      Drawable drawable2 = editText.getBackground();
      if (drawable2 == null)
        return; 
      Drawable drawable1 = drawable2;
      if (DrawableUtils.canSafelyMutateDrawable(drawable2))
        drawable1 = drawable2.mutate(); 
      if (this.j.g()) {
        drawable1.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter(this.j.j(), PorterDuff.Mode.SRC_IN));
        return;
      } 
      if (this.l) {
        TextView textView = this.m;
        if (textView != null) {
          drawable1.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
          return;
        } 
      } 
      DrawableCompat.clearColorFilter(drawable1);
      this.a.refreshDrawableState();
    } 
  }
  
  public boolean d() {
    return (this.S.getVisibility() == 0);
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt) {
    if (this.i != null) {
      EditText editText = this.a;
      if (editText != null) {
        boolean bool = this.C;
        this.C = false;
        CharSequence charSequence = editText.getHint();
        this.a.setHint(this.i);
        try {
          super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
          return;
        } finally {
          this.a.setHint(charSequence);
          this.C = bool;
        } 
      } 
    } 
    super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
    this.aI = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.aI = false;
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void drawableStateChanged() {
    boolean bool1;
    if (this.aH)
      return; 
    boolean bool2 = true;
    this.aH = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    CollapsingTextHelper collapsingTextHelper = this.c;
    if (collapsingTextHelper != null) {
      bool1 = collapsingTextHelper.a(arrayOfInt) | false;
    } else {
      bool1 = false;
    } 
    if (this.a != null) {
      if (!ViewCompat.isLaidOut((View)this) || !isEnabled())
        bool2 = false; 
      a(bool2);
    } 
    c();
    f();
    if (bool1)
      invalidate(); 
    this.aH = false;
  }
  
  public boolean e() {
    return (this.h.getVisibility() == 0 && this.ag.getVisibility() == 0);
  }
  
  void f() {
    // Byte code:
    //   0: aload_0
    //   1: getfield D : Lcom/google/android/material/shape/MaterialShapeDrawable;
    //   4: ifnull -> 436
    //   7: aload_0
    //   8: getfield H : I
    //   11: ifne -> 15
    //   14: return
    //   15: aload_0
    //   16: invokevirtual isFocused : ()Z
    //   19: istore_1
    //   20: iconst_0
    //   21: istore #4
    //   23: iload_1
    //   24: ifne -> 54
    //   27: aload_0
    //   28: getfield a : Landroid/widget/EditText;
    //   31: astore #5
    //   33: aload #5
    //   35: ifnull -> 49
    //   38: aload #5
    //   40: invokevirtual hasFocus : ()Z
    //   43: ifeq -> 49
    //   46: goto -> 54
    //   49: iconst_0
    //   50: istore_1
    //   51: goto -> 56
    //   54: iconst_1
    //   55: istore_1
    //   56: aload_0
    //   57: invokevirtual isHovered : ()Z
    //   60: ifne -> 90
    //   63: aload_0
    //   64: getfield a : Landroid/widget/EditText;
    //   67: astore #5
    //   69: aload #5
    //   71: ifnull -> 85
    //   74: aload #5
    //   76: invokevirtual isHovered : ()Z
    //   79: ifeq -> 85
    //   82: goto -> 90
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -> 92
    //   90: iconst_1
    //   91: istore_2
    //   92: aload_0
    //   93: invokevirtual isEnabled : ()Z
    //   96: ifne -> 110
    //   99: aload_0
    //   100: aload_0
    //   101: getfield aD : I
    //   104: putfield M : I
    //   107: goto -> 234
    //   110: aload_0
    //   111: getfield j : Lcom/google/android/material/textfield/IndicatorViewController;
    //   114: invokevirtual g : ()Z
    //   117: ifeq -> 150
    //   120: aload_0
    //   121: getfield ay : Landroid/content/res/ColorStateList;
    //   124: ifnull -> 136
    //   127: aload_0
    //   128: iload_1
    //   129: iload_2
    //   130: invokespecial b : (ZZ)V
    //   133: goto -> 234
    //   136: aload_0
    //   137: aload_0
    //   138: getfield j : Lcom/google/android/material/textfield/IndicatorViewController;
    //   141: invokevirtual j : ()I
    //   144: putfield M : I
    //   147: goto -> 234
    //   150: aload_0
    //   151: getfield l : Z
    //   154: ifeq -> 196
    //   157: aload_0
    //   158: getfield m : Landroid/widget/TextView;
    //   161: astore #5
    //   163: aload #5
    //   165: ifnull -> 196
    //   168: aload_0
    //   169: getfield ay : Landroid/content/res/ColorStateList;
    //   172: ifnull -> 184
    //   175: aload_0
    //   176: iload_1
    //   177: iload_2
    //   178: invokespecial b : (ZZ)V
    //   181: goto -> 234
    //   184: aload_0
    //   185: aload #5
    //   187: invokevirtual getCurrentTextColor : ()I
    //   190: putfield M : I
    //   193: goto -> 234
    //   196: iload_1
    //   197: ifeq -> 211
    //   200: aload_0
    //   201: aload_0
    //   202: getfield ax : I
    //   205: putfield M : I
    //   208: goto -> 234
    //   211: iload_2
    //   212: ifeq -> 226
    //   215: aload_0
    //   216: aload_0
    //   217: getfield aw : I
    //   220: putfield M : I
    //   223: goto -> 234
    //   226: aload_0
    //   227: aload_0
    //   228: getfield av : I
    //   231: putfield M : I
    //   234: iload #4
    //   236: istore_3
    //   237: aload_0
    //   238: invokevirtual getErrorIconDrawable : ()Landroid/graphics/drawable/Drawable;
    //   241: ifnull -> 272
    //   244: iload #4
    //   246: istore_3
    //   247: aload_0
    //   248: getfield j : Lcom/google/android/material/textfield/IndicatorViewController;
    //   251: invokevirtual e : ()Z
    //   254: ifeq -> 272
    //   257: iload #4
    //   259: istore_3
    //   260: aload_0
    //   261: getfield j : Lcom/google/android/material/textfield/IndicatorViewController;
    //   264: invokevirtual g : ()Z
    //   267: ifeq -> 272
    //   270: iconst_1
    //   271: istore_3
    //   272: aload_0
    //   273: iload_3
    //   274: invokespecial setErrorIconVisible : (Z)V
    //   277: aload_0
    //   278: aload_0
    //   279: getfield ar : Lcom/google/android/material/internal/CheckableImageButton;
    //   282: aload_0
    //   283: getfield as : Landroid/content/res/ColorStateList;
    //   286: invokespecial a : (Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;)V
    //   289: aload_0
    //   290: aload_0
    //   291: getfield S : Lcom/google/android/material/internal/CheckableImageButton;
    //   294: aload_0
    //   295: getfield T : Landroid/content/res/ColorStateList;
    //   298: invokespecial a : (Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;)V
    //   301: aload_0
    //   302: aload_0
    //   303: getfield ag : Lcom/google/android/material/internal/CheckableImageButton;
    //   306: aload_0
    //   307: getfield ai : Landroid/content/res/ColorStateList;
    //   310: invokespecial a : (Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;)V
    //   313: aload_0
    //   314: invokespecial getEndIconDelegate : ()Lcom/google/android/material/textfield/EndIconDelegate;
    //   317: invokevirtual b : ()Z
    //   320: ifeq -> 334
    //   323: aload_0
    //   324: aload_0
    //   325: getfield j : Lcom/google/android/material/textfield/IndicatorViewController;
    //   328: invokevirtual g : ()Z
    //   331: invokespecial b : (Z)V
    //   334: iload_1
    //   335: ifeq -> 356
    //   338: aload_0
    //   339: invokevirtual isEnabled : ()Z
    //   342: ifeq -> 356
    //   345: aload_0
    //   346: aload_0
    //   347: getfield L : I
    //   350: putfield J : I
    //   353: goto -> 364
    //   356: aload_0
    //   357: aload_0
    //   358: getfield K : I
    //   361: putfield J : I
    //   364: aload_0
    //   365: getfield H : I
    //   368: iconst_1
    //   369: if_icmpne -> 432
    //   372: aload_0
    //   373: invokevirtual isEnabled : ()Z
    //   376: ifne -> 390
    //   379: aload_0
    //   380: aload_0
    //   381: getfield aA : I
    //   384: putfield N : I
    //   387: goto -> 432
    //   390: iload_2
    //   391: ifeq -> 409
    //   394: iload_1
    //   395: ifne -> 409
    //   398: aload_0
    //   399: aload_0
    //   400: getfield aC : I
    //   403: putfield N : I
    //   406: goto -> 432
    //   409: iload_1
    //   410: ifeq -> 424
    //   413: aload_0
    //   414: aload_0
    //   415: getfield aB : I
    //   418: putfield N : I
    //   421: goto -> 432
    //   424: aload_0
    //   425: aload_0
    //   426: getfield az : I
    //   429: putfield N : I
    //   432: aload_0
    //   433: invokespecial A : ()V
    //   436: return
  }
  
  public int getBaseline() {
    EditText editText = this.a;
    return (editText != null) ? (editText.getBaseline() + getPaddingTop() + x()) : super.getBaseline();
  }
  
  MaterialShapeDrawable getBoxBackground() {
    int i = this.H;
    if (i == 1 || i == 2)
      return this.D; 
    throw new IllegalStateException();
  }
  
  public int getBoxBackgroundColor() {
    return this.N;
  }
  
  public int getBoxBackgroundMode() {
    return this.H;
  }
  
  public float getBoxCornerRadiusBottomEnd() {
    return this.D.ab();
  }
  
  public float getBoxCornerRadiusBottomStart() {
    return this.D.ac();
  }
  
  public float getBoxCornerRadiusTopEnd() {
    return this.D.aa();
  }
  
  public float getBoxCornerRadiusTopStart() {
    return this.D.Z();
  }
  
  public int getBoxStrokeColor() {
    return this.ax;
  }
  
  public ColorStateList getBoxStrokeErrorColor() {
    return this.ay;
  }
  
  public int getBoxStrokeWidth() {
    return this.K;
  }
  
  public int getBoxStrokeWidthFocused() {
    return this.L;
  }
  
  public int getCounterMaxLength() {
    return this.k;
  }
  
  CharSequence getCounterOverflowDescription() {
    if (this.b && this.l) {
      TextView textView = this.m;
      if (textView != null)
        return textView.getContentDescription(); 
    } 
    return null;
  }
  
  public ColorStateList getCounterOverflowTextColor() {
    return this.u;
  }
  
  public ColorStateList getCounterTextColor() {
    return this.u;
  }
  
  public ColorStateList getDefaultHintTextColor() {
    return this.at;
  }
  
  public EditText getEditText() {
    return this.a;
  }
  
  public CharSequence getEndIconContentDescription() {
    return this.ag.getContentDescription();
  }
  
  public Drawable getEndIconDrawable() {
    return this.ag.getDrawable();
  }
  
  public int getEndIconMode() {
    return this.ae;
  }
  
  CheckableImageButton getEndIconView() {
    return this.ag;
  }
  
  public CharSequence getError() {
    return this.j.e() ? this.j.h() : null;
  }
  
  public CharSequence getErrorContentDescription() {
    return this.j.l();
  }
  
  public int getErrorCurrentTextColors() {
    return this.j.j();
  }
  
  public Drawable getErrorIconDrawable() {
    return this.ar.getDrawable();
  }
  
  final int getErrorTextCurrentColor() {
    return this.j.j();
  }
  
  public CharSequence getHelperText() {
    return this.j.f() ? this.j.i() : null;
  }
  
  public int getHelperTextCurrentTextColor() {
    return this.j.m();
  }
  
  public CharSequence getHint() {
    return this.A ? this.B : null;
  }
  
  final float getHintCollapsedTextHeight() {
    return this.c.c();
  }
  
  final int getHintCurrentCollapsedTextColor() {
    return this.c.k();
  }
  
  public ColorStateList getHintTextColor() {
    return this.au;
  }
  
  @Deprecated
  public CharSequence getPasswordVisibilityToggleContentDescription() {
    return this.ag.getContentDescription();
  }
  
  @Deprecated
  public Drawable getPasswordVisibilityToggleDrawable() {
    return this.ag.getDrawable();
  }
  
  public CharSequence getPlaceholderText() {
    return this.q ? this.p : null;
  }
  
  public int getPlaceholderTextAppearance() {
    return this.t;
  }
  
  public ColorStateList getPlaceholderTextColor() {
    return this.s;
  }
  
  public CharSequence getPrefixText() {
    return this.w;
  }
  
  public ColorStateList getPrefixTextColor() {
    return this.x.getTextColors();
  }
  
  public TextView getPrefixTextView() {
    return this.x;
  }
  
  public CharSequence getStartIconContentDescription() {
    return this.S.getContentDescription();
  }
  
  public Drawable getStartIconDrawable() {
    return this.S.getDrawable();
  }
  
  public CharSequence getSuffixText() {
    return this.y;
  }
  
  public ColorStateList getSuffixTextColor() {
    return this.z.getTextColors();
  }
  
  public TextView getSuffixTextView() {
    return this.z;
  }
  
  public Typeface getTypeface() {
    return this.R;
  }
  
  final boolean h() {
    return this.aE;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    EditText editText = this.a;
    if (editText != null) {
      Rect rect = this.O;
      DescendantOffsetUtils.b((ViewGroup)this, (View)editText, rect);
      c(rect);
      if (this.A) {
        this.c.a(this.a.getTextSize());
        paramInt1 = this.a.getGravity();
        this.c.b(paramInt1 & 0xFFFFFF8F | 0x30);
        this.c.a(paramInt1);
        this.c.b(a(rect));
        this.c.a(b(rect));
        this.c.l();
        if (N() && !this.aE)
          O(); 
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    boolean bool1 = E();
    boolean bool2 = K();
    if (bool1 || bool2)
      this.a.post(new Runnable(this) {
            public void run() {
              this.a.a.requestLayout();
            }
          }); 
    F();
    t();
    v();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    setError(savedState.a);
    if (savedState.b)
      this.ag.post(new Runnable(this) {
            public void run() {
              TextInputLayout.c(this.a).performClick();
              TextInputLayout.c(this.a).jumpDrawablesToCurrentState();
            }
          }); 
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState() {
    boolean bool;
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    if (this.j.g())
      savedState.a = getError(); 
    if (I() && this.ag.isChecked()) {
      bool = true;
    } else {
      bool = false;
    } 
    savedState.b = bool;
    return (Parcelable)savedState;
  }
  
  public void setBoxBackgroundColor(int paramInt) {
    if (this.N != paramInt) {
      this.N = paramInt;
      this.az = paramInt;
      this.aB = paramInt;
      this.aC = paramInt;
      A();
    } 
  }
  
  public void setBoxBackgroundColorResource(int paramInt) {
    setBoxBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setBoxBackgroundColorStateList(ColorStateList paramColorStateList) {
    this.az = paramColorStateList.getDefaultColor();
    this.N = this.az;
    this.aA = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
    this.aB = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);
    this.aC = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
    A();
  }
  
  public void setBoxBackgroundMode(int paramInt) {
    if (paramInt == this.H)
      return; 
    this.H = paramInt;
    if (this.a != null)
      g(); 
  }
  
  public void setBoxStrokeColor(int paramInt) {
    if (this.ax != paramInt) {
      this.ax = paramInt;
      f();
    } 
  }
  
  public void setBoxStrokeColorStateList(ColorStateList paramColorStateList) {
    if (paramColorStateList.isStateful()) {
      this.av = paramColorStateList.getDefaultColor();
      this.aD = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
      this.aw = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
      this.ax = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);
    } else if (this.ax != paramColorStateList.getDefaultColor()) {
      this.ax = paramColorStateList.getDefaultColor();
    } 
    f();
  }
  
  public void setBoxStrokeErrorColor(ColorStateList paramColorStateList) {
    if (this.ay != paramColorStateList) {
      this.ay = paramColorStateList;
      f();
    } 
  }
  
  public void setBoxStrokeWidth(int paramInt) {
    this.K = paramInt;
    f();
  }
  
  public void setBoxStrokeWidthFocused(int paramInt) {
    this.L = paramInt;
    f();
  }
  
  public void setBoxStrokeWidthFocusedResource(int paramInt) {
    setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setBoxStrokeWidthResource(int paramInt) {
    setBoxStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setCounterEnabled(boolean paramBoolean) {
    if (this.b != paramBoolean) {
      if (paramBoolean) {
        this.m = (TextView)new AppCompatTextView(getContext());
        this.m.setId(R.id.textinput_counter);
        Typeface typeface = this.R;
        if (typeface != null)
          this.m.setTypeface(typeface); 
        this.m.setMaxLines(1);
        this.j.a(this.m, 2);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)this.m.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
        w();
        m();
      } else {
        this.j.b(this.m, 2);
        this.m = null;
      } 
      this.b = paramBoolean;
    } 
  }
  
  public void setCounterMaxLength(int paramInt) {
    if (this.k != paramInt) {
      if (paramInt > 0) {
        this.k = paramInt;
      } else {
        this.k = -1;
      } 
      if (this.b)
        m(); 
    } 
  }
  
  public void setCounterOverflowTextAppearance(int paramInt) {
    if (this.n != paramInt) {
      this.n = paramInt;
      w();
    } 
  }
  
  public void setCounterOverflowTextColor(ColorStateList paramColorStateList) {
    if (this.v != paramColorStateList) {
      this.v = paramColorStateList;
      w();
    } 
  }
  
  public void setCounterTextAppearance(int paramInt) {
    if (this.o != paramInt) {
      this.o = paramInt;
      w();
    } 
  }
  
  public void setCounterTextColor(ColorStateList paramColorStateList) {
    if (this.u != paramColorStateList) {
      this.u = paramColorStateList;
      w();
    } 
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList) {
    this.at = paramColorStateList;
    this.au = paramColorStateList;
    if (this.a != null)
      a(false); 
  }
  
  public void setEnabled(boolean paramBoolean) {
    a((ViewGroup)this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setEndIconActivated(boolean paramBoolean) {
    this.ag.setActivated(paramBoolean);
  }
  
  public void setEndIconCheckable(boolean paramBoolean) {
    this.ag.setCheckable(paramBoolean);
  }
  
  public void setEndIconContentDescription(int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getResources().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setEndIconContentDescription(charSequence);
  }
  
  public void setEndIconContentDescription(CharSequence paramCharSequence) {
    if (getEndIconContentDescription() != paramCharSequence)
      this.ag.setContentDescription(paramCharSequence); 
  }
  
  public void setEndIconDrawable(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setEndIconDrawable(drawable);
  }
  
  public void setEndIconDrawable(Drawable paramDrawable) {
    this.ag.setImageDrawable(paramDrawable);
  }
  
  public void setEndIconMode(int paramInt) {
    boolean bool;
    int i = this.ae;
    this.ae = paramInt;
    c(i);
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    setEndIconVisible(bool);
    if (getEndIconDelegate().a(this.H)) {
      getEndIconDelegate().a();
      J();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The current box background mode ");
    stringBuilder.append(this.H);
    stringBuilder.append(" is not supported by the end icon mode ");
    stringBuilder.append(paramInt);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void setEndIconOnClickListener(View.OnClickListener paramOnClickListener) {
    a(this.ag, paramOnClickListener, this.ap);
  }
  
  public void setEndIconOnLongClickListener(View.OnLongClickListener paramOnLongClickListener) {
    this.ap = paramOnLongClickListener;
    a(this.ag, paramOnLongClickListener);
  }
  
  public void setEndIconTintList(ColorStateList paramColorStateList) {
    if (this.ai != paramColorStateList) {
      this.ai = paramColorStateList;
      this.aj = true;
      J();
    } 
  }
  
  public void setEndIconTintMode(PorterDuff.Mode paramMode) {
    if (this.ak != paramMode) {
      this.ak = paramMode;
      this.al = true;
      J();
    } 
  }
  
  public void setEndIconVisible(boolean paramBoolean) {
    if (e() != paramBoolean) {
      byte b;
      CheckableImageButton checkableImageButton = this.ag;
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      checkableImageButton.setVisibility(b);
      v();
      K();
    } 
  }
  
  public void setError(CharSequence paramCharSequence) {
    if (!this.j.e()) {
      if (TextUtils.isEmpty(paramCharSequence))
        return; 
      setErrorEnabled(true);
    } 
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.j.b(paramCharSequence);
      return;
    } 
    this.j.b();
  }
  
  public void setErrorContentDescription(CharSequence paramCharSequence) {
    this.j.c(paramCharSequence);
  }
  
  public void setErrorEnabled(boolean paramBoolean) {
    this.j.a(paramBoolean);
  }
  
  public void setErrorIconDrawable(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setErrorIconDrawable(drawable);
  }
  
  public void setErrorIconDrawable(Drawable paramDrawable) {
    boolean bool;
    this.ar.setImageDrawable(paramDrawable);
    if (paramDrawable != null && this.j.e()) {
      bool = true;
    } else {
      bool = false;
    } 
    setErrorIconVisible(bool);
  }
  
  public void setErrorIconOnClickListener(View.OnClickListener paramOnClickListener) {
    a(this.ar, paramOnClickListener, this.aq);
  }
  
  public void setErrorIconOnLongClickListener(View.OnLongClickListener paramOnLongClickListener) {
    this.aq = paramOnLongClickListener;
    a(this.ar, paramOnLongClickListener);
  }
  
  public void setErrorIconTintList(ColorStateList paramColorStateList) {
    this.as = paramColorStateList;
    Drawable drawable2 = this.ar.getDrawable();
    Drawable drawable1 = drawable2;
    if (drawable2 != null) {
      drawable1 = DrawableCompat.wrap(drawable2).mutate();
      DrawableCompat.setTintList(drawable1, paramColorStateList);
    } 
    if (this.ar.getDrawable() != drawable1)
      this.ar.setImageDrawable(drawable1); 
  }
  
  public void setErrorIconTintMode(PorterDuff.Mode paramMode) {
    Drawable drawable2 = this.ar.getDrawable();
    Drawable drawable1 = drawable2;
    if (drawable2 != null) {
      drawable1 = DrawableCompat.wrap(drawable2).mutate();
      DrawableCompat.setTintMode(drawable1, paramMode);
    } 
    if (this.ar.getDrawable() != drawable1)
      this.ar.setImageDrawable(drawable1); 
  }
  
  public void setErrorTextAppearance(int paramInt) {
    this.j.b(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList) {
    this.j.a(paramColorStateList);
  }
  
  public void setHelperText(CharSequence paramCharSequence) {
    if (TextUtils.isEmpty(paramCharSequence)) {
      if (b()) {
        setHelperTextEnabled(false);
        return;
      } 
    } else {
      if (!b())
        setHelperTextEnabled(true); 
      this.j.a(paramCharSequence);
    } 
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList) {
    this.j.b(paramColorStateList);
  }
  
  public void setHelperTextEnabled(boolean paramBoolean) {
    this.j.b(paramBoolean);
  }
  
  public void setHelperTextTextAppearance(int paramInt) {
    this.j.c(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence) {
    if (this.A) {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    } 
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean) {
    this.aF = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean) {
    if (paramBoolean != this.A) {
      this.A = paramBoolean;
      if (!this.A) {
        this.C = false;
        if (!TextUtils.isEmpty(this.B) && TextUtils.isEmpty(this.a.getHint()))
          this.a.setHint(this.B); 
        setHintInternal((CharSequence)null);
      } else {
        CharSequence charSequence = this.a.getHint();
        if (!TextUtils.isEmpty(charSequence)) {
          if (TextUtils.isEmpty(this.B))
            setHint(charSequence); 
          this.a.setHint(null);
        } 
        this.C = true;
      } 
      if (this.a != null)
        l(); 
    } 
  }
  
  public void setHintTextAppearance(int paramInt) {
    this.c.c(paramInt);
    this.au = this.c.o();
    if (this.a != null) {
      a(false);
      l();
    } 
  }
  
  public void setHintTextColor(ColorStateList paramColorStateList) {
    if (this.au != paramColorStateList) {
      if (this.at == null)
        this.c.a(paramColorStateList); 
      this.au = paramColorStateList;
      if (this.a != null)
        a(false); 
    } 
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleContentDescription(int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getResources().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setPasswordVisibilityToggleContentDescription(charSequence);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence) {
    this.ag.setContentDescription(paramCharSequence);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleDrawable(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setPasswordVisibilityToggleDrawable(drawable);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable) {
    this.ag.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean) {
    if (paramBoolean && this.ae != 1) {
      setEndIconMode(1);
      return;
    } 
    if (!paramBoolean)
      setEndIconMode(0); 
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList) {
    this.ai = paramColorStateList;
    this.aj = true;
    J();
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode) {
    this.ak = paramMode;
    this.al = true;
    J();
  }
  
  public void setPlaceholderText(CharSequence paramCharSequence) {
    if (this.q && TextUtils.isEmpty(paramCharSequence)) {
      setPlaceholderTextEnabled(false);
    } else {
      if (!this.q)
        setPlaceholderTextEnabled(true); 
      this.p = paramCharSequence;
    } 
    n();
  }
  
  public void setPlaceholderTextAppearance(int paramInt) {
    this.t = paramInt;
    TextView textView = this.r;
    if (textView != null)
      TextViewCompat.setTextAppearance(textView, paramInt); 
  }
  
  public void setPlaceholderTextColor(ColorStateList paramColorStateList) {
    if (this.s != paramColorStateList) {
      this.s = paramColorStateList;
      TextView textView = this.r;
      if (textView != null && paramColorStateList != null)
        textView.setTextColor(paramColorStateList); 
    } 
  }
  
  public void setPrefixText(CharSequence paramCharSequence) {
    CharSequence charSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      charSequence = null;
    } else {
      charSequence = paramCharSequence;
    } 
    this.w = charSequence;
    this.x.setText(paramCharSequence);
    s();
  }
  
  public void setPrefixTextAppearance(int paramInt) {
    TextViewCompat.setTextAppearance(this.x, paramInt);
  }
  
  public void setPrefixTextColor(ColorStateList paramColorStateList) {
    this.x.setTextColor(paramColorStateList);
  }
  
  public void setStartIconCheckable(boolean paramBoolean) {
    this.S.setCheckable(paramBoolean);
  }
  
  public void setStartIconContentDescription(int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getResources().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setStartIconContentDescription(charSequence);
  }
  
  public void setStartIconContentDescription(CharSequence paramCharSequence) {
    if (getStartIconContentDescription() != paramCharSequence)
      this.S.setContentDescription(paramCharSequence); 
  }
  
  public void setStartIconDrawable(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setStartIconDrawable(drawable);
  }
  
  public void setStartIconDrawable(Drawable paramDrawable) {
    this.S.setImageDrawable(paramDrawable);
    if (paramDrawable != null) {
      setStartIconVisible(true);
      H();
      return;
    } 
    setStartIconVisible(false);
    setStartIconOnClickListener((View.OnClickListener)null);
    setStartIconOnLongClickListener((View.OnLongClickListener)null);
    setStartIconContentDescription((CharSequence)null);
  }
  
  public void setStartIconOnClickListener(View.OnClickListener paramOnClickListener) {
    a(this.S, paramOnClickListener, this.ac);
  }
  
  public void setStartIconOnLongClickListener(View.OnLongClickListener paramOnLongClickListener) {
    this.ac = paramOnLongClickListener;
    a(this.S, paramOnLongClickListener);
  }
  
  public void setStartIconTintList(ColorStateList paramColorStateList) {
    if (this.T != paramColorStateList) {
      this.T = paramColorStateList;
      this.U = true;
      H();
    } 
  }
  
  public void setStartIconTintMode(PorterDuff.Mode paramMode) {
    if (this.V != paramMode) {
      this.V = paramMode;
      this.W = true;
      H();
    } 
  }
  
  public void setStartIconVisible(boolean paramBoolean) {
    if (d() != paramBoolean) {
      byte b;
      CheckableImageButton checkableImageButton = this.S;
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      checkableImageButton.setVisibility(b);
      t();
      K();
    } 
  }
  
  public void setSuffixText(CharSequence paramCharSequence) {
    CharSequence charSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      charSequence = null;
    } else {
      charSequence = paramCharSequence;
    } 
    this.y = charSequence;
    this.z.setText(paramCharSequence);
    u();
  }
  
  public void setSuffixTextAppearance(int paramInt) {
    TextViewCompat.setTextAppearance(this.z, paramInt);
  }
  
  public void setSuffixTextColor(ColorStateList paramColorStateList) {
    this.z.setTextColor(paramColorStateList);
  }
  
  public void setTextInputAccessibilityDelegate(AccessibilityDelegate paramAccessibilityDelegate) {
    EditText editText = this.a;
    if (editText != null)
      ViewCompat.setAccessibilityDelegate((View)editText, paramAccessibilityDelegate); 
  }
  
  public void setTypeface(Typeface paramTypeface) {
    if (paramTypeface != this.R) {
      this.R = paramTypeface;
      this.c.c(paramTypeface);
      this.j.a(paramTypeface);
      TextView textView = this.m;
      if (textView != null)
        textView.setTypeface(paramTypeface); 
    } 
  }
  
  public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final TextInputLayout a;
    
    public AccessibilityDelegate(TextInputLayout param1TextInputLayout) {
      this.a = param1TextInputLayout;
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      boolean bool;
      CharSequence charSequence2;
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      EditText editText = this.a.getEditText();
      if (editText != null) {
        charSequence2 = (CharSequence)editText.getText();
      } else {
        charSequence2 = null;
      } 
      CharSequence charSequence1 = this.a.getHint();
      CharSequence charSequence5 = this.a.getHelperText();
      CharSequence charSequence3 = this.a.getError();
      int i = this.a.getCounterMaxLength();
      CharSequence charSequence4 = this.a.getCounterOverflowDescription();
      int k = TextUtils.isEmpty(charSequence2) ^ true;
      boolean bool1 = TextUtils.isEmpty(charSequence1);
      int m = TextUtils.isEmpty(charSequence5) ^ true;
      int j = TextUtils.isEmpty(charSequence3) ^ true;
      if (j != 0 || !TextUtils.isEmpty(charSequence4)) {
        bool = true;
      } else {
        bool = false;
      } 
      if ((bool1 ^ true) != 0) {
        charSequence1 = charSequence1.toString();
      } else {
        charSequence1 = "";
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)charSequence1);
      if ((j != 0 || m != 0) && !TextUtils.isEmpty(charSequence1)) {
        charSequence1 = ", ";
      } else {
        charSequence1 = "";
      } 
      stringBuilder.append((String)charSequence1);
      charSequence1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append((String)charSequence1);
      if (j != 0) {
        charSequence1 = charSequence3;
      } else if (m != 0) {
        charSequence1 = charSequence5;
      } else {
        charSequence1 = "";
      } 
      stringBuilder.append(charSequence1);
      charSequence5 = stringBuilder.toString();
      if (k != 0) {
        param1AccessibilityNodeInfoCompat.setText(charSequence2);
      } else if (!TextUtils.isEmpty(charSequence5)) {
        param1AccessibilityNodeInfoCompat.setText(charSequence5);
      } 
      if (!TextUtils.isEmpty(charSequence5)) {
        if (Build.VERSION.SDK_INT >= 26) {
          param1AccessibilityNodeInfoCompat.setHintText(charSequence5);
        } else {
          charSequence1 = charSequence5;
          if (k != 0) {
            charSequence1 = new StringBuilder();
            charSequence1.append(charSequence2);
            charSequence1.append(", ");
            charSequence1.append((String)charSequence5);
            charSequence1 = charSequence1.toString();
          } 
          param1AccessibilityNodeInfoCompat.setText(charSequence1);
        } 
        param1AccessibilityNodeInfoCompat.setShowingHintText(k ^ 0x1);
      } 
      if (charSequence2 == null || charSequence2.length() != i)
        i = -1; 
      param1AccessibilityNodeInfoCompat.setMaxTextLength(i);
      if (bool) {
        if (j != 0) {
          charSequence1 = charSequence3;
        } else {
          charSequence1 = charSequence4;
        } 
        param1AccessibilityNodeInfoCompat.setError(charSequence1);
      } 
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BoxBackgroundMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EndIconMode {}
  
  public static interface OnEditTextAttachedListener {
    void a(TextInputLayout param1TextInputLayout);
  }
  
  public static interface OnEndIconChangedListener {
    void a(TextInputLayout param1TextInputLayout, int param1Int);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public TextInputLayout.SavedState a(Parcel param2Parcel) {
          return new TextInputLayout.SavedState(param2Parcel, null);
        }
        
        public TextInputLayout.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new TextInputLayout.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public TextInputLayout.SavedState[] a(int param2Int) {
          return new TextInputLayout.SavedState[param2Int];
        }
      };
    
    CharSequence a;
    
    boolean b;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(param1Parcel);
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.b = bool;
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TextInputLayout.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" error=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public TextInputLayout.SavedState a(Parcel param1Parcel) {
      return new TextInputLayout.SavedState(param1Parcel, null);
    }
    
    public TextInputLayout.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new TextInputLayout.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public TextInputLayout.SavedState[] a(int param1Int) {
      return new TextInputLayout.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\TextInputLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */