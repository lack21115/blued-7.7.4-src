package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.blued.android.module.live_china.R;
import java.util.ArrayList;
import java.util.List;

public class HoleRelativeLayout extends RelativeLayout {
  private List<RoundRect> a;
  
  private Paint b;
  
  private Xfermode c;
  
  private int d = -1;
  
  public HoleRelativeLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public HoleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HoleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HoleRelativeLayout);
    this.d = typedArray.getColor(R.styleable.HoleRelativeLayout_bgColor, this.d);
    typedArray.recycle();
    this.a = new ArrayList<RoundRect>();
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.c = (Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  }
  
  private void a(Canvas paramCanvas, RoundRect paramRoundRect) {
    Path path = new Path();
    path.moveTo(paramRoundRect.a + paramRoundRect.e, paramRoundRect.b);
    path.lineTo(paramRoundRect.a + paramRoundRect.c - paramRoundRect.f, paramRoundRect.b);
    path.addCircle(paramRoundRect.a + paramRoundRect.a() / 2.0F, paramRoundRect.b + paramRoundRect.b() / 2.0F, paramRoundRect.a() / 2.0F, Path.Direction.CW);
    path.close();
    paramCanvas.drawPath(path, this.b);
  }
  
  private void b(Canvas paramCanvas, RoundRect paramRoundRect) {
    Path path = new Path();
    path.moveTo(paramRoundRect.a + paramRoundRect.e, paramRoundRect.b);
    path.lineTo(paramRoundRect.a + paramRoundRect.c - paramRoundRect.f, paramRoundRect.b);
    path.arcTo(new RectF(paramRoundRect.a + paramRoundRect.c - paramRoundRect.f * 2.0F, paramRoundRect.b, paramRoundRect.a + paramRoundRect.c, paramRoundRect.b + paramRoundRect.f * 2.0F), 270.0F, 90.0F);
    path.lineTo(paramRoundRect.a + paramRoundRect.c, paramRoundRect.b + paramRoundRect.d - paramRoundRect.h);
    path.arcTo(new RectF(paramRoundRect.a + paramRoundRect.c - paramRoundRect.h * 2.0F, paramRoundRect.b + paramRoundRect.d - paramRoundRect.h * 2.0F, paramRoundRect.a + paramRoundRect.c, paramRoundRect.b + paramRoundRect.d), 0.0F, 90.0F);
    path.lineTo(paramRoundRect.a + paramRoundRect.g, paramRoundRect.b + paramRoundRect.d);
    path.arcTo(new RectF(paramRoundRect.a, paramRoundRect.b + paramRoundRect.d - paramRoundRect.g * 2.0F, paramRoundRect.a + paramRoundRect.g * 2.0F, paramRoundRect.b + paramRoundRect.d), 90.0F, 90.0F);
    path.lineTo(paramRoundRect.a, paramRoundRect.b + paramRoundRect.e);
    path.arcTo(new RectF(paramRoundRect.a, paramRoundRect.b, paramRoundRect.a + paramRoundRect.e * 2.0F, paramRoundRect.b + paramRoundRect.e * 2.0F), 180.0F, 90.0F);
    path.close();
    paramCanvas.drawPath(path, this.b);
  }
  
  public void a(RoundRect paramRoundRect) {
    this.a.add(paramRoundRect);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int j = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.drawColor(this.d);
    this.b.setXfermode(this.c);
    for (int i = 0; i < this.a.size(); i++) {
      RoundRect roundRect = this.a.get(i);
      if (roundRect.i) {
        a(paramCanvas, roundRect);
      } else {
        b(paramCanvas, roundRect);
      } 
    } 
    this.b.setXfermode(null);
    paramCanvas.restoreToCount(j);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    for (int i = 0; i < this.a.size(); i++) {
      RoundRect roundRect = this.a.get(i);
      if (paramMotionEvent.getX() >= roundRect.a && paramMotionEvent.getX() <= roundRect.a + roundRect.c && paramMotionEvent.getY() >= roundRect.b && paramMotionEvent.getY() <= roundRect.b + roundRect.d)
        return super.onTouchEvent(paramMotionEvent); 
    } 
    return true;
  }
  
  public void setBgColor(int paramInt) {
    this.d = paramInt;
    invalidate();
  }
  
  public static class RoundRect {
    public float a;
    
    public float b;
    
    public float c;
    
    public float d;
    
    public float e;
    
    public float f;
    
    public float g;
    
    public float h;
    
    public boolean i;
    
    public float a() {
      return this.c;
    }
    
    public float b() {
      return this.d;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RoundRect{x=");
      stringBuilder.append(this.a);
      stringBuilder.append(", y=");
      stringBuilder.append(this.b);
      stringBuilder.append(", width=");
      stringBuilder.append(this.c);
      stringBuilder.append(", height=");
      stringBuilder.append(this.d);
      stringBuilder.append(", leftTopRadius=");
      stringBuilder.append(this.e);
      stringBuilder.append(", rightTopRadius=");
      stringBuilder.append(this.f);
      stringBuilder.append(", leftBottomRadius=");
      stringBuilder.append(this.g);
      stringBuilder.append(", rightBottomRadius=");
      stringBuilder.append(this.h);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\HoleRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */