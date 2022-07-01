package com.soft.blued.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.statistics.BluedStatistics;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.Host;

public class ServerAddressSettingFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
  private View d;
  
  private TextView e;
  
  private RadioGroup f;
  
  private RadioButton g;
  
  private RadioButton h;
  
  private Button i;
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
    String str = TTAdSdk.getAdManager().getSDKVersion();
    switch (paramInt) {
      default:
        return;
      case 2131299579:
        Host.a(true);
        textView = this.e;
        stringBuilder = new StringBuilder();
        stringBuilder.append(Host.b());
        stringBuilder.append("\n穿山甲版本号：");
        stringBuilder.append(str);
        textView.setText(stringBuilder.toString());
        return;
      case 2131299578:
        break;
    } 
    Host.a(false);
    TextView textView = this.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Host.b());
    stringBuilder.append("\n穿山甲版本号：");
    stringBuilder.append(str);
    textView.setText(stringBuilder.toString());
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296600)
      return; 
    if (this.f.getCheckedRadioButtonId() == this.g.getId()) {
      BluedHttpUrl.j();
    } else if (this.f.getCheckedRadioButtonId() == this.h.getId()) {
      BluedHttpUrl.i();
    } 
    BluedStatistics.a(BluedHttpUrl.t(), 443, HappyDnsUtils.d());
    LiveMsgSendManager.a().b();
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493312, paramViewGroup, false);
      this.f = (RadioGroup)this.d.findViewById(2131299580);
      this.f.setOnCheckedChangeListener(this);
      this.g = (RadioButton)this.d.findViewById(2131299579);
      this.h = (RadioButton)this.d.findViewById(2131299578);
      this.e = (TextView)this.d.findViewById(2131296421);
      if (BluedHttpUrl.h()) {
        this.g.setChecked(true);
      } else {
        this.h.setChecked(true);
      } 
      Host.a(BluedHttpUrl.h());
      this.e.setText(Host.b());
      this.i = (Button)this.d.findViewById(2131296600);
      this.i.setOnClickListener(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ServerAddressSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */