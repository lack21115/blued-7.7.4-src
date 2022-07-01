package com.soft.blued.ui.notify.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class SystemNoticeFragment_ViewBinding implements Unbinder {
  private SystemNoticeFragment b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  private View f;
  
  public SystemNoticeFragment_ViewBinding(SystemNoticeFragment paramSystemNoticeFragment, View paramView) {
    this.b = paramSystemNoticeFragment;
    paramSystemNoticeFragment.ivAttention = (ImageView)Utils.a(paramView, 2131297691, "field 'ivAttention'", ImageView.class);
    paramSystemNoticeFragment.llAttention = (LinearLayout)Utils.a(paramView, 2131298711, "field 'llAttention'", LinearLayout.class);
    View view = Utils.a(paramView, 2131300534, "field 'tvAttentionCount' and method 'onViewClicked'");
    paramSystemNoticeFragment.tvAttentionCount = (QBadgeContainer)Utils.b(view, 2131300534, "field 'tvAttentionCount'", QBadgeContainer.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramSystemNoticeFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramSystemNoticeFragment.ivLike = (ImageView)Utils.a(paramView, 2131297824, "field 'ivLike'", ImageView.class);
    paramSystemNoticeFragment.llLike = (LinearLayout)Utils.a(paramView, 2131298911, "field 'llLike'", LinearLayout.class);
    view = Utils.a(paramView, 2131300954, "field 'tvLikeCount' and method 'onViewClicked'");
    paramSystemNoticeFragment.tvLikeCount = (QBadgeContainer)Utils.b(view, 2131300954, "field 'tvLikeCount'", QBadgeContainer.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramSystemNoticeFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramSystemNoticeFragment.ivGroup = (ImageView)Utils.a(paramView, 2131297783, "field 'ivGroup'", ImageView.class);
    paramSystemNoticeFragment.llGroup = (LinearLayout)Utils.a(paramView, 2131298830, "field 'llGroup'", LinearLayout.class);
    view = Utils.a(paramView, 2131300818, "field 'tvGroupCount' and method 'onViewClicked'");
    paramSystemNoticeFragment.tvGroupCount = (QBadgeContainer)Utils.b(view, 2131300818, "field 'tvGroupCount'", QBadgeContainer.class);
    this.e = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramSystemNoticeFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramSystemNoticeFragment.ivCircle = (ImageView)Utils.a(paramView, 2131297723, "field 'ivCircle'", ImageView.class);
    paramSystemNoticeFragment.llCircle = (LinearLayout)Utils.a(paramView, 2131298745, "field 'llCircle'", LinearLayout.class);
    view = Utils.a(paramView, 2131300628, "field 'tvCircleCount' and method 'onViewClicked'");
    paramSystemNoticeFragment.tvCircleCount = (QBadgeContainer)Utils.b(view, 2131300628, "field 'tvCircleCount'", QBadgeContainer.class);
    this.f = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramSystemNoticeFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramSystemNoticeFragment.llMenu = (LinearLayout)Utils.a(paramView, 2131298947, "field 'llMenu'", LinearLayout.class);
    paramSystemNoticeFragment.llLine = Utils.a(paramView, 2131298914, "field 'llLine'");
    paramSystemNoticeFragment.appbar = (AppBarLayout)Utils.a(paramView, 2131296447, "field 'appbar'", AppBarLayout.class);
    paramSystemNoticeFragment.recycleView = (RecyclerView)Utils.a(paramView, 2131299598, "field 'recycleView'", RecyclerView.class);
    paramSystemNoticeFragment.coordinator = (CoordinatorLayout)Utils.a(paramView, 2131296843, "field 'coordinator'", CoordinatorLayout.class);
    paramSystemNoticeFragment.srlList = (SmartRefreshLayout)Utils.a(paramView, 2131300012, "field 'srlList'", SmartRefreshLayout.class);
  }
  
  public void unbind() {
    SystemNoticeFragment systemNoticeFragment = this.b;
    if (systemNoticeFragment != null) {
      this.b = null;
      systemNoticeFragment.ivAttention = null;
      systemNoticeFragment.llAttention = null;
      systemNoticeFragment.tvAttentionCount = null;
      systemNoticeFragment.ivLike = null;
      systemNoticeFragment.llLike = null;
      systemNoticeFragment.tvLikeCount = null;
      systemNoticeFragment.ivGroup = null;
      systemNoticeFragment.llGroup = null;
      systemNoticeFragment.tvGroupCount = null;
      systemNoticeFragment.ivCircle = null;
      systemNoticeFragment.llCircle = null;
      systemNoticeFragment.tvCircleCount = null;
      systemNoticeFragment.llMenu = null;
      systemNoticeFragment.llLine = null;
      systemNoticeFragment.appbar = null;
      systemNoticeFragment.recycleView = null;
      systemNoticeFragment.coordinator = null;
      systemNoticeFragment.srlList = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\SystemNoticeFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */