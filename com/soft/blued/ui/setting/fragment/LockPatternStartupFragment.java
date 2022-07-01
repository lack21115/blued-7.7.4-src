package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.customview.LockPatternView;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class LockPatternStartupFragment extends BaseFragment implements View.OnClickListener, LockPatternView.OnPatternListener {
  private LockPatternView d;
  
  private TextView e;
  
  private TextView f;
  
  private ImageView g;
  
  private View h;
  
  private int i = 0;
  
  private void k() {
    this.d = (LockPatternView)this.h.findViewById(2131299167);
    this.d.setOnPatternListener(this);
    this.e = (TextView)this.h.findViewById(2131299168);
    this.f = (TextView)this.h.findViewById(2131300782);
    this.g = (ImageView)this.h.findViewById(2131297955);
    this.f.setOnClickListener(this);
    if (UserInfo.a().i() != null)
      ImageLoader.a((IRequestHost)w_(), UserInfo.a().i().getAvatar()).c().a(2131234356).a(this.g); 
  }
  
  public boolean V_() {
    getActivity().finish();
    AppUtils.a(AppInfo.d());
    return false;
  }
  
  public void a() {}
  
  public void a(List<LockPatternView.Cell> paramList) {}
  
  public void b() {}
  
  public void b(List<LockPatternView.Cell> paramList) {
    if (LockPatternView.a(paramList).equals(BluedPreferences.bc())) {
      LiveFloatManager.a().k();
      getActivity().finish();
      return;
    } 
    this.i++;
    if (this.i <= 4) {
      this.d.setDisplayMode(LockPatternView.DisplayMode.c);
      a(new Runnable(this) {
            public void run() {
              LockPatternStartupFragment.a(this.a).a();
              LockPatternStartupFragment.a(this.a).c();
            }
          },  500L);
      TextView textView = this.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getResources().getText(2131757802));
      stringBuilder.append("");
      stringBuilder.append(5 - this.i);
      stringBuilder.append("");
      stringBuilder.append(getResources().getText(2131757801));
      textView.setText(stringBuilder.toString());
      this.e.setTextColor(getResources().getColor(2131100173));
      Animation animation = AnimationUtils.loadAnimation((Context)getActivity(), 2130772030);
      this.e.startAnimation(animation);
      return;
    } 
    CommonConstants.a = Boolean.valueOf(true);
    SignInActivity.c = true;
    UserRelationshipUtils.a("", new int[0]);
    BluedPreferences.z(false);
    BluedPreferences.F("");
    getActivity().finish();
  }
  
  public boolean j() {
    return false;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131300782)
      return; 
    CommonAlertDialog.a((Context)getActivity(), "", getResources().getString(2131757799), getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            CommonConstants.a = Boolean.valueOf(true);
            SignInActivity.c = true;
            UserRelationshipUtils.a("", new int[0]);
            BluedPreferences.z(false);
            BluedPreferences.F("");
            this.a.getActivity().finish();
          }
        }null, null, null);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.h;
    if (view == null) {
      this.h = paramLayoutInflater.inflate(2131493210, paramViewGroup, false);
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.h.getParent()).removeView(this.h);
    } 
    return this.h;
  }
  
  public void onDestroy() {
    CommonConstants.b = Boolean.valueOf(false);
    super.onDestroy();
  }
  
  public void onStart() {
    CommonConstants.b = Boolean.valueOf(true);
    super.onStart();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\LockPatternStartupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */