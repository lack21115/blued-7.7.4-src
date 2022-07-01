package com.baidu.mobads;

import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.lang.ref.WeakReference;

public class BaiduNativeAdPlacement {
  private String a;
  
  private IXAdResponseInfo b;
  
  private boolean c;
  
  private boolean d;
  
  private boolean e = false;
  
  private WeakReference<BaiduNativeH5AdView> f = null;
  
  private int g = 0;
  
  private int h = 1;
  
  private int i = 1;
  
  public static void setAppSid(String paramString) {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(paramString);
  }
  
  protected IXAdResponseInfo getAdResponse() {
    return this.b;
  }
  
  public BaiduNativeH5AdView getAdView() {
    WeakReference<BaiduNativeH5AdView> weakReference = this.f;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public String getApId() {
    return this.a;
  }
  
  protected int getPosistionId() {
    return this.h;
  }
  
  protected boolean getRequestStarted() {
    return this.e;
  }
  
  protected int getSequenceId() {
    return this.i;
  }
  
  protected int getSessionId() {
    return this.g;
  }
  
  public boolean hasValidResponse() {
    return (this.b != null && isAdAvailable());
  }
  
  protected boolean isAdAvailable() {
    boolean bool;
    IXAdResponseInfo iXAdResponseInfo = this.b;
    if (iXAdResponseInfo != null && iXAdResponseInfo.getPrimaryAdInstanceInfo() != null && System.currentTimeMillis() - this.b.getPrimaryAdInstanceInfo().getCreateTime() <= 1800000L) {
      bool = true;
    } else {
      bool = false;
    } 
    return (bool && !this.c);
  }
  
  public boolean isAdDataLoaded() {
    BaiduNativeH5AdView baiduNativeH5AdView = getAdView();
    return (baiduNativeH5AdView != null) ? baiduNativeH5AdView.isAdDataLoaded() : false;
  }
  
  protected boolean isWinSended() {
    return this.d;
  }
  
  public void setAdResponse(IXAdResponseInfo paramIXAdResponseInfo) {
    this.d = false;
    this.b = paramIXAdResponseInfo;
  }
  
  public void setAdView(BaiduNativeH5AdView paramBaiduNativeH5AdView) {
    this.f = new WeakReference<BaiduNativeH5AdView>(paramBaiduNativeH5AdView);
  }
  
  public void setApId(String paramString) {
    this.a = paramString;
  }
  
  protected void setClicked(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void setPositionId(int paramInt) {
    if (paramInt < 1)
      return; 
    this.h = paramInt;
  }
  
  protected void setRequestStarted(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void setSessionId(int paramInt) {
    if (paramInt < 1)
      return; 
    this.g = paramInt;
    this.i = g.a().a(paramInt);
  }
  
  protected void setWinSended(boolean paramBoolean) {
    this.d = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\BaiduNativeAdPlacement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */