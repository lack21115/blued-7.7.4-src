package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

class MaterialButtonHelper {
  private static final boolean a;
  
  private final MaterialButton b;
  
  private ShapeAppearanceModel c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private PorterDuff.Mode j;
  
  private ColorStateList k;
  
  private ColorStateList l;
  
  private ColorStateList m;
  
  private Drawable n;
  
  private boolean o = false;
  
  private boolean p = false;
  
  private boolean q = false;
  
  private boolean r;
  
  private LayerDrawable s;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
  
  MaterialButtonHelper(MaterialButton paramMaterialButton, ShapeAppearanceModel paramShapeAppearanceModel) {
    this.b = paramMaterialButton;
    this.c = paramShapeAppearanceModel;
  }
  
  private InsetDrawable a(Drawable paramDrawable) {
    return new InsetDrawable(paramDrawable, this.d, this.f, this.e, this.g);
  }
  
  private void b(ShapeAppearanceModel paramShapeAppearanceModel) {
    if (i() != null)
      i().setShapeAppearanceModel(paramShapeAppearanceModel); 
    if (o() != null)
      o().setShapeAppearanceModel(paramShapeAppearanceModel); 
    if (k() != null)
      k().setShapeAppearanceModel(paramShapeAppearanceModel); 
  }
  
  private MaterialShapeDrawable c(boolean paramBoolean) {
    LayerDrawable layerDrawable = this.s;
    return (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) ? (a ? (MaterialShapeDrawable)((LayerDrawable)((InsetDrawable)this.s.getDrawable(0)).getDrawable()).getDrawable(paramBoolean ^ true) : (MaterialShapeDrawable)this.s.getDrawable(paramBoolean ^ true)) : null;
  }
  
  private Drawable m() {
    boolean bool;
    MaterialShapeDrawable materialShapeDrawable1 = new MaterialShapeDrawable(this.c);
    materialShapeDrawable1.a(this.b.getContext());
    DrawableCompat.setTintList((Drawable)materialShapeDrawable1, this.k);
    PorterDuff.Mode mode = this.j;
    if (mode != null)
      DrawableCompat.setTintMode((Drawable)materialShapeDrawable1, mode); 
    materialShapeDrawable1.a(this.i, this.l);
    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.c);
    materialShapeDrawable2.setTint(0);
    float f = this.i;
    if (this.o) {
      bool = MaterialColors.a((View)this.b, R.attr.colorSurface);
    } else {
      bool = false;
    } 
    materialShapeDrawable2.a(f, bool);
    if (a) {
      this.n = (Drawable)new MaterialShapeDrawable(this.c);
      DrawableCompat.setTint(this.n, -1);
      this.s = (LayerDrawable)new RippleDrawable(RippleUtils.b(this.m), (Drawable)a((Drawable)new LayerDrawable(new Drawable[] { (Drawable)materialShapeDrawable2, (Drawable)materialShapeDrawable1 }, )), this.n);
      return (Drawable)this.s;
    } 
    this.n = (Drawable)new RippleDrawableCompat(this.c);
    DrawableCompat.setTintList(this.n, RippleUtils.b(this.m));
    this.s = new LayerDrawable(new Drawable[] { (Drawable)materialShapeDrawable2, (Drawable)materialShapeDrawable1, this.n });
    return (Drawable)a((Drawable)this.s);
  }
  
  private void n() {
    MaterialShapeDrawable materialShapeDrawable1 = i();
    MaterialShapeDrawable materialShapeDrawable2 = o();
    if (materialShapeDrawable1 != null) {
      materialShapeDrawable1.a(this.i, this.l);
      if (materialShapeDrawable2 != null) {
        boolean bool;
        float f = this.i;
        if (this.o) {
          bool = MaterialColors.a((View)this.b, R.attr.colorSurface);
        } else {
          bool = false;
        } 
        materialShapeDrawable2.a(f, bool);
      } 
    } 
  }
  
  private MaterialShapeDrawable o() {
    return c(true);
  }
  
  void a() {
    this.p = true;
    this.b.setSupportBackgroundTintList(this.k);
    this.b.setSupportBackgroundTintMode(this.j);
  }
  
  void a(int paramInt) {
    if (i() != null)
      i().setTint(paramInt); 
  }
  
  void a(int paramInt1, int paramInt2) {
    Drawable drawable = this.n;
    if (drawable != null)
      drawable.setBounds(this.d, this.f, paramInt2 - this.e, paramInt1 - this.g); 
  }
  
  void a(ColorStateList paramColorStateList) {
    if (this.k != paramColorStateList) {
      this.k = paramColorStateList;
      if (i() != null)
        DrawableCompat.setTintList((Drawable)i(), this.k); 
    } 
  }
  
  void a(TypedArray paramTypedArray) {
    this.d = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
    this.e = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
    this.f = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
    this.g = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
    if (paramTypedArray.hasValue(R.styleable.MaterialButton_cornerRadius)) {
      this.h = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
      a(this.c.a(this.h));
      this.q = true;
    } 
    this.i = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
    this.j = ViewUtils.a(paramTypedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.k = MaterialResources.a(this.b.getContext(), paramTypedArray, R.styleable.MaterialButton_backgroundTint);
    this.l = MaterialResources.a(this.b.getContext(), paramTypedArray, R.styleable.MaterialButton_strokeColor);
    this.m = MaterialResources.a(this.b.getContext(), paramTypedArray, R.styleable.MaterialButton_rippleColor);
    this.r = paramTypedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
    int i = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
    int j = ViewCompat.getPaddingStart((View)this.b);
    int k = this.b.getPaddingTop();
    int m = ViewCompat.getPaddingEnd((View)this.b);
    int n = this.b.getPaddingBottom();
    if (paramTypedArray.hasValue(R.styleable.MaterialButton_android_background)) {
      a();
    } else {
      this.b.setInternalBackground(m());
      MaterialShapeDrawable materialShapeDrawable = i();
      if (materialShapeDrawable != null)
        materialShapeDrawable.r(i); 
    } 
    ViewCompat.setPaddingRelative((View)this.b, j + this.d, k + this.f, m + this.e, n + this.g);
  }
  
  void a(PorterDuff.Mode paramMode) {
    if (this.j != paramMode) {
      this.j = paramMode;
      if (i() != null && this.j != null)
        DrawableCompat.setTintMode((Drawable)i(), this.j); 
    } 
  }
  
  void a(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.c = paramShapeAppearanceModel;
    b(paramShapeAppearanceModel);
  }
  
  void a(boolean paramBoolean) {
    this.o = paramBoolean;
    n();
  }
  
  void b(int paramInt) {
    if (this.i != paramInt) {
      this.i = paramInt;
      n();
    } 
  }
  
  void b(ColorStateList paramColorStateList) {
    if (this.m != paramColorStateList) {
      this.m = paramColorStateList;
      if (a && this.b.getBackground() instanceof RippleDrawable) {
        ((RippleDrawable)this.b.getBackground()).setColor(RippleUtils.b(paramColorStateList));
        return;
      } 
      if (!a && this.b.getBackground() instanceof RippleDrawableCompat)
        ((RippleDrawableCompat)this.b.getBackground()).setTintList(RippleUtils.b(paramColorStateList)); 
    } 
  }
  
  void b(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  boolean b() {
    return this.p;
  }
  
  ColorStateList c() {
    return this.k;
  }
  
  void c(int paramInt) {
    if (!this.q || this.h != paramInt) {
      this.h = paramInt;
      this.q = true;
      a(this.c.a(paramInt));
    } 
  }
  
  void c(ColorStateList paramColorStateList) {
    if (this.l != paramColorStateList) {
      this.l = paramColorStateList;
      n();
    } 
  }
  
  PorterDuff.Mode d() {
    return this.j;
  }
  
  ColorStateList e() {
    return this.m;
  }
  
  ColorStateList f() {
    return this.l;
  }
  
  int g() {
    return this.i;
  }
  
  int h() {
    return this.h;
  }
  
  MaterialShapeDrawable i() {
    return c(false);
  }
  
  boolean j() {
    return this.r;
  }
  
  public Shapeable k() {
    LayerDrawable layerDrawable = this.s;
    return (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) ? ((this.s.getNumberOfLayers() > 2) ? (Shapeable)this.s.getDrawable(2) : (Shapeable)this.s.getDrawable(1)) : null;
  }
  
  ShapeAppearanceModel l() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\button\MaterialButtonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */