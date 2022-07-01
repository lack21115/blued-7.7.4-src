package com.baidu.mobads.interfaces;

import android.content.Context;
import android.net.Uri;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.download.activate.IXMonitorActivation;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import java.util.HashMap;

public interface IXAdContainerFactory {
  IXAppInfo createAppInfo();
  
  IXAdContainer createXAdContainer(IXAdContainerContext paramIXAdContainerContext, HashMap<String, String> paramHashMap);
  
  Boolean getDebugMode();
  
  String getFullProxyVersion();
  
  double getProxyVersion();
  
  double getRemoteVersion();
  
  IXMonitorActivation getXMonitorActivation(Context paramContext, IXAdLogger paramIXAdLogger);
  
  double handleShakeVersion(double paramDouble, String paramString);
  
  boolean runCommandByProxy(Uri paramUri);
  
  void setDebugMode(Boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdContainerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */