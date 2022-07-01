package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public interface SystemNotifier {
  void notifyObservers(int paramInt);
  
  void notifyObservers(Intent paramIntent, String paramString);
  
  void registerObserver(SystemObserver paramSystemObserver);
  
  void unRegisterObserver(SystemObserver paramSystemObserver);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapter\sysobs\SystemNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */