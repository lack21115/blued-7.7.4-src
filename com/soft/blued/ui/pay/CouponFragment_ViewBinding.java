package com.soft.blued.ui.pay;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;

public class CouponFragment_ViewBinding implements Unbinder {
  private CouponFragment b;
  
  public CouponFragment_ViewBinding(CouponFragment paramCouponFragment, View paramView) {
    this.b = paramCouponFragment;
    paramCouponFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramCouponFragment.couponListView = (RecyclerView)Utils.a(paramView, 2131298136, "field 'couponListView'", RecyclerView.class);
    paramCouponFragment.tvUseBtn = (ShapeTextView)Utils.a(paramView, 2131301466, "field 'tvUseBtn'", ShapeTextView.class);
    paramCouponFragment.noDataAndLoadFailView = (NoDataAndLoadFailView)Utils.a(paramView, 2131299389, "field 'noDataAndLoadFailView'", NoDataAndLoadFailView.class);
  }
  
  public void unbind() {
    CouponFragment couponFragment = this.b;
    if (couponFragment != null) {
      this.b = null;
      couponFragment.title = null;
      couponFragment.couponListView = null;
      couponFragment.tvUseBtn = null;
      couponFragment.noDataAndLoadFailView = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\CouponFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */