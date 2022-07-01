package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;

public final class Common {
  public static final Api<Api.ApiOptions.NoOptions> API;
  
  public static final Api.ClientKey<zaj> CLIENT_KEY = new Api.ClientKey();
  
  public static final zad zaa;
  
  private static final Api.AbstractClientBuilder<zaj, Api.ApiOptions.NoOptions> zab = new zab();
  
  static {
    API = new Api("Common.API", zab, CLIENT_KEY);
    zaa = new zac();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\service\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */