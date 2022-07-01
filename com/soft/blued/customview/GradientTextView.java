package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.soft.blued.R;

public class GradientTextView extends AppCompatTextView {
  private Paint a;
  
  private TextPaint b;
  
  private int c;
  
  private int d;
  
  private float e;
  
  private float f;
  
  private int g;
  
  private float h;
  
  public GradientTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public GradientTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a() {
    float f1 = getMeasuredHeight();
    float f2 = this.e;
    float f3 = getMeasuredWidth();
    float f4 = this.f;
    int i = this.c;
    int j = this.d;
    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
    LinearGradient linearGradient = new LinearGradient(0.0F, 0.0F, f3 * f4, f1 * f2, new int[] { i, j }, null, tileMode);
    this.a.setShader((Shader)linearGradient);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WordArtText);
    this.c = typedArray.getColor(3, 0);
    this.d = typedArray.getColor(0, 0);
    this.g = typedArray.getColor(4, 0);
    this.e = typedArray.getFloat(1, 1.0F);
    this.f = typedArray.getFloat(2, 0.0F);
    this.h = typedArray.getDimension(5, 1.0F);
    typedArray.recycle();
  }
  
  private void b() {
    if (this.b == null)
      this.b = new TextPaint(); 
    this.b.setTextSize(this.a.getTextSize());
    this.b.setTypeface(this.a.getTypeface());
    this.b.setFlags(this.a.getFlags());
    this.b.setAlpha(this.a.getAlpha());
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(this.g);
    this.b.setStrokeWidth(this.h);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Rect rect = new Rect();
    this.a = (Paint)getPaint();
    String str = getText().toString();
    this.a.getTextBounds(str, 0, str.length(), rect);
    int i = rect.bottom / 2 + rect.top / 2;
    if (this.c != 0 && this.d != 0) {
      a();
      paramCanvas.drawText(str, (getMeasuredWidth() / 2 - rect.width() / 2), (getMeasuredHeight() / 2 - i), this.a);
    } 
    if (this.g != 0) {
      b();
      paramCanvas.drawText(str, (getMeasuredWidth() / 2 - rect.width() / 2), (getMeasuredHeight() / 2 - i), (Paint)this.b);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\GradientTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */