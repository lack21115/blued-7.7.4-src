package com.blued.android.module.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.live.base.R;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
  private static final String a = FlowLayout.class.getSimpleName();
  
  private boolean b = true;
  
  private int c = 0;
  
  private int d = 0;
  
  private int e = -65538;
  
  private float f = 0.0F;
  
  private float g = 0.0F;
  
  private boolean h = false;
  
  private int i = Integer.MAX_VALUE;
  
  private int j = -1;
  
  private int k = -65536;
  
  private int l;
  
  private List<Float> m = new ArrayList<Float>();
  
  private List<Integer> n = new ArrayList<Integer>();
  
  private List<Integer> o = new ArrayList<Integer>();
  
  private List<Integer> p = new ArrayList<Integer>();
  
  public FlowLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout, 0, 0);
    try {
      this.b = typedArray.getBoolean(R.styleable.FlowLayout_flFlow, true);
      try {
        this.c = typedArray.getInt(R.styleable.FlowLayout_flChildSpacing, 0);
      } catch (NumberFormatException numberFormatException) {
        this.c = typedArray.getDimensionPixelSize(R.styleable.FlowLayout_flChildSpacing, (int)a(0.0F));
      } 
      try {
        this.d = typedArray.getInt(R.styleable.FlowLayout_flMinChildSpacing, 0);
      } catch (NumberFormatException numberFormatException) {
        this.d = typedArray.getDimensionPixelSize(R.styleable.FlowLayout_flMinChildSpacing, (int)a(0.0F));
      } 
      try {
        this.e = typedArray.getInt(R.styleable.FlowLayout_flChildSpacingForLastRow, -65538);
      } catch (NumberFormatException numberFormatException) {
        this.e = typedArray.getDimensionPixelSize(R.styleable.FlowLayout_flChildSpacingForLastRow, (int)a(0.0F));
      } 
      try {
        this.f = typedArray.getInt(R.styleable.FlowLayout_flRowSpacing, 0);
      } catch (NumberFormatException numberFormatException) {
        this.f = typedArray.getDimension(R.styleable.FlowLayout_flRowSpacing, a(0.0F));
      } 
      this.i = typedArray.getInt(R.styleable.FlowLayout_flMaxRows, 2147483647);
      this.h = typedArray.getBoolean(R.styleable.FlowLayout_flRtl, false);
      this.j = typedArray.getInt(R.styleable.FlowLayout_android_gravity, -1);
      this.k = typedArray.getInt(R.styleable.FlowLayout_flRowVerticalGravity, -65536);
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  private float a(float paramFloat) {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j = this.c;
    byte b = 0;
    int i = b;
    if (j != -65536) {
      i = b;
      if (paramInt4 < this.o.size()) {
        i = b;
        if (paramInt4 < this.p.size()) {
          if (((Integer)this.p.get(paramInt4)).intValue() <= 0)
            return 0; 
          if (paramInt1 != 1)
            return (paramInt1 != 5) ? 0 : (paramInt2 - paramInt3 - ((Integer)this.o.get(paramInt4)).intValue()); 
          i = (paramInt2 - paramInt3 - ((Integer)this.o.get(paramInt4)).intValue()) / 2;
        } 
      } 
    } 
    return i;
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt1 == -65536) ? ((paramInt4 > 1) ? ((paramInt2 - paramInt3) / (paramInt4 - 1)) : 0.0F) : paramInt1;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  public int getChildSpacing() {
    return this.c;
  }
  
  public int getChildSpacingForLastRow() {
    return this.e;
  }
  
  public int getMaxRows() {
    return this.i;
  }
  
  public int getMinChildSpacing() {
    return this.d;
  }
  
  public float getRowSpacing() {
    return this.f;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j;
    int i = getPaddingLeft();
    int i3 = getPaddingRight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    if (this.h) {
      j = getWidth() - i3;
    } else {
      j = i;
    } 
    int i1 = this.j;
    int n = i1 & 0x70;
    int i4 = i1 & 0x7;
    if (n != 16) {
      if (n != 80) {
        paramInt2 = k;
      } else {
        paramInt2 = paramInt4 - paramInt2 - k - m - this.l;
        paramInt2 = k + paramInt2;
      } 
    } else {
      paramInt2 = (paramInt4 - paramInt2 - k - m - this.l) / 2;
      paramInt2 = k + paramInt2;
    } 
    paramInt4 = i + i3;
    int i5 = paramInt3 - paramInt1;
    j += a(i4, i5, paramInt4, 0);
    paramInt1 = this.k & 0x70;
    paramInt3 = this.p.size();
    m = 0;
    int i2 = 0;
    k = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (m < paramInt3) {
      n = ((Integer)this.p.get(m)).intValue();
      int i6 = ((Integer)this.n.get(m)).intValue();
      float f = ((Float)this.m.get(m)).floatValue();
      int i7 = 0;
      i1 = j;
      i = i2;
      j = i6;
      for (i6 = i7; i6 < n && i < getChildCount(); i6 = i10) {
        float f1;
        int i9;
        i2 = i + 1;
        View view = getChildAt(i);
        if (view.getVisibility() == 8) {
          i = i2;
          continue;
        } 
        int i10 = i6 + 1;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
          i6 = marginLayoutParams.leftMargin;
          i7 = marginLayoutParams.rightMargin;
          i9 = marginLayoutParams.topMargin;
          i8 = marginLayoutParams.bottomMargin;
        } else {
          i8 = 0;
          i9 = 0;
          i6 = 0;
          i7 = 0;
        } 
        int i12 = view.getMeasuredWidth();
        int i13 = view.getMeasuredHeight();
        int i11 = k + i9;
        if (paramInt2 == 80) {
          i = k + j - i8 - i13;
        } else {
          i = i11;
          if (paramInt2 == 16)
            i = i11 + (j - i9 - i8 - i13) / 2; 
        } 
        int i8 = i + i13;
        if (this.h) {
          i9 = i1 - i7;
          view.layout(i9 - i12, i, i9, i8);
          f1 = i1 - i12 + f + i6 + i7;
        } else {
          i9 = i1 + i6;
          view.layout(i9, i, i9 + i12, i8);
          f1 = i1 + i12 + f + i6 + i7;
        } 
        i1 = (int)f1;
        i = i2;
      } 
      if (this.h) {
        n = getWidth() - i3;
      } else {
        n = paramInt1;
      } 
      n = a(i4, i5, paramInt4, ++m) + n;
      k = (int)(k + j + this.g);
      j = n;
      i2 = i;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    float f;
    int i1;
    boolean bool;
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    this.m.clear();
    this.n.clear();
    this.o.clear();
    this.p.clear();
    int i5 = getChildCount();
    int i9 = i - getPaddingLeft() - getPaddingRight();
    if (i4 != 0 && this.b) {
      bool = true;
    } else {
      bool = false;
    } 
    if (this.c == -65536 && i4 == 0) {
      i1 = 0;
    } else {
      i1 = this.c;
    } 
    if (i1 == -65536) {
      f = this.d;
    } else {
      f = i1;
    } 
    int m = 0;
    int n = 0;
    int i6 = 0;
    int i7 = 0;
    int i2 = 0;
    int k = 0;
    int i8;
    for (i8 = 0; i6 < i5; i8 = i10) {
      int i10;
      View view = getChildAt(i6);
      if (view.getVisibility() == 8) {
        i10 = m;
        m = n;
        n = i1;
        i1 = i10;
        i10 = i8;
      } else {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
          measureChildWithMargins(view, paramInt1, 0, paramInt2, k);
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
          i12 = marginLayoutParams.leftMargin;
          int i16 = marginLayoutParams.rightMargin;
          i10 = marginLayoutParams.topMargin;
          int i15 = marginLayoutParams.bottomMargin;
          i12 += i16;
          i10 += i15;
        } else {
          measureChild(view, paramInt1, paramInt2);
          i12 = 0;
          i10 = 0;
        } 
        int i14 = m;
        float f1 = f;
        int i13 = n;
        m = view.getMeasuredWidth() + i12;
        int i12 = view.getMeasuredHeight() + i10;
        if (bool && i2 + m > i9) {
          List<Float> list1 = this.m;
          n = i1;
          list1.add(Float.valueOf(b(n, i9, i13, i14)));
          this.p.add(Integer.valueOf(i14));
          this.n.add(Integer.valueOf(i8));
          List<Integer> list = this.o;
          i1 = (int)f1;
          list.add(Integer.valueOf(i2 - i1));
          i10 = k;
          if (this.m.size() <= this.i)
            i10 = k + i8; 
          i7 = Math.max(i7, i2);
          i8 = i12;
          i2 = i1 + m;
          i1 = 1;
          k = i10;
          i10 = i8;
        } else {
          n = i1;
          i1 = i14 + 1;
          i2 = (int)(i2 + m + f1);
          m += i13;
          i10 = Math.max(i8, i12);
        } 
      } 
      int i11 = i6 + 1;
      i6 = m;
      i8 = n;
      m = i1;
      n = i6;
      i6 = i11;
      i1 = i8;
    } 
    paramInt1 = this.e;
    if (paramInt1 == -65537) {
      if (this.m.size() >= 1) {
        List<Float> list = this.m;
        list.add(list.get(list.size() - 1));
      } else {
        this.m.add(Float.valueOf(b(i1, i9, n, m)));
      } 
    } else if (paramInt1 != -65538) {
      this.m.add(Float.valueOf(b(paramInt1, i9, n, m)));
    } else {
      this.m.add(Float.valueOf(b(i1, i9, n, m)));
    } 
    this.p.add(Integer.valueOf(m));
    this.n.add(Integer.valueOf(i8));
    this.o.add(Integer.valueOf(i2 - (int)f));
    paramInt2 = k;
    if (this.m.size() <= this.i)
      paramInt2 = k + i8; 
    paramInt1 = Math.max(i7, i2);
    if (i1 == -65536) {
      paramInt1 = i;
    } else if (i4 == 0) {
      paramInt1 = paramInt1 + getPaddingLeft() + getPaddingRight();
    } else {
      paramInt1 = Math.min(paramInt1 + getPaddingLeft() + getPaddingRight(), i);
    } 
    k = paramInt2 + getPaddingTop() + getPaddingBottom();
    m = Math.min(this.m.size(), this.i);
    if (this.f == -65536.0F && i3 == 0) {
      f = 0.0F;
    } else {
      f = this.f;
    } 
    if (f == -65536.0F) {
      if (m > 1) {
        this.g = ((j - k) / (m - 1));
      } else {
        this.g = 0.0F;
      } 
      paramInt2 = j;
    } else {
      this.g = f;
      paramInt2 = k;
      if (m > 1) {
        paramInt2 = (int)(k + this.g * (m - 1));
        if (i3 != 0)
          paramInt2 = Math.min(paramInt2, j); 
      } 
    } 
    this.l = paramInt2;
    if (i4 == 1073741824)
      paramInt1 = i; 
    if (i3 == 1073741824)
      paramInt2 = j; 
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setChildSpacing(int paramInt) {
    this.c = paramInt;
    requestLayout();
  }
  
  public void setChildSpacingForLastRow(int paramInt) {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setFlow(boolean paramBoolean) {
    this.b = paramBoolean;
    requestLayout();
  }
  
  public void setGravity(int paramInt) {
    if (this.j != paramInt) {
      this.j = paramInt;
      requestLayout();
    } 
  }
  
  public void setMaxRows(int paramInt) {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setMinChildSpacing(int paramInt) {
    this.d = paramInt;
    requestLayout();
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener) {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      getChildAt(i).setOnClickListener(new View.OnClickListener(this, paramOnItemClickListener, i) {
            public void onClick(View param1View) {
              this.a.a(param1View, this.b);
            }
          });
    } 
  }
  
  public void setRowSpacing(float paramFloat) {
    this.f = paramFloat;
    requestLayout();
  }
  
  public void setRowVerticalGravity(int paramInt) {
    if (this.k != paramInt) {
      this.k = paramInt;
      requestLayout();
    } 
  }
  
  public void setRtl(boolean paramBoolean) {
    this.h = paramBoolean;
    requestLayout();
  }
  
  public static interface OnItemClickListener {
    void a(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\FlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */