package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class NearbyPeopleFragment$MenuHolder_ViewBinding implements Unbinder {
  private NearbyPeopleFragment.MenuHolder b;
  
  public NearbyPeopleFragment$MenuHolder_ViewBinding(NearbyPeopleFragment.MenuHolder paramMenuHolder, View paramView) {
    this.b = paramMenuHolder;
    paramMenuHolder.tvSortMenu = (TextView)Utils.a(paramView, 2131301348, "field 'tvSortMenu'", TextView.class);
    paramMenuHolder.ivSortMenu = (ImageView)Utils.a(paramView, 2131297924, "field 'ivSortMenu'", ImageView.class);
  }
  
  public void unbind() {
    NearbyPeopleFragment.MenuHolder menuHolder = this.b;
    if (menuHolder != null) {
      this.b = null;
      menuHolder.tvSortMenu = null;
      menuHolder.ivSortMenu = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleFragment$MenuHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */