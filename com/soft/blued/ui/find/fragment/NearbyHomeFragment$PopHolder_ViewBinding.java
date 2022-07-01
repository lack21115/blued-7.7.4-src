package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class NearbyHomeFragment$PopHolder_ViewBinding implements Unbinder {
  private NearbyHomeFragment.PopHolder b;
  
  public NearbyHomeFragment$PopHolder_ViewBinding(NearbyHomeFragment.PopHolder paramPopHolder, View paramView) {
    this.b = paramPopHolder;
    paramPopHolder.llFilter = (LinearLayout)Utils.a(paramView, 2131298803, "field 'llFilter'", LinearLayout.class);
    paramPopHolder.ivFilterDot = Utils.a(paramView, 2131297769, "field 'ivFilterDot'");
    paramPopHolder.ivFilterMode = (ImageView)Utils.a(paramView, 2131297770, "field 'ivFilterMode'", ImageView.class);
    paramPopHolder.tvFilterMode = (TextView)Utils.a(paramView, 2131300769, "field 'tvFilterMode'", TextView.class);
    paramPopHolder.llMap = (LinearLayout)Utils.a(paramView, 2131298943, "field 'llMap'", LinearLayout.class);
    paramPopHolder.llSearch = (LinearLayout)Utils.a(paramView, 2131299070, "field 'llSearch'", LinearLayout.class);
    paramPopHolder.llList = (LinearLayout)Utils.a(paramView, 2131298915, "field 'llList'", LinearLayout.class);
    paramPopHolder.ivListMode = (ImageView)Utils.a(paramView, 2131297830, "field 'ivListMode'", ImageView.class);
    paramPopHolder.tvListMode = (TextView)Utils.a(paramView, 2131300967, "field 'tvListMode'", TextView.class);
    paramPopHolder.llCustomInvisible = (LinearLayout)Utils.a(paramView, 2131298767, "field 'llCustomInvisible'", LinearLayout.class);
    paramPopHolder.tvCustomInvisible = (TextView)Utils.a(paramView, 2131300686, "field 'tvCustomInvisible'", TextView.class);
  }
  
  public void unbind() {
    NearbyHomeFragment.PopHolder popHolder = this.b;
    if (popHolder != null) {
      this.b = null;
      popHolder.llFilter = null;
      popHolder.ivFilterDot = null;
      popHolder.ivFilterMode = null;
      popHolder.tvFilterMode = null;
      popHolder.llMap = null;
      popHolder.llSearch = null;
      popHolder.llList = null;
      popHolder.ivListMode = null;
      popHolder.tvListMode = null;
      popHolder.llCustomInvisible = null;
      popHolder.tvCustomInvisible = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyHomeFragment$PopHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */