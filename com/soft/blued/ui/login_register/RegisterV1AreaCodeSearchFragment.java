package com.soft.blued.ui.login_register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.model.AreaCode;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSelectorSearchAdapter;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RegisterV1AreaCodeSearchFragment extends KeyBoardFragment {
  public AreaCodeSelectorSearchAdapter e;
  
  public SearchView f;
  
  private String o = RegisterV1AreaCodeSearchFragment.class.getSimpleName();
  
  private View p;
  
  private Context q;
  
  private ListView r;
  
  private KeyboardListenLinearLayout s;
  
  private View t;
  
  private List<AreaCode> u = new ArrayList<AreaCode>();
  
  private List<AreaCode> v = new ArrayList<AreaCode>();
  
  private List<AreaCode> a(String paramString) {
    AreaCode areaCode;
    ArrayList<AreaCode> arrayList2 = new ArrayList();
    this.u = AreaUtils.b();
    List<AreaCode> list = this.u;
    ArrayList<AreaCode> arrayList1 = arrayList2;
    if (list != null) {
      arrayList1 = arrayList2;
      if (list.size() > 0) {
        arrayList2 = new ArrayList();
        Iterator<AreaCode> iterator = this.v.iterator();
        while (true) {
          arrayList1 = arrayList2;
          if (iterator.hasNext()) {
            areaCode = iterator.next();
            if (!TextUtils.isEmpty(areaCode.getName()) && areaCode.getName().toLowerCase().contains(paramString.toLowerCase()))
              arrayList2.add(areaCode); 
            continue;
          } 
          break;
        } 
      } 
    } 
    return (List<AreaCode>)areaCode;
  }
  
  private void t() {
    this.r = (ListView)this.p.findViewById(2131296350);
    this.r.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            LoginRegisterHttpUtils.a("sel_country_mo");
            AreaCode areaCode = (AreaCode)param1AdapterView.getAdapter().getItem(param1Int);
            if (areaCode != null) {
              Intent intent = new Intent();
              intent.putExtra(RegisterV1AreaCodeFragment.o, areaCode.getCode());
              this.a.getActivity().setResult(-1, intent);
              this.a.getActivity().finish();
            } 
          }
        });
  }
  
  private void u() {
    this.s = (KeyboardListenLinearLayout)this.p.findViewById(2131297981);
    this.t = this.p.findViewById(2131297985);
    this.f = (SearchView)this.p.findViewById(2131299874);
    this.f.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
          
          public void a(String param1String) {
            if (!StringUtils.e(param1String)) {
              this.a.e.a(RegisterV1AreaCodeSearchFragment.a(this.a, param1String), param1String);
              return;
            } 
            this.a.e.a(RegisterV1AreaCodeSearchFragment.a(this.a), "");
          }
          
          public void b() {}
        });
  }
  
  private void v() {
    this.u = AreaUtils.b();
    this.v.addAll(this.u);
    Collections.sort(this.u);
    this.e = new AreaCodeSelectorSearchAdapter(this.q, this.u);
    this.r.setAdapter((ListAdapter)this.e);
  }
  
  public void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  public void e_(int paramInt) {
    if (BluedConstant.f != BluedConstant.g) {
      if (BluedConstant.f == BluedConstant.h)
        return; 
      if (paramInt != -3) {
        if (paramInt != -2)
          return; 
        this.t.setVisibility(8);
        this.t.setOnTouchListener(null);
        SearchView searchView = this.f;
        if (searchView != null) {
          searchView.a(false);
          return;
        } 
      } else {
        this.t.setVisibility(0);
        this.t.setOnTouchListener(new View.OnTouchListener(this) {
              public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
                if (param1MotionEvent.getAction() != 0)
                  return false; 
                if (param1MotionEvent.getAction() == 0)
                  KeyboardUtils.a((Activity)this.a.getActivity()); 
                return true;
              }
            });
        SearchView searchView = this.f;
        if (searchView != null)
          searchView.a(true); 
      } 
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.q = (Context)getActivity();
    View view = this.p;
    if (view == null) {
      this.p = paramLayoutInflater.inflate(2131493291, paramViewGroup, false);
      t();
      u();
      v();
      this.s.setBackgroundColor(BluedSkinUtils.a(this.q, 2131100728));
      b(this.s);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.p.getParent()).removeView(this.p);
    } 
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\RegisterV1AreaCodeSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */