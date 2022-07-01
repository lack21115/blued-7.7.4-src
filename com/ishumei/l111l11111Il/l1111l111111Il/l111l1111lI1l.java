package com.ishumei.l111l11111Il.l1111l111111Il;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class l111l1111lI1l {
  private String l1111l111111Il = "";
  
  abstract String l1111l111111Il();
  
  final String l1111l111111Il(long paramLong) {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    (new Thread(new Runnable(this, countDownLatch) {
          public final void run() {
            try {
              l111l1111lI1l.l1111l111111Il(this.l111l11111lIl, this.l111l11111lIl.l1111l111111Il());
            } finally {
              Exception exception;
            } 
            this.l1111l111111Il.countDown();
          }
        })).start();
    try {
      countDownLatch.await(150L, TimeUnit.MILLISECONDS);
    } catch (InterruptedException interruptedException) {}
    return this.l1111l111111Il;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l111l1111lI1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */