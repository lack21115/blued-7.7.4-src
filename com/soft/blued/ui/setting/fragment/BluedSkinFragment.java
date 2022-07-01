package com.soft.blued.ui.setting.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.BindView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.RippleAnimationView;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.utils.BluedPreferences;
import skin.support.observe.SkinObservable;

public class BluedSkinFragment extends MvpFragment<MvpPresenter> implements View.OnClickListener, BluedSkinObserver {
  @BindView(2131298766)
  TextView llCustom;
  
  @BindView(2131299090)
  RelativeLayout llSystem;
  
  @BindView(2131299102)
  CommonTopTitleNoTrans llTitle;
  
  @BindView(2131300196)
  ToggleButton tbSkin;
  
  @BindView(2131300696)
  CheckedTextView tvDark;
  
  @BindView(2131301119)
  CheckedTextView tvNomarl;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, BluedSkinFragment.class, null);
  }
  
  private void a(View paramView, boolean paramBoolean) {
    RippleAnimationView.a(paramView).a(1000L).a();
    BluedPreferences.I(paramBoolean);
    if (paramBoolean) {
      BluedSkinUtils.a("night.skin", new BluedSkinLoaderListener(this) {
            public void a() {}
            
            public void a(String param1String) {}
            
            public void b() {
              VipBubbleManager.a().b();
            }
          });
      EventTrackSettings.b(SettingsProtos.Event.DARK_MODE_BTN_CLICK, true);
      return;
    } 
    BluedSkinUtils.b();
    EventTrackSettings.b(SettingsProtos.Event.DARK_MODE_BTN_CLICK, false);
    VipBubbleManager.a().b();
  }
  
  private void b(boolean paramBoolean) {
    CheckedTextView checkedTextView = this.tvNomarl;
    Drawable drawable2 = null;
    if (paramBoolean) {
      drawable1 = null;
    } else {
      drawable1 = getResources().getDrawable(2131232616);
    } 
    checkedTextView.setCheckMarkDrawable(drawable1);
    checkedTextView = this.tvDark;
    Drawable drawable1 = drawable2;
    if (paramBoolean)
      drawable1 = getResources().getDrawable(2131232616); 
    checkedTextView.setCheckMarkDrawable(drawable1);
  }
  
  private void c(boolean paramBoolean) {
    BluedPreferences.Q(paramBoolean);
    d(paramBoolean);
  }
  
  private void d(boolean paramBoolean) {
    if (paramBoolean) {
      this.llCustom.setVisibility(8);
      this.tvDark.setVisibility(8);
      this.tvNomarl.setVisibility(8);
      return;
    } 
    this.llCustom.setVisibility(0);
    this.tvDark.setVisibility(0);
    this.tvNomarl.setVisibility(0);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.llTitle.setCenterText(getResources().getString(2131755663));
    this.llTitle.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    b(BluedPreferences.cZ());
    this.tvNomarl.setOnClickListener(this);
    this.tvDark.setOnClickListener(this);
    if (Build.VERSION.SDK_INT < 29) {
      this.llSystem.setVisibility(8);
      this.llCustom.setVisibility(8);
      return;
    } 
    d(BluedPreferences.dO());
    this.tbSkin.setChecked(BluedPreferences.dO());
    this.tbSkin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              BluedSkinFragment bluedSkinFragment = this.a;
              BluedSkinFragment.a(bluedSkinFragment, (View)bluedSkinFragment.llSystem, BluedSkinUtils.a((Activity)this.a.getActivity()));
            } else {
              BluedSkinFragment bluedSkinFragment = this.a;
              bluedSkinFragment.onClick((View)bluedSkinFragment.tvNomarl);
            } 
            EventTrackSettings.c(SettingsProtos.Event.DARK_MODE_BTN_CLICK, param1Boolean);
            BluedSkinFragment.a(this.a, param1Boolean);
          }
        });
  }
  
  public void a(SkinObservable paramSkinObservable, Object paramObject) {
    int i = BluedSkinUtils.a(getContext(), 2131100728);
    getActivity().findViewById(16908290).setBackgroundColor(i);
    StatusBarHelper.a((Activity)getActivity());
    StatusBarHelper.a((Activity)getActivity(), BluedSkinUtils.a(getContext(), AppInfo.k()));
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131300696) {
      if (i != 2131301119)
        return; 
      b(false);
      a((View)this.tvNomarl, false);
      BluedPreferences.Q(false);
      return;
    } 
    b(true);
    a((View)this.tvDark, true);
    BluedPreferences.Q(false);
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    BluedSkinUtils.b(this);
  }
  
  public void onResume() {
    super.onResume();
    BluedSkinUtils.a(this);
  }
  
  public int p() {
    return 2131493324;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\BluedSkinFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */