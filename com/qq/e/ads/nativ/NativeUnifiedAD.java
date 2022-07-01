package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class NativeUnifiedAD extends AbstractAD<NUADI> {
  private AdListenerAdapter a;
  
  private List<Integer> b = new ArrayList<Integer>();
  
  private List<String> c;
  
  private String d;
  
  private volatile int e;
  
  private volatile int f;
  
  private int g = 0;
  
  private int h = 0;
  
  private String i;
  
  private LoadAdParams j;
  
  public NativeUnifiedAD(Context paramContext, String paramString, NativeADUnifiedListener paramNativeADUnifiedListener) {
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramContext, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString, paramNativeADUnifiedListener);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    a(paramNativeADUnifiedListener, 2003);
  }
  
  @Deprecated
  public NativeUnifiedAD(Context paramContext, String paramString1, String paramString2, NativeADUnifiedListener paramNativeADUnifiedListener) {
    GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
    a(paramContext, paramString1, paramString2, paramNativeADUnifiedListener);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (!c()) {
      GDTLogger.e("Parameters or context error, details in init NativeUnifiedAD log");
      return;
    } 
    if (b()) {
      NUADI nUADI = (NUADI)a();
      if (nUADI != null) {
        LoadAdParams loadAdParams = this.j;
        if (loadAdParams != null) {
          nUADI.loadData(paramInt, loadAdParams);
          return;
        } 
        nUADI.loadData(paramInt);
        return;
      } 
    } else if (paramBoolean) {
      this.b.add(Integer.valueOf(paramInt));
    } 
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, NativeADUnifiedListener paramNativeADUnifiedListener) {
    if (paramContext == null || StringUtil.isEmpty(paramString1) || StringUtil.isEmpty(paramString2)) {
      GDTLogger.e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", new Object[] { paramString1, paramString2, paramContext }));
      a(paramNativeADUnifiedListener, 4002);
      return;
    } 
    this.a = new AdListenerAdapter(paramNativeADUnifiedListener);
    this.d = paramString2;
    a(paramContext, paramString1, paramString2, paramNativeADUnifiedListener);
  }
  
  public final void a(AbstractAD.BasicADListener paramBasicADListener, int paramInt) {
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramBasicADListener, paramInt) {
          public void run() {
            NativeUnifiedAD.a(this.c, this.a, this.b);
          }
        });
  }
  
  public String getAdNetWorkName() {
    NUADI nUADI = (NUADI)a();
    if (nUADI != null)
      return nUADI.getAdNetWorkName(); 
    GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onADLoaded\"");
    return null;
  }
  
  public void loadData(int paramInt) {
    loadData(paramInt, (LoadAdParams)null);
  }
  
  public void loadData(int paramInt, LoadAdParams paramLoadAdParams) {
    if (paramLoadAdParams != null) {
      this.j = paramLoadAdParams;
      String str = this.j.getPassThroughInfoJsonString();
      if (str != null && (str.getBytes()).length >= 512) {
        StringBuilder stringBuilder = new StringBuilder("NativeUnifiedAD setAdParams too large ,current size: ");
        stringBuilder.append((this.j.toString().getBytes()).length);
        GDTLogger.e(stringBuilder.toString());
      } 
    } 
    a(paramInt, true);
    if (this.g == 0)
      GDTLogger.i("请调用setVideoPlayPolicy()接口，设置“用户感知的视频广告播放策略”，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。"); 
    if (this.h == 0)
      GDTLogger.i("请调用setVideoADContainerRender()接口，设置“用户首次看到的视频广告容器”渲染策略，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。"); 
  }
  
  public void setCategories(List<String> paramList) {
    this.c = paramList;
    NUADI nUADI = (NUADI)a();
    if (nUADI != null && paramList != null)
      nUADI.setCategories(paramList); 
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.f = paramInt;
    if (this.f > 0 && this.e > this.f)
      GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration"); 
    NUADI nUADI = (NUADI)a();
    if (nUADI != null)
      nUADI.setMaxVideoDuration(this.f); 
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.e = paramInt;
    if (this.f > 0 && this.e > this.f)
      GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration"); 
    NUADI nUADI = (NUADI)a();
    if (nUADI != null)
      nUADI.setMinVideoDuration(this.e); 
  }
  
  public void setTag(Map paramMap) {
    if (paramMap != null && paramMap.size() > 0)
      try {
        JSONObject jSONObject = new JSONObject(paramMap);
        GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", jSONObject, this.d);
        return;
      } catch (Exception exception) {
        GDTLogger.e("NativeUnifiedAD#setTag Exception");
        exception.printStackTrace();
      }  
  }
  
  public void setVastClassName(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      GDTLogger.e("Vast class name can't be null");
      return;
    } 
    this.i = paramString;
    NUADI nUADI = (NUADI)a();
    if (nUADI != null)
      nUADI.setVastClassName(paramString); 
  }
  
  public void setVideoADContainerRender(int paramInt) {
    if (paramInt != 1 && paramInt != 2) {
      GDTLogger.e("videoADContainerRender参数有误，只能是VideoADContainerRender.SDK 或 VideoADContainerRender.DEV");
      return;
    } 
    this.h = paramInt;
    NUADI nUADI = (NUADI)a();
    if (nUADI != null)
      nUADI.setVideoADContainerRender(paramInt); 
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    if (paramInt != 1 && paramInt != 2) {
      GDTLogger.e("videoPlayPolicy参数有误，只能是VideoPlayPolicy.AUTO 或 VideoPlayPolicy.MANUAL");
      return;
    } 
    this.g = paramInt;
    NUADI nUADI = (NUADI)a();
    if (nUADI != null)
      nUADI.setVideoPlayPolicy(paramInt); 
  }
  
  static class AdListenerAdapter implements ADListener {
    private NativeADUnifiedListener a;
    
    public AdListenerAdapter(NativeADUnifiedListener param1NativeADUnifiedListener) {
      this.a = param1NativeADUnifiedListener;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      if (this.a != null) {
        Object[] arrayOfObject = param1ADEvent.getParas();
        int i = param1ADEvent.getType();
        if (i != 1) {
          if (i != 2)
            return; 
          if (arrayOfObject.length > 0 && arrayOfObject[0] instanceof Integer) {
            this.a.onNoAD(a.a(((Integer)param1ADEvent.getParas()[0]).intValue()));
            return;
          } 
        } else if (arrayOfObject.length == 1 && arrayOfObject[0] instanceof List) {
          List list = (List)arrayOfObject[0];
          ArrayList<NativeUnifiedADDataAdapter> arrayList = new ArrayList();
          if (list != null && list.size() > 0) {
            Iterator<NativeUnifiedADData> iterator = list.iterator();
            while (iterator.hasNext())
              arrayList.add(new NativeUnifiedADDataAdapter(iterator.next())); 
          } 
          this.a.onADLoaded((List)arrayList);
          return;
        } 
      } else {
        GDTLogger.i("not bind NativeADUnifiedListener");
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeUnifiedAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */