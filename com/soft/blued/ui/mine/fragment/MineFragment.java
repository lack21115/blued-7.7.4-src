package com.soft.blued.ui.mine.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.DividerGridItemDecoration;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.mine.adapter.MineFourEntryAdapter;
import com.soft.blued.ui.mine.adapter.MineNineEntryAdapter;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.mine.presenter.MinePresenter;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.fragment.FollowedAndFansFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentFeed;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MineFragment extends MvpFragment<MinePresenter> {
  @BindView(2131296419)
  BluedADConstraintLayout adViewLayout;
  
  @BindView(2131297700)
  ImageView avatarWidget;
  
  @BindView(2131296881)
  CardView cvAd;
  
  @BindView(2131296882)
  CardView cvAnchors;
  
  @BindView(2131296889)
  CardView cvHealth;
  
  @BindView(2131296897)
  CardView cvOther;
  
  @BindView(2131296900)
  CardView cvService;
  
  private List<MineEntryInfo.VipBroadcast> d;
  
  private List<Unbinder> e = new ArrayList<Unbinder>();
  
  private MineFourEntryAdapter f;
  
  private List<MineEntryInfo.ColumnsItem> g;
  
  private MineNineEntryAdapter h;
  
  @BindView(2131297362)
  ImageView headerView;
  
  private List<MineEntryInfo.ColumnsItem> i;
  
  @BindView(2131297419)
  ImageView imgAd;
  
  @BindView(2131297707)
  ImageView ivBgIcon;
  
  @BindView(2131297752)
  ImageView ivEdit;
  
  @BindView(2131297863)
  ImageView ivMore;
  
  @BindView(2131297957)
  ImageView ivVerify;
  
  @BindView(2131297965)
  ImageView ivVipBg;
  
  @BindView(2131297967)
  ImageView ivVipBtn;
  
  @BindView(2131297968)
  ImageView ivVipIcon;
  
  private MineNineEntryAdapter j;
  
  @BindView(2131298065)
  LinearLayout layoutHeaderName;
  
  @BindView(2131298073)
  LinearLayout layoutName;
  
  @BindView(2131298102)
  LinearLayout layoutVip;
  
  @BindView(2131298103)
  ShapeLinearLayout layoutVipBtn;
  
  @BindView(2131298127)
  LinearLayout linearLayout;
  
  @BindView(2131298873)
  LinearLayout llHealthFlipper;
  
  @BindView(2131298965)
  LinearLayout llMyAttentions;
  
  @BindView(2131298966)
  LinearLayout llMyFans;
  
  @BindView(2131298967)
  LinearLayout llMyFeed;
  
  @BindView(2131298968)
  LinearLayout ll_my_group;
  
  private List<MineEntryInfo.ColumnsItem> n;
  
  private List<View> o;
  
  private List<MineEntryInfo.TvBanner> p;
  
  private MineNineEntryAdapter q;
  
  private List<MineEntryInfo.ColumnsItem> r;
  
  @BindView(2131299766)
  RecyclerView rvAnchorsEntry;
  
  @BindView(2131299775)
  RecyclerView rvHealthEntry;
  
  @BindView(2131299782)
  RecyclerView rvOthersEntry;
  
  @BindView(2131299792)
  RecyclerView rvServiceEntry;
  
  private List<Unbinder> s = new ArrayList<Unbinder>();
  
  @BindView(2131299840)
  ScrollView scrollPage;
  
  private Context t;
  
  @BindView(2131300291)
  FrameLayout top;
  
  @BindView(2131300536)
  TextView tvAttentionsCount;
  
  @BindView(2131300542)
  TextView tvAvatarAuditing;
  
  @BindView(2131300745)
  TextView tvFansCount;
  
  @BindView(2131300757)
  TextView tvFeedCount;
  
  @BindView(2131300759)
  TextView tvFeedName;
  
  @BindView(2131301082)
  TextView tvMyName;
  
  @BindView(2131301497)
  TextView tvVipBtn;
  
  @BindView(2131301504)
  TextView tvVipTitle;
  
  @BindView(2131301080)
  TextView tv_my_group_cnt;
  
  private boolean u = false;
  
  private DividerGridItemDecoration v;
  
  @BindView(2131301591)
  ViewFlipper vfHealth;
  
  @BindView(2131301593)
  ViewFlipper vfVipAd;
  
  private DividerGridItemDecoration w;
  
  private DividerGridItemDecoration x;
  
  private DividerGridItemDecoration y;
  
  private void E() {
    if (!BluedConstant.a)
      this.ll_my_group.setVisibility(0); 
  }
  
  private void F() {
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.t, 2);
    this.rvAnchorsEntry.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.f = new MineFourEntryAdapter(this.t, (IRequestHost)w_());
    this.rvAnchorsEntry.setAdapter((RecyclerView.Adapter)this.f);
    gridLayoutManager = new GridLayoutManager(this.t, 3);
    this.rvServiceEntry.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.h = new MineNineEntryAdapter(this.t, (IRequestHost)w_());
    this.rvServiceEntry.setAdapter((RecyclerView.Adapter)this.h);
    gridLayoutManager = new GridLayoutManager(this.t, 3);
    this.rvHealthEntry.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.j = new MineNineEntryAdapter(this.t, (IRequestHost)w_());
    this.rvHealthEntry.setAdapter((RecyclerView.Adapter)this.j);
    gridLayoutManager = new GridLayoutManager(this.t, 3);
    this.rvOthersEntry.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.q = new MineNineEntryAdapter(this.t, (IRequestHost)w_());
    this.rvOthersEntry.setAdapter((RecyclerView.Adapter)this.q);
    H();
  }
  
  private void G() {}
  
  private void H() {
    if (this.rvAnchorsEntry != null && this.rvServiceEntry != null && this.rvHealthEntry != null && this.rvOthersEntry != null) {
      int i = DensityUtils.a(this.t, 0.5F);
      this.v = new DividerGridItemDecoration(this.rvAnchorsEntry, i, 2131100851);
      this.rvAnchorsEntry.addItemDecoration((RecyclerView.ItemDecoration)this.v);
      this.w = new DividerGridItemDecoration(this.rvServiceEntry, i, 2131100851);
      this.rvServiceEntry.addItemDecoration((RecyclerView.ItemDecoration)this.w);
      this.x = new DividerGridItemDecoration(this.rvHealthEntry, i, 2131100851);
      this.rvHealthEntry.addItemDecoration((RecyclerView.ItemDecoration)this.x);
      this.y = new DividerGridItemDecoration(this.rvOthersEntry, i, 2131100851);
      this.rvOthersEntry.addItemDecoration((RecyclerView.ItemDecoration)this.y);
    } 
  }
  
  private void I() {
    DividerGridItemDecoration dividerGridItemDecoration = this.v;
    if (dividerGridItemDecoration != null)
      dividerGridItemDecoration.g(); 
    dividerGridItemDecoration = this.w;
    if (dividerGridItemDecoration != null)
      dividerGridItemDecoration.g(); 
    dividerGridItemDecoration = this.x;
    if (dividerGridItemDecoration != null)
      dividerGridItemDecoration.g(); 
    dividerGridItemDecoration = this.y;
    if (dividerGridItemDecoration != null)
      dividerGridItemDecoration.g(); 
  }
  
  private void a(MineEntryInfo.ImgBanner paramImgBanner) {
    if (paramImgBanner != null && !TextUtils.isEmpty(paramImgBanner.img)) {
      ImageLoader.a((IRequestHost)w_(), paramImgBanner.img).a(12.0F).a(this.imgAd);
      this.adViewLayout.a((BluedADExtra)paramImgBanner, (View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, paramImgBanner) {
              public void onClick(View param1View) {
                SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
                String str = this.a.link;
                int i = (BluedConfig.b().j()).is_chat_shadow;
                boolean bool = true;
                if (i != 1)
                  bool = false; 
                EventTrackSettings.a(event, str, null, bool);
                WebViewShowInfoFragment.show(MineFragment.b(this.b), this.a.link, 9);
              }
            }));
      this.cvAd.setVisibility(0);
      return;
    } 
    this.cvAd.setVisibility(8);
  }
  
  private void a(List<MineEntryInfo.ColumnsItem> paramList) {
    if (this.g == null)
      this.g = new ArrayList<MineEntryInfo.ColumnsItem>(); 
    this.g.clear();
    if (paramList != null && paramList.size() > 0) {
      this.g.addAll(paramList);
      this.cvAnchors.setVisibility(0);
    } else {
      this.cvAnchors.setVisibility(8);
    } 
    this.f.c(this.g);
  }
  
  private void a(List<MineEntryInfo.ColumnsItem> paramList, List<MineEntryInfo.TvBanner> paramList1) {
    if (this.n == null)
      this.n = new ArrayList<MineEntryInfo.ColumnsItem>(); 
    this.n.clear();
    if (paramList != null && paramList.size() > 0) {
      this.n.addAll(paramList);
      this.rvHealthEntry.setVisibility(0);
    } else {
      this.rvHealthEntry.setVisibility(8);
    } 
    this.j.c(this.n);
    this.p = paramList1;
    List<View> list = this.o;
    if (list == null) {
      this.o = new ArrayList<View>();
    } else {
      list.clear();
    } 
    this.vfHealth.removeAllViews();
    if (paramList1 != null && paramList1.size() > 0) {
      int i;
      for (i = 0; i < paramList1.size(); i++) {
        MineEntryInfo.TvBanner tvBanner = paramList1.get(i);
        if (!TextUtils.isEmpty(tvBanner.title) && !TextUtils.isEmpty(tvBanner.content)) {
          BannerViewHolder bannerViewHolder = new BannerViewHolder(this);
          View view = getLayoutInflater().inflate(2131493593, null);
          Unbinder unbinder = ButterKnife.a(bannerViewHolder, view);
          this.s.add(unbinder);
          try {
            bannerViewHolder.title.setText(tvBanner.title);
            bannerViewHolder.title.setTextColor(Color.parseColor(tvBanner.title_color));
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          try {
            bannerViewHolder.content.setText(tvBanner.content);
            bannerViewHolder.content.setTextColor(Color.parseColor(tvBanner.content_color));
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          view.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, i, tvBanner) {
                  public void onClick(View param1View) {
                    SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
                    String str1 = ((MineEntryInfo.TvBanner)MineFragment.c(this.c).get(this.a)).link;
                    String str2 = ((MineEntryInfo.TvBanner)MineFragment.c(this.c).get(this.a)).id;
                    int i = (BluedConfig.b().j()).is_chat_shadow;
                    boolean bool = true;
                    if (i != 1)
                      bool = false; 
                    EventTrackSettings.a(event, str1, str2, bool);
                    WebViewShowInfoFragment.show(MineFragment.b(this.c), this.b.link, 9);
                  }
                }));
          this.o.add(view);
          this.vfHealth.addView(view);
        } 
      } 
      this.vfHealth.getInAnimation().setAnimationListener(new Animation.AnimationListener(this, paramList1) {
            public void onAnimationEnd(Animation param1Animation) {
              if (this.b.vfHealth.getGlobalVisibleRect(new Rect()) && MineFragment.c(this.b) != null && MineFragment.c(this.b).size() > this.b.vfHealth.getDisplayedChild()) {
                boolean bool;
                SettingsProtos.Event event = SettingsProtos.Event.MINE_AREA_SHOW;
                SettingsProtos.ModuleType moduleType = SettingsProtos.ModuleType.HEALTH;
                String str1 = ((MineEntryInfo.TvBanner)MineFragment.c(this.b).get(this.b.vfHealth.getDisplayedChild())).link;
                String str2 = ((MineEntryInfo.TvBanner)MineFragment.c(this.b).get(this.b.vfHealth.getDisplayedChild())).id;
                if ((BluedConfig.b().j()).is_chat_shadow == 1) {
                  bool = true;
                } else {
                  bool = false;
                } 
                EventTrackSettings.a(event, moduleType, str1, str2, bool);
              } 
              if (this.a.size() <= 1)
                this.b.vfHealth.stopFlipping(); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      i = paramList1.size();
      boolean bool = true;
      if (i > 1) {
        this.vfHealth.startFlipping();
      } else {
        this.vfHealth.stopFlipping();
        SettingsProtos.Event event = SettingsProtos.Event.MINE_AREA_SHOW;
        SettingsProtos.ModuleType moduleType = SettingsProtos.ModuleType.HEALTH;
        String str1 = ((MineEntryInfo.TvBanner)paramList1.get(0)).link;
        String str2 = ((MineEntryInfo.TvBanner)paramList1.get(0)).id;
        if ((BluedConfig.b().j()).is_chat_shadow != 1)
          bool = false; 
        EventTrackSettings.a(event, moduleType, str1, str2, bool);
      } 
      this.llHealthFlipper.setVisibility(0);
    } else {
      this.llHealthFlipper.setVisibility(8);
    } 
    if ((paramList != null && paramList.size() > 0) || (paramList1 != null && paramList1.size() > 0)) {
      this.cvHealth.setVisibility(0);
      return;
    } 
    this.cvHealth.setVisibility(8);
  }
  
  private void a(List<MineEntryInfo.VipBroadcast> paramList, boolean paramBoolean) {
    this.d = paramList;
    this.vfVipAd.removeAllViews();
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        MineEntryInfo.VipBroadcast vipBroadcast = paramList.get(i);
        if (!TextUtils.isEmpty(vipBroadcast.text)) {
          VipViewHolder vipViewHolder = new VipViewHolder(this);
          View view = getLayoutInflater().inflate(2131493597, null);
          Unbinder unbinder = ButterKnife.a(vipViewHolder, view);
          this.e.add(unbinder);
          vipViewHolder.content.setText(vipBroadcast.text);
          if (paramBoolean) {
            vipViewHolder.icon.setVisibility(8);
            vipViewHolder.content.setTextColor(this.t.getResources().getColor(2131100980));
            vipViewHolder.content.setBackground(null);
            vipViewHolder.content.setPadding(DensityUtils.a(this.t, 5.0F), 0, 0, 0);
          } else {
            int j = vipBroadcast.type;
            if (j != 1) {
              if (j != 2) {
                vipViewHolder.icon.setVisibility(8);
                vipViewHolder.content.setTextColor(BluedSkinUtils.a(this.t, 2131100844));
                vipViewHolder.content.setBackground(null);
                vipViewHolder.content.setPadding(DensityUtils.a(this.t, 5.0F), 0, 0, 0);
              } else {
                vipViewHolder.icon.setImageResource(2131233415);
                vipViewHolder.icon.setVisibility(0);
                vipViewHolder.content.setTextColor(this.t.getResources().getColor(2131099657));
                vipViewHolder.content.setBackgroundResource(2131233414);
                vipViewHolder.content.setPadding(DensityUtils.a(this.t, 10.0F), 0, 0, 0);
              } 
            } else {
              vipViewHolder.icon.setImageResource(2131233422);
              vipViewHolder.icon.setVisibility(0);
              vipViewHolder.content.setTextColor(this.t.getResources().getColor(2131099662));
              vipViewHolder.content.setBackgroundResource(2131233421);
              vipViewHolder.content.setPadding(DensityUtils.a(this.t, 10.0F), 0, 0, 0);
            } 
          } 
          view.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, i) {
                  public void onClick(View param1View) {
                    EventTrackSettings.b(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_CLICK, ((MineEntryInfo.VipBroadcast)MineFragment.a(this.b).get(this.a)).url);
                    InstantLog.a("mine_vip_banner_right_click");
                    WebViewShowInfoFragment.show(MineFragment.b(this.b), ((MineEntryInfo.VipBroadcast)MineFragment.a(this.b).get(this.a)).url, 0);
                  }
                }));
          this.vfVipAd.addView(view);
        } 
      } 
      this.vfVipAd.getInAnimation().setAnimationListener(new Animation.AnimationListener(this, paramList) {
            public void onAnimationEnd(Animation param1Animation) {
              if (this.b.vfVipAd.getGlobalVisibleRect(new Rect()) && MineFragment.a(this.b) != null && MineFragment.a(this.b).size() > this.b.vfVipAd.getDisplayedChild())
                EventTrackSettings.b(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_SHOW, ((MineEntryInfo.VipBroadcast)MineFragment.a(this.b).get(this.b.vfVipAd.getDisplayedChild())).url); 
              if (this.a.size() <= 1)
                this.b.vfVipAd.stopFlipping(); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      if (paramList.size() > 1) {
        this.vfVipAd.startFlipping();
      } else {
        this.vfVipAd.stopFlipping();
        EventTrackSettings.b(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_SHOW, ((MineEntryInfo.VipBroadcast)this.d.get(0)).url);
      } 
      this.vfVipAd.setVisibility(0);
      return;
    } 
    this.vfVipAd.setVisibility(8);
  }
  
  private void b(List<MineEntryInfo.ColumnsItem> paramList) {
    if (this.i == null)
      this.i = new ArrayList<MineEntryInfo.ColumnsItem>(); 
    this.i.clear();
    if (paramList != null && paramList.size() > 0) {
      this.i.addAll(paramList);
      this.cvService.setVisibility(0);
    } else {
      this.cvService.setVisibility(8);
    } 
    this.h.c(this.i);
  }
  
  private void c(List<MineEntryInfo.ColumnsItem> paramList) {
    if (this.r == null)
      this.r = new ArrayList<MineEntryInfo.ColumnsItem>(); 
    this.r.clear();
    if (paramList != null && paramList.size() > 0)
      this.r.addAll(paramList); 
    this.q.c(this.r);
  }
  
  private void m() {
    if (UserInfo.a().i() != null) {
      ImageOptions imageOptions = new ImageOptions();
      if ((UserInfo.a().i()).vip_grade == 0) {
        imageOptions.c = 2131234358;
        imageOptions.a = 2131234358;
      } else {
        imageOptions.c = 2131234357;
        imageOptions.a = 2131234357;
      } 
      int i = (this.t.getResources().getDisplayMetrics()).widthPixels;
      this.tvAttentionsCount.setText(UserInfo.a().i().getFollowedCount());
      this.tvFansCount.setText(UserInfo.a().i().getFollowerCount());
      this.tvFeedCount.setText(UserInfo.a().i().getMyTicktocksCount());
      String str = UserInfo.a().i().getGroupsCount();
      if (StringUtils.e(str) || "0".equals(str)) {
        this.ll_my_group.setVisibility(8);
      } else if (!BluedConstant.a) {
        this.ll_my_group.setVisibility(0);
        this.tv_my_group_cnt.setText(UserInfo.a().i().getGroupsCount());
      } else {
        this.ll_my_group.setVisibility(8);
      } 
      i = UserInfo.a().i().getVBadge();
      if (i == 0) {
        this.ivVerify.setImageDrawable(this.t.getResources().getDrawable(2131234373));
      } else {
        UserRelationshipUtils.a(this.ivVerify, i, 1);
      } 
      this.tvMyName.setText(UserInfo.a().i().getName());
      str = AvatarUtils.a(0, UserInfo.a().i().getAvatar());
      ImageLoader.a((IRequestHost)w_(), str).a(imageOptions).c().a(this.headerView);
      return;
    } 
    this.tvMyName.setText("");
    this.tvAttentionsCount.setText("0");
    this.tvFansCount.setText("0");
    this.tv_my_group_cnt.setText("0");
  }
  
  private void n() {
    if (StatusBarHelper.a()) {
      ViewGroup.LayoutParams layoutParams = this.top.getLayoutParams();
      layoutParams.height = StatusBarHelper.a((Context)getActivity());
      this.top.setLayoutParams(layoutParams);
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.t = getContext();
    n();
    E();
    F();
    G();
    m();
  }
  
  protected void a(MineEntryInfo paramMineEntryInfo) {
    if (paramMineEntryInfo != null) {
      if (BluedConfig.b().u()) {
        this.ivEdit.setVisibility(8);
      } else {
        this.ivEdit.setVisibility(0);
      } 
      m();
      Logger.a("mine", paramMineEntryInfo);
      if (paramMineEntryInfo.user.avatar_audited == 0) {
        this.tvAvatarAuditing.setVisibility(0);
      } else {
        this.tvAvatarAuditing.setVisibility(8);
      } 
      if (paramMineEntryInfo.broadcast != null) {
        boolean bool;
        List<MineEntryInfo.VipBroadcast> list = paramMineEntryInfo.broadcast.carousels;
        if (paramMineEntryInfo.broadcast.is_broadcast_test == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        a(list, bool);
        this.tvVipTitle.setText(paramMineEntryInfo.broadcast.title);
        this.tvVipTitle.setTextColor(BluedSkinUtils.a(this.t, 2131100838));
        this.tvVipBtn.setText(paramMineEntryInfo.broadcast.btn);
        if (paramMineEntryInfo.broadcast.is_broadcast_test == 0) {
          this.ivVipBg.setImageResource(2131233423);
          this.ivVipBg.setImageAlpha(255);
          this.ivBgIcon.setImageDrawable(null);
          this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.t, 2131100806));
          this.ivVipBtn.setImageResource(2131233419);
          this.tvVipTitle.setTextColor(this.t.getResources().getColor(2131100980));
          ShapeHelper.b((ShapeHelper.ShapeView)this.layoutVipBtn, 2131100792);
        } else {
          int i = paramMineEntryInfo.broadcast.vip_grade;
          if (i != 1) {
            if (i != 2) {
              this.ivVipBg.setImageDrawable(null);
              this.ivBgIcon.setImageDrawable(null);
              this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.t, 2131100838));
              this.ivVipBtn.setImageResource(2131233419);
            } else {
              this.ivVipBg.setImageDrawable(BluedSkinUtils.b(this.t, 2131233915));
              this.ivVipBg.setImageAlpha(33);
              this.ivBgIcon.setImageResource(2131233416);
              this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.t, 2131099659));
              this.ivVipBtn.setImageResource(2131233417);
            } 
          } else {
            this.ivVipBg.setImageDrawable(BluedSkinUtils.b(this.t, 2131233917));
            this.ivVipBg.setImageAlpha(33);
            this.ivBgIcon.setImageResource(2131233424);
            this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.t, 2131099661));
            this.ivVipBtn.setImageResource(2131233420);
          } 
          if (paramMineEntryInfo.broadcast.vip_grade != 0) {
            this.ivVipIcon.setVisibility(0);
            UserRelationshipUtils.a(this.ivVipIcon, paramMineEntryInfo.broadcast);
            ShapeHelper.b((ShapeHelper.ShapeView)this.layoutVipBtn, 2131100728);
          } else {
            this.ivVipIcon.setVisibility(8);
            ShapeHelper.b((ShapeHelper.ShapeView)this.layoutVipBtn, 2131100881);
          } 
        } 
      } else {
        this.ivVipBg.setImageDrawable(null);
        this.ivBgIcon.setImageDrawable(null);
        this.tvVipBtn.setTextColor(BluedSkinUtils.a(this.t, 2131100838));
        this.ivVipBtn.setImageResource(2131233419);
        this.ivVipIcon.setVisibility(8);
      } 
      if (paramMineEntryInfo.columns != null) {
        a(paramMineEntryInfo.columns.anchors);
        b(paramMineEntryInfo.columns.service);
        a(paramMineEntryInfo.img_banner);
        a(paramMineEntryInfo.columns.health, paramMineEntryInfo.text_banner);
        c(paramMineEntryInfo.columns.others);
      } 
      a(Integer.valueOf(paramMineEntryInfo.user.theme_pendant));
    } 
  }
  
  protected void a(Integer paramInteger) {
    ImageLoader.a((IRequestHost)w_(), AvatarWidgetManager.a().a(paramInteger.intValue())).a(this.avatarWidget);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (this.r == null)
      this.r = new ArrayList<MineEntryInfo.ColumnsItem>(); 
    if (this.r.size() == 0) {
      MineEntryInfo.ColumnsItem columnsItem = new MineEntryInfo.ColumnsItem();
      columnsItem.icon = "http://www.bldimg.com/img/mine_setting.png";
      columnsItem.title = this.t.getResources().getString(2131758707);
      columnsItem.url = "http://native.blued.cn?action=setting";
      this.r.add(columnsItem);
      this.q.c(this.r);
      this.q.notifyDataSetChanged();
    } 
  }
  
  public void aL_() {
    super.aL_();
    List<Unbinder> list = this.s;
    if (list != null) {
      Iterator<Unbinder> iterator = list.iterator();
      while (iterator.hasNext())
        ((Unbinder)iterator.next()).unbind(); 
      this.s.clear();
    } 
    list = this.e;
    if (list != null) {
      Iterator<Unbinder> iterator = list.iterator();
      while (iterator.hasNext())
        ((Unbinder)iterator.next()).unbind(); 
      this.e.clear();
    } 
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.u = false;
  }
  
  protected void k() {
    this.scrollPage.smoothScrollTo(0, 0);
  }
  
  protected void l() {}
  
  public void onResume() {
    super.onResume();
    if (this.u)
      ((MinePresenter)s()).d(); 
    this.u = true;
    I();
  }
  
  @OnClick({2131297752, 2131298065, 2131297362, 2131301082, 2131297863, 2131298965, 2131298966, 2131298967, 2131298102, 2131298103, 2131298968})
  public void onViewClicked(View paramView) {
    Bundle bundle;
    String str1;
    String str2;
    switch (paramView.getId()) {
      default:
        return;
      case 2131298968:
        TerminalActivity.d(getContext(), MyGroupFragment.class, null);
        return;
      case 2131298967:
        UserInfoFragmentFeed.a(this.t);
        return;
      case 2131298966:
        BluedConstant.e = 1;
        bundle = new Bundle();
        bundle.putString("followed_or_fan", "fans");
        bundle.putString("uid", UserInfo.a().i().getUid());
        TerminalActivity.d((Context)getActivity(), FollowedAndFansFragment.class, bundle);
        return;
      case 2131298965:
        BluedConstant.e = 0;
        bundle = new Bundle();
        bundle.putString("followed_or_fan", "followed");
        bundle.putString("uid", UserInfo.a().i().getUid());
        TerminalActivity.d((Context)getActivity(), FollowedAndFansFragment.class, bundle);
        return;
      case 2131298102:
      case 2131298103:
        EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_CENTER_CLICK);
        str2 = ((MinePresenter)s()).m();
        str1 = str2;
        if (StringUtils.e(str2))
          str1 = BluedHttpUrl.g(); 
        InstantLog.b("my_model", 14);
        WebViewShowInfoFragment.show(this.t, str1, 0);
        return;
      case 2131297752:
        if (YYRoomInfoManager.d().m()) {
          AppMethods.a(this.t.getResources().getText(2131759451));
          return;
        } 
        if (!PopMenuUtils.a(this.t)) {
          InstantLog.b("my_model", 2);
          InstantLog.a("modify_user_profile", Integer.valueOf(0));
          ModifyUserInfoFragment.a(this.t, 601, false);
          return;
        } 
        return;
      case 2131297362:
      case 2131297863:
      case 2131298065:
      case 2131301082:
        break;
    } 
    InstantLog.b("my_model", 1);
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.uid = (UserInfo.a().i()).uid;
    userBasicModel.name = (UserInfo.a().i()).name;
    userBasicModel.avatar = (UserInfo.a().i()).avatar;
    userBasicModel.vip_grade = (UserInfo.a().i()).vip_grade;
    UserInfoFragmentNew.a(this.t, userBasicModel, "", false, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public int p() {
    return 2131493222;
  }
  
  class BannerViewHolder {
    @BindView(2131300488)
    TextView content;
    
    @BindView(2131300490)
    TextView title;
    
    BannerViewHolder(MineFragment this$0) {}
  }
  
  class VipViewHolder {
    @BindView(2131300663)
    TextView content;
    
    @BindView(2131297964)
    ImageView icon;
    
    VipViewHolder(MineFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\fragment\MineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */