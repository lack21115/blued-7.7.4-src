package com.blued.android.framework.web;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.collection.ArrayMap;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.R;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.Tools;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.CommonProtos;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class BluedWebView<T extends BluedWebView.WebCallback> implements View.OnCreateContextMenuListener {
  private static final boolean a = HappyDnsUtils.b();
  
  private static String[] y = BluedURIRouter.a().e();
  
  private static Map<String, String> z = new ConcurrentHashMap<String, String>();
  
  private boolean b = false;
  
  private final String c = "blued_httpdns=1";
  
  private RectPosition d;
  
  private DisplayMetrics e;
  
  private int f = 0;
  
  private int g;
  
  private Fragment h;
  
  private WebView i;
  
  private ViewGroup j;
  
  private T k;
  
  private WebUploadFile l;
  
  private JSExecutor m = null;
  
  private DownloaderJSCallback n = null;
  
  private String o;
  
  private View p;
  
  private WebChromeClient.CustomViewCallback q;
  
  private String r = "";
  
  private String s = "";
  
  private String t = "";
  
  private boolean u = false;
  
  private String v;
  
  private int w = -1;
  
  private Map<String, Long> x = new ConcurrentHashMap<String, Long>();
  
  public BluedWebView(Fragment paramFragment, WebView paramWebView, ViewGroup paramViewGroup, T paramT) {
    this.h = paramFragment;
    this.i = paramWebView;
    this.j = paramViewGroup;
    this.k = paramT;
    o();
  }
  
  private Locale a(Configuration paramConfiguration) {
    return (Build.VERSION.SDK_INT >= 24) ? paramConfiguration.getLocales().get(0) : paramConfiguration.locale;
  }
  
  public static boolean a(Context paramContext, String paramString, WebCallback paramWebCallback) {
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("preOverrideUrlLoad(), url:");
      stringBuilder.append(paramString);
      Log.v("webTest", stringBuilder.toString());
    } 
    if (TextUtils.isEmpty(paramString))
      return true; 
    if (CommonUrlHandler.a(paramContext, paramString))
      return true; 
    Uri uri = BluedURIRouter.a().d(paramString);
    if ((paramWebCallback != null && paramWebCallback.a(paramContext, paramString)) || BluedURIRouter.a().a(paramContext, uri))
      return true; 
    if (!paramString.startsWith("http://") && !paramString.startsWith("https://") && !paramString.startsWith("blued://") && !paramString.startsWith("iblued://") && !paramString.startsWith("www.")) {
      Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      try {
        if (AppMethods.a(intent)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("system handle it: ");
          stringBuilder.append(paramString);
          Log.v("webTest", stringBuilder.toString());
          paramContext.startActivity(intent);
          return true;
        } 
      } catch (SecurityException securityException) {
        securityException.printStackTrace();
      } 
      return true;
    } 
    return false;
  }
  
  public static void b(Context paramContext) {
    CookieManager cookieManager;
    if (AppMethods.c(21)) {
      cookieManager = p();
      if (cookieManager != null) {
        cookieManager.flush();
        return;
      } 
    } else {
      CookieSyncManager.createInstance((Context)cookieManager);
      p();
      CookieSyncManager.getInstance().sync();
    } 
  }
  
  public static void c(Context paramContext) {
    CookieManager cookieManager = p();
    if (cookieManager == null)
      return; 
    if (Build.VERSION.SDK_INT >= 21) {
      cookieManager.removeSessionCookies(null);
      cookieManager.removeAllCookies(null);
      cookieManager.flush();
      return;
    } 
    CookieSyncManager.createInstance(paramContext);
    cookieManager.removeSessionCookie();
    cookieManager.removeAllCookie();
    CookieSyncManager.getInstance().sync();
    CookieSyncManager.getInstance().startSync();
  }
  
  private void c(String paramString) {
    if (!this.b) {
      boolean bool;
      if (!TextUtils.isEmpty(paramString) && paramString.contains("blued_httpdns=1")) {
        bool = true;
      } else {
        bool = false;
      } 
      this.b = bool;
    } 
  }
  
  private boolean d(String paramString) {
    boolean bool2 = a((Context)this.h.getActivity(), paramString, (WebCallback)this.k);
    boolean bool1 = bool2;
    if (!bool2)
      bool1 = e(paramString); 
    return bool1;
  }
  
  private boolean e(String paramString) {
    StringBuilder stringBuilder;
    T t2;
    BluedUrlParser bluedUrlParser = BluedUrlParser.a(paramString);
    int i = 0;
    if (bluedUrlParser == null)
      return false; 
    if (!Tools.a(this.h))
      return false; 
    boolean bool = "changetitle".equals(bluedUrlParser.a());
    String str2 = null;
    String str1 = null;
    paramString = null;
    if (bool) {
      if (bluedUrlParser.b() != null)
        paramString = (String)bluedUrlParser.b().get("title"); 
      if (!TextUtils.isEmpty(paramString)) {
        this.t = paramString;
        T t = this.k;
        if (t != null)
          t.a(this, paramString); 
      } 
      return true;
    } 
    if ("download".equals(bluedUrlParser.a())) {
      if (bluedUrlParser.b() != null) {
        str2 = (String)bluedUrlParser.b().get("opt");
        str1 = (String)bluedUrlParser.b().get("code");
        paramString = (String)bluedUrlParser.b().get("url");
      } else {
        paramString = null;
        str1 = paramString;
      } 
      if (!TextUtils.isEmpty(paramString))
        WebDownloaderManager.a().a(this.m.b(), paramString, str2, str1); 
      return true;
    } 
    if ("jscb".equals(bluedUrlParser.a())) {
      if (bluedUrlParser.b() != null) {
        str1 = (String)bluedUrlParser.b().get("opt");
        paramString = (String)bluedUrlParser.b().get("fun");
      } else {
        paramString = null;
      } 
      if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(paramString)) {
        if ("register_download".equals(str1)) {
          if (this.n == null) {
            this.n = new DownloaderJSCallback(this.m);
            WebDownloaderManager.a().a(this.n);
          } 
          this.n.a(this.m.b(), paramString);
          return true;
        } 
        if ("get_uid".equals(str1)) {
          str1 = ProviderHolder.a().b().a();
          JSExecutor jSExecutor = this.m;
          String str = jSExecutor.b();
          stringBuilder = new StringBuilder();
          stringBuilder.append("javascript:");
          stringBuilder.append(paramString);
          stringBuilder.append("('");
          stringBuilder.append(str1);
          stringBuilder.append("')");
          jSExecutor.a(str, stringBuilder.toString());
        } 
      } 
      return true;
    } 
    if ("close".equals(stringBuilder.a())) {
      T t = this.k;
      if (t != null)
        t.a(stringBuilder.b(), this); 
      Fragment fragment = this.h;
      if (fragment instanceof DialogFragment) {
        ((DialogFragment)fragment).dismiss();
        return true;
      } 
      fragment.getActivity().finish();
      return true;
    } 
    if ("webshare".equals(stringBuilder.a())) {
      str2 = this.r;
      Map<String, String> map = stringBuilder.b();
      String str = "";
      if (map != null) {
        paramString = (String)stringBuilder.b().get("type");
        if (!StringUtils.a(paramString))
          i = Integer.valueOf(paramString).intValue(); 
        if (map.containsKey("title")) {
          paramString = (String)map.get("title");
        } else {
          paramString = "";
        } 
        if (map.containsKey("content")) {
          str1 = (String)map.get("content");
        } else {
          str1 = "";
        } 
        if (map.containsKey("to"))
          str = (String)map.get("to"); 
        if (map.containsKey("url"))
          str2 = (String)map.get("url"); 
        String str3 = paramString;
        paramString = str;
        str = str3;
      } else {
        paramString = "";
        String str3 = paramString;
        i = 0;
        str1 = str;
        str = str3;
      } 
      t2 = this.k;
      if (t2 != null)
        t2.a(paramString, str2, str, str1, i, map, this); 
      return true;
    } 
    T t1 = this.k;
    return (t1 != null && t1.a(this, (BluedUrlParser)t2));
  }
  
  private String f(String paramString) {
    return (paramString == null) ? null : paramString.split(";")[0];
  }
  
  private String g(String paramString) {
    if (paramString == null)
      return null; 
    String[] arrayOfString = paramString.split(";");
    if (arrayOfString.length <= 1)
      return null; 
    String str = arrayOfString[1];
    return !str.contains("=") ? null : str.substring(str.indexOf("=") + 1);
  }
  
  private void m() {
    this.i.getSettings().setUseWideViewPort(true);
    this.i.getSettings().setJavaScriptEnabled(true);
    this.i.getSettings().setGeolocationEnabled(true);
    this.i.getSettings().setGeolocationDatabasePath(this.h.getActivity().getFilesDir().getPath());
    this.i.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.i.getSettings().setLoadWithOverviewMode(true);
    this.i.getSettings().setBuiltInZoomControls(true);
    this.i.getSettings().setSupportZoom(true);
    if (AppMethods.c(21))
      n(); 
    this.i.getSettings().setDomStorageEnabled(true);
    this.i.getSettings().setAppCacheEnabled(true);
    this.i.setScrollBarStyle(33554432);
    this.i.getSettings().setSavePassword(false);
    this.i.addJavascriptInterface(new InJavaScriptBluedNativeObject(), "bluedNative");
    this.i.addJavascriptInterface(new InJavaScriptLocalObj(this), "android");
    this.i.addJavascriptInterface(new InJavaScriptBluedNativeObject(), "bluedNative");
  }
  
  private void n() {
    try {
      this.i.getSettings().setMixedContentMode(2);
      return;
    } catch (NoSuchMethodError noSuchMethodError) {
      noSuchMethodError.printStackTrace();
      return;
    } 
  }
  
  private void o() {
    T t = this.k;
    if (t != null)
      t.b(); 
    q();
    this.g = StatusBarHelper.a(this.i.getContext());
    this.m = new JSExecutor();
    this.m.a(this.i);
    m();
    a((Context)this.h.getActivity());
    String str = AppMethods.b(this.i.getSettings().getUserAgentString(), "ibb/1.0.0");
    this.i.getSettings().setUserAgentString(str);
    this.i.setOnCreateContextMenuListener(this);
    this.i.setWebChromeClient(new BluedWebChromeClient(this) {
          public void onGeolocationPermissionsShowPrompt(String param1String, GeolocationPermissions.Callback param1Callback) {
            param1Callback.invoke(param1String, true, false);
          }
          
          public void onHideCustomView() {
            if (BluedWebView.d(this.a) == null)
              return; 
            if (BluedWebView.c(this.a) != null && BluedWebView.c(this.a).getActivity() != null)
              BluedWebView.c(this.a).getActivity().setRequestedOrientation(1); 
            if (BluedWebView.e(this.a) != null) {
              BluedWebView.e(this.a).removeView(BluedWebView.d(this.a));
              if (BluedWebView.f(this.a) != null)
                BluedWebView.f(this.a).onCustomViewHidden(); 
              BluedWebView.a(this.a, (View)null);
              BluedWebView.a(this.a, (WebChromeClient.CustomViewCallback)null);
            } 
          }
          
          public void onProgressChanged(WebView param1WebView, int param1Int) {
            super.onProgressChanged(param1WebView, param1Int);
            if (BluedWebView.a(this.a) != null)
              BluedWebView.a(this.a).a(this.a, param1Int); 
          }
          
          public void onReceivedTitle(WebView param1WebView, String param1String) {
            super.onReceivedTitle(param1WebView, param1String);
            BluedWebView.a(this.a, param1String);
            if (BluedWebView.a(this.a) != null)
              BluedWebView.a(this.a).a(this.a, param1String); 
          }
          
          public void onShowCustomView(View param1View, WebChromeClient.CustomViewCallback param1CustomViewCallback) {
            if (BluedWebView.d(this.a) != null) {
              param1CustomViewCallback.onCustomViewHidden();
              return;
            } 
            if (BluedWebView.c(this.a) != null && BluedWebView.c(this.a).getActivity() != null) {
              BluedWebView.c(this.a).getActivity().setRequestedOrientation(0);
              if (BluedWebView.e(this.a) != null) {
                BluedWebView.e(this.a).addView(param1View);
                BluedWebView.a(this.a, param1View);
                BluedWebView.a(this.a, param1CustomViewCallback);
              } 
            } 
          }
          
          public boolean onShowFileChooser(WebView param1WebView, ValueCallback<Uri[]> param1ValueCallback, WebChromeClient.FileChooserParams param1FileChooserParams) {
            if (BluedWebView.b(this.a) == null) {
              BluedWebView bluedWebView = this.a;
              BluedWebView.a(bluedWebView, new WebUploadFile(BluedWebView.c(bluedWebView)));
            } 
            BluedWebView.b(this.a).a(param1WebView, param1ValueCallback, param1FileChooserParams);
            return true;
          }
        });
    this.e = this.i.getContext().getResources().getDisplayMetrics();
    this.i.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            float f = param1MotionEvent.getRawY();
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i != 1)
                return false; 
            } else {
              this.a.j();
              if (BluedWebView.g(this.a) != null) {
                i = BluedWebView.RectPosition.a(BluedWebView.g(this.a));
                int m = BluedWebView.RectPosition.b(BluedWebView.g(this.a));
                i = (int)(i * (BluedWebView.h(this.a)).density);
                int j = BluedWebView.i(this.a);
                int k = BluedWebView.j(this.a);
                m = (int)(m * (BluedWebView.h(this.a)).density);
                int n = BluedWebView.i(this.a);
                int i1 = BluedWebView.j(this.a);
                if (f > (i + j + k) && f < (m + n + i1)) {
                  BluedWebView.k(this.a).requestDisallowInterceptTouchEvent(true);
                  return false;
                } 
                BluedWebView.k(this.a).requestDisallowInterceptTouchEvent(false);
              } 
            } 
            return false;
          }
        });
    this.i.setWebViewClient(new WebViewClient(this) {
          private boolean b = false;
          
          private URLConnection a(String param1String1, String param1String2, WebResourceRequest param1WebResourceRequest, boolean param1Boolean) {
            // Byte code:
            //   0: aconst_null
            //   1: astore #9
            //   3: aload #9
            //   5: astore #8
            //   7: new java/net/URL
            //   10: dup
            //   11: aload_1
            //   12: invokespecial <init> : (Ljava/lang/String;)V
            //   15: astore #12
            //   17: ldc ''
            //   19: astore #11
            //   21: aload #9
            //   23: astore #8
            //   25: invokestatic d : ()Lcom/qiniu/android/dns/DnsManager;
            //   28: aload_2
            //   29: invokevirtual query : (Ljava/lang/String;)[Ljava/lang/String;
            //   32: astore #13
            //   34: aload #11
            //   36: astore #10
            //   38: aload #13
            //   40: ifnull -> 63
            //   43: aload #11
            //   45: astore #10
            //   47: aload #9
            //   49: astore #8
            //   51: aload #13
            //   53: arraylength
            //   54: ifle -> 63
            //   57: aload #13
            //   59: iconst_0
            //   60: aaload
            //   61: astore #10
            //   63: aload #9
            //   65: astore #8
            //   67: new java/lang/StringBuilder
            //   70: dup
            //   71: invokespecial <init> : ()V
            //   74: astore #11
            //   76: aload #9
            //   78: astore #8
            //   80: aload #11
            //   82: ldc 'httpDns query ip: '
            //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   87: pop
            //   88: aload #9
            //   90: astore #8
            //   92: aload #11
            //   94: aload #10
            //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   99: pop
            //   100: aload #9
            //   102: astore #8
            //   104: aload #11
            //   106: ldc ' for host: '
            //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   111: pop
            //   112: aload #9
            //   114: astore #8
            //   116: aload #11
            //   118: aload_2
            //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   122: pop
            //   123: aload #9
            //   125: astore #8
            //   127: ldc 'webTest'
            //   129: aload #11
            //   131: invokevirtual toString : ()Ljava/lang/String;
            //   134: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
            //   137: pop
            //   138: aload #9
            //   140: astore #8
            //   142: aload #10
            //   144: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   147: ifne -> 255
            //   150: aload #9
            //   152: astore #8
            //   154: aload_1
            //   155: aload_2
            //   156: aload #10
            //   158: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   161: astore #11
            //   163: aload #9
            //   165: astore #8
            //   167: new java/lang/StringBuilder
            //   170: dup
            //   171: invokespecial <init> : ()V
            //   174: astore #12
            //   176: aload #9
            //   178: astore #8
            //   180: aload #12
            //   182: ldc 'httpDns real url: '
            //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   187: pop
            //   188: aload #9
            //   190: astore #8
            //   192: aload #12
            //   194: aload #11
            //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   199: pop
            //   200: aload #9
            //   202: astore #8
            //   204: ldc 'webTest'
            //   206: aload #12
            //   208: invokevirtual toString : ()Ljava/lang/String;
            //   211: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
            //   214: pop
            //   215: aload #9
            //   217: astore #8
            //   219: new java/net/URL
            //   222: dup
            //   223: aload #11
            //   225: invokespecial <init> : (Ljava/lang/String;)V
            //   228: invokevirtual openConnection : ()Ljava/net/URLConnection;
            //   231: checkcast java/net/HttpURLConnection
            //   234: astore #9
            //   236: aload #9
            //   238: ldc 'Host'
            //   240: aload_2
            //   241: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
            //   244: goto -> 266
            //   247: astore_1
            //   248: aload #9
            //   250: astore #8
            //   252: goto -> 977
            //   255: aload #9
            //   257: astore #8
            //   259: aload #12
            //   261: invokevirtual openConnection : ()Ljava/net/URLConnection;
            //   264: astore #9
            //   266: aload #9
            //   268: astore #8
            //   270: aload_3
            //   271: invokeinterface getRequestHeaders : ()Ljava/util/Map;
            //   276: astore #11
            //   278: aload #11
            //   280: ifnull -> 363
            //   283: aload #9
            //   285: astore #8
            //   287: aload #11
            //   289: invokeinterface entrySet : ()Ljava/util/Set;
            //   294: invokeinterface iterator : ()Ljava/util/Iterator;
            //   299: astore #11
            //   301: aload #9
            //   303: astore #8
            //   305: aload #11
            //   307: invokeinterface hasNext : ()Z
            //   312: ifeq -> 363
            //   315: aload #9
            //   317: astore #8
            //   319: aload #11
            //   321: invokeinterface next : ()Ljava/lang/Object;
            //   326: checkcast java/util/Map$Entry
            //   329: astore #12
            //   331: aload #9
            //   333: astore #8
            //   335: aload #9
            //   337: aload #12
            //   339: invokeinterface getKey : ()Ljava/lang/Object;
            //   344: checkcast java/lang/String
            //   347: aload #12
            //   349: invokeinterface getValue : ()Ljava/lang/Object;
            //   354: checkcast java/lang/String
            //   357: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
            //   360: goto -> 301
            //   363: aload #9
            //   365: astore #8
            //   367: aload #10
            //   369: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   372: istore #7
            //   374: iload #7
            //   376: ifne -> 419
            //   379: aload #9
            //   381: astore #8
            //   383: invokestatic getInstance : ()Landroid/webkit/CookieManager;
            //   386: aload #10
            //   388: invokevirtual getCookie : (Ljava/lang/String;)Ljava/lang/String;
            //   391: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   394: ifne -> 419
            //   397: aload #9
            //   399: astore #8
            //   401: aload #9
            //   403: ldc 'Cookie'
            //   405: invokestatic getInstance : ()Landroid/webkit/CookieManager;
            //   408: aload #10
            //   410: invokevirtual getCookie : (Ljava/lang/String;)Ljava/lang/String;
            //   413: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
            //   416: goto -> 569
            //   419: aload #9
            //   421: astore #8
            //   423: invokestatic l : ()[Ljava/lang/String;
            //   426: astore #11
            //   428: aload #9
            //   430: astore #8
            //   432: aload #11
            //   434: arraylength
            //   435: istore #6
            //   437: iconst_0
            //   438: istore #5
            //   440: iload #5
            //   442: iload #6
            //   444: if_icmpge -> 569
            //   447: aload #11
            //   449: iload #5
            //   451: aaload
            //   452: astore #12
            //   454: aload #9
            //   456: astore #8
            //   458: aload_2
            //   459: aload #12
            //   461: invokevirtual endsWith : (Ljava/lang/String;)Z
            //   464: ifeq -> 997
            //   467: aload #9
            //   469: astore #8
            //   471: invokestatic getInstance : ()Landroid/webkit/CookieManager;
            //   474: aload #12
            //   476: invokevirtual getCookie : (Ljava/lang/String;)Ljava/lang/String;
            //   479: astore #12
            //   481: aload #9
            //   483: astore #8
            //   485: aload #12
            //   487: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   490: ifeq -> 496
            //   493: goto -> 997
            //   496: aload #9
            //   498: astore #8
            //   500: aload #9
            //   502: ldc 'Cookie'
            //   504: aload #12
            //   506: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
            //   509: aload #9
            //   511: astore #8
            //   513: aload #12
            //   515: ldc ';'
            //   517: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
            //   520: astore #11
            //   522: iconst_0
            //   523: istore #5
            //   525: aload #9
            //   527: astore #8
            //   529: iload #5
            //   531: aload #11
            //   533: arraylength
            //   534: if_icmpge -> 569
            //   537: aload #9
            //   539: astore #8
            //   541: aload #10
            //   543: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   546: ifne -> 988
            //   549: aload #9
            //   551: astore #8
            //   553: invokestatic getInstance : ()Landroid/webkit/CookieManager;
            //   556: aload #10
            //   558: aload #11
            //   560: iload #5
            //   562: aaload
            //   563: invokevirtual setCookie : (Ljava/lang/String;Ljava/lang/String;)V
            //   566: goto -> 988
            //   569: aload #9
            //   571: astore #8
            //   573: aload #9
            //   575: ldc 'X-Requested-With'
            //   577: invokestatic d : ()Landroid/content/Context;
            //   580: invokevirtual getPackageName : ()Ljava/lang/String;
            //   583: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
            //   586: aload #9
            //   588: astore #8
            //   590: aload #9
            //   592: instanceof javax/net/ssl/HttpsURLConnection
            //   595: ifeq -> 621
            //   598: aload #9
            //   600: astore #8
            //   602: aload #9
            //   604: checkcast javax/net/ssl/HttpsURLConnection
            //   607: new com/blued/android/framework/web/BluedWebView$3$1
            //   610: dup
            //   611: aload_0
            //   612: aload #10
            //   614: aload_2
            //   615: invokespecial <init> : (Lcom/blued/android/framework/web/BluedWebView$3;Ljava/lang/String;Ljava/lang/String;)V
            //   618: invokevirtual setHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
            //   621: aload #9
            //   623: astore #11
            //   625: iload #4
            //   627: ifne -> 985
            //   630: aload #9
            //   632: astore #8
            //   634: aload #9
            //   636: instanceof javax/net/ssl/HttpsURLConnection
            //   639: ifne -> 658
            //   642: aload #9
            //   644: astore #8
            //   646: aload #9
            //   648: astore #11
            //   650: aload #9
            //   652: instanceof java/net/HttpURLConnection
            //   655: ifeq -> 985
            //   658: aload #9
            //   660: astore #8
            //   662: aload #9
            //   664: checkcast java/net/HttpURLConnection
            //   667: iconst_0
            //   668: invokevirtual setInstanceFollowRedirects : (Z)V
            //   671: aload #9
            //   673: astore #8
            //   675: aload #9
            //   677: astore #11
            //   679: aload #9
            //   681: checkcast java/net/HttpURLConnection
            //   684: invokevirtual getResponseCode : ()I
            //   687: sipush #300
            //   690: if_icmplt -> 985
            //   693: aload #9
            //   695: astore #8
            //   697: aload #9
            //   699: astore #11
            //   701: aload #9
            //   703: checkcast java/net/HttpURLConnection
            //   706: invokevirtual getResponseCode : ()I
            //   709: sipush #307
            //   712: if_icmpgt -> 985
            //   715: aload #9
            //   717: astore #8
            //   719: aload #9
            //   721: ldc 'Location'
            //   723: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
            //   726: astore #11
            //   728: aload #9
            //   730: astore #8
            //   732: aload #11
            //   734: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   737: istore #7
            //   739: iconst_1
            //   740: istore #4
            //   742: iload #7
            //   744: ifne -> 961
            //   747: aload #9
            //   749: astore #8
            //   751: aload #11
            //   753: ldc 'action='
            //   755: invokevirtual contains : (Ljava/lang/CharSequence;)Z
            //   758: ifeq -> 961
            //   761: aload #9
            //   763: astore #8
            //   765: aload #11
            //   767: ldc 'http'
            //   769: invokevirtual startsWith : (Ljava/lang/String;)Z
            //   772: ifeq -> 795
            //   775: aload #9
            //   777: astore #8
            //   779: aload #11
            //   781: aload #10
            //   783: aload_2
            //   784: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   787: pop
            //   788: aload #11
            //   790: astore #10
            //   792: goto -> 854
            //   795: aload #9
            //   797: astore #8
            //   799: new java/lang/StringBuilder
            //   802: dup
            //   803: invokespecial <init> : ()V
            //   806: astore #10
            //   808: aload #9
            //   810: astore #8
            //   812: aload #10
            //   814: ldc 'https://'
            //   816: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   819: pop
            //   820: aload #9
            //   822: astore #8
            //   824: aload #10
            //   826: aload_2
            //   827: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   830: pop
            //   831: aload #9
            //   833: astore #8
            //   835: aload #10
            //   837: aload #11
            //   839: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   842: pop
            //   843: aload #9
            //   845: astore #8
            //   847: aload #10
            //   849: invokevirtual toString : ()Ljava/lang/String;
            //   852: astore #10
            //   854: aload #9
            //   856: astore #8
            //   858: aload_0
            //   859: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   862: aload #10
            //   864: invokestatic c : (Lcom/blued/android/framework/web/BluedWebView;Ljava/lang/String;)Z
            //   867: istore #7
            //   869: iload #7
            //   871: ifeq -> 948
            //   874: aload #9
            //   876: astore #8
            //   878: aload_0
            //   879: iload #7
            //   881: putfield b : Z
            //   884: aload #9
            //   886: astore #8
            //   888: aload #9
            //   890: astore #11
            //   892: aload_0
            //   893: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   896: invokestatic a : (Lcom/blued/android/framework/web/BluedWebView;)Lcom/blued/android/framework/web/BluedWebView$WebCallback;
            //   899: ifnull -> 985
            //   902: aload #9
            //   904: astore #8
            //   906: aload_0
            //   907: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   910: invokestatic a : (Lcom/blued/android/framework/web/BluedWebView;)Lcom/blued/android/framework/web/BluedWebView$WebCallback;
            //   913: astore_2
            //   914: aload #9
            //   916: astore #8
            //   918: aload_0
            //   919: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   922: astore_3
            //   923: iload #7
            //   925: ifne -> 1006
            //   928: goto -> 931
            //   931: aload #9
            //   933: astore #8
            //   935: aload_2
            //   936: aload_3
            //   937: aload_1
            //   938: iload #4
            //   940: invokeinterface a : (Lcom/blued/android/framework/web/BluedWebView;Ljava/lang/String;Z)V
            //   945: aload #9
            //   947: areturn
            //   948: aload #9
            //   950: astore #8
            //   952: aload_0
            //   953: aload_1
            //   954: aload_2
            //   955: aload_3
            //   956: iconst_1
            //   957: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Landroid/webkit/WebResourceRequest;Z)Ljava/net/URLConnection;
            //   960: areturn
            //   961: aload #9
            //   963: astore #8
            //   965: aload_0
            //   966: aload_1
            //   967: aload_2
            //   968: aload_3
            //   969: iconst_1
            //   970: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Landroid/webkit/WebResourceRequest;Z)Ljava/net/URLConnection;
            //   973: astore_1
            //   974: aload_1
            //   975: areturn
            //   976: astore_1
            //   977: aload_1
            //   978: invokevirtual printStackTrace : ()V
            //   981: aload #8
            //   983: astore #11
            //   985: aload #11
            //   987: areturn
            //   988: iload #5
            //   990: iconst_1
            //   991: iadd
            //   992: istore #5
            //   994: goto -> 525
            //   997: iload #5
            //   999: iconst_1
            //   1000: iadd
            //   1001: istore #5
            //   1003: goto -> 440
            //   1006: iconst_0
            //   1007: istore #4
            //   1009: goto -> 931
            // Exception table:
            //   from	to	target	type
            //   7	17	976	java/lang/Exception
            //   25	34	976	java/lang/Exception
            //   51	57	976	java/lang/Exception
            //   67	76	976	java/lang/Exception
            //   80	88	976	java/lang/Exception
            //   92	100	976	java/lang/Exception
            //   104	112	976	java/lang/Exception
            //   116	123	976	java/lang/Exception
            //   127	138	976	java/lang/Exception
            //   142	150	976	java/lang/Exception
            //   154	163	976	java/lang/Exception
            //   167	176	976	java/lang/Exception
            //   180	188	976	java/lang/Exception
            //   192	200	976	java/lang/Exception
            //   204	215	976	java/lang/Exception
            //   219	236	976	java/lang/Exception
            //   236	244	247	java/lang/Exception
            //   259	266	976	java/lang/Exception
            //   270	278	976	java/lang/Exception
            //   287	301	976	java/lang/Exception
            //   305	315	976	java/lang/Exception
            //   319	331	976	java/lang/Exception
            //   335	360	976	java/lang/Exception
            //   367	374	976	java/lang/Exception
            //   383	397	976	java/lang/Exception
            //   401	416	976	java/lang/Exception
            //   423	428	976	java/lang/Exception
            //   432	437	976	java/lang/Exception
            //   458	467	976	java/lang/Exception
            //   471	481	976	java/lang/Exception
            //   485	493	976	java/lang/Exception
            //   500	509	976	java/lang/Exception
            //   513	522	976	java/lang/Exception
            //   529	537	976	java/lang/Exception
            //   541	549	976	java/lang/Exception
            //   553	566	976	java/lang/Exception
            //   573	586	976	java/lang/Exception
            //   590	598	976	java/lang/Exception
            //   602	621	976	java/lang/Exception
            //   634	642	976	java/lang/Exception
            //   650	658	976	java/lang/Exception
            //   662	671	976	java/lang/Exception
            //   679	693	976	java/lang/Exception
            //   701	715	976	java/lang/Exception
            //   719	728	976	java/lang/Exception
            //   732	739	976	java/lang/Exception
            //   751	761	976	java/lang/Exception
            //   765	775	976	java/lang/Exception
            //   779	788	976	java/lang/Exception
            //   799	808	976	java/lang/Exception
            //   812	820	976	java/lang/Exception
            //   824	831	976	java/lang/Exception
            //   835	843	976	java/lang/Exception
            //   847	854	976	java/lang/Exception
            //   858	869	976	java/lang/Exception
            //   878	884	976	java/lang/Exception
            //   892	902	976	java/lang/Exception
            //   906	914	976	java/lang/Exception
            //   918	923	976	java/lang/Exception
            //   935	945	976	java/lang/Exception
            //   952	961	976	java/lang/Exception
            //   965	974	976	java/lang/Exception
          }
          
          public void onPageFinished(WebView param1WebView, String param1String) {
            if (Tools.a(BluedWebView.c(this.a))) {
              if (AppInfo.m()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onPageFinished(), url:");
                stringBuilder.append(param1String);
                Log.v("webTest", stringBuilder.toString());
              } 
              super.onPageFinished(param1WebView, param1String);
              Long long_ = (Long)BluedWebView.l(this.a).remove(param1String);
              if (long_ != null)
                BluedStatistics.b().a(param1String, SystemClock.uptimeMillis() - long_.longValue()); 
              if (BluedWebView.m(this.a) != null)
                BluedWebView.m(this.a).a(param1String); 
              if (BluedWebView.a(this.a) != null)
                BluedWebView.a(this.a).b(this.a, param1String, this.b ^ true); 
              if (!BluedWebView.n(this.a)) {
                BluedWebView.a(this.a, true);
                BluedWebView.a(this.a).a(BluedWebView.o(this.a), BluedWebView.p(this.a), BluedWebView.c(this.a), this.a);
              } 
              this.a.i();
            } 
          }
          
          public void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
            if (AppInfo.m()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onPageStarted(), url:");
              stringBuilder.append(param1String);
              Log.v("webTest", stringBuilder.toString());
            } 
            BluedWebView.b(this.a, param1String);
            super.onPageStarted(param1WebView, param1String, param1Bitmap);
            BluedWebView.l(this.a).put(param1String, Long.valueOf(SystemClock.uptimeMillis()));
          }
          
          public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
            if (AppInfo.m()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onReceivedError(), failingUrl:");
              stringBuilder.append(param1String2);
              stringBuilder.append(", errorCode:");
              stringBuilder.append(param1Int);
              stringBuilder.append(", description:");
              stringBuilder.append(param1String1);
              Log.v("webTest", stringBuilder.toString());
            } 
            long l = -1L;
            Long long_ = (Long)BluedWebView.l(this.a).remove(param1String2);
            if (long_ != null)
              l = SystemClock.uptimeMillis() - long_.longValue(); 
            BluedStatistics.b().a(param1String2, l, param1Int, param1String1);
            if (BluedWebView.a(this.a) != null)
              BluedWebView.a(this.a).a(this.a, param1Int, param1String1, param1String2); 
          }
          
          public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
            // Byte code:
            //   0: invokestatic m : ()Z
            //   3: ifeq -> 52
            //   6: new java/lang/StringBuilder
            //   9: dup
            //   10: invokespecial <init> : ()V
            //   13: astore_1
            //   14: aload_1
            //   15: ldc_w 'onReceivedError(), request:'
            //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   21: pop
            //   22: aload_1
            //   23: aload_2
            //   24: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   27: pop
            //   28: aload_1
            //   29: ldc_w ', error:'
            //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   35: pop
            //   36: aload_1
            //   37: aload_3
            //   38: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   41: pop
            //   42: ldc 'webTest'
            //   44: aload_1
            //   45: invokevirtual toString : ()Ljava/lang/String;
            //   48: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
            //   51: pop
            //   52: ldc ''
            //   54: astore_1
            //   55: aload_2
            //   56: ifnull -> 78
            //   59: aload_2
            //   60: invokeinterface getUrl : ()Landroid/net/Uri;
            //   65: astore_2
            //   66: aload_2
            //   67: ifnull -> 78
            //   70: aload_2
            //   71: invokevirtual toString : ()Ljava/lang/String;
            //   74: astore_2
            //   75: goto -> 81
            //   78: ldc ''
            //   80: astore_2
            //   81: aload_3
            //   82: ifnull -> 110
            //   85: aload_3
            //   86: invokevirtual getErrorCode : ()I
            //   89: istore #4
            //   91: aload_3
            //   92: invokevirtual getDescription : ()Ljava/lang/CharSequence;
            //   95: astore_3
            //   96: aload_3
            //   97: ifnull -> 107
            //   100: aload_3
            //   101: invokeinterface toString : ()Ljava/lang/String;
            //   106: astore_1
            //   107: goto -> 113
            //   110: iconst_0
            //   111: istore #4
            //   113: ldc2_w -1
            //   116: lstore #5
            //   118: aload_0
            //   119: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   122: invokestatic l : (Lcom/blued/android/framework/web/BluedWebView;)Ljava/util/Map;
            //   125: aload_2
            //   126: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
            //   131: checkcast java/lang/Long
            //   134: astore_3
            //   135: aload_3
            //   136: ifnull -> 149
            //   139: invokestatic uptimeMillis : ()J
            //   142: aload_3
            //   143: invokevirtual longValue : ()J
            //   146: lsub
            //   147: lstore #5
            //   149: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
            //   152: aload_2
            //   153: lload #5
            //   155: iload #4
            //   157: aload_1
            //   158: invokevirtual a : (Ljava/lang/String;JILjava/lang/String;)V
            //   161: aload_0
            //   162: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   165: invokestatic a : (Lcom/blued/android/framework/web/BluedWebView;)Lcom/blued/android/framework/web/BluedWebView$WebCallback;
            //   168: ifnull -> 205
            //   171: aload_0
            //   172: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   175: invokestatic o : (Lcom/blued/android/framework/web/BluedWebView;)Ljava/lang/String;
            //   178: aload_2
            //   179: invokevirtual equals : (Ljava/lang/Object;)Z
            //   182: ifeq -> 205
            //   185: aload_0
            //   186: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   189: invokestatic a : (Lcom/blued/android/framework/web/BluedWebView;)Lcom/blued/android/framework/web/BluedWebView$WebCallback;
            //   192: aload_0
            //   193: getfield a : Lcom/blued/android/framework/web/BluedWebView;
            //   196: iload #4
            //   198: aload_1
            //   199: aload_2
            //   200: invokeinterface a : (Lcom/blued/android/framework/web/BluedWebView;ILjava/lang/String;Ljava/lang/String;)V
            //   205: return
          }
          
          public WebResourceResponse shouldInterceptRequest(WebView param1WebView, WebResourceRequest param1WebResourceRequest) {
            if (!BluedWebView.q(this.a) && !BluedWebView.k())
              return super.shouldInterceptRequest(param1WebView, param1WebResourceRequest); 
            if (param1WebResourceRequest != null && param1WebResourceRequest.getUrl() != null && param1WebResourceRequest.getMethod().equalsIgnoreCase("get")) {
              String str1 = param1WebResourceRequest.getUrl().getHost();
              if (TextUtils.isEmpty(str1))
                return super.shouldInterceptRequest(param1WebView, param1WebResourceRequest); 
              if (!BluedWebView.q(this.a) && !str1.endsWith("bldimg.com") && !str1.endsWith("blued.cn") && !str1.endsWith("blued.com") && !str1.endsWith("blued.tw") && !str1.endsWith("blued.us") && !str1.endsWith("bluedapp.com") && !str1.endsWith("bluedofficial.tumblr.com"))
                return super.shouldInterceptRequest(param1WebView, param1WebResourceRequest); 
              String str2 = param1WebResourceRequest.getUrl().getScheme().trim();
              String str3 = param1WebResourceRequest.getUrl().toString();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("shouldInterceptRequest url: ");
              stringBuilder.append(str3);
              Log.b("webTest", stringBuilder.toString());
              if (str2.equalsIgnoreCase("http") || str2.equalsIgnoreCase("https"))
                try {
                  URLConnection uRLConnection = a(str3, str1, param1WebResourceRequest, false);
                  if (uRLConnection == null)
                    return null; 
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("ContentType: ");
                  stringBuilder1.append(uRLConnection.getContentType());
                  Log.b("webTest", stringBuilder1.toString());
                  String str = uRLConnection.getContentType();
                  return new WebResourceResponse(BluedWebView.d(this.a, str), BluedWebView.e(this.a, str), uRLConnection.getInputStream());
                } catch (MalformedURLException malformedURLException) {
                  malformedURLException.printStackTrace();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("shouldInterceptRequest MalformedURLException:");
                  stringBuilder1.append(malformedURLException);
                  Log.b("webTest", stringBuilder1.toString());
                } catch (IOException iOException) {
                  iOException.printStackTrace();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("shouldInterceptRequest IOException:");
                  stringBuilder1.append(iOException);
                  Log.b("webTest", stringBuilder1.toString());
                }  
            } 
            return super.shouldInterceptRequest(param1WebView, param1WebResourceRequest);
          }
          
          public WebResourceResponse shouldInterceptRequest(WebView param1WebView, String param1String) {
            return super.shouldInterceptRequest(param1WebView, param1String);
          }
          
          public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
            if (AppInfo.m()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("shouldOverrideUrlLoading(), url:");
              stringBuilder.append(param1String);
              Log.v("webTest", stringBuilder.toString());
            } 
            boolean bool = BluedWebView.c(this.a, param1String);
            this.b = bool;
            if (BluedWebView.a(this.a) != null)
              BluedWebView.a(this.a).a(this.a, param1String, bool ^ true); 
            return bool;
          }
        });
    this.i.setDownloadListener(new DownloadListener(this) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            if (Tools.a(BluedWebView.c(this.a))) {
              if (AppInfo.m()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onDownloadStart(), url:");
                stringBuilder.append(param1String1);
                Log.v("webTest", stringBuilder.toString());
              } 
              Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(param1String1));
              BluedWebView.c(this.a).startActivity(intent);
            } 
          }
        });
  }
  
  private static CookieManager p() {
    String[] arrayOfString = y;
    CookieManager cookieManager = null;
    if (arrayOfString == null || arrayOfString.length == 0) {
      if (AppInfo.m())
        Log.w("webTest", "cookieDomains is empty!"); 
      return null;
    } 
    try {
      String str1;
      CookieManager cookieManager1 = CookieManager.getInstance();
      cookieManager = cookieManager1;
      cookieManager1.setAcceptCookie(true);
      cookieManager = cookieManager1;
      StringBuilder stringBuilder3 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder3.append("token=");
      cookieManager = cookieManager1;
      boolean bool = TextUtils.isEmpty(ProviderHolder.a().b().b());
      String str2 = "";
      if (bool) {
        str1 = "";
      } else {
        cookieManager = cookieManager1;
        str1 = AesCrypto.a(ProviderHolder.a().b().b());
      } 
      cookieManager = cookieManager1;
      stringBuilder3.append(str1);
      cookieManager = cookieManager1;
      String str6 = stringBuilder3.toString();
      cookieManager = cookieManager1;
      stringBuilder3 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder3.append("uid=");
      cookieManager = cookieManager1;
      if (TextUtils.isEmpty(ProviderHolder.a().b().a())) {
        str1 = str2;
      } else {
        cookieManager = cookieManager1;
        str1 = AesCrypto.a(ProviderHolder.a().b().a());
      } 
      cookieManager = cookieManager1;
      stringBuilder3.append(str1);
      cookieManager = cookieManager1;
      String str9 = stringBuilder3.toString();
      cookieManager = cookieManager1;
      StringBuilder stringBuilder1 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder1.append("app=");
      cookieManager = cookieManager1;
      stringBuilder1.append(ProviderHolder.a().e().a());
      cookieManager = cookieManager1;
      String str10 = stringBuilder1.toString();
      cookieManager = cookieManager1;
      stringBuilder1 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder1.append("Accept-Language=");
      cookieManager = cookieManager1;
      stringBuilder1.append(LocaleUtils.b());
      cookieManager = cookieManager1;
      String str11 = stringBuilder1.toString();
      cookieManager = cookieManager1;
      CommonProtos.Common common = BluedStatistics.a().b();
      cookieManager = cookieManager1;
      StringBuilder stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("net_op=");
      cookieManager = cookieManager1;
      stringBuilder2.append(URLEncoder.encode(common.getNetOp(), "UTF-8"));
      cookieManager = cookieManager1;
      String str12 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("net=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getNet());
      cookieManager = cookieManager1;
      String str13 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("lat=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getLat());
      cookieManager = cookieManager1;
      String str14 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("lon=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getLon());
      cookieManager = cookieManager1;
      String str15 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("channel=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getChannel());
      cookieManager = cookieManager1;
      String str16 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("screen_width=");
      cookieManager = cookieManager1;
      stringBuilder2.append(String.valueOf(common.getScreenWidth()));
      cookieManager = cookieManager1;
      String str17 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("screen_high=");
      cookieManager = cookieManager1;
      stringBuilder2.append(String.valueOf(common.getScreenHigh()));
      cookieManager = cookieManager1;
      String str18 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("device=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getDevice());
      cookieManager = cookieManager1;
      String str3 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("imei=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getImei());
      cookieManager = cookieManager1;
      String str7 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("smid=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getSmid());
      cookieManager = cookieManager1;
      String str8 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("dev_dna=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getDevDna());
      cookieManager = cookieManager1;
      String str5 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      stringBuilder2 = new StringBuilder();
      cookieManager = cookieManager1;
      stringBuilder2.append("timezone=");
      cookieManager = cookieManager1;
      stringBuilder2.append(common.getTimezone());
      cookieManager = cookieManager1;
      String str4 = stringBuilder2.toString();
      cookieManager = cookieManager1;
      String[] arrayOfString1 = y;
      cookieManager = cookieManager1;
      int j = arrayOfString1.length;
      int i = 0;
      while (true) {
        cookieManager = cookieManager1;
        if (i < j) {
          Map.Entry entry2;
          String str = arrayOfString1[i];
          int k = i;
          String[] arrayOfString2 = arrayOfString1;
          cookieManager = cookieManager1;
          if (z != null) {
            cookieManager = cookieManager1;
            Iterator<Map.Entry> iterator = z.entrySet().iterator();
            while (true) {
              k = i;
              arrayOfString2 = arrayOfString1;
              cookieManager = cookieManager1;
              if (iterator.hasNext()) {
                cookieManager = cookieManager1;
                entry2 = iterator.next();
                cookieManager = cookieManager1;
                StringBuilder stringBuilder = new StringBuilder();
                cookieManager = cookieManager1;
                stringBuilder.append((String)entry2.getKey());
                cookieManager = cookieManager1;
                stringBuilder.append("=");
                cookieManager = cookieManager1;
                stringBuilder.append((String)entry2.getValue());
                cookieManager = cookieManager1;
                cookieManager1.setCookie(str, stringBuilder.toString());
                continue;
              } 
              break;
            } 
          } 
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str6);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str9);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, "native=1");
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str10);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str11);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str12);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str13);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str14);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str15);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str16);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str17);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str18);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str3);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str7);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str8);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str5);
          cookieManager = cookieManager1;
          cookieManager1.setCookie(str, str4);
          Map.Entry entry1 = entry2;
          i = k + 1;
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return cookieManager;
  }
  
  private void q() {
    Locale locale = LocaleUtils.c();
    if (locale != null && Build.VERSION.SDK_INT >= 17) {
      Resources resources = AppInfo.d().getResources();
      Configuration configuration = resources.getConfiguration();
      if (!a(configuration).equals(locale)) {
        Locale.setDefault(locale);
        configuration = new Configuration(configuration);
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
      } 
    } 
  }
  
  public Fragment a() {
    return this.h;
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(Context paramContext) {
    if (AppMethods.c(21)) {
      d(paramContext);
      return;
    } 
    CookieSyncManager.createInstance(paramContext);
    p();
    CookieSyncManager.getInstance().sync();
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.l != null && paramInt1 == WebUploadFile.a) {
      this.l.a(paramInt1, paramInt2, paramIntent);
      return true;
    } 
    return false;
  }
  
  public boolean a(String paramString) {
    return a(paramString, this.t);
  }
  
  public boolean a(String paramString1, String paramString2) {
    T t = this.k;
    if (t != null && t.b(paramString1))
      return false; 
    t = this.k;
    if (t != null)
      t.a(); 
    this.r = paramString1;
    this.s = paramString1;
    this.t = paramString2;
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("Accept-Language", LocaleUtils.b());
    String str = ProviderHolder.a().e().b();
    if (!TextUtils.isEmpty(str))
      arrayMap.put("X-CLIENT-COLOR", str); 
    this.i.getSettings().setDefaultTextEncodingName("utf-8");
    if (AppInfo.m()) {
      String[] arrayOfString = y;
      if (arrayOfString != null && arrayOfString.length > 0) {
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
          String str1 = arrayOfString[i];
          String str2 = CookieManager.getInstance().getCookie(str1);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("== ");
          stringBuilder2.append(str1);
          stringBuilder2.append(" ==↓↓↓↓↓↓");
          Log.i("webTest", stringBuilder2.toString());
          if (str2 != null) {
            String[] arrayOfString1 = str2.split(";");
            int m = arrayOfString1.length;
            int k;
            for (k = 0; k < m; k++)
              Log.v("webTest", arrayOfString1[k]); 
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("== ");
          stringBuilder1.append(str1);
          stringBuilder1.append(" ==↑↑↑↑↑↑↑");
          Log.i("webTest", stringBuilder1.toString());
        } 
      } 
    } 
    c(paramString1);
    this.i.loadUrl(paramString1, (Map)arrayMap);
    return true;
  }
  
  public int b() {
    return this.w;
  }
  
  public void b(int paramInt) {
    this.w = paramInt;
  }
  
  public void b(String paramString) {
    T t = this.k;
    if (t != null)
      t.a(paramString, this.r, "", "", 0, null, this); 
  }
  
  public WebView c() {
    return this.i;
  }
  
  public String d() {
    return this.r;
  }
  
  public void d(Context paramContext) {
    CookieManager cookieManager = p();
    WebView webView = this.i;
    if (webView != null)
      cookieManager.setAcceptThirdPartyCookies(webView, true); 
    if (cookieManager != null)
      cookieManager.flush(); 
  }
  
  public String e() {
    return this.t;
  }
  
  public void f() {
    this.i.onResume();
    if (!TextUtils.isEmpty(this.o)) {
      JSExecutor jSExecutor = this.m;
      if (jSExecutor != null)
        jSExecutor.a(jSExecutor.b(), this.o); 
    } 
  }
  
  public void g() {
    this.i.onPause();
  }
  
  public void h() {
    JSExecutor jSExecutor = this.m;
    if (jSExecutor != null)
      jSExecutor.a(); 
    if (this.n != null)
      WebDownloaderManager.a().b(this.n); 
    this.i.clearCache(true);
    this.i.setVisibility(8);
    this.i.destroy();
  }
  
  public void i() {
    String str = this.h.getActivity().getString(R.string.web_js_get_option_menu);
    WebView webView = this.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("javascript:");
    stringBuilder.append(str);
    webView.loadUrl(stringBuilder.toString());
    this.i.loadUrl("javascript:getOptionMenuFunction()");
  }
  
  public void j() {
    this.i.loadUrl("javascript:getBannerPosition()");
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener(this) {
        public boolean onMenuItemClick(MenuItem param1MenuItem) {
          if (param1MenuItem.getItemId() == 1 && !TextUtils.isEmpty(BluedWebView.r(this.a))) {
            String str1 = Tools.a();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(System.currentTimeMillis());
            stringBuilder1.append(".jpg");
            String str2 = stringBuilder1.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str1);
            stringBuilder2.append(File.separator);
            stringBuilder2.append(str2);
            str1 = stringBuilder2.toString();
            FileDownloader.a(BluedWebView.r(this.a), str1, new FileHttpResponseHandler(this) {
                  public void a(File param2File) {
                    if (param2File != null) {
                      if (!param2File.exists())
                        return; 
                      AppInfo.n().post(new -$$Lambda$BluedWebView$5$1$zmqhq_BBav4d5PfDawtzQrMJQs4(this, param2File));
                    } 
                  }
                  
                  public void a(Throwable param2Throwable, int param2Int, File param2File) {
                    super.onFailure(param2Throwable, param2Int, param2File);
                    AppMethods.d(R.string.imagefailed_save_failed);
                  }
                }null);
            return true;
          } 
          return false;
        }
      };
    if (paramView instanceof WebView) {
      WebView.HitTestResult hitTestResult = ((WebView)paramView).getHitTestResult();
      if (hitTestResult != null) {
        int i = hitTestResult.getType();
        if (i == 5 || i == 8) {
          this.v = hitTestResult.getExtra();
          paramContextMenu.add(0, 1, 0, R.string.web_save_picture).setOnMenuItemClickListener(onMenuItemClickListener);
        } 
      } 
    } 
  }
  
  final class InJavaScriptBluedNativeObject {
    @JavascriptInterface
    public void getH5ViewPagerInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      BluedWebView bluedWebView = BluedWebView.this;
      BluedWebView.a(bluedWebView, new BluedWebView.RectPosition(bluedWebView, param1Int1, param1Int2, param1Int3, param1Int4));
    }
    
    @JavascriptInterface
    public void registerResumeJs(String param1String) {
      BluedWebView.f(BluedWebView.this, param1String);
    }
  }
  
  final class InJavaScriptLocalObj {
    InJavaScriptLocalObj(BluedWebView this$0) {}
    
    @JavascriptInterface
    public void setOptionMenu(String param1String) {
      BluedWebView.k(this.a).post(new Runnable(this, param1String) {
            public void run() {
              if (BluedWebView.a(this.b.a) != null)
                BluedWebView.a(this.b.a).a(this.a); 
            }
          });
    }
    
    @JavascriptInterface
    public void shareTo(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      shareTo(param1String1, param1String2, param1String3, "", "", "0", "0", param1String4, param1String5);
    }
    
    @JavascriptInterface
    public void shareTo(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7, String param1String8, String param1String9) {
      if (BluedWebView.c(this.a) == null)
        return; 
      Runnable runnable = new Runnable(this, param1String1, param1String2, param1String3, param1String4, param1String5, param1String6, param1String7, param1String8, param1String9) {
          public void run() {
            if (BluedWebView.a(this.j.a) != null)
              BluedWebView.a(this.j.a).a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j.a); 
          }
        };
      if (BluedWebView.c(this.a) instanceof BaseFragment)
        ((BaseFragment)BluedWebView.c(this.a)).a(runnable, 500L); 
      if (BluedWebView.c(this.a) instanceof BaseDialogFragment)
        ((BaseDialogFragment)BluedWebView.c(this.a)).a(runnable, 500L); 
    }
  }
  
  class null implements Runnable {
    null(BluedWebView this$0, String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7, String param1String8, String param1String9) {}
    
    public void run() {
      if (BluedWebView.a(this.j.a) != null)
        BluedWebView.a(this.j.a).a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j.a); 
    }
  }
  
  class null implements Runnable {
    null(BluedWebView this$0, String param1String) {}
    
    public void run() {
      if (BluedWebView.a(this.b.a) != null)
        BluedWebView.a(this.b.a).a(this.a); 
    }
  }
  
  class RectPosition {
    private int b;
    
    private int c;
    
    private int d;
    
    private int e;
    
    public RectPosition(BluedWebView this$0, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.b = param1Int2;
      this.c = param1Int1;
      this.d = param1Int3;
      this.e = param1Int4;
    }
  }
  
  public static interface WebCallback {
    void a();
    
    void a(BluedWebView param1BluedWebView, int param1Int);
    
    void a(BluedWebView param1BluedWebView, int param1Int, String param1String1, String param1String2);
    
    void a(BluedWebView param1BluedWebView, String param1String);
    
    void a(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean);
    
    void a(String param1String);
    
    void a(String param1String1, String param1String2, Fragment param1Fragment, BluedWebView param1BluedWebView);
    
    void a(String param1String1, String param1String2, String param1String3, String param1String4, int param1Int, Map<String, String> param1Map, BluedWebView param1BluedWebView);
    
    void a(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7, String param1String8, String param1String9, BluedWebView param1BluedWebView);
    
    void a(Map<String, String> param1Map, BluedWebView param1BluedWebView);
    
    boolean a(Context param1Context, String param1String);
    
    boolean a(BluedWebView param1BluedWebView, BluedUrlParser param1BluedUrlParser);
    
    void b();
    
    void b(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean);
    
    boolean b(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\BluedWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */