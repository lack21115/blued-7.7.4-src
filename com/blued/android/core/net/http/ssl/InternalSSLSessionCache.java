package com.blued.android.core.net.http.ssl;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.conscrypt.FileClientSessionCache;
import org.conscrypt.SSLClientSessionCache;

public final class InternalSSLSessionCache {
  public final SSLClientSessionCache a;
  
  public InternalSSLSessionCache(Context paramContext) {
    File file = paramContext.getDir("sslcache", 0);
    try {
      SSLClientSessionCache sSLClientSessionCache = FileClientSessionCache.usingDirectory(file);
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to create SSL session cache in ");
      stringBuilder.append(file);
      Log.w("SSLSessionCache", stringBuilder.toString(), iOException);
      iOException = null;
    } 
    this.a = (SSLClientSessionCache)iOException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\ssl\InternalSSLSessionCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */