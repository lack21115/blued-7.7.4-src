package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

public class MusicLoadMoreView extends InternalClassics implements RefreshFooter {
  protected boolean a = false;
  
  private View b;
  
  public MusicLoadMoreView(Context paramContext) {
    this(paramContext, null);
  }
  
  public MusicLoadMoreView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicLoadMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = LayoutInflater.from(paramContext).inflate(R.layout.music_load_more, (ViewGroup)this).findViewById(R.id.load_more_loading_view);
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    if (!this.a) {
      if (paramBoolean) {
        this.b.setVisibility(0);
      } else {
        this.b.setVisibility(8);
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
          return;
        case 5:
          this.b.setVisibility(0);
          return;
        case 3:
        case 4:
          this.b.setVisibility(0);
          return;
        case 1:
          this.b.setVisibility(0);
          break;
        case 2:
          break;
      } 
      this.b.setVisibility(0);
    } 
  }
  
  public boolean a(boolean paramBoolean) {
    if (this.a != paramBoolean) {
      this.a = paramBoolean;
      if (paramBoolean) {
        this.b.setVisibility(8);
      } else {
        this.b.setVisibility(0);
      } 
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\MusicLoadMoreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */