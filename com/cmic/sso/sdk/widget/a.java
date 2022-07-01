package com.cmic.sso.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.cmic.sso.sdk.AuthThemeConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.utils.w;

public class a extends Dialog {
  private WebView a;
  
  private String b;
  
  private String c;
  
  public a(Context paramContext, int paramInt, String paramString1, String paramString2) {
    super(paramContext, paramInt);
    this.c = paramString1;
    this.b = paramString2;
    a();
  }
  
  private ViewGroup b() {
    String str;
    LinearLayout linearLayout = new LinearLayout(getContext());
    linearLayout.setOrientation(1);
    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    int i = AuthnHelper.getInstance(null).getAuthThemeConfig().getClauseLayoutResID();
    if (TextUtils.isEmpty(this.c)) {
      str = "服务条款";
    } else {
      str = this.c;
    } 
    if (i != -1) {
      View view = getLayoutInflater().inflate(i, (ViewGroup)linearLayout, false);
      linearLayout.addView((View)w.a(getContext(), view, 1118481, 0, str, null));
    } else {
      linearLayout.addView((View)w.a(getContext(), null, 1118481, 2236962, str, new View.OnClickListener(this) {
              public void onClick(View param1View) {
                a.a(this.a).stopLoading();
                this.a.cancel();
              }
            }));
    } 
    this.a = new WebView(getContext());
    this.a.getSettings().setJavaScriptEnabled(true);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    linearLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams);
    return (ViewGroup)linearLayout;
  }
  
  protected void a() {
    requestWindowFeature(1);
    getWindow().setFeatureDrawableAlpha(0, 0);
    AuthThemeConfig authThemeConfig = AuthnHelper.getInstance(null).getAuthThemeConfig();
    if (Build.VERSION.SDK_INT >= 21 && authThemeConfig.getStatusBarColor() != 0) {
      getWindow().addFlags(-2147483648);
      getWindow().clearFlags(67108864);
      getWindow().setStatusBarColor(authThemeConfig.getStatusBarColor());
      getWindow().setNavigationBarColor(authThemeConfig.getStatusBarColor());
    } 
    if (Build.VERSION.SDK_INT >= 23)
      if (authThemeConfig.isLightColor()) {
        getWindow().getDecorView().setSystemUiVisibility(8192);
      } else {
        getWindow().getDecorView().setSystemUiVisibility(0);
      }  
    setContentView((View)b());
    if (Build.VERSION.SDK_INT < 17) {
      this.a.removeJavascriptInterface("searchBoxJavaBridge_");
      this.a.removeJavascriptInterface("accessibility");
      this.a.removeJavascriptInterface("accessibilityTraversal");
    } 
    this.a.setWebViewClient(new WebViewClient(this) {
          public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
            a.a(this.a).loadUrl(param1String);
            return true;
          }
        });
    this.a.loadUrl(this.b);
  }
  
  public void dismiss() {
    super.dismiss();
    this.a.stopLoading();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */