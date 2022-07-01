package com.soft.blued.ui.setting.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.setting.adapter.BluedIconAdapter;
import com.soft.blued.ui.setting.model.BluedIcon;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ChangeBluedIconFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private List<BluedIcon> f;
  
  private BluedIconAdapter g;
  
  private RecyclerView h;
  
  private int i = 2;
  
  private void a() {
    this.f = new ArrayList<BluedIcon>();
    this.f.add(new BluedIcon(2131231104, false, "com.soft.blued.icon0"));
    this.f.add(new BluedIcon(2131231105, false, "com.soft.blued.icon1"));
    this.f.add(new BluedIcon(2131231106, false, "com.soft.blued.icon2"));
    this.f.add(new BluedIcon(2131231107, false, "com.soft.blued.icon3"));
    this.f.add(new BluedIcon(2131231108, false, "com.soft.blued.icon4"));
    this.f.add(new BluedIcon(2131231109, false, "com.soft.blued.icon5"));
    this.f.add(new BluedIcon(2131231110, false, "com.soft.blued.icon6"));
    for (BluedIcon bluedIcon : this.f) {
      if (bluedIcon.getLauncherName().equals(BluedPreferences.a("com.soft.blued.icon0"))) {
        bluedIcon.setChecked(true);
        break;
      } 
    } 
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, this.d, 3) {
        public boolean canScrollVertically() {
          return false;
        }
      };
    this.h = (RecyclerView)this.e.findViewById(2131299776);
    this.h.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.g = new BluedIconAdapter(this.d, this.f);
    this.h.setAdapter((RecyclerView.Adapter)this.g);
    this.g.a(new BluedIconAdapter.OnItemClickListener(this) {
          public void a(View param1View, int param1Int) {
            InstantLog.b("change_icon_click", param1Int);
            ChangeBluedIconFragment.a(this.a, param1Int);
          }
        });
  }
  
  private void a(int paramInt) {
    if ((UserInfo.a().i()).vip_grade == 0) {
      PayUtils.a(this.d, this.i, "", 14, VipProtos.FromType.UNKNOWN_FROM);
      return;
    } 
    for (int i = 0; i < this.f.size(); i++) {
      if (i == paramInt) {
        ((BluedIcon)this.f.get(i)).setChecked(true);
      } else {
        ((BluedIcon)this.f.get(i)).setChecked(false);
      } 
    } 
    this.g.notifyDataSetChanged();
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, ChangeBluedIconFragment.class, null);
  }
  
  public static void a(Context paramContext, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_VIP_GRADE", paramInt);
    TerminalActivity.d(paramContext, ChangeBluedIconFragment.class, bundle);
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(getString(2131755742));
    commonTopTitleNoTrans.setLeftClickListener(new -$$Lambda$ChangeBluedIconFragment$f8QShhFKgEGDZWE0t2LrpopiUKQ(this));
    commonTopTitleNoTrans.setRightText(2131758642);
    commonTopTitleNoTrans.setRightTextColor(2131100838);
    commonTopTitleNoTrans.setRightClickListener(new -$$Lambda$ChangeBluedIconFragment$w8-BsQjyhXtdn5TrRNkhwkHTheE(this));
  }
  
  private void l() {
    for (int i = 0; i < this.f.size(); i++) {
      if (((BluedIcon)this.f.get(i)).isChecked()) {
        VipProtos.Event event = VipProtos.Event.VIP_CHANGE_ICON_SAVE_BTN_CLICK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        EventTrackVIP.b(event, stringBuilder.toString());
        InstantLog.b("change_icon_use", i);
        a(((BluedIcon)this.f.get(i)).getLauncherName());
        AppMethods.d(2131755743);
        getActivity().finish();
        return;
      } 
    } 
  }
  
  public void a(String paramString) {
    if (StringUtils.e(paramString))
      return; 
    PackageManager packageManager = getActivity().getPackageManager();
    for (int i = 0; i < this.f.size(); i++) {
      try {
        packageManager.setComponentEnabledSetting(new ComponentName((Context)getActivity(), ((BluedIcon)this.f.get(i)).getLauncherName()), 2, 1);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    packageManager.setComponentEnabledSetting(new ComponentName((Context)getActivity(), paramString), 1, 1);
    BluedPreferences.b(paramString);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    if (getArguments() != null)
      this.i = getArguments().getInt("KEY_VIP_GRADE", 2); 
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493083, paramViewGroup, false);
      k();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\ChangeBluedIconFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */