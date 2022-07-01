package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.View.VerifyCodeFragment;
import com.soft.blued.ui.setting.Contract.LoginDeviceListContract;
import com.soft.blued.ui.setting.Presenter.LoginDeviceListPresenter;
import com.soft.blued.ui.setting.adapter.LoginDeviceListAdapter;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class LoginDeviceListFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, LoginDeviceListContract.IView {
  private View d;
  
  private Context e;
  
  private LoginDeviceListContract.IPresenter f;
  
  private LoginDeviceListAdapter g;
  
  private View h;
  
  private Dialog i;
  
  private TextView j;
  
  private ListView k;
  
  private ToggleButton l;
  
  private CommonTopTitleNoTrans m;
  
  private RenrenPullToRefreshListView n;
  
  private String o;
  
  private List<DeviceModel> p;
  
  private boolean q;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, LoginDeviceListFragment.class, null);
  }
  
  private void a(boolean paramBoolean, List<DeviceModel> paramList) {
    this.p.clear();
    if (paramBoolean) {
      if (paramList == null || paramList.size() == 0) {
        this.j.setVisibility(8);
      } else {
        this.j.setVisibility(0);
        this.p.addAll(paramList);
      } 
    } else {
      this.j.setVisibility(8);
    } 
    this.g.notifyDataSetChanged();
  }
  
  private void k() {
    this.m = (CommonTopTitleNoTrans)this.d.findViewById(2131296873);
    this.m.a();
    this.m.setLeftImg(2131232743);
    this.m.setCenterText(2131757811);
    this.m.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.i = DialogUtils.a(this.e);
    this.n = (RenrenPullToRefreshListView)this.d.findViewById(2131299761);
    this.n.setRefreshEnabled(false);
    this.k = (ListView)this.n.getRefreshableView();
    this.p = new ArrayList<DeviceModel>();
    this.g = new LoginDeviceListAdapter(this.e, this.f, this.p);
    this.h = LayoutInflater.from(this.e).inflate(2131493401, (ViewGroup)this.k, false);
    this.j = (TextView)this.h.findViewById(2131300968);
    this.l = (ToggleButton)this.h.findViewById(2131300246);
    this.k.addHeaderView(this.h);
    this.k.setAdapter((ListAdapter)this.g);
    this.l.setOnCheckedChangeListener(this);
  }
  
  public void a() {
    DialogUtils.a(this.i);
  }
  
  public void a(LoginProtectionModel paramLoginProtectionModel) {
    if (paramLoginProtectionModel != null) {
      int i = paramLoginProtectionModel.device_safe;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.l.setChecked(bool);
      BluedPreferences.D(bool);
      a(bool, paramLoginProtectionModel.devices);
    } 
  }
  
  public void a(String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("mobile", paramString);
    bundle.putInt("target_type", 1);
    VerifyCodeFragment.a(this.e, bundle);
  }
  
  public void a(boolean paramBoolean) {
    this.q = false;
    this.l.setOnCheckedChangeListener(null);
    this.l.setChecked(paramBoolean);
    BluedPreferences.D(paramBoolean);
    this.l.setOnCheckedChangeListener(this);
  }
  
  public void b() {
    DialogUtils.b(this.i);
  }
  
  public void c() {
    this.q = true;
    CommonAlertDialog.a(this.e, null, getResources().getString(2131758327), getResources().getString(2131755636), getResources().getString(2131755726), getResources().getString(2131758897), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            Bundle bundle = new Bundle();
            bundle.putString("from_page", "login_secure");
            TerminalActivity.d((Context)this.a.getActivity(), LinkMobileFragment.class, bundle);
          }
        }new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.a(false);
          }
        },  new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            this.a.a(false);
          }
        },  false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    this.l.setEnabled(false);
    a(new Runnable(this) {
          public void run() {
            LoginDeviceListFragment.a(this.a).setEnabled(true);
          }
        },  1000L);
    if (!paramCompoundButton.isPressed())
      return; 
    BluedPreferences.D(paramBoolean);
    if (!paramBoolean) {
      this.q = true;
      CommonAlertDialog.a(this.e, null, getResources().getString(2131759084), getResources().getString(2131759085), getResources().getString(2131755726), getResources().getString(2131758968), new DialogInterface.OnClickListener(this, paramBoolean) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              LoginDeviceListFragment loginDeviceListFragment = this.b;
              LoginDeviceListFragment.a(loginDeviceListFragment, this.a, LoginDeviceListFragment.b(loginDeviceListFragment).b());
              LoginDeviceListFragment.b(this.b).a("close", "");
            }
          }new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.a.a(true);
            }
          },  new DialogInterface.OnCancelListener(this) {
            public void onCancel(DialogInterface param1DialogInterface) {
              this.a.a(true);
            }
          },  false);
      return;
    } 
    this.f.a("set", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493211, paramViewGroup, false);
      this.f = (LoginDeviceListContract.IPresenter)new LoginDeviceListPresenter(this, (IRequestHost)w_());
      k();
    } else {
      ((ViewGroup)view.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onDestroy() {
    super.onDestroy();
    b();
  }
  
  public void onStart() {
    super.onStart();
    this.f.bb_();
    this.o = LoginRegisterTools.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\LoginDeviceListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */