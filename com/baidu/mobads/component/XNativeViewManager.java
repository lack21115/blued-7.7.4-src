package com.baidu.mobads.component;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class XNativeViewManager {
  private static XNativeViewManager sInstance;
  
  private CopyOnWriteArrayList<XNativeView> mViewList;
  
  public static XNativeViewManager getInstance() {
    // Byte code:
    //   0: getstatic com/baidu/mobads/component/XNativeViewManager.sInstance : Lcom/baidu/mobads/component/XNativeViewManager;
    //   3: ifnonnull -> 50
    //   6: ldc com/baidu/mobads/component/XNativeViewManager
    //   8: monitorenter
    //   9: getstatic com/baidu/mobads/component/XNativeViewManager.sInstance : Lcom/baidu/mobads/component/XNativeViewManager;
    //   12: ifnonnull -> 38
    //   15: new com/baidu/mobads/component/XNativeViewManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/baidu/mobads/component/XNativeViewManager.sInstance : Lcom/baidu/mobads/component/XNativeViewManager;
    //   25: getstatic com/baidu/mobads/component/XNativeViewManager.sInstance : Lcom/baidu/mobads/component/XNativeViewManager;
    //   28: new java/util/concurrent/CopyOnWriteArrayList
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: putfield mViewList : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   38: ldc com/baidu/mobads/component/XNativeViewManager
    //   40: monitorexit
    //   41: goto -> 50
    //   44: astore_0
    //   45: ldc com/baidu/mobads/component/XNativeViewManager
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    //   50: getstatic com/baidu/mobads/component/XNativeViewManager.sInstance : Lcom/baidu/mobads/component/XNativeViewManager;
    //   53: areturn
    // Exception table:
    //   from	to	target	type
    //   9	38	44	finally
    //   38	41	44	finally
    //   45	48	44	finally
  }
  
  public void addItem(XNativeView paramXNativeView) {
    this.mViewList.add(paramXNativeView);
  }
  
  public void removeNativeView(XNativeView paramXNativeView) {
    CopyOnWriteArrayList<XNativeView> copyOnWriteArrayList = this.mViewList;
    if (copyOnWriteArrayList != null) {
      if (copyOnWriteArrayList.size() == 0)
        return; 
      Iterator<XNativeView> iterator = this.mViewList.iterator();
      while (iterator.hasNext()) {
        if ((XNativeView)iterator.next() == paramXNativeView)
          this.mViewList.remove(paramXNativeView); 
      } 
    } 
  }
  
  public void resetAllPlayer(XNativeView paramXNativeView) {
    CopyOnWriteArrayList<XNativeView> copyOnWriteArrayList = this.mViewList;
    if (copyOnWriteArrayList != null) {
      if (copyOnWriteArrayList.size() == 0)
        return; 
      for (XNativeView xNativeView : this.mViewList) {
        if (xNativeView != paramXNativeView) {
          xNativeView.stop();
          xNativeView.handleCover();
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\component\XNativeViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */