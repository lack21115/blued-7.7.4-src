package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

public class FlowLayout extends ViewGroup {
  private int a;
  
  private int b;
  
  private boolean c = false;
  
  private int d;
  
  public FlowLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt2 != Integer.MIN_VALUE) ? ((paramInt2 != 1073741824) ? paramInt3 : paramInt1) : Math.min(paramInt3, paramInt1);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout, 0, 0);
    this.a = typedArray.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
    this.b = typedArray.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
    typedArray.recycle();
  }
  
  public int b(View paramView) {
    Object object = paramView.getTag(R.id.row_index_key);
    return !(object instanceof Integer) ? -1 : ((Integer)object).intValue();
  }
  
  public boolean b() {
    return this.c;
  }
  
  protected int getItemSpacing() {
    return this.b;
  }
  
  protected int getLineSpacing() {
    return this.a;
  }
  
  protected int getRowCount() {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    boolean bool;
    if (getChildCount() == 0) {
      this.d = 0;
      return;
    } 
    this.d = 1;
    if (ViewCompat.getLayoutDirection((View)this) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      paramInt2 = getPaddingRight();
    } else {
      paramInt2 = getPaddingLeft();
    } 
    if (bool) {
      paramInt4 = getPaddingLeft();
    } else {
      paramInt4 = getPaddingRight();
    } 
    int j = getPaddingTop();
    int k = paramInt3 - paramInt1 - paramInt4;
    paramInt3 = paramInt2;
    paramInt1 = j;
    int i;
    for (i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (view.getVisibility() == 8) {
        view.setTag(R.id.row_index_key, Integer.valueOf(-1));
      } else {
        byte b1;
        byte b2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
          b2 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
          b1 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
        } else {
          b1 = 0;
          b2 = 0;
        } 
        int n = view.getMeasuredWidth();
        int m = paramInt3;
        paramInt4 = paramInt1;
        if (!this.c) {
          m = paramInt3;
          paramInt4 = paramInt1;
          if (paramInt3 + b2 + n > k) {
            paramInt4 = j + this.a;
            this.d++;
            m = paramInt2;
          } 
        } 
        view.setTag(R.id.row_index_key, Integer.valueOf(this.d - 1));
        paramInt1 = m + b2;
        paramInt3 = view.getMeasuredWidth() + paramInt1;
        j = view.getMeasuredHeight() + paramInt4;
        if (bool) {
          view.layout(k - paramInt3, paramInt4, k - m - b2, j);
        } else {
          view.layout(paramInt1, paramInt4, paramInt3, j);
        } 
        paramInt3 = m + b2 + b1 + view.getMeasuredWidth() + this.b;
        paramInt1 = paramInt4;
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int n;
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    if (i4 == Integer.MIN_VALUE || i4 == 1073741824) {
      n = i3;
    } else {
      n = Integer.MAX_VALUE;
    } 
    int k = getPaddingLeft();
    int i = getPaddingTop();
    int i7 = getPaddingRight();
    int j = i;
    int i1 = 0;
    int m = 0;
    int i2 = i;
    i = m;
    while (i1 < getChildCount()) {
      View view = getChildAt(i1);
      if (view.getVisibility() != 8) {
        byte b1;
        byte b2;
        measureChild(view, paramInt1, paramInt2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
          b1 = marginLayoutParams.leftMargin + 0;
          b2 = marginLayoutParams.rightMargin + 0;
        } else {
          b1 = 0;
          b2 = 0;
        } 
        int i10 = view.getMeasuredWidth();
        int i9 = k;
        m = j;
        int i8 = i9;
        if (k + b1 + i10 > n - i7) {
          m = j;
          i8 = i9;
          if (!b()) {
            i8 = getPaddingLeft();
            m = this.a + i2;
          } 
        } 
        k = i8 + b1 + view.getMeasuredWidth();
        i2 = view.getMeasuredHeight();
        j = i;
        if (k > i)
          j = k; 
        k = view.getMeasuredWidth();
        i9 = this.b;
        i = j;
        if (i1 == getChildCount() - 1)
          i = j + b2; 
        i2 += m;
        k = i8 + b1 + b2 + k + i9;
        j = m;
      } 
      i1++;
    } 
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingBottom();
    setMeasuredDimension(a(i3, i4, i + paramInt1), a(i5, i6, i2 + paramInt2));
  }
  
  protected void setItemSpacing(int paramInt) {
    this.b = paramInt;
  }
  
  protected void setLineSpacing(int paramInt) {
    this.a = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean) {
    this.c = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\FlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */