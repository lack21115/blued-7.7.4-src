package com.blued.android.modules;

import android.content.Context;
import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.live.ILiveFloatManager;
import com.blued.android.module.base.live.LiveFloatManagerProxy;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.ui.msg.DialogSkipFragment;

public class LiveFloatManagerModule {
  protected static ILiveFloatManager a = new ILiveFloatManager() {
      public boolean a(Context param1Context) {
        if (LiveFloatManager.a().F()) {
          DialogSkipFragment.a(param1Context, 4);
          return true;
        } 
        return false;
      }
    };
  
  public static void a() {
    LiveFloatManagerProxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\LiveFloatManagerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */