package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.mobads.b.a;
import com.baidu.mobads.command.a;
import com.baidu.mobads.command.a.a;
import com.baidu.mobads.d.b;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.b.b;
import com.baidu.mobads.openad.b.d;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import java.util.HashMap;

public class XAdSDKFoundationFacade {
  private static final XAdSDKFoundationFacade o = new XAdSDKFoundationFacade();
  
  private m a;
  
  private s b = new s();
  
  private IBase64 c = new a();
  
  private IXAdLogger d = q.a();
  
  private IXAdViewUtils e = new ab();
  
  private IXAdBitmapUtils f = new g();
  
  private IXAdURIUitls g = new aa();
  
  private IXAdIOUtils h = new p();
  
  private r i = new r();
  
  private IXAdActivityUtils j = new f();
  
  private IXAdSystemUtils k = t.a();
  
  private h l = new h();
  
  private l m = new l();
  
  private IXAdErrorCode n = (IXAdErrorCode)new b(this.d);
  
  private Context p;
  
  private IXAdContainerFactory q;
  
  public static XAdSDKFoundationFacade getInstance() {
    return o;
  }
  
  public void downloadApp(IXAdInstanceInfo paramIXAdInstanceInfo) {
    try {
      getInstance().getCommonUtils();
      (new a(null, paramIXAdInstanceInfo, null)).a();
      return;
    } catch (Exception exception) {
      Log.e("", "");
      return;
    } 
  }
  
  public void downloadAppSilence(IXAdInstanceInfo paramIXAdInstanceInfo) {
    downloadApp(paramIXAdInstanceInfo);
  }
  
  public IXAdActivityUtils getActivityUtils() {
    return this.j;
  }
  
  public l getAdConstants() {
    return this.m;
  }
  
  public IXAdContainerFactory getAdContainerFactory() {
    return this.q;
  }
  
  public m getAdCreativeCacheManager() {
    return this.a;
  }
  
  public IXAdLogger getAdLogger() {
    return this.d;
  }
  
  public s getAdResource() {
    return this.b;
  }
  
  public Context getApplicationContext() {
    return this.p;
  }
  
  public IBase64 getBase64() {
    return this.c;
  }
  
  public IXAdBitmapUtils getBitmapUtils() {
    return this.f;
  }
  
  public h getCommonUtils() {
    return this.l;
  }
  
  public IOAdDownloaderManager getDownloaderManager() {
    return (IOAdDownloaderManager)d.a(getApplicationContext());
  }
  
  public IOAdDownloaderManager getDownloaderManager(Context paramContext) {
    return (IOAdDownloaderManager)d.a(paramContext);
  }
  
  public IXAdErrorCode getErrorCode() {
    return this.n;
  }
  
  public Intent getInstallIntent(String paramString) {
    return getPackageUtils().a(getApplicationContext(), paramString);
  }
  
  public IXAdIOUtils getIoUtils() {
    return this.h;
  }
  
  public r getPackageUtils() {
    return this.i;
  }
  
  public String getProxyVer() {
    return "8.8283";
  }
  
  public IXAdSystemUtils getSystemUtils() {
    return this.k;
  }
  
  public IXAdURIUitls getURIUitls() {
    return this.g;
  }
  
  public IXAdViewUtils getViewUtils() {
    return this.e;
  }
  
  public void initializeAdContainerFactory(IXAdContainerFactory paramIXAdContainerFactory) {
    if (paramIXAdContainerFactory == null)
      this.q = paramIXAdContainerFactory; 
  }
  
  public void initializeApplicationContext(Context paramContext) {
    if (this.p == null)
      this.p = paramContext; 
    this.a = new m(this.p);
  }
  
  public void makeRequest(String paramString) {
    b b = new b(paramString, "");
    b.e = 1;
    (new a()).a(b);
  }
  
  public void sendLog(String paramString, HashMap<String, String> paramHashMap) {
    a.a().a(getApplicationContext(), paramString, null, null, paramHashMap);
  }
  
  public void setMobileConfirmed(String paramString) {
    b b = b.a(paramString);
    if (b != null) {
      a a = b.a();
      if (a != null)
        a.s = true; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\XAdSDKFoundationFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */