package com.soft.blued.ui.msg.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.soft.blued.customview.CirclePageIndicator;

public class UserGiftFragment_ViewBinding implements Unbinder {
  private UserGiftFragment b;
  
  public UserGiftFragment_ViewBinding(UserGiftFragment paramUserGiftFragment, View paramView) {
    this.b = paramUserGiftFragment;
    paramUserGiftFragment.circlePageIndicator = (CirclePageIndicator)Utils.a(paramView, 2131297592, "field 'circlePageIndicator'", CirclePageIndicator.class);
    paramUserGiftFragment.gift_pager = (ViewPager)Utils.a(paramView, 2131297250, "field 'gift_pager'", ViewPager.class);
    paramUserGiftFragment.rl_pay_type = (ShapeRelativeLayout)Utils.a(paramView, 2131299723, "field 'rl_pay_type'", ShapeRelativeLayout.class);
    paramUserGiftFragment.stv_buy = (TextView)Utils.a(paramView, 2131300055, "field 'stv_buy'", TextView.class);
    paramUserGiftFragment.tv_pay_type = (TextView)Utils.a(paramView, 2131301165, "field 'tv_pay_type'", TextView.class);
    paramUserGiftFragment.ll_stock_tip = (LinearLayout)Utils.a(paramView, 2131299087, "field 'll_stock_tip'", LinearLayout.class);
    paramUserGiftFragment.rl_voucher = (ShapeRelativeLayout)Utils.a(paramView, 2131299739, "field 'rl_voucher'", ShapeRelativeLayout.class);
    paramUserGiftFragment.tv_voucher = (TextView)Utils.a(paramView, 2131301514, "field 'tv_voucher'", TextView.class);
    paramUserGiftFragment.tv_voucher_title = (TextView)Utils.a(paramView, 2131301515, "field 'tv_voucher_title'", TextView.class);
    paramUserGiftFragment.tv_pay_title = (TextView)Utils.a(paramView, 2131301164, "field 'tv_pay_title'", TextView.class);
    paramUserGiftFragment.voucher_line = Utils.a(paramView, 2131301722, "field 'voucher_line'");
  }
  
  public void unbind() {
    UserGiftFragment userGiftFragment = this.b;
    if (userGiftFragment != null) {
      this.b = null;
      userGiftFragment.circlePageIndicator = null;
      userGiftFragment.gift_pager = null;
      userGiftFragment.rl_pay_type = null;
      userGiftFragment.stv_buy = null;
      userGiftFragment.tv_pay_type = null;
      userGiftFragment.ll_stock_tip = null;
      userGiftFragment.rl_voucher = null;
      userGiftFragment.tv_voucher = null;
      userGiftFragment.tv_voucher_title = null;
      userGiftFragment.tv_pay_title = null;
      userGiftFragment.voucher_line = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\UserGiftFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */