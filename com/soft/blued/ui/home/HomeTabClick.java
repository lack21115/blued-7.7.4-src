package com.soft.blued.ui.home;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewConfiguration;
import androidx.collection.ArrayMap;
import java.util.Map;

public class HomeTabClick {
  private static int a = ViewConfiguration.getDoubleTapTimeout();
  
  private static boolean b = false;
  
  private static Class c;
  
  private static Map<String, TabClickListener> d;
  
  private static Handler e;
  
  private static String f;
  
  public static void a() {
    Map<String, TabClickListener> map = d;
    if (map != null) {
      map.clear();
      d = null;
    } 
    c = null;
    b = false;
  }
  
  public static void a(Class paramClass) {
    c = paramClass;
    d = (Map<String, TabClickListener>)new ArrayMap();
    b = true;
    e = new UIHandler();
  }
  
  public static void a(String paramString) {
    if (!b)
      return; 
    if (e.hasMessages(1) && paramString.equals(f)) {
      e.removeMessages(1);
      Handler handler1 = e;
      handler1.sendMessage(handler1.obtainMessage(2, paramString));
      return;
    } 
    f = paramString;
    Handler handler = e;
    handler.sendMessageDelayed(handler.obtainMessage(1, paramString), a);
  }
  
  public static void a(String paramString, TabClickListener paramTabClickListener) {
    if (!b)
      return; 
    d.put(paramString, paramTabClickListener);
  }
  
  public static void b(String paramString, TabClickListener paramTabClickListener) {
    if (!b)
      return; 
    TabClickListener tabClickListener = d.get(paramString);
    if (tabClickListener != null && tabClickListener == paramTabClickListener)
      d.remove(paramString); 
  }
  
  public static interface TabClickListener {
    void c(String param1String);
    
    void d(String param1String);
  }
  
  static class UIHandler extends Handler {
    public UIHandler() {
      super(Looper.getMainLooper());
    }
    
    public void handleMessage(Message param1Message) {
      String str;
      int i = param1Message.what;
      if (i != 1) {
        if (i != 2)
          return; 
        str = (String)param1Message.obj;
        if (HomeTabClick.b() != null) {
          HomeTabClick.TabClickListener tabClickListener = (HomeTabClick.TabClickListener)HomeTabClick.b().get(str);
          if (tabClickListener != null) {
            tabClickListener.d(str);
            return;
          } 
        } 
      } else {
        str = (String)((Message)str).obj;
        if (HomeTabClick.b() != null) {
          HomeTabClick.TabClickListener tabClickListener = (HomeTabClick.TabClickListener)HomeTabClick.b().get(str);
          if (tabClickListener != null)
            tabClickListener.c(str); 
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\HomeTabClick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */