package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public abstract class BrowserRequestParamBase {
  public static final int EXEC_REQUEST_ACTION_CANCEL = 3;
  
  public static final int EXEC_REQUEST_ACTION_ERROR = 2;
  
  public static final int EXEC_REQUEST_ACTION_OK = 1;
  
  public static final String EXTRA_KEY_LAUNCHER = "key_launcher";
  
  protected static final String EXTRA_KEY_SPECIFY_TITLE = "key_specify_title";
  
  protected static final String EXTRA_KEY_URL = "key_url";
  
  protected Context mContext;
  
  protected BrowserLauncher mLaucher;
  
  protected String mSpecifyTitle;
  
  protected String mUrl;
  
  public BrowserRequestParamBase(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public Bundle createRequestParamBundle() {
    Bundle bundle = new Bundle();
    if (!TextUtils.isEmpty(this.mUrl))
      bundle.putString("key_url", this.mUrl); 
    BrowserLauncher browserLauncher = this.mLaucher;
    if (browserLauncher != null)
      bundle.putSerializable("key_launcher", browserLauncher); 
    if (!TextUtils.isEmpty(this.mSpecifyTitle))
      bundle.putString("key_specify_title", this.mSpecifyTitle); 
    onCreateRequestParamBundle(bundle);
    return bundle;
  }
  
  public abstract void execRequest(Activity paramActivity, int paramInt);
  
  public BrowserLauncher getLauncher() {
    return this.mLaucher;
  }
  
  public String getSpecifyTitle() {
    return this.mSpecifyTitle;
  }
  
  public String getUrl() {
    return this.mUrl;
  }
  
  protected abstract void onCreateRequestParamBundle(Bundle paramBundle);
  
  protected abstract void onSetupRequestParam(Bundle paramBundle);
  
  public void setLauncher(BrowserLauncher paramBrowserLauncher) {
    this.mLaucher = paramBrowserLauncher;
  }
  
  public void setSpecifyTitle(String paramString) {
    this.mSpecifyTitle = paramString;
  }
  
  public void setUrl(String paramString) {
    this.mUrl = paramString;
  }
  
  public void setupRequestParam(Bundle paramBundle) {
    this.mUrl = paramBundle.getString("key_url");
    this.mLaucher = (BrowserLauncher)paramBundle.getSerializable("key_launcher");
    this.mSpecifyTitle = paramBundle.getString("key_specify_title");
    onSetupRequestParam(paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\BrowserRequestParamBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */