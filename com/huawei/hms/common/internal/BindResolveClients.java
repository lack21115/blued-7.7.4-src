package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

public class BindResolveClients {
  private static final Object LOCK_INST = new Object();
  
  private ArrayList<ResolveClientBean> mClientList = new ArrayList<ResolveClientBean>();
  
  private BindResolveClients() {}
  
  public static BindResolveClients getInstance() {
    return SingletonManager.INSTANCE;
  }
  
  boolean isClientRegistered(ResolveClientBean paramResolveClientBean) {
    synchronized (LOCK_INST) {
      return this.mClientList.contains(paramResolveClientBean);
    } 
  }
  
  public void notifyClientReconnect() {
    synchronized (LOCK_INST) {
      ListIterator<ResolveClientBean> listIterator = this.mClientList.listIterator();
      while (listIterator.hasNext())
        ((ResolveClientBean)listIterator.next()).clientReconnect(); 
      this.mClientList.clear();
      return;
    } 
  }
  
  void register(ResolveClientBean paramResolveClientBean) {
    if (paramResolveClientBean == null)
      return; 
    synchronized (LOCK_INST) {
      if (!this.mClientList.contains(paramResolveClientBean))
        this.mClientList.add(paramResolveClientBean); 
      return;
    } 
  }
  
  void unRegister(ResolveClientBean paramResolveClientBean) {
    if (paramResolveClientBean == null)
      return; 
    synchronized (LOCK_INST) {
      if (this.mClientList.contains(paramResolveClientBean)) {
        ListIterator<ResolveClientBean> listIterator = this.mClientList.listIterator();
        while (listIterator.hasNext()) {
          if (paramResolveClientBean.equals(listIterator.next())) {
            listIterator.remove();
            break;
          } 
        } 
      } 
      return;
    } 
  }
  
  public void unRegisterAll() {
    synchronized (LOCK_INST) {
      this.mClientList.clear();
      return;
    } 
  }
  
  static class SingletonManager {
    private static final BindResolveClients INSTANCE = new BindResolveClients();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\BindResolveClients.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */