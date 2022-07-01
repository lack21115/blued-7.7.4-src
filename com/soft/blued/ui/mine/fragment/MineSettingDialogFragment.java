package com.soft.blued.ui.mine.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.das.vip.VipProtos;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;

public class MineSettingDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
  private Context a;
  
  private View b;
  
  private ImageView c;
  
  private TextView d;
  
  private ToggleButton e;
  
  private ToggleButton f;
  
  private boolean g;
  
  private boolean h;
  
  private OnMineSettingListener i;
  
  private void f() {
    ShapeHelper.b((ShapeHelper.ShapeView)this.b.findViewById(2131298088), 2131100728);
    this.c = (ImageView)this.b.findViewById(2131297729);
    this.d = (TextView)this.b.findViewById(2131300722);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e = (ToggleButton)this.b.findViewById(2131300245);
    this.f = (ToggleButton)this.b.findViewById(2131300241);
    this.e.setChecked(this.g);
    this.f.setChecked(this.h);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public void onClick(View paramView) {
    OnMineSettingListener onMineSettingListener;
    int i = (UserInfo.a().i()).vip_grade;
    switch (paramView.getId()) {
      default:
        return;
      case 2131300722:
        onMineSettingListener = this.i;
        if (onMineSettingListener != null && i != 0)
          onMineSettingListener.a(this.e.isChecked(), this.f.isChecked()); 
        dismiss();
        return;
      case 2131300245:
        if (i == 0 && (BluedConfig.b().j()).is_hide_last_operate == 0) {
          this.e.setChecked(false);
          PayUtils.a((Context)getActivity(), 0, "mine_hide_time");
        } 
        EventTrackVIP.a(VipProtos.Event.MINE_HIDE_TINE_BTN_CLICK, EventTrackVIP.b((UserInfo.a().i()).vip_grade), this.e.isChecked());
        return;
      case 2131300241:
        if (i == 0 && (BluedConfig.b().j()).is_hide_distance == 0) {
          this.f.setChecked(false);
          PayUtils.a((Context)getActivity(), 1, "mine_hide_distance");
        } 
        EventTrackVIP.a(VipProtos.Event.MINE_HIDE_RANGE_BTN_CLICK, EventTrackVIP.b((UserInfo.a().i()).vip_grade), this.f.isChecked());
        return;
      case 2131297729:
        break;
    } 
    dismiss();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(0, 2131820776);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = this.b;
    if (view == null) {
      this.b = paramLayoutInflater.inflate(2131493021, paramViewGroup, false);
      f();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.b.getParent()).removeView(this.b);
    } 
    return this.b;
  }
  
  public static interface OnMineSettingListener {
    void a(boolean param1Boolean1, boolean param1Boolean2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\fragment\MineSettingDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */