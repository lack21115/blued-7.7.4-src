package com.soft.blued.ui.login_register.View;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.constant.LoginConstants;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.db.UserAccountsVDao;
import com.soft.blued.db.model.UserAccountsModel;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.LoginV1ForThreeActivity;
import com.soft.blued.ui.login_register.RegisterV1AreaCodeFragment;
import com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment;
import com.soft.blued.ui.setting.fragment.HelpCenterFragment;
import com.soft.blued.ui.setting.fragment.ServerAddressSettingFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class LoginFragment extends KeyBoardFragment implements View.OnClickListener {
  private LoginWithEmailFragment A;
  
  private MyAdapter B;
  
  private ImageView C;
  
  private LinearLayout D;
  
  private Bundle E;
  
  private Context e;
  
  private final int f = 0;
  
  private final int o = 1;
  
  private final int p = 2;
  
  private KeyboardListenLinearLayout q;
  
  private View r;
  
  private TextView s;
  
  private TabPageIndicatorWithDot t;
  
  private ViewPager u;
  
  private TextView v;
  
  private TextView w;
  
  private TextView x;
  
  private TextView y;
  
  private LoginWithPhoneFragment z;
  
  private void u() {
    this.s = (TextView)this.r.findViewById(2131296863);
    this.s.setVisibility(8);
    this.q = (KeyboardListenLinearLayout)this.r.findViewById(2131297981);
    this.q.setBackgroundColor(BluedSkinUtils.a(this.e, 2131100728));
    this.u = (ViewPager)this.r.findViewById(2131301698);
    this.t = (TabPageIndicatorWithDot)this.r.findViewById(2131300461);
    this.v = (TextView)this.r.findViewById(2131301344);
    this.w = (TextView)this.r.findViewById(2131301527);
    this.x = (TextView)this.r.findViewById(2131300781);
    this.y = (TextView)this.r.findViewById(2131301331);
    this.D = (LinearLayout)this.r.findViewById(2131299047);
    this.C = (ImageView)this.r.findViewById(2131296865);
    this.C.setOnClickListener(this);
    this.E = getArguments();
    if (this.E != null) {
      this.s.setVisibility(8);
      this.D.setVisibility(8);
      this.C.setVisibility(0);
    } 
    if (!TextUtils.isEmpty(BluedPreferences.bK()))
      CommonAlertDialog.a((Context)getActivity(), "", BluedPreferences.bK(), getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              BluedPreferences.Z("");
            }
          },  null, 0).a(false); 
  }
  
  private void v() {
    a(this.q);
    this.q.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
  }
  
  private void w() {
    this.z = new LoginWithPhoneFragment();
    this.A = new LoginWithEmailFragment();
    this.z.setArguments(this.E);
    this.A.setArguments(this.E);
    this.B = new MyAdapter(this, getChildFragmentManager());
    this.u.setAdapter((PagerAdapter)this.B);
    this.t.setViewPager(this.u);
    UserAccountsModel userAccountsModel = UserAccountsVDao.a().d();
    if (userAccountsModel != null && userAccountsModel.getLoginType() == 0)
      this.u.setCurrentItem(1); 
  }
  
  public boolean V_() {
    AppUtils.a(AppInfo.d());
    return false;
  }
  
  public boolean j() {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 100)
      return; 
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra(RegisterV1AreaCodeFragment.o);
      if (!StringUtils.e(str))
        LoginConstants.a = str; 
    } 
  }
  
  public void onClick(View paramView) {
    Intent intent;
    Bundle bundle;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301527:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.WECHAT);
        intent = new Intent(this.e, LoginV1ForThreeActivity.class);
        bundle = this.E;
        if (bundle != null)
          intent.putExtra("fragment_args", bundle); 
        intent.putExtra("from_three_plat", "plat_weixin");
        this.e.startActivity(intent);
        return;
      case 2131301344:
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PAGE_REGISTER_BTN_CLICK);
        LoginRegisterHttpUtils.a("signup_main");
        TerminalActivity.d(this.e, RegisterV1ForPhoneFragment.class, null);
        return;
      case 2131301331:
        TerminalActivity.d((Context)getActivity(), HelpCenterFragment.class, null);
        return;
      case 2131300781:
        LoginRegisterTools.a(getActivity());
        return;
      case 2131297981:
        KeyboardUtils.a((Activity)getActivity());
        return;
      case 2131296865:
        getActivity().finish();
        return;
      case 2131296863:
        break;
    } 
    TerminalActivity.d((Context)getActivity(), ServerAddressSettingFragment.class, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    getActivity().getWindow().setBackgroundDrawable(this.e.getResources().getDrawable(2131234242));
    View view = this.r;
    if (view == null) {
      this.r = paramLayoutInflater.inflate(2131493212, paramViewGroup, false);
      u();
      w();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.r.getParent()).removeView(this.r);
    } 
    return this.r;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    v();
  }
  
  public boolean t() {
    return (this.E != null);
  }
  
  public static interface AniInterface {}
  
  class MyAdapter extends FragmentPagerAdapter {
    public Object a;
    
    private String[] c = new String[] { LoginFragment.a(this.b).getResources().getString(2131755560), LoginFragment.a(this.b).getResources().getString(2131755523) };
    
    public MyAdapter(LoginFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return 2;
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)((param1Int != 0) ? ((param1Int != 1) ? null : LoginFragment.c(this.b)) : LoginFragment.b(this.b));
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.c[param1Int];
    }
    
    public void setPrimaryItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.setPrimaryItem(param1ViewGroup, param1Int, param1Object);
      if (param1Object == null)
        return; 
      Object object = this.a;
      if (object != null && object.equals(param1Object))
        return; 
      if (param1Object instanceof LoginWithPhoneFragment) {
        object = param1Object;
        if (((LoginWithPhoneFragment)object).j != null) {
          ((LoginWithPhoneFragment)object).j.requestFocus();
          this.a = param1Object;
          return;
        } 
      } else if (param1Object instanceof LoginWithEmailFragment) {
        object = param1Object;
        if (((LoginWithEmailFragment)object).g != null) {
          ((LoginWithEmailFragment)object).g.requestFocus();
          this.a = param1Object;
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\View\LoginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */