package com.squareup.okhttp.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping {
  private final CountDownLatch latch = new CountDownLatch(1);
  
  private long received = -1L;
  
  private long sent = -1L;
  
  void cancel() {
    if (this.received == -1L) {
      long l = this.sent;
      if (l != -1L) {
        this.received = l - 1L;
        this.latch.countDown();
        return;
      } 
    } 
    throw new IllegalStateException();
  }
  
  void receive() {
    if (this.received == -1L && this.sent != -1L) {
      this.received = System.nanoTime();
      this.latch.countDown();
      return;
    } 
    throw new IllegalStateException();
  }
  
  public long roundTripTime() throws InterruptedException {
    this.latch.await();
    return this.received - this.sent;
  }
  
  public long roundTripTime(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.latch.await(paramLong, paramTimeUnit) ? (this.received - this.sent) : -2L;
  }
  
  void send() {
    if (this.sent == -1L) {
      this.sent = System.nanoTime();
      return;
    } 
    throw new IllegalStateException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\Ping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */