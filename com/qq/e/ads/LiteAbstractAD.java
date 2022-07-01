package com.qq.e.ads;

import android.content.Context;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

public abstract class LiteAbstractAD<T> {
  private T a;
  
  protected abstract T a(Context paramContext, POFactory paramPOFactory, String paramString1, String paramString2);
  
  protected abstract void a(int paramInt);
  
  protected final void a(Context paramContext, String paramString1, String paramString2) {
    if (!a.a(paramContext)) {
      GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
      a(4002);
      return;
    } 
    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, paramContext, paramString1, paramString2) {
          public void run() {
            int i;
            LiteAbstractAD liteAbstractAD;
            if (GDTADManager.getInstance().initWith(this.a, this.b)) {
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.e("Exception while init plugin", exception);
                liteAbstractAD = this.d;
              } 
            } else {
              GDTLogger.e("Fail to init ADManager");
              liteAbstractAD = this.d;
              i = 200101;
            } 
            liteAbstractAD.a(i);
          }
        });
  }
  
  protected abstract void a(T paramT);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\LiteAbstractAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */