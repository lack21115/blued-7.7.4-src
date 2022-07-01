package com.baidu.mobad.feeds;

import android.content.Context;
import com.baidu.mobads.f.q;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.List;

public class BaiduNativeManager implements BaiduNative.NativeADEventListener, BaiduNative.NativeDownloadListener {
  private static final String a = BaiduNativeManager.class.getSimpleName();
  
  private final Context b;
  
  private final String c;
  
  private boolean d = true;
  
  private int e = 8000;
  
  private boolean f = false;
  
  private RequestParameters g;
  
  private FeedAdListener h;
  
  public BaiduNativeManager(Context paramContext, String paramString) {
    this(paramContext, paramString, 8000);
  }
  
  public BaiduNativeManager(Context paramContext, String paramString, int paramInt) {
    this(paramContext, paramString, true, paramInt);
  }
  
  public BaiduNativeManager(Context paramContext, String paramString, boolean paramBoolean) {
    this(paramContext, paramString, paramBoolean, 8000);
  }
  
  public BaiduNativeManager(Context paramContext, String paramString, boolean paramBoolean, int paramInt) {
    this.b = paramContext;
    XAdSDKFoundationFacade.getInstance().initializeApplicationContext(paramContext.getApplicationContext());
    this.c = paramString;
    this.d = paramBoolean;
    this.e = paramInt;
    q.a(paramContext).a();
  }
  
  public void loadFeedAd(RequestParameters paramRequestParameters, FeedAdListener paramFeedAdListener) {
    this.g = paramRequestParameters;
    this.h = paramFeedAdListener;
    BaiduNative baiduNative = new BaiduNative(this.b, this.c, this, this.d, this.e);
    baiduNative.setCacheVideoOnlyWifi(this.f);
    baiduNative.setDownloadListener(this);
    baiduNative.makeRequest(paramRequestParameters);
  }
  
  public void onADExposed(NativeResponse paramNativeResponse) {
    if (paramNativeResponse instanceof XAdNativeResponse)
      ((XAdNativeResponse)paramNativeResponse).onADExposed(); 
  }
  
  public void onADStatusChanged(NativeResponse paramNativeResponse) {
    if (paramNativeResponse instanceof XAdNativeResponse)
      ((XAdNativeResponse)paramNativeResponse).onADStatusChanged(); 
  }
  
  public void onAdClick(NativeResponse paramNativeResponse) {
    if (paramNativeResponse instanceof XAdNativeResponse)
      ((XAdNativeResponse)paramNativeResponse).onAdClick(); 
  }
  
  public void onLpClosed() {
    FeedAdListener feedAdListener = this.h;
    if (feedAdListener != null)
      feedAdListener.onLpClosed(); 
  }
  
  public void onNativeFail(NativeErrorCode paramNativeErrorCode) {
    FeedAdListener feedAdListener = this.h;
    if (feedAdListener != null)
      feedAdListener.onNativeFail(paramNativeErrorCode); 
  }
  
  public void onNativeLoad(List<NativeResponse> paramList) {
    FeedAdListener feedAdListener = this.h;
    if (feedAdListener != null)
      feedAdListener.onNativeLoad(paramList); 
  }
  
  public void onVideoDownloadFailed() {
    FeedAdListener feedAdListener = this.h;
    if (feedAdListener != null)
      feedAdListener.onVideoDownloadFailed(); 
  }
  
  public void onVideoDownloadSuccess() {
    FeedAdListener feedAdListener = this.h;
    if (feedAdListener != null)
      feedAdListener.onVideoDownloadSuccess(); 
  }
  
  public void setCacheVideoOnlyWifi(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public static interface FeedAdListener {
    void onLpClosed();
    
    void onNativeFail(NativeErrorCode param1NativeErrorCode);
    
    void onNativeLoad(List<NativeResponse> param1List);
    
    void onVideoDownloadFailed();
    
    void onVideoDownloadSuccess();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\BaiduNativeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */