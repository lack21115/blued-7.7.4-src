package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;

public class LiveLiangWebFragment extends BaseFragment {
  public PopLiveActivityWebView d;
  
  public String e;
  
  public int f;
  
  private Context g;
  
  private View h;
  
  private void a() {
    if (getArguments() != null) {
      this.e = getArguments().getString("web_url");
      this.f = getArguments().getInt("type");
    } 
  }
  
  public ViewGroup a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup) {
    return (ViewGroup)paramLayoutInflater.inflate(R.layout.dialog_live_web, paramViewGroup, false);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = (Context)getActivity();
    getActivity().getWindow().setSoftInputMode(18);
    View view = this.h;
    if (view == null)
      try {
        this.h = (View)a(paramLayoutInflater, paramViewGroup);
        a();
        this.d = (PopLiveActivityWebView)this.h.findViewById(R.id.live_activity_web_view);
        this.d.a((Fragment)this);
        this.d.b(this.e, this.f);
        return this.h;
      } catch (InflateException inflateException) {
        getActivity().finish();
        AppMethods.a("请前往系统应用商店安装系统浏览器~");
        return null;
      }  
    if (view.getParent() != null)
      ((ViewGroup)this.h.getParent()).removeView(this.h); 
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveLiangWebFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */