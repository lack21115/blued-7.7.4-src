package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
  private static final int[] a = new int[] { 16842911 };
  
  private static final int[] b = new int[] { 16842912 };
  
  private static final int c = R.style.Widget_MaterialComponents_Button;
  
  private final MaterialButtonHelper d;
  
  private final LinkedHashSet<OnCheckedChangeListener> e = new LinkedHashSet<OnCheckedChangeListener>();
  
  private OnPressedChangeListener f;
  
  private PorterDuff.Mode g;
  
  private ColorStateList h;
  
  private Drawable i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private boolean m;
  
  private boolean n;
  
  private int o;
  
  public MaterialButton(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.materialButtonStyle);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, c), paramAttributeSet, paramInt);
    boolean bool = false;
    this.m = false;
    this.n = false;
    paramContext = getContext();
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.MaterialButton, paramInt, c, new int[0]);
    this.l = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
    this.g = ViewUtils.a(typedArray.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.h = MaterialResources.a(getContext(), typedArray, R.styleable.MaterialButton_iconTint);
    this.i = MaterialResources.b(getContext(), typedArray, R.styleable.MaterialButton_icon);
    this.o = typedArray.getInteger(R.styleable.MaterialButton_iconGravity, 1);
    this.j = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
    this.d = new MaterialButtonHelper(this, ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, c).a());
    this.d.a(typedArray);
    typedArray.recycle();
    setCompoundDrawablePadding(this.l);
    if (this.i != null)
      bool = true; 
    a(bool);
  }
  
  private void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Landroid/graphics/drawable/Drawable;
    //   4: astore #7
    //   6: iconst_0
    //   7: istore #4
    //   9: aload #7
    //   11: ifnull -> 122
    //   14: aload_0
    //   15: aload #7
    //   17: invokestatic wrap : (Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   20: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   23: putfield i : Landroid/graphics/drawable/Drawable;
    //   26: aload_0
    //   27: getfield i : Landroid/graphics/drawable/Drawable;
    //   30: aload_0
    //   31: getfield h : Landroid/content/res/ColorStateList;
    //   34: invokestatic setTintList : (Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   37: aload_0
    //   38: getfield g : Landroid/graphics/PorterDuff$Mode;
    //   41: astore #7
    //   43: aload #7
    //   45: ifnull -> 57
    //   48: aload_0
    //   49: getfield i : Landroid/graphics/drawable/Drawable;
    //   52: aload #7
    //   54: invokestatic setTintMode : (Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   57: aload_0
    //   58: getfield j : I
    //   61: istore_2
    //   62: iload_2
    //   63: ifeq -> 69
    //   66: goto -> 77
    //   69: aload_0
    //   70: getfield i : Landroid/graphics/drawable/Drawable;
    //   73: invokevirtual getIntrinsicWidth : ()I
    //   76: istore_2
    //   77: aload_0
    //   78: getfield j : I
    //   81: istore_3
    //   82: iload_3
    //   83: ifeq -> 89
    //   86: goto -> 97
    //   89: aload_0
    //   90: getfield i : Landroid/graphics/drawable/Drawable;
    //   93: invokevirtual getIntrinsicHeight : ()I
    //   96: istore_3
    //   97: aload_0
    //   98: getfield i : Landroid/graphics/drawable/Drawable;
    //   101: astore #7
    //   103: aload_0
    //   104: getfield k : I
    //   107: istore #5
    //   109: aload #7
    //   111: iload #5
    //   113: iconst_0
    //   114: iload_2
    //   115: iload #5
    //   117: iadd
    //   118: iload_3
    //   119: invokevirtual setBounds : (IIII)V
    //   122: aload_0
    //   123: getfield o : I
    //   126: istore_2
    //   127: iload_2
    //   128: iconst_1
    //   129: if_icmpeq -> 146
    //   132: iload_2
    //   133: iconst_2
    //   134: if_icmpne -> 140
    //   137: goto -> 146
    //   140: iconst_0
    //   141: istore #6
    //   143: goto -> 149
    //   146: iconst_1
    //   147: istore #6
    //   149: iload_1
    //   150: ifeq -> 160
    //   153: aload_0
    //   154: iload #6
    //   156: invokespecial b : (Z)V
    //   159: return
    //   160: aload_0
    //   161: invokestatic getCompoundDrawablesRelative : (Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;
    //   164: astore #8
    //   166: aload #8
    //   168: iconst_0
    //   169: aaload
    //   170: astore #7
    //   172: aload #8
    //   174: iconst_2
    //   175: aaload
    //   176: astore #8
    //   178: iload #6
    //   180: ifeq -> 192
    //   183: aload #7
    //   185: aload_0
    //   186: getfield i : Landroid/graphics/drawable/Drawable;
    //   189: if_acmpne -> 212
    //   192: iload #4
    //   194: istore_2
    //   195: iload #6
    //   197: ifne -> 214
    //   200: iload #4
    //   202: istore_2
    //   203: aload #8
    //   205: aload_0
    //   206: getfield i : Landroid/graphics/drawable/Drawable;
    //   209: if_acmpeq -> 214
    //   212: iconst_1
    //   213: istore_2
    //   214: iload_2
    //   215: ifeq -> 224
    //   218: aload_0
    //   219: iload #6
    //   221: invokespecial b : (Z)V
    //   224: return
  }
  
  private void b() {
    if (this.i != null) {
      if (getLayout() == null)
        return; 
      int i = this.o;
      boolean bool1 = true;
      if (i == 1 || i == 3) {
        this.k = 0;
        a(false);
        return;
      } 
      TextPaint textPaint = getPaint();
      String str2 = getText().toString();
      String str1 = str2;
      if (getTransformationMethod() != null)
        str1 = getTransformationMethod().getTransformation(str2, (View)this).toString(); 
      int k = Math.min((int)textPaint.measureText(str1), getLayout().getEllipsizedWidth());
      int j = this.j;
      i = j;
      if (j == 0)
        i = this.i.getIntrinsicWidth(); 
      j = (getMeasuredWidth() - k - ViewCompat.getPaddingEnd((View)this) - i - this.l - ViewCompat.getPaddingStart((View)this)) / 2;
      boolean bool2 = c();
      if (this.o != 4)
        bool1 = false; 
      i = j;
      if (bool2 != bool1)
        i = -j; 
      if (this.k != i) {
        this.k = i;
        a(false);
      } 
      return;
    } 
  }
  
  private void b(boolean paramBoolean) {
    if (paramBoolean) {
      TextViewCompat.setCompoundDrawablesRelative((TextView)this, this.i, null, null, null);
      return;
    } 
    TextViewCompat.setCompoundDrawablesRelative((TextView)this, null, null, this.i, null);
  }
  
  private boolean c() {
    return (ViewCompat.getLayoutDirection((View)this) == 1);
  }
  
  private boolean d() {
    MaterialButtonHelper materialButtonHelper = this.d;
    return (materialButtonHelper != null && !materialButtonHelper.b());
  }
  
  private String getA11yClassName() {
    Class<Button> clazz;
    if (a()) {
      Class<CompoundButton> clazz1 = CompoundButton.class;
    } else {
      clazz = Button.class;
    } 
    return clazz.getName();
  }
  
  public void a(OnCheckedChangeListener paramOnCheckedChangeListener) {
    this.e.add(paramOnCheckedChangeListener);
  }
  
  public boolean a() {
    MaterialButtonHelper materialButtonHelper = this.d;
    return (materialButtonHelper != null && materialButtonHelper.j());
  }
  
  public void b(OnCheckedChangeListener paramOnCheckedChangeListener) {
    this.e.remove(paramOnCheckedChangeListener);
  }
  
  public ColorStateList getBackgroundTintList() {
    return getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode() {
    return getSupportBackgroundTintMode();
  }
  
  public int getCornerRadius() {
    return d() ? this.d.h() : 0;
  }
  
  public Drawable getIcon() {
    return this.i;
  }
  
  public int getIconGravity() {
    return this.o;
  }
  
  public int getIconPadding() {
    return this.l;
  }
  
  public int getIconSize() {
    return this.j;
  }
  
  public ColorStateList getIconTint() {
    return this.h;
  }
  
  public PorterDuff.Mode getIconTintMode() {
    return this.g;
  }
  
  public ColorStateList getRippleColor() {
    return d() ? this.d.e() : null;
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel() {
    if (d())
      return this.d.l(); 
    throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
  }
  
  public ColorStateList getStrokeColor() {
    return d() ? this.d.f() : null;
  }
  
  public int getStrokeWidth() {
    return d() ? this.d.g() : 0;
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    return d() ? this.d.c() : super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    return d() ? this.d.d() : super.getSupportBackgroundTintMode();
  }
  
  public boolean isChecked() {
    return this.m;
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (d())
      MaterialShapeUtils.a((View)this, this.d.i()); 
  }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (a())
      mergeDrawableStates(arrayOfInt, a); 
    if (isChecked())
      mergeDrawableStates(arrayOfInt, b); 
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(getA11yClassName());
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(getA11yClassName());
    paramAccessibilityNodeInfo.setCheckable(a());
    paramAccessibilityNodeInfo.setChecked(isChecked());
    paramAccessibilityNodeInfo.setClickable(isClickable());
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21) {
      MaterialButtonHelper materialButtonHelper = this.d;
      if (materialButtonHelper != null)
        materialButtonHelper.a(paramInt4 - paramInt2, paramInt3 - paramInt1); 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    b();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    setChecked(savedState.a);
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.m;
    return (Parcelable)savedState;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public boolean performClick() {
    toggle();
    return super.performClick();
  }
  
  public void setBackground(Drawable paramDrawable) {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt) {
    if (d()) {
      this.d.a(paramInt);
      return;
    } 
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    if (d()) {
      if (paramDrawable != getBackground()) {
        Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
        this.d.a();
        super.setBackgroundDrawable(paramDrawable);
        return;
      } 
      getBackground().setState(paramDrawable.getState());
      return;
    } 
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setBackgroundDrawable(drawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList) {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode) {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCheckable(boolean paramBoolean) {
    if (d())
      this.d.b(paramBoolean); 
  }
  
  public void setChecked(boolean paramBoolean) {
    if (a() && isEnabled() && this.m != paramBoolean) {
      this.m = paramBoolean;
      refreshDrawableState();
      if (this.n)
        return; 
      this.n = true;
      Iterator<OnCheckedChangeListener> iterator = this.e.iterator();
      while (iterator.hasNext())
        ((OnCheckedChangeListener)iterator.next()).a(this, this.m); 
      this.n = false;
    } 
  }
  
  public void setCornerRadius(int paramInt) {
    if (d())
      this.d.c(paramInt); 
  }
  
  public void setCornerRadiusResource(int paramInt) {
    if (d())
      setCornerRadius(getResources().getDimensionPixelSize(paramInt)); 
  }
  
  public void setElevation(float paramFloat) {
    super.setElevation(paramFloat);
    if (d())
      this.d.i().r(paramFloat); 
  }
  
  public void setIcon(Drawable paramDrawable) {
    if (this.i != paramDrawable) {
      this.i = paramDrawable;
      a(true);
    } 
  }
  
  public void setIconGravity(int paramInt) {
    if (this.o != paramInt) {
      this.o = paramInt;
      b();
    } 
  }
  
  public void setIconPadding(int paramInt) {
    if (this.l != paramInt) {
      this.l = paramInt;
      setCompoundDrawablePadding(paramInt);
    } 
  }
  
  public void setIconResource(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setIcon(drawable);
  }
  
  public void setIconSize(int paramInt) {
    if (paramInt >= 0) {
      if (this.j != paramInt) {
        this.j = paramInt;
        a(true);
      } 
      return;
    } 
    throw new IllegalArgumentException("iconSize cannot be less than 0");
  }
  
  public void setIconTint(ColorStateList paramColorStateList) {
    if (this.h != paramColorStateList) {
      this.h = paramColorStateList;
      a(false);
    } 
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode) {
    if (this.g != paramMode) {
      this.g = paramMode;
      a(false);
    } 
  }
  
  public void setIconTintResource(int paramInt) {
    setIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  void setInternalBackground(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  void setOnPressedChangeListenerInternal(OnPressedChangeListener paramOnPressedChangeListener) {
    this.f = paramOnPressedChangeListener;
  }
  
  public void setPressed(boolean paramBoolean) {
    OnPressedChangeListener onPressedChangeListener = this.f;
    if (onPressedChangeListener != null)
      onPressedChangeListener.a(this, paramBoolean); 
    super.setPressed(paramBoolean);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList) {
    if (d())
      this.d.b(paramColorStateList); 
  }
  
  public void setRippleColorResource(int paramInt) {
    if (d())
      setRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt)); 
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel) {
    if (d()) {
      this.d.a(paramShapeAppearanceModel);
      return;
    } 
    throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
  }
  
  void setShouldDrawSurfaceColorStroke(boolean paramBoolean) {
    if (d())
      this.d.a(paramBoolean); 
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList) {
    if (d())
      this.d.c(paramColorStateList); 
  }
  
  public void setStrokeColorResource(int paramInt) {
    if (d())
      setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt)); 
  }
  
  public void setStrokeWidth(int paramInt) {
    if (d())
      this.d.b(paramInt); 
  }
  
  public void setStrokeWidthResource(int paramInt) {
    if (d())
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt)); 
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    if (d()) {
      this.d.a(paramColorStateList);
      return;
    } 
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (d()) {
      this.d.a(paramMode);
      return;
    } 
    super.setSupportBackgroundTintMode(paramMode);
  }
  
  public void toggle() {
    setChecked(this.m ^ true);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IconGravity {}
  
  public static interface OnCheckedChangeListener {
    void a(MaterialButton param1MaterialButton, boolean param1Boolean);
  }
  
  static interface OnPressedChangeListener {
    void a(MaterialButton param1MaterialButton, boolean param1Boolean);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public MaterialButton.SavedState a(Parcel param2Parcel) {
          return new MaterialButton.SavedState(param2Parcel, null);
        }
        
        public MaterialButton.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new MaterialButton.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public MaterialButton.SavedState[] a(int param2Int) {
          return new MaterialButton.SavedState[param2Int];
        }
      };
    
    boolean a;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      if (param1ClassLoader == null)
        getClass().getClassLoader(); 
      a(param1Parcel);
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    private void a(Parcel param1Parcel) {
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.a = bool;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public MaterialButton.SavedState a(Parcel param1Parcel) {
      return new MaterialButton.SavedState(param1Parcel, null);
    }
    
    public MaterialButton.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new MaterialButton.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public MaterialButton.SavedState[] a(int param1Int) {
      return new MaterialButton.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\button\MaterialButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */