package com.soft.blued.ui.pay.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.vip.VipProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.customview.VerticalDashView;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CouponListAdapter extends BaseQuickAdapter<BluedCoupon, BaseViewHolder> {
  public ShapeTextView a;
  
  public CouponListAdapter(Context paramContext, ShapeTextView paramShapeTextView) {
    super(2131493492, new ArrayList());
    this.k = paramContext;
    this.a = paramShapeTextView;
  }
  
  public static void a(Context paramContext, ShapeTextView paramShapeTextView, boolean paramBoolean) {
    if (!paramBoolean) {
      paramShapeTextView.setEnabled(false);
      ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100807);
      return;
    } 
    paramShapeTextView.setEnabled(true);
    ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100788);
  }
  
  private void a(CouponViewHolder paramCouponViewHolder, BluedCoupon paramBluedCoupon) {
    c(paramCouponViewHolder, paramBluedCoupon);
    CouponViewHolder.b(paramCouponViewHolder).setBackground(this.k.getResources().getDrawable(2131231069));
    CouponViewHolder.c(paramCouponViewHolder).setDashColor(2131100842);
    CouponViewHolder.d(paramCouponViewHolder).setBackground(this.k.getResources().getDrawable(2131231071));
    CouponViewHolder.e(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100842));
    CouponViewHolder.f(paramCouponViewHolder).setImageResource(2131232695);
    CouponViewHolder.g(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100842));
    CouponViewHolder.h(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100842));
    CouponViewHolder.i(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100842));
    CouponViewHolder.j(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100842));
    CouponViewHolder.k(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100842));
    CouponViewHolder.l(paramCouponViewHolder).setVisibility(0);
    CouponViewHolder.m(paramCouponViewHolder).setVisibility(8);
    CouponViewHolder.n(paramCouponViewHolder).setVisibility(0);
    int i = paramBluedCoupon.type;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 9) {
            CouponViewHolder.n(paramCouponViewHolder).setVisibility(8);
            return;
          } 
          CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232510);
          return;
        } 
        CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232766);
        return;
      } 
      CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232734);
      return;
    } 
    CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232823);
  }
  
  private void b(CouponViewHolder paramCouponViewHolder, BluedCoupon paramBluedCoupon) {
    c(paramCouponViewHolder, paramBluedCoupon);
    CouponViewHolder.m(paramCouponViewHolder).setVisibility(0);
    if (paramBluedCoupon.ifChoosed) {
      CouponViewHolder.b(paramCouponViewHolder).setBackground(this.k.getResources().getDrawable(2131231070));
      CouponViewHolder.c(paramCouponViewHolder).setDashColor("#84BDFF");
      CouponViewHolder.d(paramCouponViewHolder).setBackground(this.k.getResources().getDrawable(2131231072));
      CouponViewHolder.m(paramCouponViewHolder).setImageResource(2131232456);
    } else {
      CouponViewHolder.b(paramCouponViewHolder).setBackground(this.k.getResources().getDrawable(2131231069));
      if (paramBluedCoupon.is_available == 1) {
        CouponViewHolder.c(paramCouponViewHolder).setDashColor(2131100842);
      } else {
        CouponViewHolder.c(paramCouponViewHolder).setDashColor(2131100881);
      } 
      CouponViewHolder.d(paramCouponViewHolder).setBackground(this.k.getResources().getDrawable(2131231071));
      CouponViewHolder.m(paramCouponViewHolder).setImageResource(2131232457);
    } 
    CouponViewHolder.e(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100716));
    CouponViewHolder.f(paramCouponViewHolder).setImageResource(2131232694);
    CouponViewHolder.g(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100716));
    CouponViewHolder.h(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100838));
    CouponViewHolder.i(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100838));
    CouponViewHolder.j(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100838));
    CouponViewHolder.k(paramCouponViewHolder).setTextColor(this.k.getResources().getColor(2131100838));
    CouponViewHolder.l(paramCouponViewHolder).setVisibility(8);
    CouponViewHolder.n(paramCouponViewHolder).setVisibility(0);
    int i = paramBluedCoupon.type;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 9) {
            CouponViewHolder.n(paramCouponViewHolder).setVisibility(8);
          } else {
            CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232509);
          } 
        } else {
          CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232389);
        } 
      } else {
        CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232731);
      } 
    } else {
      CouponViewHolder.n(paramCouponViewHolder).setImageResource(2131232812);
    } 
    CouponViewHolder.a(paramCouponViewHolder).setOnClickListener(new -$$Lambda$CouponListAdapter$qgD5etONdsgcMUJ0JAsxaZkJiuU(this, paramBluedCoupon));
  }
  
  private void c(CouponViewHolder paramCouponViewHolder, BluedCoupon paramBluedCoupon) {
    long l = Math.round(paramBluedCoupon.money);
    TextView textView = CouponViewHolder.e(paramCouponViewHolder);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    if (l >= 100L) {
      CouponViewHolder.e(paramCouponViewHolder).setTextSize(28.0F);
    } else {
      CouponViewHolder.e(paramCouponViewHolder).setTextSize(36.0F);
    } 
    CouponViewHolder.g(paramCouponViewHolder).setText(paramBluedCoupon.discount_desc);
    CouponViewHolder.h(paramCouponViewHolder).setText(paramBluedCoupon.name);
    textView = CouponViewHolder.j(paramCouponViewHolder);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramBluedCoupon.start_time);
    stringBuilder.append("-");
    stringBuilder.append(paramBluedCoupon.end_time);
    textView.setText(stringBuilder.toString());
    if (!StringUtils.e(paramBluedCoupon.tag)) {
      CouponViewHolder.k(paramCouponViewHolder).setVisibility(0);
      CouponViewHolder.k(paramCouponViewHolder).setText(paramBluedCoupon.tag);
    } else {
      CouponViewHolder.k(paramCouponViewHolder).setVisibility(8);
    } 
    if (!StringUtils.e(paramBluedCoupon.not_available_desc)) {
      CouponViewHolder.o(paramCouponViewHolder).setText(paramBluedCoupon.not_available_desc);
      CouponViewHolder.o(paramCouponViewHolder).setVisibility(0);
      CouponViewHolder.p(paramCouponViewHolder).setVisibility(0);
    } else {
      CouponViewHolder.o(paramCouponViewHolder).setVisibility(8);
      CouponViewHolder.p(paramCouponViewHolder).setVisibility(8);
    } 
    if (paramBluedCoupon.discount_type == 0) {
      CouponViewHolder.q(paramCouponViewHolder).setVisibility(0);
      CouponViewHolder.g(paramCouponViewHolder).setVisibility(8);
      return;
    } 
    CouponViewHolder.q(paramCouponViewHolder).setVisibility(8);
    CouponViewHolder.g(paramCouponViewHolder).setVisibility(0);
  }
  
  public BluedCoupon a() {
    for (int i = 0; i < this.n.size(); i++) {
      if (((BluedCoupon)this.n.get(i)).ifChoosed)
        return this.n.get(i); 
    } 
    return null;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedCoupon paramBluedCoupon) {
    if (paramBaseViewHolder != null) {
      CouponViewHolder couponViewHolder = new CouponViewHolder(this, paramBaseViewHolder);
      if (paramBluedCoupon.is_available == 1) {
        b(couponViewHolder, paramBluedCoupon);
      } else {
        a(couponViewHolder, paramBluedCoupon);
      } 
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)CouponViewHolder.a(couponViewHolder).getLayoutParams();
      if (paramBaseViewHolder.getAdapterPosition() == this.n.size() - 1) {
        layoutParams.bottomMargin = DensityUtils.a(this.k, 85.0F);
      } else {
        layoutParams.bottomMargin = 0;
      } 
      CouponViewHolder.a(couponViewHolder).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      if (!paramBluedCoupon.ifShowUrlVisited) {
        VipProtos.Event event = VipProtos.Event.ORDER_COUPON_SHOW;
        VipProtos.OrderType orderType = EventTrackVIP.c(paramBluedCoupon.type);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramBluedCoupon.id);
        stringBuilder.append("");
        EventTrackVIP.a(event, orderType, stringBuilder.toString());
        paramBluedCoupon.ifShowUrlVisited = true;
      } 
    } 
  }
  
  public void a(Collection<? extends BluedCoupon> paramCollection) {
    super.a(paramCollection);
    notifyDataSetChanged();
  }
  
  public void c(List<BluedCoupon> paramList) {
    super.c(paramList);
    notifyDataSetChanged();
  }
  
  public class CouponViewHolder {
    private ConstraintLayout b;
    
    private FrameLayout c;
    
    private LinearLayout d;
    
    private ConstraintLayout e;
    
    private TextView f;
    
    private ImageView g;
    
    private TextView h;
    
    private TextView i;
    
    private TextView j;
    
    private TextView k;
    
    private ImageView l;
    
    private TextView m;
    
    private VerticalDashView n;
    
    private ImageView o;
    
    private TextView p;
    
    private TextView q;
    
    private ImageView r;
    
    CouponViewHolder(CouponListAdapter this$0, BaseViewHolder param1BaseViewHolder) {
      this.b = (ConstraintLayout)param1BaseViewHolder.d(2131301652);
      this.c = (FrameLayout)param1BaseViewHolder.d(2131301656);
      this.d = (LinearLayout)param1BaseViewHolder.d(2131298955);
      this.e = (ConstraintLayout)param1BaseViewHolder.d(2131301681);
      this.f = (TextView)param1BaseViewHolder.d(2131301088);
      this.g = (ImageView)param1BaseViewHolder.d(2131297462);
      this.h = (TextView)param1BaseViewHolder.d(2131300675);
      this.i = (TextView)param1BaseViewHolder.d(2131300674);
      this.j = (TextView)param1BaseViewHolder.d(2131300677);
      this.k = (TextView)param1BaseViewHolder.d(2131300959);
      this.l = (ImageView)param1BaseViewHolder.d(2131297508);
      this.m = (TextView)param1BaseViewHolder.d(2131300671);
      this.n = (VerticalDashView)param1BaseViewHolder.d(2131301693);
      this.o = (ImageView)param1BaseViewHolder.d(2131297454);
      this.p = (TextView)param1BaseViewHolder.d(2131301046);
      this.q = (TextView)param1BaseViewHolder.d(2131301223);
      this.r = (ImageView)param1BaseViewHolder.d(2131297498);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\adapter\CouponListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */