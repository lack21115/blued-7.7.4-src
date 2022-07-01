package com.soft.blued.ui.circle.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.RotateLayout;
import com.soft.blued.customview.TextViewFixTouchForDynamic;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.adapter.CircleDetailsTalkAdapter;
import com.soft.blued.ui.circle.model.CircleAdModel;
import com.soft.blued.ui.circle.model.CircleBubble;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.presenter.CircleDetailsPresenter;
import com.soft.blued.ui.circle.view.CircleJoinView;
import com.soft.blued.ui.circle.view.GroupJoinView;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.ShareToFragment;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.pop.CircleGroupListPop;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.MarkDownLinkHelper;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CircleDetailsFragment extends MvpFragment<CircleDetailsPresenter> {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  @BindView(2131296752)
  CircleJoinView cjvJoin;
  
  @BindView(2131296753)
  CircleJoinView cjvJoinScroll;
  
  @BindView(2131296754)
  ShapeLinearLayout cjvJoinStroke;
  
  @BindView(2131296755)
  CircleJoinView cjvJoinView;
  
  @BindView(2131296761)
  ConstraintLayout clHeader;
  
  @BindView(2131296843)
  CoordinatorLayout coordinator;
  
  public AnimationSet d;
  
  public boolean e = false;
  
  private CircleDetailsTalkAdapter f;
  
  @BindView(2131297053)
  FloatFooterView ffvPost;
  
  @BindView(2131297099)
  FrameLayout flContent;
  
  @BindView(2131297111)
  FrameLayout flHeaderBottom;
  
  @BindView(2131297168)
  FrameLayout flTopWhite;
  
  private NoDataAndLoadFailView g;
  
  @BindView(2131297295)
  GroupJoinView group_join;
  
  private View h;
  
  @BindView(2131297358)
  ClassicsHeader header;
  
  private Context i;
  
  @BindView(2131297488)
  ImageView imgGuide;
  
  @BindView(2131297490)
  ImageView imgHeader;
  
  @BindView(2131297568)
  ImageView imgTopBg;
  
  @BindView(2131297669)
  ImageView ivActiveList;
  
  @BindView(2131297670)
  ImageView ivActiveListHelp;
  
  @BindView(2131297671)
  ImageView ivAdBanner;
  
  @BindView(2131297879)
  ImageView ivNoPermission;
  
  @BindView(2131297880)
  ImageView ivNumber;
  
  @BindView(2131297881)
  ImageView ivNumberScroll;
  
  @BindView(2131297947)
  ImageView ivTopBg;
  
  private int j;
  
  @BindView(2131298097)
  FrameLayout layoutTitleScroll;
  
  @BindView(2131298691)
  LinearLayout llActiveHeader;
  
  @BindView(2131298692)
  LinearLayout llActiveHeaderAll;
  
  @BindView(2131298694)
  LinearLayout llActiveList;
  
  @BindView(2131298896)
  LinearLayout llIsTop1;
  
  @BindView(2131298897)
  LinearLayout llIsTop2;
  
  @BindView(2131298898)
  LinearLayout llIsTop3;
  
  @BindView(2131299102)
  LinearLayout llTitle;
  
  @BindView(2131299104)
  LinearLayout llTitleScroll;
  
  @BindView(2131299753)
  FrameLayout mRootView;
  
  private int n;
  
  @BindView(2131299391)
  NoDataAndLoadFailView noPermissionView;
  
  private float o;
  
  private SkeletonScreen p;
  
  private Timer q;
  
  private int r = 0;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299756)
  RotateLayout rotateLayout;
  
  private List<BluedIngSelfFeed> s = new ArrayList<BluedIngSelfFeed>();
  
  @BindView(2131299914)
  ShapeConstraintLayout sclNoPermission;
  
  @BindView(2131299976)
  ShapeLinearLayout sllIsTop;
  
  @BindView(2131299978)
  ShapeLinearLayout sllListTitle;
  
  @BindView(2131299981)
  ShapeLinearLayout sllTab;
  
  @BindView(2131300089)
  ShapeTextView stvEssence;
  
  @BindView(2131300099)
  ShapeTextView stvHot;
  
  @BindView(2131300104)
  ShapeTextView stvNew;
  
  private List<BluedIngSelfFeed> t = new ArrayList<BluedIngSelfFeed>();
  
  @BindView(2131300283)
  View titleScrollBg;
  
  @BindView(2131300284)
  ImageView titleScrollLeft;
  
  @BindView(2131300285)
  CommonTopTitleNoTrans titleStill;
  
  @BindView(2131300299)
  View topLine;
  
  @BindView(2131300484)
  TextView tvActiveList;
  
  @BindView(2131300663)
  TextViewFixTouchForDynamic tvContent;
  
  @BindView(2131300922)
  TextView tvIsTopTitle1;
  
  @BindView(2131300923)
  TextView tvIsTopTitle2;
  
  @BindView(2131300924)
  TextView tvIsTopTitle3;
  
  @BindView(2131301088)
  TextView tvName;
  
  @BindView(2131301093)
  TextView tvNameScroll;
  
  @BindView(2131301127)
  TextView tvNumber;
  
  @BindView(2131301128)
  TextView tvNumberScroll;
  
  @BindView(2131301439)
  TextView tvTopWhite;
  
  private List<BluedIngSelfFeed> u = new ArrayList<BluedIngSelfFeed>();
  
  private AppBarLayout.OnOffsetChangedListener v = new AppBarLayout.OnOffsetChangedListener(this) {
      public void onOffsetChanged(AppBarLayout param1AppBarLayout, int param1Int) {
        int i = this.a.appbar.getHeight() - DensityUtils.a(CircleDetailsFragment.a(this.a), 60.0F);
        int j = Math.abs(param1Int);
        if (j > 0)
          this.a.rotateLayout.setVisibility(8); 
        float f = Math.min(j, i) * 1.0F / i;
        this.a.flTopWhite.setAlpha(f);
        this.a.titleStill.setAlpha(1.0F - f);
        this.a.layoutTitleScroll.setAlpha(f);
        if (f < 0.2F) {
          this.a.cjvJoinScroll.setClickable(false);
        } else {
          this.a.cjvJoinScroll.setClickable(true);
        } 
        i = Math.abs(CircleDetailsFragment.i(this.a) - param1Int);
        if (CircleDetailsFragment.i(this.a) < param1Int && i > 10) {
          this.a.ffvPost.a();
        } else if (CircleDetailsFragment.i(this.a) > param1Int && i > 10) {
          this.a.ffvPost.b();
        } 
        CircleDetailsFragment.a(this.a, param1Int);
        if (this.a.sclNoPermission != null && this.a.sclNoPermission.getVisibility() == 0) {
          param1Int = this.a.appbar.getHeight();
          i = this.a.sllIsTop.getHeight();
          j = this.a.sllListTitle.getHeight();
          int k = this.a.flTopWhite.getHeight();
          int m = this.a.layoutTitleScroll.getHeight();
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.sclNoPermission.getLayoutParams();
          marginLayoutParams.width = -1;
          marginLayoutParams.height = AppInfo.m;
          marginLayoutParams.topMargin = param1Int - i - j + k + m;
          this.a.sclNoPermission.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
        } 
      }
    };
  
  private RecyclerView.OnScrollListener w = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (this.a.ffvPost != null && param1Int == 0) {
          if (!param1RecyclerView.canScrollVertically(-1))
            return; 
          if (!param1RecyclerView.canScrollVertically(1))
            this.a.ffvPost.b(); 
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (this.a.ffvPost != null) {
          if (param1Int2 < 0) {
            this.a.ffvPost.a();
            return;
          } 
          if (param1Int2 > 0)
            this.a.ffvPost.b(); 
        } 
      }
    };
  
  private boolean x = false;
  
  private void E() {
    this.ffvPost.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_CIRCLE_NOTE);
            CircleDetailsFragment.a(this.a, (CircleBubble)null);
          }
        });
    this.ffvPost.setBtnAnimatorUpdateListener(new FloatFooterView.BtnAnimatorUpdateListener(this) {
          public void a(ValueAnimator param1ValueAnimator) {
            if (this.a.imgGuide != null) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.imgGuide.getLayoutParams();
              layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
              this.a.imgGuide.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            } 
          }
        });
  }
  
  private void F() {
    if (this.d != null) {
      this.cjvJoinStroke.setVisibility(8);
      this.q.cancel();
      this.d.setRepeatMode(0);
      this.d.cancel();
      this.cjvJoinStroke.clearAnimation();
    } 
  }
  
  private void G() {
    ShapeHelper.b((ShapeHelper.ShapeView)this.sllListTitle, 2131100728);
    ShapeHelper.b((ShapeHelper.ShapeView)this.sllTab, 2131100881);
    ShapeHelper.a((ShapeHelper.ShapeView)this.stvNew, 2131100838);
    ShapeHelper.a((ShapeHelper.ShapeView)this.stvHot, 2131100838);
    ShapeHelper.a((ShapeHelper.ShapeView)this.stvEssence, 2131100838);
    this.stvNew.setOnClickListener(new -$$Lambda$CircleDetailsFragment$h0e_aFXd06pI2GQhKiSL2GARiss(this));
    this.stvHot.setOnClickListener(new -$$Lambda$CircleDetailsFragment$LPtkaCLYDHEWXupEtv-zp2F63XE(this));
    this.stvEssence.setOnClickListener(new -$$Lambda$CircleDetailsFragment$XOIEe9OJWSyvfkMHuWB-LED8bPA(this));
    L();
  }
  
  private void H() {
    this.recyclerView.setBackgroundColor(BluedSkinUtils.a(this.i, 2131100728));
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.f = new CircleDetailsTalkAdapter(getContext(), (IRequestHost)w_());
    this.g = new NoDataAndLoadFailView(this.i);
    this.g.setNoDataImg(2131232633);
    this.g.setNoDataStr(2131755868);
    this.f.e((View)this.g);
    this.h = View.inflate(this.i, 2131493768, null);
    this.h.setVisibility(8);
    this.f.c(this.h);
    this.f.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((CircleDetailsPresenter)this.a.s()).f();
          }
        },  this.recyclerView);
    this.f.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            MessageProtos.StrangerSource strangerSource;
            int i = param1View.getId();
            if (i != 2131299371 && i != 2131299375)
              return; 
            BluedIngSelfFeed bluedIngSelfFeed = CircleDetailsFragment.c(this.a).n().get(param1Int);
            if (bluedIngSelfFeed.is_anonym == 1) {
              AppMethods.d(2131755842);
              return;
            } 
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.uid = bluedIngSelfFeed.feed_uid;
            userBasicModel.name = bluedIngSelfFeed.user_name;
            userBasicModel.avatar = bluedIngSelfFeed.user_avatar;
            userBasicModel.is_show_vip_page = bluedIngSelfFeed.is_show_vip_page;
            String str = EncryptTool.b(bluedIngSelfFeed.feed_id);
            if (((CircleDetailsPresenter)this.a.s()).m()) {
              strangerSource = MessageProtos.StrangerSource.CIRCLE_DETAIL_NOTE_NEW;
            } else {
              strangerSource = MessageProtos.StrangerSource.CIRCLE_DETAIL_NOTE_HOT;
            } 
            UserInfoFragmentNew.a(CircleDetailsFragment.a(this.a), userBasicModel, "CIRCLE_DETAIL", null, null, new MsgSourceEntity(strangerSource, str));
          }
        });
    this.f.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            BluedIngSelfFeed bluedIngSelfFeed = CircleDetailsFragment.c(this.a).n().get(param1Int);
            bluedIngSelfFeed.circle_title = (((CircleDetailsPresenter)this.a.s()).t()).title;
            bluedIngSelfFeed.admin_level = (((CircleDetailsPresenter)this.a.s()).t()).admin_level;
            bluedIngSelfFeed.cover = (((CircleDetailsPresenter)this.a.s()).t()).cover;
            bluedIngSelfFeed.members_num = (((CircleDetailsPresenter)this.a.s()).t()).members_num;
            param1Int = ((CircleDetailsPresenter)this.a.s()).n();
            if (param1Int != 0) {
              if (param1Int != 1) {
                if (param1Int != 2)
                  return; 
                CirclePostDetailsFragment.a(this.a.getContext(), bluedIngSelfFeed, FeedProtos.NoteSource.CIRCLE_ESSENCE);
                return;
              } 
              CirclePostDetailsFragment.a(this.a.getContext(), bluedIngSelfFeed, FeedProtos.NoteSource.CIRCLE_HOT);
              return;
            } 
            CirclePostDetailsFragment.a(this.a.getContext(), bluedIngSelfFeed, FeedProtos.NoteSource.CIRCLE_NEW);
          }
        });
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.f);
  }
  
  private void I() {
    View.OnClickListener onClickListener = new View.OnClickListener(this) {
        public void onClick(View param1View) {
          CircleDetailsFragment.d(this.a);
        }
      };
    this.titleScrollLeft.setOnClickListener(onClickListener);
    this.titleStill.getLeftImg().setOnClickListener(onClickListener);
    this.titleStill.a();
    this.titleStill.getRightImg().setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.titleStill.getAlpha() >= 0.9F) {
              EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_MANAGE_SHOW, ((CircleDetailsPresenter)this.a.s()).p());
              CircleDetailsFragment.e(this.a);
            } 
          }
        });
  }
  
  private void J() {
    ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
    BasePopupView basePopupView = CommonShowBottomWindow.a(getContext(), arrayList);
    BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
    menuItemInfo.a = this.i.getResources().getString(2131755894);
    menuItemInfo.c = new View.OnClickListener(this, basePopupView) {
        public void onClick(View param1View) {
          EventTrackFeed.f(FeedProtos.Event.CIRCLE_USER_MANAGE_INVITE_CLICK, ((CircleDetailsPresenter)this.b.s()).p());
          ShareToFragment.a(CircleDetailsFragment.a(this.b), ((CircleDetailsPresenter)this.b.s()).p());
          BasePopupView basePopupView = this.a;
          if (basePopupView != null)
            basePopupView.p(); 
        }
      };
    arrayList.add(menuItemInfo);
    basePopupView.h();
  }
  
  private void K() {
    this.j = StatusBarHelper.a(this.i);
    ShapeHelper.b((ShapeHelper.ShapeView)this.sllIsTop, 2131100728);
    this.titleStill.setAlpha(1.0F);
    FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams)this.titleStill.getLayoutParams();
    layoutParams1.topMargin = this.j;
    this.titleStill.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    M();
    layoutParams1 = (FrameLayout.LayoutParams)this.rotateLayout.getLayoutParams();
    layoutParams1.topMargin += this.j;
    this.rotateLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.flTopWhite.getLayoutParams();
    layoutParams.height = this.j;
    this.flTopWhite.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.flTopWhite.setAlpha(0.0F);
    this.layoutTitleScroll.setAlpha(0.0F);
    this.cjvJoinScroll.setClickable(false);
    this.cjvJoin.setStyle(1);
    this.cjvJoinScroll.setStyle(1);
    this.appbar.a(this.v);
    this.recyclerView.addOnScrollListener(this.w);
    this.refreshLayout.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshHeader param1RefreshHeader, boolean param1Boolean, float param1Float, int param1Int1, int param1Int2, int param1Int3) {
            if (this.a.imgTopBg != null) {
              this.a.rotateLayout.d();
              this.a.rotateLayout.a(-6.0F);
              FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.imgTopBg.getLayoutParams();
              param1Int2 = AppInfo.l;
              param1Int1 = (int)(param1Int1 * 1.3F);
              layoutParams.width = param1Int2 + param1Int1;
              float f = layoutParams.width;
              if (CircleDetailsFragment.h(this.a) > 0.0F) {
                param1Float = CircleDetailsFragment.h(this.a);
              } else {
                param1Float = 0.72F;
              } 
              layoutParams.height = (int)(f * param1Float);
              layoutParams.leftMargin = -param1Int1 / 2;
              this.a.imgTopBg.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            } 
          }
          
          public void a(RefreshLayout param1RefreshLayout, RefreshState param1RefreshState1, RefreshState param1RefreshState2) {
            if (param1RefreshState2 == RefreshState.b) {
              if (this.a.rotateLayout != null) {
                this.a.rotateLayout.setVisibility(0);
                this.a.titleStill.getRightImg().setVisibility(8);
                return;
              } 
            } else if ((param1RefreshState2 == RefreshState.d || param1RefreshState2 == RefreshState.a) && this.a.rotateLayout != null) {
              this.a.rotateLayout.setVisibility(8);
              if (((CircleDetailsPresenter)this.a.s()).s())
                this.a.titleStill.getRightImg().setVisibility(0); 
            } 
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((CircleDetailsPresenter)this.a.s()).e();
            CircleDetailsFragment.f(this.a).setVisibility(8);
            CircleDetailsFragment.g(this.a);
          }
        });
  }
  
  private void L() {
    int i = ((CircleDetailsPresenter)s()).n();
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_TAB_BTN_SHOW, FeedProtos.TabType.ESSENCE_CICLE);
        ShapeHelper.b((ShapeHelper.ShapeView)this.stvEssence, 2131100882);
        ShapeHelper.b((ShapeHelper.ShapeView)this.stvNew, 2131100881);
        ShapeHelper.b((ShapeHelper.ShapeView)this.stvHot, 2131100881);
        return;
      } 
      EventTrackFeed.a(FeedProtos.Event.CIRCLE_TAB_BTN_SHOW, FeedProtos.TabType.HOT_CIRCLE);
      ShapeHelper.b((ShapeHelper.ShapeView)this.stvHot, 2131100882);
      ShapeHelper.b((ShapeHelper.ShapeView)this.stvNew, 2131100881);
      ShapeHelper.b((ShapeHelper.ShapeView)this.stvEssence, 2131100881);
      return;
    } 
    EventTrackFeed.a(FeedProtos.Event.CIRCLE_TAB_BTN_SHOW, FeedProtos.TabType.NEW_CIRCLE);
    ShapeHelper.b((ShapeHelper.ShapeView)this.stvNew, 2131100882);
    ShapeHelper.b((ShapeHelper.ShapeView)this.stvHot, 2131100881);
    ShapeHelper.b((ShapeHelper.ShapeView)this.stvEssence, 2131100881);
  }
  
  private void M() {
    int i = AppInfo.l;
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.imgTopBg.getLayoutParams();
    layoutParams.width = i;
    layoutParams.height = i + DensityUtils.a(this.i, 50.0F);
    this.imgTopBg.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.o = layoutParams.height * 1.0F / layoutParams.width;
  }
  
  private void N() {
    getActivity().finish();
  }
  
  public static void a(Context paramContext, MyCircleModel paramMyCircleModel, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE) {
    if (paramMyCircleModel == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("circle_data", (Serializable)paramMyCircleModel);
    bundle.putSerializable("circle_from_page", (Serializable)paramCIRCLE_FROM_PAGE);
    bundle.putSerializable("circle_classify_id", Integer.valueOf(paramMyCircleModel.classify_id));
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, CircleDetailsFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt) {
    a(paramContext, paramString, (String)null, 0, CircleConstants.CIRCLE_FROM_PAGE.FEED_LIST_ADAPTER, 0, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE, int paramInt2) {
    if (TextUtils.isEmpty(paramString))
      return; 
    Bundle bundle = new Bundle();
    bundle.putString("circle_id", paramString);
    bundle.putInt("circle_details_tab", paramInt1);
    bundle.putSerializable("circle_from_page", (Serializable)paramCIRCLE_FROM_PAGE);
    bundle.putInt("h5_from", paramInt2);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, CircleDetailsFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE) {
    a(paramContext, paramString, (String)null, 0, paramCIRCLE_FROM_PAGE, 0, 0);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE, int paramInt2, int paramInt3) {
    if (TextUtils.isEmpty(paramString1))
      return; 
    Bundle bundle = new Bundle();
    bundle.putString("circle_id", paramString1);
    bundle.putString("feed_id", paramString2);
    bundle.putInt("circle_details_tab", paramInt1);
    bundle.putSerializable("circle_from_page", (Serializable)paramCIRCLE_FROM_PAGE);
    bundle.putInt("notify_from", paramInt2);
    bundle.putInt("feed_from", paramInt3);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, CircleDetailsFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE) {
    a(paramContext, paramString1, paramString2, 0, paramCIRCLE_FROM_PAGE, 0, 0);
  }
  
  private void a(MyCircleModel paramMyCircleModel) {
    SkeletonScreen skeletonScreen = this.p;
    if (skeletonScreen != null)
      skeletonScreen.a(); 
    if (paramMyCircleModel == null)
      return; 
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(paramMyCircleModel.cover)).a(2131231281).a(new ImageLoadResult(this, (IRequestHost)w_(), paramMyCircleModel) {
          private void d() {
            if (this.b.layoutTitleScroll != null && this.b.tvTopWhite != null && this.b.ivTopBg != null) {
              int i = CircleDetailsFragment.a(this.b).getResources().getColor(2131100795);
              this.b.layoutTitleScroll.setBackgroundColor(i);
              this.b.tvTopWhite.setBackgroundColor(i);
            } 
          }
          
          public void a() {
            ImageFileLoader.a((IRequestHost)this.b.w_()).b(AvatarUtils.a(this.a.cover)).a(new ImageFileLoader.OnLoadFileListener(this) {
                  public void onUIFinish(File param2File, Exception param2Exception) {
                    if (param2File != null && param2File.exists()) {
                      Bitmap bitmap = BitmapFactory.decodeFile(param2File.getPath());
                    } else {
                      param2File = null;
                    } 
                    if (param2File != null) {
                      Palette.from((Bitmap)param2File).generate(new Palette.PaletteAsyncListener(this) {
                            public void onGenerated(Palette param3Palette) {
                              if (param3Palette != null) {
                                Palette.Swatch swatch = param3Palette.getLightVibrantSwatch();
                                if (swatch != null) {
                                  int i = swatch.getRgb();
                                  if (this.a.a.b.layoutTitleScroll != null && this.a.a.b.tvTopWhite != null && this.a.a.b.ivTopBg != null) {
                                    this.a.a.b.layoutTitleScroll.setBackgroundColor(i);
                                    this.a.a.b.tvTopWhite.setBackgroundColor(i);
                                    this.a.a.b.ivTopBg.setBackgroundColor(i);
                                    return;
                                  } 
                                } else {
                                  CircleDetailsFragment.null.a(this.a.a);
                                  return;
                                } 
                              } else {
                                CircleDetailsFragment.null.a(this.a.a);
                              } 
                            }
                          });
                      return;
                    } 
                    CircleDetailsFragment.null.a(this.a);
                  }
                }).a();
          }
          
          public void a(int param1Int, Exception param1Exception) {
            d();
          }
        }).a(this.imgTopBg);
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, paramMyCircleModel.cover)).a(2131231281).a(6.0F).a(this.imgHeader);
    int j = paramMyCircleModel.cover_is_auditing;
    int i = 1;
    if (j == 1) {
      this.flHeaderBottom.setVisibility(0);
    } else {
      this.flHeaderBottom.setVisibility(8);
    } 
    this.tvName.setText(paramMyCircleModel.title);
    this.tvNameScroll.setText(paramMyCircleModel.title);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramMyCircleModel.members_num);
    stringBuilder1.append(this.i.getString(2131757871));
    String str2 = stringBuilder1.toString();
    this.tvNumber.setText(str2);
    this.tvNumberScroll.setText(str2);
    this.ivNumber.setVisibility(0);
    this.ivNumberScroll.setVisibility(0);
    if (paramMyCircleModel.active_list_is_show == 1) {
      this.llActiveList.setVisibility(0);
      if (paramMyCircleModel.active_list_open == 1) {
        this.ivActiveList.setImageResource(2131231260);
        this.tvActiveList.setTextColor(getResources().getColor(2131100728));
        this.ivActiveListHelp.setVisibility(8);
        this.llActiveHeaderAll.setVisibility(0);
        ArrayList<String> arrayList = new ArrayList();
        if (paramMyCircleModel.active_list_top != null && paramMyCircleModel.active_list_top.length > 0)
          arrayList.addAll(Arrays.asList(paramMyCircleModel.active_list_top)); 
        while (arrayList.size() < 3)
          arrayList.add(""); 
        this.llActiveHeader.removeAllViews();
        for (String str : arrayList) {
          ImageView imageView = new ImageView(this.i);
          ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(DensityUtils.a(this.i, 19.0F), DensityUtils.a(this.i, 19.0F));
          if (!i)
            marginLayoutParams.leftMargin = -DensityUtils.a(this.i, 7.0F); 
          imageView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          this.llActiveHeader.addView((View)imageView);
          ImageLoader.a((IRequestHost)w_(), str).a(2131234358).c(2131234358).c().a(1.0F, this.i.getResources().getColor(2131100728)).a(imageView);
          i = 0;
        } 
        this.llActiveList.setOnClickListener(new View.OnClickListener(this, paramMyCircleModel) {
              public void onClick(View param1View) {
                EventTrackFeed.f(FeedProtos.Event.CIRCLE_ACTIVE_MEMBER_CLICK, this.a.circle_id);
                WebViewShowInfoFragment.show(CircleDetailsFragment.a(this.b), H5Url.a(54, new Object[] { EncryptTool.b(this.a.circle_id) }));
              }
            });
      } else {
        this.ivActiveList.setImageResource(2131231258);
        this.tvActiveList.setTextColor(getResources().getColor(2131100842));
        this.ivActiveListHelp.setVisibility(0);
        this.llActiveHeaderAll.setVisibility(8);
        this.llActiveList.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                AppMethods.d(2131755831);
              }
            });
      } 
    } else {
      this.llActiveList.setVisibility(8);
    } 
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramMyCircleModel) {
        public void onClick(View param1View) {
          if (this.a.is_disclosure != 1 && this.a.isNotMember()) {
            AppMethods.d(2131755848);
            return;
          } 
          CircleMemberFragment.a(CircleDetailsFragment.a(this.b), this.a);
        }
      };
    this.llTitle.setOnClickListener(onClickListener);
    this.llTitleScroll.setOnClickListener(onClickListener);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.i.getString(2131755877));
    if (!TextUtils.isEmpty(paramMyCircleModel.description)) {
      str1 = paramMyCircleModel.description;
    } else {
      str1 = getString(2131755866);
    } 
    stringBuilder2.append(str1);
    String str1 = stringBuilder2.toString();
    i = AppInfo.l - DensityUtils.a(this.i, 20.0F);
    ViewGroup.LayoutParams layoutParams = this.tvContent.getLayoutParams();
    layoutParams.width = i;
    this.tvContent.setLayoutParams(layoutParams);
    this.tvContent.setMaxWidth(i);
    this.tvContent.setMoeTextColor(this.i.getResources().getColor(2131100728));
    this.tvContent.setMaxLines(3);
    this.tvContent.setExpandText(str1);
    this.tvContent.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
    this.flContent.setOnClickListener(new View.OnClickListener(this, str1) {
          public void onClick(View param1View) {
            if (this.b.tvContent.getMaxLines() == 3) {
              this.b.tvContent.setMaxLines(100);
              this.b.tvContent.setExpandText(this.a);
              return;
            } 
            this.b.tvContent.setMaxLines(3);
            this.b.tvContent.setExpandText(this.a);
          }
        });
    b(paramMyCircleModel);
    c(paramMyCircleModel);
  }
  
  private void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    boolean bool1;
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_DRAW;
    String str1 = ((CircleDetailsPresenter)s()).p();
    String str2 = paramBluedIngSelfFeed.feed_id;
    FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.CIRCLE_TOP;
    FeedProtos.NoteType noteType = EventTrackFeed.b(paramBluedIngSelfFeed);
    String str3 = paramBluedIngSelfFeed.note_from;
    int i = paramBluedIngSelfFeed.is_anonym;
    boolean bool2 = true;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramBluedIngSelfFeed.is_essence != 1)
      bool2 = false; 
    EventTrackFeed.a(event, str1, str2, noteSource, true, noteType, str3, bool1, bool2, MarkDownLinkHelper.a(paramBluedIngSelfFeed.feed_pure_content));
  }
  
  private void a(List<BluedIngSelfFeed> paramList) {
    int i = paramList.size();
    if (i > 0) {
      BluedIngSelfFeed bluedIngSelfFeed = paramList.get(0);
      this.topLine.setVisibility(0);
      this.llIsTop1.setVisibility(0);
      if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
        this.tvIsTopTitle1.setText(bluedIngSelfFeed.feed_content);
      } else {
        this.tvIsTopTitle1.setText(2131755914);
      } 
      this.llIsTop1.setOnClickListener(new View.OnClickListener(this, paramList) {
            public void onClick(View param1View) {
              CirclePostDetailsFragment.a(CircleDetailsFragment.a(this.b), ((BluedIngSelfFeed)this.a.get(0)).feed_id, FeedProtos.NoteSource.CIRCLE_TOP);
            }
          });
      a(bluedIngSelfFeed);
    } else {
      this.topLine.setVisibility(8);
      this.llIsTop1.setVisibility(8);
    } 
    if (i > 1) {
      BluedIngSelfFeed bluedIngSelfFeed = paramList.get(1);
      this.llIsTop2.setVisibility(0);
      if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
        this.tvIsTopTitle2.setText(bluedIngSelfFeed.feed_content);
      } else {
        this.tvIsTopTitle2.setText(2131755914);
      } 
      this.llIsTop2.setOnClickListener(new View.OnClickListener(this, paramList) {
            public void onClick(View param1View) {
              CirclePostDetailsFragment.a(CircleDetailsFragment.a(this.b), ((BluedIngSelfFeed)this.a.get(1)).feed_id, FeedProtos.NoteSource.CIRCLE_TOP);
            }
          });
      a(bluedIngSelfFeed);
    } else {
      this.llIsTop2.setVisibility(8);
    } 
    if (i > 2) {
      BluedIngSelfFeed bluedIngSelfFeed = paramList.get(2);
      this.llIsTop3.setVisibility(0);
      if (!TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
        this.tvIsTopTitle3.setText(bluedIngSelfFeed.feed_content);
      } else {
        this.tvIsTopTitle3.setText(2131755914);
      } 
      this.llIsTop3.setOnClickListener(new View.OnClickListener(this, paramList) {
            public void onClick(View param1View) {
              CirclePostDetailsFragment.a(CircleDetailsFragment.a(this.b), ((BluedIngSelfFeed)this.a.get(2)).feed_id, FeedProtos.NoteSource.CIRCLE_TOP);
            }
          });
      a(bluedIngSelfFeed);
      return;
    } 
    this.llIsTop3.setVisibility(8);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt) {
    a(paramContext, paramString, (String)null, 0, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_NOTIFY, paramInt, 0);
  }
  
  private void b(CircleBubble paramCircleBubble) {
    Context context1;
    if (((CircleDetailsPresenter)s()).t().isJoin()) {
      if ((((CircleDetailsPresenter)s()).t()).has_mute == 1) {
        context1 = this.i;
        CommonAlertDialog.a(context1, context1.getString(2131755908), null, this.i.getString(2131755907), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                CircleMemberFragment.a(CircleDetailsFragment.a(this.a), ((CircleDetailsPresenter)this.a.s()).t());
              }
            }this.i.getString(2131755906), null, null);
        return;
      } 
      CircleAddPostFragment.a(this.i, ((CircleDetailsPresenter)s()).p(), ((CircleDetailsPresenter)s()).o(), (((CircleDetailsPresenter)s()).t()).cover, (CircleBubble)context1);
      return;
    } 
    Context context2 = this.i;
    CommonAlertDialog.a(context2, null, context2.getString(2131755911), this.i.getString(2131755910), new DialogInterface.OnClickListener(this, (CircleBubble)context1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            ((CircleDetailsPresenter)this.b.s()).a(false, new CircleMethods.JoinViewChangeListener(this) {
                  public void joinViewChange(CircleJoinState param2CircleJoinState) {
                    if (param2CircleJoinState.isJoin())
                      CircleAddPostFragment.a(CircleDetailsFragment.a(this.a.b), ((CircleDetailsPresenter)this.a.b.s()).p(), ((CircleDetailsPresenter)this.a.b.s()).o(), (((CircleDetailsPresenter)this.a.b.s()).t()).cover, this.a.a); 
                  }
                }this.b.getFragmentManager());
            CircleDetailsFragment.b(this.b);
          }
        }this.i.getString(2131755909), null, null);
  }
  
  private void b(MyCircleModel paramMyCircleModel) {
    if (BluedConstant.a || paramMyCircleModel.show_groups == 0 || paramMyCircleModel.groups == null || paramMyCircleModel.groups.size() == 0) {
      this.group_join.setVisibility(8);
      return;
    } 
    if (paramMyCircleModel.all_groups_full == 1) {
      this.group_join.a();
    } else {
      this.group_join.a();
    } 
    this.group_join.setVisibility(0);
    this.group_join.setOnClickListener(new View.OnClickListener(this, paramMyCircleModel) {
          public void onClick(View param1View) {
            if (this.a.groups != null && this.a.groups.size() == 1) {
              Context context = this.b.getContext();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(((GroupInfoModel)this.a.groups.get(0)).group_id);
              stringBuilder.append("");
              GroupInfoFragment.a(context, stringBuilder.toString(), this.a.groups.get(0), SocialNetWorkProtos.SourceType.CIRCLE);
              return;
            } 
            (new CircleGroupListPop(this.b.getContext(), this.a.groups, (IRequestHost)this.b.w_())).a(this.b.getContext());
          }
        });
  }
  
  private void b(boolean paramBoolean) {
    this.refreshLayout.g();
    if (paramBoolean) {
      this.f.l();
    } else {
      this.f.m();
    } 
    if (this.f.n().size() <= 0) {
      if (paramBoolean) {
        this.g.a();
        return;
      } 
      this.g.b();
    } 
  }
  
  private void c(MyCircleModel paramMyCircleModel) {
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramMyCircleModel) {
        public void onClick(View param1View) {
          boolean bool;
          if (this.a.isOwner()) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_SHOW, this.a.circle_id);
            CircleSettingFragment.a(this.b.getContext(), this.a);
            return;
          } 
          if (this.a.isJoin()) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_EXIT_BOX_SHOW, this.a.circle_id);
            CommonAlertDialog.a(CircleDetailsFragment.a(this.b), null, CircleDetailsFragment.a(this.b).getString(2131755855), CircleDetailsFragment.a(this.b).getString(2131755857), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    EventTrackFeed.f(FeedProtos.Event.CIRCLE_EXIT_BTN_CLICK, this.a.a.circle_id);
                    BluedPreferences.a(this.a.a.circle_id, false);
                    ((CircleDetailsPresenter)this.a.b.s()).r();
                  }
                }CircleDetailsFragment.a(this.b).getString(2131755856), null, null);
            return;
          } 
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK;
          String str = ((CircleDetailsPresenter)this.b.s()).p();
          FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.CIRCLE_DETAIL;
          if ((((CircleDetailsPresenter)this.b.s()).t()).allow_join == 0) {
            bool = true;
          } else {
            bool = false;
          } 
          EventTrackFeed.a(event, str, circleSource, bool, (((CircleDetailsPresenter)this.b.s()).t()).classify_id);
          ((CircleDetailsPresenter)this.b.s()).a(true, null, this.b.getFragmentManager());
          CircleDetailsFragment.b(this.b);
        }
      };
    this.cjvJoin.setOnClickListener(onClickListener);
    this.cjvJoinScroll.setOnClickListener(onClickListener);
    if (paramMyCircleModel.isOwner()) {
      this.cjvJoin.a();
      this.cjvJoinScroll.a();
      this.cjvJoinStroke.setVisibility(8);
    } else {
      this.cjvJoin.setJoinStatus(paramMyCircleModel.getJoinState());
      this.cjvJoinScroll.setJoinStatus(paramMyCircleModel.getJoinState());
      this.cjvJoinView.setJoinStatus(paramMyCircleModel.getJoinState());
    } 
    if (!paramMyCircleModel.isJoin() && (((CircleDetailsPresenter)s()).t()).is_applied == 0) {
      this.cjvJoinStroke.setVisibility(0);
      if (this.cjvJoinStroke.getVisibility() == 0 && !this.e) {
        this.d = AnimationUtils.a((View)this.cjvJoinStroke, 1.3F, 1.45F, 1, 1500);
        this.q = new Timer();
        this.q.schedule(new TimerTask(this) {
              public void run() {
                this.a.a(new -$$Lambda$CircleDetailsFragment$33$ELwr6blWnLcYCtDko8rDsmGiiZ0(this));
              }
            },  300L, 15000L);
        this.e = true;
      } 
    } else {
      this.cjvJoinStroke.setVisibility(8);
      F();
    } 
    if (paramMyCircleModel.is_disclosure != 1 && paramMyCircleModel.isNotMember()) {
      this.refreshLayout.c(false);
      ((AppBarLayout.LayoutParams)this.appbar.getChildAt(0).getLayoutParams()).a(0);
      this.sclNoPermission.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), 2131231275).a(this.ivNoPermission);
      this.noPermissionView.setNoDataBtnListener(onClickListener);
      ShapeTextView shapeTextView = this.noPermissionView.getBtn();
      int i = paramMyCircleModel.is_applied;
      if (i != 1) {
        if (i != 2) {
          this.noPermissionView.setBtnStr(2131755846);
          shapeTextView.setAlpha(1.0F);
          shapeTextView.setEnabled(true);
        } else {
          this.noPermissionView.setBtnStr(2131755864);
          shapeTextView.setAlpha(0.3F);
          shapeTextView.setEnabled(false);
        } 
      } else {
        this.noPermissionView.setBtnStr(2131755845);
        shapeTextView.setAlpha(0.3F);
        shapeTextView.setEnabled(false);
      } 
    } else {
      this.refreshLayout.c(true);
      View view = this.appbar.getChildAt(0);
      AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)view.getLayoutParams();
      layoutParams.a(1);
      view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.sclNoPermission.setVisibility(8);
    } 
    if (paramMyCircleModel.is_applied == 1 || paramMyCircleModel.is_applied == 2) {
      this.ffvPost.setBtnEnabled(false);
      this.ffvPost.setBtnBackgroundColor(2131100721);
      return;
    } 
    this.ffvPost.setBtnEnabled(true);
    this.ffvPost.setBtnBackgroundColor(2131100716);
  }
  
  private void l() {
    LiveEventBus.get("refresh_circle_group", GroupInfoModel.class).observe((LifecycleOwner)this, new Observer<GroupInfoModel>(this) {
          public void a(GroupInfoModel param1GroupInfoModel) {
            if (param1GroupInfoModel != null) {
              MyCircleModel myCircleModel = ((CircleDetailsPresenter)this.a.s()).t();
              if (myCircleModel != null && myCircleModel.groups != null && myCircleModel.groups.size() > 0) {
                int i = myCircleModel.groups.indexOf(param1GroupInfoModel);
                if (i != -1)
                  myCircleModel.groups.set(i, param1GroupInfoModel); 
              } 
            } 
          }
        });
    LiveEventBus.get("group_dismiss", GroupInfoModel.class).observe((LifecycleOwner)this, new Observer<GroupInfoModel>(this) {
          public void a(GroupInfoModel param1GroupInfoModel) {
            if (param1GroupInfoModel != null) {
              MyCircleModel myCircleModel = ((CircleDetailsPresenter)this.a.s()).t();
              if (myCircleModel != null && myCircleModel.groups != null && myCircleModel.groups.size() > 0)
                myCircleModel.groups.remove(param1GroupInfoModel); 
            } 
          }
        });
    LiveEventBus.get("refresh_circle_group_enter", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            if (((CircleDetailsPresenter)this.a.s()).t() != null) {
              (((CircleDetailsPresenter)this.a.s()).t()).show_groups = param1Integer.intValue();
              CircleDetailsFragment circleDetailsFragment = this.a;
              CircleDetailsFragment.a(circleDetailsFragment, ((CircleDetailsPresenter)circleDetailsFragment.s()).t());
            } 
          }
        });
    LiveEventBus.get("kick_out_member", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            this.a.u();
          }
        });
  }
  
  private void m() {
    this.p = (SkeletonScreen)Skeleton.a((View)this.mRootView).a(2131493092).c(1000).b(2131100634).d(30).a();
  }
  
  private void n() {
    this.rotateLayout.setVisibility(0);
    this.titleStill.getRightImg().setVisibility(8);
    this.rotateLayout.d();
    this.rotateLayout.a(-15.0F);
    this.rotateLayout.b();
  }
  
  public boolean V_() {
    N();
    return true;
  }
  
  public void a(int paramInt) {
    this.f.a(paramInt);
    ((CircleDetailsPresenter)s()).a(paramInt);
    L();
    byte b = 8;
    if (paramInt != 1) {
      if (paramInt != 2) {
        this.f.c(this.s);
        if (this.s.size() == 0)
          this.g.a(); 
        View view2 = this.h;
        if (!((CircleDetailsPresenter)s()).h)
          b = 0; 
        view2.setVisibility(b);
        return;
      } 
      this.f.c(this.u);
      if (this.u.size() == 0)
        this.g.a(); 
      View view1 = this.h;
      if (!((CircleDetailsPresenter)s()).j)
        b = 0; 
      view1.setVisibility(b);
      return;
    } 
    this.f.c(this.t);
    if (this.t.size() == 0)
      this.g.a(); 
    View view = this.h;
    if (!((CircleDetailsPresenter)s()).i)
      b = 0; 
    view.setVisibility(b);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.i = getContext();
    StatusBarHelper.a((Activity)getActivity(), false);
    n();
    K();
    I();
    H();
    G();
    E();
    m();
    l();
  }
  
  protected void a(CircleBubble paramCircleBubble) {
    if (TextUtils.isEmpty(paramCircleBubble.img))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramCircleBubble.bubble_code);
    stringBuilder.append(UserInfo.a().i().getUid());
    String str = stringBuilder.toString();
    if (!BluedPreferences.A(str))
      return; 
    EventTrackFeed.a(FeedProtos.Event.FEED_BUBBLE_SHOW, ((CircleDetailsPresenter)s()).p(), FeedProtos.FeedFrom.CIRCLE_DETAIL_POP, paramCircleBubble.bubbleId);
    this.imgGuide.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), paramCircleBubble.img).f().e(-1).a(new ImageLoadResult(this, (IRequestHost)w_(), paramCircleBubble, str) {
          public void a() {
            this.c.imgGuide.setVisibility(0);
            this.c.imgGuide.setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    EventTrackFeed.a(FeedProtos.Event.FEED_BUBBLE_CLICK, ((CircleDetailsPresenter)this.a.c.s()).p(), FeedProtos.FeedFrom.CIRCLE_DETAIL_POP, this.a.a.bubbleId);
                    BluedPreferences.B(this.a.b);
                    CircleDetailsFragment.a(this.a.c, this.a.a);
                    this.a.c.imgGuide.setVisibility(8);
                  }
                });
          }
          
          public void a(int param1Int, Exception param1Exception) {
            this.c.imgGuide.setVisibility(8);
          }
        }).a(this.imgGuide);
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
    if (paramList == null)
      return; 
    byte b = -1;
    switch (paramString.hashCode()) {
      case 1799320587:
        if (paramString.equals("circle_join_state"))
          b = 5; 
        break;
      case 1211125443:
        if (paramString.equals("circle_delete_feed"))
          b = 9; 
        break;
      case 483172972:
        if (paramString.equals("circle_new_list"))
          b = 2; 
        break;
      case 301159657:
        if (paramString.equals("circle_details_top"))
          b = 1; 
        break;
      case -66578769:
        if (paramString.equals("circle_post"))
          b = 7; 
        break;
      case -925288260:
        if (paramString.equals("circle_essence_list"))
          b = 4; 
        break;
      case -1098664433:
        if (paramString.equals("circle_details_ad"))
          b = 8; 
        break;
      case -1110522970:
        if (paramString.equals("circle_tab"))
          b = 6; 
        break;
      case -1184539681:
        if (paramString.equals("circle_hot_list"))
          b = 3; 
        break;
      case -1519155757:
        if (paramString.equals("circle_details"))
          b = 0; 
        break;
    } 
    switch (b) {
      default:
        return;
      case 9:
        MvpUtils.a(paramList, String.class, new MvpUtils.DataHandler<String>(this) {
              public void a() {}
              
              public void a(String param1String) {
                CircleDetailsFragment.c(this.a).b(param1String);
              }
            });
        return;
      case 8:
        MvpUtils.a(paramList, CircleAdModel.class, new MvpUtils.DataHandler<CircleAdModel>(this) {
              public void a() {
                this.a.ivAdBanner.setVisibility(8);
              }
              
              public void a(CircleAdModel param1CircleAdModel) {
                this.a.ivAdBanner.setVisibility(0);
                ImageLoader.a((IRequestHost)this.a.w_(), param1CircleAdModel.icon).a(this.a.ivAdBanner);
                this.a.ivAdBanner.setOnClickListener(new View.OnClickListener(this, param1CircleAdModel) {
                      public void onClick(View param2View) {
                        WebViewShowInfoFragment.show(CircleDetailsFragment.a(this.b.a), this.a.url, -1);
                      }
                    });
              }
            });
        return;
      case 7:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataHandler<BluedIngSelfFeed>(this) {
              public void a() {}
              
              public void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
                if (CircleDetailsFragment.c(this.a) != null) {
                  CircleDetailsFragment.c(this.a).a(0, param1BluedIngSelfFeed);
                  CircleDetailsFragment.c(this.a).notifyDataSetChanged();
                } 
              }
            });
        return;
      case 6:
        L();
        this.refreshLayout.i();
        return;
      case 5:
        c(((CircleDetailsPresenter)s()).t());
        return;
      case 4:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>(this) {
              public void a() {}
              
              public void a(List<BluedIngSelfFeed> param1List) {
                if (param1List != null && param1List.size() > 0) {
                  if (((CircleDetailsPresenter)this.a.s()).k)
                    CircleDetailsFragment.l(this.a).clear(); 
                  CircleDetailsFragment.l(this.a).addAll(param1List);
                } 
                CircleDetailsFragment circleDetailsFragment = this.a;
                circleDetailsFragment.a(((CircleDetailsPresenter)circleDetailsFragment.s()).n());
              }
            });
        return;
      case 3:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>(this) {
              public void a() {}
              
              public void a(List<BluedIngSelfFeed> param1List) {
                if (param1List != null && param1List.size() > 0) {
                  if (((CircleDetailsPresenter)this.a.s()).k)
                    CircleDetailsFragment.k(this.a).clear(); 
                  CircleDetailsFragment.k(this.a).addAll(param1List);
                } 
                CircleDetailsFragment circleDetailsFragment = this.a;
                circleDetailsFragment.a(((CircleDetailsPresenter)circleDetailsFragment.s()).n());
              }
            });
        return;
      case 2:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>(this) {
              public void a() {}
              
              public void a(List<BluedIngSelfFeed> param1List) {
                if (param1List != null && param1List.size() > 0) {
                  if (((CircleDetailsPresenter)this.a.s()).k)
                    CircleDetailsFragment.j(this.a).clear(); 
                  CircleDetailsFragment.j(this.a).addAll(param1List);
                } 
                CircleDetailsFragment circleDetailsFragment = this.a;
                circleDetailsFragment.a(((CircleDetailsPresenter)circleDetailsFragment.s()).n());
              }
            });
        return;
      case 1:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>(this) {
              public void a() {
                CircleDetailsFragment.a(this.a, new ArrayList());
              }
              
              public void a(List<BluedIngSelfFeed> param1List) {
                CircleDetailsFragment.a(this.a, param1List);
              }
            });
        return;
      case 0:
        break;
    } 
    MvpUtils.a(paramList, MyCircleModel.class, new MvpUtils.DataHandler<MyCircleModel>(this) {
          public void a() {
            CircleDetailsFragment.b(this.a, (MyCircleModel)null);
          }
          
          public void a(MyCircleModel param1MyCircleModel) {
            CircleDetailsFragment.b(this.a, param1MyCircleModel);
          }
        });
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
    if (b != 0) {
      if (b != 1)
        return; 
    } else {
      this.rotateLayout.setVisibility(8);
      this.rotateLayout.e();
      if (((CircleDetailsPresenter)s()).s())
        this.titleStill.getRightImg().setVisibility(0); 
      k();
    } 
    b(paramBoolean);
  }
  
  public void aL_() {
    this.p = null;
    this.appbar.b(this.v);
    this.recyclerView.removeOnScrollListener(this.w);
    super.aL_();
    this.g = null;
  }
  
  public void k() {
    if (BluedPreferences.aw(((CircleDetailsPresenter)s()).p()) && BluedPreferences.ax(((CircleDetailsPresenter)s()).p()) && ((CircleDetailsPresenter)s()).t().isJoin()) {
      EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_FEED_POP_SHOW);
      BluedPreferences.b(((CircleDetailsPresenter)s()).p(), false);
      CommonAlertDialog.a(getContext(), getString(2131757089), CircleMethods.isEn((((CircleDetailsPresenter)s()).t()).title), getString(2131757087), new -$$Lambda$CircleDetailsFragment$S9z9rxfbjUypyq-zA5ISVup8JRY(this), new -$$Lambda$CircleDetailsFragment$Z-HcV-XW0J4i5hnAzqfL1Wo2zpo(this), 1);
    } 
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.d != null)
      this.q.cancel(); 
  }
  
  public void onResume() {
    super.onResume();
    if (this.x)
      k(); 
  }
  
  public int p() {
    return 2131493091;
  }
  
  public void x() {
    super.x();
    this.f.c(true);
    this.h.setVisibility(8);
  }
  
  public void y() {
    super.y();
    this.f.c(false);
    this.h.setVisibility(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleDetailsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */