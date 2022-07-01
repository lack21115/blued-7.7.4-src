package com.qq.e.comm.plugin.ab.f;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.ab.b.b;
import com.qq.e.comm.plugin.ab.d.d;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import org.json.JSONObject;

public class c extends WebView implements a {
  private final e a;
  
  private boolean b;
  
  public c(Context paramContext, WebViewClient paramWebViewClient, b paramb, JSONObject paramJSONObject) {
    super(a(paramContext));
    this.a = new e(this, paramJSONObject);
    WebSettings webSettings = getSettings();
    StringBuilder stringBuilder = new StringBuilder(webSettings.getUserAgentString());
    stringBuilder.append(" GDTMobSDK/");
    stringBuilder.append(SDKStatus.getSDKVersion());
    stringBuilder.append(".");
    stringBuilder.append(GDTADManager.getInstance().getPM().getPluginVersion());
    webSettings.setUserAgentString(stringBuilder.toString());
    webSettings.setJavaScriptEnabled(true);
    if (paramWebViewClient != null) {
      if (paramWebViewClient instanceof d)
        ((d)paramWebViewClient).a(this.a); 
      setWebViewClient(paramWebViewClient);
    } 
    if (paramb != null) {
      paramb.a(this.a);
      setWebChromeClient(paramb);
    } else {
      b b1 = new b();
      b1.a(this.a);
      setWebChromeClient(b1);
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    } 
    if (Build.VERSION.SDK_INT >= 21)
      getSettings().setMixedContentMode(0); 
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
    setDownloadListener(new DownloadListener(this, paramContext) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(param1String1));
            if (intent.resolveActivity(GDTADManager.getInstance().getAppContext().getPackageManager()) != null) {
              if (!(this.a instanceof android.app.Activity))
                intent.addFlags(268435456); 
              this.a.startActivity(intent);
            } 
          }
        });
    resumeTimers();
  }
  
  private static Context a(Context paramContext) {
    if (Build.VERSION.SDK_INT != 21) {
      Context context = paramContext;
      return (Build.VERSION.SDK_INT == 22) ? paramContext.createConfigurationContext(new Configuration()) : context;
    } 
    return paramContext.createConfigurationContext(new Configuration());
  }
  
  public void b(String paramString) {
    if (Build.VERSION.SDK_INT >= 19) {
      evaluateJavascript(paramString, null);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("javascript:");
    stringBuilder.append(paramString);
    loadUrl(stringBuilder.toString());
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
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */