package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.utils.ResourceManager;

public class CommentComponentView extends FrameLayout {
  private static final String ALREADY_COMMENT_EN = "Comment";
  
  private static final String ALREADY_COMMENT_ZH_CN = "微博热评";
  
  private static final String ALREADY_COMMENT_ZH_TW = "微博熱評";
  
  private static final String COMMENT_H5 = "http://widget.weibo.com/distribution/socail_comments_sdk.php";
  
  private RequestParam mCommentParam;
  
  private LinearLayout mContentLy;
  
  public CommentComponentView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public CommentComponentView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public CommentComponentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void execAttented() {
    WbAppActivator.getInstance(getContext(), this.mCommentParam.mAppKey).activateApp();
    WidgetRequestParam widgetRequestParam = new WidgetRequestParam(getContext());
    widgetRequestParam.setUrl("http://widget.weibo.com/distribution/socail_comments_sdk.php");
    widgetRequestParam.setSpecifyTitle(ResourceManager.getString(getContext(), "Comment", "微博热评", "微博熱評"));
    widgetRequestParam.setAppKey(this.mCommentParam.mAppKey);
    widgetRequestParam.setCommentTopic(this.mCommentParam.mTopic);
    widgetRequestParam.setCommentContent(this.mCommentParam.mContent);
    widgetRequestParam.setCommentCategory(this.mCommentParam.mCategory.getValue());
    widgetRequestParam.setAuthListener(this.mCommentParam.mAuthlistener);
    widgetRequestParam.setToken(this.mCommentParam.mAccessToken);
    Bundle bundle = widgetRequestParam.createRequestParamBundle();
    Intent intent = new Intent(getContext(), WeiboSdkBrowser.class);
    intent.putExtras(bundle);
    getContext().startActivity(intent);
  }
  
  private void init(Context paramContext) {
    this.mContentLy = new LinearLayout(paramContext);
    this.mContentLy.setOrientation(0);
    this.mContentLy.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ImageView imageView = new ImageView(paramContext);
    imageView.setImageDrawable(ResourceManager.getDrawable(paramContext, "sdk_weibo_logo.png"));
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ResourceManager.dp2px(getContext(), 20), ResourceManager.dp2px(getContext(), 20));
    layoutParams2.gravity = 16;
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    TextView textView = new TextView(paramContext);
    textView.setText(ResourceManager.getString(paramContext, "Comment", "微博热评", "微博熱評"));
    textView.setTextColor(-32256);
    textView.setTextSize(2, 15.0F);
    textView.setIncludeFontPadding(false);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams1.gravity = 16;
    layoutParams1.leftMargin = ResourceManager.dp2px(getContext(), 4);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.mContentLy.addView((View)imageView);
    this.mContentLy.addView((View)textView);
    addView((View)this.mContentLy);
    textView.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            CommentComponentView.this.execAttented();
          }
        });
  }
  
  public void setCommentParam(RequestParam paramRequestParam) {
    this.mCommentParam = paramRequestParam;
  }
  
  public enum Category {
    MOVIE("1001"),
    TRAVEL("1002");
    
    private String mVal;
    
    static {
    
    }
    
    Category(String param1String1) {
      this.mVal = param1String1;
    }
    
    public String getValue() {
      return this.mVal;
    }
  }
  
  public static class RequestParam {
    private String mAccessToken;
    
    private String mAppKey;
    
    private WeiboAuthListener mAuthlistener;
    
    private CommentComponentView.Category mCategory;
    
    private String mContent;
    
    private String mTopic;
    
    public static RequestParam createRequestParam(String param1String1, String param1String2, String param1String3, CommentComponentView.Category param1Category, WeiboAuthListener param1WeiboAuthListener) {
      RequestParam requestParam = new RequestParam();
      requestParam.mAppKey = param1String1;
      requestParam.mTopic = param1String2;
      requestParam.mContent = param1String3;
      requestParam.mCategory = param1Category;
      requestParam.mAuthlistener = param1WeiboAuthListener;
      return requestParam;
    }
    
    public static RequestParam createRequestParam(String param1String1, String param1String2, String param1String3, String param1String4, CommentComponentView.Category param1Category, WeiboAuthListener param1WeiboAuthListener) {
      RequestParam requestParam = new RequestParam();
      requestParam.mAppKey = param1String1;
      requestParam.mAccessToken = param1String2;
      requestParam.mTopic = param1String3;
      requestParam.mContent = param1String4;
      requestParam.mCategory = param1Category;
      requestParam.mAuthlistener = param1WeiboAuthListener;
      return requestParam;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\view\CommentComponentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */