package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

public class AccountLockedFragment extends BaseFragment {
  public String d;
  
  public String e;
  
  public Context f;
  
  public View g;
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putString("KEY_CONTENT", paramString1);
    bundle.putString("KEY_UID", paramString2);
    TerminalActivity.d(paramContext, AccountLockedFragment.class, bundle);
  }
  
  public void a() {
    ((CommonTopTitleNoTrans)this.g.findViewById(2131300273)).setLeftClickListener(new -$$Lambda$AccountLockedFragment$sjwVbZyhxJfyQDAaZni-I8Yrrfw(this));
    ((TextView)this.g.findViewById(2131300663)).setText(this.d);
    ((TextView)this.g.findViewById(2131300518)).setOnClickListener(new -$$Lambda$AccountLockedFragment$KLkIzpPzicRSxH4LiFBGpcPF1I8(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    if (this.g == null) {
      this.g = paramLayoutInflater.inflate(2131493071, paramViewGroup, false);
      if (getArguments() != null) {
        this.d = getArguments().getString("KEY_CONTENT");
        this.e = getArguments().getString("KEY_UID");
      } 
      a();
    } 
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\AccountLockedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */