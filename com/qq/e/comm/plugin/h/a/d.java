package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;

public class d extends b {
  public String a(Context paramContext) {
    String str = b(paramContext);
    return !TextUtils.isEmpty(str) ? Md5Util.encode(str) : null;
  }
  
  protected boolean a() {
    return (GDTADManager.getInstance().getSM().getInteger("adidon", 1) == 1);
  }
  
  protected String c(Context paramContext) {
    try {
      return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } finally {
      paramContext = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AndroidIDReader Exception:");
      stringBuilder.append(paramContext.getMessage());
      GDTLogger.d(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\h\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */