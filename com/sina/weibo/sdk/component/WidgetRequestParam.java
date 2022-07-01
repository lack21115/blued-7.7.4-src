package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

public class WidgetRequestParam extends BrowserRequestParamBase {
  public static final String EXTRA_KEY_WIDGET_CALLBACK = "key_widget_callback";
  
  public static final String REQ_PARAM_ATTENTION_FUID = "fuid";
  
  public static final String REQ_PARAM_COMMENT_CATEGORY = "category";
  
  public static final String REQ_PARAM_COMMENT_CONTENT = "content";
  
  public static final String REQ_PARAM_COMMENT_TOPIC = "q";
  
  private String mAppKey;
  
  private String mAppPackage;
  
  private String mAttentionFuid;
  
  private WeiboAuthListener mAuthListener;
  
  private String mAuthListenerKey;
  
  private String mCommentCategory;
  
  private String mCommentContent;
  
  private String mCommentTopic;
  
  private String mHashKey;
  
  private String mToken;
  
  private WidgetRequestCallback mWidgetRequestCallback;
  
  private String mWidgetRequestCallbackKey;
  
  public WidgetRequestParam(Context paramContext) {
    super(paramContext);
  }
  
  private String buildUrl(String paramString) {
    Uri.Builder builder = Uri.parse(paramString).buildUpon();
    builder.appendQueryParameter("version", "0031405000");
    if (!TextUtils.isEmpty(this.mAppKey))
      builder.appendQueryParameter("source", this.mAppKey); 
    if (!TextUtils.isEmpty(this.mToken))
      builder.appendQueryParameter("access_token", this.mToken); 
    String str = Utility.getAid(this.mContext, this.mAppKey);
    if (!TextUtils.isEmpty(str))
      builder.appendQueryParameter("aid", str); 
    if (!TextUtils.isEmpty(this.mAppPackage))
      builder.appendQueryParameter("packagename", this.mAppPackage); 
    if (!TextUtils.isEmpty(this.mHashKey))
      builder.appendQueryParameter("key_hash", this.mHashKey); 
    if (!TextUtils.isEmpty(this.mAttentionFuid))
      builder.appendQueryParameter("fuid", this.mAttentionFuid); 
    if (!TextUtils.isEmpty(this.mCommentTopic))
      builder.appendQueryParameter("q", this.mCommentTopic); 
    if (!TextUtils.isEmpty(this.mCommentContent))
      builder.appendQueryParameter("content", this.mCommentContent); 
    if (!TextUtils.isEmpty(this.mCommentCategory))
      builder.appendQueryParameter("category", this.mCommentCategory); 
    return builder.build().toString();
  }
  
  public void execRequest(Activity paramActivity, int paramInt) {
    if (paramInt == 3)
      WeiboSdkBrowser.closeBrowser(paramActivity, this.mAuthListenerKey, this.mWidgetRequestCallbackKey); 
  }
  
  public String getAppKey() {
    return this.mAppKey;
  }
  
  public String getAttentionFuid() {
    return this.mAttentionFuid;
  }
  
  public WeiboAuthListener getAuthListener() {
    return this.mAuthListener;
  }
  
  public String getAuthListenerKey() {
    return this.mAuthListenerKey;
  }
  
  public String getCommentCategory() {
    return this.mCommentCategory;
  }
  
  public String getCommentContent() {
    return this.mCommentContent;
  }
  
  public String getCommentTopic() {
    return this.mCommentTopic;
  }
  
  public String getToken() {
    return this.mToken;
  }
  
  public WidgetRequestCallback getWidgetRequestCallback() {
    return this.mWidgetRequestCallback;
  }
  
  public String getWidgetRequestCallbackKey() {
    return this.mWidgetRequestCallbackKey;
  }
  
  public void onCreateRequestParamBundle(Bundle paramBundle) {
    this.mAppPackage = this.mContext.getPackageName();
    if (!TextUtils.isEmpty(this.mAppPackage))
      this.mHashKey = MD5.hexdigest(Utility.getSign(this.mContext, this.mAppPackage)); 
    paramBundle.putString("access_token", this.mToken);
    paramBundle.putString("source", this.mAppKey);
    paramBundle.putString("packagename", this.mAppPackage);
    paramBundle.putString("key_hash", this.mHashKey);
    paramBundle.putString("fuid", this.mAttentionFuid);
    paramBundle.putString("q", this.mCommentTopic);
    paramBundle.putString("content", this.mCommentContent);
    paramBundle.putString("category", this.mCommentCategory);
    WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
    if (this.mAuthListener != null) {
      this.mAuthListenerKey = weiboCallbackManager.genCallbackKey();
      weiboCallbackManager.setWeiboAuthListener(this.mAuthListenerKey, this.mAuthListener);
      paramBundle.putString("key_listener", this.mAuthListenerKey);
    } 
    if (this.mWidgetRequestCallback != null) {
      this.mWidgetRequestCallbackKey = weiboCallbackManager.genCallbackKey();
      weiboCallbackManager.setWidgetRequestCallback(this.mWidgetRequestCallbackKey, this.mWidgetRequestCallback);
      paramBundle.putString("key_widget_callback", this.mWidgetRequestCallbackKey);
    } 
  }
  
  protected void onSetupRequestParam(Bundle paramBundle) {
    this.mAppKey = paramBundle.getString("source");
    this.mAppPackage = paramBundle.getString("packagename");
    this.mHashKey = paramBundle.getString("key_hash");
    this.mToken = paramBundle.getString("access_token");
    this.mAttentionFuid = paramBundle.getString("fuid");
    this.mCommentTopic = paramBundle.getString("q");
    this.mCommentContent = paramBundle.getString("content");
    this.mCommentCategory = paramBundle.getString("category");
    this.mAuthListenerKey = paramBundle.getString("key_listener");
    if (!TextUtils.isEmpty(this.mAuthListenerKey))
      this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey); 
    this.mWidgetRequestCallbackKey = paramBundle.getString("key_widget_callback");
    if (!TextUtils.isEmpty(this.mWidgetRequestCallbackKey))
      this.mWidgetRequestCallback = WeiboCallbackManager.getInstance(this.mContext).getWidgetRequestCallback(this.mWidgetRequestCallbackKey); 
    this.mUrl = buildUrl(this.mUrl);
  }
  
  public void setAppKey(String paramString) {
    this.mAppKey = paramString;
  }
  
  public void setAttentionFuid(String paramString) {
    this.mAttentionFuid = paramString;
  }
  
  public void setAuthListener(WeiboAuthListener paramWeiboAuthListener) {
    this.mAuthListener = paramWeiboAuthListener;
  }
  
  public void setCommentCategory(String paramString) {
    this.mCommentCategory = paramString;
  }
  
  public void setCommentContent(String paramString) {
    this.mCommentContent = paramString;
  }
  
  public void setCommentTopic(String paramString) {
    this.mCommentTopic = paramString;
  }
  
  public void setToken(String paramString) {
    this.mToken = paramString;
  }
  
  public void setWidgetRequestCallback(WidgetRequestCallback paramWidgetRequestCallback) {
    this.mWidgetRequestCallback = paramWidgetRequestCallback;
  }
  
  public static interface WidgetRequestCallback {
    void onWebViewResult(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\WidgetRequestParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */