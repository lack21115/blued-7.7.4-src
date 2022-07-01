package com.blued.android.modules;

import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.http.FeedStateObserverProxy;
import com.blued.android.module.base.http.IFeedStateObserver;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import java.util.ArrayList;

public class FeedStateObserverModule {
  static IFeedStateObserver a;
  
  static FeedRefreshObserver.IFeedRefreshObserver b;
  
  private static ArrayList<FeedStateObserverProxy.IFeedStateListener> c = new ArrayList<FeedStateObserverProxy.IFeedStateListener>();
  
  static {
    a = new IFeedStateObserver() {
        public void a(FeedStateObserverProxy.IFeedStateListener param1IFeedStateListener) {
          if (FeedStateObserverModule.b() != null && param1IFeedStateListener != null && !FeedStateObserverModule.b().contains(param1IFeedStateListener))
            FeedStateObserverModule.b().add(param1IFeedStateListener); 
        }
        
        public void b(FeedStateObserverProxy.IFeedStateListener param1IFeedStateListener) {
          if (FeedStateObserverModule.b() != null && param1IFeedStateListener != null && FeedStateObserverModule.b().contains(param1IFeedStateListener))
            FeedStateObserverModule.b().remove(param1IFeedStateListener); 
        }
      };
    b = new FeedRefreshObserver.IFeedRefreshObserver() {
        public void a(Object param1Object, int param1Int) {
          param1Object = FeedStateObserverModule.b().iterator();
          while (param1Object.hasNext()) {
            FeedStateObserverProxy.IFeedStateListener iFeedStateListener = param1Object.next();
            if (iFeedStateListener != null && param1Int == 3)
              iFeedStateListener.ah_(); 
          } 
        }
      };
  }
  
  public static void a() {
    FeedRefreshObserver.a().a(b);
    FeedStateObserverProxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\FeedStateObserverModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */