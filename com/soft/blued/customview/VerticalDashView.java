package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.soft.blued.R;

public class VerticalDashView extends View {
  private Paint a;
  
  private Rect b;
  
  private Context c;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private int g;
  
  public VerticalDashView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    float f1 = TypedValue.applyDimension(1, 4.0F, displayMetrics);
    float f2 = TypedValue.applyDimension(1, 4.0F, displayMetrics);
    float f3 = TypedValue.applyDimension(1, 4.0F, displayMetrics);
    if (paramAttributeSet != null) {
      TypedArray typedArray = this.c.obtainStyledAttributes(paramAttributeSet, R.styleable.VerticalDashView);
      this.d = typedArray.getDimension(1, (int)f2);
      this.e = typedArray.getDimension(2, (int)f1);
      this.f = typedArray.getDimension(3, (int)f3);
      this.g = typedArray.getColor(0, this.c.getResources().getColor(2131100716));
    } 
    this.a = new Paint();
    a();
  }
  
  protected void a() {
    this.a.setColor(this.g);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.f);
    this.a.setAntiAlias(true);
    this.a.setPathEffect((PathEffect)new DashPathEffect(new float[] { this.d, this.e }, 0.0F));
    this.b = new Rect();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    float f = (this.b.right - this.b.left) / 2.0F;
    paramCanvas.drawLine(f, 0.0F, f, this.b.bottom + 0.0F - this.b.top, this.a);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect rect = this.b;
    rect.left = paramInt1;
    rect.top = paramInt2;
    rect.right = paramInt3;
    rect.bottom = paramInt4;
  }
  
  public void setDashColor(int paramInt) {
    this.g = this.c.getResources().getColor(paramInt);
    a();
    postInvalidate();
  }
  
  public void setDashColor(String paramString) {
    this.g = Color.parseColor(paramString);
    a();
    postInvalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\VerticalDashView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */