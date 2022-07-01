package com.soft.blued.utils.third;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.soft.blued.http.BluedHttpUrl;
import com.youzan.androidsdk.YouzanSDK;
import com.youzan.androidsdk.YouzanSDKAdapter;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdkx5.YouZanSDKX5Adapter;

public class YouZanUtils {
  public static void a() {
    if (!YouzanSDK.isReady()) {
      BluedHttpUrl.h();
      BluedHttpUrl.h();
      YouzanSDK.init(AppInfo.d(), "edf395742e546a9610", "2649fdcf02a343afb844ce82af30b843", (YouzanSDKAdapter)new YouZanSDKX5Adapter());
    } 
  }
  
  public static void a(Context paramContext, YouzanToken paramYouzanToken) {
    YouzanSDK.sync(paramContext, paramYouzanToken);
  }
  
  public static void b() {
    if (YouzanSDK.isReady())
      YouzanSDK.userLogout(AppInfo.d()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\third\YouZanUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */