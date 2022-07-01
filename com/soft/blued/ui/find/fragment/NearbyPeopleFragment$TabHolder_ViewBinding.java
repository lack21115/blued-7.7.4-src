package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;

public class NearbyPeopleFragment$TabHolder_ViewBinding implements Unbinder {
  private NearbyPeopleFragment.TabHolder b;
  
  public NearbyPeopleFragment$TabHolder_ViewBinding(NearbyPeopleFragment.TabHolder paramTabHolder, View paramView) {
    this.b = paramTabHolder;
    paramTabHolder.layoutSortTab = (ShapeLinearLayout)Utils.a(paramView, 2131298094, "field 'layoutSortTab'", ShapeLinearLayout.class);
    paramTabHolder.tvSortTab = (ShapeTextView)Utils.a(paramView, 2131301348, "field 'tvSortTab'", ShapeTextView.class);
    paramTabHolder.ivSortTab = (ImageView)Utils.a(paramView, 2131297924, "field 'ivSortTab'", ImageView.class);
    paramTabHolder.tvDivider = (TextView)Utils.a(paramView, 2131300720, "field 'tvDivider'", TextView.class);
  }
  
  public void unbind() {
    NearbyPeopleFragment.TabHolder tabHolder = this.b;
    if (tabHolder != null) {
      this.b = null;
      tabHolder.layoutSortTab = null;
      tabHolder.tvSortTab = null;
      tabHolder.ivSortTab = null;
      tabHolder.tvDivider = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleFragment$TabHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */