package com.tencent.connect.auth;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.open.a;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.c.c;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.Util;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.open.web.security.b;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthDialog extends Dialog {
  private String a;
  
  private OnTimeListener b;
  
  private IUiListener c;
  
  private Handler d;
  
  private FrameLayout e;
  
  private LinearLayout f;
  
  private FrameLayout g;
  
  private ProgressBar h;
  
  private String i;
  
  private c j;
  
  private Context k;
  
  private b l;
  
  private boolean m = false;
  
  private int n;
  
  private String o;
  
  private String p;
  
  private long q = 0L;
  
  private long r = 30000L;
  
  private HashMap<String, Runnable> s;
  
  static {
    try {
      Context context = Global.getContext();
      if (context != null) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(context.getFilesDir().toString());
        stringBuilder2.append("/");
        stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
        if ((new File(stringBuilder2.toString())).exists()) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(context.getFilesDir().toString());
          stringBuilder2.append("/");
          stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
          System.load(stringBuilder2.toString());
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("-->load lib success:");
          stringBuilder3.append(AuthAgent.SECURE_LIB_NAME);
          f.c("openSDK_LOG.AuthDialog", stringBuilder3.toString());
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("-->fail, because so is not exists:");
        stringBuilder1.append(AuthAgent.SECURE_LIB_NAME);
        f.c("openSDK_LOG.AuthDialog", stringBuilder1.toString());
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-->load lib fail, because context is null:");
      stringBuilder.append(AuthAgent.SECURE_LIB_NAME);
      f.c("openSDK_LOG.AuthDialog", stringBuilder.toString());
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-->load lib error:");
      stringBuilder.append(AuthAgent.SECURE_LIB_NAME);
      f.b("openSDK_LOG.AuthDialog", stringBuilder.toString(), exception);
      return;
    } 
  }
  
  public AuthDialog(Context paramContext, String paramString1, String paramString2, IUiListener paramIUiListener, QQToken paramQQToken) {
    super(paramContext, 16973840);
    this.k = paramContext;
    this.a = paramString2;
    this.b = new OnTimeListener(this, paramString1, paramString2, paramQQToken.getAppId(), paramIUiListener);
    this.d = new THandler(this, this.b, paramContext.getMainLooper());
    this.c = paramIUiListener;
    this.i = paramString1;
    this.l = new b();
    getWindow().setSoftInputMode(32);
  }
  
  private String a() {
    String str = this.a;
    str = str.substring(str.indexOf("?") + 1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://qzs.qq.com/open/mobile/login/qzsjump.html?");
    stringBuilder.append(str);
    str = stringBuilder.toString();
    f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
    return str;
  }
  
  private String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
      String str = this.p;
      str = str.substring(str.length() - 4);
      stringBuilder.append("_u_");
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  private void b() {
    c();
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.j = new c(this.k);
    this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.e = new FrameLayout(this.k);
    layoutParams.gravity = 17;
    this.e.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.e.addView((View)this.j);
    this.e.addView((View)this.g);
    setContentView((View)this.e);
  }
  
  private static void b(Context paramContext, String paramString) {
    try {
      JSONObject jSONObject = Util.parseJson(paramString);
      int i = jSONObject.getInt("type");
      String str = jSONObject.getString("msg");
      Toast.makeText(paramContext.getApplicationContext(), str, i).show();
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  private void c() {
    this.h = new ProgressBar(this.k);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f = new LinearLayout(this.k);
    if (this.i.equals("action_login")) {
      LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams3.gravity = 16;
      layoutParams3.leftMargin = 5;
      TextView textView = new TextView(this.k);
      if (Locale.getDefault().getLanguage().equals("zh")) {
        textView.setText("登录中...");
      } else {
        textView.setText("Logging in...");
      } 
      textView.setTextColor(Color.rgb(255, 255, 255));
      textView.setTextSize(18.0F);
      textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    } else {
      layoutParams = null;
    } 
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams2.gravity = 17;
    this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.f.addView((View)this.h);
    if (layoutParams != null)
      this.f.addView((View)layoutParams); 
    this.g = new FrameLayout(this.k);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -2);
    layoutParams1.leftMargin = 80;
    layoutParams1.rightMargin = 80;
    layoutParams1.topMargin = 40;
    layoutParams1.bottomMargin = 40;
    layoutParams1.gravity = 17;
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.g.setBackgroundResource(17301504);
    this.g.addView((View)this.f);
  }
  
  private void d() {
    this.j.setVerticalScrollBarEnabled(false);
    this.j.setHorizontalScrollBarEnabled(false);
    this.j.setWebViewClient(new LoginWebViewClient());
    this.j.setWebChromeClient(new WebChromeClient());
    this.j.clearFormData();
    this.j.clearSslPreferences();
    this.j.setOnLongClickListener(new View.OnLongClickListener(this) {
          public boolean onLongClick(View param1View) {
            return true;
          }
        });
    this.j.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if ((i == 0 || i == 1) && !param1View.hasFocus())
              param1View.requestFocus(); 
            return false;
          }
        });
    WebSettings webSettings = this.j.getSettings();
    webSettings.setSavePassword(false);
    webSettings.setSaveFormData(false);
    webSettings.setCacheMode(-1);
    webSettings.setNeedInitialFocus(false);
    webSettings.setBuiltInZoomControls(true);
    webSettings.setSupportZoom(true);
    webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDatabaseEnabled(true);
    webSettings.setDatabasePath(this.k.getDir("databases", 0).getPath());
    webSettings.setDomStorageEnabled(true);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("-->mUrl : ");
    stringBuilder.append(this.a);
    f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
    String str = this.a;
    this.o = str;
    this.j.loadUrl(str);
    this.j.setVisibility(4);
    this.j.getSettings().setSavePassword(false);
    this.l.a((a.b)new SecureJsInterface(), "SecureJsInterface");
    SecureJsInterface.isPWDEdit = false;
    setOnDismissListener(new DialogInterface.OnDismissListener(this) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            try {
              JniInterface.clearAllPWD();
              return;
            } catch (Exception exception) {
              return;
            } 
          }
        });
  }
  
  private boolean e() {
    AuthMap authMap = AuthMap.getInstance();
    String str1 = authMap.makeKey();
    AuthMap.Auth auth = new AuthMap.Auth();
    auth.listener = this.c;
    auth.dialog = this;
    auth.key = str1;
    String str2 = authMap.set(auth);
    String str3 = this.a;
    str3 = str3.substring(0, str3.indexOf("?"));
    Bundle bundle = Util.parseUrl(this.a);
    bundle.putString("token_key", str1);
    bundle.putString("serial", str2);
    bundle.putString("browser", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str3);
    stringBuilder.append("?");
    stringBuilder.append(Util.encodeUrl(bundle));
    this.a = stringBuilder.toString();
    return Util.openBrowser(this.k, this.a);
  }
  
  public void callJs(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("javascript:");
    stringBuilder.append(paramString1);
    stringBuilder.append("(");
    stringBuilder.append(paramString2);
    stringBuilder.append(");void(");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(");");
    paramString1 = stringBuilder.toString();
    this.j.loadUrl(paramString1);
  }
  
  public void dismiss() {
    this.s.clear();
    this.d.removeCallbacksAndMessages(null);
    if (isShowing())
      super.dismiss(); 
    c c1 = this.j;
    if (c1 != null) {
      c1.destroy();
      this.j = null;
    } 
  }
  
  public void onBackPressed() {
    if (!this.m)
      this.b.onCancel(); 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    b();
    d();
    this.s = new HashMap<String, Runnable>();
  }
  
  protected void onStop() {
    super.onStop();
  }
  
  class LoginWebViewClient extends WebViewClient {
    private LoginWebViewClient(AuthDialog this$0) {}
    
    public void onPageFinished(WebView param1WebView, String param1String) {
      super.onPageFinished(param1WebView, param1String);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-->onPageFinished, url: ");
      stringBuilder.append(param1String);
      f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
      AuthDialog.g(this.a).setVisibility(8);
      if (AuthDialog.e(this.a) != null)
        AuthDialog.e(this.a).setVisibility(0); 
      if (!TextUtils.isEmpty(param1String))
        AuthDialog.n(this.a).removeCallbacks((Runnable)AuthDialog.p(this.a).remove(param1String)); 
    }
    
    public void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-->onPageStarted, url: ");
      stringBuilder.append(param1String);
      f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
      super.onPageStarted(param1WebView, param1String, param1Bitmap);
      AuthDialog.g(this.a).setVisibility(0);
      AuthDialog.a(this.a, SystemClock.elapsedRealtime());
      if (!TextUtils.isEmpty(AuthDialog.i(this.a)))
        AuthDialog.n(this.a).removeCallbacks((Runnable)AuthDialog.p(this.a).remove(AuthDialog.i(this.a))); 
      AuthDialog.c(this.a, param1String);
      AuthDialog authDialog = this.a;
      AuthDialog.TimeOutRunable timeOutRunable = new AuthDialog.TimeOutRunable(authDialog, AuthDialog.i(authDialog));
      AuthDialog.p(this.a).put(param1String, timeOutRunable);
      AuthDialog.n(this.a).postDelayed(timeOutRunable, 120000L);
    }
    
    public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
      super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-->onReceivedError, errorCode: ");
      stringBuilder.append(param1Int);
      stringBuilder.append(" | description: ");
      stringBuilder.append(param1String1);
      f.c("openSDK_LOG.AuthDialog", stringBuilder.toString());
      if (!Util.checkNetWork(AuthDialog.a(this.a))) {
        AuthDialog.f(this.a).onError(new UiError(9001, "当前网络不可用，请稍后重试！", param1String2));
        this.a.dismiss();
        return;
      } 
      if (!AuthDialog.i(this.a).startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = AuthDialog.j(this.a);
        if (AuthDialog.k(this.a) < 1 && l1 - l2 < AuthDialog.l(this.a)) {
          AuthDialog.m(this.a);
          AuthDialog.n(this.a).postDelayed(new Runnable(this) {
                public void run() {
                  AuthDialog.e(this.a.a).loadUrl(AuthDialog.i(this.a.a));
                }
              },  500L);
          return;
        } 
        AuthDialog.e(this.a).loadUrl(AuthDialog.o(this.a));
        return;
      } 
      AuthDialog.f(this.a).onError(new UiError(param1Int, param1String1, param1String2));
      this.a.dismiss();
    }
    
    public void onReceivedSslError(WebView param1WebView, SslErrorHandler param1SslErrorHandler, SslError param1SslError) {
      param1SslErrorHandler.cancel();
      AuthDialog.f(this.a).onError(new UiError(param1SslError.getPrimaryError(), "请求不合法，请检查手机安全设置，如系统时间、代理等。", "ssl error"));
      this.a.dismiss();
    }
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      AuthDialog authDialog;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-->Redirect URL: ");
      stringBuilder.append(param1String);
      f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
      if (param1String.startsWith("auth://browser")) {
        JSONObject jSONObject = Util.parseUrlToJson(param1String);
        authDialog = this.a;
        AuthDialog.a(authDialog, AuthDialog.b(authDialog));
        if (AuthDialog.c(this.a))
          return true; 
        if (jSONObject.optString("fail_cb", null) != null) {
          this.a.callJs(jSONObject.optString("fail_cb"), "");
          return true;
        } 
        if (jSONObject.optInt("fall_to_wv") == 1) {
          authDialog = this.a;
          String str1 = AuthDialog.d(authDialog);
          str = "?";
          if (str1.indexOf("?") > -1)
            str = "&"; 
          AuthDialog.a(authDialog, str);
          AuthDialog.a(this.a, "browser_error=1");
          AuthDialog.e(this.a).loadUrl(AuthDialog.d(this.a));
          return true;
        } 
        String str = str.optString("redir", null);
        if (str != null)
          AuthDialog.e(this.a).loadUrl(str); 
        return true;
      } 
      if (authDialog.startsWith("auth://tauth.qq.com/")) {
        AuthDialog.f(this.a).onComplete(Util.parseUrlToJson((String)authDialog));
        this.a.dismiss();
        return true;
      } 
      if (authDialog.startsWith("auth://cancel")) {
        AuthDialog.f(this.a).onCancel();
        this.a.dismiss();
        return true;
      } 
      if (authDialog.startsWith("auth://close")) {
        this.a.dismiss();
        return true;
      } 
      if (authDialog.startsWith("download://"))
        try {
          Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(authDialog.substring(11))));
          intent.addFlags(268435456);
          AuthDialog.a(this.a).startActivity(intent);
          return true;
        } catch (Exception exception) {
          f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", exception);
          return true;
        }  
      if (authDialog.startsWith("auth://progress"))
        try {
          List<String> list = Uri.parse((String)authDialog).getPathSegments();
          if (list.isEmpty())
            return true; 
          int i = Integer.valueOf(list.get(0)).intValue();
          if (i == 0) {
            AuthDialog.g(this.a).setVisibility(8);
            AuthDialog.e(this.a).setVisibility(0);
            return true;
          } 
          if (i == 1)
            AuthDialog.g(this.a).setVisibility(0); 
          return true;
        } catch (Exception exception) {
          return true;
        }  
      if (authDialog.startsWith("auth://onLoginSubmit"))
        try {
          List<String> list = Uri.parse((String)authDialog).getPathSegments();
          if (!list.isEmpty())
            AuthDialog.b(this.a, list.get(0)); 
          return true;
        } catch (Exception exception) {
          return true;
        }  
      if (AuthDialog.h(this.a).a((WebView)AuthDialog.e(this.a), (String)authDialog))
        return true; 
      f.c("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
      return false;
    }
  }
  
  class null implements Runnable {
    null(AuthDialog this$0) {}
    
    public void run() {
      AuthDialog.e(this.a.a).loadUrl(AuthDialog.i(this.a.a));
    }
  }
  
  class OnTimeListener implements IUiListener {
    String a;
    
    String b;
    
    private String d;
    
    private IUiListener e;
    
    public OnTimeListener(AuthDialog this$0, String param1String1, String param1String2, String param1String3, IUiListener param1IUiListener) {
      this.d = param1String1;
      this.a = param1String2;
      this.b = param1String3;
      this.e = param1IUiListener;
    }
    
    private void a(String param1String) {
      try {
        onComplete(Util.parseJson(param1String));
        return;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        onError(new UiError(-4, "服务器返回数据格式有误!", param1String));
        return;
      } 
    }
    
    public void onCancel() {
      IUiListener iUiListener = this.e;
      if (iUiListener != null) {
        iUiListener.onCancel();
        this.e = null;
      } 
    }
    
    public void onComplete(Object param1Object) {
      param1Object = param1Object;
      g g = g.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.d);
      stringBuilder.append("_H5");
      g.a(stringBuilder.toString(), SystemClock.elapsedRealtime(), 0L, 0L, param1Object.optInt("ret", -6), this.a, false);
      IUiListener iUiListener = this.e;
      if (iUiListener != null) {
        iUiListener.onComplete(param1Object);
        this.e = null;
      } 
    }
    
    public void onError(UiError param1UiError) {
      String str;
      if (param1UiError.errorMessage != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(param1UiError.errorMessage);
        stringBuilder1.append(this.a);
        str = stringBuilder1.toString();
      } else {
        str = this.a;
      } 
      g g = g.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.d);
      stringBuilder.append("_H5");
      g.a(stringBuilder.toString(), SystemClock.elapsedRealtime(), 0L, 0L, param1UiError.errorCode, str, false);
      AuthDialog.a(this.c, str);
      IUiListener iUiListener = this.e;
      if (iUiListener != null) {
        iUiListener.onError(param1UiError);
        this.e = null;
      } 
    }
  }
  
  class THandler extends Handler {
    private AuthDialog.OnTimeListener b;
    
    public THandler(AuthDialog this$0, AuthDialog.OnTimeListener param1OnTimeListener, Looper param1Looper) {
      super(param1Looper);
      this.b = param1OnTimeListener;
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          AuthDialog.a(AuthDialog.a(this.a), (String)param1Message.obj);
          return;
        } 
        this.b.onCancel();
        return;
      } 
      AuthDialog.OnTimeListener.a(this.b, (String)param1Message.obj);
    }
  }
  
  class TimeOutRunable implements Runnable {
    String a = "";
    
    public TimeOutRunable(AuthDialog this$0, String param1String) {
      this.a = param1String;
    }
    
    public void run() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-->timeoutUrl: ");
      stringBuilder.append(this.a);
      stringBuilder.append(" | mRetryUrl: ");
      stringBuilder.append(AuthDialog.i(this.b));
      f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
      if (this.a.equals(AuthDialog.i(this.b))) {
        AuthDialog.f(this.b).onError(new UiError(9002, "请求页面超时，请稍后重试！", AuthDialog.i(this.b)));
        this.b.dismiss();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\auth\AuthDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */