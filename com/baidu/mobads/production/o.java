package com.baidu.mobads.production;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.c.b;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
import java.util.Map;

public class o extends c implements IXAdContainerContext {
  public IXAdContainerEventListener a;
  
  private Context b;
  
  private Activity d;
  
  private RelativeLayout e;
  
  private IXAdResponseInfo f;
  
  private IXAdInstanceInfo g;
  
  private View h;
  
  private IXAdProdInfo i;
  
  private long j = 0L;
  
  private HashMap<String, Integer> k = new HashMap<String, Integer>();
  
  public o(Context paramContext, Activity paramActivity, IXAdProdInfo paramIXAdProdInfo, RelativeLayout paramRelativeLayout, IXAdContainerEventListener paramIXAdContainerEventListener, IXAdResponseInfo paramIXAdResponseInfo, View paramView) {
    this.b = paramContext;
    this.d = paramActivity;
    this.i = paramIXAdProdInfo;
    this.e = paramRelativeLayout;
    this.a = paramIXAdContainerEventListener;
    this.f = paramIXAdResponseInfo;
    this.g = paramIXAdResponseInfo.getPrimaryAdInstanceInfo();
    this.h = paramView;
  }
  
  public IOAdTimer createOAdTimer(int paramInt) {
    return (IOAdTimer)new com.baidu.mobads.openad.e.a(paramInt);
  }
  
  public IOAdTimer createOAdTimer(int paramInt1, int paramInt2) {
    return (IOAdTimer)new com.baidu.mobads.openad.e.a(paramInt1, paramInt2);
  }
  
  public void fireAdMetrics(String paramString, HashMap<String, String> paramHashMap) {
    String str = XAdSDKFoundationFacade.getInstance().getURIUitls().addParameters(paramString, paramHashMap);
    com.baidu.mobads.openad.d.a a = new com.baidu.mobads.openad.d.a();
    b b = new b(str, "");
    b.e = 1;
    a.a(b, Boolean.valueOf(true));
  }
  
  public Activity getActivity() {
    if (this.d == null) {
      RelativeLayout relativeLayout = this.e;
      if (relativeLayout != null)
        this.d = (Activity)relativeLayout.getContext(); 
    } 
    return this.d;
  }
  
  public IXAdConstants getAdConstants() {
    return (IXAdConstants)XAdSDKFoundationFacade.getInstance().getAdConstants();
  }
  
  public IXAdContainerEventListener getAdContainerListener() {
    return this.a;
  }
  
  public IXAdInstanceInfo getAdInstanceInfo() {
    return this.g;
  }
  
  public View getAdLeadingView() {
    return this.h;
  }
  
  public IXAdLogger getAdLogger() {
    return XAdSDKFoundationFacade.getInstance().getAdLogger();
  }
  
  public RelativeLayout getAdProdBase() {
    return this.e;
  }
  
  public IXAdProdInfo getAdProdInfo() {
    return this.i;
  }
  
  public IXAdResource getAdResource() {
    return (IXAdResource)XAdSDKFoundationFacade.getInstance().getAdResource();
  }
  
  public IXAdResponseInfo getAdResponseInfo() {
    return this.f;
  }
  
  public IXAdURIUitls getAdUitls4URI() {
    return XAdSDKFoundationFacade.getInstance().getURIUitls();
  }
  
  public IXAdActivityUtils getAdUtils4Activity() {
    return XAdSDKFoundationFacade.getInstance().getActivityUtils();
  }
  
  public IXAdBitmapUtils getAdUtils4Bitmap() {
    return XAdSDKFoundationFacade.getInstance().getBitmapUtils();
  }
  
  public IXAdCommonUtils getAdUtils4Common() {
    return (IXAdCommonUtils)XAdSDKFoundationFacade.getInstance().getCommonUtils();
  }
  
  public IXAdIOUtils getAdUtils4IO() {
    return XAdSDKFoundationFacade.getInstance().getIoUtils();
  }
  
  public IXAdPackageUtils getAdUtils4Package() {
    return (IXAdPackageUtils)XAdSDKFoundationFacade.getInstance().getPackageUtils();
  }
  
  public IXAdSystemUtils getAdUtils4System() {
    return XAdSDKFoundationFacade.getInstance().getSystemUtils();
  }
  
  public IXAdViewUtils getAdUtils4View() {
    return XAdSDKFoundationFacade.getInstance().getViewUtils();
  }
  
  public Context getApplicationContext() {
    return this.b;
  }
  
  public IBase64 getBase64() {
    return XAdSDKFoundationFacade.getInstance().getBase64();
  }
  
  public IOAdDownloaderManager getDownloaderManager(Context paramContext) {
    return XAdSDKFoundationFacade.getInstance().getDownloaderManager(paramContext);
  }
  
  public IXAdErrorCode getErrorCode() {
    return XAdSDKFoundationFacade.getInstance().getErrorCode();
  }
  
  public String getProxyVersion() {
    return "8.8283";
  }
  
  public void processCommand(String paramString, HashMap<String, Object> paramHashMap) {
    if (System.currentTimeMillis() - this.j > 1000L) {
      this.j = System.currentTimeMillis();
      dispatchEvent((IOAdEvent)new a(this, "process_command", paramString, paramHashMap));
    } 
  }
  
  public void registerAdService(String paramString, HashMap<String, Object> paramHashMap) {
    if (!this.k.containsKey(paramString)) {
      this.k.put(paramString, Integer.valueOf(1));
      dispatchEvent((IOAdEvent)new a(this, "regsiter_adservice", paramString, paramHashMap));
    } 
  }
  
  public void unregisterAdService(String paramString) {
    if (this.k.containsKey(paramString)) {
      this.k.remove(paramString);
      dispatchEvent((IOAdEvent)new a(this, "unregsiter_adservice", paramString, new HashMap<String, Object>()));
    } 
  }
  
  public class a extends b {
    private String b;
    
    private HashMap<String, Object> c;
    
    public a(o this$0, String param1String1, String param1String2, HashMap<String, Object> param1HashMap) {
      super(param1String1);
      this.b = param1String2;
      this.c = param1HashMap;
    }
    
    public HashMap<String, Object> getData() {
      return this.c;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */