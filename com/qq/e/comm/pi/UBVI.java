package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

public interface UBVI {
  public static final Map<String, String> ext = new HashMap<String, String>();
  
  void destroy();
  
  void fetchAd();
  
  void onWindowFocusChanged(boolean paramBoolean);
  
  void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy);
  
  void setLoadAdParams(LoadAdParams paramLoadAdParams);
  
  void setRefresh(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\UBVI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */