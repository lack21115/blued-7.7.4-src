package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.u;
import com.qiniu.pili.droid.shortvideo.f.e;

public class PLShortVideoEnv {
  public static void checkAuthentication(Context paramContext, PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    u.a().a(paramContext);
    u.a().a(paramPLAuthenticationResultCallback);
  }
  
  public static void init(Context paramContext) {
    QosManager.a().b(paramContext);
    u.a().a(paramContext);
  }
  
  public static void setLogLevel(int paramInt) {
    e.a(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoEnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */