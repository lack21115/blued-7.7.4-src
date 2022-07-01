package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class CircleJoinSettingFragment_ViewBinding implements Unbinder {
  private CircleJoinSettingFragment b;
  
  private View c;
  
  private View d;
  
  public CircleJoinSettingFragment_ViewBinding(CircleJoinSettingFragment paramCircleJoinSettingFragment, View paramView) {
    this.b = paramCircleJoinSettingFragment;
    paramCircleJoinSettingFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    View view = Utils.a(paramView, 2131298776, "field 'llDirect' and method 'onViewClicked'");
    paramCircleJoinSettingFragment.llDirect = (LinearLayout)Utils.b(view, 2131298776, "field 'llDirect'", LinearLayout.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCircleJoinSettingFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramCircleJoinSettingFragment.ivDirect = (ImageView)Utils.a(paramView, 2131297748, "field 'ivDirect'", ImageView.class);
    view = Utils.a(paramView, 2131298709, "field 'llApply' and method 'onViewClicked'");
    paramCircleJoinSettingFragment.llApply = (LinearLayout)Utils.b(view, 2131298709, "field 'llApply'", LinearLayout.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCircleJoinSettingFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramCircleJoinSettingFragment.ivApply = (ImageView)Utils.a(paramView, 2131297686, "field 'ivApply'", ImageView.class);
  }
  
  public void unbind() {
    CircleJoinSettingFragment circleJoinSettingFragment = this.b;
    if (circleJoinSettingFragment != null) {
      this.b = null;
      circleJoinSettingFragment.title = null;
      circleJoinSettingFragment.llDirect = null;
      circleJoinSettingFragment.ivDirect = null;
      circleJoinSettingFragment.llApply = null;
      circleJoinSettingFragment.ivApply = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleJoinSettingFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */