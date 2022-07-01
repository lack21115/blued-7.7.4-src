package com.qiniu.android.http;

import com.qiniu.android.collect.LogHandler;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public class HttpEventListener extends EventListener {
  public static final EventListener.Factory FACTORY = new EventListener.Factory() {
      final AtomicLong nextCallId = new AtomicLong(1L);
      
      public EventListener create(Call param1Call) {
        return new HttpEventListener(this.nextCallId.getAndIncrement(), (Client.ResponseTag)param1Call.a().e(), System.nanoTime());
      }
    };
  
  private long callId = 1L;
  
  private final long callStartNanos;
  
  private long connect_elapsed_time;
  
  private long dns_elapsed_time;
  
  private LogHandler logHandler;
  
  private long request_elapsed_time;
  
  private Client.ResponseTag responseTag;
  
  private long response_elapsed_time;
  
  private long start_connect_elapsed_time;
  
  private long start_dns_elapsed_time;
  
  private long start_request_elapsed_time;
  
  private long start_response_elapsed_time;
  
  private long start_tls_connect_elapsed_time;
  
  private long start_total_elapsed_time;
  
  private long tls_connect_elapsed_time;
  
  private long total_elapsed_time;
  
  private long wait_elapsed_time;
  
  public HttpEventListener(long paramLong1, Client.ResponseTag paramResponseTag, long paramLong2) {
    this.callId = paramLong1;
    this.callStartNanos = paramLong2;
    this.responseTag = paramResponseTag;
    if (paramResponseTag.logHandler == null) {
      this.logHandler = new LogHandler() {
          public Object getUploadInfo() {
            return null;
          }
          
          public void send(String param1String, Object param1Object) {}
        };
      return;
    } 
    this.logHandler = paramResponseTag.logHandler;
  }
  
  public void callEnd(Call paramCall) {
    super.callEnd(paramCall);
    this.total_elapsed_time = System.currentTimeMillis() - this.start_total_elapsed_time;
    this.logHandler.send("total_elapsed_time", Long.valueOf(this.total_elapsed_time));
  }
  
  public void callFailed(Call paramCall, IOException paramIOException) {
    super.callFailed(paramCall, paramIOException);
  }
  
  public void callStart(Call paramCall) {
    super.callStart(paramCall);
    this.start_total_elapsed_time = System.currentTimeMillis();
  }
  
  public void connectEnd(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, Protocol paramProtocol) {
    super.connectEnd(paramCall, paramInetSocketAddress, paramProxy, paramProtocol);
    this.connect_elapsed_time = System.currentTimeMillis() - this.start_connect_elapsed_time;
    this.logHandler.send("connect_elapsed_time", Long.valueOf(this.connect_elapsed_time));
  }
  
  public void connectFailed(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, Protocol paramProtocol, IOException paramIOException) {
    super.connectFailed(paramCall, paramInetSocketAddress, paramProxy, paramProtocol, paramIOException);
  }
  
  public void connectStart(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy) {
    super.connectStart(paramCall, paramInetSocketAddress, paramProxy);
    this.start_connect_elapsed_time = System.currentTimeMillis();
  }
  
  public void connectionAcquired(Call paramCall, Connection paramConnection) {
    super.connectionAcquired(paramCall, paramConnection);
  }
  
  public void connectionReleased(Call paramCall, Connection paramConnection) {
    super.connectionReleased(paramCall, paramConnection);
  }
  
  public void dnsEnd(Call paramCall, String paramString, List<InetAddress> paramList) {
    super.dnsEnd(paramCall, paramString, paramList);
    this.dns_elapsed_time = System.currentTimeMillis() - this.start_dns_elapsed_time;
    this.logHandler.send("dns_elapsed_time", Long.valueOf(this.dns_elapsed_time));
  }
  
  public void dnsStart(Call paramCall, String paramString) {
    super.dnsStart(paramCall, paramString);
    this.start_dns_elapsed_time = System.currentTimeMillis();
  }
  
  public void requestBodyEnd(Call paramCall, long paramLong) {
    super.requestBodyEnd(paramCall, paramLong);
    this.request_elapsed_time = System.currentTimeMillis() - this.start_request_elapsed_time;
    this.logHandler.send("request_elapsed_time", Long.valueOf(this.request_elapsed_time));
  }
  
  public void requestBodyStart(Call paramCall) {
    super.requestBodyStart(paramCall);
  }
  
  public void requestHeadersEnd(Call paramCall, Request paramRequest) {
    super.requestHeadersEnd(paramCall, paramRequest);
  }
  
  public void requestHeadersStart(Call paramCall) {
    super.requestHeadersStart(paramCall);
    this.start_request_elapsed_time = System.currentTimeMillis();
  }
  
  public void responseBodyEnd(Call paramCall, long paramLong) {
    super.responseBodyEnd(paramCall, paramLong);
    this.response_elapsed_time = System.currentTimeMillis() - this.start_response_elapsed_time;
    this.wait_elapsed_time = System.currentTimeMillis() - this.start_request_elapsed_time;
    this.logHandler.send("response_elapsed_time", Long.valueOf(this.response_elapsed_time));
    this.logHandler.send("wait_elapsed_time", Long.valueOf(this.wait_elapsed_time));
  }
  
  public void responseBodyStart(Call paramCall) {
    super.responseBodyStart(paramCall);
  }
  
  public void responseHeadersEnd(Call paramCall, Response paramResponse) {
    super.responseHeadersEnd(paramCall, paramResponse);
  }
  
  public void responseHeadersStart(Call paramCall) {
    super.responseHeadersStart(paramCall);
    this.start_response_elapsed_time = System.currentTimeMillis();
  }
  
  public void secureConnectEnd(Call paramCall, Handshake paramHandshake) {
    super.secureConnectEnd(paramCall, paramHandshake);
    this.tls_connect_elapsed_time = System.currentTimeMillis() - this.start_tls_connect_elapsed_time;
    this.logHandler.send("tls_connect_elapsed_time", Long.valueOf(this.tls_connect_elapsed_time));
  }
  
  public void secureConnectStart(Call paramCall) {
    super.secureConnectStart(paramCall);
    this.start_tls_connect_elapsed_time = System.currentTimeMillis();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\HttpEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */