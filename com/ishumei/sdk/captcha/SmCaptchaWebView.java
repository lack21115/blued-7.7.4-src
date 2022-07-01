package com.ishumei.sdk.captcha;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class SmCaptchaWebView extends WebView {
  public static final boolean DEBUG = false;
  
  private static final int MESSAGE_TIMEOUT = 1;
  
  public static final String MODE_ICON_SELECT = "icon_select";
  
  public static final String MODE_SELECT = "select";
  
  public static final String MODE_SEQ_SELECT = "seq_select";
  
  public static final String MODE_SLIDE = "slide";
  
  public static final String MODE_SPATIAL_SELECT = "spatial_select";
  
  public static int SMCAPTCHA_JS_INIT_ERROR = 2004;
  
  public static int SMCAPTCHA_JS_OPTION_ERROR = 2003;
  
  public static int SMCAPTCHA_JS_RESOURCE_ERROR = 2001;
  
  public static int SMCAPTCHA_JS_SERVER_ERROR = 2002;
  
  public static int SMCAPTCHA_SDK_NOLISTENER = 1004;
  
  public static int SMCAPTCHA_SDK_OPTION_EMPTY = 1001;
  
  public static int SMCAPTCHA_SDK_OPTION_NOAPPID = 1003;
  
  public static int SMCAPTCHA_SDK_OPTION_NOORG = 1002;
  
  public static int SMCAPTCHA_SUCCESS = 0;
  
  public static int SMCAPTCHA_WV_NETWORK_ERROR = 1005;
  
  public static int SMCAPTCHA_WV_RESULT_ERROR = 1006;
  
  private static final String SM_CA_DEBUG_HTML = "http://castatic-dev.fengkongcloud.com/pr/v1.0.3/index.html";
  
  private static final String SM_CA_DEBUG_SDK_VERSION = "1.1.8beta";
  
  private static final String SM_CA_HTML = "https://castatic.fengkongcloud.com/pr/v1.0.3/index.html";
  
  private static final int SM_CA_LOAD_HTML_RETRY = 2;
  
  private static final int SM_CA_LOAD_HTML_TIMEOUT = 10000;
  
  private static final String SM_CA_OS = "android";
  
  private static final String SM_CA_RELEASE_HTML = "https://castatic.fengkongcloud.com/pr/v1.0.3/index.html";
  
  private static final String SM_CA_RELEASE_SDK_VERSION = "1.2.2";
  
  private static final String SM_CA_SDK_VERSION = "1.2.2";
  
  public static int SMcAPTCHA_JS_NETWORK_ERROR = 2005;
  
  private static final String TAG = "SmCaptchaWebView";
  
  private String compatHijackUrl;
  
  private Set<String> interceptUrls = new HashSet<String>();
  
  private boolean isInit = false;
  
  private ResultListener listener;
  
  private SmOption option;
  
  private int retry = 0;
  
  public SmCaptchaWebView(Context paramContext) {
    super(paramContext);
  }
  
  public SmCaptchaWebView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public SmCaptchaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public SmCaptchaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public SmCaptchaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean) {
    super(paramContext, paramAttributeSet, paramInt, paramBoolean);
  }
  
  private boolean dispatchPersonalSchemeUrl(WebView paramWebView, Uri paramUri) {
    if (paramUri.getScheme().equals("shumei")) {
      StringBuilder stringBuilder;
      if (paramUri.getAuthority().equals("onresult")) {
        String str = paramUri.getQueryParameter("data");
        try {
          JSONObject jSONObject = new JSONObject(str);
          String str1 = jSONObject.getString("method");
          if (O000O00000oO.O0000O000000oO(str1, "onError")) {
            onError(jSONObject.getInt("code"));
          } else if (O000O00000oO.O0000O000000oO(str1, "onSuccess")) {
            onSuccess(jSONObject.getString("rid"), jSONObject.getBoolean("pass"));
          } else if (O000O00000oO.O0000O000000oO(str1, "onReady")) {
            onReady();
          } 
        } catch (JSONException jSONException) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Exception: ");
          stringBuilder.append(jSONException.getMessage());
          stringBuilder.toString();
          onError(SMCAPTCHA_WV_RESULT_ERROR);
        } 
      } else if (stringBuilder.getAuthority().equals("requestnativeparams")) {
        jSONException.loadUrl(getInjectJSdeliverNativeParams());
      } 
      return true;
    } 
    return false;
  }
  
  private String getInjectJSdeliverNativeParams() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      hashMap.put("organization", this.option.getOrganization());
      hashMap.put("appId", this.option.getAppId());
      hashMap.put("channel", this.option.getChannel());
      hashMap.put("mode", this.option.getMode());
      hashMap.put("https", Boolean.valueOf(this.option.isHttps()));
      if (this.option.getExtOption() != null)
        for (Map.Entry<String, Object> entry : this.option.getExtOption().entrySet())
          hashMap.put(entry.getKey(), entry.getValue());  
      if (!TextUtils.isEmpty(this.option.getHost())) {
        String str2 = this.option.getHost();
        String str1 = str2;
        if (str2.startsWith("http")) {
          int i = str2.indexOf("://");
          str1 = str2;
          if (i != -1)
            str1 = str2.substring(i + 3); 
        } 
        hashMap.put("domains", Collections.singletonList(str1));
      } 
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
      if (this.option.getExtData() != null)
        for (Map.Entry<String, String> entry : this.option.getExtData().entrySet())
          hashMap1.put(entry.getKey(), entry.getValue());  
      boolean bool = O000O00000oO.O000O00000oO(this.option.getDeviceId());
      if (bool)
        hashMap1.put("deviceId", this.option.getDeviceId()); 
      hashMap1.put("os", "android");
      hashMap1.put("sdkver", "1.2.2");
      hashMap.put("data", hashMap1);
      if (!TextUtils.isEmpty(this.option.getTipMessage())) {
        hashMap1 = new HashMap<Object, Object>();
        hashMap1.put("sliderPlaceholder", this.option.getTipMessage());
        hashMap.put("tipsMessage", hashMap1);
      } 
      String str = O000O0000O0oO.O0000O000000oO(hashMap).toString();
      str = str.replaceAll("'", "\\\\'");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("javascript:deliverNativeParams('");
      stringBuilder.append(str);
      stringBuilder.append("')");
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private void initAlert() {
    setWebChromeClient(new O0000O000000oO(this));
  }
  
  private void initIntercept() {
    try {
      this.interceptUrls.add(O000O00000oO.O0000O000000oO("d09c9ed089ced09c909199"));
      this.interceptUrls.add(O000O00000oO.O0000O000000oO("d09c9ed089ced08d9a98968c8b9a8d"));
      this.interceptUrls.add(O000O00000oO.O0000O000000oO("d09c9ed089ced099899a8d969986"));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void initStyle() {
    getSettings().setJavaScriptEnabled(true);
    getSettings().setUseWideViewPort(false);
    getSettings().setSupportZoom(true);
    getSettings().setLoadWithOverviewMode(false);
    getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    getSettings().setCacheMode(2);
    getSettings().setAllowFileAccess(true);
    getSettings().setNeedInitialFocus(false);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().setLoadsImagesAutomatically(true);
    getSettings().setUseWideViewPort(false);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
  }
  
  private void onError(int paramInt) {
    ResultListener resultListener = this.listener;
    if (resultListener != null)
      resultListener.onError(paramInt); 
  }
  
  private void onReady() {
    ResultListener resultListener = this.listener;
    if (resultListener != null)
      resultListener.onReady(); 
  }
  
  private void onSuccess(String paramString, boolean paramBoolean) {
    ResultListener resultListener = this.listener;
    if (resultListener != null)
      resultListener.onSuccess(paramString, paramBoolean); 
  }
  
  private boolean shouldIntercept(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    Iterator<String> iterator = this.interceptUrls.iterator();
    while (iterator.hasNext()) {
      if (paramString.contains(iterator.next()))
        return true; 
    } 
    return false;
  }
  
  public void disableCaptcha() {
    loadUrl("javascript:SMCaptcha.disableCaptcha();");
  }
  
  public void enableCaptcha() {
    loadUrl("javascript:SMCaptcha.enableCaptcha();");
  }
  
  public int initWithOption(SmOption paramSmOption, ResultListener paramResultListener) {
    if (paramSmOption == null)
      return SMCAPTCHA_SDK_OPTION_EMPTY; 
    if (O000O00000oO.O000O00000OoO(paramSmOption.getOrganization()))
      return SMCAPTCHA_SDK_OPTION_NOORG; 
    if (O000O00000oO.O000O00000OoO(paramSmOption.getAppId()))
      return SMCAPTCHA_SDK_OPTION_NOAPPID; 
    this.option = paramSmOption;
    if (paramResultListener == null)
      return SMCAPTCHA_SDK_NOLISTENER; 
    initIntercept();
    if (paramSmOption.getMode() == null)
      paramSmOption.setMode("slide"); 
    paramSmOption.setHttps(paramSmOption.getCaptchaHtml().startsWith("https"));
    this.listener = paramResultListener;
    initStyle();
    setWebViewClient(new O000O00000OoO(this, paramSmOption));
    O0000O000000oO.O0000O000000oO(paramSmOption.getCaptchaHtml());
    reloadCaptcha();
    this.isInit = true;
    return SMCAPTCHA_SUCCESS;
  }
  
  public void loadDefaultHtml() {
    loadData(O0000O000000oO.O0000O000000oO(), "text/html", "utf-8");
  }
  
  public void reloadCaptcha() {
    loadUrl(this.option.getCaptchaHtml());
    this.retry++;
  }
  
  class O0000O000000oO extends WebChromeClient {
    O0000O000000oO(SmCaptchaWebView this$0) {}
    
    public boolean onJsAlert(WebView param1WebView, String param1String1, String param1String2, JsResult param1JsResult) {
      return super.onJsAlert(param1WebView, param1String1, param1String2, param1JsResult);
    }
    
    public boolean onJsConfirm(WebView param1WebView, String param1String1, String param1String2, JsResult param1JsResult) {
      return super.onJsConfirm(param1WebView, param1String1, param1String2, param1JsResult);
    }
    
    public boolean onJsPrompt(WebView param1WebView, String param1String1, String param1String2, String param1String3, JsPromptResult param1JsPromptResult) {
      return super.onJsPrompt(param1WebView, param1String1, param1String2, param1String3, param1JsPromptResult);
    }
  }
  
  class O000O00000OoO extends WebViewClient {
    private Timer O0000O000000oO = new Timer();
    
    private Handler O000O00000OoO = new O0000O000000oO(this);
    
    O000O00000OoO(SmCaptchaWebView this$0, SmCaptchaWebView.SmOption param1SmOption) {}
    
    private void O0000O000000oO(TimerTask param1TimerTask, long param1Long1, long param1Long2) {
      Timer timer = this.O0000O000000oO;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Timer}, name=null} */
      try {
        this.O0000O000000oO.schedule(param1TimerTask, param1Long1, param1Long2);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("safe time schedule:");
        stringBuilder.append(exception.getMessage());
        stringBuilder.toString();
      } finally {}
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Timer}, name=null} */
    }
    
    private void O000O00000OoO() {
      Timer timer = this.O0000O000000oO;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Timer}, name=null} */
      try {
        this.O0000O000000oO.cancel();
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("safe time cancel:");
        stringBuilder.append(exception.getMessage());
        stringBuilder.toString();
      } finally {
        Exception exception;
      } 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Timer}, name=null} */
    }
    
    public void O0000O000000oO() {
      if (this.O000O00000oO.retry < this.O000O00000o0O.getRetry()) {
        this.O000O00000oO.loadUrl("about:blank");
        this.O000O00000oO.reloadCaptcha();
        return;
      } 
      this.O000O00000oO.loadDefaultHtml();
      this.O000O00000oO.onError(SmCaptchaWebView.SMCAPTCHA_WV_NETWORK_ERROR);
    }
    
    public void onPageFinished(WebView param1WebView, String param1String) {
      super.onPageFinished(param1WebView, param1String);
      O000O00000OoO();
    }
    
    public void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
      if (this.O000O00000oO.compatHijackUrl == null || !this.O000O00000oO.compatHijackUrl.equals(param1String)) {
        SmCaptchaWebView.access$102(this.O000O00000oO, null);
        super.onPageStarted(param1WebView, param1String, param1Bitmap);
      } 
      O0000O000000oO(new O000O00000OoO(this), this.O000O00000o0O.getTimeout(), 1L);
    }
    
    public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
      super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
      if (this.O000O00000o0O.getCaptchaHtml().equals(param1String2) || param1String2.contains("fengkongcloud.com")) {
        O0000O000000oO();
        return;
      } 
      this.O000O00000oO.onError(SmCaptchaWebView.SMCAPTCHA_WV_NETWORK_ERROR);
      this.O000O00000oO.loadUrl("about:blank");
    }
    
    public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
      super.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
      if (Build.VERSION.SDK_INT >= 21) {
        String str = param1WebResourceRequest.getUrl().toString();
        if (this.O000O00000o0O.getCaptchaHtml().equals(str) || str.contains("fengkongcloud.com")) {
          O0000O000000oO();
          return;
        } 
      } 
      this.O000O00000oO.onError(SmCaptchaWebView.SMCAPTCHA_WV_NETWORK_ERROR);
      this.O000O00000oO.loadUrl("about:blank");
    }
    
    public void onReceivedHttpError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceResponse param1WebResourceResponse) {
      super.onReceivedHttpError(param1WebView, param1WebResourceRequest, param1WebResourceResponse);
      if (Build.VERSION.SDK_INT >= 21) {
        String str = param1WebResourceRequest.getUrl().toString();
        if (this.O000O00000o0O.getCaptchaHtml().equals(str) || str.contains("fengkongcloud.com")) {
          O0000O000000oO();
          return;
        } 
        this.O000O00000oO.loadUrl("about:blank");
        this.O000O00000oO.onError(SmCaptchaWebView.SMCAPTCHA_WV_NETWORK_ERROR);
        return;
      } 
    }
    
    public void onReceivedSslError(WebView param1WebView, SslErrorHandler param1SslErrorHandler, SslError param1SslError) {
      param1SslErrorHandler.cancel();
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView param1WebView, WebResourceRequest param1WebResourceRequest) {
      if (Build.VERSION.SDK_INT >= 21) {
        String str = param1WebResourceRequest.getUrl().toString();
        if (this.O000O00000oO.shouldIntercept(str)) {
          WebResourceResponse webResourceResponse = SmCaptcha.O000O00000OoO(str);
          if (webResourceResponse != null)
            return webResourceResponse; 
        } 
      } 
      return super.shouldInterceptRequest(param1WebView, param1WebResourceRequest);
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView param1WebView, String param1String) {
      if (this.O000O00000oO.shouldIntercept(param1String)) {
        WebResourceResponse webResourceResponse = SmCaptcha.O000O00000OoO(param1String);
        if (webResourceResponse != null)
          return webResourceResponse; 
      } 
      return super.shouldInterceptRequest(param1WebView, param1String);
    }
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, WebResourceRequest param1WebResourceRequest) {
      return (Build.VERSION.SDK_INT >= 21 && this.O000O00000oO.dispatchPersonalSchemeUrl(param1WebView, param1WebResourceRequest.getUrl())) ? true : super.shouldOverrideUrlLoading(param1WebView, param1WebResourceRequest);
    }
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      if (this.O000O00000oO.dispatchPersonalSchemeUrl(param1WebView, Uri.parse(param1String))) {
        SmCaptchaWebView.access$102(this.O000O00000oO, param1String);
        try {
          this.O000O00000oO.stopLoading();
        } finally {}
        return true;
      } 
      return super.shouldOverrideUrlLoading(param1WebView, param1String);
    }
    
    class O0000O000000oO extends Handler {
      O0000O000000oO(SmCaptchaWebView.O000O00000OoO this$0) {}
      
      public void handleMessage(Message param2Message) {
        super.handleMessage(param2Message);
        if (param2Message.what != 1)
          return; 
        this.O0000O000000oO.O0000O000000oO();
      }
    }
    
    class O000O00000OoO extends TimerTask {
      O000O00000OoO(SmCaptchaWebView.O000O00000OoO this$0) {}
      
      public void run() {
        Message message = new Message();
        message.what = 1;
        SmCaptchaWebView.O000O00000OoO.O0000O000000oO(this.O0000O000000oO).sendMessage(message);
        SmCaptchaWebView.O000O00000OoO.O000O00000OoO(this.O0000O000000oO);
      }
    }
  }
  
  class O0000O000000oO extends Handler {
    O0000O000000oO(SmCaptchaWebView this$0) {}
    
    public void handleMessage(Message param1Message) {
      super.handleMessage(param1Message);
      if (param1Message.what != 1)
        return; 
      this.O0000O000000oO.O0000O000000oO();
    }
  }
  
  class O000O00000OoO extends TimerTask {
    O000O00000OoO(SmCaptchaWebView this$0) {}
    
    public void run() {
      Message message = new Message();
      message.what = 1;
      SmCaptchaWebView.O000O00000OoO.O0000O000000oO(this.O0000O000000oO).sendMessage(message);
      SmCaptchaWebView.O000O00000OoO.O000O00000OoO(this.O0000O000000oO);
    }
  }
  
  public static interface ResultListener {
    void onError(int param1Int);
    
    void onReady();
    
    void onSuccess(CharSequence param1CharSequence, boolean param1Boolean);
  }
  
  public static class SmOption {
    private String appId;
    
    private String captchaHtml = "https://castatic.fengkongcloud.com/pr/v1.0.3/index.html";
    
    private String cdnHost;
    
    private String channel;
    
    private String deviceId;
    
    private Map<String, String> extData;
    
    private Map<String, Object> extOption;
    
    private String host;
    
    private boolean https = true;
    
    private String mode = "slide";
    
    private String organization;
    
    private int retry = 2;
    
    private int timeout = 10000;
    
    private String tipMessage;
    
    private String getCdnCaptchaHtml() {
      try {
        String str1 = (new URL(this.captchaHtml)).getHost();
      } catch (MalformedURLException malformedURLException) {
        malformedURLException = null;
      } 
      if (TextUtils.isEmpty((CharSequence)malformedURLException))
        return this.captchaHtml; 
      String str = this.captchaHtml.replace((CharSequence)malformedURLException, this.cdnHost);
      return isHttps() ? str : str.replaceFirst("https://", "http://");
    }
    
    public String getAppId() {
      return this.appId;
    }
    
    String getCaptchaHtml() {
      return TextUtils.isEmpty(this.cdnHost) ? this.captchaHtml : getCdnCaptchaHtml();
    }
    
    public String getChannel() {
      return this.channel;
    }
    
    public String getDeviceId() {
      return this.deviceId;
    }
    
    public Map<String, String> getExtData() {
      return this.extData;
    }
    
    public Map<String, Object> getExtOption() {
      return this.extOption;
    }
    
    public String getHost() {
      return this.host;
    }
    
    public String getMode() {
      return this.mode;
    }
    
    public String getOrganization() {
      return this.organization;
    }
    
    public int getRetry() {
      return this.retry;
    }
    
    public int getTimeout() {
      return this.timeout;
    }
    
    public String getTipMessage() {
      return this.tipMessage;
    }
    
    public boolean isHttps() {
      return this.https;
    }
    
    public void setAppId(String param1String) {
      this.appId = param1String;
    }
    
    public void setCdnHost(String param1String) {
      this.cdnHost = param1String;
    }
    
    public void setChannel(String param1String) {
      this.channel = param1String;
    }
    
    public void setDeviceId(String param1String) {
      this.deviceId = param1String;
    }
    
    public void setExtData(Map<String, String> param1Map) {
      this.extData = param1Map;
    }
    
    public void setExtOption(Map<String, Object> param1Map) {
      this.extOption = param1Map;
    }
    
    public void setHost(String param1String) {
      this.host = param1String;
    }
    
    public void setHttps(boolean param1Boolean) {
      this.https = param1Boolean;
    }
    
    public void setMode(String param1String) {
      this.mode = param1String;
    }
    
    public void setOrganization(String param1String) {
      this.organization = param1String;
    }
    
    public void setRetry(int param1Int) {
      this.retry = param1Int;
    }
    
    public void setTimeout(int param1Int) {
      this.timeout = param1Int;
    }
    
    public void setTipMessage(String param1String) {
      this.tipMessage = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\sdk\captcha\SmCaptchaWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */