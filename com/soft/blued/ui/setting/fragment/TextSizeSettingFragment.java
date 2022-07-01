package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.adapttextview.FontAdjustTextHelper;
import com.soft.blued.customview.adapttextview.TextSizeRaeSeekBar;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.user.UserInfo;

public class TextSizeSettingFragment extends MvpFragment {
  @BindView(2131297953)
  ImageView ivUserHeader;
  
  @BindView(2131299813)
  TextSizeRaeSeekBar sbTextSize;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131300947)
  TextView tvLeft;
  
  @BindView(2131301277)
  TextView tvRight;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, TextSizeSettingFragment.class, null);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.title.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.sbTextSize.getProgress() != FontAdjustTextHelper.b())
              EventTrackSettings.a(SettingsProtos.Event.WORD_SIZE_CHANGE, this.a.sbTextSize.getProgress()); 
            FontAdjustTextHelper.b(this.a.sbTextSize.getProgress());
            this.a.C();
          }
        });
    ImageLoader.a((IRequestHost)w_(), UserInfo.a().i().getAvatar()).a(2131234356).a(20.0F).a(this.ivUserHeader);
    this.sbTextSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
          public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
            param1Int = FontAdjustTextHelper.a(param1Int);
            TextView textView = this.a.tvRight;
            float f = param1Int;
            textView.setTextSize(f);
            this.a.tvLeft.setTextSize(f);
            this.a.title.setRightBtnEnable(true);
          }
          
          public void onStartTrackingTouch(SeekBar param1SeekBar) {}
          
          public void onStopTrackingTouch(SeekBar param1SeekBar) {}
        });
    if (this.sbTextSize.getMax() < FontAdjustTextHelper.b())
      FontAdjustTextHelper.b(1); 
    this.sbTextSize.setProgress(FontAdjustTextHelper.b());
    this.title.setRightBtnEnable(false);
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public int p() {
    return 2131493332;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\TextSizeSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */