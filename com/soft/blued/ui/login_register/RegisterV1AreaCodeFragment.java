package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.model.AreaCode;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSectionBar;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSelectorAdapter;
import com.soft.blued.ui.login_register.View.LoginWithPhoneFragment;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegisterV1AreaCodeFragment extends KeyBoardFragment implements View.OnClickListener {
  public static String o = "select_area_code";
  
  public static String p = "from_page";
  
  public AreaCodeSelectorAdapter e;
  
  public EditText f;
  
  private String q = RegisterV1AreaCodeFragment.class.getSimpleName();
  
  private KeyboardListenLinearLayout r;
  
  private Context s;
  
  private CommonTopTitleNoTrans t;
  
  private ListView u;
  
  private AreaCodeSectionBar v;
  
  private SearchView w;
  
  private List<AreaCode> x = new ArrayList<AreaCode>();
  
  private void t() {
    this.t = (CommonTopTitleNoTrans)this.r.findViewById(2131300300);
    this.t.a();
    this.t.setCenterText(getString(2131755491));
    this.t.setLeftClickListener(this);
  }
  
  private void u() {
    this.v = (AreaCodeSectionBar)this.r.findViewById(2131296351);
    this.u = (ListView)this.r.findViewById(2131296350);
    if (getArguments() != null) {
      String str = getArguments().getString(p);
      if (!StringUtils.e(str)) {
        if (str.equals(RegisterV1ForPhoneFragment.class.getSimpleName())) {
          this.t.setCenterText(this.s.getResources().getString(2131755491));
          return;
        } 
        if (str.equals(LoginWithPhoneFragment.class.getSimpleName()))
          this.t.setCenterText(this.s.getResources().getString(2131755488)); 
      } 
    } 
  }
  
  private void v() {
    this.w = (SearchView)this.r.findViewById(2131299874);
    this.f = (EditText)this.w.getEditView();
    this.w.setMaskLayerOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TerminalActivity.a((Fragment)this.a, RegisterV1AreaCodeSearchFragment.class, null, 100);
          }
        });
  }
  
  private void w() {
    this.x = AreaUtils.b();
    Collections.sort(this.x);
    this.e = new AreaCodeSelectorAdapter(this.s, this.x);
    this.u.setAdapter((ListAdapter)this.e);
    this.v.setListView(this.u);
    this.u.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            LoginRegisterHttpUtils.a("sel_country_mo");
            Intent intent = new Intent();
            intent.putExtra(RegisterV1AreaCodeFragment.o, ((AreaCode)RegisterV1AreaCodeFragment.a(this.a).get(param1Int)).getCode());
            this.a.getActivity().setResult(-1, intent);
            this.a.getActivity().finish();
          }
        });
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      SearchView searchView = this.w;
      if (searchView != null) {
        searchView.a(false);
        return;
      } 
    } else {
      SearchView searchView = this.w;
      if (searchView != null)
        searchView.a(true); 
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 100)
      return; 
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra(o);
      Intent intent = new Intent();
      intent.putExtra(o, str);
      getActivity().setResult(-1, intent);
      getActivity().finish();
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296863)
      return; 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.s = (Context)getActivity();
    KeyboardListenLinearLayout keyboardListenLinearLayout = this.r;
    if (keyboardListenLinearLayout == null) {
      this.r = (KeyboardListenLinearLayout)paramLayoutInflater.inflate(2131493290, paramViewGroup, false);
      this.r.setBackgroundColor(BluedSkinUtils.a(this.s, 2131100728));
      a(this.r);
      t();
      u();
      v();
      w();
    } else if (keyboardListenLinearLayout.getParent() != null) {
      ((ViewGroup)this.r.getParent()).removeView((View)this.r);
    } 
    return (View)this.r;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\RegisterV1AreaCodeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */