package com.soft.blued.ui.find.model;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.BlueAppLocal;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;

public class NearbyFeedCity {
  private static NearbyFeedCity mSingleton;
  
  public static String getCityTitle(Context paramContext, String paramString) {
    String str2 = AreaUtils.b(paramString, BlueAppLocal.c());
    paramString = str2;
    if (TextUtils.isEmpty(str2))
      paramString = paramContext.getString(2131755963); 
    String str1 = paramString;
    if (paramString != null) {
      str1 = paramString;
      if (paramString.indexOf("(") > 0)
        str1 = paramString.substring(0, paramString.indexOf("(")); 
    } 
    paramString = str1;
    if (str1 != null) {
      paramString = str1;
      if (str1.indexOf("（") > 0)
        paramString = str1.substring(0, str1.indexOf("（")); 
    } 
    return paramString;
  }
  
  public static NearbyFeedCity getInstance() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/find/model/NearbyFeedCity.mSingleton : Lcom/soft/blued/ui/find/model/NearbyFeedCity;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/find/model/NearbyFeedCity
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/find/model/NearbyFeedCity.mSingleton : Lcom/soft/blued/ui/find/model/NearbyFeedCity;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/find/model/NearbyFeedCity
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/find/model/NearbyFeedCity.mSingleton : Lcom/soft/blued/ui/find/model/NearbyFeedCity;
    //   25: ldc com/soft/blued/ui/find/model/NearbyFeedCity
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/find/model/NearbyFeedCity
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/find/model/NearbyFeedCity.mSingleton : Lcom/soft/blued/ui/find/model/NearbyFeedCity;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public String getLatitude() {
    return BluedPreferences.t();
  }
  
  public String getLongitude() {
    return BluedPreferences.s();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\NearbyFeedCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */