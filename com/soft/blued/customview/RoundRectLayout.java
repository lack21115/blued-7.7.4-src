package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.soft.blued.R;

public class RoundRectLayout extends RelativeLayout {
  private Path a;
  
  private float b;
  
  private int c;
  
  private int d;
  
  private float e;
  
  private int f = 1;
  
  public RoundRectLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundRectLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, 0);
    a(paramAttributeSet, paramInt);
  }
  
  private void a() {
    if (getWidth() == this.c && getHeight() == this.d && this.e == this.b)
      return; 
    this.c = getWidth();
    this.d = getHeight();
    this.e = this.b;
    this.a.reset();
    int i = this.f;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return; 
            Path path4 = this.a;
            RectF rectF4 = new RectF(0.0F, 0.0F, this.c, this.d);
            float f4 = this.b;
            Path.Direction direction3 = Path.Direction.CW;
            path4.addRoundRect(rectF4, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f4, f4, f4, f4 }, direction3);
            return;
          } 
          Path path3 = this.a;
          RectF rectF3 = new RectF(0.0F, 0.0F, this.c, this.d);
          float f3 = this.b;
          Path.Direction direction2 = Path.Direction.CW;
          path3.addRoundRect(rectF3, new float[] { 0.0F, 0.0F, f3, f3, f3, f3, 0.0F, 0.0F }, direction2);
          return;
        } 
        Path path2 = this.a;
        RectF rectF2 = new RectF(0.0F, 0.0F, this.c, this.d);
        float f2 = this.b;
        Path.Direction direction1 = Path.Direction.CW;
        path2.addRoundRect(rectF2, new float[] { f2, f2, f2, f2, 0.0F, 0.0F, 0.0F, 0.0F }, direction1);
        return;
      } 
      Path path1 = this.a;
      RectF rectF1 = new RectF(0.0F, 0.0F, this.c, this.d);
      float f1 = this.b;
      Path.Direction direction = Path.Direction.CW;
      path1.addRoundRect(rectF1, new float[] { f1, f1, 0.0F, 0.0F, 0.0F, 0.0F, f1, f1 }, direction);
      return;
    } 
    Path path = this.a;
    RectF rectF = new RectF(0.0F, 0.0F, this.c, this.d);
    float f = this.b;
    path.addRoundRect(rectF, f, f, Path.Direction.CW);
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt) {
    this.b = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeTextView, paramInt, 0).getDimension(7, 0.0F);
    this.a = new Path();
    this.a.setFillType(Path.FillType.EVEN_ODD);
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.f != 0) {
      int i = paramCanvas.save();
      a();
      paramCanvas.clipPath(this.a);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    } 
    super.draw(paramCanvas);
  }
  
  public void setBackground(Drawable paramDrawable) {
    super.setBackground(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt) {
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
  }
  
  public void setCornerRadius(int paramInt) {
    this.b = paramInt;
  }
  
  public void setRoundMode(int paramInt) {
    this.f = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\RoundRectLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */