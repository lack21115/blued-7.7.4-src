package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TTRoundRectImageView extends ImageView {
  private Paint a = new Paint();
  
  private int b = 25;
  
  private int c = 25;
  
  private Matrix d;
  
  public TTRoundRectImageView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TTRoundRectImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TTRoundRectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setAntiAlias(true);
    this.a.setFilterBitmap(true);
    this.d = new Matrix();
  }
  
  private Bitmap a(Drawable paramDrawable) {
    int i;
    int j;
    if (paramDrawable == null)
      return null; 
    if (paramDrawable instanceof BitmapDrawable)
      return ((BitmapDrawable)paramDrawable).getBitmap(); 
    if (paramDrawable.getIntrinsicWidth() <= 0) {
      i = getWidth();
    } else {
      i = paramDrawable.getIntrinsicWidth();
    } 
    if (paramDrawable.getIntrinsicHeight() <= 0) {
      j = getHeight();
    } else {
      j = paramDrawable.getIntrinsicHeight();
    } 
    Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(canvas);
    return bitmap;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Drawable drawable = getDrawable();
    if (drawable != null) {
      Bitmap bitmap = a(drawable);
      if (bitmap != null) {
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        int i = bitmap.getWidth();
        int j = getWidth();
        float f = 1.0F;
        if (i != j || bitmap.getHeight() != getHeight())
          f = Math.max(getWidth() * 1.0F / bitmap.getWidth(), getHeight() * 1.0F / bitmap.getHeight()); 
        this.d.setScale(f, f);
        bitmapShader.setLocalMatrix(this.d);
        this.a.setShader((Shader)bitmapShader);
        paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.b, this.c, this.a);
        return;
      } 
      super.onDraw(paramCanvas);
      return;
    } 
    super.onDraw(paramCanvas);
  }
  
  public void setXRound(int paramInt) {
    this.b = paramInt;
    postInvalidate();
  }
  
  public void setYRound(int paramInt) {
    this.c = paramInt;
    postInvalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\TTRoundRectImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */