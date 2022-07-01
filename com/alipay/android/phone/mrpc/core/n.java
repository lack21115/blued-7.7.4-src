package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class n implements ThreadFactory {
  private final AtomicInteger a = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable) {
    StringBuilder stringBuilder = new StringBuilder("com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #");
    stringBuilder.append(this.a.getAndIncrement());
    paramRunnable = new Thread(paramRunnable, stringBuilder.toString());
    paramRunnable.setPriority(4);
    return (Thread)paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */