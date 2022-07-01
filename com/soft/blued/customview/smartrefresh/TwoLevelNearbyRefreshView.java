package com.soft.blued.customview.smartrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;

public class TwoLevelNearbyRefreshView extends TwoLevelRefreshView {
  public TwoLevelNearbyRefreshView(Context paramContext) {
    super(paramContext);
  }
  
  public TwoLevelNearbyRefreshView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public TwoLevelNearbyRefreshView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    int i = null.a[paramRefreshState2.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          this.c.setText(2131758478);
          return;
        } 
        if (this.e) {
          this.c.setText(2131758198);
          return;
        } 
        this.c.setText(2131758479);
        return;
      } 
      if (this.e) {
        this.c.setText(2131758198);
        return;
      } 
      this.c.setText(2131758476);
      return;
    } 
    if (this.b != null) {
      this.b.setFrame(0);
      this.b.setProgress(0.0F);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\smartrefresh\TwoLevelNearbyRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */