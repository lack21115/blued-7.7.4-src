package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;
import com.soft.blued.ui.circle.view.CircleJoinView;

public class CirclePostDetailsFragment_ViewBinding implements Unbinder {
  private CirclePostDetailsFragment b;
  
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
  
  public CirclePostDetailsFragment_ViewBinding(CirclePostDetailsFragment paramCirclePostDetailsFragment, View paramView) {
    this.b = paramCirclePostDetailsFragment;
    paramCirclePostDetailsFragment.cl_title_bar = (ConstraintLayout)Utils.a(paramView, 2131296770, "field 'cl_title_bar'", ConstraintLayout.class);
    paramCirclePostDetailsFragment.refresh_layout = (SmartRefreshLayout)Utils.a(paramView, 2131299616, "field 'refresh_layout'", SmartRefreshLayout.class);
    View view = Utils.a(paramView, 2131300633, "field 'tv_circle_name' and method 'onClick'");
    paramCirclePostDetailsFragment.tv_circle_name = (TextView)Utils.b(view, 2131300633, "field 'tv_circle_name'", TextView.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297858, "field 'iv_menu' and method 'onClick'");
    paramCirclePostDetailsFragment.iv_menu = (ImageView)Utils.b(view, 2131297858, "field 'iv_menu'", ImageView.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131296752, "field 'cjv_join' and method 'onClick'");
    paramCirclePostDetailsFragment.cjv_join = (CircleJoinView)Utils.b(view, 2131296752, "field 'cjv_join'", CircleJoinView.class);
    this.e = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramCirclePostDetailsFragment.comment_list = (RecyclerView)Utils.a(paramView, 2131296799, "field 'comment_list'", RecyclerView.class);
    paramCirclePostDetailsFragment.keyboardLayout = (KeyboardListenLinearLayout)Utils.a(paramView, 2131297982, "field 'keyboardLayout'", KeyboardListenLinearLayout.class);
    paramCirclePostDetailsFragment.keyboardView = Utils.a(paramView, 2131297985, "field 'keyboardView'");
    paramCirclePostDetailsFragment.layoutCommentAll = (LinearLayout)Utils.a(paramView, 2131298052, "field 'layoutCommentAll'", LinearLayout.class);
    paramCirclePostDetailsFragment.editView = (EditText)Utils.a(paramView, 2131296971, "field 'editView'", EditText.class);
    paramCirclePostDetailsFragment.edit_layout = (ShapeRelativeLayout)Utils.a(paramView, 2131296968, "field 'edit_layout'", ShapeRelativeLayout.class);
    view = Utils.a(paramView, 2131297391, "field 'iconAlbum' and method 'onClick'");
    paramCirclePostDetailsFragment.iconAlbum = (ImageView)Utils.b(view, 2131297391, "field 'iconAlbum'", ImageView.class);
    this.f = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297405, "field 'iconShare' and method 'onClick'");
    paramCirclePostDetailsFragment.iconShare = (ImageView)Utils.b(view, 2131297405, "field 'iconShare'", ImageView.class);
    this.g = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramCirclePostDetailsFragment.tv_comment_cnt_bottom = (TextView)Utils.a(paramView, 2131300651, "field 'tv_comment_cnt_bottom'", TextView.class);
    paramCirclePostDetailsFragment.tv_praise_cnt_bottom = (TextView)Utils.a(paramView, 2131301187, "field 'tv_praise_cnt_bottom'", TextView.class);
    paramCirclePostDetailsFragment.layout_like_comment = Utils.a(paramView, 2131298068, "field 'layout_like_comment'");
    paramCirclePostDetailsFragment.layout_album = (LinearLayout)Utils.a(paramView, 2131298043, "field 'layout_album'", LinearLayout.class);
    paramCirclePostDetailsFragment.iv_comment_header = (ImageView)Utils.a(paramView, 2131297733, "field 'iv_comment_header'", ImageView.class);
    paramCirclePostDetailsFragment.fl_anonymous_comment = (FrameLayout)Utils.a(paramView, 2131297083, "field 'fl_anonymous_comment'", FrameLayout.class);
    paramCirclePostDetailsFragment.cb_anonymous_comment = (CheckBox)Utils.a(paramView, 2131296666, "field 'cb_anonymous_comment'", CheckBox.class);
    view = Utils.a(paramView, 2131297400, "field 'icon_like' and method 'onClick'");
    paramCirclePostDetailsFragment.icon_like = (ImageView)Utils.b(view, 2131297400, "field 'icon_like'", ImageView.class);
    this.h = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramCirclePostDetailsFragment.emoticonLayout = (LinearLayout)Utils.a(paramView, 2131296983, "field 'emoticonLayout'", LinearLayout.class);
    paramCirclePostDetailsFragment.viewEpv = (EmoticonsPageView)Utils.a(paramView, 2131301643, "field 'viewEpv'", EmoticonsPageView.class);
    paramCirclePostDetailsFragment.viewEiv = (EmoticonsIndicatorView)Utils.a(paramView, 2131301642, "field 'viewEiv'", EmoticonsIndicatorView.class);
    paramCirclePostDetailsFragment.viewEtv = (EmoticonsToolBarView)Utils.a(paramView, 2131301644, "field 'viewEtv'", EmoticonsToolBarView.class);
    paramCirclePostDetailsFragment.emoticonLayoutRoot = (SwitchPanelRelativeLayout)Utils.a(paramView, 2131296984, "field 'emoticonLayoutRoot'", SwitchPanelRelativeLayout.class);
    paramCirclePostDetailsFragment.touchView = Utils.a(paramView, 2131300308, "field 'touchView'");
    view = Utils.a(paramView, 2131297734, "field 'iv_cover' and method 'onClick'");
    paramCirclePostDetailsFragment.iv_cover = (ImageView)Utils.b(view, 2131297734, "field 'iv_cover'", ImageView.class);
    this.i = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramCirclePostDetailsFragment.tv_member_num = (TextView)Utils.a(paramView, 2131301032, "field 'tv_member_num'", TextView.class);
    paramCirclePostDetailsFragment.rl_title_bar = (RelativeLayout)Utils.a(paramView, 2131299734, "field 'rl_title_bar'", RelativeLayout.class);
    view = Utils.a(paramView, 2131299890, "method 'onClick'");
    this.j = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297394, "method 'onClick'");
    this.k = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297701, "method 'onClick'");
    this.l = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramView = Utils.a(paramView, 2131297397, "method 'onClick'");
    this.m = paramView;
    paramView.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCirclePostDetailsFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
  }
  
  public void unbind() {
    CirclePostDetailsFragment circlePostDetailsFragment = this.b;
    if (circlePostDetailsFragment != null) {
      this.b = null;
      circlePostDetailsFragment.cl_title_bar = null;
      circlePostDetailsFragment.refresh_layout = null;
      circlePostDetailsFragment.tv_circle_name = null;
      circlePostDetailsFragment.iv_menu = null;
      circlePostDetailsFragment.cjv_join = null;
      circlePostDetailsFragment.comment_list = null;
      circlePostDetailsFragment.keyboardLayout = null;
      circlePostDetailsFragment.keyboardView = null;
      circlePostDetailsFragment.layoutCommentAll = null;
      circlePostDetailsFragment.editView = null;
      circlePostDetailsFragment.edit_layout = null;
      circlePostDetailsFragment.iconAlbum = null;
      circlePostDetailsFragment.iconShare = null;
      circlePostDetailsFragment.tv_comment_cnt_bottom = null;
      circlePostDetailsFragment.tv_praise_cnt_bottom = null;
      circlePostDetailsFragment.layout_like_comment = null;
      circlePostDetailsFragment.layout_album = null;
      circlePostDetailsFragment.iv_comment_header = null;
      circlePostDetailsFragment.fl_anonymous_comment = null;
      circlePostDetailsFragment.cb_anonymous_comment = null;
      circlePostDetailsFragment.icon_like = null;
      circlePostDetailsFragment.emoticonLayout = null;
      circlePostDetailsFragment.viewEpv = null;
      circlePostDetailsFragment.viewEiv = null;
      circlePostDetailsFragment.viewEtv = null;
      circlePostDetailsFragment.emoticonLayoutRoot = null;
      circlePostDetailsFragment.touchView = null;
      circlePostDetailsFragment.iv_cover = null;
      circlePostDetailsFragment.tv_member_num = null;
      circlePostDetailsFragment.rl_title_bar = null;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CirclePostDetailsFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */