package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class ShapeableImageView extends AppCompatImageView implements Shapeable {
  private static final int a = R.style.Widget_MaterialComponents_ShapeableImageView;
  
  private final ShapeAppearancePathProvider b = new ShapeAppearancePathProvider();
  
  private final RectF c;
  
  private final RectF d;
  
  private final Paint e;
  
  private final Paint f;
  
  private final Path g = new Path();
  
  private ColorStateList h;
  
  private ShapeAppearanceModel i;
  
  private float j;
  
  private Path k;
  
  private final MaterialShapeDrawable l;
  
  public ShapeableImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShapeableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setColor(-1);
    this.f.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.c = new RectF();
    this.d = new RectF();
    this.k = new Path();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeableImageView, paramInt, a);
    this.h = MaterialResources.a(paramContext, typedArray, R.styleable.ShapeableImageView_strokeColor);
    this.j = typedArray.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
    this.e = new Paint();
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setAntiAlias(true);
    this.i = ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, a).a();
    this.l = new MaterialShapeDrawable(this.i);
    if (Build.VERSION.SDK_INT >= 21)
      setOutlineProvider(new OutlineProvider(this)); 
  }
  
  private void a(int paramInt1, int paramInt2) {
    this.c.set(getPaddingLeft(), getPaddingTop(), (paramInt1 - getPaddingRight()), (paramInt2 - getPaddingBottom()));
    this.b.a(this.i, 1.0F, this.c, this.g);
    this.k.rewind();
    this.k.addPath(this.g);
    this.d.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.k.addRect(this.d, Path.Direction.CCW);
  }
  
  private void a(Canvas paramCanvas) {
    if (this.h == null)
      return; 
    this.e.setStrokeWidth(this.j);
    int i = this.h.getColorForState(getDrawableState(), this.h.getDefaultColor());
    if (this.j > 0.0F && i != 0) {
      this.e.setColor(i);
      paramCanvas.drawPath(this.g, this.e);
    } 
  }
  
  public ShapeAppearanceModel getShapeAppearanceModel() {
    return this.i;
  }
  
  public ColorStateList getStrokeColor() {
    return this.h;
  }
  
  public float getStrokeWidth() {
    return this.j;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    setLayerType(2, null);
  }
  
  protected void onDetachedFromWindow() {
    setLayerType(0, null);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    paramCanvas.drawPath(this.k, this.f);
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void setShapeAppearanceModel(ShapeAppearanceModel paramShapeAppearanceModel) {
    this.i = paramShapeAppearanceModel;
    this.l.setShapeAppearanceModel(paramShapeAppearanceModel);
    a(getWidth(), getHeight());
    invalidate();
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList) {
    this.h = paramColorStateList;
    invalidate();
  }
  
  public void setStrokeColorResource(int paramInt) {
    setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setStrokeWidth(float paramFloat) {
    if (this.j != paramFloat) {
      this.j = paramFloat;
      invalidate();
    } 
  }
  
  public void setStrokeWidthResource(int paramInt) {
    setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
  
  class OutlineProvider extends ViewOutlineProvider {
    private final Rect b = new Rect();
    
    OutlineProvider(ShapeableImageView this$0) {}
    
    public void getOutline(View param1View, Outline param1Outline) {
      if (ShapeableImageView.a(this.a) == null)
        return; 
      ShapeableImageView.b(this.a).round(this.b);
      ShapeableImageView.c(this.a).setBounds(this.b);
      ShapeableImageView.c(this.a).getOutline(param1Outline);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\imageview\ShapeableImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */