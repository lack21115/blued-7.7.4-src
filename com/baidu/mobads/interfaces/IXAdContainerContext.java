package com.baidu.mobads.interfaces;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
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
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import java.util.HashMap;

public interface IXAdContainerContext extends IOAdEventDispatcher {
  IOAdTimer createOAdTimer(int paramInt);
  
  IOAdTimer createOAdTimer(int paramInt1, int paramInt2);
  
  void fireAdMetrics(String paramString, HashMap<String, String> paramHashMap);
  
  Activity getActivity();
  
  IXAdConstants getAdConstants();
  
  IXAdContainerEventListener getAdContainerListener();
  
  IXAdInstanceInfo getAdInstanceInfo();
  
  View getAdLeadingView();
  
  IXAdLogger getAdLogger();
  
  RelativeLayout getAdProdBase();
  
  IXAdProdInfo getAdProdInfo();
  
  IXAdResource getAdResource();
  
  IXAdResponseInfo getAdResponseInfo();
  
  IXAdURIUitls getAdUitls4URI();
  
  IXAdActivityUtils getAdUtils4Activity();
  
  IXAdBitmapUtils getAdUtils4Bitmap();
  
  IXAdCommonUtils getAdUtils4Common();
  
  IXAdIOUtils getAdUtils4IO();
  
  IXAdPackageUtils getAdUtils4Package();
  
  IXAdSystemUtils getAdUtils4System();
  
  IXAdViewUtils getAdUtils4View();
  
  Context getApplicationContext();
  
  IBase64 getBase64();
  
  IOAdDownloaderManager getDownloaderManager(Context paramContext);
  
  IXAdErrorCode getErrorCode();
  
  String getProxyVersion();
  
  void processCommand(String paramString, HashMap<String, Object> paramHashMap);
  
  void registerAdService(String paramString, HashMap<String, Object> paramHashMap);
  
  void unregisterAdService(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdContainerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */