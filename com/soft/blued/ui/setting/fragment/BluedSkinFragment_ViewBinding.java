package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class BluedSkinFragment_ViewBinding implements Unbinder {
  private BluedSkinFragment b;
  
  public BluedSkinFragment_ViewBinding(BluedSkinFragment paramBluedSkinFragment, View paramView) {
    this.b = paramBluedSkinFragment;
    paramBluedSkinFragment.llTitle = (CommonTopTitleNoTrans)Utils.a(paramView, 2131299102, "field 'llTitle'", CommonTopTitleNoTrans.class);
    paramBluedSkinFragment.tbSkin = (ToggleButton)Utils.a(paramView, 2131300196, "field 'tbSkin'", ToggleButton.class);
    paramBluedSkinFragment.llSystem = (RelativeLayout)Utils.a(paramView, 2131299090, "field 'llSystem'", RelativeLayout.class);
    paramBluedSkinFragment.llCustom = (TextView)Utils.a(paramView, 2131298766, "field 'llCustom'", TextView.class);
    paramBluedSkinFragment.tvNomarl = (CheckedTextView)Utils.a(paramView, 2131301119, "field 'tvNomarl'", CheckedTextView.class);
    paramBluedSkinFragment.tvDark = (CheckedTextView)Utils.a(paramView, 2131300696, "field 'tvDark'", CheckedTextView.class);
  }
  
  public void unbind() {
    BluedSkinFragment bluedSkinFragment = this.b;
    if (bluedSkinFragment != null) {
      this.b = null;
      bluedSkinFragment.llTitle = null;
      bluedSkinFragment.tbSkin = null;
      bluedSkinFragment.llSystem = null;
      bluedSkinFragment.llCustom = null;
      bluedSkinFragment.tvNomarl = null;
      bluedSkinFragment.tvDark = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\BluedSkinFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */