package com.baidu.mobads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.c.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class BaiduNativeH5AdView extends RelativeLayout {
  IOAdEventListener a = new h(this);
  
  private BaiduNativeAdPlacement b;
  
  private a c;
  
  private BaiduNativeH5EventListner d = null;
  
  private RequestParameters e;
  
  private boolean f = false;
  
  private boolean g = false;
  
  public BaiduNativeH5AdView(Context paramContext, int paramInt) {
    super(paramContext);
    a(paramContext, paramInt);
  }
  
  public BaiduNativeH5AdView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, 0);
  }
  
  public BaiduNativeH5AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, 0);
  }
  
  private void a() {
    a a1 = this.c;
    if (a1 != null)
      a1.a(); 
  }
  
  private void a(Context paramContext, int paramInt) {
    if (paramInt != 0)
      setBackgroundResource(paramInt); 
  }
  
  private void b() {
    a();
    a a1 = this.c;
    if (a1 != null)
      a1.r(); 
  }
  
  public BaiduNativeAdPlacement getAdPlacement() {
    return this.b;
  }
  
  public boolean isAdDataLoaded() {
    return this.g;
  }
  
  public void makeRequest(RequestParameters paramRequestParameters) {
    BaiduNativeAdPlacement baiduNativeAdPlacement2 = this.b;
    if (baiduNativeAdPlacement2 != null)
      if (baiduNativeAdPlacement2.hasValidResponse()) {
        if (this.f)
          return; 
      } else {
        this.f = false;
        if (this.b.getRequestStarted())
          return; 
        this.b.setRequestStarted(true);
      }  
    RequestParameters requestParameters = paramRequestParameters;
    if (paramRequestParameters == null)
      requestParameters = (new RequestParameters.Builder()).build(); 
    this.e = requestParameters;
    if (this.c != null)
      b(); 
    this.c = new a(getContext(), this);
    this.c.a(requestParameters);
    this.c.addEventListener("AdError", this.a);
    this.c.addEventListener("AdStarted", this.a);
    this.c.addEventListener("AdUserClick", this.a);
    this.c.addEventListener("AdImpression", this.a);
    this.c.addEventListener("AdLoadData", this.a);
    BaiduNativeAdPlacement baiduNativeAdPlacement1 = this.b;
    if (baiduNativeAdPlacement1 != null && baiduNativeAdPlacement1.getAdResponse() != null)
      this.c.setAdResponseInfo(this.b.getAdResponse()); 
    this.c.a(this.b.getSessionId());
    this.c.c(this.b.getPosistionId());
    this.c.d(this.b.getSequenceId());
    this.c.request();
  }
  
  public void recordImpression() {
    BaiduNativeAdPlacement baiduNativeAdPlacement = this.b;
    if (baiduNativeAdPlacement != null && baiduNativeAdPlacement.getAdResponse() != null && !this.b.isWinSended())
      this.c.a((View)this, this.b.getAdResponse().getPrimaryAdInstanceInfo(), (IXAdFeedsRequestParameters)this.e); 
  }
  
  public void setAdPlacement(BaiduNativeAdPlacement paramBaiduNativeAdPlacement) {
    this.b = paramBaiduNativeAdPlacement;
  }
  
  public void setAdPlacementData(Object paramObject) {
    BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
    baiduNativeAdPlacement.setApId((String)q.a(paramObject, "getApId", new Class[0], new Object[0]));
    paramObject = q.a(paramObject, "getAppSid", new Class[0], new Object[0]);
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId((String)paramObject);
    this.b = baiduNativeAdPlacement;
  }
  
  public void setEventListener(BaiduNativeH5EventListner paramBaiduNativeH5EventListner) {
    this.d = paramBaiduNativeH5EventListner;
  }
  
  public static interface BaiduNativeH5EventListner {
    void onAdClick();
    
    void onAdDataLoaded();
    
    void onAdFail(String param1String);
    
    void onAdShow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\BaiduNativeH5AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */