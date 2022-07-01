package com.blued.android.module.shortvideo.manager;

import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverMgr {
  private static ObserverMgr a;
  
  private List<EventObserver> b = new ArrayList<EventObserver>();
  
  private List<ReturnObserver> c = new ArrayList<ReturnObserver>();
  
  public static ObserverMgr a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/shortvideo/manager/ObserverMgr.a : Lcom/blued/android/module/shortvideo/manager/ObserverMgr;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/shortvideo/manager/ObserverMgr
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/shortvideo/manager/ObserverMgr.a : Lcom/blued/android/module/shortvideo/manager/ObserverMgr;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/shortvideo/manager/ObserverMgr
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/shortvideo/manager/ObserverMgr.a : Lcom/blued/android/module/shortvideo/manager/ObserverMgr;
    //   25: ldc com/blued/android/module/shortvideo/manager/ObserverMgr
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/shortvideo/manager/ObserverMgr
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/shortvideo/manager/ObserverMgr.a : Lcom/blued/android/module/shortvideo/manager/ObserverMgr;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(EventType.VALUE paramVALUE) {
    Iterator<EventObserver> iterator = this.b.iterator();
    while (iterator.hasNext())
      ((EventObserver)iterator.next()).a(paramVALUE); 
  }
  
  public void a(EventType.VALUE paramVALUE, boolean paramBoolean) {
    Iterator<ReturnObserver> iterator = this.c.iterator();
    while (iterator.hasNext())
      ((ReturnObserver)iterator.next()).a(paramVALUE, paramBoolean); 
  }
  
  public boolean a(EventObserver paramEventObserver) {
    return !this.b.contains(paramEventObserver) ? this.b.add(paramEventObserver) : false;
  }
  
  public boolean a(ReturnObserver paramReturnObserver) {
    return !this.c.contains(paramReturnObserver) ? this.c.add(paramReturnObserver) : false;
  }
  
  public boolean b(EventObserver paramEventObserver) {
    return this.b.contains(paramEventObserver) ? this.b.remove(paramEventObserver) : false;
  }
  
  public boolean b(ReturnObserver paramReturnObserver) {
    return this.c.contains(paramReturnObserver) ? this.c.remove(paramReturnObserver) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\manager\ObserverMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */