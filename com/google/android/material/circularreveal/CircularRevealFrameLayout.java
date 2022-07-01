package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CircularRevealFrameLayout extends FrameLayout implements CircularRevealWidget {
  private final CircularRevealHelper a = new CircularRevealHelper(this);
  
  public CircularRevealFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void a() {
    this.a.a();
  }
  
  public void a(Canvas paramCanvas) {
    super.draw(paramCanvas);
  }
  
  public void an_() {
    this.a.b();
  }
  
  public boolean c() {
    return super.isOpaque();
  }
  
  public void draw(Canvas paramCanvas) {
    CircularRevealHelper circularRevealHelper = this.a;
    if (circularRevealHelper != null) {
      circularRevealHelper.a(paramCanvas);
      return;
    } 
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable() {
    return this.a.e();
  }
  
  public int getCircularRevealScrimColor() {
    return this.a.d();
  }
  
  public CircularRevealWidget.RevealInfo getRevealInfo() {
    return this.a.c();
  }
  
  public boolean isOpaque() {
    CircularRevealHelper circularRevealHelper = this.a;
    return (circularRevealHelper != null) ? circularRevealHelper.f() : super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable) {
    this.a.a(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt) {
    this.a.a(paramInt);
  }
  
  public void setRevealInfo(CircularRevealWidget.RevealInfo paramRevealInfo) {
    this.a.a(paramRevealInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\circularreveal\CircularRevealFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */