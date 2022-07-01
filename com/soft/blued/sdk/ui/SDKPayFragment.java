package com.soft.blued.sdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.utils.Logger;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.model.DialogWith6PW;

public class SDKPayFragment extends BaseFragment implements View.OnClickListener, SDKPayContract.IView {
  CommonTopTitleNoTrans d;
  
  private long e;
  
  private int f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private SDKPayContract.IPresenter m;
  
  private View n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private Button s;
  
  private Dialog t;
  
  private TextView u;
  
  private TextView v;
  
  public static void a(Context paramContext, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    Bundle bundle = new Bundle();
    bundle.putLong("action_id", paramLong);
    bundle.putInt("goods_id", paramInt);
    bundle.putString("app_key", paramString1);
    bundle.putString("secret_key", paramString2);
    bundle.putString("app_sign", paramString3);
    bundle.putString("app_sign_t", paramString4);
    bundle.putString("app_token", paramString5);
    bundle.putString("app_body", paramString6);
    Logger.a("SDKAction", new Object[] { 
          "SDKPayFragment.show(), actionId:", Long.valueOf(paramLong), ", goodsId:", Integer.valueOf(paramInt), ", appKey:", paramString1, ", appSecretKey:", paramString2, ", appSign:", paramString3, 
          ", appSignT:", paramString4, ", appToken:", paramString5, ", appBody:", paramString6 });
    TerminalActivity.d(paramContext, SDKPayFragment.class, bundle);
  }
  
  private void k() {
    this.e = getArguments().getLong("action_id");
    this.f = getArguments().getInt("goods_id");
    this.g = getArguments().getString("app_key");
    this.h = getArguments().getString("secret_key");
    this.j = getArguments().getString("app_sign");
    this.k = getArguments().getString("app_sign_t");
    this.i = getArguments().getString("app_token");
    this.l = getArguments().getString("app_body");
    this.m = new SDKPayPresenter((Context)getActivity(), this.e, this.f, this.g, this.h, this.j, this.k, this.i, this.l, this);
    this.o = (TextView)this.n.findViewById(2131300557);
    this.p = (TextView)this.n.findViewById(2131301146);
    this.q = (TextView)this.n.findViewById(2131301166);
    this.r = (TextView)this.n.findViewById(2131300810);
    this.s = (Button)this.n.findViewById(2131296602);
    this.s.setOnClickListener(this);
    this.t = DialogUtils.b((Context)getActivity());
    this.u = (TextView)this.n.findViewById(2131300551);
    this.v = (TextView)this.n.findViewById(2131301444);
    this.v.setOnClickListener(this);
    this.m.bb_();
    this.d = (CommonTopTitleNoTrans)this.n.findViewById(2131300278);
    this.d.setCenterText(getString(2131758657));
    this.d.setLeftClickListener(this);
    this.d.a();
  }
  
  public boolean V_() {
    SDKActionManager.a((Context)getActivity(), this.e);
    getActivity().finish();
    return true;
  }
  
  public void a() {
    DialogUtils.a(this.t);
  }
  
  public void a(double paramDouble) {
    long l = (long)paramDouble;
    this.u.setText(getString(2131758649, new Object[] { Long.valueOf(l) }));
  }
  
  public void a(int paramInt) {
    this.o.setText(String.valueOf(paramInt));
  }
  
  public void a(String paramString) {
    this.q.setText(paramString);
  }
  
  public void aD_() {
    this.s.setVisibility(8);
  }
  
  public void aE_() {
    String str1 = getString(2131755031);
    String str2 = getString(2131758659);
    CommonAlertDialog.a((Context)getActivity(), str1, str2, true, true, true, false, new CommonAlertDialog.PWDListener(this) {
          public void a(String param1String, boolean param1Boolean, DialogWith6PW param1DialogWith6PW) {
            SDKPayFragment.a(this.a).a(param1String);
          }
        },  null);
  }
  
  public void aF_() {
    CommonAlertDialog.a((Context)getActivity(), null, "", getString(2131758652), getString(2131756057), getString(2131756086), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            SDKPayFragment.a(this.a).c();
          }
        },  null, null, true);
  }
  
  public void b() {
    DialogUtils.b(this.t);
  }
  
  public void b(String paramString) {
    this.p.setText(getString(2131758653, new Object[] { paramString }));
  }
  
  public void c(String paramString) {
    this.r.setText(paramString);
  }
  
  public void e() {
    this.s.setVisibility(0);
  }
  
  public void h() {
    if (w_() != null && w_().isActive())
      getActivity().finish(); 
  }
  
  public void i() {
    CommonAlertDialog.a((Context)getActivity(), null, "", getString(2131758651), getString(2131756057), getString(2131756086), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            SDKPayFragment.a(this.a).b();
          }
        },  null, null, true);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296602) {
      if (i != 2131296863) {
        if (i != 2131301444)
          return; 
        this.m.b();
        return;
      } 
      Logger.a("SDKAction", new Object[] { "click return btn, cancel action" });
      SDKActionManager.a((Context)getActivity(), this.e);
      getActivity().finish();
      return;
    } 
    this.m.a((String)null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.n;
    if (view == null) {
      this.n = paramLayoutInflater.inflate(2131493304, paramViewGroup, false);
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.n.getParent()).removeView(this.n);
    } 
    return this.n;
  }
  
  public void onResume() {
    super.onResume();
    if (!SDKActionManager.a(this.e)) {
      getActivity().finish();
      return;
    } 
    this.m.a(true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sd\\ui\SDKPayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */