package com.qq.e.comm.plugin.ab.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.ab.b.b;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import org.json.JSONObject;

public class i extends WebView implements a {
  private final e a;
  
  private boolean b;
  
  public i(Context paramContext, WebViewClient paramWebViewClient, h paramh, JSONObject paramJSONObject) {
    super(paramContext);
    this.a = new e(this, paramJSONObject);
    try {
      WebSettings webSettings = getSettings();
      StringBuilder stringBuilder = new StringBuilder(webSettings.getUserAgentString());
      stringBuilder.append(" GDTMobSDK/");
      stringBuilder.append(SDKStatus.getSDKVersion());
      stringBuilder.append(".");
      stringBuilder.append(GDTADManager.getInstance().getPM().getPluginVersion());
      webSettings.setUserAgentString(stringBuilder.toString());
      webSettings.setJavaScriptEnabled(true);
      if (paramWebViewClient != null) {
        if (paramWebViewClient instanceof com.qq.e.comm.plugin.ab.d.i)
          ((com.qq.e.comm.plugin.ab.d.i)paramWebViewClient).a(this.a); 
        setWebViewClient(paramWebViewClient);
      } 
      if (paramh != null) {
        paramh.a(this.a);
        setWebChromeClient(paramh);
      } else {
        h h1 = new h();
        h1.a(this.a);
        setWebChromeClient(h1);
      } 
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
      webSettings.setMixedContentMode(0);
      setInitialScale(100);
      webSettings.setLoadWithOverviewMode(true);
      webSettings.setUseWideViewPort(true);
      String str2 = aj.a(getContext()).getAbsolutePath();
      webSettings.setAllowFileAccess(true);
      webSettings.setAppCachePath(str2);
      webSettings.setAppCacheMaxSize(8388608L);
      webSettings.setAppCacheEnabled(true);
      webSettings.setLoadsImagesAutomatically(true);
      webSettings.setCacheMode(-1);
      webSettings.setDomStorageEnabled(true);
      webSettings.setSupportMultipleWindows(false);
      webSettings.setSaveFormData(false);
      File file = aj.b(getContext());
      if (!file.exists())
        file.mkdirs(); 
      String str1 = file.getAbsolutePath();
      webSettings.setDatabaseEnabled(true);
      webSettings.setDatabasePath(str1);
      webSettings.setGeolocationEnabled(true);
      webSettings.setGeolocationDatabasePath(str1);
    } finally {
      paramContext = null;
    } 
    resumeTimers();
  }
  
  public void b(String paramString) {
    evaluateJavascript(paramString, null);
  }
  
  public View c() {
    return (View)this;
  }
  
  public e d() {
    return this.a;
  }
  
  public void destroy() {
    if (this.b)
      return; 
    loadUrl("about:blank");
    ViewParent viewParent = getParent();
    if (viewParent != null && viewParent instanceof ViewGroup)
      ((ViewGroup)viewParent).removeView((View)this); 
    removeAllViews();
    super.destroy();
    this.b = true;
  }
  
  public void onVisibilityChanged(View paramView, int paramInt) {
    b b;
    String str;
    e e1;
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      e1 = this.a;
      str = "onPageShown";
      b = new b("onPageShown", null);
    } else {
      e1 = this.a;
      str = "onPageHidden";
      b = new b("onPageHidden", null);
    } 
    e1.a(b);
    GDTLogger.d(str);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */