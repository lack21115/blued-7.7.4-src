package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.lang.reflect.Constructor;

class a {
  public static BaseRewardAd a(String paramString1, Context paramContext, String paramString2, String paramString3) throws Exception {
    Constructor<BaseRewardAd> constructor = Class.forName(paramString1).<BaseRewardAd>asSubclass(BaseRewardAd.class).getDeclaredConstructor(new Class[] { Context.class, String.class, String.class });
    constructor.setAccessible(true);
    return constructor.newInstance(new Object[] { paramContext, paramString2, paramString3 });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */