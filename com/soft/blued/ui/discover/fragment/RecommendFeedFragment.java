package com.soft.blued.ui.discover.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.das.client.feed.FeedProtos;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.AutoScrollViewPager;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.LinePageIndicator;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.discover.model.DiscoverPicture;
import com.soft.blued.ui.discover.model.DiscoverSquareExtra;
import com.soft.blued.ui.discover.presenter.RecommendFeedPresenter;
import com.soft.blued.ui.discover.view.DiscoveryEntryView;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.RefreshUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.pop.BluedPopupWindow;
import java.util.ArrayList;
import java.util.List;

public class RecommendFeedFragment extends MvpKeyBoardFragment<RecommendFeedPresenter> implements HomeTabClick.TabClickListener {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  @BindView(2131297080)
  ConstraintLayout flAds;
  
  @BindView(2131297488)
  ImageView imgGuide;
  
  @BindView(2131297592)
  LinePageIndicator indicator;
  
  @BindView(2131298122)
  View lineEntry;
  
  @BindView(2131298787)
  LinearLayout llEntry;
  
  @BindView(2131298800)
  FloatFooterView llFeedPost;
  
  @BindView(2131299605)
  RecyclerView mRecyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout mRefreshLayout;
  
  LayoutInflater n;
  
  @BindView(2131301664)
  NoDataAndLoadFailView noDataView;
  
  private FeedListAdapterForRecyclerView o;
  
  private Unbinder p;
  
  private ADViewHolder q = new ADViewHolder(this);
  
  private MyPagerAdapter r;
  
  @BindView(2131299730)
  RelativeLayout rlSquare;
  
  private List<View> s;
  
  private List<DiscoverPicture> t;
  
  private boolean u = false;
  
  private RecyclerView.OnScrollListener v = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (!this.a.t())
          return; 
        if (RecommendFeedFragment.a(this.a) != null && (RecommendFeedFragment.a(this.a)).p != null)
          (RecommendFeedFragment.a(this.a)).p.onScrollStateChanged(param1RecyclerView, param1Int); 
        if (this.a.llFeedPost != null && param1Int == 0) {
          if (!param1RecyclerView.canScrollVertically(-1)) {
            this.a.llFeedPost.a();
            return;
          } 
          if (!param1RecyclerView.canScrollVertically(1))
            this.a.llFeedPost.b(); 
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (!this.a.t())
          return; 
        if (RecommendFeedFragment.a(this.a) != null && (RecommendFeedFragment.a(this.a)).p != null)
          (RecommendFeedFragment.a(this.a)).p.onScrolled(param1RecyclerView, param1Int1, param1Int2); 
        if (param1Int2 < 0) {
          this.a.llFeedPost.a();
          return;
        } 
        if (param1Int2 > 0)
          this.a.llFeedPost.b(); 
      }
    };
  
  @BindView(2131299443)
  AutoScrollViewPager viewPagerAD;
  
  private BluedPopupWindow w;
  
  private void K() {
    if (BluedConfig.b().i() == null)
      return; 
    String str1 = BluedPreferences.aO();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((BluedConfig.b().i()).bubble_code);
    stringBuilder.append(UserInfo.a().i().getUid());
    String str2 = stringBuilder.toString();
    if (!TextUtils.isEmpty(str2) && str1.equals(str2))
      return; 
    BluedPreferences.z(str2);
    String str3 = (BluedConfig.b().i()).url;
    String str4 = (BluedConfig.b().i()).bubble_pic;
    if (TextUtils.isEmpty(str4))
      return; 
    EventTrackFeed.a(FeedProtos.Event.FEED_BUBBLE_SHOW, "", FeedProtos.FeedFrom.PUBLISH_PLAZA_RECOMMEND, "");
    this.imgGuide.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), str4).f().e(-1).a(new ImageLoadResult(this, (IRequestHost)w_(), str2, str1, str4, str3) {
          public void a() {
            if (!TextUtils.isEmpty(this.a) && this.b.equals(this.a))
              return; 
            this.e.imgGuide.setVisibility(0);
            this.e.imgGuide.setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    EventTrackFeed.a(FeedProtos.Event.FEED_BUBBLE_CLICK, "", FeedProtos.FeedFrom.PUBLISH_PLAZA_RECOMMEND, "");
                    InstantLog.a("square_bubble_click", this.a.c);
                    WebViewShowInfoFragment.show(this.a.e.getContext(), this.a.d, 0);
                    this.a.e.imgGuide.setVisibility(8);
                  }
                });
          }
          
          public void a(int param1Int, Exception param1Exception) {
            this.e.imgGuide.setVisibility(8);
          }
        }).a(this.imgGuide);
    InstantLog.a("square_bubble_show", str4);
  }
  
  private void L() {
    InstantLog.b("feed_post_btn_click", 1);
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_PLAZA_RECOMMEND);
    FeedPostFragment.a(getContext(), true);
  }
  
  private void b(boolean paramBoolean) {
    I();
    this.mRefreshLayout.g();
    this.mRefreshLayout.h();
    if (this.o.n().size() > 0) {
      this.noDataView.c();
      return;
    } 
    if (paramBoolean) {
      this.noDataView.a();
      return;
    } 
    this.noDataView.b();
  }
  
  private void c(List<DiscoverPicture> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.t.clear();
      for (int i = 0; i < paramList.size(); i++)
        this.t.add(paramList.get(i)); 
      H();
      this.r = new MyPagerAdapter(this);
      this.viewPagerAD.setAdapter(this.r);
      this.viewPagerAD.c(3000);
      this.viewPagerAD.setInterval(3000L);
      this.indicator.setViewPager((ViewPager)this.viewPagerAD);
      if (this.s.size() > 0) {
        if (this.s.size() == 1) {
          this.indicator.setVisibility(8);
        } else {
          this.indicator.setVisibility(0);
        } 
        this.flAds.setVisibility(0);
        return;
      } 
      this.flAds.setVisibility(8);
      return;
    } 
    this.flAds.setVisibility(8);
  }
  
  public boolean A() {
    return true;
  }
  
  public void E() {
    this.llFeedPost.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            RecommendFeedFragment.b(this.a);
          }
        });
    this.llFeedPost.setBtnAnimatorUpdateListener(new FloatFooterView.BtnAnimatorUpdateListener(this) {
          public void a(ValueAnimator param1ValueAnimator) {
            if (this.a.imgGuide != null) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.imgGuide.getLayoutParams();
              layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
              this.a.imgGuide.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            } 
          }
        });
    if (this.o == null)
      this.o = new FeedListAdapterForRecyclerView(new ArrayList(), getContext(), (IRequestHost)w_(), this.mRecyclerView, 6); 
    ((RecommendFeedPresenter)s()).a(this.o);
    this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.o);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.mRecyclerView.addOnScrollListener(this.v);
    this.mRefreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((RecommendFeedPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((RecommendFeedPresenter)this.a.s()).e();
          }
        });
    K();
  }
  
  public void F() {
    this.noDataView.c();
  }
  
  public void G() {
    this.flAds.setVisibility(8);
  }
  
  public void H() {
    this.s.clear();
    for (int i = 0; i < this.t.size(); i++) {
      DiscoverPicture discoverPicture = this.t.get(i);
      View view = this.n.inflate(2131493598, null);
      this.p = ButterKnife.a(this.q, view);
      if (discoverPicture.is_show_adm_icon == 1) {
        this.q.img_ad_icon.setVisibility(0);
      } else {
        this.q.img_ad_icon.setVisibility(8);
      } 
      ImageLoader.a((IRequestHost)w_(), discoverPicture.image).a(2131230924).a(this.q.img_ad);
      this.q.img_ad.setOnClickListener(new View.OnClickListener(this, discoverPicture) {
            public void onClick(View param1View) {
              DiscoverPicture discoverPicture = this.a;
              if (discoverPicture != null && discoverPicture.click_url != null)
                for (int i = 0; i < this.a.click_url.length; i++)
                  FindHttpUtils.a(this.a.click_url[i]);  
              if (!StringUtils.e(this.a.url)) {
                EventTrackFeed.b(FeedProtos.Event.FIND_PLAZA_BANNER_CLICK, this.a.url);
                WebViewShowInfoFragment.show(this.b.getContext(), this.a.url, 9);
              } 
            }
          });
      this.s.add(view);
    } 
  }
  
  public void I() {
    MyPagerAdapter myPagerAdapter = this.r;
    if (myPagerAdapter != null && myPagerAdapter.getCount() > 0) {
      this.viewPagerAD.setCurrentItem(0);
      this.indicator.a((ViewPager)this.viewPagerAD, 0);
    } 
  }
  
  public void J() {
    if (!BluedPreferences.eE())
      return; 
    if (this.w == null) {
      View view = View.inflate(getContext(), 2131494035, null);
      this.w = BluedPopupWindow.Builder.a((Activity)getContext(), view).a(true).a();
      this.w.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
            public void onDismiss() {
              RecommendFeedFragment.a(this.a, (BluedPopupWindow)null);
            }
          });
      view.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              RecommendFeedFragment.e(this.a).dismiss();
            }
          });
      this.w.a((View)this.llEntry, 2, 3, 0, -DensityUtils.a(getContext(), 9.0F));
      view.postDelayed(new Runnable(this) {
            public void run() {
              if (RecommendFeedFragment.e(this.a) != null && RecommendFeedFragment.e(this.a).isShowing())
                RecommendFeedFragment.e(this.a).dismiss(); 
            }
          },  3000L);
      BluedPreferences.eD();
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.t = new ArrayList<DiscoverPicture>();
    this.s = new ArrayList<View>();
    this.n = LayoutInflater.from(getContext());
    F();
    E();
  }
  
  public void a(String paramString, List paramList) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial a : (Ljava/lang/String;Ljava/util/List;)V
    //   6: aload_1
    //   7: invokevirtual hashCode : ()I
    //   10: istore_3
    //   11: iload_3
    //   12: ldc_w -2109989095
    //   15: if_icmpeq -> 43
    //   18: iload_3
    //   19: ldc_w -1542303787
    //   22: if_icmpeq -> 28
    //   25: goto -> 58
    //   28: aload_1
    //   29: ldc_w 'discover_picture_list'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 58
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -> 60
    //   43: aload_1
    //   44: ldc_w 'delete_circle_feed'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 58
    //   53: iconst_1
    //   54: istore_3
    //   55: goto -> 60
    //   58: iconst_m1
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq -> 85
    //   64: iload_3
    //   65: iconst_1
    //   66: if_icmpeq -> 70
    //   69: return
    //   70: aload_2
    //   71: ldc java/lang/String
    //   73: new com/soft/blued/ui/discover/fragment/RecommendFeedFragment$7
    //   76: dup
    //   77: aload_0
    //   78: invokespecial <init> : (Lcom/soft/blued/ui/discover/fragment/RecommendFeedFragment;)V
    //   81: invokestatic a : (Ljava/util/List;Ljava/lang/Class;Lcom/blued/android/framework/ui/mvp/MvpUtils$DataHandler;)V
    //   84: return
    //   85: aload_2
    //   86: ldc_w com/soft/blued/ui/discover/model/DiscoverPicture
    //   89: new com/soft/blued/ui/discover/fragment/RecommendFeedFragment$6
    //   92: dup
    //   93: aload_0
    //   94: invokespecial <init> : (Lcom/soft/blued/ui/discover/fragment/RecommendFeedFragment;)V
    //   97: invokestatic a : (Ljava/util/List;Ljava/lang/Class;Lcom/blued/android/framework/ui/mvp/MvpUtils$DataListHandler;)V
    //   100: return
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -1290256561) {
      if (i == 623698297 && paramString.equals("_load_type_loadmore_"))
        b = 1; 
    } else if (paramString.equals("_load_type_refresh_")) {
      b = 0;
    } 
    if (b != 0 && b != 1)
      return; 
    b(paramBoolean);
  }
  
  protected void a(List<DiscoverSquareExtra.Explore> paramList) {
    this.llEntry.removeAllViews();
    for (DiscoverSquareExtra.Explore explore : paramList) {
      DiscoveryEntryView discoveryEntryView = new DiscoveryEntryView(getContext(), (IRequestHost)w_());
      discoveryEntryView.a(explore, (IRequestHost)w_());
      this.llEntry.addView((View)discoveryEntryView);
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)discoveryEntryView.getLayoutParams();
      layoutParams.width = 0;
      layoutParams.weight = 1.0F;
      discoveryEntryView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      discoveryEntryView.a(explore, (IRequestHost)w_());
    } 
    this.lineEntry.setVisibility(0);
    J();
  }
  
  public void aL_() {
    super.aL_();
    Unbinder unbinder = this.p;
    if (unbinder != null) {
      unbinder.unbind();
      this.p = null;
    } 
    RecyclerView recyclerView = this.mRecyclerView;
    if (recyclerView != null)
      recyclerView.removeOnScrollListener(this.v); 
  }
  
  protected void b(List<BluedIngSelfFeed> paramList) {
    this.o.c(paramList);
  }
  
  public void c(String paramString) {
    if ("feed".equals(paramString) && this.mRefreshLayout != null) {
      RecyclerView recyclerView = this.mRecyclerView;
      if (recyclerView != null) {
        recyclerView.scrollToPosition(0);
        RefreshUtils.a(this.appbar);
        this.mRefreshLayout.d(100);
      } 
    } 
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  public void onDestroy() {
    HomeTabClick.b("feed", this);
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.o;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.c(); 
  }
  
  public void onResume() {
    super.onResume();
    LinearLayout linearLayout = this.llEntry;
    if (linearLayout != null) {
      int j = linearLayout.getChildCount();
      for (int i = 0; i < j; i++) {
        View view = this.llEntry.getChildAt(i);
        if (view instanceof DiscoveryEntryView)
          ((DiscoveryEntryView)view).a((IRequestHost)w_()); 
      } 
    } 
    if (this.o != null && getUserVisibleHint())
      this.o.b(); 
    if (getUserVisibleHint())
      HomeTabClick.a("feed", this); 
  }
  
  public int p() {
    return 2131493281;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      HomeTabClick.a("feed", this);
      if (!this.u) {
        InstantLog.b("first_auto_load", 2);
        this.u = true;
      } 
    } 
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.o;
    if (feedListAdapterForRecyclerView != null) {
      if (paramBoolean) {
        feedListAdapterForRecyclerView.b();
        return;
      } 
      feedListAdapterForRecyclerView.c();
    } 
  }
  
  public void u() {
    this.mRefreshLayout.i();
  }
  
  public void y() {
    this.mRefreshLayout.b(false);
    AppMethods.a(getContext().getResources().getString(2131758247));
  }
  
  public boolean z() {
    return true;
  }
  
  class ADViewHolder {
    @BindView(2131297419)
    ImageView img_ad;
    
    @BindView(2131297421)
    ImageView img_ad_icon;
    
    ADViewHolder(RecommendFeedFragment this$0) {}
  }
  
  public class MyPagerAdapter extends PagerAdapter {
    public MyPagerAdapter(RecommendFeedFragment this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return (RecommendFeedFragment.c(this.a) != null) ? RecommendFeedFragment.c(this.a).size() : 0;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      param1ViewGroup.addView(RecommendFeedFragment.c(this.a).get(param1Int));
      DiscoverPicture discoverPicture = RecommendFeedFragment.d(this.a).get(param1Int);
      if (!discoverPicture.isShowUrlVisited && discoverPicture.show_url != null && discoverPicture.show_url.length > 0) {
        for (int i = 0; i < discoverPicture.show_url.length; i++)
          FindHttpUtils.a(discoverPicture.show_url[i]); 
        discoverPicture.isShowUrlVisited = true;
      } 
      return RecommendFeedFragment.c(this.a).get(param1Int);
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\RecommendFeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */