package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class CacheStrategy {
  public final Response cacheResponse;
  
  public final Request networkRequest;
  
  private CacheStrategy(Request paramRequest, Response paramResponse) {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest) {
    int i = paramResponse.code();
    boolean bool2 = false;
    if (i != 200 && i != 410 && i != 414 && i != 501 && i != 203 && i != 204)
      if (i != 307) {
        if (i != 308 && i != 404 && i != 405)
          switch (i) {
            default:
              return false;
            case 302:
              if (paramResponse.header("Expires") != null || paramResponse.cacheControl().maxAgeSeconds() != -1 || paramResponse.cacheControl().isPublic() || paramResponse.cacheControl().isPrivate())
                break; 
              return false;
            case 300:
            case 301:
              break;
          }  
      } else {
      
      }  
    boolean bool1 = bool2;
    if (!paramResponse.cacheControl().noStore()) {
      bool1 = bool2;
      if (!paramRequest.cacheControl().noStore())
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static class Factory {
    private int ageSeconds = -1;
    
    final Response cacheResponse;
    
    private String etag;
    
    private Date expires;
    
    private Date lastModified;
    
    private String lastModifiedString;
    
    final long nowMillis;
    
    private long receivedResponseMillis;
    
    final Request request;
    
    private long sentRequestMillis;
    
    private Date servedDate;
    
    private String servedDateString;
    
    public Factory(long param1Long, Request param1Request, Response param1Response) {
      this.nowMillis = param1Long;
      this.request = param1Request;
      this.cacheResponse = param1Response;
      if (param1Response != null) {
        Headers headers = param1Response.headers();
        int i = 0;
        int j = headers.size();
        while (i < j) {
          String str1 = headers.name(i);
          String str2 = headers.value(i);
          if ("Date".equalsIgnoreCase(str1)) {
            this.servedDate = HttpDate.parse(str2);
            this.servedDateString = str2;
          } else if ("Expires".equalsIgnoreCase(str1)) {
            this.expires = HttpDate.parse(str2);
          } else if ("Last-Modified".equalsIgnoreCase(str1)) {
            this.lastModified = HttpDate.parse(str2);
            this.lastModifiedString = str2;
          } else if ("ETag".equalsIgnoreCase(str1)) {
            this.etag = str2;
          } else if ("Age".equalsIgnoreCase(str1)) {
            this.ageSeconds = HeaderParser.parseSeconds(str2, -1);
          } else if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(str1)) {
            this.sentRequestMillis = Long.parseLong(str2);
          } else if (OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(str1)) {
            this.receivedResponseMillis = Long.parseLong(str2);
          } 
          i++;
        } 
      } 
    }
    
    private long cacheResponseAge() {
      Date date = this.servedDate;
      long l1 = 0L;
      if (date != null)
        l1 = Math.max(0L, this.receivedResponseMillis - date.getTime()); 
      long l2 = l1;
      if (this.ageSeconds != -1)
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.ageSeconds)); 
      l1 = this.receivedResponseMillis;
      return l2 + l1 - this.sentRequestMillis + this.nowMillis - l1;
    }
    
    private long computeFreshnessLifetime() {
      CacheControl cacheControl = this.cacheResponse.cacheControl();
      if (cacheControl.maxAgeSeconds() != -1)
        return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()); 
      Date date = this.expires;
      long l1 = 0L;
      if (date != null) {
        date = this.servedDate;
        if (date != null) {
          l = date.getTime();
        } else {
          l = this.receivedResponseMillis;
        } 
        long l = this.expires.getTime() - l;
        if (l > 0L)
          l1 = l; 
        return l1;
      } 
      long l2 = l1;
      if (this.lastModified != null) {
        l2 = l1;
        if (this.cacheResponse.request().httpUrl().query() == null) {
          date = this.servedDate;
          if (date != null) {
            l2 = date.getTime();
          } else {
            l2 = this.sentRequestMillis;
          } 
          long l = l2 - this.lastModified.getTime();
          l2 = l1;
          if (l > 0L)
            l2 = l / 10L; 
        } 
      } 
      return l2;
    }
    
    private CacheStrategy getCandidate() {
      if (this.cacheResponse == null)
        return new CacheStrategy(this.request, null); 
      if (this.request.isHttps() && this.cacheResponse.handshake() == null)
        return new CacheStrategy(this.request, null); 
      if (!CacheStrategy.isCacheable(this.cacheResponse, this.request))
        return new CacheStrategy(this.request, null); 
      CacheControl cacheControl1 = this.request.cacheControl();
      if (cacheControl1.noCache() || hasConditions(this.request))
        return new CacheStrategy(this.request, null); 
      long l5 = cacheResponseAge();
      long l2 = computeFreshnessLifetime();
      long l1 = l2;
      if (cacheControl1.maxAgeSeconds() != -1)
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(cacheControl1.maxAgeSeconds())); 
      int i = cacheControl1.minFreshSeconds();
      long l4 = 0L;
      if (i != -1) {
        l2 = TimeUnit.SECONDS.toMillis(cacheControl1.minFreshSeconds());
      } else {
        l2 = 0L;
      } 
      CacheControl cacheControl2 = this.cacheResponse.cacheControl();
      long l3 = l4;
      if (!cacheControl2.mustRevalidate()) {
        l3 = l4;
        if (cacheControl1.maxStaleSeconds() != -1)
          l3 = TimeUnit.SECONDS.toMillis(cacheControl1.maxStaleSeconds()); 
      } 
      if (!cacheControl2.noCache()) {
        l2 += l5;
        if (l2 < l3 + l1) {
          Response.Builder builder1 = this.cacheResponse.newBuilder();
          if (l2 >= l1)
            builder1.addHeader("Warning", "110 HttpURLConnection \"Response is stale\""); 
          if (l5 > 86400000L && isFreshnessLifetimeHeuristic())
            builder1.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\""); 
          return new CacheStrategy(null, builder1.build());
        } 
      } 
      Request.Builder builder = this.request.newBuilder();
      String str = this.etag;
      if (str != null) {
        builder.header("If-None-Match", str);
      } else if (this.lastModified != null) {
        builder.header("If-Modified-Since", this.lastModifiedString);
      } else if (this.servedDate != null) {
        builder.header("If-Modified-Since", this.servedDateString);
      } 
      Request request = builder.build();
      return hasConditions(request) ? new CacheStrategy(request, this.cacheResponse) : new CacheStrategy(request, null);
    }
    
    private static boolean hasConditions(Request param1Request) {
      return (param1Request.header("If-Modified-Since") != null || param1Request.header("If-None-Match") != null);
    }
    
    private boolean isFreshnessLifetimeHeuristic() {
      return (this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null);
    }
    
    public CacheStrategy get() {
      CacheStrategy cacheStrategy2 = getCandidate();
      CacheStrategy cacheStrategy1 = cacheStrategy2;
      if (cacheStrategy2.networkRequest != null) {
        cacheStrategy1 = cacheStrategy2;
        if (this.request.cacheControl().onlyIfCached())
          cacheStrategy1 = new CacheStrategy(null, null); 
      } 
      return cacheStrategy1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\http\CacheStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */