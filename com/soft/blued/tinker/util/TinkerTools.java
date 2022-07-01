package com.soft.blued.tinker.util;

import com.blued.android.core.AppInfo;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.TinkerRuntimeException;

public class TinkerTools {
  public static String a() {
    try {
      Tinker tinker = Tinker.with(AppInfo.d());
      if (tinker != null && tinker.isTinkerLoaded())
        return tinker.getTinkerLoadResultIfPresent().getPackageConfigByName("patchCode"); 
    } catch (TinkerRuntimeException tinkerRuntimeException) {
      tinkerRuntimeException.printStackTrace();
    } 
    return "0";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinke\\util\TinkerTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */