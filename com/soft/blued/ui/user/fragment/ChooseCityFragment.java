package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.user.adapter.CountryAdapter;
import com.soft.blued.ui.user.model.Country;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ChooseCityFragment extends BaseFragment {
  public CountryAdapter d;
  
  private Context e;
  
  private View f;
  
  private List<Country> g = new ArrayList<Country>();
  
  private ListView h;
  
  private String i = "";
  
  private String j = "";
  
  private void a() {
    this.h = (ListView)this.f.findViewById(2131296350);
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putString("areacode", paramString1);
    bundle.putString("areaname", paramString2);
    TerminalActivity.a((Fragment)paramBaseFragment, ChooseCityFragment.class, bundle, 1766);
  }
  
  private void a(String paramString) {
    Intent intent = new Intent();
    intent.putExtra("areacode", paramString);
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  private void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.f.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    if (!StringUtils.e(this.j)) {
      commonTopTitleNoTrans.setCenterText(this.j);
      return;
    } 
    commonTopTitleNoTrans.setCenterText(getResources().getString(2131755825));
  }
  
  private void l() {
    List<Country> list = AreaUtils.a(this.i);
    for (int i = 0; i < list.size(); i++) {
      Country country = list.get(i);
      this.g.add(country);
    } 
    this.d = new CountryAdapter(this.e, this.g);
    this.h.setAdapter((ListAdapter)this.d);
    this.h.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            Country country = ChooseCityFragment.a(this.a).get(param1Int);
            if ("1".equals(country.has_child)) {
              ChooseCityFragment.a(this.a, country.nation_code, country.nation);
              return;
            } 
            ChooseCityFragment.a(this.a, country.nation_code);
          }
        });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramIntent != null && !StringUtils.e(paramIntent.getStringExtra("areacode")))
      a(paramIntent.getStringExtra("areacode")); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    if (this.f == null) {
      this.f = paramLayoutInflater.inflate(2131493335, paramViewGroup, false);
      if (getArguments() != null) {
        this.i = getArguments().getString("areacode");
        this.j = getArguments().getString("areaname");
      } 
      a();
      k();
      l();
    } 
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ChooseCityFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */