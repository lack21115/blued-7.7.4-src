package com.qq.e.comm.pi;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

public interface NSPVI {
  public static final Map<String, String> ext = new HashMap<String, String>();
  
  void fetchAdOnly();
  
  void fetchAndShowIn(ViewGroup paramViewGroup);
  
  String getAdNetWorkName();
  
  String getECPMLevel();
  
  void preload();
  
  void setAdListener(ADListener paramADListener);
  
  void setAdLogoMargin(int paramInt1, int paramInt2);
  
  void setFetchDelay(int paramInt);
  
  void setFloatView(View paramView);
  
  void setLoadAdParams(LoadAdParams paramLoadAdParams);
  
  void setPreloadView(View paramView);
  
  void setSkipView(View paramView);
  
  void showAd(ViewGroup paramViewGroup);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\NSPVI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */