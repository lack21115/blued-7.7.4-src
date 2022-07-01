package com.baidu.mobad.video;

import android.content.Context;
import android.location.Location;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class XAdManager implements IXAdManager {
  private static IXAdManager d;
  
  private String a;
  
  private Location b;
  
  private Context c;
  
  private XAdManager(Context paramContext) {
    Context context = paramContext;
    if (paramContext instanceof android.app.Activity)
      context = paramContext.getApplicationContext(); 
    this.c = context;
  }
  
  public static IXAdManager getInstance(Context paramContext) {
    if (d == null)
      d = new XAdManager(paramContext); 
    return d;
  }
  
  public String getVersion() {
    return "8.8283";
  }
  
  public IXAdContext newAdContext() {
    return new XAdContext(this.c, this.a, this.b);
  }
  
  public void setAppSid(String paramString) {
    this.a = paramString;
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(paramString);
  }
  
  public void setLocation(Location paramLocation) {
    this.b = paramLocation;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\video\XAdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */