package com.blued.android.core.ui;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import java.util.HashSet;
import java.util.WeakHashMap;

public class UIRunnableManager {
  private static final WeakHashMap<IRequestHost, HashSet<UITask>> a = new WeakHashMap<IRequestHost, HashSet<UITask>>();
  
  public static void a(IRequestHost paramIRequestHost) {
    if (paramIRequestHost == null)
      return; 
    synchronized (a) {
      HashSet hashSet = a.get(paramIRequestHost);
      if (hashSet != null) {
        for (UITask uITask : hashSet) {
          if (uITask != null)
            AppInfo.n().removeCallbacks(uITask); 
        } 
        hashSet.clear();
      } 
      a.remove(paramIRequestHost);
      return;
    } 
  }
  
  public static boolean a(IRequestHost paramIRequestHost, Runnable paramRunnable, long paramLong) {
    if (paramIRequestHost == null || !paramIRequestHost.isActive() || paramRunnable == null)
      return false; 
    UITask uITask = new UITask(paramIRequestHost, paramRunnable);
    if (0L == paramLong) {
      AppInfo.n().post(uITask);
    } else {
      AppInfo.n().postDelayed(uITask, paramLong);
    } 
    synchronized (a) {
      HashSet<UITask> hashSet2 = a.get(paramIRequestHost);
      HashSet<UITask> hashSet1 = hashSet2;
      if (hashSet2 == null) {
        hashSet1 = new HashSet();
        a.put(paramIRequestHost, hashSet1);
      } 
      hashSet1.add(uITask);
      return true;
    } 
  }
  
  private static void b(IRequestHost paramIRequestHost, UITask paramUITask) {
    if (paramIRequestHost != null) {
      if (paramUITask == null)
        return; 
      synchronized (a) {
        HashSet hashSet = a.get(paramIRequestHost);
        if (hashSet != null)
          hashSet.remove(paramUITask); 
        return;
      } 
    } 
  }
  
  static class UITask implements Runnable {
    private final IRequestHost a;
    
    private final Runnable b;
    
    public UITask(IRequestHost param1IRequestHost, Runnable param1Runnable) {
      this.a = param1IRequestHost;
      this.b = param1Runnable;
    }
    
    public void run() {
      IRequestHost iRequestHost = this.a;
      if (iRequestHost != null) {
        UIRunnableManager.a(iRequestHost, this);
        if (this.a.isActive())
          this.b.run(); 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\UIRunnableManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */