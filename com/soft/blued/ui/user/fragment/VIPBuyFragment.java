package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.PageTabLayout;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.user.model.VIPBuyTipsModel;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import com.soft.blued.ui.user.observer.VIPBuyOnBackPressedObserver;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.views.PopSVIPBuyTipsView;
import com.soft.blued.ui.user.views.PopVIPBuyTipsView;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.io.Serializable;
import java.util.List;

public class VIPBuyFragment extends BaseFragment implements VIPBuyOnBackPressedObserver.IVIPBuyOnBackPressedObserver, VIPBuyResultObserver.IVIPBuyResultObserver {
  public Context d;
  
  public View e;
  
  String[] f = null;
  
  private CommonTopTitleNoTrans g;
  
  private ShapeTextView h;
  
  private PageTabLayout i;
  
  private ViewPager j;
  
  private VIPBuyOptionListFragment k;
  
  private VIPBuyOptionListFragment l;
  
  private int m;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private boolean q = false;
  
  private int r;
  
  private int s;
  
  private VipProtos.FromType t;
  
  private int u;
  
  private List<VIPPrivilegeModel> v;
  
  private PopVIPBuyTipsView w;
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, VipProtos.FromType paramFromType, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", paramInt1);
    bundle.putString("KEY_VIP_DETAIL", paramString);
    bundle.putBoolean("KEY_IF_SHOW_COUPON", paramBoolean);
    bundle.putInt("KEY_RIGHT_ID", paramInt2);
    bundle.putSerializable("KEY_VIP_FROM_TYPE", (Serializable)paramFromType);
    TerminalActivity.d(paramContext, VIPBuyFragment.class, bundle);
  }
  
  private void b(int paramInt) {
    ((TextView)this.i.a(paramInt).a().findViewById(2131300723)).setVisibility(0);
  }
  
  private void c(int paramInt) {
    ((TextView)this.i.a(paramInt).a().findViewById(2131300723)).setVisibility(8);
  }
  
  private void l() {
    this.f = new String[] { this.d.getResources().getString(2131758972), this.d.getResources().getString(2131759236) };
  }
  
  private boolean m() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("openIntercept:");
    stringBuilder.append(this.u);
    Log.v("drb", stringBuilder.toString());
    if (this.u == 1) {
      if (this.r == 1) {
        this.w = new PopVIPBuyTipsView(this, this.v, 1);
        this.w.c();
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_SHOW, 1);
        return true;
      } 
      this.w = (PopVIPBuyTipsView)new PopSVIPBuyTipsView(this, this.v, 2);
      this.w.c();
      EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_SHOW, 2);
      return true;
    } 
    return false;
  }
  
  public boolean V_() {
    if (m())
      return true; 
    PopVIPBuyTipsView popVIPBuyTipsView = this.w;
    if (popVIPBuyTipsView != null && popVIPBuyTipsView.b()) {
      this.w.d();
      return true;
    } 
    getActivity().finish();
    return super.V_();
  }
  
  public void a() {
    this.g = (CommonTopTitleNoTrans)this.e.findViewById(2131300273);
    this.g.setLeftClickListener(new -$$Lambda$VIPBuyFragment$3ZfMnGEhnpTdpE_BWvPL-E8mIC4(this));
    this.g.a();
    this.g.setCenterText(2131759289);
    this.i = (PageTabLayout)this.e.findViewById(2131300168);
    this.h = (ShapeTextView)this.e.findViewById(2131300167);
    ShapeHelper.b((ShapeHelper.ShapeView)this.h, 2131100733);
    this.j = (ViewPager)this.e.findViewById(2131301731);
    this.k = new VIPBuyOptionListFragment();
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", 1);
    bundle.putString("KEY_TARGET_UID", this.n);
    bundle.putString("KEY_ACTIVITY_ID", this.o);
    bundle.putString("KEY_VIP_DETAIL", this.p);
    bundle.putInt("KEY_RIGHT_ID", this.s);
    bundle.putBoolean("KEY_IF_SHOW_COUPON", this.q);
    bundle.putSerializable("KEY_VIP_FROM_TYPE", (Serializable)this.t);
    this.k.setArguments(bundle);
    this.l = new VIPBuyOptionListFragment();
    bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", 2);
    bundle.putString("KEY_TARGET_UID", this.n);
    bundle.putString("KEY_ACTIVITY_ID", this.o);
    bundle.putString("KEY_VIP_DETAIL", this.p);
    bundle.putInt("KEY_RIGHT_ID", this.s);
    bundle.putBoolean("KEY_IF_SHOW_COUPON", this.q);
    bundle.putSerializable("KEY_VIP_FROM_TYPE", (Serializable)this.t);
    this.l.setArguments(bundle);
    MyAdapter myAdapter = new MyAdapter(this, getChildFragmentManager());
    this.j.setAdapter((PagerAdapter)myAdapter);
    this.i.setupWithViewPager(this.j);
    this.j.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            VIPBuyFragment.a(this.a, param1Int);
            if (param1Int == 0) {
              VIPBuyFragment.b(this.a, param1Int);
              BluedPreferences.cF();
            } 
            this.a.k();
          }
        });
    for (int i = 0; i < this.f.length; i++) {
      View view = LayoutInflater.from(this.d).inflate(2131493658, null);
      ShapeTextView shapeTextView = (ShapeTextView)view.findViewById(2131301409);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131100838);
      shapeTextView.setText(this.f[i]);
      this.i.a(i).a(view);
    } 
    if (this.m == 1) {
      this.j.setCurrentItem(1);
      this.r = 1;
      if (BluedPreferences.cE())
        b(0); 
    } 
    k();
  }
  
  public void a(int paramInt) {
    PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<VIPBuyTipsModel>>(this) {
          protected void a(BluedEntityA<VIPBuyTipsModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              VIPBuyTipsModel vIPBuyTipsModel = param1BluedEntityA.data.get(0);
              if (vIPBuyTipsModel != null) {
                VIPBuyFragment.c(this.a, vIPBuyTipsModel.open_intercept);
                VIPBuyFragment.a(this.a, vIPBuyTipsModel.privilege);
              } 
            } 
          }
        }paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    a(new -$$Lambda$VIPBuyFragment$ZruKwCwlsvQHVbtBx0feC31cPNE(this, paramBoolean), 500L);
  }
  
  public void k() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("check:");
    stringBuilder.append((UserInfo.a().i()).vip_grade);
    Log.v("drb", stringBuilder.toString());
    if ((UserInfo.a().i()).vip_grade == 0) {
      if (this.r == 1) {
        a(0);
        return;
      } 
      a(1);
      return;
    } 
    if ((UserInfo.a().i()).vip_grade == 1) {
      if (this.r == 1) {
        this.u = 0;
        return;
      } 
      a(1);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493355, paramViewGroup, false);
      if (getArguments() != null) {
        this.m = getArguments().getInt("KEY_VIP_GRADE");
        this.n = getArguments().getString("KEY_TARGET_UID");
        this.o = getArguments().getString("KEY_ACTIVITY_ID");
        this.p = getArguments().getString("KEY_VIP_DETAIL");
        this.q = getArguments().getBoolean("KEY_IF_SHOW_COUPON");
        this.s = getArguments().getInt("KEY_RIGHT_ID");
        this.t = (VipProtos.FromType)getArguments().getSerializable("KEY_VIP_FROM_TYPE");
      } 
      l();
      a();
      VIPBuyResultObserver.a().a(this, getLifecycle());
      VIPBuyOnBackPressedObserver.a().a(this, getLifecycle());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(VIPBuyFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return 2;
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? ((param1Int != 1) ? null : VIPBuyFragment.b(this.a)) : VIPBuyFragment.a(this.a));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return (param1Int < this.a.f.length) ? this.a.f[param1Int] : this.a.f[this.a.f.length - 1];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPBuyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */