package com.soft.blued.ui.live.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.observer.LiveListRefreshObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.presenter.LivePresenter;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.live.view.LiveListFloatReddishBag;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.click.SingleClickProxy;

public class LiveFragment extends MvpFragment<LivePresenter> implements View.OnClickListener, SingleSessionListener, LiveListRefreshObserver.ILiveListRefreshObserver, LiveListSetSelectedTab.iLiveListSetSelectedTab, HomeTabClick.TabClickListener, LiveFloatRedBagViewScrollObserver.IFloatRedBagViewScrollObserver {
  @BindView(2131296523)
  View beauty_close;
  
  @BindView(2131296526)
  View beauty_open;
  
  public boolean d;
  
  public String e;
  
  public int f = 3;
  
  @BindView(2131297107)
  View fl_floor;
  
  @BindView(2131297170)
  View fl_two_level_indicate;
  
  private String g = LiveFragment.class.getSimpleName();
  
  private Context h;
  
  private BluedLiveState i;
  
  @BindView(2131301725)
  TabPageIndicatorWithDot indicator;
  
  @BindView(2131297532)
  View ivRankingRemind;
  
  @BindView(2131297950)
  View iv_two_level_indicate;
  
  private long j;
  
  @BindView(2131299610)
  LiveListFloatReddishBag mRedBagView;
  
  @BindView(2131297551)
  ShapeTextView mRightNewDot;
  
  @BindView(2131300273)
  View mTitle;
  
  @BindView(2131296863)
  ImageView mTitleLeft;
  
  @BindView(2131296867)
  ImageView mTitleRight;
  
  @BindView(2131299194)
  CustomViewPager mViewPager;
  
  private MyAdapter n;
  
  private boolean o;
  
  private boolean p = false;
  
  private int q;
  
  private int r;
  
  private boolean s;
  
  @BindView(2131299876)
  ImageView second_floor;
  
  private int t = 0;
  
  private int u = 1;
  
  private ViewPager.OnPageChangeListener v = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        if (!LiveFragment.a(this.a))
          return; 
        KeyboardUtils.a((Activity)this.a.getActivity());
        LiveFragment.a(this.a, param1Int);
        param1Int = LiveFragment.b(this.a);
        if (param1Int != 0 && param1Int != 1) {
          if (param1Int != 2)
            return; 
          this.a.indicator.c(2);
          ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)1), 6L);
        } 
      }
    };
  
  @BindView(2131297355)
  View view_hard;
  
  @BindView(2131299994)
  View view_soft;
  
  private Boolean w = Boolean.valueOf(false);
  
  private void E() {
    if (StatusBarHelper.a())
      this.mTitle.setPadding(0, StatusBarHelper.a((Context)getActivity()), 0, 0); 
    this.mTitleLeft.setImageDrawable(BluedSkinUtils.b(this.h, 2131232750));
    this.mTitleLeft.setVisibility(0);
    this.mTitleLeft.setOnClickListener(this);
    this.o = BluedPreferences.bs();
    if (this.o)
      this.ivRankingRemind.setVisibility(0); 
    this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.h, 2131232742));
    this.mTitleRight.setVisibility(0);
    this.mTitleRight.setOnClickListener((View.OnClickListener)new SingleClickProxy(this, 2000L, null));
    this.mRightNewDot.setVisibility(8);
    this.mTitle.post(new Runnable(this) {
          public void run() {
            if (this.a.mTitle != null) {
              LiveFragment liveFragment = this.a;
              LiveFragment.b(liveFragment, liveFragment.mTitle.getHeight());
            } 
          }
        });
  }
  
  private void F() {
    this.f = 3;
  }
  
  private void m() {}
  
  private void n() {
    this.mRedBagView.setFragment((BaseFragment)this);
    this.mRedBagView.c();
    if (this.n == null)
      this.n = new MyAdapter(this, getChildFragmentManager()); 
    this.mViewPager.setAdapter((PagerAdapter)this.n);
    this.mViewPager.setOffscreenPageLimit(1);
    this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (!LiveFragment.a(this.a))
              return; 
            if (param1Int == 2) {
              this.a.mRedBagView.setVisibility(8);
              return;
            } 
            this.a.k();
          }
        });
    if (!BlueAppLocal.d())
      this.indicator.setTabPaddingLeftRight(DensityUtils.a(this.h, 5.0F)); 
    this.indicator.setViewPager((ViewPager)this.mViewPager);
    this.indicator.setOnPageChangeListener(this.v);
    this.indicator.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener(this) {
          public void a(int param1Int) {
            if (param1Int == 2)
              this.a.indicator.c(2); 
          }
        });
    this.mViewPager.setCurrentItem(this.u);
    this.view_soft.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.view_soft.setSelected(true);
            this.a.view_hard.setSelected(false);
            BluedPreferences.p(0);
          }
        });
    this.view_hard.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.view_soft.setSelected(false);
            this.a.view_hard.setSelected(true);
            BluedPreferences.p(1);
          }
        });
    if (BluedPreferences.bI() == 0) {
      this.view_soft.setSelected(true);
      this.view_hard.setSelected(false);
    } else {
      this.view_soft.setSelected(false);
      this.view_hard.setSelected(true);
    } 
    this.beauty_open.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.beauty_open.setSelected(true);
            this.a.beauty_close.setSelected(false);
            BluedPreferences.q(0);
          }
        });
    this.beauty_close.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.beauty_open.setSelected(false);
            this.a.beauty_close.setSelected(true);
            BluedPreferences.q(1);
          }
        });
    if (BluedPreferences.bJ() == 0) {
      this.beauty_open.setSelected(true);
      this.beauty_close.setSelected(false);
    } else {
      this.beauty_open.setSelected(false);
      this.beauty_close.setSelected(true);
    } 
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.fl_floor.getLayoutParams();
    layoutParams.width = AppInfo.l;
    this.t = (int)(AppInfo.l * 1.2666667F);
    layoutParams.height = this.t;
    this.fl_floor.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a() {
    if (!this.s)
      return; 
    TabPageIndicatorWithDot tabPageIndicatorWithDot = this.indicator;
    if (tabPageIndicatorWithDot != null)
      tabPageIndicatorWithDot.c(2); 
  }
  
  public void a(float paramFloat, int paramInt) {
    if (!this.s)
      return; 
    if (this.fl_floor.getVisibility() != 0)
      return; 
    this.mTitle.setAlpha(1.0F - Math.min(paramFloat * 1.8F, 1.0F));
    this.fl_floor.setTranslationY(Math.min(paramInt - this.t + this.r, 0));
  }
  
  public void a(int paramInt) {
    if (paramInt < this.mViewPager.getAdapter().getCount())
      this.mViewPager.setCurrentItem(paramInt); 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    F();
    E();
    n();
    a(this.d, "");
    this.j = 0L;
    LiveListSetSelectedTab.a().a(this);
    LiveFloatRedBagViewScrollObserver.a().a(this);
    this.s = true;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    if (!this.s)
      return; 
    if (this.mViewPager.getCurrentItem() == 0 || this.mViewPager.getCurrentItem() == 1)
      this.mRedBagView.getCustomScrollListener().onScrolled(paramRecyclerView, paramInt1, paramInt2); 
  }
  
  public void a(BluedLiveState paramBluedLiveState) {
    Log.i("xpm", "receive setLiveState");
    try {
      this.i = paramBluedLiveState;
      if (1 == paramBluedLiveState.is_permission || 2 == paramBluedLiveState.is_permission) {
        this.mTitleRight.setVisibility(0);
        this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.h, 2131232742));
      } else {
        this.mTitleRight.setVisibility(0);
        this.mTitleRight.setImageDrawable(BluedSkinUtils.b(this.h, 2131232742));
      } 
      if (paramBluedLiveState.allow_applied == 0) {
        this.mTitleRight.setVisibility(8);
      } else {
        this.mTitleRight.setVisibility(0);
      } 
      if (this.p) {
        BluedPreferences.aI();
        LiveUtils.a(this.h, paramBluedLiveState);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == "LIVE_STATE")
      this.p = false; 
  }
  
  public void a(boolean paramBoolean) {
    if (!this.s)
      return; 
    this.q = LiveListRefreshObserver.c();
    if (!this.o && paramBoolean)
      this.ivRankingRemind.setVisibility(0); 
  }
  
  public void a(boolean paramBoolean, String paramString) {
    if (!this.s)
      return; 
    this.d = paramBoolean;
    this.e = paramString;
    if (!TextUtils.isEmpty(this.e)) {
      this.fl_floor.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), paramString).a(2131233090).a(this.second_floor);
    } else {
      this.mTitle.setAlpha(1.0F);
      this.fl_floor.setVisibility(8);
    } 
    a(0.0F, 0);
    if (this.d && !BluedPreferences.dj())
      b(new Runnable(this) {
            public void run() {
              if (this.a.iv_two_level_indicate == null)
                return; 
              if (this.a.iv_two_level_indicate.getLayoutParams() == null)
                return; 
              FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.iv_two_level_indicate.getLayoutParams();
              layoutParams.topMargin = LiveFragment.e(this.a);
              this.a.iv_two_level_indicate.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              this.a.fl_two_level_indicate.setVisibility(0);
              this.a.fl_two_level_indicate.setOnClickListener(new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      this.a.a.fl_two_level_indicate.setVisibility(8);
                      BluedPreferences.dk();
                    }
                  });
            }
          }); 
  }
  
  public void c(String paramString) {
    if ("live".equals(paramString))
      ((LivePresenter)s()).m(); 
  }
  
  public void d(String paramString) {
    if ("live".equals(paramString))
      c(paramString); 
  }
  
  public void k() {
    LiveListFloatReddishBag liveListFloatReddishBag = this.mRedBagView;
    if (liveListFloatReddishBag != null)
      liveListFloatReddishBag.c(); 
  }
  
  public ViewPager l() {
    return (ViewPager)this.mViewPager;
  }
  
  public void o() {
    super.o();
    this.h = (Context)getActivity();
    m();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (!this.s)
      return; 
    if (paramInt2 == -1)
      if (paramInt1 != 100) {
        if (paramInt1 == 10111 && !TextUtils.isEmpty(paramIntent.getStringExtra("string_edit")))
          LiveRoomHttpUtils.b(paramIntent.getStringExtra("string_edit"), new BluedUIHttpResponse(this, (IRequestHost)w_()) {
                public boolean onUIFailure(int param1Int, String param1String) {
                  LiveFragment.a(this.a, Boolean.valueOf(true));
                  return super.onUIFailure(param1Int, param1String);
                }
                
                public void onUIFinish() {
                  if (LiveFragment.c(this.a).booleanValue()) {
                    LiveFragment.a(this.a, Boolean.valueOf(false));
                    AppMethods.a(LiveFragment.d(this.a).getString(2131756464));
                  } 
                  super.onUIFinish();
                }
                
                public void onUIUpdate(BluedEntity param1BluedEntity) {
                  AppMethods.a(this.a.getString(2131755118));
                }
              }(IRequestHost)w_()); 
      } else if (paramIntent != null && !"".equals(paramIntent.toString()) && !TextUtils.isEmpty("string_edit")) {
        String str1 = paramIntent.getStringExtra("string_edit");
        String str2 = paramIntent.getStringExtra("feed_id");
        ((LivePresenter)s()).a(str2, str1);
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      if (this.p)
        return; 
      this.p = true;
      EventTrackLive.a(LiveProtos.Event.LIVE_START_FROM_LIVELIST);
      InstantLog.a("live_start_from_livelist");
      ((LivePresenter)s()).m();
      this.mRightNewDot.setVisibility(8);
      ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)1), 7L);
      return;
    } 
    BluedPreferences.k(this.q);
    BluedPreferences.bt();
    this.ivRankingRemind.setVisibility(8);
    LiveRankWebViewFragment.a((Context)getActivity(), 0);
  }
  
  public void onDestroy() {
    super.onDestroy();
    HomeTabClick.b("live", this);
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    this.s = false;
    LiveListSetSelectedTab.a().b(this);
    LiveFloatRedBagViewScrollObserver.a().b(this);
  }
  
  public void onPause() {
    this.j = System.currentTimeMillis();
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    if (this.j != 0L) {
      if (System.currentTimeMillis() - this.j > 300000L)
        ((LivePresenter)s()).m(); 
      this.j = 0L;
    } 
    ImageView imageView = this.mTitleLeft;
    if (imageView != null)
      imageView.setImageDrawable(BluedSkinUtils.b(this.h, 2131232750)); 
    imageView = this.mTitleRight;
    if (imageView != null)
      imageView.setImageDrawable(BluedSkinUtils.b(this.h, 2131232742)); 
    this.o = BluedPreferences.bs();
    if (this.mViewPager.getCurrentItem() == 2) {
      this.mRedBagView.setVisibility(8);
      return;
    } 
    k();
  }
  
  public void onSessionDataChanged(SessionModel paramSessionModel) {
    if (!this.s)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("直播 sessionData.sessionType = ");
    stringBuilder.append(paramSessionModel.sessionType);
    stringBuilder.append(" -- sessionId = ");
    stringBuilder.append(paramSessionModel.sessionId);
    Log.v("pk", stringBuilder.toString());
    if (paramSessionModel.sessionType == 1 && paramSessionModel.sessionId == 7L)
      a(new Runnable(this) {
            public void run() {
              if (this.a.mRightNewDot != null)
                this.a.mRightNewDot.setVisibility(0); 
            }
          }); 
    if (paramSessionModel.sessionType == 1 && paramSessionModel.sessionId == 6L)
      a(new Runnable(this) {
            public void run() {
              if (this.a.indicator != null)
                this.a.indicator.a(2); 
            }
          }); 
  }
  
  public void onSessionRemoved(short paramShort, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("直播 onSessionRemoved sessionData.sessionType = ");
    stringBuilder.append(paramShort);
    stringBuilder.append(" -- sessionId = ");
    stringBuilder.append(paramLong);
    Log.v("pk", stringBuilder.toString());
    if (!this.s)
      return; 
    if (paramShort == 1 && paramLong == 7L)
      a(new Runnable(this) {
            public void run() {
              if (this.a.mRightNewDot != null)
                this.a.mRightNewDot.setVisibility(8); 
            }
          }); 
    if (paramShort == 1 && paramLong == 6L)
      a(new Runnable(this) {
            public void run() {
              if (this.a.indicator != null)
                this.a.indicator.c(2); 
            }
          }); 
  }
  
  public void onStart() {
    super.onStart();
    LiveListRefreshObserver.a().a(this);
    ChatHelperV4.a().e(this);
    ChatHelperV4.a().g(this);
  }
  
  public void onStop() {
    super.onStop();
    LiveListRefreshObserver.a().b(this);
    ChatHelperV4.a().f(this);
    ChatHelperV4.a().h(this);
  }
  
  public int p() {
    return 2131493167;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
      HomeTabClick.a("live", this); 
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    FragmentManager a;
    
    private String[] c = LiveFragment.d(this.b).getResources().getStringArray(2130903088);
    
    public MyAdapter(LiveFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
      this.a = param1FragmentManager;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.b.f;
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : new LiveListFollowFragmentNew()) : new LiveHomeFragment()) : LiveRecommendFragment.a("12", 0));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.c[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */