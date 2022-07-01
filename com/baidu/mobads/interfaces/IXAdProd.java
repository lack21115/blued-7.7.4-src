package com.baidu.mobads.interfaces;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import java.util.HashMap;

public interface IXAdProd {
  public static final String SLOT_DID_FINISH = "slot_did_finish";
  
  public static final String SLOT_DID_LOADED = "slot_did_loaded";
  
  public static final String SLOT_DID_START = "slot_did_start";
  
  public static final String SLOT_ERROR = "slot_error";
  
  Activity getActivity();
  
  IXAdContainerFactory getAdContainerFactory();
  
  IXAdRequestInfo getAdRequestInfo();
  
  IXAdResponseInfo getAdResponseInfo();
  
  Context getApplicationContext();
  
  IXAdInstanceInfo getCurrentAdInstance();
  
  IXAdContainer getCurrentXAdContainer();
  
  int getDuration();
  
  String getId();
  
  HashMap<String, String> getParameter();
  
  int getPlayheadTime();
  
  ViewGroup getProdBase();
  
  IXAdProdInfo getProdInfo();
  
  IXAdFeedsRequestParameters getRequestParameters();
  
  IXAdConstants4PDK.SlotState getSlotState();
  
  IXAdConstants4PDK.SlotType getType();
  
  Boolean isAdServerRequestingSuccess();
  
  void load();
  
  void pause();
  
  void request();
  
  void resize();
  
  void resume();
  
  void setActivity(Context paramContext);
  
  void setAdResponseInfo(IXAdResponseInfo paramIXAdResponseInfo);
  
  void setAdSlotBase(RelativeLayout paramRelativeLayout);
  
  void setId(String paramString);
  
  void setParameter(HashMap<String, String> paramHashMap);
  
  void start();
  
  void stop();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdProd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */