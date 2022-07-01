package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class WrapperView extends ViewGroup {
  View a;
  
  Drawable b;
  
  int c;
  
  View d;
  
  int e;
  
  WrapperView(Context paramContext) {
    super(paramContext);
  }
  
  void a(View paramView1, View paramView2, Drawable paramDrawable, int paramInt) {
    if (paramView1 != null) {
      View view = this.a;
      if (view != paramView1) {
        removeView(view);
        this.a = paramView1;
        ViewParent viewParent = paramView1.getParent();
        if (viewParent != null && viewParent != this && viewParent instanceof ViewGroup)
          ((ViewGroup)viewParent).removeView(paramView1); 
        addView(paramView1);
      } 
      paramView1 = this.d;
      if (paramView1 != paramView2) {
        if (paramView1 != null)
          removeView(paramView1); 
        this.d = paramView2;
        if (paramView2 != null)
          addView(paramView2); 
      } 
      if (this.b != paramDrawable) {
        this.b = paramDrawable;
        this.c = paramInt;
        invalidate();
      } 
      return;
    } 
    throw new NullPointerException("List view item must not be null.");
  }
  
  public boolean a() {
    return (this.d != null);
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    if (this.d == null && this.b != null && this.a.getVisibility() != 8) {
      if (Build.VERSION.SDK_INT < 11)
        paramCanvas.clipRect(0, 0, getWidth(), this.c); 
      this.b.draw(paramCanvas);
    } 
  }
  
  public View getHeader() {
    return this.d;
  }
  
  public View getItem() {
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    View view = this.d;
    if (view != null) {
      paramInt3 = view.getMeasuredHeight();
      this.d.layout(0, 0, paramInt1, paramInt3);
      this.e = paramInt3;
      this.a.layout(0, paramInt3, paramInt1, paramInt2);
      return;
    } 
    Drawable drawable = this.b;
    if (drawable != null) {
      drawable.setBounds(0, 0, paramInt1, this.c);
      paramInt3 = this.c;
      this.e = paramInt3;
      this.a.layout(0, paramInt3, paramInt1, paramInt2);
      return;
    } 
    this.e = 0;
    this.a.layout(0, 0, paramInt1, paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    View view = this.d;
    if (view != null) {
      ViewGroup.LayoutParams layoutParams1 = view.getLayoutParams();
      if (layoutParams1 != null && layoutParams1.height > 0) {
        this.d.measure(paramInt2, View.MeasureSpec.makeMeasureSpec(layoutParams1.height, 1073741824));
      } else {
        this.d.measure(paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0));
      } 
      paramInt1 = this.d.getMeasuredHeight() + 0;
    } else if (this.b != null && this.a.getVisibility() != 8) {
      paramInt1 = this.c + 0;
    } else {
      paramInt1 = 0;
    } 
    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
    if (this.a.getVisibility() == 8) {
      this.a.measure(paramInt2, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
    } else {
      if (layoutParams != null && layoutParams.height >= 0) {
        this.a.measure(paramInt2, View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        paramInt2 = this.a.getMeasuredHeight();
      } else {
        this.a.measure(paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0));
        paramInt2 = this.a.getMeasuredHeight();
      } 
      paramInt1 += paramInt2;
    } 
    setMeasuredDimension(i, paramInt1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\WrapperView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */