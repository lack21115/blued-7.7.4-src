package com.soft.blued.ui.web;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NoTitleWebViewShowFragment extends WebViewShowInfoFragment {
  private View p;
  
  public NoTitleWebViewShowFragment a(String paramString) {
    String str = paramString;
    if (!paramString.contains("://")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("http://");
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    this.d = str;
    return this;
  }
  
  public void a(String paramString1, String paramString2) {
    if (!this.f.a(this.d, "")) {
      this.i.setVisibility(0);
      this.h.setVisibility(8);
      this.f.c().setVisibility(8);
    } 
  }
  
  protected void l() {
    super.l();
    this.p = this.e.findViewById(2131301751);
    this.p.setVisibility(8);
  }
  
  public void m() {
    this.f.b("");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\web\NoTitleWebViewShowFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */