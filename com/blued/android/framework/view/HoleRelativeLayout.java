package com.blued.android.framework.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.R;
import com.blued.android.framework.utils.DensityUtils;
import java.util.ArrayList;
import java.util.List;

public class HoleRelativeLayout extends RelativeLayout {
  private List<RoundRect> a;
  
  private Paint b;
  
  private Xfermode c;
  
  private Activity d;
  
  private boolean e = false;
  
  private boolean f = true;
  
  private View.OnClickListener g;
  
  private int h = Color.parseColor("#D91E2327");
  
  public HoleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HoleRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HoleRelativeLayout);
    this.h = typedArray.getColor(R.styleable.HoleRelativeLayout_bgColor, this.h);
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
  
  private boolean b() {
    Activity activity = this.d;
    if (activity != null) {
      int i = activity.findViewById(16908290).getHeight();
      if (AppInfo.m == i)
        return true; 
    } 
    return false;
  }
  
  public void a() {
    ViewGroup viewGroup = (ViewGroup)getParent();
    if (viewGroup == null)
      return; 
    viewGroup.removeView((View)this);
    View.OnClickListener onClickListener = this.g;
    if (onClickListener != null)
      onClickListener.onClick((View)this); 
  }
  
  public void a(RoundRect paramRoundRect) {
    this.a.add(paramRoundRect);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int j = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.drawColor(this.h);
    this.b.setXfermode(this.c);
    for (int i = 0; i < this.a.size(); i++)
      a(paramCanvas, this.a.get(i)); 
    this.b.setXfermode(null);
    paramCanvas.restoreToCount(j);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.e) {
      if (paramMotionEvent.getAction() != 1)
        return true; 
      a();
      return true;
    } 
    for (int i = 0; i < this.a.size(); i++) {
      RoundRect roundRect = this.a.get(i);
      if (paramMotionEvent.getX() >= roundRect.a && paramMotionEvent.getX() <= roundRect.a + roundRect.c && paramMotionEvent.getY() >= roundRect.b && paramMotionEvent.getY() <= roundRect.b + roundRect.d)
        return this.f ? super.onTouchEvent(paramMotionEvent) : true; 
    } 
    return true;
  }
  
  public void setCanDetachOnTouched(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void setIfHoleCanDetach(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setOnDetachLisnter(View.OnClickListener paramOnClickListener) {
    this.g = paramOnClickListener;
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
    
    public void a(float param1Float) {
      this.e = param1Float;
      this.f = param1Float;
      this.g = param1Float;
      this.h = param1Float;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\HoleRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */