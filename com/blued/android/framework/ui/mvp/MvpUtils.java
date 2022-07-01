package com.blued.android.framework.ui.mvp;

import android.os.Looper;
import java.util.List;

public class MvpUtils {
  public static <T> void a(List<List> paramList, Class<T> paramClass, DataHandler<T> paramDataHandler) {
    if (paramList != null && paramList.size() > 0) {
      paramList = paramList.get(0);
      if (paramClass.isInstance(paramList)) {
        paramDataHandler.a((T)paramList);
        return;
      } 
    } 
    paramDataHandler.a();
  }
  
  public static <T> void a(List<T> paramList, Class<T> paramClass, DataListHandler<T> paramDataListHandler) {
    if (paramList != null && paramList.size() > 0 && paramClass.isInstance(paramList.get(0))) {
      paramDataListHandler.a(paramList);
      return;
    } 
    paramDataListHandler.a();
  }
  
  public static boolean a() {
    return (Thread.currentThread() == Looper.getMainLooper().getThread());
  }
  
  public static interface DataHandler<T> {
    void a();
    
    void a(T param1T);
  }
  
  public static interface DataListHandler<T> {
    void a();
    
    void a(List<T> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\mvp\MvpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */