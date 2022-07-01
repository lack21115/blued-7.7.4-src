package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable extends Drawable {
  private final Matrix a;
  
  private final RectF b;
  
  private final RectF c;
  
  private Drawable d;
  
  private State e;
  
  private boolean f;
  
  public FixedSizeDrawable(Drawable paramDrawable, int paramInt1, int paramInt2) {
    this(new State(paramDrawable.getConstantState(), paramInt1, paramInt2), paramDrawable);
  }
  
  FixedSizeDrawable(State paramState, Drawable paramDrawable) {
    this.e = (State)Preconditions.a(paramState);
    this.d = (Drawable)Preconditions.a(paramDrawable);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    this.a = new Matrix();
    this.b = new RectF(0.0F, 0.0F, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    this.c = new RectF();
  }
  
  private void a() {
    this.a.setRectToRect(this.b, this.c, Matrix.ScaleToFit.CENTER);
  }
  
  public void clearColorFilter() {
    this.d.clearColorFilter();
  }
  
  public void draw(Canvas paramCanvas) {
    paramCanvas.save();
    paramCanvas.concat(this.a);
    this.d.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getAlpha() {
    return this.d.getAlpha();
  }
  
  public Drawable.Callback getCallback() {
    return this.d.getCallback();
  }
  
  public int getChangingConfigurations() {
    return this.d.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState() {
    return this.e;
  }
  
  public Drawable getCurrent() {
    return this.d.getCurrent();
  }
  
  public int getIntrinsicHeight() {
    return this.e.b;
  }
  
  public int getIntrinsicWidth() {
    return this.e.a;
  }
  
  public int getMinimumHeight() {
    return this.d.getMinimumHeight();
  }
  
  public int getMinimumWidth() {
    return this.d.getMinimumWidth();
  }
  
  public int getOpacity() {
    return this.d.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect) {
    return this.d.getPadding(paramRect);
  }
  
  public void invalidateSelf() {
    super.invalidateSelf();
    this.d.invalidateSelf();
  }
  
  public Drawable mutate() {
    if (!this.f && super.mutate() == this) {
      this.d = this.d.mutate();
      this.e = new State(this.e);
      this.f = true;
    } 
    return this;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong) {
    super.scheduleSelf(paramRunnable, paramLong);
    this.d.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt) {
    this.d.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.set(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void setBounds(Rect paramRect) {
    super.setBounds(paramRect);
    this.c.set(paramRect);
    a();
  }
  
  public void setChangingConfigurations(int paramInt) {
    this.d.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode) {
    this.d.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.d.setColorFilter(paramColorFilter);
  }
  
  @Deprecated
  public void setDither(boolean paramBoolean) {
    this.d.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean) {
    this.d.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    return this.d.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable) {
    super.unscheduleSelf(paramRunnable);
    this.d.unscheduleSelf(paramRunnable);
  }
  
  static final class State extends Drawable.ConstantState {
    final int a;
    
    final int b;
    
    private final Drawable.ConstantState c;
    
    State(Drawable.ConstantState param1ConstantState, int param1Int1, int param1Int2) {
      this.c = param1ConstantState;
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    State(State param1State) {
      this(param1State.c, param1State.a, param1State.b);
    }
    
    public int getChangingConfigurations() {
      return 0;
    }
    
    public Drawable newDrawable() {
      return new FixedSizeDrawable(this, this.c.newDrawable());
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      return new FixedSizeDrawable(this, this.c.newDrawable(param1Resources));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\FixedSizeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */