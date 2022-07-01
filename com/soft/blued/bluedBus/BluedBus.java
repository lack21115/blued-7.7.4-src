package com.soft.blued.bluedBus;

import android.os.Looper;
import com.soft.blued.utils.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class BluedBus {
  private Map<Class, List<SubscriberMethod>> a = (Map)new HashMap<Class<?>, List<SubscriberMethod>>();
  
  private Map<String, CopyOnWriteArrayList<Subscription>> b = new HashMap<String, CopyOnWriteArrayList<Subscription>>();
  
  private Map<Class, List<String>> c = (Map)new HashMap<Class<?>, List<String>>();
  
  private final MainThreadSupport d = a();
  
  private final Poster e;
  
  private BluedBus() {
    MainThreadSupport mainThreadSupport = this.d;
    if (mainThreadSupport != null) {
      Poster poster = mainThreadSupport.a(this);
    } else {
      mainThreadSupport = null;
    } 
    this.e = (Poster)mainThreadSupport;
  }
  
  MainThreadSupport a() {
    MainThreadSupport mainThreadSupport = this.d;
    if (mainThreadSupport != null)
      return mainThreadSupport; 
    Looper looper = Looper.getMainLooper();
    return (looper == null) ? null : new MainThreadSupport.AndroidHandlerMainThreadSupport(looper);
  }
  
  void a(PendingPost paramPendingPost) {
    Object[] arrayOfObject = paramPendingPost.a;
    Subscription subscription = paramPendingPost.b;
    PendingPost.a(paramPendingPost);
    a(subscription, arrayOfObject);
  }
  
  void a(Subscription paramSubscription, Object[] paramArrayOfObject) {
    try {
      paramSubscription.b.a.invoke(paramSubscription.a, paramArrayOfObject);
      return;
    } catch (Exception exception) {
      Logger.a("drb", new Object[] { "Exception = ", exception });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\bluedBus\BluedBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */