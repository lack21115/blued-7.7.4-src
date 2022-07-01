package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.p.a;

public class g {
  public static String a(e parame) {
    String str1;
    int i = null.a[parame.ordinal()];
    String str3 = "nativeAdLogo_";
    if (i != 1) {
      str1 = str3;
      if (i != 2)
        if (i != 3 && i != 4) {
          str1 = str3;
        } else {
          str1 = "rewardAdLogo_";
        }  
    } else {
      str1 = "splashAdLogo_";
    } 
    SM sM = GDTADManager.getInstance().getSM();
    if (sM != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append("logo");
      str1 = sM.getString(stringBuilder.toString());
    } else {
      str1 = null;
    } 
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      i = null.a[parame.ordinal()];
      if (i != 1)
        return (i == 2 || (i != 3 && i != 4)) ? "http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkNativeAdLogo.png" : "http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkRewardAdLogo.png"; 
      str2 = "http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkSplashAdLogo.png";
    } 
    return str2;
  }
  
  public static void a(ImageView paramImageView) {
    a.a().a("http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkRewardBrowseAdLogo.png", paramImageView);
  }
  
  public static void a(ImageView paramImageView, e parame) {
    String str = a(parame);
    if (paramImageView != null && !TextUtils.isEmpty(str))
      a.a().a(str, paramImageView); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */