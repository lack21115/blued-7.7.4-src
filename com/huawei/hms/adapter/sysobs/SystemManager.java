package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SystemManager {
  private static SystemManager a = new SystemManager();
  
  private static final Object b = new Object();
  
  private static SystemNotifier c = new SystemNotifier() {
      private final List<SystemObserver> a = new ArrayList<SystemObserver>();
      
      public void notifyObservers(int param1Int) {
        synchronized (SystemManager.a()) {
          Iterator<SystemObserver> iterator = this.a.iterator();
          while (iterator.hasNext()) {
            if (((SystemObserver)iterator.next()).onUpdateResult(param1Int))
              iterator.remove(); 
          } 
          return;
        } 
      }
      
      public void notifyObservers(Intent param1Intent, String param1String) {
        synchronized (SystemManager.a()) {
          Iterator<SystemObserver> iterator = this.a.iterator();
          while (iterator.hasNext()) {
            if (((SystemObserver)iterator.next()).onSolutionResult(param1Intent, param1String))
              iterator.remove(); 
          } 
          return;
        } 
      }
      
      public void registerObserver(SystemObserver param1SystemObserver) {
        if (param1SystemObserver == null)
          return; 
        if (!this.a.contains(param1SystemObserver))
          synchronized (SystemManager.a()) {
            this.a.add(param1SystemObserver);
            return;
          }  
      }
      
      public void unRegisterObserver(SystemObserver param1SystemObserver) {
        synchronized (SystemManager.a()) {
          this.a.remove(param1SystemObserver);
          return;
        } 
      }
    };
  
  public static SystemManager getInstance() {
    return a;
  }
  
  public static SystemNotifier getSystemNotifier() {
    return c;
  }
  
  public void notifyResolutionResult(Intent paramIntent, String paramString) {
    c.notifyObservers(paramIntent, paramString);
  }
  
  public void notifyUpdateResult(int paramInt) {
    c.notifyObservers(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapter\sysobs\SystemManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */