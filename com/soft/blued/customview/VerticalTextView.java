package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.framework.utils.DensityUtils;

public class VerticalTextView extends AppCompatTextView {
  protected TextPaint a = new TextPaint(1);
  
  private int b;
  
  private CharSequence c = "左滑看更多";
  
  private Paint d;
  
  private Path e;
  
  private float f = 0.0F;
  
  private int g;
  
  private boolean h = true;
  
  public VerticalTextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public VerticalTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setAntiAlias(true);
    this.b = DensityUtils.a(paramContext, 4.0F);
    this.g = DensityUtils.a(paramContext, 8.0F);
    this.d = new Paint();
    this.d.setColor(Color.parseColor("#F3F4F4"));
    this.d.setAntiAlias(true);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setStrokeWidth(1.0F);
    this.e = new Path();
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.f = paramFloat1;
    paramFloat2 = paramFloat2 / 2.0F - this.g;
    if (this.f >= paramFloat2) {
      this.f = paramFloat2;
    } else {
      this.f = paramFloat2 + (paramFloat1 - paramFloat2) / 2.0F;
    } 
    invalidate();
  }
  
  public boolean getIsDrawShadow() {
    return this.h;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.h) {
      this.e.reset();
      this.e.moveTo(getWidth(), 0.0F);
      this.e.quadTo(this.f, (getHeight() / 2), getWidth(), getHeight());
      paramCanvas.drawPath(this.e, this.d);
    } 
    this.a.setTextSize(getTextSize());
    this.a.setColor(getCurrentTextColor());
    this.a.setTypeface(getTypeface());
    CharSequence charSequence = this.c;
    if (charSequence != null && !charSequence.toString().trim().equals("") && getLayout() != null) {
      Rect rect = new Rect();
      TextPaint textPaint = this.a;
      String str = charSequence.toString();
      int j = charSequence.length();
      int i = 0;
      textPaint.getTextBounds(str, 0, j, rect);
      float f2 = getLayout().getLineLeft(0) + getPaddingLeft();
      float f1 = f2;
      if (getCompoundDrawables()[0] != null) {
        Rect rect1 = getCompoundDrawables()[0].getBounds();
        f1 = f2 + (rect1.right - rect1.left);
      } 
      f2 = getCompoundDrawablePadding();
      float f3 = getBaseline();
      j = rect.bottom - rect.top + this.b;
      float f4 = ((charSequence.length() - 1) * j / 2);
      while (i < charSequence.length()) {
        paramCanvas.drawText(String.valueOf(charSequence.charAt(i)), f1 + f2, (i * j) + f3 - f4, (Paint)this.a);
        i++;
      } 
    } 
    super.onDraw(paramCanvas);
  }
  
  public void setDrawShadow(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    this.c = paramCharSequence;
    super.setText("", paramBufferType);
  }
  
  public void setVerticalText(CharSequence paramCharSequence) {
    if (TextUtils.isEmpty(paramCharSequence))
      return; 
    this.c = paramCharSequence;
    invalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\VerticalTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */