package com.soft.blued.ui.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.H5Url;
import com.soft.blued.ui.pay.adapter.CouponListAdapter;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.ui.pay.presenter.CouponPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class CouponFragment extends MvpFragment<CouponPresenter> {
  public static String e = "COUPON_RESULT";
  
  @BindView(2131298136)
  RecyclerView couponListView;
  
  public Context d;
  
  private CouponListAdapter f;
  
  @BindView(2131299389)
  NoDataAndLoadFailView noDataAndLoadFailView;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131301466)
  ShapeTextView tvUseBtn;
  
  private void a(int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    BluedCoupon bluedCoupon = this.f.a();
    boolean bool = false;
    if (bluedCoupon != null) {
      hashMap.put("id", String.valueOf((this.f.a()).id));
      hashMap.put("money", Double.valueOf((this.f.a()).money));
    } else {
      hashMap.put("id", "");
      hashMap.put("money", Integer.valueOf(0));
    } 
    if (paramInt == -1)
      bool = true; 
    hashMap.put("is_confirm", Integer.valueOf(bool));
    Intent intent = new Intent();
    intent.putExtra("_flutter_result_", hashMap);
    intent.putExtra(e, (Serializable)this.f.a());
    if (getActivity() != null) {
      getActivity().setResult(paramInt, intent);
      getActivity().finish();
    } 
  }
  
  public static void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 <= 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("choosed id,coupon:");
    stringBuilder.append(paramInt3);
    stringBuilder.append(",goodid:");
    stringBuilder.append(paramInt2);
    Logger.a("coupon", stringBuilder.toString());
    Bundle bundle = new Bundle();
    bundle.putInt(CouponPresenter.j, paramInt2);
    bundle.putInt(CouponPresenter.l, paramInt3);
    TerminalActivity.a(paramFragment, CouponFragment.class, bundle, paramInt1);
  }
  
  public boolean V_() {
    a(0);
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (Context)getActivity();
    this.f = new CouponListAdapter(this.d, this.tvUseBtn);
    this.f.a(new -$$Lambda$CouponFragment$eWEk1B59iERlCTjUSr9JzoO5N84(this));
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setOrientation(1);
    this.couponListView.setAdapter((RecyclerView.Adapter)this.f);
    this.couponListView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.title.setLeftClickListener(new -$$Lambda$CouponFragment$LsRemuzxNVl648wgUMnLxsrNvJI(this));
    this.title.setRightText(this.d.getResources().getString(2131759158));
    this.title.setRightClickListener(new -$$Lambda$CouponFragment$sYwmufLfxaiIGhfnow9-awx8iic(this));
    this.tvUseBtn.setOnClickListener(new -$$Lambda$CouponFragment$1cjmzWap0zCsI5qYNGjkdOyL0SI(this));
    this.noDataAndLoadFailView.setNoDataImg(2131232634);
    this.noDataAndLoadFailView.setNoDataStr(2131758224);
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
    if (paramList == null || paramList.size() == 0) {
      this.noDataAndLoadFailView.setVisibility(0);
      this.couponListView.setVisibility(8);
      CouponListAdapter.a(this.d, this.tvUseBtn, false);
      return;
    } 
    this.noDataAndLoadFailView.setVisibility(8);
    this.couponListView.setVisibility(0);
    this.f.c(paramList);
    Logger.a("coupon", this.f.a());
    if (this.f.a() == null) {
      CouponListAdapter.a(this.d, this.tvUseBtn, false);
      return;
    } 
    CouponListAdapter.a(this.d, this.tvUseBtn, true);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (!paramBoolean && this.f.getItemCount() == 0) {
      this.noDataAndLoadFailView.setVisibility(0);
      this.couponListView.setVisibility(8);
      CouponListAdapter.a(this.d, this.tvUseBtn, false);
    } 
  }
  
  public int p() {
    return 2131493111;
  }
  
  public void x() {
    super.x();
    this.f.c(true);
  }
  
  public void y() {
    super.y();
    this.f.c(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\CouponFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */