package com.baidu.mobads.production.rewardvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.MobRewardVideoImpl;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXRewardVideoAdContainer;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.r;
import com.baidu.mobads.vo.d;
import java.util.ArrayList;
import java.util.HashMap;

public class a extends b {
  private boolean A = false;
  
  private boolean B;
  
  private b y;
  
  private IXRewardVideoAdContainer z;
  
  public a(Context paramContext, String paramString, boolean paramBoolean) {
    super(paramContext);
    setId(paramString);
    setActivity(paramContext);
    setAdSlotBase(null);
    this.B = paramBoolean;
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_REWARD_VIDEO;
    this.y = new b(getApplicationContext(), getActivity(), this.o);
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
    Rect rect = XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenRect(paramContext);
    this.y.d(rect.width());
    this.y.e(rect.height());
    this.y.h(0);
    this.y.d(paramString);
    this.y.g(1);
    this.y.f(AdSize.RewardVideo.getValue());
    this.y.i(l.getAdCreativeTypeImage() + l.getAdCreativeTypeVideo());
  }
  
  private void x() {
    MobRewardVideoImpl.mAdContainer = (IXRewardVideoAdContainer)this.h;
    MobRewardVideoImpl.mContext = this.h.getAdContainerContext();
    Intent intent = new Intent(this.f, MobRewardVideoImpl.getActivityClass());
    if (this.f != null && !(this.f instanceof android.app.Activity))
      intent.addFlags(268435456); 
    intent.putExtra("orientation", y());
    intent.putExtra("useSurfaceView", this.B);
    this.f.startActivity(intent);
  }
  
  private String y() {
    return (this.f != null && (this.f.getResources().getConfiguration()).orientation == 2) ? "landscape" : "portrait";
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    if (this.A) {
      this.A = false;
      x();
    } 
  }
  
  public void a(b paramb, u paramu, int paramInt) {
    paramu.a(paramb, paramInt);
  }
  
  public boolean a() {
    this.z = (IXRewardVideoAdContainer)this.h;
    IXRewardVideoAdContainer iXRewardVideoAdContainer = this.z;
    return (iXRewardVideoAdContainer != null) ? iXRewardVideoAdContainer.isExpired() : false;
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {}
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public boolean b() {
    this.z = (IXRewardVideoAdContainer)this.h;
    IXRewardVideoAdContainer iXRewardVideoAdContainer = this.z;
    return (iXRewardVideoAdContainer != null) ? iXRewardVideoAdContainer.isVideoDownloaded() : false;
  }
  
  public void c() {
    this.h.load();
  }
  
  public void c(boolean paramBoolean) {
    this.A = paramBoolean;
  }
  
  public void d() {
    this.m = 8000;
  }
  
  public void q() {
    super.q();
    MobRewardVideoImpl.mAdContainer = null;
    MobRewardVideoImpl.mContext = null;
  }
  
  public void request() {
    a(this.y);
  }
  
  public boolean t() {
    try {
      this.z = (IXRewardVideoAdContainer)this.h;
      if (this.z != null) {
        boolean bool = this.z.getAdContainerContext().getAdInstanceInfo().getAdHasDisplayed();
        return bool ^ true;
      } 
    } catch (Exception exception) {
      IXAdLogger iXAdLogger = this.u;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("notPlayedBefore-exception=");
      stringBuilder.append(exception.getMessage());
      iXAdLogger.d("XAbstractAdProdTemplate", stringBuilder.toString());
    } 
    return false;
  }
  
  public boolean u() {
    this.z = (IXRewardVideoAdContainer)this.h;
    IXRewardVideoAdContainer iXRewardVideoAdContainer = this.z;
    return (iXRewardVideoAdContainer != null && iXRewardVideoAdContainer.getAdContainerContext() != null && this.z.getAdContainerContext().getAdInstanceInfo() != null && !TextUtils.isEmpty(this.z.getAdContainerContext().getAdInstanceInfo().getVideoUrl()));
  }
  
  public void v() {
    x();
  }
  
  public d w() {
    return this.y;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\rewardvideo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */