package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.vip.VipProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.ExpandedLinearLayoutManager;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.fragment.AdvertFloatFragment;
import com.soft.blued.ui.find.model.AdvertFloatModel;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.user.adapter.NonVIPRightAdapter;
import com.soft.blued.ui.user.adapter.VIPCenterBannerAdapter;
import com.soft.blued.ui.user.adapter.VIPCenterExpLvlRightAdapter;
import com.soft.blued.ui.user.adapter.VIPRightOptionAdapter;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.user.model.VIPRightOption;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.presenter.VIPCenterTabPageNewPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.FlutterRouter;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VIPCenterTabPageFragment extends MvpFragment<VIPCenterTabPageNewPresenter> implements VIPBuyResultObserver.IVIPBuyResultObserver {
  public Rect d;
  
  public VIPRightOptionAdapter e;
  
  public NonVIPRightAdapter f;
  
  Dialog g;
  
  private Unbinder h;
  
  private Unbinder i;
  
  @BindView(2131297491)
  ImageView imgHeaderBg;
  
  @BindView(2131297583)
  ImageView imgVIPTitle;
  
  private Unbinder j;
  
  @BindView(2131298144)
  RecyclerView listView;
  
  @BindView(2131298736)
  CardView llBuy;
  
  private HeaderViewHolder n = new HeaderViewHolder(this);
  
  private BannerHolder o = new BannerHolder(this);
  
  private BannerHolder p = new BannerHolder(this);
  
  private String q;
  
  private List<Unbinder> r = new ArrayList<Unbinder>();
  
  private Context s;
  
  @BindView(2131299842)
  NestedScrollView scrollView;
  
  private int t;
  
  @BindView(2131299441)
  CommonTopTitleNoTrans title;
  
  @BindView(2131299442)
  CommonTopTitleNoTrans titleHover;
  
  @BindView(2131300598)
  TextView tvBuyBtn;
  
  @BindView(2131301207)
  View tvProtocolExpLvlBtmLine;
  
  private int u;
  
  private boolean v = false;
  
  @BindView(2131301623)
  View viewBtmBanner;
  
  @BindView(2131301705)
  LabeledTextView vipHelpCenter;
  
  @BindView(2131301706)
  LabeledTextView vipOrderRecord;
  
  @BindView(2131301707)
  LabeledTextView vipPrivacyClause;
  
  @BindView(2131301710)
  View vipProtocolExpLvl;
  
  @BindView(2131301711)
  LabeledTextView vipProtocolTerms;
  
  @BindView(2131301712)
  LabeledTextView vipServiceTerms;
  
  private boolean w = false;
  
  private boolean x = false;
  
  private View y;
  
  private String z;
  
  private void E() {
    int i;
    VIPCenterNewFragment vIPCenterNewFragment = (VIPCenterNewFragment)getParentFragment();
    Rect rect2 = new Rect();
    this.n.layoutRightTitle.getGlobalVisibleRect(rect2);
    Rect rect1 = new Rect();
    if (this.viewBtmBanner.getVisibility() == 0) {
      this.viewBtmBanner.getGlobalVisibleRect(rect1);
    } else {
      this.vipServiceTerms.getGlobalVisibleRect(rect1);
    } 
    if (this.d == null)
      this.d = new Rect(); 
    Rect rect3 = this.d;
    rect3.left = 0;
    rect3.right = AppInfo.l;
    this.d.top = rect2.bottom;
    rect2 = this.d;
    if (rect1.top == 0) {
      i = AppInfo.m;
    } else {
      i = rect1.top;
    } 
    rect2.bottom = i;
    if (vIPCenterNewFragment != null)
      vIPCenterNewFragment.a(this.d); 
  }
  
  private void F() {
    String str1 = H5Url.a(32);
    String str2 = H5Url.a(31);
    String str3 = H5Url.a(13);
    String str4 = H5Url.a(37);
    String str5 = H5Url.a(21);
    this.vipServiceTerms.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$yzcAybB98PdwLzLXgNDulZ-GPQ8(this, str1));
    this.vipProtocolTerms.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$pMQbAmyjmwncNcNCOjfbpbd6oPM(this, str2));
    this.vipHelpCenter.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$rp7GciGd3k-ui4w4oj0SSq03nyM(this, str4));
    this.vipOrderRecord.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$gVd0pWvpo8CEUerqQv_9AvBsFAw(this, str3));
    this.vipPrivacyClause.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$vTFTzmegu3POQPN13jeNZfUTNXg(this, str5));
    this.vipProtocolExpLvl.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$SlJ8I0RUYQOg9DVuEMhYbp0WYXU(this));
  }
  
  private void G() {
    if (!this.v && getUserVisibleHint()) {
      this.v = true;
      EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_PAGE_SHOW, (UserInfo.a().i()).vip_grade, getArguments().getInt("KEY_VIP_GRADE", 2));
    } 
  }
  
  private void H() {
    if (!this.w && getUserVisibleHint() && this.tvBuyBtn != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.tvBuyBtn.getText());
      stringBuilder.append("");
      if (!StringUtils.e(stringBuilder.toString()) && this.tvBuyBtn.getVisibility() == 0) {
        this.w = true;
        if (this.tvBuyBtn.getText().equals(this.s.getResources().getString(2131758579))) {
          EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_SHOW, (UserInfo.a().i()).vip_grade, this.t, VipProtos.BtnType.RENEW);
          return;
        } 
        if (this.tvBuyBtn.getText().equals(this.s.getResources().getString(2131755802))) {
          EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_SHOW, (UserInfo.a().i()).vip_grade, this.t, VipProtos.BtnType.NOW_RESUME);
          return;
        } 
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_SHOW, (UserInfo.a().i()).vip_grade, this.t, VipProtos.BtnType.NOW_BUY);
      } 
    } 
  }
  
  public static BaseFragment a(int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", paramInt);
    bundle.putString("KEY_VIP_DETAIL", paramString);
    VIPCenterTabPageFragment vIPCenterTabPageFragment = new VIPCenterTabPageFragment();
    vIPCenterTabPageFragment.setArguments(bundle);
    return (BaseFragment)vIPCenterTabPageFragment;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", paramInt);
    bundle.putBoolean("KEY_INDEPENDENT_PAGE", true);
    bundle.putString("KEY_VIP_DETAIL", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, VIPCenterTabPageFragment.class, bundle);
  }
  
  private void a(BannerHolder paramBannerHolder, int paramInt) {
    if (paramBannerHolder == null)
      return; 
    AutoScrollViewPager autoScrollViewPager = paramBannerHolder.bannerViewPager;
    if (autoScrollViewPager != null) {
      if (autoScrollViewPager.getAdapter() == null)
        return; 
      VIPCenterForJsonParse._banner _banner = ((VIPCenterBannerAdapter)autoScrollViewPager.getAdapter()).a(paramInt);
      if (_banner != null && !_banner.ifShowed) {
        _banner.ifShowed = true;
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_BANNER_SHOW, (UserInfo.a().i()).vip_grade, this.t, _banner.link);
      } 
    } 
  }
  
  private void a(VIPCenterForJsonParse paramVIPCenterForJsonParse) {
    if (paramVIPCenterForJsonParse == null) {
      this.n.layoutExpLvlRight.setVisibility(8);
      return;
    } 
    VIPCenterForJsonParse.UserLvlPriviledge userLvlPriviledge = paramVIPCenterForJsonParse.user_lvl_privilege;
    if (userLvlPriviledge == null) {
      this.n.layoutExpLvlRight.setVisibility(8);
      return;
    } 
    if (userLvlPriviledge.is_show_lvl_list == 0) {
      this.n.layoutExpLvlRight.setVisibility(8);
      return;
    } 
    if (paramVIPCenterForJsonParse.user_info.grade != 0 || this.t == paramVIPCenterForJsonParse.user_info.expire_type) {
      this.n.layoutExpLvlRight.setVisibility(0);
      this.n.layoutExpLvlRight.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              FlutterRouter.c(VIPCenterTabPageFragment.a(this.a));
            }
          });
      if (userLvlPriviledge.is_show_lvl_list == 1) {
        this.n.tvExpLvlTitle.setText(2131755440);
      } else {
        this.n.tvExpLvlTitle.setText(2131758151);
      } 
      if (!StringUtils.e(userLvlPriviledge.user_lvl_content)) {
        this.n.tvWaitingRightDesc.setVisibility(0);
        this.n.tvWaitingRightDesc.setText(userLvlPriviledge.user_lvl_content);
      } else {
        this.n.tvWaitingRightDesc.setVisibility(8);
      } 
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.s);
      linearLayoutManager.setOrientation(0);
      this.n.rvExpLvlRight.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
      VIPCenterExpLvlRightAdapter vIPCenterExpLvlRightAdapter = new VIPCenterExpLvlRightAdapter((IRequestHost)w_(), userLvlPriviledge.privilege_list, this.t);
      this.n.rvExpLvlRight.setAdapter((RecyclerView.Adapter)vIPCenterExpLvlRightAdapter);
      return;
    } 
    this.n.layoutExpLvlRight.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, View paramView, BannerHolder paramBannerHolder, List<VIPCenterForJsonParse._banner> paramList) {
    if (paramBoolean || paramList == null || paramList.size() == 0) {
      paramView.setVisibility(8);
      return;
    } 
    paramView.setVisibility(0);
    VIPCenterBannerAdapter vIPCenterBannerAdapter = new VIPCenterBannerAdapter(this.s, (IRequestHost)w_(), this.t, paramList);
    AutoScrollViewPager autoScrollViewPager = paramBannerHolder.bannerViewPager;
    LinePageIndicator linePageIndicator = paramBannerHolder.indicator;
    if (paramList.size() == 1) {
      linePageIndicator.setVisibility(4);
    } else {
      linePageIndicator.setVisibility(0);
    } 
    autoScrollViewPager.setAdapter((PagerAdapter)vIPCenterBannerAdapter);
    autoScrollViewPager.setInterval(3000L);
    autoScrollViewPager.f();
    linePageIndicator.setViewPager((ViewPager)autoScrollViewPager);
    if (k()) {
      a(paramBannerHolder, 0);
    } else if (getUserVisibleHint() && ((VIPCenterNewFragment)getParentFragment()).l() == this.t) {
      a(paramBannerHolder, 0);
    } 
    autoScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this, paramBannerHolder) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (this.b.getUserVisibleHint())
              VIPCenterTabPageFragment.a(this.b, this.a, param1Int); 
          }
        });
  }
  
  private void b(VIPCenterForJsonParse paramVIPCenterForJsonParse) {
    TextView textView;
    if (paramVIPCenterForJsonParse == null || paramVIPCenterForJsonParse.user_info == null) {
      this.n.llOutOfDate.setVisibility(8);
      this.n.llReachOutDateText.setVisibility(8);
      return;
    } 
    if (!k() && paramVIPCenterForJsonParse.user_info.expire_type != 0) {
      VIPCenterNewFragment vIPCenterNewFragment = (VIPCenterNewFragment)getParentFragment();
      if (vIPCenterNewFragment != null) {
        boolean bool;
        if (paramVIPCenterForJsonParse.user_info.expire_type == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        vIPCenterNewFragment.b(bool);
      } 
    } 
    String str = AvatarUtils.a(1, (UserInfo.a().i()).avatar);
    this.llBuy.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), str).c().a(2131234356).a(this.n.imgAvatar);
    this.n.tvUserName.setText((UserInfo.a().i()).name);
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.vip_grade = paramVIPCenterForJsonParse.user_info.grade;
    userBasicModel.is_vip_annual = paramVIPCenterForJsonParse.user_info.is_vip_annual;
    userBasicModel.expire_type = paramVIPCenterForJsonParse.user_info.expire_type;
    userBasicModel.vip_exp_lvl = paramVIPCenterForJsonParse.user_info.vip_exp_lvl;
    UserRelationshipUtils.a(this.n.imgVIPIcon, userBasicModel);
    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)this.n.tvUserName.getLayoutParams();
    if (paramVIPCenterForJsonParse.user_info.is_show_level == 1) {
      this.n.tvExpLvl.setVisibility(0);
      this.n.imgExpLvlIcon.setVisibility(0);
      this.n.tvExpLvl.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$Y3CY_TP_idObuW8ca2zp1o7uZOM(this));
      this.n.imgExpLvlIcon.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$KZ0VW4LyQTIjXH0x6w0pSD62JQ4(this));
      this.vipProtocolExpLvl.setVisibility(0);
      this.tvProtocolExpLvlBtmLine.setVisibility(0);
      layoutParams.topMargin = DensityUtils.a(this.s, 17.0F);
    } else {
      this.n.tvExpLvl.setVisibility(8);
      this.n.imgExpLvlIcon.setVisibility(8);
      this.vipProtocolExpLvl.setVisibility(8);
      this.tvProtocolExpLvlBtmLine.setVisibility(8);
      layoutParams.topMargin = DensityUtils.a(this.s, 30.0F);
    } 
    this.n.tvUserName.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (paramVIPCenterForJsonParse.user_info.expire_type == this.t && paramVIPCenterForJsonParse.user_info.expire_time != 0L) {
      this.n.viewReachOutDate.setVisibility(0);
      this.tvBuyBtn.setText(2131758579);
      this.n.tvExpLvl.setText(2131759230);
      this.n.llOutOfDate.setVisibility(0);
      this.n.llReachOutDateText.setVisibility(8);
      this.n.tvReachOutDate.setVisibility(8);
      if (this.t != 2) {
        this.n.tvOutDatePart1.setText(2131759382);
      } else {
        this.n.tvOutDatePart1.setText(2131759379);
      } 
      int i = TimeAndDateUtils.a(System.currentTimeMillis(), paramVIPCenterForJsonParse.user_info.expire_time * 1000L);
      textView = this.n.tvOutDateDays;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      return;
    } 
    if ((UserInfo.a().i()).vip_grade != 0) {
      long l;
      this.n.viewReachOutDate.setVisibility(0);
      this.n.tvExpLvl.setText(2131759225);
      this.tvBuyBtn.setText(2131755802);
      this.n.llOutOfDate.setVisibility(8);
      this.n.llReachOutDateText.setVisibility(0);
      if (this.t != 2) {
        this.n.tvReachOutDatePart1.setText(2131759383);
      } else {
        this.n.tvReachOutDatePart1.setText(2131759380);
      } 
      if (this.t == 2) {
        l = ((VIPCenterForJsonParse)textView).user_info.svip_endtime;
      } else {
        l = ((VIPCenterForJsonParse)textView).user_info.vip_endtime;
      } 
      if (((VIPCenterForJsonParse)textView).user_info.is_show_expire == 1) {
        this.n.tvReachOutDate.setVisibility(8);
        this.n.tvReachOutBuy.setVisibility(0);
        this.n.llReachOutDateText.setVisibility(0);
        int i = TimeAndDateUtils.a(System.currentTimeMillis(), l * 1000L);
        textView = this.n.tvReachOutDateDays;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        this.llBuy.setVisibility(0);
        return;
      } 
      l *= 1000L;
      if (l > System.currentTimeMillis()) {
        String str1 = this.s.getResources().getString(2131759267, new Object[] { ((SimpleDateFormat)TimeAndDateUtils.a.get()).format(new Date(l)) });
        this.n.tvReachOutDate.setText(str1);
        this.n.tvReachOutDate.setVisibility(0);
      } else {
        this.n.tvReachOutDate.setVisibility(8);
      } 
      this.n.tvReachOutBuy.setVisibility(0);
      this.n.llReachOutDateText.setVisibility(8);
      this.llBuy.setVisibility(8);
      return;
    } 
    this.n.viewReachOutDate.setVisibility(8);
    this.llBuy.setVisibility(0);
  }
  
  private void c(VIPCenterForJsonParse paramVIPCenterForJsonParse) {
    if (paramVIPCenterForJsonParse == null || paramVIPCenterForJsonParse.upgrade == null || paramVIPCenterForJsonParse.upgrade.size() == 0 || this.t == 2) {
      this.n.viewUpToSVIP.setVisibility(8);
      return;
    } 
    if (!k()) {
      this.n.viewUpToSVIP.setVisibility(8);
      return;
    } 
    this.n.viewUpToSVIP.setVisibility(0);
    if (!StringUtils.e(((VIPCenterForJsonParse._upgrade)paramVIPCenterForJsonParse.upgrade.get(0)).tips))
      this.n.tvUpToSvip.setText(((VIPCenterForJsonParse._upgrade)paramVIPCenterForJsonParse.upgrade.get(0)).tips); 
    this.n.tvUpToSvip.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$-kGzRiWEa_RwC7jlfhS6nxB_zds(this));
    this.n.vfUpToSVIP.removeAllViews();
    this.r.clear();
    for (VIPCenterForJsonParse._upgrade _upgrade : paramVIPCenterForJsonParse.upgrade) {
      View view = LayoutInflater.from(this.s).inflate(2131493664, null, false);
      UpToSVIPViewHolder upToSVIPViewHolder = new UpToSVIPViewHolder(this);
      Unbinder unbinder = ButterKnife.a(upToSVIPViewHolder, view);
      this.r.add(unbinder);
      upToSVIPViewHolder.tvTitle.setText(_upgrade.title);
      this.n.vfUpToSVIP.addView(view);
      view.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$91vAABIoGFUZh1B_r4Q4IDfMjkg(this, _upgrade));
    } 
  }
  
  private void n() {
    this.y = LayoutInflater.from(this.s).inflate(2131493358, null);
    this.h = ButterKnife.a(this.n, this.y);
    this.i = ButterKnife.a(this.o, this.n.viewBanner);
    this.j = ButterKnife.a(this.p, this.viewBtmBanner);
    ExpandedLinearLayoutManager expandedLinearLayoutManager = new ExpandedLinearLayoutManager(this.s);
    expandedLinearLayoutManager.setOrientation(1);
    this.listView.setLayoutManager((RecyclerView.LayoutManager)expandedLinearLayoutManager);
    if (getArguments() != null)
      this.z = getArguments().getString("KEY_VIP_DETAIL", ""); 
  }
  
  public boolean V_() {
    l();
    return super.V_();
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(";");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(";");
    stringBuilder.append(k());
    Logger.a("charge_notify", stringBuilder.toString());
    if (paramBoolean && k()) {
      a(this.s, (UserInfo.a().i()).vip_grade, this.z);
      getActivity().finish();
    } 
  }
  
  public void a(Bundle paramBundle) {
    this.s = (Context)getActivity();
    this.g = DialogUtils.a(this.s);
    DialogUtils.a(this.g);
    this.q = BluedPreferences.Z();
    LiveEventBus.get("INVISIBLE_DISTANCE", Boolean.class).observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            if (this.a.e != null)
              for (VIPRightOption vIPRightOption : this.a.e.n()) {
                if (vIPRightOption.pid == 3 && vIPRightOption.is_on == 1 && !param1Boolean.booleanValue())
                  vIPRightOption.is_on = 0; 
              }  
            if (this.a.e != null)
              this.a.e.notifyDataSetChanged(); 
          }
        });
    this.u = DensityUtils.a(this.s, 150.0F);
    super.a(paramBundle);
    n();
    if (getArguments() != null) {
      this.t = getArguments().getInt("KEY_VIP_GRADE", 2);
      if (k())
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_PAGE_SHOW, (UserInfo.a().i()).vip_grade, this.t); 
    } 
    this.e = new VIPRightOptionAdapter(this.s, this.t, getFragmentManager(), (IRequestHost)w_());
    this.f = new NonVIPRightAdapter(this.s, this.t, getChildFragmentManager(), (IRequestHost)w_());
    if ((UserInfo.a().i()).vip_grade == 0) {
      this.listView.setAdapter((RecyclerView.Adapter)this.f);
      this.f.b(this.y);
    } else {
      this.listView.setAdapter((RecyclerView.Adapter)this.e);
      this.e.b(this.y);
    } 
    if (this.t == 2) {
      this.llBuy.setBackground(this.s.getResources().getDrawable(2131231096));
      this.tvBuyBtn.setTextColor(this.s.getResources().getColor(2131100728));
      this.n.imgHeaderBG.setImageResource(2131231097);
      this.imgHeaderBg.setImageResource(2131231097);
      this.n.imgVIPTitle.setImageResource(2131232821);
      this.imgVIPTitle.setImageResource(2131232821);
      this.n.imgWaterPrint.setImageResource(2131232824);
      this.n.tvRightTitle.setText(2131759262);
      this.title.setLeftImg(2131232744);
      this.title.getCenterTextView().setTextColor(this.s.getResources().getColor(2131100728));
    } else {
      this.llBuy.setBackground(this.s.getResources().getDrawable(2131234090));
      this.tvBuyBtn.setTextColor(this.s.getResources().getColor(2131100838));
      this.n.imgHeaderBG.setImageResource(2131231101);
      this.imgHeaderBg.setImageResource(2131231101);
      this.n.imgVIPTitle.setImageResource(2131232822);
      this.imgVIPTitle.setImageResource(2131232822);
      this.n.imgWaterPrint.setImageResource(2131232825);
      this.n.tvRightTitle.setText(2131759263);
      this.title.setLeftImg(2131232743);
      this.title.getCenterTextView().setTextColor(this.s.getResources().getColor(2131100838));
    } 
    this.n.tvReachOutBuy.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$cshw47GgMP_iopAzucISOWiEUHw(this));
    this.tvBuyBtn.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$9wykoRMfkSnXw9xUPOXApB-lhrs(this));
    this.n.viewToRightDetail.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$-i3LdRC70cHWq84dLdZhCGELYic(this));
    this.n.viewToRightDetailArrow.setOnClickListener(new -$$Lambda$VIPCenterTabPageFragment$AVoXvktsxduI9WYhCNLMnzr6oFI(this));
    if (k()) {
      this.title.setVisibility(0);
      this.titleHover.setVisibility(0);
      this.titleHover.setBackgroundColor(BluedSkinUtils.a(this.s, 2131100728));
      this.titleHover.setAlpha(0.0F);
      this.title.setPadding(0, StatusBarHelper.a(this.s), 0, 0);
      this.titleHover.setPadding(0, StatusBarHelper.a(this.s), 0, 0);
      this.title.setLeftClickListener(new -$$Lambda$VIPCenterTabPageFragment$bFHdAc9gJmGrVABfebr6VDLDSXE(this));
      this.titleHover.setLeftClickListener(new -$$Lambda$VIPCenterTabPageFragment$C1LtsFn1XUib-scKu0627-LZ-AY(this));
      if (this.t == 1)
        StatusBarHelper.a((Activity)getActivity(), true); 
      this.scrollView.setOnScrollChangeListener(new -$$Lambda$VIPCenterTabPageFragment$LtqXioaW4rjt0ENyjhh94xESUrw(this));
    } else {
      this.title.setVisibility(8);
      this.titleHover.setVisibility(8);
      this.scrollView.setOnScrollChangeListener(new -$$Lambda$VIPCenterTabPageFragment$YGdtUeSQNshw7uaPl5mFe0LKf7Q(this));
    } 
    F();
  }
  
  public void a(String paramString, List<VIPCenterForJsonParse> paramList) {
    super.a(paramString, paramList);
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      VIPCenterForJsonParse vIPCenterForJsonParse = paramList.get(0);
      if (vIPCenterForJsonParse != null) {
        if (vIPCenterForJsonParse.user_info == null)
          return; 
        boolean bool = "DATA_VIP_OPTION_CACHE".equals(paramString);
        if (vIPCenterForJsonParse.banner != null) {
          if (this.t == 2) {
            paramList = vIPCenterForJsonParse.banner.svip;
          } else {
            paramList = vIPCenterForJsonParse.banner.vip;
          } 
          a(bool, this.n.viewBanner, this.o, (List)paramList);
        } 
        if (vIPCenterForJsonParse.footer != null) {
          if (this.t == 2) {
            paramList = vIPCenterForJsonParse.footer.svip;
          } else {
            paramList = vIPCenterForJsonParse.footer.vip;
          } 
          a(bool, this.viewBtmBanner, this.p, (List)paramList);
        } 
        this.imgHeaderBg.setVisibility(8);
        this.imgVIPTitle.setVisibility(8);
        b(vIPCenterForJsonParse);
        c(vIPCenterForJsonParse);
        a(vIPCenterForJsonParse);
        if (vIPCenterForJsonParse.privilege != null && vIPCenterForJsonParse.privilege.size() > 0)
          this.e.a(vIPCenterForJsonParse.privilege, this.t); 
        if (vIPCenterForJsonParse.privilege_normal != null && vIPCenterForJsonParse.privilege_normal.size() > 0)
          this.f.c(vIPCenterForJsonParse.privilege_normal); 
        a(new -$$Lambda$VIPCenterTabPageFragment$Li9vNbCm4tbrQqIPfBGcR-CfMhk(this), 500L);
        H();
        if (!"DATA_VIP_OPTION_CACHE".equals(paramString)) {
          AdvertFloatModel advertFloatModel = vIPCenterForJsonParse.market;
          if (advertFloatModel != null && advertFloatModel.images != null) {
            if (AppInfo.l >= 720) {
              advertFloatModel.advert_pic = advertFloatModel.images._795x1020;
            } else {
              advertFloatModel.advert_pic = advertFloatModel.images._530x680;
            } 
            ImageFileLoader.a((IRequestHost)w_()).a(advertFloatModel.advert_pic).a(new -$$Lambda$VIPCenterTabPageFragment$VDvqMKwI6BlAiutVDHpVZAfWkgk(this, advertFloatModel)).a();
          } 
        } 
        this.scrollView.setVisibility(0);
        DialogUtils.b(this.g);
      } 
    } 
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 || paramInt == 3)
      l(); 
    return super.a(paramInt, paramKeyEvent);
  }
  
  public void aL_() {
    super.aL_();
    this.h.unbind();
    this.i.unbind();
    this.j.unbind();
    List<Unbinder> list = this.r;
    if (list != null && list.size() > 0) {
      Iterator<Unbinder> iterator = this.r.iterator();
      while (iterator.hasNext())
        ((Unbinder)iterator.next()).unbind(); 
    } 
  }
  
  public void b(int paramInt, String paramString) {
    paramString = BluedHttpUrl.a(paramInt, paramString, this.t, (UserInfo.a().i()).vip_grade);
    WebViewShowInfoFragment.show(this.s, paramString, -1);
  }
  
  public void b_(boolean paramBoolean) {
    if (k()) {
      super.b_(paramBoolean);
      return;
    } 
    if (getArguments().getInt("KEY_VIP_GRADE", 2) == 2)
      super.b_(paramBoolean); 
  }
  
  public boolean k() {
    Bundle bundle = getArguments();
    boolean bool = false;
    if (bundle != null)
      bool = getArguments().getBoolean("KEY_INDEPENDENT_PAGE", false); 
    return bool;
  }
  
  public void l() {
    if (k()) {
      BluedConfig.b().d();
      if (s() != null && this.e.d)
        ((VIPCenterTabPageNewPresenter)s()).d(this.q); 
    } 
    getActivity().finish();
  }
  
  public Rect m() {
    return this.d;
  }
  
  public int p() {
    StatusBarHelper.a((Activity)getActivity(), false);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getIfIndependentPage()=");
    stringBuilder.append(k());
    Logger.a("charge_notify", stringBuilder.toString());
    if (k())
      VIPBuyResultObserver.a().a(this, getLifecycle()); 
    return 2131493360;
  }
  
  public String q() {
    return a("VipCenter");
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    HeaderViewHolder headerViewHolder = this.n;
    if (headerViewHolder != null && headerViewHolder.viewBanner != null && paramBoolean) {
      BannerHolder bannerHolder = this.o;
      a(bannerHolder, bannerHolder.bannerViewPager.getCurrentItem());
    } 
    G();
    H();
  }
  
  class BannerHolder {
    @BindView(2131296497)
    AutoScrollViewPager bannerViewPager;
    
    @BindView(2131297592)
    LinePageIndicator indicator;
    
    BannerHolder(VIPCenterTabPageFragment this$0) {}
  }
  
  class HeaderViewHolder {
    @BindView(2131297432)
    ImageView imgAvatar;
    
    @BindView(2131297476)
    ImageView imgExpLvlIcon;
    
    @BindView(2131297491)
    ImageView imgHeaderBG;
    
    @BindView(2131297581)
    ImageView imgVIPIcon;
    
    @BindView(2131297583)
    ImageView imgVIPTitle;
    
    @BindView(2131297585)
    ImageView imgWaterPrint;
    
    @BindView(2131298059)
    View layoutExpLvlRight;
    
    @BindView(2131298090)
    View layoutRightTitle;
    
    @BindView(2131299004)
    View llOutOfDate;
    
    @BindView(2131299037)
    View llReachOutDateText;
    
    @BindView(2131299769)
    RecyclerView rvExpLvlRight;
    
    @BindView(2131300740)
    TextView tvExpLvl;
    
    @BindView(2131300741)
    TextView tvExpLvlTitle;
    
    @BindView(2131301153)
    TextView tvOutDateDays;
    
    @BindView(2131301154)
    TextView tvOutDatePart1;
    
    @BindView(2131301226)
    TextView tvReachOutBuy;
    
    @BindView(2131301227)
    TextView tvReachOutDate;
    
    @BindView(2131301229)
    TextView tvReachOutDateDays;
    
    @BindView(2131301230)
    TextView tvReachOutDatePart1;
    
    @BindView(2131301282)
    TextView tvRightTitle;
    
    @BindView(2131301462)
    TextView tvUpToSvip;
    
    @BindView(2131301088)
    TextView tvUserName;
    
    @BindView(2131301516)
    TextView tvWaitingRightDesc;
    
    @BindView(2131301592)
    ViewFlipper vfUpToSVIP;
    
    @BindView(2131301621)
    View viewBanner;
    
    @BindView(2131301677)
    View viewReachOutDate;
    
    @BindView(2131301228)
    View viewReachOutDateCutline;
    
    @BindView(2131301424)
    View viewToRightDetail;
    
    @BindView(2131297550)
    View viewToRightDetailArrow;
    
    @BindView(2131301691)
    View viewUpToSVIP;
    
    HeaderViewHolder(VIPCenterTabPageFragment this$0) {}
  }
  
  class UpToSVIPViewHolder {
    @BindView(2131301409)
    TextView tvTitle;
    
    UpToSVIPViewHolder(VIPCenterTabPageFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPCenterTabPageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */