package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

public class TwoLevelHeader extends InternalAbstract implements RefreshHeader {
  protected int a;
  
  protected float b = 0.0F;
  
  protected float c = 2.5F;
  
  protected float d = 1.9F;
  
  protected float e = 1.0F;
  
  protected boolean f = true;
  
  protected boolean g = true;
  
  protected int h = 1000;
  
  protected int i;
  
  protected RefreshHeader j;
  
  protected RefreshKernel k;
  
  protected OnTwoLevelListener l;
  
  public TwoLevelHeader(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TwoLevelHeader(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TwoLevelHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TwoLevelHeader);
    this.c = typedArray.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.c);
    this.d = typedArray.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.d);
    this.e = typedArray.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.e);
    this.h = typedArray.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.h);
    this.f = typedArray.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.f);
    this.g = typedArray.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.g);
    typedArray.recycle();
  }
  
  public TwoLevelHeader a(OnTwoLevelListener paramOnTwoLevelListener) {
    this.l = paramOnTwoLevelListener;
    return this;
  }
  
  public TwoLevelHeader a(RefreshHeader paramRefreshHeader) {
    return a(paramRefreshHeader, -1, -2);
  }
  
  public TwoLevelHeader a(RefreshHeader paramRefreshHeader, int paramInt1, int paramInt2) {
    if (paramRefreshHeader != null) {
      RefreshHeader refreshHeader = this.j;
      if (refreshHeader != null)
        removeView(refreshHeader.getView()); 
      if (paramRefreshHeader.getSpinnerStyle() == SpinnerStyle.c) {
        addView(paramRefreshHeader.getView(), 0, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt1, paramInt2));
      } else {
        addView(paramRefreshHeader.getView(), paramInt1, paramInt2);
      } 
      this.j = paramRefreshHeader;
      this.x = (RefreshInternal)paramRefreshHeader;
    } 
    return this;
  }
  
  public TwoLevelHeader a(boolean paramBoolean) {
    this.f = paramBoolean;
    return this;
  }
  
  protected void a(int paramInt) {
    RefreshHeader refreshHeader = this.j;
    if (this.a != paramInt && refreshHeader != null) {
      View view;
      this.a = paramInt;
      int i = null.b[refreshHeader.getSpinnerStyle().ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        view = refreshHeader.getView();
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, paramInt));
        return;
      } 
      view.getView().setTranslationY(paramInt);
    } 
  }
  
  public void a(RefreshKernel paramRefreshKernel, int paramInt1, int paramInt2) {
    RefreshHeader refreshHeader = this.j;
    if (refreshHeader == null)
      return; 
    if ((paramInt2 + paramInt1) * 1.0F / paramInt1 != this.c && this.i == 0) {
      this.i = paramInt1;
      this.j = null;
      paramRefreshKernel.a().e(this.c);
      this.j = refreshHeader;
    } 
    if (this.k == null && refreshHeader.getSpinnerStyle() == SpinnerStyle.a && !isInEditMode()) {
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)refreshHeader.getView().getLayoutParams();
      marginLayoutParams.topMargin -= paramInt1;
      refreshHeader.getView().setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    } 
    this.i = paramInt1;
    this.k = paramRefreshKernel;
    paramRefreshKernel.b(this.h);
    paramRefreshKernel.a((RefreshInternal)this, this.g ^ true);
    refreshHeader.a(paramRefreshKernel, paramInt1, paramInt2);
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    RefreshHeader refreshHeader = this.j;
    if (refreshHeader != null) {
      refreshHeader.a(paramRefreshLayout, paramRefreshState1, paramRefreshState2);
      int i = null.a[paramRefreshState2.ordinal()];
      boolean bool = true;
      if (i != 1) {
        if (i != 2)
          if (i != 3) {
            if (i != 4)
              return; 
            if (refreshHeader.getView().getAlpha() == 0.0F && refreshHeader.getView() != this) {
              refreshHeader.getView().setAlpha(1.0F);
              return;
            } 
          } else if (refreshHeader.getView() != this) {
            refreshHeader.getView().animate().alpha(1.0F).setDuration((this.h / 2));
            return;
          }  
      } else {
        if (refreshHeader.getView() != this)
          refreshHeader.getView().animate().alpha(0.0F).setDuration((this.h / 2)); 
        RefreshKernel refreshKernel = this.k;
        if (refreshKernel != null) {
          OnTwoLevelListener onTwoLevelListener = this.l;
          boolean bool1 = bool;
          if (onTwoLevelListener != null)
            if (onTwoLevelListener.a(paramRefreshLayout)) {
              bool1 = bool;
            } else {
              bool1 = false;
            }  
          refreshKernel.a(bool1);
        } 
      } 
    } 
  }
  
  public void a(boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3) {
    a(paramInt1);
    RefreshHeader refreshHeader = this.j;
    RefreshKernel refreshKernel = this.k;
    if (refreshHeader != null)
      refreshHeader.a(paramBoolean, paramFloat, paramInt1, paramInt2, paramInt3); 
    if (paramBoolean) {
      float f1 = this.b;
      float f2 = this.d;
      if (f1 < f2 && paramFloat >= f2 && this.f) {
        refreshKernel.a(RefreshState.h);
      } else if (this.b >= this.d && paramFloat < this.e) {
        refreshKernel.a(RefreshState.b);
      } else {
        f1 = this.b;
        f2 = this.d;
        if (f1 >= f2 && paramFloat < f2)
          refreshKernel.a(RefreshState.f); 
      } 
      this.b = paramFloat;
    } 
  }
  
  public TwoLevelHeader b(int paramInt) {
    this.h = paramInt;
    return this;
  }
  
  public boolean equals(Object paramObject) {
    RefreshHeader refreshHeader = this.j;
    return ((refreshHeader != null && refreshHeader.equals(paramObject)) || super.equals(paramObject));
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.w = SpinnerStyle.e;
    if (this.j == null)
      a(new ClassicsHeader(getContext())); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.w = SpinnerStyle.c;
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view instanceof RefreshHeader) {
        this.j = (RefreshHeader)view;
        this.x = (RefreshInternal)view;
        bringChildToFront(view);
        break;
      } 
    } 
    if (this.j == null)
      a(new ClassicsHeader(getContext())); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    RefreshHeader refreshHeader = this.j;
    if (refreshHeader != null) {
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE) {
        refreshHeader.getView().measure(paramInt1, paramInt2);
        paramInt2 = refreshHeader.getView().getMeasuredHeight();
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), paramInt1), paramInt2);
        return;
      } 
      super.onMeasure(paramInt1, paramInt2);
      return;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\header\TwoLevelHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */