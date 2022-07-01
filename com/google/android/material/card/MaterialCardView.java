package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialCardView extends CardView implements Checkable, Shapeable {
  private static final int[] e = new int[] { 16842911 };
  
  private static final int[] f = new int[] { 16842912 };
  
  private static final int[] g = new int[] { R.attr.state_dragged };
  
  private static final int h = R.style.Widget_MaterialComponents_CardView;
  
  private final MaterialCardViewHelper i;
  
  private boolean j = true;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private OnCheckedChangeListener m;
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.materialCardViewStyle);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, h), paramAttributeSet, paramInt);
    TypedArray typedArray = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.MaterialCardView, paramInt, h, new int[0]);
    this.i = new MaterialCardViewHelper(this, paramAttributeSet, paramInt, h);
    this.i.b(super.getCardBackgroundColor());
    this.i.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
    this.i.a(typedArray);
    typedArray.recycle();
  }
  
  private void c() {
    if (Build.VERSION.SDK_INT > 26)
      this.i.t(); 
  }
  
  private RectF getBoundsAsRectF() {
    RectF rectF = new RectF();
    rectF.set(this.i.e().getBounds());
    return rectF;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.setContentPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean al_() {
    return this.l;
  }
  
  public boolean am_() {
    MaterialCardViewHelper materialCardViewHelper = this.i;
    return (materialCardViewHelper != null && materialCardViewHelper.p());
  }
  
  public ColorStateList getCardBackgroundColor() {
    return this.i.f();
  }
  
  public ColorStateList getCardForegroundColor() {
    return this.i.g();
  }
  
  float getCardViewRadius() {
    return a(this);
  }
  
  public Drawable getCheckedIcon() {
    return this.i.s();
  }
  
  public ColorStateList getCheckedIconTint() {
    return this.i.q();
  }
  
  public int getContentPaddingBottom() {
    return (this.i.h()).bottom;
  }
  
  public int getContentPaddingLeft() {
    return (this.i.h()).left;
  }
  
  public int getContentPaddingRight() {
    return (this.i.h()).right;
  }
  
  public int getContentPaddingTop() {
    return (this.i.h()).top;
  }
  
  public float getProgress() {
    return this.i.k();
  }
  
  public float getRadius() {
    return this.i.j();
  }
  
  public ColorStateList getRippleColor() {
    return this.i.r();
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel() {
    return this.i.u();
  }
  
  @Deprecated
  public int getStrokeColor() {
    return this.i.b();
  }
  
  public ColorStateList getStrokeColorStateList() {
    return this.i.c();
  }
  
  public int getStrokeWidth() {
    return this.i.d();
  }
  
  public boolean isChecked() {
    return this.k;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this, this.i.e());
  }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    if (am_())
      mergeDrawableStates(arrayOfInt, e); 
    if (isChecked())
      mergeDrawableStates(arrayOfInt, f); 
    if (al_())
      mergeDrawableStates(arrayOfInt, g); 
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityNodeInfo.setCheckable(am_());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    paramAccessibilityNodeInfo.setChecked(isChecked());
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.i.a(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setBackground(Drawable paramDrawable) {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    if (this.j) {
      if (!this.i.a()) {
        Log.i("MaterialCardView", "Setting a custom background is not supported.");
        this.i.a(true);
      } 
      super.setBackgroundDrawable(paramDrawable);
    } 
  }
  
  void setBackgroundInternal(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCardBackgroundColor(int paramInt) {
    this.i.b(ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList) {
    this.i.b(paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat) {
    super.setCardElevation(paramFloat);
    this.i.l();
  }
  
  public void setCardForegroundColor(ColorStateList paramColorStateList) {
    this.i.c(paramColorStateList);
  }
  
  public void setCheckable(boolean paramBoolean) {
    this.i.b(paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean) {
    if (this.k != paramBoolean)
      toggle(); 
  }
  
  public void setCheckedIcon(Drawable paramDrawable) {
    this.i.a(paramDrawable);
  }
  
  public void setCheckedIconResource(int paramInt) {
    this.i.a(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setCheckedIconTint(ColorStateList paramColorStateList) {
    this.i.e(paramColorStateList);
  }
  
  public void setClickable(boolean paramBoolean) {
    super.setClickable(paramBoolean);
    MaterialCardViewHelper materialCardViewHelper = this.i;
    if (materialCardViewHelper != null)
      materialCardViewHelper.i(); 
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.i.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDragged(boolean paramBoolean) {
    if (this.l != paramBoolean) {
      this.l = paramBoolean;
      refreshDrawableState();
      c();
      invalidate();
    } 
  }
  
  public void setMaxCardElevation(float paramFloat) {
    super.setMaxCardElevation(paramFloat);
    this.i.m();
  }
  
  public void setOnCheckedChangeListener(OnCheckedChangeListener paramOnCheckedChangeListener) {
    this.m = paramOnCheckedChangeListener;
  }
  
  public void setPreventCornerOverlap(boolean paramBoolean) {
    super.setPreventCornerOverlap(paramBoolean);
    this.i.m();
    this.i.o();
  }
  
  public void setProgress(float paramFloat) {
    this.i.b(paramFloat);
  }
  
  public void setRadius(float paramFloat) {
    super.setRadius(paramFloat);
    this.i.a(paramFloat);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList) {
    this.i.d(paramColorStateList);
  }
  
  public void setRippleColorResource(int paramInt) {
    this.i.d(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel) {
    if (Build.VERSION.SDK_INT >= 21)
      setClipToOutline(paramShapeAppearanceModel.a(getBoundsAsRectF())); 
    this.i.a(paramShapeAppearanceModel);
  }
  
  public void setStrokeColor(int paramInt) {
    this.i.a(ColorStateList.valueOf(paramInt));
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList) {
    this.i.a(paramColorStateList);
  }
  
  public void setStrokeWidth(int paramInt) {
    this.i.a(paramInt);
  }
  
  public void setUseCompatPadding(boolean paramBoolean) {
    super.setUseCompatPadding(paramBoolean);
    this.i.m();
    this.i.o();
  }
  
  public void toggle() {
    if (am_() && isEnabled()) {
      this.k ^= 0x1;
      refreshDrawableState();
      c();
      OnCheckedChangeListener onCheckedChangeListener = this.m;
      if (onCheckedChangeListener != null)
        onCheckedChangeListener.a(this, this.k); 
    } 
  }
  
  public static interface OnCheckedChangeListener {
    void a(MaterialCardView param1MaterialCardView, boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\card\MaterialCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */