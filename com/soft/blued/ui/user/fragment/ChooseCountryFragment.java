package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.KeyboardUtils;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SearchView;
import com.soft.blued.ui.login_register.AreaCode.AreaCodeSectionBar;
import com.soft.blued.ui.user.adapter.CountryAdapter;
import com.soft.blued.ui.user.model.Country;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChooseCountryFragment extends KeyBoardFragment {
  public CountryAdapter e;
  
  public SearchView f;
  
  private Context o;
  
  private View p;
  
  private List<Country> q = new ArrayList<Country>();
  
  private AreaCodeSectionBar r;
  
  private ListView s;
  
  private KeyboardListenLinearLayout t;
  
  private View u;
  
  public static void a(BaseFragment paramBaseFragment, int paramInt) {
    PermissionHelper.c(new PermissionCallbacks(paramBaseFragment, paramInt) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            TerminalActivity.a((Fragment)this.a, ChooseCountryFragment.class, null, this.b);
          }
        });
  }
  
  private void a(String paramString) {
    Intent intent = new Intent();
    intent.putExtra("areacode", paramString);
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  private String b(String paramString) {
    int i = paramString.length();
    String str = paramString;
    while (i < 5) {
      if ("*".equals(paramString)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("9");
        stringBuilder.append(str);
        str = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        stringBuilder.append(str);
        str = stringBuilder.toString();
      } 
      i++;
    } 
    return str;
  }
  
  private void t() {
    this.r = (AreaCodeSectionBar)this.p.findViewById(2131296351);
    this.s = (ListView)this.p.findViewById(2131296350);
    this.t = (KeyboardListenLinearLayout)this.p.findViewById(2131297981);
    this.u = this.p.findViewById(2131297985);
    this.f = (SearchView)this.p.findViewById(2131299874);
    this.f.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
          
          public void a(String param1String) {
            if (this.a.e != null) {
              this.a.e.b(param1String);
              this.a.e.notifyDataSetChanged();
            } 
          }
          
          public void b() {}
        });
  }
  
  private void u() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.p.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131755825));
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  private void v() {
    List<?> list = AreaUtils.c();
    Collections.sort(list, new Comparator<Country>(this) {
          public int a(Country param1Country1, Country param1Country2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ChooseCountryFragment.a(this.a, param1Country1.group_by));
            stringBuilder.append(param1Country1.abbr);
            String str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(ChooseCountryFragment.a(this.a, param1Country2.group_by));
            stringBuilder.append(param1Country2.abbr);
            return str.compareTo(stringBuilder.toString());
          }
        });
    for (int i = 0; i < list.size(); i++) {
      Country country1 = (Country)list.get(i);
      this.q.add(country1);
    } 
    this.e = new CountryAdapter(this.o, this.q);
    this.s.setAdapter((ListAdapter)this.e);
    this.r.a(this.s, this.e);
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            Country country = ChooseCountryFragment.a(this.a).get(param1Int);
            if ("1".equals(country.has_child)) {
              ChooseCountryFragment chooseCountryFragment1 = this.a;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(country.continent);
              stringBuilder1.append("_");
              stringBuilder1.append(country.nation_code);
              ChooseCityFragment.a((BaseFragment)chooseCountryFragment1, stringBuilder1.toString(), country.nation);
              return;
            } 
            ChooseCountryFragment chooseCountryFragment = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(country.continent);
            stringBuilder.append("_");
            stringBuilder.append(country.nation_code);
            stringBuilder.append("_000000");
            ChooseCountryFragment.b(chooseCountryFragment, stringBuilder.toString());
          }
        });
    Country country = new Country(this.o.getResources().getString(2131755823).replace("_", ""), "156", "CN", "CN", "1", 1);
    country.group_by = getResources().getString(2131758408);
    this.e.a(country);
    this.e.notifyDataSetChanged();
  }
  
  public void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  public void e_(int paramInt) {
    if (BluedConstant.f != BluedConstant.h) {
      if (BluedConstant.f == BluedConstant.g)
        return; 
      if (paramInt != -3) {
        if (paramInt != -2)
          return; 
        this.u.setVisibility(8);
        this.u.setOnTouchListener(null);
        SearchView searchView = this.f;
        if (searchView != null) {
          searchView.a(false);
          return;
        } 
      } else {
        this.u.setVisibility(0);
        this.u.setOnTouchListener(new View.OnTouchListener(this) {
              public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
                if (param1MotionEvent.getAction() == 0) {
                  Rect rect = new Rect();
                  this.a.f.getFocusedRect(rect);
                  if (!rect.contains((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY()))
                    KeyboardUtils.a((Activity)this.a.getActivity()); 
                } 
                return false;
              }
            });
        SearchView searchView = this.f;
        if (searchView != null)
          searchView.a(true); 
      } 
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("areacode")))
      a(paramIntent.getStringExtra("areacode")); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.o = (Context)getActivity();
    if (this.p == null) {
      this.p = paramLayoutInflater.inflate(2131493336, paramViewGroup, false);
      t();
      u();
      b(this.t);
      v();
    } 
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ChooseCountryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */