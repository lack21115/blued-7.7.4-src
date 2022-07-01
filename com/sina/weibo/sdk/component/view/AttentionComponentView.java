package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

public class AttentionComponentView extends FrameLayout {
  private static final String ALREADY_ATTEND_EN = "Following";
  
  private static final String ALREADY_ATTEND_ZH_CN = "已关注";
  
  private static final String ALREADY_ATTEND_ZH_TW = "已關注";
  
  private static final String ATTEND_EN = "Follow";
  
  private static final String ATTEND_ZH_CN = "关注";
  
  private static final String ATTEND_ZH_TW = "關注";
  
  private static final String ATTENTION_H5 = "http://widget.weibo.com/relationship/followsdk.php";
  
  private static final String FRIENDSHIPS_SHOW_URL = "https://api.weibo.com/2/friendships/show.json";
  
  private static final String TAG = AttentionComponentView.class.getName();
  
  private FrameLayout flButton;
  
  private RequestParam mAttentionParam;
  
  private TextView mButton;
  
  private volatile boolean mIsLoadingState = false;
  
  private ProgressBar pbLoading;
  
  public AttentionComponentView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public AttentionComponentView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AttentionComponentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void execAttented() {
    WidgetRequestParam widgetRequestParam = new WidgetRequestParam(getContext());
    widgetRequestParam.setUrl("http://widget.weibo.com/relationship/followsdk.php");
    widgetRequestParam.setSpecifyTitle(ResourceManager.getString(getContext(), "Follow", "关注", "關注"));
    widgetRequestParam.setAppKey(this.mAttentionParam.mAppKey);
    widgetRequestParam.setAttentionFuid(this.mAttentionParam.mAttentionUid);
    widgetRequestParam.setAuthListener(this.mAttentionParam.mAuthlistener);
    widgetRequestParam.setToken(this.mAttentionParam.mAccessToken);
    widgetRequestParam.setWidgetRequestCallback(new WidgetRequestParam.WidgetRequestCallback() {
          public void onWebViewResult(String param1String) {
            param1String = Utility.parseUri(param1String).getString("result");
            if (!TextUtils.isEmpty(param1String))
              try {
                long l = Integer.parseInt(param1String);
                if (l == 1L) {
                  AttentionComponentView.this.showFollowButton(true);
                  return;
                } 
                if (l == 0L)
                  AttentionComponentView.this.showFollowButton(false); 
                return;
              } catch (NumberFormatException numberFormatException) {
                return;
              }  
          }
        });
    Bundle bundle = widgetRequestParam.createRequestParamBundle();
    Intent intent = new Intent(getContext(), WeiboSdkBrowser.class);
    intent.putExtras(bundle);
    getContext().startActivity(intent);
  }
  
  private void init(Context paramContext) {
    StateListDrawable stateListDrawable = ResourceManager.createStateListDrawable(paramContext, "common_button_white.9.png", "common_button_white_highlighted.9.png");
    this.flButton = new FrameLayout(paramContext);
    this.flButton.setBackgroundDrawable((Drawable)stateListDrawable);
    int i = ResourceManager.dp2px(getContext(), 6);
    int j = ResourceManager.dp2px(getContext(), 2);
    int k = ResourceManager.dp2px(getContext(), 6);
    this.flButton.setPadding(0, i, j, k);
    this.flButton.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(ResourceManager.dp2px(getContext(), 66), -2));
    addView((View)this.flButton);
    this.mButton = new TextView(getContext());
    this.mButton.setIncludeFontPadding(false);
    this.mButton.setSingleLine(true);
    this.mButton.setTextSize(2, 13.0F);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 17;
    this.mButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.flButton.addView((View)this.mButton);
    this.pbLoading = new ProgressBar(getContext(), null, 16842873);
    this.pbLoading.setVisibility(8);
    layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 17;
    this.pbLoading.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.flButton.addView((View)this.pbLoading);
    this.flButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            AttentionComponentView.this.execAttented();
          }
        });
    showFollowButton(false);
  }
  
  private void loadAttentionState(RequestParam paramRequestParam) {
    if (this.mIsLoadingState)
      return; 
    WbAppActivator.getInstance(getContext(), paramRequestParam.mAppKey).activateApp();
    this.mIsLoadingState = true;
    startLoading();
    WeiboParameters weiboParameters = new WeiboParameters(paramRequestParam.mAppKey);
    weiboParameters.put("access_token", paramRequestParam.mAccessToken);
    weiboParameters.put("target_id", paramRequestParam.mAttentionUid);
    weiboParameters.put("target_screen_name", paramRequestParam.mAttentionScreenName);
    NetUtils.internalHttpRequest(getContext(), "https://api.weibo.com/2/friendships/show.json", weiboParameters, "GET", new RequestListener() {
          public void onComplete(String param1String) {
            String str = AttentionComponentView.TAG;
            StringBuilder stringBuilder = new StringBuilder("json : ");
            stringBuilder.append(param1String);
            LogUtil.d(str, stringBuilder.toString());
            try {
              final JSONObject target = (new JSONObject(param1String)).optJSONObject("target");
              AttentionComponentView.this.getHandler().post(new Runnable() {
                    public void run() {
                      if (target != null)
                        AttentionComponentView.null.access$0(AttentionComponentView.null.this).showFollowButton(target.optBoolean("followed_by", false)); 
                      (AttentionComponentView.null.access$0(AttentionComponentView.null.this)).mIsLoadingState = false;
                    }
                  });
              return;
            } catch (JSONException jSONException) {
              return;
            } 
          }
          
          public void onWeiboException(WeiboException param1WeiboException) {
            String str = AttentionComponentView.TAG;
            StringBuilder stringBuilder = new StringBuilder("error : ");
            stringBuilder.append(param1WeiboException.getMessage());
            LogUtil.d(str, stringBuilder.toString());
            AttentionComponentView.this.mIsLoadingState = false;
          }
        });
  }
  
  private void requestAsync(Context paramContext, String paramString1, WeiboParameters paramWeiboParameters, String paramString2, RequestListener paramRequestListener) {
    NetUtils.internalHttpRequest(paramContext, paramString1, paramWeiboParameters, paramString2, paramRequestListener);
  }
  
  private void showFollowButton(boolean paramBoolean) {
    stopLoading();
    if (paramBoolean) {
      this.mButton.setText(ResourceManager.getString(getContext(), "Following", "已关注", "已關注"));
      this.mButton.setTextColor(-13421773);
      Drawable drawable1 = ResourceManager.getDrawable(getContext(), "timeline_relationship_icon_attention.png");
      this.mButton.setCompoundDrawablesWithIntrinsicBounds(drawable1, null, null, null);
      this.flButton.setEnabled(false);
      return;
    } 
    this.mButton.setText(ResourceManager.getString(getContext(), "Follow", "关注", "關注"));
    this.mButton.setTextColor(-32256);
    Drawable drawable = ResourceManager.getDrawable(getContext(), "timeline_relationship_icon_addattention.png");
    this.mButton.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    this.flButton.setEnabled(true);
  }
  
  private void startLoading() {
    this.flButton.setEnabled(false);
    this.mButton.setVisibility(8);
    this.pbLoading.setVisibility(0);
  }
  
  private void stopLoading() {
    this.flButton.setEnabled(true);
    this.mButton.setVisibility(0);
    this.pbLoading.setVisibility(8);
  }
  
  public void setAttentionParam(RequestParam paramRequestParam) {
    this.mAttentionParam = paramRequestParam;
    if (paramRequestParam.hasAuthoriz())
      loadAttentionState(paramRequestParam); 
  }
  
  public static class RequestParam {
    private String mAccessToken;
    
    private String mAppKey;
    
    private String mAttentionScreenName;
    
    private String mAttentionUid;
    
    private WeiboAuthListener mAuthlistener;
    
    public static RequestParam createRequestParam(String param1String1, String param1String2, String param1String3, WeiboAuthListener param1WeiboAuthListener) {
      RequestParam requestParam = new RequestParam();
      requestParam.mAppKey = param1String1;
      requestParam.mAttentionUid = param1String2;
      requestParam.mAttentionScreenName = param1String3;
      requestParam.mAuthlistener = param1WeiboAuthListener;
      return requestParam;
    }
    
    public static RequestParam createRequestParam(String param1String1, String param1String2, String param1String3, String param1String4, WeiboAuthListener param1WeiboAuthListener) {
      RequestParam requestParam = new RequestParam();
      requestParam.mAppKey = param1String1;
      requestParam.mAccessToken = param1String2;
      requestParam.mAttentionUid = param1String3;
      requestParam.mAttentionScreenName = param1String4;
      requestParam.mAuthlistener = param1WeiboAuthListener;
      return requestParam;
    }
    
    private boolean hasAuthoriz() {
      return !TextUtils.isEmpty(this.mAccessToken);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\view\AttentionComponentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */