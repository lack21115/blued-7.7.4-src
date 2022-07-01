package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class GroupInfoEditFragment_ViewBinding implements Unbinder {
  private GroupInfoEditFragment b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  public GroupInfoEditFragment_ViewBinding(GroupInfoEditFragment paramGroupInfoEditFragment, View paramView) {
    this.b = paramGroupInfoEditFragment;
    paramGroupInfoEditFragment.tv_description = (TextView)Utils.a(paramView, 2131300705, "field 'tv_description'", TextView.class);
    paramGroupInfoEditFragment.tv_group_name = (TextView)Utils.a(paramView, 2131300851, "field 'tv_group_name'", TextView.class);
    paramGroupInfoEditFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramGroupInfoEditFragment.iv_icon = (ImageView)Utils.a(paramView, 2131297804, "field 'iv_icon'", ImageView.class);
    View view = Utils.a(paramView, 2131296758, "method 'onClick'");
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoEditFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    view = Utils.a(paramView, 2131296760, "method 'onClick'");
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoEditFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
    paramView = Utils.a(paramView, 2131296762, "method 'onClick'");
    this.e = paramView;
    paramView.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramGroupInfoEditFragment) {
          public void a(View param1View) {
            this.b.onClick(param1View);
          }
        });
  }
  
  public void unbind() {
    GroupInfoEditFragment groupInfoEditFragment = this.b;
    if (groupInfoEditFragment != null) {
      this.b = null;
      groupInfoEditFragment.tv_description = null;
      groupInfoEditFragment.tv_group_name = null;
      groupInfoEditFragment.title = null;
      groupInfoEditFragment.iv_icon = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupInfoEditFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */