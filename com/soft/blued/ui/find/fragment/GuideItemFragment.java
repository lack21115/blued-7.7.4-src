package com.soft.blued.ui.find.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;

public class GuideItemFragment extends BaseFragment {
  private View d;
  
  private ImageView e;
  
  private TextView f;
  
  private TextView g;
  
  private HomeGuideFragment.GuideBean h;
  
  private void a() {
    this.e = (ImageView)this.d.findViewById(2131297796);
    this.f = (TextView)this.d.findViewById(2131301409);
    this.g = (TextView)this.d.findViewById(2131300704);
    HomeGuideFragment.GuideBean guideBean = this.h;
    if (guideBean != null) {
      this.e.setImageResource(guideBean.a);
      this.f.setText(this.h.b);
      this.g.setText(this.h.c);
    } 
  }
  
  public boolean V_() {
    return true;
  }
  
  public boolean j() {
    return false;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null)
      this.h = (HomeGuideFragment.GuideBean)getArguments().getSerializable("data"); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = paramLayoutInflater.inflate(2131494016, null);
    a();
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\GuideItemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */