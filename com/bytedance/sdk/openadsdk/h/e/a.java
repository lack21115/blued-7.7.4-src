package com.bytedance.sdk.openadsdk.h.e;

import com.bytedance.sdk.openadsdk.h.i;
import java.io.InputStream;
import java.util.List;

public abstract class a {
  List<i.b> a;
  
  f b;
  
  public abstract int a();
  
  protected i.b a(String paramString) {
    if (paramString == null)
      return null; 
    List<i.b> list = this.a;
    if (list != null && list.size() > 0)
      for (i.b b : this.a) {
        if (paramString.equals(b.a))
          return b; 
      }  
    return null;
  }
  
  protected String a(int paramInt) {
    switch (paramInt) {
      default:
        switch (paramInt) {
          default:
            switch (paramInt) {
              default:
                switch (paramInt) {
                  default:
                    return "";
                  case 505:
                    return "HTTP Version Not Supported";
                  case 504:
                    return "Gateway Timeout";
                  case 503:
                    return "Service Unavailable";
                  case 502:
                    return "Bad Gateway";
                  case 501:
                    return "Not Implemented";
                  case 500:
                    break;
                } 
                return "Internal Server Error";
              case 415:
                return "Unsupported Media Type";
              case 414:
                return "Request-URI Too Large";
              case 413:
                return "Request Entity Too Large";
              case 412:
                return "Precondition Failed";
              case 411:
                return "Length Required";
              case 410:
                return "Gone";
              case 409:
                return "Conflict";
              case 408:
                return "Request Time-Out";
              case 407:
                return "Proxy Authentication Required";
              case 406:
                return "Not Acceptable";
              case 405:
                return "Method Not Allowed";
              case 404:
                return "Not Found";
              case 403:
                return "Forbidden";
              case 402:
                return "Payment Required";
              case 401:
                return "Unauthorized";
              case 400:
                break;
            } 
            return "Bad Request";
          case 305:
            return "Use Proxy";
          case 304:
            return "Not Modified";
          case 303:
            return "See Other";
          case 302:
            return "Temporary Redirect";
          case 301:
            return "Moved Permanently";
          case 300:
            break;
        } 
        return "Multiple Choices";
      case 206:
        return "Partial Content";
      case 205:
        return "Reset Content";
      case 204:
        return "No Content";
      case 203:
        return "Non-Authoritative";
      case 202:
        return "Accepted";
      case 201:
        return "Created";
      case 200:
        break;
    } 
    return "OK";
  }
  
  public abstract String a(String paramString1, String paramString2);
  
  public abstract boolean b();
  
  public abstract List<i.b> c();
  
  public abstract InputStream d();
  
  public abstract String e();
  
  public abstract String f();
  
  public f g() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */