package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;

public class NearbyFeedFragment$NearbyOperateViewHolder_ViewBinding implements Unbinder {
  private NearbyFeedFragment.NearbyOperateViewHolder b;
  
  public NearbyFeedFragment$NearbyOperateViewHolder_ViewBinding(NearbyFeedFragment.NearbyOperateViewHolder paramNearbyOperateViewHolder, View paramView) {
    this.b = paramNearbyOperateViewHolder;
    paramNearbyOperateViewHolder.tvVfCircleTitle = (TextView)Utils.a(paramView, 2131301491, "field 'tvVfCircleTitle'", TextView.class);
    paramNearbyOperateViewHolder.tvRecommend = (TextView)Utils.a(paramView, 2131301238, "field 'tvRecommend'", TextView.class);
    paramNearbyOperateViewHolder.adConstraintLayout = (BluedADConstraintLayout)Utils.a(paramView, 2131296537, "field 'adConstraintLayout'", BluedADConstraintLayout.class);
  }
  
  public void unbind() {
    NearbyFeedFragment.NearbyOperateViewHolder nearbyOperateViewHolder = this.b;
    if (nearbyOperateViewHolder != null) {
      this.b = null;
      nearbyOperateViewHolder.tvVfCircleTitle = null;
      nearbyOperateViewHolder.tvRecommend = null;
      nearbyOperateViewHolder.adConstraintLayout = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyFeedFragment$NearbyOperateViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */