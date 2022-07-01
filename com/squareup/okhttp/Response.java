package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.OkHeaders;
import java.util.Collections;
import java.util.List;

public final class Response {
  private final ResponseBody body;
  
  private volatile CacheControl cacheControl;
  
  private Response cacheResponse;
  
  private final int code;
  
  private final Handshake handshake;
  
  private final Headers headers;
  
  private final String message;
  
  private Response networkResponse;
  
  private final Response priorResponse;
  
  private final Protocol protocol;
  
  private final Request request;
  
  private Response(Builder paramBuilder) {
    this.request = paramBuilder.request;
    this.protocol = paramBuilder.protocol;
    this.code = paramBuilder.code;
    this.message = paramBuilder.message;
    this.handshake = paramBuilder.handshake;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.networkResponse = paramBuilder.networkResponse;
    this.cacheResponse = paramBuilder.cacheResponse;
    this.priorResponse = paramBuilder.priorResponse;
  }
  
  public ResponseBody body() {
    return this.body;
  }
  
  public CacheControl cacheControl() {
    CacheControl cacheControl = this.cacheControl;
    if (cacheControl != null)
      return cacheControl; 
    cacheControl = CacheControl.parse(this.headers);
    this.cacheControl = cacheControl;
    return cacheControl;
  }
  
  public Response cacheResponse() {
    return this.cacheResponse;
  }
  
  public List<Challenge> challenges() {
    String str;
    int i = this.code;
    if (i == 401) {
      str = "WWW-Authenticate";
    } else {
      if (i == 407) {
        str = "Proxy-Authenticate";
        return OkHeaders.parseChallenges(headers(), str);
      } 
      return Collections.emptyList();
    } 
    return OkHeaders.parseChallenges(headers(), str);
  }
  
  public int code() {
    return this.code;
  }
  
  public Handshake handshake() {
    return this.handshake;
  }
  
  public String header(String paramString) {
    return header(paramString, null);
  }
  
  public String header(String paramString1, String paramString2) {
    paramString1 = this.headers.get(paramString1);
    return (paramString1 != null) ? paramString1 : paramString2;
  }
  
  public Headers headers() {
    return this.headers;
  }
  
  public List<String> headers(String paramString) {
    return this.headers.values(paramString);
  }
  
  public boolean isRedirect() {
    int i = this.code;
    if (i != 307 && i != 308)
      switch (i) {
        default:
          return false;
        case 300:
        case 301:
        case 302:
        case 303:
          break;
      }  
    return true;
  }
  
  public boolean isSuccessful() {
    int i = this.code;
    return (i >= 200 && i < 300);
  }
  
  public String message() {
    return this.message;
  }
  
  public Response networkResponse() {
    return this.networkResponse;
  }
  
  public Builder newBuilder() {
    return new Builder(this);
  }
  
  public Response priorResponse() {
    return this.priorResponse;
  }
  
  public Protocol protocol() {
    return this.protocol;
  }
  
  public Request request() {
    return this.request;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Response{protocol=");
    stringBuilder.append(this.protocol);
    stringBuilder.append(", code=");
    stringBuilder.append(this.code);
    stringBuilder.append(", message=");
    stringBuilder.append(this.message);
    stringBuilder.append(", url=");
    stringBuilder.append(this.request.urlString());
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static class Builder {
    private ResponseBody body;
    
    private Response cacheResponse;
    
    private int code = -1;
    
    private Handshake handshake;
    
    private Headers.Builder headers;
    
    private String message;
    
    private Response networkResponse;
    
    private Response priorResponse;
    
    private Protocol protocol;
    
    private Request request;
    
    public Builder() {
      this.headers = new Headers.Builder();
    }
    
    private Builder(Response param1Response) {
      this.request = param1Response.request;
      this.protocol = param1Response.protocol;
      this.code = param1Response.code;
      this.message = param1Response.message;
      this.handshake = param1Response.handshake;
      this.headers = param1Response.headers.newBuilder();
      this.body = param1Response.body;
      this.networkResponse = param1Response.networkResponse;
      this.cacheResponse = param1Response.cacheResponse;
      this.priorResponse = param1Response.priorResponse;
    }
    
    private void checkPriorResponse(Response param1Response) {
      if (param1Response.body == null)
        return; 
      throw new IllegalArgumentException("priorResponse.body != null");
    }
    
    private void checkSupportResponse(String param1String, Response param1Response) {
      if (param1Response.body == null) {
        if (param1Response.networkResponse == null) {
          if (param1Response.cacheResponse == null) {
            if (param1Response.priorResponse == null)
              return; 
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(param1String);
            stringBuilder3.append(".priorResponse != null");
            throw new IllegalArgumentException(stringBuilder3.toString());
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(param1String);
          stringBuilder2.append(".cacheResponse != null");
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(param1String);
        stringBuilder1.append(".networkResponse != null");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append(".body != null");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder addHeader(String param1String1, String param1String2) {
      this.headers.add(param1String1, param1String2);
      return this;
    }
    
    public Builder body(ResponseBody param1ResponseBody) {
      this.body = param1ResponseBody;
      return this;
    }
    
    public Response build() {
      if (this.request != null) {
        if (this.protocol != null) {
          if (this.code >= 0)
            return new Response(this); 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("code < 0: ");
          stringBuilder.append(this.code);
          throw new IllegalStateException(stringBuilder.toString());
        } 
        throw new IllegalStateException("protocol == null");
      } 
      throw new IllegalStateException("request == null");
    }
    
    public Builder cacheResponse(Response param1Response) {
      if (param1Response != null)
        checkSupportResponse("cacheResponse", param1Response); 
      this.cacheResponse = param1Response;
      return this;
    }
    
    public Builder code(int param1Int) {
      this.code = param1Int;
      return this;
    }
    
    public Builder handshake(Handshake param1Handshake) {
      this.handshake = param1Handshake;
      return this;
    }
    
    public Builder header(String param1String1, String param1String2) {
      this.headers.set(param1String1, param1String2);
      return this;
    }
    
    public Builder headers(Headers param1Headers) {
      this.headers = param1Headers.newBuilder();
      return this;
    }
    
    public Builder message(String param1String) {
      this.message = param1String;
      return this;
    }
    
    public Builder networkResponse(Response param1Response) {
      if (param1Response != null)
        checkSupportResponse("networkResponse", param1Response); 
      this.networkResponse = param1Response;
      return this;
    }
    
    public Builder priorResponse(Response param1Response) {
      if (param1Response != null)
        checkPriorResponse(param1Response); 
      this.priorResponse = param1Response;
      return this;
    }
    
    public Builder protocol(Protocol param1Protocol) {
      this.protocol = param1Protocol;
      return this;
    }
    
    public Builder removeHeader(String param1String) {
      this.headers.removeAll(param1String);
      return this;
    }
    
    public Builder request(Request param1Request) {
      this.request = param1Request;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */