package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

public abstract class InternalAbstract extends RelativeLayout implements RefreshInternal {
  protected View v;
  
  protected SpinnerStyle w;
  
  protected RefreshInternal x;
  
  public InternalAbstract(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public InternalAbstract(View paramView) {
    this(paramView, refreshInternal);
  }
  
  protected InternalAbstract(View paramView, RefreshInternal paramRefreshInternal) {
    super(paramView.getContext(), null, 0);
    this.v = paramView;
    this.x = paramRefreshInternal;
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    RefreshInternal refreshInternal = this.x;
    return (refreshInternal != null && refreshInternal != this) ? refreshInternal.a(paramRefreshLayout, paramBoolean) : 0;
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2) {
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this)
      refreshInternal.a(paramFloat, paramInt1, paramInt2); 
  }
  
  public void a(RefreshKernel paramRefreshKernel, int paramInt1, int paramInt2) {
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this) {
      refreshInternal.a(paramRefreshKernel, paramInt1, paramInt2);
      return;
    } 
    View view = this.v;
    if (view != null) {
      ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
      if (layoutParams instanceof SmartRefreshLayout.LayoutParams)
        paramRefreshKernel.a(this, ((SmartRefreshLayout.LayoutParams)layoutParams).a); 
    } 
  }
  
  public void a(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this)
      refreshInternal.a(paramRefreshLayout, paramInt1, paramInt2); 
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this) {
      RefreshState refreshState1;
      RefreshState refreshState2;
      if (this instanceof com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper && refreshInternal instanceof com.scwang.smartrefresh.layout.api.RefreshHeader) {
        RefreshState refreshState = paramRefreshState1;
        if (paramRefreshState1.s)
          refreshState = paramRefreshState1.b(); 
        refreshState1 = refreshState;
        refreshState2 = paramRefreshState2;
        if (paramRefreshState2.s) {
          refreshState2 = paramRefreshState2.b();
          refreshState1 = refreshState;
        } 
      } else {
        refreshState1 = paramRefreshState1;
        refreshState2 = paramRefreshState2;
        if (this instanceof com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper) {
          refreshState1 = paramRefreshState1;
          refreshState2 = paramRefreshState2;
          if (this.x instanceof com.scwang.smartrefresh.layout.api.RefreshFooter) {
            RefreshState refreshState = paramRefreshState1;
            if (paramRefreshState1.r)
              refreshState = paramRefreshState1.a(); 
            refreshState1 = refreshState;
            refreshState2 = paramRefreshState2;
            if (paramRefreshState2.r) {
              refreshState2 = paramRefreshState2.a();
              refreshState1 = refreshState;
            } 
          } 
        } 
      } 
      this.x.a(paramRefreshLayout, refreshState1, refreshState2);
    } 
  }
  
  public void a(boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3) {
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this)
      refreshInternal.a(paramBoolean, paramFloat, paramInt1, paramInt2, paramInt3); 
  }
  
  public boolean a() {
    RefreshInternal refreshInternal = this.x;
    return (refreshInternal != null && refreshInternal != this && refreshInternal.a());
  }
  
  public void b(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this)
      refreshInternal.b(paramRefreshLayout, paramInt1, paramInt2); 
  }
  
  public boolean equals(Object paramObject) {
    return !super.equals(paramObject) ? ((paramObject instanceof RefreshInternal) ? ((super.getView() == ((RefreshInternal)paramObject).getView())) : false) : true;
  }
  
  public SpinnerStyle getSpinnerStyle() {
    SpinnerStyle spinnerStyle2 = this.w;
    if (spinnerStyle2 != null)
      return spinnerStyle2; 
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this)
      return refreshInternal.getSpinnerStyle(); 
    View view = this.v;
    if (view != null) {
      ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
      if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
        this.w = ((SmartRefreshLayout.LayoutParams)layoutParams).b;
        SpinnerStyle spinnerStyle = this.w;
        if (spinnerStyle != null)
          return spinnerStyle; 
      } 
      if (layoutParams != null && (layoutParams.height == 0 || layoutParams.height == -1)) {
        SpinnerStyle spinnerStyle = SpinnerStyle.b;
        this.w = spinnerStyle;
        return spinnerStyle;
      } 
    } 
    SpinnerStyle spinnerStyle1 = SpinnerStyle.a;
    this.w = spinnerStyle1;
    return spinnerStyle1;
  }
  
  public View getView() {
    InternalAbstract internalAbstract;
    View view2 = this.v;
    View view1 = view2;
    if (view2 == null)
      internalAbstract = this; 
    return (View)internalAbstract;
  }
  
  @Deprecated
  public void setPrimaryColors(int... paramVarArgs) {
    RefreshInternal refreshInternal = this.x;
    if (refreshInternal != null && refreshInternal != this)
      refreshInternal.setPrimaryColors(paramVarArgs); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\internal\InternalAbstract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */