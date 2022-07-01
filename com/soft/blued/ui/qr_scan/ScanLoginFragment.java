package com.soft.blued.ui.qr_scan;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.http.LoginRegisterHttpUtils;

public class ScanLoginFragment extends BaseFragment implements View.OnClickListener {
  public static String d;
  
  private Context e;
  
  private TextView f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private Dialog j;
  
  private View k;
  
  private Bundle l;
  
  private String m;
  
  private boolean n;
  
  private int o = 15;
  
  private boolean p;
  
  private Handler q = new Handler(new Handler.Callback(this) {
        public boolean handleMessage(Message param1Message) {
          int i = param1Message.what;
          return false;
        }
      });
  
  private Runnable r = new Runnable(this) {
      public void run() {
        if (ScanLoginFragment.a(this.a))
          return; 
        if (ScanLoginFragment.b(this.a) == 0) {
          ScanLoginFragment.c(this.a).setVisibility(0);
          ScanLoginFragment.c(this.a).setTextColor(ScanLoginFragment.d(this.a).getResources().getColor(2131100594));
          ScanLoginFragment.a(this.a, true);
          ScanLoginFragment.e(this.a).setText(ScanLoginFragment.d(this.a).getResources().getString(2131758511));
          ScanLoginFragment.c(this.a).setText(ScanLoginFragment.d(this.a).getResources().getString(2131758509));
          return;
        } 
        ScanLoginFragment.f(this.a);
        ScanLoginFragment.g(this.a).postDelayed(this, 1000L);
      }
    };
  
  private void a() {
    this.f = (TextView)this.k.findViewById(2131299828);
    this.f.setOnClickListener(this);
  }
  
  private void a(String paramString) {
    LoginRegisterHttpUtils.a(this.e, new BluedUIHttpResponse(this) {
          public boolean onUIFailure(int param1Int, String param1String) {
            ScanLoginFragment.c(this.a).setVisibility(0);
            ScanLoginFragment.c(this.a).setTextColor(ScanLoginFragment.d(this.a).getResources().getColor(2131100592));
            ScanLoginFragment.c(this.a).setText(ScanLoginFragment.d(this.a).getResources().getString(2131758510));
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ScanLoginFragment.h(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ScanLoginFragment.h(this.a));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.a("登录成功");
            this.a.getActivity().finish();
          }
        }paramString, (IRequestHost)w_());
  }
  
  private void k() {
    this.j = DialogUtils.a(this.e);
    this.h = (TextView)this.k.findViewById(2131299829);
    this.h.setOnClickListener(this);
    this.g = (TextView)this.k.findViewById(2131299827);
    this.i = (TextView)this.k.findViewById(2131299828);
  }
  
  private void l() {
    this.l = getArguments();
    Bundle bundle = this.l;
    if (bundle != null)
      this.m = bundle.getString(d); 
    this.q.post(this.r);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131299829:
        if (this.p) {
          Intent intent = new Intent((Context)getActivity(), CaptureActivity.class);
          getActivity().startActivity(intent);
          getActivity().finish();
          return;
        } 
        a(this.m);
        return;
      case 2131299828:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.k;
    if (view == null) {
      this.k = paramLayoutInflater.inflate(2131493302, paramViewGroup, false);
      a();
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.k.getParent()).removeView(this.k);
    } 
    return this.k;
  }
  
  public void onPause() {
    super.onPause();
    this.n = true;
  }
  
  public void onResume() {
    super.onResume();
    if (this.n) {
      this.q.post(this.r);
      this.n = false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\qr_scan\ScanLoginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */