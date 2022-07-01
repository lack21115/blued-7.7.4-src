package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class GroupInfoFragment_ViewBinding implements Unbinder {
  private GroupInfoFragment b;
  
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
  
  private View n;
  
  private View o;
  
  private View p;
  
  private View q;
  
  public GroupInfoFragment_ViewBinding(GroupInfoFragment paramGroupInfoFragment, View paramView) {
    this.b = paramGroupInfoFragment;
    paramGroupInfoFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramGroupInfoFragment.iv_icon = (ImageView)Utils.a(paramView, 2131297804, "field 'iv_icon'", ImageView.class);
    paramGroupInfoFragment.tv_group_name = (TextView)Utils.a(paramView, 2131300851, "field 'tv_group_name'", TextView.class);
    paramGroupInfoFragment.tv_member_num = (TextView)Utils.a(paramView, 2131301032, "field 'tv_member_num'", TextView.class);
    paramGroupInfoFragment.list_manager = (RecyclerView)Utils.a(paramView, 2131298140, "field 'list_manager'", RecyclerView.class);
    paramGroupInfoFragment.iv_arrow_right = (ImageView)Utils.a(paramView, 2131297689, "field 'iv_arrow_right'", ImageView.class);
    View view = Utils.a(paramView, 2131300806, "field 'tv_go_chat' and method 'onClick'");
    paramGroupInfoFragment.tv_go_chat = (TextView)Utils.b(view, 2131300806, "field 'tv_go_chat'", TextView.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297304, "field 'group_setting_top' and method 'onClick'");
    paramGroupInfoFragment.group_setting_top = (ImageView)Utils.b(view, 2131297304, "field 'group_setting_top'", ImageView.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297302, "field 'group_setting_mute' and method 'onClick'");
    paramGroupInfoFragment.group_setting_mute = (ImageView)Utils.b(view, 2131297302, "field 'group_setting_mute'", ImageView.class);
    this.e = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297301, "field 'group_setting_at_mute' and method 'onClick'");
    paramGroupInfoFragment.group_setting_at_mute = (ImageView)Utils.b(view, 2131297301, "field 'group_setting_at_mute'", ImageView.class);
    this.f = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131297303, "field 'group_setting_mute_notify' and method 'onClick'");
    paramGroupInfoFragment.group_setting_mute_notify = (ImageView)Utils.b(view, 2131297303, "field 'group_setting_mute_notify'", ImageView.class);
    this.g = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramGroupInfoFragment.group_identity_change = (ImageView)Utils.a(paramView, 2131297294, "field 'group_identity_change'", ImageView.class);
    view = Utils.a(paramView, 2131299693, "field 'rl_change' and method 'onClick'");
    paramGroupInfoFragment.rl_change = (RelativeLayout)Utils.b(view, 2131299693, "field 'rl_change'", RelativeLayout.class);
    this.h = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131301263, "field 'tv_report' and method 'onClick'");
    paramGroupInfoFragment.tv_report = (TextView)Utils.b(view, 2131301263, "field 'tv_report'", TextView.class);
    this.i = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131300639, "field 'tv_clear_msg' and method 'onClick'");
    paramGroupInfoFragment.tv_clear_msg = (TextView)Utils.b(view, 2131300639, "field 'tv_clear_msg'", TextView.class);
    this.j = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131300739, "field 'tv_exit' and method 'onClick'");
    paramGroupInfoFragment.tv_exit = (TextView)Utils.b(view, 2131300739, "field 'tv_exit'", TextView.class);
    this.k = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramGroupInfoFragment.tv_dismiss_hint = (TextView)Utils.a(paramView, 2131300712, "field 'tv_dismiss_hint'", TextView.class);
    paramGroupInfoFragment.rl_description = (RelativeLayout)Utils.a(paramView, 2131299698, "field 'rl_description'", RelativeLayout.class);
    paramGroupInfoFragment.ll_owner_modify = (LinearLayout)Utils.a(paramView, 2131299006, "field 'll_owner_modify'", LinearLayout.class);
    paramGroupInfoFragment.ll_setting = (LinearLayout)Utils.a(paramView, 2131299079, "field 'll_setting'", LinearLayout.class);
    view = Utils.a(paramView, 2131297855, "field 'iv_manager_setting' and method 'onClick'");
    paramGroupInfoFragment.iv_manager_setting = (ImageView)Utils.b(view, 2131297855, "field 'iv_manager_setting'", ImageView.class);
    this.l = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131300494, "field 'tv_add_group' and method 'onClick'");
    paramGroupInfoFragment.tv_add_group = (ShapeTextView)Utils.b(view, 2131300494, "field 'tv_add_group'", ShapeTextView.class);
    this.m = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramGroupInfoFragment.rl_verify = (RelativeLayout)Utils.a(paramView, 2131299737, "field 'rl_verify'", RelativeLayout.class);
    view = Utils.a(paramView, 2131297305, "field 'group_setting_verify' and method 'onClick'");
    paramGroupInfoFragment.group_setting_verify = (ImageView)Utils.b(view, 2131297305, "field 'group_setting_verify'", ImageView.class);
    this.n = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramGroupInfoFragment.rl_setting_at_notify = (RelativeLayout)Utils.a(paramView, 2131299727, "field 'rl_setting_at_notify'", RelativeLayout.class);
    view = Utils.a(paramView, 2131296459, "field 'apply_reason' and method 'onClick'");
    paramGroupInfoFragment.apply_reason = view;
    this.o = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramGroupInfoFragment.et_reason = (EditText)Utils.a(paramView, 2131297010, "field 'et_reason'", EditText.class);
    view = Utils.a(paramView, 2131300519, "field 'tv_apply' and method 'onClick'");
    paramGroupInfoFragment.tv_apply = (ShapeTextView)Utils.b(view, 2131300519, "field 'tv_apply'", ShapeTextView.class);
    this.p = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramGroupInfoFragment.rl_et = (RelativeLayout)Utils.a(paramView, 2131299702, "field 'rl_et'", RelativeLayout.class);
    paramGroupInfoFragment.tv_apply_hint = (TextView)Utils.a(paramView, 2131300522, "field 'tv_apply_hint'", TextView.class);
    paramGroupInfoFragment.ll_apply = (ShapeLinearLayout)Utils.a(paramView, 2131298709, "field 'll_apply'", ShapeLinearLayout.class);
    paramGroupInfoFragment.tv_desc = (TextView)Utils.a(paramView, 2131300704, "field 'tv_desc'", TextView.class);
    paramGroupInfoFragment.scrollView = (ScrollView)Utils.a(paramView, 2131299836, "field 'scrollView'", ScrollView.class);
    paramGroupInfoFragment.ll_keyboard = (KeyboardListenLinearLayout)Utils.a(paramView, 2131298905, "field 'll_keyboard'", KeyboardListenLinearLayout.class);
    paramGroupInfoFragment.ll_report = (LinearLayout)Utils.a(paramView, 2131299054, "field 'll_report'", LinearLayout.class);
    paramGroupInfoFragment.ll_clear_msg = (LinearLayout)Utils.a(paramView, 2131298749, "field 'll_clear_msg'", LinearLayout.class);
    paramGroupInfoFragment.ll_exit = (LinearLayout)Utils.a(paramView, 2131298791, "field 'll_exit'", LinearLayout.class);
    paramView = Utils.a(paramView, 2131299720, "method 'onClick'");
    this.q = paramView;
    paramView.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
  }
  
  public void unbind() {
    GroupInfoFragment groupInfoFragment = this.b;
    if (groupInfoFragment != null) {
      this.b = null;
      groupInfoFragment.title = null;
      groupInfoFragment.iv_icon = null;
      groupInfoFragment.tv_group_name = null;
      groupInfoFragment.tv_member_num = null;
      groupInfoFragment.list_manager = null;
      groupInfoFragment.iv_arrow_right = null;
      groupInfoFragment.tv_go_chat = null;
      groupInfoFragment.group_setting_top = null;
      groupInfoFragment.group_setting_mute = null;
      groupInfoFragment.group_setting_at_mute = null;
      groupInfoFragment.group_setting_mute_notify = null;
      groupInfoFragment.group_identity_change = null;
      groupInfoFragment.rl_change = null;
      groupInfoFragment.tv_report = null;
      groupInfoFragment.tv_clear_msg = null;
      groupInfoFragment.tv_exit = null;
      groupInfoFragment.tv_dismiss_hint = null;
      groupInfoFragment.rl_description = null;
      groupInfoFragment.ll_owner_modify = null;
      groupInfoFragment.ll_setting = null;
      groupInfoFragment.iv_manager_setting = null;
      groupInfoFragment.tv_add_group = null;
      groupInfoFragment.rl_verify = null;
      groupInfoFragment.group_setting_verify = null;
      groupInfoFragment.rl_setting_at_notify = null;
      groupInfoFragment.apply_reason = null;
      groupInfoFragment.et_reason = null;
      groupInfoFragment.tv_apply = null;
      groupInfoFragment.rl_et = null;
      groupInfoFragment.tv_apply_hint = null;
      groupInfoFragment.ll_apply = null;
      groupInfoFragment.tv_desc = null;
      groupInfoFragment.scrollView = null;
      groupInfoFragment.ll_keyboard = null;
      groupInfoFragment.ll_report = null;
      groupInfoFragment.ll_clear_msg = null;
      groupInfoFragment.ll_exit = null;
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
      this.n.setOnClickListener(null);
      this.n = null;
      this.o.setOnClickListener(null);
      this.o = null;
      this.p.setOnClickListener(null);
      this.p = null;
      this.q.setOnClickListener(null);
      this.q = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupInfoFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */