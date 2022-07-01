package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

public class RippleDrawableCompat extends Drawable implements TintAwareDrawable, Shapeable {
  private RippleDrawableCompatState a;
  
  private RippleDrawableCompat(RippleDrawableCompatState paramRippleDrawableCompatState) {
    this.a = paramRippleDrawableCompatState;
  }
  
  public RippleDrawableCompat(ShapeAppearanceModel paramShapeAppearanceModel) {
    this(new RippleDrawableCompatState(new MaterialShapeDrawable(paramShapeAppearanceModel)));
  }
  
  public RippleDrawableCompat a() {
    this.a = new RippleDrawableCompatState(this.a);
    return this;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.a.b)
      this.a.a.draw(paramCanvas); 
  }
  
  public Drawable.ConstantState getConstantState() {
    return this.a;
  }
  
  public int getOpacity() {
    return this.a.a.getOpacity();
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel() {
    return this.a.a.getShapeAppearanceModel();
  }
  
  public boolean isStateful() {
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    this.a.a.setBounds(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    boolean bool1 = super.onStateChange(paramArrayOfint);
    if (this.a.a.setState(paramArrayOfint))
      bool1 = true; 
    boolean bool2 = RippleUtils.a(paramArrayOfint);
    if (this.a.b != bool2) {
      this.a.b = bool2;
      bool1 = true;
    } 
    return bool1;
  }
  
  public void setAlpha(int paramInt) {
    this.a.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.a.a.setColorFilter(paramColorFilter);
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.a.a.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setTint(int paramInt) {
    this.a.a.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    this.a.a.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    this.a.a.setTintMode(paramMode);
  }
  
  static final class RippleDrawableCompatState extends Drawable.ConstantState {
    MaterialShapeDrawable a;
    
    boolean b;
    
    public RippleDrawableCompatState(RippleDrawableCompatState param1RippleDrawableCompatState) {
      this.a = (MaterialShapeDrawable)param1RippleDrawableCompatState.a.getConstantState().newDrawable();
      this.b = param1RippleDrawableCompatState.b;
    }
    
    public RippleDrawableCompatState(MaterialShapeDrawable param1MaterialShapeDrawable) {
      this.a = param1MaterialShapeDrawable;
      this.b = false;
    }
    
    public RippleDrawableCompat a() {
      return new RippleDrawableCompat(new RippleDrawableCompatState(this));
    }
    
    public int getChangingConfigurations() {
      return 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\ripple\RippleDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */