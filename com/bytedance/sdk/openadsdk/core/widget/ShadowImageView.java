package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ShadowImageView extends ImageView {
  private Paint a;
  
  private RectF b;
  
  public ShadowImageView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public ShadowImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ShadowImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    this.a = new Paint();
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setColor(Color.parseColor("#99333333"));
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(0.0F);
    this.b = new RectF();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    RectF rectF = this.b;
    paramCanvas.drawRoundRect(rectF, rectF.right / 2.0F, this.b.bottom / 2.0F, this.a);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.b.right != getMeasuredWidth() || this.b.bottom != getMeasuredHeight())
      this.b.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\ShadowImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */