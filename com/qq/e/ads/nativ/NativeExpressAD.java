package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class NativeExpressAD extends AbstractAD<NEADI> {
  public static final int EVENT_TYPE_AD_WILL_OPEN_OVERLAY = 20;
  
  public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
  
  public static final int EVENT_TYPE_ON_AD_CLOSED = 7;
  
  public static final int EVENT_TYPE_ON_AD_CLOSE_OVERLAY = 10;
  
  public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
  
  public static final int EVENT_TYPE_ON_AD_LEFT_APPLICATION = 8;
  
  public static final int EVENT_TYPE_ON_AD_LOADED = 2;
  
  public static final int EVENT_TYPE_ON_AD_OPEN_OVERLAY = 9;
  
  public static final int EVENT_TYPE_ON_NO_AD = 1;
  
  public static final int EVENT_TYPE_ON_RENDER_FAILED = 3;
  
  public static final int EVENT_TYPE_ON_RENDER_SUCCESS = 4;
  
  public static final int EVENT_TYPE_ON_VIDEO_CACHED = 21;
  
  public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 16;
  
  public static final int EVENT_TYPE_ON_VIDEO_ERROR = 17;
  
  public static final int EVENT_TYPE_ON_VIDEO_INIT = 11;
  
  public static final int EVENT_TYPE_ON_VIDEO_LOADING = 12;
  
  public static final int EVENT_TYPE_ON_VIDEO_PAGE_CLOSE = 19;
  
  public static final int EVENT_TYPE_ON_VIDEO_PAGE_OPEN = 18;
  
  public static final int EVENT_TYPE_ON_VIDEO_PAUSE = 15;
  
  public static final int EVENT_TYPE_ON_VIDEO_READY = 13;
  
  public static final int EVENT_TYPE_ON_VIDEO_START = 14;
  
  private volatile int a;
  
  private volatile int b;
  
  private volatile int c;
  
  private List<Integer> d = Collections.synchronizedList(new ArrayList<Integer>());
  
  private VideoOption e;
  
  private ADSize f;
  
  private NativeExpressADListener g;
  
  private String h;
  
  private LoadAdParams i;
  
  public NativeExpressAD(Context paramContext, ADSize paramADSize, String paramString, NativeExpressADListener paramNativeExpressADListener) {
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramContext, paramADSize, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString, paramNativeExpressADListener);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    a(paramNativeExpressADListener, 2003);
  }
  
  @Deprecated
  public NativeExpressAD(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, NativeExpressADListener paramNativeExpressADListener) {
    GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
    a(paramContext, paramADSize, paramString1, paramString2, paramNativeExpressADListener);
  }
  
  private void a(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, NativeExpressADListener paramNativeExpressADListener) {
    if (StringUtil.isEmpty(paramString1) || StringUtil.isEmpty(paramString2) || paramADSize == null || paramContext == null) {
      GDTLogger.e(String.format("NativeExpressAD Constructor params error, adSize=%s, appid=%s, posId=%s, context=%s", new Object[] { paramADSize, paramString1, paramString2, paramContext }));
      a(paramNativeExpressADListener, 2001);
      return;
    } 
    this.f = paramADSize;
    this.g = paramNativeExpressADListener;
    this.h = paramString2;
    a(paramContext, paramString1, paramString2, paramNativeExpressADListener);
  }
  
  public void loadAD(int paramInt) {
    loadAD(paramInt, (LoadAdParams)null);
  }
  
  public void loadAD(int paramInt, LoadAdParams paramLoadAdParams) {
    String str;
    if (!c()) {
      str = "AD init Paras OR Context error,details in logs produced while init NativeAD";
    } else {
      if (str != null)
        setAdParams((LoadAdParams)str); 
      if (this.c == 0)
        GDTLogger.i("请调用setVideoPlayPolicy()接口，设置“用户感知的视频广告播放策略”，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。"); 
      if (!b())
        synchronized (this.d) {
          this.d.add(Integer.valueOf(paramInt));
          return;
        }  
      NEADI nEADI = (NEADI)a();
      if (nEADI != null) {
        LoadAdParams loadAdParams = this.i;
        if (loadAdParams != null) {
          nEADI.loadAd(paramInt, loadAdParams);
          return;
        } 
        nEADI.loadAd(paramInt);
        return;
      } 
      str = "Native Express AD Init error, see more logs";
    } 
    GDTLogger.e(str);
  }
  
  public void setAdParams(LoadAdParams paramLoadAdParams) {
    this.i = paramLoadAdParams;
    if (paramLoadAdParams != null) {
      String str = paramLoadAdParams.getPassThroughInfoJsonString();
      if (str != null && (str.getBytes()).length >= 512) {
        StringBuilder stringBuilder = new StringBuilder("NativeExpressAD setAdParams too large ,current size: ");
        stringBuilder.append((paramLoadAdParams.toString().getBytes()).length);
        GDTLogger.e(stringBuilder.toString());
      } 
    } 
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.b = paramInt;
    if (this.b > 0 && this.a > this.b)
      GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration"); 
    NEADI nEADI = (NEADI)a();
    if (nEADI != null)
      nEADI.setMaxVideoDuration(this.b); 
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.a = paramInt;
    if (this.b > 0 && this.a > this.b)
      GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration"); 
    NEADI nEADI = (NEADI)a();
    if (nEADI != null)
      nEADI.setMinVideoDuration(this.a); 
  }
  
  public void setTag(Map paramMap) {
    if (paramMap != null && paramMap.size() > 0)
      try {
        JSONObject jSONObject = new JSONObject(paramMap);
        GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", jSONObject, this.h);
        return;
      } catch (Exception exception) {
        GDTLogger.e("NativeUnifiedAD#setTag Exception");
        exception.printStackTrace();
      }  
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.e = paramVideoOption;
    NEADI nEADI = (NEADI)a();
    if (nEADI != null && paramVideoOption != null)
      nEADI.setVideoOption(paramVideoOption); 
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    if (paramInt != 1 && paramInt != 2) {
      GDTLogger.e("videoPlayPolicy参数有误，只能是VideoPlayPolicy.AUTO 或 VideoPlayPolicy.MANUAL");
      return;
    } 
    this.c = paramInt;
    NEADI nEADI = (NEADI)a();
    if (nEADI != null)
      nEADI.setVideoPlayPolicy(this.c); 
  }
  
  public static class ADListenerAdapter implements ADListener {
    private NativeExpressAD.NativeExpressADListener a;
    
    private NativeExpressMediaListener b;
    
    public ADListenerAdapter(NativeExpressAD.NativeExpressADListener param1NativeExpressADListener) {
      this.a = param1NativeExpressADListener;
    }
    
    public ADListenerAdapter(NativeExpressMediaListener param1NativeExpressMediaListener) {
      this.b = param1NativeExpressMediaListener;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      switch (param1ADEvent.getType()) {
        default:
          return;
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 21:
          NativeExpressAD.a(this.b, param1ADEvent);
          return;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
          break;
      } 
      NativeExpressAD.a(this.a, param1ADEvent);
    }
  }
  
  public static interface NativeExpressADListener extends AbstractAD.BasicADListener {
    void onADClicked(NativeExpressADView param1NativeExpressADView);
    
    void onADCloseOverlay(NativeExpressADView param1NativeExpressADView);
    
    void onADClosed(NativeExpressADView param1NativeExpressADView);
    
    void onADExposure(NativeExpressADView param1NativeExpressADView);
    
    void onADLeftApplication(NativeExpressADView param1NativeExpressADView);
    
    void onADLoaded(List<NativeExpressADView> param1List);
    
    void onADOpenOverlay(NativeExpressADView param1NativeExpressADView);
    
    void onRenderFail(NativeExpressADView param1NativeExpressADView);
    
    void onRenderSuccess(NativeExpressADView param1NativeExpressADView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeExpressAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */