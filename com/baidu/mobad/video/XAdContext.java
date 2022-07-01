package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.h.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class XAdContext implements IXAdContext {
  public static final String PARAMETER_KEY_OF_BASE_HEIGHT = "BASE_HEIGHT";
  
  public static final String PARAMETER_KEY_OF_BASE_WIDTH = "BASE_WIDTH";
  
  public static final String TAG = "XAdContext";
  
  int a = 0;
  
  int b = 0;
  
  private HashMap<String, Object> c = new HashMap<String, Object>();
  
  private IXAdConstants4PDK.ScreenSizeMode d = IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN;
  
  private IXAdConstants4PDK.VideoState e = IXAdConstants4PDK.VideoState.IDLE;
  
  private IXAdConstants4PDK.ActivityState f = IXAdConstants4PDK.ActivityState.CREATE;
  
  private IXAdConstants4PDK.VisitorAction g;
  
  private double h;
  
  private int i;
  
  private int j;
  
  private Context k;
  
  private String l;
  
  private Location m;
  
  protected IXAdLogger mAdLogger;
  
  private Activity n;
  
  private RelativeLayout o;
  
  private final IOAdEventDispatcher p;
  
  private final XAdSlotManager q;
  
  public XAdContext(Context paramContext, String paramString, Location paramLocation) {
    this.k = paramContext;
    this.l = paramString;
    this.m = paramLocation;
    this.p = (IOAdEventDispatcher)new c();
    this.q = new XAdSlotManager();
    this.mAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
  }
  
  private void a(Set<String> paramSet) {
    a a = new a();
    Iterator<String> iterator = paramSet.iterator();
    while (iterator.hasNext()) {
      b b = new b(iterator.next(), "");
      b.e = 1;
      a.a(b, Boolean.valueOf(true));
    } 
  }
  
  public void addEventListener(String paramString, IOAdEventListener paramIOAdEventListener) {
    this.p.addEventListener(paramString, paramIOAdEventListener);
  }
  
  public void dispatchEvent(IOAdEvent paramIOAdEvent) {}
  
  public void dispose() {}
  
  public Activity getActivity() {
    return this.n;
  }
  
  public Object getParameter(String paramString) {
    return this.c.get(paramString);
  }
  
  public IXAdProd getSlotById(String paramString) {
    return this.q.retrieveAdSlotById(paramString);
  }
  
  public IXAdManager getXAdManager() {
    return null;
  }
  
  public IXLinearAdSlot newPrerollAdSlot(String paramString, int paramInt1, int paramInt2) {
    if (!this.q.containsAdSlot(paramString).booleanValue()) {
      b b = new b((Context)this.n, paramString);
      b.setActivity((Context)this.n);
      b.setAdSlotBase(this.o);
      b.setId(paramString);
      AdSlotEventListener adSlotEventListener = new AdSlotEventListener(this.k, (IXAdProd)b, this.p);
      b.removeAllListeners();
      b.addEventListener("complete", adSlotEventListener);
      b.addEventListener("AdStarted", adSlotEventListener);
      b.addEventListener("AdStopped", adSlotEventListener);
      b.addEventListener("AdError", adSlotEventListener);
      b.addEventListener("AdUserClick", adSlotEventListener);
      this.q.addAdSlot((IXAdProd)b);
    } 
    return this.q.retrievePrerollAdSlot();
  }
  
  public void notifyVisitorAction(IXAdConstants4PDK.VisitorAction paramVisitorAction) {
    this.g = paramVisitorAction;
  }
  
  public void removeEventListener(String paramString, IOAdEventListener paramIOAdEventListener) {
    this.p.removeEventListener(paramString, paramIOAdEventListener);
  }
  
  public void setActivity(Activity paramActivity) {
    if (paramActivity != null && this.n == null) {
      this.n = paramActivity;
      if (this.k == null)
        this.k = this.n.getApplicationContext(); 
    } 
  }
  
  public void setActivityState(IXAdConstants4PDK.ActivityState paramActivityState) {
    this.f = paramActivityState;
    this.mAdLogger.i("XAdContext", paramActivityState.getValue());
    IXLinearAdSlot iXLinearAdSlot = this.q.retrievePrerollAdSlot();
    if (iXLinearAdSlot != null) {
      if (paramActivityState == IXAdConstants4PDK.ActivityState.PAUSE)
        iXLinearAdSlot.pause(); 
      if (paramActivityState == IXAdConstants4PDK.ActivityState.RESUME)
        iXLinearAdSlot.resume(); 
    } 
  }
  
  public void setAdCreativeLoadingTimeout(int paramInt) {
    this.j = paramInt;
  }
  
  public void setAdServerRequestingTimeout(int paramInt) {
    this.i = paramInt;
  }
  
  public void setContentVideoPlayheadTime(double paramDouble) {
    this.h = paramDouble;
  }
  
  public void setContentVideoScreenMode(IXAdConstants4PDK.ScreenSizeMode paramScreenSizeMode) {
    this.d = paramScreenSizeMode;
    IXLinearAdSlot iXLinearAdSlot = this.q.retrievePrerollAdSlot();
    if (this.d == IXAdConstants4PDK.ScreenSizeMode.FULL_SCREEN && iXLinearAdSlot != null && iXLinearAdSlot.getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
      IXAdInstanceInfo iXAdInstanceInfo = iXLinearAdSlot.getCurrentAdInstance();
      if (iXAdInstanceInfo != null) {
        int j = (int)iXLinearAdSlot.getCurrentXAdContainer().getPlayheadTime();
        IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        ArrayList<String> arrayList = new ArrayList();
        List<String> list = iXAdInstanceInfo.getFullScreenTrackers();
        for (int i = 0; i < list.size(); i++) {
          String str = list.get(i);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(j);
          arrayList.add(iXAdURIUitls.addParameter(str, "progress", stringBuilder.toString()));
        } 
        iXAdInstanceInfo.setFullScreenTrackers(arrayList);
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(iXAdInstanceInfo.getFullScreenTrackers());
        a(hashSet);
      } 
    } 
  }
  
  public void setContentVideoState(IXAdConstants4PDK.VideoState paramVideoState) {
    this.e = paramVideoState;
  }
  
  public void setParameter(String paramString, Object paramObject) {
    this.c.put(paramString, paramObject);
  }
  
  public void setSupportTipView(boolean paramBoolean) {
    this.q.retrievePrerollAdSlot().setSupportTipView(paramBoolean);
  }
  
  public void setVideoDisplayBase(RelativeLayout paramRelativeLayout) {
    this.o = paramRelativeLayout;
    setActivity((Activity)this.o.getContext());
    (new Handler(getActivity().getMainLooper())).post(new XAdContext$1(this));
  }
  
  public void setVideoDisplayBaseHeight(int paramInt) {
    this.b = paramInt;
  }
  
  public void setVideoDisplayBaseWidth(int paramInt) {
    this.a = paramInt;
  }
  
  public void submitRequest() {
    IXLinearAdSlot iXLinearAdSlot = this.q.retrievePrerollAdSlot();
    if (this.i > 0 && this.j > 0) {
      HashMap<String, String> hashMap = iXLinearAdSlot.getParameter();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.i);
      hashMap.put("AD_REQUESTING_TIMEOUT", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.j);
      hashMap.put("AD_CREATIVE_LOADING_TIMEOUT", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.a);
      hashMap.put("BASE_WIDTH", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.b);
      hashMap.put("BASE_HEIGHT", stringBuilder.toString());
      iXLinearAdSlot.setParameter(hashMap);
    } 
    iXLinearAdSlot.request();
  }
  
  public static class AdSlotEventListener implements IOAdEventListener {
    public static final String TAG = "AdSlotEventListener";
    
    private final Context a;
    
    private final IXAdProd b;
    
    private final IOAdEventDispatcher c;
    
    public AdSlotEventListener(Context param1Context, IXAdProd param1IXAdProd, IOAdEventDispatcher param1IOAdEventDispatcher) {
      this.a = param1Context;
      this.b = param1IXAdProd;
      this.c = param1IOAdEventDispatcher;
    }
    
    public void run(IOAdEvent param1IOAdEvent) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().i("AdSlotEventListener", param1IOAdEvent.getType());
      XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new XAdContext$AdSlotEventListener$1(this, param1IOAdEvent));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\video\XAdContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */