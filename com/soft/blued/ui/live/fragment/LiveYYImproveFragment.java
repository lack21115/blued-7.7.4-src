package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.http.H5Url;
import com.soft.blued.ui.live.presenter.LiveYYImprovePresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;

public class LiveYYImproveFragment extends LiveBaseImproveFragment<LiveYYImprovePresenter> implements View.OnClickListener {
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, LiveYYImproveFragment.class, null);
  }
  
  public void a(int paramInt, String paramString) {
    ((LiveYYImprovePresenter)s()).b(paramInt, paramString);
  }
  
  public void a(Context paramContext, String paramString, int paramInt) {
    ((LiveYYImprovePresenter)s()).a(paramContext, paramString, paramInt);
  }
  
  public void b(String paramString, List paramList) {
    byte b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("type:");
    stringBuilder.append(paramString);
    Log.i("xpp", stringBuilder.toString());
    if (paramString.hashCode() == 717989595 && paramString.equals("LIVE_SHOW_AGREEMENT")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    WebViewShowInfoFragment.show(getContext(), H5Url.a(56), 0);
  }
  
  public void b(boolean paramBoolean) {
    ((LiveYYImprovePresenter)s()).a(paramBoolean);
  }
  
  public void k() {
    WebViewShowInfoFragment.show((Context)getActivity(), H5Url.a(7), 0);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131301252) {
      super.onClick(paramView);
      return;
    } 
    ((LiveYYImprovePresenter)s()).a(false);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.f = getContext();
  }
  
  public void onResume() {
    super.onResume();
    if (this.h) {
      this.h = false;
      ((LiveYYImprovePresenter)s()).a(false);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveYYImproveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */