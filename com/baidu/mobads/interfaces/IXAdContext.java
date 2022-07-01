package com.baidu.mobads.interfaces;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

public interface IXAdContext {
  void addEventListener(String paramString, IOAdEventListener paramIOAdEventListener);
  
  void dispatchEvent(IOAdEvent paramIOAdEvent);
  
  void dispose();
  
  Activity getActivity();
  
  Object getParameter(String paramString);
  
  IXAdProd getSlotById(String paramString);
  
  IXAdManager getXAdManager();
  
  IXLinearAdSlot newPrerollAdSlot(String paramString, int paramInt1, int paramInt2);
  
  void notifyVisitorAction(IXAdConstants4PDK.VisitorAction paramVisitorAction);
  
  void removeEventListener(String paramString, IOAdEventListener paramIOAdEventListener);
  
  void setActivity(Activity paramActivity);
  
  void setActivityState(IXAdConstants4PDK.ActivityState paramActivityState);
  
  void setAdCreativeLoadingTimeout(int paramInt);
  
  void setAdServerRequestingTimeout(int paramInt);
  
  void setContentVideoPlayheadTime(double paramDouble);
  
  void setContentVideoScreenMode(IXAdConstants4PDK.ScreenSizeMode paramScreenSizeMode);
  
  void setContentVideoState(IXAdConstants4PDK.VideoState paramVideoState);
  
  void setParameter(String paramString, Object paramObject);
  
  void setVideoDisplayBase(RelativeLayout paramRelativeLayout);
  
  void setVideoDisplayBaseHeight(int paramInt);
  
  void setVideoDisplayBaseWidth(int paramInt);
  
  void submitRequest();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */