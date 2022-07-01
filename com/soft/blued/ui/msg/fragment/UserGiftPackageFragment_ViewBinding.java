package com.soft.blued.ui.msg.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CirclePageIndicator;

public class UserGiftPackageFragment_ViewBinding implements Unbinder {
  private UserGiftPackageFragment b;
  
  public UserGiftPackageFragment_ViewBinding(UserGiftPackageFragment paramUserGiftPackageFragment, View paramView) {
    this.b = paramUserGiftPackageFragment;
    paramUserGiftPackageFragment.circlePageIndicator = (CirclePageIndicator)Utils.a(paramView, 2131297592, "field 'circlePageIndicator'", CirclePageIndicator.class);
    paramUserGiftPackageFragment.gift_pager = (ViewPager)Utils.a(paramView, 2131297250, "field 'gift_pager'", ViewPager.class);
    paramUserGiftPackageFragment.stv_buy = (TextView)Utils.a(paramView, 2131300055, "field 'stv_buy'", TextView.class);
    paramUserGiftPackageFragment.tv_empty = (TextView)Utils.a(paramView, 2131300730, "field 'tv_empty'", TextView.class);
  }
  
  public void unbind() {
    UserGiftPackageFragment userGiftPackageFragment = this.b;
    if (userGiftPackageFragment != null) {
      this.b = null;
      userGiftPackageFragment.circlePageIndicator = null;
      userGiftPackageFragment.gift_pager = null;
      userGiftPackageFragment.stv_buy = null;
      userGiftPackageFragment.tv_empty = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\UserGiftPackageFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */