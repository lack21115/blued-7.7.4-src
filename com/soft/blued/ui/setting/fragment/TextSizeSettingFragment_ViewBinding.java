package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.adapttextview.TextSizeRaeSeekBar;

public class TextSizeSettingFragment_ViewBinding implements Unbinder {
  private TextSizeSettingFragment b;
  
  public TextSizeSettingFragment_ViewBinding(TextSizeSettingFragment paramTextSizeSettingFragment, View paramView) {
    this.b = paramTextSizeSettingFragment;
    paramTextSizeSettingFragment.title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300273, "field 'title'", CommonTopTitleNoTrans.class);
    paramTextSizeSettingFragment.ivUserHeader = (ImageView)Utils.a(paramView, 2131297953, "field 'ivUserHeader'", ImageView.class);
    paramTextSizeSettingFragment.tvRight = (TextView)Utils.a(paramView, 2131301277, "field 'tvRight'", TextView.class);
    paramTextSizeSettingFragment.tvLeft = (TextView)Utils.a(paramView, 2131300947, "field 'tvLeft'", TextView.class);
    paramTextSizeSettingFragment.sbTextSize = (TextSizeRaeSeekBar)Utils.a(paramView, 2131299813, "field 'sbTextSize'", TextSizeRaeSeekBar.class);
  }
  
  public void unbind() {
    TextSizeSettingFragment textSizeSettingFragment = this.b;
    if (textSizeSettingFragment != null) {
      this.b = null;
      textSizeSettingFragment.title = null;
      textSizeSettingFragment.ivUserHeader = null;
      textSizeSettingFragment.tvRight = null;
      textSizeSettingFragment.tvLeft = null;
      textSizeSettingFragment.sbTextSize = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\TextSizeSettingFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */