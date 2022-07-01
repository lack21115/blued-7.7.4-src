package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.view.LoadingBar;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;

public class WeiboSdkBrowser extends Activity implements BrowserRequestCallBack {
  public static final String BROWSER_CLOSE_SCHEME = "sinaweibo://browser/close";
  
  public static final String BROWSER_WIDGET_SCHEME = "sinaweibo://browser/datatransfer";
  
  private static final String CANCEL_EN = "Close";
  
  private static final String CANCEL_ZH_CN = "关闭";
  
  private static final String CANCEL_ZH_TW = "关闭";
  
  private static final String CHANNEL_DATA_ERROR_EN = "channel_data_error";
  
  private static final String CHANNEL_DATA_ERROR_ZH_CN = "重新加载";
  
  private static final String CHANNEL_DATA_ERROR_ZH_TW = "重新載入";
  
  private static final String EMPTY_PROMPT_BAD_NETWORK_UI_EN = "A network error occurs, please tap the button to reload";
  
  private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN = "网络出错啦，请点击按钮重新加载";
  
  private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW = "網路出錯啦，請點擊按鈕重新載入";
  
  private static final String LOADINFO_EN = "Loading....";
  
  private static final String LOADINFO_ZH_CN = "加载中....";
  
  private static final String LOADINFO_ZH_TW = "載入中....";
  
  private static final String TAG = WeiboSdkBrowser.class.getName();
  
  private static final String WEIBOBROWSER_NO_TITLE_EN = "No Title";
  
  private static final String WEIBOBROWSER_NO_TITLE_ZH_CN = "无标题";
  
  private static final String WEIBOBROWSER_NO_TITLE_ZH_TW = "無標題";
  
  private boolean isErrorPage;
  
  private Boolean isFromGame = Boolean.valueOf(false);
  
  private boolean isLoading;
  
  private String mHtmlTitle;
  
  private TextView mLeftBtn;
  
  private Button mLoadErrorRetryBtn;
  
  private LinearLayout mLoadErrorView;
  
  private LoadingBar mLoadingBar;
  
  private BrowserRequestParamBase mRequestParam;
  
  private String mSpecifyTitle;
  
  private TextView mTitleText;
  
  private String mUrl;
  
  private WebView mWebView;
  
  private WeiboWebViewClient mWeiboWebViewClient;
  
  public static void closeBrowser(Activity paramActivity, String paramString1, String paramString2) {
    WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(paramActivity.getApplicationContext());
    if (!TextUtils.isEmpty(paramString1)) {
      weiboCallbackManager.removeWeiboAuthListener(paramString1);
      paramActivity.finish();
    } 
    if (!TextUtils.isEmpty(paramString2)) {
      weiboCallbackManager.removeWidgetRequestCallback(paramString2);
      paramActivity.finish();
    } 
  }
  
  private BrowserRequestParamBase createBrowserRequestParam(Bundle paramBundle) {
    AuthRequestParam authRequestParam;
    ShareRequestParam shareRequestParam;
    WidgetRequestParam widgetRequestParam;
    this.isFromGame = Boolean.valueOf(false);
    BrowserLauncher browserLauncher = (BrowserLauncher)paramBundle.getSerializable("key_launcher");
    if (browserLauncher == BrowserLauncher.AUTH) {
      authRequestParam = new AuthRequestParam((Context)this);
      authRequestParam.setupRequestParam(paramBundle);
      installAuthWeiboWebViewClient(authRequestParam);
      return authRequestParam;
    } 
    if (authRequestParam == BrowserLauncher.SHARE) {
      shareRequestParam = new ShareRequestParam((Context)this);
      shareRequestParam.setupRequestParam(paramBundle);
      installShareWeiboWebViewClient(shareRequestParam);
      return shareRequestParam;
    } 
    if (shareRequestParam == BrowserLauncher.WIDGET) {
      widgetRequestParam = new WidgetRequestParam((Context)this);
      widgetRequestParam.setupRequestParam(paramBundle);
      installWidgetWeiboWebViewClient(widgetRequestParam);
      return widgetRequestParam;
    } 
    if (widgetRequestParam == BrowserLauncher.GAME) {
      this.isFromGame = Boolean.valueOf(true);
      GameRequestParam gameRequestParam = new GameRequestParam((Context)this);
      gameRequestParam.setupRequestParam(paramBundle);
      installWeiboWebGameClient(gameRequestParam);
      return gameRequestParam;
    } 
    return null;
  }
  
  private void handleReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    if (!paramString2.startsWith("sinaweibo")) {
      this.isErrorPage = true;
      promptError();
    } 
  }
  
  private void hiddenErrorPrompt() {
    this.mLoadErrorView.setVisibility(8);
    this.mWebView.setVisibility(0);
  }
  
  private boolean initDataFromIntent(Intent paramIntent) {
    Bundle bundle = paramIntent.getExtras();
    this.mRequestParam = createBrowserRequestParam(bundle);
    BrowserRequestParamBase browserRequestParamBase = this.mRequestParam;
    if (browserRequestParamBase != null) {
      this.mUrl = browserRequestParamBase.getUrl();
      this.mSpecifyTitle = this.mRequestParam.getSpecifyTitle();
    } else {
      String str2 = bundle.getString("key_url");
      String str1 = bundle.getString("key_specify_title");
      if (!TextUtils.isEmpty(str2) && str2.startsWith("http")) {
        this.mUrl = str2;
        this.mSpecifyTitle = str1;
      } 
    } 
    if (TextUtils.isEmpty(this.mUrl))
      return false; 
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder("LOAD URL : ");
    stringBuilder.append(this.mUrl);
    LogUtil.d(str, stringBuilder.toString());
    return true;
  }
  
  private View initTitleBar() {
    RelativeLayout relativeLayout = new RelativeLayout((Context)this);
    relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, ResourceManager.dp2px((Context)this, 45)));
    relativeLayout.setBackgroundDrawable(ResourceManager.getNinePatchDrawable((Context)this, "weibosdk_navigationbar_background.9.png"));
    this.mLeftBtn = new TextView((Context)this);
    this.mLeftBtn.setClickable(true);
    this.mLeftBtn.setTextSize(2, 17.0F);
    this.mLeftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 1728020992));
    this.mLeftBtn.setText(ResourceManager.getString((Context)this, "Close", "关闭", "关闭"));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(5);
    layoutParams.addRule(15);
    layoutParams.leftMargin = ResourceManager.dp2px((Context)this, 10);
    layoutParams.rightMargin = ResourceManager.dp2px((Context)this, 10);
    this.mLeftBtn.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    relativeLayout.addView((View)this.mLeftBtn);
    this.mTitleText = new TextView((Context)this);
    this.mTitleText.setTextSize(2, 18.0F);
    this.mTitleText.setTextColor(-11382190);
    this.mTitleText.setEllipsize(TextUtils.TruncateAt.END);
    this.mTitleText.setSingleLine(true);
    this.mTitleText.setGravity(17);
    this.mTitleText.setMaxWidth(ResourceManager.dp2px((Context)this, 160));
    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(13);
    this.mTitleText.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    relativeLayout.addView((View)this.mTitleText);
    return (View)relativeLayout;
  }
  
  private void initWebView() {
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    if (isWeiboShareRequestParam(this.mRequestParam))
      this.mWebView.getSettings().setUserAgentString(Utility.generateUA((Context)this)); 
    this.mWebView.getSettings().setSavePassword(false);
    this.mWebView.setWebViewClient(this.mWeiboWebViewClient);
    this.mWebView.setWebChromeClient(new WeiboChromeClient(null));
    this.mWebView.requestFocus();
    this.mWebView.setScrollBarStyle(0);
    if (Build.VERSION.SDK_INT >= 11) {
      this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      return;
    } 
    removeJavascriptInterface(this.mWebView);
  }
  
  private void installAuthWeiboWebViewClient(AuthRequestParam paramAuthRequestParam) {
    this.mWeiboWebViewClient = new AuthWeiboWebViewClient(this, paramAuthRequestParam);
    this.mWeiboWebViewClient.setBrowserRequestCallBack(this);
  }
  
  private void installShareWeiboWebViewClient(ShareRequestParam paramShareRequestParam) {
    ShareWeiboWebViewClient shareWeiboWebViewClient = new ShareWeiboWebViewClient(this, paramShareRequestParam);
    shareWeiboWebViewClient.setBrowserRequestCallBack(this);
    this.mWeiboWebViewClient = shareWeiboWebViewClient;
  }
  
  private void installWeiboWebGameClient(GameRequestParam paramGameRequestParam) {
    WeiboGameClient weiboGameClient = new WeiboGameClient(this, paramGameRequestParam);
    weiboGameClient.setBrowserRequestCallBack(this);
    this.mWeiboWebViewClient = weiboGameClient;
  }
  
  private void installWidgetWeiboWebViewClient(WidgetRequestParam paramWidgetRequestParam) {
    WidgetWeiboWebViewClient widgetWeiboWebViewClient = new WidgetWeiboWebViewClient(this, paramWidgetRequestParam);
    widgetWeiboWebViewClient.setBrowserRequestCallBack(this);
    this.mWeiboWebViewClient = widgetWeiboWebViewClient;
  }
  
  private boolean isWeiboCustomScheme(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ("sinaweibo".equalsIgnoreCase(Uri.parse(paramString).getAuthority()));
  }
  
  private boolean isWeiboShareRequestParam(BrowserRequestParamBase paramBrowserRequestParamBase) {
    return (paramBrowserRequestParamBase != null && paramBrowserRequestParamBase.getLauncher() == BrowserLauncher.SHARE);
  }
  
  private void openUrl(String paramString) {
    this.mWebView.loadUrl(paramString);
  }
  
  private void promptError() {
    this.mLoadErrorView.setVisibility(0);
    this.mWebView.setVisibility(8);
  }
  
  private void setContentView() {
    RelativeLayout relativeLayout = new RelativeLayout((Context)this);
    relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    relativeLayout.setBackgroundColor(-1);
    LinearLayout linearLayout = new LinearLayout((Context)this);
    linearLayout.setId(1);
    linearLayout.setOrientation(1);
    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    View view = initTitleBar();
    TextView textView2 = new TextView((Context)this);
    textView2.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 2)));
    textView2.setBackgroundDrawable(ResourceManager.getNinePatchDrawable((Context)this, "weibosdk_common_shadow_top.9.png"));
    this.mLoadingBar = new LoadingBar((Context)this);
    this.mLoadingBar.setBackgroundColor(0);
    this.mLoadingBar.drawProgress(0);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, ResourceManager.dp2px((Context)this, 3));
    this.mLoadingBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    linearLayout.addView(view);
    linearLayout.addView((View)textView2);
    linearLayout.addView((View)this.mLoadingBar);
    this.mWebView = new WebView((Context)this);
    this.mWebView.setBackgroundColor(-1);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams.addRule(3, 1);
    this.mWebView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.mLoadErrorView = new LinearLayout((Context)this);
    this.mLoadErrorView.setVisibility(8);
    this.mLoadErrorView.setOrientation(1);
    this.mLoadErrorView.setGravity(17);
    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams.addRule(3, 1);
    this.mLoadErrorView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageView imageView = new ImageView((Context)this);
    imageView.setImageDrawable(ResourceManager.getDrawable((Context)this, "weibosdk_empty_failed.png"));
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    int i = ResourceManager.dp2px((Context)this, 8);
    layoutParams2.bottomMargin = i;
    layoutParams2.rightMargin = i;
    layoutParams2.topMargin = i;
    layoutParams2.leftMargin = i;
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.mLoadErrorView.addView((View)imageView);
    TextView textView1 = new TextView((Context)this);
    textView1.setGravity(1);
    textView1.setTextColor(-4342339);
    textView1.setTextSize(2, 14.0F);
    textView1.setText(ResourceManager.getString((Context)this, "A network error occurs, please tap the button to reload", "网络出错啦，请点击按钮重新加载", "網路出錯啦，請點擊按鈕重新載入"));
    textView1.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    this.mLoadErrorView.addView((View)textView1);
    this.mLoadErrorRetryBtn = new Button((Context)this);
    this.mLoadErrorRetryBtn.setGravity(17);
    this.mLoadErrorRetryBtn.setTextColor(-8882056);
    this.mLoadErrorRetryBtn.setTextSize(2, 16.0F);
    this.mLoadErrorRetryBtn.setText(ResourceManager.getString((Context)this, "channel_data_error", "重新加载", "重新載入"));
    this.mLoadErrorRetryBtn.setBackgroundDrawable((Drawable)ResourceManager.createStateListDrawable((Context)this, "weibosdk_common_button_alpha.9.png", "weibosdk_common_button_alpha_highlighted.9.png"));
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ResourceManager.dp2px((Context)this, 142), ResourceManager.dp2px((Context)this, 46));
    layoutParams1.topMargin = ResourceManager.dp2px((Context)this, 10);
    this.mLoadErrorRetryBtn.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.mLoadErrorRetryBtn.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            WeiboSdkBrowser weiboSdkBrowser = WeiboSdkBrowser.this;
            weiboSdkBrowser.openUrl(weiboSdkBrowser.mUrl);
            WeiboSdkBrowser.this.isErrorPage = false;
          }
        });
    this.mLoadErrorView.addView((View)this.mLoadErrorRetryBtn);
    relativeLayout.addView((View)linearLayout);
    relativeLayout.addView((View)this.mWebView);
    relativeLayout.addView((View)this.mLoadErrorView);
    setContentView((View)relativeLayout);
    setTopNavTitle();
  }
  
  private void setTopNavTitle() {
    this.mTitleText.setText(this.mSpecifyTitle);
    this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            if (WeiboSdkBrowser.this.mRequestParam != null)
              WeiboSdkBrowser.this.mRequestParam.execRequest(WeiboSdkBrowser.this, 3); 
            WeiboSdkBrowser.this.finish();
          }
        });
  }
  
  private void setViewLoading() {
    this.mTitleText.setText(ResourceManager.getString((Context)this, "Loading....", "加载中....", "載入中...."));
    this.mLoadingBar.setVisibility(0);
  }
  
  private void setViewNormal() {
    updateTitleName();
    this.mLoadingBar.setVisibility(8);
  }
  
  public static void startAuth(Context paramContext, String paramString, AuthInfo paramAuthInfo, WeiboAuthListener paramWeiboAuthListener) {
    AuthRequestParam authRequestParam = new AuthRequestParam(paramContext);
    authRequestParam.setLauncher(BrowserLauncher.AUTH);
    authRequestParam.setUrl(paramString);
    authRequestParam.setAuthInfo(paramAuthInfo);
    authRequestParam.setAuthListener(paramWeiboAuthListener);
    Intent intent = new Intent(paramContext, WeiboSdkBrowser.class);
    intent.putExtras(authRequestParam.createRequestParamBundle());
    paramContext.startActivity(intent);
  }
  
  private void startShare() {
    LogUtil.d(TAG, "Enter startShare()............");
    final ShareRequestParam req = (ShareRequestParam)this.mRequestParam;
    if (shareRequestParam.hasImage()) {
      LogUtil.d(TAG, "loadUrl hasImage............");
      WeiboParameters weiboParameters = shareRequestParam.buildUploadPicParam(new WeiboParameters(shareRequestParam.getAppKey()));
      (new AsyncWeiboRunner((Context)this)).requestAsync("http://service.weibo.com/share/mobilesdk_uppic.php", weiboParameters, "POST", new RequestListener() {
            public void onComplete(String param1String) {
              String str = WeiboSdkBrowser.TAG;
              StringBuilder stringBuilder = new StringBuilder("post onComplete : ");
              stringBuilder.append(param1String);
              LogUtil.d(str, stringBuilder.toString());
              ShareRequestParam.UploadPicResult uploadPicResult = ShareRequestParam.UploadPicResult.parse(param1String);
              if (uploadPicResult != null && uploadPicResult.getCode() == 1 && !TextUtils.isEmpty(uploadPicResult.getPicId())) {
                WeiboSdkBrowser.this.openUrl(req.buildUrl(uploadPicResult.getPicId()));
                return;
              } 
              req.sendSdkErrorResponse(WeiboSdkBrowser.this, "upload pic faild");
              WeiboSdkBrowser.this.finish();
            }
            
            public void onWeiboException(WeiboException param1WeiboException) {
              String str = WeiboSdkBrowser.TAG;
              StringBuilder stringBuilder = new StringBuilder("post onWeiboException ");
              stringBuilder.append(param1WeiboException.getMessage());
              LogUtil.d(str, stringBuilder.toString());
              req.sendSdkErrorResponse(WeiboSdkBrowser.this, param1WeiboException.getMessage());
              WeiboSdkBrowser.this.finish();
            }
          });
      return;
    } 
    openUrl(this.mUrl);
  }
  
  public static void startShared(Context paramContext, String paramString, AuthInfo paramAuthInfo, WeiboAuthListener paramWeiboAuthListener) {}
  
  private void updateTitleName() {
    String str;
    if (!TextUtils.isEmpty(this.mHtmlTitle)) {
      str = this.mHtmlTitle;
    } else if (!TextUtils.isEmpty(this.mSpecifyTitle)) {
      str = this.mSpecifyTitle;
    } else {
      str = "";
    } 
    this.mTitleText.setText(str);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (!initDataFromIntent(getIntent())) {
      finish();
      return;
    } 
    setContentView();
    initWebView();
    if (isWeiboShareRequestParam(this.mRequestParam)) {
      startShare();
      return;
    } 
    openUrl(this.mUrl);
  }
  
  protected void onDestroy() {
    NetworkHelper.clearCookies((Context)this);
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    BrowserRequestParamBase browserRequestParamBase;
    if (paramInt == 4) {
      browserRequestParamBase = this.mRequestParam;
      if (browserRequestParamBase != null)
        browserRequestParamBase.execRequest(this, 3); 
      finish();
      return true;
    } 
    return super.onKeyUp(paramInt, (KeyEvent)browserRequestParamBase);
  }
  
  public void onPageFinishedCallBack(WebView paramWebView, String paramString) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder("onPageFinished URL: ");
    stringBuilder.append(paramString);
    LogUtil.d(str, stringBuilder.toString());
    if (this.isErrorPage) {
      promptError();
      return;
    } 
    this.isErrorPage = false;
    hiddenErrorPrompt();
  }
  
  public void onPageStartedCallBack(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder("onPageStarted URL: ");
    stringBuilder.append(paramString);
    LogUtil.d(str, stringBuilder.toString());
    this.mUrl = paramString;
    if (!isWeiboCustomScheme(paramString))
      this.mHtmlTitle = ""; 
  }
  
  public void onReceivedErrorCallBack(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder("onReceivedError: errorCode = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", description = ");
    stringBuilder.append(paramString1);
    stringBuilder.append(", failingUrl = ");
    stringBuilder.append(paramString2);
    LogUtil.d(str, stringBuilder.toString());
    handleReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedSslErrorCallBack(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    LogUtil.d(TAG, "onReceivedSslErrorCallBack.........");
  }
  
  protected void onResume() {
    super.onResume();
  }
  
  protected void refreshAllViews() {
    if (this.isLoading) {
      setViewLoading();
      return;
    } 
    setViewNormal();
  }
  
  public void removeJavascriptInterface(WebView paramWebView) {
    if (Build.VERSION.SDK_INT < 11)
      try {
        paramWebView.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
        return;
      } catch (Exception exception) {
        LogUtil.e(TAG, exception.toString());
      }  
  }
  
  public boolean shouldOverrideUrlLoadingCallBack(WebView paramWebView, String paramString) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder("shouldOverrideUrlLoading URL: ");
    stringBuilder.append(paramString);
    LogUtil.i(str, stringBuilder.toString());
    return false;
  }
  
  class WeiboChromeClient extends WebChromeClient {
    private WeiboChromeClient() {}
    
    public void onProgressChanged(WebView param1WebView, int param1Int) {
      WeiboSdkBrowser.this.mLoadingBar.drawProgress(param1Int);
      if (param1Int == 100) {
        WeiboSdkBrowser.this.isLoading = false;
        WeiboSdkBrowser.this.refreshAllViews();
        return;
      } 
      if (!WeiboSdkBrowser.this.isLoading) {
        WeiboSdkBrowser.this.isLoading = true;
        WeiboSdkBrowser.this.refreshAllViews();
      } 
    }
    
    public void onReceivedTitle(WebView param1WebView, String param1String) {
      WeiboSdkBrowser weiboSdkBrowser = WeiboSdkBrowser.this;
      if (!weiboSdkBrowser.isWeiboCustomScheme(weiboSdkBrowser.mUrl) && !WeiboSdkBrowser.this.isFromGame.booleanValue()) {
        WeiboSdkBrowser.this.mHtmlTitle = param1String;
        WeiboSdkBrowser.this.updateTitleName();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\WeiboSdkBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */