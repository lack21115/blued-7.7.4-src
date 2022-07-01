package com.soft.blued.customview.smartrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

public class BluedLoadMoreView extends InternalClassics implements RefreshFooter {
  protected boolean a = false;
  
  private View b;
  
  private View c;
  
  private View d;
  
  public BluedLoadMoreView(Context paramContext) {
    this(paramContext, null);
  }
  
  public BluedLoadMoreView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BluedLoadMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    View view = LayoutInflater.from(paramContext).inflate(2131493767, (ViewGroup)this);
    this.b = view.findViewById(2131299154);
    this.c = view.findViewById(2131299153);
    this.d = view.findViewById(2131299152);
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    if (!this.a) {
      if (paramBoolean) {
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
      } else {
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        this.d.setVisibility(8);
      } 
      return super.a(paramRefreshLayout, paramBoolean);
    } 
    return 0;
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    if (!this.a) {
      switch (null.a[paramRefreshState2.ordinal()]) {
        default:
          return;
        case 6:
          this.b.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          return;
        case 5:
          this.b.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          return;
        case 3:
        case 4:
          this.b.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          return;
        case 1:
          this.b.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          break;
        case 2:
          break;
      } 
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
    } 
  }
  
  public boolean a(boolean paramBoolean) {
    if (this.a != paramBoolean) {
      this.a = paramBoolean;
      if (paramBoolean) {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
      } else {
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
      } 
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\smartrefresh\BluedLoadMoreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */