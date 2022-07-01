package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class MaterialCardViewHelper {
  private static final int[] a = new int[] { 16842912 };
  
  private static final double b = Math.cos(Math.toRadians(45.0D));
  
  private final MaterialCardView c;
  
  private final Rect d = new Rect();
  
  private final MaterialShapeDrawable e;
  
  private final MaterialShapeDrawable f;
  
  private final int g;
  
  private final int h;
  
  private int i;
  
  private Drawable j;
  
  private Drawable k;
  
  private ColorStateList l;
  
  private ColorStateList m;
  
  private ShapeAppearanceModel n;
  
  private ColorStateList o;
  
  private Drawable p;
  
  private LayerDrawable q;
  
  private MaterialShapeDrawable r;
  
  private MaterialShapeDrawable s;
  
  private boolean t = false;
  
  private boolean u;
  
  public MaterialCardViewHelper(MaterialCardView paramMaterialCardView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    this.c = paramMaterialCardView;
    this.e = new MaterialShapeDrawable(paramMaterialCardView.getContext(), paramAttributeSet, paramInt1, paramInt2);
    this.e.a(paramMaterialCardView.getContext());
    this.e.G(-12303292);
    ShapeAppearanceModel.Builder builder = this.e.getShapeAppearanceModel().n();
    TypedArray typedArray = paramMaterialCardView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CardView, paramInt1, R.style.CardView);
    if (typedArray.hasValue(R.styleable.CardView_cardCornerRadius))
      builder.a(typedArray.getDimension(R.styleable.CardView_cardCornerRadius, 0.0F)); 
    this.f = new MaterialShapeDrawable();
    a(builder.a());
    Resources resources = paramMaterialCardView.getResources();
    this.g = resources.getDimensionPixelSize(R.dimen.mtrl_card_checked_icon_margin);
    this.h = resources.getDimensionPixelSize(R.dimen.mtrl_card_checked_icon_size);
    typedArray.recycle();
  }
  
  private boolean A() {
    return (this.c.getPreventCornerOverlap() && x() && this.c.getUseCompatPadding());
  }
  
  private float B() {
    return Math.max(Math.max(a(this.n.b(), this.e.Z()), a(this.n.c(), this.e.aa())), Math.max(a(this.n.d(), this.e.ac()), a(this.n.e(), this.e.ab())));
  }
  
  private Drawable C() {
    if (this.p == null)
      this.p = D(); 
    if (this.q == null) {
      Drawable drawable = G();
      this.q = new LayerDrawable(new Drawable[] { this.p, (Drawable)this.f, drawable });
      this.q.setId(2, R.id.mtrl_card_checked_layer_id);
    } 
    return (Drawable)this.q;
  }
  
  private Drawable D() {
    if (RippleUtils.a) {
      this.s = H();
      return (Drawable)new RippleDrawable(this.l, null, (Drawable)this.s);
    } 
    return E();
  }
  
  private Drawable E() {
    StateListDrawable stateListDrawable = new StateListDrawable();
    this.r = H();
    this.r.g(this.l);
    MaterialShapeDrawable materialShapeDrawable = this.r;
    stateListDrawable.addState(new int[] { 16842919 }, (Drawable)materialShapeDrawable);
    return (Drawable)stateListDrawable;
  }
  
  private void F() {
    if (RippleUtils.a) {
      Drawable drawable = this.p;
      if (drawable != null) {
        ((RippleDrawable)drawable).setColor(this.l);
        return;
      } 
    } 
    MaterialShapeDrawable materialShapeDrawable = this.r;
    if (materialShapeDrawable != null)
      materialShapeDrawable.g(this.l); 
  }
  
  private Drawable G() {
    StateListDrawable stateListDrawable = new StateListDrawable();
    Drawable drawable = this.k;
    if (drawable != null)
      stateListDrawable.addState(a, drawable); 
    return (Drawable)stateListDrawable;
  }
  
  private MaterialShapeDrawable H() {
    return new MaterialShapeDrawable(this.n);
  }
  
  private float a(CornerTreatment paramCornerTreatment, float paramFloat) {
    return (paramCornerTreatment instanceof com.google.android.material.shape.RoundedCornerTreatment) ? (float)((1.0D - b) * paramFloat) : ((paramCornerTreatment instanceof com.google.android.material.shape.CutCornerTreatment) ? (paramFloat / 2.0F) : 0.0F);
  }
  
  private void b(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT >= 23 && this.c.getForeground() instanceof InsetDrawable) {
      ((InsetDrawable)this.c.getForeground()).setDrawable(paramDrawable);
      return;
    } 
    this.c.setForeground(c(paramDrawable));
  }
  
  private Drawable c(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT < 21) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i || this.c.getUseCompatPadding()) {
      int j = (int)Math.ceil(v());
      i = (int)Math.ceil(w());
      return (Drawable)new InsetDrawable(this, paramDrawable, i, j, i, j) {
          public int getMinimumHeight() {
            return -1;
          }
          
          public int getMinimumWidth() {
            return -1;
          }
          
          public boolean getPadding(Rect param1Rect) {
            return false;
          }
        };
    } 
    int i = 0;
    boolean bool = false;
    return (Drawable)new InsetDrawable(this, paramDrawable, i, bool, i, bool) {
        public int getMinimumHeight() {
          return -1;
        }
        
        public int getMinimumWidth() {
          return -1;
        }
        
        public boolean getPadding(Rect param1Rect) {
          return false;
        }
      };
  }
  
  private float v() {
    float f1;
    float f2 = this.c.getMaxCardElevation();
    if (A()) {
      f1 = B();
    } else {
      f1 = 0.0F;
    } 
    return f2 * 1.5F + f1;
  }
  
  private float w() {
    float f1;
    float f2 = this.c.getMaxCardElevation();
    if (A()) {
      f1 = B();
    } else {
      f1 = 0.0F;
    } 
    return f2 + f1;
  }
  
  private boolean x() {
    return (Build.VERSION.SDK_INT >= 21 && this.e.ad());
  }
  
  private float y() {
    return (this.c.getPreventCornerOverlap() && (Build.VERSION.SDK_INT < 21 || this.c.getUseCompatPadding())) ? (float)((1.0D - b) * this.c.getCardViewRadius()) : 0.0F;
  }
  
  private boolean z() {
    return (this.c.getPreventCornerOverlap() && !x());
  }
  
  void a(float paramFloat) {
    a(this.n.a(paramFloat));
    this.j.invalidateSelf();
    if (A() || z())
      o(); 
    if (A())
      m(); 
  }
  
  void a(int paramInt) {
    if (paramInt == this.i)
      return; 
    this.i = paramInt;
    n();
  }
  
  void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield q : Landroid/graphics/drawable/LayerDrawable;
    //   4: ifnull -> 142
    //   7: aload_0
    //   8: getfield g : I
    //   11: istore #4
    //   13: aload_0
    //   14: getfield h : I
    //   17: istore #5
    //   19: iload_1
    //   20: iload #4
    //   22: isub
    //   23: iload #5
    //   25: isub
    //   26: istore_3
    //   27: iload_2
    //   28: iload #4
    //   30: isub
    //   31: iload #5
    //   33: isub
    //   34: istore #4
    //   36: getstatic android/os/Build$VERSION.SDK_INT : I
    //   39: bipush #21
    //   41: if_icmpge -> 49
    //   44: iconst_1
    //   45: istore_1
    //   46: goto -> 51
    //   49: iconst_0
    //   50: istore_1
    //   51: iload_1
    //   52: ifne -> 70
    //   55: iload_3
    //   56: istore_1
    //   57: iload #4
    //   59: istore_2
    //   60: aload_0
    //   61: getfield c : Lcom/google/android/material/card/MaterialCardView;
    //   64: invokevirtual getUseCompatPadding : ()Z
    //   67: ifeq -> 99
    //   70: iload #4
    //   72: aload_0
    //   73: invokespecial v : ()F
    //   76: fconst_2
    //   77: fmul
    //   78: f2d
    //   79: invokestatic ceil : (D)D
    //   82: d2i
    //   83: isub
    //   84: istore_2
    //   85: iload_3
    //   86: aload_0
    //   87: invokespecial w : ()F
    //   90: fconst_2
    //   91: fmul
    //   92: f2d
    //   93: invokestatic ceil : (D)D
    //   96: d2i
    //   97: isub
    //   98: istore_1
    //   99: aload_0
    //   100: getfield g : I
    //   103: istore_3
    //   104: aload_0
    //   105: getfield c : Lcom/google/android/material/card/MaterialCardView;
    //   108: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   111: iconst_1
    //   112: if_icmpne -> 121
    //   115: iload_1
    //   116: istore #4
    //   118: goto -> 126
    //   121: iload_3
    //   122: istore #4
    //   124: iload_1
    //   125: istore_3
    //   126: aload_0
    //   127: getfield q : Landroid/graphics/drawable/LayerDrawable;
    //   130: iconst_2
    //   131: iload_3
    //   132: aload_0
    //   133: getfield g : I
    //   136: iload #4
    //   138: iload_2
    //   139: invokevirtual setLayerInset : (IIIII)V
    //   142: return
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.d.set(paramInt1, paramInt2, paramInt3, paramInt4);
    o();
  }
  
  void a(ColorStateList paramColorStateList) {
    if (this.o == paramColorStateList)
      return; 
    this.o = paramColorStateList;
    n();
  }
  
  void a(TypedArray paramTypedArray) {
    MaterialShapeDrawable materialShapeDrawable;
    this.o = MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.MaterialCardView_strokeColor);
    if (this.o == null)
      this.o = ColorStateList.valueOf(-1); 
    this.i = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
    this.u = paramTypedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
    this.c.setLongClickable(this.u);
    this.m = MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.MaterialCardView_checkedIconTint);
    a(MaterialResources.b(this.c.getContext(), paramTypedArray, R.styleable.MaterialCardView_checkedIcon));
    this.l = MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.MaterialCardView_rippleColor);
    if (this.l == null)
      this.l = ColorStateList.valueOf(MaterialColors.a((View)this.c, R.attr.colorControlHighlight)); 
    c(MaterialResources.a(this.c.getContext(), paramTypedArray, R.styleable.MaterialCardView_cardForegroundColor));
    F();
    l();
    n();
    this.c.setBackgroundInternal(c((Drawable)this.e));
    if (this.c.isClickable()) {
      Drawable drawable = C();
    } else {
      materialShapeDrawable = this.f;
    } 
    this.j = (Drawable)materialShapeDrawable;
    this.c.setForeground(c(this.j));
  }
  
  void a(Drawable paramDrawable) {
    this.k = paramDrawable;
    if (paramDrawable != null) {
      this.k = DrawableCompat.wrap(paramDrawable.mutate());
      DrawableCompat.setTintList(this.k, this.m);
    } 
    if (this.q != null) {
      paramDrawable = G();
      this.q.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, paramDrawable);
    } 
  }
  
  void a(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.n = paramShapeAppearanceModel;
    this.e.setShapeAppearanceModel(paramShapeAppearanceModel);
    MaterialShapeDrawable materialShapeDrawable = this.e;
    materialShapeDrawable.g(materialShapeDrawable.ad() ^ true);
    materialShapeDrawable = this.f;
    if (materialShapeDrawable != null)
      materialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel); 
    materialShapeDrawable = this.s;
    if (materialShapeDrawable != null)
      materialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel); 
    materialShapeDrawable = this.r;
    if (materialShapeDrawable != null)
      materialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel); 
  }
  
  void a(boolean paramBoolean) {
    this.t = paramBoolean;
  }
  
  boolean a() {
    return this.t;
  }
  
  int b() {
    ColorStateList colorStateList = this.o;
    return (colorStateList == null) ? -1 : colorStateList.getDefaultColor();
  }
  
  void b(float paramFloat) {
    this.e.p(paramFloat);
    MaterialShapeDrawable materialShapeDrawable = this.f;
    if (materialShapeDrawable != null)
      materialShapeDrawable.p(paramFloat); 
    materialShapeDrawable = this.s;
    if (materialShapeDrawable != null)
      materialShapeDrawable.p(paramFloat); 
  }
  
  void b(ColorStateList paramColorStateList) {
    this.e.g(paramColorStateList);
  }
  
  void b(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  ColorStateList c() {
    return this.o;
  }
  
  void c(ColorStateList paramColorStateList) {
    MaterialShapeDrawable materialShapeDrawable = this.f;
    ColorStateList colorStateList = paramColorStateList;
    if (paramColorStateList == null)
      colorStateList = ColorStateList.valueOf(0); 
    materialShapeDrawable.g(colorStateList);
  }
  
  int d() {
    return this.i;
  }
  
  void d(ColorStateList paramColorStateList) {
    this.l = paramColorStateList;
    F();
  }
  
  MaterialShapeDrawable e() {
    return this.e;
  }
  
  void e(ColorStateList paramColorStateList) {
    this.m = paramColorStateList;
    Drawable drawable = this.k;
    if (drawable != null)
      DrawableCompat.setTintList(drawable, paramColorStateList); 
  }
  
  ColorStateList f() {
    return this.e.M();
  }
  
  ColorStateList g() {
    return this.f.M();
  }
  
  Rect h() {
    return this.d;
  }
  
  void i() {
    MaterialShapeDrawable materialShapeDrawable;
    Drawable drawable2 = this.j;
    if (this.c.isClickable()) {
      Drawable drawable = C();
    } else {
      materialShapeDrawable = this.f;
    } 
    this.j = (Drawable)materialShapeDrawable;
    Drawable drawable1 = this.j;
    if (drawable2 != drawable1)
      b(drawable1); 
  }
  
  float j() {
    return this.e.Z();
  }
  
  float k() {
    return this.e.Q();
  }
  
  void l() {
    this.e.r(this.c.getCardElevation());
  }
  
  void m() {
    if (!a())
      this.c.setBackgroundInternal(c((Drawable)this.e)); 
    this.c.setForeground(c(this.j));
  }
  
  void n() {
    this.f.a(this.i, this.o);
  }
  
  void o() {
    float f;
    if (z() || A()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      f = B();
    } else {
      f = 0.0F;
    } 
    int i = (int)(f - y());
    this.c.a(this.d.left + i, this.d.top + i, this.d.right + i, this.d.bottom + i);
  }
  
  boolean p() {
    return this.u;
  }
  
  ColorStateList q() {
    return this.m;
  }
  
  ColorStateList r() {
    return this.l;
  }
  
  Drawable s() {
    return this.k;
  }
  
  void t() {
    Drawable drawable = this.p;
    if (drawable != null) {
      Rect rect = drawable.getBounds();
      int i = rect.bottom;
      this.p.setBounds(rect.left, rect.top, rect.right, i - 1);
      this.p.setBounds(rect.left, rect.top, rect.right, i);
    } 
  }
  
  ShapeAppearanceModel u() {
    return this.n;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\card\MaterialCardViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */