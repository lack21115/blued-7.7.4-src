package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class CutoutDrawable extends MaterialShapeDrawable {
  private final Paint a = new Paint(1);
  
  private final RectF b;
  
  private int c;
  
  CutoutDrawable() {
    this((ShapeAppearanceModel)null);
  }
  
  CutoutDrawable(ShapeAppearanceModel paramShapeAppearanceModel) {
    super(paramShapeAppearanceModel);
    c();
    this.b = new RectF();
  }
  
  private void a(Canvas paramCanvas) {
    View view;
    Drawable.Callback callback = getCallback();
    if (a(callback)) {
      view = (View)callback;
      if (view.getLayerType() != 2) {
        view.setLayerType(2, null);
        return;
      } 
    } else {
      b((Canvas)view);
    } 
  }
  
  private boolean a(Drawable.Callback paramCallback) {
    return paramCallback instanceof View;
  }
  
  private void b(Canvas paramCanvas) {
    if (Build.VERSION.SDK_INT >= 21) {
      this.c = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      return;
    } 
    this.c = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
  }
  
  private void c() {
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setColor(-1);
    this.a.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private void c(Canvas paramCanvas) {
    if (!a(getCallback()))
      paramCanvas.restoreToCount(this.c); 
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (paramFloat1 != this.b.left || paramFloat2 != this.b.top || paramFloat3 != this.b.right || paramFloat4 != this.b.bottom) {
      this.b.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    } 
  }
  
  void a(RectF paramRectF) {
    a(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
  
  boolean a() {
    return this.b.isEmpty() ^ true;
  }
  
  void b() {
    a(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void draw(Canvas paramCanvas) {
    a(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.drawRect(this.b, this.a);
    c(paramCanvas);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\CutoutDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */