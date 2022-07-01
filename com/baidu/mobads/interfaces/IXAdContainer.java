package com.baidu.mobads.interfaces;

import android.view.KeyEvent;
import android.view.View;
import java.util.HashMap;

public interface IXAdContainer {
  void destroy();
  
  void dispose();
  
  IXAdContainerContext getAdContainerContext();
  
  View getAdView();
  
  double getDuration();
  
  HashMap<String, String> getParameters();
  
  double getPlayheadTime();
  
  String getRemoteVersion();
  
  void load();
  
  void onAttachedToWindow();
  
  void onDetachedFromWindow();
  
  void onWindowFocusChanged(boolean paramBoolean);
  
  void onWindowVisibilityChanged(int paramInt);
  
  void pause();
  
  Boolean processKeyEvent(int paramInt, KeyEvent paramKeyEvent);
  
  void resize(int paramInt1, int paramInt2);
  
  void resume();
  
  void setParameters(HashMap<String, String> paramHashMap);
  
  void start();
  
  void stop();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */