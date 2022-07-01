package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class NearbyPeopleFragment$TipHeaderHolder_ViewBinding implements Unbinder {
  private NearbyPeopleFragment.TipHeaderHolder b;
  
  public NearbyPeopleFragment$TipHeaderHolder_ViewBinding(NearbyPeopleFragment.TipHeaderHolder paramTipHeaderHolder, View paramView) {
    this.b = paramTipHeaderHolder;
    paramTipHeaderHolder.imgHeader = (ImageView)Utils.a(paramView, 2131297362, "field 'imgHeader'", ImageView.class);
  }
  
  public void unbind() {
    NearbyPeopleFragment.TipHeaderHolder tipHeaderHolder = this.b;
    if (tipHeaderHolder != null) {
      this.b = null;
      tipHeaderHolder.imgHeader = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleFragment$TipHeaderHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */