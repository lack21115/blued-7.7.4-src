package com.qiniu.android.dns;

import java.io.IOException;

public interface IResolver {
  public static final int DNS_DEFAULT_TIMEOUT = 10;
  
  Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\IResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */