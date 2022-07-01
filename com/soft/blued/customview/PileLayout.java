package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.utils.DensityUtils;

public class PileLayout extends ViewGroup {
  protected float a;
  
  protected float b;
  
  public PileLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null, 0);
  }
  
  public PileLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PileLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = DensityUtils.a(paramContext, 4.0F);
    this.b = DensityUtils.a(paramContext, 10.0F);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int k = getPaddingLeft();
    int i = getPaddingTop();
    int n = getChildCount();
    paramInt4 = 0;
    int j = 0;
    int m = 0;
    while (m < n) {
      int i1;
      View view = getChildAt(m);
      if (view.getVisibility() == 8) {
        paramInt2 = i;
        i1 = paramInt4;
      } else {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i3 = marginLayoutParams.leftMargin + view.getMeasuredWidth() + marginLayoutParams.rightMargin;
        int i2 = k;
        paramInt2 = i;
        i1 = paramInt4;
        if (k + i3 + getPaddingRight() > paramInt3 - paramInt1) {
          i2 = getPaddingLeft();
          paramInt2 = (int)(i + paramInt4 + this.a);
          i1 = 0;
          j = 0;
        } 
        view.layout(marginLayoutParams.leftMargin + i2, marginLayoutParams.topMargin + paramInt2, marginLayoutParams.leftMargin + i2 + view.getMeasuredWidth(), marginLayoutParams.topMargin + paramInt2 + view.getMeasuredHeight());
        i = i2 + i3;
        k = marginLayoutParams.topMargin;
        i2 = view.getMeasuredHeight();
        i3 = marginLayoutParams.bottomMargin;
        paramInt4 = i;
        if (j != n - 1)
          paramInt4 = (int)(i - this.b); 
        i1 = Math.max(i1, k + i2 + i3);
        j++;
        k = paramInt4;
      } 
      m++;
      i = paramInt2;
      paramInt4 = i1;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int i5 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i6 = getChildCount();
    int n = 0;
    int i = 0;
    int i1 = 0;
    int j = 0;
    int i2 = 0;
    int m;
    for (m = 0; i1 < i6; m = i7) {
      int i7;
      View view = getChildAt(i1);
      if (view.getVisibility() == 8) {
        i7 = i;
        int i8 = j;
        if (i1 == i6 - 1) {
          i7 = i + n;
          i8 = Math.max(j, i2);
        } 
        i = i7;
        j = i8;
        i7 = m;
      } else {
        float f1;
        measureChildWithMargins(view, paramInt1, 0, paramInt2, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i8 = view.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        i7 = view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        int i9 = i2 + i8;
        float f2 = i9;
        if (m) {
          f1 = this.b;
        } else {
          f1 = 0.0F;
        } 
        if (f2 - f1 > (i3 - getPaddingLeft() - getPaddingRight())) {
          m = Math.max(j, i2);
          n = (int)(i + n + this.a);
          i2 = 0;
          j = i8;
          i = i7;
          i7 = n;
          n = m;
        } else {
          i8 = i9;
          if (m > 0)
            i8 = (int)(f2 - this.b); 
          i9 = Math.max(n, i7);
          i2 = m;
          n = j;
          i7 = i;
          i = i9;
          j = i8;
        } 
        m = i7;
        i8 = n;
        if (i1 == i6 - 1) {
          i8 = Math.max(j, n);
          m = i7 + i;
        } 
        i7 = i2 + 1;
        n = i;
        i2 = j;
        j = i8;
        i = m;
      } 
      i1++;
    } 
    if (i5 == 1073741824) {
      paramInt1 = i3;
    } else {
      paramInt1 = j + getPaddingLeft() + getPaddingRight();
    } 
    if (i4 != 1073741824)
      k = i + getPaddingTop() + getPaddingBottom(); 
    setMeasuredDimension(paramInt1, k);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PileLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */