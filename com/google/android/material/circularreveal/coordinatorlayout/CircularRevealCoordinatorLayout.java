package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;

public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements CircularRevealWidget {
  private final CircularRevealHelper f = new CircularRevealHelper((CircularRevealHelper.Delegate)this);
  
  public CircularRevealCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void a() {
    this.f.a();
  }
  
  public void a(Canvas paramCanvas) {
    super.draw(paramCanvas);
  }
  
  public void an_() {
    this.f.b();
  }
  
  public boolean c() {
    return super.isOpaque();
  }
  
  public void draw(Canvas paramCanvas) {
    CircularRevealHelper circularRevealHelper = this.f;
    if (circularRevealHelper != null) {
      circularRevealHelper.a(paramCanvas);
      return;
    } 
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable() {
    return this.f.e();
  }
  
  public int getCircularRevealScrimColor() {
    return this.f.d();
  }
  
  public CircularRevealWidget.RevealInfo getRevealInfo() {
    return this.f.c();
  }
  
  public boolean isOpaque() {
    CircularRevealHelper circularRevealHelper = this.f;
    return (circularRevealHelper != null) ? circularRevealHelper.f() : super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable) {
    this.f.a(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt) {
    this.f.a(paramInt);
  }
  
  public void setRevealInfo(CircularRevealWidget.RevealInfo paramRevealInfo) {
    this.f.a(paramRevealInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\circularreveal\coordinatorlayout\CircularRevealCoordinatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */