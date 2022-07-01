package com.baidu.mobads.production.c;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.f.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.feeds.IXAdDummyContainer;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import com.baidu.mobads.vo.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c extends b {
  private boolean A = true;
  
  private int B = 8000;
  
  private d y;
  
  private ArrayList<IXAdInstanceInfo> z;
  
  public c(Context paramContext) {
    super(paramContext);
  }
  
  public c(Context paramContext, String paramString) {
    this(paramContext, paramString, true);
  }
  
  public c(Context paramContext, String paramString, int paramInt) {
    this(paramContext, paramString, true, paramInt);
  }
  
  public c(Context paramContext, String paramString, boolean paramBoolean) {
    this(paramContext, paramString, paramBoolean, 8000);
  }
  
  public c(Context paramContext, String paramString, boolean paramBoolean, int paramInt) {
    super(paramContext);
    this.A = paramBoolean;
    this.B = paramInt;
    setId(paramString);
    setActivity(paramContext);
    setAdSlotBase(null);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS;
    this.y = new d(getApplicationContext(), getActivity(), this.o);
    l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(l.getSupportedActionType4RequestingNone());
    arrayList.add(l.getSupportedActionType4RequestingLandingPage());
    arrayList.add(l.a());
    XAdSDKFoundationFacade.getInstance().getPackageUtils();
    if (r.b(paramContext))
      arrayList.add(l.getSupportedActionType4RequestingDownload()); 
    String str = XAdSDKFoundationFacade.getInstance().getCommonUtils().a(arrayList);
    this.y.b(str);
    this.y.d(600);
    this.y.e(500);
    this.y.h(0);
    this.y.d(paramString);
    this.y.f(AdSize.FeedNative.getValue());
    this.y.g(1);
    this.y.i(XAdSDKFoundationFacade.getInstance().getAdConstants().getAdCreativeTypeImage());
  }
  
  private Map<String, Object> a(int paramInt, List<String> paramList) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put(XAdSDKFoundationFacade.getInstance().getAdConstants().feedsTrackerParameterKeyProgress(), Integer.valueOf(paramInt));
    hashMap.put(XAdSDKFoundationFacade.getInstance().getAdConstants().feedsTrackerParameterKeyList(), paramList);
    return (Map)hashMap;
  }
  
  public ArrayList<IXAdInstanceInfo> a() {
    return this.z;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, IXAdInstanceInfo paramIXAdInstanceInfo) {}
  
  public void a(Context paramContext, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      Map<String, Object> map = a(paramInt, paramIXAdInstanceInfo.getCloseTrackers());
      ((IXAdDummyContainer)this.h).onClose(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters, map);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, int paramInt, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      b().d().setClickView(paramView);
      Map<String, Object> map = a(paramInt, paramIXAdInstanceInfo.getThirdClickTrackingUrls());
      ((IXAdDummyContainer)this.h).onClick(paramView, paramIXAdInstanceInfo, paramInt, paramIXAdFeedsRequestParameters, map);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      Map<String, Object> map = a(-1, paramIXAdInstanceInfo.getThirdImpressionTrackingUrls());
      ((IXAdDummyContainer)this.h).onImpression(paramView, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters, map);
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
    this.y.a(paramRequestParameters.getExtras());
    super.a(paramRequestParameters);
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    paramIXAdContainer.start();
  }
  
  public void a(b paramb, u paramu, int paramInt) {
    paramu.a(paramb, paramInt);
  }
  
  public boolean a(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramIXAdInstanceInfo.getHtmlSnippet());
      stringBuffer.append("_&_");
      stringBuffer.append(paramIXAdInstanceInfo.getQueryKey());
      stringBuffer.append("_&_");
      stringBuffer.append(paramIXAdInstanceInfo.getAdId());
      stringBuffer.append("_&_");
      stringBuffer.append(paramIXAdInstanceInfo.getMainPictureUrl());
      stringBuffer.append("_&_");
      stringBuffer.append(paramIXAdInstanceInfo.getTitle());
      stringBuffer.append("_&_");
      q.a = stringBuffer.toString();
    } catch (Exception exception) {}
    try {
      return ((IXAdDummyContainer)this.h).isAdAvailable(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters);
    } catch (Exception exception) {}
    return false;
  }
  
  public d b() {
    return this.y;
  }
  
  public void b(Context paramContext, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      Map<String, Object> map = a(paramInt, paramIXAdInstanceInfo.getFullScreenTrackers());
      ((IXAdDummyContainer)this.h).onFullScreen(paramContext, paramInt, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters, map);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void b(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      Map<String, Object> map = a(0, paramIXAdInstanceInfo.getStartTrackers());
      ((IXAdDummyContainer)this.h).onStart(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters, map);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void b(View paramView, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    a(paramView, paramIXAdInstanceInfo, -1, paramIXAdFeedsRequestParameters);
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    this.z = paramIXAdContainer.getAdContainerContext().getAdResponseInfo().getAdInstanceList();
  }
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public void c() {
    this.h.load();
  }
  
  public void c(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      ((IXAdDummyContainer)this.h).onComplete(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters, null);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void d() {
    this.m = this.B;
  }
  
  public void d(Context paramContext, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdFeedsRequestParameters paramIXAdFeedsRequestParameters) {
    try {
      Map<String, Object> map = a(0, paramIXAdInstanceInfo.getCstartcardTrackers());
      ((IXAdDummyContainer)this.h).onCstartcard(paramContext, paramIXAdInstanceInfo, paramIXAdFeedsRequestParameters, map);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void request() {
    a(this.y);
  }
  
  public boolean s() {
    return this.A;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */