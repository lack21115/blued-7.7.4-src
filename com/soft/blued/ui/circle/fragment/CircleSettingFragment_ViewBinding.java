package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class CircleSettingFragment_ViewBinding implements Unbinder {
  private CircleSettingFragment b;
  
  private View c;
  
  private View d;
  
  public CircleSettingFragment_ViewBinding(CircleSettingFragment paramCircleSettingFragment, View paramView) {
    this.b = paramCircleSettingFragment;
    paramCircleSettingFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    View view = Utils.a(paramView, 2131298893, "field 'llInfoSetting' and method 'onViewClicked'");
    paramCircleSettingFragment.llInfoSetting = (LinearLayout)Utils.b(view, 2131298893, "field 'llInfoSetting'", LinearLayout.class);
    this.c = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCircleSettingFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    view = Utils.a(paramView, 2131298904, "field 'llJoinSetting' and method 'onViewClicked'");
    paramCircleSettingFragment.llJoinSetting = (LinearLayout)Utils.b(view, 2131298904, "field 'llJoinSetting'", LinearLayout.class);
    this.d = view;
    view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener(this, paramCircleSettingFragment) {
          public void a(View param1View) {
            this.b.onViewClicked(param1View);
          }
        });
    paramCircleSettingFragment.tvJoinSetting = (TextView)Utils.a(paramView, 2131300938, "field 'tvJoinSetting'", TextView.class);
    paramCircleSettingFragment.ivJoinSettingIcon = (ImageView)Utils.a(paramView, 2131297818, "field 'ivJoinSettingIcon'", ImageView.class);
  }
  
  public void unbind() {
    CircleSettingFragment circleSettingFragment = this.b;
    if (circleSettingFragment != null) {
      this.b = null;
      circleSettingFragment.title = null;
      circleSettingFragment.llInfoSetting = null;
      circleSettingFragment.llJoinSetting = null;
      circleSettingFragment.tvJoinSetting = null;
      circleSettingFragment.ivJoinSettingIcon = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleSettingFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */