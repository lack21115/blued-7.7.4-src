package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
  FloatingActionButtonImplLollipop(FloatingActionButton paramFloatingActionButton, ShadowViewDelegate paramShadowViewDelegate) {
    super(paramFloatingActionButton, paramShadowViewDelegate);
  }
  
  private Animator a(float paramFloat1, float paramFloat2) {
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.play((Animator)ObjectAnimator.ofFloat(this.s, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with((Animator)ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    animatorSet.setInterpolator(a);
    return (Animator)animatorSet;
  }
  
  public float a() {
    return this.s.getElevation();
  }
  
  BorderDrawable a(int paramInt, ColorStateList paramColorStateList) {
    Context context = this.s.getContext();
    BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.b));
    borderDrawable.a(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
    borderDrawable.a(paramInt);
    borderDrawable.a(paramColorStateList);
    return borderDrawable;
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (Build.VERSION.SDK_INT == 21) {
      this.s.refreshDrawableState();
    } else {
      StateListAnimator stateListAnimator = new StateListAnimator();
      stateListAnimator.addState(m, a(paramFloat1, paramFloat3));
      stateListAnimator.addState(n, a(paramFloat1, paramFloat2));
      stateListAnimator.addState(o, a(paramFloat1, paramFloat2));
      stateListAnimator.addState(p, a(paramFloat1, paramFloat2));
      AnimatorSet animatorSet = new AnimatorSet();
      ArrayList<ObjectAnimator> arrayList = new ArrayList();
      arrayList.add(ObjectAnimator.ofFloat(this.s, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24)
        arrayList.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[] { this.s.getTranslationZ() }).setDuration(100L)); 
      arrayList.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      animatorSet.playSequentially(arrayList.<Animator>toArray(new Animator[0]));
      animatorSet.setInterpolator(a);
      stateListAnimator.addState(q, (Animator)animatorSet);
      stateListAnimator.addState(r, a(0.0F, 0.0F));
      this.s.setStateListAnimator(stateListAnimator);
    } 
    if (p())
      o(); 
  }
  
  void a(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt) {
    MaterialShapeDrawable materialShapeDrawable;
    this.c = u();
    this.c.setTintList(paramColorStateList1);
    if (paramMode != null)
      this.c.setTintMode(paramMode); 
    this.c.a(this.s.getContext());
    if (paramInt > 0) {
      this.e = a(paramInt, paramColorStateList1);
      LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)Preconditions.checkNotNull(this.e), (Drawable)Preconditions.checkNotNull(this.c) });
    } else {
      this.e = null;
      materialShapeDrawable = this.c;
    } 
    this.d = (Drawable)new RippleDrawable(RippleUtils.b(paramColorStateList2), (Drawable)materialShapeDrawable, null);
    this.f = this.d;
  }
  
  void a(Rect paramRect) {
    if (this.t.a()) {
      super.a(paramRect);
      return;
    } 
    if (!h()) {
      int i = (this.l - this.s.getSizeDimension()) / 2;
      paramRect.set(i, i, i, i);
      return;
    } 
    paramRect.set(0, 0, 0, 0);
  }
  
  void a(int[] paramArrayOfint) {
    if (Build.VERSION.SDK_INT == 21) {
      if (this.s.isEnabled()) {
        this.s.setElevation(this.i);
        if (this.s.isPressed()) {
          this.s.setTranslationZ(this.k);
          return;
        } 
        if (this.s.isFocused() || this.s.isHovered()) {
          this.s.setTranslationZ(this.j);
          return;
        } 
        this.s.setTranslationZ(0.0F);
        return;
      } 
      this.s.setElevation(0.0F);
      this.s.setTranslationZ(0.0F);
    } 
  }
  
  void b(ColorStateList paramColorStateList) {
    if (this.d instanceof RippleDrawable) {
      ((RippleDrawable)this.d).setColor(RippleUtils.b(paramColorStateList));
      return;
    } 
    super.b(paramColorStateList);
  }
  
  void j() {}
  
  void n() {
    o();
  }
  
  boolean p() {
    return (this.t.a() || !h());
  }
  
  boolean s() {
    return false;
  }
  
  MaterialShapeDrawable u() {
    return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.b));
  }
  
  void x() {}
  
  static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
    AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel param1ShapeAppearanceModel) {
      super(param1ShapeAppearanceModel);
    }
    
    public boolean isStateful() {
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\FloatingActionButtonImplLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */