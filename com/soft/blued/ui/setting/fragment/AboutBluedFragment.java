package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.MarketTool;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.version.update.UpdateVersionFragment;
import com.soft.blued.version.update.UpdateVersionHelper;

public class AboutBluedFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private TextView e;
  
  private LinearLayout f;
  
  private LinearLayout g;
  
  private LinearLayout h;
  
  private LinearLayout i;
  
  private LinearLayout j;
  
  private View k;
  
  private ShapeTextView l;
  
  private ShapeTextView m;
  
  private Dialog n;
  
  private String o = AboutBluedFragment.class.getSimpleName();
  
  private void a() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.k.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131755213));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
  
  private void k() {
    this.e = (TextView)this.k.findViewById(2131301490);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getResources().getString(2131759210));
    stringBuilder.append(" ");
    stringBuilder.append(DeviceUtils.c());
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if ("a8888a".equals(AppInfo.c)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(" beta");
      str1 = stringBuilder1.toString();
    } 
    this.e.setText(str1);
    this.f = (LinearLayout)this.k.findViewById(2131299131);
    this.g = (LinearLayout)this.k.findViewById(2131298996);
    this.i = (LinearLayout)this.k.findViewById(2131299035);
    this.l = (ShapeTextView)this.k.findViewById(2131297951);
    this.h = (LinearLayout)this.k.findViewById(2131298952);
    this.j = (LinearLayout)this.k.findViewById(2131298895);
    this.m = (ShapeTextView)this.k.findViewById(2131297817);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.setOnClickListener(this);
    if (DeviceUtils.f())
      this.g.setVisibility(8); 
    this.n = DialogUtils.a((Context)getActivity());
    str1 = BluedPreferences.dK();
    if (DeviceUtils.b() > StringUtils.a(str1, 0)) {
      this.m.setVisibility(0);
      return;
    } 
    this.m.setVisibility(8);
  }
  
  private void l() {
    MineHttpUtils.a((Context)getActivity(), "1", (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<DownloadBaseInfo>>(this) {
          public void a(BluedEntityA<DownloadBaseInfo> param1BluedEntityA) {
            if (CommonTools.a((Fragment)this.a)) {
              DialogUtils.b(AboutBluedFragment.a(this.a));
              if (param1BluedEntityA != null)
                try {
                  if (param1BluedEntityA.hasData()) {
                    DownloadBaseInfo downloadBaseInfo = param1BluedEntityA.data.get(0);
                    String str = downloadBaseInfo.type;
                    if (!StringUtils.e(str) && str.equals("0")) {
                      AppMethods.a(this.a.getResources().getString(2131755628));
                      return;
                    } 
                    if (!TextUtils.isEmpty(str) && str.equals("1")) {
                      UpdateVersionFragment.a(AboutBluedFragment.b(this.a), downloadBaseInfo, "i_s_weak_update");
                      return;
                    } 
                    if (!TextUtils.isEmpty(str) && str.equals("2")) {
                      UpdateVersionFragment.a(AboutBluedFragment.b(this.a), downloadBaseInfo, "i_s_strong_update");
                      return;
                    } 
                  } 
                } catch (Exception exception) {
                  exception.printStackTrace();
                }  
            } 
          }
          
          public void onUIStart() {
            DialogUtils.a(AboutBluedFragment.a(this.a));
          }
        });
  }
  
  public void onClick(View paramView) {
    Intent intent;
    String str;
    switch (paramView.getId()) {
      default:
        return;
      case 2131299131:
        if (!DeviceUtils.f()) {
          int i = UpdateVersionHelper.a(this.d);
          if (i != -1) {
            if (i != 2) {
              if (i != 8)
                return; 
              UpdateVersionFragment.a(this.d, "i_s_install_update");
              return;
            } 
            AppMethods.d(2131759020);
            return;
          } 
          l();
          return;
        } 
        return;
      case 2131299035:
        intent = MarketTool.a().b();
        if (AppUtils.a(intent)) {
          startActivity(intent);
          return;
        } 
        return;
      case 2131298996:
        if ("CN".equals(BlueAppLocal.c().getCountry())) {
          str = BluedHttpUrl.a;
        } else {
          str = "http://m.bluedapp.com";
        } 
        WebViewShowInfoFragment.a((Context)getActivity(), str, getResources().getString(2131758293), 2);
        return;
      case 2131298952:
        str = getResources().getString(2131755654);
        WebViewShowInfoFragment.a((Context)getActivity(), str, getResources().getString(2131757898), 7);
        return;
      case 2131298895:
        if (this.m.getVisibility() == 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(DeviceUtils.b());
          BluedPreferences.ao(stringBuilder.toString());
          this.m.setVisibility(8);
        } 
        WebViewShowInfoFragment.a((Context)getActivity(), H5Url.a(46), getResources().getString(2131757074), 7);
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.k;
    if (view == null) {
      this.k = paramLayoutInflater.inflate(2131493069, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.k.getParent()).removeView(this.k);
    } 
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\AboutBluedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */