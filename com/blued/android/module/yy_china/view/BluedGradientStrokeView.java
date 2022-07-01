package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.blued.android.module.yy_china.R;

public class BluedGradientStrokeView extends LinearLayout {
  private Paint a;
  
  private Xfermode b;
  
  private float c = 0.0F;
  
  private float d = 0.0F;
  
  private float e = 0.0F;
  
  private float f = 0.0F;
  
  private float g = 0.0F;
  
  private float h = 0.0F;
  
  private int i;
  
  private RoundRect j;
  
  private Path k = new Path();
  
  public BluedGradientStrokeView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BluedGradientStrokeView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BluedGradientStrokeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BluedGradientStrokeView);
    this.c = typedArray.getDimension(R.styleable.BluedGradientStrokeView_stroke_width, 0.0F);
    this.d = typedArray.getDimension(R.styleable.BluedGradientStrokeView_left_top_radius, 0.0F);
    this.e = typedArray.getDimension(R.styleable.BluedGradientStrokeView_right_top_radius, 0.0F);
    this.f = typedArray.getDimension(R.styleable.BluedGradientStrokeView_bottom_left_radius, 0.0F);
    this.g = typedArray.getDimension(R.styleable.BluedGradientStrokeView_bottom_right_radius, 0.0F);
    this.h = typedArray.getDimension(R.styleable.BluedGradientStrokeView_radius, 0.0F);
    this.i = typedArray.getResourceId(R.styleable.BluedGradientStrokeView_storke_color, R.drawable.shape_raduis_6dp_66ffa3_3e93ff_4e9bff);
    typedArray.recycle();
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.b = (Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    this.a.setXfermode(this.b);
    RectF rectF = new RectF();
    rectF.set(this.j.a, this.j.b, this.j.c, this.j.d);
    this.k.reset();
    Path path = this.k;
    float f = this.h;
    path.addRoundRect(rectF, f, f, Path.Direction.CW);
    this.k.setFillType(Path.FillType.WINDING);
    paramCanvas.clipPath(this.k, Region.Op.DIFFERENCE);
    Drawable drawable = getResources().getDrawable(this.i);
    drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    drawable.draw(paramCanvas);
    this.a.setXfermode(null);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.j = new RoundRect();
    RoundRect roundRect = this.j;
    float f1 = this.c;
    roundRect.a = f1;
    roundRect.b = f1;
    roundRect.c = getMeasuredWidth() - this.c;
    this.j.d = getMeasuredHeight() - this.c;
    roundRect = this.j;
    float f2 = this.d;
    f1 = f2;
    if (f2 <= 0.0F)
      f1 = this.h; 
    roundRect.e = f1;
    roundRect = this.j;
    f2 = this.e;
    f1 = f2;
    if (f2 <= 0.0F)
      f1 = this.h; 
    roundRect.f = f1;
    roundRect = this.j;
    f2 = this.f;
    f1 = f2;
    if (f2 <= 0.0F)
      f1 = this.h; 
    roundRect.g = f1;
    roundRect = this.j;
    f2 = this.g;
    f1 = f2;
    if (f2 <= 0.0F)
      f1 = this.h; 
    roundRect.h = f1;
  }
  
  class RoundRect {
    public float a;
    
    public float b;
    
    public float c;
    
    public float d;
    
    public float e;
    
    public float f;
    
    public float g;
    
    public float h;
    
    private RoundRect(BluedGradientStrokeView this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\BluedGradientStrokeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */