package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.lang.reflect.Constructor;

class b {
  public static BaseInterstitialAd a(String paramString1, Activity paramActivity, String paramString2, String paramString3) throws Exception {
    Constructor<BaseInterstitialAd> constructor = Class.forName(paramString1).<BaseInterstitialAd>asSubclass(BaseInterstitialAd.class).getDeclaredConstructor(new Class[] { Activity.class, String.class, String.class });
    constructor.setAccessible(true);
    return constructor.newInstance(new Object[] { paramActivity, paramString2, paramString3 });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */