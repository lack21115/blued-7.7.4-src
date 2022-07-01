package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;

public class CircularRevealCardView extends MaterialCardView implements CircularRevealWidget {
  private final CircularRevealHelper e = new CircularRevealHelper((CircularRevealHelper.Delegate)this);
  
  public CircularRevealCardView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void a() {
    this.e.a();
  }
  
  public void a(Canvas paramCanvas) {
    super.draw(paramCanvas);
  }
  
  public void an_() {
    this.e.b();
  }
  
  public boolean c() {
    return super.isOpaque();
  }
  
  public void draw(Canvas paramCanvas) {
    CircularRevealHelper circularRevealHelper = this.e;
    if (circularRevealHelper != null) {
      circularRevealHelper.a(paramCanvas);
      return;
    } 
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable() {
    return this.e.e();
  }
  
  public int getCircularRevealScrimColor() {
    return this.e.d();
  }
  
  public CircularRevealWidget.RevealInfo getRevealInfo() {
    return this.e.c();
  }
  
  public boolean isOpaque() {
    CircularRevealHelper circularRevealHelper = this.e;
    return (circularRevealHelper != null) ? circularRevealHelper.f() : super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable) {
    this.e.a(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt) {
    this.e.a(paramInt);
  }
  
  public void setRevealInfo(CircularRevealWidget.RevealInfo paramRevealInfo) {
    this.e.a(paramRevealInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\circularreveal\cardview\CircularRevealCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */