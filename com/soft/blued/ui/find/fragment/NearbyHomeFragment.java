package com.soft.blued.ui.find.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.customview.NearbyHomeViewPager;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.adapter.NearbyHomePagerAdapter;
import com.soft.blued.ui.find.model.HomeTopTabModel;
import com.soft.blued.ui.find.observer.NearbyFindSetSelectedTab;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.find.presenter.NearbyHomePresenter;
import com.soft.blued.ui.group.UserGroupListsFragment;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.search.SearchAllFragment;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.version.update.UpdateVersionHelper;
import com.soft.blued.view.tip.dialog.PrivacyClauseDialog;
import java.util.ArrayList;
import java.util.List;

public class NearbyHomeFragment extends MvpFragment<NearbyHomePresenter> implements SingleSessionListener, NearbyFindSetSelectedTab.INearbyFindSetSelectedTab {
  public static int d;
  
  @BindView(2131296537)
  BluedADConstraintLayout adConstraintLayout;
  
  @BindView(2131297530)
  ImageView adNearbyImg;
  
  public boolean e = false;
  
  private PopHolder f;
  
  @BindView(2131297107)
  FrameLayout fl_floor;
  
  private List<Unbinder> g = new ArrayList<Unbinder>();
  
  private Unbinder h;
  
  private boolean i = false;
  
  @BindView(2131297532)
  ShapeTextView imgNewRemindVisitor;
  
  @BindView(2131301725)
  TabPageIndicatorWithDot indicatorTitle;
  
  private NearbyHomePagerAdapter j;
  
  @BindView(2131300273)
  View mTitle;
  
  @BindView(2131296863)
  ImageView mTitleLeft;
  
  @BindView(2131296867)
  ImageView mTitleRight;
  
  @BindView(2131297551)
  ShapeTextView mTitleRightDot;
  
  @BindView(2131296869)
  FrameLayout mTitleRightMenu;
  
  @BindView(2131296871)
  TextView mTitleRightText;
  
  @BindView(2131299192)
  NearbyHomeViewPager mViewPager;
  
  private PopMenu n;
  
  @BindView(2131299360)
  TextView nearbyActivityTip;
  
  private Context o;
  
  private ViewPager.OnPageChangeListener p = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        int i = ((HomeTopTabModel)((NearbyHomePresenter)this.a.s()).j.get(param1Int)).tab_id;
        if (i != 1) {
          if (i != 2) {
            if (i == 3) {
              this.a.mTitleRightMenu.setVisibility(0);
              this.a.mTitleRight.setImageResource(2131232755);
              this.a.mTitleRightText.setVisibility(8);
              this.a.adConstraintLayout.setVisibility(8);
              this.a.mTitleRight.setOnClickListener(new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      InstantLog.a("my_group");
                      TerminalActivity.d(NearbyHomeFragment.b(this.a.a), UserGroupListsFragment.class, null);
                    }
                  });
            } 
          } else {
            this.a.mTitleRightMenu.setVisibility(8);
            this.a.mTitleRightText.setVisibility(8);
            this.a.adConstraintLayout.setVisibility(8);
          } 
        } else {
          this.a.mTitleRightMenu.setVisibility(0);
          this.a.mTitleRightText.setVisibility(8);
          NearbyHomeFragment nearbyHomeFragment = this.a;
          nearbyHomeFragment.a(NearbyHomeFragment.g(nearbyHomeFragment));
          this.a.mTitleRight.setOnClickListener(new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  if (NearbyHomeFragment.c(this.a.a).a()) {
                    NearbyHomeFragment.c(this.a.a).d();
                  } else {
                    NearbyHomeFragment.c(this.a.a).a(this.a.a.mTitle);
                  } 
                  this.a.a.mTitleRightDot.setVisibility(8);
                  BluedPreferences.dH();
                }
              });
        } 
        NearbyHomeFragment.d = ((HomeTopTabModel)((NearbyHomePresenter)this.a.s()).j.get(param1Int)).tab_id;
      }
    };
  
  private BluedADExtra q;
  
  private int r = 0;
  
  private int s;
  
  @BindView(2131299876)
  ImageView second_floor;
  
  private boolean t;
  
  @BindView(2131301393)
  TextView tvTip;
  
  private String u;
  
  private void E() {
    Context context = this.o;
    if (context == null)
      return; 
    ViewGroup viewGroup = (ViewGroup)LayoutInflater.from(context).inflate(2131494053, null);
    this.f = new PopHolder(this);
    this.h = ButterKnife.a(this.f, (View)viewGroup);
    this.g.add(this.h);
    if (!BluedPreferences.dI())
      this.f.ivFilterDot.setVisibility(0); 
    Log.v("drb", "initPop:");
    a(Boolean.valueOf(false));
    this.n = new PopMenu(this.o, (View)viewGroup);
    this.n.a(new PopMenu.onShowListener(this) {
          public void a() {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_SETTINGS_BTN_CLICK);
            if ((NearbyHomeFragment.a(this.a)).ivFilterMode != null && (NearbyHomeFragment.a(this.a)).tvFilterMode != null && (NearbyHomeFragment.a(this.a)).ivListMode != null) {
              if ((NearbyHomeFragment.a(this.a)).tvListMode == null)
                return; 
              if (BluedPreferences.G()) {
                (NearbyHomeFragment.a(this.a)).ivFilterMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.b(this.a), 2131232626));
                (NearbyHomeFragment.a(this.a)).tvFilterMode.setText(2131758328);
                (NearbyHomeFragment.a(this.a)).tvFilterMode.setTextColor(BluedSkinUtils.a(NearbyHomeFragment.b(this.a), 2131100838));
              } else {
                (NearbyHomeFragment.a(this.a)).ivFilterMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.b(this.a), 2131232625));
                (NearbyHomeFragment.a(this.a)).tvFilterMode.setText(2131756024);
                (NearbyHomeFragment.a(this.a)).tvFilterMode.setTextColor(BluedSkinUtils.a(NearbyHomeFragment.b(this.a), 2131100844));
              } 
              if (BluedPreferences.I() == 0) {
                (NearbyHomeFragment.a(this.a)).ivListMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.b(this.a), 2131232628));
                (NearbyHomeFragment.a(this.a)).tvListMode.setText(2131757123);
                return;
              } 
              (NearbyHomeFragment.a(this.a)).ivListMode.setImageDrawable(BluedSkinUtils.b(NearbyHomeFragment.b(this.a), 2131232627));
              (NearbyHomeFragment.a(this.a)).tvListMode.setText(2131756595);
            } 
          }
        });
    this.f.llFilter.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            NearbyHomeFragment.c(this.a).d();
            if (NearbyHomeFragment.d(this.a)) {
              EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_FILTER_BTN_CLICK);
              InstantLog.a("nearby_filter_btn_click");
              if (!BluedPreferences.dI()) {
                BluedPreferences.dJ();
                (NearbyHomeFragment.a(this.a)).ivFilterDot.setVisibility(8);
              } 
            } 
          }
        });
    this.f.llCustomInvisible.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            NearbyHomeFragment.c(this.a).d();
            NearbyHomeFragment.e(this.a);
            EventTrackGuy.a(GuyProtos.Event.NEARBY_SETTINGS_HIDE_CLICK);
          }
        });
    this.f.llMap.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            NearbyHomeFragment.c(this.a).d();
            NearbyHomeFragment.f(this.a);
            GuyProtos.Event event = GuyProtos.Event.NEARBY_FRIEND_MAP_FIND_CLICK;
            int i = (BluedConfig.b().j()).is_chat_shadow;
            boolean bool = true;
            if (i != 1)
              bool = false; 
            EventTrackGuy.c(event, bool);
          }
        });
    this.f.llSearch.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            NearbyHomeFragment.c(this.a).d();
            SearchAllFragment.a(NearbyHomeFragment.b(this.a), false);
          }
        });
    this.f.llList.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            NearbyHomeFragment.c(this.a).d();
            if (HomeActivity.c != null)
              ((NearbyViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(NearbyViewModel.class)).b.postValue(null); 
          }
        });
  }
  
  private void F() {
    if (this.j == null)
      this.j = new NearbyHomePagerAdapter(getChildFragmentManager(), ((NearbyHomePresenter)s()).j); 
    this.mViewPager.setAdapter((PagerAdapter)this.j);
    this.mViewPager.setOffscreenPageLimit(((NearbyHomePresenter)s()).j.size());
    this.mTitleRightDot.setVisibility(8);
    this.indicatorTitle.setViewPager((ViewPager)this.mViewPager);
    this.indicatorTitle.setOnPageChangeListener(this.p);
    G();
    int j = BluedConfig.b().r();
    for (int i = 0; i < ((NearbyHomePresenter)s()).j.size(); i++) {
      if (j == ((HomeTopTabModel)((NearbyHomePresenter)s()).j.get(i)).tab_id) {
        this.mViewPager.setCurrentItem(i);
        this.p.onPageSelected(i);
        break;
      } 
    } 
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.fl_floor.getLayoutParams();
    layoutParams.width = AppInfo.l;
    this.r = (int)(AppInfo.l * 1.2666667F);
    layoutParams.height = this.r;
    this.fl_floor.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void G() {
    for (int i = 0; i < ((NearbyHomePresenter)s()).j.size(); i++) {
      if (((HomeTopTabModel)((NearbyHomePresenter)s()).j.get(i)).tab_id == 2) {
        this.indicatorTitle.b(i).setMaxWidth(DensityUtils.a(this.o, 90.0F));
        this.indicatorTitle.b(i).setEllipsize(TextUtils.TruncateAt.END);
      } 
    } 
  }
  
  private boolean H() {
    if (FilterDialogFragment.a)
      return false; 
    (new FilterDialogFragment()).show(getChildFragmentManager(), "");
    return true;
  }
  
  private void I() {
    VipInvisibleDialogFragment vipInvisibleDialogFragment = new VipInvisibleDialogFragment();
    vipInvisibleDialogFragment.a = this.o.getResources().getString(2131756144);
    vipInvisibleDialogFragment.b = "nearby_settings_hide";
    vipInvisibleDialogFragment.show(getChildFragmentManager(), NearbyHomeFragment.class.getName());
  }
  
  private void J() {
    (new FindSearchMapDialogFragment()).show(getChildFragmentManager(), "");
  }
  
  private void K() {
    this.mTitleRightText.setVisibility(8);
    this.mTitleRightMenu.setVisibility(0);
    if (StatusBarHelper.a())
      this.mTitle.setPadding(0, StatusBarHelper.a((Context)getActivity()), 0, 0); 
    if (BluedPreferences.dG())
      this.mTitleRightDot.setVisibility(0); 
    if (BluedPreferences.G()) {
      this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.o, 2131232749));
    } else {
      this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.o, 2131232748));
    } 
    this.mTitleLeft.setVisibility(0);
    this.mTitleLeft.setImageDrawable(BluedSkinUtils.b(this.o, 2131232760));
    this.mTitleLeft.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            BluedPreferences.A(false);
            this.a.imgNewRemindVisitor.setVisibility(8);
            ChatHelperV4.a().a(4L);
            TerminalActivity.d((Context)this.a.getActivity(), VisitHistoryFragment.class, null);
          }
        });
    this.mTitleRight.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            NearbyHomeFragment.c(this.a).a(this.a.mTitle);
            this.a.mTitleRightDot.setVisibility(8);
            BluedPreferences.dH();
          }
        });
    this.mTitle.post(new Runnable(this) {
          public void run() {
            if (this.a.mTitle != null) {
              NearbyHomeFragment nearbyHomeFragment = this.a;
              NearbyHomeFragment.a(nearbyHomeFragment, nearbyHomeFragment.mTitle.getHeight());
            } 
          }
        });
  }
  
  private void a(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showNearbyBubble stay_time:");
    stringBuilder.append(paramInt);
    Log.v("drb", stringBuilder.toString());
    if (this.nearbyActivityTip != null) {
      EventTrackGuy.b(GuyProtos.Event.CHECK_IN_BUBBLE_SHOW);
      int i = this.mTitle.getBottom();
      ((RelativeLayout.LayoutParams)this.nearbyActivityTip.getLayoutParams()).topMargin = i - DensityUtils.a(this.o, 10.0F);
      this.nearbyActivityTip.setVisibility(0);
      this.nearbyActivityTip.setText(paramString);
      a(new Runnable(this) {
            public void run() {
              if (this.a.w_().isActive() && this.a.nearbyActivityTip != null) {
                this.a.nearbyActivityTip.setVisibility(8);
                Log.v("drb", "showNearbyBubble GONE");
              } 
            }
          }(paramInt * 1000));
      this.nearbyActivityTip.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              this.a.adConstraintLayout.performClick();
              EventTrackGuy.b(GuyProtos.Event.CHECK_IN_BUBBLE_CLICK);
            }
          });
    } 
  }
  
  private void b(BluedADExtra paramBluedADExtra) {
    String str = BluedPreferences.dS();
    int i = BluedPreferences.dT();
    int j = BluedPreferences.dU();
    long l2 = BluedPreferences.dV().longValue();
    long l3 = BluedPreferences.dW().longValue();
    long l4 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("广告气泡本地缓存title：");
    stringBuilder.append(str);
    stringBuilder.append(" stayTime：");
    stringBuilder.append(i);
    stringBuilder.append(" frequencyType：");
    stringBuilder.append(j);
    stringBuilder.append(" frequencyTime：");
    stringBuilder.append(l2);
    stringBuilder.append(" lastTime：");
    stringBuilder.append(l3);
    Log.v("drb", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("广告气泡服务器title：");
    stringBuilder.append(paramBluedADExtra.bubble_title);
    stringBuilder.append(" stayTime：");
    stringBuilder.append(paramBluedADExtra.bubble_stay_time);
    stringBuilder.append(" frequencyType：");
    stringBuilder.append(paramBluedADExtra.bubble_frequency_type);
    stringBuilder.append(" frequencyTime：");
    stringBuilder.append(paramBluedADExtra.bubble_frequency_time);
    Log.v("drb", stringBuilder.toString());
    if (!TextUtils.isEmpty(paramBluedADExtra.bubble_title) && paramBluedADExtra.bubble_frequency_type != 0 && paramBluedADExtra.bubble_stay_time != 0 && TextUtils.isEmpty(str) && i == 0 && j == 0) {
      Log.v("drb", "首次展示");
      a(paramBluedADExtra.bubble_title, paramBluedADExtra.bubble_stay_time);
    } 
    long l1 = 86400000L;
    if (j != 2) {
      if (j != 3) {
        if (j == 4)
          l1 = 86400000L * l2; 
      } else {
        l1 = -1702967296L;
      } 
    } else {
      l1 = 604800000L;
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append("广告气泡 currentTime:");
    stringBuilder.append(l4);
    stringBuilder.append(" lastTime:");
    stringBuilder.append(l3);
    stringBuilder.append(" rule:");
    stringBuilder.append(l1);
    Log.v("drb", stringBuilder.toString());
    if (l1 != 0L && l3 != 0L && l4 - l3 > l1) {
      Log.v("drb", "广告气泡满足本地判断展示条件");
      a(str, i);
      BluedPreferences.r(System.currentTimeMillis());
    } else {
      Log.v("drb", "广告气泡不满足本地判断展示条件");
    } 
    if (!TextUtils.equals(paramBluedADExtra.bubble_title, str))
      BluedPreferences.ar(paramBluedADExtra.bubble_title); 
    if (paramBluedADExtra.bubble_stay_time != i)
      BluedPreferences.y(paramBluedADExtra.bubble_stay_time); 
    if (paramBluedADExtra.bubble_frequency_type != j) {
      BluedPreferences.z(paramBluedADExtra.bubble_frequency_type);
      BluedPreferences.r(System.currentTimeMillis());
    } 
    if (paramBluedADExtra.bubble_frequency_time != l2)
      BluedPreferences.q(paramBluedADExtra.bubble_frequency_time); 
  }
  
  public void a(float paramFloat, int paramInt) {
    FrameLayout frameLayout = this.fl_floor;
    if (frameLayout != null) {
      if (frameLayout.getVisibility() != 0)
        return; 
      View view = this.mTitle;
      if (view != null)
        view.setAlpha(1.0F - Math.min(paramFloat * 1.8F, 1.0F)); 
      FrameLayout frameLayout1 = this.fl_floor;
      if (frameLayout1 != null)
        frameLayout1.setTranslationY(Math.min(paramInt - this.r + this.s, 0)); 
    } 
  }
  
  public void a(int paramInt) {
    NearbyHomeViewPager nearbyHomeViewPager = this.mViewPager;
    if (nearbyHomeViewPager != null && paramInt >= 0 && nearbyHomeViewPager.getChildCount() > paramInt)
      this.mViewPager.setCurrentItem(paramInt); 
  }
  
  protected void a(Rect paramRect) {
    this.mViewPager.setIgnoreRect(paramRect);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    E();
    K();
    F();
    a(this.t, "");
  }
  
  protected void a(BluedADExtra paramBluedADExtra) {
    Log.v("drb", "showNearbyActivity");
    if (paramBluedADExtra != null) {
      this.q = paramBluedADExtra;
      this.adConstraintLayout.setVisibility(0);
      this.adConstraintLayout.a(paramBluedADExtra, new View.OnClickListener(this, paramBluedADExtra) {
            public void onClick(View param1View) {
              EventTrackGuy.b(GuyProtos.Event.NEARBY_SETTINGS_AD_ENTER_CLICK);
              WebViewShowInfoFragment.show(NearbyHomeFragment.b(this.b), this.a.target_url, 9);
            }
          });
      int i = TextUtils.isEmpty(paramBluedADExtra.ads_apng) ^ true;
      if (!TextUtils.isEmpty(paramBluedADExtra.ads_gif))
        i = 2; 
      int j = i;
      if (!TextUtils.isEmpty(paramBluedADExtra.ads_apng)) {
        j = i;
        if (!TextUtils.isEmpty(paramBluedADExtra.ads_gif))
          j = 1; 
      } 
      if (j != 0) {
        if (j != 1) {
          if (j == 2)
            ImageLoader.a((IRequestHost)w_(), paramBluedADExtra.ads_gif).h().a(new ImageLoader.OnAnimationStateListener(this, paramBluedADExtra) {
                  public void a() {}
                  
                  public void b() {
                    NearbyHomeFragment.a(this.b, this.a);
                    ImageLoader.a((IRequestHost)this.b.w_(), this.a.ads_pics).a(this.b.adNearbyImg);
                  }
                }).a(this.adNearbyImg); 
        } else {
          ImageLoader.a((IRequestHost)w_(), paramBluedADExtra.ads_apng).f().a(new ImageLoader.OnAnimationStateListener(this, paramBluedADExtra) {
                public void a() {}
                
                public void b() {
                  NearbyHomeFragment.a(this.b, this.a);
                  ImageLoader.a((IRequestHost)this.b.w_(), this.a.ads_pics).a(this.b.adNearbyImg);
                }
              }).a(this.adNearbyImg);
        } 
      } else {
        ImageLoader.a((IRequestHost)w_(), paramBluedADExtra.ads_pics).a(this.adNearbyImg);
        b(paramBluedADExtra);
      } 
      EventTrackGuy.b(GuyProtos.Event.NEARBY_SETTINGS_AD_ENTER_SHOW);
      return;
    } 
    this.adConstraintLayout.setVisibility(8);
  }
  
  protected void a(Boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--setInvisibleState:");
    stringBuilder.append(paramBoolean);
    Log.v("drb", stringBuilder.toString());
    if (paramBoolean.booleanValue()) {
      this.f.tvCustomInvisible.setText(2131758328);
      this.f.tvCustomInvisible.setTextColor(BluedSkinUtils.a(this.o, 2131100838));
      return;
    } 
    this.f.tvCustomInvisible.setText(2131756024);
    this.f.tvCustomInvisible.setTextColor(BluedSkinUtils.a(this.o, 2131100844));
  }
  
  public void a(boolean paramBoolean, String paramString) {
    if (this.fl_floor != null && this.mTitle != null) {
      this.t = paramBoolean;
      this.u = paramString;
      if (!TextUtils.isEmpty(this.u)) {
        FrameLayout frameLayout = this.fl_floor;
        if (frameLayout != null)
          frameLayout.setVisibility(0); 
        if (this.second_floor != null)
          ImageLoader.a((IRequestHost)w_(), paramString).a(2131233090).a(this.second_floor); 
      } else {
        View view = this.mTitle;
        if (view != null)
          view.setAlpha(1.0F); 
        FrameLayout frameLayout = this.fl_floor;
        if (frameLayout != null)
          frameLayout.setVisibility(8); 
      } 
      a(0.0F, 0);
    } 
  }
  
  public void aL_() {
    super.aL_();
    Unbinder unbinder = this.h;
    if (unbinder != null)
      unbinder.unbind(); 
  }
  
  public void k() {
    if (!this.e) {
      this.tvTip.setVisibility(0);
      this.tvTip.setOnClickListener(new -$$Lambda$NearbyHomeFragment$UR-b4cub00naCzCo3xdL_k1iqOw(this));
      b(new -$$Lambda$NearbyHomeFragment$j3fDsGsxRy2JKfOs4qqO2N3EDvA(this), 5000L);
      BluedPreferences.dD();
      this.e = true;
    } 
  }
  
  public void l() {
    this.tvTip.setVisibility(8);
  }
  
  protected void m() {
    this.indicatorTitle.b();
    G();
  }
  
  protected void n() {
    if (BluedPreferences.G()) {
      this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.o, 2131232749));
      return;
    } 
    this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.o, 2131232748));
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.o = (Context)getActivity();
    NearbyFindSetSelectedTab.a().a(this);
  }
  
  public void onDestroy() {
    super.onDestroy();
    NearbyFindSetSelectedTab.a().b(this);
  }
  
  public void onDestroyView() {
    super.onDestroyView();
  }
  
  public void onResume() {
    super.onResume();
    if (!this.i) {
      this.i = true;
      UpdateVersionHelper.b(this.o);
      PrivacyClauseDialog.a(this.o, (IRequestHost)w_());
    } 
    if (!BluedPreferences.bh()) {
      ShapeTextView shapeTextView = this.imgNewRemindVisitor;
      if (shapeTextView != null)
        shapeTextView.setVisibility(8); 
    } 
  }
  
  public void onSessionDataChanged(SessionModel paramSessionModel) {
    if (paramSessionModel.sessionId == 4L)
      a(new Runnable(this, paramSessionModel) {
            public void run() {
              if (CommonTools.a((Fragment)this.b))
                if (this.a.noReadMsgCount > 0) {
                  BluedPreferences.A(true);
                  if (NearbyHomeFragment.d == 1) {
                    this.b.imgNewRemindVisitor.setVisibility(0);
                    return;
                  } 
                } else {
                  this.b.imgNewRemindVisitor.setVisibility(8);
                }  
            }
          }); 
  }
  
  public void onSessionRemoved(short paramShort, long paramLong) {
    if (paramShort == 1 && paramLong == 4L)
      AppInfo.n().post(new Runnable(this) {
            public void run() {
              if (CommonTools.a((Fragment)this.a))
                this.a.imgNewRemindVisitor.setVisibility(8); 
            }
          }); 
  }
  
  public void onStart() {
    super.onStart();
    ChatHelperV4.a().c(this);
  }
  
  public void onStop() {
    super.onStop();
    ChatHelperV4.a().d(this);
  }
  
  public int p() {
    return 2131493215;
  }
  
  class PopHolder {
    @BindView(2131297769)
    View ivFilterDot;
    
    @BindView(2131297770)
    ImageView ivFilterMode;
    
    @BindView(2131297830)
    ImageView ivListMode;
    
    @BindView(2131298767)
    LinearLayout llCustomInvisible;
    
    @BindView(2131298803)
    LinearLayout llFilter;
    
    @BindView(2131298915)
    LinearLayout llList;
    
    @BindView(2131298943)
    LinearLayout llMap;
    
    @BindView(2131299070)
    LinearLayout llSearch;
    
    @BindView(2131300686)
    TextView tvCustomInvisible;
    
    @BindView(2131300769)
    TextView tvFilterMode;
    
    @BindView(2131300967)
    TextView tvListMode;
    
    PopHolder(NearbyHomeFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyHomeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */