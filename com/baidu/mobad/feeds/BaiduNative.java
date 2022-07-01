package com.baidu.mobad.feeds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.command.c.a;
import com.baidu.mobads.f.q;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.c.c;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class BaiduNative {
  private List<NativeResponse> a;
  
  private final Context b;
  
  private final String c;
  
  private c d;
  
  private BaiduNativeNetworkListener e;
  
  private NativeDownloadListener f;
  
  private BaiduNativeEventListener g;
  
  private CustomIOAdEventListener h;
  
  public BaiduNative(Context paramContext, String paramString, BaiduNativeNetworkListener paramBaiduNativeNetworkListener) {
    this(paramContext, paramString, paramBaiduNativeNetworkListener, new c(paramContext, paramString));
  }
  
  public BaiduNative(Context paramContext, String paramString, BaiduNativeNetworkListener paramBaiduNativeNetworkListener, int paramInt) {
    this(paramContext, paramString, paramBaiduNativeNetworkListener, new c(paramContext, paramString, paramInt));
  }
  
  public BaiduNative(Context paramContext, String paramString, BaiduNativeNetworkListener paramBaiduNativeNetworkListener, c paramc) {
    this.b = paramContext;
    XAdSDKFoundationFacade.getInstance().initializeApplicationContext(paramContext.getApplicationContext());
    this.c = paramString;
    this.e = paramBaiduNativeNetworkListener;
    q.a(paramContext).a();
    this.d = paramc;
  }
  
  public BaiduNative(Context paramContext, String paramString, BaiduNativeNetworkListener paramBaiduNativeNetworkListener, boolean paramBoolean) {
    this(paramContext, paramString, paramBaiduNativeNetworkListener, new c(paramContext, paramString, paramBoolean));
  }
  
  public BaiduNative(Context paramContext, String paramString, BaiduNativeNetworkListener paramBaiduNativeNetworkListener, boolean paramBoolean, int paramInt) {
    this(paramContext, paramString, paramBaiduNativeNetworkListener, new c(paramContext, paramString, paramBoolean, paramInt));
  }
  
  private int a(IXAdInstanceInfo paramIXAdInstanceInfo) {
    if (paramIXAdInstanceInfo != null)
      try {
        if (paramIXAdInstanceInfo.getActionType() == 512)
          return (new JSONObject(paramIXAdInstanceInfo.getAppOpenStrs())).optInt("fb_act"); 
      } finally {} 
    return 0;
  }
  
  public static void setAppSid(Context paramContext, String paramString) {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(paramString);
  }
  
  public void destroy() {}
  
  protected void handleClick(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, int paramInt, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.a(paramView, paramIXAdInstanceInfo, paramInt, paramIXAdFeedsRequestParameters);
  }
  
  protected void handleClick(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.b(paramView, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  protected void handleOnClickAd(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.d(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  protected void handleOnClose(Context paramContext, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.a(paramContext, paramInt, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  protected void handleOnComplete(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.c(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  protected void handleOnError(Context paramContext, int paramInt1, int paramInt2, IXAdInstanceInfo paramIXAdInstanceInfo) {
    this.d.a(paramContext, paramInt1, paramInt2, paramIXAdInstanceInfo);
  }
  
  protected void handleOnFullScreen(Context paramContext, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.b(paramContext, paramInt, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  protected void handleOnStart(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.b(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  protected boolean isAdAvailable(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    return this.d.a(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  public void makeRequest() {
    makeRequest((RequestParameters)null);
  }
  
  public void makeRequest(RequestParameters paramRequestParameters) {
    RequestParameters requestParameters = paramRequestParameters;
    if (paramRequestParameters == null)
      requestParameters = (new RequestParameters.Builder()).build(); 
    requestParameters.mPlacementId = this.c;
    this.h = new CustomIOAdEventListener(this, requestParameters);
    this.d.addEventListener("AdStarted", this.h);
    this.d.addEventListener("AdUserClick", this.h);
    this.d.addEventListener("AdError", this.h);
    this.d.addEventListener("vdieoCacheSucc", this.h);
    this.d.addEventListener("vdieoCacheFailed", this.h);
    this.d.addEventListener("AdImpression", this.h);
    this.d.addEventListener("AdStatusChange", this.h);
    this.d.a(requestParameters);
    this.d.request();
  }
  
  protected void recordImpression(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    this.d.a(paramView, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
  }
  
  public void setCacheVideoOnlyWifi(boolean paramBoolean) {
    c c1 = this.d;
    if (c1 != null)
      c1.b(paramBoolean); 
  }
  
  public void setDownloadListener(NativeDownloadListener paramNativeDownloadListener) {
    this.f = paramNativeDownloadListener;
  }
  
  @Deprecated
  public void setNativeEventListener(BaiduNativeEventListener paramBaiduNativeEventListener) {
    this.g = paramBaiduNativeEventListener;
  }
  
  public static interface BaiduNativeEventListener {
    void onClicked();
    
    void onImpressionSended();
  }
  
  public static interface BaiduNativeNetworkListener {
    void onNativeFail(NativeErrorCode param1NativeErrorCode);
    
    void onNativeLoad(List<NativeResponse> param1List);
  }
  
  class CustomIOAdEventListener implements IOAdEventListener {
    private IXAdFeedsRequestParameters b;
    
    public CustomIOAdEventListener(BaiduNative this$0, IXAdFeedsRequestParameters param1IXAdFeedsRequestParameters) {
      this.b = param1IXAdFeedsRequestParameters;
    }
    
    public void run(IOAdEvent param1IOAdEvent) {
      ArrayList arrayList;
      boolean bool1 = "AdStarted".equals(param1IOAdEvent.getType());
      byte b = 0;
      boolean bool = false;
      int i = 0;
      if (bool1) {
        if (BaiduNative.a(this.a) != null) {
          arrayList = new ArrayList();
          HashSet<String> hashSet = new HashSet();
          l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
          b = 0;
          while (true) {
            if (b < BaiduNative.b(this.a).a().size()) {
              IXAdInstanceInfo iXAdInstanceInfo = BaiduNative.b(this.a).a().get(b);
              String str = iXAdInstanceInfo.getAppPackageName();
              if (iXAdInstanceInfo.getActionType() == l.getActTypeDownload()) {
                if (str == null || str.equals("") || str.equals("null") || hashSet.contains(str)) {
                  i = 1;
                } else {
                  hashSet.add(str);
                  bool1 = XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.c(this.a), str);
                  int j = bool1 ^ true;
                  i = 0;
                } 
              } else {
                if (iXAdInstanceInfo.getActionType() == l.getActTypeOpenExternalApp() && BaiduNative.a(this.a, iXAdInstanceInfo) == l.getActTypeDownload() && !TextUtils.isEmpty(str)) {
                  bool1 = XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.c(this.a), str);
                } else {
                  i = 0;
                  bool1 = false;
                } 
                int j = bool1 ^ true;
                i = 0;
              } 
            } else {
              break;
            } 
            bool1 = false;
          } 
          BaiduNative.a(this.a, arrayList);
          XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new BaiduNative$CustomIOAdEventListener$1(this, arrayList));
          return;
        } 
      } else {
        String str;
        if ("AdError".equals(arrayList.getType())) {
          BaiduNative.b(this.a).removeAllListeners();
          str = (String)arrayList.getData().get("message");
          if (BaiduNative.a(this.a) != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new BaiduNative$CustomIOAdEventListener$2(this));
            return;
          } 
        } else {
          String str1;
          if ("AdUserClick".equals(str.getType())) {
            if (BaiduNative.a(this.a) instanceof BaiduNative.FeedLpCloseListener) {
              Map map = str.getData();
              if (map != null) {
                str1 = (String)map.get("instanceInfo");
                while (i < BaiduNative.d(this.a).size()) {
                  XAdNativeResponse xAdNativeResponse = BaiduNative.d(this.a).get(i);
                  if (xAdNativeResponse.getUniqueId().equals(str1))
                    ((BaiduNative.FeedLpCloseListener)BaiduNative.a(this.a)).onAdClick(xAdNativeResponse); 
                  i++;
                } 
              } 
            } 
            if (BaiduNative.a(this.a) instanceof BaiduNative.FeedLpCloseListener && (BaiduNative.b(this.a)).d.getActionType() == 1) {
              a.a(BaiduNative.c(this.a)).b();
              a.a(BaiduNative.c(this.a)).addEventListener("AdLpClosed", BaiduNative.e(this.a));
              return;
            } 
          } else {
            if ("AdLpClosed".equals(str1.getType()) && BaiduNative.a(this.a) instanceof BaiduNative.FeedLpCloseListener) {
              a.a(BaiduNative.c(this.a)).removeEventListeners("AdLpClosed");
              a.a(BaiduNative.c(this.a)).c();
              ((BaiduNative.FeedLpCloseListener)BaiduNative.a(this.a)).onLpClosed();
              return;
            } 
            if ("vdieoCacheSucc".equals(str1.getType())) {
              if (BaiduNative.a(this.a) instanceof BaiduNative.VideoCacheListener) {
                ((BaiduNative.VideoCacheListener)BaiduNative.a(this.a)).onVideoDownloadSuccess();
                return;
              } 
            } else if ("vdieoCacheFailed".equals(str1.getType())) {
              if (BaiduNative.a(this.a) instanceof BaiduNative.VideoCacheListener) {
                ((BaiduNative.VideoCacheListener)BaiduNative.a(this.a)).onVideoDownloadFailed();
                return;
              } 
            } else {
              String str2;
              if ("AdImpression".equals(str1.getType())) {
                if (BaiduNative.a(this.a) instanceof BaiduNative.NativeADEventListener) {
                  Map map = str1.getData();
                  if (map != null) {
                    str2 = (String)map.get("instanceInfo");
                    for (i = b; i < BaiduNative.d(this.a).size(); i++) {
                      XAdNativeResponse xAdNativeResponse = BaiduNative.d(this.a).get(i);
                      if (xAdNativeResponse.getUniqueId().equals(str2))
                        ((BaiduNative.NativeADEventListener)BaiduNative.a(this.a)).onADExposed(xAdNativeResponse); 
                    } 
                  } 
                } 
              } else if ("AdStatusChange".equals(str2.getType()) && BaiduNative.f(this.a) != null) {
                Map map = str2.getData();
                str2 = str2.getMessage();
                if (map != null && !TextUtils.isEmpty(str2))
                  for (i = bool; i < BaiduNative.d(this.a).size(); i++) {
                    XAdNativeResponse xAdNativeResponse = BaiduNative.d(this.a).get(i);
                    if (xAdNativeResponse.isDownloadApp() && str2.equals(xAdNativeResponse.getAppPackage()))
                      BaiduNative.f(this.a).onADStatusChanged(xAdNativeResponse); 
                  }  
              } 
            } 
          } 
        } 
      } 
    }
  }
  
  public static interface FeedLpCloseListener extends BaiduNativeNetworkListener {
    void onAdClick(NativeResponse param1NativeResponse);
    
    void onLpClosed();
  }
  
  public static interface NativeADEventListener extends VideoCacheListener {
    void onADExposed(NativeResponse param1NativeResponse);
  }
  
  public static interface NativeDownloadListener {
    void onADStatusChanged(NativeResponse param1NativeResponse);
  }
  
  public static interface VideoCacheListener extends FeedLpCloseListener {
    void onVideoDownloadFailed();
    
    void onVideoDownloadSuccess();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\feeds\BaiduNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */