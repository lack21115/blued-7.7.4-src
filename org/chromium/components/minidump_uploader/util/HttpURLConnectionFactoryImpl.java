package org.chromium.components.minidump_uploader.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class HttpURLConnectionFactoryImpl implements HttpURLConnectionFactory {
  public final HttpURLConnection createHttpURLConnection(String paramString) {
    try {
      return (HttpURLConnection)(new URL(paramString)).openConnection();
    } catch (IOException iOException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploade\\util\HttpURLConnectionFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */