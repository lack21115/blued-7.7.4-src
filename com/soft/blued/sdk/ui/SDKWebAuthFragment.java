package com.soft.blued.sdk.ui;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.web.BluedWebView;
import com.soft.blued.http.H5Url;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.sdk.SDKAuthAction;
import com.soft.blued.sdk.SDKBaseAction;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;

public class SDKWebAuthFragment extends WebViewShowInfoFragment {
  private long p = 0L;
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong) {
    paramString1 = H5Url.a(30, new Object[] { paramString1 });
    Bundle bundle = new Bundle();
    bundle.putString("web_url", paramString1);
    bundle.putString("title_name", "");
    bundle.putInt("from_tag", 0);
    bundle.putLong("action_id", paramLong);
    TerminalActivity.d(paramContext, SDKWebAuthFragment.class, bundle);
  }
  
  public void a() {
    super.a();
    this.p = getArguments().getLong("action_id");
    Logger.a("SDKAction", new Object[] { "SDKWebAuthFragment init, actionId:", Long.valueOf(this.p) });
  }
  
  public boolean a(BluedWebView paramBluedWebView, BluedUrlParser paramBluedUrlParser) {
    String str1;
    String str2;
    if ("blued_auth".equals(paramBluedUrlParser.a()) && w_() != null && w_().isActive()) {
      if (paramBluedUrlParser.b() != null) {
        boolean bool;
        str1 = (String)paramBluedUrlParser.b().get("access_token");
        String str = (String)paramBluedUrlParser.b().get("expire");
        str2 = (String)paramBluedUrlParser.b().get("package_name");
        try {
          bool = Integer.parseInt(str);
        } catch (Exception exception) {
          exception.printStackTrace();
          bool = false;
        } 
        SDKBaseAction sDKBaseAction = SDKActionManager.b(this.p);
        if (sDKBaseAction != null && sDKBaseAction instanceof SDKAuthAction)
          ((SDKAuthAction)sDKBaseAction).a((Context)getActivity(), 0, 0, null, str1, bool, str2); 
      } 
      getActivity().finish();
      return true;
    } 
    return super.a((BluedWebView)str1, (BluedUrlParser)str2);
  }
  
  public void k() {
    super.k();
    SDKActionManager.a((Context)getActivity(), this.p);
  }
  
  public void onResume() {
    super.onResume();
    if (!SDKActionManager.a(this.p))
      getActivity().finish(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sd\\ui\SDKWebAuthFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */