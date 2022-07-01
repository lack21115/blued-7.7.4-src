package com.geetest.onelogin.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.onelogin.config.OneLoginThemeConfig;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.j.d;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.listener.c;
import com.geetest.onelogin.view.a;
import com.geetest.onelogin.view.b;

public class OneLoginWebActivity extends Activity {
  private WebView a;
  
  private String b;
  
  private String c;
  
  private RelativeLayout d;
  
  private RelativeLayout e;
  
  private ImageView f;
  
  private TextView g;
  
  private Context h;
  
  private boolean i;
  
  private OneLoginThemeConfig j;
  
  private WebViewClient k;
  
  private void a() throws Exception {
    this.d = (RelativeLayout)findViewById(a.a("gt_one_login_web_bg_layout", this.h));
    this.e = (RelativeLayout)findViewById(a.a("gt_one_login_web_nav_layout", this.h));
    this.g = (TextView)findViewById(a.a("gt_one_login_nav_title", this.h));
    this.f = (ImageView)findViewById(a.a("gt_one_login_nav_iv", this.h));
    this.a = (WebView)findViewById(a.a("gt_one_login_web", this.h));
  }
  
  private void b() {
    try {
      Intent intent = getIntent();
      this.i = intent.getBooleanExtra("web_is_operator_privacy", false);
      this.b = intent.getStringExtra("web_intent");
      this.c = intent.getStringExtra("web_title_name");
      this.j = b.w().A();
      this.k = b.w().h();
      a();
      c();
      d();
      return;
    } catch (Exception exception) {
      h.c(exception.toString());
      finish();
      return;
    } 
  }
  
  private void c() throws Exception {
    if (this.i || !this.j.isNavTextNormal()) {
      this.g.setText(this.c);
    } else {
      this.g.setText(this.j.getNavWebViewText());
    } 
    this.g.setTextColor(this.j.getNavWebViewTextColor());
    this.g.setTextSize(this.j.getNavWebViewTextSize());
    this.g.setTypeface(this.j.getNavWebViewTextTypeface());
    this.e.setBackgroundColor(this.j.getNavColor());
    if (this.j.isAuthNavTransparent())
      this.e.getBackground().setAlpha(0); 
    ViewGroup.LayoutParams layoutParams1 = this.e.getLayoutParams();
    layoutParams1.height = d.a(this.h, this.j.getAuthNavHeight());
    this.e.setLayoutParams(layoutParams1);
    this.f.setBackgroundColor(0);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    layoutParams.width = d.a(this.h, this.j.getReturnImgWidth());
    layoutParams.height = d.a(this.h, this.j.getReturnImgHeight());
    layoutParams.leftMargin = d.a(this.h, this.j.getReturnImgOffsetX());
    if (this.j.isReturnImgCenterInVertical()) {
      layoutParams.gravity = 16;
    } else {
      layoutParams.topMargin = d.a(this.h, this.j.getReturnImgOffsetY());
    } 
    this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    String str = this.j.getNavReturnImgPath();
    if (TextUtils.isEmpty(str)) {
      h.c("NavReturnImgPath is null");
    } else {
      this.f.setImageResource(a.b(str, this.h));
    } 
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            try {
              if (OneLoginWebActivity.a(this.a) != null) {
                if (OneLoginWebActivity.a(this.a).canGoBack()) {
                  OneLoginWebActivity.a(this.a).goBack();
                  return;
                } 
                this.a.finish();
                return;
              } 
              this.a.finish();
              return;
            } catch (Exception exception) {
              h.c(exception.toString());
              this.a.finish();
              return;
            } 
          }
        });
    str = this.j.getAuthBGImgPath();
    if (TextUtils.isEmpty(str)) {
      h.c("AuthBGImgPath is null");
      return;
    } 
    this.d.setBackgroundResource(a.b(str, this.h));
  }
  
  private void d() throws Exception {
    if (this.k == null)
      this.k = new WebViewClient(this) {
          public void onReceivedSslError(WebView param1WebView, SslErrorHandler param1SslErrorHandler, SslError param1SslError) {
            param1SslErrorHandler.proceed();
            super.onReceivedSslError(param1WebView, param1SslErrorHandler, param1SslError);
          }
          
          public boolean shouldOverrideUrlLoading(WebView param1WebView, WebResourceRequest param1WebResourceRequest) {
            return false;
          }
        }; 
    WebSettings webSettings = this.a.getSettings();
    webSettings.setJavaScriptEnabled(true);
    this.a.setWebChromeClient(new WebChromeClient());
    this.a.setWebViewClient(this.k);
    webSettings.setAllowFileAccess(false);
    webSettings.setAllowContentAccess(true);
    webSettings.setDatabaseEnabled(true);
    webSettings.setDomStorageEnabled(true);
    webSettings.setAppCacheEnabled(true);
    webSettings.setUseWideViewPort(true);
    this.a.loadUrl(this.b);
  }
  
  public void finish() {
    super.finish();
    try {
      b.w().O();
      return;
    } catch (Exception exception) {
      h.c(exception.toString());
      return;
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    c.b(this);
    try {
      setContentView(a.a("gt_activity_one_login_web", this));
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("the OneLoginWebActivity is null");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      finish();
    } 
    this.h = getApplicationContext();
    b();
  }
  
  protected void onDestroy() {
    try {
      ViewGroup viewGroup = (ViewGroup)this.a.getParent();
      if (viewGroup != null)
        viewGroup.removeView((View)this.a); 
      this.a.removeAllViews();
      this.a.destroy();
      this.a = null;
    } catch (Exception exception) {
      h.c(exception.toString());
    } 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    // Byte code:
    //   0: iload_1
    //   1: iconst_4
    //   2: if_icmpne -> 31
    //   5: aload_0
    //   6: getfield a : Landroid/webkit/WebView;
    //   9: ifnull -> 31
    //   12: aload_0
    //   13: getfield a : Landroid/webkit/WebView;
    //   16: invokevirtual canGoBack : ()Z
    //   19: ifeq -> 31
    //   22: aload_0
    //   23: getfield a : Landroid/webkit/WebView;
    //   26: invokevirtual goBack : ()V
    //   29: iconst_1
    //   30: ireturn
    //   31: iload_1
    //   32: iconst_4
    //   33: if_icmpne -> 56
    //   36: aload_2
    //   37: invokevirtual getRepeatCount : ()I
    //   40: ifne -> 56
    //   43: aload_0
    //   44: invokevirtual finish : ()V
    //   47: iconst_1
    //   48: ireturn
    //   49: aload_3
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: invokestatic c : (Ljava/lang/String;)V
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: invokespecial onKeyDown : (ILandroid/view/KeyEvent;)Z
    //   62: ireturn
    //   63: astore_3
    //   64: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   5	29	63	java/lang/Exception
    //   36	47	63	java/lang/Exception
  }
  
  protected void onResume() {
    super.onResume();
    b.c(this, this.j);
  }
  
  protected void onStart() {
    super.onStart();
    b.a(this, this.j);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\activity\OneLoginWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */