package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class GDTAD {
  private static boolean a = false;
  
  private static InitListener b;
  
  private static PM.a.a c = new PM.a.a() {
      public final void onLoadFail() {
        GDTLogger.w("Init fail", null);
      }
      
      public final void onLoadSuccess() {
        GDTAD.a(true);
        if (GDTAD.a() != null)
          GDTAD.a().onSuccess(); 
      }
    };
  
  public static void initSDK(Context paramContext, String paramString, InitListener paramInitListener) {
    String str;
    if (a) {
      GDTLogger.w("SDK已经被初始化过", null);
      return;
    } 
    if (paramContext == null) {
      str = "Context参数不能为null";
    } else if (StringUtil.isEmpty(paramString)) {
      str = "AppId参数不能为空";
    } else {
      b = paramInitListener;
      GDTADManager gDTADManager = GDTADManager.getInstance();
      gDTADManager.setPluginLoadListener(c);
      gDTADManager.initWith(str.getApplicationContext(), paramString);
      return;
    } 
    GDTLogger.e(str);
  }
  
  public static interface InitListener {
    void onSuccess();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\cfg\GDTAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */