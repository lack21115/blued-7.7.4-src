package com.blued.android.modules;

import android.content.Context;
import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.ui.IPopMenuFromCenter;
import com.blued.android.module.base.ui.PopMenuFromCenterProxy;
import com.soft.blued.utils.PopMenuUtils;

public class PopMenuFromCenterModule {
  protected static IPopMenuFromCenter a = new IPopMenuFromCenter() {
      public boolean a(Context param1Context) {
        return PopMenuUtils.a(param1Context);
      }
    };
  
  public static void a() {
    PopMenuFromCenterProxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\PopMenuFromCenterModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */