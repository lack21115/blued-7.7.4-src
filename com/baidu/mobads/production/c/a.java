package com.baidu.mobads.production.c;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.BaiduNativeH5AdView;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.feeds.IXAdDummyContainer;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import java.util.ArrayList;
import java.util.HashMap;

public class a extends b {
  private b y = null;
  
  private BaiduNativeH5AdView z;
  
  public a(Context paramContext, BaiduNativeH5AdView paramBaiduNativeH5AdView) {
    super(paramContext);
    this.z = paramBaiduNativeH5AdView;
    setId(this.z.getAdPlacement().getApId());
    setActivity(paramContext);
    setAdSlotBase((RelativeLayout)this.z);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS;
    this.y = new b(getApplicationContext(), getActivity(), this.o);
    this.y.d(this.z.getAdPlacement().getApId());
    l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(l.getSupportedActionType4RequestingLandingPage());
    arrayList.add(l.a());
    XAdSDKFoundationFacade.getInstance().getPackageUtils();
    if (r.b(this.f))
      arrayList.add(l.getSupportedActionType4RequestingDownload()); 
    String str = XAdSDKFoundationFacade.getInstance().getCommonUtils().a(arrayList);
    this.y.b(str);
    this.y.h(0);
    this.y.f(AdSize.FeedH5TemplateNative.getValue());
    this.y.g(1);
  }
  
  public void a() {}
  
  public void a(int paramInt) {
    this.y.a(paramInt);
  }
  
  public void a(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      ((IXAdDummyContainer)this.h).onImpression(paramView, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters, new HashMap<Object, Object>());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(RequestParameters paramRequestParameters) {
    int i = paramRequestParameters.getWidth();
    int j = paramRequestParameters.getHeight();
    if (i > 0 && j > 0) {
      this.y.d(i);
      this.y.e(j);
    } 
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    paramIXAdContainer.start();
  }
  
  public void a(b paramb, u paramu, int paramInt) {
    if (getAdResponseInfo() != null) {
      b("XAdMouldeLoader ad-server requesting success");
      return;
    } 
    paramu.a(paramb, paramInt);
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {}
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {
    if (paramIXAdResponseInfo.getAdInstanceList().size() > 0) {
      if (paramIXAdResponseInfo.getPrimaryAdInstanceInfo().getHtmlSnippet() == null || paramIXAdResponseInfo.getPrimaryAdInstanceInfo().getHtmlSnippet().length() <= 0) {
        a(XAdErrorCode.REQUEST_PARAM_ERROR, "代码位错误，请检查代码位是否是信息流模板");
        return;
      } 
      this.z.getAdPlacement().setAdResponse(paramIXAdResponseInfo);
      dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdLoadData"));
      return;
    } 
  }
  
  public void c() {
    if (this.h != null) {
      this.h.load();
      return;
    } 
    this.u.e("container is null");
  }
  
  public void c(int paramInt) {
    this.y.b(paramInt);
  }
  
  public void d() {}
  
  public void d(int paramInt) {
    this.y.c(paramInt);
  }
  
  public IXAdRequestInfo getAdRequestInfo() {
    return (IXAdRequestInfo)this.y;
  }
  
  public void request() {
    o();
    a(this.y);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */