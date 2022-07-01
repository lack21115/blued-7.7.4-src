package com.soft.blued.ui.circle.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.EditInputNumView;

public class CircleInfoSettingFragment_ViewBinding implements Unbinder {
  private CircleInfoSettingFragment b;
  
  public CircleInfoSettingFragment_ViewBinding(CircleInfoSettingFragment paramCircleInfoSettingFragment, View paramView) {
    this.b = paramCircleInfoSettingFragment;
    paramCircleInfoSettingFragment.keyboardLayout = (KeyboardListenLinearLayout)Utils.a(paramView, 2131297982, "field 'keyboardLayout'", KeyboardListenLinearLayout.class);
    paramCircleInfoSettingFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramCircleInfoSettingFragment.llHeader = (LinearLayout)Utils.a(paramView, 2131298870, "field 'llHeader'", LinearLayout.class);
    paramCircleInfoSettingFragment.ivHeader = (ImageView)Utils.a(paramView, 2131297797, "field 'ivHeader'", ImageView.class);
    paramCircleInfoSettingFragment.flHeaderBottom = (FrameLayout)Utils.a(paramView, 2131297111, "field 'flHeaderBottom'", FrameLayout.class);
    paramCircleInfoSettingFragment.tvEdit = (TextView)Utils.a(paramView, 2131300728, "field 'tvEdit'", TextView.class);
    paramCircleInfoSettingFragment.edtInfo = (EditText)Utils.a(paramView, 2131296975, "field 'edtInfo'", EditText.class);
    paramCircleInfoSettingFragment.invWordCount = (EditInputNumView)Utils.a(paramView, 2131297597, "field 'invWordCount'", EditInputNumView.class);
  }
  
  public void unbind() {
    CircleInfoSettingFragment circleInfoSettingFragment = this.b;
    if (circleInfoSettingFragment != null) {
      this.b = null;
      circleInfoSettingFragment.keyboardLayout = null;
      circleInfoSettingFragment.title = null;
      circleInfoSettingFragment.llHeader = null;
      circleInfoSettingFragment.ivHeader = null;
      circleInfoSettingFragment.flHeaderBottom = null;
      circleInfoSettingFragment.tvEdit = null;
      circleInfoSettingFragment.edtInfo = null;
      circleInfoSettingFragment.invWordCount = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleInfoSettingFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */