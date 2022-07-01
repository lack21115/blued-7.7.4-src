package com.baidu.mobads.interfaces;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

public interface IXLinearAdSlot extends IXAdProd {
  void addEventListener(String paramString, IOAdEventListener paramIOAdEventListener);
  
  void dispatchEvent(IOAdEvent paramIOAdEvent);
  
  void dispose();
  
  Activity getActivity();
  
  Object getParameter(String paramString);
  
  void notifyVisitorAction(IXAdConstants4PDK.VisitorAction paramVisitorAction);
  
  void removeEventListener(String paramString, IOAdEventListener paramIOAdEventListener);
  
  void setActivityState(IXAdConstants4PDK.ActivityState paramActivityState);
  
  void setContentVideoAssetCurrentTimePosition(double paramDouble);
  
  void setMaxAdNum(int paramInt);
  
  void setMaxDuration(int paramInt);
  
  void setParameter(String paramString, Object paramObject);
  
  void setSupportTipView(boolean paramBoolean);
  
  void setVideoDisplayBase(RelativeLayout paramRelativeLayout);
  
  void setVideoState(IXAdConstants4PDK.VideoState paramVideoState);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXLinearAdSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */