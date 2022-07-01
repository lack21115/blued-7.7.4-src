package com.blued.android.core.net.http;

import java.io.IOException;

public class StatusCode {
  public static int a(IOException paramIOException) {
    if (paramIOException != null) {
      if (paramIOException instanceof java.net.SocketException)
        return (paramIOException instanceof java.net.ConnectException) ? -2020 : ((paramIOException instanceof java.net.NoRouteToHostException) ? -2022 : ((paramIOException instanceof java.net.PortUnreachableException) ? -2023 : ((paramIOException instanceof java.net.BindException) ? -2025 : -2014))); 
      if (paramIOException instanceof java.io.InterruptedIOException)
        return (paramIOException instanceof java.net.SocketTimeoutException) ? -2019 : -2015; 
      if (paramIOException instanceof javax.net.ssl.SSLException)
        return -2016; 
      if (paramIOException instanceof java.io.EOFException)
        return -2017; 
      if (paramIOException instanceof java.io.FileNotFoundException)
        return -2012; 
      if (paramIOException instanceof java.net.UnknownHostException)
        return -2013; 
      if (paramIOException instanceof java.net.UnknownServiceException)
        return -2021; 
      if (paramIOException instanceof java.net.HttpRetryException)
        return -2018; 
      if (paramIOException instanceof java.net.ProtocolException)
        return -2024; 
    } 
    return -2011;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\StatusCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */