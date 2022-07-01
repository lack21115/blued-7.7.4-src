package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;

public class VIPCustomizedFragment extends MvpFragment {
  private Context d;
  
  private int e = 0;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131301620)
  LabeledTextView viewAppIcon;
  
  @BindView(2131301628)
  LabeledTextView viewBubble;
  
  @BindView(2131301630)
  LabeledTextView viewChatBg;
  
  @BindView(2131301647)
  LabeledTextView viewFeedBg;
  
  @BindView(2131301695)
  LabeledTextView viewWidget;
  
  public static void a(Context paramContext, int paramInt) {
    if ((UserInfo.a().i()).vip_grade == 0)
      return; 
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", paramInt);
    TerminalActivity.d(paramContext, VIPCustomizedFragment.class, bundle);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (getArguments() != null)
      this.e = getArguments().getInt("KEY_VIP_GRADE"); 
    this.d = (Context)getActivity();
    this.title.setLeftClickListener(new -$$Lambda$VIPCustomizedFragment$jpcm2kPldpXFU6OsRuWJ08BcwYo(this));
    if (!BluedPreferences.dZ())
      this.viewBubble.a(Boolean.valueOf(true)); 
    this.viewBubble.setOnClickListener(new -$$Lambda$VIPCustomizedFragment$fYDU87_awsTdC0OA5KECLLannu8(this));
    this.viewChatBg.setOnClickListener(new -$$Lambda$VIPCustomizedFragment$xuGucGNgHGprH0cXan50R0QTftA(this));
    if (!BluedPreferences.ef())
      this.viewFeedBg.a(Boolean.valueOf(true)); 
    this.viewFeedBg.setOnClickListener(new -$$Lambda$VIPCustomizedFragment$sffP6NjaRyiPD3f7S-Q2uluokEM(this));
    this.viewAppIcon.setOnClickListener(new -$$Lambda$VIPCustomizedFragment$prPT63xYl8d8Wkzwdw7zvulTwpo(this));
    if (!BluedPreferences.eb())
      this.viewWidget.a(Boolean.valueOf(true)); 
    this.viewWidget.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackVIP.a(VipProtos.Event.VIP_CENTER_PHOTO_PENDANT_CLICK, VIPCustomizedFragment.a(this.a));
            this.a.viewWidget.a(Boolean.valueOf(false));
            BluedPreferences.ec();
            WidgetListFragment.a(VIPCustomizedFragment.b(this.a), 2, "photo_pendant_vip_center", VipProtos.FromType.PHOTO_PENDANT_VIP_CENTER);
          }
        });
  }
  
  public int p() {
    return 2131493114;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VIPCustomizedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */