package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class ShadowTextView extends TextView {
  private Paint a;
  
  private RectF b;
  
  private int c = 0;
  
  public ShadowTextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ShadowTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShadowTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    setTextColor(-1);
    this.a = new Paint();
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setColor(Color.parseColor("#99333333"));
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(0.0F);
    this.b = new RectF();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    RectF rectF = this.b;
    paramCanvas.drawRoundRect(rectF, rectF.bottom / 2.0F, this.b.bottom / 2.0F, this.a);
    float f = getPaint().measureText(getText().toString());
    paramCanvas.translate(this.b.right / 2.0F - f / 2.0F, 0.0F);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredWidth();
    int i = getMeasuredHeight();
    if (paramInt2 > 0 && i > 0) {
      this.c = (int)getPaint().measureText("00");
      int j = this.c;
      paramInt1 = paramInt2;
      if (paramInt2 < j)
        paramInt1 = j; 
      paramInt1 += i / 2 * 2;
      setMeasuredDimension(paramInt1, i);
      this.b.set(0.0F, 0.0F, paramInt1, i);
      return;
    } 
    this.b.set(0.0F, 0.0F, 0.0F, 0.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\ShadowTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */