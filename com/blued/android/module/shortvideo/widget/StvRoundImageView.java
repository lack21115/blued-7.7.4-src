package com.blued.android.module.shortvideo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.module.shortvideo.R;

public class StvRoundImageView extends AppCompatImageView {
  private Paint a;
  
  private int b = 0;
  
  private int c = a(10.0F);
  
  public StvRoundImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StvRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat) {
    return (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  private Bitmap a(Drawable paramDrawable) {
    if (paramDrawable == null)
      return null; 
    Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Matrix matrix = getImageMatrix();
    if (matrix != null)
      canvas.concat(matrix); 
    paramDrawable.draw(canvas);
    return bitmap;
  }
  
  private void a() {
    this.a = new Paint(5);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    int[] arrayOfInt = R.styleable.StvRoundImageView;
    boolean bool = false;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0);
    paramInt = bool;
    if (typedArray.hasValue(R.styleable.StvRoundImageView_stv_round_v_type))
      paramInt = typedArray.getInt(R.styleable.StvRoundImageView_stv_round_v_type, 0); 
    this.b = paramInt;
    if (typedArray.hasValue(R.styleable.StvRoundImageView_stv_round_v_radius)) {
      paramInt = typedArray.getDimensionPixelSize(R.styleable.StvRoundImageView_stv_round_v_radius, this.c);
    } else {
      paramInt = this.c;
    } 
    this.c = paramInt;
    typedArray.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Drawable drawable = getDrawable();
    Matrix matrix = getImageMatrix();
    if (drawable == null)
      return; 
    if (drawable.getIntrinsicWidth() != 0) {
      Bitmap bitmap;
      if (drawable.getIntrinsicHeight() == 0)
        return; 
      if (matrix == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
        drawable.draw(paramCanvas);
        return;
      } 
      int i = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (Build.VERSION.SDK_INT >= 16 && getCropToPadding()) {
        int k = getScrollX();
        int m = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + k, getPaddingTop() + m, k + getRight() - getLeft() - getPaddingRight(), m + getBottom() - getTop() - getPaddingBottom());
      } 
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      int j = this.b;
      if (j == 1) {
        bitmap = a(drawable);
        this.a.setShader((Shader)new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paramCanvas.drawCircle((getWidth() / 2), (getHeight() / 2), (getWidth() / 2), this.a);
      } else {
        RectF rectF;
        if (j == 2) {
          bitmap = a((Drawable)bitmap);
          this.a.setShader((Shader)new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
          rectF = new RectF(getPaddingLeft(), getPaddingTop(), (getWidth() - getPaddingRight()), (getHeight() - getPaddingBottom()));
          j = this.c;
          paramCanvas.drawRoundRect(rectF, j, j, this.a);
        } else {
          if (matrix != null)
            paramCanvas.concat(matrix); 
          rectF.draw(paramCanvas);
        } 
      } 
      paramCanvas.restoreToCount(i);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.b == 1) {
      super.onMeasure(paramInt1, paramInt2);
      paramInt1 = Math.min(getMeasuredHeight(), getMeasuredWidth());
      setMeasuredDimension(paramInt1, paramInt1);
      return;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setShapeType(int paramInt) {
    this.b = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\widget\StvRoundImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */