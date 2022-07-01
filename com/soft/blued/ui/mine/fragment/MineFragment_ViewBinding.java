package com.soft.blued.ui.mine.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;

public class MineFragment_ViewBinding implements Unbinder {
  private MineFragment b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  private View f;
  
  private View g;
  
  private View h;
  
  private View i;
  
  private View j;
  
  private View k;
  
  private View l;
  
  private View m;
  
  public MineFragment_ViewBinding(MineFragment paramMineFragment, View paramView) {
    this.b = paramMineFragment;
    paramMineFragment.top = (FrameLayout)Utils.a(paramView, 2131300291, "field 'top'", FrameLayout.class);
    paramMineFragment.scrollPage = (ScrollView)Utils.a(paramView, 2131299840, "field 'scrollPage'", ScrollView.class);
    View view = Utils.a(paramView, 2131297752, "field 'ivEdit' and method 'onViewClicked'");
    paramMineFragment.ivEdit = (ImageView)Utils.b(view, 2131297752, "field 'ivEdit'", ImageView.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    view = Utils.a(paramView, 2131298065, "field 'layoutHeaderName' and method 'onViewClicked'");
    paramMineFragment.layoutHeaderName = (LinearLayout)Utils.b(view, 2131298065, "field 'layoutHeaderName'", LinearLayout.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    view = Utils.a(paramView, 2131297362, "field 'headerView' and method 'onViewClicked'");
    paramMineFragment.headerView = (ImageView)Utils.b(view, 2131297362, "field 'headerView'", ImageView.class);
    this.e = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.ivVerify = (ImageView)Utils.a(paramView, 2131297957, "field 'ivVerify'", ImageView.class);
    view = Utils.a(paramView, 2131301082, "field 'tvMyName' and method 'onViewClicked'");
    paramMineFragment.tvMyName = (TextView)Utils.b(view, 2131301082, "field 'tvMyName'", TextView.class);
    this.f = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.layoutName = (LinearLayout)Utils.a(paramView, 2131298073, "field 'layoutName'", LinearLayout.class);
    view = Utils.a(paramView, 2131297863, "field 'ivMore' and method 'onViewClicked'");
    paramMineFragment.ivMore = (ImageView)Utils.b(view, 2131297863, "field 'ivMore'", ImageView.class);
    this.g = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.tvAttentionsCount = (TextView)Utils.a(paramView, 2131300536, "field 'tvAttentionsCount'", TextView.class);
    view = Utils.a(paramView, 2131298965, "field 'llMyAttentions' and method 'onViewClicked'");
    paramMineFragment.llMyAttentions = (LinearLayout)Utils.b(view, 2131298965, "field 'llMyAttentions'", LinearLayout.class);
    this.h = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.tvFansCount = (TextView)Utils.a(paramView, 2131300745, "field 'tvFansCount'", TextView.class);
    view = Utils.a(paramView, 2131298966, "field 'llMyFans' and method 'onViewClicked'");
    paramMineFragment.llMyFans = (LinearLayout)Utils.b(view, 2131298966, "field 'llMyFans'", LinearLayout.class);
    this.i = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.tvFeedCount = (TextView)Utils.a(paramView, 2131300757, "field 'tvFeedCount'", TextView.class);
    paramMineFragment.tvFeedName = (TextView)Utils.a(paramView, 2131300759, "field 'tvFeedName'", TextView.class);
    view = Utils.a(paramView, 2131298967, "field 'llMyFeed' and method 'onViewClicked'");
    paramMineFragment.llMyFeed = (LinearLayout)Utils.b(view, 2131298967, "field 'llMyFeed'", LinearLayout.class);
    this.j = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.linearLayout = (LinearLayout)Utils.a(paramView, 2131298127, "field 'linearLayout'", LinearLayout.class);
    paramMineFragment.tvVipTitle = (TextView)Utils.a(paramView, 2131301504, "field 'tvVipTitle'", TextView.class);
    paramMineFragment.ivVipIcon = (ImageView)Utils.a(paramView, 2131297968, "field 'ivVipIcon'", ImageView.class);
    paramMineFragment.vfVipAd = (ViewFlipper)Utils.a(paramView, 2131301593, "field 'vfVipAd'", ViewFlipper.class);
    paramMineFragment.tvVipBtn = (TextView)Utils.a(paramView, 2131301497, "field 'tvVipBtn'", TextView.class);
    paramMineFragment.ivVipBtn = (ImageView)Utils.a(paramView, 2131297967, "field 'ivVipBtn'", ImageView.class);
    view = Utils.a(paramView, 2131298103, "field 'layoutVipBtn' and method 'onViewClicked'");
    paramMineFragment.layoutVipBtn = (ShapeLinearLayout)Utils.b(view, 2131298103, "field 'layoutVipBtn'", ShapeLinearLayout.class);
    this.k = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    view = Utils.a(paramView, 2131298102, "field 'layoutVip' and method 'onViewClicked'");
    paramMineFragment.layoutVip = (LinearLayout)Utils.b(view, 2131298102, "field 'layoutVip'", LinearLayout.class);
    this.l = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.ivVipBg = (ImageView)Utils.a(paramView, 2131297965, "field 'ivVipBg'", ImageView.class);
    paramMineFragment.ivBgIcon = (ImageView)Utils.a(paramView, 2131297707, "field 'ivBgIcon'", ImageView.class);
    paramMineFragment.llHealthFlipper = (LinearLayout)Utils.a(paramView, 2131298873, "field 'llHealthFlipper'", LinearLayout.class);
    paramMineFragment.tvAvatarAuditing = (TextView)Utils.a(paramView, 2131300542, "field 'tvAvatarAuditing'", TextView.class);
    paramMineFragment.avatarWidget = (ImageView)Utils.a(paramView, 2131297700, "field 'avatarWidget'", ImageView.class);
    paramMineFragment.rvAnchorsEntry = (RecyclerView)Utils.a(paramView, 2131299766, "field 'rvAnchorsEntry'", RecyclerView.class);
    paramMineFragment.cvAnchors = (CardView)Utils.a(paramView, 2131296882, "field 'cvAnchors'", CardView.class);
    paramMineFragment.rvServiceEntry = (RecyclerView)Utils.a(paramView, 2131299792, "field 'rvServiceEntry'", RecyclerView.class);
    paramMineFragment.cvService = (CardView)Utils.a(paramView, 2131296900, "field 'cvService'", CardView.class);
    paramMineFragment.imgAd = (ImageView)Utils.a(paramView, 2131297419, "field 'imgAd'", ImageView.class);
    paramMineFragment.cvAd = (CardView)Utils.a(paramView, 2131296881, "field 'cvAd'", CardView.class);
    paramMineFragment.adViewLayout = (BluedADConstraintLayout)Utils.a(paramView, 2131296419, "field 'adViewLayout'", BluedADConstraintLayout.class);
    paramMineFragment.rvHealthEntry = (RecyclerView)Utils.a(paramView, 2131299775, "field 'rvHealthEntry'", RecyclerView.class);
    paramMineFragment.vfHealth = (ViewFlipper)Utils.a(paramView, 2131301591, "field 'vfHealth'", ViewFlipper.class);
    paramMineFragment.cvHealth = (CardView)Utils.a(paramView, 2131296889, "field 'cvHealth'", CardView.class);
    paramMineFragment.rvOthersEntry = (RecyclerView)Utils.a(paramView, 2131299782, "field 'rvOthersEntry'", RecyclerView.class);
    paramMineFragment.cvOther = (CardView)Utils.a(paramView, 2131296897, "field 'cvOther'", CardView.class);
    view = Utils.a(paramView, 2131298968, "field 'll_my_group' and method 'onViewClicked'");
    paramMineFragment.ll_my_group = (LinearLayout)Utils.b(view, 2131298968, "field 'll_my_group'", LinearLayout.class);
    this.m = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramMineFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramMineFragment.tv_my_group_cnt = (TextView)Utils.a(paramView, 2131301080, "field 'tv_my_group_cnt'", TextView.class);
  }
  
  public void unbind() {
    MineFragment mineFragment = this.b;
    if (mineFragment != null) {
      this.b = null;
      mineFragment.top = null;
      mineFragment.scrollPage = null;
      mineFragment.ivEdit = null;
      mineFragment.layoutHeaderName = null;
      mineFragment.headerView = null;
      mineFragment.ivVerify = null;
      mineFragment.tvMyName = null;
      mineFragment.layoutName = null;
      mineFragment.ivMore = null;
      mineFragment.tvAttentionsCount = null;
      mineFragment.llMyAttentions = null;
      mineFragment.tvFansCount = null;
      mineFragment.llMyFans = null;
      mineFragment.tvFeedCount = null;
      mineFragment.tvFeedName = null;
      mineFragment.llMyFeed = null;
      mineFragment.linearLayout = null;
      mineFragment.tvVipTitle = null;
      mineFragment.ivVipIcon = null;
      mineFragment.vfVipAd = null;
      mineFragment.tvVipBtn = null;
      mineFragment.ivVipBtn = null;
      mineFragment.layoutVipBtn = null;
      mineFragment.layoutVip = null;
      mineFragment.ivVipBg = null;
      mineFragment.ivBgIcon = null;
      mineFragment.llHealthFlipper = null;
      mineFragment.tvAvatarAuditing = null;
      mineFragment.avatarWidget = null;
      mineFragment.rvAnchorsEntry = null;
      mineFragment.cvAnchors = null;
      mineFragment.rvServiceEntry = null;
      mineFragment.cvService = null;
      mineFragment.imgAd = null;
      mineFragment.cvAd = null;
      mineFragment.adViewLayout = null;
      mineFragment.rvHealthEntry = null;
      mineFragment.vfHealth = null;
      mineFragment.cvHealth = null;
      mineFragment.rvOthersEntry = null;
      mineFragment.cvOther = null;
      mineFragment.ll_my_group = null;
      mineFragment.tv_my_group_cnt = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      this.g.setOnClickListener(null);
      this.g = null;
      this.h.setOnClickListener(null);
      this.h = null;
      this.i.setOnClickListener(null);
      this.i = null;
      this.j.setOnClickListener(null);
      this.j = null;
      this.k.setOnClickListener(null);
      this.k = null;
      this.l.setOnClickListener(null);
      this.l = null;
      this.m.setOnClickListener(null);
      this.m = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\fragment\MineFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */