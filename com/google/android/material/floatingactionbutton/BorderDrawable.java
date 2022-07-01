package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class BorderDrawable extends Drawable {
  float a;
  
  private final ShapeAppearancePathProvider b = new ShapeAppearancePathProvider();
  
  private final Paint c;
  
  private final Path d = new Path();
  
  private final Rect e = new Rect();
  
  private final RectF f = new RectF();
  
  private final RectF g = new RectF();
  
  private final BorderState h = new BorderState();
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private boolean n = true;
  
  private ShapeAppearanceModel o;
  
  private ColorStateList p;
  
  BorderDrawable(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.o = paramShapeAppearanceModel;
    this.c = new Paint(1);
    this.c.setStyle(Paint.Style.STROKE);
  }
  
  private Shader b() {
    Rect rect = this.e;
    copyBounds(rect);
    float f1 = this.a / rect.height();
    int i = ColorUtils.compositeColors(this.i, this.m);
    int j = ColorUtils.compositeColors(this.j, this.m);
    int k = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.j, 0), this.m);
    int m = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.l, 0), this.m);
    int n = ColorUtils.compositeColors(this.l, this.m);
    int i1 = ColorUtils.compositeColors(this.k, this.m);
    float f2 = rect.top;
    float f3 = rect.bottom;
    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
    return (Shader)new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, tileMode);
  }
  
  protected RectF a() {
    this.g.set(getBounds());
    return this.g;
  }
  
  public void a(float paramFloat) {
    if (this.a != paramFloat) {
      this.a = paramFloat;
      this.c.setStrokeWidth(paramFloat * 1.3333F);
      this.n = true;
      invalidateSelf();
    } 
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
  }
  
  void a(ColorStateList paramColorStateList) {
    if (paramColorStateList != null)
      this.m = paramColorStateList.getColorForState(getState(), this.m); 
    this.p = paramColorStateList;
    this.n = true;
    invalidateSelf();
  }
  
  public void a(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.o = paramShapeAppearanceModel;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.n) {
      this.c.setShader(b());
      this.n = false;
    } 
    float f1 = this.c.getStrokeWidth() / 2.0F;
    copyBounds(this.e);
    this.f.set(this.e);
    float f2 = Math.min(this.o.f().a(a()), this.f.width() / 2.0F);
    if (this.o.a(a())) {
      this.f.inset(f1, f1);
      paramCanvas.drawRoundRect(this.f, f2, f2, this.c);
    } 
  }
  
  public Drawable.ConstantState getConstantState() {
    return this.h;
  }
  
  public int getOpacity() {
    return (this.a > 0.0F) ? -3 : -2;
  }
  
  public void getOutline(Outline paramOutline) {
    if (this.o.a(a())) {
      float f = this.o.f().a(a());
      paramOutline.setRoundRect(getBounds(), f);
      return;
    } 
    copyBounds(this.e);
    this.f.set(this.e);
    this.b.a(this.o, 1.0F, this.f, this.d);
    if (this.d.isConvex())
      paramOutline.setConvexPath(this.d); 
  }
  
  public boolean getPadding(Rect paramRect) {
    if (this.o.a(a())) {
      int i = Math.round(this.a);
      paramRect.set(i, i, i, i);
    } 
    return true;
  }
  
  public boolean isStateful() {
    ColorStateList colorStateList = this.p;
    return ((colorStateList != null && colorStateList.isStateful()) || super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect) {
    this.n = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    ColorStateList colorStateList = this.p;
    if (colorStateList != null) {
      int i = colorStateList.getColorForState(paramArrayOfint, this.m);
      if (i != this.m) {
        this.n = true;
        this.m = i;
      } 
    } 
    if (this.n)
      invalidateSelf(); 
    return this.n;
  }
  
  public void setAlpha(int paramInt) {
    this.c.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.c.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  class BorderState extends Drawable.ConstantState {
    private BorderState(BorderDrawable this$0) {}
    
    public int getChangingConfigurations() {
      return 0;
    }
    
    public Drawable newDrawable() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\floatingactionbutton\BorderDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */