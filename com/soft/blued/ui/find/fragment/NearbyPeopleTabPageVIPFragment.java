package com.soft.blued.ui.find.fragment;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.das.vip.VipProtos;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleVIPGridAdapter;
import com.soft.blued.ui.find.model.AdvertFloatModel;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.util.ArrayList;

public class NearbyPeopleTabPageVIPFragment extends NearbyPeopleTabPageFragment implements HomeTabClick.TabClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
  ValueAnimator u;
  
  VipProtos.IdentityType v;
  
  private boolean w = false;
  
  private View x;
  
  private View y;
  
  private View z;
  
  private void a(FindDataExtra paramFindDataExtra) {
    if (paramFindDataExtra != null && paramFindDataExtra.guide_map != null) {
      FindDataExtra.GuideMap guideMap = paramFindDataExtra.guide_map;
      if (guideMap.is_open == 1 && !TextUtils.isEmpty(guideMap.image)) {
        String str = BluedPreferences.cj();
        if (!TextUtils.isEmpty(guideMap.code) && !guideMap.code.equals(str)) {
          AdvertFloatModel advertFloatModel = new AdvertFloatModel();
          advertFloatModel.advert_pic = guideMap.image;
          ImageFileLoader.a((IRequestHost)w_()).a(advertFloatModel.advert_pic).a(new ImageFileLoader.OnLoadFileListener(this, guideMap, advertFloatModel) {
                public void onUIFinish(File param1File, Exception param1Exception) {
                  if (param1File != null && param1File.exists() && this.c.n) {
                    BluedPreferences.ah(this.a.code);
                    AdvertFloatFragment.a(this.c.d, this.b, ADConstants.AD_POSITION.k);
                  } 
                }
              }).a();
        } 
      } 
    } 
  }
  
  public static NearbyPeopleTabPageVIPFragment r() {
    NearbyPeopleTabPageVIPFragment nearbyPeopleTabPageVIPFragment = new NearbyPeopleTabPageVIPFragment();
    Bundle bundle = new Bundle();
    bundle.putString("KEY_SORT_BY", "selected");
    nearbyPeopleTabPageVIPFragment.setArguments(bundle);
    return nearbyPeopleTabPageVIPFragment;
  }
  
  private void s() {
    this.i.clearOnScrollListeners();
    this.g.setRefreshEnabled(true);
    this.g.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            this.a.a(true);
          }
        });
    this.g.k();
    o().refresh();
  }
  
  private void t() {
    this.g.setVisibility(8);
    this.q.setVisibility(8);
    this.x.setVisibility(0);
    this.y.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackVIP.a(VipProtos.Event.FEATURED_FOR_YOU_PAGE_BUY_SVIP_BTN_CLICK, this.a.v);
            PayUtils.a(this.a.d, "nearby_choice_for_you_buy", 26, VipProtos.FromType.UNKNOWN_FROM);
          }
        });
    this.z.setVisibility(8);
  }
  
  private void u() {
    this.g.setVisibility(0);
    this.q.setVisibility(0);
    this.z.setVisibility(0);
    this.z.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            PayUtils.a(this.a.d, "nearby_choice_for_you_buy", 26, VipProtos.FromType.UNKNOWN_FROM);
          }
        });
    this.x.setVisibility(8);
  }
  
  public void a() {
    super.a();
    this.x = this.e.findViewById(2131298828);
    this.y = this.e.findViewById(2131300603);
    this.z = this.e.findViewById(2131300056);
    int i = (BluedConfig.b().c()).vip_grade;
    if (i != 0) {
      if (i != 1) {
        if (i == 2)
          this.v = VipProtos.IdentityType.SVIP_TYPE; 
      } else {
        this.v = VipProtos.IdentityType.VIP_TYPE;
      } 
    } else {
      this.v = VipProtos.IdentityType.NONE;
    } 
    EventTrackVIP.a(VipProtos.Event.FEATURED_FOR_YOU_PAGE_SHOW, this.v);
    s();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean)
      a(true); 
  }
  
  public void a(RecyclerView paramRecyclerView) {}
  
  public void a(BluedEntity<UserFindResult, FindDataExtra> paramBluedEntity, boolean paramBoolean) {
    boolean bool;
    super.a(paramBluedEntity, paramBoolean);
    if (paramBluedEntity != null)
      a((FindDataExtra)paramBluedEntity.extra); 
    if (paramBoolean) {
      this.k.c(null);
      this.q.setVisibility(8);
      this.x.setVisibility(8);
      this.z.setVisibility(8);
      return;
    } 
    if ((BluedConfig.b().c()).vip_grade == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      this.g.setVisibility(0);
      this.q.setVisibility(0);
      this.x.setVisibility(8);
      this.z.setVisibility(8);
      return;
    } 
    if ((BluedConfig.b().c()).selected_not_vip_show_type == 0) {
      t();
      return;
    } 
    u();
  }
  
  public void a(String paramString) {
    if (!this.w && this.q != null) {
      this.w = true;
      if (this.q.getVisibility() == 8)
        this.q.setVisibility(0); 
      if (!StringUtils.e(paramString)) {
        this.q.setText(paramString);
        this.u.start();
        this.q.postDelayed(new Runnable(this) {
              public void run() {
                NearbyPeopleTabPageVIPFragment.a(this.a, false);
                this.a.u.reverse();
              }
            }5000L);
      } 
    } 
  }
  
  public void c(String paramString) {
    if ("find".equals(paramString) && this.g != null)
      this.g.k(); 
  }
  
  public void d(String paramString) {
    c(paramString);
  }
  
  public void k() {
    this.l = 2;
  }
  
  public void m() {
    this.k = (PeopleGridQuickAdapter)new PeopleVIPGridAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), this.f, this.i);
    this.u = ValueAnimator.ofInt(new int[] { DensityUtils.a(this.d, -35.0F), DensityUtils.a(this.d, 10.0F) });
    this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          FrameLayout.LayoutParams a = (FrameLayout.LayoutParams)this.b.q.getLayoutParams();
          
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            this.a.topMargin = i;
            this.b.q.setLayoutParams((ViewGroup.LayoutParams)this.a);
          }
        });
    this.u.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    this.u.setDuration(500L);
  }
  
  public void onDestroy() {
    super.onDestroy();
    HomeTabClick.b("find", this);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
      HomeTabClick.a("find", this); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleTabPageVIPFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */