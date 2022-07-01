package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;

class a {
  public static BaseNativeExpressAd a(String paramString1, ADSize paramADSize, Context paramContext, String paramString2, String paramString3) throws Exception {
    return Class.forName(paramString1).<BaseNativeExpressAd>asSubclass(BaseNativeExpressAd.class).getDeclaredConstructor(new Class[] { Context.class, ADSize.class, String.class, String.class }).newInstance(new Object[] { paramContext, paramADSize, paramString2, paramString3 });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */